package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.SignUpPage;

public class SignUP_Cases extends BaseClass {
	
	SignUpPage signupUser;
	
	@Test
	public void signupPageVerification() throws InterruptedException, IOException
	{
		signupUser = new SignUpPage(driver);
		signupUser.enterSignupUserDetails();
		//signupUser.signUpButtonStatus();
		Assert.assertTrue(signupUser.signUpButtonStatus(),"Disabledddd");
	}

}
