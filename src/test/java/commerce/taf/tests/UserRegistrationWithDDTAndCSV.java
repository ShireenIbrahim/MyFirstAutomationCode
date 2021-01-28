package commerce.taf.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commerce.taf.dataReader.ReadCSVFile;
import commerce.taf.pages.HomePage;
import commerce.taf.pages.LoginPage;
import commerce.taf.pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndCSV extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="csvData")
	private Object[][] readData()
	{
		return ReadCSVFile.readFile();
	}
	
	@Test(priority = 1 , dataProvider = "csvData")
	public void UserRegisterSuccessfully(String fname, String lname, String email, String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		registerObject.UserRegister(fname, lname, email, password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(registerObject.successNotification.getText().contains("Your registration completed"));
		registerObject.Logout();
		homeObject = new HomePage(driver);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		registerObject.Logout();
	}
}
