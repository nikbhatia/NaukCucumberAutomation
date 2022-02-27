package com.naukri.stepdefinitions.CandidateCommunication;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.URLBuilder;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.CandidateCommunication.CommunicationInboxPO;
import com.naukri.pageobjects.CandidateCommunication.MailBoxTabPO;
import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Test;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import static com.naukri.automation.util.URLBuilder.getEndPoint;

public class NewThreadFormationInInboxStepDef {

    CommunicationInboxPO objCommunicationInboxPO = (CommunicationInboxPO) PageObjectWrapper.getObject(CommunicationInboxPO.class);
    GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
    URLBuilder urlBuilder = (URLBuilder) PageObjectWrapper.getObject(URLBuilder.class);
    MailBoxTabPO mailBoxTabPO = (MailBoxTabPO) PageObjectWrapper.getObject(MailBoxTabPO.class);
    CommonAction commonAction = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
    MailBoxTabPO objMailBoxPO = (MailBoxTabPO) PageObjectWrapper.getObject(MailBoxTabPO.class);


    @Then("User updates the value of Url formed for cv detail page.")
    public void setCVDetailUrl() {
        objCommunicationInboxPO.setCvDetailUrlInMongo();
    }

    @Then("User move to cv detail page of candidate.")
    public void moveToCVDetailUrl() throws ParseException {
        //genericFunction.launchSpecificURL(urlBuilder.getURL("specificCVDetailPage"));
        String applicationId = objCommunicationInboxPO.getCvDetailUrlFromMongo();
        genericFunction.launchSpecificURL(YamlReader.getAppConfigValue("URLs.baseURL") + getEndPoint("cvDetailsPage") + "/" + applicationId);
    }

    @And("User see a link on RMS GNB with label {string}.")
    public void verifyMailboxOnGNB(String mailbox) {
        Assert.assertTrue(objCommunicationInboxPO.verifyValuesAreDisplayedOrNotOnCCPage(mailbox), "Mailbox link is not visible on GNB");
        TestNGLogUtility.pass("Mailbox link is visible on GNB");

    }

    @Then("User Verify {string} Heading is Visible on Page")
    public void verifyHeading(String pageHeading) {
        genericFunction.pageRefresh();
        Assert.assertEquals(pageHeading, commonAction.getTextByVisibility(objCommunicationInboxPO.eleInboxHeading));
        TestNGLogUtility.pass("Heading is Visible on Page");

    }

    @And("User Click on {string} visible on the top")
    public void clickOnLatestMail(String latestMail) {
        objCommunicationInboxPO.userClicksOnFilter(latestMail);
    }

    @And("User Verify Details of first tuple on left facet")
    public void verifyDetailsLeftFacet() {
        Assert.assertTrue(objCommunicationInboxPO.compareMaps(objCommunicationInboxPO.fillLeftFacetDetails(), mailBoxTabPO.candidateInfoOnCVDetailPage), "Details of left facet and cv detail page doesn't match");
        TestNGLogUtility.pass("Details on left facet and cv detail for candidate matched successfully");
    }

    @And("User Verify Mail Details on right facet")
    public void verifyDetailsRightFacet() {
        Assert.assertTrue(objCommunicationInboxPO.compareMaps(mailBoxTabPO.candidateInfoOnCVDetailPage, objCommunicationInboxPO.fillCandidateInfoMailboxPage(true)), "Details of right facet and cv detail page doesn't match");
        TestNGLogUtility.pass("Details on right facet and cv detail for candidate matched successfully");
    }

    @Then("User Verify Header and Reminder for {string}")
    public void verifyHeaderAndReminder(String HeaderType) {
        Assert.assertTrue(mailBoxTabPO.checkHeaders(HeaderType), "Headers/reminders not working fine");
        TestNGLogUtility.pass("Header/reminder working correctly");
    }

    @And("User Get the information for mail sent from mailbox tab")
    public void getMailInfo() {
        mailBoxTabPO.fillMailInfoFromMailBoxTab();
        mailBoxTabPO.fillRequirementDetails();
    }

    @And("User get candidate info from right facet")
    public void getCandidateDetailsMailboxPage() {
        objCommunicationInboxPO.fillCandidateInfoMailboxPage(true);
        TestNGLogUtility.info("User get info from right facet");
    }

