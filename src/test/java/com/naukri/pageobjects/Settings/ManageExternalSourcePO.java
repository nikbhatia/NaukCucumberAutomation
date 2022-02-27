package com.naukri.pageobjects.Settings;

import org.openqa.selenium.By;

import com.naukri.test.base.BaseAutomation;

public class ManageExternalSourcePO extends BaseAutomation {

	/**
	 * @author jatin.bisht
	 */
	private By txtExternalName = By.xpath("//input[@placeholder='Enter External Source Name']");
	private By divExternalSourceName = By.xpath("//*[text()='${externalSourceName}']");
	private By hvrMenuExternalSource = By.xpath("(//div[@class='menu'])[1]");
	private By btnOptions = By.xpath("(//div[text()='${optionOnExternalSource}'])[1]");

	/**
	 * @author jatin.bisht This method fills external source name by generating
	 *         random string
	 */
	public void fillExternalSourceName(String externalSourceName) {
		sendKeys(txtExternalName, externalSourceName);
	}

	/**
	 * @author jatin.bisht This nethod verifies the external source which we add is
	 *         visible or not
	 * @param externalSourceName (Name of external source)
	 */
	public boolean verifyManageExternalSourceAdd(String externalSourceName) {
		return isDisplayed(parameterizedLocator(divExternalSourceName, externalSourceName));
	}

	/**
	 * @author jatin.bisht This method first hovers on menu of external source then
	 *         click on passed string option
	 */
	public void clickOnOptionsExternalSource(String optionOnExternalSource) {
		wait.waitForPageToLoadCompletely();
		getElement(hvrMenuExternalSource).click();
		getElement(btnOptions, optionOnExternalSource).click();
	}

	/**
	 * @author jatin.bisht This method clear external soruce name
	 * @param externalSourceName
	 */
	public void fillNewExternalSourceName(String externalSourceName) {
		getElement(txtExternalName).clear();
		sendKeys(txtExternalName, externalSourceName);
	}

}
