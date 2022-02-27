package com.naukri.pageobjects.Applications;

import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

public class ApplicationLogsPagePO extends PageObjectWrapper {
	
	By eleApplicationLogsHeading = By.xpath("//div[contains(text(),'${applicationHeadingText}')]");
	
	public boolean verifyThePresenceOfApplicationLogsHeading(String headingText) {
		return isDisplayed(parameterizedLocator(eleApplicationLogsHeading, headingText));
	}

}
