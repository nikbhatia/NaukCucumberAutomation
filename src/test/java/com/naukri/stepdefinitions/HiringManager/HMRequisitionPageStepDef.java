package com.naukri.stepdefinitions.HiringManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.HiringManager.AllRequisitionPagePO;
import com.naukri.pageobjects.HiringManager.ApprovalSettingsPagePO;
import com.naukri.pageobjects.HiringManager.HMDashboardPagePO;
import com.naukri.pageobjects.HiringManager.ManageGroupPagePO;
import com.naukri.pageobjects.HiringManager.RaiseRequisitionPagePO;
import com.naukri.pageobjects.HiringManager.RequirementPagePO;
import com.naukri.pageobjects.Requirements.RequirementListingPagePO;
import com.naukri.pageobjects.Settings.ManageSubuserPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class HMRequisitionPageStepDef {

	HMDashboardPagePO HMDashboardPagePOObject = new HMDashboardPagePO();
	CommonAction CommonActionObject = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	ManageGroupPagePO ManageGroupPagePOObject = new ManageGroupPagePO();
	RequirementPagePO RequirementPagePOObject = new RequirementPagePO();
	RaiseRequisitionPagePO RaiseRequisitionPagePOObject = new RaiseRequisitionPagePO();
	AllRequisitionPagePO AllRequisitionPagePOObject = new AllRequisitionPagePO();
	ApprovalSettingsPagePO SettingsPagePOObject = new ApprovalSettingsPagePO();
	RequirementListingPagePO requirementListingPagePO = (RequirementListingPagePO) PageObjectWrapper.getObject(RequirementListingPagePO.class);
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	ManageSubuserPO objManageSubuser = (ManageSubuserPO) PageObjectWrapper.getObject(ManageSubuserPO.class);
	
	static String approverOneID = "mansihmmlh@yopmail.com";
	static String approverTwoId = "aliasalias@yopmail.com"; 
	static String groupName;
	public static String reqName;
	static String approvalName;
	int reqRaiserByYouCount;
	int reqReadyForCreationCount;
	int commentCountOfRequisition;
	List<String> allComments = new ArrayList<String>();

	@And("I turn \"(.*)\" Requisition Approval Mandatory toggle bar")
	public void changeRequisitionToggel(String toggle) {
		SettingsPagePOObject.requisitionApprovalSetting(toggle);
		TestNGLogUtility.info("User turn "+toggle+" approval mandotory button");
	}

	@And("I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process")
	public void createGroup(DataTable dt) {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		List<String> hrNames = new ArrayList<String>();
		List<String> hrSpoc = new ArrayList<String>();
		List<String> hmNames = new ArrayList<String>();
		List<String> hmSpoc = new ArrayList<String>();
		List<String> appoversId = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).get("HR").equals("NA")) {
				hrNames.add(list.get(i).get("HR"));
			}
			if (!list.get(i).get("HRSpoc").equals("NA"))
				hrSpoc.add(list.get(i).get("HRSpoc"));
			if (!list.get(i).get("HM").equals("NA"))
				hmNames.add(list.get(i).get("HM"));
			if (!list.get(i).get("HMSpoc").equals("NA"))
				hmSpoc.add(list.get(i).get("HMSpoc"));
		}
		appoversId.add(approverOneID);
		appoversId.add(approverTwoId);
		groupName = "TestGroup " + new Date().getTime();
		approvalName = "TestApprovalProcess "+ new Date().getTime();
		ManageGroupPagePOObject.addGroupCustomize(groupName, hrNames, hrSpoc, hmNames, hmSpoc,true, appoversId,approvalName);
		TestNGLogUtility.info("User creates group with name "+groupName+" and approval process named "+approvalName);
	}
	
	@Then("Verify that Group name is displayed on manage group page")
	public void verifyGroupIsDisplayed(){
		Assert.assertTrue(ManageGroupPagePOObject.isCreatedGroupDisplayedOnPage(groupName));
		TestNGLogUtility.pass("Group name is displayed on manage group page");
		PropFileHandler.writeProperty("GroupName",groupName);
		PropFileHandler.writeProperty("ApprovalName",approvalName);
	}

	@When("I goto raise requisition page from dashboard")
	public void gotoRaiseRequisitionPageFromDashboard() {
		HMDashboardPagePOObject.gotoRaiseRequirementPageFromDashboard();
		TestNGLogUtility.info("I goto raise requisition page from dashboard");
	}

	@And("HM Spoc creates requisition with no approval process")
	public void raiseRequisitionWithNoApprovalProcess() {
		reqName = "TestRequisition "+ new Date().getTime();
		RaiseRequisitionPagePOObject.fillRequisitionFormWithoutApprovalProcess(reqName, PropFileHandler.readProperty("GroupName"));
		TestNGLogUtility.info("HM Spoc creates requisition "+reqName+" with no approval process and group "+PropFileHandler.readProperty("GroupName"));
	}

	@And("I click on requisition name")
	public void clickOnRequisitionName()
	{
		AllRequisitionPagePOObject.clickOnRequisitionName(reqName);
		TestNGLogUtility.info("I click on requisition name");
	}
	
	@Then("I verify comment")
	public void verifyCommentOnRequsition()
	{
		Assert.assertEquals(AllRequisitionPagePOObject.getRaiseRequisitionComment(),"1) Other Information Given By HM");
		TestNGLogUtility.pass("I verify comment");
	}
	
	@Then("I see add comment button below requisition name")
	public void addCommentButtonIsDisplayedForReq() {
		AllRequisitionPagePOObject.isAddCommentBtnIsDisplayedForGivenReq(reqName);
		TestNGLogUtility.info("I see add comment button below requisition name");
	}

	@Then("HM Spoc sees \"(.*)\" label instead of Comment")
	public void checkLabelDisplayed(String label) {
		String labelDisplayed = RaiseRequisitionPagePOObject.getOtherInformationDisplayedLabel();
		Assert.assertEquals(label, labelDisplayed);
		TestNGLogUtility.pass("HM Spoc sees "+label+" label instead of Comment");
	}

	@And("HM Spoc sees placeholder as \"(.*)\"")
	public void checkPlaceholderDisplayed(String placeholder) {
		String placeholderDisplayed = RaiseRequisitionPagePOObject.getOtherInformationTextAreaPlaceholder();
		Assert.assertEquals(placeholder, placeholderDisplayed);
		TestNGLogUtility.pass("HM Spoc sees placeholder as "+placeholder);
	}

	@And("HR Spoc adds comment for the requisition with no approval process as {string}")
	public void commentAddedByHRSpocForRequisitionWithNoApprovalProcess(String comment)
	{
		AllRequisitionPagePOObject.addCommentForRequisitionWithNoApprovalByHRSopc(reqName, comment);
		TestNGLogUtility.info("HR Spoc adds comment for the requisition with no approval process as "+comment);
	}
	@And("HR Spoc adds comment for the requisition with no approval process as {string} on overview page")
	public void commentAddedByHROnOverviewPage(String comment)
	{
		AllRequisitionPagePOObject.addCommentOnOverviewPage(reqName,comment);
	}
	
	@When("HR Spoc adds comment for the requisition as {string}")
	public void commentAddedByHRSpoc(String comment) {
		AllRequisitionPagePOObject.addCommentForRequisitionWithApprovalPendingByHRSpoc(reqName, comment);
		TestNGLogUtility.info("HR Spoc adds comment for the requisition as "+comment);
	}

	@Then("HM Spoc is able to add comment for requisition as {string}")
	public void commentAddedByHMSpoc(String comment) {
		AllRequisitionPagePOObject.addCommentForRequisitionByHMSpoc(reqName, comment);
		TestNGLogUtility.info("HM Spoc is able to add comment for requisition as "+comment);
	}

	@And("User is able to see added comment on top as {string}")
	public void getTopComment(String comment) {
		String topComment = AllRequisitionPagePOObject.getTopCommentForHMSpoc(reqName);
		Assert.assertEquals(topComment, comment);
		TestNGLogUtility.pass("User is able to see added comment on top as "+comment);
	}

	@When("I click on comments for raised requisition ready for creation")
	public void clickAddCommentBtnForRequisitionReadyForCreation() {
		AllRequisitionPagePOObject.clickAddCommentBtnForRequisitionReadyForCreation(reqName);
		TestNGLogUtility.info("I click on comments for raised requisition ready for creation");
	}
	@When("I click on comments for raised requisition ready for creation on overview page")
	public void clickCommentRaisedRequisition()
	{
		AllRequisitionPagePOObject.clickCommentSRaisedRequisitionOverviewPage();
	}

	@Then("HM Spoc must be able to see {string} comment added by HR Spoc against requisition")
	public void getCommentOfHRSpoc(String addedComment) {
		String comment = AllRequisitionPagePOObject.getTopCommentForHMSpoc(reqName);
		Assert.assertEquals(addedComment, comment);
		TestNGLogUtility.pass("HM Spoc must be able to see "+addedComment+" comment added by HR Spoc against requisition");
	}
	@Then("HM Spoc must be able to see {string} comment added by HR Spoc against requisition on overview")
	public void getCommentOnOverviewPage(String comment)
	{
		Assert.assertTrue(AllRequisitionPagePOObject.verifyCommentOnPage(comment),"comment not displayed on overview");
	}

	@Then("HR Spoc must be able to see comment {string} added by HM Spoc against requisition")
	public void getCommentOfHMSpoc(String addedComment) {
		String comment = AllRequisitionPagePOObject.getTopCommentForHRSpocWithNoApprovalPending(reqName);
		Assert.assertEquals(comment, addedComment);
		TestNGLogUtility.pass("HR Spoc must be able to see comment "+addedComment+" added by HM Spoc against requisition");
	}

	@And("HM Spoc creates requisition with approval process")
	public void raiseReqWithApprovalProcess() {
		reqName = "TestRequisition "+ new Date().getTime();
		RaiseRequisitionPagePOObject.fillRequisitionFormWithApprovalProcess(reqName, PropFileHandler.readProperty("GroupName"), PropFileHandler.readProperty("ApprovalName"));
		TestNGLogUtility.info("HM Spoc creates requisition with approval process with name " +reqName);
	}

	@When("I click on comments for raised requisition with pending approval")
	public void clickAddCommentBtnForRequisitionPendingApproval() {
		AllRequisitionPagePOObject.clickAddCommentForRequisitionPendingApproval(reqName);
		TestNGLogUtility.info("I click on comments for raised requisition with pending approval");
	}

	@And("Approver adds comment for the requisition as {string}")
	public void commentAddedByApprover(String comment) {
		AllRequisitionPagePOObject.addCommentForRequisitionPendingApprovalByApprover(reqName, comment);
		TestNGLogUtility.info("Approver adds comment for the requisition as "+comment);
	}

	@Then("HR Spoc must be able to see {string} comment added by approver against requisition")
	public void getCommentOfApproverForHRSpoc(String addedComment) {
		String topComment = AllRequisitionPagePOObject.getTopCommentForHMSpoc(reqName);
		Assert.assertEquals(addedComment, topComment);
		TestNGLogUtility.pass("HR Spoc must be able to see "+addedComment+" comment added by approver against requisition");
	}

	@Then("HM Spoc must be able to see {string} comment added by approver against requisition")
	public void getCommentOfApproverForHMSpoc(String addedComment) {
		String topComment = AllRequisitionPagePOObject.getTopCommentForHMSpoc(reqName);
		Assert.assertEquals(addedComment, topComment);
		TestNGLogUtility.pass("HM Spoc must be able to see "+addedComment+" comment added by approver against requisition");
	}

	@When("I click on Raise Requisition button")
	public void clickRaiseReqButtonOnReqListingPage() {
		AllRequisitionPagePOObject.clickRaiseRequisitionButton();
		TestNGLogUtility.info("I click on Raise Requisition button");
	}

	@Then("I should get requisition raised success message")
	public void checkSuccessMsgAfterReqCreation() {
		String successMsg = AllRequisitionPagePOObject.getReqCreationSuccessMsg();
		String reqId = AllRequisitionPagePOObject.getReqId(reqName);
		String expectedSuccessMsg = "Requisition ["+reqId+"] "+reqName+" was created successfully";
		Assert.assertEquals(successMsg, expectedSuccessMsg,"[ASSERT FAIL]: Requisition success message is not displayed");
		TestNGLogUtility.pass("Requisition Raised success message is displayed");
	}

	@When("I click on Select Group dropdown")
	public void clickOnGroupDD() {
		RaiseRequisitionPagePOObject.clickonGroupDD();
		TestNGLogUtility.info("I click on Select Group dropdown");
	}

	@Then("I see the name of group in which i am HM Spoc in drop down")
	public void isGroupDisplayed() {
		RaiseRequisitionPagePOObject.isGroupDisplayed(PropFileHandler.readProperty("GroupName"));
		TestNGLogUtility.info("I see the name of group in which i am HM Spoc in drop down as "+PropFileHandler.readProperty("GroupName"));
	}

	@Then("I see that the Status of requirement as {string}")
	public void getStatusOfRequisition(String expectedReqStatus) {
		String reqStatus = AllRequisitionPagePOObject.getStatusOfRequisition(reqName);
		TestNGLogUtility.info("The Status of requirement is "+reqStatus);
		Assert.assertEquals(expectedReqStatus, reqStatus);
		TestNGLogUtility.pass("I see that the Status of requirement as " + expectedReqStatus);
	}

	@And("I get the count of requisitions for Requisitions Raised by You and Requisitions Ready for Creation")
	public void getCountOfRequisition() {
		reqRaiserByYouCount = Integer.parseInt(AllRequisitionPagePOObject.getReqRaisedByYouCount());
		reqReadyForCreationCount = Integer.parseInt(AllRequisitionPagePOObject.getReqReadyForCreationCount());
		TestNGLogUtility.info("Count of requisition raised by you is " + reqRaiserByYouCount);
		TestNGLogUtility.info("Count of requisition ready for creation is " + reqReadyForCreationCount);
	}

	@Then("I see that count is increased for Requisitions Raised by You and Requisitions Ready for Creation")
	public void compareCount() {
		Assert.assertEquals(reqRaiserByYouCount + 1,Integer.parseInt(AllRequisitionPagePOObject.getReqRaisedByYouCount()));
		Assert.assertEquals(reqReadyForCreationCount + 1,Integer.parseInt(AllRequisitionPagePOObject.getReqReadyForCreationCount()));
		TestNGLogUtility.info("I see that count is increased for Requisitions Raised by You and Requisitions Ready for Creation");
	}

	@And("Approver rejects the requisition")
	public void rejectRequisition() {
		AllRequisitionPagePOObject.rejectRequisitionAwaitingYourApproval(reqName);
		TestNGLogUtility.info("Approver rejects the requisition");

	}

	@And("I get comment count of requisition")
	public void getCommentCountOfRequisition() {
		commentCountOfRequisition = AllRequisitionPagePOObject.getCommentCountOfRaisedReqForHMSpoc(reqName);
		TestNGLogUtility.info("I get comment count of requisition "+commentCountOfRequisition);
	}

	@And("I get all comments of requistion")
	public void getAllComments() {
		allComments = AllRequisitionPagePOObject.getAllCommentOfRaisedReqForHMSpoc(reqName);
		TestNGLogUtility.info("I get all comments of requistion "+allComments);
	}

	@When("I reinitiate requisition")
	public void reinitiateRequisition() {
		AllRequisitionPagePOObject.reinitiateReq(reqName);
		TestNGLogUtility.info("I reinitiate requisition");
	}

	@Then("I see that current comment count is same as comment count before reinitiating requisition")
	public void compareCommentCount() {
		Assert.assertEquals(commentCountOfRequisition,AllRequisitionPagePOObject.getCommentCountOfRaisedReqForHMSpoc(reqName));
		TestNGLogUtility.pass("I see that current comment count is same as comment count before reinitiating requisition");
	}

	@And("I see that comments are also same as before")
	public void compareComment() {
		Assert.assertEquals(true,allComments.equals(AllRequisitionPagePOObject.getAllCommentOfRaisedReqForHMSpoc(reqName)));
		TestNGLogUtility.pass("I see that comments are also same as before");
	}

	@And("I go to {string} section")
	public void gotoRequisitionSection(String reqSection) {
		AllRequisitionPagePOObject.gotoGivenReqState(reqSection);
		TestNGLogUtility.info("User click on "+reqSection);
	}

	@When("I create requirement for raised requisition")
	public void createRequirementFromRequisition() {
		RequirementPagePOObject.createRequirementFromRequisition(reqName);
		TestNGLogUtility.info("I create requirement for raised requisition");
	}

	@Then("HM verifies that {string} is stacked over {string}")
	public void verifyCommentStacking(String commentTwo, String commentOne) {
		Assert.assertEquals(commentTwo, AllRequisitionPagePOObject.getTopCommentForHMSpoc(reqName));
		TestNGLogUtility.pass("HM verifies that "+commentTwo+" is stacked over "+commentOne);
	}
	
	@When("User click on Add Requisition button")
	public void clickOnAddRequisition()
	{
		RaiseRequisitionPagePOObject.addRequisition();
		TestNGLogUtility.info("User click on Add Requisition button");
	} 
	
	@Then("User verify below error messages")
	public void verifyErrorMessage(List<String> errorMsg)
	{
		for(String errMsg:errorMsg)
		{
			Assert.assertTrue(RaiseRequisitionPagePOObject.isGivenTextDisplayed(errMsg),"[ASSERT FAIL]: "+errMsg+" is not displayed");
			TestNGLogUtility.pass("Text "+errMsg+" is displayed");
		}	
	}
	
	@When("User enter Requisition Title as {string}")
	public void fillRequisitionTitle(String reqTitle)
	{
		RaiseRequisitionPagePOObject.fillRequisitionTitle(reqTitle);
		TestNGLogUtility.info("User enter Requisition Title as "+reqTitle);
	}
	
	@When("User enter Job Title as {string}")
	public void fillJobTitle(String jobTitle)
	{
		RaiseRequisitionPagePOObject.fillJobTitle(jobTitle);
		TestNGLogUtility.info("User enter Job Title as "+jobTitle);
	}
	
	@When("User enter Minimum Work Experience as {string}")
	public void fillMinimumWorkExp(String minWorkExp)
	{
		RaiseRequisitionPagePOObject.fillMinWorkEx(minWorkExp);
		TestNGLogUtility.info("User enter Minimum Work Experience as "+minWorkExp);
	}
	
	@When("User enter Key Skills as")
	public void fillKeySkills(List<String> keySkills)
	{
		RaiseRequisitionPagePOObject.fillKeySkills(keySkills);
		TestNGLogUtility.info("User enter Key Skills as "+keySkills);
	}
	
	@When("User enter Vacancy as {string}")
	public void fillVacancy(String vacancy)
	{
		RaiseRequisitionPagePOObject.fillVacancy(vacancy);
		TestNGLogUtility.info("User enter Vacancy as "+vacancy);
	}
	
	@Then("Verify error text {string} is displayed")
	public void verifyErrorMessage(String errorMessage)
	{
		Assert.assertTrue(RaiseRequisitionPagePOObject.isGivenTextDisplayed(errorMessage),"[ASSERT FAIL]: "+errorMessage+" is not displayed");
		TestNGLogUtility.pass("Error message "+errorMessage+" is displayed");
	}
	
	@And("I get name of first requisition")
	public void getTheNameOfTopRequisition()
	{
		reqName = RaiseRequisitionPagePOObject.getTheNameOfTopRequisition();
		TestNGLogUtility.info("I get name of first requisition");
	}

	@When("User click on created requisition")
	public void User_click_on_created_requisition() {
		AllRequisitionPagePOObject.clickOnRequisition(reqName);
	}
	
	@When("User Click on add requisition button")
	public void User_Click_on_add_requisition_button() {
		RaiseRequisitionPagePOObject.addRequisition();
	}
	
	@When("User fill the required requisition details")
	public void User_fill_the_required_requisition_details() {
		reqName="Reqisition_"+System.currentTimeMillis();
		RaiseRequisitionPagePOObject.fillRequisitionFormWithoutAnyApprovalProcess(reqName);
	}
	
	@And("User fill all required fields for requisition")
	public void User_fill_all_required_fields_for_requisition() {
		RaiseRequisitionPagePOObject.fillRequisitionfields(reqName, groupName);
	}
	@When("User prefills the requisition from top suggestion")
	public void prefillRequisitionAndSave()
	{
		RaiseRequisitionPagePOObject.prefillFromTopRequistion();
		TestNGLogUtility.info("User prefills the requisition from top suggestion");
	}
	
	@And("Verify that {string} button is not displayed for requirement")
	public void verifyButtonNotDisplayed(String btnName)
	{
		Assert.assertFalse(AllRequisitionPagePOObject.isButtonDisplayedForRequirement(reqName,btnName));
		TestNGLogUtility.pass(btnName+" button is not displayed for requirement");
	}
	
	@And("Verify that {string} button is displayed for requirement")
	public void verifyButtonDisplayed(String btnName)
	{
		Assert.assertTrue(AllRequisitionPagePOObject.isButtonDisplayedForRequirement(reqName,btnName));
		TestNGLogUtility.pass(btnName+" button is displayed for requirement name "+reqName);
	}
	
	@Then("Verify created requisition is displayed")
	public void verifyRequisitionNameIsDisplayed()
	{
		Assert.assertTrue(AllRequisitionPagePOObject.isRequisitionNameDisplayed(reqName));
		TestNGLogUtility.pass("Created requisition is displayed");
	}
	
	@Then("Verify created requisition is not displayed")
	public void verifyRequirementIsNotDisplayed()
	{ 
		TestNGLogUtility.info("Verify that requirement"+reqName+" is displayed or not");
		Assert.assertFalse(AllRequisitionPagePOObject.isRequisitionNameDisplayed(reqName));
		TestNGLogUtility.pass("Created requisition is not displayed");
	}
	
	@When("User select created group")
	public void selectCreatedGroup()
	{
		RaiseRequisitionPagePOObject.selectGroup(PropFileHandler.readProperty("GroupName"));
		TestNGLogUtility.info("User select created group name "+PropFileHandler.readProperty("GroupName"));
	}
	
	@When("User click on Edit link under group")
	public void User_click_on_Edit_link_under_group() {
		ManageGroupPagePOObject.clickOnEditlinkUnderGroup(groupName);
	}

	@Then("Verify {string} message against {string} label")
	public void verifyMessageAgainstApprovalProcessDD(String text, String label)
	{
		Assert.assertEquals(RaiseRequisitionPagePOObject.getTextDisplayedAgainstLabel(label), text);
		TestNGLogUtility.pass(text+ "is displayed against field "+label);
	}
	
	@Then("Verify {string} success message is displayed")
	public void verifySuccessMessageDisplayed(String message)
	{
		Assert.assertEquals(AllRequisitionPagePOObject.getReqCreationSuccessMsg(), message);
		TestNGLogUtility.pass(message+" success message is displayed");
	}
	
	@When("User click on {string} button under Requirement")
	public void clickOnWithdraw(String btnName)
	{
		AllRequisitionPagePOObject.clickOnWithdraw(reqName);
		TestNGLogUtility.info("User click on "+btnName);
	}
	
	@Then("Verify {string} of lb is {string}")
	public void verifyTextOnWithdrawLB(String placement, String textMessage)
	{
		Assert.assertEquals(AllRequisitionPagePOObject.getTextFromWithdrawLB(placement), textMessage);
		TestNGLogUtility.pass(textMessage+" message is displayed");
	}
	
	@And("Verify {string} button is displayed on withdraw LB")
	public void verifyButtonOnWithdrawLB(String btnName)
	{
		Assert.assertTrue(AllRequisitionPagePOObject.isButtonDisplayedInWithdrawLB(btnName));
		TestNGLogUtility.pass(btnName+" button is displayed on withdraw LB");
	}
	
	@When("User enter Annual CTC as {string}")
	public void fillMaxSalary(String salary)
	{
		RaiseRequisitionPagePOObject.fillMaxSalary(salary);
		TestNGLogUtility.info("User enters max salary");
	}
	
	@And("User selects top group")
	public void selectTopGroup() {
		RaiseRequisitionPagePOObject.selectFirstGroupInDD();
		TestNGLogUtility.info("User selects top group");
	}
	
	@When("User edit the group and {string} HMSpoc {string} from group")
	public void User_edit_the_group_and_HMSpoc_from_group(String action, String hmspoc) {
		ManageGroupPagePOObject.addOrRemoveHm(action, hmspoc);
	}
	
	@When("User click created requirement from requisition")
	public void User_click_created_requirement_from_requisition() {
		requirementListingPagePO.clickOnRequirementName(reqName);
	}
	
	@When("User click on Prefill from other Prefill from existing Requisitions or Templates DD")
	public void clickOnPrefillDD()
	{
		RaiseRequisitionPagePOObject.clickPrefillFromOtheirRequisitionOrTemplateDD();
		TestNGLogUtility.info("User click on Prefill from other Prefill from existing Requisitions or Templates DD");
	}
	
	@Then("Verify that user does not see {string} tab on overview page")
	public void verifyAbsenceOfTabOnReqOverview(String tabName)
	{
		Assert.assertFalse(cvDetailsPagePO.isButtonDisplayed(tabName), tabName+ " is displayed");
		TestNGLogUtility.pass(tabName+" is not displayed");
	}
	@Then("Verify that user see {string} tab on overview page")
	public void verifyPresenceOftabOnReqOverview(String tabName)
	{
		Assert.assertTrue(cvDetailsPagePO.isButtonDisplayed(tabName), tabName+ " is not displayed");
		TestNGLogUtility.pass(tabName+" is displayed");
	}

	@And("User turn {string} Requisition Details Settings")
	public void changeSwitchForRequisitionDetailSetting(String changeTo)
	{
		objManageSubuser.toggleRequisitionDetailSetting(changeTo);
		TestNGLogUtility.info("User turn "+changeTo+" Requisition Details Settings");
	}
	
	@When("User clicks on created requirement name")
	public void clickOnCreateRequirementName()
	{
		requirementListingPagePO.clickOnRequirementName(reqName);
		TestNGLogUtility.info("User clicks on created requirement name");
	}
	@When("User click on Edit link under group created")
	public void user_click_edit_groupCreated()
	{
		String groupName = PropFileHandler.readProperty("GroupName");
		ManageGroupPagePOObject.clickOnEditlinkUnderGroup(groupName);
	}
	@When("user clicks on the requisition link")
	public void userCLicksOnRequisitionLinkOnREquisitionListingPage()
	{
		RaiseRequisitionPagePOObject.clickOnRequisitionOnListingPage();
	}
	
	@And("Approver approves the requisition")
	public void approveRequisition()
	{
		AllRequisitionPagePOObject.approveRequisitionAwaitingYourApproval(reqName);
		TestNGLogUtility.info("Approver approves the requisition");
	}

}
