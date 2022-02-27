package com.naukri.pageobjects.Offer;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.stepdefinitions.Offer.OfferGenerationSalaryRuleSettingsStepDef;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

/**
 * @author raunak.b
 *
 */
public class offerDocTemplatePO extends BaseAutomation {

	private By addNewOfferDoc = By.xpath("//button[@id='create-offer-doc-btn']");
	private By enterDocTemplateName = By.xpath("//input[@class='odt-tmpl-name ']");
	private By warningStripNoSalaryBreakup = By.xpath(
			"//div[@class='msg']//span[contains(text(),'Offer Document Template cannot be created without Salary Breakup Template')]");
	private By hereLinkSalaryBreakup = By.xpath("//a[text()='here']");
	private By offerSalaryDD = By.xpath("//span[@class='dropArrowDD']");
	private By selectOfferSalaryTemplateFromDD = By.xpath("(//ul[@class='dropdown ']//span)[${string}]");
	private By saveDocTemplate = By.xpath("//button[@id='save-offer-doc-template']");
	private By templateDocEntry = By.xpath("(//span[@class='inline-name'])[1]");
	private By salaryTemplateMappedToDoc = By.xpath("(//div[@class='table-row-item'])[2]");
	private By deleteDocTemplateFromListing = By
			.xpath("//span[contains(text(),'${string}')]/ancestor::li//span[@class='od-delete od-row-action']//img");
	private static By ContinueConfirmationBtn = By.xpath("//button[@class='confBtn yes']");
	private static By errorStripListingPage = By.xpath("//div[@class='msg']");
	private static By TemplateSearchByTxt = By.xpath("//span[text()='${string}']");
	private static By salaryTemplateEntryListingPage = By.xpath("(//span[text()='${string}']/ancestor::li//div)[3]");
	private static By editDocTemplateListing = By
			.xpath("//span[contains(text(),'${string}')]/ancestor::li//span[@class='od-edit od-row-action']//img");
	private By inlineEditTemplateName = By.xpath("//input[@class='inline-tb ']");
	private By saveInlineEditTemplateName = By.xpath("//img[@class='inline--save-btn']");
	private By errorMessage = By.xpath("//div[@class='msg']");

	OfferGenerationSalaryListingPO offerSettings = (OfferGenerationSalaryListingPO) PageObjectWrapper
			.getObject(OfferGenerationSalaryListingPO.class);
	OfferGenerationSalaryRuleSettingsPO salarybreakupRuleObject = (OfferGenerationSalaryRuleSettingsPO) PageObjectWrapper
			.getObject(OfferGenerationSalaryRuleSettingsPO.class);
	OfferGenerationSalaryTemplateOutputPO salarybreakupRUleOutputObject = (OfferGenerationSalaryTemplateOutputPO) PageObjectWrapper
			.getObject(OfferGenerationSalaryTemplateOutputPO.class);
	OfferGenerationSalaryTemplateReviewNApprovePO reviewnApproveObject = (OfferGenerationSalaryTemplateReviewNApprovePO) PageObjectWrapper
			.getObject(OfferGenerationSalaryTemplateReviewNApprovePO.class);
	OfferValidationPagePO validationPO = (OfferValidationPagePO) PageObjectWrapper
			.getObject(OfferValidationPagePO.class);
	static String offerDocRandomName = "Test" + System.currentTimeMillis();

	/**
	 * @author raunak.b click on add new offer documnet
	 */
	public void clickAddNewOfferDoc() {
		wait.waitForElementToBeClickable(addNewOfferDoc);
		click(addNewOfferDoc);
	}

	/**
	 * @author raunak.b verify whether salary breakup exists or not
	 * 
	 * @return true if salary breakup template not displayed
	 */
	public boolean checkWhetherSalaryBreakupExistsOrNot() {
		// return getElement(warningStripNoSalaryBreakup).isDisplayed();
		return isDisplayed(warningStripNoSalaryBreakup);
	}

	/**
	 * @author raunak.b call function to create salary breakup template if not
	 *         present
	 * 
	 */
	public void ifSalarytemplateNotPresentCreate() {
		if (checkWhetherSalaryBreakupExistsOrNot()) {
			click(hereLinkSalaryBreakup);
			wait.waitForPageToLoadCompletely();
			switchToChildWindow();
			createSalaryBreakupTemplate();
		}
	}

