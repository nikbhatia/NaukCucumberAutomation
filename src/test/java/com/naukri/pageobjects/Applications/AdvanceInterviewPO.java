package com.naukri.pageobjects.Applications;

import java.util.List;

import org.openqa.selenium.By;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

/**
 * Page Object class comprises of all the page object methods used in
 * applications for settings page
 * 
 * @author jatin.bisht
 *
 */
public class AdvanceInterviewPO extends BaseAutomation {

	private By txtLocation = By.cssSelector("textarea[placeholder='Type or search Location']");
	private By ddSelectionStageDD = By.xpath("(//span[@class=' outerArow'])[1]");
	private By lnkInterviewStage = By.xpath("(//a[text()='Interview'])[1]");
	private By ddSelectGroup = By.id("inp_hiringFordd");
	private By eleSelectGroup = By.xpath("(//b[contains(text(),'DonotEditDelete')])[1]");
	private By ddInterviewtype = By.cssSelector(".dropdownMainContainer");
	private By eleInterviewTypeTelephonic = By.cssSelector("label[for='TELEPHONIC']");
	private By eleInterviewTypeVideoConference = By.cssSelector("label[for='VIDEO_CONFERENCE']");
	private By eleConferenceModeOther = By.cssSelector("label[for='OTHER']");
	private By ddInterviewers = By.cssSelector("input[placeholder='Type to search interviewers']");
	private By liSelectAllInterviewers = By.cssSelector("li[value='aSelectAll']");
	private By eleCalendarIcon = By.id("calendarIcon");
	private By ddStartTime = By.cssSelector("input[value='09:00 AM']");
	private By ddEndTime = By.cssSelector("input[value='10:00 AM']");
	private By eleSelectTime = By.cssSelector("li[index='1']");
	private By eleEditIcon = By.cssSelector("a[title='Edit']");
//	private By btnCandidateCustomize = By.xpath("//span[contains(text(),'the candidate')]//..//button");
//	private By btnInterviewerCustomize = By.xpath("//span[contains(text(),'to interviewers')]//..//button");
	private By chkInterviewerCheckbox = By.cssSelector("label[for='notifyInterviewerEmail']");
	private By chkCandidateCheckbox = By.cssSelector("label[for='notifyCandidateByEmail']");
	private By ddSelectRequirement = By.id("inp_projectList");
	private By lnkSelectRequirement = By.xpath("(//a[contains(text(),'Created by')])[1]");
	private By lnkRequirementApplicationCount = By.xpath("//div[@class='proCount cle']/p/a");
	private By lnkRequirementName = By.xpath("//div[@class='pb5 pt5']/a");
	private By eleNextDate = By.cssSelector(".arrow.right");
	private By elePreviousDate = By.cssSelector(".arrow.left");
//	private By lnkAddInterviewers = By.xpath("//div[@class='interviewScheduleErrorMsg']/a");
	private By eleRescheduleIcon = By.cssSelector(".refreshIc");
	private By ddMeetingRoom = By.xpath("//input[contains(@placeholder,'Meeting Rooms')]");
	private By lblRoomForInterview = By.xpath("//span[text()='Room for Interview']");
	private By liFirstMeetingRoom = By.cssSelector("li[index='1']");
	private By liSecondMeetingRoom = By.cssSelector("li[index='2']");
	private By btnDeleteMeetingRoom = By.xpath("//button[@type='button']//img");
	private By btnFirstApplicationOnSrp = By.xpath("(//strong[@class='fl candName']/a)[1]");
	private By btnAddInterviewerChip = By.cssSelector(".addHm");
	private By inpCandidateMailSubject = By.xpath("(//input[@id='mailSubject'])[1]");
	private By inpcandidateMailBody = By.xpath("(//div[@class='mailBodyWriter'])[1]");
	private By btnCandidateMailTags = By.xpath("(//div[text()='[tags] '])[1]");
	private By liCandidateMailTag = By.xpath("(//li[text()='Interview Duration'])[1]");
	private By inpInterviewerMailSubject = By.xpath("(//input[@id='mailSubject'])[2]");
	private By inpInterviewerMailBody = By.xpath("(//div[@class='mailBodyWriter'])[2]");
	private By btnInterviewerMailTags = By.xpath("(//div[text()='[tags] '])[2]");
	private By liInterviewerMailTag = By.xpath("(//li[text()='Interview Duration'])[2]");
	private By chkBoxblockMyCalendar = By.id("blockRecruiterCalendarId");
	private By editButton = By.xpath("//button[text()='Edit']");
	
	/**
	 * @author jatin.bisht This method fill details which are mandatory for
	 *         scheduling interview like location
	 */
	public void fillLocationForInterview(String location) {
		wait.waitForPageToLoadCompletely();
		sendKeys(txtLocation, location);
		TestNGLogUtility.info("Location is filled");
	}

	/**
	 * @author jatin.bisht This method move application to first interview stage
	 */
	public void moveApplicationToInterviewStage() {
		getElement(ddSelectionStageDD).click();
		getElement(lnkInterviewStage).click();
		TestNGLogUtility.info("Application move to interview stage");
	}

	/**
	 * @author jatin.bisht This method select group while creating new requirement
	 *         from add a single profile page
	 */
	public void selectGroupWhileCreatingRequirement() {
		getElement(ddSelectGroup).click();
		sendKeys(ddSelectGroup, "DonotEditDelete");
		getElement(eleSelectGroup).click();
	}

