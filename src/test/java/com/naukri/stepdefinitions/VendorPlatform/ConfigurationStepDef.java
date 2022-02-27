package com.naukri.stepdefinitions.VendorPlatform;

import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.testng.Assert;
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
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import com.naukri.automation.util.GenericFunctions;
import java.util.Map;
public class ConfigurationStepDef {
	
	public static String TestDataFile = ".//src//test//resources//testdata//testDataAssessment.properties";
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	APITestOps APITestObj = (APITestOps) PageObjectWrapper.getObject(APITestOps.class);
	HEmarketingTourAndRequestDemoPO RD = (HEmarketingTourAndRequestDemoPO) PageObjectWrapper
			.getObject(HEmarketingTourAndRequestDemoPO.class);
	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper
			.getObject(AssessmentPartnerIntegrationPO.class);
	AttachAssessmentForPartnerPO attach = (AttachAssessmentForPartnerPO) PageObjectWrapper
			.getObject(AttachAssessmentForPartnerPO.class);
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	
	@Then("User verify Manage Integration option is visible")
	public void verifyManageIntegrationOptionIsVisible() {
		Assert.assertTrue(API.VerifyManageIntegrationInSettings(), "Manage partner Integration link not found") ;
	}
 
	@Then("User verify Assessment Partner Integration option is visible")
	public void verify_Assessment_Partner_Integration_option_is_visible() {
		Assert.assertTrue(API.VerifyAssessmentPartnerIntegrationInSettings(), "Link not found");
	}
	
	@Then ("User click on Assessment Partner Integration Assessment")
	public void User_click_on_Assessment_Partner_Integration() {
	 API.clickOnAssessmentPartnerIntegrationInSettings();
	}
	
	@And ("Verify User lands on Partner listing page")
	public void Verify_User_lands_on_Partner_listing_page() {
		Assert.assertTrue(API.verifyAssessmentPartnerIntegrationPageHeader(), "Partner Listings page header not found");
		
	}
	
	@And ("User verify all three partners are listed in the listing")
	public void User_verify_all_three_partners_are_listed_in_the_listing() {
		if(API.getNumberOfPartnersAdded()>=1)
		{
		Assert.assertTrue(API.isPartnerPresent("Naukri Assessments"),"Partner with name Naukri Assessments not present");
		Assert.assertTrue(API.isPartnerPresent("HackerEarth"),"Partner with name Naukri Assessments not present");
		Assert.assertTrue(API.isPartnerPresent("Codility"),"Partner with name Naukri Assessments not present");
		Assert.assertTrue(API.getNumberOfPartnersAdded() == 3,"Total number of partners are not three");
		}
		else
			Assert.fail("No Partner Found");
		
	}
	
	@And ("User Verify ER is shown as configured if FN subscription present")
	public void User_Verify_ER_is_shown_as_configured_if_FN_subscription_present() {
		
	}
	
	
	@Then ("User verify partner's list is in alphabetical order or not")
	public void User_verify_partner_list_sorted_or_not() {
		Assert.assertTrue(API.isPartnerListSorted(), "Partner List is not sorted");
	}
	
	@Then ("User click on Manage Partner Assessment")
	public void User_click_on_Manage_Partner_Assessment() {
	 API.clickOnManageIntegration();
	}
	

	@Then("User verifies that Request Demo page is displayed")
	public void user_verifies_that_page_is_displayed() {	
		Assert.assertTrue(RD.verifyHeaderLabelPresenceAtRequestDemoPage(), "Label Not found for Request demo page") ;
	}
	
	 @Then ("move to Request demo page for any partner")
	 public void move_to_Request_demo_page_for_any_partner(){
		API.clickOnRequestADemoForAnyPartner();
		API.switchToChildWindow();
	 }

	@Then("user submit the Request Demo Form")
	public void user_submit_theRequestDemoForm() {
		
	 RD.requestDemoHE(PropFileHandler.readProperty("FullName"), PropFileHandler.readProperty("WorkEmailAddress"), PropFileHandler.readProperty("Designation"), PropFileHandler.readProperty("CompanyName"), PropFileHandler.readProperty("PhoneNumber"));
	    //Assertion to be added 
	}

	@Then("User verify the information is visible on support@hackerearth.com")
	public void user_verify_the_information_is_visible_on_support_hackerearth_com() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User verify same information is displayed on our support email id rmshelpdesk@naukri.com , kaur.amanpreet@naukri.com")
	public void user_verify_same_information_is_displayed_on_our_support_email_id_rmshelpdesk_naukri_com_kaur_amanpreet_naukri_com() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("User Verify {string} field is displayed")
	public void user_Verify_field_is_displayed(String fieldName) {
	    
	    Assert.assertTrue(RD.verifyElementsOnRequestDemoPage(fieldName),  fieldName+ "not present on Request demo page") ;
	}

