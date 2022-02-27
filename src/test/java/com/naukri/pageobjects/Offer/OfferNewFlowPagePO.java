package com.naukri.pageobjects.Offer;

import java.util.List;

import org.openqa.selenium.By;

import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

/**
 * @author udit.khanna
 *
 */
public class OfferNewFlowPagePO extends BaseAutomation {

	private By eleBreakupTableDD = By.id("breakupTableDD");
	private By eleSetButtonOnPermissionsLayout = By
			.xpath("//div[@id = \"offerGenerationModuleContent\"]//input[@value=\"Set\"]");
	private By eleOfferGenerationPermission = By.xpath("//*[@id=\"${string}\"]");
	private By eleFirstStepperTxt = By.xpath("//span[contains(text(), 'Input Offer Details')]");
	private By lnkCommonForLink = By.xpath("(//a[text()='${link}'])[1]");
	private By txtThirdStepper = By.xpath("//span[text()=\"3. Email Offer Letter to candidate\"]");
	private By eleStatusRibbonMessage = By.xpath("//div[@id='statusRibbon']//*[contains(text(),'${string}')]");
	private By eleLinkInMessage = By.xpath("//a[text()=\"${string}\"]");
	private By eleSalaryBreakupListHeader = By
			.xpath("//div[@class='sb-header-title' and text()='Offer Generation Rules & Salary Breakup']");
	private By eleSalaryBreakupInDD = By.xpath("//span[text()='${string}']");
	private By eleRadioBtnOnSecondStepper = By.xpath("//label[text()='${string}']");
	private By eleZohoEditorInIframe = By.xpath("//iframe[@id=\"writer-iframe\"]");
	private By eleErrorMsgOnSecondStepper = By.xpath("//span[contains(text(),\"${string}\")]");
	private By eleSelectOfferLetterTemplateDD = By.id("offerTemplateDD");
	private By eleOfferDocumentInDD = By.xpath("//li[text()='${string}']");
	private By eleAttachedOfferLetter = By.xpath("//span[@class='offerLetterName' and contains(text(),'Offer-')]");
	private By eleDownloadbtnOnThirdStepper = By.xpath("//button[@class=\"download-offer-letter\"]");
	private By btnGenerateAndAttachOfferLetter = By.id("sendOfferMail");
	private By eleStepperInNewOfferLayer = By.xpath("//span[text()='${string}']");
	private By eleSecondStepperVerificationText = By
			.xpath("//div[text()='Select the type of Offer Letter that will be sent.']");
	private By eleDialogBox = By.xpath("//span[text()='${string}']");
	private By elePreviousOfferInfo = By
			.xpath("//div[@class=\"prevOffersInformation\"]/span[contains(text(),'${string}')]");
	private By eleOfferDetailsSection = By
			.xpath("//div[@class='candFieldHead']/span[contains(text(),'Offer Details')]");
	private By eleComposeMailLink = By.xpath("//a[@data-actiontype='composeMail']");
	private By eleFillOfferDetailsOnCVDetails = By
			.xpath("//div[@id='timeLineAction']//*[contains(text(),'FILL OFFER DETAILS')]");
	private By eleSendToCandidateOnCVDetails = By
			.xpath("//div[@id='timeLineAction']//*[contains(text(),'SEND TO CANDIDATE')]");
	private By lblOfferGenPage = By.xpath("//span[@class='stepper current disable']/span");
	private By eleCandidateOnProfileProjectInbox = By.xpath("//a[contains(text(),'${string}')]");
	private By eleTabInOfferNewFlow = By.xpath("//span[@class='stepper current ' and contains(text(),'${string}')]");

	// Objects
	offerDocTemplatePO offerDocTemplate = (offerDocTemplatePO) PageObjectWrapper.getObject(offerDocTemplatePO.class);

	/**
	 * verify New Offer Layer
	 * 
	 * @return
	 */
	public boolean verifyNewOfferLayer() {
		wait.waitForVisibilityOfElement(eleFirstStepperTxt);
		return isDisplayed(txtThirdStepper);
	}

