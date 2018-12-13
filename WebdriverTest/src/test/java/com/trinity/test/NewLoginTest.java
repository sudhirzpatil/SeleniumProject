package com.trinity.test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.trinity.pages.NewLoginPage;
import com.util.impl.BaseScript;

public class NewLoginTest extends BaseScript {
	
	NewLoginPage objLogin ;
	
	@BeforeTest
	public void setup(){
		
		killAllWindows();
		setupConfig();
		setupDriver();
	}
	
	@Test(priority=0)
	public void test_Login_To_Trinity(){
		
		objLogin = new NewLoginPage(driver);
		objLogin.loginToGuru99();
	}
	
	
	

	
}