    @And("User verify details of candidate from right facet and cv detail page")
    public void verifyDetailsOfCandidate() {
        Assert.assertTrue(objCommunicationInboxPO.compareMaps(objCommunicationInboxPO.candidateInfoOnMailboxPage, mailBoxTabPO.candidateInfoOnCVDetailPage), "Details of right facet and cv detail page doesn't match");
        TestNGLogUtility.pass("Details on right facet and cv detail for candidate matched successfully");
    }

    @And("Verify success message strip is shown {string}")
    public void verifySuccessStrip(String message) {
        Assert.assertEquals(message,commonAction.getTextByVisibility(objCommunicationInboxPO.eleSuccessMessage),"Mail not sent successfully");
        TestNGLogUtility.pass("Mail not sent successfully from Reply all option");
    }

    @And("Verify {string} tab is selected by default")
    public void verifyDefaultTab(String activeTab){
        Assert.assertEquals(activeTab,commonAction.getTextByVisibility(objCommunicationInboxPO.eleActiveTab));
    }

    @And("Verify right facet is empty")
    public void verifyRightFacet(){
        Assert.assertTrue(commonAction.getTextByVisibility(objCommunicationInboxPO.eleRightFacet).isEmpty());
        TestNGLogUtility.pass("Right facet is empty");
    }

    @And("User verify candidate image on left facet and cv detail")
    public void verifyCandidateImageLeftFacet(){
        Assert.assertEquals(mailBoxTabPO.candidateProfileImageUrl,objCommunicationInboxPO.getCandidatePhotoLeftFacet());
        TestNGLogUtility.pass("Candidate Image on left facet and cv detail are same");
    }

    @And ("User verify candidate image on right facet and cv detail")
    public void verifyCandidateImageRightFacet(){
        Assert.assertEquals(mailBoxTabPO.candidateProfileImageUrl,objCommunicationInboxPO.getCandidatePhotoRightFacet());
        TestNGLogUtility.pass("Candidate Image on right facet and cv detail are same");
    }

    @And("User verifies placeholder in search bar {string}")
    public void verifyPlaceholderSearchBar(String placeholder){
        Assert.assertEquals(placeholder,objCommunicationInboxPO.getPlaceholderSearchBar());
        TestNGLogUtility.pass("Placeholder in search bar is correct");
    }

    @And("User verifies search suggestions for search term {string}")
    public void verifySearchSuggestions(String searchTerm){
        Assert.assertTrue(objCommunicationInboxPO.verifySearchSuggestion(searchTerm));
        TestNGLogUtility.pass("Search suggestions contains searched term");
    }

    @And("User Click on first suggestion for candidate name")
    public void clickOnFirstSuggestionCandidateName(){
        objCommunicationInboxPO.clickOnFirstSuggestion(objCommunicationInboxPO.eleFirstCandidateSuggestion);
        TestNGLogUtility.info("User clicked on first suggestion for candidate name in search bar");
    }

    @And("User Click on first suggestion for subject line")
    public void clickOnFirstSuggestionSubjectLine(){
        objCommunicationInboxPO.clickOnFirstSuggestion(objCommunicationInboxPO.eleFirstSubjectLineSuggestion);
        TestNGLogUtility.info("User clicked on first suggestion for subject line in search bar");
    }

    @Then("User verifies result on left facet contains searched term {string} in candidate name")
    public void verifySearchResultCandidateNameLeftFacet(String searchedTerm){
        Assert.assertTrue(commonAction.getTextByVisibility(objCommunicationInboxPO.eleCandidateNameLeftFacet).toLowerCase().contains(searchedTerm.toLowerCase()));
        TestNGLogUtility.pass("Candidate Name on left facet contains searched term");
    }

    @Then("User verifies result on left facet contains searched term {string} in subject line")
    public void verifySearchResultSubjectLineLeftFacet(String searchedTerm){
        Assert.assertTrue(commonAction.getTextByVisibility(objCommunicationInboxPO.eleSubjectLeftFacet).toLowerCase().contains(searchedTerm.toLowerCase()));
        TestNGLogUtility.pass("Subject Line on left facet contains searched term");
    }

