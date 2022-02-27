package com.naukri.stepdefinitions.Settings;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.test.base.CommonAction;
import com.naukri.pageobjects.Settings.ManageFeedbackFormPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageFeedbackFormStepDef {
	
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
//	APITestOps APITestObj = new APITestOps();

	ManageFeedbackFormPO ManageFeedbackFormActionObj = new ManageFeedbackFormPO();
	
	
//	@Then("verify user is able to view all columns")
//	public void verifyAllcolumn() {
//		Assert.assertTrue(ManageFeedbackFormActionObj.verifyAllColumns(),
//				"Test case failed : user is not able to see all columns at Manage feedback form page");
//		}
	
	@Then("verify user see heading \"([^\"]*)\"")
	public void verifyHeading(String heading) {
		Assert.assertTrue(ManageFeedbackFormActionObj.verifyHeadings(heading),
				"Test case failed : user is not able to see headings");
	}
	
	@When("user fill feedback form name & Form title")
	public void fillFormName() {
		String formName = "AutoFeed" + CommonAction.generateRandomStrings(5, "String");
		PropFileHandler.writeProperty("formName",formName);
		ManageFeedbackFormActionObj.fillFormNames(formName);
	}
	
	@And("user use all type of questions")
	public void createAllTypeQuestion() {
		String question = "question No "+ CommonAction.generateRandomStrings(2,"int");
		ManageFeedbackFormActionObj.createAllTypeQuestions(question);
	}
	
	@Then("verify user is able to see created feedback form")
	public void verifyFormAdded() {
		String formName = PropFileHandler.readProperty("formName");
		Assert.assertTrue(ManageFeedbackFormActionObj.verifyFormsAdded(formName),
				"Test case failed : user is not able to see new created feedback form");
	}
	
	
	@When("user fill mandatory fields for feedback form")
	public void fillMandatoryFieldsFeedbackForm() {
		String formName = "AutoFeed" + CommonAction.generateRandomStrings(5, "String");
		PropFileHandler.writeProperty("formName",formName);
		ManageFeedbackFormActionObj.fillMandatoryFieldsForFeedbackForm(formName);
	}
	
	@When("user fill new fields for feedback form")
	public void fillNewFieldFeedbackForm() {
		String formName = "NewFeed" + CommonAction.generateRandomStrings(5, "String");
		PropFileHandler.writeProperty("formName",formName);
		ManageFeedbackFormActionObj.fillNewfieldsFeedbackForm(formName);		
	}
	
	@Then("verify preview of feedback form is visible to user")
	public void verifyPreviewFeedbackForm() {
		Assert.assertTrue(ManageFeedbackFormActionObj.verifyPreviewFeedbackForms(),
				"Test case failed : user is not able to see preview of feedback form");
	}
	
	@When("user click on Delete link under feedback form")
	public void deleteFeedbackForm() {
		//String formName = PropFileHandler.readProperty("formName");
		ManageFeedbackFormActionObj.deleteFeedbackForms(PropFileHandler.readProperty("formName"));
	}
	

	@And("user prefill the form by selecting already created form")
	public void prefillFeedbackForm() {
		ManageFeedbackFormActionObj.prefillFeedbackForms();
	}
	
	@And("user enter same feedback form name")
	public void userEnterSameFeedbackFormName() {
		ManageFeedbackFormActionObj.userEnterSameFeedbackName();
	}
	
	@And("user uncheck the box share with everyone")
	public void uncheckShareCheckBox() {
		ManageFeedbackFormActionObj.unCheckShareCheckBoxs();
	}
}
	
