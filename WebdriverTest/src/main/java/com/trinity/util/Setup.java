package com.trinity.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.impl.constants;
import com.util.impl.Locators;

public class Setup implements constants, Locators {

	private static WebDriver driver = null;
	public static Properties prop;

	public void initialise(String browser) throws Exception {

		prop = new Properties();
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")
				+ "\\global.properties");
		prop.load(fi);

		if (browser.equals(firefox)) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals(chrome)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals(ie)) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String url = prop.getProperty(constants.url);
		url = url.replace("{APP_HOST}",
				UserDataUtil.getMap().get(applicationHost));
		System.out.println("OIM Url is: " + url);
		driver.get(url);

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public void destroy() {
		driver.close();
	}

	public static boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 3) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public static boolean retryingFindElement(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 3) {
			try {
				driver.findElement(by);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public static WebElement retryingFindWebelement(WebElement element, By by) {
		boolean result = false;
		WebElement webElement = null;
		int attempts = 0;
		while (attempts < 4) {
			try {
				webElement = element.findElement(by);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return webElement;
	}

	

	public static boolean waitForJSandJQueryToLoad() {
		// wait for jQuery to load
		WebDriverWait localWait = new WebDriverWait(driver, 60);
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver)
							.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					// no jQuery present
					return true;
				}
			}
		};
		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver)
						.executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		return localWait.until(jQueryLoad) && localWait.until(jsLoad);
	}

	// This method is to capture the screenshot and return the path of the
	// screenshot.
	public static String getScreenhot(WebDriver driver, String screenshotName) {
		String destination =null;
		try{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss")
				.format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		destination = System.getProperty("user.dir")
				+ "/FailedTestsScreenshots/" + screenshotName + "_" + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		}catch(Exception e){
			e.printStackTrace();
		}
		return destination;
	}

}

