package com.naukri.stepdefinitions.Applications;

import com.naukri.pageobjects.Applications.AdvanceInterviewPO;
import com.naukri.pageobjects.Applications.InterviewSchedulingPagePO;
import com.naukri.pageobjects.Applications.SettingsPagePO;
import com.naukri.stepdefinitions.CommonStepDef.CommonStepDef;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdvanceInterviewStepDef {

	AdvanceInterviewPO advanceInterviewPOobj = new AdvanceInterviewPO();

	@When("user fill {string} location for scheduling interview")
	public void userFillLocationForInterviewScheduling(String location) {
		advanceInterviewPOobj.fillLocationForInterview(location);
	}

	@And("user select Requirement while adding a single profile")
	public void userSelectReqWhileAddingSingleProfile() {
		advanceInterviewPOobj.selectRequirementWhileAddingCandidate();
	}

	@And("user open email editor of candidate")
	public void userOpenEmailEditorOfCandidate() {
		advanceInterviewPOobj.openEmailEditorOfCandidate();
	}
	
	@And("user open email editor of interviewer")
	public void userOpenEmailEditorOfInterviewer() {
		advanceInterviewPOobj.openEmailEditorOfInterviewer();
	}

	@And("user click on notify interviewer checkbox")
	public void userCheckInterviewersCheckbox() {
		advanceInterviewPOobj.clickOnCheckboxInterviewer();
	}
	
	@And("user click on notify candidate checkbox")
	public void userCheckCandidateCheckbox() {
		advanceInterviewPOobj.clickOnCheckboxCandidate();
	}
	
	@When("user edit mail editors of interviewer and candidate")
	public void userEditMailEditorsOfBoth() {
		advanceInterviewPOobj.EditMailEditorsOfBoth();
	}
	
	@When("user click on edit icon for scheduled interview")
	public void userClickOneditIconForInterview() {
		advanceInterviewPOobj.clickOnEditIconForInterview();
	}

	@When("user move an application to interview stage")
	public void userMoveApplicationToInterview() {
		advanceInterviewPOobj.moveApplicationToInterviewStage();
	}

	@And("User select group while creating requirement")
	public void userSelectGroupWhileCreatingRequirement() {
		advanceInterviewPOobj.selectGroupWhileCreatingRequirement();
	}

	@And("user change the interview type,date,time")
	public void userChangeInterviewTypeDateTime() {
		advanceInterviewPOobj.ChangeInterviewTypeDateTime();
	}

	@And("user select interviewers while scheduling interview")
	public void userSelectInterviewersWhileSchedulingInterview() {
		advanceInterviewPOobj.SelectInterviewersWhileSchedulingInterview();
	}
	
	@When("user move to requirement inbox from cv detail page")
	public void userMoveToRequirementInboxFromCVpage() {
		advanceInterviewPOobj.moveToReqInboxFromCVpage();
	}
	
	@And("user change date & type of interview")
	public void userChangeDateTypeOfInterview() {
		advanceInterviewPOobj.changeInterviewDateAndType();
	}
	@And("user click on first application on SRP")
	public void clickOnFirstApplication() {
		advanceInterviewPOobj.userClickOnFirstApplicationOnSRP();
	}
	
	@And("user fill interviewers name for interview")
		public void userFillInterviewersForInterview() {
		advanceInterviewPOobj.fillInterviewerForInterview();
	}
	@When("user select two meeting rooms for interview")
	public void userSelectTwoMeetingRooms() {
		advanceInterviewPOobj.selectTwoMeetingRooms();
	}
	@When("user click on delete icon for meeting rooms")
	public void userClickOnDeleteIconMeetingRoom() {
		advanceInterviewPOobj.clickOnDeleteIconMeetingRoom();
	}
	@And("user select one meeting room for interview")
	public void userSelectOneMeetingRoom() {
		advanceInterviewPOobj.selectOneMeetingRoom();
	}
	@And("user add one more interviewer for interview")
	public void userAddOneMoreInterviewer() {
		advanceInterviewPOobj.addOneMoreInterviewer();
	}
	
	@And("user {string} block calendar checkbox")
	public void userSelectBlockInterviewCheckbox(String select) {
		advanceInterviewPOobj.selectBlockMyCalendarCheckBox(select);
	}
	
}
