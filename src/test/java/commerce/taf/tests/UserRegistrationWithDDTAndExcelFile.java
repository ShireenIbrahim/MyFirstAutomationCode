package commerce.taf.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commerce.taf.dataReader.ReadExcelFile;
import commerce.taf.pages.HomePage;
import commerce.taf.pages.LoginPage;
import commerce.taf.pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndExcelFile extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name ="ExcelData")
	private Object[][] getUserRegisterationData()
	{
		ReadExcelFile re = new ReadExcelFile();
		return re.getExcelData();
	}
	
	@Test(priority = 1, dataProvider = "ExcelData")
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.Logout();
	}
}
