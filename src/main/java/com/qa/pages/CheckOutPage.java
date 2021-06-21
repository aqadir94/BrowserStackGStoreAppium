package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CheckOutPage extends BasePage {
	
	@AndroidFindBy(xpath="//android.widget.CheckBox")
	MobileElement tandc_Chkbx;
	
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	MobileElement visitWebSite_Btn;
	
	
	public void checkTandCs() {
		
		wait.until(ExpectedConditions.visibilityOf(tandc_Chkbx));
		tandc_Chkbx.click();
		
	}
	
	
public void click_visitWebSite_Btn() {
		
		wait.until(ExpectedConditions.visibilityOf(visitWebSite_Btn));
		visitWebSite_Btn.click();
		
	}
	

}
