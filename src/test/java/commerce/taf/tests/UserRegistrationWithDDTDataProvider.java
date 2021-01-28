package commerce.taf.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commerce.taf.pages.HomePage;
import commerce.taf.pages.LoginPage;
import commerce.taf.pages.UserRegistrationPage;

public class UserRegistrationWithDDTDataProvider extends TestBase{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name = "testData")
	public static Object[][] setData()
	{
		return new Object[][]
				{
			{"Shiry","Ibrahim","test55@test.com","123456"},
			{"Test","Test","Test66@test.com","123456"}
				};
	}

	@Test(priority = 1 , dataProvider = "testData")
	public void UserRegisterSuccessfully(String fname , String lname , String email , String pwd)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		registerObject.UserRegister(fname, lname, email, pwd);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(registerObject.successNotification.getText().contains("Your registration completed"));
		registerObject.Logout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email,pwd);
		registerObject.Logout();
	}
}
