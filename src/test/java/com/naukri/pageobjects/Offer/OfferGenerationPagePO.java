package com.naukri.pageobjects.Offer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;

/**
 * @author udit.khanna
 *
 */
public class OfferGenerationPagePO extends BaseAutomation {

	// variables
	public static String candidateName = "", contactNumber = "", emailId = "", requirementTitle = "",
			offeredDesignation = "", candidatesJoiningSalary = "", offerLetterPath = "", offerLetterTemplate = "",
			offerMailSubjectText = "", offerMailBodyText = "";
	static String selectionStage = "Prospect";
	public static String candidateDetailsPageUrl = "";
	static String OfferGenPageVerifyText = "Fill Offer Details";

	// locators
	public By btnNextOnOfferDetails = By.id("sendOfferMail");
	public By attachOfferLetterInput = By.id("attachOfferLetter");
	public By btnAttachOfferLetterUpload = By.xpath("//*[starts-with(@class,'uploadBtn')]");
	public By offerMailSubject = By.id("offerSub");
	public By btnSendMail = By.id("sendOfferMail");
	public By btnUploadOfferLetter = By.xpath("//button[text()='UPLOAD']");
	public By offerMailBody = By.xpath("//div[@class='mailBodyWriter']");
	public By attachOfferLetterErrorMsg = By.xpath("//div[@class='msg']");
	public By btnSaveTemplate = By.xpath("//div[@class='msg']");
	public By txtSaveOfferTemplate = By.id("saveOfferTemp");
	public By btnSendOfferMail = By.id("sendOfferMail");
	public By txtQuickSearchTemplate = By.id("headSearch");
	public By btnQuickSearchTemplate = By.xpath("//input[@id='headSearch']/following::input[@type='submit']");
	public By searchTemplateResultFirstElement = By.xpath("//a[contains(@id,'mailTemplateName')]");
	public By inactiveStepper = By.xpath("//span[@class='stepper  disable']/span");
	public By candidateStatusMsg = By.xpath("//div[@class='candOffrStatus']");
	public By btnSendReminder = By.xpath("//a[@data-actiontype='sendReminder']");
	public By msgSuccessReminderSent = By
			.xpath("//a[@id = 'closeSendReminderMsg']/following::div//span[@class='etxt']/span");
	public By btnEditOffer = By.cssSelector("#generateOffer .generate-offer-docum-text");
	public By msgEditOffer = By.xpath("//*[@id='statusRibbon']//div[@class='msg']");
	public By offeredDesignationOnCVDetails = By.xpath("//strong[@class='designation']");
	public By salaryOnCVDetails = By.xpath("(//span[@class='salValue'])[1]");
	public By previewMailSubject = By.xpath("(//div[@id='mailLayoutDiv']/parent::form//div)[1]");
	public By previewMailBody = By.id("mailBodyData");
	public By selectOfferStageFromDD = By.xpath("(//li[starts-with(@class,'isOfferStage')])[${string}]");
	public By attachOfferLetterSection = By.xpath("//div[@class='AttachOffer posR']");
	public By IncludeSignature = By.xpath("//label[text()='${string}']");
	public By eleOfferDetailsSection = By.xpath("//div[@class='candFieldHead']/span[contains(text(),'Offer Details')]");
	public By eleOfferStatusInOfferTimeline = By.xpath("//strong[@class='offerStat']/span");
	public By PrefillOfferletterDD = By.xpath("//span[text()='${string}']");
	public By mailSubject = By.xpath("//input[@id='offerSub']");
	public By mailBody = By.xpath("(//div[@class='mailBodyWriter']//u)[2]");
	private By eleCurrencyDDArrow = By.xpath("//div[@class=\"select-controller\"]/span[@class=\"select-toggler\"]");
	private By eleCurrencyDDValue = By.xpath("//div[@class=\"select-list\"]//li/span[text()='${string}']");
	private By eleSalaryOfferInOfferDetailsSection = By
			.xpath("//div[@class=\"offrDetail\"]//span[contains(text(),'${string}')]/following-sibling::span");
	private By eleSalaryOfferInOfferStatusSection = By
			.xpath("//div[@class=\"mt5\"]//span[contains(text(),'${string}')]/following-sibling::span");
	private By elePreviousOfferDownArrow = By
			.xpath("//strong[text()='${string}']/following-sibling::span[@class='dwnArrow']");
	private By elePreviousOfferedDesignation = By
			.xpath("//div[@id=\"prevOffersContainer\"]//strong[@class=\"designation\"]");
	private By elePreviousCandidatesJoiningSalary = By
			.xpath("//div[@id=\"prevOffersContainer\"]//span[text()='Salary Offered ']/following-sibling::span[@class=\"salValue\"]");
	private By cancelAttachOfferLetter = By.xpath("//button[text()='Skip']");
	private By salaryOnOfferStripCVDetails = By.xpath("(//span[@class='salOffer']/following-sibling::span)[1]");
	private By designationOnOfferstripCVDetails = By.xpath("//span[@class='offrDesignation']");
	private By offerLogsStatusCandidate = By.xpath("//div[@title='${string}']/following-sibling::div/div[contains(@class,'statusValue')]");        
        private By offerEllipsis = By.cssSelector("#subStageStatusChange img[src$='ellipsis.svg']");
        
