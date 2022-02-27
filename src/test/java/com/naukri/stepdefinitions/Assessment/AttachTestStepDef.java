package com.naukri.stepdefinitions.Assessment;

import com.naukri.automation.util.APITestOps;
import com.naukri.pageobjects.Assessment.AttachAssessmentPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class AttachTestStepDef {

	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	APITestOps APITestObj = new APITestOps();

	AttachAssessmentPO attachAssessmentTest = new AttachAssessmentPO();
	public static String testName;
	public static String getFIrstCategoryName = null;
	public static int totalTest = 0;

	@And("User attach a test on substage \"([^\"]*)\" of \"([^\"]*)\" stage on selection stage tab")
	public void attachTestOnGivenStage(String subStageName, String stageName) {
		clickOnSelectionStage();
		clickOnStages(stageName);
		clickSubStageOnSelctionStageTab(subStageName, stageName);
		clickOnTestIcon();
		click_first_test();
		click_send_test_automatically_to_candidate();
		click_on_attach_test();
	}

	@And("^click on selection stage$")
	public void clickOnSelectionStage() {
		attachAssessmentTest.clickOnSelectionStages();
	}

	@And("click on \"(.*)\" stage on selection stages tab")
	public void clickOnStages(String stageName) {
		attachAssessmentTest.clickOnStageOnSelectionStageTab(stageName);
	}

	@And("User click on substage \"([^\"]*)\" of \"([^\"]*)\" stage on selection stage tab")
	public void clickSubStageOnSelctionStageTab(String subStageName, String stageName) {
		attachAssessmentTest.clicksubStage(subStageName);

	}

	@Then("^apply test icon should be visible$")
	public void testIconShouldBeVisible() {
		Assert.assertTrue(attachAssessmentTest.verifyTesticonVisibleOrNotOnApplied(),
				"[Assertion Fail]test icon not visible");

	}

	@And("^click on test icon$")
	public void clickOnTestIcon() {
		attachAssessmentTest.clickTestIconOnMatching();
	}

	@And("^Recuiter attach the test$")
	public void attachTest() {
		testName = attachAssessmentTest.clickOnFirstTest();
		attachAssessmentTest.clickOnSelect();
		attachAssessmentTest.clickAttachTest();
	}

	@Then("^test should be visible on requirement dashboard$")
	public void verifyTestIsVisibleOnRequirementDashboard() {
		String ExpectedTest = attachAssessmentTest.getTextmappedTestOnDashboard();
		Assert.assertTrue(ExpectedTest.contains(testName), "[Assertion Fail]Test is not mapped ");
	}

	@And("^get the total no of tests$")
	public void get_the_total_no_of_tests() {
		totalTest = attachAssessmentTest.getTotalNoOfTestInACategory();

	}

	@Then("^Verify that total number of tests is visible$")
	public void verify_that_total_number_of_tests_is_visible() {
		Assert.assertTrue(attachAssessmentTest.noOfTestsVisibleOnCategory(),
				"[Assertion Fail] No of tests is not visible on test selection page");
	}

	@And("^click on category name$")
	public void click_on_category_name() {
		getFIrstCategoryName = attachAssessmentTest.getFirstCategory();
		attachAssessmentTest.clickOnFirstCategory();
	}

	@And("^verify that category name, time taken, questions heading should be visible$")
	public void verify_that_category_name_time_taken_questions_heading_should_be_visible() {

		Assert.assertTrue(attachAssessmentTest.verifyfieldsOfCategory(getFIrstCategoryName),
				"[Assertion Fail] Fields of category not correctly displayed");
	}

	@And("^verify first (\\d+) tests are visible$")
	public void verify_first_tests_are_visible(int arg1) {

		Assert.assertTrue(attachAssessmentTest.verifyFirstFiveVisible(),
				"[Assertion Fail]First five tests not visble ");
	}

	@And("^verify the view n more tests in this category and view all the tests$")
	public void verify_the_view_n_more_tests_in_this_category_and_view_all_the_tests() {

		Assert.assertTrue(attachAssessmentTest.verifyViewNMoreTests(totalTest),
				"[Assertion Fail] All tests are visible under category ");

	}

	@And("^verify the total no of tests matches the count of tests$")
	public void verify_the_total_no_of_tests_matches_the_count_of_tests() {
		Assert.assertTrue(attachAssessmentTest.verifyAllTestsDisplayed(totalTest),
				"[Assertion Fail] All the tests are not displayed");
	}

	@And("^Enter \"([^\"]*)\" in searchbar$")
	public void enter_Demo_Edit_in_searchbar(String demo) {
		attachAssessmentTest.enterInSearchBar(demo);
	}

	@Then("^verify test results of \"([^\"]*)\" is correct$")
	public void verify_test_results_of_Demo_Edit_is_correct(String demo) {
		Assert.assertTrue(attachAssessmentTest.verifySearchResultsOfTest(demo),
				"[Assertion Fail]search results are not correct");
	}

	@When("^click on \"([^\"]*)\" button in bottom$")
	public void click_on_cancel_button_attachTest(String str) {
		attachAssessmentTest.clickOnButton(str);

	}

	@Then("^it should take me to the previous page without mapping the selected test to the stage$")
	public void previous_page_without_mapping_the_selected_test_to_stage() {
		Assert.assertTrue(attachAssessmentTest.getTitleOfPage().contains("Requirement Overview"),
				"[Assertion Fail] The user is not directed to requirement overview page");
	}

	@And("^select first test$")
	public void click_first_test() {
		testName = attachAssessmentTest.clickOnFirstTest();
		attachAssessmentTest.clickOnSelect();
		// attachAssessmentTest.clickAttachTest();
	}

	@Then("^configuring test settings page should be displayed$")
	public void configuring_test_settings_page_should_be_displayed() {
		Assert.assertTrue(attachAssessmentTest.validateStaticDataOnConfigurePage(testName),
				"[Assertion Fail] The static data on configure test settings page is incorrect");
	}

	@When("^click on attach test$")
	public void click_on_attach_test() {
		attachAssessmentTest.clickAttachTest();
	}

	@And("^click on edit icon$")
	public void click_on_edit_icon() {
		attachAssessmentTest.clickEditTest();
	}

	@Then("^I should see labels such as send test automatically,restrict multiple tabs,monitor webcam usage$")
	public void verify_send_test_automatically_restrict_multipletabs_webcam() {
		Assert.assertTrue(attachAssessmentTest.verifyCheckboxesOnConfigurationPage(),
				"[Assertion Fail] test configuration details are incorrectly displayed");
	}

	@And("^click on send test automatically to candidate$")
	public void click_send_test_automatically_to_candidate() {
		attachAssessmentTest.clickSendTestAutomatically();
	}

	@And("^select the restrict multiple tabs checkbox$")
	public void select_the_restrict_multiple_tabs_checkbox() {
		attachAssessmentTest.clickRestrictMultipleTabs();
	}

	@Then("^default value of no of candidates allowed should be 50$")
	public void verifyNoCandidatesConfigurationPage() {
		Assert.assertTrue(attachAssessmentTest.getDefaultCountOnConfigurationPage().contains("50"),
				"[Assertion Fail] Default count does not match 50");
	}

	@And("^enter \"([^\"]*)\" days$")
	public void enter_Invalid_days(String days) {
		attachAssessmentTest.enterInvalidActivationPeriodDays(days);
	}

	@Then("^error should be displayed that maximum activation period can be 1-365 days and 0-23 hours$")
	public void verifyErrorMessageActivationPeriod() {
		Assert.assertTrue(attachAssessmentTest.getErrorActivationPeriod().contains(
				"Invalid Activation Period. Select only integer values between 1-365 for Days and 0-23 for Hours."),
				"[Assertion Fail] Error message displayed not correct");

	}

	@And("^enter \"([^\"]*)\" day and \"([^\"]*)\" hours$")
	public void EnterActivationPeriodInDaysAndHours(String days, String hours) {
		attachAssessmentTest.EnterActivationPeriodInDayAndHour(days, hours);
	}

	@And("^clear the activation period value$")
	public void clear_the_activation_period_value() {
		attachAssessmentTest.clearActivationPeriod();
	}

	@And("^enter the no of candidates allowed more than the total credits allotted$")
	public void enter_no_candidates_allowed_more_than_total_credits_allotted() {
		attachAssessmentTest.enterCountMoreThanCreditsAvailable();
	}

	@Then("^the error message should be displayed that the no of candidates cannot be greater than the credits available$")
	public void errorMessageTotalCreditsGreaterThanCreditsAvailable() {
		Assert.assertTrue(
				attachAssessmentTest.errorMsgGreaterThanTotalCredits()
						.contains("This number cannot be greater than the test credits available."),
				"[Assertion Fail] Error msg displayed in incorrect");
	}

	@When("^enter no of candidates allowed to be \"([^\"]*)\"$")
	public void noOfCandidates(int candidates) {
		attachAssessmentTest.enterNoOfCandidates(candidates);
	}

	@Then("^verify all the initial configured settings should be prefilled candidates should be \"([^\"]*)\"$")
	public void no_assessment_icon_should_be_visible(String candidates) {
		Assert.assertTrue(attachAssessmentTest.getDefaultCountOnConfigurationPage().contains(candidates),
				"[Assertion Fail] Assessment icon should not be visible ");
	}

	@Then("^verify the label of the page$")
	public void verify_the_label_of_the_page() {
		Assert.assertTrue(attachAssessmentTest.labelConfigurationPage().contains("Edit Assessment Test Settings"),
				"[Assertion Fail] label of page is incorrect");
	}

	@When("^click on the back button$")
	public void click_on_the_back_button() {
		attachAssessmentTest.clickOnBackBtn();
		attachAssessmentTest.clickConfirmationBtn();
	}

	@Then("^we should get redirected to requirement dashboard$")
	public void redirected_to_requirement_dashboard() {
		Assert.assertTrue(attachAssessmentTest.getTitleOfPage().contains("Requirement Overview"),
				"[Assertion Fail] Not redirected to requirement overview");
	}

	@When("^delete the value in activation period$")
	public void delete_the_value_in_activation_period() {
		attachAssessmentTest.clearActivationPeriod();

	}

	@Then("^the value in activation period should be displayed as 10$")
	public void getValueActivationPeriod() {
		Assert.assertTrue(attachAssessmentTest.getActivationValue().contains("10"),
				"[Assertion Fail] Activation value is not equal to 10");
	}

}
