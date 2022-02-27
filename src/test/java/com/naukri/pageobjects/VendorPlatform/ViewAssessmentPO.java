package com.naukri.pageobjects.VendorPlatform;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.JSUtility;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.pageobjects.Assessment.AttachAssessmentPO;
import com.naukri.pageobjects.HiringManager.BulkUploadPagePO;
import com.naukri.pageobjects.Offer.OfferApprovalPagePO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

/**
 * @author abhishek.dwivedi
 *
 */
public class ViewAssessmentPO extends BaseAutomation {
	String emailId = "";
	AddASingleProfilePagePO objAddASingleProfilePage = new AddASingleProfilePagePO();
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	AttachAssessmentPO objAttachAssessment = new AttachAssessmentPO();
	OfferApprovalPagePO objOfferApprovalPagePO=new OfferApprovalPagePO();
	BulkUploadPagePO objBulkUploadPagePO=new BulkUploadPagePO();
	
	private By txtCopyToExistingRequirement = By
			.xpath("//ul[@class='DDsearch']//input[@placeholder[contains(.,'existing Requirement')]]");
	private By eleRequirementNameSuggesstion = By.xpath("//ul[@id='ul_projectList']//a[contains(.,'${reqName}')]");
	private By btnReqNameOnCVDetailPage = By.xpath("//a[@title[contains(.,'${reqName}')]]");
	private By lblTestCategory = By.xpath("//div[@class='categoryTupple']//span[contains(.,'${testName}')]/..");
	private By lblCategory = By.xpath("(//div[@class='categoryTupple'])");
	private By eleNoOfCandidateInRequirement = By.xpath("//div[@class[contains(.,'proCount')]]//a");
	private By btnAssessmentTests = By.xpath("//span[contains(.,'${AssessmentTests}')]");
	private By eleStageSelectionArow = By.xpath("//a[contains(.,'${candidateName}')]/../../../..//following-sibling::div[@class='hiringStat cle']//a//span[@class[contains(.,'outerArow')]]");
	private By eleSelectStage = By.xpath("//ul[@class[contains(.,'statusNav')]]//a[contains(.,'${Stage}')]//span[contains(.,'${subStage}')]/../..");
	private By btnTestName = By.xpath("//span[contains(.,'${testName}')]//small/../..");
	private By chkFacetsType = By.xpath("//span[contains(.,'${testName}')]/..//following-sibling::div//label[contains(.,'${facetsType}')]/input");
	private By btnAddAssessment = By
			.xpath("//div[text()='${subStageName}']//parent::li//a[@title[contains(.,'Assessment Test')]]//parent::span");
	private By lblSubStageOnSelectionStage = By.xpath("//div[@class='subName' and contains(.,'${subStageName}')]");
	private By rdofirstTest = By.xpath("(//div[@class='tableRow  ']//label)[1]");
	private By eleFacetsTypeBlock = By.xpath("//span[contains(.,'${testName}')]/..//following-sibling::div[@style[contains(.,'block;')]]");
	private By txtCandidateName = By.id("candidateName");
	private By btnSelectionStageTab = By.xpath("//a[@id='smtabStages']");
	private By ddOfSelectionStage = By.xpath("//div[text()='${selectionStage}']/..//..//div//span[@class='icon']");
	private By txtSubStageName = By.xpath("//div[text()='${helpText}']");
	private By btnAddAssessmentOnSelectionStage = By.xpath("//div[text()='${substageName}']/..//a[@title='Add Assessment Test to this selection stage']");
    private By btnPathMore = By.xpath("//a[contains(.,'More')]/em");
	private By btnPathAddSingleProfile = By.xpath("//ul[@class='subNav']//a[@class='addSingleCandidate']");
	private By txtEmail = By.xpath("//input[@id='emilBlock_0']");
	private By btnSaveCandidate = By.xpath("//input[@onclick='showPopUp();']");
	public By eleNoOfCandidateOnSRP = By.xpath("//div[@class='candDet newTuple']");
	private By btnConfigureNow=By.xpath("//button[@class='configureHangout']"); 
	private By eleInterviewTypeOption=By.xpath("//select/option[contains(.,'${interviewTypeOption}')]"); 
	private By lblConfigureYourAccount=By.xpath("//div[@class='hangoutWarning']"); 
	private By eleSetHourForInterview = By.xpath("//input[@name=\"interviewTimeHH\"]");
	private By eleSetMinutesForInterview = By.xpath("//input[@name=\"interviewTimeMM\"]");
	private By eleSetDateForInterview = By.xpath("//td[text()='${date}']");
	private By eleCalendarIconInterview = By.xpath("//a[@class=\"calendar fr\"]");
	private By txtMailSubject = By.id("mailTemplateSubject");		
	private By ddlInterviewType=By.xpath("//label[contains(.,'Interview Type:')]/..//select");
	private By eleCandidateEmailId = By.xpath("//div[@class='contactCol1']//a");
	private By txtSearchCandidateOn = By.id("keywordSearch");
	private By eleSearchIcon = By.id("searchKeyword");
	private By eleEditIcon=By.xpath("//small[@class='editIc']/..");
	AssessmentPartnerIntegrationPO objAssessmentPartnerIntegrationPO = (AssessmentPartnerIntegrationPO) PageObjectWrapper
			.getObject(AssessmentPartnerIntegrationPO.class);
	