	/**
	 * change Status Of Offer Generation Permission
	 * 
	 * @param permissionName
	 * @param statusOfPermission
	 */
	public void changeStatusOfOfferGenerationPermission(String permissionName, String statusOfPermission) {
		String presentStatusOfPermission = getAttribute(
				parameterizedLocator(eleOfferGenerationPermission, permissionName), "value");
		if (!presentStatusOfPermission.equalsIgnoreCase(statusOfPermission)) {
			jsUtil.clickByJS(parameterizedLocator(eleOfferGenerationPermission, permissionName));
		}
		if (getAttribute(parameterizedLocator(eleOfferGenerationPermission, permissionName), "value")
				.equalsIgnoreCase(statusOfPermission))
			click(eleSetButtonOnPermissionsLayout);

		wait.waitForPageToLoadCompletely();
	}

	/**
	 * click link on page
	 * 
	 * @param linkText
	 */
	public void links(String link) {
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollDown(parameterizedLocator(lnkCommonForLink, link));
		getElement(lnkCommonForLink, link).click();
	}

	/**
	 * verify Message On New Offer Layer
	 * 
	 * @return true if message present on new offer layer
	 */
	public boolean verifyMessageOnNewOfferLayer(String message) {
		return isDisplayed(eleStatusRibbonMessage, message);
	}

	/**
	 * click Link In Message In New Offer Layer
	 * 
	 * @param linkTxt
	 */
	public void clickLinkInMessageInNewOfferLayer(String linkTxt) {
		click(parameterizedLocator(eleLinkInMessage, linkTxt));
	}

	/**
	 * verify Navigated To Salary Rule Listing
	 * 
	 * @return true if Navigated To Salary Rule Listing
	 */
	public boolean verifyNavigatedToSalaryRuleListing() {
		switchToChildWindow();
		return isDisplayed(eleSalaryBreakupListHeader);
	}

