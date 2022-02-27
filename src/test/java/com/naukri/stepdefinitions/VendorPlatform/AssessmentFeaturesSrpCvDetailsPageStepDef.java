package com.naukri.stepdefinitions.VendorPlatform;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.naukri.pageobjects.VendorPlatform.*;
import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.MongoDBConnector;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.pageobjects.Assessment.CandidateAssessmentPO;
import com.naukri.pageobjects.CandidateCommunication.MailBoxTabPO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import com.naukri.automation.util.GenericFunctions;

public class AssessmentFeaturesSrpCvDetailsPageStepDef {
    public static String RequirementName = "", NoOfInvites, reqName = "", newTestName = "", candName = "", processID = "";
    APITestOps APITestObj = new APITestOps();
    CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
    HackerEarthSitePO hesite = (HackerEarthSitePO) PageObjectWrapper.getObject(HackerEarthSitePO.class);
    AttachAssessmentForPartnerPO attach = (AttachAssessmentForPartnerPO) PageObjectWrapper
            .getObject(AttachAssessmentForPartnerPO.class);
    AssessmentFeaturesOnSrpAndCVDetailsPO AssessmentFeatures = (AssessmentFeaturesOnSrpAndCVDetailsPO) PageObjectWrapper
            .getObject(AssessmentFeaturesOnSrpAndCVDetailsPO.class);

    MailBoxTabPO objMailBoxPO = (MailBoxTabPO) PageObjectWrapper.getObject(MailBoxTabPO.class);
    SoftAssert sa = new SoftAssert();
    public static JSONObject data = MongoDBConnector.getJSONObject("PartnerAssessment", "DocumentName", "ErrorSuccessMessages");
    public static Map<String, Object> APIbody = new HashMap<String, Object>();

    @And("User click on Send a new assessment")
    public void user_click_on_Send_a_new_assessment() {
        RequirementName = attach.getRequirementName();
        AssessmentFeatures.clickOnSendAnewAssessment();
    }

    @Then("User select all the candidates at {string} stages")
    public void user_select_all_the_candidates_at_stages(String stage) {
        if (stage.equals("All"))
            AssessmentFeatures.selectCandidatesOnSRP();
        else
            AssessmentFeatures.selectCandidatesOnSRP(stage);
    }

    @Then("User verify the heading on Send Assessment page")
    public void user_verify_the_heading_on_Send_Assessment_page() {
        Assert.assertTrue(attach.validatHeadingOnSendAssessmentPage(), "Heading is incorrect");
    }

    @Then("User verify the subheading on Send Assessment page")
    public void user_verify_the_subheading_on_Send_Assessment_page() {
        Assert.assertTrue(attach.validatDynamicSubHeadingOnSendAssessmentPage(RequirementName), "Subheading is incorrect");
    }

    @Then("User click on Send Assessment button")
    public void user_click_on_Send_Assessment_button() {
        attach.clickOnSendTestButton();
    }

    @Then("User click on trigger test automatically check box and fill {string} in  candidates allowed textbox")
    public void user_click_on_trigger_test_automatically_check_box_and_fill_in_candidates_allowed_textbox(String candidatesAllowed) {
        attach.checkAutomaticTriggerCheckBox();
        attach.PassCandidatesAllowedForAutomaticTrigger(candidatesAllowed);
    }

    @Then("User verify the test attached on {string} substage of expanded stage")
    public void user_verify_the_test_attached_on_substage_of_expanded_stage(String subStage, DataTable dt) {
        List<String> list = dt.asList(String.class);
        Assert.assertTrue(attach.verifyTestAttachedAtstageOrSubstage(subStage, list.get(0)), "Given test not found at the substage");
        ;
    }

    @Then("User click on Edit icon for test attached on {string}")
    public void user_click_on_Edit_icon_for_test_attached_on(String subStage) {
        RequirementName = attach.getRequirementName();
        attach.clickOnEditAssessmentIconOnSubstages(subStage);
    }

