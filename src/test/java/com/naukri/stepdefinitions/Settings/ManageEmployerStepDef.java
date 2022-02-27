package com.naukri.stepdefinitions.Settings;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.BillingAPI;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Settings.ManageEmployerPO;
import com.naukri.pageobjects.Settings.ManageGroupPO;
import com.naukri.pageobjects.Settings.ManageRequisitionTemplatePO;
import com.naukri.test.base.CommonAction;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.List;

import static com.naukri.test.base.BaseAutomation.wait;
import static com.naukri.test.base.CommonAction.generateRandomStrings;

public class ManageEmployerStepDef {
	ManageEmployerPO manageEmployerObject = new ManageEmployerPO();
	ManageRequisitionTemplatePO manageRequisitionTemplatePO = new ManageRequisitionTemplatePO();
	ManageGroupPO manageGroupActionObject = new ManageGroupPO();
	CommonAction commonActions = new CommonAction();
	String employerName = null;
	String empAddress = null;
	String gstinString = null;
	String categoryName = null;
	String flatfee=null;

	private String timeStamp = ""+System.currentTimeMillis();

	@When("Click on add a new employer")
	public void clickAddEmployer() {
		manageEmployerObject.clickAddNewEmployer();
	}

	@When("enter employer name")
	public void enterEmployerName() {
		manageEmployerObject.enterEmployerName("Employer- "+timeStamp);
	}

	@When("Enter Subrecruiter name and click on save")
	public void enterSubrecruiterNameAndClickOnSave() {
		manageEmployerObject.enterSubrecruiterNameOnGroup("subuserconsultantplus1@yopmail.com");
	}

	@And("user add a new employer with billing details")
	public void userAddANewEmployerWithBillingDetails() {
		manageEmployerObject.clickAddNewEmployer();
		manageEmployerObject.enterEmployerName("Employer- "+timeStamp);
		manageEmployerObject.enterEmployerDescription();
		manageEmployerObject.selectRecruitersOnEmployerPage();
		manageEmployerObject.clickBillingDetailsTab();
		manageEmployerObject.clickAddButtonToAddBillingInformation();
		manageEmployerObject.addNewBillingInformation("Category - "+timeStamp, "10000");
		manageEmployerObject.saveEmployer();
	}

	@And("user edit added employer and click on billing details tab")
	public void userEditAddedEmployerAndClickOnBillingDetailsTab() {
		manageEmployerObject.clickOnAddedEmployerRelatedLinks("Employer- "+timeStamp, "Edit");
		manageEmployerObject.clickBillingDetailsTab();
	}

	@And("user add new billing detail")
	public void userAddNewBillingDetail() {
		manageEmployerObject.click_on_Element("Add more");
		manageEmployerObject.addNewBillingInformation("Category 2 - "+timeStamp, "10000");
	}

	@When("user click on edit icon after adding billing details")
	public void userClickOnEditIconAfterAddingBillingDetails() {
		manageEmployerObject.click_on_Element("edit",2);
	}

	@And("user click on category name field and click on flat fee option")
	public void userClickOnCategoryNameFieldAndClickOnFlatFeeOption() {
		manageEmployerObject.clickCategoryNameInBillingDetails();
		manageEmployerObject.clickFlatFeeTextBoxInBillingDetails();
	}

	@Then("Verify Save button is enabled")
	public void verifySaveButtonIsEnabled() {
		Assert.assertTrue(manageEmployerObject.click_on_Element("SAVE",1), "Save button is not working !!!!!");

	}

	@When("user fill mandatory fields of Employer Details and Recruiters on Add new employer page")
	public void userFillManadatoryEmployerDetailsRecruiters() {
		employerName = manageEmployerObject.enterEmployerName("Employer- "+timeStamp);
		manageEmployerObject.enterEmployerDescription();
		manageEmployerObject.selectRecruitersOnEmployerPage();
	}

	@And("user click on Billing Details tab")
	public void userClickOnBillingDetailsTab() {
		manageEmployerObject.clickBillingDetailsTab();
		wait.waitForPageToLoadCompletely();
	}

	@And("user click on Employer Address tab")
	public void userClickOnEmployerAddressTab() {
		manageEmployerObject.clickEmployerAddressTab();
	}

	@Then("Verify employer is added with success msg")
	public void verifyEmployerIsAddedWithSuccessMsg() {
		Assert.assertTrue(manageEmployerObject.verifySuccessMessage("Employer Added"), "Employer is not added successfully !!!!");
	}
	@When("^user click on \"(.*)\" option of Added Employer$")
	public void click_on_option_of_added_employer(String optionText) {
		manageEmployerObject.clickOnAddedEmployerRelatedLinks(employerName, optionText);
	}

