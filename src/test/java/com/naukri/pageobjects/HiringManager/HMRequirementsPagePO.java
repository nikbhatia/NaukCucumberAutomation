package com.naukri.pageobjects.HiringManager;

import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

public class HMRequirementsPagePO extends PageObjectWrapper{
	
	By btnRefineRequirement = By.xpath("//a[@id='refine_project']");
	By lblPageTitle = By.xpath("//div[@id='pageTitle']");
	By lblRefiningOn = By.xpath("//span[@id='refineOnText']");
	By lblRequirementTitle = By.xpath("//a[@id='tab_2']");
	By lblLastModified = By.xpath("//a[@id='tab_1']");
	By lblGroup = By.xpath("//div[text()='Group']");
	By lblNumberOfApplication = By.xpath("//div[text()='Number of Applications']");
	By lblCreatedBy = By.xpath("//ul[@id='ques_list']//span[text()='Created By']");
	By btnClrAllRefine = By.xpath("//a[@id='clearTag']");
	By btnCloseRefine = By.xpath("//div[@id='refinewrap']//a[text()=' Close']");
	By txtRequirementName = By.xpath("//a[@title='${ReqName}']");
	By lnkApplicationCountAgainstReq = By.xpath("//a[@title='${string}']/../../..//em[contains(@id,'appCount')]");

	/**
	 * @author gupta.mansi
	 * This method returns true if requirement name is displayed on first page of requirement listing page
	 * @param requirementName
	 * @return true if Requirement name is displayed
	 */
	public boolean isRequirementNameDisplayed(String requirementName)
	{
		return isDisplayed(parameterizedLocator(txtRequirementName, requirementName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method clicks on Application count for given requirement name and switched to tab opened
	 * @param reqName
	 */
	public void clickOnAppCountAndSwitchToTab(String reqName)
	{
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(parameterizedLocator(lnkApplicationCountAgainstReq, reqName));
		click(parameterizedLocator(lnkApplicationCountAgainstReq, reqName));
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
	}
	
}