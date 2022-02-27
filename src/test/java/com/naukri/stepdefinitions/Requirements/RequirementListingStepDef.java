package com.naukri.stepdefinitions.Requirements;

import com.naukri.pageobjects.Requirements.RequirementOverviewPagePO;
import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.pageobjects.Requirements.RequirementListingPagePO;
import com.naukri.stepdefinitions.VendorPlatform.AttachStepDef;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RequirementListingStepDef {

	RequirementListingPagePO requirementListingPagePO = (RequirementListingPagePO) PageObjectWrapper.getObject(RequirementListingPagePO.class);
	RequirementCreationStepDef requirementCreation = (RequirementCreationStepDef) PageObjectWrapper.getObject(RequirementCreationStepDef.class);
	RequirementCreationPagePO requirementCreationPagePO = (RequirementCreationPagePO) PageObjectWrapper
			.getObject(RequirementCreationPagePO.class);
	RequirementOverviewPagePO requirementOverviewPagePO = (RequirementOverviewPagePO) PageObjectWrapper.getObject(RequirementOverviewPagePO.class);

	@Then("Verify User see the Filter by {string}")
	public void i_should_be_able_to_see_the_Filter_by(String filterText) {
		Assert.assertTrue(requirementListingPagePO.checkThePresenceOfStatusFilter(filterText),
				"The " + filterText + " is not displayed");
		TestNGLogUtility.pass("The " + filterText + " is displayed");
	}

	@Then("Verify User see text {string} on status filter")
	public void i_should_be_able_to_see_text_on_status_filter(String statusFilterText) {
		Assert.assertTrue(requirementListingPagePO.checkTheDefaultStatusFilterText(statusFilterText),
				"The default " + statusFilterText + " is not displayed");
		TestNGLogUtility.pass("The default " + statusFilterText + " is displayed");
	}

	@When("User click on filter by status")
	public void i_click_on_filter_by_status() {
		requirementListingPagePO.clickOnRequirementStatusFilter();
	}

	@Then("Verify User see the checkbox {string} label is {string}")
	public void i_should_see_the_checkbox_label_is(String checkboxLabel, String checkboxLabelState) {
		Assert.assertTrue(requirementListingPagePO.checkTheDefaultStateOfRequirementFilter(checkboxLabel, checkboxLabelState),
				"The checkbox " + checkboxLabel + " is not in " + checkboxLabelState + " state");
		TestNGLogUtility.pass("The checkbox " + checkboxLabel + " is in " + checkboxLabelState + " state");
	}

	@Then("Verify User see text {string} on requirement source filter")
	public void i_should_be_able_to_see_text_on_requirement_source_filter(String defaultTextOnSourceFilter) {
		Assert.assertTrue(requirementListingPagePO.verifyTheDefaultTextOnRequirementSourceFilter(defaultTextOnSourceFilter),
				"The " + defaultTextOnSourceFilter + " is not displayed as the default requirement source");
		TestNGLogUtility.pass("The " + defaultTextOnSourceFilter + " is displayed as the default requirement source");
	}

	@When("User click on filter by requirement source")
	public void i_click_on_filter_by_requirement_source() {
		requirementListingPagePO.clickOnRequirementSourceDD();
	}

	@Then("Verify User see the list as {string}")
	public void i_should_see_the_list_as(String expectedRequirementSourceString) {
		Assert.assertTrue(requirementListingPagePO.compareTheListOfRequirementSource(expectedRequirementSourceString),
				"The list of requirement source is not as expected");
		TestNGLogUtility.pass("The list of requirement source is as expected");
	}

	@Then("Verify User see the requirement created above")
	public void i_should_be_able_to_see_the_requirement_created_above() {
		Assert.assertTrue(requirementListingPagePO.checkTheVisibilityOfRequirementName(),
				RequirementCreationPagePO.requirementName + " is not visible on the requirement listing page");
		TestNGLogUtility.pass(RequirementCreationPagePO.requirementName + " is visible on the requirement listing page");
	}

	@When("User type in the requirement name in the search bar")
	public void i_type_in_the_requirement_name_in_the_search_bar() {
		requirementListingPagePO.typeInRequirementNameInRequirementSearchFilter();
	}

	@When("User type in the requirement id in the search bar")
	public void userTypeInRequirementIdInSearchBar() {
		requirementListingPagePO.typeINRequirementIdInRequirementSearchFilter();
	}

	@When("User click on the search button on requirement listing")
	public void i_click_on_the_search_button_on_requirement_listing() {
		requirementListingPagePO.clickOnSearchForRequirement();
	}

	@Then("Verify User see the searched requirement on the listing page")
	public void i_should_be_able_to_see_the_searched_requirement_on_the_listing_page() {
		Assert.assertTrue(requirementListingPagePO.checkTheVisibilityOfRequirementName(),
				RequirementCreationPagePO.requirementName + " is not visible on the requirement listing page after search");
		TestNGLogUtility.pass(RequirementCreationPagePO.requirementName + " is visible on the requirement listing page after search");
	}

	@Then("User should be able to see the label {string} sources")
	public void i_should_be_able_to_see_the_label_sources(String souceCountString) {
		Assert.assertTrue(!requirementListingPagePO.verifyTheSourceCountForRequirementOnRequirementListing(souceCountString),
				"The sources for the requirement is not displayed correctly");
		TestNGLogUtility.pass("The sources for the requirement is displayed correctly");
	}

	@When("User click on the status graph of the created requirement")
	public void i_click_on_the_status_graph_of_the_created_requirement() {
		requirementListingPagePO.clickOnStatusRequirementBasisRequirementName();
	}

	@Then("Verify User see the status graph {string}")
	public void i_should_be_able_to_see_the_status_graph(String expectedState) {
		Assert.assertTrue(requirementListingPagePO.checkTheStateOfRequirementStatusGraph(expectedState),
				"The requirement graph status is not behaving as intended");
		TestNGLogUtility.pass("The requirement graph status is not behaving as intended");
	}

	@When("User hover on {string} for a requriement")
	public void i_hover_on_for_a_requriement(String optionForRequirement) {

	}

	@When("User hover on {string} for a {string}")
	public void i_hover_on_for_a(String optionForRequirement, String requirementType) {
		requirementListingPagePO.hoverOnRequirementOptions(optionForRequirement, requirementType);
	}

	@Then("User should be able to see the list of option available {string} under {string}")
	public void i_should_be_able_to_see_the_list_of_option_available_under(String expectedOptions, String forRequirementOption) {

	}

	@Then("Verify User see the list of option available {string} under {string} for {string}")
	public void i_should_be_able_to_see_the_list_of_option_available_under_for(String listOfExpectedOptions, String requirementOptionType, String requirementType) {
		Assert.assertTrue(requirementListingPagePO.compareTheListOfOptions(listOfExpectedOptions, requirementOptionType, requirementType),
				"The options available under the option " + requirementOptionType + " is not displayed correctly");
		TestNGLogUtility.pass("The options available under the option " + requirementOptionType + " is displayed correctly");
	}

	@When("User click on {string} of menu {string} of {string}")
	public void i_click_on_of_menu_of(String requirementOption, String optionInList, String requirementType) {
		requirementListingPagePO.clickOnRequirementOptionSubMenu(optionInList, requirementOption, requirementType);
		// more actions , add single profile , rquirement created
	}

	@Then("Verify User not see the download by index lightbox open")
	public void i_should_not_see_the_download_by_index_lightbox_open() {
		Assert.assertTrue(!requirementListingPagePO.presenceOfDownloadByIndexOnRequirementListing(),
				"The requirement listing page's download by index is visibility");
		TestNGLogUtility.pass("The requirement listing page's download by index is visibility");
	}

	@When("User {string} the checkbox with the label {string}")
	public void i_the_checkbox_with_the_label(String checkStatus, String checkboxLabel) {
		requirementListingPagePO.changeStateOfStatusFilterOnRequirementListingPage(checkStatus, checkboxLabel);
	}

	@When("User record the total count of requirement in system")
	public void i_record_the_total_count_of_requirement_in_system() {
		requirementListingPagePO.recordTotalCount(0);
	}

	@When("User record the total count of requirement")
	public void i_record_the_total_count_of_requirement() {
		requirementListingPagePO.recordTotalCount(1);
	}

	@Then("Verify User see the total number of requirement less than the number of requirement recorded in all the requirement status according to {string}")
	public void i_should_see_the_total_number_of_requirement_less_than_the_number_of_requirement_recorded_in_all_the_requirement_status(String account) {
		Assert.assertTrue(requirementListingPagePO.checkForRequirementCount(account),
				"The total system requirement is not equal to the number of requirements on status");
		TestNGLogUtility.pass("The total system requirement is equal to the number of requirements on status");
	}

	@When("User read the first requirement name")
	public void i_read_the_first_requirement_name() {
		requirementListingPagePO.readTheRequirementName();
	}

	@And("User adds {string} notification on Dashboard if not present")
	public void addNotificationOnDashboardIfNotPresent(String notificationOnDashboard) {
		requirementListingPagePO.addNotificationOnDashboardIfNotPresent(notificationOnDashboard);
	}

	@When("User clicks on count for the {string}")
	public void clickCountOnNotoficationOnDashboard(String notificationOnDashboard) {
		requirementListingPagePO.clickCountOnNotoficationOnDashboard(notificationOnDashboard);
	}

	@Then("Verify Total count of requirments matchs that on Dashboard")
	public void totalCountOnDashBoardMatchOnReqListing() {
		Assert.assertTrue(requirementListingPagePO.totalCountOnDashBoardMatchOnReqListing(),
				"Total count of requirments does not match that on Dashboard");
		TestNGLogUtility.pass("Total count of requirments matches that on Dashboard");
	}

	@When("User click on the application count against requirement.")
	public void user_click_on_the_application_count_against_requirement() {
		requirementListingPagePO.clickOnApplicationCount(requirementCreation.requirementName);
	}

	@Then("Verify User see the Filter icon for categorization of requirements")
	public void verify_user_see_the_filter_icon_for_requirement_categorization() {
		Assert.assertTrue(requirementListingPagePO.verifyCategorizationOfRequirement(), "job categorization filter is not displayed");
		TestNGLogUtility.pass("All the requirement categories matches");
	}

	@When("User click on filter by Requirement categorization")
	public void user_click_on_filter_requirement_categorization() {
		requirementListingPagePO.clickOnRefineRequirementFilter();
	}

	@Then("Verify User see the list as {string},{string},{string},{string},{string}")
	public void verify_user_see_list_of_reqCategorization_filter(String industry, String funcArea, String group, String createdBy, String visible) {
		Assert.assertTrue(requirementListingPagePO.verifyCategorizationFilters(industry, funcArea, group, createdBy, visible), "categorization of filters not displayed");
	}

	@When("User clicks on comments icon on the requirement created")
	public void user_clicks_on_comments_icon_req_created() {
		requirementListingPagePO.userClicksOnCommentsIconReqCreated();
	}

	@When("User enters comment on the listing page")
	public void user_enters_comments_on_listing_page() {
		requirementListingPagePO.enterComment();
	}

	@Then("user verifies the count of comments should be {string}")
	public void user_verifies_count_comments(String countComment) {
		Assert.assertTrue(requirementListingPagePO.verifyTheCountOfCommentOnListingPage(countComment), "count of comment is not displayed correctly");
	}

	@When("User clicks on delete icon for the latest comment")
	public void user_clicks_on_delete_icon_latest_comment() {
		requirementListingPagePO.deleteCommentOnTopReq();
	}

	//	@Then("User verifies add a single profile url is opened")
//	public void userVerifiesSingleProfileUrlIsOpened()
//	{
//		Assert.assertTrue(requirementListingPagePO.verifySingleProfileUrlNavigated(),"user not navigated to add single profile page");
//	}
	@Then("User verify the count of application on listing page should be {string}")
	public void verifyApplicationCountOnListingPage(String appCount) {
		Assert.assertTrue(requirementListingPagePO.verifyApplicationCountOnListingPage(appCount), "application count on lsiting page does not match actual value");
	}

	@Then("Verify User is able to see download by index lightbox")
	public void verifyUserIsAbleToSeeDownloadByInDexLightbox() {
		Assert.assertTrue(requirementListingPagePO.verifyDownloadByIndexLightbox(), "download by index lightbox is not displayed");
	}

	@When("user selects any requirement and marks its status to closed")
	public void userSelectAnyRequirementAndMarkItsStatussASCLosed() {
		requirementListingPagePO.userMarksReqAsClosed();
	}

	@Then("verify the status of requirement is closed")
	public void verifyTheStatusOfRequirementIsClosed() {
		Assert.assertTrue(requirementListingPagePO.verifyStatusOfRequirementIsClosed(), "requirement is not closed even even status is marked closed");
	}

	@When("User clicks on {string} for requirement created")
	public void userClicksOnBtnOnRequirement(String btn) {
		requirementListingPagePO.clickOnButtonForCreatedReqOnListingPage(btn);
	}

	@When("User clicks on Sources under requirement")
	public void userclicksOnSourcesUnderRequirement() {
		requirementListingPagePO.userClicksOnSourcesUnderReq();
	}

	@Then("User verifies {string} is displayed on listing page")
	public void userVerifiesJobTitleOnListingPage(String jobTitle) {
		Assert.assertTrue(requirementListingPagePO.verifyjobTypeOnListingPage(jobTitle), "job is not displayed on listing page");
	}

	@Then("Verify Job types posted with action options such as {string} displayed on listing page")
	public void verifyJobTypespostedOnListingPage(String jobOption) {
		Assert.assertTrue(requirementListingPagePO.verifyListOfOptionPresentForAJob(jobOption), "list of options are not displayed");
	}

	@When("User changes the Job title of the requirement")
	public void updateJobTitle() {
		requirementCreationPagePO.updateJobTitleOfReq();
	}

	@When("User marks tick to update job with new job title")
	public void userMarksTickToUpdateJob() {
		requirementOverviewPagePO.userMarksToUpdateJobOnReq();
	}

	@Then("User verifies the job title on listing page is updated")
	public void userVerifiesJobTitleOnListingPageUpdated() {
		Assert.assertTrue(requirementListingPagePO.verifyUpdatedJobOnListingPage(), "job title is not updated");
	}

	@When("User selects {string} requirements from filter")
	public void selectrequirementCOuntOnPage(String count) {
		requirementListingPagePO.selectRequirementCountOnPage(count);
	}

	@Then("Verify only {string} requirements are displayed on listing page")
	public void verifyRequirementCountOnListingPage(String count)
	{
		Assert.assertTrue(requirementListingPagePO.verifyRequirementCountOnListing(count),"requirement count do not match with the selected count");
	}
	@When("User clicks on first filter on refine requirements")
	public void userClicksOnFirstFilterOnRefineREquirements()
	{
		requirementListingPagePO.clickOnFirstFilterOnRefineRequirement();
	}
	@When("User clicks on Refine Requirements on listing page")
	public void clickOnRefineRequirementsOnListingPage()
	{
		requirementListingPagePO.refineRequirementsOnListingPage();
	}
	@Then("Verify the requirement count on listing page after filter is selected")
	public void verifyRequirementCountONListingPage()
	{
		Assert.assertTrue(requirementListingPagePO.verifyRequirementCOuntOnListingPage(),"requirements are not filtered");
	}
//	@Then("Verify User see the searched results displayed")
//	public void verifyUserSearchedResultsDisplayed()
//	{
//		Assert.assertTrue(requirementListingPagePO.verifyUserSearchedResultsDisplayed(),"search results is not displayed with requirement id");
//	}
	@Then("Verify Groups not displayed on requirement listing page")
	public void verifyGroupsNotDisplayedOnListingPage()
	{
		Assert.assertFalse(requirementListingPagePO.verifyGroupsNotDisplayedOnListingpage(),"groups /employers are displayed on eapps account");
	}
//	@Then("Verify requirement visible to 1 recruiters")
//	public void verifyRequirementVisibileOnEapps()
//	{
//		Assert.assertTrue(requirementListingPagePO.verifyReqVisibleOnEapps(),"recruiters not mapped to requirement");
//	}
	@When("select subrecruiter {string}")
	public void selectSubrecruiterFromDD(String rec)
	{
		requirementCreationPagePO.selectSUbrecruiterFromDD(rec);
	}
	@Then("Verify requirement visible to {string} recruiters")
	public void verifyRequirementVisibleToSubuser(String rec)
	{
		Assert.assertTrue(requirementListingPagePO.verifyCountOfVisibilty(rec),"visibility count is not displayed correct");
	}
	@Then("Verify requirement visible to superuser only on eapps")
	public void verifyReqVisibleToOnlySUperuser()
	{
		Assert.assertFalse(requirementListingPagePO.verifyreqVisibleToOnlySuperUser(),"req visible to other rec");
	}
	@When("user clicks on requirement name on listing page")
	public void clickOnReqNameOnListingPage()
	{
		requirementListingPagePO.clickOnRequirementName(RequirementCreationPagePO.requirementName);
	}
	@Then("Verify User do not see the requirement created above")
	public void verifyReqNotVisible()
	{
		Assert.assertFalse(requirementListingPagePO.checkVisibiltyOfRequirement(),"req is visible to subuser when visibilty not given");
	}
	@Then("Verify subUser see the requirement created above")
	public void verifySubuserSeeReqvisible()
	{
		Assert.assertTrue(requirementListingPagePO.checkVisibiltyOfRequirement(),"req is not visible to the subuser");
	}
	@When("user selects the requirement created")
	public void userSelectsrequirementCreated()
	{
		requirementListingPagePO.selectTheRequirementCreated();
	}
	@When("user search basis the requisition id on project listing page")
	public void userSearchBasisRequisitionId()
	{
		requirementListingPagePO.typeINRequirementIdInRequisitionIdSearchFilter();
	}


}