	public void clickNextOnOfferDetailsBtn() {
		click(btnNextOnOfferDetails);
	}

	/**
	 * Wait for visibility of Upload Offer Letter button
	 */
	public void waitForUploadOfferLetterButton() {
		wait.waitForVisibilityOfElement(btnUploadOfferLetter);
	}

	/**
	 * Attach Offer Letter based on file size
	 * 
	 * @param fileSize
	 * @author udit.khanna
	 */
	public void attachOfferLetterOnAttachOfferLetterPage(String fileSize) {
		offerLetterPath = getOfferLetterPath(fileSize);
		// To display the input field of AttachOfferLetter button
		jsUtil.executeJavascript(
				"document.getElementById('attachOfferLetter').setAttribute('style', 'display:block');");
		driver.findElement(By.id("attachOfferLetter")).sendKeys(offerLetterPath);
	}

	/**
	 * Gives the Offer Letter Path to be attached
	 * 
	 * @param fileSize
	 *            to be attached
	 * @return
	 * @author udit.khanna
	 */
	private String getOfferLetterPath(String fileSize) {
		String filePathYaml = "", offerLetterPath = "";
		switch (fileSize) {
		case "Less than 5 MB":
			filePathYaml = "OfferLetterPathLessThan5MB";
			break;
		case "More than 5 MB":
			filePathYaml = "OfferLetterPathMoreThan5MB";
			break;
		default:
			filePathYaml = "";
		}
		offerLetterPath = OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
				+ YamlReader.getAppConfigValue("TestData." + filePathYaml);
		return offerLetterPath;
	}

	/**
	 * Clears subject field of Offer Mail
	 * 
	 * @author udit.khanna
	 */
	public void clearOfferMailSubject() {
		wait.waitForVisibilityOfElement(offerMailSubject);
		getElement(offerMailSubject).clear();
		sendKeys(offerMailSubject, "a");
		getElement(offerMailSubject).sendKeys(Keys.BACK_SPACE);
	}

	/**
	 * Verifies if Send Mail Button is disabled
	 * 
	 * @author udit.khanna
	 * @return
	 */
	public boolean verifySendMailButtonDisabled() {
		return getAttribute(btnSendMail, "class").contains("disable");
	}

	/**
	 * Clears body field of Offer Mail
	 * 
	 * @author udit.khanna
	 */
	public void clearOfferMailBody() {
		wait.waitForVisibilityOfElement(offerMailBody);
		getElement(offerMailBody).clear();

	}

