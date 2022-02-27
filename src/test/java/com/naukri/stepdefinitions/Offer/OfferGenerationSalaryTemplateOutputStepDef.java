package com.naukri.stepdefinitions.Offer;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryTemplateOutputPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class OfferGenerationSalaryTemplateOutputStepDef {
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	OfferGenerationSalaryTemplateOutputPO offerGenerationSalaryTemplateOutputPO = (OfferGenerationSalaryTemplateOutputPO) PageObjectWrapper
			.getObject(OfferGenerationSalaryTemplateOutputPO.class);

	@Then("Verify system identified fields on the output screen")
	public void verify_system_identified_fields_on_the_screen() {
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifySystemIdentifiedFields(),
				"All Fields are not identified by the system on the output page.");
	}

	@Then("Click on Menu option for {string}")
	public void Click_on_Menu_option_for(String string) {
		offerGenerationSalaryTemplateOutputPO.clickMenuOption(string);
	}

	@Then("Click {string} on output screen")
	public void Click_link_on_output_screen(String linkText) {
		offerGenerationSalaryTemplateOutputPO.clickLinkOnOutputScreen(linkText);
	}

	@Then("Verify {string} not displayed on output screen")
	public void Verify_no_more_columns_can_be_added(String linkText) {
		offerGenerationSalaryTemplateOutputPO.verifyIfLinkIsNotAvailable(linkText);
	}

	@Then("delete all rows from output screen")
	public void delete_all_rows_from_output_screen() {
		offerGenerationSalaryTemplateOutputPO.deleteAllRowsFromOutputScreen();
	}

	@Then("verify the options in the menu option for inside cell")
	public void verify_the_options_in_the_menu_option(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyOptionsInMenuOptionForInsideCell(list),
				"Menu Option does not contain all options");
	}

	@Then("click {string} in Menu option")
	public void click_style_in_Menu_option(String style) {
		offerGenerationSalaryTemplateOutputPO.clickStyleInMenuOption(style);
	}

	@Then("verify {string} has been applied to the cell")
	public void verify_style_has_been_applied_to_the_cell(String style) {
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyStyleAppliedToCell(style),
				style + " has not been applied to the cell");
	}

	@Then("Verify row added on output screen")
	public void Verify_row_added_on_output_screen() {
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyRowAddedToOutput(), "Row has not been added.");
	}

	@Then("verify available tags in Insert Tag Menu option")
	public void verify_available_tags_in_Insert_Tag_Menu_option(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyAvailableTagsInInsertTagMenuOption(list),
				"Insert Tag Menu Option does not contain all tags.");
	}

	@Then("verify {string} tag inserted in the first inside cell")
	public void verify_tag_inserted_in_the_first_inside_cell(String tagValue) {
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyTagInserterdInFirstInsideCell(tagValue),
				"Tag is not inserted in the cell.");
	}
	
	@Then("Click {string} in Menu Option on output screen")
	public void Click_link_in_Menu_Option_on_output_screen(String linkText) {
		offerGenerationSalaryTemplateOutputPO.clickLinkInMenuOptionOnOutputScreen(linkText);
	}
	
	@Then("{string} layer opens on output screen")
	public void layer_opens_on_output_screen(String linkText) {
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyLayerOpensOnOutputScreen(linkText), linkText + " layer is not opened.");
	}
	
	@Then("add Footnote Symbol {string} on the layer")
	public void add_Footnote_Symbol_on_the_layer(String symbol) {
		offerGenerationSalaryTemplateOutputPO.addFootnoteSymbolOnTheLayer(symbol);
	}
	
	@Then("add Footnote Text on the layer")
	public void add_Footnote_Text_on_the_layer(DataTable dt) {
		List<String> list = dt.asList(String.class);
		offerGenerationSalaryTemplateOutputPO.addFootnoteTextOnTheLayer(list);
	}
	
	@Then("click {string} button")
	public void click_button(String buttonText) {
		offerGenerationSalaryTemplateOutputPO.clickButton(buttonText);
	}
	
	@Then("verify footnote has been added")
	public void verify_footnote_has_been_added(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyFootnoteHasBeenAdded(list),
				"Footnote ave not been added.");
	}
	
	@Then("verify footnote has been removed")
	public void verify_footnote_has_been_removed() {
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyFootnoteRemoved(), "Footnote has not been deleted.");
	}
	
	@Then("verify contents of the first cell are cleared")
	public void verify_contents_of_the_first_cell_are_cleared() {
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyContentsAreCleared(), "Contents of the cell have not been cleared.");
	}
	
	@Then("verify {string} error message is displayed for CTC field")
	public void verify_error_message_is_displayed_for_CTC_field(String errorMsg) {
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyErrorMessageForCTCField(errorMsg), "Error message for CTC field is not displyed.");
	}
	
	@Then("select {string} in CTC dropdown")
	public void select_string_in_CTC_dropdown(String DDString) {
		offerGenerationSalaryTemplateOutputPO.selectStringInCTCDropdown(DDString);
	}

	@Then("verify Review & Approve is displayed")
	public void verify_Review_n_Approve_is_displayed() {
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyReviewAndApprovePageOpened(), "Not navigated to Review and Approve page.");
	}
	
	@Then("select {string} as Input source")
	public void select_string_as_Input_source(String string) {
		offerGenerationSalaryTemplateOutputPO.selectStringAsInputSource(string);
	}
	
	@Then("select {string} and {string} as input")
	public void select_sheetname_and_cell_reference_as_input(String sheetName, String cellReference) {
		offerGenerationSalaryTemplateOutputPO.selectSheetnameAndCellReferenceAsInput(sheetName, cellReference);
	}
	
	@Then("click {string} on input screen")
	public void clickLinkOnInputScreen(String linkText) {
		offerGenerationSalaryTemplateOutputPO.clickLinkOnInputScreen(linkText);
	}
	
	@Then("verify warning message {string}")
	public void verifyWarningMessage(String warningMsgText) {
		Assert.assertTrue(offerGenerationSalaryTemplateOutputPO.verifyWarningMessage(warningMsgText), "Warning message is not being displayed.");
	}
	
	@Then("scroll down to cancel button for Input source")
	public void scroll_down_to_cancel_button_for_Input_scource() {
		offerGenerationSalaryTemplateOutputPO.scrollDownToCancelBtnForInputSource();
	}
	
}