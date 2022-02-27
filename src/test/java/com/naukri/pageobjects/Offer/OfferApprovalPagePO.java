package com.naukri.pageobjects.Offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;

/**
 * @author udit.khanna
 *
 */
public class OfferApprovalPagePO extends BaseAutomation {

	// variables
	static String selectionStage = "Prospect";
	public static String candidateName = "", contactNumber = "", emailId = "";
	private static final String TXT_HINT_TEXT_MAIL_TO_CANDIDATE_UNCHECKED = "You will have to mail the offer letter to candidate, post approval from";

	// locators
	public By eleAddToRequirementInputField = By.id("inp_projectList");
	public By txtRequirementTitle = By.id("projectName");
	public By eleStatusSelectDD = By.id("subStatusId");
	public By eleStarRating = By.id("starRating1");
	public By eleSelectionStageOption = By
			.xpath("(//select[@id=\"subStatusId\"]/option[contains(text(),\"${string}\")])[1]");
	public By eleFirstValueInRequirementDD = By.xpath("//ul[@id=\"ul_projectList\"]/li[1]");
	public By eleSelectApprovalProcessDD = By
			.xpath("//div[@class='select-controller singleSelectBar']//span[text()='DownArrow']");
	public By eleSelectApprovalProcessDDlist = By.xpath("//div[@class='select-list']//li");
	public By candidateName_text = By.xpath("//label[@for= \"name\"]/following-sibling::input");
	public By email_text = By.id("emilBlock_0");
	public By contact_text = By.id("numBlock_0");
	public By eleRequirementNameInDD = By.xpath("//a[starts-with(@id,'projectList')]/b[contains(text(),'${string}')]");
	public By btnOfferApproveOrReject = By.xpath("//button[@class='btn-${string}']");
	public By eleOfferDetailsSection = By.xpath("//div[@class='candFieldHead']/span[contains(text(),'Offer Details')]");
	public By msgOfferApprovalOrRejectionStatus = By
			.xpath("//div[@class='offerSuccessMessage']//span[contains(text(),'${string}')]");
	public By eleCandidateOfferStatusInOfferSection = By.xpath("//div[@class='candOffrStatus']");
	public By txtSearchCandidate = By.id("keywordSearch");
	public By eleSearchIcon = By.id("searchKeyword");
	public By eleOfferedDesignation = By.xpath("//span[@class='offrDesignation']");
	public By eleOfferDetailsFields = By.xpath("//div[@class='mt5']//span");
	public By eleRequirementLinkOnProjectList = By.xpath("//a[text()='${string}']");
	public By eleApplicationsForRequirment = By.xpath("//div[starts-with(@class,'pageHead')]//a[text()='1']");
	public By btnApproveOrRejectOnRequirementOverview = By.xpath("//button[@class='btn-${string}']");
	public By btnApproveOnRequirementOverview = By.xpath("//button[@class='btn-approve']");
	public By eleCheckBoxOnAttachOfferLetter = By.xpath("//label[text()='${string}']");
	public By lblDialogBox = By.xpath("//span[text()='${string}']");
	public By btnDialogBoxButton = By.xpath("//button[@class='confBtn ${string}']");
	public By lblOfferStatusInOfferDetails = By.xpath("//div[@class='offerMsgContainer']//span[text()='${string}']");
	public By eleCandidateDetailsOnSRP = By.xpath("//span[text()='${string}']");
	public By txtHintTextOnAttachOfferLetter = By.xpath("//span[@class='hintTxt']");
	private By linkInOfferSectionOnCVDetails = By.xpath("//*[text()='${string}']");
	public By eleEnquireAboutOfferLayer = By
			.xpath("//div[@class='panel-title' and text()='Mail to be sent to candidate']");
	public By txtCommentsInEnquireAboutOffer = By.xpath("//textarea[@class='comment-box']");
	public By btnInEnquireAboutOffer = By.xpath("//div[@id='ofa-layer-body']//button[text()='${string}']");
	public By eleOfferStatusMessage = By.xpath("//div[@class='offerSuccessMessage']//span[@class='etxt']/span");
	public By eleCandidateMessageOnCVDetails = By.xpath("//div[@id='currOffrMsgList']/p[@class='candMsg']");
	public By eleSendMessageLinkInOfferDetails = By.xpath("//a[@id='openMsgBox']/strong[text()='SEND MESSAGE']");
	public By txtSendMessageToApprover = By.id("msgBox");
	public By eleSendMessageBelowTextboxInOfferDetails = By.id("sendMsg");
	public By eleApproversInShowFullApproval = By.xpath("//span[@class='oa-popup-approver-email']");
	public By btnRejectOnCVDetails = By.xpath("//a[@class=' rjbtn']");
	public By eleNotificationFirstRow = By.xpath("//div[@class='notifTuple border-bottom']");
	public By sendToCandidateAfterApproved = By.xpath("(//div[@id='timeLineAction']//strong)[1]");
	public By mailBodyOnOfferLightbox = By.xpath("//div[@class='mailBody']");
	public By offerApprovalMandatoryChkBx = By.xpath("//a[@id='offerApprovalMandSwitch']");
	public By setApprovalSettings = By.xpath("(//input[@value='Set'])[1]");
	public By offerApprovalMandatoryValueOff = By.xpath("//a[@id='offerApprovalMandSwitch']//input[@value='off']");
	public By offerApprovalMandatoryValueOn = By.xpath("//a[@id='offerApprovalMandSwitch']//input[@value='on']");
	public By btnOfferApproveOnCVDetails = By.xpath("//button[@class='btn-approve']");
	public By btnOfferRejectOnCVDetails = By.xpath("//button[@class='btn-reject']");
	public By eleNotifyAboutOffer = By.xpath("//a[text()='Notify about offer']");
	private By eleStatusTextInUpdateStatus = By.xpath(
			"//div[@class = \"bulkStatusContainer\"]//*[@id = \"statusListDD\"]//*[contains(text(),\"${string}\")]");
	private By ActionsOnReqList = By.xpath("(//a[text()='${string}'])[1]");
	private By emailCandidateText = By.id("emilBlock_0");
	private By saveCandidatebtn = By.id("editCandBasicButton");
	private By projectInboxCount = By.id("totalApplicantCount");
	private By UpdateStatusDD = By.xpath("(//li[@class='frst'])[1]");
	private By eleSelectApprovalProcessLbl = By
			.xpath("//div[@id=\"approvalMapping\"]//label[contains(text(),'Select Approval Process:')]");
	private By eleRequirementNameOnCVDetails = By.xpath("//a[@title='${string}']");
	private By eleApplicationCountOnRequirementOverview = By
			.xpath("(//div[@title='${string}']/following-sibling::div//a)[1]");
	private By eleProjectIdOnRequirementOverview = By.id("projectId");
	private By eleSearchBarOnReqListing = By.id("keywords");
	private By eleSearchIconOnReqListing = By
			.xpath("//div[@id=\"searchBox\"]//input[@type=\"submit\"]");

