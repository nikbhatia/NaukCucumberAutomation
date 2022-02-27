package com.naukri.stepdefinitions.Offer;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryListingPO;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryTemplateOutputPO;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryTemplateReviewNApprovePO;
import com.naukri.pageobjects.Offer.OfferValidationPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class OfferGenerationSalaryTemplateReviewNApproveStepDef {
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	OfferGenerationSalaryTemplateReviewNApprovePO offerGenerationSalaryTemplateReviewnApprovePO = (OfferGenerationSalaryTemplateReviewNApprovePO) PageObjectWrapper
			.getObject(OfferGenerationSalaryTemplateReviewNApprovePO.class);
	OfferValidationPagePO offerValidationPO = (OfferValidationPagePO) PageObjectWrapper
			.getObject(OfferValidationPagePO.class);
	OfferGenerationSalaryTemplateOutputPO offerGenerationSalaryTemplateOutputPO = (OfferGenerationSalaryTemplateOutputPO) PageObjectWrapper
			.getObject(OfferGenerationSalaryTemplateOutputPO.class);
	OfferGenerationSalaryListingPO offerGenerationSalaryPO = (OfferGenerationSalaryListingPO) PageObjectWrapper
			.getObject(OfferGenerationSalaryListingPO.class);

	@Then("verify all input fields are displayed on Review page")
	public void verify_all_input_fields_are_displayed_on_Review_page(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(offerGenerationSalaryTemplateReviewnApprovePO.verifyAllInputsInReviewPage(list),
				"Review page does not contains all Inputs.");
	}	

	@Then("click {string} on Review page")
	public void click_link_on_review_page(String linkText) {
		offerGenerationSalaryTemplateReviewnApprovePO.clickLinkOnReviewPage(linkText);
	}

	@Then("verify error message for each input fields")
	public void verify_error_message_for_each_input_fields(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(offerGenerationSalaryTemplateReviewnApprovePO.verifyAllInputErrorsOnReviewPage(list),
				"Error for inputs on Review page are not correct.");
	}
	
	@Then("enter {string} value in {string} field")
	public void enter_value_in_field(String inputType, String field) {
		offerGenerationSalaryTemplateReviewnApprovePO.enterValueInFieldOnReviewPage(inputType,field);
	}
	
	@Then("select a date {string} days for current date in {string} datepicker")
	public void select_a_date_n_days_for_current_date_in_datepicker(String numberOfDays, String fieldName) {
		offerValidationPO.selectDateInCalendar(fieldName, Integer.parseInt(numberOfDays));
	}
	
	@Then("verify error message for {string} field")
	public void verify_error_message_for_field(String fieldName, DataTable dt) {
		List<String> list = dt.asList(String.class);
		offerGenerationSalaryTemplateReviewnApprovePO.verifyErrorMessageForField(fieldName, list);
	}
	
	@Then("verify all the input and output fields in the breakup table")
	public void verify_all_the_input_and_output_fields_in_the_breakup_table() {
		Assert.assertTrue(offerGenerationSalaryTemplateReviewnApprovePO.verifyAllInputAndOutputFields(), "Inputs and Outputs in Breakup table are invalid.");
	}
	
	@Then("verify footnotes have been added to Review page")
	public void verify_footnotes_have_been_added_to_Review_page(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(offerGenerationSalaryTemplateReviewnApprovePO.verifyFootnoteAddedToBreakupTable(list));
	}
	
	@Then("click {string} button on Review page")
	public void click_button_on_Review_page(String buttonText) {
		offerGenerationSalaryTemplateOutputPO.clickButton(buttonText);
	}
	
	@Then("template should not be in drafted state")
	public void template_should_not_be_in_drafted_state() {
		Assert.assertTrue(offerGenerationSalaryTemplateReviewnApprovePO.verifyDraftLabelNotDisplayed(),"Template is in draft stage");
	}
}