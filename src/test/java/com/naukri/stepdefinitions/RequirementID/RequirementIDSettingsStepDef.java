package com.naukri.stepdefinitions.RequirementID;

import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.HiringManager.RaiseRequisitionPagePO;
import com.naukri.pageobjects.HiringManager.RequirementPagePO;
import com.naukri.pageobjects.RequirementID.RequirementIDSettingsPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class RequirementIDSettingsStepDef {
	RequirementIDSettingsPO requirementIDSettingsPO = (RequirementIDSettingsPO) PageObjectWrapper
			.getObject(RequirementIDSettingsPO.class);
	RaiseRequisitionPagePO raiseRequisitionPagePO = (RaiseRequisitionPagePO) PageObjectWrapper
			.getObject(RaiseRequisitionPagePO.class);
	RequirementPagePO requirementPagePO = (RequirementPagePO) PageObjectWrapper.getObject(RequirementPagePO.class);
	SoftAssert softAssert = new SoftAssert();

	@Then("User should be able to see {string} heading of the page")
	public void verifyManageRequirementPageHeading(String pageTitleTxt) {
		Assert.assertTrue(requirementIDSettingsPO.verifyManageRequirementPageHeading(pageTitleTxt),
				"Title does not match.");
	}

	@And("User should be able to see {string} sub-heading of the page")
	public void verifyManageRequirementPageSubHeading(String pageSubTitleTxt) {
		Assert.assertTrue(requirementIDSettingsPO.verifyManageRequirementPageSubHeading(pageSubTitleTxt),
				"SubTitle does not match.");
	}

	@And("User clicks {string} button")
	public void clickButton(String btnTxt) {
		requirementIDSettingsPO.clickBtn(btnTxt);
	}

	@Then("User should see {string} on settings page")
	public void verifySettingsVisible(String settingsText) {
		Assert.assertTrue(requirementIDSettingsPO.verifySettingsVisibility(settingsText),
				"Settings text is not present on the page.");
	}

	@Then("User should be able to see all components on Manage Requirement ID page")
	public void verifyComponentsOnManageRequirementIDPage(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(requirementIDSettingsPO.verifyComponentsOnManageRequirementIDPage(list),
				"Components are not same on the page.");

	}

	@When("User click on the {string} dropdown on Req ID page")
	public void clickDDonReqIDPage(String ddTxt) {
		requirementIDSettingsPO.clickDDonReqIDPage(ddTxt);
	}

	@Then("User should be able to see all options for Component dropdown")
	public void verifyOptionsInTextComponentDD(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(requirementIDSettingsPO.verifyOptionsInDD(list), "Options are not same for the dropdown");
	}

	@And("User enters {string} as Company Name")
	public void enterTxtInCompanyName(String companyNameTxt) {
		requirementIDSettingsPO.enterTxtInCompanyName(companyNameTxt);
	}

	@And("User clicks Save button on White Label Settings")
	public void clickSaveBtnOnWhiteLabelSettings() {
		requirementIDSettingsPO.clickSaveBtnOnWhiteLabelSettings();
	}

	@And("User select {string} from dropdown on Req ID Settings")
	public void clickOnValueFromDDonReqIDSettings(String ddTxt) {
		requirementIDSettingsPO.clickOnValueFromDD(ddTxt);
	}

//	@Then("User should see {string} in sample Requirement ID")
//	public void verifyStrInSampleReqID(String str) {
//		Assert.assertTrue(requirementIDSettingsPO.verifyStrInSampleReqID(str),
//				"String not present in sample Requirement ID");
//	}

	@Then("User should be able to see {string} link on Requirement ID Settings page")
	public void verifyLinkOnRequirementIDSettingsPage(String linkTxt) {
		Assert.assertTrue(requirementIDSettingsPO.verifyLinkOnRequirementIDSettingsPage(linkTxt),
				"Link is not present on Requirement ID Settings page.");
	}

	@And("User click on Review group name initials link")
	public void clickReviewGroupNameInitialsLink() {
		requirementIDSettingsPO.clickReviewGroupNameInitialsLink();
	}

	@When("User change Group Initials of first group on Edit Group initials pop-up")
	public void editGrpInitialsoOfFirstGrp() {
		requirementIDSettingsPO.editGrpInitialsOfFirstGrp(GenericFunctions.generateRandomStrings(3, "String"));
	}
	
	@Then("User should be able to save the group initials")
	public void verifyGroupInitialsPopUpClosed() {
		Assert.assertTrue(requirementIDSettingsPO.verifyGroupInitialsPopUpClosed(),
				"Group initials not saved, popup is not closed.");
	}
	
	@Then("User should be able to see text field in {string} on Requirement ID page")
	public void verifyTextfieldIsDisplayedOnReqIdPage(String componentStr) {
		Assert.assertTrue(requirementIDSettingsPO.verifyTextfieldIsDisplayedOnReqIdPage(componentStr),
				"Text field is not visible for the component: " + componentStr);
	}
	
	@Then("User should see validation message {string} for the text field")
	public void verifyValidationMsgForTxtFieldOnReqIdPage(String validationMsg) {
		Assert.assertTrue(requirementIDSettingsPO.verifyValidationMsgForTxtFieldOnReqIdPage(validationMsg),
				"Validation msg for text field not visible");
	}
	
	@When("User enters {int} {string} character in Text field for {string} in Req ID page")
	public void enterCharInTextFieldInReqIdPage(int noOfChar, String typeOfChar, String txtField){
		requirementIDSettingsPO.enterCharInTextFieldInReqID(GenericFunctions.generateRandomStrings(noOfChar, typeOfChar), txtField);
	}
	
	@Then("User should be able to see sample id contains characters entered in {string} Text field")
	public void verifySampleIdHasTxtEnteredInTxtField(String componentTxt) {
		Assert.assertTrue(requirementIDSettingsPO.verifySampleIdHasTxtEnteredInTxtField(componentTxt),
				"Sample Id does not have text entered in " + componentTxt + "text field");
	}
	
	@Then("User should not be able to see {string} in Sample ID")
	public void verifySampleIdNotHaveComponent(String componentTxt) {
		Assert.assertTrue(requirementIDSettingsPO.verifySampleIdNotHaveComponent(componentTxt),
				"Sample Id has text from " + componentTxt);
	}
	
	@Then("User should see checkbox with text on Req Id page")
	public void verifyCheckboxTxtOnReqIDPage(DataTable dt) {
		List<String> list = dt.asList(String.class);
		softAssert.assertTrue(requirementIDSettingsPO.verifyCheckboxTxtOnReqIDPage(list), "Texts do not match the checkbox.");
	}
	
	@Then("User should see {string} in Sample ID for {string}")
	public void verifySubComponentInSampleId(String subYearComponent, String Component) {
		softAssert.assertTrue(requirementIDSettingsPO.verifySubComponentInSampleId(Component, subYearComponent), "Sample ID does not have value");
		softAssert.assertAll();
	}
	
	@Then("User should see values entered in the components in Sample Requirement ID")
	public void verifySampleRequirementId(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(requirementIDSettingsPO.verifySampleRequirementId(list), "Sample Requirement ID does not contain the selected componenets");
	}
	
	@Then("User should see values entered in the components in Sample Requisition ID")
	public void verifySampleRequisitionId(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(requirementIDSettingsPO.verifySampleRequisitionId(list), "Sample Requisition ID does not contain the selected componenets");
	}
	
	@Then("User should see buttons on Requirement ID page")
	public void verifyButtonOnRequirementId(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(requirementIDSettingsPO.verifyButtonOnRequirementId(list), "Buttons not visible on Requirement ID page.");
	}
	
	@And("save Sample Requirement ID and Requisition ID")
	public void saveSampleRequirementNRequisitionIdToPropertiesFile() {
		requirementIDSettingsPO.saveSampleRequirementNRequisitionIdToPropertiesFile();
	}
	
	@Then("User should see same Sample Requirement ID and Requisition ID")
	public void verifySameSampleIds() {
		Assert.assertTrue(requirementIDSettingsPO.verifySameSampleIds(), "Sample Requirement ID and Requisition ID are not same.");
	}
	
	@Then("User should see {string} message in snackbar on Settings page")
	public void verifyMsgOnSnackBarOnSettingsPage(String msgOnSnackBar) {
		Assert.assertTrue(requirementIDSettingsPO.verifyMsgOnSnackBarOnSettingsPage(msgOnSnackBar), "Snack bar not displayed on Settings page.");
	}
	
	@Then("User sees cancel confirmation box")
	public void verifyCancelConfirmationBoxIsDisplayed() {
		Assert.assertTrue(requirementIDSettingsPO.verifyCancelConfirmationBoxIsDisplayed(), "Cancel Confirmation box is not displayed");
	}
	
	@Then("User should be directed to {string}")
	public void verifyUserDirectedToPage(String url) {
		Assert.assertTrue(requirementIDSettingsPO.verifyUserDirectedToPage(YamlReader.getAppConfigValue("URLs." + url)), "User not directed to page.");
	}
	
	@Then("User should see {string} msg on Requirement Id page")
	public void verifyMsgOnReqIdPage(String msg) {
		Assert.assertTrue(requirementIDSettingsPO.verifyMsgOnReqIdPage(msg), "Message not displayed on Requirement ID page.");
	}
	
	@And("User makes the Group Initials of first two groups same")
	public void makeFirstTwoGroupInitialsSame(){
		requirementIDSettingsPO.makeFirstTwoGroupInitialsSame();
	}
	
	@Then("User should see {string} lightbox on Req Id page")
	public void verifyLightBoxOnReqIdPage(String lightBoxText) {
		Assert.assertTrue(requirementIDSettingsPO.verifyLightBoxOnReqIdPage(lightBoxText), "Light box not visible on Requirement ID page.");
	}
	
	@And("User clears Default Group Intials")
	public void clearDefaultGroupInitials(){
		requirementIDSettingsPO.clearDefaultGroupInitials();
	}
	
	@And("User sets Default Group Initials")
	public void setDefaultGroupInitials(){
		requirementIDSettingsPO.setDefaultGroupInitials();
	}
	
	@When("User sets same Group Initials as Default Group Initials for a group")
	public void setSameGroupInitialsAsDefaultGroupInitials(){
		requirementIDSettingsPO.setSameGroupInitialsAsDefaultGroupInitials();
	}
	
	@Then("User should see {string} message on Group Initials lightbox")
	public void verifyMsgOnGroupInitialsLightBox(String msg) {
		Assert.assertTrue(requirementIDSettingsPO.verifyMsgOnGroupInitialsLightBox(msg), "Message on Group Initials not visible");
	}
	
	@Then("Verify User see same Requisition Id as set in Settings in Success Message on Requisition Listing")
	public void verifyRequisitionIdInSuccessMsg() {
		Assert.assertTrue(requirementIDSettingsPO.verifyRequisitionIdInSuccessMsg(), "Requisition Creation success message does not contain Requisition ID set from settings");
	}
	
	@When("User creates requisition with no approval process and first group in DD")
	public void createRequisitionWithNoApprovalAndFirstGroupInDD(){
		raiseRequisitionPagePO.createRequisitionWithNoApprovalAndFirstGroupInDD();
	}
	@Then("verify requisition is created with requisition id set on listing page")
	public void verifyRequisitionIsCreatedWithId()
	{
		Assert.assertTrue(requirementIDSettingsPO.verifyRequisitionIsCreatedWithIdOnListingPage(),"Requisition is not created with requisition id");
	}
	
	@When("User creates requirement for raised requisition using Requisition ID")
	public void createRequirementForRequisitionUsingRequisitionId(){
		requirementPagePO.createRequirementFromRequisition(requirementIDSettingsPO.getRequisitionIdFromPropertiesFile());
	}
	
	
	@Then("Verify User see same Requirement ID as set in Settings on {string}")
	public void verifyRequirementIDSameAsSetInSettings(String page) {
		Assert.assertTrue(requirementIDSettingsPO.verifyRequirementIDSameAsSetInSettings(page), "Requirement ID is not same as set in Settings");
	}
	
	@And("User search for candidate added using email ID")
	public void searchCandidateOnSrpUsingEmailId(){
		requirementIDSettingsPO.searchCandidateOnSrpUsingEmailId();
	}
	
	@When("User select first group in DD on requisition")
	public void User_select_first_group_in_DD_on_requisition(){
		raiseRequisitionPagePO.selectFirstGroupInDD();
	}

	@When("user searches for the requisition with requisition id")
	public void userSearchedRequisitionWithRequisitionID()
	{
		raiseRequisitionPagePO.userSearchedRequisitionWIthID();
	}
	@Then("verify requisition is searched based on requisition id")
	public void verifyRequisitionSearchableFRomId()
	{
		Assert.assertTrue(raiseRequisitionPagePO.verifyRequisitionSearchableFromID(),"rquisition is not searchable from id");
	}

	
}