package com.naukri.stepdefinitions.Settings;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.CommonAction;
import com.naukri.pageobjects.Settings.ManageCVBackUpPO;
import com.naukri.pageobjects.Settings.ManageDocumentsPO;
import com.naukri.pageobjects.Settings.ManageJobBoardsPO;
import com.naukri.pageobjects.Settings.ManageWhiteLabelPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ManageDocumentsStepDefs {
	
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	ManageDocumentsPO ManageDocumentsPOObj = new ManageDocumentsPO();
	
	@When("user input new document name on manage document page")
	public void inputDocumentName() {
		String documentName = "Document " + CommonAction.generateRandomStrings(5,"String");
		PropFileHandler.writeProperty("documentName", documentName);
		ManageDocumentsPOObj.inputDocumentNames(documentName);
	}
	
	@And("user click on add symbol on manage document page")
	public void clickOnAddSymbol() {
		ManageDocumentsPOObj.clickOnAddDocumentSymbol();
	}
	
	@Then("newly added document should be visible on the manage document page")
	public void addedDocumentShouldBeVisible() {
		String documentName = PropFileHandler.readProperty("documentName");
		Assert.assertTrue(ManageDocumentsPOObj.verifyNewAddedDocument(documentName),
				"test case failed:- added document is not visible");
	}
	
	@When("user select all available documents")
	public void selectAllavailabelDocuments() {
		ManageDocumentsPOObj.selectAvailableDocuments();
	}
	
	@Then("all selected documents should be visible on manage document page")
	public void verifyAllSelectedDocuments() {
		Assert.assertTrue(ManageDocumentsPOObj.verifySelectedDocumentsAreVisible(),
				"test case failed:- All selected documents are not visible");
	}
	
	@Then("User should be able to see the lightbox with title {string}")
	public void user_should_be_able_to_see_the_lightbox_with_title(String expectedString) {
	    Assert.assertTrue( ManageDocumentsPOObj.checkThePresenceOfTitle(expectedString), 
	    		expectedString + " is not visible for the lightbox");
	    TestNGLogUtility.pass(expectedString + " is visible for the lightbox");
	}
	
	@When("User clicks on Select Documents")
	public void user_clicks_on_Select_Documents() {
		ManageDocumentsPOObj.clickOnSelectDoc();
	}
	
	@When("User selects {string}")
	public void user_selects(String expectedDocumentNameToBeSelected) {
	   ManageDocumentsPOObj.selectDocument(expectedDocumentNameToBeSelected);
	}

}