	/**
	 * create New Salary Template In State
	 * 
	 * @param state
	 *            can be "draft" or "confirm"
	 */
	public void createNewSalaryTemplateInState(String state) {
		if (state.equalsIgnoreCase("draft")) {
			offerDocTemplate.createDraftSalaryTemplate();
			// save created draft salary breakup name to
			// "DraftSalaryBreakupName"
			ReadWritePropertyFile.setProperty("DraftSalaryBreakupName",
					ReadWritePropertyFile.getProperty("SalaryBreakupName",
							OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
									+ "offerManagementSalaryBreakup.properties"),
					OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		} else if (state.equalsIgnoreCase("confirm")) {
			offerDocTemplate.createSalaryBreakupTemplate();
			ReadWritePropertyFile.setProperty("offerSalaryBreakupAgainstDoc",
					ReadWritePropertyFile.getProperty("SalaryBreakupName",
							OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
									+ "offerManagementSalaryBreakup.properties"),
					OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		}
	}

	/**
	 * click Select Salary Breakup Template Dropdown On New Offer Layer
	 */
	public void clickSelectSalaryBreakupTemplateDropdownOnNewOfferLayer() {
		click(eleBreakupTableDD);
	}

	/**
	 * verify Confirm Salary Template In Dropdown
	 * 
	 * @return true if Confirm Salary Template present In Dropdown
	 */
	public boolean verifyConfirmSalaryTemplateInDropdown() {
		return isDisplayed(eleSalaryBreakupInDD, ReadWritePropertyFile.getProperty("SalaryBreakupName",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties"));
	}

	/**
	 * verify draft Salary Template In Dropdown not present
	 * 
	 * @return true draft Salary Template In Dropdown not present
	 */
	public boolean verifyDraftSalaryTemplateInDropdownIsNotDisplayed() {
		return !isDisplayed(eleSalaryBreakupInDD, ReadWritePropertyFile.getProperty("DraftSalaryBreakupName",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties"));
	}

	/**
	 * click Confirmed Salary Breakup Template Dropdown On New Offer Layer
	 */
	public void clickConfirmedSalaryBreakupTemplateDropdownOnNewOfferLayer() {
		click(parameterizedLocator(eleSalaryBreakupInDD, ReadWritePropertyFile.getProperty(
				"offerSalaryBreakupAgainstDoc",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties")));
	}

	/**
	 * verify radio buttons are visible On Second Stepper
	 * 
	 * @param list
	 * @return true if radio buttons are visible on second stepper
	 */
	public boolean verifyradioButtonsOnSecondStepper(List<String> list) {
		return isDisplayed(eleRadioBtnOnSecondStepper, list.get(0))
				& isDisplayed(eleRadioBtnOnSecondStepper, list.get(1));
	}

	/**
	 * click Radio Btn On New Offer Layer
	 * 
	 * @param radioBtnTxt
	 */
	public void clickRadioBtnOnNewOfferLayer(String radioBtnTxt) {
		click(parameterizedLocator(eleRadioBtnOnSecondStepper, radioBtnTxt));
	}

	/**
	 * verify Zoho Editor Is Displayed
	 * 
	 * @return true if zoho editor is visible
	 */
	public boolean verifyZohoEditorIsDisplayed() {
		wait.waitForValignWrapperToDisappear(1019, 577);
		wait.waitForPageToLoadCompletely();
		return isDisplayed(eleZohoEditorInIframe);
	}

	/**
	 * verify Error Msg On Second Stepper Of New Offer Layer
	 * 
	 * @param errorMsgTxt
	 * @return true if Error Msg is displayed
	 */
	public boolean verifyErrorMsgOnSecondStepperOfNewOfferLayer(String errorMsgTxt) {
		return isDisplayed(eleErrorMsgOnSecondStepper, errorMsgTxt);
	}

	/**
	 * verify Navigated To Offer Document Listing
	 * 
	 * @return true if navigated to Offer document listing
	 */
	public boolean verifyNavigatedToOfferDocumentListing() {
		switchToChildWindow();
		return getCurrentURL().equalsIgnoreCase(YamlReader.getAppConfigValue("URLs.offerDoclisting"));
	}

	/**
	 * create New Offer Document using Salary template in
	 * offerManagementSalaryBreakup.properties
	 * 
	 * @throws Exception
	 *             If offer document not created
	 */
	public void createNewOfferDocument() throws Exception {
		offerDocTemplate.clickAddNewOfferDoc();
		offerDocTemplate.enterOfferDocTemplateName();
		offerDocTemplate.SelectSalaryBreakupDD();
		offerDocTemplate.clickOnSaveOfferDocTemplate();
		wait.waitForPageToLoadCompletely();
		if (offerDocTemplate.verifyOfferDocRowOnListingPage() == false)
			throw new Exception("Offer Document not created");
	}

	/**
	 * click Select Offer Letter Template DD
	 */
	public void clickSelectOfferLetterTemplateDD() {
		click(eleSelectOfferLetterTemplateDD);
		wait.waitForValignWrapperToDisappear(10, 10);
	}

	/**
	 * verify New Offer Document Created In Dropdown Options
	 * 
	 * @return true if new offer document is present in DD
	 */
	public boolean verifyNewOfferDocumentCreatedInDropdownOptions() {
		return isDisplayed(eleOfferDocumentInDD, ReadWritePropertyFile.getProperty("offerDocName",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties"));
	}

	/**
	 * click New Offer Document Created DD
	 */
	public void clickNewOfferDocumentCreatedDD() {
		click(parameterizedLocator(eleOfferDocumentInDD, ReadWritePropertyFile.getProperty("offerDocName",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties")));
	}

	/**
	 * verify Attached Offer Letter And Download Btn
	 * 
	 * @return true Offer Letter And Download Btn are attached
	 */
	public boolean verifyAttachedOfferLetterAndDownloadBtn() {
		wait.waitForValignWrapperToDisappear(1019, 577);
		return isDisplayed(eleAttachedOfferLetter) & isDisplayed(eleDownloadbtnOnThirdStepper);
	}

	/**
	 * click Generate and Attach Offer Letter Button
	 */
	public void clickGenerateAndAttachOfferLetterBtn() {
		wait.waitForValignWrapperToDisappear(1019, 577);
		wait.waitForPageToLoadCompletely();
		jsUtil.clickByJS(btnGenerateAndAttachOfferLetter);
		wait.hardWait(10);
	}

	/**
	 * click Stepper
	 * 
	 * @param stepperTxt
	 */
	public void clickStepper(String stepperTxt) {
		click(parameterizedLocator(eleStepperInNewOfferLayer, stepperTxt));
	}

	/**
	 * verify Directed Back To Second Stepper
	 * 
	 * @return true if directed to second stepper
	 */
	public boolean verifyDirectedBackToSecondStepper() {
		wait.waitForValignWrapperToDisappear(1019, 577);
		wait.waitForPageToLoadCompletely();
		return isDisplayed(eleSecondStepperVerificationText);
	}

	/**
	 * verify Dialog Box Visibility
	 * 
	 * @param dialogBoxTxt
	 * @return true if Dialog Box is Visible
	 */
	public boolean verifyDialogBoxVisibility(String dialogBoxTxt) {
		return isDisplayed(eleDialogBox, dialogBoxTxt);
	}

	/**
	 * verify Previous Offer Info
	 * 
	 * @param previousOfferInfoTxt
	 * @return true if Previous Offer Information is visible
	 */
	public boolean verifyPreviousOfferInfo(String previousOfferInfoTxt) {
		return isDisplayed(elePreviousOfferInfo, previousOfferInfoTxt);
	}

	/**
	 * click Compose Mail Link
	 */
	public void clickComposeMailLink() {
		jsUtil.scrollDown(eleOfferDetailsSection);
		click(eleComposeMailLink);
	}

	/**
	 * click Fill Offer Details Link On CV Details
	 */
	public void clickFillOfferDetailsLinkOnCVDetails() {
		click(eleFillOfferDetailsOnCVDetails);
	}

	/**
	 * click Send To Candidate Link On CV Details
	 */
	public void clickSendToCandidateLinkOnCVDetails() {
		jsUtil.scrollDown(eleOfferDetailsSection);
		click(eleSendToCandidateOnCVDetails);
	}

	/**
	 * verify Redirected On Offer Generation Page
	 * 
	 * @return true
	 */
	public boolean verifyRedirectedOnOfferOldFlow(String verifyTabTxt) {
		wait.waitForPageToLoadCompletely();
		return getText(lblOfferGenPage).contains(verifyTabTxt);
	}

	/**
	 * verify Candidate Visible On Profile Project Inbox
	 * 
	 * @return true if candidate is visible
	 */
	public boolean verifyCandidateVisibleOnProfileProjectInbox() {
		for (int counter = 0; !isDisplayed(
				parameterizedLocator(eleCandidateOnProfileProjectInbox,
						ReadWritePropertyFile
								.getProperty("CandidateNameForApproval",
										OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
												+ "offerManagementSalaryBreakup.properties")))
				& counter < 5; counter++) {
			wait.waitForPageToLoadCompletely();
			pageRefresh();
		}
		return isDisplayed(parameterizedLocator(eleCandidateOnProfileProjectInbox, ReadWritePropertyFile.getProperty(
				"CandidateNameForApproval",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties")));
	}

	/**
	 * verify Redirected On Offer New Flow
	 * 
	 * @param tabText
	 * @return true if directed to new offer tab
	 */
	public boolean verifyRedirectedOnOfferNewFlow(String tabText) {
		return isDisplayed(eleTabInOfferNewFlow, tabText);
	}

}
