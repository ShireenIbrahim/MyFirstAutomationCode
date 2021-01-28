package commerce.taf.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import commerce.taf.dataReader.ReadJsonFile;
import commerce.taf.pages.HomePage;
import commerce.taf.pages.LoginPage;
import commerce.taf.pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndJSON extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	
	@Test(priority = 1)
	public void UserRegisterSuccessfully()
	{
		ReadJsonFile jsonReader = new ReadJsonFile();
		jsonReader.loadJson();
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		registerObject.UserRegister(jsonReader.fname, jsonReader.lname, jsonReader.email, jsonReader.password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(registerObject.successNotification.getText().contains("Your registration completed"));
		registerObject.Logout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(jsonReader.email, jsonReader.password);
		registerObject.Logout();
	}
}
