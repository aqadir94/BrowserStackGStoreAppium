package com.qa.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CreateDriverSession {

	
public static AppiumDriver initializedriver(String platform) throws MalformedURLException {
	
	AppiumDriver driver = null;
	if(platform.contentEquals("Android")) {

	DesiredCapabilities cap=new DesiredCapabilities(); 
	String path=System.getProperty("user.dir");
	String appURL=path+File.separator+"ApiDemos-debug.apk"; //use file separator instead (works on any os)
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android_Pixel4");// -emulator
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S9");// -real device
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
	
	cap.setCapability(MobileCapabilityType.UDID, "50584a424e443498");
	
	cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	cap.setCapability("chromedriverExecutable", "C:\\chromedriver-mobile_browser\\chromedriver.exe"); //path to the compatible driver version
	
	cap.setCapability("unlockType", "pin");
	cap.setCapability("unlockKey", "74159");
	//cap.setCapability("chromedriverExecutable", "path to the compatible driver");
	
	URL url=new URL("http://0.0.0.0:4723/wd/hub");
	
	 driver=new AndroidDriver(url,cap);
	

	}
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	return driver;

}

public static void main(String args[]) throws MalformedURLException {
	
	
	AppiumDriver driver=initializedriver("Android");
	
	driver.get("https://www.google.com/");
}




}