    @Then("User verify the dynamic subheading and prefilled stage on Edit Assessment page for {string}")
    public void user_verify_the_dynamic_subheading_and_prefilled_stage_on_Edit_Assessment_page(String testName) {
        Assert.assertTrue(attach.validatDynamicSubHeadingOnEditAssessmentPage(RequirementName, testName), "Wrong subheading for Edit Assessment");
    }

    @And("User click on Attach icon for substage {string} of stage {string}")
    public void user_click_on_Attach_icon_for_substage(String subStage, String stage) {
        RequirementName = attach.getRequirementName();
        attach.clickOnAttachIconOnSubStageForStage(stage, subStage);
    }

    @Then("User verify trigger test automatically check box is checked")
    public void user_verify_trigger_test_automatically_check_box_is_checked() {
        Assert.assertTrue(attach.verifyAutomaticTriggerCheckedOrNot(), "Max candidates textbox not present");
    }

    @Then("User verify the candidates allowed are {string} in the textbox")
    public void user_verify_the_candidates_allowed_are_in_the_textbox(String value) {
        Assert.assertTrue(attach.getValueOfNumberOfCandidatesAllowed().equals(value), "Max candidates value not retained");
    }

    @Then("User deselect the trigger test automatically check box")
    public void user_deselect_the_trigger_test_automatically_check_box() {
        if (attach.verifyAutomaticTriggerCheckedOrNot()) {
            attach.checkAutomaticTriggerCheckBox();
            Assert.assertFalse(attach.verifyAutomaticTriggerCheckedOrNot(), "Max candidates textbox  present");
        } else
            Assert.fail("Automatic trigger checkbox already not checked");
    }

    @Then("User click on Save Settings button")
    public void user_click_on_Save_Settings_button() {
        AssessmentFeatures.clickOnSaveSettings();
    }

    @Then("User verify the settings are updated for Naukri Assessments test")
    public void user_verify_the_settings_are_updated_for_Naukri_Assessments_test() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @And("User verify the settings are updated for the test on {string} substage for {string} stage")
    public void user_verify_the_settings_are_updated_for_the_HE_test(String subStage, String stage) {
        attach.expandStageDropdown(stage);
        attach.clickOnEditAssessmentIconOnSubstages(subStage);
        Assert.assertFalse(attach.verifyAutomaticTriggerCheckedOrNot(), "Changes on Edit Assessment not retained");
    }

    @Then("User attach a {string} test at {string} stage using selection stages")
    public void user_attach_a_test_at_stage_using_selection_stages(String partnerName, String stage) {
        attach.clickOnAttachIconOnStageWithNoSubstages(stage);
        attach.selectAssessmentPartnerOption(partnerName);
        if (partnerName.equalsIgnoreCase("HackerEarth")) {
            attach.selectHETest();
            attach.clickNextButton();
        } else {
            attach.clickOncategory();
            attach.selectTestInACategory();
            attach.clickNextButton();
        }
        attach.clickOnAttachTestButton();
    }

    @Then("User click on remove test attached at {string} stage")
    public void user_click_on_remove_test_attached_at_stage(String stage) {
        attach.clickOnDeleteAssessmentOnStage(stage);
    }

    @Then("User click on Yes on the confirmation box")
    public void user_click_on_on_the_confirmation_box() {
        attach.clickOnYesDeleteAssessment();
    }

    @Then("User verify that the test is removed from {string} stage")
    public void user_verify_that_the_test_is_removed_from_stage(String stage) {
        attach.checkPresenceOfAttachIconOnStageWithNoSubstage(stage);
    }

    @Then("User select {string} radio button in Send Assessment confirmation box")
    public void user_select_radio_button_in_Send_Assessment_confirmation_box(String radio) {
        //	NoOfInvites = AssessmentFeatures.clickOnSendToAllOrStageRadioButtonInSendConfirmationBox(radio);
    }

    @Then("User click on {string} in Send Assessment confirmation box")
    public void user_click_on_in_Send_Assessment_confirmation_box(String response) {
        AssessmentFeatures.clickOnResponseInSendConfirmationBox(response);
    }

    @Then("User verify that In progress status message is displayed for {string}")
    public void user_verify_that_In_progress_status_message_is_displayed(String partnerName) {
        Assert.assertTrue(AssessmentFeatures.verifyInProgressMessageAfterSendAssessment(data.get("InProgressMessage").toString(), partnerName), "In Progress message incorrect or not found");
        ;
    }

