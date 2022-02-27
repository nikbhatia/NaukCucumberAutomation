package com.naukri.pageobjects.Applications;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.PageObjectWrapper;

public class AdvanceSearchPO extends PageObjectWrapper {
	
	final static String activeMenuClass = "active";

	By eleProfileAdvSearchLink = By.id("advSrchLink");
	By eleProfileOptionInGnb = By.xpath("//div[@class=\"gnbOuter\"]//a[text()=\"Profiles\"]/parent::li");
	By eleAdvancedSearchHeading = By.xpath("//div[contains(text(),'${advancedSearchHeadingText}')]");
	By eleDivisionSearchHeading = By.xpath("//*[contains(text(),'${advancedSearchHeadingText}')]");
	By eleModifiedInList = By.xpath("//select[@name=\"lastModified\"]/option");
	By eleFindResumeLocator = By.xpath("//input[contains(@value,'${buttonText}')]");
	By eleAdvancedSearchApplication = By.xpath("//div[contains(@class,\"refineGr\")]//a[contains(text(),\"Advanced Search\")]");
	
	public void clickOnProfileAdvSearch(String advanceSearchIdentifier) {
		By by = advanceSearchIdentifier.equalsIgnoreCase("Profile Search") ? eleProfileAdvSearchLink : eleAdvancedSearchApplication;
		click(by);
	}
	
	public boolean checkProfileOptionOfGNBAsActive() {
		return getAttribute(eleProfileOptionInGnb, "class").contains(activeMenuClass);
	}
	
	public boolean verifyThePresenceOfHeadingOnAdvanceSearchLayout(String headingText) {
		By by = (headingText.equalsIgnoreCase("advanced search") || headingText.equalsIgnoreCase("Basic Details"))? parameterizedLocator(eleAdvancedSearchHeading, headingText) : 
				parameterizedLocator(eleDivisionSearchHeading, headingText);
		jsUtil.scrollDown(by);
		return isDisplayed(by);
	}
	
	public boolean verifyPresenceOfFindResume(String buttonText) {
		return isDisplayed(parameterizedLocator(eleFindResumeLocator, buttonText));
	}
	
	public boolean verifyModifiedListOfAction(List<String> actualValueList) {
		List<WebElement> modifiedListOnUi = getElements(eleModifiedInList);
		for(WebElement we : modifiedListOnUi) {
			if(!actualValueList.contains(we.getText())) {
				TestNGLogUtility.info("Option on UI " + we.getText());
				return false;
			}
		}
		return true;
	}
	
}
