package com.naukri.stepdefinitions.Applications;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.CVDetailsPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import kafka.security.auth.All;

public class CvDeatilStepDef {

	CVDetailsPagePO cvDetailsPagePO = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
	int beforeaddedRowCount;
	String summaryData = "", addedLanguage = "";
	List<String> candidateDetails = new ArrayList<String>();
	List<String> candidateFeildDetails = new ArrayList<String>();
	List<String> workExpTuple = new ArrayList<String>();
	List<String> eduDetails = new ArrayList<String>();

	@When("User on cv detail page")
	public void user_er_on_cv_detail_page() {
		cvDetailsPagePO.verifyRedirectedOnCVDetailsPage();

	}

	@Then("User should be able to see following sections on CV detail page")
	public void user_should_be_able_to_see_followingsections_on_CV_detail_page(DataTable dataTable) {
		List<String> AllSections = dataTable.asList(String.class);
		for(String section:AllSections) {
		Assert.assertTrue(cvDetailsPagePO.verifySectionOnCvDetailPage(section),
				section + " is not displaed as expected");
		TestNGLogUtility.pass(section + " is displayed as expected");
		}

	}

	@Then("User should be able to see link on CV detail page")
	public void user_should_be_able_to_see_link_on_CV_detail_page(DataTable dataTable) {
		List<String> AllBreadcrumbs = dataTable.asList(String.class);
		for(String breadcrumbs:AllBreadcrumbs) {
	 	Assert.assertTrue(cvDetailsPagePO.verifyAllBreadcrumbsLinkOnCvDetailPage(breadcrumbs),
				breadcrumbs + " is not displaed as expected");
		TestNGLogUtility.pass(breadcrumbs + " is displayed as expected");
		}
	}

	@When("User click on {string} link against {string} on CV detail page")
	public void user_click_on_link_against_CV_detail_page(String section, String link) {
		cvDetailsPagePO.clickOnEditOrAddLinkInSection(link, section);

	}

	@When("User fill detail in respected field on CV detail page")
	public void user_fill_detail_in_respected_field_on_CV_detail_page(DataTable dataTable) {
		List<String> candidateDetail = dataTable.asList(String.class);
		for(int i=0;i<candidateDetail.size();i=i+2) {
			cvDetailsPagePO.setCandidateDetails(candidateDetail.get(i), candidateDetail.get(i+1));
			candidateFeildDetails.add(candidateDetail.get(i));
			candidateDetails.add(candidateDetail.get(i+1));
		}
		
	}

	@When("User reload the page.")
	public void user_reload_the_page() {
		cvDetailsPagePO.pageRefresh();

	}

	@Then("User should be able to see all the entered value are edited in candidate details section")
	public void user_should_be_able_to_see_all_the_entered_value_are_edited_in_candidate_details_section() {
		for (int i = 0; i < candidateDetails.size(); i++) {
			Assert.assertTrue(
					cvDetailsPagePO.verifyCandidateDetails(candidateFeildDetails.get(i), candidateDetails.get(i)),
					candidateFeildDetails.get(i) + " is not displayed as expected");
			TestNGLogUtility.pass(candidateFeildDetails.get(i) + " is displayed as expected");
		}
	}

	@When("enter data in summary as {string}")
	public void enter_data_in_summary_as(String summaryValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calender = Calendar.getInstance();
		summaryData = summaryValue + sdf.format(calender.getTime());
		cvDetailsPagePO.setSummary(summaryData);
	}

	@Then("User should be able to see saved summary data.")
	public void user_should_be_able_to_see_saved_summary_data() {
		Assert.assertTrue(cvDetailsPagePO.verifySummaryText(summaryData), "Summary value is not displayed as expected");
		TestNGLogUtility.pass("Summary value is displayed as expected");
	}

	@When("User select radio button of {string}")
	public void user_select_radio_button_of(String value) {
		cvDetailsPagePO.setValueWithLabelText(value);
		workExpTuple.add(value);

	}

	@When("User fill detail in Designation field as {string} on CV detail page")
	public void user_fill_detail_in_Designation_field_as_on_CV_detail_page(String designation) {
		cvDetailsPagePO.setWorkDesignation(designation);
		workExpTuple.add(designation);
	}

	@When("User fill detail in job Profile field as {string} on CV detail page")
	public void user_fill_detail_in_job_Profile_field_as_on_CV_detail_page(String jobProfile) {
		cvDetailsPagePO.setworkJobProfile(jobProfile);
		workExpTuple.add(jobProfile);
	}

	@When("User select {string} as {string} {string} on CV detail page")
	public void user_select_as_on_CV_detail_page(String string, String month, String year) {
		cvDetailsPagePO.setDuration(month, year);
		workExpTuple.add(month + " " + year);

	}

	@When("User select {string} from dropdown as {string} on CV detail page")
	public void user_select_from_dropdown_as_on_CV_detail_page(String string, String period) {
		cvDetailsPagePO.setNoticePeriod(period);
		workExpTuple.add(period);
	}

	@Then("User should be able to see all the entered details in work experience fields")
	public void user_should_be_able_to_see_all_the_entered_details_in_work_experience_fields() {
		for (String workExpValues : workExpTuple) {
			Assert.assertTrue(cvDetailsPagePO.verifyWorkExpTuple(workExpValues),
					workExpValues + " is not displayed as expected.");
			TestNGLogUtility.pass("work experience values are displayed as expected");

		}
	}

