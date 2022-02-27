package com.naukri.pageobjects.Vendor;

import com.naukri.automation.util.*;
import com.naukri.pageobjects.Offer.OfferGenerationPagePO;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryRuleSettingsPO;
import com.naukri.pageobjects.CandidateCommunication.MailBoxTabPO;
import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.naukri.test.base.BaseAutomation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

public class VendorSubmissionPO extends BaseAutomation {

	public  By assignVendor = By.xpath("//a[text()='Assign Vendor']");
	public  By selectVendors = By.xpath("//span[text()='Select Vendors']");
	public  By searchHere = By.xpath("//input[@placeholder='Search here']");
	public  By maxCv = By.xpath("//input[@placeholder='Add CV submission limit']");

	public By eleVendorSubmissionRequirementName = By.xpath("//a[contains(text(),'${requirement}')]");
	public By btnVendorSubmissionAssign = By.xpath("//button[contains(@class,'save blockBtn')]");
	public By eleVendorSubmissionVendor = By.xpath("//div[contains(text(),'${vendorname}')]");
	public By eleVendorSubmissionClientPortalRequirementName = By.xpath("//a[contains(text(),'${reuirementname}')]");
	public By eleVendorSubmissionPipeline = By.xpath("//div[@class='stgCont']//span[@class='stgNm']");

	public By eleVendorSubmissionSubmitCandidate = By.xpath("//div[@class='vendors']//div[@class='cle']//div[1]//a");
	public By lblVendorSubmissionVendorSuccess = By.xpath("//span[contains(text(),'${successmessage}')]");
	public By txtVendorSubmissionCandidateEmail = By.xpath("//input[@name='SM-PRIMARYEMAIL']");
	public By txtVendorSubmissionCandidateCompany = By.xpath("//input[@name='EX-CURR_EMP_NAME']");
	public By txtVendorSubmissionCandidateDesignation = By.xpath("//input[@name='EX-CURR_EMP_DESIGNATION']");
	public By eleVendorSubmissionSelectDDValue = By.xpath("//div[@class='select-list']//div//ul//li[1]");

	public By eleVendorSubmissionStagingName = By.xpath("//a[contains(text(),'${Vendorlulwjk}')]//following::div[@class='reqFooter']//button");
	public By btnVendorSubmissionSubmitCandidate = By.xpath("//a[contains(text(),'Submit Candidates')]");
	public By msgSubmitCandidate = By.xpath("//div[@class='msg']");
	public By btnCandidateProfileSubmit = By.xpath("//button[contains(text(),'SUBMIT CANDIDATE')]");
	public By eleClickDropDown = By.xpath("// span[text()='${ddname}']");
	public By txtCandidateName = By.xpath("//input[@placeholder=\"Enter Candidate's Name\"]");

	public By txtCandidateEmail = By.xpath("//input[@placeholder='Type email address']");
	public By btnAddCandidate = By.xpath("//input[contains(@class,'red_btn fl')]");
	public By eleRequirementLink = By.xpath("//div[@class='pb5 pt5']//a");
	public By txtRequirementTitle = By.xpath("//input[@id='projectName']");
	public By linkAddNew=By.xpath("//a[@id='createNProject']");

	public By eleVenueForInterview = By.xpath("//input[@name=\"VENUE\"]");
	public By eleCalendarIconInterview = By.xpath("//a[@class=\"calendar fr\"]");
	public By eleSetDateForInterview = By.xpath("//td[@class=\"currDate\"]");
	public By eleSetMinutesForInterview = By.xpath("//input[@name=\"interviewTimeMM\"]");

