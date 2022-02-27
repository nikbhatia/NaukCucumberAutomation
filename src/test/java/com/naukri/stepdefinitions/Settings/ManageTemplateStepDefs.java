package com.naukri.stepdefinitions.Settings;

import com.naukri.automation.util.BasicTestOps;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.pageobjects.Billing.BillingDashboardPagePO;
import com.naukri.pageobjects.Settings.ManageGroupPO;
import com.naukri.pageobjects.Settings.ManageTemplatePO;
import com.naukri.pageobjects.Settings.SettingsDashboardPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

public class ManageTemplateStepDefs {
	
	ManageTemplatePO ManageTemplateActionObject = new ManageTemplatePO();
	SettingsDashboardPO SettingGroupActionObject = new SettingsDashboardPO();
	ManageGroupPO ManageGroupActionObject = new ManageGroupPO();
	BillingDashboardPagePO billingDashboardPagePO = (BillingDashboardPagePO) PageObjectWrapper.getObject(BillingDashboardPagePO.class);
	private String timeStamp = ""+System.currentTimeMillis();
	private String uniqueTemplateName;
	String templateName = BasicTestOps.generateRandomStrings(9, "Alphanumeric");

	@And("user select template type \"([^\"]*)\"")
	public void clickOnTemplateTypee(String templateType) {
		ManageTemplateActionObject.clickOnTemplateType(templateType);
	}
	
	@When("user fill mandatory fields for Message template with tags")
	public void fillMandatoryFieldsForMsg() {
		String templateName = "Template" + CommonAction.generateRandomStrings(8, "String");
		PropFileHandler.writeProperty("templateName", templateName);
		ManageTemplateActionObject.fillMandatoryFieldsForMsg(templateName);
	}
	

	
	@Then("verify created template is visible to user")
	public void verifyTemplateAdded() {
		String templateName = PropFileHandler.readProperty("templateName");
		Assert.assertTrue(ManageTemplateActionObject.verifyTemplateAdd(templateName),
				"Test case failed : user is not able to see new added template");
	}
	
	@When("user fill mandatory fields for status template")
	public void fillMandatoryFieldsForStatuschng() {
		String templateName = "Template" + CommonAction.generateRandomStrings(8, "String");
		PropFileHandler.writeProperty("templateName", templateName);
		ManageTemplateActionObject.fillMandatoryfieldForStatusChange(templateName);
	}
	
	@When("user fill mandatory fields for other template")
	public void fillMandatoryFields() {
		String templateName = "Template" + CommonAction.generateRandomStrings(8, "String");
		PropFileHandler.writeProperty("templateName", templateName);
		ManageTemplateActionObject.fillMandatoryfield(templateName);
	}
	
	@When("user click on Delete link under template")
	public void deleteTemplates() {
		ManageTemplateActionObject.deleteTemplate();
	}
	
	@When("user select 2 template")
	public void selectTemplateInBulk() {
		ManageTemplateActionObject.selectTemplateBulk();
	}
	
	@And("user click on bulk delete button for template")
	public void deleteTemplateInBulk() {
		ManageTemplateActionObject.deleteTemplateBulk();
	}
	
	@And("user fill fields with new data")
	public void fillNewDetailsForStatusChng() {
		ManageTemplateActionObject.fillNewDetails();
	}
	
	@Then("verify details are filled")
	public void verifyDetailsFilled() {
		Assert.assertTrue(ManageTemplateActionObject.verifyDetailFilled(),
				"Test case failed : user is not able to see filled details");
	}
	
	@Then("user is able to view preview of mail template")
	public void verifyMailPreviews() {
		Assert.assertTrue(ManageTemplateActionObject.verifyMailpreview(),
				"Test case failed : user is not able to see preview template");
	}
	
	@When("user search the template with correct filters")
	public void SearchcorrectTemplates() {
		String searchTemplateName = PropFileHandler.readProperty("templateName");
		ManageTemplateActionObject.searchCorrectTemplate(searchTemplateName);
	}
	
	@Then("user able to see the searched template")
	public void verifySearchcorrectTemplates() {
		String searchTemplateName = PropFileHandler.readProperty("templateName");
		Assert.assertTrue((ManageTemplateActionObject.verifySearchCorrectTemplate(searchTemplateName)),
				"Test case failed : user is not able to see searched template");
	}
	