    @Then("User verify that {string} message is displayed and correct")
    public void user_verify_that_success_message_is_displayed(String msgTpye, DataTable dt) {
        List<String> list = dt.asList(String.class);
        Assert.assertTrue(AssessmentFeatures.verifySuccessErrorMessageAfterSendAssessment(msgTpye, data, list.get(0)), "Success/error message incorrect or not found");
    }

    @Then("User verify the attach button is now {string}")
    public void user_verify_the_attach_button_is_now(String viewBtnTxt) {
        Assert.assertTrue(AssessmentFeatures.verifyAttachConvertToViewAssessment(viewBtnTxt), "Incorrect button name");
    }

    @When("User hover on Send Assessment to open Dropdown")
    public void user_hover_on_Send_Assessment_to_open_Dropdown() {
        AssessmentFeatures.hoverOnSendAssessment();
    }

    @And("User hover on View Assessment to open Dropdown")
    public void user_hover_on_View_Assessment_to_open_Dropdown() {
        AssessmentFeatures.hoverOnViewAssessment();
    }

    @And("User click on Attach new assessment in dropdown")
    public void user_hover_on_Attach_new_Assessment_in_Dropdown() {
        AssessmentFeatures.clickOnAttachnewAssessment();
    }

    @Then("User verify that {string} attached at {string} stage is shown in {string} Dropdown")
    public void user_verify_that_attached_at_stage_is_shown_in_Dropdown(String testName, String stageName, String DDtype) {
        if (testName.equalsIgnoreCase("new test"))
            testName = newTestName;
        Assert.assertTrue(AssessmentFeatures.verifyTestAtStagePresentInDD(DDtype, testName, stageName), "Test at the stage not found");
        TestNGLogUtility.info("Test found in Send dropdown");
    }

    @When("User click on {string} attached at {string} stage in {string} Dropdown")
    public void user_click_on_attached_at_stage_in_Dropdown(String testName, String stageName, String DDtype) {
        if (testName.equalsIgnoreCase("new test"))
            testName = newTestName;
        AssessmentFeatures.clickOnParticularTestInSendAssessmentDD(testName, DDtype);
    }

    @Then("User verify the {string} tuple for the candidate on {string} page")
    public void user_verify_the_tuple_for_the_candidate_on_page(String link, String page, DataTable dt) {
        List<String> list = dt.asList(String.class);
        String testName = list.get(0);
        if (list.get(0).equals(""))
            testName = newTestName;
        Assert.assertTrue(AssessmentFeatures.verifytuplemessageforAssessment(link, data, testName,page), link + " tuple message not found or incorrect");
    }

    @Then("User verify soon to be sent message is displayed for {string}")
    public void user_verify_soon_to_be_sent_message_is_displayed(String testName) {
        Assert.assertTrue(AssessmentFeatures.verifySoonToBeSentMessageAfterSendAssessment(testName), "Test soon to be sent messsage not found");
    }

    @When("User verify the heading and sub heading of modal window for test for {string} assessments")
    public void user_verify_the_heading_and_sub_heading_of_modal_window_for_test(String msgType, DataTable dt) {
        List<String> list = dt.asList(String.class);
        sa.assertTrue(AssessmentFeatures.verifyModalWindowHeading(list.get(0)), "Wrong Heading for Send Modal wndow");
        sa.assertTrue(AssessmentFeatures.verifyModalWindowSubHeading(data, msgType, list.get(1)), "Wrong Sub Heading for Send Modal wndow");
        sa.assertAll();
    }

    @When("User verify that {string} checkbox is checked by default")
    public void user_verify_that_checkbox_is_checked_by_default(String checkBox) {
        Assert.assertTrue(AssessmentFeatures.verifyCheckBoxIsSelected(checkBox), "CheckBox is not selected");
    }

    @And("User verify that {string} checkbox is not checked by default")
    public void user_verify_that_checkbox_is_not_checked_by_default(String checkBox) {
        Assert.assertFalse(AssessmentFeatures.verifyCheckBoxIsSelected(checkBox), "CheckBox is selected");
    }

