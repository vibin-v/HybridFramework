package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class SignUpPage {
	
	WebDriver driver;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By signupLinkfromLoginpage = By.xpath("//a[text()='New user? Signup']");
	By signup_Name = By.id("name");
	By signup_Email = By.id("email");
	By signup_Password = By.id("password");
	By signup_Interests = By.xpath("//label[text()='Selenium']");
	By signup_Gender = By.id("gender2");
	By signup_state = By.xpath("//select[@id='state']/option[2]");
	By signup_Hobbies = By.xpath("//select[@id='hobbies']/option[2]");
	By signup_Submit = By.xpath("//button[text()='Sign up']");
	
	public void enterSignupUserDetails() throws InterruptedException, IOException
	{
		driver.findElement(signupLinkfromLoginpage).click();
		Thread.sleep(5000);
		driver.findElement(signup_Name).sendKeys("Vibin");
		Utility.checkElement(driver, signup_Email).sendKeys("abcd@gmail.com");
		Utility.checkElement(driver, signup_Password).sendKeys("KL01@trivandrum");
		Utility.checkElement(driver, signup_Interests).click();
		Utility.checkElement(driver, signup_Gender).click();
		Utility.checkElement(driver, signup_state).click();
		Utility.checkElement(driver, signup_Hobbies).click();
		Thread.sleep(5000);
	}
	
	public boolean signUpButtonStatus()
	{
		boolean signupBtnStatus = driver.findElement(signup_Submit).isEnabled();
		return signupBtnStatus;
	}
}
