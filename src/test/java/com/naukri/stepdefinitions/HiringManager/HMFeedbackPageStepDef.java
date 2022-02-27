package com.naukri.stepdefinitions.HiringManager;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.pageobjects.Applications.AllProfilePagePO;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.pageobjects.Applications.InterviewSchedulingPagePO;
import com.naukri.pageobjects.Applications.InterviewSchedulingPagePO.BasicInterviewSchedulingPagePO;
//import com.naukri.pageobjects.HiringManager.CVDeataiPagePO;
import com.naukri.pageobjects.HiringManager.HMDashboardPagePO;
import com.naukri.pageobjects.HiringManager.HMFeedbackPagePO;
import com.naukri.pageobjects.HiringManager.HMRequirementsPagePO;
import com.naukri.pageobjects.HiringManager.ManageGroupPagePO;
import com.naukri.pageobjects.HiringManager.RequirementInboxPagePO;
import com.naukri.pageobjects.HiringManager.RequirementPagePO;
import com.naukri.pageobjects.Settings.ManageSubuserPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HMFeedbackPageStepDef {

	HMFeedbackPagePO HMFeedbackPagePOObject = new HMFeedbackPagePO();
	HMDashboardPagePO HMDashboardPagePOObject = new HMDashboardPagePO();
	CommonAction CommonActionObject = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	ManageGroupPagePO ManageGroupPagePOObject = new ManageGroupPagePO();
	RequirementPagePO RequirementPagePOObject = new RequirementPagePO();
	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	AllProfilePagePO allProfilePagePO = (AllProfilePagePO) PageObjectWrapper.getObject(AllProfilePagePO.class);
	GenericFunctions objGenericFunctions = new GenericFunctions();
	BasicInterviewSchedulingPagePO basicInterview = (BasicInterviewSchedulingPagePO) PageObjectWrapper.getInnerClassObject(InterviewSchedulingPagePO.class, BasicInterviewSchedulingPagePO.class);
	RequirementInboxPagePO RequirementInboxPagePOObject = (RequirementInboxPagePO) PageObjectWrapper.getObject(RequirementInboxPagePO.class);
	SoftAssert softAssert = new SoftAssert();
	HMRequirementsPagePO HMRequirementsPagePOObject = new HMRequirementsPagePO();
	CVDetailsPagePO cvDetails = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	ManageSubuserPO objManageSubuser = (ManageSubuserPO) PageObjectWrapper.getObject(ManageSubuserPO.class);
	
	
	@Given("I am logged in with {string} user {string}")
	public void loggedin(String subscription, String userType) {
		String userName = subscription + "." + userType;
		String password = subscription + "." + userType + "password";
		CommonActionObject.loginToRMS(getAppConfigValue("URLs.appURL"), getAppConfigValue("HM." + userName),getAppConfigValue("HM." + password));
		TestNGLogUtility.info("User is logged in");
	}

	@And("I am on Pending Reviews Feed page for a first pipeline stage")
	public void pipeline_stage() {
		if (HMDashboardPagePOObject.isAnyPipelineStageIsThereForFeedback()) {
			String stageName = HMDashboardPagePOObject.getNameOfFirstPipelineStage();
			PropFileHandler.writeProperty("StageName", stageName);
			HMDashboardPagePOObject.clickOnCountOfGivenStage(stageName);
			TestNGLogUtility.info("I am on pending feedback page of " + stageName + " stage");
		}
	}

	@Then("Verify application is displayed")
	public void verifyApplicationIsDisplayed() {
		Assert.assertTrue(HMDashboardPagePOObject.verifyCandidateIspresentOnFeedbackPendingPage(PropFileHandler.readProperty("CandidateEmailId1")));
		TestNGLogUtility.pass("Application is displayed");
	}
	
	@Then("Verify application is not displayed")
	public void verifyApplicationIsNotDisplayed()
	{
		Assert.assertTrue(HMDashboardPagePOObject.verifyCandidateIsAbsentOnFeedbackPendingPage(PropFileHandler.readProperty("CandidateEmailId1")));
		TestNGLogUtility.pass("Application is not displayed");
	}

	@And("I check the count of pending feedback on page")
	public void getCountOnPendingReviewPage() {
		int countDispalyedOnFeedbackPage = HMFeedbackPagePOObject.getTotalFeedbackCountForPipelineStageOnPendingReviewPage();
		PropFileHandler.writeProperty("countDispalyedOnFeedbackPage", String.valueOf(countDispalyedOnFeedbackPage));
		TestNGLogUtility.info("Count on pending feedback stage is " + countDispalyedOnFeedbackPage);
	}

	@When("User navigates to {string} page")
	public void navigateToModule(String moduleName) {
		CommonActionObject.navigateToUrl(URLBuilder.getURL(moduleName));
		TestNGLogUtility.info("User navigates to " + moduleName);
	}

	@Then("Verify count on dashboard for pipeline stage is same as on pending feedback page")
	public void verifyCountOnFeedbackPendingAndDashboard() {
		Assert.assertEquals(PropFileHandler.readProperty("countDispalyedOnFeedbackPage"),PropFileHandler.readProperty("PendingReviewCount"));
		TestNGLogUtility.pass("Count on pending feedback page for pipeline stage is same as on dahboard");
	}

	@When("^I click on Give Feedback button for first application$")
	public void click_on_give_feedback_button() {
		HMFeedbackPagePOObject.clickOnGiveFeedbackButtonForFistCandidate();
		TestNGLogUtility.info("Clicking on feedback button for first application");
	}

	@And("I click on application name")
	public void clickOnGivenApplicationName() {
		HMFeedbackPagePOObject.clickOnGivenApplicationName(PropFileHandler.readProperty("CandidateEmailId1"));
		TestNGLogUtility.info("User click on application name");
	}

	@Then("I verify that feedback is displayed for that stage with {string} label")
	public void verifyFeedbackState(String feedbackState) {
		softAssert.assertEquals(cvDetailsPagePO.isFeedbackStateDisplayed(feedbackState), true);
		TestNGLogUtility.pass("Feedback state is same as choosen state");
	}

	@And("I verify that {string} is displayed in place of name of approver")
	public void verifyFeedbackGiverName(String name) {
		softAssert.assertEquals(cvDetailsPagePO.isFeedbackGiverNameDisplayed(name), true);
		TestNGLogUtility.pass("Name of feedback provided is as expected");
	}

	@And("I verify that current stage is {string}")
	public void verifyCurrentStage(String stateStageName) {
		softAssert.assertEquals(cvDetailsPagePO.iscurrentStateStageDisplayed(stateStageName), true);
		TestNGLogUtility.pass("Current state is same as expected");
		softAssert.assertAll();
	}

	@Then("I see {string} is appended before the stage name")
	public void isApprovedAppended(String approved) {
		List<String> displayedStageLabel = Arrays.asList(HMFeedbackPagePOObject.nameDisplayedAfterFeedbackApproved(approved).split(" "));
		List<String> stageName = Arrays.asList(PropFileHandler.readProperty("StageName").split(" "));
		Assert.assertEquals(true, displayedStageLabel.contains(approved));
		Assert.assertEquals(true, displayedStageLabel.containsAll(stageName));
		TestNGLogUtility.pass("Approved is appended before stage name");

	}

	@And("I checked the comment count for first application")
	public void getCommentCountBeforeGivingFeedbackComment() {
		int commentCount = HMFeedbackPagePOObject.getCommentCount();
		PropFileHandler.writeProperty("CommentCount", String.valueOf(commentCount));
		TestNGLogUtility.info("I checked the comment count for first application");
	}

	@Then("I see that the comment count for same application is increased by one")
	public void checkCommentCountAfterGivingFeedbackComment() {
		int commentCount = HMFeedbackPagePOObject.getCommentCount();
		int prevCommentCount = Integer.parseInt(PropFileHandler.readProperty("CommentCount"));
		Assert.assertEquals(commentCount, prevCommentCount + 1);
		TestNGLogUtility.pass("I see that the comment count for same application is increased by "+commentCount);
	}

	@And("I see that the comment given during feedback is displayed")
	public void checkCommentDispalyedAfterFeedback() {
		String feedbackCommentDisplayed = HMFeedbackPagePOObject.getOverAllFeedbackComment();
		Assert.assertEquals(feedbackCommentDisplayed,"[Interview Feedback] Feedback Comment");
		TestNGLogUtility.pass("I see that the comment given during feedback is displayed as "+feedbackCommentDisplayed);
	}

	@And("I see that the star rating given during feedback is displayed")
	public void checkStarRatingDisplayedAfterFeedback() {
		int starRating = HMFeedbackPagePOObject.getOverAllFeedbackStarRating();
		Assert.assertEquals(3, starRating);
		TestNGLogUtility.pass("I see that the star rating given during feedback is displayed as "+starRating);
	}

	@And("I checked the count of pending review for a particular stage")
	public void checkCountOfFirstPipelineStage() {
		if (HMDashboardPagePOObject.isAnyPipelineStageIsThereForFeedback()) {
			int PendingReviewCount = HMDashboardPagePOObject.getCountOfFirstPipelineStage();
			PropFileHandler.writeProperty("PendingReviewCount",String.valueOf(HMDashboardPagePOObject.getCountOfFirstPipelineStage()));
			TestNGLogUtility.info("Feedback Pending count for stage on dashboard is " + PendingReviewCount);
		}
	}

	@When("User do summation of all numbers corresponding to pipeline stages")
	public void summationOfCountOfAllPendingFeedbacksForPipelineStages() {
		if (HMDashboardPagePOObject.isAnyPipelineStageIsThereForFeedback()) {
			PropFileHandler.writeProperty("SummationOfAllPendingReviewsOfStages",String.valueOf(HMDashboardPagePOObject.sumOfCountOfAllPipelineStages()));
			TestNGLogUtility.info("Summation of all numbers corresponding to pipeline stages is "+ PropFileHandler.readProperty("SummationOfAllPendingReviewsOfStages"));
		}
	}

	@And("User get count of Pending Reviews")
	public void summationOfPendingReviewsAndUpcomingInterviews() {
		int pendingReviewCount = HMDashboardPagePOObject.getpendingReviewsCountFromDashboard();
		PropFileHandler.writeProperty("PendingReviewCount",String.valueOf(pendingReviewCount));
		TestNGLogUtility.info("All Pending Review count is  "+ PropFileHandler.readProperty("PendingReviewCount"));

	}

	@Then("Verify that count of summation of pipeline stage and All pending review is same")
	public void compareCounts() {
		Assert.assertEquals(PropFileHandler.readProperty("SummationOfAllPendingReviewsOfStages"),PropFileHandler.readProperty("PendingReviewCount"));
		TestNGLogUtility.pass("Count of summation of all numbers corresponding to pipeline stages is same as count of summation of Pending Reviews and Upcoming Interviews");
	}

	@And("User add group with \"(.*)\" as HR and also as HRSpoc, \"(.*)\" as HM and \"(.*)\" as HMSpoc")
	public void addGrp(String hrName, String hmName, String hmSpocName) {
		String groupName = "TestGroup " + new Date().getTime();
		ManageGroupPagePOObject.addGroup(groupName, hmName, hrName, hmSpocName);
		PropFileHandler.writeProperty("GroupName", groupName);
		TestNGLogUtility.info("User adds group with name "+PropFileHandler.readProperty("GroupName"));
	}
	
	@And("User click on {string} stage mapping button")
	public void clickOnStageMapping(String buttonName)
	{
		ManageGroupPagePOObject.clickOnLinkOnManageGroupPage(buttonName);
		TestNGLogUtility.info("User click on "+buttonName);
	}

	@And("I map {string} to {string} stage")
	public void mapHMToSelectionStageSubStage(String hmName, String stageName) {
		PropFileHandler.writeProperty("FirstSelectionStageName",ManageGroupPagePOObject.getNameOfFirstSelectionStage());
		ManageGroupPagePOObject.addHiringManagerToSelectionStage(hmName, stageName);
		TestNGLogUtility.info("I map " + hmName + " to " + stageName + " stage");
	}

	@And("I map feedback form to {string} stage")
	public void addFeedbackFormToSubstage(String stageName) {
		ManageGroupPagePOObject.addFeedbackFormToSelectionStage(stageName);
		TestNGLogUtility.info("I map feedback form to " + stageName + " stage");
	}

	@And("I created a requirement which is mapped with created group")
	public void createRequirementAndMapGroupAndAddSingleProfile() {
		PropFileHandler.writeProperty("PrefillRequirementName", "Requirement created for HM Automation");
		PropFileHandler.writeProperty("RequirementName", "RequirementTesting " + new Date().getTime());
		RequirementPagePOObject.createRequirement(PropFileHandler.readProperty("GroupName"),PropFileHandler.readProperty("RequirementName"),PropFileHandler.readProperty("PrefillRequirementName"));
		TestNGLogUtility.info("I created a requirement with name "+PropFileHandler.readProperty("RequirementName")+" which is mapped with created group "+PropFileHandler.readProperty("GroupName"));
	}

	@And("I added a single profile in requirement")
	public void addSingleProfile() {
		PropFileHandler.writeProperty("CandidateEmailId1", new Date().getTime() + "TestEmail@yopmail.com");
		RequirementPagePOObject.addSingleProfile(PropFileHandler.readProperty("RequirementId"),PropFileHandler.readProperty("CandidateEmailId1"));
		TestNGLogUtility.info("I added a single profile in requirement with email Id as "+PropFileHandler.readProperty("CandidateEmailId1"));
	}

	@And("I am on Pending Reviews Feed page for {string} stage")
	public void gotoPendingReviewPageForSubstage(String stageName) {
		HMDashboardPagePOObject.clickOnCountOfGivenStage(stageName);
		TestNGLogUtility.info("I am on Pending Reviews Feed page for " + stageName + " stage");
	}

	@And("I logout")
	public void logout() {
		objGenericFunctions.logout();
		TestNGLogUtility.info("I logout");
	}

	@And("I checked the count of pending review for a particular sub stage")
	public void feedbackPendingCountOfSubstageDashboard() {
		if (HMDashboardPagePOObject.isAnyPipelineStageIsThereForFeedback()) {
			int PendingReviewCount = HMDashboardPagePOObject.getCountOfFirstSubstage();
			PropFileHandler.writeProperty("PendingReviewCount", String.valueOf(PendingReviewCount));
			TestNGLogUtility.info("Feedback Pending count for substage on dashboard is " + PendingReviewCount);
		}
	}

	@When("I am on Pending Reviews Feed page for a particular sub stage")
	public void clickOnPendingFeedbackCountForSubStage() {
		HMDashboardPagePOObject.clickOnCountOfFirstSubstage();
		TestNGLogUtility.info("I am on Pending Reviews Feed page for a particular sub stage");
	}
	
	@And("I close current tab and switch to parent tab")
	public void closeAndSwitchToParent()
	{
		HMDashboardPagePOObject.closeCurrentWindowAndSwitchToParent();
		TestNGLogUtility.info("Close and Switch");
	}
	
	@Then("Verify created requirement is not displayed")
	public void verifyRequirementNameNotDisplayed()
	{
		Assert.assertFalse(HMRequirementsPagePOObject.isRequirementNameDisplayed(PropFileHandler.readProperty("RequirementName")));
		TestNGLogUtility.pass("Created requirement is not displayed");
		
	}
	
	@Then("Verify created requirement is displayed")
	public void verifyRequirementNameDisplayed()
	{
		Assert.assertTrue(HMRequirementsPagePOObject.isRequirementNameDisplayed(PropFileHandler.readProperty("RequirementName")));
		TestNGLogUtility.pass("Created requirement is displayed");
		
	}
	
	@When("User clicks on Give Feedback button for given emailId")
	public void clickOnGiveFeedbackButton()
	{
		HMFeedbackPagePOObject.clickOnGiveFeedbackButtonForGivenEId(PropFileHandler.readProperty("CandidateEmailId1"));
		TestNGLogUtility.info("User clicks on Give Feedback button for given emailId");
	}
	
	@And("I move profile on {string} stage")
	public void moveToStage(String stageName)
	{
		cvDetailsPagePO.moveApplicationToStage(stageName);
		TestNGLogUtility.info("User moves application on "+stageName+" stage");
	}
	
	@When("User click on count displayed against requirement")
	public void clickOnAppCountAgaistReq()
	{
		HMRequirementsPagePOObject.clickOnAppCountAndSwitchToTab(PropFileHandler.readProperty("RequirementName"));
		TestNGLogUtility.info("User click on count displayed against requirement");
	}
	
	@And("Verify Give Feedback dd is not displayed on SRP page")
	public void verifyGiveFeedbackButtonIsNotDisplayed()
	{
		Assert.assertFalse(RequirementInboxPagePOObject.isGiveFeedbackButtonDisplayed(PropFileHandler.readProperty("CandidateEmailId1")));
		TestNGLogUtility.pass("Give Feedback button is not displayed");
		
	}
	
	@And("User click on Give Feedback dd for top application")
	public void clickOnGiveFeedbackDD()
	{
		HMFeedbackPagePOObject.clickOnGiveFeedbackButtonForFistCandidate();
		TestNGLogUtility.info("User click on Give Feedback dd for top application");
	}
	
	@And("User click on {string} state")
	public void clickONStageName(String stateName)
	{
		HMFeedbackPagePOObject.clickOnStateNameFromGiveFeedbackDD(stateName);
		TestNGLogUtility.info("User clicks on "+stateName+" state name");
		
	}
	
	@And("User click on {string} button from feedback form lightbox")
	public void clickOnButtonFromGiveGeedbackLB(String buttonName)
	{
		HMFeedbackPagePOObject.clickOnButtonFromGiveFeedbackLB(buttonName);
		TestNGLogUtility.info("User click on "+buttonName+" button from feedback form lightbox");
	}
	
	@And("User fills feedback form")
	public void fillFeedbackForm()
	{
		HMFeedbackPagePOObject.fillFeedbackForm();
		TestNGLogUtility.info("User fills feedback form");
	}
	
	@And("User map created feedback form to {string} stage")
	public void mapGivenFeedbackForm(String stageName)
	{
		ManageGroupPagePOObject.addFeedbackFormToSelectionStage(stageName,PropFileHandler.readProperty("formName"));
		TestNGLogUtility.info("User map created feedback form name-- "+PropFileHandler.readProperty("formName")+" to "+stageName+" stage");	
	}
	
	@Then("Verify that {string} state is displayed in Give Feedback dd")
	public void verifyStateNameDisplayedInGiveFeedbackDD(String stateName)
	{
		HMFeedbackPagePOObject.isGivenStateNameDisplayedInGiveFeedbackDD(stateName);
		TestNGLogUtility.pass(stateName+" state is displayed in Give Feedback dd");
	}
	
	@And("User gets application id from CV Detail page")
	public void getApplicationId()
	{
		PropFileHandler.writeProperty("HMApplicationId", cvDetailsPagePO.getApplicationId());
		TestNGLogUtility.info("Application id is "+PropFileHandler.readProperty("HMApplicationId"));
	}
	
	@And("User click on count for {string}")
	public void clickOnCountTypeFromDashboard(String countForName)
	{
		HMDashboardPagePOObject.clickOnCountFromWidgetFromHMDashboard(countForName);
		TestNGLogUtility.info("User click on count for "+countForName);
	}
	
	@Then("Verify that give feedback dd is displayed for application id")
	public void verifyApplicationIdIsDisplayed()
	{
		Assert.assertTrue(HMDashboardPagePOObject.isGiveFeedbackDDForApplicationIdDisplayed(PropFileHandler.readProperty("HMApplicationId")));
		TestNGLogUtility.info("Give feedback dd is displayed for application id "+PropFileHandler.readProperty("HMApplicationId"));
		
	}
	
	@And("User get count of Upcoming Interview from dashboard")
	public void getCountOfUpcomingInterview()
	{
		int upcomingInterviewCount = HMDashboardPagePOObject.getupcomingInterviewsCountFromDashboard();
		PropFileHandler.writeProperty("UpcomingInterviewCount", String.valueOf(upcomingInterviewCount));
		TestNGLogUtility.info("User get count of Upcoming Interview from dashboard as "+upcomingInterviewCount);
	}
	
	@Then("Verify Give Feedback dd is present on CV Deatil page")
	public void isGiveFeedbackDisplayedOnCvDetailPage()
	{
		Assert.assertTrue(cvDetailsPagePO.isGiveFeedbackDDDisplayed());
		TestNGLogUtility.pass("Give Feedback dd is present on CV Deatil page");
	}
	
	@And("User click on Give Feedback dd from CV Detail page")
	public void clickGiveFeedbacFromCVDetailPage()
	{
		cvDetailsPagePO.clickOnGiveFeedbackFromCVDetailPage();
		TestNGLogUtility.info("User click on Give Feedback dd from CV Detail page");
	}
	
	@Then("Verify that current count of Upcoming Interview is one less than count before giving feedback")
	public void verifyCurrentCountOfUpcomingInterview()
	{
		int upcomingInterviewCount = HMDashboardPagePOObject.getupcomingInterviewsCountFromDashboard();
		Assert.assertEquals(upcomingInterviewCount, Integer.parseInt(PropFileHandler.readProperty("UpcomingInterviewCount"))-1);
		TestNGLogUtility.pass("Current count of Upcoming Interview "+upcomingInterviewCount+" is one less than count before giving feedback "+PropFileHandler.readProperty("UpcomingInterviewCount"));
	}
	
	@And("Verify that the the candidate is not displayed count under section Upcomimg Interviews")
	public void verifyCandidateIsNotDisplayedUnderUpcomingInterview()
	{
		Assert.assertFalse(HMDashboardPagePOObject.isApplicationDisplayedUnderUpcomingInterviewSection(PropFileHandler.readProperty("HMApplicationId")),"Candidate Name is present under the Upcoming Interview Section");
		TestNGLogUtility.pass("Candidate Name is not present under the Upcoming Interview Section");
	}
	
	@And("User sets {string} from AM PM dd")
	public void setAMPMFromDD(String value)
	{
		basicInterview.setAMPM(value);
		TestNGLogUtility.info("User sets "+value+" from AM PM dd");
	}
	
	@Then("Verify application is displayed under Upcoming Interview section")
	public void verifyApplicationIdDisplayedUnderUpcomingInterviewSection()
	{
		Assert.assertTrue(HMDashboardPagePOObject.isApplicationDisplayedUnderUpcomingInterviewSection(PropFileHandler.readProperty("HMApplicationId")),"Application is not present");
		TestNGLogUtility.pass("Application id "+PropFileHandler.readProperty("HMApplicationId")+" is displayed under Upcoming Interview section");
	}
	
	@When("User clicks application under upcoming interview from dashboard")
	public void clickONApplicationFromUpcomingInterview()
	{
		HMDashboardPagePOObject.clickOnApplicationIDFromUpcomingSection(PropFileHandler.readProperty("HMApplicationId"));
		TestNGLogUtility.info("User clicks application under upcoming interview from dashboard");
	}
	
	@And("I verify that current stage for given application id is {string} from SRP")
	public void verifyStageFromSRP(String stage)
	{
		Assert.assertTrue(RequirementInboxPagePOObject.isStageNameSameForGivenApplicationID(PropFileHandler.readProperty("HMApplicationId"),stage),"Stage not displayed as expected");
		TestNGLogUtility.pass("Current stage is "+stage+" for given application id "+PropFileHandler.readProperty("HMApplicationId"));
	}
	
	@And("User map {string} feedback form to {string} state")
	public void mapFeedbackFormOnStage(String formName, String stageName)
	{
		ManageGroupPagePOObject.addFeedbackFormToSelectionStage(stageName,formName);
		TestNGLogUtility.info("User map created feedback form name-- "+formName+" to "+stageName+" stage");	
	}
	
	@Then("Verify give feedback lightbox is not displayed")
	public void verifyAbsenceOfLightbox()
	{
		Assert.assertFalse(HMFeedbackPagePOObject.isFeedbackFormLightboxDisplayed(), "Lightbox is displayed");
		TestNGLogUtility.pass("Give feedback lightbox is not displayed");
	}
	
	@And("Verify that {string} button is displayed for application")
	public void verifyPresenceOfButton(String btnName)
	{
		Assert.assertTrue(cvDetailsPagePO.isButtonDisplayed(btnName), btnName+ " is not displayed");
		TestNGLogUtility.pass(btnName+" is displayed");
	}
	
	@And("Verify that {string} button is not displayed for application")
	public void verifyAbsenceOfButton(String btnName)
	{
		Assert.assertFalse(cvDetailsPagePO.isButtonDisplayed(btnName), btnName+ " is displayed");
		TestNGLogUtility.pass(btnName+" is not displayed");
	}
	
	@And("User click on count displayed against applications")
	public void clickOnAllApplicationCountFromHMDashboard()
	{
		HMDashboardPagePOObject.clickOnApplicationCountFromDashboard();
		TestNGLogUtility.info("User click on count displayed against applications");
	}
	
	@Then("Verify Assessment section is displayed")
	public void verifyPresenceOfAssessmentFeedback()
	{
		Assert.assertTrue(cvDetails.verifyThePresenceOfAssessmentDiv(), "Assessment div is not present on the CV Details Page");
		TestNGLogUtility.pass("Assessment div is present on the CV Details Page");
	}

	@Then("Verify Assessment section is not displayed")
	public void verifyAbsenceOfAssessmentFeedback()
	{
		Assert.assertFalse(cvDetails.verifyThePresenceOfAssessmentDiv(), "Assessment div is present on the CV Details Page");
		TestNGLogUtility.pass("Assessment div is not present on the CV Details Page");
	}
	
	@And("User turn {string} Feedback Visibility Settings")
	public void toggleFeedbackVisibilitySetting(String changeTo)
	{
		objManageSubuser.toggleFeedbackVisibilitySettings(changeTo);
		TestNGLogUtility.info("User turn "+changeTo+" Requisition Details Settings");
	}
	
	@And("User save feedback visibility setting")
	public void saveFeedbackVisibility()
	{
		objManageSubuser.saveFeedbackVisibilitySetting();
		TestNGLogUtility.info("User save feedback visibility setting");
	}
	
	@And("User provides Interview Date as next month's day one")
	public void fillInterviewDateAsNextMonth()
	{
		basicInterview.setDateAsNextMonthFirst();
		TestNGLogUtility.info("User provides Interview Date as next month's day one");
	}
	
	@When("User click on {string} button on confirmation box")
	public void clickOnBtnOnDiscardLB(String btnName)
	{
		HMFeedbackPagePOObject.clickOnButtonOnConfirmationBox(btnName);
		TestNGLogUtility.info("User click on "+btnName+" button on confirmation box");
	}
	
}
