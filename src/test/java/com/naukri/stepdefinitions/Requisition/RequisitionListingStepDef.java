package com.naukri.stepdefinitions.Requisition;

import com.gargoylesoftware.htmlunit.Page;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Requisition.ApprovalTemplateListingPO;
import com.naukri.pageobjects.Requisition.RequisitionListingPO;
import com.naukri.pageobjects.Requisition.RequisitionListingPO.RequisitionCreationFormPagePO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequisitionListingStepDef {

    public String requestListingPage = "URLs.requisitionListing";
    public String requisitionTitle = "nikhil" + System.currentTimeMillis();
    public String requisitionRaisedByYouTab = "Requisitions Raised by You";
    public String searchKeywordRequisition = "requisition";
    public String searchableRequisiitonId = "DQW-565";
    public String searchByFirstThreeLetters = "req";
    public String prefillWithExistingTemplate = "nikhil";
    public String groupName = "Requirement requisition";
    public String recruiter = "enterprise_subuser1@naukri.com";
    public String approvalProcess = "requsition raised 12 nov ";
    public String keyskills = "java";
    public String jobTitle = "Software Engineer";
    public String minExp = "4";
    public String maxExp = "5";
    public String tabCount;


    Map<Object, Object> requisitionFormData = new HashMap<Object, Object>();

   // CommonAction commonAction = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
    RequisitionListingPO requestListing = (RequisitionListingPO) PageObjectWrapper.getObject(RequisitionListingPO.class);
    RequisitionCreationFormPagePO requisitionCreation = (RequisitionCreationFormPagePO) PageObjectWrapper.getInnerClassObject(RequisitionListingPO.class, RequisitionCreationFormPagePO.class);
    ApprovalTemplateListingPO templateListing = (ApprovalTemplateListingPO) PageObjectWrapper.getObject(ApprovalTemplateListingPO.class);
    SoftAssert softAssert = new SoftAssert();

    @When("I navigate to Requisition listing page.")
    public void openRequisitionListingPage() {
        requestListing.openSpecificURL(requestListingPage);
    }

    @When("I click on search button with Requisition that does not exist for the client")
    public void searchInvalidRequisition() {
        requestListing.searchRequisition(CommonAction.generateRandomStrings(9, "Alphanumeric"));
    }

    @Then("I see Requisition not found with clear link")
    public void verifyRequisitionNotFound() {
        Assert.assertTrue(requestListing.noRequisitionToShowIsDisplayed());
        TestNGLogUtility.pass(" Requisition not found with clear link.");
    }

    @When("I click on the clear button")
    public void clickOnClearButton() {
        requestListing.clickOnClearLink();
    }

    @And("Verify that after clicking on clear button all Tabs are visible.")
    public void verifyTabsVisibility() {
        Assert.assertTrue(requestListing.tabBlockIsDisplayed());
        TestNGLogUtility.pass("Requisition Tabs are visible");
    }

    @When("I click on search button by filling valid Request Name on Requisition listing page.")
    public void searchRequisitionWithRequestName() {
        requestListing.searchRequisition(searchKeywordRequisition);
    }

    @And("verify that the text with the search Request Name if exist should be highlighted and listed on top in tuple.")
    public void verifyHighlightedRequisitionOnSearch() {
        Assert.assertTrue(requestListing.highlightedRequisitionResultsIsDisplayed(searchKeywordRequisition));
        TestNGLogUtility.pass("Requisitions are Highlighted on search");

    }

    @Then("I search with RequisitionId that exist.")
    public void searchTemplate() {
        requestListing.searchRequisition(searchableRequisiitonId);
    }

    @And("verify that the RequisitionId with the search keyword if exist should be highlighted and listed on top in tuple.")
    public void verifyHighlightedTemplatesOnSearch() {
        Assert.assertTrue(requestListing.highlightedRequisitionResultsIsDisplayed(searchableRequisiitonId));
        TestNGLogUtility.pass("Requisition Id is Highlighted on search");
    }

    @When("I search with text by typing first three words irrespective of complete Requisition")
    public void searchFunctionalityThreeWords() {
        requestListing.fillSearchTextBox(searchByFirstThreeLetters);
    }

    @Then("I see link to the similar names of Requisition in the search bar")
    public void verifyLinkOnSearchBar() {
        Assert.assertTrue(requestListing.getSuggestionLinkForRequisitionIsDisplayed());
        TestNGLogUtility.pass("link to the Requisitions in the search bar displayed");
    }

    @Then("I click on link with results")
    public void clickOnResults() {
        requestListing.clickOnAllResultsSuggestionLink();
    }

    @And("Verify it shows the result with text that you entered and clicked.")
    public void verifyResultOnClick() {
        Assert.assertTrue(requestListing.highlightedRequisitionResultsIsDisplayed(searchByFirstThreeLetters));
        TestNGLogUtility.pass("shows the result with template that you clicked.");
    }

    @When("I click on raise request and fill required details with group and Approval Template")
    public void createRequisitionWithApprovalTemplate() {
        requestListing.clickOnRaiseRequest();
        requisitionFormData = requestListing.fillRequisitionFormData(requisitionTitle, prefillWithExistingTemplate, groupName, recruiter, approvalProcess, keyskills, jobTitle, minExp, maxExp);
        requisitionCreation.fillRequisitionFormWithPrefill(requisitionFormData, true);
        requisitionCreation.clickOnRaiseRequisition();
        Assert.assertTrue(requestListing.getSuccessMessage());
        TestNGLogUtility.pass("requisition is created with group and approval template attached");

    }


    @And("Verify Requisition is visible at the top in tab requisition raised by you and verify Approval status and pending approvers name")
    public void verifyRequisitionDetailsUnderRaisedByYou() {
        Assert.assertEquals(requestListing.getFirstRequisitionName(requisitionRaisedByYouTab), requisitionTitle);
        Assert.assertEquals(requestListing.getNameForHMWhoRaisedRequisition(), "You");
        Assert.assertEquals(requestListing.getStatusForRequisitionListedInFirstTuple(), "Approval Pending");
        Assert.assertEquals(requestListing.getPendingApproversNameForRequisitionListedInFirstTuple(), "enterprise_subuser1@naukri.com");
        Assert.assertTrue(requestListing.reminderSentFromApprovalHistoryIsDisplayed());
        Assert.assertEquals(requestListing.getRequisitionRaisedDate(), requestListing.getCurrentDate());
        TestNGLogUtility.pass("requisition is visible at the top and in requisition raised by you tab");
    }

    @And("Verify Requisition is visible at the top in tab requisition raised by you")
    public void verifyRequisitionUnderRaisedByYou() {
        Assert.assertEquals(requestListing.getFirstRequisitionName(requisitionRaisedByYouTab), requisitionTitle);
        Assert.assertEquals(requestListing.getStatusForRequisitionListedInFirstTuple(), "Pending For Requirement");
        Assert.assertEquals(Integer.parseInt(requestListing.getSelectedTabCount()), Integer.parseInt(tabCount) + 1);
        TestNGLogUtility.pass("requisition is visible at the top and in requisition raised by you tab");
    }

    @Then("I Comment on the Requisition")
    public void commentOnRequisition() {
        requestListing.addComment("test Comment");
    }

    @And("Verify Comment is visible on the page")
    public void verifyCommentOnRequisition() {
        Assert.assertEquals(requestListing.getComment(), "test Comment");
        TestNGLogUtility.pass(" Comment is visible on the page");

    }

    @Then("I delete the comment from Requisition")
    public void deleteCommentFromRequisition() {
        requestListing.deleteFirstComment();
    }

    @And("Verify Comment is deleted")
    public void verifyCommentDeletion() {
        Assert.assertFalse(requestListing.deleteCommentButtonIsVisible());
        TestNGLogUtility.pass(" Comment is deleted");

    }

    @When("I switch to tab {string}")
    public void moveToTab(String tabName) {
        requestListing.choseTabsOnRequisitionListingPage(tabName);
    }

    @Then("I click on send Reminder")
    public void clickSendReminderButton() {
        requestListing.clickOnSendReminder();
    }

    @And("Verify Reminder sent successfully")
    public void verifySendReminder() {
        Assert.assertTrue(requestListing.reminderSentIsDisplayed());
    }

    @Then("Verify I see status as {string} or {string} under {string}")
    public void verifyStatus(String statusPending, String statusCompletion ,String tabText) {
        String requisitionName = requestListing.getFirstRequisitionName(tabText);
        Assert.assertTrue(requestListing.getStatusForRequisition(tabText, requisitionName, statusPending, statusCompletion));
        TestNGLogUtility.pass(" I switch to tab and get requisition status");

    }

    @When("I click on raise request and fill required details without approval Template")
    public void createRequisitionWithoutApprovalTemplate() {
        tabCount = requestListing.getSelectedTabCount();
        requestListing.clickOnRaiseRequest();
        requisitionFormData = requestListing.fillRequisitionFormData(requisitionTitle, prefillWithExistingTemplate, groupName, recruiter, approvalProcess, keyskills, jobTitle, minExp, maxExp);
        requisitionCreation.fillRequisitionFormWithPrefill(requisitionFormData, false);
        requisitionCreation.clickOnRaiseRequisition();
    }

    @Then("I click on raise request and search with prefill request")
    public void raiseRequisitionWithPrefill() {
        Map<Object, Object> requisitionFormData = new HashMap<Object, Object>();
        requisitionFormData.put("requisitionTitle", requisitionTitle);
        requisitionFormData.put("prefillWithRequisition", "Requisition without Approval");
        requisitionFormData.put("group", " Requirement requisition ");
        requisitionFormData.put("recruiterSelector", "enterprise_subuser1@naukri.com");
        requisitionFormData.put("approvalProcess", "requsition raised 12 nov ");
        requisitionCreation.clickOnRaiseRequisition();
    }

    @And("Verify that number we are selecting through pagination and the tuples as result we are getting are correct for all tabs")
    public void verifyPagination(DataTable dt) {
        List<String> list = dt.asList(String.class);
        list.forEach((str) -> {
            softAssert.assertTrue(requestListing.verifyPaginationOnRequisitionListingPage(str));
            TestNGLogUtility.pass("select pagination by selecting values on different tabs");
        });
        softAssert.assertAll();
    }




}
