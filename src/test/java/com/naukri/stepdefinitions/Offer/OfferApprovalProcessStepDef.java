package com.naukri.stepdefinitions.Offer;

import java.util.List;

import org.testng.Assert;

import com.naukri.pageobjects.Offer.OfferApprovalProcessPO;
import com.naukri.pageobjects.Offer.OfferSettingsPagePO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class OfferApprovalProcessStepDef {
	OfferApprovalProcessPO offerApprovalObject = (OfferApprovalProcessPO) PageObjectWrapper.getObject(OfferApprovalProcessPO.class);
	OfferSettingsPagePO offerSettings = (OfferSettingsPagePO) PageObjectWrapper.getObject(OfferSettingsPagePO.class);

	@When("click on Add New offer Template")
	public void clickOnAddNewOfferTemplate() {
		offerApprovalObject.clickAddNewApprovalTemplate();
	}

	@When("Enter offer approval template name")
	public void enterOfferApprovalTemplateName() {
		offerApprovalObject.enterApprovalName();
	}

	@When("Enter stage name {string}")
	public void enterStageName(String stageName1) {
		offerApprovalObject.enterStageName(stageName1);
	}

	@When("Enter two approvers {string} and {string}")
	public void enterTwoApprovers(String approver1, String approver2) {
		offerApprovalObject.enterApproversInStageOne(approver1, approver2);
	}

	@When("Enter one approver {string}")
	public void enterOneApproverInStage(String approver) {
		offerApprovalObject.enterOneApproverInStageOne(approver);
	}

	@When("Click on save template")
	public void clickOnSaveTemplate() {
		offerApprovalObject.clickOnSaveApprovalTemplate();
	}

	@Then("verify approval process is displayed under selected tab")
	public void verifyApprovalProcessDisplayedUnderSelectedTab() {
		Assert.assertTrue(offerApprovalObject.verifyApprovalTemplateIsDisplayedUnderSelectedTab(),
				"created template is not displayed under selected tab");
	}

	@When("click on add approval stage")
	public void clickOnAddApprovalStage() {
		offerApprovalObject.clickOnAddApprovalStage();
	}

	@When("Enter second stage name {string}")
	public void enterSecondStageName(String stageName) {
		offerApprovalObject.enterSecondStageName(stageName);
	}

	@When("Enter one approver in stage2 {string}")
	public void enterOneApproverInStage2(String approverName) {
		offerApprovalObject.enterOneApproverInStage2(approverName);
	}

	@When("click on selected tab")
	public void clickOnSelectedTab() {
		offerApprovalObject.clickOnSelected();
	}

	@When("click on preview of template created on group lightbox")
	public void clickOnPreviewOfTemplate() {
		offerApprovalObject.clickOnViewTemplate();
	}

	@Then("approvers are displayed under approval template")
	public void verifyApproversDisplayedUnderTemplate(DataTable dt) {
		List<String> list = dt.asList(String.class);
		Assert.assertTrue(offerApprovalObject.verifyApproversDisplayedUnderTemplate(list),
				"approvers not displayed under template");

	}

	@Then("verify {string} is displayed")
	public void verifyApprovalMandatoryDisplayed(String approvalMandatory) {
		Assert.assertTrue(offerApprovalObject.verifyApprovalMandatoryDisplayed(approvalMandatory),
				"approval mandatory from everyone is not displayed");
	}

	@Then("{string} tab should not be visible")
	public void manageApprovalProcessTabVisible(String approvalTab) {
		Assert.assertFalse(offerApprovalObject.manageApprovalProcessTabIsDisplayed(approvalTab),
				"manage approval tab is displayed in other accounts other tham enterprise");
	}

	@Then("{string} section on settings page")
	public void TextOnSettingsPage(String textSettingsPage) {
		Assert.assertTrue(offerApprovalObject.textOnSettingsPage(textSettingsPage),
				"text not displayed correctly on settings page");
	}

	@When("click on add new approval template")
	public void clickOnAddNewApprovalTemplate() {
		offerApprovalObject.clickOnAddNewApprovalTemplate();
	}

	@When("Enter one approval template name")
	public void enterOneApprovalTemplateName() {
		offerApprovalObject.enterApprovalName();
	}

	@When("select first group under offer approval")
	public void selectFirstGroupUnderOfferApproval() {
		offerApprovalObject.selectFirstGroupUnderOfferApproval();
	}

	@When("select one template under prefill from existing approval process")
	public void selectOneTemplateUnderPrefillFromExisting() {
		offerApprovalObject.selectOneTemplateunderPrefillFromExisting();
	}

	@Then("verify stage name {string} and its approvers {string} and {string} should be displayed")
	public void verifyStageNameApproversInPrefillList(String stageName, String approver1, String approver2)
	{
		Assert.assertTrue(offerApprovalObject.verifyApproversListAndStageNameInPrefillExisting(stageName,approver1,approver2),"stage name and approvers displayed on prefill not correct");
	}
	@When("user {string} approval template")
	public void userDeletedApprovalTemplate(String deleteBtn)
	{
		offerApprovalObject.deleteApprovalTemplateListingPage(deleteBtn);
	}
//	@Then("template deleted should be displayed on lightbox")
//	public void templateDeletedDisplayedOnLightBox()
//	{
//		Assert.assertTrue(offerApprovalObject.templateDisplayedOnDeleteLightbox(),"incorrect template name is displayed on lightbox");
//	}
	@Then("approval template should not be displayed on approval listing page")
	public void approvalTemplateNotDisplayedListingPage()
	{
		Assert.assertFalse(offerApprovalObject.templateDeletedListingPage(),"template is still displayed on listing page");
	}
	@Then("{string} should be displayed")
	public void templateDeletedStripListingPage(String textOnStrip)
	{
		Assert.assertTrue(offerApprovalObject.templateDeletdStriplistingPage(textOnStrip),"template deleted but confirmation strip not displayed on listing page");
	}
	
	@When("user clicks on {string} approval template")
	public void clickEditApprovalTemplate(String editBtn)
	{
		offerApprovalObject.clickEditApprovalTemplate(editBtn);
	}
	@When("user clicks on {string} to preview approval template")
	public void clickPreviewApprovalTemplate(String preview)
	{
		offerApprovalObject.clickPreviewTemplate(preview);
	}
	@Then("approval template preview should be displayed ie stage {string} and approver {string} , {string} and approver {string}")
	public void previewApprovalTemplate(String stage1, String approver1, String stage2, String approver2)
	{
		Assert.assertTrue(offerApprovalObject.verifyPreviewApprovalTemplate(stage1,approver1,stage2,approver2),"stage and approvers not displayed in preview");
	}
	@When("enter approval template name on search bar")
	public void enterApprovalTemplateName()
	{
		offerApprovalObject.enterApprovalTemplateName();
	}
	@Then("verify {string} should be displayed")
	public void verifyNoSelectedTemplateVisible(String noResultsFound)
	{
		Assert.assertTrue(offerApprovalObject.verifyNoSelectedTemplateVisible(noResultsFound),"No approval Template selected is displayed");
	}
	@When("get total no of groups present in the system")
	public void totalGroupsInSystem()
	{
		offerApprovalObject.getTotalGroups();
	}
	@When("click on Assign to groups for Offer Approval DD")
	public void clickAssignToGroupsForOfferApproval()
	{
		offerApprovalObject.clickAssignToGroupsForOfferApproval();
	}
	@Then("verify count of groups displayed under DD")
	public void verifyCountOfGroupsOnOfferDD()
	{
		Assert.assertTrue(offerApprovalObject.verifyCountOfGroupsOnOfferDD(),"count of groups doesnt not match on add approval lightbox");
	}
	@When("get total no of approval templates visible")
	public void getTotalApprovalTemplates()
	{
		offerApprovalObject.getTotalApprovalTemplates();
	}
	@Then("verify count of approval templates visible")
	public void verifyCountApprovalTemplates()
	{
		Assert.assertTrue(offerApprovalObject.verifyCountApprovalTemplates(),"count of approval templates not displayed correctly");
	}
	@Then("verify group name and under Applied on Offers should be displayed")
	public void verifyGroupNameAndAppliedOn()
	{
		Assert.assertTrue(offerApprovalObject.verifyGroupNameAndAppliedOn(),"group name on manage approval listing page is not displayed correctly");
	}
	@When("Enter one approver as \"([^\"]*)\"")
	public void enterOneApproverInStageAsPerSubscription(String subscriptionType) {
		String[] userAndPass = offerSettings.getUsernameAndPasswordForOffer(subscriptionType);
		offerApprovalObject.enterOneApproverInStageOne(userAndPass[0]);
	}
	
	@When("Enter one approver in stage2 as {string}")
	public void enterOneApproverInStage2AsPerSubscription(String subscriptionType) {
		String[] userAndPass = offerSettings.getUsernameAndPasswordForOffer(subscriptionType);
		offerApprovalObject.enterOneApproverInStage2(userAndPass[0]);
	}
	
	@And("I save {string} Offer template name")
	public void I_save_Offer_template_name(String firstOrSecond) {
		offerApprovalObject.saveTemplateNameToPropertyFile(firstOrSecond);
	}
	@Then("{string} should be displayed on offer timeline")
	public void StatusOnOfferTimeline(String status)
	{
		Assert.assertTrue(offerApprovalObject.StatusOnTimeline(status),"offer status not displayed");
	}
	@When("I click on update on the bulk status layer")
	public void clickUpdateBulkStatusLayer()
	{
		offerApprovalObject.clickUpdateBulkStatusLayer();
	}
}


