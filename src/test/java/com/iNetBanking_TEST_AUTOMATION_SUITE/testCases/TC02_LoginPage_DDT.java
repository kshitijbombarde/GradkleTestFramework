package com.iNetBanking_TEST_AUTOMATION_SUITE.testCases;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking_TEST_AUTOMATION_SUITE.pageObjects.LoginPage;
import com.iNetBanking_TEST_AUTOMATION_SUITE.utiilities.XLUtils;


public class TC02_LoginPage_DDT extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String passwd) throws IOException, InterruptedException{
		LoginPage lp = new LoginPage(driver);	
		lp.setUserName(user);
		logger.info("username was fetched !");
		lp.setPassword(passwd);
		logger.info("password was fetched !");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		
		if(isAlertPresent()==true){
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Attempt was Failed !");
		}
		else{
			Assert.assertTrue(true);
			logger.info("Login Attempt was Successful !");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e){
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/iNetBanking/testData/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1",1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++){
			for(int j=0;j<colcount;j++){
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
	return logindata;
	}
}