	//VideoInterview
	private By eleSuccessMsgInterviewType = By.xpath("//div[@id='statusDataMsgDisplayDiv']//span[@class='videoHoverCard pRel']");
	private By eleInterviewType = By.xpath("//span[@class='videoHoverCard pRel']");
	private By eleSuccessMsgContactCardIcon = By.xpath("//div[@id='statusDataMsgDisplayDiv']//span[@class='videoConfDetail']");
	private By eleContactCardIcon = By.xpath("//span[@class='videoConfDetail']");
	private By eleSuccessMessageText = By.xpath("//div[@id='statusChangeMessageDiv']//span[@class='etxt']/strong");
	private By eleContactCardHeading = By.xpath("//div[@class='videoCard w265 w_bg p15']/div/b");
	private By eleMeetingURL = By.xpath("//div[@class='videoCard w265 w_bg p15']/div/span/span[contains(@class,'googleMeetingUrl')]");
	private By eleCopyLink = By.xpath("//div[@class='videoCard w265 w_bg p15']/div/span/span[contains(@class,'copyLinkUrl')]");
	private By eleContactCardSendToCand = By.xpath("//div[contains(@class,'videoCard w265 w_bg p15')]//a[text()='Send to Candidate']");
	private By eleContactCardSendToHM = By.xpath("//div[contains(@class,'videoCard w265 w_bg p15')]//a[text()='Send to Interviewer']");
	private By eleContactCard = By.xpath("//div[contains(@class,'videoCard')]");
	private By ddStatusChange = By.xpath("//span[@class=\" outerArow\"]");
	private By eleSuccessMsgFwdToHM = By.xpath("//a[@id='calendarInviteEnableForward'][text()='Forward To Hiring Manager']");
	private By btnPreviewAndSend = By.id("previewMailFromCreateLB");
	private By eleSendMailFromMailPreview = By.xpath("//input[@class='blue_btn fr previewSend']");
	private By chkboxAutomaticMailHM = By.id("sendMailToHmcb");
	private By eleAutomaticMailHMTxt = By.xpath("//label[@for='sendMailToHmcb']");
	//MailContent elements
	private By eleMailInitContent = By.xpath("//td[@id='mailBodyData']");
	private By eleMailInterviewDetails = By.xpath("//td[@id='mailBodyData']//ul/li");
	private By eleMailGoogleLink = By.xpath("//td[@id='mailBodyData']//a");
	private By lblMailBodyDataOnPreview=By.xpath("//td[@id='mailBodyData']");
	private By eleDeleteAttachedTest=By.xpath("//small[@class[contains(.,'testDelIcon')]]");
	private By btnYesOnDeleteTestPopUp=By.xpath("//input[@id='delTestSuccess']");
	private By eleNextMonthCalendar = By.xpath("//li[@class=' nav'][3]");
	public static Map<String, String> hmapMailInterviewContentFromPreview= new HashMap<String, String>();
	public static Map<String, String> hmapMailInterviewContentFromCandidateInbox = new HashMap<String, String>();
	
