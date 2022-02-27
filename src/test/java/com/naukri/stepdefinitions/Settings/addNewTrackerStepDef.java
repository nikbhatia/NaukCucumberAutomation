package com.naukri.stepdefinitions.Settings;

import org.testng.Assert;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Settings.addNewTrackerPO;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class addNewTrackerStepDef {
	addNewTrackerPO addNewTrackerObject = new addNewTrackerPO();

	public static String trackerName = "";
	public static String employerName = "";
	public static String totalNoOfEmployers = "";

	@When("click on add a new tracker")
	public void click_on_add_a_new_tracker() {
		addNewTrackerObject.clickAddTracker();
	}

	@When("Enter tracker name")
	public void enter_tracker_name() {
		trackerName = addNewTrackerObject.fillTrackerName();
		PropFileHandler.writeProperty("setTrackerName", trackerName);
	}

	@When("select name , email id , job title")
	public void selectNameEmailJobTitle() {
		addNewTrackerObject.checkselectiveFields("Name", "Email ID", "Job Title");
	}

	@When("Click on save button on create new tracker page")
	public void click_on_save() {
		addNewTrackerObject.clickSaveBtn();
	}

	@Then("(.*) name should be displayed on the page")
	public void add_a_new_template_name_should_be_displayed_on_the_page(String addTrackerBtn) {
		Assert.assertTrue(addNewTrackerObject.verifyAddANewTrackerDisplayed(addTrackerBtn),
				"add a new tracker not visible");
	}

	@When("Click on edit labels")
	public void clickEditLabels() {
		addNewTrackerObject.clickOnEditLabels();
	}

	@When("Change the names of the labels ie (.*),(.*)")
	public void changeNamesOfLabels(String label1, String label2) {
		addNewTrackerObject.changelabelsOfFields(label1, label2);
	}

	@When("click on save edit labels")
	public void clickOnSaveEditLabels() {
		addNewTrackerObject.clickSaveEditLabels();
	}

	@Then("verify that labels are edited in the coloumn")
	public void verifyLabelsAreEditedInColoumn() {
		Assert.assertTrue(addNewTrackerObject.verifyLabelsAreEdited(), "labels are not edited");
	}

	@Then("(.*) button should be displayed on the page")
	public void delete_button_should_be_displayed_on_the_page(String delete) {
		Assert.assertTrue(addNewTrackerObject.verifyDeleteBtnDisplayed(delete), "delete btn not visible");
	}

	@Then("Heading such as Trackers , show my trackers and last modified date should be visible")
	public void heading_such_as_Trackers_show_my_trackers_and_last_modified_date_should_be_visible() {
		Assert.assertTrue(
				addNewTrackerObject.verifyHeadingsOnTrackerListingPage("Trackers", "Show My Trackers", "Last Modified"),
				"Headings not correctly displyed");
	}

	@When("select an employer")
	public void selectAnEmployer() {
		employerName = addNewTrackerObject.enterEmployerName();
		PropFileHandler.writeProperty("setEmployerName", employerName);
	}

	@When("get the total no of employers")
	public void getTotalNoEmployers() {
		totalNoOfEmployers = addNewTrackerObject.getTotalNoOfEmployers();
		PropFileHandler.writeProperty("countEmloyers", totalNoOfEmployers);
	}

	@Then("(.*) should be the heading")
	public void headingCreateTracker(String headingTracker) {
		Assert.assertTrue(addNewTrackerObject.headingNewTracker().contains(headingTracker),
				"Add new tracker should be displayed");
	}

	@When("click on the assign employer DD")
	public void clickOnEmployerDD() {
		addNewTrackerObject.clickAssignEmployerDD();
	}

	@Then("All the employers of the company should be visible")
	public void verifyAllEmployersVisible() {
		String ActualTotalEmployers = PropFileHandler.readProperty("countEmloyers");
		Assert.assertTrue(addNewTrackerObject.countOfEmployersVisible().contains(ActualTotalEmployers),
				"all employers are not visible");
	}

	@When("Choose the employer from assign employer DD")
	public void chooseEmployerName() {
		addNewTrackerObject.selectEmployerName();
	}

	@Then("employer name should be disabled ie we must not be allowed to change the employer name")
	public void employerDisabledInAssignEmployerDD() {
		Assert.assertFalse(addNewTrackerObject.verifyEmployerDDIsDisabled(), "employer DD is not disabled");
	}

	@Then("we should be able to choose the employer")
	public void verifyEmployerDDNotDisabled() {
		Assert.assertTrue(addNewTrackerObject.verifyEmployerDDIsDisabled(), "employer DD is disabled");
	}

	@When("click on Share with")
	public void clickShareWith() {
		addNewTrackerObject.clickOnShareWith();
	}

	@Then("Everyone in group and no one should be displayed")
	public void everyOneInGroupAndNoOneShouldBeDisplayed() {
		Assert.assertTrue(addNewTrackerObject.verifyEveryoneOnGroupAndNoOneVisible(),
				"everyone in group and none is not visible");
	}

	@When("click on None option")
	public void clickNone() {
		addNewTrackerObject.clickOnNone("None");
	}

	@When("click on everyone in group")
	public void clickOnEveryoneInGroup() {
		addNewTrackerObject.chooseShareWith("Everyone in Group");
	}

	@When("click on share with everyone")
	public void clickOnEveryOne() {
		addNewTrackerObject.chooseShareWith("Everyone");
	}

	@When("Enter random string 52 chars in first field")
	public void enterInFirstField() {
		addNewTrackerObject.ExceedWordLimitInFirstRow();
	}

	@Then("verify the validation message for word limit")
	public void verifyvalidationOfWordlimit() {
		Assert.assertTrue(addNewTrackerObject.verifyWordLimitError(), "correct validation error not displayed");
	}

	@When("Enter (.*) in second field")
	public void enterSpecialChars(String specialChars) {
		addNewTrackerObject.enterSpecialChars(specialChars);
	}

	@Then("verify the validation message of special chars")
	public void verifyValidationSpecialChars() {
		Assert.assertTrue(addNewTrackerObject.verifyValidationMsgSpecialChars(), "incorret validation msg");
	}

	@Then("I should see three labels default, custom and values")
	public void EditcoloumnNameLabels() {
		Assert.assertTrue(addNewTrackerObject.verifyEditColoumnNameLabels(),
				"edit coloumn name lightbox labels are not displayed");
	}

	@Then("User should be able to see {string} option in {string} section")
	public void EditcoloumnNameLabels(String fieldName, String trackerSection) {
		addNewTrackerObject.enterValueOnSearchApplicationDeatils(fieldName);
		Assert.assertTrue(addNewTrackerObject.verifyfieldInTrackerList(fieldName),
				fieldName + " is not displayed in "+ trackerSection +" List");
		TestNGLogUtility.pass(fieldName + " is displaying in "+ trackerSection +" List successfully");
	}

}