	@Then("User Verify {string} button is displayed")
	public void user_Verify_button_is_displayed(String buttonName) {
		
		Assert.assertTrue(RD.verifyRequestNowButtonPresence(buttonName),  buttonName+"Button not present on Request demo page") ;
	}

	@Then("User verify Phone Number is accepting valid data")
	public void user_verify_Phone_Number_is_accepting_valid_data(DataTable dt) {
	
			List<String> list = dt.asList(String.class);
		Assert.assertTrue(RD.validatePhoneNumberFormat(list.get(0)),  "Phone Number is not accepting valid data") ;
	}

	@Then("User Verify Phone Number with invalid digits gives proper Error message")
	public void user_Verify_with_invalid_digits_gives_proper_Error_message(DataTable dt) {
		
		RD.pageRefresh();	
			List<String> list = dt.asList(String.class);
		Assert.assertTrue(RD.validateInvalidPhoneNumberErrorMsg(list.get(0)),  "Phone Number with invalid digits do not give proper Error message") ;
	}

	@Then("User verify Work Email Address field with valid email")
	public void user_verify_Work_Email_Address_field_with_valid_email(DataTable dt) {
		RD.pageRefresh();
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(RD.validateEmailFormat(list.get(0)),  "Work Email Address field with valid email is not accepted") ;
	}

	@Then("User verify Work Email Address field with invalid email gives proper error")
	public void user_verify_Work_Email_Address_field_with_invalid_email_gives_proper_error(DataTable dt) {
		RD.pageRefresh();
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(RD.validateInvalidEmailErrorMsg(list.get(0)),  "Work Email Address field with invalid email does not give proper error") ;
	}

	@Then("User verify error message is displayed for mandatory fields if submitted empty")
	public void user_verify_error_message_is_displayed_for_mandatory_fields_if_submitted_empty() {
		Assert.assertTrue(RD.verifyErrorMsgForRequiredFields(),  "One or more Mandatory field/Fields does not give proper error") ;
	}

	@Then("User verify success message is displayed.")
	public void user_verify_success_message_is_displayed() {
	    
		Assert.assertTrue(RD.verifyElementsOnRequestDemoSuccessPage(),  "Demo Request Success message not found") ;
	}

	@Then("user verify mandatory fields labels are followed by Asterik")
	public void user_verify_mandatory_fields_labels_are_followed_by_Asterik() {
	    RD.verifyRequiredFieldsMarkedWithAsterik();
	}
	
	@Then("User delete the entry from client_account table if HE already configured")
	public void user_delete_the_entry_from_client_account_table_if_HE_already_configured(DataTable dt) {
			
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		Boolean bool = API.deletePartnerFromClientAccountTableifConfigured(API.createBsonDocumentFromKeyValues(list));
		Assert.assertTrue(bool,"HackerEarth is not unconfigured");  
	}

	@Then("User click on each Configure {string}")
	public void user_click_on_each_Configure_partner(String partnerName) {
	    API.clickOnConfigurePartnerButton("Configure " + partnerName);
	}

	@Then("User fill and submit configure light box for HackerEarth with correct credentials")
	public void user_fill_and_submit_configure_light_box_for_HackerEarth_with_correct_credentials(DataTable dt) {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
	    API.configureHE(list.get(0).get("client_id"), list.get(0).get("client_secret"));
	}

	@Then("User validate {string} is shown configured")
	public void user_validate_HackerEarth_is_shown_configured(String partnerName) {
	    Assert.assertTrue(API.ValidatePartnerConfigured(partnerName));
	}
	
	@And("User configure {string} if not configured")
	public void user_configure_HackerEarth_if_not_configured(String partnerName,DataTable dt) {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
	    if(!API.ValidatePartnerConfigured(partnerName)){
			API.clickOnConfigurePartnerButton("Configure "+partnerName);
	    	API.ConfigurePartner(partnerName, dt);}
	    else
	    	TestNGLogUtility.info(partnerName+" already configured");
	}

	@Then("User validate entry is made in client_account table in database")
	public void user_validate_entry_is_made_in_client_account_table_in_database(DataTable dt) {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		long count = API.ValidateDocumentInClientAccountTable(API.createBsonDocumentFromKeyValues(list));
		Assert.assertTrue(count > 0,"Entry not found in clientAccount table");
		Assert.assertTrue(count < 2,"Duplicate Entry for HackerEarth found in clientAccount table");
	}


