package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import base.BaseClass;
import dataProvider.DataProviders;
import pages.DashboardPage;
import pages.LoginPage;


public class LoginApplication extends BaseClass{
	
	LoginPage login;
	DashboardPage dashboard;
	
	@Test(priority=1,dataProvider = "loginCredential",dataProviderClass = DataProviders.class)
	public void loginWithValidCredential(String uname,String password) throws InterruptedException, IOException
	{
		login = new LoginPage(driver);
		dashboard = login.loginToApplication(uname,password);
		Thread.sleep(4000);
		Assert.assertTrue(dashboard.welcomeText().contains("Welcome"), "Login failed!!!");
		ChainTestListener.log("Log:INFO - User Login Success.");
		Reporter.log("Log:INFO - User Login Success.");
	}
	
	@Test(dependsOnMethods="loginWithValidCredential", priority=2)
	public void logOutFromApp() throws InterruptedException
	{
		dashboard.signOutFromApp();
		Thread.sleep(3000);
		Assert.assertTrue(login.isLogoutSuccess(),"Logout failed");
		ChainTestListener.log("Log:INFO - User LogOut Success.");
	}
	
	@Test(priority=3)
	public void isSocialLinksDisplayed()
	{
		login = new LoginPage(driver);
		int linkCount = login.isSocialLinksDisplayed();
		Assert.assertEquals(linkCount,9, "linkCount");
		ChainTestListener.log("Log:INFO - Socal Links displayed.");
	}
	
	@Test(priority=4)
	public void isSignUpLinkDisplayed() throws InterruptedException, IOException
	{
		login = new LoginPage(driver);
		Assert.assertTrue(login.isSignUpLinkDisplayed(), "SignUp link not displayed");
		ChainTestListener.log("Log:INFO - SgnUp Link Dsplayed.");
	}
	
	


}
