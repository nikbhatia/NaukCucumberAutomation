package com.naukri.pageobjects.Offer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

/**
 * @author raunak.b
 *
 */
public class OfferGenerationSalaryListingPO extends BaseAutomation {

	public static By createSalaryBreakupBtn = By.xpath("//button[@id='create-salary-breakup-btn']");
	public static By uploadExcelSpreadsheet = By.xpath("//button[text()='Upload Salary Spreadsheet']");
	public static By salaryBreakupName = By.xpath("//input[@class='exl-lbl-inp ']");
	public static By cancelSalaryBreakupsBtn = By.xpath("//button[@id='cancel-salary-template-creation']");
	public static By nextSalaryBreakupsBtn = By.xpath("//button[@class='save blockBtn']");
	public static By ContinueConfirmationBtn = By.xpath("//button[@class='confBtn yes']");
	public static By firsttemplateOnListing = By.xpath("(//span[@class='inline-name'])[1]");
	public static By draftOnListingPage = By
			.xpath("//span[contains(text(),'${string}')]/following-sibling::span[@class='sb-template-draft']");
	public static By totalTemplates = By.xpath("//li[contains(@class,'table-data')]");
	public static By templateNumberDD = By.xpath("//div[@class='pagination']//select");
	public static By deleteStripOnListingPage = By.xpath("//span[@class='hideErrSucc']");
	// public static By entryOnListingPageLastEdited =
	// By.xpath("//span[text()='${string}']//ancestor::li//div[2]");
	// public static By entryOnListingPageLastModified =
	// By.xpath("//span[text()='${string}']//ancestor::li//div[3]");
	public static By entryOnListingPageActions = By.xpath("//span[text()='${string}']//ancestor::li//div[${string}]");
	public static By salaryTemplateNameOnListingPage = By.xpath("(//span[@class='inline-name'])[${string}]");
	public static By salaryTemplateNameOnEdit = By.xpath("//input[@class='inline-tb ']");
	public static By saveCrossTemplateListingPage = By.xpath("//img[@class='inline--${string}-btn']");
	public static By errorOnListingPageInvalidChar = By.xpath("//span[@class='inline-value-error-msg']");
	public static By errorStripListingPage = By.xpath("//div[@class='msg']");

	public static By NoOfTemplateFromListingPageDD = By
			.xpath("//div[@class='pagination']//select/option[@value='${string}']");
	public static By editListingPage = By
			.xpath("//span[contains(text(),'${string}')]/ancestor::li//span[@class='sb-edit sb-row-action']//img");
	public static By deleteListingPage = By
			.xpath("//span[contains(text(),'${string}')]/ancestor::li//span[@class='sb-delete sb-row-action']//img");
	public static By eleSalaryTemplates = By.xpath("//li[@class=\"table-data-row list  undefined\"]");
	public static By eleDeleteIconForFirstSalaryTemplate = By
			.xpath("(//span[@class='sb-delete sb-row-action']//img)[1]");
	public static By eleDeleteIconForFirstOfferDocTemplate = By.xpath("(//span[@class='od-delete od-row-action']//img)[1]");

	OfferGenerationSalaryRuleSettingsPO salaryRulePO = new OfferGenerationSalaryRuleSettingsPO();
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	OfferSettingsPagePO offerSettings = (OfferSettingsPagePO) PageObjectWrapper.getObject(OfferSettingsPagePO.class);

	/**@author raunak.b
	 * To click on create salary breakup btn
	 */
	public void clickOnCreateSalaryBreakup() {
		// wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(createSalaryBreakupBtn);
		// wait.waitForElementToBeClickable(createSalaryBreakupBtn);
		// getElement(createSalaryBreakupBtn).click();
		click(createSalaryBreakupBtn);
	}