    @And("User Click on link for all results in candidate name")
    public void clickOnLinkForAllResultsCandidateName(){
        objCommunicationInboxPO.clickOnFirstSuggestion(objCommunicationInboxPO.lnkAllCandidateName);
        TestNGLogUtility.info("User clicked on link :All results for candidate name in search bar");
    }

    @And("User Click on link for all results in subject line")
    public void clickOnLinkForAllResultsSubjectLine(){
        objCommunicationInboxPO.clickOnFirstSuggestion(objCommunicationInboxPO.lnkAllSubjectLines);
        TestNGLogUtility.info("User clicked on link :All results for subject line in search bar");
    }

    @And("User searched for search term that does not exist in candidate name and subject line")
    public void verifySuggestionNotFound() {
        Assert.assertFalse(objCommunicationInboxPO.verifySearchSuggestion(">!>"),"search term found");
        TestNGLogUtility.pass("Suggestions not found on search bar");
    }

    @And("User verifies message for result not found")
    public void verifySearchTermNotFoundIsDisplayed(){
        Assert.assertTrue(objCommunicationInboxPO.verifySuggestionNotFoundIsDisplayed(),"Searched term found is displayed on search bar");
        TestNGLogUtility.pass("Searched term not found is displayed on search bar");
    }

    @And("User verifies search for search term {string}")
    public void enterSearchTerm(String searchTerm){
        objCommunicationInboxPO.searchCCInbox(searchTerm);
        TestNGLogUtility.info("Searched on cc inbox page with " + searchTerm);

    }

    @And("Verify {string} is highlighted in left facet")
    public void verifyHighlightedSearchTerm(String searchTerm) {
        Assert.assertTrue(objCommunicationInboxPO.verifyHighlightedSearchTermLeftFacet(searchTerm),"Searched term is not highlighted in left facet");
        TestNGLogUtility.pass("Searched term is highlighted in left facet");
    }

    @And("Verify {string} is highlighted in right facet")
    public void verifyHighlightedSubjectRightFacet(String searchTerm) {
        Assert.assertTrue(objCommunicationInboxPO.verifyHighlightedSearchTermRightFacet(searchTerm),"Searched term is not highlighted in right facet");
        TestNGLogUtility.pass("Searched term is highlighted in right facet");
    }

    @And("Verify Date and Time displayed on left and right facet for mail are identical")
    public void verifyDateTimeOnLeftAndRightFacet(){
        Assert.assertTrue(objCommunicationInboxPO.verifyTimeOnLeftAndRightFacet(),"Date and Time displayed on left and right facet for mail are not identical");
        TestNGLogUtility.pass("Date and Time displayed on left and right facet for mail are identical");
    }

    @And("User Get the information for mail sent from mailbox tab for unmapped profile")
    public void getMailInfoUnmappedProfile() {
        mailBoxTabPO.fillMailInfoFromMailBoxTab();
        TestNGLogUtility.info("information for mail sent from mailbox tab for unmapped profile is saved in map");
    }

    @And("User Verify Mail Details on right facet for unmapped profile")
    public void verifyDetailsRightFacetUnmappedProfile() {
        Assert.assertTrue(objCommunicationInboxPO.compareMaps(mailBoxTabPO.candidateInfoOnCVDetailPage, objCommunicationInboxPO.fillCandidateInfoMailboxPage(false)), "Details of right facet and cv detail page doesn't match");
        TestNGLogUtility.pass("Details on right facet and cv detail for candidate matched successfully");
    }

    @And("User click on delete button present on cv detail page")
    public void deleteProfile(){
        Assert.assertTrue(mailBoxTabPO.deleteProfile(),"profile not deleted");
        TestNGLogUtility.pass("profile deleted successfully");

    }

    @And("User verify mail not found on left facet cc mailbox page")
    public void verifyMailOnLeftFacet() {
        Assert.assertFalse(objCommunicationInboxPO.compareMaps(objCommunicationInboxPO.fillLeftFacetDetails(), mailBoxTabPO.candidateInfoOnCVDetailPage), "Details on left facet and cv detail for candidate matched");
        TestNGLogUtility.pass("Details after deletion not found on cc mailbox page");
    }

