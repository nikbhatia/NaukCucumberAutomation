package com.naukri.pageobjects.Settings;

import org.openqa.selenium.By;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.test.base.PageObjectWrapper;

public class AddDuplicateSettingPO extends PageObjectWrapper {
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	By duplicateSettingsHeader = By.xpath("//h1[text()=\"${header}\"]");
	By btnWithText = By.xpath("//button[text()='${text}']");
	By btnAddNew = By.xpath("//button[text()='ADD NEW']");
	By lnkDelete= By.xpath("//a[text()='DELETE']");
	By btnConfirmDelete= By.xpath("//button[text()='Delete']");
	By selectOptionWithText=By.xpath("//*[contains(text(),'${sourceType}')]");
	By ddDuplicateDuration=By.xpath("//select[@class='duplicate-selecbox']");
	

	/**
	 * This method verifying that user has been landed on Duplicate settings page.
	 * 
	 * @author himanshu.dua
	 * @param pageName
	 * @return
	 */
	public boolean verifyDuplicateSettingsPage(String pageName) {
		return isDisplayed(parameterizedLocator(duplicateSettingsHeader, pageName));
	}

	/**
	 * This method will add new duplicate setting and delete existing settings
	 * @author himanshu.dua
	 * @param btnName
	 */
	public void clickOnAddNewDuplicateSettingButton(String btnName) {
		while(isDisplayed(btnAddNew)) {
			click(lnkDelete);
			click(btnConfirmDelete);
			wait.hardWait(1);
		}
		click(parameterizedLocator(btnWithText,btnName));
	}
	
	/**
	 * This method will click on any option with text
	 * @author himanshu.dua
	 * @param optionName
	 */
	public void clickOnSourceType(String optionName) {
		click(parameterizedLocator(selectOptionWithText, optionName));
	}
	
	/**
	 * This method will select the duration from drop down
	 * @author himanshu.dua 
	 * @param option
	 */
	public void selectOptionFromDropdown(String option) {
		selectByVisibleText(ddDuplicateDuration, option);
	}
	
	public void clickOnButtonWithText(String btnName) {
		click(parameterizedLocator(btnWithText, btnName));
	}
}