	@Then("User verify number of fields in configuration light box for {string}")
	public void user_verify_number_of_fields_in_configuration_light_box(String partnerName) {
	    Assert.assertTrue(API.numberOfFieldsInconfigurationLightbox(partnerName), "Number of fields incorrect for the partner");
	}

	@Then("User verify both the labels in configuration light box")
	public void user_verify_both_the_labels_in_configuration_light_box() {
	    Boolean bool = API.verifyElementsOnConfigureHEWindow("HE_ClientID_label") && API.verifyElementsOnConfigureHEWindow("HE_ClientSecretLabel");
	    Assert.assertTrue(bool,"Incorrect labels in configuration light box for HE");
	}

	@Then("User validate the success message for HackerEarth configuration")
	public void user_validate_the_success_message_for_HackerEarth_configuration() {
		Assert.assertTrue(API.VerifySuccessMessageHE(),"Incorrect Success message");
	}

	@Then("User fill and submit configure light box for {string} with incorrect credentials")
	public void user_fill_and_submit_configure_light_box_for_partner_with_incorrect_credentials(String partnerName, DataTable dt) {
		List<String> list = dt.asList(String.class);
		API.ConfigurePartner(partnerName, dt);
	}

	@Then("User validate the error message for {string} configuration failure")
	public void user_validate_the_error_message_for_partner_configuration_failure(String partnerName) {
	    Assert.assertTrue(API.VerifyErrorMessageHE(AssessmentFeaturesSrpCvDetailsPageStepDef.data.get("ErrorMsgWrongConfigCredential"+partnerName).toString()),"Incorrect Error message");
	}

	@Then("User verify Naukri Assessments is displayed")
	public void user_verify_Naukri_Assessments_is_displayed() {
		Assert.assertTrue(API.isPartnerPresent("Naukri Assessments"), "Naukri Assessments not present");

	}

	@Then("User verify configure button not present for Naukri Assessments")
	public void user_verify_configure_button_not_present_for_Naukri_Assessments() {
	    Assert.assertTrue(API.VerifyConfigureButtonForNaukriAssessments() == false, "Configure button present for ER");
	}
	
	@Then("User move to Marketing tour page for {string} from Assessment partner Integration")
	public void user_move_to_Marketing_tour_page(String partner) {
		API.clickOnLearnMoreLink(partner);

	}
	
	@Then("User move to Marketing tour page for HackerEarth from Attach Assessment")
	public void User_move_to_Marketing_tour_page_for_HackerEarth_from_Attach_Assessment() {
		attach.clickOnKnowMoreInHoverMessage();
	}
	
	@Then("User verify heading on Marketing tour page")
	public void user_verify_heading_on_Marketing_tour_page(DataTable dt) {
		List<String> list = dt.asList(String.class);
			Assert.assertTrue(RD.verifyHeadingOnTourPage(list.get(0)),"Test case failed : As user is not able to see the heading " + list.get(0) + "");
	}

	@Then("User verify sub headings on Marketing tour page")
	public void user_verify_sub_headings_on_Marketing_tour_page(DataTable dt) {
		List<String> list = dt.asList(String.class);
		for (int i = 0; i < list.size(); i++) {
			Assert.assertTrue(RD.verifylabelsAndElementsOnStaticPages(list.get(i)),"Test case failed : As user is not able to see the heading " + list.get(i) + "");
		}			
	}

	@Then("User verify {string} button is displayed")
	public void user_verify_button_is_displayed(String label) {
		RD.verifyStaticPagesButton(label);
	}
	
	@Then("User click on {string} button on marketing page")
	public void User_click_on_button_on_marketing_page(String button){
		RD.clickOnStaticPagesButtons(button);
	}
	
	@And("User verify the success message is displayed for send interest")
	public void User_verify_the_success_message_is_displayed_for_send_interest(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(RD.verifySuccessMessageInCaseOfSendInterest(list.get(0)), "Success meesage Incorrect");
	}
	
	@Then("User select a particular or first test for partner")
	public void user_select_a_particular_or_first_test_for_partner(DataTable dt) {
		List<String> list = dt.asList(String.class);
		String testToSelect = "";
		if(list.get(0).equals(""))		
			testToSelect = AssessmentFeaturesSrpCvDetailsPageStepDef.newTestName;
		else 
			testToSelect = list.get(0);
		attach.selectHETest(testToSelect);

	}

	@Then("User click on Next button")
	public void user_click_on_Next_button() {
		attach.clickNextButton();
	}

