package commerce.taf.cuc.steps;

import org.testng.Assert;

import commerce.taf.pages.HomePage;
import commerce.taf.pages.UserRegistrationPage;
import commerce.taf.tests.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegistration extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	
	@Given("Home page open")
	public void home_page_open() throws Throwable
	{
	System.out.println("current URL : "+driver.getCurrentUrl());
	 homeObject = new HomePage(driver);
	}
	
	@When("I click on the register link")
	public void i_click_on_the_register_link() 
	{
	   homeObject.openRegistrationPage();
	}
	
	@When("Fill the user data")
	public void fill_the_user_data() 
	{
	    registerObject = new UserRegistrationPage(driver);
	    registerObject.UserRegister("test", "test", "testtest8855@test.co", "123456");
	}
	
	@Then("User register")
	public void user_register() 
	{
		Assert.assertTrue(registerObject.successNotification.getText().contains("Your registration completed"));
	}
}
