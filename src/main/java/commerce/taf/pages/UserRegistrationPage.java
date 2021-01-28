package commerce.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "gender")
	WebElement genderRedioBtn;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTxt;
	
	@FindBy(id = "LastName")
	WebElement lastNameTxt;
	
	@FindBy(id = "Email")
	WebElement mailTxt;
	
	@FindBy(id = "Password")
	WebElement passwordTxt;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
	public WebElement successNotification;
	
	@FindBy(linkText = "Log out")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountLink;
	
	public void UserRegister(String firstName , String lastName , String email , String password)
	{
		clearTxt(firstNameTxt);
		clearTxt(lastNameTxt);
		clearTxt(mailTxt);
		clearTxt(passwordTxt);
		clearTxt(confirmPasswordTxt);
		
		clickButton(genderRedioBtn);
		sendTxt(firstNameTxt, firstName);
		sendTxt(lastNameTxt, lastName);
		sendTxt(mailTxt, email);
		sendTxt(passwordTxt, password);
		sendTxt(confirmPasswordTxt, password);
		clickButton(registerBtn);
	}
	
	public void Logout()
	{
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage()
	{
		clickButton(myAccountLink);
	}

}