	/**@author raunak.b
	 * To verify salary template rule name
	 * 
	 * @return boolean
	 */
	public boolean salaryTemplateRuleNameVisible() {
		wait.waitForPageToLoadCompletely();
		String getTemplateNameFRomPropertiesFile = ReadWritePropertyFile.getProperty("SalaryBreakupName",
				salaryRulePO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		String firstSalaryTemplateName = getElement(firsttemplateOnListing).getText();
		if (getTemplateNameFRomPropertiesFile.equals(firstSalaryTemplateName)) {
			return true;
		} else {
			return false;
		}
	}

	/**@author raunak.b
	 * To check draft label is displayed
	 * 
	 * @return boolean
	 */
	public boolean draftLabelDisplayed() {
		String getTemplateNameFRomPropertiesFile = ReadWritePropertyFile.getProperty("SalaryBreakupName",
				salaryRulePO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		return getElement(draftOnListingPage, getTemplateNameFRomPropertiesFile).isDisplayed();
	}

	/**@author raunak.b
	 * To verify last modified and last edited
	 * 
	 * @param ExpecteduserName
	 * @return boolean
	 */
	public boolean verifyLastModifiedANdLastEdited(String ExpecteduserName) {
		String getTemplateNameFromPropertiesFile = ReadWritePropertyFile.getProperty("SalaryBreakupName",
				salaryRulePO.fileSystemPath() + "offerManagementSalaryBreakup.properties");

		String ActuallastEditedBy = getElement(entryOnListingPageActions, getTemplateNameFromPropertiesFile + "|2")
				.getText();
		String ActuallastModifiedDate = getElement(entryOnListingPageActions, getTemplateNameFromPropertiesFile + "|3")
				.getText();
		String ExpectedLastModifiedDate = genericFunctions.getCurrentDate("DD MMM YYYY");
		// if(ActuallastEditedBy.contains(ExpecteduserName) &&
		// ActuallastModifiedDate.contains(ExpectedLastModifiedDate))
		String[] userAndPass = offerSettings.getUsernameAndPasswordForOffer(ExpecteduserName);
		if (userAndPass[0].equalsIgnoreCase("lokesh.agrawal@naukri.com")) {
			if (ActuallastEditedBy.contains(userAndPass[0]) | ActuallastEditedBy.contains("Lokesh Agrawal"))
				return true;
			else
				return false;
		} else if (userAndPass[0].equalsIgnoreCase("singh.avinash@naukri.com")) {
			if (ActuallastEditedBy.contains(userAndPass[0]) | ActuallastEditedBy.contains("Avinash Singh"))
				return true;
			else
				return false;
		} else
			return false;
	}

	/**@author raunak.b
	 * To verify count templates displayed
	 * 
	 * @param numberOfTemplates
	 * @return boolean
	 */
	public boolean verifyCountTemplatesDisplayed(int numberOfTemplates) {
		return getElements(totalTemplates).size() == numberOfTemplates;
	}

	/**@author raunak.b
	 * To select number from template DD
	 * 
	 * @param number
	 */
	public void selectNumberFromTemplateDD(int number) {
		click(templateNumberDD);
		click(parameterizedLocator(NoOfTemplateFromListingPageDD, Integer.toString(number)));
	}

	/**@author raunak.b
	 * To delete template from listing page
	 */
	public void deleteTemplateListingPage() {
		String getTemplateNameFromPropertiesFile = ReadWritePropertyFile.getProperty("SalaryBreakupName",
				salaryRulePO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		wait.waitForVisibilityOfElement(parameterizedLocator(deleteListingPage, getTemplateNameFromPropertiesFile));
		jsUtil.executeJavascript("document.getElementsByClassName('sb-listing-row-actions')[0].style.display='block';");
		jsUtil.clickByJS(parameterizedLocator(deleteListingPage, getTemplateNameFromPropertiesFile));
		getElement(ContinueConfirmationBtn).click();
		wait.waitForPageToLoadCompletely();
	}

	/**@author raunak.b
	 * To verify template is displayed
	 * 
	 * @return boolean
	 */
	public boolean verifyTemplateNotDisplayed() {
		wait.waitForPageToLoadCompletely();
		getElement(deleteStripOnListingPage).click();
		return driver.getPageSource().contains(ReadWritePropertyFile.getProperty("SalaryBreakupName",
				salaryRulePO.fileSystemPath() + "offerManagementSalaryBreakup.properties"));
	}

	/**@author raunak.b
	 * To edit template listing page
	 */
	public void editTemplateListingPage() {
		wait.waitForPageToLoadCompletely();
		String getTemplateNameFromPropertiesFile = ReadWritePropertyFile.getProperty("SalaryBreakupName",
				salaryRulePO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		jsUtil.executeJavascript("document.getElementsByClassName('sb-listing-row-actions')[0].style.display='block';");
		jsUtil.clickByJS(parameterizedLocator(editListingPage, getTemplateNameFromPropertiesFile));
		wait.waitForPageToLoadCompletely();
	}

	/**enter duplicate template name on listing page 
	 * 
	 */
	public void enterDuplicateTemplateName() {
		wait.waitForPageToLoadCompletely();
		String secondTemplateOnListingPage = getElement(salaryTemplateNameOnListingPage, "2").getText();
		// System.out.println(secondTemplateOnListingPage);
		getElement(salaryTemplateNameOnListingPage, "1").click();
		sendKeys(salaryTemplateNameOnEdit, secondTemplateOnListingPage);
		// click(saveCrossTemplateListingPage+"|save");
		getElement(saveCrossTemplateListingPage, "save").click();
	}

	/**@author raunak.b
	 * verify duplicate names of salary template not allowed 
	 * @param error
	 * @return true if error strip visible 
	 */
	public boolean verifyDuplicateNameNotAllowed(String error) {
		wait.waitForPageToLoadCompletely();
		return getElement(errorStripListingPage).getText().equals(error);
	}

	/**@author raunak.b
	 * click on cancel button on template 
	 */
	public void clickOnCancelButtonTemplate() {
		getElement(saveCrossTemplateListingPage, "cancel").click();
	}

	/**@author raunak.b
	 * enter invalid char as template name
	 * @param invalidChar
	 */
	public void enterInvalidCharsAsTemplateName(String invalidChar) {
		getElement(salaryTemplateNameOnListingPage, "1").click();
		sendKeys(salaryTemplateNameOnEdit, invalidChar);
		getElement(saveCrossTemplateListingPage, "save").click();
	}

	/**@author raunak.b
	 * verify error msg on listing page
	 * @param msg
	 * @return true if error msg displayed on listing page
	 */
	public boolean verifyErrorMsgOnListingPage(String msg) {
		return getElement(errorOnListingPageInvalidChar).getText().equals(msg);
	}

	/**@author raunak.b
	 * delete All Salary Templates
	 */
	public void deleteAllSalaryTemplates() {
		int salaryTableList = getElements(eleSalaryTemplates).size();
		while (salaryTableList > 0) {
			deleteFirstSalaryTemplateInList();
			salaryTableList = getElements(eleSalaryTemplates).size();
		}
	}

	/**@author raunak.b
	 * delete First Salary Template In List
	 */
	public void deleteFirstSalaryTemplateInList() {
		jsUtil.executeJavascript("document.getElementsByClassName('sb-listing-row-actions')[0].style.display='block';");
		jsUtil.clickByJS(eleDeleteIconForFirstSalaryTemplate);
		getElement(ContinueConfirmationBtn).click();
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * delete All Offer Document Templates
	 */
	public void deleteAllOfferDocTemplates() {
		int offerDocList = getElements(eleSalaryTemplates).size();
		while (offerDocList > 0) {
			deleteFirstOfferDocumentTemplateInList();
			offerDocList = getElements(eleSalaryTemplates).size();
		}
	}

	/**
	 * delete First Offer Document Template In List
	 */
	public void deleteFirstOfferDocumentTemplateInList() {
		jsUtil.executeJavascript("document.getElementsByClassName('od-listing-row-actions')[0].style.display='block';");
		jsUtil.clickByJS(eleDeleteIconForFirstOfferDocTemplate);
		getElement(ContinueConfirmationBtn).click();
		wait.waitForPageToLoadCompletely();
	}

}
