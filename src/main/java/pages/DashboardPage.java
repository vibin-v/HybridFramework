package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By dashboardMenu = By.xpath("//img[@alt='menu']");
	By signOutBtn = By.xpath("//button[text()='Sign out']");
	By welcomeTxt = By.xpath("//h4[@class='welcomeMessage']");
	
	public LoginPage signOutFromApp() throws InterruptedException
	{
		driver.findElement(dashboardMenu).click();
		Thread.sleep(3000);
		driver.findElement(signOutBtn).click();
		
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public String welcomeText()
	{
		String welcomeLabelText = driver.findElement(welcomeTxt).getText();
		return welcomeLabelText;
	}

}