	/**
	 * Verify error message on Attach Offer Letter page
	 * 
	 * @param errorMessage
	 * @return
	 */
	public boolean verifyErrorMessageOnAttachOfferLetterPage(String errorMessage) {
		return getText(attachOfferLetterErrorMsg)
				.equalsIgnoreCase("Attachment size limit exceeded. Please attach file of less than 5 MB");
	}

	/**
	 * Fill Offer Mail subject field
	 */
	public void fillOfferMailSubject(String subjectText) {
		offerMailSubjectText = subjectText;
		sendKeys(offerMailSubject, offerMailSubjectText);
	}

	/**
	 * Fill Offer Mail body field
	 */
	public void fillOfferMailBody(String bodyText) {
		offerMailBodyText = bodyText;
		sendKeys(offerMailBody, offerMailBodyText);
	}

	/**
	 * Enters offer letter template name
	 * 
	 * @param offerTemplate
	 */
	public void enterOfferMailTemplateName(String offerTemplate) {
		offerLetterTemplate = offerTemplate;
		sendKeys(txtSaveOfferTemplate, offerTemplate);
	}

	/**
	 * Click Send Mail button on Attach Offer Letter
	 */
	public void clickSendMailOnAttachOfferLetter() {
		click(btnSendOfferMail);
	}

	/**
	 * Search Offer Letter Template generated while sending Offer
	 * 
	 * @author udit.khanna
	 */
	public void searchOfferLetterTemplate() {
		sendKeys(txtQuickSearchTemplate, offerLetterTemplate);
		click(btnQuickSearchTemplate);
	}

	/**
	 * Verify Offer Letter Template created on search
	 * 
	 * @return
	 * @author udit.khanna
	 */
	public boolean verifyOfferLetterTemplateOnSearchResult() {
		return getText(searchTemplateResultFirstElement).equalsIgnoreCase(offerLetterTemplate);
	}

	/**
	 * Verify if Attach Offer Letter section is disabled
	 */
	public boolean verifyDisabledAttachOfferLetterSection() {
		return getText(inactiveStepper).contains("Attach Offer Letter");
	}

	/**
	 * Verify if offer is sent to the candidate
	 * 
	 * @param msg
	 *            to be verified
	 * @return
	 * @author udit.khanna
	 */
	public boolean verifyOfferMailSentToCandidate(String msg) {
		wait.waitForVisibilityOfElement(eleOfferDetailsSection);
		return getText(candidateStatusMsg).trim().equalsIgnoreCase(msg);
	}

	/**
	 * Click Send Reminder button
	 * 
	 */
	public void clickSendReminderButton() {
		click(btnSendReminder);
	}

	/**
	 * Verify Reminder message sent success message is received
	 * 
	 * @param msg
	 * @return
	 * @author udit.khanna
	 */
	public boolean verifyReminderMessageSent(String msg) {
		return getText(msgSuccessReminderSent).contains(msg);
	}

	/**
	 * Verify Send Mail Button is Enabled
	 * 
	 * @return
	 * @author udit.khanna
	 */
	public boolean verifySendMailButtonIsEnabled() {
		wait.waitForElementToBeClickable(btnSendMail);
		return !(getAttribute(btnSendMail, "class").contains("disable"));
	}

	/**
	 * click Edit Offer button
	 */
	public void clickEditOfferButton() {
		jsUtil.scrollUp();
		click(btnEditOffer);
	}

	/**
	 * Verify edit Offer message on Offer Details page
	 * 
	 * @param editOfferMsg
	 * @return
	 * @author udit.khanna
	 */
	public boolean verifyEditOfferPage(String editOfferMsg) {
		return getText(msgEditOffer).equalsIgnoreCase(editOfferMsg);
	}

	/**
	 * Verify Offered Designation is updated on CV Details page
	 * 
	 * @return
	 * @author udit.khanna
	 */
	public boolean verifyOfferedDesignationOnCVDetails() {
		wait.hardWait(2);
		return getText(offeredDesignationOnCVDetails).trim().equals(OfferValidationPagePO.offeredDesignation);
	}

