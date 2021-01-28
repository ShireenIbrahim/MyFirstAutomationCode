package commerce.taf.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import commerce.taf.pages.HomePage;
import commerce.taf.pages.LoginPage;
import commerce.taf.pages.MyAccountPage;
import commerce.taf.pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {

	HomePage homeObject;
	MyAccountPage myAccountObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	String firstName = "Shireen";
	String lastName = "Ibrahim";
	String email = "Shireen.ibrahim1816@gmail.com";
	String password = "12345678";
	String newPassword = "123456";
	
	@Test(priority = 1)
	public void UserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		registerObject.UserRegister(firstName, lastName, email, password);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertTrue(registerObject.successNotification.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void UserCanChangePasswordTest()
	{
		registerObject = new UserRegistrationPage(driver);
		registerObject.openMyAccountPage();
		
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openChangePasswordPage();
		myAccountObject.changePassword(password, newPassword);
		Assert.assertTrue(myAccountObject.resultNotification.getText().contains("Password was changed"));
	}
	
	@Test(priority = 3)
	public void RegisteredUserCanLogout()
	{
		registerObject.Logout();
	}
	
	@Test(priority = 4)
	public void RegisteredUserLogin()
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);	
	}

}