	@When("^user click on \"(.*)\" option of Employer$")
	public void click_on_option_of_employer(String optionText) {
		manageEmployerObject.clickOnAddedEmployerRelatedLinks(BillingAPI.employerName, optionText);
	}

	@And("^user click on Element with Id as \"(.*)\" on the Confirmation Pop Up$")
	public void click_on_element_on_the_Confirmation_PopUp(String elementId) {
		manageEmployerObject.clickOnAnyDeleteConfirmationBoxElementById(elementId);
	}

	@Then("^Success ribbon as \"(.*)\" should be displayed$")
	public void success_ribbon_should_be_displayed(String successMsg) {
		Assert.assertTrue(manageEmployerObject.verifySuccessMessage(successMsg),
				"Success ribbon as Employer A dded is displayed !!!");

	}

	@And("user click on Save button On Employer Page")
	public void clickonSavebuttonOnEmployerPage(){
		manageEmployerObject.saveEmployer();
	}

	@Then("Verify add employer page opens with all tabs")
	public void verifyAddEmployerPageOpensWithAllTabs(DataTable allTabsOnAddEmployerPage) {
		List<String> AllTabsOnAddEmployerPage = allTabsOnAddEmployerPage.asList(String.class);
		List<String> AllTabsOnAddEmployerPageeVisible = manageEmployerObject.getNameOfAllTabsVisible();
		Assert.assertEquals(AllTabsOnAddEmployerPage, AllTabsOnAddEmployerPageeVisible);
		TestNGLogUtility.pass("[Assertion Pass]: Correct Tab name are visible");
	}

	@And("Verify sub headings of tabs present on Add Employer Page")
	public void verifySubHeadingsOfTabsPresentOnAddEmployerPage(DataTable subHeadsOfTabs) {
		List<String> SubHeadsOfTabs = subHeadsOfTabs.asList(String.class);
		List<String> SubHeadsOfTabsVisible = manageEmployerObject.getSubHeadOfAllTabsVisible();
		Assert.assertEquals(SubHeadsOfTabs, SubHeadsOfTabsVisible);
		TestNGLogUtility.pass("[Assertion Pass]: Correct Tab Sub Heads name are visible");
	}

	@And("user click on {string} tab")
	public void userClickOnTab(String tabName) {
		manageEmployerObject.clickOnTab(tabName);
	}

	@And("user click Address field and then click anywhere for textbox validation message")
	public void
	userClickAddressFieldAndThenClickAnywhereForTextboxValidationMessage() {
		manageEmployerObject.manadatoryTextFieldValidationForAddress();
	}

	@Then("verify validation message {string} for {string} should appear")
	public void verifyValidationMessageForShouldAppear(String validationMsg, String labelName) {
		Assert.assertTrue(manageEmployerObject.verifyValidationForLabelInEmployerPage(validationMsg, labelName),
				validationMsg + " is not displayed for label " + labelName);
	}

	@When("user click GSTIN field and then click anywhere for textbox validation message")
	public void userClickGSTINFieldAndThenClickAnywhereForTextboxValidationMessage() {
		manageEmployerObject.manadatoryTextFieldValidationForGSTIN();
	}

	@When("user enter (\\d+) character length in address field")
	public void userEnterCharacterLengthInAddressField(int addressLength) {
		empAddress=manageEmployerObject.fillEmployerAddress(generateRandomStrings(addressLength, "String"));
	}

	@When("user Fill {string} character in address field")
	public void userFillCharacterInAddressField(String address) {
		empAddress=manageEmployerObject.fillEmployerAddress(address);
	}

	@When("user enter GSTIN {string} code")
	public void userEnterGSTINCode(String gstin) {
		gstinString = manageEmployerObject.fillEmployerGSTIN(gstin);
	}

	@Then("Added Employer Registered Address should be displayed in the list")
	public void addedEmployerRegisteredAddressShouldBeDisplayedInTheList() {
		Assert.assertTrue(manageEmployerObject.verifyEmployerSavedDetailsisDisplayed(empAddress), "Employer Registered Address is not displayed in the list !!!");

	}

	@And("Added Employer GSTIN Code should be displayed in the list")
	public void addedEmployerGSTINCodeShouldBeDisplayedInTheList() {
		Assert.assertTrue(manageEmployerObject.verifyEmployerSavedDetailsisDisplayed(gstinString), "Employer GSTIN Code is not displayed in the list !!!");

	}

	@And("Added Employer PAN No. should be displayed in the list")
	public void addedEmployerPANNoShouldBeDisplayedInTheList() {
		Assert.assertTrue(manageEmployerObject.verifyEmployerSavedDetailsisDisplayed(gstinString.substring(2,12)), "Employer PAN Number is not displayed in the list !!!");

	}