    @When("User verify that radio buttons under {string} checkbox are not present")
    public void user_verify_that_radio_buttons_under_checkbox_are_not_present(String checkbox1) {
        Assert.assertEquals(AssessmentFeatures.getNumberOfRadioAfterCheckBox(checkbox1), 0, "Radio buttons are present");
    }

    @When("User verify that {string} and {string} checkboxes are not present")
    public void user_verify_that_and_checkboxes_are_not_present(String checkbox1, String checkbox2) {
        Assert.assertFalse(AssessmentFeatures.verifyPresenceOfCheckBox(checkbox1), "Radio buttons are present");
        Assert.assertFalse(AssessmentFeatures.verifyPresenceOfCheckBox(checkbox2), "Radio buttons are present");
    }

    @When("User verify that {string} button is not clickable")
    public void user_verify_that_button_is_not_clickable(String string) {
        Assert.assertTrue(AssessmentFeatures.verifySendButtonClickable(), "end button is clickable");
    }


    @When("User verify that {int} radio buttons under {string} checkbox  present")
    public void user_verify_that_radio_buttons_under_checkbox_present(int num, String checkbox1) {
        Assert.assertEquals(AssessmentFeatures.getNumberOfRadioAfterCheckBox(checkbox1), num, "Radio buttons are present");
    }

    @When("User select {string} radio button under {string} checkbox")
    public void user_select_radio_button_under_checkbox(String radioBtn, String checkbox) {
        AssessmentFeatures.selectRadioAfterCheckBox(radioBtn, checkbox);
    }

    @When("User select the candidate not on {string} stage")
    public void user_select_the_candidate_not_on_stage(String stage) {
        AssessmentFeatures.selectCandidatesNotOnStage(stage);
    }

    @When("User verify that radio buttons under {string} checkbox not present")
    public void user_verify_that_radio_buttons_under_checkbox_not_present(String checkBox) {
        Assert.assertEquals(AssessmentFeatures.getNumberOfRadioAfterCheckBox(checkBox), 0, "Radio buttons are present");
    }

    @And("User verify the text of webcam and tab switching checkboxes")
    public void User_verify_the_text_of_webcam_and_tab_switching_checkboxes(DataTable dt) {
        List<String> list = dt.asList(String.class);
        for (int i = 0; i < list.size(); i++)
            Assert.assertTrue(AssessmentFeatures.verifyAnyText(list.get(i)), "Wrong test for Webcam and Tab switch settings");
        ;
    }

    @When("User verify whether webcam and tab switching checkboxes are present for {string}")
    public void user_verify_webcam_and_tab_switching_checkboxes_are_present_for(String partnerName) {
        if (partnerName.equals("HackerEarth"))
            Assert.assertFalse(AssessmentFeatures.verifyWebCamAndProctorSettings(), "Settings present for HackerEarth as well");
        else
            Assert.assertTrue(AssessmentFeatures.verifyWebCamAndProctorSettings(), "Settings present for the partner as well");
    }

    //The user should be on overview page to use this method
    @Given("User adds multiple profiles to an existing requirement through API for \"([^\"]*)\"")
    public void addNewCandidateAndReq(String subType, DataTable dt) {
        List<String> list = dt.asList(String.class);
        processID = AssessmentFeatures.getProcessIDforRequirement();
        reqName = attach.getRequirementName();
        int NoOfCandidates = Integer.parseInt(list.get(1));
        for (int i = 1; i <= NoOfCandidates; i++) {
            APIbody = APITestObj.addCandidateInExistingOrNewRequirement(getAppConfigValue("Users." + subType + ".Superuser.username"),
                    getAppConfigValue("Users.Password"), processID, reqName, list.get(0),
                    getAppConfigValue("Users." + subType + ".Superuser.ReqsubStatusId"));
        }
        reqName = APIbody.get("project[projectName]").toString();
        TestNGLogUtility.info(NoOfCandidates + " Candidate(s) added to the Requirement: " + reqName);
    }

