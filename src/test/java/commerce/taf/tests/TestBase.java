package commerce.taf.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import commerce.taf.utilities.Helper;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters("browser")
	public void startupDriver(@Optional("Chrome") String runningBrowser)
	{
		if(runningBrowser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(runningBrowser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	@AfterMethod
	public void takeScreensotInFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			System.out.println("Failed!");
			System.out.println("Take screenshot ......");
			Helper.captureScreenShot(driver, result.getName());
		}
	}
	
	@AfterSuite
	public void closeDriver()
	{
		driver.quit();
	}
}