	/**
	 * To add basic information like name,contact and email of candidate
	 * 
	 * @author abhishek.dwivedi
	 * @param candidateName , Existing RequirementName
	 */
	public void addASingleProfileWithCandidateInfo(String candidateName, String existingRequirementName) {
		goToPageURL(YamlReader.getAppConfigValue("URLs.addSingleProfile"));
		emailId = candidateName + System.currentTimeMillis() + "@mailsac.com";
		sendKeys(objAddASingleProfilePage.candidateName_text, candidateName);
		sendKeys(objAddASingleProfilePage.email_text, emailId);
		objOfferApprovalPagePO.addRequirementToSingleProfile(existingRequirementName);
		//searchExistingRequirementOnAddCandidatePage(existingRequirementName);
		objAddASingleProfilePage.clickAddCandidateBtn();
	}

	/**
	 * This method is used to quick search requirement and click
	 * 
	 * @param reqName
	 * @author abhishek.dwivedi
	 */
	public void searchExistingRequirementOnAddCandidatePage(String reqName) {
		getElement(txtCopyToExistingRequirement).click();
		getElement(txtCopyToExistingRequirement).sendKeys(reqName);
		getElement(eleRequirementNameSuggesstion, reqName).click();
	}

	/**
	 * This method is used to click on requirement name on CV detail page
	 * 
	 * @param reqName
	 * @author abhishek.dwivedi
	 */
	public void clickReqNameOnCVDetailsPage(String reqName) {
		getElement(btnReqNameOnCVDetailPage, reqName).click();
		genericFunctions.switchToWindow();
	}

