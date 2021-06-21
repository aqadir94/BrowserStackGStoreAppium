package com.qa.pages;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.BasePage;
import com.qa.resources.DriverManager;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class productsPage extends BasePage {
	
	
	@AndroidFindBy(xpath="//*[contains(@text,'Products')]")
	MobileElement products; 
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	MobileElement shopnCart_Btn; 
	
	
	public MobileElement selectProduct(String product) {
		
		
		
		wait.until(ExpectedConditions.visibilityOf(products));
		return (MobileElement) ((FindsByAndroidUIAutomator) DriverManager.getDriver()).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
						+ "new UiSelector().text("+product+"));");
		
		
		
		
		
	}
	
	public void addToCart() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(DriverManager.getDriver().findElementsByXPath("//*[contains(@text,'ADD TO CART')]").size()==2) {
			
			
			((RemoteWebElement) DriverManager.getDriver().findElementsByXPath("//*[contains(@text,'ADD TO CART')]").get(1)).click();
			
		}
		
		else {
		//((RemoteWebElement) DriverManager.getDriver().findElementsByXPath("//*[contains(@text,'ADD TO CART')]").get(1)).click();
		}
	}
	
	public void clickShoppingCart() {
		
		wait.until(ExpectedConditions.visibilityOf(shopnCart_Btn));
		shopnCart_Btn.click();
		
	}

}
