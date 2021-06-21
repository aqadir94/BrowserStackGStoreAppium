package com.qa.tests;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.CheckOutPage;
import com.qa.pages.MainPage;
import com.qa.pages.productsPage;
import com.qa.resources.DriverManager;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;

public class selectionTest extends BaseTest{
	
	
	@BeforeMethod
	public void beforeMethod() {
		
		
		if(DriverManager.getDriver()!=null) {
			
			((InteractsWithApps)(DriverManager.getDriver())).closeApp();
			((InteractsWithApps)(DriverManager.getDriver())).launchApp();
		}
	}
	
	
	@Test
	public void test() throws InterruptedException {
		
		
		MainPage m1=new MainPage();
		productsPage p1=new productsPage();
		CheckOutPage c1=new CheckOutPage();
		m1.click_country_DrpDwn();
		m1.scrollToCountry("\"Kenya\"");
		m1.click_country("Kenya");
		m1.enter_Name("Koma");
		m1.click_female_Radio();
		m1.click_letsShop();
		
		Thread.sleep(3000);
		
		 ((FindsByAndroidUIAutomator) DriverManager.getDriver()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"Converse All Star\"));");
    }

		////*[@text='Converse All Star']/parent::	
	//android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]

		/*
		p1.selectProduct("\"PG 3\"");
		p1.addToCart();
		p1.clickShoppingCart();
		
		c1.checkTandCs();
		c1.click_visitWebSite_Btn();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String>handles=DriverManager.getDriver().getContextHandles();
		DriverManager.getDriver().context(handles.toArray()[1].toString());
		DriverManager.getDriver().findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("lop");
		*/
		
		//DriverManager.getDriver().get("http://www.google.com");
	}


