package com.qa.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.resources.DriverManager;

public class BaseTest {
	
	@Parameters({"deviceID"})
	@BeforeTest
	public void beforeTest(String deviceID) {
		
		DriverManager.initializeDriver(deviceID);
		
		}
	
	
	@AfterTest
	public void afterTest() {
		
		DriverManager.getDriver().quit();
		
		
	}

}
