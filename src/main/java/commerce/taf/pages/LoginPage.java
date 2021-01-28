package commerce.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Email")
	WebElement emailTxt;
	
	@FindBy(id = "Password")
	WebElement passwordTxt;
	
	@FindBy(css="input.button-1.login-button")
	WebElement loginBtn;
	
	public void UserLogin(String email , String password)
	{
		clearTxt(emailTxt);
		clearTxt(passwordTxt);
		sendTxt(emailTxt, email);
		sendTxt(passwordTxt, password);
		clickButton(loginBtn);
	}

}
