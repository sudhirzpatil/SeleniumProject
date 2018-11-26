package com.trinity.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.util.impl.constants;

public class UserDataUtil implements constants{
	
	private static Map<String, String> userDataMap;
	private static Map<String, String> testSpecificUserDataMap;
	private static Map<String, JSONObject> jsonApiDataMap;
	
	
	private static void loadUserData(){
		userDataMap = new HashMap<String, String>();
		Object[][] array = ReadExcel.fileDataProvider(loadUserData);
		
		for (Object[] objects : array) {
			userDataMap.put((String)objects[0], (String)objects[1]);
		}
	}
	
	private static void loadTestSpecificUserData(String testSpecificUserDataSheet){
		testSpecificUserDataMap = new HashMap<String, String>();
		Object[][] array = ReadExcel.fileDataProvider(loadTestSpecificUserData);
		//System.out.println("Array size is: "+array.length);
		
		for (Object[] objects : array) {
			testSpecificUserDataMap.put((String)objects[0], (String)objects[1]);
		}
	}
	
	public static Map<String, String> getMap(){
		if(null == userDataMap || userDataMap.isEmpty()){
			loadUserData();
		}
		return userDataMap;
	}
	
	public static Map<String, String> getTestSpecificUserDataMap(String testSpecificUserData){
		if(null == testSpecificUserDataMap || testSpecificUserDataMap.isEmpty()){
			loadTestSpecificUserData(testSpecificUserData);
		}
		return testSpecificUserDataMap;
	}
	
	public static Map<String, JSONObject> getJsonObjMap(){
		if(null==jsonApiDataMap || jsonApiDataMap.isEmpty()){
			jsonApiDataMap = new HashMap<String, JSONObject>();
		}
		return jsonApiDataMap;
	}
	
}
