package com.naukri.pageobjects.HiringManager;

import org.openqa.selenium.By;

import com.naukri.test.base.PageObjectWrapper;

public class RequirementInboxPagePO extends PageObjectWrapper {
	
	private By ddGiveFeedback = By.xpath("//span[@title='${eID}']/../../../../../../..//span[contains(text(),'Give Feedback')]");
	private By eleApplicationSatge = By.xpath("//div[@id='${appId}']//span[text()='${stage}']");
	/**
	 * @author gupta.mansi
	 * This method return true if Give Feedback button is displayed for given Application id
	 * @param eId: emailId
	 * @return: true is displayed
	 */
	public boolean isGiveFeedbackButtonDisplayed(String eId)
	{
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(ddGiveFeedback, eId));
	}
	
	/**
	 * @author gupta.mansi
	 * Return true if stage name is same as given for given app id
	 * @param appId
	 * @param stageName
	 * @return
	 */
	public boolean isStageNameSameForGivenApplicationID(String appId, String stageName)
	{
		return isDisplayed(parameterizedLocator(eleApplicationSatge, appId,stageName));
	}

}
