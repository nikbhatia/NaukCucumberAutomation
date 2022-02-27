package com.naukri.stepdefinitions.Settings;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Settings.SettingsDashboardPO;
import com.naukri.pageobjects.Settings.SettingsDashboardPO.EditSingnaturePO;
//import com.naukri.pageobjects.Settings.AdminDashboard;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class SettingsDashboardStepDefs {

	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	SettingsDashboardPO SettingsDashboardPOObj = (SettingsDashboardPO) PageObjectWrapper
			.getObject(SettingsDashboardPO.class);
	EditSingnaturePO editSignature = (EditSingnaturePO) PageObjectWrapper.getInnerClassObject(SettingsDashboardPO.class, EditSingnaturePO.class);
	
	HashMap<String, String> testCredits = new HashMap<String, String>();

	@And("\"([^\"]*)\" user is on Settings Page with \"([^\"]*)\"$")
	public void userNavigationToRMSSettings(String subscriptionType, String userType) {
		String userName = "Settings." + subscriptionType + "." + userType;
		String password = "Settings.Password";
		genericFunction.loginToRMS(getAppConfigValue("URLs.RMSSettings"), getAppConfigValue(userName),
				getAppConfigValue(password));

	}

	@Then("user is able to see all sub headings on settings page")
	public void ableToSeeAllSubHeadingsOnSettingsPage(DataTable allSubHeadingsTable) {
		List<String> allSubHeadingsName = allSubHeadingsTable.asList(String.class);
		List<String> allSubHeadingsNameVisible = SettingsDashboardPOObj.getNameOfAllSettingsAsSubHead();
		Assert.assertEquals(allSubHeadingsName, allSubHeadingsNameVisible);
		TestNGLogUtility.pass("[Assertion Pass]: Correct Sub Headings name are visible on Settings Page");
	}

	@Then("user is able to see all settings name on setting page")
	public void ableToSeeAllSettingsName(DataTable allSettingsTable) {
		List<String> allSettingsName = allSettingsTable.asList(String.class);
		List<String> allSettingsNameVisible = SettingsDashboardPOObj.getNameOfAllSettings();
		Assert.assertEquals(allSettingsName, allSettingsNameVisible, "correct settings name are not visible");
	}

	@When("I navigate to the whitelabel settings.")
	public void i_navigate_to_the_whitelabel_settings() {
		SettingsDashboardPOObj.clickOnWhiteLabelSettings();
	}

	@When("User clicks on Customize the Selection Process on settings page")
	public void user_clicks_on_Customize_the_Selection_Process_on_settings_page() {
		SettingsDashboardPOObj.clickOnSelectionStage();
	}
	
	@Then("User should be able to see a pop up with heading {string}")
	public void user_should_be_able_to_see_a_pop_up_with_heading(String expectedHeadingString) {
	    Assert.assertTrue(editSignature.verifyThePresenceOfSignatureLightbox(expectedHeadingString), 
	    		expectedHeadingString + " is not visible on the lightbox");
	    TestNGLogUtility.pass(expectedHeadingString + " is visible on the lightbox");
	}

	@When("User records the signature from the popup")
	public void user_records_the_signature_from_the_popup() {
	    editSignature.getRecruiterSignature();
	}
	

	@When("User click on {string} link on settings page")
	public void user_click_on_link_on_settings_page(String nameOfFeature) {
		SettingsDashboardPOObj.clickOnSettingsPageLink(nameOfFeature);
	}

}
