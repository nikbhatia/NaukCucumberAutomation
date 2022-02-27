package com.naukri.pageobjects.VendorPlatform;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.naukri.test.base.BaseAutomation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.naukri.automation.util.*;
import com.naukri.test.base.PageObjectWrapper;

/**
 * 
 * @author ambar.gupta
 *
 */
public class AssessmentFeaturesOnSrpAndCVDetailsPO extends BaseAutomation {

	private final By eleSendAssessmentDD = By.id("sendAssessmentButton");
	private final By eleSendNewAssessment = By.xpath("//li/a[text()='Send a New Assessment']");
	private final By eleAttachNewAssessment = By.xpath("//li/a[text()='Attach New Assessment']");
	private final By eleSEndDDTest = By.xpath("//li/a[text()='${testName}']");
	private final By btnConfirmationBox = By.xpath("//button[text()='${response}']");
	private final By btnDisabledSend = By.xpath("//button[text()='${response}'][contains(@class,'disable')]");
	private final By chkboxConfirmationBoxTestNotSent = By.xpath("//input[@id='sendNewInvites']");
	private final By chkboxTestNotSent = By.xpath("//label[@for='sendNewInvites']");
	private final By chkboxConfirmationBoxTestAlreadySent = By.xpath("//label[@for='sendReInvites']");
	private final By rdoRadioBtn = By.xpath("//label[@for='${checkbox}']/parent::span/following-sibling::span/label[@for='${radio}']");
	private final By rdoSendToStageNew = By.xpath("//label[@for='${checkbox}']/parent::span/following-sibling::span/label[@for='sendToStageNew']");
	private final By rdoSendToNonStageNew = By.xpath("//label[@for='${checkbox}']/parent::span/following-sibling::span/label[@for='sendToNonStageNew']");
	private final By eleCredsConfirmationBox = By.xpath("//span[contains(@class,'creds')]");
	private final By chkboxConfirmationBoxWebcamProctoring = By.xpath("//label[@for='webcamProctoring']");
	private final By chkboxConfirmationBoxRestrictMultipleTabs = By.xpath("//label[@for='restrictMultipleTabs']");
	private final By eleSendConfirmationBoxText = By.xpath("//*[contains(@class,'topHead')]");
	private final By eleInProgressMessageStrip = By.xpath("//span[@class='movingDot']/parent::span");
	private final By eleTestNameSuccessMsg = By.xpath("//div[@class='msg']/div/a");
	private final By eleModalHeading = By.className("modalHeading");
	private final By eleInviteStatusMsgStrip = By.xpath("//div[@class='msg']");
	private final By rdoConfirmationBoxSendToStage = By.xpath("//label[@for='sendStage']/p/b']");
	private final By chkboxSRPCandidates = By.xpath("//div[@class='candDet newTuple']/div/input");
	private final By chkboxSRPCandidateByName = By.xpath("//a[@title='${candidateName}']/parent::strong/preceding-sibling::input");
	private final By chkboxSRPCandidatesByStage = By.xpath("//div[*/div[*/span[text()='${stageName}']]]/preceding-sibling::div/div/input");
	private final By chkboxSelectAllCandidates = By.xpath("//input[@class='srpTopChk fl']");
	private final By eleNoOfProfiles = By.className("fr");
	private final By btnViewAssessment = By.xpath("//div[@id='attachAssessmentButton']/a");
	private final By eleTestNameSendOrViewDD = By.xpath("//div[@id='${id}']/ul[contains(@class,'assessmentDD')]/li/a/div[text()='${testName}']");
	private final By eleStageSendOrViewDD = By.xpath(".//following-sibling::div");
	private final By eleFirstTupleMsgAssessment = By.xpath("//div[contains(@class,'testTpl')]");
	private final By eleProjectID = By.id("projectId");
	private final By rdoSendNewInvites = By.xpath("//label[@for='sendNewInvites']/parent::span/following-sibling::span[contains(@class,'customRadio')]");
	private final By rdoSendReInvites = By.xpath("//label[@for='sendReInvites']/parent::span/following-sibling::span[contains(@class,'customRadio')]");
	private final By eleAnyText = By.xpath("//*[text()='${text}']");
	private final By eleStatusRibbon = By.id("statusRibbon");
	private final By eleModalBody = By.className("modalBody");
	private final By eleModalErrorHeading = By.xpath("//div[@class='modalBody']/div/b");
	private final By eleAssessCandidateName = By.className("assessCandidateName");
	private final By eleCandidateImage = By.xpath("//span[@class='assessCandidateImg']/img");
	private final By eleCandidateToHover = By.xpath("//div[@class='modalBody']/div/span/a");
	private final By btnModalFooterOK = By.xpath("//div[contains(@class,'modalFooter')]/button");
	private final By eleViewErrorDetails = By.xpath("//div[@class='statusRibbon']//a[text()='View error details']");
	private final By eleReminderConResponse = By.xpath("//div[@id='testReminder']//button[contains(@class,'confBtn')][text()='${responseYesNo}']");
	private final By eleRemConfirmationBox = By.xpath("//div[@id='testReminder']/div/div[@class='ConfirmationBox']");
	private final By eleCandidateByName = By.xpath("//strong[contains(@class,candName)]/a[@title='${candName}']");
	private final By eleAssessmentDetailsCVDetails = By.id("assessmentResults");
	private final By eleTestNameCVDetails = By.className("tName");
	private final By eleTestCompDateCVDetails = By.className("tDate");
	private final By eleResultCVDetails = By.xpath("//div[contains(@class, 'rsltStts')]");
	private final By eleScoreCVDetails = By.className("dtl");
	private final By eleResult = By.xpath("//div[@class='rsltStts dtl']/span[@class='desc']");
	private final By linkResend = By.xpath("//div[contains(@class,'testTpl')]//a[text()=' Resend']");
	//Edit Assessment Page
	private final By btnSaveSettings = By.id("attachTest");
	private final By elePrefilledStage = By.className("prefilledStage");

