package com.naukri.stepdefinitions.Applications;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.InboxPagePO;
import com.naukri.pageobjects.Applications.InboxPagePO.AddToRequirementLightbox;
import com.naukri.pageobjects.Applications.MasterProfileListingPagePO;
import com.naukri.pageobjects.Dashboard.DashboardPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MasterProfileStepDef {

	DashboardPagePO dashboardPagePO = (DashboardPagePO) PageObjectWrapper.getObject(DashboardPagePO.class);
	MasterProfileListingPagePO masterProfilePagePO = (MasterProfileListingPagePO) PageObjectWrapper.getObject(MasterProfileListingPagePO.class);
	AddToRequirementLightbox addToRequirementLightbox = (AddToRequirementLightbox) PageObjectWrapper.getInnerClassObject(InboxPagePO.class, AddToRequirementLightbox.class);
	InboxPagePO inboxPagePO = (InboxPagePO) PageObjectWrapper.getObject(InboxPagePO.class);
	
	@When("User searches the master profile of the application created in the previous step")
	public void user_searches_the_master_profile_of_the_application_created_in_the_previous_step() {
		dashboardPagePO.searchMasterProfileOnDashboard();
	}

	@Then("User should be able to see the profile appearing on the search result page")
	public void user_should_be_able_to_see_the_profile_appearing_on_the_search_result_page() {
	   Assert.assertTrue(masterProfilePagePO.verifyThePresenceOfMasterProfile(), 
			   "Master Profile is not visible");
	   TestNGLogUtility.pass("Master Profile is visible on search page");
	}
	
	@Then("User should be able to see the error message {string}")
	public void user_should_be_able_to_see_the_error_message(String expectedErrorMessage) {
		Assert.assertTrue(masterProfilePagePO.verifyThePresenceOfErrorMessage(expectedErrorMessage), 
				"The expected error message for forward flow " + expectedErrorMessage);
		TestNGLogUtility.pass("The expected error message for forward flow is visible " + expectedErrorMessage);
	}
	
	@When("User clicks on the forward option")
	public void user_clicks_on_the_forward_option() {
	    masterProfilePagePO.clickOnForwardOptionForMasterProfile();
	}
	
	@Then("User should not be able to the status strip")
	public void user_should_not_be_able_to_the_status_strip() {
	    Assert.assertTrue(!masterProfilePagePO.verifyThePresenceOfStatusStripOnMasterProfile(),
	    		"Status change strip is visible for the master profile");
	    TestNGLogUtility.pass("Status change strip is not present for master profile");
	}

	@Then("User should not be able to see the star rating")
	public void user_should_not_be_able_to_see_the_star_rating() {
		Assert.assertTrue(!masterProfilePagePO.verifyThePresenceOfStarRating(), 
				"Star Rating is present for the master profile");
		TestNGLogUtility.pass("Star Rating is not present for the master profile");
	}
	
	@Then("User should be able to see the comments icon")
	public void user_should_be_able_to_see_the_comments_icon() {
	   Assert.assertTrue(masterProfilePagePO.verifyThePresenceOfComment(), 
			   "The comment section is not visible for the master profile");
	   TestNGLogUtility.pass( "The comment section is visible for the master profile");
	}

	@When("User click on comment icon")
	public void user_click_on_comment_icon() {
	    masterProfilePagePO.clickOnCommentOption();
	}

	@Then("User should be able to see the comment widget open")
	public void user_should_be_able_to_see_the_comment_widget_open() {
	   Assert.assertTrue(masterProfilePagePO.verifyThePresenceOfAddComment(), 
			   "Comment widget is not displayed");
	   TestNGLogUtility.pass("Comment widget is displayed");
	}

	@When("User types in the {string} in the comment field of the master profile")
	public void user_types_in_the_in_the_comment_field_of_the_master_profile(String commentString) {
		masterProfilePagePO.fillInCommentText(commentString);
	}

	@When("User clicks on Add Comment buttons")
	public void user_clicks_on_Add_Comment_buttons() {
	    masterProfilePagePO.clickOnAddCommentButton();
	}

	@Then("User should be able to see the added comment {string} in the comment list")
	public void user_should_be_able_to_see_the_added_comment_in_the_comment_list(String expectedComment) {
	    Assert.assertTrue(masterProfilePagePO.verifyTheTextOfComment(expectedComment), 
	    		expectedComment+" is not visible");
	    TestNGLogUtility.pass(expectedComment+" is visible");
	}

	@Then("User should be able to see the comment count incremented")
	public void user_should_be_able_to_see_the_comment_count_incremented() {
	    Assert.assertTrue(masterProfilePagePO.verifyIncrementedCommentCount(), 
	    		"Comment Count is not incremented");
	    TestNGLogUtility.pass("Comment count is incremented");
	}

	@When("User clicks on the Add to Requirement on the action bar")
	public void user_clicks_on_the_Add_to_Requirement_on_the_action_bar() {
		masterProfilePagePO.clickOnAddToRequirement();
	}
	
	@Then("User should be able to see the popup with heading {string}")
	public void user_should_be_able_to_see_the_popup_with_heading(String popupHeadingText) {
		Assert.assertTrue(addToRequirementLightbox.checkPresenceAddToRequirementTitle(), 
				popupHeadingText+" is not displayed");
		TestNGLogUtility.pass(popupHeadingText+" is not displayed");
	}

	@When("User clicks on the checkbox with label {string}")
	public void user_clicks_on_the_checkbox_with_label(String string) {
	    addToRequirementLightbox.checkAddNewRequirementCheckbox();
	}
	
	@When("User clicks on the checkbox for add new requirement")
	public void user_clicks_on_the_checkbox_for_add_new_requirement() {
	    addToRequirementLightbox.checkAddNewRequirementCheckbox();
	}

	@Then("User should be able to see the text field with the label {string}")
	public void user_should_be_able_to_see_the_text_field_with_the_label(String labelText) {
		Assert.assertTrue(addToRequirementLightbox.verifyThePresenceOfInputForLabel(labelText), 
				"Field following the sibling " + labelText + " is not displayed");
		TestNGLogUtility.pass("Field following the sibling " + labelText + " is displayed");
	}

	@When("User types in the requirement name in the popup")
	public void user_types_in_the_requirement_name_in_the_popup() {
	    addToRequirementLightbox.fillInRequirementNameForMasterProfile();
	}

	@When("User selects the status as {string}")
	public void user_selects_the_status_as(String statusString) {
	    addToRequirementLightbox.selectStatusOfApplication(statusString);
	}

	@When("User clicks on the {string} button on the popup")
	public void user_clicks_on_the_button_on_the_popup(String btnText) {
	    addToRequirementLightbox.clickOnActionButton(btnText);
	}

	@Then("User should be able to see the success message as {string}")
	public void user_should_be_able_to_see_the_success_message_as(String successMessageText) {
		Assert.assertTrue(addToRequirementLightbox.verifyTheSuccessMessage(successMessageText), 
				successMessageText + " is not visible");
		TestNGLogUtility.pass(successMessageText + " is visible");
	}

	@Then("User should be able to see the name of the requirement entered")
	public void user_should_be_able_to_see_the_name_of_the_requirement_entered() {
	    Assert.assertTrue(addToRequirementLightbox.verifyThePresenceOfRequirementName(), 
	    		"Requirement name is not visible on lightbox");
	    TestNGLogUtility.pass("Requirement name is visible on lightbox");
	}
	
	@When("User clicks on the Add to Requirement on the tupple")
	public void user_clicks_on_the_Add_to_Requirement_on_the_tupple() {
	    masterProfilePagePO.clickOnAddToRequirementOnCandidateTupple();
	}

	@When("User clicks on the {string} button on download lightbox")
	public void user_clicks_on_the_button_on_download_lightbox(String downloadOption) {
		inboxPagePO.clickOnFooterButtonsOfDownload(downloadOption);
	}
	
	@When("User fills in {int} for starting range and {int} for ending range")
	public void user_fills_in_for_starting_range_and_for_ending_range(Integer startRange, Integer endRange) {
		inboxPagePO.fillStartAndEndIndex(startRange, endRange);
	}
	
	@Then("User should be able to see the personal symbol for CV searched")
	public void user_should_be_able_to_see_the_personal_symbol_for_CV_searched() {
	    Assert.assertTrue(masterProfilePagePO.verifyThePresenceOfPersonalIcon(), 
	    		"Personal CV icon is not displayed");
	    TestNGLogUtility.pass("Personal CV icon is visible");
	}

	@Then("User should be able to see the tooltip of personal symbol as {string}")
	public void user_should_be_able_to_see_the_tooltip_of_personal_symbol_as(String expectedToolTip) {
	   Assert.assertTrue(masterProfilePagePO.verifyTheToolTipForPersonal(expectedToolTip), 
			   expectedToolTip + " is not correct");
	   TestNGLogUtility.pass(expectedToolTip + " is correct");
	}
	
	@When("User records the page count")
	public void user_records_the_page_count() {
	   masterProfilePagePO.getPageCount();
	}

	@When("User changes the Sort by category to {string}")
	public void user_changes_the_Sort_by_category_to(String sortingString) {
	   masterProfilePagePO.changeTheSortType(sortingString);
	}

	@Then("User should be able to see the same count of profile")
	public void user_should_be_able_to_see_the_same_count_of_profile() {
	   Assert.assertTrue(masterProfilePagePO.verifyApplicationCountOfPageAfterFilter(),
			   "Page count is not same after applying the filter");
	   TestNGLogUtility.pass("Page count is same after applying the filter");
	}
	
	@When("User changes the page size to {string} of {string}")
	public void user_changes_the_page_size_to_of(String pageSize, String presenceOfPageSize) {
	    masterProfilePagePO.changeThePageSize(pageSize, presenceOfPageSize);
	}
	
	@When("User searches for the {string} value in search within result")
	public void user_searches_for_the_value_in_search_within_result(String fieldLabel) {
		masterProfilePagePO.fetchValueAndSearchFromPropertyFileBasedOnKey(fieldLabel);
	}

	@Then("User should be able to see the {string} highlighted")
	public void user_should_be_able_to_see_the_highlighted(String fieldLabel) {
	    Assert.assertTrue(masterProfilePagePO.verifyHighlightingBasedOnKey(fieldLabel), 
	    		"Field Value for " + fieldLabel + " is not highlighted");
	    TestNGLogUtility.pass("Field Value for " + fieldLabel + " is highlighted");
	}
	
	@When("User hovers on select next to contact number and selects {string}")
	public void user_hovers_on_select_next_to_contact_number_and_selects(String actionString) {
		masterProfilePagePO.selectTheDesiredContactOption(actionString);
	}

	@Then("User should be able to see the status {string} next to contact number")
	public void user_should_be_able_to_see_the_status_next_to_contact_number(String expectedActionString) {
	    Assert.assertTrue(masterProfilePagePO.verifyTheContactStatus(expectedActionString), 
	    		expectedActionString+ " is not visible for the call option");
	    TestNGLogUtility.pass(expectedActionString+ " is visible for the call option");
	}
	
	@When("User clicks on {string} facet")
	public void user_clicks_on_facet(String facetText) {
	    masterProfilePagePO.clickOnFacet(facetText);
	}

	@Then("User should be able to see count {int} infront of {string} in property file")
	public void user_should_be_able_to_see_count_infront_of_in_property_file(Integer countOfApplications, String propertyFileKey) {
		Assert.assertTrue(masterProfilePagePO.verifyPresenceOfNumberAgainstFilter(countOfApplications, propertyFileKey), 
				"Count of applications with value " + countOfApplications + " is not visible for " + propertyFileKey);
	}

	@When("User checks the checkbox with {string} value")
	public void user_checks_the_checkbox_with_location_value(String propertyFileKey) {
		masterProfilePagePO.clickOnFilterChecbox(propertyFileKey);
	}
	
	@Then("User should be able to see count {int} infront of Personal CVs count")
	public void user_should_be_able_to_see_count_infront_of_Personal_CVs_count(Integer countOfApplications) {
	    Assert.assertTrue(masterProfilePagePO.verifyTheCountOfPrivateApplication(countOfApplications), 
	    		"Application count is not correct for personal cvs");
	    TestNGLogUtility.pass("Application count is correct for personal cvs");
	}

	@When("User clicks on Private CVs checkbox")
	public void user_clicks_on_Private_CVs_checkbox() {
	    masterProfilePagePO.clickOnCheckboxForPrivateApplications();
	}
	
	@Then("User should be able to see the {string} date of present day on master profile SRP")
	public void user_should_be_able_to_see_the_date_of_present_day_on_master_profile_SRP(String dateLabelString) {
		
	}


}
