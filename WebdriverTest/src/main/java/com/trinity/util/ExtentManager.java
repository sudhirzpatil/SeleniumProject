package com.trinity.util;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports instance;

	public static synchronized ExtentReports getInstance() {
		if (instance == null) {
			instance = new ExtentReports(System.getProperty("user.dir") + "/Extent.html");
		}
		return instance;
	}

}
