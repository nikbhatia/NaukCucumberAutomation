package com.naukri.stepdefinitions.Settings;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.CommonAction;
import com.naukri.pageobjects.Settings.ManageCVBackUpPO;
import com.naukri.pageobjects.Settings.ManageJobBoardsPO;
import com.naukri.pageobjects.Settings.ManageRequisitionTemplatePO;
import com.naukri.pageobjects.Settings.ManageWhiteLabelPO;
import com.naukri.stepdefinitions.Requirements.RequirementCreationStepDef;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ManageRequisitionTemplateStepDefs {

	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
//	APITestOps APITestObj = new APITestOps();
	public static String reqTemplateName="";
	ManageRequisitionTemplatePO ManageRequisitionTemplatePOobj = new ManageRequisitionTemplatePO();

	@And("user create Requisition template by prefilling it")
	public void createRequisitionTemplateByprefill() {
		String reqTemplateName = "Requisition" + CommonAction.generateRandomStrings(5, "String");
		PropFileHandler.writeProperty("reqTemplateName", reqTemplateName);
		ManageRequisitionTemplatePOobj.createRequisitionTemplateByPrefilling(reqTemplateName);
	}

	@And("user click on \"([^\"]*)\" value")
	public void clickOnValue(String value) {
		ManageRequisitionTemplatePOobj.clickOnValuee(value);
	}

	@When("user click on sorting option on template name")
	public void clickOnSortingOption() {
		ManageRequisitionTemplatePOobj.clickOnSorting();
	}

	@Then("verify user is able to see template name is sorted order")
	public void verifySortingOnTemplate() {
		ManageRequisitionTemplatePOobj.verifySortingTemplate();
	}

	@When("user fill mandatory fields for requisition template")
	public void fillMandatoryFieldsReqTemplate() {
		reqTemplateName = "Requisition" + CommonAction.generateRandomStrings(5, "String");
		PropFileHandler.writeProperty("reqTemplateName", reqTemplateName);
		ManageRequisitionTemplatePOobj.fillMandatoryFieldsOfReqTemplate(reqTemplateName);
	}

	@When("user fill all fields for creating requisition template")
	public void fillAllFieldsOfRequisitionTemplate() {
		String reqTemplateName = "Requisition" + CommonAction.generateRandomStrings(5, "String");
		PropFileHandler.writeProperty("reqTemplateName", reqTemplateName);
		ManageRequisitionTemplatePOobj.fillAllFieldsReqTemplate(reqTemplateName);
	}

	@Then("verify created requisition template is visible to user")
	public void verifyRequisitionTemplateAdded() {
		String reqTemplateName = PropFileHandler.readProperty("reqTemplateName");
		Assert.assertTrue(ManageRequisitionTemplatePOobj.verifyRequisitionTemplateAdd(reqTemplateName),
				"Test case failed : user is not able to see new added Requisition template");
	}

	@When("user click on list item \"([^\"]*)\" on requisition template listing page")
	public void clickOnListItem(String listItem) {
		ManageRequisitionTemplatePOobj.clickOnListItems(listItem);
	}

	@When("user enter same requisition template name which already exist")
	public void enterSametemplateName() {
		ManageRequisitionTemplatePOobj.enterSameRequisitionTemplateName();
	}

	@When("user entered the created requisition template on search bar")
	public void enterRequisitionTemplateOnSearchBar() {
		String reqTemplateName = PropFileHandler.readProperty("reqTemplateName");
		PropFileHandler.writeProperty("reqTemplateName", reqTemplateName);
		ManageRequisitionTemplatePOobj.enterReqTemplateNameOnsearch(reqTemplateName);
	}

	@When("user click on cross option on success strip")
	public void clickOnCrossOptionSuccessStrip() {
		ManageRequisitionTemplatePOobj.clickOnCrossOptionOnStrip();
	}

	@Then("verify success message \"([^\"]*)\" is not visible")
	public void verifySuccessMsgNotVisible(String successMsg) {
		Assert.assertFalse(ManageRequisitionTemplatePOobj.verifySuccessMsgNotVisible(successMsg),
				"Test case failed : As user is still able to see the success message"+successMsg+"");
	}
	
	@Then("verify user has only preview option available on template which is created by superuser")
	public void getListOfActions() {
		String reqTemplateName = PropFileHandler.readProperty("reqTemplateName");
		PropFileHandler.writeProperty("reqTemplateName", reqTemplateName);
		Assert.assertTrue(ManageRequisitionTemplatePOobj.getListOfAuthorisedActions(reqTemplateName),
				"Test case failed: Subuser is able to see 'Edit' option for template which is created by other user");
	}

	@When("user fill requisition name,group,recruiter on raise requisition page")
	public void userFillReqNameGroup() {
		String reqTemplateName = "Requisition " + CommonAction.generateRandomStrings(5, "String");
		PropFileHandler.writeProperty("reqTemplateName", reqTemplateName);
		ManageRequisitionTemplatePOobj.fillReqNameGroupRecruiter(reqTemplateName);	
	}
	
	@And("user prefill requisition from requisition template on raise requisition page")
	public void userPrefillFromRequisitionTemplate() {
		ManageRequisitionTemplatePOobj.prefillFromRequisitionTemplate();
	}

	 @When("User click on the preview button of recent created requisition template")
	    public void User_click_on_the_preview_button_of_recent_created_requisition_template() {
		 ManageRequisitionTemplatePOobj.clickOnPreviewButton(reqTemplateName);
	    }

	 @Then("User should be able to see Variable amount with annual CTC is displaying on requisition popup")
	    public void User_should_be_able_to_see_Variable_amount_with_annual_CTC_is_displaying_on_requisition_popup() {
		 Assert.assertTrue(ManageRequisitionTemplatePOobj.verifyVariableWithSalary(RequirementCreationStepDef.variablePercent),"Correct Veriable Amount is not being dispalyed on requisition template.");
		 TestNGLogUtility.pass("Correct Veriable Amount is being dispalyed on requisition template.");  
	 }
	 
	 @Then("User should be able to see {string} is displaying on requisition popup")
	    public void User_should_be_able_to_see_is_displaying_on_requisition_popup(String fieldName) {
		 Assert.assertTrue(ManageRequisitionTemplatePOobj.verifyVariableWithSalary(RequirementCreationStepDef.variablePercent),"Correct Veriable Amount is not being dispalyed on requisition template.");
		 TestNGLogUtility.pass("Correct Veriable Amount is being dispalyed on requisition template.");  
	 }
	 
	 @When("I fill in the {string} as {string} in requisition")
		public void i_fill_in_the_as(String ctcType, String ctcValue) {
			ManageRequisitionTemplatePOobj.fillMinAndMaxSalary(ctcType, ctcValue);
			RequirementCreationStepDef.ctcAmount=ctcValue;
			if (ctcType.equals("minCTC"))
				RequirementCreationStepDef.minAmount = RequirementCreationStepDef.ctcAmount;
		}
	 
	 @When("User add keyword as on Requisition Template")
		public void User_add_keyword_as(DataTable dataTable) {
			List<String> skills = dataTable.asList(String.class);
			for (String skill : skills)
				ManageRequisitionTemplatePOobj.fillKeyWord(skill);
		}
	 
	 @When("User click on the star on keyword chip on Requisition Template")
		public void User_click_on_the_star_on_keyword_chip(DataTable dataTable) {
			List<String> skills = dataTable.asList(String.class);
			for (String skill : skills)
				ManageRequisitionTemplatePOobj.clickOnStarAgainstSkill(skill);
		}
	 
	 @Then("User should be able to see correct tooltip for {string} on Requisition template")
	    public void User_should_be_able_to_see_is_displaying_on_requisition_popup(String type, DataTable dataTable) {
			List<String> skills = dataTable.asList(String.class);
			for (String skill : skills) {
		 Assert.assertTrue(ManageRequisitionTemplatePOobj.verifytoolTip(type, skill),"Correct tooltip for "+ type + " is not being dispalyed on requisition template.");
		 TestNGLogUtility.pass("Correct tooltip for "+ type + " is being dispalyed on requisition template.");  
	 }
	 }
}

