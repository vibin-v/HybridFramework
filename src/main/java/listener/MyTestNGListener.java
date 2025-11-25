package listener;

import java.io.IOException;

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
	
	@Override
    public void onTestFailure(ITestResult result) {
        ChainTestListener.log("Log: FAIL - Test Failed");
        ChainTestListener.log("Error: " + result.getThrowable().getMessage());

        try {
            if (ConfigUtility.readProperty("ScreenshotOnFail").equalsIgnoreCase("true")) {
                String screenshotPath = Utility.captureScreeshot(BrowserFactory.getDriver());
                ChainTestListener.embed(screenshotPath, "image/png");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	public void onTestSkipped(ITestResult result)
	{
		ChainTestListener.log("Log:SKIPPED - Test Skipped");
	}

	

}