    @When("User navigate to settings page")
    public void User_navigate_to_settings_page() {
        commonActions.navigateToUrl(URLBuilder.getURL("settingsPage"));
    }

    @Given("User adds a single profile to a new requirement through API for \"([^\"]*)\" user")
    public void addaCandidateToNewReq(String subType, DataTable dt) {
        List<String> list = dt.asList(String.class);
        APIbody = APITestObj.addCandidateInExistingOrNewRequirement(getAppConfigValue("Users." + subType + ".Superuser.username"),
                getAppConfigValue("Users." + subType + ".Superuser.password"), "", "", list.get(0),
                getAppConfigValue("Users." + subType + ".Superuser.ReqsubStatusId"));
        reqName = APIbody.get("project[projectName]").toString();
        candName = APIbody.get("candidateProfile[name]").toString();
    }

    @And("User move to newly created or first requirement")
    public void User_move_to_newly_created_or_first_requirement() {
        attach.moveToNewlyCreatedOrFirstRequirement(reqName);
    }

    @And("User add an copy of HackerEarth Test for below credentials")
    public void UserAddCopyOfHackerEarthTestForBelowCredentials(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        String testName = list.get(0).get("testName");
        String randomNumber = Integer.toString(((int) (Math.random() * (100000000))) + 1);
        newTestName = testName + randomNumber;
        hesite.goToTestURLfromName(testName);
        hesite.LoginToPartner(list.get(0).get("Username"), list.get(0).get("Password"));
        hesite.clickOnCloneTest();
        hesite.fillNameAndCreateTest(newTestName);
        hesite.goToTestURLfromName(newTestName);
        hesite.clickOnPublishTest();
        hesite.clickOnPublish();
        TestNGLogUtility.info(newTestName + "test has been added on HackerEarth");
    }

    @And("User delete the test from HackerEarth")
    public void User_delete_the_test_from_HackerEarth(DataTable dt) {
        String testToDelete = "";
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        if (list.get(0).get("testName").equals(""))
            testToDelete = newTestName;
        else
            testToDelete = list.get(0).get("testName");
        hesite.deleteTestFromHackerEarth(list.get(0).get("Username"), list.get(0).get("Password"), testToDelete);
    }

    @And("User invite an candidate for the test")
    public void user_invite_a_candidate_for_the_test(DataTable dt) {
        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        String testToInvite = list.get(0).get("testName");
        if (testToInvite.equals(""))
            testToInvite = newTestName;
        hesite.inviteCandidateForTestFromHE(testToInvite, list.get(0).get("CandidateEmailID"));
    }

    @Then("User verify that {string} for {string} is displayed within confirmation box")
    public void user_verify_that_for_is_displayed_within_confirmation_box(String errorType, String partnerName) {
        Assert.assertTrue(AssessmentFeatures.verifyHackerEarthErrorMessage(errorType, "confirmation box", data), "Error message is incorrect");
    }

    @Then("User verify that the sticky box is displayed with {string} for {string}")
    public void user_verify_that_the_sticky_box_is_displayed_with_for(String errorType, String partnerName) {
        Assert.assertTrue(AssessmentFeatures.verifyHackerEarthErrorMessage(errorType, "sticky box", data), "Error message is incorrect");
    }

    @When("User switch to new tab")
    public void user_switch_to_new_tab() {
        AssessmentFeatures.openNewTab();
    }

    @When("User update the end date for the new test from HackerEarth to make it expired")
    public void user_update_the_end_date_for_the_new_test_from_HackerEarth_to_make_it_expired(DataTable dt) {
        hesite.goToTestURLfromName(newTestName);
        hesite.setEndDateAndTimeAsCurrent();
    }

    @Then("User click on {string} link in the error message")
    public void user_click_on_link_in_the_error_message(String string) {
        AssessmentFeatures.clickOnViewErrorDetails();
    }

    @Then("User verify that {string} error for {string} is displayed inside modal window")
    public void user_verify_that_for_is_displayed_inside_modal_window(String error, String partnerName) {
        Assert.assertTrue(AssessmentFeatures.verifyModalErrorHeading(error), "Error message is incorrect");
    }

