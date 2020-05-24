package com.iNetBanking_TEST_AUTOMATION_SUITE.utiilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class readConfig {

	Properties pro;
	public readConfig(){
		File src = new File("./configuration/config.properties");
		try{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e){
			System.out.println("Exception  : " + e.getMessage());
		}
	}	
		
	public String getApplicationURL(){
		String url = pro.getProperty("appUrl");
		return url;
		}
	public String getUsername(){
		String userid = pro.getProperty("username");
		return userid;
		}
	public String getUserpass(){
		String userpass = pro.getProperty("password");
		return userpass;
		}
	public String getChromeDriver(){
		String chrome = pro.getProperty("chromepath");
		return chrome;
		}
	public String getFirefoxDriver(){
		String gecko = pro.getProperty("firefoxpath");
		return gecko;
		}
	public String getIEDriver(){
		String iepath = pro.getProperty("irdriverpath");
		return iepath;
		}
	
	
}
