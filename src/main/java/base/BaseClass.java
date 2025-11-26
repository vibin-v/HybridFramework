package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import factory.BrowserFactory;
import dataProvider.ConfigUtility;


public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		System.out.println("Log-Info : SettingUp browser...");
		driver = BrowserFactory.startBrowser(ConfigUtility.readProperty("BrowserType"), ConfigUtility.readProperty("BaseURL"), ConfigUtility.readProperty("HeadlessMode"));
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("Log-Info : Closing browser...");
		driver.quit();
	}

}
