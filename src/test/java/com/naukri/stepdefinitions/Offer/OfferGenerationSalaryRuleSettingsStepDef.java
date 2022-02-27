package com.naukri.stepdefinitions.Offer;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryRuleSettingsPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class OfferGenerationSalaryRuleSettingsStepDef {
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	OfferGenerationSalaryRuleSettingsPO offerGenerationSalaryRulePO = (OfferGenerationSalaryRuleSettingsPO) PageObjectWrapper
			.getObject(OfferGenerationSalaryRuleSettingsPO.class);

	@When("click on Upload Salary Spreadsheet {string}")
	public void clickUploadSalarySpreadsheet(String excelSheet) {
		offerGenerationSalaryRulePO.UploadExcelFromBreakups(excelSheet);
	}

	// @When("click on Upload Salary Spreadsheet OfferReddy.xlsx")
	// public void uploadSalaryTemplateExcel()
	// {
	// //offerGenerationSalaryPO.waitForUploadOfferLetterButton();
	// offerGenerationSalaryPO.UploadExcelFromBreakups();
	// }
	@When("Fill the Salary Template rule name")
	public void fillSalaryTemplateName() {
		offerGenerationSalaryRulePO.fillSalaryRuleTemplateName();
	}

	@When("click on next button on footer salary breakups page")
	public void clickOnNextSalaryBreakupsLightbox() {

		offerGenerationSalaryRulePO.clickOnNextButtonOnSalaryBreakup();

	}

	@When("click on cancel from salary breakups lightbox")
	public void clickOnCancelSalaryBreakupsLightbox() {
		offerGenerationSalaryRulePO.clickOnCancelButtonOnSalaryBreakup();
	}

	@When("choose sheet {string} and label {string}")
	public void selectSheetAndLabel(String SheetName, String ColoumnName) {
		offerGenerationSalaryRulePO.chooseLabelAndSheet(SheetName, ColoumnName);
	}

	@Then("verify all inputs are identified by RMS")
	public void verifyAllInputsIdentified() {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyInputTableForSampleInput(),
				"Inputs are not identified properly");
	}

	@When("verify Define Salary Breakup is displayed")
	public void outputScreenIsDisplayedOrnot() {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyOutputScreenIsDisplayed(),
				"output screen is not displayed");
	}

	@When("click on add new input")
	public void clickOnNewInput() {
		offerGenerationSalaryRulePO.addInputClick();
	}

	@When("fill label name {string}")
	public void fillLabelName(String LabelName) {
		offerGenerationSalaryRulePO.fillNewLabelName(LabelName);
	}

	@Then("validation error ie unique label should be displayed")
	public void DuplicateLabelsNotAllowed() {
		Assert.assertEquals(offerGenerationSalaryRulePO.verifyDuplicateLabelsNotAllowed(),
				"Please enter unique labels");
	}

	@When("click on change excel link and upload {string}")
	public void clickOnChangeExcelLinkAndUploadExcel(String excelName) {
		offerGenerationSalaryRulePO.clickChangeBtnExcelUpload(excelName);
	}

	@Then("verify {string} is displayed on excel upload screen")
	public void verifyExcelIsUploaded(String excelName) {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyExcelIsUploadedCorrectly(excelName),
				"Uploaded excel is not correct");
	}

	@Then("validate excel cant be uploaded greater than 5 MB")
	public void validateExcelUploadGreaterThan5MbError() {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyErrorFileSizeUpto5MbAllowed(),
				"error is not displayed when file size is greater than 5 MB");
	}

	@When("choose sheet {string} and click on labels DD")
	public void chooseSheet(String SheetName) {
		offerGenerationSalaryRulePO.selectSheetAndClickOnLabelsDD(SheetName);
	}

	@Then("validate {string} has {int} coloumns")
	public void validateSheetAndItsColoumnsCount(String sheetName, int coloumnCount) {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyColoumnsCount(sheetName, coloumnCount),
				"coloumn size displayed not correct");
	}

	@Then("verify error is displayed to upload a valid file")
	public void verifyErrorToUploadValidFile() {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyErrorToUploadValidFile(), "Valid file is also uploaded");
	}

	@Then("labels tab should be displayed")
	public void labelScreenDisplayed() {
		Assert.assertTrue(offerGenerationSalaryRulePO.labelsScreenDisplayed(), "label tab not displayed");
	}

	@When("click on Upload Excel Tab")
	public void clickOnUploadExcelTab() {
		offerGenerationSalaryRulePO.clickOnUploadExcelTab();
	}

	@Then("Change button should not be visible")
	public void changeBtnNotVisible() {
		Assert.assertFalse(offerGenerationSalaryRulePO.changeBTnVisibility(), "change btn is not visible");
	}

	@Then("input screen should be displayed")
	public void inputScreenDisplayed() {
		Assert.assertTrue(offerGenerationSalaryRulePO.inputScreenDisplayed(), "input screen is not displayed");
	}

	@Then("validate only sheet1 labels are identified and {int} labels of sheet2 not identified")
	public void verifyOnlySheet1LabelsIdentified(int countWithNoLabel) {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyLabelsIdentified(countWithNoLabel),
				"sheet2 labels are also identified");
	}

	@When("click on skip button")
	public void clickOnSkipLabelsScreen() {
		offerGenerationSalaryRulePO.clickOnSkipLabelsScreen();
	}

	@Then("verify no labels are identified add label is displayed in {int} cells")
	public void verifyNoLabelsIdentified(int countWithNoLabels) {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyLabelsIdentified(countWithNoLabels),
				"labels are identified even after skip is clicked");
	}

	@When("click on Default value of {string} and enter {string}")
	public void EnterDefaultValue(String label, String defaultValue) {
		offerGenerationSalaryRulePO.enterDefaultValue(label, defaultValue);
	}

	@When("Select any cell reference under CTC {string}")
	public void selectAnyCellReferenceUnderCTC(String cellRef) {
		offerGenerationSalaryRulePO.selectAnyCellrefUnderCTC(cellRef);
	}

	@Then("{string} should have default value as {string}")
	public void verifyLabelHasDefaultValue(String labelName, String defaultValue) {
		offerGenerationSalaryRulePO.verifyLabelHasDefaultValue(labelName, defaultValue);
	}

	@When("click on Update Breakup")
	public void clickOnUpdateBreakup() {
		offerGenerationSalaryRulePO.clickOnUpdateBreakup();
	}

	@Then("verify all the validation errors on the page for labels {string},{string},{string},{string},{string}")
	public void verifyAllValidationErrorsOnReviewScreen(String label1, String label2, String label3, String label4,
			String label5) {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyAllValidationErrors(label1, label2, label3, label4, label5),
				"all validation errors not displayed correctly");
	}

	@When("select input type of {string} as {string}")
	public void selectInputType(String label, String inputType) {
		offerGenerationSalaryRulePO.selectInputType(label, inputType);
	}

	@When("select sheet {string} under Fetch From Spreadsheet")
	public void selectSheetFromFetchFromSpreadsheet(String sheetName) {
		offerGenerationSalaryRulePO.selectSheet(sheetName);
	}

	@When("select Fetch From Spreadsheet of {string}")
	public void selectFetchFRomSpreadsheet(String labelName) {
		offerGenerationSalaryRulePO.chooseFromSpreadsheet(labelName);
	}

	@When("enter range values {string} to {string}")
	public void enterRangeValues(String startingRange, String EndRange) {
		offerGenerationSalaryRulePO.enterRangeOfValuesInFillFromSpreadsheet(startingRange, EndRange);
	}

	@When("Click on save on fetch from spreadsheet lightbox")
	public void clickSaveFetchFromSpreadsheet() {
		offerGenerationSalaryRulePO.clickSaveFetchFromSpreadsheet();
	}

	@Then("Value Range of {string} should be {string}")
	public void valueRangeDisplayedCorrectly(String labelName, String sheetRange) {
		Assert.assertTrue(offerGenerationSalaryRulePO.valueRangeDisplayedCorrectly(labelName, sheetRange),
				"range of sheet not displayed correctly");
	}

	@Then("error should be displayed when invalid range is entered")
	public void errorDisplayedInvalidRange() {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyErrorDisplayedOnInValidRange(), "error not displayed");
	}

	@Then("verify Single choice values for Labelname {string} should be")
	public void verifySingleChoiceDDReviewScreen(String label, DataTable dt) {
		List<String> list = dt.asList();
		Assert.assertTrue(
				offerGenerationSalaryRulePO.verifySingleChoiceValues(label, list),
				"single choice DD values are not displayed correctly");
	}

	@When("Add 3 values {string},{string},{string} in manually type options under {string}")
	public void add3ValuesUnderManuallyTypeOptions(String value1, String value2, String value3, String labelName) {
		offerGenerationSalaryRulePO.addValuesUnderManuallyTypeOptions(value1, value2, value3, labelName);
	}

	@When("delete {string} value from manually type options")
	public void deleteValueFromManuallyTypeOption(String value) {
		offerGenerationSalaryRulePO.deleteValueFromManuallyTypeOption(value);
	}

	@Then("verify Single choice values for Labelname {string} after deleting one value should be")
	public void verifySingleChoiceValuesAfterDeletingValue(String label, DataTable dt) {
		List<String> list = dt.asList();
		Assert.assertTrue(
				offerGenerationSalaryRulePO.verifySingleChoiceValuesAfterDeletingOneValue(label, list),
				"single choice DD values are not displayed correctly");
	}

	@When("click on Input tab")
	public void clickOnInputTab() {
		offerGenerationSalaryRulePO.clickOnInputTab();
	}

	@When("delete row with label {string}")
	public void deleteRowWithLabel(String label) {
		offerGenerationSalaryRulePO.deleteRowWithLabel(label);
	}

	@Then("verify label {string} is not displayed on review and approve page")
	public void verifyLabelNotDisplayedOnReviewScreen(String labelName) {
		Assert.assertFalse(offerGenerationSalaryRulePO.verifyLabelisNotDisplayed(labelName),
				"label displayed even after deleting it");

	}

	@Then("verify single choice is detected in input type corresponding to label {string}")
	public void verifySingleChoiceDetectedOnInputScreen(String labelName) {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifySingleChoiceDetectedOnInputScreen(labelName),
				"single choice is not detected");
	}

	@Then("verify error should be displayed in case null values is passed in vlookup formula ie {string}")
	public void vlookupErrorCaseWhenNullValuesPresentInRange(String msg) {
		Assert.assertTrue(offerGenerationSalaryRulePO.verifyVlookupErrorDisplayedNullValuesPresent(msg),
				"vlookup error is not present when null values are present in range");
	}

	@When("Enter text value {string} under {string}")
	public void enterTextOnReviewAndApprove(String text, String label) {
		offerGenerationSalaryRulePO.enterTextUnderLabel(text, label);
	}

	@Then("validation should be displayed to only enter numeric values under {string}")
	public void verifyOnlyNumericValuesAllowed(String labelName) {
		Assert.assertEquals(offerGenerationSalaryRulePO.verifyOnlyNumericValueAllowed(labelName),
				"This field is mandatory");
	}

	@Then("verify blank cell error is displayed on input screen")
	public void verifyBlankCellErrorDisplayed() {
		Assert.assertEquals(offerGenerationSalaryRulePO.verifyNullCellErrorVlookupDisplayedOnInputScreen(),
				"Blank cell Sheet1:Z1 present in input range Z1:Z2");
	}
}