	/**
	 * @author jatin.bisht This method open email editor of candidate in interview
	 *         scheduling page
	 */
//	public void openEmailEditorOfCandidate() {
//		wait.waitForPageToLoadCompletely();
//		wait.waitForVisibilityOfElement(btnCandidateCustomize);
//		wait.waitForElementToBeClickable(btnCandidateCustomize);
//		getElement(btnCandidateCustomize).click();
//	}

	/**
	 * @author jatin.bisht This method click on edit icon under the interview
	 *         schedule tuple
	 */

	public void clickOnEditIconForInterview() {
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollUp();
		getElement(eleEditIcon).click();
		TestNGLogUtility.info("clicked on edit button");
	}

	/**
	 * @author jatin.bisht This method open email editor of candidate and
	 *         interviewer in interview scheduling page
	 */
	public void clickOnCheckboxInterviewer() {
		scrollToElement(chkInterviewerCheckbox);
		getElement(chkInterviewerCheckbox).click();
		wait.waitForPageToLoadCompletely();
		
	}
	
	public void clickOnCheckboxCandidate() {
		scrollToElement(chkCandidateCheckbox);
		getElement(chkCandidateCheckbox).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author jatin.bisht
	 */
	public void EditMailEditorsOfBoth() {
		getElement(inpCandidateMailSubject).click();
		getElement(btnCandidateMailTags).click();
		getElement(liCandidateMailTag).click();
		getElement(inpcandidateMailBody).click();
		getElement(btnCandidateMailTags).click();
		getElement(liCandidateMailTag).click();
		TestNGLogUtility.info("Inserted tags in candidate editor");
//		getElement(inpInterviewerMailSubject).click();
//		getElement(btnInterviewerMailTags).click();
//		getElement(liInterviewerMailTag).click();
//		getElement(inpcandidateMailBody).click();
//		getElement(btnInterviewerMailTags).click();
//		getElement(liInterviewerMailTag).click();
//		TestNGLogUtility.info("Inserted tags in interviewers editor");
	}
	
	/**
	 * @author jatin.bisht This method select Requirement while adding a single
	 *         profile
	 */
	public void selectRequirementWhileAddingCandidate() {
		getElement(ddSelectRequirement).click();
		getElement(lnkSelectRequirement).click();
	}

	/**
	 * @author jatin.bisht This method change interview type and interview time
	 */
	public void ChangeInterviewTypeDateTime() {
		wait.waitForPageToLoadCompletely();
		wait.waitForPageToLoadCompletely();
		getElement(ddInterviewtype).click();
		getElement(eleInterviewTypeTelephonic).click();
		getElement(ddStartTime).click();
		getElement(eleSelectTime).click();
		getElement(ddEndTime).click();
		getElement(eleSelectTime).click();
	}

	/**
	 * @author jatin.bishtThis method select all interviewers while scheduling
	 *         interview
	 */
	public void SelectInterviewersWhileSchedulingInterview() {
		wait.waitForPageToLoadCompletely();
		wait.waitForPageToLoadCompletely();
		getElement(ddInterviewers).click();
		getElement(liSelectAllInterviewers).click();
		TestNGLogUtility.info("selects all interviewers when scheduling interview");
	}
	
	public void moveToReqInboxFromCVpage() {
		getElement(lnkRequirementName).click();
		getElement(lnkRequirementApplicationCount).click();
	}
	
	public void changeInterviewDateAndType() {
		getElement(eleNextDate).click();
		getElement(ddInterviewtype).click();
		getElement(eleInterviewTypeVideoConference).click();
		getElement(eleConferenceModeOther).click();
	}
	
	public void userClickOnFirstApplicationOnSRP() {
		getElement(btnFirstApplicationOnSrp).click();	
	}
	
	public void fillInterviewerForInterview() {
		getElement(ddInterviewers).click();
		sendKeys(ddInterviewers, "interviewer1@yopmail.com");
		getElement(btnAddInterviewerChip).click();
		TestNGLogUtility.info("Interviewer added");
	}
	
	public void addOneMoreInterviewer() {
		getElement(ddInterviewers).click();
		sendKeys(ddInterviewers, "interviewer2@yopmail.com");
		getElement(btnAddInterviewerChip).click();
		TestNGLogUtility.info("Added one more interviewer");
	}
	
	public void selectTwoMeetingRooms() {
		getElement(ddMeetingRoom).click();
		getElement(liFirstMeetingRoom).click();
		getElement(liSecondMeetingRoom).click();
		TestNGLogUtility.info("selected 2 meeting rooms");
		getElement(lblRoomForInterview).click();
	}
	
	public void selectOneMeetingRoom() {
		getElement(ddMeetingRoom).click();
		getElement(liSecondMeetingRoom).click();
		TestNGLogUtility.info("selected 1 meeting room");
		getElement(lblRoomForInterview).click();
	}
	
	
	public void clickOnDeleteIconMeetingRoom() {
		getElement(btnDeleteMeetingRoom).click();
	}
	
	public void selectBlockMyCalendarCheckBox(String isChecked) {
		if(isChecked.equalsIgnoreCase("unselect")) {
			getElement(chkBoxblockMyCalendar).click();
			TestNGLogUtility.info("selecting check box");
		} 
	}

	public void openEmailEditorOfCandidate() {
		scrollToElement(chkCandidateCheckbox);
		getElement(chkCandidateCheckbox).click();
		getElement(editButton).click();
	}

	public void openEmailEditorOfInterviewer() {
		scrollToElement(chkInterviewerCheckbox);
		getElement(chkInterviewerCheckbox).click();
		getElement(editButton).click();
	}
}
