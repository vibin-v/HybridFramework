package factory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static WebDriver startBrowser(String browserType,String baseURL,String hlessMode) throws IOException
	{
		
		System.out.println(hlessMode);
		if(browserType.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			if(hlessMode.equalsIgnoreCase("true"))
			{
				System.out.println("In headless");
				options.addArguments("--headless=new");
				
				options.addArguments("--window-size=1920,1080"); 
				options.addArguments("--disable-gpu");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
			}
				driver = new ChromeDriver(options);
			
		}
		else if(browserType.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Incorrect browser Type");
		}
		
		driver.get(baseURL);
		return driver;
	}

}