	@When("user search the template with wrong filters")
	public void searchWrongTemplates() {
	//	String searchTemplateName = PropFileHandler.readProperty("templateName");
		ManageTemplateActionObject.searchWrongTemplate();
	}
	
	
	@When("user chose prefill from template & fill template name")
	public void prefillFromTemplates() {
		String templateName = "Template " + CommonAction.generateRandomStrings(8, "String");
		ManageTemplateActionObject.prefillFromTemplate(templateName);
	}

	@And("user add a new {string} template with {string} category")
	public void userAddANewTemplateWithCategory(String templateType, String templateCategory) {
		ManageGroupActionObject.ClickOnlinks("Add a New Template  ");
		ManageTemplateActionObject.clickOnTemplateType(templateType);
		ManageTemplateActionObject.selectFinancialTemplateCategory(templateCategory);
		ManageTemplateActionObject.clearPreviousBodyAndFillNew("Credit Note Body");
		uniqueTemplateName = ManageTemplateActionObject.enterFinanceTemplateName(templateCategory + " Temp" + timeStamp);
	}

	@And("user add a {string} template with {string} category from previously created templates")
	public void userAddATemplateWithCategoryFromPreviouslyCreatedTemplates(String templateType, String templateCategory) {
		ManageGroupActionObject.ClickOnlinks("Add a New Template  ");
		ManageTemplateActionObject.clickOnTemplateType(templateType);
		ManageTemplateActionObject.selectFinancialTemplateCategory(templateCategory);
		ManageTemplateActionObject.clickOnPrefillFromTemplateDD();
		ManageTemplateActionObject.searchAndSelectExistingTemplate(uniqueTemplateName);
	}

	@And("user change the category from category list")
	public void userChangeTheCategoryFromCategoryList() {
		ManageTemplateActionObject.changeFinancialTemplateCategory("Payment Reminder");
	}

	@Then("Prefill template name should be changed to Prefill from template text")
	public void prefillTemplateNameShouldBeChangedToPrefillFromTemplateText() {
		Assert.assertEquals(ManageTemplateActionObject.getDefaultTextOfPrefillFromFinanceTemplate(), "Prefill from Template");
	}

	@And("user fill mandatory fields for financial template")
	public void userFillMandatoryFieldsForFinancialTemplate() {
		ManageTemplateActionObject.fillMandatoryfieldForFinancialTemplate(templateName);
	}

	@And("user save financial template")
	public void userSaveFinancialTemplate() {
		ManageTemplateActionObject.saveFinancialTemplate();
	}

	@And("user share financial template")
	public void userShareFinancialTemplate() {
		ManageTemplateActionObject.clickOnShareTemplateBtn();
	}

	@Then("verify created financial template is visible to user")
	public void verifyCreatedFinancialTemplateIsVisibleToUser() {
		Assert.assertTrue(ManageTemplateActionObject.verifyTemplateAdd(templateName),
				"Test case failed : user is not able to see new added template");
	}

	@When("user close the mail preview")
	public void userCloseTheMailPreview() {
		ManageTemplateActionObject.closeMailPreview();
	}

	@And("user fill mandatory fields for financial template with the same template name")
	public void userFillMandatoryFieldsForFinancialTemplateWithTheSameTemplateName() {
		ManageTemplateActionObject.fillMandatoryfieldForFinancialTemplate("billingCategoryTemplateName");
	}

	@Then("validate duplicate template validation message")
	public void validateDuplicateTemplateValidationMessage() {
		Assert.assertEquals("Template with the same name exists. Please use a different name",
				ManageTemplateActionObject.getValidationMessage());
	}

	@Then("validate template should be shared")
	public void validateTemplateShouldBeShared() {
		Assert.assertTrue(ManageTemplateActionObject.verifyUnshareTextOnTemplate(), "Template is not shared successfully");

	}

	@Then("validate all options in the category list")
	public void validateAllOptionsInTheCategoryList() {
		List<String> categoryNames = ManageTemplateActionObject.getCategoryList("categoryList");
		Assert.assertTrue(ManageTemplateActionObject.VerifyAllCategory(categoryNames), "All Category list is not correct");
	}

	@And("user click on category list button")
	public void userClickOnCategoryListButton() {
		ManageTemplateActionObject.clickOnCategoryList();
	}

	@Then("validate all category options template data")
	public void validateAllCategoryOptionsTemplateData() {
		Assert.assertTrue(ManageTemplateActionObject.verifyCategoryTemplatesData(), "All Category options data is not relevant");
	}
	
	@When("User selects the {string} excel tracker")
	public void user_selects_the_excel_tracker(String indexOfExcelTracker) {
	    ManageTemplateActionObject.selectExcelTrackerBasedOnIndexForTemplate(indexOfExcelTracker);
	}
}