	public By eleSetHourForInterview = By.xpath("//input[@name=\"interviewTimeHH\"]");
	public By btnSetInterviewStage = By.xpath("//a[@class='red_btn fl']");
	public By textCandidateName=By.xpath("//div[@class='sectionBody w400 SM-NAME']//input");
	public By listSelectSource=By.id("subSourceId");
	public By vendorName=By.xpath("//option[contains(text(),'${vemdorname}')]");
	public By eleCandidateName=By.xpath("//a[contains(text(),'${Vendorgowwbq}')]");
	public By eleVendorOptions=By.xpath("//span[contains(text(),'${option}')]");
	public By textMessageTab=By.xpath("//textarea[@class='msgBox']");
	public By eleMessageVerify=By.xpath("//div[contains(text(),'${message}')]");
	public By eleSubHeadingInsideTab=By.xpath("//strong[contains(text(),'${subheading}')]");
	public By eleInfoByRecruiter=By.xpath("//span[contains(text(),'${info}')]");
	public By eleMessageOnVendorPortal=By.xpath("//div[contains(text(),'${message}')]");
	public By elePlaceHolderText=By.xpath("//textarea[@placeholder='${msgBox}']");
	public By eleVenCandidateName=By.xpath("//a[contains(text(),'${CandidateName}')]");
	public By eleEmployer=By.xpath("//div[contains(text(),'${NAUKRI RMS}')]");
	public By eleVendorSubmitted=By.xpath("//span[contains(text(),'${Submitted}')]");
	public By eleCalendarIcon=By.xpath("//i[@id='calendarIcon']");
	public By eleCalendarDay=By.xpath("//div[contains(text(),'${day}')]");
	public By eleVendorMobileno=By.xpath("//input[@name='SM-PRIMARYPHONE']");
	public By eleMessageIcon=By.xpath("//a[contains(text(),'${candidateName}')]//following::div[@class='fr p5 crsrPtr']");

	public By eleDetailsForVendor=By.xpath("//div[contains(text(),'${Vendor Messages}')]");
	public By eleVendorBoxMessage=By.xpath("//textarea[@placeholder='${Type your message to vendor}']");
	public By eleTextArea= By.xpath("//textarea[@class='msgBox']");
	public By eleNotificationVendor=By.xpath("//div[@class='notifBody row']//p[contains(text(),'${notification}')]");
	public By eleMore=By.xpath("//footer[contains(text(),'MORE')]");
	public By txtCompanyName = By.id("companyName");








	GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper.getObject(AssessmentPartnerIntegrationPO.class);
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);

	public String CandidateName="Null",candidateName = "",VendorCanMail,VendorCanMobileNo,day,VendorCanDesignation;



	/**
	 * To submit the details of candidate from vendor portal
	 * @author avani
	 */
	public void vendorFormSubmit() throws Exception {
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		vendorFormNameDesignationDetails();
		vendorFormEducationDetails();
		DOBOfVendorCandidate();
		wait.waitForPageToLoadCompletely();
		click(btnCandidateProfileSubmit);
		wait.waitForPageToLoadCompletely();

	}
	/**
	 * To provide DOB while submitting vendor candidate
	 * @author avani
	 */
	public void DOBOfVendorCandidate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d");
		LocalDateTime now = LocalDateTime.now().plusDays(1);
		day=dtf.format(now);
		scrollToElement(eleCalendarIcon);
		click(eleCalendarIcon);
		scrollToElement(parameterizedLocator(eleCalendarDay,day));
		click(parameterizedLocator(eleCalendarDay,day));
	}

	/**
	 * This message is use to provide vendor name,phone no,email,company,designation
	 * @author avani
	 */
	public void vendorFormNameDesignationDetails(){
		CandidateName="Vendor"+""+(CommonAction.generateRandomStrings(6, "String"));
		VendorCanMail = (CommonAction.generateRandomStrings(10, "Alphanumeric")) + ("@mailsac.com");
		VendorCanMobileNo= (CommonAction.generateRandomStrings(10, "Number"));
		VendorCanDesignation = ("VcanDeg" + CommonAction.generateRandomStrings(10, "Alphanumeric"));
		PropFileHandler.writeProperty("VendorCandidateName",CandidateName);
		sendKeys(textCandidateName,CandidateName);
		sendKeys(txtVendorSubmissionCandidateEmail, VendorCanMail);
		sendKeys(eleVendorMobileno,VendorCanMobileNo);
		sendKeys(txtVendorSubmissionCandidateDesignation,VendorCanDesignation);
	}
	/**
	 *This methos is use to provide education details of candidate
	 * @author avani
	 */
	public void vendorFormEducationDetails(){
		clickDropDown("Select UG Course");
		click(eleVendorSubmissionSelectDDValue);
		clickDropDown("Select PG Course");
		click(eleVendorSubmissionSelectDDValue);
	}
	/**
	 * This method is used to add single profile and create new requirement
	 * @param vendorRequirementname
	 * @author avani
	 */
	public void addSingleProfileWithRequirement(String vendorRequirementname) {
		genericFunction.launchSpecificURL(PropFileHandler.readProperty("AddSingleProfile"));
		String CandidateName = "Candidate"+" "+CommonAction.generateRandomStrings(10, "String");
		String CandidateEmail = (CommonAction.generateRandomStrings(10, "Alphanumeric")) + ("@mailsac.com");
		sendKeys(txtCandidateName, CandidateName);
		sendKeys(txtCandidateEmail, CandidateEmail);
		click(linkAddNew);
		sendKeys(txtRequirementTitle,vendorRequirementname);
		setSource();
		click(btnAddCandidate);
		click(eleRequirementLink);
		genericFunction.switchToWindow();
	}

	/**
	 * This method is used to add the source to a requirement
	 * @author avani
	 */
	public void setSource(){
		click(listSelectSource);
		click(parameterizedLocator(vendorName,PropFileHandler.readProperty("VendorNameFull")));
	}
	/**
	 * This method use to verify candidate submission success message
	 * @return true if able to see success message
	 * @author avani
	 */
	public boolean verifyCandidateSubmitSuccessfully() {
		String successMessage = getElement(msgSubmitCandidate).getText();

		return(successMessage.equalsIgnoreCase(PropFileHandler.readProperty("VendorCandidateSubmissionSuccessmessage")));
	}

	/**
	 * This method use to select specific requirement
	 * @param vendorRequirement
	 * @author avani
	 */
	public void selectSpecificRequirement(String vendorRequirement) {
		genericFunction.launchSpecificURL(PropFileHandler.readProperty("ProjectList"));
		click(parameterizedLocator(eleVendorSubmissionRequirementName,vendorRequirement));
		genericFunction.switchToWindow();
	}

	/**
	 * To click on the drop downs on submission page
	 * @param ddName : text name of drop down
	 * @author avani
	 */
	public void clickDropDown(String ddName) {
		jsUtil.scrollDown(parameterizedLocator(eleClickDropDown, ddName));
		click(parameterizedLocator(eleClickDropDown, ddName));
	}
	/**
	 * This method use to add requirement to Vendor
	 * @author avani
	 */
	public void addRequirementToVendor() {
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		getElement(assignVendor).click();
		wait.waitForPageToLoadCompletely();
		getElement(selectVendors).click();
		getElement(searchHere).sendKeys(PropFileHandler.readProperty("VendorNameFull"));
		getElement(eleVendorSubmissionVendor, PropFileHandler.readProperty("VendorNameFull")).click();
		getElement(maxCv).sendKeys("10");
		click(btnVendorSubmissionAssign);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method use to check the success message after assigning Vendor by Employer
	 * @author avani
	 */
	public boolean verifyTheSuccessMessage() {
		wait.waitForPageToLoadCompletely();
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		String VendorSubmissionVendorSuccess = PropFileHandler.readProperty("VendorSubmissionSuccessmesage");
		return (isDisplayed(lblVendorSubmissionVendorSuccess, VendorSubmissionVendorSuccess));
	}

	/**
	 * This method use to submit candidate from vendor portal under specific requirement
	 * @author avani
	 */

	public void verifyRequirementAndMoveToSubmitCandidate() {
		click(btnVendorSubmissionSubmitCandidate);
		genericFunction.switchToWindow();

	}


	/**
	 * This method use to select specific requirement on list of requirement page
	 * @param vendorRequirementname
	 * @author avani
	 */
	public void selectSpecificRequiremnetOnListPage(String vendorRequirementname){
		click(parameterizedLocator(eleVendorSubmissionClientPortalRequirementName,vendorRequirementname));
		genericFunction.switchToWindow();
	}
	/**
	 * This method use to login to Vendor Portal
	 * @author avani
	 */
	public void VendorLogin(){
		String logout = getAppConfigValue("URLs.RMSLogout");
		String vendorPortalUrl = getAppConfigValue("URLs.baseURL") + "/vendorportal/" + ReadWritePropertyFile.getProperty("clientId", VendorPortalPO.vendorPortalFile);
		commonActions.loginToRMS(logout,getAppConfigValue("Users.Vendor.VendorUsername"), getAppConfigValue("Users.Vendor.VendorPassword"));
		commonActions.navigateToUrl(vendorPortalUrl);

	}

	/**
	 * This method use to select specific requirement on Vendor portal
	 * @param vendorRequirementname
	 * @author avani
	 */
	public void selectSpecificRequirementOnVendorPortal(String vendorRequirementname){
		getElement(eleVendorSubmissionRequirementName, vendorRequirementname).click();
		genericFunction.switchToWindow();
		if(waitForTheElementToVisible(vendorRequirementname));
		TestNGLogUtility.info("Selected specific requirement");

	}

	/**
	 * This method use to click on the count of submitted application against the particular vendor
	 * @author avani
	 */
	public void clickOnApplicationCount() {
		click(parameterizedLocator(eleVendorSubmissionSubmitCandidate,PropFileHandler.readProperty("vendorName")));
		genericFunction.switchToWindow();
		pageRefresh();
		wait.waitForPageToLoadCompletely();
	}
	/**
	 * This method use to wait for the  candidate added by vendor on SRP page
	 * @author avani
	 */

	public boolean waitForTheApplicationOnSRPPage(){
		boolean result=API.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(eleCandidateName,CandidateName),10);
		return result;
	}
	/**
	 * This method use to click on candidate profile added by vendor on SRP page
	 * @author avani
	 */
	public void clickOnProfileOnSRPPage(){
		click(parameterizedLocator(eleCandidateName,CandidateName));
		genericFunction.switchToWindow();
	}


	/**
	 * This method use to set interview details
	 * @author avani
	 */
	public void setInterviewDetails() {
		scheduleInterview("Noida", "11", "11");
		clickOnsetInterviewStage();
	}
	/**
	 * This method use to schedule interview
	 * @param hour,minutes,venue
	 * @author avani
	 */
	public void scheduleInterview(String venue, String hour, String minutes) {
		sendKeys(eleVenueForInterview, venue);
		click(eleCalendarIconInterview);
		click(eleSetDateForInterview);
		sendKeys(eleSetHourForInterview, hour);
		sendKeys(eleSetMinutesForInterview, minutes);
	}
	/**
	 * This method use to click on Set button
	 * @author avani
	 */
	public void clickOnsetInterviewStage() {
		click(btnSetInterviewStage);
	}


	/**
	 * This method use to check pipeline of candidate from Vendor portal for specific requirement
	 * @param vendorCandidateName,Stging
	 * @author avani
	 */

	public boolean verifyUpdatedStagingInPipeline(String vendorCandidateName, String StagingName) {
		System.out.println(getText(parameterizedLocator(eleVendorSubmissionStagingName,vendorCandidateName)) + "" + StagingName);
		return(getText(parameterizedLocator(eleVendorSubmissionStagingName,vendorCandidateName)).equalsIgnoreCase(StagingName));
	}
	/**
	 * To Verify requirement option for vendor
	 * @return It will return true if tab exist
	 * @author avani
	 */
	public boolean verifyRequirementDetailsTab(String options) {
//		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(eleVendorOptions,options));
	}

	/**
	 * To Verify message option for vendor
	 * @return It will return true if tab exist
	 * @author avani
	 */
	public boolean verifyMessageTab(String options) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(eleVendorOptions,options));
	}

	/**
	 * To Verify instructions option for vendor
	 * @return It will return true if tab exist
	 * @author avani
	 */
	public boolean verifyInstructionsTab(String options) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(eleVendorOptions,options));
	}

	/**
	 * To Verify questionnaire option for vendor
	 * @return It will return true if tab exist
	 * @author avani
	 */
	public boolean verifyQuestionnaireTab(String options) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(parameterizedLocator(eleVendorOptions,options));
	}

	/**
	 * To Verify options available on Vendor Protal Overview page are clickable
	 * @param options
	 * @author avani
	 */
	public void verifyOptionsIsClickableOnVendorRequirementOverviewPage(List<String> options){
		wait.waitForPageToLoadCompletely();
		for(int i=0;i<options.size();i++){
			click(parameterizedLocator(eleVendorOptions,options.get(i)));
		}

	}
	/**
	 * This method is used to send message from vendor portal
	 * @param message
	 * @author avani
	 */

	public void sendMessageFromVendorPortal(String message){
		wait.waitForPageToLoadCompletely();
		sendKeys(textMessageTab,message);
	}
	/**
	 * This method is used verify sent message on vendor portal
	 * @param messageVerify
	 * @author avani
	 */
	public boolean userVerifyTheMessageSent(String messageVerify){
		wait.waitForPageToLoadCompletely();
		return(isDisplayed(parameterizedLocator(eleMessageVerify,messageVerify)));
	}

	/**
	 * This method is used verify subheading inside the tabs available on VendorPortal Requirement Overview Page
	 * @param name
	 * @return true if subheading is present else false
	 * @author avani
	 */
	public boolean userVerifySubHeadingInsideTheTab(String name){
		wait.waitForPageToLoadCompletely();
		return(isDisplayed(parameterizedLocator(eleSubHeadingInsideTab,name)));
	}
	/**
	 * This method is used verify info sent by the recruiter inside the Instructions tab on Vendor Portal Requirement Overview page
	 * @param Info
	 * @return true if info is same as recruiter has sent  else false
	 * @author avani
	 */
	public boolean userVerifyInformationSentByrecruiterInsideTheTab(String Info){
		wait.waitForPageToLoadCompletely();
		return(isDisplayed(parameterizedLocator(eleInfoByRecruiter,Info)));

	}
	/**
	 * This method is used verify info sent by the recruiter inside the Message tab on Vendor Portal Requirement Overview page
	 * @param Info
	 * @return true if info is same as recruiter has sent else false
	 * @author avani
	 */
	public boolean userVerifyInformationSentByrecruiterInsideTheMessageTab(String Info){
		wait.waitForPageToLoadCompletely();
		return(isDisplayed(parameterizedLocator(eleMessageOnVendorPortal,Info)));
	}
	/**
	 * This method is used verify the placeholder value for message textbox inside the Message tab on Vendor Portal Requirement Overview page
	 * @param message
	 * @return true if placeholder value of message textbox is same as expected
	 * @author avani
	 */

	public boolean verifyPlaceholderMessageInsideTextBoxOnVendorPortal(String message){
		wait.waitForPageToLoadCompletely();
		return(isDisplayed(parameterizedLocator(elePlaceHolderText,message)));
	}

	/**
	 * This method is used  refresh the page till the time submitted candidate is not displayed on Requirement Overview page
	 * @return true if candidate is displayed
	 * @author avani
	 */
	public boolean refreshTillTheCandidateIsNotDisplayed( ) {
		return(API.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(eleVenCandidateName,CandidateName),10));
	}

	/**
	 * This method is used  to click on connected Employer From GNB
	 * @param employerName
	 * @author avani
	 */
	public void clickEmployer(String employerName){
		click(parameterizedLocator(eleEmployer,employerName));
	}
	/**
	 * This method is used  to click on Employer name on vendorPortal
	 * @param name
	 * @author avani
	 */
	public void clickOnNaukriRMS(String name){
		click(parameterizedLocator(eleVenCandidateName,name));
	}
	/**
	 * This method is used  to click on submitted profiles on vendorportal
	 * @param name
	 * @author avani
	 */
	public void clickOnSubmitted(String name){
		click(parameterizedLocator(eleVendorSubmitted,name));
		genericFunction.switchToWindow();
	}

	/**
	 * This method is used  to click on submitted candidate name on vendorSrp page on vendorportal
	 * @author avani
	 */
	public void clickOnSubmittedCandidateName(){
		click(parameterizedLocator(eleVenCandidateName,PropFileHandler.readProperty("VendorCandidateName")));
		genericFunction.switchToWindow();
		TestNGLogUtility.info("Clicked on Submitted Candidate name-->"+PropFileHandler.readProperty("VendorCandidateName"));

	}
	/**
	 * This method is used  to click on message icon present on the candidate tuple on SRP page of vendorPortal
	 * @author avani
	 */
	public void clickOnMessageIconOnSRPPage(){
		click(parameterizedLocator(eleMessageIcon,PropFileHandler.readProperty("VendorCandidateName")));
		TestNGLogUtility.info("Clicked on message icon for the candidate->"+PropFileHandler.readProperty("VendorCandidateName"));

	}

	/**
	 * This method is used  to verify Details if the Employer Message/Vendor Message on both recruiter and
	 * at vendor end displayed or not
	 * @param name
	 * @return if details are matched returns true else false
	 * @author avani
	 */
	public boolean verifyDetailsOnCvDetailsPage(String name){
		return(isDisplayed(parameterizedLocator(eleDetailsForVendor,name)));
	}
	/**
	 * This method is used  to verify if the correct message is displayed in placeholder of message box
	 * @param message
	 * @return if message is correct returns true else false
	 * @author avani
	 */
	public boolean verifyMessageInPlaceholder(String message){
		return(isDisplayed(parameterizedLocator(eleVendorBoxMessage,message)));
	}
	/**
	 * This method is used  to click on message box present on cv details page
	 * @param message
	 * @author avani
	 */
	public void clickOnMessageBox(String message) {
		click(parameterizedLocator(eleVendorBoxMessage, message));

	}
	/**
	 * This method is used  to send message to recruiter
	 * @param message
	 * @author avani
	 */
	public void sendMessageToRecruiter(String message){
		sendKeys(eleTextArea,message);
	}
	/**
	 * This method is used  to verify message sent to recruiter
	 * @param message
	 * @return if message is correct returns true else false
	 * @author avani
	 */
	public boolean verifyMessageSentToRecruiter(String message){
		return(isDisplayed(parameterizedLocator(eleDetailsForVendor,message)));
	}
	/**
	 * This method is used  to verify message sender name
	 * @param SenderNameDetails
	 * @return if sendername is correct returns true else false
	 * @author avani
	 */
	public boolean verifySenderNameOnCvDetailsPage(String SenderNameDetails){
		return(isDisplayed(parameterizedLocator(eleInfoByRecruiter,SenderNameDetails)));
	}
	/**
	 * This method is used  to verify message count
	 * @param number
	 * @return if sendername is correct returns true else false
	 * @author avani
	 */
	public boolean verifyTheCountOfMessages(String number){
		return(isDisplayed(parameterizedLocator(eleDetailsForVendor,number)));
	}
	/**
	 * This method use to wait for the particular element on the page
	 * @author avani
	 */

	public boolean waitForTheElementToVisible(String ElementName){
		boolean result=API.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(eleMessageOnVendorPortal,ElementName),10);
		return result;
	}

	/**
	 * This method use to refresh the page the page till the time candidate is not displayed
	 * @return true when candidate is displayed
	 * @author avani
	 */
	public boolean refreshTillTheTimeVendorCandidateIsNotDisplayed(){
		return(API.refreshPageAndCheckElementIsDisplayed(parameterizedLocator(eleEmployer,PropFileHandler.readProperty("VendorCandidateName")),10));

	}
	/**
	 * This method use to verify employername on cv details page
	 * @return true when employer name is correct
	 * @author avani
	 */

	public boolean verifyEmployerNameOnCvDetailsPage(String EmployerName){
		return(isDisplayed(eleCalendarDay,EmployerName));
	}
	/**
	 * This method use to verify employername on srp page
	 * @return true when employer name is correct
	 * @author avani
	 */
	public boolean verifyEmployerNameOnSRPPage(String EmployerName){
		return(isDisplayed(eleInfoByRecruiter,EmployerName));
	}

	/**
	 * This method use to verify notification from vendor end on recruiter dashboard
	 * @return true when notification is displayed
	 * @author avani
	 */
	public boolean verifyNotificationForVendor(String notificationName){
		return(isDisplayed(parameterizedLocator(eleNotificationVendor,notificationName)));
	}
	/**
	 * This method use to click on more link on dahsboard notification section
	 * @author avani
	 */
	public void clickOnMoreNotificationRMSDashboard(){
		click(eleMore);
	}
	/**
	 * This method use to click on vendor's notification at recruiter's end in dashboard notification
	 * @author avani
	 */
	public void clickOnNotificatioRecievedWhenVendorSendMessage(String notificationName){
		click((parameterizedLocator(eleNotificationVendor,notificationName)));

	}
	/**
	 * This method use to change the company name
	 * @author avani
	 */
	public void changeCompanyName(String companyName){
		sendKeys(txtCompanyName,companyName);
	}

}