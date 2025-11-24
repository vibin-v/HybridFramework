package helper;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.ConfigUtility;

public class Utility {
	
	public static void threadSleep() throws IOException, InterruptedException 
	{
		String sleepTime = ConfigUtility.readProperty("ThreadSleepTime");
		int seconds = Integer.parseInt(sleepTime); 
	    Thread.sleep(seconds * 1000);
	}
	
	
	public static void clickElement(WebDriver driver,By locator) throws InterruptedException, IOException
	{
		Utility.checkElement(driver, locator);
		driver.findElement(locator).click();
	}
	public static void typeOnElement(WebDriver driver,By locator,String inputText) throws InterruptedException, IOException
	{
		Utility.checkElement(driver, locator);
		driver.findElement(locator).sendKeys(inputText);
	}
	
	
	public static void clickUsingJS(WebDriver driver,By locator)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(locator));
	}
	
	public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException, IOException
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	    threadSleep();
	    js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid white;');", element);
	}
	
	public static WebElement checkElement(WebDriver driver,By locator) throws InterruptedException, IOException
	{
		System.out.println("checkElement verified");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
		if(ConfigUtility.readProperty("HighlighElement").equalsIgnoreCase("Yes"))
		{
		highlightElement(driver, ele);
		}
		return ele;
	}
	
	public static String captureScreeshot(WebDriver driver)
	{
		TakesScreenshot screeShot = (TakesScreenshot) driver;
		return screeShot.getScreenshotAs(OutputType.BASE64);
	}

	
	

	
	

}