	/**
	 * @author raunak.b create salary breakup template
	 */
	public void createSalaryBreakupTemplate() {

		offerSettings.clickOnCreateSalaryBreakup();
		salarybreakupRuleObject.UploadExcelFromBreakups("SampleExcel1.xlsx");
		salarybreakupRuleObject.fillSalaryRuleTemplateName();
		salarybreakupRuleObject.clickOnNextButtonOnSalaryBreakup();
		salarybreakupRuleObject.chooseLabelAndSheet("Sheet1", "Column A");
		salarybreakupRuleObject.clickOnNextButtonOnSalaryBreakup();
		salarybreakupRuleObject.clickOnNextButtonOnSalaryBreakup();
		salarybreakupRUleOutputObject.selectStringInCTCDropdown("Sheet1:B2");
		salarybreakupRuleObject.clickOnNextButtonOnSalaryBreakup();
		reviewnApproveObject.enterValueInFieldOnReviewPage("string", "Offered Designation");
		validationPO.selectDateInCalendar("Offered on", Integer.parseInt("2"));
		validationPO.selectDateInCalendar("Candidate's tentative joining date", Integer.parseInt("4"));
		reviewnApproveObject.enterValueInFieldOnReviewPage("number", "Label4");
		reviewnApproveObject.enterValueInFieldOnReviewPage("number", "Label1");
		reviewnApproveObject.clickLinkOnReviewPage("Update Breakup");
		wait.hardWait(2);
		salarybreakupRUleOutputObject.clickButton("Confirm");

	}