	@When("User choose Degree from dropdown on CV detail page")
	public void user_choose_from_dropdown_as(DataTable dataTable) {
		List<String> education = dataTable.asList(String.class);
		for(int i=0;i<education.size();i=i+2) {
		cvDetailsPagePO.setEducationDegreeValue(education.get(i), education.get(i+1));
		eduDetails.add(education.get(i+1));
		}
	}

	@When("User select the education type as {string} on CV detail page")
	public void user_select_the_education_type_as(String value) {
		cvDetailsPagePO.setValueWithLabelText(value);
	}

	@Then("User should be able to see saved education on the cv details page for {string}")
	public void user_should_be_able_to_see_saved_education_on_the_cv_details_page_for(String detail) {
		for (String eduValue : eduDetails) {
			Assert.assertTrue(cvDetailsPagePO.verifyEducationDetails(eduValue), eduValue +" is not displayed as expected");
			TestNGLogUtility.pass(eduValue + " education values are displayed as expected");
		}
		eduDetails.clear();

	}

	@When("User fill detail in {string} as {string} on CV detail page")
	public void user_fill_detail_in_as(String string, String diplomaValue) {
		cvDetailsPagePO.setDiplomaCertifiocate(diplomaValue);
		eduDetails.add(diplomaValue);
	}

	@Then("User should be able to see added certificate in education")
	public void user_should_be_able_to_see_added_certificate_in_education() {
		Assert.assertTrue(cvDetailsPagePO.verifySuccessMessage(), "Success message is not being displaying.");
		for (String eduValue : eduDetails)
			Assert.assertTrue(cvDetailsPagePO.verifyEducationDetails(eduValue),
					"Diploma certificate value is not as expected.");
		TestNGLogUtility.pass("education certificate values are displayed as expected");
	}

	@When("Add language {string} and Proficiency as {string} , {string} and {string} on CV detail page")
	public void add_language_and_Proficiency_as_and(String languageValue, String p1, String p2, String p3) {
		cvDetailsPagePO.setLanguage(languageValue, p1, p2, p3);
		addedLanguage = languageValue;
	}

	@When("click on {string} link on CV detail page")
	public void click_on_link(String link) {
		beforeaddedRowCount = cvDetailsPagePO.clickOnAddLanguageLink(link);
	}

	@Then("User should be able to see another field for add language")
	public void user_should_be_able_to_see_another_field_for_add_language() {
		Assert.assertTrue(cvDetailsPagePO.verifyAddedLanguageRow(beforeaddedRowCount), "row is not added as expected");
		TestNGLogUtility.pass("Row has been added as expected");
	}

	@Then("User should be able to see added language on CV detail page")
	public void user_should_be_able_to_see_added_language() {
		Assert.assertTrue(cvDetailsPagePO.verifyAddedLanguage(addedLanguage), "language is not added as expected");
		TestNGLogUtility.pass("language has been added as expected");
	}

	@When("User choose {string}  date as {string} and month as {string} and year as {string} on CV detail page")
	public void user_choose_date_as_and_month_as_and_year_as(String string, String day, String month, String year) {
		cvDetailsPagePO.setDOB(day, month, year);
	}

	@When("User choose option in other details on CV detail page")
	public void user_choose_as(DataTable dt) {
		List<String> otherDetail = dt.asList(String.class);
		for(int i=0;i<otherDetail.size();i=i+2) {
		cvDetailsPagePO.setValueWithLabelText(otherDetail.get(i+1));
		}
	}

	@When("User entered value in other details on CV detail page")
	public void user_entered_as(DataTable dt) {
		List<String> otherDetail = dt.asList(String.class);
		for(int i=0;i<otherDetail.size();i=i+2) {
		cvDetailsPagePO.setOtherDetailsTextBoxes(otherDetail.get(i), otherDetail.get(i+1));
		}
	}

	@When("User select value in other details on CV detail page")
	public void user_select_as(DataTable dt) {
		List<String> otherDetail = dt.asList(String.class);
		for(int i=0;i<otherDetail.size();i=i+2) {
		cvDetailsPagePO.selectotherDetailsDD(otherDetail.get(i), otherDetail.get(i+1));
		}
	}

	@Then("User should be able to see added details in {string} section")
	public void user_should_be_able_to_see_added_details_in_section(String string) {
		Assert.assertTrue(cvDetailsPagePO.verifySuccessMessage(), "Success message is not being displaying.");
		TestNGLogUtility.pass("Other details has been added as expected");
	}

	@When("User click on {string} button on candidate profile page")
	public void user_click_on_button_on_candidate_profile_page(String string) {
		cvDetailsPagePO.clickOnSaveBtn();
	}

	@When("User fill detail in Employer Name field as {string}")
	public void user_fill_detail_in_Employer_Name_field_as(String value) {
		cvDetailsPagePO.setEmoloyer(value);
	}
	
	@When("User click on {string} button.")
	public void user_click_on_button(String btnText) {
	  cvDetailsPagePO.clickOnFirstSaveBtn();
	}
	
}
