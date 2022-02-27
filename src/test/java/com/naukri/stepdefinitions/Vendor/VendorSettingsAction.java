package com.naukri.stepdefinitions.Vendor;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.test.base.BaseAutomation;

public class VendorSettingsAction extends BaseAutomation {
	
	
	
	
	public void clickSettingPageLink(String linkName) {

		getElement(By.xpath("//a[text()='"+linkName+"']")).click();
		
	}
	
}
