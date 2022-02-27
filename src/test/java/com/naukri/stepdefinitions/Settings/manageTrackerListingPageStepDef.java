package com.naukri.stepdefinitions.Settings;

import org.testng.Assert;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.pageobjects.Settings.manageTrackerListingPagePO;
import com.naukri.test.base.CommonAction;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class manageTrackerListingPageStepDef {
	manageTrackerListingPagePO manageListingPageObject = new manageTrackerListingPagePO();
	CommonAction commonActions = new CommonAction();
	String employerName = null;

	@When("Enter the template name Under Quick Search Template")
	public void enter_the_template_name_Under_Quick_Search_Template() {

		manageListingPageObject.enterQuickSearch();

	}

	@Then("The search results should be displayed correctly")
	public void the_search_results_should_be_displayed_correctly() {
		Assert.assertTrue(manageListingPageObject.verifyTrackerIsDisplayed(), "Search Results are not matching");
	}

	@Then("Under (.*) ,tracker should be displayed")
	public void verifyTrackerVisibleUnderUncategorised(String uncategorised) {
		Assert.assertTrue(manageListingPageObject.verifycategoryLabelVisible(uncategorised),
				"uncategorised label not visible");
		Assert.assertTrue(manageListingPageObject.verifyTrackerIsDisplayed(), "tracker not visible");
	}

	@Then("Tracker should be displayed under employer category")
	public void verifyTrackerVisibleUnderEmployerName() {
		String employerName = PropFileHandler.readProperty("setEmployerName");
		System.out.println(employerName + "expected employer name ........");
		Assert.assertTrue(manageListingPageObject.verifycategoryLabelVisible(employerName),
				"tracker not displayed under employer name");
		Assert.assertTrue(manageListingPageObject.verifyTrackerIsDisplayed(), "tracker not visible");
	}

	@Then("(.*),(.*),(.*) buttons should be visible")
	public void shareEditDeleteButtonVisible(String share, String edit, String delete) {
		Assert.assertTrue(manageListingPageObject.checkVisibiltyOfShareEditDeleteBtns(share, edit, delete),
				"share edit delete buttons not visible on listing page");
	}

	@When("Click on (.*) button")
	public void clickOnBtnOnListingPage(String Lnk) {
		manageListingPageObject.clickOnButton(Lnk);
	}

	@Then("the tracker should be shared")
	public void trackerShouldBeShared() {
		Assert.assertTrue(manageListingPageObject.verifySharedWithEveryone(), "Share with everyone is not visible");
	}

	@Then("the tracker should no longer be in system")
	public void trackerNotDisplayed() {
		Assert.assertTrue(manageListingPageObject.verifyNoResultsVisible().contains("No Results found"),
				"tracker should not be displayed");
	}

	@Then("Assign employer should be a label name")
	public void verifyLabelNameEmployer() {
		Assert.assertTrue(manageListingPageObject.verifyLabelEmployerName().contains("Assign Employer"),
				"label of assign employer not correct");
	}

	@Then("the tracker should not be visible")
	public void trackerShouldNotBeVisible() {
		Assert.assertTrue(manageListingPageObject.verifyTrackerDOesNotExists(),
				"tracker do exists even when not it shou;d not be visible to subrecruiter");
	}

	@Then("Edit Tracker Coloumn Labels should not be displayed")
	public void verifyEditLabelsVisibleInEnterpriseAccount() {
		Assert.assertFalse(manageListingPageObject.verifyEditLabelsVisible(),
				"edit labels visible in enterprise account");
	}

	@When("click on edit tracker")
	public void clickOnEditTracker() {
		manageListingPageObject.clickEditTracker();

	}

	@When("get the employer name")
	public void getEmployerName() {
		employerName = manageListingPageObject.getEmployerName();
	}

	@Then("the employer name should be visible")
	public void employerNameShouldBeVisible() {
		Assert.assertTrue(manageListingPageObject.getEmployerName().contains(employerName),
				"employer name not displayed");
	}

	@Then("I should see ‘Edit Tracker Column Name")
	public void EditTrackerColoumnName() {
		Assert.assertTrue(manageListingPageObject.editColoumnnameLabelVisible(), "edit coloumn name not displayed");
	}

	@When("click on edit tracker coloumn name")
	public void clickOnEditTrackerName() {
		manageListingPageObject.clickOnEditColoumnname();
	}
}
