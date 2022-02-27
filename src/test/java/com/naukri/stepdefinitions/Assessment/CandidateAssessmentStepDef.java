package com.naukri.stepdefinitions.Assessment;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadEmail;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Assessment.CandidateAssessmentPO;
import com.naukri.pageobjects.Assessment.CustomizeSelectionProcessPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

public class CandidateAssessmentStepDef {
	public String selStageName;
	public static LinkedHashSet<String> globalStages;
	public static LinkedHashSet<String> projectStages;

	CustomizeSelectionProcessPO customizeSelectionProcess = (CustomizeSelectionProcessPO) PageObjectWrapper
			.getObject(CustomizeSelectionProcessPO.class);
	CandidateAssessmentPO cadAssessment = (CandidateAssessmentPO) PageObjectWrapper
			.getObject(CandidateAssessmentPO.class);
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);

	@Then("Verify that user is able to see the Add candidate button on candidate assessment page")
	public void verifyThatUserIsAbleToSeeTheAddCandidateButtonOnPage() {
		Assert.assertTrue(cadAssessment.verifyAddCandidateButtonOnPage(),
				"Test case Failed : As user os not able to see the add candidate button on candidate assessment page");
	}

	@Then("Verify that user is able to see the listed headings on page")
	public void verifyThatUserIsAbleToSeeTheListedHeadingsOnPage(DataTable dt) {
		List<String> list = dt.asList(String.class);
		for (int i = 0; i < list.size(); i++) {
			Assert.assertTrue(cadAssessment.verifyHeadings(list.get(i)),
					"Test case failed : As user is not able to see the heading " + list.get(i) + "");
		}

	}

	@Then("\"([^\"]*)\" User Sets all the stages on customize the selection process page")
	public void userIsOnCustoMizeTheSelectionProcessPage(String userType) {
		commonActions.navigateToUrl(getAppConfigValue("URLs.customizeSelectionProcess"));
		globalStages = customizeSelectionProcess.getGlobalSelectionStage();

	}

	@Then("Verify that user is able to see all the stages in Selected Stage DD")
	public void verifyThatUserIsAbleToSeeAllTheStagesInSelectedStageDD() {
		cadAssessment.clickSelectedStageDD();
		projectStages = cadAssessment.getAllSelectionStageFromDD();
		Assert.assertTrue(globalStages.equals(projectStages),
				"Test case failed : User is not able to see all the stages in Selection stage DD");
	}

	@Then("User attach a test on \"([^\"]*)\" stage when using selction stage DD to select stage")
	public void userAttachATestOnFollowingStageWhenUsingSelctionStageDDToSelectStage(String stageName) {
		cadAssessment.clickSelectedStageDD();
		cadAssessment.selectStage(stageName);
	}

	@And("User added a stage on customized section stage page")
	public void userAddedAStageOnCustomizedSectionStagePage() {
		selStageName = CommonAction.generateRandomStrings(9, "String");
		customizeSelectionProcess.clickAddSelectionStage();
		customizeSelectionProcess.addSelectionStage(selStageName);
		customizeSelectionProcess.clickSaveButton();
	}

	@Then("Verify that user is able to \"([^\"]*)\" the stage on customized selection page")
	public void verifyThatUserIsAbleToSeeTheStageOnCustomizedSelectionPage(String status) {
		if (status.equalsIgnoreCase("Add")) {
			Assert.assertTrue(customizeSelectionProcess.verifySelectionStage(selStageName),
					"Test case failed : As Stage didn't added at customize selection page");
			TestNGLogUtility.pass("Test case Passed : As user is able to see the stage customize selection page");
		}
		if (status.equalsIgnoreCase("Delete")) {
			Assert.assertFalse(customizeSelectionProcess.verifySelectionStage(selStageName),
					"Test case failed : As Stage didn't deleted at customize selection page");
			TestNGLogUtility.pass("Test case Passed : As user is not able to see the stage customize selection page");
		}
	}

	@Then("Verify that stage is \"([^\"]*)\" from customize selected process page reflected to Selected Stage DD")
	public void verifyThatStatusOfStageFromCustomizePageInSelectedStageDD(String status) {
		cadAssessment.clickSelectedStageDD();
		if (status.equalsIgnoreCase("Added")) {
			Assert.assertTrue(cadAssessment.verifySelectStagesInDD(selStageName),
					"Test case failed : As user is not able to see the stage in selction stage dd");
			TestNGLogUtility.pass("Test case Passed : As user is able to see the stage in selction stage dd");
		}
		if (status.equalsIgnoreCase("Deleted")) {
			Assert.assertFalse(cadAssessment.verifySelectStagesInDD(selStageName),
					"Test case failed : As user is able to see the stage in selction stage dd");
			TestNGLogUtility.pass("Test case Passed : As user is not able to see the stage in selction stage dd");
		}
	}

	@And("User deleted the added stage from customized section stage page")
	public void userDeleteTheAddedStageFromCustomizedSectionStagePage() {
		customizeSelectionProcess.deleteSelectionStage(selStageName);
	}

	@Then("Verify that user is able to view the test on \"([^\"]*)\" stage on Candidate Assessment Page Grid")
	public void verifyThatUserIsAbleToViewTheTestOnCandidateAssessmentPageGrid(String stageName) {
		Assert.assertTrue(cadAssessment.testOnCandidateAssessmentTab(AttachTestStepDef.testName, stageName),
				"Test case Failed : As user is not able to see the attached test on candidate assessment tab grid");
		TestNGLogUtility.pass("As user is able to see the attached test on candidate assessment tab grid");
	}

	@When("User click on \"([^\"]*)\" button on Candidate Assessment Page Grid")
	public void UserClickOnButtonOnCandidateAssessmentPageGrid(String status) {
		cadAssessment.clickOnTestsLinks(AttachTestStepDef.testName, status);
	}

	@Then("Verify that Test is displying in inactive tests History")
	public void VerifyThatTestIsDisplyingInInactiveTestsHistory() {
		Assert.assertTrue(cadAssessment.verifyInactiveTest(AttachTestStepDef.testName),
				"Test case failed : As user is still able to see the test in active test");
		TestNGLogUtility
				.pass("As user is able to see the attached test in inactive category on candidate assessment tab grid");
	}

	@And("User select \"([^\"]*)\" in light box")
	public void userSelectOptionInLightBox(String option) {
		cadAssessment.selectYorN(option);
	}

	@And("User accept to remove the test")
	public void userAcceptToRemoveTheTest() {
		cadAssessment.acceptRemoveConfirmation();
	}

}
