package commerce.taf.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import commerce.taf.pages.HomePage;
import commerce.taf.pages.LoginPage;
import commerce.taf.pages.UserRegistrationPage;
import commerce.taf.dataReader.ReadPropertiesFile;

public class UserRegistrationDDTWithPropertiesFile extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	//Read data from properties file
	String fname = ReadPropertiesFile.userData.getProperty("firstName");
	String lname = ReadPropertiesFile.userData.getProperty("lastName");
	String email = ReadPropertiesFile.userData.getProperty("email");
	String pwd = ReadPropertiesFile.userData.getProperty("password");
	
	@Test(priority = 1)
	public void UserRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		registerObject.UserRegister(fname, lname, email, pwd);
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
		loginObject.UserLogin(email, pwd);
		
	}
}
