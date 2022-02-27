package com.naukri.pageobjects.Applications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Settings.ManageDocumentsPO;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Page Object Class consists of all the page object methods and locators for CV
 * Details Page
 * 
 * @author rachit.mehrotra
 *
 */
public class CVDetailsPagePO extends PageObjectWrapper {

	AddASingleProfilePagePO addSingleProfile = (AddASingleProfilePagePO) PageObjectWrapper
			.getObject(AddASingleProfilePagePO.class);
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);

	// locator
	public By successMessage_span = By.xpath("//div[@id = \"messageFromAddCand\"]//span");
	public By contactDetails_text = By.id("candidatePhoneId");
	public By editSuccessMessage = By.id("SuccessmsgBx");
	public By saveEdittedDetails = By.id("editCandBasicButton");
	public By editProfileValue = By.xpath("//div[@class = \"candhead\"]//a[text()=\"Edit\"]");
	public By contactNumber = By.id("numBlock_0");
	public By globalSearchBox_txt = By.id("headTopSearchBox");
	public By advanceSearchBtn = By.id("advQuichSearchBtn");
	public By statusChangeArrow = By.xpath("//a[text()=\" Reject \"]/preceding-sibling::a//*[contains(@class, \" outerArow\")]");
	public By statusChangeSuccessMessage = By.xpath("//div[@id =\"statusChangeMessageDiv\"]//span[@class=\"etxt\"]");
	public By currentStatusOfCandidate = By.xpath("//span[contains(@class,\"interTxt\")]");
	public By statusChangeDDHistory = By.xpath("//div[contains(@id , \"statusChangeMenu\")]");
	public By selectionStagesDD = By.xpath("//div[@id='itm']//a[contains(text(),'${stage}')]");

	public By sectionOnCvDetail = By.xpath("//span[contains(text(),'${section}')]");
	public By breadcrumbsLink = By.xpath("//a[contains(text(),'${breadcrumbs}')]");
	public By linkSectionEditOrAdd = By.xpath("//span[contains(text(),'${section}')]/following-sibling::a[contains(text(),'${link}')]");
	public By candidateDetails = By.xpath("(//label[contains(text(),'${CandidateDetails}')]/following-sibling::*)[1]");
	public By preferredCityName = By.xpath("//label[text()='${cityName}']");
	public By valueOptions = By.xpath("//a[contains(text(),'${valueOptions}')]");
	public By summary = By.xpath("//textarea[@name='summary']");
	public By employer = By.id("empName");
	public By ddDurationMonth = By.xpath("//select[@name='candidateExperience[workingFromMonth]']");
	public By ddDurationYear = By.xpath("//select[@name='candidateExperience[workingFromYear]']");
	public By workDesigantion = By.id("Designation-");
	public By workJobProfile = By.xpath("//textarea[contains(@name,\"candidateExperience[jobProfile]\")]");
	public By workNoticePeriod = By.xpath("(//select[@name='candidateExperience[noticePeriod]'])[1]");
	public By workExpTuple = By.xpath("//div[contains(@id,'viewWorkExp')]//*[contains(text(),'${workExpTuple}')]");
	public By ddEducation = By.xpath("//*[contains(@id,'inp_${ddEducation}')]");
	public By ddName = By.xpath("//ul[contains(@id,'ul_${ddEducation}')]//a[text()='${ddName}']");
	public By RbWithValue = By.xpath("//label[contains(.,'${RbValue}')]//input");
	public By tbLanguageFirst = By.id("lang0");
	public By cbLanguageProficiency = By.xpath("//input[@name='candidateProfile[languagesKnown][0][${cbLanguageProficiency}]']");
	public By languageRow = By.xpath("//input[contains(@id,'lang')]");
	public By dobDay = By.xpath("//select[@name='candidateProfile[dobDay]']");
	public By dobMonth = By.xpath("//select[@name='candidateProfile[dobMonth]']");
	public By dobYear = By.xpath("//select[@name='candidateProfile[dobYear]']");
	public By candidateDetailsValue = By.xpath("//em[contains(text(),'${candidateDetailsValue}')]/following-sibling::span");
	public By successMessage = By.xpath("(//div[contains(@class,'psuccess')])[2]");
	public By viewSummary = By.id("viewSummary");
	public By educationCourseDetail = By.xpath("(//*[contains(text(),'${courseName}')])[${courseName}]");
	public By educationCourseDetailCount = By.xpath("//*[contains(text(),'${courseName}')]");
	public By educationDetail = By.xpath("//p[contains(text(),'${educationDetail}')]");
	public By languageTuple = By.xpath("//td[contains(text(),'${languageTuple}')]");
	public By tbDiploma = By.xpath("//input[@name='diploma[]']");
	public By tbOtherDetailsSection = By.xpath("//*[contains(@name,'candidateProfile[${value}]')]");
	public By btnSave = By.xpath("(//a[text()='Save'])[${size}]");
	public By btnSaveTotal = By.xpath("(//a[text()='Save'])");

    public By selectionStageSubStageDD = By.xpath("(//a[contains(text(),'${stage}')])//span[text()='${substage}']");
    public By candidateStatus = By.cssSelector("span.interTxt");
    By eleCandidateNameOnCVDetails = By.xpath("//div[contains(@class,\"candhead\")]/div[contains(@class,\"hText\")]");
    By eleCandidateEmailId = By.xpath("//div[@id = \"candCont\"]//a");
    private By btnRemoveFromBackup=By.id("removeFromBackUp");
    By eleProfileSummary = By.xpath("//div[contains(@class,\"candhead\")]/pre");
    By eleExpandContactDetails = By.xpath("//a[contains(@class,\"extndBotIc\")]");
    By eleSecondaryEmailAddress = By.xpath("//a[@title='${replaceEmail}']");
    By eleContactNumber = By.xpath("//span[@title='${contactNumber}']");
    By eleRequirementNameHolder = By.xpath("//a[contains(text(),'${requirementName}')]");
    By eleSelectCallActions = By.id("selectCallActions");
    By eleCommentsTextArea = By.id("comments");
    By eleAddCommentButton = By.id("addCommentButton");
    By eleCommentListOnNumber = By.xpath("//ul[contains(@class,\"commentList cle\")]//p['${indexOfComment}']");
    By eleStarRatingSelector = By.xpath("//div[contains(@id,\"starRating\")]//li[${starRating}]");
    By eleStarRatingFetch = By.xpath("//input[contains(@id,\"starRating\")]");
    By eleOuterArrowStatus = By.xpath("//span[contains(@class,\"outerArow\")]");
    By eleSelectionStageHolder = By.xpath("//a[contains(text(),'${selectionStage}')]");
    By eleSelectionStageText = By.xpath("//span[contains(text(),'${selectionStageText}')]");
    By eleProcessOverlay = By.xpath("//div[contains(@class, \"processing-overlay processing-overlay-40  \")]");
    By eleVideoInterviewPromotion = By.xpath("//span[contains(@title,\"Close\")]");
    By eleGiveFeedback = By.xpath("//input[contains(@value,\"Give Feedback\")]");
    By eleGiveFeedbackStarRating = By.xpath("//ul[@class=\"starRating\"]//span[contains(text(),'${starRating}')]");
    By eleAddFeedbackButton = By.xpath("//a[contains(text(),\"Add Comment\")]");
    By eleCommentTextArea = By.xpath("//textarea[contains(@placeholder,\"Type here\")]");
    By eleFeedbackActionButton = By.xpath("//div[@class=\"approveReject\"]//button[contains(text(),'${buttonText}')]");
    By eleAssessmentFeedback = By.id("feedbackAssessment");
    By eleCommentOverlay = By.xpath("//div[contains(@class,'candBtns cle ')]");
    By eleCandidateDetailsFooter = By.xpath("//span[contains(text(),'${textToVerify}')]");
    By eleSourceOfApplicationHolder = By.xpath("//a[contains(text(),'${sourceString}')]");
    By eleUploadIcon = By.xpath("//small[contains(@class,\"uploadNw\")]");
    By eleClickOnRequestDocument = By.id("scrollToRequest");
    By eleDocumentManagementSystemHolder = By.xpath("//p[contains(text(),'${documentManagementString}')]");
    By eleDocumentInput = By.xpath("//input[contains(@placeholder,'${documentForString}')]");
    By eleRequestBtnOnDms = By.xpath("//button[contains(text(),\"Request\")]");
    By eleCancelBtnOnDms = By.xpath("//div[contains(@class,\"uploadContainer\")]//a[contains(text(),\"Cancel\")]");
    By eleAttachDocument = By.xpath("//span[contains(text(),\"Attached Documents\")]");
    By eleDMSLink = By.xpath("//div[contains(@class,\"attachDocSection\")]//a[contains(text(),'${linkVisibleText}')]");
    By eleRequestDocumentForInput = By.id("advSelect");
    By eleDefaultDocument = By.xpath("//ul[contains(@class,\"dropdown\")]/li//span[contains(text(),'${documentType}')]");
    By eleCandidateClassOverlay = By.xpath("//div[contains(@class,\"candBtns\")]");
    By eleGroupLocatorOfDocument = By.xpath("//ul[contains(@class,\"dropdown\")]/li");
    By eleSuccessMessageForDMS = By.xpath("//span[contains(text(),'${successMessage}')]");
    By eleDMSMessage = By.xpath("//span[contains(text(),'${textForDMS}')]");
    By eleSendReminderMessage = By.xpath("//a[contains(text(),\"Send Reminder\")]");
    By eleSendReminderMessageForSent = By.xpath("//span[contains(text(),'${textMessage}')]");
    By eleCandidateImage = By.xpath("//div[contains(@class,\"canPic\")]//img[contains(@id,\"logo\")]");
    By feedbackState = By.xpath("//div[@id='feedbackAssessmentAccord']//span[text()='${state} ']");
    By lblhmName = By.xpath("//div[contains(@class,'statusUpdate')]//span[text()='${hmName}']");
	By lblStateStageName = By.xpath("//div[@id='applicationStatusActionsSection']//span[text()='${stateStageName}']");
	By eleMoveApplicationToSubSelectionStage = By.xpath("//a[contains(text(),'${selectionStage}')]//span[contains(text(),' - ${substageName}')]");
	By eleMoveApplicationToSelectionStage = By.xpath("//a[text()='${stage}']");
	By eleApplicationId = By.xpath("//div[@id='profileDetails']//span[contains(text(),'Application ID')]");
	By ddGiveFeeddback = By.xpath("//span[contains(text(),'Give Feedback')]");
	By btnChangeFeedback = By.xpath("//*[text()='${btnName}']");
	By btnForward = By.xpath("//a[contains(@onclick,'forwardMail')]");
	By eleCurrentLocation = By.xpath("//em[text()='Current Location:']//following-sibling::span");
    
    private By btnViewOnCVDetailsPage=By.xpath("//div[@class='profileStatus']/..//following-sibling::div//a[contains(.,'VIEW')]");
    private By eleUnMappedProfileBlock=By.xpath("//span[contains(.,'Unmapped Applications')]");
    private By eleMasterProfileBlock=By.xpath("//span[contains(.,'Master Profile')]");
    private By eleMasterProfileMailBox=By.xpath("//span[contains(.,'Master Profile')]/../ancestor::div[@id[contains(.,'sticky-wrapper-header')]]//following-sibling::div");
    private By eleUnMappedProfileMailBox=By.xpath("(//span[contains(.,'Unmapped Applications')]/../ancestor::div[@id[contains(.,'sticky-wrapper-header')]]//following-sibling::div)[2]");

	//variables
	String editContactNumber = "1234567891";
	public static String candidateDetailsPageUrl = "";
	public static String statusTextGlobal = "";
	public HashMap<String, Integer> callStatusMapping = new HashMap<String, Integer>();
	List<WebElement> listOfDocuments = new ArrayList<WebElement>();
	private String selectedCheckboxClassName = "multi selected";

	/**
	 * To verify the visibility of success message for candidate creation through
	 * add single profile
	 * 
	 * @author rachit.mehrotra
	 * @param successMessage
	 * @return boolean
	 */
	public boolean verifySuccessStatusMessage(String successMessage) {
		candidateDetailsPageUrl = getCurrentURL();
		wait.waitForVisibilityOfElement(successMessage_span);
		return getText(successMessage_span).contains(successMessage);
	}

	/**
	 * To verify redirection to candidate's CV Detail Page
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean verifyRedirectedOnCVDetailsPage() {
		wait.waitForPageToLoadCompletely();
		TestNGLogUtility.info("Current Url " + getCurrentURL());
		TestNGLogUtility.info("Expected Url " + YamlReader.getAppConfigValue("URLs.cvDetailsPage"));
		return getCurrentURL().contains(URLBuilder.getEndPoint("cvDetailsPage"));
	}

	/**
	 * To verify the presence of requirement name in case candidate is mapped to one
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean verifyVisibilityOfRequirementTitle() {
		return getText(By.xpath("//a[contains(text(),\"" + addSingleProfile.requirementTitle + "\")]"))
				.contains(addSingleProfile.requirementTitle);
	}

	/**
	 * To verify presence of candidate's email
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean verifyTheVisibilityOfCandidateemail() {
		return getText(By.xpath("//a[contains(text(),\"" + addSingleProfile.emailId + "\")]"))
				.contains(addSingleProfile.emailId);
	}

	/**
	 * To verify the presence of candidate's contact number
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	@SuppressWarnings("static-access")
	public boolean verifyTheVisibilityOfCandidateContact() {
		return getText(contactDetails_text).contains(addSingleProfile.contactNumber);
	}

	/**
	 * To verify the candidate's current status stage
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	@SuppressWarnings("static-access")
	public boolean verifyTheSelectionStage() {
		TestNGLogUtility.info(
				"basic " + getText(By.xpath("//span[contains(@title,\"" + addSingleProfile.selectionStage + "\")]"))
						.contains(addSingleProfile.selectionStage));
		return getText(By.xpath("//span[contains(@title,\"" + addSingleProfile.selectionStage + "\")]"))
				.contains(addSingleProfile.selectionStage);
	}

	/**
	 * To click on edit profile button present on CV details page
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickEditProfileButton() {
		jsUtil.scrollUp();
		click(editProfileValue);
	}

	/**
	 * To edit the contact number of candidate
	 * 
	 * @author rachit.mehrotra
	 */
	public void editContactNumber() {
		sendKeys(contactNumber, "");
		sendKeys(contactNumber, editContactNumber);
	}

	/**
	 * To click on save candidate details on CV details page
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickSaveDetailsButton() {
		click(saveEdittedDetails);
	}

	/**
	 * To verify the success message presence after editing basic details of
	 * candidate
	 * 
	 * @author rachit.mehrotra
	 * @param successMessage
	 * @return boolean
	 */
	public boolean verifyThePresenceOfEditSuccessMessage(String successMessage) {
		return getText(editSuccessMessage).contains(successMessage);
	}

	/**
	 * To compare the contact details present for the candidate
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean compareEditContact() {
		return getText(contactDetails_text).contains(editContactNumber);
	}

	/**
	 * To fill candidate's detail in advanced search to get master profile for that
	 * particular candidate corresponding to detail
	 * 
	 * @author rachit.mehrotra
	 * @param masterProfileSearchKeyword
	 */
	public void fillGlobalSearchText(String masterProfileSearchKeyword) {
		String searchText = "";
		if (masterProfileSearchKeyword.contains("email")) {
			searchText = AddASingleProfilePagePO.emailId;
		} else {
			searchText = AddASingleProfilePagePO.contactNumber;
		}
		TestNGLogUtility.info("search " + searchText);
		sendKeys(globalSearchBox_txt, searchText);
		click(advanceSearchBtn);
	}

	/**
	 * To click on status change DD on CV details page
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnStatusChangeDD() {
		jsUtil.scrollUp();
		wait.waitForInvisibilityOfElement(10, 3, eleProcessOverlay);
		click(statusChangeArrow);
	}

	/**
	 * To change the status to particular stage for a candidate
	 * 
	 * @author rachit.mehrotra
	 * @param statusText
	 */
	public void changeStatusOfCandidate(String statusText) {
		wait.waitForInvisibilityOfElement(10, 3, eleProcessOverlay);
		statusTextGlobal = statusText;
		if (statusTextGlobal.contains("-")) {
			getElement(selectionStageSubStageDD, statusTextGlobal).click();
		} else {
			getElement(selectionStagesDD, statusTextGlobal).click();
		}
		TestNGLogUtility.info("User clicked on " + statusTextGlobal);
	}

	/**
	 * To verify the status change success message
	 * 
	 * @author rachit.mehrotra
	 * @param successMessage
	 * @return boolean
	 */
	public boolean validateStatusChangeSuccessMessage(String successMessage) {
		wait.waitForInvisibilityOfElement(10, 3,
				By.xpath("//div[@class = ' processing-overlay processing-overlay-40  ']"));
		return getText(statusChangeSuccessMessage).contains(successMessage);
	}

	/**
	 * To verify the status of candidate to one passed as the parameter to function
	 * 
	 * @author rachit.mehrotra
	 * @param actualStatus
	 * @return boolean
	 */
	public boolean verifyStatusOfCandidate(String actualStatus) {
		return getText(currentStatusOfCandidate).contains(actualStatus);
	}

	/**
	 * To verify text from status change history widget
	 * 
	 * @author rachit.mehrotra
	 * @param recruiterNameText
	 * @return boolean
	 */
	public boolean statusChangeHistory(String recruiterNameText) {
		jsUtil.hoverByJS(statusChangeDDHistory);
		return recruiterNameText
				.contains(getText(By.xpath("(//div[contains(@id , \"statusChangeMenu\")]/a)[1]")).replace("..", ""));
	}

	/**
	 * To get contact number present on candidate CV details page
	 * 
	 * @author rachit.mehrotra
	 * @return String
	 */
	public String getContactNumber() {
		return getText(By.id("candidatePhoneId"));
	}

	/**
	 * This method is to verify the candidate status has been changed or not
	 * 
	 * @author rachit.mehrotra
	 * @param status of the candidate
	 * @return true/false basis on the comparison
	 */
	public boolean verifyCandidateStatusChanges(String status) {
		return getElement(candidateStatus).getAttribute("title").equalsIgnoreCase(status);
	}

	/**
	 * To verify the length and characters of the candidate name displayed on once
	 * exceeding the character limit
	 * 
	 * @author rachit.mehrotra
	 * @return boolean basis comparison
	 */
	@SuppressWarnings("static-access")
	public boolean verifyTheLengthOfText() {
		String actualName = addSingleProfile.candidateName;
		if (addSingleProfile.flag && addSingleProfile.candidateName.length()>35)
			actualName = addSingleProfile.candidateName.substring(0, 35);
		TestNGLogUtility.info("condition for name match " + getText(eleCandidateNameOnCVDetails).equals(actualName));
		return getText(eleCandidateNameOnCVDetails).equals(actualName);
	}

	/**
	 * To verify the email of the candidate on the cv details page
	 * 
	 * @return boolean basis comparison
	 */
	public boolean verifyTheEmailIdTextOnCVDetailsPage() {
		String candidateEmailId = getText(eleCandidateEmailId);
		TestNGLogUtility.info("Candidate Name from CV details page " + candidateEmailId);
		return candidateEmailId.equals(AddASingleProfilePagePO.emailId);
	}

	/**
	 * To verify the phone of the candidate on the cv details page
	 * 
	 * @return boolean basis comparison
	 */
	public boolean verifyTheLengthOfMobileNumberStored(int lengthOfMobileNumber) {
		return getText(contactDetails_text).equals(AddASingleProfilePagePO.contactNumber.substring(0, 15));
	}

	/**
	 * To verify the Remove from back up button displayed on the cv details page
	 * 
	 * @author abhishek.dwivedi
	 * @return true/false
	 */
	public boolean isTheRemoveFromBackuoDisplayedOnCVDetailsPage() {
		return isDisplayed(btnRemoveFromBackup);
	}

	/**
	 * To verify the profile summary text on CV details page
	 * 
	 * @param expectedProfileSummaryText
	 * @return true/false basis comparison
	 */
	public boolean verifyTheTextOfProfileSummary(String expectedProfileSummaryText) {
		return getText(eleProfileSummary).replace("\"", "").equals(expectedProfileSummaryText);
	}

	/**
	 * To verify the length of the profile summary
	 * 
	 * @param lengthOfString
	 * @return true/false basis comparison
	 */
	public boolean verifyTheTextOfProfileSummary(int lengthOfString) {
		String expectedProfileSummary;
		if (AddASingleProfilePagePO.profileSummary.length() > 250)
			expectedProfileSummary = AddASingleProfilePagePO.profileSummary.substring(0, 250);
		else
			expectedProfileSummary = AddASingleProfilePagePO.profileSummary;
		return verifyTheTextOfProfileSummary(expectedProfileSummary);
	}

	/**
	 * to verify the presence of secondary email
	 * 
	 * @return true/false basis presence
	 */
	public boolean verifyThePresenceOfSecondaryMail() {
		click(eleExpandContactDetails);
		return isDisplayed(parameterizedLocator(eleSecondaryEmailAddress, AddASingleProfilePagePO.secondaryEmail));
	}

	/**
	 * to verify the presence of mobile number
	 * 
	 * @return true/false basis presence
	 */
	public boolean verifyThePresenceOfMobileNumber() {
		return isDisplayed(parameterizedLocator(eleContactNumber, AddASingleProfilePagePO.contactNumber));
	}

	/**
	 * To verify the presence of secondary mobile number
	 * 
	 * @return true/false basis presence
	 */
	public boolean verifyThePresenceOfSecondaryMobileNumber() {
		click(eleExpandContactDetails);
		return isDisplayed(parameterizedLocator(eleContactNumber, AddASingleProfilePagePO.secondaryContactNumber));
	}

	/**
	 * To verify the presence of requirement name on the candidate details page
	 * 
	 * @return true/false basis comparison
	 */
	public boolean verifyThePresenceOfRequirement() {
		return isDisplayed(parameterizedLocator(eleRequirementNameHolder, AddASingleProfilePagePO.newRequirementTitle));
	}

	/**
	 * To verify the call status DD
	 * 
	 * @return boolean basis comparison
	 */
	public boolean verifyThePresenceOfCallActions() {
		return isDisplayed(eleSelectCallActions);
	}

	/**
	 * To set the call status from DD
	 * 
	 * @param callAction
	 */
	public void selectCallAction(String callAction) {
		Select select = new Select(getElement(eleSelectCallActions));
		select.selectByVisibleText(callAction);
	}

	/**
	 * To verify the change in status of Call DD
	 * 
	 * @param callStatus
	 * @return boolean basis comparison
	 */
	public boolean verifyTheSelectedCallStatus(String callStatus) {
		fillInCallMappingStatus();
		return Integer.parseInt(jsUtil.executeJavascriptForJSVariables(
				"document.getElementById('selectCallActions').value")) == callStatusMapping.get(callStatus);
	}

	/**
	 * To prepare a map for verification of the called status
	 */
	private void fillInCallMappingStatus() {
		callStatusMapping.put("Called", 1);
		callStatusMapping.put("Messaged", 2);
		callStatusMapping.put("Call not picked", 3);
		callStatusMapping.put("Not Reachable", 4);
		callStatusMapping.put("Send Whatsapp Message", 5);
	}

	/**
	 * To fill in the comment on CV details page
	 * 
	 * @param commentText
	 */
	public void fillInCommentsOnCVDetailsPage(String commentText) {
		wait.waitForInvisibilityOfElement(10, 3, eleProcessOverlay);
		jsUtil.scrollUp();
		sendKeys(eleCommentsTextArea, commentText);
		click(eleAddCommentButton);
	}

	/**
	 * To verify the presence of the comment present on the index
	 * 
	 * @param expectedCommentText
	 * @param index
	 * @return boolean basis comparison
	 */
	public boolean verifyTheCommentTextOnIndex(String expectedCommentText, int index) {
		return expectedCommentText
				.equals(getText(parameterizedLocator(eleCommentListOnNumber, Integer.toString(index))).trim());
	}

	/**
	 * To fill in the star rating
	 * 
	 * @param starRatingValue
	 */
	public void fillInStarRating(int starRatingValue) {
		click(parameterizedLocator(eleStarRatingSelector, Integer.toString(starRatingValue)));
	}

	/**
	 * To verify the candidate star rating
	 * 
	 * @param starRating
	 * @return boolean basis comparison
	 */
	public boolean verifyTheStarRating(String starRating) {
		return getAttribute(eleStarRatingFetch, "value").equals(starRating);
	}

	/**
	 * To click on close button of the video interview promotion page
	 */
	public void clickOnCloseButtonForVideoPromotion() {
		if (isDisplayed(eleVideoInterviewPromotion))
			click(eleVideoInterviewPromotion);
	}

	/**
	 * To click on give feedback button
	 */
	public void clickGiveFeedbackButton() {
		switchToChildWindow();
		click(eleGiveFeedback);
	}

	/**
	 * To give the star rating for the candidate
	 * 
	 * @param starRating
	 */
	public void giveStarRatingForHMFeedback(String starRating) {
		click(parameterizedLocator(eleGiveFeedbackStarRating, starRating));
	}

	/**
	 * To add the feedback comment of the candidate
	 * 
	 * @param commentText
	 */
	public void addCommentForHMFeedback(String commentText) {
		click(eleAddFeedbackButton);
		wait.waitForVisibilityOfElement(eleCommentTextArea);
		sendKeys(eleCommentTextArea, commentText);
	}

	/**
	 * To click on the action button of the feedback overlay of the candidate
	 * 
	 * @param btnText
	 */
	public void clickOnActionButtonForHMFeedback(String btnText) {
		click(parameterizedLocator(eleFeedbackActionButton, btnText));
		pageRefresh();
	}

	/**
	 * To launch the CV details page of the candidate whose feedback has been
	 * recieved
	 */
	public void launchApplicationDetailPageViaURL() {
		genericFunctions.launchSpecificURL(candidateDetailsPageUrl);
		switchToChildWindow();
	}

	/**
	 * 
	 * @author himanshu.dua
	 * @return
	 */
	public boolean verifySectionOnCvDetailPage(String section) {
		return isDisplayed(parameterizedLocator(sectionOnCvDetail, section));
	}

	/**
	 * This method is verify all the Breadcrumbs on the CV detail page
	 * 
	 * @author himanshu.dua
	 * @param breadcrumbs
	 * @return
	 */
	public boolean verifyAllBreadcrumbsLinkOnCvDetailPage(String breadcrumbs) {
		return isDisplayed(parameterizedLocator(breadcrumbsLink, breadcrumbs));
	}

	/**
	 * This method is used for click on Edit/Add link on section in CV detail page
	 * 
	 * @author himanshu.dua
	 * @param section
	 * @param link
	 */
	public void clickOnEditOrAddLinkInSection(String section, String link) {
		click(parameterizedLocator(linkSectionEditOrAdd, section, link));
	}

	public void setCandidateDetails(String field, String value) {
		switch (field) {
		case "Current Company":
		case "Current Designation":
		case "Key Skills":
			click(parameterizedLocator(candidateDetails, field));
			sendKeys(parameterizedLocator(candidateDetails, field), value);

			break;
		case "Current Location":
		case "Functional Area":
		case "Role":
		case "Industry":
			click(parameterizedLocator(candidateDetails, field));
			click(parameterizedLocator(valueOptions, value));
			break;
		case "Total Experience":
		case "Annual Salary":
		case "Expected CTC":
			selectByVisibleText(parameterizedLocator(candidateDetails, field), value);
			break;
		case "Preferred Location":
			click(parameterizedLocator(preferredCityName, value));
			break;
		}

	}

	/**
	 * This method is set designation in candidate profile
	 * 
	 * @author himanshu.dua
	 * @param designation
	 */
	public void setWorkDesignation(String designation) {
		sendKeys(workDesigantion, designation);
	}

	/**
	 * This method is set job Profile in candidate profile
	 * 
	 * @author himanshu.dua
	 * @param jobProfile
	 */
	public void setworkJobProfile(String jobProfile) {
		click(workJobProfile);
		sendKeys(workJobProfile, jobProfile);
	}

	/**
	 * This method is click on save button on candidate profile
	 * 
	 * @author himanshu.dua
	 */
	public void clickOnSaveBtn() {
		int size = getElements(btnSaveTotal).size();
		click(parameterizedLocator(btnSave, String.valueOf(size)));
		wait.waitForVisibilityOfElement(successMessage);
	}

	/**
	 * This method is click on save button on candidate profile
	 * 
	 * @author himanshu.dua
	 */
	public void clickOnFirstSaveBtn() {
		click((btnSaveTotal));
		wait.waitForVisibilityOfElement(successMessage);
	}

	/**
	 * This method will set summary
	 * 
	 * @author himanshu.dua
	 * @param summaryValue
	 */
	public void setSummary(String summaryValue) {
		click(summary);
		sendKeys(summary, summaryValue);
		PropFileHandler.writeProperty("summaryOfCandidate", summaryValue);
	}

	/**
	 * This method will set the Employer value
	 * 
	 * @author himanshu.dua
	 * @param employerValue
	 */
	public void setEmoloyer(String employerValue) {
		sendKeys(employer, employerValue);
	}

	/**
	 * This method will select the value from duration drop down
	 * 
	 * @author himanshu.dua
	 * @param month
	 * @param year
	 */
	public void setDuration(String month, String year) {
		selectByVisibleText(ddDurationMonth, month);
		selectByVisibleText(ddDurationYear, year);
	}

	/**
	 * This method is set key skills in candidate profile
	 * 
	 * @author himanshu.dua
	 * @param skill
	 */
	public void setNoticePeriod(String period) {
		selectByVisibleText(workNoticePeriod, period);
	}

	/**
	 * This method will verify all the work experience tuple value
	 * 
	 * @author himanshu.dua
	 * @param value
	 * @return
	 */
	public boolean verifyWorkExpTuple(String value) {
		return isDisplayed(parameterizedLocator(workExpTuple, value));
	}

	/**
	 * This method will set the education degree course
	 * 
	 * @author himanshu.dua
	 * @param value
	 */
	public void setEducationDegreeValue(String ddValue, String value) {
		click(parameterizedLocator(ddEducation, ddValue));
		click(parameterizedLocator(ddName, ddValue, value));
	}

	/**
	 * This method will set value with label text
	 * 
	 * @author himanshu.dua
	 * @param value
	 */
	public void setValueWithLabelText(String value) {
		click(parameterizedLocator(RbWithValue, value));
	}

	/**
	 * This method will set language value
	 * 
	 * @param languageValue
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public void setLanguage(String languageValue, String p1, String p2, String p3) {
		sendKeys(tbLanguageFirst, languageValue);
		click(parameterizedLocator(cbLanguageProficiency, p1));
		click(parameterizedLocator(cbLanguageProficiency, p2));
		click(parameterizedLocator(cbLanguageProficiency, p3));
	}

	/**
	 * This method will click on Add language link
	 * 
	 * @author himanshu.dua
	 * @param value
	 */
	public int clickOnAddLanguageLink(String value) {
		int rowCountBefore = getElements(languageRow).size();
		click(parameterizedLocator(valueOptions, value));
		return rowCountBefore;
	}

	/**
	 * This method will verify language row count increased by 1
	 * 
	 * @param value
	 * @return
	 */
	public boolean verifyAddedLanguageRow(int beforeValue) {
		int rowCountAfter = getElements(languageRow).size();
		return rowCountAfter == beforeValue + 1;
	}

	/**
	 * This will set Date of birth in candidate profile
	 * 
	 * @author himanshu.dua
	 * @param day
	 * @param month
	 * @param year
	 */
	public void setDOB(String day, String month, String year) {
		selectByVisibleText(dobDay, day);
		selectByVisibleText(dobMonth, month);
		selectByVisibleText(dobYear, year);
	}

	/**
	 * This method will set Other Details value
	 * 
	 * @author himanshu.dua
	 * @param section
	 * @param value
	*/
	public void setOtherDetailsTextBoxes(String section, String value) {
		sendKeys(parameterizedLocator(tbOtherDetailsSection, section), value);
	}

	/**
	 * This method will verify each value of candidate detail
	 * 
	 * @param detailType
	 * @param expectedValue
	 * @return
	 */
	public boolean verifyCandidateDetails(String detailType, String expectedValue) {
		if (detailType.trim().equalsIgnoreCase("Preferred Location"))
			detailType = "Pref. Location";
		String actualValue = getText(parameterizedLocator(candidateDetailsValue, detailType));
		return actualValue.trim().contains(expectedValue.trim());
	}

	/**
	 * This method will verify success message strip
	 * 
	 * @author himanshu.dua
	 * @return
	 */
	public boolean verifySuccessMessage() {
		return isDisplayed(successMessage);
	}

	/**
	 * This method will verify added summary text
	 * 
	 * @author himanshu.dua
	 * @param summaryText
	 * @return
	 */
	public boolean verifySummaryText(String summaryText) {
		return getText(viewSummary).equalsIgnoreCase(summaryText);
	}

	/**
	 * This method verify the added course detail
	 * 
	 * @author himanshu.dua
	 * @param detail
	 * @return
	 */
	public boolean verifyEducationDetails(String detail) {
		if (detail.contains("20"))
			detail = detail.replace("20", "in 20");
		int size = getElements(parameterizedLocator(educationCourseDetailCount, detail)).size();
		return isDisplayed(parameterizedLocator(educationCourseDetail, detail, String.valueOf(size)));
	}

	/**
	 * This method will verify added language tuple
	 * 
	 * @author himanshu.dua
	 * @param value
	 * @return
	 */
	public boolean verifyAddedLanguage(String value) {
		return isDisplayed(parameterizedLocator(languageTuple, value));
	}

	/**
	 * This method is user for set diploma value.
	 * 
	 * @author himanshu.dua
	 * @param diplomaValue
	 */
	public void setDiplomaCertifiocate(String diplomaValue) {
		sendKeys(tbDiploma, diplomaValue);
	}

	/**
	 * This method will select the values from DD
	 * 
	 * @author himanshu.dua
	 * @param sectionDD
	 * @param value
	 */
	public void selectotherDetailsDD(String sectionDD, String value) {
		selectByVisibleText(parameterizedLocator(tbOtherDetailsSection, sectionDD), value);
	}
    
    /**
     * To verify the presence of the assessment div on CV details page
     * @return boolean basis the presence
     */
    public boolean verifyThePresenceOfAssessmentDiv() {
    	return isDisplayed(eleAssessmentFeedback);
    }

    /**
	 * To click on the View button of Other Requirement box on the right side of CV
	 * Details page
	 * 
	 * @author abhishek.dwivedi
	 */
	public void clickOnViewButtonOnCVDetailsPage() {
		if (isDisplayed(btnViewOnCVDetailsPage))
			click(btnViewOnCVDetailsPage);
		switchToChildWindow();
	}

	/**
	 * To verify the presence of Master Profile/Unmapped profile Block and MailBox
	 * Displayed on CV details page
	 * 
	 * @return boolean basis the presence
	 */
	public boolean isMasterAndUnMappedProfileMailBoxDisplayed(String profileName) {
		boolean flag = false;
		switch (profileName.toString()) {
		case "MasterProfile Block":
		    jsUtil.executeJavascript("window.scrollTo(0, document.body.scrollHeight)");
			flag = isDisplayed(eleMasterProfileBlock);
			break;
		case "MasterProfile MailBox":
			click(eleMasterProfileBlock);
			wait.hardWait(2);
			flag = isDisplayed(eleMasterProfileMailBox);
			break;
		case "UnMappedProfile Block":
			flag = isDisplayed(eleUnMappedProfileBlock);
			break;
		case "UnMappedProfile MailBox":
			click(eleUnMappedProfileBlock);
			wait.hardWait(2);
			flag = isDisplayed(eleUnMappedProfileMailBox);
			break;
		}
		return flag;
	}
	
	public boolean verifyThePresenceOfApplicationIdOnCVDetailsPage(String key) {
		return Integer.parseInt(getText(parameterizedLocator(eleCandidateDetailsFooter, key)).replaceAll("[^0-9]", "")) == 
				Integer.parseInt(candidateDetailsPageUrl.replaceAll("[^0-9]", ""));
	}
	
	public boolean verifyThePresenceOfSourceString(String source) {
		return isDisplayed(parameterizedLocator(eleSourceOfApplicationHolder, source));
	}
	
	public boolean verifyThePresenceOfUploadIcon() {
		return isDisplayed(eleUploadIcon);
	}
	
	/**
	 * To click on request doc
	 */
	public void clickOnRequestDocument() {
		click(eleClickOnRequestDocument);
		TestNGLogUtility.info("clicked on request document");
	}
	
	/**
	 * To verify the presence of the document string
	 * @param expectedString
	 * @return boolean
	 */
	public boolean verifyThePresenceOfDocumentManagementString(String expectedString) {
		return isDisplayed(parameterizedLocator(eleDocumentManagementSystemHolder, expectedString));
	}
	
	/**
	 * To verify the presence of upload document input field
	 * @param expectedPlaceholderString
	 * @return boolean
	 */
	public boolean verifyThePresenceOfUploadField(String expectedPlaceholderString) {
		return isDisplayed(parameterizedLocator(eleDocumentInput, expectedPlaceholderString));
	}
	
	/**
	 * To verify the presence of action button on DMS
	 * @param btnText
	 * @return boolean
	 */
	public boolean verifyThePresenceOfDMSActionButtons(String btnText) {
		boolean flag = btnText.contains("Request") ? isDisplayed(eleRequestBtnOnDms) : isDisplayed(eleCancelBtnOnDms);
		return flag;
	}
	
	/**
	 * To scroll to request document section
	 */
	public void scrollDownToAttachmentSection() {
		jsUtil.scrollMid(eleAttachDocument);
	}
	
	/**
	 * To click on DMS link
	 * @param linkText
	 */
	public void clickOnDMSLink(String linkText) {
		click(parameterizedLocator(eleDMSLink, linkText));
		TestNGLogUtility.info("Link for " + linkText + " is clicked");
	}
	
	/**
	 * To click on request document text field
	 */
	public void clickOnRequestDocumentForCandidate() {
		click(eleRequestDocumentForInput);
		TestNGLogUtility.info("clicked on request document input");
	}
	
	/**
	 * To verify the default document
	 * @param defaultDocument
	 * @return boolean
	 */
	public boolean verifyDefaultDocumentOption(List<String> defaultDocument) {
		for(String a : defaultDocument) {
			if(!isDisplayed(parameterizedLocator(eleDefaultDocument, a))) {
				TestNGLogUtility.info(a+" Not found");
				return false;
			}
			TestNGLogUtility.info(a+" Found");
		}
		return true;
	}
	
	/**
	 * To verify the presence of added document
	 * @return boolean
	 */
	public boolean verifyTheAddedDocumentAddition() {
		return (isDisplayed(parameterizedLocator(eleDefaultDocument, ManageDocumentsPO.documentName)) && 
				isDisplayed(parameterizedLocator(eleDefaultDocument, PropFileHandler.readProperty("documentName"))));
	}
	
	/**
	 * to click on document name
	 * @param documentName
	 */
	public void clickOnDocumentName(String documentName) {
		click(parameterizedLocator(eleDefaultDocument, documentName));
		TestNGLogUtility.info("clicked on " + documentName);
	}
	
	/**
	 * To verify the checkbox of all documents checked
	 * @return
	 */
	public boolean verifyTheCheckboxOfAllDocumentsChecked() {
		listOfDocuments = getElements(eleGroupLocatorOfDocument);
		for(WebElement we : listOfDocuments) {
			if(!(we.getAttribute("class")).contains(selectedCheckboxClassName))
				return false;
		}
		return true;
	}
	
	/**
	 * To verify the placeholder on the request document text field
	 * @param expectedStringPlaceholder
	 * @return boolean
	 */
	public boolean verifyTheCorrectPlaceholder(String expectedStringPlaceholder) {
		return getAttribute(eleRequestDocumentForInput, "placeholder").equals(expectedStringPlaceholder+" ("+(listOfDocuments.size()-1)+")");
	}
	
	/**
	 * To click on the action btns for request document
	 * @param btnText
	 */
	public void clickOnRequestDocumentActionBtn(String btnText) {
		if(btnText.equals("Request"))
			click(eleRequestBtnOnDms);
	}
	
	/**
	 * DMS Success Message
	 * @param documentSucessMessage
	 * @return boolean
	 */
	public boolean verifyTheDocumentSuccessMessage(String documentSucessMessage) {
		return isDisplayed(parameterizedLocator(eleSuccessMessageForDMS, documentSucessMessage));
	}
	
	/**
	 * To verify the DMS status message
	 * @param dmsMessageText
	 * @return boolean
	 */
	public boolean verifyTheDMSMessageText(String dmsMessageText) {
		return isDisplayed(parameterizedLocator(eleDMSMessage, dmsMessageText.replaceAll(" is pending.", "")));
	}
	
	/**
	 * To verify the presence of send reminder of DMS
	 * @return boolean
	 */
	public boolean verifyThePresenceOfSendReminder() {
		return isDisplayed(eleSendReminderMessage);
	}
	
	/**
	 * To click on send reminder link
	 */
	public void clickOnSendReminder() {
		click(eleSendReminderMessage);
		TestNGLogUtility.info("Clicked on send Reminder");
	}
	
	/**
	 * To verify the presence of the reminder sent status
	 * @param expectedMessage
	 * @return boolean
	 */
	public boolean verifyThePresenceOfMsgForSendReminder(String expectedMessage) {
		By by = parameterizedLocator(eleSendReminderMessageForSent, expectedMessage);
		wait.waitForVisibilityOfElement(by);
		return isDisplayed(by);
	}
	
	/**
	 * To get the encoded and decoded body size of the image
	 * @return boolean
	 */
	public boolean verifyThePresenceOfCandidateImage() {
		String url = getAttribute(eleCandidateImage, "src");
		long encodedBodySize = jsUtil.getEncodedBodySize(url);
		long decodedBodySize = jsUtil.getDecodedBodySize(url);
		TestNGLogUtility.info("encodedBodySize " + encodedBodySize);
		TestNGLogUtility.info("decodedBodySize " + decodedBodySize);
		return (encodedBodySize > 0L && decodedBodySize > 0L);
	}
	
	public boolean verifyThePresenceOfRequirementNameOnCVDetailsPage() {
		return isDisplayed(parameterizedLocator(eleRequirementNameHolder, PropFileHandler.readProperty("requirementNameForApplication")));
	}
	
	public boolean verifyTheStatusOfApplication() {
		return getText(currentStatusOfCandidate).equals(CandidateDetailsPagePO.statusOfApplicationMapped);
	}
	
	/**
	 * This method is used to verify state of feedback status
	 * @param feedbackStateName
	 * @return boolean true if state is present
	 * @author gupta.mansi
	 */
	public boolean isFeedbackStateDisplayed(String feedbackStateName)
	{
		return isDisplayed(parameterizedLocator(feedbackState,feedbackStateName));
	}
	
	/**
	 * This method is used to verify the name of feedback giver
	 * @param byUserName
	 * @return boolean
	 * @author gupta.mansi
	 */
	public boolean isFeedbackGiverNameDisplayed(String byUserName)
	{
		return isDisplayed(parameterizedLocator(lblhmName, byUserName));
	}
	
	/**
	 * This method is used to verify current state-stage of application
	 * @param currentStage
	 * @return boolean true if current state-stage is same as param
	 * @author gupta.mansi
	 */
	public boolean iscurrentStateStageDisplayed(String currentStage)
	{
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(lblStateStageName, currentStage));
	}
	
	/**
	 * This method is used to move application to given selection stage
	 * @author gupta.mansi
	 * @param selectionStageName
	 */
	public void moveApplicationToStage(String selectionStageName) {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(statusChangeArrow);
		jsUtil.scrollUp();
		getElement(statusChangeArrow).click();
		if(selectionStageName.contains("-")) {
		getElement(parameterizedLocator(eleMoveApplicationToSubSelectionStage, (selectionStageName.split("-"))[0].trim(), (selectionStageName.split("-"))[1].trim())).click();
		wait.waitForPageToLoadCompletely(); }
		else {
			getElement(parameterizedLocator(eleMoveApplicationToSelectionStage,selectionStageName)).click();
			wait.waitForPageToLoadCompletely();
		}
		wait.waitForPageToLoadCompletely();
	}
	
	/**
	 * @author gupta.mansi
	 * This method returns application id from CV details page
	 * @return application id as String
	 */
	public String getApplicationId()
	{
		jsUtil.scrollToElement(eleApplicationId);
		return ((getText(eleApplicationId).split(":"))[1].split(" "))[1];
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if give feedback dd is present on CV Detail page
	 * @return true if drop down is displayed
	 */
	public boolean isGiveFeedbackDDDisplayed()
	{
		return isDisplayed(ddGiveFeeddback);
	}
	
	/**
	 * @author gupta.mansi
	 * Click on Give Feedback from CV Detail page
	 */
	public void clickOnGiveFeedbackFromCVDetailPage()
	{
		wait.waitForElementToBeClickable(ddGiveFeeddback);
		click(ddGiveFeeddback);
		
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if given button is displayed
	 * @param buttonName
	 * @return true if button is displayed
	 */
	public boolean isButtonDisplayed(String buttonName)
	{
		return isDisplayed(parameterizedLocator(btnChangeFeedback, buttonName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on given button name
	 * @param buttonName
	 */
	public void clickOnButtonForFeedback(String buttonName)
	{
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(btnChangeFeedback, buttonName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method returns true if master profile search box is displayed
	 * @return true if master profile search box is displayed else false
	 */
	public boolean verifyPresenceOfMasterProfileSearch()
	{
		return isDisplayed(advanceSearchBtn);
	}
	
	/**
	 * @author gupta.mansi
	 * This method returns text of current location
	 * @return String
	 */
	public String getCurrentLocation()
	{
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollToElement(eleCurrentLocation);
		return getText(eleCurrentLocation);
	}

}