	@When("user click on {string} checkbox")
	public void userClickOnCheckbox(String checkBoxText) {
		manageEmployerObject.click_on_Element(checkBoxText);
	}

	@And("user click on {string} icon")
	public void userClickOnIcon(String iconValue) {
		manageEmployerObject.click_on_Element(iconValue);
	}

	@Then("Added Employer GSTIN Code as Tax Exempt should be displayed in the list")
	public void addedEmployerGSTINCodeAsTaxExemptShouldBeDisplayedInTheList() {
		Assert.assertTrue(manageEmployerObject.verifyEmployerAsTaxExemptisDisplayed(gstinString.substring(2,12)), "Employer GSTIN Code is not displayed in the list !!!");
	}

	@And("user click on {string} radio button")
	public void userClickOnRadioButton(String radioText) {
		manageEmployerObject.click_on_Element(radioText);
	}

	@Then("Added Employer as Not Registered should be displayed in the list")
	public void addedEmployerAsNotRegisteredShouldBeDisplayedInTheList() {
		Assert.assertTrue(manageEmployerObject.verifyEmployerAsNotRegisteredCompanyDisplayed(empAddress), "Employer as Not Registered is not displayed in the list !!!");
	}

	@Then("Employer Address options should be displayed")
	public void employerAddressOptionsShouldBeDisplayed() {
		Assert.assertTrue(manageEmployerObject.verifyEmployerAddressOptionsAreDisplayed(),
				"Employer Address are not displayed !!!!");
	}

	@And("Added {string} as {string} must be present in the {string} field")
	public void addedAsMustBePresentInTheField(String labelName, String value, String fieldType) {
		Assert.assertTrue(manageEmployerObject.getValueOfTextAreaOrInputTextBoxInViewContainer(labelName, fieldType).contains(value), value+" is not displayed in "+labelName+" !!!!!!!!");

	}

	@Then("Add Address button should be displayed")
	public void addAddressButtonShouldBeDisplayed() {
		Assert.assertTrue(manageEmployerObject.addAddressButtonisDisplayed(), "Add Address button is not displayed !!!");

	}

	@Then("Billing options should be displayed")
	public void billingOptionsShouldBeDisplayed() {
		Assert.assertTrue(manageEmployerObject.verifyBillingOptionsareDisplayed(),
				"Billing Options are not displayed !!!!");
	}

	@When("user fill all mandatory billing details as {string} category name and {string} as flat fee")
	public void userFillAllMandatoryBillingDetailsAsCategoryNameAndAsFlatFee(String categoryName, String billingCharge) {
		manageEmployerObject.enterCategoryNameInBillingDetails(categoryName);
		manageEmployerObject.enterFlatFeeInBillingDetails(billingCharge);
	}

	@And("user click on Add button to Add New Billing Info")
	public void userClickOnAddButtonToAddNewBillingInfo() {
		manageEmployerObject.clickOnAddButtonToAddBillingInfo();
	}

	@Then("Added Employer billing category as {string} should be displayed in the list")
	public void addedEmployerBillingCategoryAsShouldBeDisplayedInTheList(String categoryName) {
		Assert.assertTrue(manageEmployerObject.verifyEmployerSavedDetailsisDisplayed(categoryName), "Employer Billing Category is not displayed !!!");

	}

	@And("Added Employer billing charge as {string} should be displayed in the list")
	public void addedEmployerBillingChargeAsShouldBeDisplayedInTheList(String billingCharge) {
		Assert.assertTrue(manageEmployerObject.verifyEmployerSavedDetailsisDisplayed(billingCharge), "Employer Billing Charge is not displayed !!!");
	}

	@And("Edit and delete button should be displayed on mousehover on saved details")
	public void editAndDeleteButtonShouldBeDisplayedOnMousehoverOnSavedDetails() {
		Assert.assertTrue(manageEmployerObject.verifyEditButtonIsDisplayedOnHover(), "Edit button is not displayed on mouse hover !!!");
		Assert.assertTrue(manageEmployerObject.verifyDeleteButtonIsDisplayedOnHover(), "Delete button is not displayed on mouse hover !!!");
	}

	@And("user click on Category Name Textbox")
	public void userClickOnCategoryNameTextbox() {
		manageEmployerObject.clickCategoryNameInBillingDetails();
	}

	@And("user fill {string} characters in Category Name Textbox")
	public void userFillCharactersInCategoryNameTextbox(String categoryName) {
		manageEmployerObject.enterCategoryNameInBillingDetails(categoryName);
	}

