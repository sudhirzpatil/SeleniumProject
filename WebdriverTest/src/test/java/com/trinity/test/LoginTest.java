package com.trinity.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.trinity.pages.LoginPage;
//import com.itg.util.ExtentManager;
//import com.itg.util.ExtentTestManager;
import com.trinity.util.ExtentManager;
import com.trinity.util.ExtentTestManager;
import com.trinity.util.ReadExcel;
import com.trinity.util.ReadExcelData;
import com.trinity.util.Setup;
import com.trinity.util.UserDataUtil;
import com.relevantcodes.extentreports.LogStatus;
import com.util.impl.constants;

public class LoginTest extends Setup implements constants{
	
	String browser;
	Logger logger = Logger.getLogger(LoginTest.class);
	
	@Parameters("browser")
	@BeforeSuite
	public void init(@Optional("chrome") String browser) throws Exception{
		UserDataUtil.getMap();
		this.browser = browser;
		initialise(browser);		
	}
	
	/**
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Test(dataProvider="loginSuccessData")
	public void testLoginSuccess(String username, String password) throws Exception {
		logger.info("Inside testLoginSuccess");
		ExtentTestManager.startTest("Login Success Test");
		System.out.println("Inside test");
		LoginPage loginPage = new LoginPage(Setup.getDriver());
		System.out.println("********* Username: "+username+" Password: "+password+" *********");
		loginPage.setUserName(username);
		loginPage.setPassword(password);
		loginPage.clickSignInButton();
		boolean isLoginSuccessful = loginPage.isLoginSuccessful();

		if (isLoginSuccessful) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Login is Successful for user " + username);
			//loginPage.clickLogoutLink();
		}
		loginPage.clickLogoutLink();
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
		logger.info("Exit testLoginSuccess");
	}
	
	@DataProvider(name="loginSuccessData")
	public Object[][] testLoginSuccessData() throws IOException {
		//Object [][] userdetails =ReadExcel.fileDataProvider("Test Login Success");;
		//System.out.println("**** userdetails size: "+userdetails.length);
		System.out.println("Inside data provider");
  		//return ReadExcel.fileDataProvider("Test Login Success");
		return ReadExcelData.ReadVariant();
		//return userdetails;
	}
	
	@AfterSuite
	public void destroy(){
		//super.destroy();
		UserDataUtil.getJsonObjMap().clear();
		
	}
}
