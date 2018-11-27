package com.trinity.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.trinity.util.ExtentTestManager;
import com.trinity.util.Setup;
import com.relevantcodes.extentreports.LogStatus;
import com.util.impl.constants;
import com.util.impl.Locators;

public class CertificationPage implements constants, Locators{

	WebDriver driver;
	WebDriverWait wait;
	
	public CertificationPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 150);
	}
	
	public boolean verifyCreateCert(String cerNm, String resObj, String userToSrch) throws InterruptedException{
		boolean flag = true;
		
		driver.findElement(byCompliance).click();
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byIdentityCertImg));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Clicked on the Compliance link");
		}
		driver.findElement(byIdentityCertImg).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(byDefinitionsLink));
		driver.findElement(byDefinitionsLink).click();
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byCertDefnText));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Clicked on the Definitions link");
		}
		driver.findElement(byCreateCert).click();
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byCreateDefnText));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Clicked on the Create Cert Button");
		}
		
		driver.findElement(byCertNm).clear();
		driver.findElement(byCertNm).sendKeys(cerNm);
		driver.findElement(byNextBttn).click();
		ExtentTestManager.getTest().log(LogStatus.INFO,"Entered Certificate name and clicked on the Next button");
		
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byBaseSelectionTxt));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Moved to the Create Definition: Base Selection page");
		}
		
		Select select = new Select(driver.findElement(byBaseSelectionDrpDown));
		select.selectByValue("2");
		driver.findElement(byNextBttn).click();
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byContentSelectionTxt));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Moved to the Create Definition: Content Selection page");
		}
		
		driver.findElement(byRolesNoneRadioOption).click();
		ExtentTestManager.getTest().log(LogStatus.INFO,"Selected None radio option under Roles section");
		
		driver.findElement(byAppInstRadioOption).click();
		
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.elementToBeClickable(byAppInstAddBttn));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Selected -Application Instance Only- radio option under Application Instances section");
		}
		
		driver.findElement(byAppInstAddBttn).click();
		ExtentTestManager.getTest().log(LogStatus.INFO,"Clicked on the Add button displayed in the Application Instance section");
		
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byHeaderOnAppInstModal));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Add Application Instance modal displayed ");
		}
		
		driver.findElement(bySearchTxtFieldAppInst).clear();
		driver.findElement(bySearchTxtFieldAppInst).sendKeys(resObj);
		ExtentTestManager.getTest().log(LogStatus.INFO,"Application Instance object entered: "+resObj);
		driver.findElement(byOuterSearchBttn).click();
		
		if(Setup.waitForJSandJQueryToLoad()){
			//wait.until(ExpectedConditions.and(ExpectedConditions.invisibilityOfElementLocated(byDefaultTxtInResultsSection),ExpectedConditions.visibilityOfElementLocated(byResultItemInResultsSection)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(byResultItemInResultsSection));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Got the result in Application Instance Result section");
		}
		
		driver.findElement(byAddAllBttnOnAppInstModal).click();
		if(Setup.waitForJSandJQueryToLoad()){
			//wait.until(ExpectedConditions.and(ExpectedConditions.invisibilityOfElementLocated(byDefaultTxtInResultsSection),ExpectedConditions.visibilityOfElementLocated(bySelectedItemInResultsSection)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(bySelectedItemInResultsSection));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Selected Application Instance");
		}
		
		driver.findElement(bySelectBttnOnModalTxt).click();
		
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byContentSelectionTxt));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Again back to the Create Definition: Content Selection page");
		}
		
		boolean selected = driver.findElement(byIncludeUsersWithNoAccountsChkBx).isSelected();
		if(selected){
			wait.until(ExpectedConditions.invisibilityOfElementLocated(byAFModal));
			driver.findElement(byIncludeUsersWithNoAccountsChkBx).click();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Unchecked -Include users with no accounts- check box");
		}
		
		boolean selected2 = driver.findElement(byNoCertAttributesChkBx).isSelected();
		if(selected2){
			wait.until(ExpectedConditions.invisibilityOfElementLocated(byAFModal));
			driver.findElement(byNoCertAttributesChkBx).click();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Unchecked -Include accounts with no certifiable attributes- check box");
		}
		
		driver.findElement(byNextBttn).click();
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byConfigurationTxt));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Moved to the Create Definition: Configuration page");
		}
		
		boolean selected3 = driver.findElement(byPerformCloseRemediationChkBx).isSelected();
		if(selected3){
			driver.findElement(byPerformCloseRemediationChkBx).click();
			ExtentTestManager.getTest().log(LogStatus.INFO,"Unchecked -Perform closed loop remediation- check box");
		}
		
		driver.findElement(byNextBttn).click();
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byReviewersTxt));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Moved to the Create Definition: Reviewers page");
		}
		
		select = new Select(driver.findElement(byReviewerSelectionDrpDown));
		select.selectByVisibleText("Search for a User");
		ExtentTestManager.getTest().log(LogStatus.INFO,"Selected -Search for a User- option from reviewer dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(bySearchUserIconOnReviewersPg));
		
		driver.findElement(bySearchUserIconOnReviewersPg).click();
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(bySearchForUserModal));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Search for Users modal displayed sucessfully");
		}
		
		driver.findElement(bySearchTxtFieldAppInst).clear();
		driver.findElement(bySearchTxtFieldAppInst).sendKeys(userToSrch);
		driver.findElement(byOuterSearchBttn).click();
		
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.numberOfElementsToBe(byUserSearchResults, 1));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Got the user search results");
		}
		driver.findElement(byUserSearchResults).click();
		wait.until(ExpectedConditions.elementToBeClickable(byAddBttnOnUserSrchModal));
		driver.findElement(byAddBttnOnUserSrchModal).click();
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='x1u p_AFDisabled']//td/input[@value='"+userToSrch+"']")));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Search was successful for: "+userToSrch);
		}
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byAFBlockingGlassPane));
		//driver.findElement(byNextBttn).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(byNextBttn));
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byCreateDefIncrementalTxt));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Moved to the Create Definition: Incremental page");
		}
		
		driver.findElement(byNextBttn).click();
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byCreateDefSummaryTxt));
			ExtentTestManager.getTest().log(LogStatus.INFO,"Moved to the Create Definition: Summary page");
		}
		
		driver.findElement(byCreateBttnOnSummaryPg).click();
		
		if(Setup.waitForJSandJQueryToLoad()){
			wait.until(ExpectedConditions.visibilityOfElementLocated(byCertJobConfirmationPopup));
			//ExtentTestManager.getTest().log(LogStatus.INFO,"Moved to the Create Definition: Summary page");
		}
		
		String sucessMsg = driver.findElement(byCreateCertSuccessMsg).getText();
		if(!sucessMsg.contains("Your certification definition was created successfully")){
			flag=false;
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Failed to Create new certification");
			driver.findElement(bySelfServiceTab).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(byMyInfoIcon));
		}
		else{
			flag=true;
			ExtentTestManager.getTest().log(LogStatus.INFO,"New certification created successfully");
			driver.findElement(byCertJobModalYesBtton).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(byAFModal));
			driver.findElement(byCertDefTabCloseIcon).click();
			driver.findElement(bySelfServiceTab).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(byMyInfoIcon));
		}
		
		if(flag==true){
			return true;
		}else{
			return false;
		}
	}
	
}