	@Then("User verify below headings on the page for {string}")
	public void user_verify_below_headings_on_the_page_for(String partner, DataTable dt) {
		List<String> list = dt.asList(String.class);
		for(int i=0; i<list.size();i++)
		{
		Assert.assertTrue(attach.verifyLabelsInConfigureTestSettingsTab(list.get(i), partner),"Error: Heading not found: "+list.get(i));;
		}
	}
	
	@Then("User verify below headings not on the page for {string}")
	public void user_verify_below_headings_not_on_the_page_for(String partner, DataTable dt) {
		List<String> list = dt.asList(String.class);
		for(int i=0; i<list.size();i++)
		{
			System.out.println(list.get(i)+"|");
		Assert.assertFalse(attach.verifyLabelsInConfigureTestSettingsTab(list.get(i), partner),"Error: Heading found: "+list.get(i));;
	}}

	@Then("User click on select stage Dropdown")
	public void user_click_on_select_stage_Dropdown() {
		attach.clickSelectedStageDD();
	}
	
	@Then("User verify no stage selected by default")
	public void User_verify_no_stage_selected_by_default() {
		Assert.assertEquals(attach.getPlaceHolderFromDropDown(), "Select stage");
	}

	@Then("User select {string} stage from the Dropdown")
	public void user_select_stage_from_the_Dropdown(String stage) {
		attach.selectStage(stage);
	}

	@Then("User click on Attach test button")
	public void user_click_on_Attach_test_button() {
	    attach.clickOnAttachTestButton();
	}

	@Then("User verify the success message for test {string}")
	public void user_verify_the_success_message_for_test(String testName) {
		attach.verifySuccessMessageForAttach(testName);
	}

	@Then("User select a particular or first test in expanded category in Naukri Assessments")
	public void user_select_a_particular_or_first_test_in_expended_category_in_Naukri_Assessments(DataTable dt) {
		List<String> list = dt.asList(String.class);
		attach.selectTestInACategory("", list.get(0));
	}
	
	@Then("User verifies attached test is not allowed to be selected again")
	public void user_verifies_attached_test_is_not_allowed_to_be_selected_again(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(attach.verifyTestDisabledOrNot(list.get(0)), "Attached test available");
	}

	@Then("User verifies {string} stage with a test attached cannot be selected")
	public void user_verifies_stage_with_a_test_attached_cannot_be_selected(String stage) {
		Assert.assertTrue(attach.verifyStageDisabledOrNot(stage), "Stage with test attached clickable");
	}
	@And("User verifies the hover message for the {string} stage on which test is already attached")
	public void User_verifies_the_hover_message_for_the_stage_on_which_test_is_already_attached(String stage) {
	Assert.assertTrue(attach.verifyHoverMsgOnUsedStage(stage,AssessmentFeaturesSrpCvDetailsPageStepDef.data.get("UsedStageHoverMessage").toString()), "Hover message incorrect");
	}
	
	@And("User verifies the hover message for the {string} test which is already attached")
	public void User_verifies_the_hover_message_for_the_test_test_which_is_already_attached(String testName) {
	Assert.assertTrue(attach.verifyHoverMsgOnAttachedTest(testName, AssessmentFeaturesSrpCvDetailsPageStepDef.data.get("AlreadySentorAttachedMsg").toString()), "Hover message incorrect");
	}
	
	@Then("User verify Candidate Assessments tab is not visible")

	public void User_verify_Candidate_Assessments_tab_is_not_visible() {
		Assert.assertFalse(attach.verifyCandidateAssessmentsTabRemoved(), "Candidate Assessments tab is still present");
	}

	@And("User verify that {string} is present and unconfigured")
	public void userVerifyThatCodilityIsPresentAndUnconfigured(String partnerName) {
		Assert.assertFalse(API.ValidatePartnerConfigured(partnerName), "Partner" +partnerName+"is already configured");
	}

	@And("User fill and submit configure light box for {string} with correct credentials")
	public void userFillAndSubmitConfigureLightBoxForCodilityWithCorrectCredentials(String partnerName, DataTable dt) {
		API.ConfigurePartner(partnerName, dt);
	}

	@And("User verify the {string} for {string}")
	public void userVerifyTheFor(String textType, String partnerName) {
		Assert.assertTrue(API.verifyTextContentForPartners(textType,partnerName, AssessmentFeaturesSrpCvDetailsPageStepDef.data), "Text or description not correct for partner");
	}

	@And("User verify the links for {string} in the description")
	public void userVerifyThtRequestDemoButtonIsPresentFor(String partnerName) {
		Assert.assertTrue(API.verifyLinksForPartnerInDescription(partnerName), "Links not as expected for partner");
	}
}
