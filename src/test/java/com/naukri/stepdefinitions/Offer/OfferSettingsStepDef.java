package com.naukri.stepdefinitions.Offer;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Assessment.CandidateAssessmentPO;
import com.naukri.pageobjects.Offer.OfferPermissionPagePO;
import com.naukri.pageobjects.Offer.OfferSettingsPagePO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class OfferSettingsStepDef {

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	OfferSettingsPagePO offerSettings = (OfferSettingsPagePO) PageObjectWrapper.getObject(OfferSettingsPagePO.class);
	CandidateAssessmentPO cadAssessment = (CandidateAssessmentPO) PageObjectWrapper
			.getObject(CandidateAssessmentPO.class);
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	OfferPermissionPagePO offerPermission = (OfferPermissionPagePO) PageObjectWrapper
			.getObject(OfferPermissionPagePO.class);

	@Given("I login into RMS as \"([^\"]*)\"")
	public void I_login_into_RMS_as(String subscriptionType) {
		String[] userAndPass = offerSettings.getUsernameAndPasswordForOffer(subscriptionType);
		genericFunctions.loginToRMS(userAndPass[0], userAndPass[1]);
	}

	@Then("I am on the Settings page of RMS")
	public void I_am_on_the_Settings_page() {
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.settingsPage"));
	}

	@Then("I should see {string} section on settings page")
	public void I_should_see_section_on_settings_page(String offerSection) {
		offerSettings.verifyOfferSectionPresentOnSettingsPage(offerSection);
	}

	@Then("I should see {string} section just above {string} section")
	public void I_should_see_section_just_above_section(String offerSection, String manageSourcesSection) {
		offerSettings.verifyOfferSectionJustAboveManageSources(offerSection, manageSourcesSection);
	}

	@Then("I should not see {string} section on settings page")
	public void I_should_not_see_section_on_settings_page(String offerSection) {
		offerSettings.verifyOfferSectionNotPresentOnSettingsPage(offerSection);
	}

	@Then("^I should see the sub-headings and description text")
	public void I_should_see_the_sub_headings_and_description_text(DataTable dt) {
		List<String> list = dt.asList(String.class);
		for (int i = 0; i < list.size(); i++) {
			Assert.assertTrue(cadAssessment.verifyHeadings(list.get(i)),
					"Test case failed : As user is not able to see the heading " + list.get(i) + "");
		}
	}
	
	@When("I search subuser name \"([^\"]*)\"")
	public void i_search_subuser_name(String subuserType) {
		offerSettings.searchRecruiter(subuserType);
	}
	
	@When("I open the manage permissions for subuser")
	public void i_open_the_manage_permissions_for_subuser() {
		offerPermission.clickManagePermissionsToSpecificUser(offerSettings.subUser);
	}
	
	@When("I logout of RMS")
	public void i_Logout_of_RMS(){
		genericFunctions.logout();
	}
	
	@Then("I am redirected to {string} page")
	public void I_am_redirected_to_page(String pageName){
		offerSettings.checkRedirectedToPage(pageName);
	}
	
	@Then("I see a layer with {string} switch")
	public void I_see_a_layer_with_switch(String subHeading){
		offerSettings.verifyOfferLayerSubHeadingText(subHeading);
	}
	@When("click on edit signature")
	public void clickEditSignature()
	{
		offerSettings.clickEditSignature();
	}
	@When("enter text under signature body")
	public void enterTextUnderSignatureBody()
	{
		offerSettings.enterTextUnderSignatureBody();
	}
	@When("click on save signature")
	public void clickSaveSignature()
	{
		offerSettings.clickSaveSignature();
	}
	@When("select {string} as category")
	public void selectOfferRoundInTemplate(String offerRound)
	{
		offerSettings.clickCategoryDDEmailTemplate();
		offerSettings.selectOfferAndJoiningRound(offerRound);
	}
	@When("enter template name and mail body and mail subject in status change template page")
	public void enterFieldsUnderStatusChangeTemplatePage()
	{
		offerSettings.fillmandatoryFieldsStatusChangeCategory();
	}
	@When("user click on Save template")
	public void clickSaveEmailTemplate()
	{
		offerSettings.saveEmailTemplate();
	}
	
	@When("I open the manage permissions for searched subuser")
	public void openManagePermissionForUser() {
		offerSettings.openManagePermissionForUser();
	}
	
}