	//From AttachTestCandidatePO

	private final By btnTestStartBtn = By.xpath("//input[@value='Start Test']");
	private final By btnendTestBtn = By.xpath("//a[text()='End Test']");
	private final By endTestBTnConfirmation = By.xpath("(//a[text()='Yes'])[1]");
	private final By txtResultStatusOnSrp = By
			.xpath("//div[@class='mt5']//strong[contains(text(),'Result:')]/following-sibling::span[2]");
	private final By lblScoreStatusOnSrp = By
			.xpath("//div[@class='mt5']//strong[contains(text(),'Score:')]/following-sibling::span[2]");
	private final By eleSRPTupleTestName = By.xpath("(//div[@class='cle testTpl']//strong)[1]");
	private final By eleSRPTupleTestompletedOn = By.xpath("(//div[@class='cle testTpl']//strong)[2]");
	private final By eleCheckBoxHE = By.className("terms-checkbox");
	private final By chkboxCodility = By.xpath("//input[@id='agree-tos']/following-sibling::span");
	private final By btnStartTheTest = By.xpath("//button[contains(text(),'Start the test')]");
	private final By btnSkipTheTour = By.xpath("//button[contains(text(),'Skip this tour')]");
	private final By btnLetsStart = By.xpath("//button[contains(text(),'Let’s start')]");
	private final By btnSubmitCodility = By.id("submit-button");
	private final By btnConfirmSubmitCodility = By.xpath("//button[text()='Submit']");
	private final By btnSkipCodility = By.xpath("//button[text()='Skip']");
	private final By txtTestCompletedCodility = By.xpath("//*[contains(text(),'Thank you for completing your test!')]]");
	private final By eleEnterTestHE = By.xpath("//button[contains(text(),'Enter Test')]");
	private final By eleSubmitAndProceedHE = By.xpath("//button[contains(text(),'Submit and Proceed')]");
	private final By eleStartTestHE = By.id("show_problems_btn");
	private final By eleEndTestHE = By.xpath("//button[contains(text(),'End test')]");
	private final By eleConfirmEndTestHE = By.xpath("//div[contains(text(),'End test')]");
	private final By eleSubmitHE = By.xpath("//input[@type='submit']");
	private final By btnattemptthetest = By.linkText("Start Test");

	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper
			.getObject(AssessmentPartnerIntegrationPO.class);
		
