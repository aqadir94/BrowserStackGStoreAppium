package com.qa.base;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.resources.DriverManager;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	
	protected WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),30);
	
	public BasePage() {
		
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
		
		
	}

}
