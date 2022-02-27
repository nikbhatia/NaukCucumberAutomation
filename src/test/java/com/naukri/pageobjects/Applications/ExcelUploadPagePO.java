package com.naukri.pageobjects.Applications;

import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

/**
 * Excel upload page object class of Applications Module
 * @author rachit.mehrotra
 *
 */
public class ExcelUploadPagePO extends PageObjectWrapper{

	By eleExcelUploadPageHeading = By.xpath("//div[contains(text(),'${replcaementOption}')]");
	
	/**
	 * To verify the presence of excel upload heading
	 * @param expectedOption
	 * @return true/false basis comparison
	 */
	public boolean verifyThePresenceOfExcelUploadHeading(String expectedOption) {
		return isDisplayed(parameterizedLocator(eleExcelUploadPageHeading, expectedOption));
	}
}