	/**
	 * @author ambar.gupta
	 * This function is used to get number of profiles on SRP page.
	 * @return number of profiles on SRP for the requirement.
	 */
	public int getNumberOfProfilesAdded() {
		return Integer.parseInt(getText(eleNoOfProfiles).trim());
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to click On Save Settings button 
	 * @return number of profiles on SRP for the requirement.
	 */
	public void clickOnSaveSettings() {
		getElement(btnSaveSettings).click();
	}
	
	/**
	 * @author ambar.gupta
	 * This function is used to verify the prefilled stage in case of edit assessment.
	 */
	public boolean verifyPrefilledStage(String preFilledStage) {
		return getText(elePrefilledStage).equals(preFilledStage);
	}
	
	/**
	 * @author ambar.gupta 
	 * This method used to select a particular candidate or first candidate in SRP page
	 */
	public void selectCandidateOnSRP() {
		selectCandidateOnSRP("");
	}
	
	/**
	 * @author ambar.gupta 
	 * This method used to select a particular candidate or first candidate in SRP page
	 */
	public void selectCandidateOnSRP(String candidateName) {
		if(candidateName == "")
		{
			 getElement(chkboxSRPCandidates).click();
		}
		else
		{
			getElement(chkboxSRPCandidateByName, candidateName).click();
		}
	}
		
		/**
		 * @author ambar.gupta 
		 * This method used to select a all candidates or all candidate on a particular stage in SRP page
		 */
		public void selectCandidatesOnSRP() {
			selectCandidatesOnSRP("");
		}
		
		/**
		 * @author ambar.gupta 
		 * This method used to select a all candidates or all candidate on a particular stage in SRP page
		 */
		public void selectCandidatesOnSRP(String stageName) {
			List<WebElement> candidates=new ArrayList<WebElement>();
			if(stageName == "")
			{
				getElement(chkboxSelectAllCandidates).click();
			}
			else
			{
				candidates= getElements(chkboxSRPCandidatesByStage, stageName);
				for (WebElement candidate : candidates) {
					candidate.click();
				}
			}
		 }
		
		/**
		 * @author ambar.gupta
		 *  To hover on Send Assessment to display dropdown
		 */
		public void hoverOnSendAssessment() {
			wait.hardWait(4);
			hover(eleSendAssessmentDD);
		}
		
		/**
		 * @author ambar.gupta
		 *  To hover on View Assessment to display dropdown
		 */
		public void hoverOnViewAssessment() {
			wait.hardWait(4);
			hover(btnViewAssessment);
		}
		
		/**
		 * @author ambar.gupta
		 *  To click on Attach a new Assessment in View Assessment dropdown
		 */
		public void clickOnAttachnewAssessment() {
			wait.waitForVisibilityOfElement(eleAttachNewAssessment).click();
		}
		
		/**
		 * @author ambar.gupta
		 *  To click on Send a new Assessment in Send Assessment dropdown
		 */
		public void clickOnSendAnewAssessment() {
			wait.hardWait(5);
			hover(eleSendAssessmentDD);
			wait.waitForVisibilityOfElement(eleSendNewAssessment).click();
		}

		/**
		 * @author ambar.gupta
		 * This function is used to click on Send/Don't Send in Confirmation box
		 * @param response converted to string
		 */
		public void clickOnResponseInSendConfirmationBox(String response) {
			wait.hardWait(10);
			click(parameterizedLocator(btnConfirmationBox, response));
		}
		
//		/**
//		 * @author ambar.gupta
//		 * This function is used to Select  Send To All or Send To stage radio button in  Send Confirmation box and return
//		 * number of candidates to which invite send is attempted
//		 * @param Response in string
//		 * @return Number of candidates to which invite send is attempted
//		 */
//		public String clickOnSendToAllOrStageRadioButtonInSendConfirmationBox(String radio) {
//			String message="";
//			if(radio.equalsIgnoreCase("sendtoall")) {
//				click(rdoConfirmationBoxSendAll); 
//				return getText(rdoConfirmationBoxSendAll).replaceAll("[^0-9]", "");			
//			}
//			else
//			    click(rdoConfirmationBoxSendToStage);
//			    return getText(rdoConfirmationBoxSendAll).replaceAll("[^0-9]", "");	
//		}
		
		/**
		 * @author ambar.gupta
		 * This function verify In progress message after send Assessment
		 * return Whether In progress message correct or not
		 * @param  InProgressMsg and partnerName
		 */
		public boolean verifyInProgressMessageAfterSendAssessment(String InProgressMsg, String partnerName) {
			TestNGLogUtility.info(InProgressMsg);
			wait.waitForInvisibilityOfElement(10, 1, eleModalHeading);
			wait.hardWait(2);
			if(isDisplayed(eleInProgressMessageStrip)) {
			TestNGLogUtility.info(getText(eleInProgressMessageStrip));
			return getText(eleInProgressMessageStrip).contains(InProgressMsg);
			}
			else 
				return false;
		}
		
		/**
		 * @author ambar.gupta
		 * This function verify Invite status message after send Assessment
		 * return Whether In progress message correct or not
		 * @param msgType, JSONObject and noOfInvites in string
		 */
		public boolean verifySuccessErrorMessageAfterSendAssessment(String msgType, JSONObject data, String noOfInvites) {
			TestNGLogUtility.info(getText(eleStatusRibbon));
			TestNGLogUtility.info(data.get("TotalSuccessMessage").toString());
			if(isDisplayed(eleStatusRibbon)) {
				switch(msgType) {
				case "success":
			       return getText(eleStatusRibbon).contains(data.get("TotalSuccessMessage").toString());
				case "failure":				
				   return getText(eleStatusRibbon).contains(data.get("TotalFailureMessage").toString().replace(" x ", " "+noOfInvites+" "));
			    default:{
					TestNGLogUtility.info("Wrong input");
					return false;
					    }
					}	
				}	
			else
				return false;
				}
		

		/**
		 * @author ambar.gupta
		 * This function verify that Attach button converts to View Assessment when any test is attached
		 * @param viewBtnTxt
		 * @return Whether the name of button is as expected or not
		 */
		public boolean verifyAttachConvertToViewAssessment(String viewBtnTxt) {
			wait.waitForPageToLoadCompletely();
			wait.hardWait(3);
			TestNGLogUtility.info(getText(btnViewAssessment));
			return getText(btnViewAssessment).contains(viewBtnTxt);
		}
		
		/**
		 * @author ambar.gupta
		 * This function verify given test and stage is present in the Send or View Dropdown
		 * @param DDType, testNAme and stageName in string
		 * @return Whether the given test at the given stage is present or not
		 */
		public boolean verifyTestAtStagePresentInDD(String DDType, String testName, String stageName) {
			switch (DDType) {
			case "SendAssessment":
			{
				By eleTestNameSendOrView = parameterizedLocator(eleTestNameSendOrViewDD, "sendAssessmentButton", testName);
				if(isDisplayed(eleTestNameSendOrView))
					return getElement(eleTestNameSendOrView).findElement(eleStageSendOrViewDD).getText().equals(stageName);
				else 
					return false;
			}
			case "ViewAssessment":
			{
				By eleTestNameSendOrView = parameterizedLocator(eleTestNameSendOrViewDD, "attachAssessmentButton", testName);
				if(isDisplayed(eleTestNameSendOrView))
					return getElement(eleTestNameSendOrView).findElement(eleStageSendOrViewDD).getText().equals(stageName);
				else 
					return false;
			}
			default:
				return false;
			}
		}
			
			/**
			 * @author ambar.gupta
			 * This function is used to click on a particular test in SendAssessment dropdown
			 */
			public void clickOnParticularTestInSendAssessmentDD(String testName, String DDtype) {
				if(DDtype.equals("SendAssessment")) {
				By eleTestNameSendOrView = parameterizedLocator(eleTestNameSendOrViewDD, "sendAssessmentButton", testName);
				click(eleTestNameSendOrView);
				}
				else {
					By eleTestNameSendOrView = parameterizedLocator(eleTestNameSendOrViewDD, "attachAssessmentButton", testName);
					click(eleTestNameSendOrView);
				}	
			}

			/**
			 * @author ambar.gupta
			 * This function is used verify assessment tuple message on SRP and CVdetails page
			 * @param link, JSONObject and TestName in string
			 * @return Whether message found and is correct or not.
			 */
			public boolean verifytuplemessageforAssessment(String link, JSONObject data, String testName, String pageName) {
				String tupleMessage="";
				jsUtil.scrollDown(eleFirstTupleMsgAssessment);
				if(isDisplayed(eleFirstTupleMsgAssessment)) {
				switch (link) {
				case "Send Test":{
					tupleMessage = testName+ " "+data.get("AssessmentTupleSendTestMsg").toString();
					TestNGLogUtility.info(tupleMessage);
					return getText(eleFirstTupleMsgAssessment).equals(tupleMessage);
				}
				case "Send Reminder":{
					tupleMessage = testName+ " "+data.get("AssessmentTupleSendReminderMsg").toString();
					TestNGLogUtility.info(tupleMessage);
					TestNGLogUtility.info(getText(eleFirstTupleMsgAssessment));
					return getText(eleFirstTupleMsgAssessment).contains(tupleMessage);
				}
				case "soon be sent":{
					tupleMessage = testName+ " "+data.get("AssessmentSoonBeSent").toString();
					TestNGLogUtility.info(tupleMessage);
					wait.hardWait(20);
					return getText(eleFirstTupleMsgAssessment).equals(tupleMessage);
				}
				case "reminder sent":{
					tupleMessage = testName+ " "+data.get("AssessmentReminderSent").toString();
					TestNGLogUtility.info(tupleMessage);
					wait.hardWait(20);
					TestNGLogUtility.info(getText(eleFirstTupleMsgAssessment));
					wait.hardWait(20);
					return getText(eleFirstTupleMsgAssessment).contains(tupleMessage);
				}
				case "Resend":{
					if(pageName.equals("CVdetails"))
						tupleMessage = testName+ " completed on " + returnDateInReqFormat() + " Resend";
					else
						tupleMessage = testName+ " completed on " + returnDateInReqFormat() + " View Detailed Report | Resend";
					TestNGLogUtility.info(tupleMessage);
					wait.hardWait(20);
					API.refreshPageAndCheckElementIsDisplayed(linkResend, 10);
					wait.waitForPageToLoadCompletely();
					System.out.println(getText(eleFirstTupleMsgAssessment));
					return getText(eleFirstTupleMsgAssessment).contains(tupleMessage);
				}
				default:{
					TestNGLogUtility.info("Wrong input to the switch case.");
					return false;
				}
				}
			}
				else {
					TestNGLogUtility.info("Assessment Message tuple strip not found");
					return false;
				}
				
			}	
			
			/**
			 * @author ambar.gupta
			 * This function verify soon to be sent message is displayed on tuple or not
			 * return Whether 'soon to be sent' message is displayed on tuple or not
			 */
			public boolean verifySoonToBeSentMessageAfterSendAssessment(String testName) {
				String AssessmentTupleAfterSendMsg=PropFileHandler.readProperty("AssessmentTupleAfterSendMsg");
				if(isDisplayed(eleFirstTupleMsgAssessment))
				return getText(eleInviteStatusMsgStrip).equals(AssessmentTupleAfterSendMsg);
				else
					return false;
			}
			
			/**
			 * @author ambar.gupta
			 * This function verify Send Confirmation box heading
			 * @param testName in string
			 * return Whether Send Confirmation box heading is correct or not
			 */
			public boolean verifyModalWindowHeading(String testName) {
				TestNGLogUtility.info(getText(eleModalHeading));
				return getText(eleModalHeading).equals("Send "+testName);
			}

			/**
			 * @author ambar.gupta
			 * This function verify Send Confirmation box sub heading
			 * @param data,msgType and noOfInvites in string
			 * return Whether Send Confirmation box sub heading is correct or not
			 */
			public boolean verifyModalWindowSubHeading(JSONObject data, String msgType, String noOfInvites) {
				wait.hardWait(10);
				wait.waitForVisibilityOfElement(eleSendConfirmationBoxText);
				TestNGLogUtility.info(getText(eleSendConfirmationBoxText));
				TestNGLogUtility.info(data.get("SubHeadingSendConfirmationWindow").toString().replace(" x ", " "+noOfInvites+" "));
			switch (msgType) {
			case "sending":	{
				String expected = data.get("SubHeadingSendConfirmationWindow").toString().replace(" x ", " "+noOfInvites+" ");
				if(Integer.parseInt(noOfInvites) > 1)
					expected = expected.replace("candidate", "candidates");
				TestNGLogUtility.info(expected);
				return getText(eleSendConfirmationBoxText).equals(expected);
			}
			case "pending":	
				return getText(eleSendConfirmationBoxText).equals(data.get("PendingSubmissionMsg").toString());

			default:
				return false;
			}
			}
			
			/**
			 * @author ambar.gupta
			 * This function verify whether checkbox selected or not
			 * @param checkBox name
			 * return Whether checkbox selected or not
			 */
			public boolean verifyCheckBoxIsSelected(String checkBox) {
				switch (checkBox) {
					case "Not yet invited":{
						if(getElement(chkboxConfirmationBoxTestNotSent).isSelected())
							return true;
						else
							return false;
					}
					case "Test Already Sent":{
						if(getElement(chkboxConfirmationBoxTestAlreadySent).isSelected())
							return true;
						else
							return false;
					}
					default:{
						TestNGLogUtility.info("Wrong input to switch case: Expected: Not yet invited or Test Already Sent");
						return false;
					}
				}
			}
			
			/**
			 * @author ambar.gupta
			 * This function verify send button is clickable or not
			 * return Whether send button is clickable or not
			 */

			public boolean verifySendButtonClickable() {
				return isDisplayed(btnDisabledSend,"SEND");
			}
			
			
			
			/**
			 * @author ambar.gupta
			 * This function is used to get processID for a requirement from overview page
			 * return processID in string
			 */
			public String getProcessIDforRequirement() {
				return getElement(eleProjectID).getAttribute("value");
			}

			/**
			 * @author ambar.gupta
			 * This function is used to get Number Of Radio butttons After CheckBox
			 * return number of radio buttons after check box
			 */
			public int getNumberOfRadioAfterCheckBox(String checkbox) {
				switch (checkbox) {
				case "Not yet invited":
					return getElements(rdoSendNewInvites).size();
				case "Test Already Sent":
					return getElements(rdoSendReInvites).size();
				default:{
					TestNGLogUtility.fail("Wrong input to checkbox");
					return 4;
						}
				}
			}
			
			/**
			 * @author ambar.gupta
			 * This function is used check whether Check box is present or not
			 * @param checkbox name in string
			 * @return whether Check box is present or not
			 */
			public boolean verifyPresenceOfCheckBox(String checkbox) {
				switch (checkbox) {
				case "Not yet invited":
					return isDisplayed(chkboxConfirmationBoxTestNotSent);
				case "Test Already Sent":
					return isDisplayed(chkboxConfirmationBoxTestAlreadySent);
				default:{
					TestNGLogUtility.fail("Wrong input");
					return false;
						}
				}
			}
			
			/**
			 * @author ambar.gupta
			 * This function is used click on checkbox
			 * @param checkbox name in string
			 */
			public void clickOnCheckBox(String checkbox) {
				switch (checkbox) {
				case "Not yet invited":{
					click(chkboxConfirmationBoxTestNotSent);
					break;}
				case "Test Already Sent":{
					click(chkboxConfirmationBoxTestAlreadySent);
					break;}
				default:{
					TestNGLogUtility.fail("Wrong input");
					break;
						}
				}
			}
			
			/**
			 * @author ambar.gupta
			 * This function is used to select Number Of Radio butttons After CheckBox
			 */
			public void selectRadioAfterCheckBox(String radio, String checkbox) {
				switch (checkbox) {
				case "Not yet invited":
					click(parameterizedLocator(rdoRadioBtn, "sendNewInvites", radio));
					break;
				case "Test Already Sent":
					click(parameterizedLocator(rdoRadioBtn, "sendReInvites", radio));
					break;
				default:{
					TestNGLogUtility.fail("Wrong input to switch case");
						}
				}
			}

			/**
			 * @author ambar.gupta
			 * This function is used check whether webcam and proctor settings are present or not
			 * @return Whether webcam and proctor settings are present or not
			 */
			public boolean verifyWebCamAndProctorSettings() {
				return isDisplayed(chkboxConfirmationBoxWebcamProctoring) && isDisplayed(chkboxConfirmationBoxRestrictMultipleTabs);
			}

			/**
			 * @author ambar.gupta
			 * This function is used check whether webcam and proctor settings are present or not
			 * @return Whether webcam and proctor settings are present or not
			 */
			public boolean verifyAnyText(String text) {
				return isDisplayed(eleAnyText, text);
			}
			

			/**
			 * @author ambar.gupta
			 * This function is used to open new tab and switch to it
			 */
			public void openNewTab() {
				jsUtil.executeJavascript("window.open()");
				switchToChildWindow();
			}
			
			/**
			 * @author ambar.gupta
			 * This function is used to verify various error messages for partner/HE
			 * @param errorType in string
			 * @return Whether message is correct or not depending on error type
			 */
			public boolean verifyHackerEarthErrorMessage(String errorType, String location,JSONObject data ) {
				switch (location) {
				case "confirmation box":
					return verifyHackerEarthErrorMessageBasedOnErrorType(errorType,  eleStatusRibbon, data);
				case "sticky box":
					return verifyHackerEarthErrorMessageBasedOnErrorType(errorType,  eleModalBody, data);		
				default:
					return false;
				}
			}

			/**
			 * @author ambar.gupta
			 * This function is used to verify various error messages for partner/HE
			 * @param errorType in string
			 * @return Whether message is correct or not depending on error type
			 */
			public boolean verifyHackerEarthErrorMessageBasedOnErrorType(String errorType, By by, JSONObject data) {
	
				TestNGLogUtility.info(getText(by));
				TestNGLogUtility.info(data.get("AuthorisationError").toString());
				TestNGLogUtility.info(data.get("TestNotFoundError").toString());
				TestNGLogUtility.info(data.get("TestExpiredError").toString());
				switch (errorType) {
				case "Authorisation error":
					return getText(by).contains(data.get("AuthorisationError").toString());
				case "TestNotFound error":
					return getText(by).contains(data.get("TestNotFoundError").toString());
				case "TestExpired error":
					return getText(by).contains(data.get("TestExpiredError").toString());
				case "AlreadyInvited":
					return getText(by).contains(data.get("CandidateAlreadyInvitedError").toString());
				default:
					return false;
				}
			}
			
			/**
			 * @author ambar.gupta
			 * This function is used to click on Okay button in sticky box
			 */

			public void clickOnOkayButton() {
				wait.hardWait(10);
				click(btnModalFooterOK);
			}
			
			/**
			 * @author ambar.gupta
			 * This function is used to click View error details link in error message
			 */

			public void clickOnViewErrorDetails() {
				wait.hardWait(10);
				click(eleViewErrorDetails);
			}

			/**
			 * @author ambar.gupta
			 * This function is used to verify error heading in error modal window
			 * @param error heading
			 * @return whether error heading correct or not
			 */
			public boolean verifyModalErrorHeading(String error) {
				return getText(eleModalErrorHeading).contains(error);
			}
			
			/**
			 * @author ambar.gupta
			 * This function is used to verify candidate name on hover in error modal window
			 * @param candName
			 * @return whether candidate name found/correct or not
			 */

			public boolean verifyCandidateNameOnHover(String candName) {
				hover(eleCandidateToHover);
				return getText(eleAssessCandidateName).contains(candName);		
			}
			
			/**
			 * @author ambar.gupta
			 * This function is used to verify candidate image on hover in error modal window
			 * @return whether candidate image found or not
			 */

			public boolean verifyCandidateImageOnHover() {
				hover(eleCandidateToHover);
				String value = getElement(eleCandidateImage).getAttribute("src");
		        if (value != null)
		            return true;
		        else
		           return false;
			}
			
			/**
			 * @author ambar.gupta
			 * This function is used to verify text in candidate tuple
			 * @param text
			 * @return whether text found/correct or not
			 */

			public boolean verifyCandidateTupleFirstText(String text) {
		
				return getText(eleFirstTupleMsgAssessment).contains(text);		
			}

			/**
			 * @author ambar.gupta
			 * This function is used to select Candidates Not On given Stage
			 * @param stage name
			 */
			public void selectCandidatesNotOnStage(String stage) {
				if(!getElement(chkboxSelectAllCandidates).isSelected()) {
					getElement(chkboxSelectAllCandidates).click();
				}
				selectCandidatesOnSRP(stage);
			}

			/**
			 * @author ambar.gupta
			 * This function is used to verify message when all candidates not at stage at which test is attached
			 * @return whether message correct or not
			 */
			public boolean verifyMessageWhenCandidatesNotAtStageAtWhichTestAttached() {
				// TODO Auto-generated method stub
				return false;
			}
			
			/**
			 * @author ambar.gupta
			 * This function is click on response in Reminder send confirmation box
			 * @param response 'yes' or 'No'
			 */
			public void clickOnResponseInReminderSendConfirmationBox(String response) {
				click(parameterizedLocator(eleReminderConResponse, response));
				wait.waitForInvisibilityOfElement(10, 1, eleRemConfirmationBox);
			}
			
			/**
			 * @author ambar.gupta
			 * This function is used to move to CV details from SRP by clicking on candidate Name
			 * @param candidateName
			 */
			public void clickOnCandidateNameToMovetoCVdetails(String candidateName) {
				click(parameterizedLocator(eleCandidateByName, candidateName));
				switchToChildWindow();
				closeParentMoveToChild();
				wait.waitForPageToLoadCompletely();
			}
			
			/**
			 * @author ambar.gupta
			 * This function is verify candidate result on CV details
			 * @param testName, cutoffStatus
			 * @return Result: pass/fail and NoResult in case of no cut off
			 * 
			 */
			public String verifyAssessmentResultOnCVdetails(String testName, String cutoffStatus) {
				pageRefresh();
				wait.waitForPageToLoadCompletely();
				wait.hardWait(6);
				jsUtil.scrollDown(eleAssessmentDetailsCVDetails);
				if(getText(eleTestCompDateCVDetails).contains(returnDateInReqFormat()) && getText(eleTestNameCVDetails).contains(testName) && isDisplayed(eleScoreCVDetails)) {
					switch (cutoffStatus) {
					case "cutoff present":{
						if(isDisplayed(eleResultCVDetails)) {
							TestNGLogUtility.info(getText(eleResult));
							return getText(eleResult);}
						else {
							TestNGLogUtility.info("Result absent even when cutoff present");
							return "TestCaseFail";
						}
					}
					case "cutoff absent":{
						if(!isDisplayed(eleResultCVDetails))
							return "noResult";
						else {
							TestNGLogUtility.info("Result present even when cutoff absent");
							return "TestCaseFail";
						}
					}
					default:{
						TestNGLogUtility.info("Wrong input to switch: Expected /'cutoff present/' or/' cutoff absent/'");
						return "TestCaseFail";
					}
					}			
				}else
					return "TestCaseFail";
			}

			/**
			 * @author ambar.gupta
			 * This function is return space seprated date in "dd-MMMM-yyyy" format
			 * @return Date in string in "dd-MMMM-yyyy" format
			 * 
			 */
			public String
			returnDateInReqFormat() {
				Date newDate = new Date();
				String strDateFormat = "dd-MMMM-yyyy";
				DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
				String formattedDate = dateFormat.format(newDate);
				String ExpectedDate = formattedDate.replaceAll("-", " ");
				TestNGLogUtility.info(ExpectedDate);
				return ExpectedDate;
			}

			/**
			 * @author ambar.gupta
			 * This function is used to update requirement name in automation database
			 * @param requirementName
			 * 
			 */
			public void UpdateReqNameInDB(String requirementName, String subscriptionType) {
				HashMap<String, String> hmap = new HashMap<>();
				System.out.println("requirementName " + requirementName+ " subscriptionType "+subscriptionType);
				hmap.put("RequirementName"+subscriptionType, requirementName);
				MongoDBConnector.UpdateValuesInMongoDocument("PartnerAssessment", hmap, "DocumentName", "DataToReuse");
			}

	/**
	 * @author ambar.gupta
	 * To attempt tests of various partners
	 * @param partnerName
	 */
	public void attemptTest(String partnerName) {

		switch (partnerName) {
			case "Naukri Assessments":
				API.refreshPageAndCheckElementIsDisplayed(btnTestStartBtn, 2);
				click(btnTestStartBtn);
				wait.waitForPageToLoadCompletely();
				wait.hardWait(2);
				click(btnendTestBtn);
				click(endTestBTnConfirmation);
				wait.waitForPageToLoadCompletely();
				break;
			case "HackerEarth":
				click(eleCheckBoxHE);
				click(eleEnterTestHE);
				click(eleSubmitAndProceedHE);
				wait.hardWait(60);
				click(eleStartTestHE);
				wait.waitForPageToLoadCompletely();
				click(eleEndTestHE);
				click(eleConfirmEndTestHE);
				wait.waitForPageToLoadCompletely();
				click(eleSubmitHE);
				break;
			case "Codility":
				click(chkboxCodility);
				click(btnStartTheTest);
				click(btnSkipTheTour);
				click(btnLetsStart);
				wait.hardWait(6);
				click(btnSubmitCodility);
				wait.hardWait(2);
				click(btnConfirmSubmitCodility);
				wait.hardWait(5);
				click(btnConfirmSubmitCodility);
				click(btnSkipCodility);
				wait.hardWait(5);
				break;
				
			default:
				TestNGLogUtility.info("Please enter correct partner name to attempt test for");
				break;
		}
	}

	/**
	 * @author ambar.gupta
	 * To verify the assessment  results from SRP page for various partners
	 * @param cutoffStatus, testName
	 * @return : status of result depending upon cutoff present or not
	 */
	public String verifyResultsOnSrp(String cutoffStatus, String testName) {
		pageRefresh();
		wait.waitForPageToLoadCompletely();
		JSONObject json = null;
		if(verifytuplemessageforAssessment("Resend",json, testName, "SRP")){
			String ScoreOnSrp = getText(lblScoreStatusOnSrp);
			switch (cutoffStatus) {
				case "cutoff present":{
					if(isDisplayed(txtResultStatusOnSrp) && ScoreOnSrp.contains("0%")) {
						TestNGLogUtility.info(getText(txtResultStatusOnSrp));
						return getText(txtResultStatusOnSrp);}
					else {
						TestNGLogUtility.info("Result absent even when cutoff present");
						return "TestCaseFail";
					}
				}
				case "cutoff absent":{
					if(!isDisplayed(txtResultStatusOnSrp) && ScoreOnSrp.contains("0%"))
						return "noResult";
					else {
						TestNGLogUtility.info("Result present even when cutoff absent");
						return "TestCaseFail";
					}
				}
				default:{
					TestNGLogUtility.info("Wrong input to switch: Expected /'cutoff present/' or/' cutoff absent/'");
					return "TestCaseFail";
				}
			}}
		else
			return "TestCaseFail";
	}


	/**
	 * @author ambar.gupta
	 * To start Assessment for various partners by clicking start test
	 */
	public void clickOnStartTest() {
		goToPageURL(getAttribute(btnattemptthetest, "href"));
	}
			
		}
		