package commerce.taf.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import commerce.taf.pages.HomePage;
import commerce.taf.pages.LoginPage;
import commerce.taf.pages.UserRegistrationPage;

public class UserRegistrationWithFaker extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	Faker fakerData = new Faker();
	String fname = fakerData.name().firstName();
	String lname = fakerData.name().lastName();
	String email = fakerData.internet().emailAddress();
	String password = fakerData.number().digits(8).toString();
	
	@Test(priority = 1)
	public void UserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		registerObject.UserRegister(fname, lname, email, password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(registerObject.successNotification.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = "UserRegisterSuccessfully")
	public void RegisteredUserCanLogout()
	{
		registerObject.Logout();
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanLogout")
	public void RegisteredUserLogin()
	{
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		
	}
}
