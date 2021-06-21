package com.qa.resources;

import java.net.URL;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.remote.DesiredCapabilities;
      
public class DriverManager {

 private static ThreadLocal<AppiumDriver> driver=new ThreadLocal<AppiumDriver>();
 
 public static AppiumDriver getDriver() {
	 
	 return driver.get();
	 
 }
 
 
 public static void setDriver(AppiumDriver driver2) {
	 
	 
	 driver.set(driver2);
 }
 
	  
	 public static void initializeDriver(String deviceID){
		
		 try {
     
			 DesiredCapabilities caps = new DesiredCapabilities();
			 JSONObject jsonObject;
		      String path=System.getProperty("user.dir");
		      //src\main\java\com\qa\resources\resources.json
		      FileInputStream fis=new FileInputStream(path+File.separator+"src"+File.separator+
		    		  "main"+File.separator+"java"+File.separator+"com"+File.separator+"qa"+
		    		  File.separator+"resources"+File.separator+"devices.json");
   
		      JSONTokener jt=new JSONTokener(fis);
		      jsonObject=new JSONObject(jt);
		      
		      JSONObject deviceData=jsonObject.getJSONObject(deviceID);
		      
      caps.setCapability("browserstack.user", "gulamabbas_dnpI5R");
      caps.setCapability("browserstack.key", "czW7xTpZ7Pzszqrwg5fw");
      
   
      //caps.setCapability("app", "bs://6a48a502702b54b68be10899451faec5f27220fe");
      
     // caps.setCapability("browser", "Chrome");
    caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
  	caps.setCapability("chromedriverExecutable", "C:\\chromedriver-mobile_browser\\chromedriver.exe");
      caps.setCapability("device", deviceData.get("device"));
      caps.setCapability("os_version", deviceData.get("os_version"));
        
 
      caps.setCapability("project", "First Java Project");
      caps.setCapability("build", "Java Android");
      caps.setCapability("name", "first_test");
      caps.setCapability("browserstack.console", "info");
      
      caps.setCapability("webviewConnectTimeout", 10000);
      
      if(deviceData.get("platform").toString().contentEquals("Android")) {
        setDriver( new AndroidDriver(
            new URL("http://hub.browserstack.com/wd/hub"), caps));
      }
      
      else if(deviceData.get("platform").toString().contentEquals("iOS")) {
    	  
    	  setDriver( new IOSDriver(
    	            new URL("http://hub.browserstack.com/wd/hub"), caps));
    	  
      }
      
      else {
    	  
    	  System.out.println("Invalid platform");
      }

		 }
		 
		 catch(Exception e) {
			 
			 e.printStackTrace();
			 
		 }
    
	 }
      
  }