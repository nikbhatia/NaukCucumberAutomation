package com.naukri.stepdefinitions.HiringManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.Applications.ForwardFlowPagePO;
import com.naukri.pageobjects.Dashboard.DashboardPagePO;
import com.naukri.pageobjects.HiringManager.HMDashboardPagePO;
import com.naukri.pageobjects.HiringManager.ManageGroupPagePO;
import com.naukri.pageobjects.HiringManager.RaiseRequisitionPagePO;
import com.naukri.pageobjects.HiringManager.RequirementPagePO;
import com.naukri.pageobjects.Reports.ConversionFunnelReportsPageObject;
import com.naukri.pageobjects.Reports.GenericFunctions;
import com.naukri.pageobjects.Requirements.RequirementListingPagePO;
import com.naukri.pageobjects.Settings.ManageGroupPO;
import com.naukri.pageobjects.Settings.ManageSubuserPO;
import com.naukri.pageobjects.VendorPlatform.ViewAssessmentPO;
import com.naukri.stepdefinitions.Reports.ConversionFunnelReportsStepDef;
import com.naukri.stepdefinitions.Reports.ReportsCommonStepDef;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class HMRenameStepDef {

	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	ManageGroupPO manageGroupPO = (ManageGroupPO) PageObjectWrapper.getObject(ManageGroupPO.class);
	ManageGroupPagePO manageGroupPagePO = (ManageGroupPagePO) PageObjectWrapper.getObject(ManageGroupPagePO.class);
	ManageSubuserPO manageSubuserPO = (ManageSubuserPO) PageObjectWrapper.getObject(ManageSubuserPO.class);
	RequirementListingPagePO requirementListingPagePO = (RequirementListingPagePO) PageObjectWrapper.getObject(RequirementListingPagePO.class);
	RaiseRequisitionPagePO raiseRequisitionPagePO = (RaiseRequisitionPagePO) PageObjectWrapper.getObject(RaiseRequisitionPagePO.class);
	ReportsCommonStepDef reportsCommonStepDef = (ReportsCommonStepDef) PageObjectWrapper.getObject(ReportsCommonStepDef.class);
	ConversionFunnelReportsStepDef conversionFunnelReportsStepDef = (ConversionFunnelReportsStepDef) PageObjectWrapper.getObject(ConversionFunnelReportsStepDef.class);
	ConversionFunnelReportsPageObject ConversionFunnelObject = new ConversionFunnelReportsPageObject();
	ForwardFlowPagePO forwardFlowPagePO = (ForwardFlowPagePO) PageObjectWrapper.getObject(ForwardFlowPagePO.class);
	ViewAssessmentPO objViewAssessment = (ViewAssessmentPO) PageObjectWrapper.getObject(ViewAssessmentPO.class);
	RequirementPagePO requirementPagePO = (RequirementPagePO) PageObjectWrapper.getObject(RequirementPagePO.class);
	DashboardPagePO dashboardPagePO = (DashboardPagePO) PageObjectWrapper.getObject(DashboardPagePO.class);
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	HMDashboardPagePO hmDashboardPagePO = (HMDashboardPagePO) PageObjectWrapper.getObject(HMDashboardPagePO.class);
	
	static String groupNameWithNoApproval;

	@And("user should be able to see {string} under {string} label")
	public void verifyLableUnderViewDetails(String userName, String labelName) {
		Assert.assertTrue(manageGroupPO.verifyUserUnderLabel(userName, labelName));
		TestNGLogUtility.pass("user should be able to see " + userName + " under " + labelName + " label");
	}

	@Then("User verify {string} title is present for add interviewer icon for {string} stage")
	public void verifyTitleName(String titleText, String stageName) {
		String observerdText = manageGroupPO.getTitleTextAddInterviewerOnSeletionStage(stageName);
		Assert.assertEquals("Expected was "+titleText+" but found "+observerdText,titleText,observerdText);
		TestNGLogUtility.pass("Title text displayed is " + titleText);
	}

	@And("User click on {string} icon for {string} stage")
	public void clickIconOnStageName(String iconName, String stageName) {
		manageGroupPO.clickOnIconForStageOnSelectionStage(stageName, iconName);
		TestNGLogUtility.pass("User click on " + iconName + " icon for " + stageName + " stage");
	}

	@Then("User should be able to see the placeholder text {string} on lightbox")
	public void verifyPresenceOfTextOnPlaceholder(String text) {
		Assert.assertTrue(manageGroupPO.verifyPresenceOfPlaceholderText(text));
		TestNGLogUtility.pass("Text on placeholder is same as expected");
	}

	@And("User selects first interviewer from lightbox dropdown")
	public void selectTopInterviewerFromAddInterviewerDd() {
		manageGroupPO.selectTopInterviewerFromAddInterviewerLB();
		TestNGLogUtility.info("User selects first interviewer from lightbox dropdown");
	}

	@Then("User should be able to see link with name {string}")
	public void verifyPresenceOfLinkText(String linkText) {
		Assert.assertTrue(manageGroupPO.verifyErrorMsg(linkText));
		TestNGLogUtility.pass(linkText + "  is displayed");
	}

	@And("User should be able to see text {string}")
	public void verifyPresenceOfText(String txt) {
		Assert.assertTrue(manageGroupPO.verifyErrorMsg(txt));
		TestNGLogUtility.pass(txt + " ---is displayed");
	}

	@And("I turn {string} CTC Visibility toggle bar")
	public void toggleCTCVisibitySetting(String value) {
		manageSubuserPO.toggleCTCVisibilitySetting(value);
		TestNGLogUtility.info("I turn " + value + " CTC Visibility toggle bar");
	}

	@And("User click on CTC Visibility drop down")
	public void clickONCTCDD() {
		manageSubuserPO.clickOnCTCVisibilityDD();
		TestNGLogUtility.info("User click on CTC Visibility drop down");
	}

	@When("User selects {string} from drop down")
	public void selectOptionFromDD(String txt) {
		manageSubuserPO.clickOptionFromCTCDD(txt);
		TestNGLogUtility.info("User selects " + txt + " from drop down");
	}

	@And("User click on top requirement name")
	public void clickOnTopRequirementName() {
		requirementListingPagePO.clickNameOfTopRequirement();
		TestNGLogUtility.info("User click on top requirement name");
	}

	@And("HM Spoc creates requisition with no approval process for {string} group")
	public void createReqWithGivenGroup(String grpName) {
		HMRequisitionPageStepDef.reqName = "TestRequisition " + new Date().getTime();
		raiseRequisitionPagePO.fillRequisitionFormWithoutApprovalProcess(HMRequisitionPageStepDef.reqName, grpName);
		TestNGLogUtility.info("HM Spoc creates requisition " + HMRequisitionPageStepDef.reqName + " with no approval process and group " + grpName);
	}

	@And("User navigates to requirement overview page if directed to requirement inbox")
	public void naviagateToRequirementOverview() {
		requirementListingPagePO.navigateToRequirementOverviewFromReqInbox();
		TestNGLogUtility.info("User navigates to requirement overview page if directed to requirement inbox");
	}

	// @And("User verifies that for displayed columns respective tooltip are
	// displayed")
	// public void verifyRespectiveToolTipForColumn()
	// {
	// for (int
	// temp=0;temp<=reportsCommonStepDef.CustomStagesListFromReports.size();temp++)
	// {
	// conversionFunnelReportsStepDef.toolTipTextForRespectiveColumnName =
	// ConversionFunnelObject.hoverOnRequiredColumnNameInDetailedReport(reportsCommonStepDef.CustomStagesListFromReports.get(temp));
	// }
	// }

	@And("User select  Attach feedback received so far checkbox")
	public void clickOnAttachFeedbackCB() {
		forwardFlowPagePO.selectAttachFeedbackReceivedSoFarCB();
		TestNGLogUtility.info("User select  Attach feedback received so far  checkbox");
	}

	@And("User click on count against created requirement")
	public void clickAgainstGivenRequirement() {
		requirementListingPagePO.refreshForCountOfApplications(PropFileHandler.readProperty("RequirementName"));
		requirementListingPagePO.clickOnApplicationCount(PropFileHandler.readProperty("RequirementName"));
		TestNGLogUtility.pass("User click on count against created requirement");
	}

	@And("User check Automatic mailer to HM checbox in settings")
	public void clickOnAutomaticMailer() {
		objViewAssessment.checkAutomaticMailerToHMCheckboxInSettings();
		TestNGLogUtility.pass("User check Automatic mailer to HM checbox in settings");
	}

	@And("I create group with below as HR, HRSpoc, HM, HMSpoc")
	public void createGroupWithoutApprovalProcess(DataTable dt) {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		List<String> hrNames = new ArrayList<String>();
		List<String> hrSpoc = new ArrayList<String>();
		List<String> hmNames = new ArrayList<String>();
		List<String> hmSpoc = new ArrayList<String>();
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
		groupNameWithNoApproval = "TestGroup " + new Date().getTime();
		manageGroupPagePO.addGroupCustomize(groupNameWithNoApproval, hrNames, hrSpoc, hmNames, hmSpoc,false,Collections.emptyList(),"");
		TestNGLogUtility.info("User creates group with name "+groupNameWithNoApproval);
	}
	
	@And("User click on {string} link under group for created group")
	public void clickOnLinkForGroup(String action)
	{
		manageGroupPO.clickOnBtnForGrpName(groupNameWithNoApproval,action);
		TestNGLogUtility.info("User click on "+action+" link under group for created group");
	}
	
	@And("User created a requirement which is mapped with no approval group")
	public void createRequirementWithNoApprovalProcess()
	{
		PropFileHandler.writeProperty("PrefillRequirementName", "Requirement created for HM Automation");
		PropFileHandler.writeProperty("RequirementName", "RequirementTesting " + new Date().getTime());
		requirementPagePO.createRequirement(groupNameWithNoApproval,PropFileHandler.readProperty("RequirementName"),PropFileHandler.readProperty("PrefillRequirementName"));
		TestNGLogUtility.info("I created a requirement with name "+PropFileHandler.readProperty("RequirementName")+" which is mapped with created group "+groupNameWithNoApproval);
	}
	
	@And("user click on Group dropdown")
	public void clickOnGroupDD()
	{
		manageSubuserPO.clickOnGroupDDInLB();
		TestNGLogUtility.pass("user click on Group dropdown");
	}
	
	@And("user type group name and click on group name")
	public void searchGroupAndClickOnName()
	{
		manageSubuserPO.searchGroupAndClickOnName(groupNameWithNoApproval);
		TestNGLogUtility.pass("user type group name and click on group name");
	}

	@When("User click on received notification for HM Removal for group")
	public void clickOnNotificationForHMRemoval() 
	{
		Assert.assertTrue(dashboardPagePO.clickOnHMRemovedNotificationForGroup(groupNameWithNoApproval));
		TestNGLogUtility.info("User click on received notification for HM Removal for group");
	}
	
	@Then("User should be able to see the info with text {string} group name {string}")
	public void verifyInfoIconTextOnPgae(String firstPart, String secondPart)
	{
		Assert.assertTrue(manageGroupPO.verifyErrorMsg(firstPart+groupNameWithNoApproval+secondPart));
		TestNGLogUtility.pass(firstPart+groupNameWithNoApproval+secondPart+"  is displayed");
	}
	
	@Then("User verify text of notification for HM removed for group")
	public void verifyNotificationHearderForGrp()
	{
		Assert.assertTrue(dashboardPagePO.verifyNotificationHeaderForGroup(groupNameWithNoApproval));
		TestNGLogUtility.info("User verify text of notification is Hiring Manager/Interviewer removed for group");
	}
	
	@And("User click on {string} from add interviewer dd")
	public void clickOnHMNameFormLB(String hmName)
	{
		manageGroupPO.clickOnInterviewerNameInLB(hmName);
		TestNGLogUtility.info("User click on "+hmName+" from add interviewer dd");
	}
	
	@And("User verify text of notification for HM removed for requirement")
	public void verifyHMRemovalNotiForReq()
	{
		Assert.assertTrue(dashboardPagePO.verifyNotificationHeaderForGroup(PropFileHandler.readProperty("RequirementName")));
		TestNGLogUtility.info("User verify text of notification is Hiring Manager/Interviewer removed for requirement");
	}
	
	@When("User click on received notification for HM Removal for requirement")
	public void clickOnHMRemovedFromReqNoti()
	{
		Assert.assertTrue(dashboardPagePO.clickOnHMRemovedNotificationForGroup(PropFileHandler.readProperty("RequirementName")));
		TestNGLogUtility.info("User click on received notification for HM Removal for requirement");
	}
	
	
	@Then("User verify text of notification for HM removed for {string} group stage")
	public void verifyNotiHeadingForRemovalFromGrpStg(String stageName)
	{
		Assert.assertTrue(dashboardPagePO.verifyNotificationHeaderForGroup(stageName));
		TestNGLogUtility.info("User verify text of notification is Hiring Manager/Interviewer removed for group stage");
	}
	
	@When("User click on received notification for HM Removal for {string} group stage")
	public void clickOnGrpStgHMRemoveNoti(String stageName)
	{
		Assert.assertTrue(dashboardPagePO.clickOnHMRemovedNotificationForGroup(stageName));
		TestNGLogUtility.info("User click on received notification for HM Removal for group stage");
	}
	
	@And("User reload {string} report if error")
	public void reloadReport(String reportName)
	{
		genericFunctions.reloadReportIfReloadDisplayed(reportName);
		TestNGLogUtility.info("User reload "+reportName+" report if error");
	}
	
	@And("User clicks on created requirement name with no approval process group")
	public void clickOnReqForNoApprovalGrp()
	{
		requirementListingPagePO.clickOnRequirementName(PropFileHandler.readProperty("RequirementName"));
		TestNGLogUtility.info("User clicks on created requirement name");
	}
	
	@And("User click on {string}")
	public void clickOnText(String txt)
	{
		hmDashboardPagePO.genericClick(txt);
		TestNGLogUtility.info("User click on "+txt);
		
	}

}
