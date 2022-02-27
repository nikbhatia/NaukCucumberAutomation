package com.naukri.stepdefinitions.Settings;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.MLH.RequirementInboxPagePO;
import com.naukri.pageobjects.Settings.ManageWhiteLabelPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ManageWhiteLabelStepDefs {

	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	ManageWhiteLabelPO manageWhiteLabelPO = (ManageWhiteLabelPO) PageObjectWrapper.getObject(ManageWhiteLabelPO.class);
	RequirementInboxPagePO objRequirementInboxPagePO = (RequirementInboxPagePO) PageObjectWrapper
			.getObject(RequirementInboxPagePO.class);
	List<String> list = new ArrayList<String>();

	@When("user fill Company Name")
	public void userFillCompanyName() {
		manageWhiteLabelPO.fillCompanyName();
	}

	@When("user fill About Company")
	public void userFillAboutCompany() {
		manageWhiteLabelPO.fillAboutCompany();
	}

	@And("user choose color theme & click on save")
	public void userChooseTheme() {
		manageWhiteLabelPO.chooseTheme();
	}

	@When("I click on tab {string} on whitelabel settings")
	public void i_click_on_tab_on_whitelabel_settings(String tabText) {
		manageWhiteLabelPO.clickOnTabsOnWhiteLabelSettings(tabText);
	}

	@When("I check the checkbox with label {string}")
	public void i_check_the_checkbox_with_label(String labelText) {
		manageWhiteLabelPO.selectTheMaskingCheckbox(labelText);
	}

	@When("I click on {string} button on the footer")
	public void i_click_on_button_on_the_footer(String actionText) {
		manageWhiteLabelPO.clickOnFooterOption(actionText);
	}

	@When("I uncheck all the checkboxes with label {string}, {string}, {string}")
	public void i_uncheck_all_the_checkboxes_with_label(String settingOption1, String settingOption2,
			String settingOption3) {
		manageWhiteLabelPO.uncheckAllTheMaskingCheckbox(settingOption1, settingOption2, settingOption3);
	}

	@And("user is able to fill Custom URL for WhiteLabel Settings")
	public void fillCustomeUrlForWhiteLabelSetting(DataTable dt) {
		list = dt.asList(String.class);
		manageWhiteLabelPO.fillCustomURL(list.get(0));
		TestNGLogUtility.info("Fill Custom URL for WhiteLabel Settings");
	}

	@And("user click on remove button on white label page")
	public void clickOnRemoveButton() {
		manageWhiteLabelPO.clickRemoveButtonToDisableCustomeURL();
		TestNGLogUtility.info("Click on remove button on white label page");
	}

	@And("User verify data of {string} on white label setting page displayed")
	public void user_verify_data_on_white_label_setting_page_displayed(String elementName) {
		Assert.assertTrue(manageWhiteLabelPO.isElementOfWhiteLabelDisplayedOnThePage(elementName));
		TestNGLogUtility.pass(elementName + " data Is displayed on the page ");
	}

	@And("User verify {string} {string} custom url as prefix")
	public void user_verify_contains_custom_url_as_prefix(String pageName, String urlDisplayed) {
		if (urlDisplayed.contains("contains")) {
			Assert.assertTrue(objRequirementInboxPagePO.getPageUrl().contains(list.get(0)));
			TestNGLogUtility.pass(pageName + " " + urlDisplayed + " custom url as prefix");
		} else if (urlDisplayed.contains("does not contain")) {
			Assert.assertFalse(objRequirementInboxPagePO.getPageUrl().contains(list.get(0)));
			TestNGLogUtility.pass(pageName + " " + urlDisplayed + " custom url as prefix");
		}
	}

	@When("User enter company name as {string} and about company as {string} details from the page")
	public void user_remove_and_details_from_the_page(String companyName, String aboutCompany) {
		manageWhiteLabelPO.fillCompanyDetails(companyName, aboutCompany);
		TestNGLogUtility.info("Enter details of company name and about company");
	}

}