	@When("user fill {string} in Flat Fee Textbox")
	public void userFillInFlatFeeTextbox(String flatFee) {
		manageEmployerObject.enterFlatFeeInBillingDetails(flatFee);
	}

	@And("user click on Percentage of Salary Textbox")
	public void userClickOnPercentageOfSalaryTextbox() {
		manageEmployerObject.clickOnPercentageOfSalaryTextbox();
	}

	@And("user fill {string} in Fixed Percentage of joining salary")
	public void userFillInFixedPercentageOfJoiningSalary(String fixedPercentageJoiningSalary) {
		manageEmployerObject.enterPercentageOfJoiningSalary(fixedPercentageJoiningSalary);
	}

	@And("user fill {string} in label {string} for {string} type TextBox")
	public void userFillInLabelForTypeTextBox(String value, String labelName, String fieldType) {
		manageEmployerObject.enterTextAreaOrInputTextBoxInViewContainer(value, labelName, fieldType);
	}

	@Then("Add button should be displayed in Billing details")
	public void addButtonShouldBeDisplayedInBillingDetails() {
		Assert.assertTrue(manageEmployerObject.verifyAddbuttonIsDisplayed(), "Add button is not displayed in Billing details !!!");

	}

	@And("user fill mandatory fields of Employer Address {string} as Address and {string} as GSTIN on Add new employer page")
	public void userFillManadatoryFieldsOfAsAddressAndAdGSTINOnEmployerAddressOnAddNewEmployerPage(String address, String gstin) {
		userClickOnEmployerAddressTab();
		manageRequisitionTemplatePO.clickOnValuee("Add Address");
		userFillCharacterInAddressField(address);
		userEnterGSTINCode(gstin);
		manageGroupActionObject.clickOnBtn("ADD");
	}

	@And("user fill mandatory fields of Billing Details {string} as Category Name and {string} as flatfee on Add new employer page")
	public void userFillMandatoryFieldsOfBillingDetailsAsCategoryNameAndAsFlatfeeOnAddNewEmployerPage(String categoryName, String Flatfee) {
		userClickOnBillingDetailsTab();
		userClickOnBillingDetailsTab();
		manageGroupActionObject.clickOnBtn("ADD");
		userFillAllMandatoryBillingDetailsAsCategoryNameAndAsFlatFee(categoryName, Flatfee);
		this.categoryName=categoryName;
		this.flatfee=Flatfee;
		manageGroupActionObject.clickOnBtn("ADD");
	}

	@Then("^Added employer should be displayed$")
	public void added_employer_should_be_displayed() {
		Assert.assertTrue(manageEmployerObject.verifyEmployerNameonManageEmployerPageisDisplayed(employerName),
				"Added Employer is not displayed !!! ");
	}

	@And("Saved Billing Details should not be duplicated with {string} Category Name")
	public void savedBillingDetailsShouldNotBeDuplicatedWithCategoryName(String categoryName) {
		Assert.assertEquals(manageEmployerObject.getEmployerSavedDetailsCount(categoryName), 1, "Saved Billing Details are duplicated !!!!");

	}

	@When("User add another Billing Category with name as {string} and value as {string} and type as {string}")
	public void userAddAnotherBillingCategoryWithNameAsAndValueAsAndTypeAs(String categoryName, String value, String type) {
		commonActions.goToPageURL(YamlReader.getAppConfigValue("URLs.groupListing"));
		manageEmployerObject.clickOnAddedEmployerRelatedLinks(BillingAPI.employerName, "Edit");
		manageEmployerObject.clickBillingDetailsTab();
		manageEmployerObject.click_on_Element("Add more");
		if(type.equalsIgnoreCase("percentage")) {
			manageEmployerObject.enterCategoryNameInBillingDetails(categoryName);
			manageEmployerObject.click_on_Element("Fixed Percentage of joining salary");
			manageEmployerObject.fill_Percentage_of_Salary_in_Billing_Details(value);
			manageEmployerObject.click_on_Add_button_to_Add_New_Billing_Information();
		}else {
			manageEmployerObject.addNewBillingInformation(categoryName, value);
		}
		manageEmployerObject.saveEmployer();
	}

	@When("User remove all Billing Category")
	public void userRemoveAllBillingCategory() {
		commonActions.goToPageURL(YamlReader.getAppConfigValue("URLs.groupListing"));
		manageEmployerObject.clickOnAddedEmployerRelatedLinks(BillingAPI.employerName, "Edit");
		manageEmployerObject.clickBillingDetailsTab();
		manageEmployerObject.click_on_Element("cross");
		manageEmployerObject.clickBillingDetailsTab();
		manageEmployerObject.save_Employer_DetailsOnEmployerPage();
	}
}