    @Then("User verify that candidate name is displayed on hover")
    public void user_verify_that_candidate_name_is_displayed_on_hover() throws InterruptedException {
        String candName = APIbody.get("candidateProfile[name]").toString();
        Assert.assertTrue(AssessmentFeatures.verifyCandidateNameOnHover(candName), "Candidate Name is incorrect/not found on hover");
        Thread.sleep(20000);
    }

    @Then("User click on Okay button in error window")
    public void user_click_on_Okay_button_in_error_modal_window() {
        AssessmentFeatures.clickOnOkayButton();
    }

    @Then("User verify error message in candidate tuple")
    public void user_verify_error_message_in_candidate_tuple(DataTable dt) {
        List<String> list = dt.asList(String.class);
        AssessmentFeatures.verifyCandidateTupleFirstText(list.get(0));
    }


    @And("User verify that message when all candidates are not at stage at which test attached")
    public void user_verify_that_message_when_all_candidates_are_not_at_stage_at_which_test_attached() {
        Assert.assertTrue(AssessmentFeatures.verifyMessageWhenCandidatesNotAtStageAtWhichTestAttached());

    }

    @And("User select response in Reminder Confirmation Box")
    public void User_select_response_in_Reminder_Confirmation_Box(DataTable dt) {
        List<String> list = dt.asList(String.class);
        AssessmentFeatures.clickOnResponseInReminderSendConfirmationBox(list.get(0));
        ;
    }

    @And("User move to CVdetails page for the candidate")
    public void user_move_to_CVdetails_page_for_the_candidate() {
        AssessmentFeatures.clickOnCandidateNameToMovetoCVdetails(candName);
    }

    @Then("User verify result on CVdetails page for test with {string} as failed")
    public void verify_result_on_CVdetails_page_for_test_with(String cutoffStatus, DataTable dt) {
        List<String> list = dt.asList(String.class);
        String testName = list.get(0);
        if (testName.equals(""))
            testName = newTestName;
        Assert.assertEquals(AssessmentFeatures.verifyAssessmentResultOnCVdetails(testName, cutoffStatus), "Failed");
        ;
    }

    @And("User update the requirement name in database for {string}")
    public void user_update_the_requirement_name_in_database(String subscriptionType) {
        AssessmentFeatures.UpdateReqNameInDB(reqName, subscriptionType);
    }

    @And("User moved to requirement with name picked from database for {string}")
    public void user_moved_to_requirement_with_name_picked_from_database(String subscriptionType) {
        JSONObject data2 = MongoDBConnector.getJSONObject("PartnerAssessment", "DocumentName", "DataToReuse");
        reqName = data2.get("RequirementName" + subscriptionType).toString();
        TestNGLogUtility.info(reqName + "  " + subscriptionType);
        attach.moveToNewlyCreatedOrFirstRequirement(reqName);
    }

    @Given("User click on {string} checkbox")
    public void user_click_on_checkbox(String checkBox) {
        AssessmentFeatures.clickOnCheckBox(checkBox);
    }

    @Then("User verify that candidate image is displayed on hover as well")
    public void user_verify_that_candidate_image_is_displayed_on_hover_as_well() {
        Boolean result = AssessmentFeatures.verifyCandidateImageOnHover();
        if (result == true)
            TestNGLogUtility.info("Candidate Image found");
        else
            TestNGLogUtility.info("Candidate Image Not found");
    }

    @Given("User delete unused tests")
    public void user_delete_unused_tests() {
        hesite.deleteUnusedTests("Kaur.amanpreet@naukri.com", "amanpreet21");
    }

    @Then("User verify result on Srp with {string} as {string} for the test")
    public void verifyResultOnSrpWithForTest(String cutoffStatus, String expectedResult, DataTable dt) {
        List<String> list = dt.asList(String.class);
        Assert.assertTrue(AssessmentFeatures.verifyResultsOnSrp(cutoffStatus, list.get(0)).contains(expectedResult),"Tuple message for result incorrect or not present");
    }

    @And("Candidate attempt the test for {string}")
    public void attemptTest(String partnerName) {
        AssessmentFeatures.clickOnStartTest();
        AssessmentFeatures.attemptTest(partnerName);
    }
}