	/**
	 * This method is used to click on selection stage then click on sub stage and
	 * attach test to that sub stage
	 * 
	 * @param selection stage Name, sub stage Name, test name
	 * @author abhishek.dwivedi
	 * @return selected test name
	 */
	public String attachTestToSubStage(String selectionStage, String subStage, String testName) {
		click(btnSelectionStageTab);
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(ddOfSelectionStage, selectionStage));
		jsUtil.scrollMid(parameterizedLocator(ddOfSelectionStage, selectionStage));
		if (isDisplayed(eleDeleteAttachedTest)) {
			click(eleDeleteAttachedTest);
			click(btnYesOnDeleteTestPopUp);
			wait.hardWait(3);
			click(parameterizedLocator(ddOfSelectionStage, selectionStage));
		}
		mouseHoverAndClickToWebElement(getElement(txtSubStageName, subStage),getElement(btnAddAssessmentOnSelectionStage, subStage));
		wait.waitForPageToLoadCompletely();
		wait.hardWait(5);
		String firstTestName = clickOnTestName(testName);
		objAttachAssessment.clickOnSelect();
		objAttachAssessment.clickAttachTest();
		return firstTestName;
	}

	/**
	 * This method use to find the Test and click on it
	 * @param test name
	 * @author abhishek.dwivedi
	 * @return selected test name
	 */
	public String clickOnTestName(String testName) {
		getElement(lblTestCategory, testName).click();
		wait.waitForVisibilityOfElement(rdofirstTest);
		String FirstTest = getElement(rdofirstTest).getText();
		getElement(rdofirstTest).click();
		return FirstTest;
	}
	/**
	 *This method use to move to Requirement Inbox page using get attribute
	 * 
	 * @author abhishek.dwivedi
	 */
	public void goToRequirementInboxPage() {
		objAssessmentPartnerIntegrationPO.refreshPageAndCheckElementIsDisplayed(eleNoOfCandidateInRequirement, 5);
		jsUtil.scrollUp();
		genericFunctions.launchSpecificURL(getAttribute(eleNoOfCandidateInRequirement, "href"));
		
	}
	/**
	 *This method use to click on Facets and link on the Requirement Inbox page
	 * 
	 * @author abhishek.dwivedi
	 * @param Facets name(test not taken, Passed ,Failed etc)
	 */
	public void clickFacetsOnReqInboxPage(String facetsName) {
		getElement(btnAssessmentTests, facetsName).click();
	}
	
	/**
	 *This method use to check link on the Requirement Inbox page is visible
	 * @param Facets name(test not taken, Passed ,Failed etc)
	 * @author abhishek.dwivedi
	 * @return true/false
	 */
	public boolean isAssessmentTestsDisplayed(String facetsName) {
		return isDisplayed(btnAssessmentTests, facetsName);
				
	}

	/**
	 * This method is used to move the specific candidate to particular stage from
	 * Requirement Inbox page
	 * 
	 * 
	 * @param Candidate Name,Stage Name
	 * @author abhishek.dwivedi
	 */
	public void moveCandidateToAStageFromReqInboxPage(String candidateName, String stageName) {
		getElement(eleStageSelectionArow, candidateName).click();
		if (stageName.contains("-")) {
			String[] subStage = stageName.split("-");
			getElement(eleSelectStage, subStage[0] + "|" + " -" + subStage[1]).click();
		} else {
			getElement(eleSelectStage, stageName).click();
		}
	}

	/**
	 * This method use to click the Test name inside Assessment Tests on Requirement
	 * Inbox page
	 * 
	 * @author abhishek.dwivedi
	 * @param selected test name
	 */
	public void clickTestNameInideAssessmentTests(String testName) {
		//if (!getElement(eleFacetsTypeBlock, testName).isDisplayed()) {
			getElement(btnTestName, testName).click();
	}
	
	/**
	 * This method use to click the check box of provided facets of a Test inside
	 * Assessment Tests on Requirement Inbox page
	 * @param test name and facet name
	 * @author abhishek.dwivedi
	 * @return No of Profile visible on Inbox page
	 */
	public int clickFacetsInideTestName(String testName, String facetsName) {
		if (!isDisplayed(eleFacetsTypeBlock, testName)) {
			clickTestNameInideAssessmentTests(testName);
			wait.hardWait(5);
		}
		if (isDisplayed(chkFacetsType, testName + "|" + facetsName)) {
			getElement(chkFacetsType, testName + "|" + facetsName).click();
			wait.hardWait(5);
			wait.waitForPageToLoadCompletely();
		}
		return getElements(eleNoOfCandidateOnSRP).size();
	}
	
	/**
	 * This method is used to click attach Assessment test to given sub-stage
	 * @author abhishek.dwivedi
	 * @param subStageName
	 */
	public void addAssessmentTestToSelectionStage(String subStageName) {
		mouseHoverToWebElement(getElement(lblSubStageOnSelectionStage, subStageName));
		getElement(btnAddAssessment, subStageName).click();
		wait.hardWait(1);
	}
	
	
	/**
	 * This method adds a single profile from Requirement overview page
	 * @author abhishek.dwivedi
	 * @param Candidate Name, Candidate EmailId
	 * 
	 */
	public void addSingleProfileFromReqOverviewPage(String candidateName, String candidateEmailId) {
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		wait.hardWait(5);
		actionBuilderUtil.hoverByAction(btnPathMore);
		    wait.waitForVisibilityOfElement(btnPathAddSingleProfile);
	        getElement(btnPathAddSingleProfile).click();
	        getElement(txtCandidateName).sendKeys(candidateName);
	        getElement(txtEmail).sendKeys(candidateEmailId);
	        getElement(btnSaveCandidate).click();
	}
	/**
	 * This method use to Go to the URL to add single profile which contains a already selected Requirement 
	 *  From Requirement OverViewPage
	 * @author abhishek.dwivedi
	 * @param Candidate Name, Candidate EmailId
	 * 
	 */
	public void addCandidateFromRequirementOverViewPage(String candidateName, String candidateEmailId) {
		goToPageURL(YamlReader.getAppConfigValue("URLs.addSingleProfile")+"?projectId="+PropFileHandler.readProperty("reqId").substring(0,5));
		//wait.waitForPageToLoadCompletely();
		wait.hardWait(2);
		getElement(txtCandidateName).sendKeys(candidateName);
		getElement(txtEmail).sendKeys(candidateEmailId);
		getElement(btnSaveCandidate).click();
	}
	/**
	 *This method use to check link configure now is visible
	 * 
	 * @author abhishek.dwivedi
	 * @return true/false
	 */
	public boolean isConfigureNowDisplayed() {
		return isDisplayed(btnConfigureNow);
				
	}
	/**
	 * This method is used to click on Interview type drop down and select option
	 * 
	 * 
	 * @author abhishek.dwivedi
	 * @param option as Interview-type
	 */
	public void clickInterviewTypeAndSelect(String option) {
		click(ddlInterviewType);
		click(parameterizedLocator(eleInterviewTypeOption,option));
	}
	/**
	 *This method use to check lTo use Google Meet/Hangout, please Configure your Gsuite (or Gmail) account is visible
	 * 
	 * @author abhishek.dwivedi
	 * @return true/false
	 */
	public boolean isConfigureYourAccoutDisplayed() {
		return isDisplayed(lblConfigureYourAccount);
				
	}

	/**
	 * This method is used to set Interview date and time
	 * 
	 * 
	 * @author abhishek.dwivedi
	 * @param hour , minutes
	 */
	public void setInterviewDateTime(String hour, String minutes) {
		click(eleCalendarIconInterview);
		click(eleNextMonthCalendar);
		click(parameterizedLocator(eleSetDateForInterview, Integer.toString(((int) (Math.random()*(26))) + 1)));
		sendKeys(eleSetHourForInterview, hour);
		sendKeys(eleSetMinutesForInterview, minutes);
	}

	/**
	 * This method is used to get the subject of the Mail
	 * 
	 * 
	 * @author abhishek.dwivedi
	 * @return subject of the Email popup
	 */
	public String getTextMailSubject() {
		return getAttribute(txtMailSubject, "value");
	}

    /**
     * This method is use to get the email id from the cv detail page
     *
     * @author abhishek.dwivedi
     * @return candidate emailid
     */
    public String getTextEmailIdFromCVDetailPage(){
        return getText(eleCandidateEmailId);	
    }
    /**
     * This method is use to enter detail on search box
     *
     * @author abhishek.dwivedi
     * @param text to be searched
     */
    public void enterDetailInSearchBox(String searchText){
        sendKeys(txtSearchCandidateOn, searchText);
        click(eleSearchIcon);
        objAssessmentPartnerIntegrationPO.refreshPageAndCheckElementIsDisplayed(eleEditIcon, 2);
    }
    
    /**
     * This method is click edit icon on Application inbox page wrt to candidate
     *
     * @author abhishek.dwivedi
     */
    public void clickOnEditIcon(){
        click(eleEditIcon);
    }
    
    // VideoInterview
    /**
     * This method is used to verify Interview type in success message 
     * @author ambar.gupta
     * @param Expected Interview type
     * @return whether expected Interview type found or not
     */
    public boolean verifyInterviewType(String interviewType){
    	String actual[] = getText(eleInterviewType).split("\\|");
    	return actual[1].trim().equalsIgnoreCase(interviewType);
    }
    
    /**
     * This method is used to verify Contact card for Hangout present or not
     * @author ambar.gupta
     * @return whether Contact card for Hangout present or not
     */
    public boolean verifyPresenceOfContactCard(){
    	hover(eleContactCardIcon);
    	return isDisplayed(eleContactCard);
    }

    /**
     * This method is used to verify heading of Contact card for Hangout 
     * @author ambar.gupta
     * @return whether heading of Contact card for Hangout correct or not
     */
	public boolean verifyContactCardHeading(String heading) {
		return getText(eleContactCardHeading).trim().equals(heading);
	}

	/**
     * This method is used to verify heading of Contact card for Hangout 
     * @author ambar.gupta
     * @return whether heading of Contact card for Hangout correct or not
     */
	public String getContactCardInterviewLink() {
		return getText(eleMeetingURL).trim();
	}

	/**
     * This method is used to verify heading of Contact card for Hangout 
     * @author ambar.gupta
     * @return whether heading of Contact card for Hangout correct or not
     */
	public boolean verifyContactCardCopyLink() {
		return isDisplayed(eleCopyLink);
	}

	/**
     * This method is used to click Send To Candidate From Contact Card
     * @author ambar.gupta
     */
	public void clickSendToCandidateFromContactCard() {
		click(eleContactCardSendToCand);
	}
	
	/**
     * This method is used to click Send To Interviewer From Contact Card
     * @author ambar.gupta
     */
	public void clickSendToInterviewerFromContactCard() {
		click(eleContactCardSendToHM);
	}
    
	/**
     * This method is used to verify presence of Send to candidate and Send to Interviewer button on Contact card
     * @author ambar.gupta
     * @return Presence of Send to candidate and Send to Interviewer button on Contact card in true or false
     */
	public boolean verifySendLinksOnContactCard(String option) {
		switch(option) {
		case "Send to Candidate":
			return isDisplayed(eleContactCardSendToCand);
		case "Send to Interviewer":
			return isDisplayed(eleContactCardSendToHM);
		default:{
			TestNGLogUtility.info("Wrong Input");
			return false;
		}
		}
	}

	/**
     * This method is used to verify presence of Success message
     * @author ambar.gupta
     * @return Presence of Success message in true or false
     */
	public boolean verifyPresenceOfSuccessMsg() {
		return isDisplayed(eleSuccessMessageText);
	}
	
	/**
     * This method is used to refresh page until element found up to given max count 
     * @author ambar.gupta
     */
	public void refreshPageUntilCandidateVisible() {
		objAssessmentPartnerIntegrationPO.refreshPageAndCheckElementIsDisplayed(ddStatusChange, 5);
	}
    
	/**
     * This method is used to click Forward To HM From SuccessMessage strip
     * @author ambar.gupta
     */
	public void clickFwdToHMFromSuccessMessage() {
		click(eleSuccessMsgFwdToHM);
	}
	
	/**
     * This method is used to get  all mail content from PersonalMailBox in a hashmap
     * @author abhishek.dwivedi
     * 
     * @return Map with mail content as key value pairs
     */
	public Map<String, String> getContentFromPersonalMailBox() {
		Map<String, String> hmapMailToInterviewerContent= new HashMap<String, String>();
		hmapMailToInterviewerContent.put("MailBody", getText(lblMailBodyDataOnPreview).toString());
		return hmapMailToInterviewerContent;
	}
	
	/**
     * This method is used to get  mail Interview details in a hashmap
     * @author ambar.gupta
     * @param the source of getting Interview details like mail preview window
     * @return Map with mail content as key value pairs
     */
	public Map<String, String> getEmailDetailsToInterviewer(String MailDetailsSource) {
		Map<String, String> hmapMailToInterviewerContent;
		hmapMailToInterviewerContent = new HashMap<String, String>();
		List<WebElement> InterviewDetails=new ArrayList<WebElement>();
		InterviewDetails = getElements(eleMailInterviewDetails);
		for (WebElement IntDetail : InterviewDetails)
		{
			String detail[] = IntDetail.getText().split(": ");
			hmapMailToInterviewerContent.put(detail[0].trim(), detail[1].trim());
		}
		hmapMailToInterviewerContent.put("Hangout Link", getText(eleMailGoogleLink).trim());
		if(MailDetailsSource.equalsIgnoreCase("MailPreview")) {
			 hmapMailInterviewContentFromPreview = hmapMailToInterviewerContent;
			 return hmapMailInterviewContentFromPreview;
		}
		else{
			hmapMailInterviewContentFromCandidateInbox = hmapMailToInterviewerContent;
			 return hmapMailInterviewContentFromCandidateInbox;
		}}
		
	
		/**
	     * This method is used to compare two maps 
	     * @author ambar.gupta
	     * @param two Maps to compare
	     * @return Whether Maps are equal or not
	     */
		public boolean compareTwoHashMaps(Map<String, String> hm1, Map<String, String> hm2)
	    {
			return hm1.equals(hm2);
	    }
		
		/**
	     * This method is used to compare forward Mail Preview with Candidate Personal MailBox
	     * @author ambar.gupta
	     * @return Whether content is same or not
	     */
		public boolean verifyforwardMailPreviewwithCandidatePersonalMailBox()
	    {
			TestNGLogUtility.info("Mail Content From Preview Mail");
			hmapMailInterviewContentFromPreview.forEach((k, v) -> {
	            TestNGLogUtility.info(k + ": " + v);
			});
	        TestNGLogUtility.info("Mail Content From CAndidate Mailbox");
	        hmapMailInterviewContentFromCandidateInbox.forEach((k, v) -> {
		        TestNGLogUtility.info(k + ": " + v);
	        });
	        return compareTwoHashMaps(hmapMailInterviewContentFromPreview, hmapMailInterviewContentFromCandidateInbox);
	    }
		 
	/**
     * This method is used to click on Send and Preview button
     * @author ambar.gupta
     */
	public void clickOnSendAndPreview() {
		jsUtil.scrollDown(btnPreviewAndSend);
		click(btnPreviewAndSend);
	}
	
	/**
     * This method is used to click on Send mail from Mail Preview window
     * @author ambar.gupta
     */
	public void clickSendMailFromMailPreview() {
		jsUtil.scrollDown(eleSendMailFromMailPreview);
		click(eleSendMailFromMailPreview);
		jsUtil.scrollUp();
	}
	
	/**
     * This method is used to launch HTML content on browser for windows and linux
     * @author ambar.gupta
     * @param HTML content as string
     */
	public void openHTMlinBrowser(String content, String fileName) {
		String StorageFileLocation = System.getProperty("user.dir") + File.separator + fileName;
		TestNGLogUtility.info("URL: "+StorageFileLocation);
		String osName = System.getProperty("os.name");
		TestNGLogUtility.info("OS Name: "+osName);
		jsUtil.executeJavascript("window.open()");
		switchToChildWindow();
		if(osName.toLowerCase().contains("win"))
			goToPageURL("file:\\"+StorageFileLocation);
		else
			goToPageURL("data:text/html;charset=utf-8," + content);
	}		
    
	/**
	 * This method is used to launch HTML content on browser for windows and linux
	 * 
	 * @author abhishek.dwivedi
	 * @param HTML content as string
	 * @return Mail preview data in hashMap
	 */
	public Map<String, String> openHTMlinBrowserAndGetContent(String content) {
		Map<String, String> hmapPersonalMailBoxPreview = new HashMap<String, String>();
		String StorageFileLocation = System.getProperty("user.dir") + File.separator + "VideoInterviewMailContent.html";
		TestNGLogUtility.info("URL: " + StorageFileLocation);
		String osName = System.getProperty("os.name");
		TestNGLogUtility.info("OS Name: " + osName);
		jsUtil.executeJavascript("window.open()");
		switchToChildWindow();
		if (osName.toLowerCase().contains("win")) {
			goToPageURL("file:\\" + StorageFileLocation);
			hmapPersonalMailBoxPreview = getContentFromPersonalMailBox();
			closeWindow();
			switchToParentWindow();
			return hmapPersonalMailBoxPreview;
		} else {
			goToPageURL("data:text/html;charset=utf-8," + content);
			hmapPersonalMailBoxPreview = getContentFromPersonalMailBox();
			closeWindow();
			switchToParentWindow();
			return hmapPersonalMailBoxPreview;
		}
	}
	
	/**
     * This method is used to update Hangout Link in hashMap if changed on updation in Interview details
     * @author ambar.gupta
     * @param New Hangout link
     * @return Whether link has been changed or not
     */
	public boolean updateHangoutLinkInhashMap(String hangoutLink) {
		String oldLink = hmapMailInterviewContentFromPreview.get("Hangout Link");
		TestNGLogUtility.info("Old Link :"+oldLink);
		TestNGLogUtility.info("New Link :"+hangoutLink);
		if(oldLink != hangoutLink) {
			hmapMailInterviewContentFromPreview.put("Hangout Link", hangoutLink);
			TestNGLogUtility.info("Updated Link :"+hmapMailInterviewContentFromPreview.get("Hangout Link"));
			return true;
		}
		else
			return false;		
	}   
	
	/**
     * This method is used to uncheck if automatic mail to HM checkbox is checked
     * @author ambar.gupta
     * @return Whether Automatic mailer to HM checkbox is unchecked or not
     */
	public boolean UncheckAutomaticMailerToHMCheckboxInSettings() {
		TestNGLogUtility.info("Automatic Mailer To HM Checkbox check status: "+getElement(chkboxAutomaticMailHM).isSelected());
		if(getElement(chkboxAutomaticMailHM).isSelected()) {
		    click(eleAutomaticMailHMTxt);
			TestNGLogUtility.info("Automatic Mailer To HM Checkbox check status: "+getElement(chkboxAutomaticMailHM).isSelected());
		}
		return !getElement(chkboxAutomaticMailHM).isSelected();
	}   
	
	/**
     * This method is used to check if automatic mail to HM checkbox is checked
     * @author ambar.gupta
     * @return Whether Automatic mailer to HM checkbox is unchecked or not
     */
	public boolean checkAutomaticMailerToHMCheckboxInSettings() {
		TestNGLogUtility.info("Automatic Mailer To HM Checkbox check status: "+getElement(chkboxAutomaticMailHM).isSelected());
		if(!getElement(chkboxAutomaticMailHM).isSelected()) {
		    click(eleAutomaticMailHMTxt);
			TestNGLogUtility.info("Automatic Mailer To HM Checkbox check status: "+getElement(chkboxAutomaticMailHM).isSelected());
		}
		return !getElement(chkboxAutomaticMailHM).isSelected();
	}
}