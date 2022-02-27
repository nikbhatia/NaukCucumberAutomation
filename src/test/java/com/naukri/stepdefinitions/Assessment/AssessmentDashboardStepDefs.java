package com.naukri.stepdefinitions.Assessment;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import static com.naukri.automation.util.YamlReader.getAppConfigValue;
import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.pageobjects.Assessment.AssessmentAdminDashboardPO;
import com.naukri.pageobjects.Assessment.AttachAssessmentPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AssessmentDashboardStepDefs {
	public static String TestDataFile = ".//src//test//resources//testdata//testDataAssessment.properties";
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	APITestOps APITestObj = new APITestOps();

	AttachAssessmentPO attachAssessmentTest = new AttachAssessmentPO();
	AssessmentAdminDashboardPO adminDasboardTest = new AssessmentAdminDashboardPO();

	HashMap<String, String> testCredits = new HashMap<String, String>();

	@When("\"([^\"]*)\" user navigated to customized selection stage page")
	public void navigateCustomizeSelctionStagePage(String str) {
		commonActions.navigateToUrl(getAppConfigValue("URLs.customizeSelectionProcess"));
	}

	@When("^select a requirement$")
	public void clickOnFirstRequirement() {
		commonActions.clickNewRequirement();

	}

	@Given("User adds a single profile to a new requirement through API for \"([^\"]*)\"")
	public void addNewCandidateAndReq(String subType, DataTable dt) {
		List<String> list = dt.asList(String.class);
			APITestObj.addCandidate(getAppConfigValue("Users."+subType+".Superuser.username"),
					getAppConfigValue("Users."+subType+".Superuser.password"), "", list.get(0),
					getAppConfigValue("Users."+subType+".Superuser.ReqsubStatusId"));
	}
	
	
	@When("^Navigate to admin dashboard$")
	public void Navigate_to_admin_dashboard() {
		adminDasboardTest.navigateToDashboard(getAppConfigValue("URLs.RMS_Dashboard"));
	}

	@When("^get the total credits , credits to be consumed and credits consumed$")
	public void get_the_total_credit_credits_to_be_consumed_and_credits_consumed() {
		testCredits.put("Test Credits Consumed", adminDasboardTest.getCountOfCreditsDashboard("Test Credits Consumed"));
		testCredits.put("Test Credits Available",
				adminDasboardTest.getCountOfCreditsDashboard("Test Credits Available"));
		testCredits.put("Test Credits Pending to be Consumed ",
				adminDasboardTest.getCountOfCreditsDashboard("Test Credits Pending to be Consumed "));

	}

	@When("^navigate to requirement listing$")
	public void navigate_to_requirement_listing() {
		adminDasboardTest.navigateToDashboard(getAppConfigValue("URLs.RMS_ProjectListing"));
	}

	@When("^refresh the page$")
	public void refresh_the_page() {
		adminDasboardTest.refreshPage();
	}

	@Then("^verify that credits pending to be consumed should be increased by 1 and other two tuples should remain the same$")
	public void verify_credits_pending_to_be_consumed_increased_by_1() {
		String StringActualtestCreditsPending = adminDasboardTest
				.getCountOfCreditsDashboard("Test Credits Pending to be Consumed ");
		String StringExpectedTestCreditsPending = testCredits.get("Test Credits Pending to be Consumed ");
		Assert.assertTrue(
				adminDasboardTest.compareExpectedAndActualPendingCreditCountWhenNotConsumed(
						StringActualtestCreditsPending, StringExpectedTestCreditsPending),
				"Test Credits Pending not incremented");
	}

	@Then("^verify that credits pending to be consumed should be decreased by 1$")
	public void verify_that_credits_pending_to_be_consumed_should_be_decresed_by_1() {
		String StringActualTestCreditPending = adminDasboardTest
				.getCountOfCreditsDashboard("Test Credits Pending to be Consumed ");
		String StringExpectedTestCreditsPending = testCredits.get("Test Credits Pending to be Consumed ");
		Assert.assertTrue(
				adminDasboardTest.compareExpectedAndActualCreditCountWhenConsumed(StringActualTestCreditPending,
						StringExpectedTestCreditsPending),
				"Test credits pending not decremented");
	}

	@Then("^verify that credits available should be decreased by 1$")
	public void verify_that_credits_available_should_be_decreased_by_1() {
		String StringActualCreditAvailable = adminDasboardTest.getCountOfCreditsDashboard("Test Credits Available");
		String StringExpectedCreditAvailable = testCredits.get("Test Credits Available");
		Assert.assertTrue(adminDasboardTest.compareExpectedAndActualAvailableCreditCountWhenConsumed(
				StringActualCreditAvailable, StringExpectedCreditAvailable), "Credits available not incremented");
	}

	@Then("^verify that credits consumed should be increased by 1$")
	public void verify_that_credits_consumed_should_be_increased_by_1() {
		String StringActualCreditsConsumed = adminDasboardTest.getCountOfCreditsDashboard("Test Credits Consumed");
		String StringExpectedCreditCOnsumed = testCredits.get("Test Credits Consumed");
		Assert.assertTrue(
				adminDasboardTest.compareExpectedAndActualPendingCreditCountWhenNotConsumed(StringActualCreditsConsumed,
						StringExpectedCreditCOnsumed),
				"Credits available not correctly displayed");
	}

	@And("Recuiter moved to candidate \"([^\"]*)\" CV Details page")
	public void moveCandidateCVDetailsPage() {
		String candidateName = PropFileHandler.readProperty("candidateName");
		String rmsUrl = getAppConfigValue("URLs.RMS_URL");

	}
}
