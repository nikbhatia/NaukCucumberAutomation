package com.naukri.pageobjects.HiringManager;

import org.openqa.selenium.By;
import com.naukri.test.base.BaseAutomation;

public class ApprovalSettingsPagePO extends BaseAutomation {

	By btnApprovalVisibilitySetting = By.xpath("//a[@id='approvalVisibilitySetting']");
	By btnRequisitionApprovalMandatory = By.xpath("//input[@id='reqApprovalMandOnOff']");
	By toggleRequisitionApprovalMandatory = By.xpath("//a[@id='reqApprovalMandSwitch']");
	By setApprovalSetting = By.xpath("//input[@onclick='approvalVisibilitySave();']");

	/**
	 * This method is used to turn requisition approval mandatory toggle bar on or off
	 * @author gupta.mansi 
	 * @param value
	 */
	public void requisitionApprovalSetting(String value) {
		getElement(btnApprovalVisibilitySetting).click();
		wait.waitForVisibilityOfElement(toggleRequisitionApprovalMandatory);
		String presentValue = getAttribute(btnRequisitionApprovalMandatory, "value").trim();
		if (!presentValue.equalsIgnoreCase(value)) {
			getElement(toggleRequisitionApprovalMandatory).click();
		}
		wait.waitForElementToBeClickable(setApprovalSetting);
		getElement(setApprovalSetting).click();
		wait.waitForPageToLoadCompletely();
	}

}
