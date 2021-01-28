package commerce.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Register")
	WebElement registrationLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;

	
	public void openRegistrationPage()
	{
		clickButton(registrationLink);
	}
	
	public void openLoginPage()
	{
		clickButton(loginLink);
	}
	
	public void openMyAccountPage()
	{
		clickButton(myAccountLink);
	}
}
