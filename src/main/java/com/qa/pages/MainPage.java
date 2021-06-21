package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.BasePage;
import com.qa.resources.DriverManager;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPage extends BasePage{
	
	
	
	@AndroidFindBy(id="android:id/text1")
	MobileElement country_DrpDwn;

	@AndroidFindBy(xpath="//*[@text='Afghanistan']")
	MobileElement country_Afghanistan;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Enter')]")
	MobileElement name; 
	
	@AndroidFindBy(xpath="//*[contains(@text,'Shop')]")
	MobileElement letsShop_btn; 
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	MobileElement male_Radio;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	MobileElement female_Radio;
	
	public void click_country_DrpDwn() {
		
		
		wait.until(ExpectedConditions.visibilityOf(country_DrpDwn));
		country_DrpDwn.click();
		
		
	}
	
	public MobileElement scrollToCountry(String country) {
		
		
		wait.until(ExpectedConditions.visibilityOf(country_Afghanistan));
		return (MobileElement) ((FindsByAndroidUIAutomator) DriverManager.getDriver()).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
						+ "new UiSelector().text("+country+"));");
		
		

	}
	
	
public void click_country(String country) {
		
		
	DriverManager.getDriver().findElementByXPath("//*[@text='"+country+"']").click();
		
		
	}

public void enter_Name(String name2) {
	
	
	wait.until(ExpectedConditions.visibilityOf(name));
	name.sendKeys("Gola mal");
}

public void click_letsShop() {
	
	
	wait.until(ExpectedConditions.visibilityOf(letsShop_btn));
	letsShop_btn.click();
}
	

public void click_male_Radio() {
	
	
	wait.until(ExpectedConditions.visibilityOf(male_Radio));
	male_Radio.click();
}


public void click_female_Radio() {
	
	
	wait.until(ExpectedConditions.visibilityOf(female_Radio));
	female_Radio.click();
}
	
}
