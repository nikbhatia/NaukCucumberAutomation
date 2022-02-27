package com.naukri.stepdefinitions.VendorPlatform;

import com.naukri.pageobjects.HiringManager.RequirementPagePO;
import com.naukri.pageobjects.MLH.MLHRequirementListingPagePO;
import com.naukri.pageobjects.VendorPlatform.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import io.cucumber.datatable.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * This class is use for view the assessment on Requirement Over View page
 * 
 * @author abhishek.dwivedi
 *
 */

public class ViewAssessmentStepDef extends BaseAutomation {

	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	APITestOps APITestObj = new APITestOps();
	ViewAssessmentPO objViewAssessment = new ViewAssessmentPO();
	AssessmentPartnerIntegrationPO API = new AssessmentPartnerIntegrationPO();
	AttachAssessmentForPartnerPO attach = new AttachAssessmentForPartnerPO();
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	RequirementPagePO objRequirementPage = new RequirementPagePO();
	HashMap<String, String> hmapStageAndtestName = new HashMap<>();
	MLHRequirementListingPagePO requirementListingPageObject = new MLHRequirementListingPagePO();
	List<String> lstTestName = new ArrayList<>();
	List<String> lstAllCandidateAddedToReq = new ArrayList<>();
	String reqName = "";
	String candidateName = "";

	@Given("I am adding a single profile with <CandidateEmail> and add them to a Requirement <RequirementName>")
	public void i_am_adding_a_single_profile_with_Candidate_Email_and_add_them_to_a_Requirement_RequirementName(
			DataTable dt) throws InterruptedException {

		for (Map<Object, Object> hmapCandidateData : dt.asMaps(String.class, String.class)) {
			String email = CommonAction.generateRandomStrings(9, "String") + "@mailSac.com";
			candidateName = hmapCandidateData.get("CandidateName").toString()
					+ CommonAction.generateRandomStrings(9, "String");
			objViewAssessment.addCandidateFromRequirementOverViewPage(candidateName, candidateName + email);
			lstAllCandidateAddedToReq.add(candidateName);
			TestNGLogUtility.info(" Candidate added to the Requirement");
		}
	}

	@Given("I search the {string} on SRP page")
	public void i_search_the_on_SRP_page(String string) {

		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.requirementInbox"));
		wait.waitForPageToLoadCompletely();
		reqName = PropFileHandler.readProperty("reqName");
		requirementListingPageObject.quickSearchRequirement(reqName);
		TestNGLogUtility.info(" Search the Requirement and click on that");

	}

	@Then("I move to perticular Requirement OverviewPage")
	public void i_move_to_Requirement_OverviewPage() {
		objViewAssessment.clickReqNameOnCVDetailsPage(reqName);
		TestNGLogUtility.info(" Move to Requirement Overview page");
	}

	@Then("User click on StageName the click on SubStage and attach test to that stages")
	public void click_on_Stage_Name_the_click_on_Sub_Stage_and_attach_test_to_that_stages(DataTable dt) {

		for (Map<Object, Object> hmapTestStage : dt.asMaps(String.class, String.class)) {
			objViewAssessment.attachTestToSubStage(hmapTestStage.get("StageName").toString(),
					hmapTestStage.get("SubStage").toString(), hmapTestStage.get("Testname").toString());

			TestNGLogUtility.info("Attach the " + hmapTestStage.get("Testname").toString() + " test on  "
					+ hmapTestStage.get("StageName").toString() + "-" + hmapTestStage.get("SubStage").toString());
		}
	}

	@Then("I move to Requirement Inbox Page")
	public void i_move_to_Requirement_SRP_page() {
		objViewAssessment.goToRequirementInboxPage();
		TestNGLogUtility.info(" move to Requirement SRP page");
	}

	@Then("I verify Assessment Tests link is Not visible")
	public void i_verify_Assessment_Tests_link_isNotVisible() {
		// Assert.assertFalse(objViewAssessment.isAssessmentTestsDisplayed("Assessment
		// Tests"));
		TestNGLogUtility.pass("Assessment Tests link is Not visible");

	}

	@Then("I verify Assessment Tests link is visible")
	public void i_verify_Assessment_Tests_link_isVisible() {
		Assert.assertTrue(objViewAssessment.isAssessmentTestsDisplayed("Assessment Tests"));
		TestNGLogUtility.pass("Assessment Tests link is visible");
	}

	@Then("I move the <CandidateName> to <StageName>")
	public void i_move_the_CandidateName_to_Stage_Name(DataTable dt) {

		for (Map<Object, Object> hmapCandidateData : dt.asMaps(String.class, String.class)) {
			if (lstAllCandidateAddedToReq.size() == 0) {
				lstAllCandidateAddedToReq.add(PropFileHandler.readProperty("candidateName"));
			}
			for (int i = 0; i < lstAllCandidateAddedToReq.size(); i++) {
				objViewAssessment.moveCandidateToAStageFromReqInboxPage(lstAllCandidateAddedToReq.get(i),
						hmapCandidateData.get("StageName").toString());
				lstTestName.add(hmapCandidateData.get("StageName").toString());
				TestNGLogUtility.info(" move the candidate " + lstAllCandidateAddedToReq.get(i) + " to"
						+ hmapCandidateData.get("StageName").toString() + " stage ");
			}
		}
	}

	@Then("I click on Assessment Tests link")
	public void i_click_on_Assessment_Tests_link() {
/*		goToPageURL("https://rms.naukri.com/profile/project/inbox/89996?token=ADMIN");
		wait.waitForPageToLoadCompletely();
*/		objViewAssessment.clickFacetsOnReqInboxPage("Assessment Tests");
		TestNGLogUtility.pass("click on Assessment Tests link");
	}

	@Then("I click on <TestName> and check the checkbox <FacetsName>")
	public void i_click_on_Test_Name_and_check_the_checkbox_Facets_Name(DataTable dt) {

		for (Map<Object, Object> hmapfacetsName : dt.asMaps(String.class, String.class)) {
			objViewAssessment.clickTestNameInideAssessmentTests(hmapfacetsName.get("TestName").toString());
			int tupleCOunt = objViewAssessment.clickFacetsInideTestName(hmapfacetsName.get("TestName").toString(),
					hmapfacetsName.get("FacetsName").toString());
			Assert.assertEquals(String.valueOf(tupleCOunt), hmapfacetsName.get("TupleCount").toString(),
					"The count of " + hmapfacetsName.get("FacetsName").toString());
			TestNGLogUtility.pass(" Count for " + hmapfacetsName.get("FacetsName").toString() + " is match");
		}

	}

}
