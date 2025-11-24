package listener;

import java.io.IOException;

import org.openqa.selenium.devtools.v136.page.model.Screenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

import dataProvider.ConfigUtility;
import factory.BrowserFactory;
import helper.Utility;

public class MyTestNGListener implements ITestListener
{
	public void onTestSuccess(ITestResult result) 
	{
	    ChainTestListener.log("Log:PASS - Test Pass");
	}
	
	public void onTestFailure(ITestResult result) 
	{
		ChainTestListener.log("Log:FAIL - Test Failed" + result.getMethod().getMethodName()+""+result.getThrowable().getMessage());
		try {
			if(ConfigUtility.readProperty("ScreenshotOnFail").equalsIgnoreCase("true"))
			{
				String screenshot = Utility.captureScreeshot(BrowserFactory.getDriver());
				ChainTestListener.embed(screenshot, "image/png");	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		ChainTestListener.log("Log:SKIPPED - Test Skipped");
	}

	

}