	/**
	 * add Requirement To Single Profile
	 * 
	 * @param reqName
	 */
	public void addRequirementToSingleProfile(String reqName) {
		// click(eleAddNewRequirementLink);
		jsUtil.scrollDown(eleAddToRequirementInputField);
		click(eleAddToRequirementInputField);
		sendKeys(eleAddToRequirementInputField, reqName);
		wait.hardWait(1);
		// wait.waitForVisibilityOfElement(eleFirstValueInRequirementDD);
		getElement(eleRequirementNameInDD, reqName).click();
		// click(eleFirstValueInRequirementDD);
		// jsUtil.scrollDown(eleStatusSelectDD);
		wait.waitForVisibilityOfElement(eleStarRating);
		wait.hardWait(1);
		// click(eleStatusSelectDD);
		// getElement(eleSelectionStageOption, selectionStage).click();
		// click(By.xpath("(//select[@id=\"subStatusId\"]/option[contains(text(),\""+selectionStage+"\")])[1]"));
	}

	/**
	 * click Select Approval Process Drop down
	 */
	public void clickSelectApprovalProcessDropdown() {
		jsUtil.scrollDown(eleNotifyAboutOffer);
		jsUtil.clickByJS(eleSelectApprovalProcessDD);
	}

	// /**
	// * check All Offer Approval Templates Displayed
	// *
	// * @param list
	// * @return
	// */
	// public boolean checkAllOfferApprovalTemplatesDisplayed(List<String> list)
	// {
	// List<WebElement> approvalListElements =
	// getElements(eleSelectApprovalProcessDDlist);
	// jsUtil.scrollDown(eleSelectApprovalProcessDDlist);
	// List<String> approvalListValues = new ArrayList<>();
	// for (WebElement element : approvalListElements) {
	// approvalListValues.add(element.getText());
	// }
	// return approvalListValues.equals(list);
	// }
	/**
	 * check All Offer Approval Templates Displayed
	 * 
	 * @return true if All Offer Approval Templates are displayed
	 */
	public boolean checkAllOfferApprovalTemplatesDisplayed() {
		List<WebElement> approvalListElements = getElements(eleSelectApprovalProcessDDlist);
		jsUtil.scrollDown(eleSelectApprovalProcessDDlist);
		List<String> approvalListValues = new ArrayList<>();
		for (WebElement element : approvalListElements) {
			approvalListValues.add(element.getText());
		}
		return (approvalListValues
				.contains(ReadWritePropertyFile.getProperty("firstApprovalTemplateName",
						OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
								+ "offerManagementSalaryBreakup.properties"))
				& approvalListValues.contains(ReadWritePropertyFile.getProperty("secondApprovalTemplateName",
						OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
								+ "offerManagementSalaryBreakup.properties")));
	}

