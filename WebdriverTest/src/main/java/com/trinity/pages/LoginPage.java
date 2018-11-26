package com.trinity.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trinity.util.Setup;
import com.util.impl.Locators;

public class LoginPage implements Locators{

	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 120);
	}
	
	public void setUserName(String userName) {
		driver.findElement(byUserName).sendKeys(userName);
		//driver.findElement(byUserName).sendKeys("spatil9");
	}
	
	public void setPassword(String password) {
		driver.findElement(byPassword).sendKeys(password);
		//driver.findElement(byPassword).sendKeys("Welcome1");
	}
	
	public void clickSignInButton(){
		driver.findElement(bySignInButton).click();
		if(Setup.waitForJSandJQueryToLoad()){
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(byUserDisplayName));
		}
	}
	
	public boolean isLoginSuccessful(){
		String str = driver.findElement(byUserDisplayName).getText();
		
		//Need to check
		/*if(str.equals("Welcome "+displayName) && driver.findElement(byLoggedInUserImage).isDisplayed()){
			return true;
		}*/
		
		if(str.contains("xelsysadm")){
			return true;
		}
		return false;
	}
	
	public void clickLogoutLink(){
		//wait.until(ExpectedConditions.and(ExpectedConditions.invisibilityOfElementLocated(byModalBkdrop), ExpectedConditions.invisibilityOfElementLocated(byDeleteSuccessModal)));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(byApprovalPendingModal));
		driver.findElement(byUserDisplayName).click();
		//wait.until(ExpectedConditions.and(ExpectedConditions.invisibilityOfElementLocated(byOverlayElement), ExpectedConditions.visibilityOfElementLocated(byLogoutLinkUnderUserImage)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(bySignOutLink));
		driver.findElement(bySignOutLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLogoutMsg));
	}
	
	public void clearCredentials(){
		driver.findElement(byUserName).clear();
		driver.findElement(byPassword).clear();
	}
		
}

