package com.naukri.stepdefinitions.VendorPlatform;
import static com.naukri.automation.util.YamlReader.getAppConfigValue;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import org.bson.Document;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;
import com.naukri.pageobjects.VendorPlatform.*;
import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Applications.InboxPagePO;
import com.naukri.pageobjects.Applications.InboxPagePO.AddToRequirementLightbox;
import com.naukri.pageobjects.Assessment.AttachAssessmentPO;
import com.naukri.pageobjects.Assessment.CandidateAssessmentPO;
import com.naukri.pageobjects.Assessment.CustomizeSelectionProcessPO;
import com.naukri.pageobjects.Requirements.RequirementCreationPagePO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import com.naukri.automation.util.GenericFunctions;
public class AttachStepDef {
	
	public static String TestDataFile = ".//src//test//resources//testdata//testDataAssessment.properties";
	public static LinkedHashSet<String> globalStages;
	public static LinkedHashSet<String> projectStages;
	public static String RequirementName;
	public String selStageName;
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	HEmarketingTourAndRequestDemoPO RD = (HEmarketingTourAndRequestDemoPO) PageObjectWrapper
			.getObject(HEmarketingTourAndRequestDemoPO.class);
	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper
			.getObject(AssessmentPartnerIntegrationPO.class);
	AttachAssessmentForPartnerPO attach = (AttachAssessmentForPartnerPO) PageObjectWrapper
			.getObject(AttachAssessmentForPartnerPO.class);
	APITestOps APITestObj = (APITestOps) PageObjectWrapper.getObject(APITestOps.class);
	CustomizeSelectionProcessPO customizeSelectionProcess = (CustomizeSelectionProcessPO) PageObjectWrapper
			.getObject(CustomizeSelectionProcessPO.class);
	CandidateAssessmentPO cadAssessment = (CandidateAssessmentPO) PageObjectWrapper
			.getObject(CandidateAssessmentPO.class);
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	RequirementCreationPagePO requirementCreationPagePO = (RequirementCreationPagePO) PageObjectWrapper
			.getObject(RequirementCreationPagePO.class);
	
	SoftAssert sa=new SoftAssert();

	@Then("User verify that atleast one partner is active or configured.")
	public void user_verify_that_atleast_one_partner_is_active_or_configured() {
	    Assert.assertTrue(API.getNumberOfConfiguredPartners()>0, "No Partner Configured");
	}

	@Then("User move to a particular requirement page")
	public void user_move_to_a_particular_requirement_page() {
	    attach.moveToFirstRequirement();
	}
	
	@And ("User click on Add Assessment button")
	public void user_click_on_Add_Assessment_button()
	{
		attach.clickAttachAssessment();
	}

	@Then("User verify that	Attach Assessment button should be available and accessible.")
	public void user_verify_that_Attach_Assessment_button_should_be_available_and_accessible() {
		Assert.assertTrue(attach.checkPresenceOfAttachAssessmentButton(),"Attach button is not present");
	}

	@Given("User login into RMS as an {string} as {string}")
	public void user_login_into_RMS_as_an_as(String subscriptionType, String userType) {
		if(userType.equalsIgnoreCase("subuser"))
		genericFunctions.loginToRMS(YamlReader.getAppConfigValue("Assessment.Enterprise.Subuser.username"), YamlReader.getAppConfigValue("Assessment.Enterprise.Subuser.password"));
		else
			genericFunctions.loginToRMS(YamlReader.getAppConfigValue("Assessment."+subscriptionType+"."+userType+".username"), YamlReader.getAppConfigValue("Password"));
	}

