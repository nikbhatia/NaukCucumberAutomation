package com.naukri.stepdefinitions.Requisition;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Requisition.ApprovalTemplateListingPO;
import com.naukri.pageobjects.Requisition.ApprovalTemplateListingPO.AddNewApprovalTemplate;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class TemplateListingStepDef {

    public String approvalTemplateName = "nikhil" + System.currentTimeMillis();
    public String approvalStageName = "Stage" + System.currentTimeMillis();
    public String approverEmail = approvalTemplateName + "yopmail.com";
    public String flag = "group";
    public String settingsPage = "URLs.RMSSettings";
    public String templateListingPage = "URLs.approvalTemplateListing";

    // Static text for search
    public String templateName;
    public String highlightedText = "Approval";
    public String threeWordsSearch = "App";
    public String searchableTemplate = "Approval-Test";
    public String invalidTemplate = "q12";
    public String validGroupName = "Requisition-Approval";
    public String pageTitle = "Manage approval workflow";


    ApprovalTemplateListingPO templateListing = (ApprovalTemplateListingPO) PageObjectWrapper.getObject(ApprovalTemplateListingPO.class);
    AddNewApprovalTemplate addNewApprovalTemplatePO = (AddNewApprovalTemplate) PageObjectWrapper.getInnerClassObject(ApprovalTemplateListingPO.class, AddNewApprovalTemplate.class);

    @Then("I navigate to template listing page.")
    public void openTemplateListingPage() {
        templateListing.openSpecificURL(templateListingPage);
    }

    @And("Verify that title on template listing page is Manage Approval workflow.")
    public void verifyTitle() {
        Assert.assertEquals(templateListing.getApprovalTemplateListingPageTitle(), pageTitle, "[Assertion Fail]: Template listing title is not correct");
        TestNGLogUtility.pass("Template listing title is correct");
    }

    @Then("I click on search button by filling valid template on template listing page")
    public void clickOnSearch() {
        templateListing.searchTemplate(searchableTemplate);
    }

    @And("Verify template with same text searched is displayed.")
    public void verifyTemplateDisplayed() {
        Assert.assertEquals(templateListing.getFirstHighlightedText(), searchableTemplate, "[Assertion Fail]: Template with same text searched is not displayed.");
        TestNGLogUtility.pass("Template with same text searched is displayed.");
    }

    @When("I click on search button with template that does not exist for the client")
    public void searchInvalidTemplate() {
        templateListing.searchTemplate(invalidTemplate);
    }

    @Then("I see Template not found with clear link")
    public void verifyTemplateNotFound() {
        Assert.assertTrue(templateListing.getTemplateNotFoundIsDisplayed(),"Not Found Text does not disappear");
        TestNGLogUtility.pass("Template not found with clear link.");
    }

    @Then("I click on clear button")
    public void clickOnClearButton() {
        templateListing.clickOnClearLink();
    }

    @And("Verify that after clicking on clear button it redirects to template listing page.")
    public void verifyRedirectionToTemplateListingPage() {
        Assert.assertEquals(templateListing.getPageUrl(), YamlReader.getAppConfigValue(templateListingPage));
        TestNGLogUtility.pass("Template Listing Page Opens up");
    }

    @Then("I click on search button by filling valid Group on template listing page")
    public void searchGroupMappedWithTemplate() {
        templateListing.selectGroupFromSuggestionInSearch(validGroupName);
    }

    @And("verify that the text with the search keyword if exist in groups should be highlighted and listed on Page in tuples.")
    public void verifyHighlightedGroupOnSearch() {
        Assert.assertTrue(templateListing.highlightedTemplateResultsIsDisplayed(validGroupName),"search keyword is not highlighted  ");
        TestNGLogUtility.pass("Groups are Highlighted on search");

    }

    @Then("I search with text that exist.")
    public void searchTemplate() {
        templateListing.searchTemplate(highlightedText);
    }

    @And("verify that the text with the search keyword if exist in Template should be highlighted and listed on Page in tuples.")
    public void verifyHighlightedTemplatesOnSearch() {
        Assert.assertTrue(templateListing.highlightedTemplateResultsIsDisplayed(highlightedText),"Template is not highlighted");
        TestNGLogUtility.pass("Templates are Highlighted on search");
    }

    @When("I search with text by typing first three words irrespective of template or group")
    public void searchFunctionalityThreeWords() {
        templateListing.fillSearchTextBox(threeWordsSearch);
    }

    @Then("i see link to the templates and groups in the search bar")
    public void verifyLinkOnSearchBar() {
        Assert.assertTrue(templateListing.getSuggestionLinkForTemplateIsDisplayed(),"link to the templates and groups in the search bar are not visible");
        TestNGLogUtility.pass("link to the templates and groups in the search bar");
    }

    @Then("i click on any of the results")
    public void clickOnResults() {
        templateListing.clickOnAllResultsSuggestionLink();
    }

    @And("Verify it shows the result with template that you clicked.")
    public void verifyResultOnClick() {
        Assert.assertTrue(templateListing.highlightedTemplateResultsIsDisplayed(threeWordsSearch),"threeWordsSearch not working three words in search are not highlighted in the tuples");
        TestNGLogUtility.pass("shows the result with template that you clicked.");
    }

    @Then("I click on preview in the first tuple.")
    public void clickOnPreview() {
        templateListing.clickOnPreviewButtonUnderTemplateTuple();
    }

    @And("Verify template preview is visible")
    public void verifyPreview() {
        Assert.assertTrue(templateListing.getTemplateInfoPreview(),"Preview not visible ");
        TestNGLogUtility.pass("template preview is visible");
    }

    @Then("i see list of templates and on first tuple i click on delete button")
    public void clickOnDeleteButton() {
        templateName = templateListing.getFirstTemplateName();
        templateListing.clickOnDeleteFirstTemplateTuple();
    }

    @And("Verify Template is deleted and not visible on search")
    public void verifyDeletionUsingSearch() {
        Assert.assertTrue(templateListing.templateDeletionSuccessStripIsDisplayed());
        TestNGLogUtility.pass("Template deletion successful strip is visible ");
        Assert.assertTrue(templateListing.noResultTextFromSearchIsDisplayed(templateName));
        TestNGLogUtility.pass("Template is deleted and not visible on search");
    }

    @Then("I click on Add New Button")
    public void clickOnAddNewButton() {
        templateListing.clickOnAddNewButton();
    }

    @Then("Verify Template creation Lightbox opens up")
    public void verifyTemplateCreationLightboxOpened() {
        Assert.assertTrue(templateListing.getLightBoxTabHeadIsDisplayed(),"lighbox head is not displayed");
        TestNGLogUtility.pass("Template creation Lightbox opens up");
    }

    @Then("fill the required details like group name and stage name , approvers and click on save button")
    public void createTemplate() {
        addNewApprovalTemplatePO.createNewApprovalProcess(approvalTemplateName, approvalStageName, approverEmail, "flag for group selection");
    }

    @And("Verify that on template listing page ,Template is visible on top.")
    public void verifyTemplateCreation() {
        Assert.assertTrue(templateListing.successStripForTemplateCreationOnTemplateListingPageIsDisplayed());
        TestNGLogUtility.pass("Template is visible on top");
        Assert.assertEquals(approvalTemplateName, templateListing.getFirstTemplateName());
        TestNGLogUtility.pass("Template created is same as coming on top of tuple");
    }

    @Given("I navigate to Account settings page.")
    public void openAccountSettingsPage() {
        templateListing.openSpecificURL(settingsPage);
    }

    @Then("I click on a link to create Approval Template under Manage Approval Workflow.")
    public void clickOnAddNewApprovalProcessLink() {
        templateListing.clickOnAddNewApprovalProcessLinkFromSettingsPage();
    }

    @Then("I click on Manage group button and then edit the group.")
    public void ClickOnEditGroupButton() {
        templateListing.clickOnManageGroup();
    }

    @Then("I click on Requisition approval tab to map approval process")
    public void mapApprovalProcess() {
        templateListing.clickOnRequisitionApprovalTab();
    }

    @Then("I click on a link Add New to create Approval Template under Manage Approval Workflow.")
    public void addApprovalProcess() {
        templateListing.clickOnAddNewBtnGroupLightbox();
    }

    @Then("fill the required details like approval name,stage name,approvers and click on save button")
    public void mapApprovalProcessWithGroup() {
        addNewApprovalTemplatePO.createNewApprovalProcess(approvalTemplateName, approvalStageName, approverEmail, flag);
    }

    @And("Verify after clicking on save button that Approval process is created.")
    public void verifyApprovalProcessCreation() {
        Assert.assertTrue(templateListing.successStripForTemplateCreationIsDisplayedOnAddANewGroupLightBox());
        TestNGLogUtility.pass("Approval process is created.");
    }

    @And("Verify after clicking on save button that group is edited successfully")
    public void verifyClickOnSaveGroup() {
        templateListing.clickOnSaveGroup();
        Assert.assertTrue(templateListing.successStripIsDisplayedForSavedGroup());
        TestNGLogUtility.pass("group is edited successfully");
    }

    @Then("I click on edit and change the approval name in first stage")
    public void editApprovalTemplate() {
        templateName = templateListing.getFirstTemplateName();
        templateListing.clickOnEditButtonUnderTemplateTuple();
        addNewApprovalTemplatePO.editTemplateName(approvalTemplateName);
    }

    @And("Verify that Approval Name changed is visible on top.")
    public void verifyApproverEditedSuccessfully() {
        Assert.assertTrue(templateListing.successStripForTemplateEditOnTemplateListingPageIsDisplayed());
        Assert.assertNotEquals(templateListing.getFirstTemplateName(), templateName);
        TestNGLogUtility.pass("Approval Name changed is visible on top.");
    }

    @Then("I fill the Approval process name and prefill other details using existing template.")
    public void createTemplateUsingPrefill() {
        addNewApprovalTemplatePO.createTemplateFromExisting(approvalTemplateName, highlightedText);
    }

    @And("Verify that number we are selecting through pagination and the tuples as result we are getting are correct.")
    public void verifyPaginationFunctionality() {
        Assert.assertTrue(templateListing.paginationResultsIsDisplayed());
        TestNGLogUtility.pass("Pagination working correctly");
    }
}