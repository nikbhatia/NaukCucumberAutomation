package com.naukri.pageobjects.Settings;

import org.openqa.selenium.By;

import com.naukri.test.base.BaseAutomation;

public class ManageCVBackUpPO extends BaseAutomation {

	/**
	 * @author jatin.bisht
	 */
	private By lblBoardName = By.xpath("//div[@class='job-displayname']/h2[text()='${boardName}']");
	private By btnAction1 = By.xpath("//*[text()='Commented']");
	private By btnAction2 = By.xpath("//*[text()='Viewed']");
	private By btnAction3 = By.xpath("//*[text()='Downloaded']");
	private By btnSave = By.id("saveButton");
	private By txtCommon = By.xpath("(//*[text()='${common}'])[1]");

	/**
	 * @author jatin.bisht clicking or selecting different Actions(on CV) for backUp
	 *         setting
	 */
	public void selectDifferentActions() {
		getElement(btnAction1).click();
		getElement(btnAction2).click();
		getElement(btnAction3).click();
		getElement(btnSave).click();
	}

	/**
	 * @author jatin.bisht This method clicks on text
	 * @param common:- text on which user wants to click
	 */
	public void clickOnText(String common) {
		getElement(txtCommon, common).click();
	}

	/**
	 * @author jatin.bisht All job boards are visible on Manage Job Boards page
	 */
	public boolean verifyAllBoardsDisplay(String boardName) {
		return isDisplayed(parameterizedLocator(lblBoardName, boardName));
	}
}