	/**
	 * @author raunak.b enter offer doc template name while creating new offer doc
	 * 
	 */
	public void enterOfferDocTemplateName() {
		String offerDocRandomName = "DOc" + System.currentTimeMillis();
		ReadWritePropertyFile.setProperty("offerDocName", offerDocRandomName,
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		sendKeys(enterDocTemplateName, offerDocRandomName);
	}

	/**
	 * @author raunak.b select first salary breakup from DD
	 * 
	 */
	public void SelectSalaryBreakupDD() {
		click(offerSalaryDD);
		wait.waitForVisibilityOfElement(parameterizedLocator(selectOfferSalaryTemplateFromDD, Integer.toString(1)));
		String salaryBreakupAgainstDoc = getText(
				parameterizedLocator(selectOfferSalaryTemplateFromDD, Integer.toString(1)));
		ReadWritePropertyFile.setProperty("offerSalaryBreakupAgainstDoc", salaryBreakupAgainstDoc,
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		click(parameterizedLocator(selectOfferSalaryTemplateFromDD, Integer.toString(1)));
		// wait.hardWait(10);
	}

	/**
	 * @author raunak.b click on save offer document template
	 * 
	 */
	public void clickOnSaveOfferDocTemplate() {
		wait.waitForValignWrapperToDisappear(1019, 577);
		wait.waitForPageToLoadCompletely();
		jsUtil.executeJavascript("document.getElementById('save-offer-doc-template').click();");
		wait.hardWait(10);
	}

	/**
	 * @author raunak.b verify offer doc row on listing page
	 * 
	 * @return true if document template is mapped to salary breakup template
	 */
	public boolean verifyOfferDocRowOnListingPage() {
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(templateDocEntry);
		String docTemplateName = ReadWritePropertyFile.getProperty("offerDocName",
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		String salaryBreakupTemplateName = ReadWritePropertyFile.getProperty("offerSalaryBreakupAgainstDoc",
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		return getText(templateDocEntry).contains(docTemplateName)
				&& getText(salaryTemplateMappedToDoc).contains(salaryBreakupTemplateName);
	}

	/**
	 * @author raunak.b delete doc template from listing page
	 * 
	 */
	public void deleteDocTemplate() {
		String getTemplateNameFromPropertiesFile = ReadWritePropertyFile.getProperty("offerDocName",
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		jsUtil.executeJavascript("document.getElementsByClassName('od-listing-row-actions')[0].style.display='block';");
		jsUtil.clickByJS(parameterizedLocator(deleteDocTemplateFromListing, getTemplateNameFromPropertiesFile));
		getElement(ContinueConfirmationBtn).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author raunak.b verify delete confirmation strip displayed on listing page
	 * 
	 * @return true if delete strip is displayed
	 */
	public boolean deleteStripOnListingDisplayed() {
		String docTemplateName = ReadWritePropertyFile.getProperty("offerDocName",
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		wait.waitForVisibilityOfElement(errorStripListingPage);
		return getText(errorStripListingPage).contains("The template " + docTemplateName + " is deleted.");
	}

	/**
	 * @author raunak.b verify offer doc template is not displayed on listing page
	 *         after deletion
	 * 
	 * @return false if offer doc template not displayed after deletion
	 */
	public boolean verifyOfferDOcTemplateNotDisplayed() {
		String docTemplateName = ReadWritePropertyFile.getProperty("offerDocName",
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		return isDisplayed(parameterizedLocator(TemplateSearchByTxt, docTemplateName));
	}

	/**
	 * @author raunak.b click salary breakup DD on offer doc creation page
	 * 
	 */
	public void clickSalaryBreakupDD() {
		click(offerSalaryDD);
	}

	/**
	 * @author raunak.b select newly created salary breakup from salary breakup DD
	 * 
	 */
	public void selectCreatedSalaryBreakup() {
		String salaryBreakupName = ReadWritePropertyFile.getProperty("SalaryBreakupName",
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		click(parameterizedLocator(TemplateSearchByTxt, salaryBreakupName));
	}

	/**
	 * @author raunak.b verify salary breakup not displayed on listing
	 * 
	 * @return false if salary breakup not displayed on listing
	 */
	public boolean verifySalaryBreakupNotDisplayedOnListing() {
		String salaryBreakupName = ReadWritePropertyFile.getProperty("SalaryBreakupName",
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		return isDisplayed(parameterizedLocator(salaryTemplateEntryListingPage, salaryBreakupName));
	}

	/**
	 * @author raunak.b verify salary breakup not displayed on DD
	 * 
	 * @return false if salary breakup not displayed on DD
	 */
	public boolean verifySalaryBreakupNotDisplayedOnDD() {
		String salaryBreakupName = ReadWritePropertyFile.getProperty("SalaryBreakupName",
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		return isDisplayed(parameterizedLocator(TemplateSearchByTxt, salaryBreakupName));
	}

	/**
	 * @author raunak.b click edit icon on offer doc listing page
	 * 
	 */
	public void clickEditOfferDocDOcListingPage() {
		driver.navigate().refresh();
		wait.waitForPageToLoadCompletely();
		String getTemplateNameFromPropertiesFile = ReadWritePropertyFile.getProperty("offerDocName",
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		jsUtil.executeJavascript("document.getElementsByClassName('od-listing-row-actions')[0].style.display='block';");
		jsUtil.clickByJS(parameterizedLocator(editDocTemplateListing, getTemplateNameFromPropertiesFile));
		// getElement(ContinueConfirmationBtn).click();
		wait.waitForPageToLoadCompletely();
		// wait.hardWait(3);
		wait.waitForVisibilityOfElement(parameterizedLocator(enterDocTemplateName, getTemplateNameFromPropertiesFile));
	}

	/**
	 * @author raunak.b edit doc template name on offer doc creation
	 * 
	 */
	public void editDocTemplateName() {
		wait.hardWait(10);
		sendKeys(enterDocTemplateName, "");
		String offerDocRandomName = "DOc" + System.currentTimeMillis();
		ReadWritePropertyFile.setProperty("offerDocName", offerDocRandomName,
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		sendKeys(enterDocTemplateName, offerDocRandomName);
	}

	/**
	 * @author raunak.b select another rule name
	 * 
	 */
	public void selectAnotherRuleName() {
		click(offerSalaryDD);
		wait.hardWait(2);
		wait.waitForElementToBeClickable(parameterizedLocator(selectOfferSalaryTemplateFromDD, Integer.toString(2)));
		getElement(parameterizedLocator(selectOfferSalaryTemplateFromDD, Integer.toString(2))).click();
	}

	/**
	 * @author raunak.b Inline edit created template from listing page
	 */
	public void InlineEditCreatedTemplateFromListingPage() {
		// static String offerDocRandomName = "Test" + System.currentTimeMillis();
		String offerDoc = ReadWritePropertyFile.getProperty("offerDocName",
				salarybreakupRuleObject.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		click(parameterizedLocator(TemplateSearchByTxt, offerDoc));
		getElement(inlineEditTemplateName).clear();
		;
		sendKeys(inlineEditTemplateName, offerDocRandomName);
		// wait.hardWait(3);
		click(saveInlineEditTemplateName);

	}

	/**
	 * @author raunak.b verify doc template name is edited or not
	 * @return true if doc template name is edited
	 */
	public boolean verifyDocTemplateNameEdited() {
		wait.waitForPageToLoadCompletely();
		String warningMsg = "The template name has been successfully updated to " + offerDocRandomName + "";
		System.out.println(getText(errorMessage));
		System.out.println(warningMsg);
		return getText(errorMessage).contains(warningMsg);
	}

		/**
	 * create Salary Template in draft state
	 */
	public void createDraftSalaryTemplate() {
		offerSettings.clickOnCreateSalaryBreakup();
		salarybreakupRuleObject.UploadExcelFromBreakups("SampleExcel1.xlsx");
		salarybreakupRuleObject.fillSalaryRuleTemplateName();
		salarybreakupRuleObject.clickOnNextButtonOnSalaryBreakup();
		salarybreakupRuleObject.clickOnCancelButtonOnSalaryBreakup();
		offerSettings.draftLabelDisplayed();
	}
}