	/**
	 * To add basic information like name,contact and email of candidate
	 */
	public void addCandidateDetails() {
		candidateName = GenericFunctions.generateRandomStrings(10, "String");
		contactNumber = Long.toString(System.currentTimeMillis()).substring(0, 10);
		emailId = "email" + System.currentTimeMillis() + "@yopmail.com";
		ReadWritePropertyFile.setProperty("CandidateNameForApproval", candidateName,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		ReadWritePropertyFile.setProperty("CandidateEmailForApproval", emailId,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		sendKeys(candidateName_text, candidateName);
		sendKeys(email_text, emailId);
		sendKeys(contact_text, contactNumber);
	}

	/**
	 * navigate To CV Details For The Candidate
	 */
	public void navigateToCVDetailsForTheCandidate() {
		driver.get(YamlReader.getAppConfigValue("URLs.cvDetailsPage") + "/" + ReadWritePropertyFile.getProperty(
				"CandidateIdForApproval",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties"));
	}

	/**
	 * select Approval Process
	 * 
	 * @param approvalProcess
	 */
	public void selectApprovalProcess(String approvalProcess) {
		List<WebElement> approvalListElements = getElements(eleSelectApprovalProcessDDlist);
		// jsUtil.scrollDown(eleSelectApprovalProcessDDlist);
		jsUtil.scrollDown(eleSelectApprovalProcessLbl);
		for (WebElement element : approvalListElements) {
			if (element.getText().equalsIgnoreCase(approvalProcess)) {
				element.click();
				break;
			}
		}
	}

	/**
	 * click Button On CV Details Page
	 * 
	 * @param buttonText
	 */
	public void clickButtonOnCVDetailsPage(String buttonText) {
		jsUtil.scrollDown(eleOfferDetailsSection);
		getElement(btnOfferApproveOrReject, buttonText).click();
		if (buttonText.equalsIgnoreCase("approve"))
			getElement(msgOfferApprovalOrRejectionStatus, "approved").isDisplayed();
	}

	/**
	 * verify Approve And Reject Buttons Displayed
	 * 
	 * @return true if Approve And Reject Buttons Displayed
	 */
	public boolean verifyApproveAndRejectButtonsDisplayed() {
		if (getElement(btnOfferApproveOrReject, "approve").isDisplayed()
				& getElement(btnOfferApproveOrReject, "reject").isDisplayed())
			return true;
		else
			return false;
	}

	/**
	 * verify Approve And Reject Msg Displayed On CV Details
	 * 
	 * @param msg
	 * @return true if message is displayed on CV Details page
	 */
	public boolean verifyApproveAndRejectMsgDisplayedOnCVDetails(String msg) {
		return getElement(msgOfferApprovalOrRejectionStatus, msg).isDisplayed();
	}

	/**
	 * get Group ID For Add Candidate
	 * 
	 * @return group ID based on execution environment
	 */
	public String getGroupIdForAddCandidate() {
		return ReadWritePropertyFile.getProperty("groupIdForApproval",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");

		// if (testEnvironment.equalsIgnoreCase("test"))
		// return "";
		// else if (testEnvironment.equalsIgnoreCase("live") |
		// testEnvironment.equalsIgnoreCase("stage"))
		// return "8424";
		// else
		// return null;
	}

	/**
	 * get subStatus ID For Add Candidate
	 * 
	 * @return subStatus ID based on execution environment
	 */
	public String getSubStatusIdForAddCandidate() {
		String environment = System.getProperty("testEnvironment");
		if (environment == null || environment.isEmpty()) {
			environment = ReadWritePropertyFile.getProperty("testEnvironment", BaseAutomation.configFile);
		}
		if (environment.equalsIgnoreCase("test"))
			return "2791_4236";
		else if (environment.equalsIgnoreCase("live") | environment.equalsIgnoreCase("stage"))
			return "3070_5416";
		// return "1063";
		else
			return null;
	}

	/**
	 * verify Status On CV Details Page
	 * 
	 * @param statusMsg
	 * @return true if Status is visible On CV Details Page
	 */
	public boolean verifyOfferStatusOnCVDetailsPage(String statusMsg) {
		if (statusMsg.equalsIgnoreCase("Candidate's Reply Pending")) {
			for (int counter = 0; getText(eleCandidateOfferStatusInOfferSection).equalsIgnoreCase("Offer Approved by All") & counter < 5; counter++) {
				wait.waitForPageToLoadCompletely();
				pageRefresh();
			}
			
//			while (getText(eleCandidateOfferStatusInOfferSection).equalsIgnoreCase("Offer Approved by All")) {
//				wait.waitForPageToLoadCompletely();
//				pageRefresh();
//			}
		}
		return getText(eleCandidateOfferStatusInOfferSection).equalsIgnoreCase(statusMsg);
	}

	/**
	 * search Candidate On Application Inbox Page
	 */
	public void searchCandidateOnApplicationInboxPage() {
		sendKeys(txtSearchCandidate, ReadWritePropertyFile.getProperty("CandidateNameForApproval",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties"));
		int counter = 0;
		do {
			click(eleSearchIcon);
			counter++;
		} while (!(getElement(eleCandidateDetailsOnSRP, ReadWritePropertyFile.getProperty("CandidateNameForApproval",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties"))
						.isDisplayed())
				& (counter < 5));
	}

	/**
	 * verify All Offer Details On SRP Page For Candidate after offer sent
	 */
	public boolean verifyAllOfferDetailsOnSRPPageForCandidate() {
		List<WebElement> listOfElements = getElements(eleOfferDetailsFields);
		List<String> listOfActualValues = new ArrayList<>();
		listOfElements.add(getElement(eleOfferedDesignation));
		for (WebElement element : listOfElements) {
			listOfActualValues.add(getText(element).replaceAll("[^a-zA-Z0-9\\s]+", ""));
		}
		return checkIfAllValuesPresentInActualOfferDetailsOnSRP(listOfActualValues);
	}

	/**
	 * check All Values Present In Actual Offer Details On SRP
	 * 
	 * @param list
	 *            Of Actual Values
	 * @return true if All Values Present In Actual Offer Details On SRP
	 */
	private boolean checkIfAllValuesPresentInActualOfferDetailsOnSRP(List<String> listOfActualValues) {
		checkDayInDateHasTwoDigits("candidateTentativeJoiningDateValue");
		checkDayInDateHasTwoDigits("offeredOnDateValue");

		if (listOfActualValues
				.contains(ReadWritePropertyFile.getProperty("OfferedDesignation",
						OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
								+ "offerManagementSalaryBreakup.properties"))
				& listOfActualValues.contains(ReadWritePropertyFile.getProperty("candidateTentativeJoiningDateValue",
						OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
								+ "offerManagementSalaryBreakup.properties"))
				& listOfActualValues.contains(ReadWritePropertyFile.getProperty("offeredOnDateValue",
						OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
								+ "offerManagementSalaryBreakup.properties"))
				& listOfActualValues.contains(ReadWritePropertyFile.getProperty("candidatesJoiningSalary",
						OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
								+ "offerManagementSalaryBreakup.properties")))
			return true;
		else
			return false;
	}

	/**
	 * check Day In Date Has Two Digits
	 * 
	 * @param attribute
	 *            in offerManagementSalaryBreakup.properties
	 */
	private void checkDayInDateHasTwoDigits(String dateString) {
		String[] date = null;
		date = ReadWritePropertyFile.getProperty(dateString,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties")
				.split(" ");
		if (date[0].length() < 2) {
			date[0] = "0" + date[0];
		}
		ReadWritePropertyFile.setProperty(dateString, date[0] + " " + date[1] + " " + date[2],
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
	}

	// /**
	// * open Requirement Created Using API
	// */
	// public void openRequirementCreatedUsingAPI() {
	// pageRefresh();
	// getElement(eleRequirementLinkOnProjectList,
	// ReadWritePropertyFile.getProperty("RequirementNameForApproval",
	// OfferGenerationSalaryRuleSettingsPO.fileSystemPath() +
	// "offerManagementSalaryBreakup.properties"))
	// .click();
	// }

	// /**
	// * click Applications For Requirement
	// */
	// public void clickApplicationsForRequirement() {
	// pageRefresh();
	// getElement(eleApplicationsForRequirment).click();
	// }

	/**
	 * click Approve Or Reject Button On Requirement Overview Page refresh max 5
	 * times if button not displayed
	 * 
	 * @param button
	 *            To Be Clicked
	 * 
	 */
	public void clickApproveOrRejectButtonOnRequirementOverview(String btnToBeClicked) {
		for (int counter = 0; !isDisplayed(btnApproveOnRequirementOverview) & counter < 5; counter++) {
			wait.waitForPageToLoadCompletely();
			pageRefresh();
		}
		getElement(btnApproveOrRejectOnRequirementOverview, btnToBeClicked).click();
	}

	/**
	 * navigate To Profile Project Inbox
	 */
	public void navigateToProfileProjectInbox() {
		goToPageURL(YamlReader.getAppConfigValue("URLs.ProfileProjectInbox") + "/" + ReadWritePropertyFile.getProperty(
				"RequirementIdForApproval",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties"));
	}

	/**
	 * navigate To Requirement Inbox
	 */
	public void navigateToRequirementInbox() {
		goToPageURL(YamlReader.getAppConfigValue("URLs.requirementInbox"));
	}

	/**
	 * get Requirement Id From URL And Save To Property File
	 */
	public void getRequirementIdFromPageAndSaveToPropertyFile() {

		String requirementId = getAttribute(eleProjectIdOnRequirementOverview, "value");
		ReadWritePropertyFile.setProperty("RequirementIdForApproval", requirementId,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
	}

	/**
	 * check Check Box On Attach Offer Letter Page if hint text contains "You
	 * will have to mail the offer letter to candidate, post approval from"
	 * 
	 * @param checkbox
	 *            Text
	 */
	public void checkCheckBoxOnAttachOfferLetterPage(String checkboxTxt) {
		if (getText(txtHintTextOnAttachOfferLetter).contains(TXT_HINT_TEXT_MAIL_TO_CANDIDATE_UNCHECKED))
			getElement(eleCheckBoxOnAttachOfferLetter, checkboxTxt).click();
	}

	/**
	 * verify Dialog Box Opened
	 * 
	 * @param dialog
	 *            Box Text
	 * @return true if Dialog Box Opens
	 */
	public boolean verifyDialogBoxOpened(String dialogBoxTxt) {
		return getElement(lblDialogBox, dialogBoxTxt).isDisplayed();
	}

	/**
	 * click Button In Dialog Box
	 * 
	 * @param dialog
	 *            Box Button Text
	 */
	public void clickButtonInDialogBox(String dialogBoxBtnTxt) {
		getElement(btnDialogBoxButton, dialogBoxBtnTxt).click();
	}

	/**
	 * verify Offer Status Text In Offer Details
	 * 
	 * @param offer
	 *            Status Text
	 * @return true if Offer Status Text is displayed In Offer Details
	 */
	public boolean verifyOfferStatusTextInOfferDetails(String offerStatusTxt) {
		pageRefresh();
		return getElement(lblOfferStatusInOfferDetails, offerStatusTxt).isDisplayed();
	}

	/**
	 * un-check mail to candidate Check Box On Attach Offer Letter Page if hint
	 * text does not contain "You will have to mail the offer letter to
	 * candidate, post approval from"
	 * 
	 * @param checkboxTxt
	 */
	public void unCheckCheckBoxOnAttachOfferLetterPage(String checkboxTxt) {
		if (!getText(txtHintTextOnAttachOfferLetter).contains(TXT_HINT_TEXT_MAIL_TO_CANDIDATE_UNCHECKED))
			getElement(eleCheckBoxOnAttachOfferLetter, checkboxTxt).click();
	}

	/**
	 * click Link On CV Details Page In Offer Section
	 * 
	 * @param linkText
	 */
	public void clickLinkOnCVDetailsPageInOfferSection(String linkText) {
		jsUtil.scrollDown(eleOfferDetailsSection);
		getElement(linkInOfferSectionOnCVDetails, linkText).click();
	}

	/**
	 * verifyEnquireAboutOfferLayer
	 */
	public boolean verifyEnquireAboutOfferLayer() {
		return isDisplayed(eleEnquireAboutOfferLayer);
	}

	/**
	 * enter Text In Comments Field In Enquire About Offer Layer
	 */
	public void enterTextInCommentsFieldInEnquireAboutOfferLayer() {
		String commentStr = GenericFunctions.generateRandomStrings(10, "String");
		sendKeys(txtCommentsInEnquireAboutOffer, commentStr);
		ReadWritePropertyFile.setProperty("commentsInEnquireAboutOffer", commentStr,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
	}

	/**
	 * click Button In Enquire About Offer Layer
	 * 
	 * @param btnText
	 */
	public void clickButtonInEnquireAboutOfferLayer(String btnText) {
		getElement(btnInEnquireAboutOffer, btnText).click();
	}

	/**
	 * verify Offer Status Message is displayed
	 * 
	 * @param statusMsgText
	 * @return true if Offer Status Message is displayed
	 */
	public boolean verifyOfferStatusMessage(String statusMsgText) {
		return getText(eleOfferStatusMessage).contains(statusMsgText);
	}

	/**
	 * verify Same Comment For The Candidate
	 * 
	 * @return true if Same Comment For The Candidate is displayed
	 */
	public boolean verifySameCommentForTheCandidate() {
		return getText(eleCandidateMessageOnCVDetails).contains(ReadWritePropertyFile.getProperty(
				"commentsInEnquireAboutOffer",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties"));
	}

	/**
	 * click Send Message Link In Offer Details
	 */
	public void clickSendMessageLinkInOfferDetails() {
		jsUtil.scrollDown(eleOfferDetailsSection);
		click(eleSendMessageLinkInOfferDetails);
	}

	/**
	 * enter Text In Send Message Textbox
	 */
	public void enterTextInSendMessageTextbox() {
		String messageStr = GenericFunctions.generateRandomStrings(10, "String");
		sendKeys(txtSendMessageToApprover, messageStr);
		ReadWritePropertyFile.setProperty("sendMessageToApproverText", messageStr,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
	}

	/**
	 * click Send Message Link Below Text box In Offer Details
	 */
	public void clickSendMessageLinkBelowTextboxInOfferDetails() {
		click(eleSendMessageBelowTextboxInOfferDetails);
	}

	/**
	 * verify Same Message Sent To Approver
	 * 
	 * @return true if Same Message Sent To Approver
	 */
	public boolean verifySameMessageSentToApprover() {
		return getText(eleCandidateMessageOnCVDetails).contains(ReadWritePropertyFile.getProperty(
				"sendMessageToApproverText",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties"));
	}

	/**
	 * verify Approvers In Show Full Approval Layer
	 * 
	 * @param expected
	 *            list
	 * @return true if all approvers present in layer
	 */
	public boolean verifyApproversInShowFullApprovalLayer(List<String> list) {
		List<String> expectedValues = new ArrayList<>();
		expectedValues.add(OfferSettingsPagePO.getUsernameAndPasswordForOffer(list.get(1))[0]);
		expectedValues.add(OfferSettingsPagePO.getUsernameAndPasswordForOffer(list.get(0))[0]);
		List<WebElement> actualValueElements = getElements(eleApproversInShowFullApproval);
		List<String> actualValues = new ArrayList<>();
		for (WebElement element : actualValueElements) {
			actualValues.add(element.getText());
		}
		return actualValues.equals(expectedValues);
	}

	/**
	 * click Reject Button On CV Details Page
	 */
	public void clickRejectButtonOnCVDetailsPage() {
		jsUtil.clickByJS(btnRejectOnCVDetails);
	}

	/**
	 * verify Offer Notification On Dashboard For Approval Pending
	 * 
	 * @return true if notification present
	 */
	public boolean verifyOfferNotificationOnDashboardForApprovalPending(String verifyText) {
		String actualStr = getText(eleNotificationFirstRow);
		if (actualStr.contains(verifyText)
				& actualStr.contains(ReadWritePropertyFile.getProperty("RequirementNameForApproval",
						OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
								+ "offerManagementSalaryBreakup.properties"))
				& actualStr.contains(ReadWritePropertyFile.getProperty("OfferedDesignation",
						OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
								+ "offerManagementSalaryBreakup.properties")))
			return true;
		else
			return false;
	}

	/**
	 * verify Approve Reject Button Not Displayed
	 * 
	 * @return true if Approve Reject Button Not Displayed
	 */
	public boolean verifyApproveRejectButtonNotDisplayed() {
		jsUtil.scrollDown(eleOfferDetailsSection);
		return (!isDisplayed(btnOfferRejectOnCVDetails) & !isDisplayed(btnOfferApproveOnCVDetails));
	}

	/**
	 * click on send to candidate btn after approved by all
	 */
	public void clickOnSendToCandidateAfterApprovedByAll() {
		jsUtil.scrollUp();
		click(sendToCandidateAfterApproved);
	}

	/**
	 * mail body displayed on offer lightbox
	 * 
	 * @return trye if mail body is displayed on offer lightbox
	 */
	public boolean mailBodyDisplayedOnOfferLightbox() {
		return isDisplayed(mailBodyOnOfferLightbox);
	}

	/**
	 * check switch offer approval mandatory
	 */
	public void checkSwitchOfferApprovalMandatory() {
		if (elementVisibility(offerApprovalMandatoryValueOff)) {
			click(offerApprovalMandatoryChkBx);
		}
	}

	/**
	 * uncheck switch offer approval mandatory
	 * 
	 */
	public void unCheckSwitchOfferApprovalMandatory() {
		if (elementVisibility(offerApprovalMandatoryValueOn)) {
			click(offerApprovalMandatoryChkBx);
		}
	}

	/**
	 * click on set approval settings
	 * 
	 */
	public void clickOnSetApprovalSettings() {
		click(setApprovalSettings);
	}

	/**
	 * save Group Id To Property File Using API
	 */
	public void saveGroupIdToPropertyFileUsingAPI(String groupId) {
		ReadWritePropertyFile.setProperty("groupIdForApproval", groupId,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
	}

	/**
	 * verify Text Not Displayed In Select Approval Process Dropdown
	 * 
	 * @param text
	 *            to be verified
	 * @return true if Text Not Displayed
	 */
	public boolean verifyTextNotDisplayedInSelectApprovalProcessDropdown(String text) {
		List<WebElement> approvalListElements = getElements(eleSelectApprovalProcessDDlist);
		jsUtil.scrollDown(eleSelectApprovalProcessDDlist);
		for (WebElement element : approvalListElements) {
			if (element.getText().equalsIgnoreCase(text)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * get Requiremnent Id For Add Candidate
	 * 
	 * @return requirement ID from properties file
	 */
	public String getRequiremnentIdForAddCandidate() {
		return ReadWritePropertyFile.getProperty("RequirementIdForApproval",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
	}

	/**
	 * change Status Of Candidate
	 * 
	 * @param statusText
	 */
	public void changeStatusOfCandidate(String statusText) {
		wait.waitForElementToBeClickable(UpdateStatusDD);
		wait.waitForVisibilityOfElement(UpdateStatusDD);
		getElement(UpdateStatusDD).click();
		click(parameterizedLocator(eleStatusTextInUpdateStatus, statusText));
	}

	/**
	 * add candidate to requirement
	 * 
	 */
	public void addCandidateToReq() {
		String emailId = "email" + System.currentTimeMillis() + "@yopmail.com";
//		driver.navigate().refresh();
		wait.waitForElementToBeClickable(parameterizedLocator(ActionsOnReqList, "More Actions "));
		hover(parameterizedLocator(ActionsOnReqList, "More Actions "));
//		clickUsingActions(getElement(parameterizedLocator(ActionsOnReqList, "More Actions ")));
		//	jsUtil.executeJavascript("document.querySelectorAll('.listWrap .manage a + .subNav')[3].style.display = 'block';");
			getElement(parameterizedLocator(ActionsOnReqList, "Add Single Profile")).click();
		// click(parameterizedLocator(ActionsOnReqList,"Add Single Profile"));
		wait.waitForVisibilityOfElement(emailCandidateText);
		sendKeys(emailCandidateText, emailId);
		jsUtil.scrollDown(saveCandidatebtn);
		click(saveCandidatebtn);
	}

	/**
	 * verify both profiles created
	 * 
	 * @return
	 */
	public boolean verifyBothProfilesCreated() {
		for (int i = 0; i <= 10; i++) {
			if (getText(projectInboxCount).contains("2")) {
				return true;
			} else {
				driver.navigate().refresh();
			}
		}
		return false;
	}

	/**
	 * click Requirement Name On CV Details get requirement Name from
	 * offerManagementSalaryBreakup.properties
	 */
	public void clickRequirementNameOnCVDetails() {
		click(parameterizedLocator(eleRequirementNameOnCVDetails, ReadWritePropertyFile.getProperty(
				"RequirementNameForApproval",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties")));
		switchToChildWindow();
	}

	/**
	 * click Application Count On Requirement Overview
	 */
	public void clickApplicationCountOnRequirementOverview() {
		click(parameterizedLocator(eleApplicationCountOnRequirementOverview, ReadWritePropertyFile.getProperty(
				"RequirementNameForApproval",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties")));
		switchToChildWindow();
	}

	/**
	 * search For Requirement On Req Listing
	 */
	public void searchForRequirementOnReqListing() {
		sendKeys(eleSearchBarOnReqListing, ReadWritePropertyFile.getProperty(
				"RequirementNameForApproval",
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties"));
		click(eleSearchIconOnReqListing);
	}
}
