package com.naukri.stepdefinitions.Requirements;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.pageobjects.HiringManager.ManageGroupPagePO;
import com.naukri.pageobjects.HiringManager.RequirementPagePO;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.pageobjects.Requirements.RequirementOverviewPagePO;
import com.naukri.pageobjects.Requirements.RequirementOverviewPagePO.AssignVendorPagePO;
import com.naukri.pageobjects.Settings.ManageGroupPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class RequirementOverviewStepDef {

	RequirementOverviewPagePO requirementOverviewPagePO = (RequirementOverviewPagePO) PageObjectWrapper.getObject(RequirementOverviewPagePO.class);
	AssignVendorPagePO assignVendorPagePO = (AssignVendorPagePO) PageObjectWrapper.getInnerClassObject(RequirementOverviewPagePO.class, AssignVendorPagePO.class);
	ManageGroupPagePO objManageGroupPagePO = (ManageGroupPagePO) PageObjectWrapper.getObject(ManageGroupPagePO.class);
	AddASingleProfilePagePO objAddASingleProfilePagePO = (AddASingleProfilePagePO) PageObjectWrapper.getObject(AddASingleProfilePagePO.class);
	RequirementPagePO objRequirementPagePO = (RequirementPagePO) PageObjectWrapper.getObject(RequirementPagePO.class);
	RequirementCreationPagePO requirementCreationPagePO = (RequirementCreationPagePO) PageObjectWrapper.getObject(RequirementCreationPagePO.class);

	String commentsGiven, grpName = "";
	List<String> lstGroupDetails = new ArrayList<String>();

	@Then("Verify Job types posted with action options such as {string} with {string}")
	public void i_must_see_the_Job_types_I_have_posted_with_action_options_such_as(String listOfOptions, String job) {
		Assert.assertTrue(requirementOverviewPagePO.verifyListOfOptionPresentForAJob(listOfOptions, job),
				"The list of options aren't as expected");
		TestNGLogUtility.pass("The list of options matched for the job");
	}

	@When("User click on {string} action of {string}")
	public void i_click_on_action_of(String jobOption, String jobPostingType) {
		requirementOverviewPagePO.clickOnJobOPtionForAJob(jobOption, jobPostingType);
	}

	@When("User click on Assign Vendor for the requirement created")
	public void i_click_on_Assign_Vendor_for_the_requirement_created() {
		requirementOverviewPagePO.clickAssignVendorOnRequirmentOverviewPage();
	}

	@Then("User should be able to see the text {string} as the heading of the lightbox")
	public void i_should_be_able_to_see_the_text_as_the_heading_of_the_lightbox(String headingText) {
		Assert.assertTrue(assignVendorPagePO.verifyTheDisplayOfAssignVendorLightbox(headingText),
				"The heading text of the lightbox is not displayed correctly.");
		TestNGLogUtility.pass("The heading text of the lightbox is displayed correctly.");
	}

	@When("User select the vendor name for assigning the requirement")
	public void i_select_the_vendor_name_for_assigning_the_requirement() {
		assignVendorPagePO.assignRequirementToVendor();
	}

	@When("User click on Assign Vendor button on Assign Vendor Lightbox")
	public void i_click_on_Assign_Vendor_button_on_Assign_Vendor_Lightbox() {
		assignVendorPagePO.clickAssignButton();
	}

	@Then("User should see the vendor assignment success message as {string}")
	public void i_should_see_the_vendor_assignment_success_message_as(String successMessage) {
		Assert.assertTrue(requirementOverviewPagePO.verifyTheSuccessMessage(successMessage),
				"The success message of the vendor requirement assignment is not displayed");
		TestNGLogUtility.pass("The success message of vendor requirement assignment is displayed");
	}

	@When("User click on the tab {string} on requirement overview page")
	public void User_click_on_the_tab_on_requirement_overview_page(String requirementTabName) {
		requirementOverviewPagePO.clickOnTabOnRequirementOverviewPage(requirementTabName);
		TestNGLogUtility.info("User click on the tab " + requirementTabName + " on requirement overview page");
	}

	@Then("Verify User see the {string} as the heading of the tab")
	public void i_should_be_able_to_see_the_as_the_heading_of_the_tab(String headingText) {
		Assert.assertTrue(requirementOverviewPagePO.verifyTheTextOfTabsOnRequirementOverviewPage(headingText),
				headingText + " is not visible on this tab");
		TestNGLogUtility.pass(headingText + " is visible on this tab");
	}

	@Then("Verify User see the {string}")
	public void i_must_see_the(String expectedStringForSalary) {
		Assert.assertTrue(requirementOverviewPagePO.verifyTheTextOfSalaryForRequirementOnRequirementDetailsTab(expectedStringForSalary),
				expectedStringForSalary + " is not displayed");
		TestNGLogUtility.pass(expectedStringForSalary + " is not displayed");
	}

	@And("User enter comments on Requirement Overview page")
	public void enterCommentsOnReqOverViewPage() {
		commentsGiven = "This is test comments";
		requirementOverviewPagePO.enterCommentsOnRequiremntOverviewPage(commentsGiven);
		TestNGLogUtility.info("User enter comments on Requirement Overview page");
	}

	@Then("User Verify the Comment given is displayed")
	public void userVerifyTheCommentGivenIsDisplayed() {
		Assert.assertTrue(requirementOverviewPagePO.isCommentDisplayed(commentsGiven));
		TestNGLogUtility.pass("User Verify the Comment given is displayed");
	}

	@Then("User click on view button of Naukri Private Job on Overview page")
	public void userClickOnViewButtonOfNaukriPrivateJob() {
		requirementOverviewPagePO.clickViewButtonOfNaukriPrivateJob();
		TestNGLogUtility.info("User click on view button of Naukri Private Job on Overview page");
	}

	@Then("Candidate applies on the job posted by the user through Naukri Platform")
	public void candidateAppliesontheJobPostedbytheUserThroughNaukriPlatform(DataTable dt) {
		List<String> lstCredential = dt.asList(String.class);
		requirementOverviewPagePO.loginAndApplyForNaukriPrivateJob(lstCredential.get(0), lstCredential.get(1));
		TestNGLogUtility.info("Candidate applies on the job posted by the user through Naukri Platform");
	}

	@Then("User Verify The count of the applications will be present as a summation of all applications on the requirement overview page")
	public void userVerifyTheCandidateApplicationWillBeMappedOnTheRequirement() {
		Assert.assertTrue(requirementOverviewPagePO.isApplyCountIncreased());
		TestNGLogUtility.pass("The count of the applications is present as a summation of all applications on the requirement overview page");
	}

	@Then("User Verify on the count will navigate to the requirement inbox page")
	public void user_Verify_on_the_count_will_navigate_to_the_requirement_inbox_page() {
		Assert.assertTrue(requirementOverviewPagePO.clickOnCountOfNaukriPrivateJob());
		TestNGLogUtility.pass("User Verify on the count will navigate to the requirement inbox page");
	}

	@Then("User click on post button on Requirement Overview Page")
	public void userClickOnPostButtonOfReqOverViewPage() {
		requirementOverviewPagePO.clickPostButton();
		TestNGLogUtility.info("User click on post button on Requirement Overview Page");
	}

	@When("User map HiringManager {string} to {string} stage")
	public void mapHiringManagerToStage(String hmName, String stageName) {
		objManageGroupPagePO.addHiringManagerToSelectionStage(hmName, stageName);

	}

	@When("User fill Group Details for a Requirement")
	public void userEditRequirementAndFillGroupDetails(io.cucumber.datatable.DataTable dt) {
		lstGroupDetails = dt.asList(String.class);
		if (lstGroupDetails.get(0).trim().equals("NoGroup")) {
			grpName = PropFileHandler.readProperty("groupName");
		} else {
			grpName = PropFileHandler.readProperty(lstGroupDetails.get(0).trim());
		}
		objAddASingleProfilePagePO.selectGroupForNewRequirement(grpName);
		objAddASingleProfilePagePO.selectVisibilityOption(lstGroupDetails.get(1));
	}

	@When("I am adding a single profile from Requirement OverView page")
	public void addASingleProfilefromRequirementOverViewpage(io.cucumber.datatable.DataTable dt) {
		String candidateEmailId;
		List<String> list = dt.asList(String.class);
		if (list.get(0).equals("")) {
			candidateEmailId = "Candidate" + CommonAction.generateRandomStrings(9, "Alphanumeric") + "@yopmail.com";
		} else {
			candidateEmailId = list.get(0).toString();
		}
		objRequirementPagePO.addSingleProfile("", candidateEmailId);
	}

	@When("User records the selection stages of the requirement created")
	public void user_records_the_selection_stages_of_the_requirement_created() {
		requirementOverviewPagePO.prepareSelectionStageMap();
	}

	@Then("User should observe that the selection stage in customize selection state and requirement level selection state is same")
	public void user_should_observe_that_the_selection_stage_in_customize_selection_state_and_requirement_level_selection_state_is_same() {
		Assert.assertTrue(requirementOverviewPagePO.verifyEqualityOfSelectionStages(),
				"The selection stage for requirement overview page and setting's selection is not same");
		TestNGLogUtility.pass("The selection stage for requirement overview page and setting's selection is same");
	}

	@When("User redirects to the requirement overview page of the created requirement")
	public void user_redirects_to_the_requirement_overview_page_of_the_created_requirement() {
		requirementOverviewPagePO.redirectToRequirementCreated();
	}

	@When("User clicks on {string} for the created requirement")
	public void user_clicks_on_for_the_created_requirement(String actionType) {
		requirementOverviewPagePO.clickOnActionButtonForRequirement(actionType);
	}

	@Then("User should be able to view the new selection stage addded")
	public void user_should_be_able_to_view_the_new_selection_stage_addded() {
		Assert.assertTrue(requirementOverviewPagePO.verifyTheSelectionStageAddedIsVisible(),
				ManageGroupPO.selectionStage + " is not visible");
		TestNGLogUtility.pass(ManageGroupPO.selectionStage + " is visible");
	}

	@Then("User should be able to see attached questionnaire under questionnaire tab")
	public void user_should_be_able_to_see_attached_questionnaire_under_questionnaire_tab() {
		Assert.assertTrue(requirementOverviewPagePO.verifyAttachedQuestionnaireInRequirement(RequirementCreationStepDef.questionnaireName), "Correct Questionnaire is not attached with requirement");
		TestNGLogUtility.pass("Questionnaire is visible same as attached");

	}

	@When("User click on the {string} tab on requirement overview page")
	public void User_click_on_the_tabon_requirement_overview_page(String requirementTabName) {
		requirementOverviewPagePO.clickOnTabsOnRequirementOverviewPage(requirementTabName);
	}

	@Then("User should be able to see {string} field with filed value {string} on requirment overview page")
	public void user_should_be_able_to_see_attached_questionnaire_under_questionnaire_tab(String fieldName, String value) {
		Assert.assertTrue(requirementOverviewPagePO.verifyfieldOnRequirementOverviewPage(fieldName, value), "Correct " + fieldName + " is not displaying on requirement Details page");
		TestNGLogUtility.pass("Correct " + fieldName + " is displaying on requirement Details page");
	}

	@Then("User verifies {string} is displayed on overview page")
	public void userVerifiesJobDisplayedOnOverviewPage(String job) {
		Assert.assertTrue(requirementOverviewPagePO.verifyJobTitleDisplayed(job), "job is not displayed on overview page");
	}

	@Then("verify the status of requirement is {string} on overviewPage")
	public void verifyStatusOnOverviewPage(String status) {
		Assert.assertTrue(requirementOverviewPagePO.checkStatusOfRequirement(status), "status of req not updated");
	}

	@Then("User should be able to see walkin details section")
	public void User_should_be_able_see_walkin_details_section(DataTable dataTable) {
		List<String> fieldNames = dataTable.asList(String.class);
		for (String fieldName : fieldNames) {
			Assert.assertTrue(requirementOverviewPagePO.verifyWalkinFieldOnRequirementDetailsSection(fieldName), "Correct " + fieldName + " is not displaying on requirement Details page");
			TestNGLogUtility.pass("Correct " + fieldName + " is displaying on requirement Details page");
		}
	}

	@When("User click on the google map url")
	public void User_click_on_google_map_url() {
		requirementOverviewPagePO.clickOnMapUrl();
	}

	@Then("User should be able to see the corrcet Google URL")
	public void User_should_be_able_to_see_the_corrcet_Google_URL() {
		Assert.assertTrue(requirementOverviewPagePO.verifyUrlOpenPage(), "Correct Google Map URL is not being opened");
		TestNGLogUtility.pass("Correct Google Map URL is being opened");

	}

	@Then("Verify Requistion Details tab is visible on requirement overview page")
	public void verifyRequisitionDetailsTabDisplayedOnOverviewPage() {
		Assert.assertTrue(requirementOverviewPagePO.clickOnRequisitionDetailsTab(), "requisition details is not displayed");
	}

	@When("User click on {string} on requirement overview page")
	public void userCLicksOnTabOnRquirementOverview(String tabName) {
		requirementOverviewPagePO.clickOnTabOnRequirementOverviewPage(tabName);
	}

	@Then("Verify {string} job is expired on overview page")
	public void verifyJobIsExpired(String job) {
		Assert.assertTrue(requirementOverviewPagePO.verifyJobIsExpired(job));
	}

	@When("User clicks on Cross on update jobs lightbox")
	public void clickOnCancelOnJobUpdate() {
		requirementOverviewPagePO.clickOnCancelOnJobUpdate();
	}

	@Then("verify currency is updated on overview page to {string}")
	public void verifyCurrencyUpdatedOnOverviewPage(String expectedText) {
		Assert.assertTrue(requirementOverviewPagePO.verifyTheTextOfSalaryForRequirementOnRequirementDetailsTab(expectedText));
	}

	@When("User sets visibilty to {string} from requirement overview page")
	public void userSetsVisibilityFRomOverviewPage(String visibleTo) {
		requirementCreationPagePO.setTheVisibilityStatusOfCandidate(visibleTo);
		requirementOverviewPagePO.clickSaveVisibilty();
	}

	@When("User sets visibilty to {string} from requirement overview page and select {string}")
	public void userSetsVisibiltyToSelectedRecruiter(String visibleTo, String recruiter)
	{
		requirementCreationPagePO.setTheVisibilityStatusOfCandidate(visibleTo);
		requirementOverviewPagePO.enterrecruiterNameUndervisibleTo(recruiter);
		requirementOverviewPagePO.clickSaveVisibilty();
	}

	@Then("Verify that under requirement category Visible to {string} is displayed")
	public void verifyThatVisibleOnRequirementOverview(String visibleTo) {
		Assert.assertTrue(requirementOverviewPagePO.verifyVisibleToAllRequirementDetails(visibleTo), "visible to text not displayed ");
	}

	@When("user clicks on Set Visibilty on overview page")
	public void userClicksOnSetVisibility() {
		requirementOverviewPagePO.clickOnSetVisibility();
	}

	@Then("verify all the tabs on requirement overview page ie {string}")
	public void verifyAllTabsOnRequirementOverviewPage(String tabs) {
		Assert.assertTrue(requirementOverviewPagePO.verifyListOfTabsOnOverviewPage(tabs), "all tabs not displayed");
	}

	@Then("Verify Add a single profile url is displayed")
	public void verifyAddSingleProfileURLDisplayed() {
		Assert.assertTrue(requirementOverviewPagePO.verifyAddSingleProfileURLDisplayed(), "not navigated to single profile url");
	}

	@When("user notes the projectId of requirement")
	public void getProjectid() {
		requirementOverviewPagePO.getProjectIdOfReq();
	}

	@When("User click on {string} of menu {string} Actions on overview page")
	public void clickOnActionButtonOnOverview(String selectOption, String moreBtn)
	{
		requirementOverviewPagePO.clickOnMoreActionButton(selectOption,moreBtn);
	}
	@When("User hover on {string} on overview page")
	public void userHoverOnOverviewPageOnActionBtn(String moreBtn)
	{
		requirementOverviewPagePO.clickOnActionsBTnOnReqOverview(moreBtn);
	}
	@When("User clicks on {string} on overview page")
	public void clickOnSelectionStage(String stage)
	{
		requirementOverviewPagePO.clickOnTabOnRequirementOverviewPage(stage);
	}
	@Then("Verify the new stage {string} is displayed on overview page")
	public void verifyNewStageDisplayedOnOverviewPage(String stage)
	{
		Assert.assertTrue(requirementOverviewPagePO.verifyNewStageDisplayed(stage),"stage name is not displayed on overview page");
	}
//	@Then("Verify all the requirement details filled while creating requirement")
//	public void verifyAllTheRquirementDetailsFilledWHileCreatingRequirement()
//	{
//		Assert.assertTrue(requirementOverviewPagePO.verifyAllcontentsOnRequirementDetails(),"details of requirement not displayed correctly");
//	}
	@When("User clicks on View questionaire")
	public void userClicksOnViewQuestionaire()
	{
		requirementOverviewPagePO.clickViewQuestionaire();
	}
	@Then("Verify {string} questions in questionaire are created and displayed on preview on overview page")
	public void verifyQuestionsDisplayedOnOverview(String countQuestions)
	{
		Assert.assertTrue(requirementOverviewPagePO.verifyQuestionsDisplayedOnOverview(countQuestions),"Questions not displayed on questionaire");
	}
	@When("User clicks on qustionaire tab on overview page")
	public void userClicksOnQuestionaireTab()
	{
		requirementOverviewPagePO.clickOnQuestionaireTab();
	}
	@When("User enters {string} under comments section")
	public void userEntersCommentOnOverview(String comment)
	{
		requirementOverviewPagePO.enterCommentsOnRequiremntOverviewPage(comment);
	}
	@Then("verify comment {string} displayed on overview page")
	public void verifyCommentDisplayedOnOverviewPage(String comment)
	{
		Assert.assertTrue(requirementOverviewPagePO.verifyCommentOnOverview(comment),"comment is not displayed on overview page");
	}
	@When("User checks on Apply reponse filters on overview page")
	public void userChecksOnApplyResponseFilters()
	{
		requirementCreationPagePO.customFiltersChkbox();
	}
	@Then("Verify response filters page is displayed")
	public void verifyResponseFilterTabisActive()
	{
		Assert.assertTrue(requirementCreationPagePO.verifyResponseFilterTabActive(),"response filter tab is not active");
	}
	@Then("verify response filters on page")
	public void verifyResponseFiltersOnPage()
	{
		Assert.assertTrue(requirementOverviewPagePO.verifyresponseFiltersOnPage(),"response filters displayed ar not correct");
	}
	@When("user sets the status to {string}")
	public void userSetsTheStatusOnOverviewPage(String status)
	{
		requirementOverviewPagePO.selectStatusOnOverview(status);
	}
	@Then("verify the status of requirement is {string} on overview page")
	public void verifyStatusRequirementOnOverviewPage(String postedVariable)
	{
		Assert.assertTrue(requirementOverviewPagePO.verifyStatusOfReqOnOverviewPage(postedVariable),"status on requirement is posted even even job is not posted");
	}
	@When("user clicks on post on requirement overview page")
	public void userClicksOnPostOnrequirementOverview()
	{
		requirementOverviewPagePO.clickPostButton();
	}
	@Then("verify requirement url contains requirement id")
	public void verifyRequirementURLONOverview()
	{
		Assert.assertTrue(requirementOverviewPagePO.verifyRequirementURLOnOveview(),"requirement id is not present in requirement url");
	}
	@Then("verify job is visible on naukri plateform")
	public void verifyJobIsVisibleOnnaukriPlatform()
	{
		Assert.assertTrue(requirementOverviewPagePO.verifyjobIsVisibleOnNaukri(),"job not visible on naukri plateform");
	}
	@Then("verify the row displayed on history")
	public void verifyHistoryRowOnOverviewPage()
	{
		Assert.assertTrue(requirementOverviewPagePO.verifyHistoryRowOnOverviewPage(),"history is not displayed on overview page");
	}
	@Then("verify the search is based on {string}")
	public void verifySearchBasedOnPamerterPassed(String filter)
	{
		Assert.assertTrue(requirementOverviewPagePO.verifySearchBasedOnFilter(filter),"search is not based on filter");
	}
	@Then("Verify the requirement details on overview page")
	public void verifyrequirementDetailsOnOverviewPage()
	{
		Assert.assertTrue(requirementOverviewPagePO.verifyRequirementDetailsOnPage(),"requirement details are not as expected");
	}
	@Then("Verify that user see {string} tab on overview page redirected from listing page")
	public void verifyPresenceOftabOnReqOverview(String tabName)
	{
		Assert.assertTrue(requirementOverviewPagePO.isButtonDisplayed(tabName), tabName+ " is not displayed");
		TestNGLogUtility.pass(tabName+" is displayed");
	}

}