    @And("Verify three dots functionality for existing mails")
    public void verifyThreeDotsFunctionality(){
        Assert.assertTrue(objCommunicationInboxPO.verifyThreeDotsFunctionality(),"Three dots functionality not working on cc mailbox");
        TestNGLogUtility.pass("Three dots functionality verified successfully");
    }

    @And("Verify {string} name for attachment sent and download link visible on cc mailbox page")
    public void verifyAttachment(String attachmentName){
        Assert.assertTrue(objCommunicationInboxPO.verifyAttachment(attachmentName),"Attachment name and download link sent are different");
        TestNGLogUtility.pass("Attachment name and download link verified successfully");

    }

    @And("User verify warning strip for time mismatch on left and right facet is not displayed")
    public void verifyWarningStripIsNotDisplayed(){
        Assert.assertFalse(objCommunicationInboxPO.verifyWarningStripIsDisplayed(),"Warning Strip Is Displayed");
        TestNGLogUtility.pass("Warning Strip Is Not Displayed");

    }

    @Then("User move to master profile cv detail page of candidate.")
    public void moveToMasterCVDetailUrl() throws ParseException {
        //genericFunction.launchSpecificURL(urlBuilder.getURL("specificCVDetailPage"));
        String applicationId = objCommunicationInboxPO.getCvDetailUrlFromMongo();
        genericFunction.launchSpecificURL(YamlReader.getAppConfigValue("URLs.baseURL") + getEndPoint("candidateDetailsPage") + applicationId);
    }

    @And("User get the requirement attached with the cv")
    public void getTheRequirementAttachedWithCV(){
        objCommunicationInboxPO.getTheRequirementAttachedWithCV();


    }


    @And("User add Default Automatic mailer for {string} stage.")
    public void i_add_Default_Automatic_mailer_for_stage(String stage) {
        Assert.assertTrue(objMailBoxPO.setDefaultAutomaticMailerForStage(stage).contains("Default Status Change Mail") , "Default automated mail not set for the stage");
    }

    @And("User refresh the page until {string} is visible")
    public void refreshUntilMailerIsVisible(String StageName){
          Assert.assertTrue(objCommunicationInboxPO.refreshUntilMailerIsVisible(StageName));
        TestNGLogUtility.info(StageName+" is Displayed on Mailer Settings page");
    }

    @And("User click on requirement on cv details page")
    public void clickOnRequirementOnCvDetailsPage(){
        objCommunicationInboxPO.clickOnRequirementOnCvDetailsPage();
        TestNGLogUtility.info("Clicked on Requirement on CV details Page");
    }

    @And("User changes the status of requirement as {string}")
    public void changeRequirementStatus(String status)
    {
        objCommunicationInboxPO.changeRequirementStatus(status);
        TestNGLogUtility.info("Changed the Status of Requirement");
    }

    @Then("User Verify Requirement is displayed as {string} on right facet")
    public void verifyRequirementStatus(String Status){
        Assert.assertTrue(objCommunicationInboxPO.verifyStatusOnCCPage(Status),"Status doesn't match");
        TestNGLogUtility.pass("Verified the Status of Requirement as " +Status);
    }

    @And("User click on Close in confirmation box")
    public void clickOnbuttoInBox(){
        objCommunicationInboxPO.clickOnbuttoInBox();
        TestNGLogUtility.info("Clicked on button in confirmation");
    }

    @And("Verify signature {string} is visible in mail under mailbox tab")
    public void verifySignature(String signature){
        Assert.assertTrue(mailBoxTabPO.candidateInfoOnCVDetailPage.get("MailBody").contains(signature),"Signature is not visible under mailbox tab");
        TestNGLogUtility.pass("Signature is visible in mail");
    }

    @And("Verify Message contains email id of candidate")
    public void verifyCandidateEmailId(){
        String emailId = mailBoxTabPO.getCandidateEmailId();
        TestNGLogUtility.info("Candidate email id is : "+emailId);
        Assert.assertTrue(mailBoxTabPO.candidateInfoOnCVDetailPage.get("MailBody").contains(emailId),"Message does not contains email id ");
        TestNGLogUtility.pass("Message contains email id ");
    }

}

