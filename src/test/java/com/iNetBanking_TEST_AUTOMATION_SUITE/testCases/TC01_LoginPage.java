package com.iNetBanking_TEST_AUTOMATION_SUITE.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking_TEST_AUTOMATION_SUITE.pageObjects.LoginPage;

public class TC01_LoginPage extends BaseClass {

	@Test
	public void loginTest() throws IOException{
		
		logger.info("URL is Opened in Browser");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Enetered Password");
		
		lp.clickSubmit();
		logger.info("Login Button was Clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager Lobo")){
			Assert.assertTrue(true);
			logger.info("Login Test Passed !");
		}
		else{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed !");
		}
		
	}
	
}
