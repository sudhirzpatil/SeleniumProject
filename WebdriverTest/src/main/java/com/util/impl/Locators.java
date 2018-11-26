package com.util.impl;
import org.openqa.selenium.By;	
public interface Locators {
	
	public static final By byUserName = By.id("pt1:_pt_it1::content");
	public static final By byPassword = By.id("pt1:_pt_it2::content");
	public static final By bySignInButton = By.id("pt1:_pt_cb1");
	public static final By byUserDisplayName = By.xpath("//div[@id='pt1:bbar:pt_m2']//table//tr/td/a");
	public static final By bySignOutLink = By.xpath("//tr[@id='pt1:bbar:cni2']//td[text()='Sign Out']");
	public static final By byLogoutMsg = By.xpath("//a[text()='Click here to login']");
	public static final By byCompliance = By.id("pt1:bbar:pt_np1:_modp_1");
	public static final By byIdentityCertImg = By.xpath("//img[@title='Identity Certification']");
	public static final By byCertConfgLink = By.xpath("//td[text()='Certification Configuration']");
	public static final By byDefinitionsLink = By.xpath("//td[text()='Definitions']");
	public static final By byCertDefnText = By.xpath("//table[@class='af_panelHeader_title-table0']//div/h1");
	public static final By byCreateCert = By.xpath("//span[text()=' Create']");
	public static final By byCreateDefnText= By.xpath("//span[text()='Create Definition: General Details']");
	public static final By byCertNm= By.xpath("//tr[contains(@id,'certificationIdentifier')]/td/input[contains(@name,'certificationIdentifier')]");
	public static final By byNextBttn= By.xpath("//button[text()='Next']");
	public static final By byBaseSelectionTxt= By.xpath("//span[text()='Create Definition: Base Selection']");
	public static final By byBaseSelectionDrpDown= By.xpath("//tr[contains(@id,'selectionStrategy')]//select[contains(@id,'selectionStrategy')]");
	public static final By byContentSelectionTxt= By.xpath("//span[text()='Create Definition: Content Selection']");
	public static final By byRolesNoneRadioOption= By.xpath("//label[text()='None']/preceding-sibling::span/input[contains(@id,'sorRoleCertificationType:_3')]");
	public static final By byAppInstRadioOption= By.xpath("//label[text()='Selected Application Instances Only']/preceding-sibling::span/input[contains(@id,'sorAppInstance:_2')]");
	public static final By byAppInstAddBttn= By.xpath("//div[contains(@id,'commandToolbarButton3')]/a");
	public static final By byHeaderOnAppInstModal= By.xpath("//div[text()='Add Application Instance']");
	public static final By bySearchTxtFieldAppInst= By.xpath("//input[contains(@id,'criterionValue::content')]");
	public static final By byOuterSearchBttn= By.xpath("//a[contains(@id,'search_icon') and @title='Search']");
	public static final By byDefaultTxtInResultsSection= By.xpath("//div[text()='No data to display']");
	public static final By byResultItemInResultsSection= By.xpath("//div[contains(@id,'pc1:t2::db')]//tr[contains(@class,'xe1')]//table/tbody/tr/td/span");
	public static final By byAddAllBttnOnAppInstModal= By.xpath("//span[text()=' Add All']/..");
	public static final By bySelectedItemInResultsSection= By.xpath("//div[contains(@id,'pc2:t3::db')]//tr[contains(@class,'xe1')]//table/tbody/tr/td/span");
	public static final By bySelectBttnOnModalTxt= By.xpath("//button[text()='Select']");
	public static final By byIncludeUsersWithNoAccountsChkBx= By.xpath("//label[text()='Include users with no accounts']/../span/input");
	public static final By byNoCertAttributesChkBx= By.xpath("//label[text()='Include accounts with no certifiable attributes']/../span/input");
	public static final By byConfigurationTxt= By.xpath("//span[text()='Create Definition: Configuration']");
	public static final By byPerformCloseRemediationChkBx= By.xpath("//label[text()='Perform closed loop remediation']/../following-sibling::td//table//td/span/span/input[@type='checkbox']");
	public static final By byReviewersTxt= By.xpath("//span[text()='Create Definition: Reviewers']");
	public static final By byReviewerSelectionDrpDown= By.xpath("//table[contains(@id,'selectOneChoice1')]/tbody/tr/td/select[contains(@id,'selectOneChoice1::content')]");
	public static final By bySearchUserIconOnReviewersPg= By.xpath("//table[contains(@id,'panelGroupLayout1')]//td/a[contains(@class,'AFIconOnly')]");
	public static final By bySearchForUserModal= By.xpath("//div[@title='Search for Users and add them to the Selected Items table below.']");
	public static final By byUserSearchResults= By.xpath("//div[contains(@class,'xdw xhg')]/div[2]/table/tbody/tr");
	public static final By byAddBttnOnUserSrchModal= By.xpath("//button[contains(@class,'x7j p_AFTextOnly') and text()='Add']");
	public static final By byCreateDefIncrementalTxt= By.xpath("//span[text()='Create Definition: Incremental']");
	public static final By byCreateDefSummaryTxt= By.xpath("//span[text()='Create Definition: Summary']");
	public static final By byCreateBttnOnSummaryPg= By.xpath("//button[contains(@id,'createButton') and text()='Create']");
	public static final By byCertJobConfirmationPopup= By.xpath("//div[text()='Certification Job']");
	public static final By byCreateCertSuccessMsg= By.xpath("//td[contains(@id,'npwd::contentContainer')]/div/div/div/span");
	public static final By byAFModal= By.xpath("//div[@class='AFModalGlassPane']");
	public static final By byAFBlockingGlassPane= By.xpath("//div[@class='AFBlockingGlassPane']");
	public static final By byCertJobModalYesBtton= By.xpath("//button[contains(@class,'xm9') and text()='Yes']");
	public static final By bySelfServiceTab= By.xpath("//span[text()='Self Service']");
	public static final By byMyInfoIcon= By.xpath("//span[text()='My Information']");
	public static final By byCertDefTabCloseIcon= By.xpath("//a[contains(@id,'rmAbv') and @title='Close Tab']");


}
