package com.naukri.stepdefinitions.Taxonomy.Location;

import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.naukri.pageobjects.HiringManager.RaiseRequisitionPagePO;
import com.naukri.pageobjects.Taxonomy.Location.TaxonomyRaiseRequisitionPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.cucumber.datatable.DataTable;

/**
 *
 * @author udit.khanna
 */
public class TaxonomyRaiseRequisitionStepDef {

	TaxonomyRaiseRequisitionPO taxonomyRaiseRequisition = (TaxonomyRaiseRequisitionPO) PageObjectWrapper
			.getObject(TaxonomyRaiseRequisitionPO.class);
	RaiseRequisitionPagePO raiseRequisitionPagePO = (RaiseRequisitionPagePO) PageObjectWrapper
			.getObject(RaiseRequisitionPagePO.class);
	SoftAssert softAssert = new SoftAssert();

	@When("User clicks on {string} drop down")
	public void clickDropDown(String dropDownId) {
		taxonomyRaiseRequisition.clickDropDown(dropDownId);
	}

	@Then("User sees {string} as checkboxes")
	public void verifyValuesAsCheckboxes(String str, DataTable dt) {
		List<String> cityList = dt.asList(String.class);
		Assert.assertTrue(taxonomyRaiseRequisition.verifyValuesAsCheckboxes(str, cityList),
				"Cities not visible in dropdown.");
	}

	@Then("User sees {string} in dropdown")
	public void verifyValueInDropdown(String str) {
		Assert.assertTrue(taxonomyRaiseRequisition.verifyValueInDropdown(str), str + " value not visible in dropdown.");
	}

	@When("User enters {string} in {string} field")
	public void enterValueInDDField(String valueToBeEntered, String ddId) {
		taxonomyRaiseRequisition.enterValueInDDField(ddId, valueToBeEntered);
	}

	@And("User checks the checkbox from the dropdown")
	public void checkCheckBoxInDD() {
		taxonomyRaiseRequisition.checkCheckBoxInDD();
	}

	@Then("User sees {string} added as tag")
	public void verifyTagAdded(String tagValue) {
		Assert.assertTrue(taxonomyRaiseRequisition.verifyTagAdded(tagValue), tagValue + " tag not added.");
	}

	@Then("User sees at max {int} cities suggestions")
	public void verifyMaxSuggestionValues(int maxSuggestions) {
		Assert.assertTrue(taxonomyRaiseRequisition.verifyMaxSuggestionValues(maxSuggestions),
				"Max suggestions not equal to : " + maxSuggestions);
	}

	@Then("User sees {int} options to add")
	public void verifyOptionsToAdd(int noOfSuggestions, DataTable dt) {
		List<String> list = dt.asList();
		Assert.assertTrue(taxonomyRaiseRequisition.verifyOptionsToAdd(noOfSuggestions, list),
				"Options to add are not visible");
	}

	@When("User clicks {string} option for adding not found city")
	public void clickOptionForAddingCity(String optionToBeClicked) {
		taxonomyRaiseRequisition.clickOptionForAddingCity(optionToBeClicked);
	}

	@Then("User sees {string} layer opened with options")
	public void verifyLayerAndContents(String layerTitle, DataTable dt) {
		List<String> list = dt.asList();
		softAssert.assertTrue(taxonomyRaiseRequisition.verifyLayerAndContents(layerTitle, list),
				layerTitle + " layer is not visible with options.");
		softAssert.assertAll();
	}
	
	@Then("User sees {string} entered text in {string} field")
	public void verifyTextInField(String txtToBeVerified, String fieldLabelValue){
		softAssert.assertTrue(taxonomyRaiseRequisition.verifyTextInField(txtToBeVerified, fieldLabelValue),
				fieldLabelValue + " field does not have text: " + txtToBeVerified);
		softAssert.assertAll();
	}
	
	@And("User clears {string} field")
	public void clearField(String strValue){
		taxonomyRaiseRequisition.clearField(strValue);
	}
	
	@Then("User sees {string} error messages on Layer")
	public void verifyErrorMsgOnLayer(String errorMsg){
		Assert.assertTrue(taxonomyRaiseRequisition.verifyErrorMsgOnLayer(errorMsg),
				"Error message is not visible");
	}
	
	@When("User enters {string} in {string} field in the layer")
	public void enterValueInFieldInLayer(String valueToBeEntered, String fieldName) {
		taxonomyRaiseRequisition.enterValueInFieldInLayer(fieldName, valueToBeEntered);
	}
	
	@When("User selects {int} option from {string} dropdown in layer")
	public void selectOptionFromDDInLayer(int noOfOption, String DDName) {
		taxonomyRaiseRequisition.selectOptionFromDDInLayer(noOfOption, DDName);
	}
	
	@When("User checks {int} option from the Job Location dropdown")
	public void checkOptionInJobLocationDD(int noOfOption) {
		taxonomyRaiseRequisition.checkOptionInJobLocationDD(noOfOption);
	}
	
	@When("User clicks cross icon for the tag")
	public void clickCrossIconForTag() {
		taxonomyRaiseRequisition.clickCrossIconForTag();
	}
	
	@Then("User sees {string} removed as tag")
	public void verifyTagRemoved(String tagValue){
		Assert.assertTrue(taxonomyRaiseRequisition.verifyTagRemoved(tagValue),
				"Tag is visible");
	}
	
	@Then("User sees {string} option is checked in dropdown")
	public void verifyOptionIsCheckedInDD(String tagValue){
		Assert.assertTrue(taxonomyRaiseRequisition.verifyOptionIsCheckedInDD(tagValue),
				"Option is not checked in dropdown");
	}
	
	@When("User unchecks {string} option from dropdown")
	public void uncheckOptionInDD(String optionToBeUnchecked){
		taxonomyRaiseRequisition.uncheckOptionInDD(optionToBeUnchecked);
	}
	
	@When("User clicks outside the Job Location dropdown")
	public void clickOutsideJobLocationDD(){
		taxonomyRaiseRequisition.clickOutsideJobLocationDD();
	}
	
	@When("User creates requisition with no approval process and first group in DD, using {string} in {string} field")
	public void createRequisitionWithNoApprovalAndFirstGroupInDDAndLocationSelected(String valueToBeEntered, String ddId){
		taxonomyRaiseRequisition.enterValueInDDField(ddId, valueToBeEntered);
		taxonomyRaiseRequisition.checkCheckBoxInDD();
		raiseRequisitionPagePO.createRequisitionWithNoApprovalAndFirstGroupInDDAndLocationSelected();
	}
	
	@When("saves Requisition Tracking ID")
	public void saveRequisitionIdToLocal(){
		taxonomyRaiseRequisition.saveRequisitionIdToLocal();
	}
	
	@When("User navigates to Requisition Overview using Requisition Tracking ID")
	public void navigateToRequisitionOverviewUsingReqId(){
		taxonomyRaiseRequisition.navigateToRequisitionOverviewUsingReqId();
	}
	
	@Then("User sees {string} as location on Requisition Overview")
	public void verifyLocationOnRequisitionOverview(String lcnToBeVerified){
		Assert.assertTrue(taxonomyRaiseRequisition.verifyLocationOnRequisitionOverview(lcnToBeVerified),
				"Location not present on Requisition Overview page.");
	}
}
