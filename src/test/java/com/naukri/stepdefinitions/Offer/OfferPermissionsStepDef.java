package com.naukri.stepdefinitions.Offer;

import org.testng.Assert;

import com.naukri.automation.util.JSUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Applications.SendAMessagePagePO;
import com.naukri.pageobjects.Offer.OfferPermissionPagePO;

import com.naukri.automation.util.GenericFunctions;

import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OfferPermissionsStepDef {

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	SendAMessagePagePO sendMessage = (SendAMessagePagePO) PageObjectWrapper.getObject(SendAMessagePagePO.class);
	OfferPermissionPagePO offerPermissionPagePO = (OfferPermissionPagePO) PageObjectWrapper
			.getObject(OfferPermissionPagePO.class);

	@When("I navigate to Settings page")
	public void i_navigate_to_Settings_page() {
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.settingsPage"));
	}

	@When("I navigate to Open Manage Permissions for any recruiter")
	public void i_navigate_to_Open_Manage_Permissions_for_any_recruiter() {
		offerPermissionPagePO.clickOnManagePermissionForASubuser(1);
	}

	@When("I select {int} sub recruiter")
	public void i_select_sub_recruiter(int index) {
		offerPermissionPagePO.clickOnManagePermissionForASubuser((index + 1));
	}

	@When("I navigate to {string} Open Manage Permissions for any recruiter")
	public void i_navigate_to_Open_Manage_Permissions_for_any_recruiter(String subscriptionType) {
		offerPermissionPagePO.clickOnManagePermissions(subscriptionType);
	}

	@Then("I should not be able to see {string} in manage permission light box")
	public void i_should_not_be_able_to_see_in_manage_permission_light_box(String offerPermissionName) {
		Assert.assertTrue(offerPermissionPagePO.checkForAbsenceOfOfferPermission(offerPermissionName),
				"The offer permission is visible");
	}

	@Then("I should be able to see {string} in manage permission light box")
	public void i_should_be_able_to_see_in_manage_permission_light_box(String offerPermissionText) {
		offerPermissionPagePO.scrollDownToOfferPermissionText(offerPermissionText);
		Assert.assertTrue(offerPermissionPagePO.checkForPresenceOfOfferPermission(offerPermissionText),
				"The offer permission is not visible");
	}

	@When("I turn the {string} permission button to {string}")
	public void i_turn_the_permission_button_to(String permissionName, String statusOfPermission) {
		offerPermissionPagePO.changeStatusOfUserPermission(permissionName, statusOfPermission);
	}

	@When("I login into RMS as an {string} subuser")
	public void i_login_into_RMS_as_an_subuser(String subscriptionType) {
		genericFunctions.logout();
		genericFunctions.setUsernameAndPassword(subscriptionType, "Subuser");
	}

	@Then("I am able to see View Offer Letter Cluster on the application inbox")
	public void i_am_able_to_see_View_Offer_Letter_Cluster_on_the_application_inbox() {
		Assert.assertTrue(!offerPermissionPagePO.offerLetterClusterVisibility(),
				"The offer letter cluster is visible on the subuser page");
	}

	@When("I search subuser name")
	public void i_search_subuser_name() {
		offerPermissionPagePO.searchRecruiter();
	}

	@When("I open the manage permissions for searched recruiter")
	public void i_open_the_manage_permissions_for_searched_recruiter() {
		offerPermissionPagePO.clickManagePermissionsToSpecificUser(offerPermissionPagePO.subusername);
	}

	@Then("I am not able to see View Offer Letter Cluster on the application inbox")
	public void i_am_not_able_to_see_View_Offer_Letter_Cluster_on_the_application_inbox() {
		Assert.assertTrue(!offerPermissionPagePO.offerLetterClusterVisibility(),
				"The offer letter cluster is visible when the permission is off");
	}

	@When("I change the status of the candidate to offer")
	public void i_change_the_status_of_the_candidate_to_offer() {
		offerPermissionPagePO.clickChangeStatusOuterArrow();
	}

	@Then("I won{string}s status to Offer Stage")
	public void i_won_s_status_to_Offer_Stage(String string) {
		Assert.assertTrue(offerPermissionPagePO.checkOfferStageIsDisabled(), "Offer Stage is not disabled");
	}

	/*@When("I am on the application inbox page")
	public void i_am_on_the_application_inbox_page() {
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.applicationInbox"));
	}*/

	/*@When("I am on CV details page for the first candidate")
	public void i_am_on_CV_details_page_for_the_first_candidate() {
		sendMessage.clickOnFirstCandidate();
	}*/

	@Then("I click \"([^\"]*)\" link on Settings page")
	public void i_click_link_on_Settings_page(String string) {
		genericFunctions.clickLinkUsingText(string);
	}

	@SuppressWarnings("static-access")
	@Then("I add sub-stage to Offer Round")
	public void i_add_sub_stage_to_Offer_Round() {
		offerPermissionPagePO.addSubStageToOfferRound(genericFunctions.generateRandomStrings(6, "String"));
	}

	@Then("I check the first Candidate checkbox and click Change Status")
	public void i_check_the_first_Candidate_checkbox_and_click_Change_Status() {
		offerPermissionPagePO.checkFirstCandidateCheckbox();
		offerPermissionPagePO.clickChangeStatus();
	}

	@Then("I am able to see new sub-stage in Update Status dropdown")
	public void i_am_able_to_see_new_sub_stage_in_Update_Status_dropdown() {
		Assert.assertTrue(offerPermissionPagePO.checkNewSubStageInUpdateStatusDropdown(),
				"New sub-stage not added to Offer Stage");
	}

	@Then("I am able to see new sub-stage in status change drop down")
	public void i_am_able_to_see_new_sub_stage_in_status_change_drop_down() {
		Assert.assertTrue(offerPermissionPagePO.checkNewSubStageInStatusChangeDropdown(),
				"New sub-stage not added to Offer Stage");
	}

	@Then("I delete the created sub-stage for Offer Round")
	public void i_delete_the_created_sub_stage_for_Offer_Round() {
		offerPermissionPagePO.deleteSubStageFromOfferRound();
		genericFunctions.clickLinkUsingText("Delete from entire System");
	}
	@When("click on offer stage and uncheck the second stage on offer and joining stage")
	public void uncheckSecondStageOnOfferStage()
	{
		offerPermissionPagePO.clickOnOfferStageOnSettingsPage();
		offerPermissionPagePO.uncheckSecondStageOnOffer();
	}
	@When("click on offer stage and check the first stage on offer and joining stage")
	public void checkFirstStageOnOfferSelectionStages()
	{
		offerPermissionPagePO.clickOnOfferStageOnSettingsPage();
		offerPermissionPagePO.checkFirstStageOnOfferSelectionStages();
	}
}