	/**
	 * Verify Salary is updated on CV Details page
	 * 
	 * @return
	 * @author udit.khanna
	 */
	public boolean verifySalaryOnCVDetails() {
		wait.waitForVisibilityOfElement(salaryOnCVDetails);
		return Integer.parseInt(getText(salaryOnCVDetails).replace("₹", "").replace(",", "")) == (Integer
				.parseInt(OfferValidationPagePO.candidatesJoiningSalary));
	}

	/**
	 * Verify offer mail subject entered is displayed on Preview Mail
	 * 
	 * @return
	 * @author udit.khanna
	 */
	public boolean verifySubjectInPreviewMail() {
		return getText(previewMailSubject).contains(offerMailSubjectText);
	}

	/**
	 * Verify offer mail body entered is displayed on Preview Mail
	 * 
	 * @return
	 * @author udit.khanna
	 */
	public boolean verifyOfferBodyInPreviewMail() {
		return getText(previewMailBody).contains(offerMailBodyText);
	}

	/**
	 * click on second stage of offer from cv details page
	 */
	public void clickSecondStageOfOffer() {
		click(parameterizedLocator(selectOfferStageFromDD, Integer.toString(2)));
	}

	/**
	 * verify attach offer letter section is displayed
	 * 
	 * @return true if attach offer letter section is displayed
	 */
	public boolean verifyattachOfferLetterSectionDisplayed() {
		return elementVisibility(attachOfferLetterSection);
	}

	/**
	 * click first stage of offer
	 * 
	 */
	public void clickFirstStageOfOffer() {
		click(parameterizedLocator(selectOfferStageFromDD, Integer.toString(1)));
	}

	public void clickIncludeSignature(String includeSignature) {
		getElement(parameterizedLocator(IncludeSignature, includeSignature)).click();
	}

