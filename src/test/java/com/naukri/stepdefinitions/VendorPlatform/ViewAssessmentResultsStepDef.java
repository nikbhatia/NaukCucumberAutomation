package com.naukri.stepdefinitions.VendorPlatform;

import java.util.List;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;
import com.naukri.pageobjects.VendorPlatform.*;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
public class ViewAssessmentResultsStepDef {
	

	AssessmentPartnerIntegrationPO API = (AssessmentPartnerIntegrationPO) PageObjectWrapper
			.getObject(AssessmentPartnerIntegrationPO.class);
	AttachAssessmentForPartnerPO attach = (AttachAssessmentForPartnerPO) PageObjectWrapper
			.getObject(AttachAssessmentForPartnerPO.class);
	ViewAssessmentResultsPO viewAssessmentResultsPO = (ViewAssessmentResultsPO) PageObjectWrapper
			.getObject(ViewAssessmentResultsPO.class);
	
	SoftAssert sa=new SoftAssert();

	@Then("User verify heading and sub heading on View Assessments page")
	public void user_verify_heading_and_sub_heading_on_View_Assessments_page(DataTable dt) {
			List<String> list = dt.asList(String.class);
			sa.assertTrue(viewAssessmentResultsPO.verifyViewAssessmentsPageHeading(list.get(0)),"Wrong Heading for View Assessments");
			sa.assertTrue(viewAssessmentResultsPO.verifyViewAssessmentsPageSubHeading(AssessmentFeaturesSrpCvDetailsPageStepDef.data.get("ViewAssessmentSubHeading") + " "+ AssessmentFeaturesSrpCvDetailsPageStepDef.reqName),"Wrong Sub Heading for View Assessments");
			sa.assertAll();
		}
	

	@Then("User verify various test details on View Assesments page")
	public void user_verify_various_test_details_on_View_Assesments_page(DataTable dt) {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		sa.assertTrue(viewAssessmentResultsPO.verifyTestDetailsOnViewAssesmentsPage("PartnerName", list.get(0).get("PartnerName")), "Wrong PartnerName");
		sa.assertTrue(viewAssessmentResultsPO.verifyTestDetailsOnViewAssesmentsPage("Stage", list.get(0).get("Stage")),"Wrong stage name");
		sa.assertTrue(viewAssessmentResultsPO.verifyTestDetailsOnViewAssesmentsPage("TestName", list.get(0).get("TestName")),"Wrong test name");
		sa.assertAll();
	}

	@Then("User verify Edit Test Settings and back button are present")
	public void user_verify_Edit_Test_Settings_backbtn_present() {
		sa.assertTrue(viewAssessmentResultsPO.verifyEditTestSettingsPresent(),"Edit Test Settings not present");
		sa.assertTrue(viewAssessmentResultsPO.verifyBackButtonPresent(),"Back Button not present");
		sa.assertAll();
	}

	@Then("User verify Export to excel is not present")
	public void user_verify_Export_to_excel_is_not_present() {
		Assert.assertFalse(viewAssessmentResultsPO.verifyExportToExcelPresent(), "Export to excel present");
	}

	@Then("User verify text and sub text on the screen with no candidates")
	public void user_verify_text_and_sub_text_on_the_screen_with_no_candidates() {
		sa.assertTrue(viewAssessmentResultsPO.verifyViewAssessmentsPageText(AssessmentFeaturesSrpCvDetailsPageStepDef.data.get("ViewAssessmentNoCandidateText").toString()),"Wrong text for View Assessments");
		sa.assertTrue(viewAssessmentResultsPO.verifyViewAssessmentsPageSubText(AssessmentFeaturesSrpCvDetailsPageStepDef.data.get("ViewAssessmentNoCandidateSubText").toString()),"Wrong Sub text for View Assessments");
		sa.assertAll();
	}

	@Then("User hover on View more options Drop down")
	public void user_hover_on_View_more_options_Drop_down() {
		viewAssessmentResultsPO.hoverOnViewMoreOptions();
	}

	@Then("User verify more options for the partner {string}")
	public void user_verify_more_options_for_the_partner(String partnerName, DataTable dt) {
		List<String> list = dt.asList(String.class);
		for(String DDitem : list)
		Assert.assertTrue(viewAssessmentResultsPO.verifyMoreOptionsDDlistItemsForPartner(partnerName, DDitem));
	}
}
