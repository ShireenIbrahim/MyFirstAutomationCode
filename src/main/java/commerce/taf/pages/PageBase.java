package commerce.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	//Create constructor
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public static void clickButton(WebElement button)
	{
		button.click();
	}
	
	public static void sendTxt(WebElement txtElement , String value)
	{
		txtElement.sendKeys(value);
	}
	
	public static void clearTxt(WebElement element)
	{
		element.clear();
	}
}