	public boolean signatureInOfferPreview() {
		String getSignaturePreview = ReadWritePropertyFile.getProperty("textUnderSignatureBody",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		return getText(previewMailBody).contains(getSignaturePreview);
	}

	/**
	 * verify Offer Status In Offer Timeline
	 * 
	 * @param statusMsg
	 * @return true if Offer Status present In Offer Timeline
	 */
	public boolean verifyOfferStatusInOfferTimeline(String statusMsg) {
		jsUtil.scrollDown(eleOfferDetailsSection);
		return getText(eleOfferStatusInOfferTimeline).contains(statusMsg);
	}

	/**
	 * click prefill from offer on attach offer page
	 * 
	 * @param prefillFromOffer
	 */
	public void clickPrefillFromOfferDD(String prefillFromOffer) {
		click(parameterizedLocator(PrefillOfferletterDD, prefillFromOffer));
	}

	/**
	 * select email template on settings page
	 * 
	 */
	public void selectEmailTemplate() {
		String emailtemplate = ReadWritePropertyFile.getProperty("EmailTemplateName",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		click(parameterizedLocator(PrefillOfferletterDD, emailtemplate));
	}

	/**
	 * verify mailbody and mail subject from prefill template
	 * 
	 * @return true if mail body and mail subject matches the template subject and
	 *         body
	 */
	public boolean verifyMailBodyAndSubjectFromPrefilltemplate() {
		String mailSubjectTxt = ReadWritePropertyFile.getProperty("EmailSubject",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		String mailBodyTxt = ReadWritePropertyFile.getProperty("EmailBody",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		return getAttribute(mailSubject, "value").contains(mailSubjectTxt) && getText(mailBody).contains(mailBodyTxt);
	}

	/**
	 * change Currency Dropdown Value
	 * 
	 * @param currency
	 *            DD Value
	 */
	public void changeCurrencyDropdownValue(String currencyDDValue) {
		click(eleCurrencyDDArrow);
		click(parameterizedLocator(eleCurrencyDDValue, currencyDDValue));
	}

	/**
	 * verify Symbol In Offer Details Section present
	 * 
	 * @param currencySymbol
	 * @param offerFieldLabel
	 * @return true if symbol present in Offer Details Section
	 */
	public boolean verifySymbolInOfferDetailsSection(String currencySymbol, String offerFieldLabel) {
		return getElement(eleSalaryOfferInOfferDetailsSection, offerFieldLabel).getText().contains(currencySymbol);
	}

	/**
	 * verify Symbol In Offer Status Section present
	 * 
	 * @param currencySymbol
	 * @param offerFieldLabel
	 * @return true if symbol present in Offer Status Section
	 */
	public boolean verifySymbolInOfferStatusSection(String currencySymbol, String offerFieldLabel) {
		return getElement(eleSalaryOfferInOfferStatusSection, offerFieldLabel).getText().contains(currencySymbol);
	}
	
	/**
	 * save Previous Offer Details In Property File
	 */
	public void savePreviousOfferDetailsInPropertyFile() {
		String previousCandidatesJoiningSalary = ReadWritePropertyFile.getProperty("candidatesJoiningSalary",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		String previousOfferedDesignation = ReadWritePropertyFile.getProperty("OfferedDesignation",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		ReadWritePropertyFile.setProperty("previousCandidatesJoiningSalary", previousCandidatesJoiningSalary,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		ReadWritePropertyFile.setProperty("previousOfferedDesignation", previousOfferedDesignation,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
	}

	/**
	 * click Down Arrow In Offer Section On CV Details
	 * 
	 * @param strText
	 */
	public void clickDownArrowInOfferSectionOnCVDetails(String strText) {
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollDown(eleOfferDetailsSection);
		click(parameterizedLocator(elePreviousOfferDownArrow, strText));
	}

	/**
	 * verify Previous Offer Details In Offer Details
	 * 
	 * @return true if Previous Offer Details In Offer Details matches previous
	 *         values
	 */
	public boolean verifyPreviousOfferDetailsInOfferDetails() {
		if (getText(elePreviousOfferedDesignation).contains(ReadWritePropertyFile.getProperty("previousOfferedDesignation",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties")) && 
				getText(elePreviousCandidatesJoiningSalary).replaceAll("[^0-9]+", "").contains(ReadWritePropertyFile.getProperty("previousCandidatesJoiningSalary",
						OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties")))
			return true;
		else
			return false;
	}

	/**click skip attach offer letter 
	 * 
	 */
	public void clickSkipAttachOfferLetter() {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(cancelAttachOfferLetter);
		click(cancelAttachOfferLetter);
	}

	/**verify designation offer strip on cv details 
	 * @return true if designation on cv details matches with entered offered details
	 */
	public boolean verifyDesignationCVDetailsOnOfferStrip() {
		wait.waitForVisibilityOfElement(designationOnOfferstripCVDetails);
		return getText(designationOnOfferstripCVDetails).trim().equals(OfferValidationPagePO.offeredDesignation);
	}

	/**verufy salary offer strip on cv details 
	 * @return true if salary on cv details matches with entered offered details 
	 */
	public boolean verifySalaryOnCVDetailsOfferStrip() {
		return getText(salaryOnOfferStripCVDetails).replaceAll(",", "")
				.contains(OfferValidationPagePO.candidatesJoiningSalary);
	}

	/**verufy attach offer letter not displayed 
	 * @return true of attach offer letter is  displayed 
	 */
	public boolean verifyAttachOfferLetterNotDisplayed() {
		return isDisplayed(attachOfferLetterSection);
	}

	/**verify offer status of candidate 
	 * @param offerStatus
	 * @return true if offered status of candidate is displayed correct on offer logs 
	 */
	public boolean verifyOfferStatusofCandidate(String offerStatus) {
		String getDesignationOfCandidate = ReadWritePropertyFile.getProperty("OfferedDesignation",OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		return getText(parameterizedLocator(offerLogsStatusCandidate,getDesignationOfCandidate)).contains(offerStatus);
	}
        
        public void clickOnOfferEllipsis(){
            getElement(offerEllipsis).click();
            TestNGLogUtility.info("User clicked on offer ellipsis");
        }
}