	@Then("User verify that User have {int} credits for Naukri Assessmests")
	public void user_verify_that_User_have_credits_for_Naukri_Assessmests(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User attach the test at a particular stage")
	public void user_attach_the_test_at_a_particular_stage() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User move a candidate to the stage where test is attached")
	public void user_move_a_candidate_to_the_stage_where_test_is_attached() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User move to candidate profile.")
	public void user_move_to_candidate_profile() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User verify that User am not able to send test to candidate.")
	public void user_verify_that_User_am_not_able_to_send_test_to_candidate() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User move to a particular requirement page with not zero applications")
	public void user_move_to_a_particular_requirement_page_with_not_zero_applications() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User move to selection stage tab in that requirement.")
	public void user_move_to_selection_stage_tab_in_that_requirement() {
	    attach.clickOnSelectionStagesTab();
	}
	
	@Then("User expand a particular or first Stage")
	public void user_expand_particular_or_first_stage(DataTable dt)
	{
		List<String> list = dt.asList(String.class);
		attach.expandStageDropdown(list.get(0));
	}

	@Then("User verify that Attach Assessment link should be available and accessible from all substages")
	public void user_verify_that_Attach_Assessment_link_should_be_available_and_accessible_from_any_stage(DataTable dt) {
		List<String> list = dt.asList(String.class);
		
	  int attachIconsCount = attach.numberOfAttachIconsInExpandedStage();
	  int substagesCount = attach.numberOfsubstagesInStage(list.get(0));
	  if(attachIconsCount==0)
		  Assert.fail("No Attach nutton found in the stage");
	  else
		  Assert.assertTrue(attachIconsCount==substagesCount, "Attach not present for every substage");
	}

	@Then("User move to any SRP page for the requirement.")
	public void user_move_to_any_candidate_profile_posted_for_the_requirement() {
	   attach.moveToSRPfromRequirement();
	}
	
	@Then("User click on {string} radio button")
	public void user_click_on_radio_button(String partnerName) {
	    attach.selectAssessmentPartnerOption(partnerName);
	}
	
	@Then("User expand a particular or first test in Naukri Assessments")
	public void user_expand_a_particular_or_first_test_in_Naukri_Assessments() {
		int tests = attach.clickOncategory();
		Assert.assertTrue(tests>0,"Zero tests in category");
		
	}

	@Then("User verify partner tests should be present with expected details for {string}")
	public void user_verify_partner_tests_should_be_present_with_expected_details(String partnerName) {
	    Assert.assertTrue(attach.validateTestDetailsLabels(partnerName), "Wrong labels");
	}
	
	@Then("User verify partner tests should be present with expected details in expanded category")
	public void User_verify_partner_tests_should_be_present_with_expected_details_in_expanded_category()
	{
		Assert.assertTrue(attach.verifyTestLabelsInExpandedCategory("Questions"), "Questions Label not found");
		Assert.assertTrue(attach.verifyTestLabelsInExpandedCategory("TimeTaken"), "TimeTaken Label not found");
		Assert.assertTrue(attach.verifyTestLabelsInExpandedCategory("UpArrow"), "UpArrow Label not found");
		Assert.assertTrue(attach.verifyTestLabelsInExpandedCategory("CategoryName"), "Category Name Label not found");
		Assert.assertTrue(attach.verifyNumberOfTestsForExpandedCategory(), "Number of tests in tupbe and actual are differnt");
	}

	@Then("User verify Create New Test button is present")
	public void user_verify_Create_New_Test_button_is_present() {
		Assert.assertTrue(attach.validatePresenceOfCreateNewTest(), "Create New Test not found");
	}

	@Then("User hover on a particular test to verify edit and preview button are present and visible")
	public void user_hover_on_a_particular_test_to_verify_edit_and_preview_button_are_present_and_visible() 
	{
		boolean preview = attach.verifyPreviewIconDisplayedOnHoveringTest();
		boolean edit = attach.verifyEditIconDisplayedOnHoveringTest();
		Assert.assertTrue(preview && edit, "Either Preview/Edit or both not visible");
	    
	}

	@Then("User verify Create New Test button is not present for Naukri Assessments")
	public void user_verify_Create_New_Test_button_is_not_present_for_Naukri_Assessments() {
	   Assert.assertFalse(attach.validatePresenceOfCreateNewTest(), "Create New Test Found for ER");
	}

	
	@Then("User verify the heading on Attach Assessment page")
	public void user_verify_the_heading_on_Attach_Assessment_page() {
	   Assert.assertTrue(attach.validatHeadingOnAttachAssessmentPage(), "Heading is incorrect");
	}

	@Then("User verify the subheading on Attach Assessment page")
	public void user_verify_the_subheading_on_Attach_Assessment_page() {
		RequirementName = attach.getRequirementName();
	    Assert.assertTrue(attach.validatDynamicSubHeadingOnAttachAssessmentPage(RequirementName), "Subheading is incorrect");
	}
	
	
	
	@And("User verify that Selection Stage is already selected as {string}")
	public void User_verify_that_Selection_Stage_is_already_selected(String stageWithSubstage) {
		
	}

	@Then("User verify the labels on Attach Assessment page")
	public void user_verify_the_labels_on_Attach_Assessment_page() {
		boolean ST = attach.verifyElementsOnAttachAssessmentPage("SelectTest");
		   boolean CTS = attach.verifyElementsOnAttachAssessmentPage("ConfigureTestSettings");
		   Assert.assertTrue(ST && CTS, "Some or all labels not found");
	}

	@Then("User verify the buttons on Attach Assessment page")
	public void user_verify_the_buttons_on_Attach_Assessment_page() {
		boolean Next = attach.verifyElementsOnAttachAssessmentPage("NextButton");
		   boolean Cancel = attach.verifyElementsOnAttachAssessmentPage("CancelButton");
		   boolean BackButton = attach.verifyElementsOnAttachAssessmentPage("BackButton");
		   boolean BackButtonArrow = attach.verifyElementsOnAttachAssessmentPage("BackButtonArrow");
		   Assert.assertTrue(Next && Cancel && BackButton && BackButtonArrow, "One or more buttons not found");
	}

	@Then("User verify number of partners shown on Attach Assessment page")
	public void user_verify_number_of_partners_shown_on_Attach_Assessment_page() {
	   Assert.assertTrue(attach.getNumberOfPartnersShown()>0, "No Partner found");
	}

	@Then("user verify the radio buttons for the partners")
	public void user_verify_the_radio_buttons_for_the_partners() {
	 boolean HE = attach.verifyElementsOnAttachAssessmentPage("rdoHackerEarth");
	   boolean ER = attach.verifyElementsOnAttachAssessmentPage("rdoNaukriAssessments");
	   Assert.assertTrue(ER && HE, "Radio button for either HE/ER or both not found");
	}

	@Then("User verify order of partners on Attach Assessment page")
	public void user_verify_order_of_partners_on_Attach_Assessment_page() {
		Assert.assertTrue(attach.isPartnerListSorted(), "Partners are not in alphatical order");
	}
	@Then("User verify buttons and labels in no tests case for {string}")
	public void user_verify_buttons_and_labels_in_no_tests_case_for(String partner) {
		sa.assertEquals(attach.getNumberOfTestsinHE(), 0,"Tests are present in HackerEarth");
		sa.assertTrue(attach.verifyButtonAndLabelInNoTestsCaseForPartners(partner, "CREATE TEST"),"CREATE TEST Button not found");
		sa.assertTrue(attach.verifyButtonAndLabelInNoTestsCaseForPartners(partner, "No Tests Label"),"Wrong Label");
		sa.assertTrue(attach.verifyButtonAndLabelInNoTestsCaseForPartners(partner, "No Tests Sub Label"),"Wrong Sub Label");
		sa.assertAll();
	}
	@Then("User checks all the stages on customize the selection process page")
	public void userIsOnCustoMizeTheSelectionProcessPage() {
		commonActions.navigateToUrl(getAppConfigValue("URLs.customizeSelectionProcess"));
		globalStages = customizeSelectionProcess.getGlobalSelectionStage();
	}

	@Then("Verify that user is able to see all the stages in Select Stage DD")
	public void verifyThatUserIsAbleToSeeAllTheStagesInSelectStageDD() {
		projectStages = cadAssessment.getAllSelectionStageFromDD();
		Assert.assertTrue(globalStages.equals(projectStages),
				"Test case failed : User is not able to see all the stages in Selection stage DD");
	}
	
	@And("User added a new stage on customized selection stage page")
	public void userAddedANewStageOnCustomizedSectionStagePage() {
		selStageName = CommonAction.generateRandomStrings(9, "String");
		customizeSelectionProcess.clickAddSelectionStage();
		customizeSelectionProcess.addSelectionStage(selStageName);
		customizeSelectionProcess.clickSaveButton();
	}
	
	@And("User deleted the newly added stage from customized section stage page")
	public void userDeleteTheAddedStageFromCustomizedSectionStagePage() {
		customizeSelectionProcess.deleteSelectionStage(selStageName);
	}
	
	@Then("Verify that stage is \"([^\"]*)\" from customize selected process page reflected to Select Stage DD")
	public void verifyThatStatusOfStageFromCustomizePageInSelectStageDD(String status){
		if (status.equalsIgnoreCase("Added")) {
			System.out.println(selStageName);
			Assert.assertTrue(attach.verifySelectionStagesInDD(selStageName),
					"Test case failed : As user is not able to see the stage in selction stage dd");
			TestNGLogUtility.pass("Test case Passed : As user is able to see the stage in selction stage dd");
		}
		if (status.equalsIgnoreCase("Deleted")) {
			Assert.assertFalse(cadAssessment.verifySelectStagesInDD(selStageName),
					"Test case failed : As user is able to see the stage in selction stage dd");
			TestNGLogUtility.pass("Test case Passed : As user is not able to see the stage in selction stage dd");
		}
	}
	
	@Then("Verify that user is able to \"([^\"]*)\" the stages on customized selection page")
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
	
	@Then("User create a new requirement and move to overview page")
	public void user_create_a_new_requirement_and_move_to_overview_page() {
		genericFunctions.selectOptionFromRMSGNB("Add A New Requirement", "Requirements");
		requirementCreationPagePO.fillRequirementName();
		requirementCreationPagePO.fillJobTitle();
		requirementCreationPagePO.fillInJD();
		requirementCreationPagePO.fillCandidateDetails();
		requirementCreationPagePO.selectCurrencyOfSalary("INR");
		requirementCreationPagePO.fillTheCTC("minCTC", "5,00,000");
		requirementCreationPagePO.fillTheCTC("maxCTC", "7,00,000");
		requirementCreationPagePO.fillTheExp("minExp", "2");
		requirementCreationPagePO.fillTheExp("maxExp", "5");
		requirementCreationPagePO.fillTheKeywords("Selenium");
		requirementCreationPagePO.fillInTheJobLocations("Delhi,Ahmedabad");
		requirementCreationPagePO.clickEmploymentTypeDD();
		requirementCreationPagePO.clickEmploymentTypeOptionfromList("Full Time, Freelance/Homebased");
		requirementCreationPagePO.clickOperationButton("Add Requirement");
		attach.clickonReqOverviewButton();
	}
	
	@Then("User fill other details of the Requirement when edit")
	public void fillMendatoryDetailsWhenRequirementIsEdited() {
		requirementCreationPagePO.fillJobTitle();
		requirementCreationPagePO.fillInJD();
		requirementCreationPagePO.selectCurrencyOfSalary("INR");
		requirementCreationPagePO.fillTheCTC("minCTC", "5,00,000");
		requirementCreationPagePO.fillTheCTC("maxCTC", "7,00,000");
		requirementCreationPagePO.fillTheExp("minExp", "2");
		requirementCreationPagePO.fillTheExp("maxExp", "5");
		requirementCreationPagePO.fillKeywords("Selenium");
		requirementCreationPagePO.fillInTheJobLocations("Delhi,Ahmedabad");
	}
}
