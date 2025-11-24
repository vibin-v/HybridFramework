package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By username = By.xpath("//input[@id='email1']");
	By password = By.id("password1");
	By loginBtn = By.xpath("//button[text()='Sign in']");
	By signInLabel = By.xpath("//h2[text()='Sign In']");
	By socialLinks = By.xpath("//div[@class='social-btns']/a");
	By signupLink = By.xpath("//a[text()='New user? Signup']");
	

	
	public DashboardPage loginToApplication(String userName,String passwd) throws InterruptedException, IOException
	{
		//driver.findElement(username).sendKeys(userName);
		Utility.typeOnElement(driver, username, userName);
		driver.findElement(password).sendKeys(passwd);
		driver.findElement(loginBtn).click();
		DashboardPage dashboardPage = new DashboardPage(driver);
		return dashboardPage;
	}
	
	public boolean isLogoutSuccess()
	{
		boolean isLogoutStatus = driver.findElement(signInLabel).isDisplayed();
		return isLogoutStatus;
	}
	
	public int isSocialLinksDisplayed()
	{
		int socialLinkCount = driver.findElements(socialLinks).size();
		return socialLinkCount;
	}
	
	public boolean isSignUpLinkDisplayed() throws InterruptedException, IOException
	{
		//boolean signUpLinkStatus = driver.findElement(signupLink).isDisplayed();
		boolean signUpLinkStatus = Utility.checkElement(driver, signupLink).isDisplayed();
		return signUpLinkStatus;
	}
	
	
	
	
	
}
