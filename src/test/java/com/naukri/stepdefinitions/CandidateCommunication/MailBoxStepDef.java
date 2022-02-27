package com.naukri.stepdefinitions.CandidateCommunication;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Applications.AddASingleProfilePagePO;
import com.naukri.pageobjects.Applications.InboxPagePO;
import com.naukri.pageobjects.CandidateCommunication.MailBoxTabPO;
import com.naukri.pageobjects.Offer.OfferPermissionPagePO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.asserts.SoftAssert;
import org.testng.internal.junit.ArrayAsserts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author abhishek.dwivedi,nikhil.bhatia
 */
public class MailBoxStepDef {
    String parentWindow = "";
    public String flowType = "null";
    public static String mailBodySubject;
    public String txtforwardmailbody;
    public String txtforwardToField;

    //GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
    GenericFunctions genericFunction = new GenericFunctions();
    // MailBoxTabPO objMailBoxPO = (MailBoxTabPO) PageObjectWrapper.getObject(MailBoxTabPO.class);
    MailBoxTabPO objMailBoxPO = new MailBoxTabPO();
    AddASingleProfilePagePO addASingleProfile = new AddASingleProfilePagePO();
    //AddASingleProfilePagePO addASingleProfile = (AddASingleProfilePagePO) PageObjectWrapper.getObject(AddASingleProfilePagePO.class);
    public static String subusername = YamlReader.getAppConfigValue("Users.Enterprise2.Subuser.username");
    public static String mailSubject = "";
    SoftAssert softAssert = new SoftAssert();
    Map<String, List<String>> hmapFilterData = new HashMap<>();

    //new code
    @And("I click on reply button from status change message")
    public void replyToMessage() {
        objMailBoxPO.clickOnReplyButton();
    }

    @And("I click on replyAll button from status change message")
    public void replyAllToMessage() {
        objMailBoxPO.clickOnReplyAllButton();
        TestNGLogUtility.info("User clicked on reply all button");
    }

    @Then("I check email id's in To field")
    public void checkToMailId() {
        Assert.assertTrue(objMailBoxPO.checkToEmailIds());
    }

    @Then("I fill message body and send the message")
    public void fillMessage() {
        objMailBoxPO.fillMessageBody("hello, This is test Message");
        objMailBoxPO.addAttachment();
        objMailBoxPO.clickOnSendMail();
    }

    @When("I fill details of the candidate")
    public void fillDetailsForCandidate() {
        addASingleProfile.addCandidateInformation();
    }

    @And("I move the Candidate to {string} Stage")
    public void switchToInterviewStage(String stage) {
        objMailBoxPO.setStatus(stage);
        objMailBoxPO.scheduleInterview("Noida", "11", "11");
        objMailBoxPO.setInterviewerEmail("All");
        objMailBoxPO.clickOnsetInterviewStage();
        objMailBoxPO.clickOnEmailCandidateButton();
    }

    @And("Verify message is listing under same subject on top and hover message for recently sent is displayed")
    public void verifyMessageListedOnTop() {
        Assert.assertTrue(objMailBoxPO.checkMessage("hello, This is test Message"));
        Assert.assertTrue(objMailBoxPO.hoverOnRecentlySentMessageIsDisplayed());
    }

    @And("Verify mailBlock for status change {string} By Logged in recruiter")
    public void verifyMailBlockText(String changedTo) {
        String changedBy = objMailBoxPO.getUsername();
        System.out.println("changedby" + changedBy + "changedto" + changedTo);
        Assert.assertTrue(objMailBoxPO.verifyMailBlock("statusChange", changedTo, changedBy));
    }

    @And("Verify no mails to show is displayed")
    public void verifyNoMailsToShow() {
        objMailBoxPO.noMailsToShowIsDispalyed();
    }

    @Then("I click on Manage Profile")
    public void clickOnManageProfile() {
        objMailBoxPO.clickOnManageProfileButton();
    }

    @And("I {string} to mask and unmask candidate mails")
    public void superUserMaskingSetting(String permission) {
        objMailBoxPO.ccReplySetting(permission);
    }

    @Then("I navigate to CV Details Page of particular candidate")
    public void openCvDetailPage() {
        objMailBoxPO.openSpecificURL(PropFileHandler.readProperty("viewcandidateDetailsUrl") + PropFileHandler.readProperty("candidateIdForCandidateCommunication"));
    }

    @And("Verify replyAll Button Is disabled")
    public void verifyReplyButtonDisabled() {
        Assert.assertFalse(objMailBoxPO.sendMessageIsDisplayed());
    }

    @And("Verify replyAll Button Is enabled")
    public void verifyReplyButtonEnabled() {
        Assert.assertTrue(objMailBoxPO.sendMessageIsDisplayed());
    }

    //new code above
    @Then("I remove Automatic mailer for {string} stage.")
    public void removeAutomaticMailer(String stage) {
        objMailBoxPO.removeAutomaticMailerForStage(stage);
        TestNGLogUtility.info("I remove Automatic mailer for "+stage+" stage.");
    }

    @And("I move to particular candidate details page")
    public void clickCandidateName() {
        objMailBoxPO.clickOnCandidateNameAndSwtchToWindow();
    }

    @Then("Verify MailboxTab is displayed")
    public void verifyMailboxTabIsDisplayed() {
        TestNGLogUtility.pass("Verify MailboxTab is displayed");
        Assert.assertTrue(objMailBoxPO.validatePresenceOfElementsOnMailTemplate("Mailbox Tab"));
    }

    @And("I see conversations between recruiter and candidate")
    public void verifyCaonversationBetRecruiterAndCandidateIsDisplayed() {
        TestNGLogUtility.pass("Verify conversations between recruiter and candidate is displayed");
        Assert.assertTrue(objMailBoxPO.validatePresenceOfElementsOnMailTemplate("Conversation"));
    }

    @And("Verify subject of mail as heading")
    public void verifySubjectOfMail() {
        TestNGLogUtility.pass("Verify subject of mail as heading");
        Assert.assertTrue(objMailBoxPO.validatePresenceOfElementsOnMailTemplate("ThreadSubject"));
    }

    @Then("User click on mailboxtab")
    public void clickOnMailboxtab() {
        objMailBoxPO.wait.waitForPageToLoadCompletely();
        objMailBoxPO.jsUtil.scrollUp();
        objMailBoxPO.clickOnMailBox();
    }

    @Then("Verify RequirementName is displayed")
    public void verifyRequirementNameIsDisplayed() {
        TestNGLogUtility.pass("Verify RequirementName is displayed");
        Assert.assertTrue(objMailBoxPO.validatePresenceOfElementsOnMailTemplate("RequirementName"));
    }

    @Then("Verify ThreadSubject is displayed")
    public void verifyThreadSubjectIsDisplayed() {
        TestNGLogUtility.pass("Verify ThreadSubject is displayed");
        Assert.assertTrue(objMailBoxPO.validatePresenceOfElementsOnMailTemplate("ThreadSubject"));
    }

    @Then("Verify MailboxTabCount is displayed")
    public void verifyMailboxTabCountIsDisplayed() {
        TestNGLogUtility.pass("Verify MailboxTabCount is displayed");
        Assert.assertTrue(objMailBoxPO.validatePresenceOfElementsOnMailTemplate("MailboxTabCount"));
    }

    @Then("Verify the arrow for incoming mail or outgoing mail.")
    public void verifyArrowForIncomingMailOutgoingMailIsDisplayed() {
        TestNGLogUtility.pass("Verify the arrow for incoming mail or outgoing mail.");
        Assert.assertTrue(objMailBoxPO.validatePresenceOfElementsOnMailTemplate("SendMailArrow"));
    }


    @And("Verify date and time of the email sent and recieved.")
    public void verifyDateAndTimeIsDisplayed() {
        TestNGLogUtility.pass("date and time of the email sent and recieved.");
        Assert.assertTrue(objMailBoxPO.validatePresenceOfElementsOnMailTemplate("Message DateTime"));
    }

    @And("I verify the mail count is changed")
    public void verifyChangedMailCountIsDisplayed() {
        Assert.assertTrue(objMailBoxPO.refreshPageAndGetUpdatedMailCount());
        TestNGLogUtility.pass("I verify the mail count is changed");
    }

    @And("User fill in the subject field as {string}")
    public void fillMailSubject(String mailSubject) {
        mailBodySubject = mailSubject + genericFunction.generateRandomDigits(6);
        objMailBoxPO.fillMailSubject(mailBodySubject);
    }

    @Then("I uncheck checkbox for cc to send mail successfully")
    public void uncheckCCMailCheckbox() {
        objMailBoxPO.ccMailCheckbox();
    }

    @Then("Verify ThreadSubject is displayed as {string}")
    public void verifyThreadSubjectInMail(String mailThreadSubject) {
        TestNGLogUtility.pass("Verify ThreadSubject is displayed");
        if (!mailSubject.equals("")) {
            mailThreadSubject = mailSubject;

        }
        softAssert.assertTrue(objMailBoxPO.isUpdatedThreadSubjectDisplayed(mailThreadSubject));
        softAssert.assertAll();
        mailSubject = "";
    }

    @And("I select Email from Reply To option")
    public void enterReplyToMailId() {
        objMailBoxPO.fillReplyToEmail();
    }

    @When("User click on forward Mail option")
    public void clickOnForwardMailoption() {
        objMailBoxPO.clickForwardMailButton();
        flowType = "forward";
    }

    @And("I verify the mail count is not changed")
    public void verifyChangedMailCountIsNotDisplayed() {
        TestNGLogUtility.pass("I verify the mail count is not changed");
        Assert.assertFalse(objMailBoxPO.refreshPageAndGetUpdatedMailCount());
    }

    @And("I move the candidate to {string} Stage")
    public void changeSelectionStage(String stage) {
        objMailBoxPO.setStatus(stage);
        objMailBoxPO.clickOnSendEmail();
    }

    @And("I fill in the Body field of Mail Template")
    public void setBodyMailTemplate() {
        objMailBoxPO.setMailTemplateBody("setbody");
        objMailBoxPO.clickOnSendStatusChangeMail();
        Assert.assertTrue(objMailBoxPO.successMessageForMailSentIsDisplayed());
    }

    /* @And("Verify ThreadSubject is not displayed as {string}")
     public void verifyEmailThreadIsNotDisplayed(String mailThreadSubject) {
         TestNGLogUtility.pass("Verify ThreadSubject is not displayed");
         Assert.assertFalse(objMailBoxPO.isUpdatedThreadSubjectDisplayed(mailThreadSubject));
     }*/
    @And("Verify email is not visible in MailBox Tab")
    public void verifyEmailtIsNotDisplayed() {
        TestNGLogUtility.pass("Verify email is not visible in MailBox Tab");
        Assert.assertFalse(objMailBoxPO.refreshPageAndGetUpdatedMailCount());
    }

    @Then("Verify ThreadSubject is not displayed as {string}")
    public void verifyThreadSubjectIsNotPresent(String mailThreadSubject) {
        TestNGLogUtility.pass("Verify ThreadSubject is not displayed");
        Assert.assertFalse(objMailBoxPO.isUpdatedThreadSubjectDisplayed(mailBodySubject));
    }

    @And("I click on Request Document option")
    public void clickOnRequestDocumentButton() {
        TestNGLogUtility.info("I click on Request Document option");
        objMailBoxPO.clickRequestDocumentLink();
    }

    @And("I click on Document List dropdown")
    public void clickDocumentListDropDown() {
        TestNGLogUtility.info("I click on Document List dropdown");
        objMailBoxPO.clickOnDocumentDropDown();
    }

    @And("I select option as {string}")
    public void selectOptionFromRequestDocumentDropdown(String optionType) {
        TestNGLogUtility.info("Select as Select All");
        objMailBoxPO.selectOptionFromDocumentDropDown(optionType);
    }

    @And("I click on Request Button")
    public void clickRequestButton() {
        TestNGLogUtility.info("I click on Request Button");
        objMailBoxPO.clickRequestButton();
    }

    @And("I click on Term and Condition check box")
    public void clickTermAndConditionCheckBox() {
        TestNGLogUtility.info("I click on Term and Condition check box");
        objMailBoxPO.clickTermandConditionCheckBox();

    }

    @And("User click on candidate and move to candidate page")
    public void clickCandidateNameAndSwitchToCandidatePage() {
        TestNGLogUtility.info("I click on candidate");
        objMailBoxPO.clickOnCandidateNameAndSwtchToWindowCandidateDetailPage();
    }

    @When("I click on Requirement Name on candidate page")
    public void clickOnRequirementNameOnCandidatePage() {
        TestNGLogUtility.info("I click on Requirement Name on candidate page");
        objMailBoxPO.clickRequirementOnCandidateDetailsPage();
    }

    @And("User close Requirement Detail page and switch to  candidate detail page")
    public void closeRequirementDetailpageAndSwitchtoCandidateDetailPage() {
        objMailBoxPO.closeRequirementpageAndSwitchBacktoCandidateDetailPage();
    }


    @Then("I apply filter {string} from {string} and {string} from {string} with attachment")
    public void applyFilter(String filterFromMailType, String filterMailType, String filterFromAllMails, String filterAllMails) {
        objMailBoxPO.filtersApplied(filterFromMailType, filterMailType, filterFromAllMails, filterAllMails, true);
        Assert.assertTrue(objMailBoxPO.checkHeaders(filterFromMailType));
    }

    @Then("I apply filter {string} from {string} and {string} from {string} without attachment")
    public void applyFilterWithoutAttachment(String filterFromMailType, String filterMailType, String filterFromAllMails, String filterAllMails) {
        objMailBoxPO.filtersApplied(filterFromMailType, filterMailType, filterFromAllMails, filterAllMails, false);
        Assert.assertTrue(objMailBoxPO.checkHeaders(filterFromMailType));
    }

    @When("I am on All profiles page")
    public void all_Profiles_Page() {
        genericFunction.launchSpecificURL(PropFileHandler.readProperty("AllProfiles"));
        objMailBoxPO.wait.hardWait(10);
    }

    @And("User type in the forward mail body {string}")
    public void user_Type_In_The_Forward_Mail_Body(String forwardmailbody) {
        txtforwardmailbody = forwardmailbody + "";
        objMailBoxPO.fillforwardmailbody(txtforwardmailbody);
    }

    @And("User add To field as {string}")
    public void user_Add_To_field_(String toField) {
        txtforwardToField = toField + "";
        objMailBoxPO.forwardToField(txtforwardToField);
    }


    @Then("Open Personal MailBox for candidate")
    public void open_Personal_MailBox_for_candidate() {
        if (!flowType.equals("null")) {
            objMailBoxPO.forwardMailBoxContent(mailBodySubject, txtforwardmailbody, txtforwardToField);
        } else {
            objMailBoxPO.getDataCandidateCommunicationMailBox();
        }
//       objMailBoxPO.candidateCommunicationSetting();
        objMailBoxPO.getDataCandidatePersonalMailBox();


    }

    @And("Verify Content and subject sent to the candidate from RMS.")
    public void verify_Content_and_subject_sent_to_the_candidate_from_RMS() {
        if (!flowType.equals("null")) {
            Assert.assertTrue(objMailBoxPO.verifyforwardMailBoxContentwithCandidatePersonalMailBox());
        } else {
            Assert.assertTrue(objMailBoxPO.verifyCCMailBoxContentwithCandidatePersonalMailBox());
        }
    }

    @Then("I search subuser")
    public void searchRecruiter() {
        objMailBoxPO.searchRecruiter(subusername);
    }

    @When("I click on manage permissions for the searched recruiter")
    public void managePermission() {
        objMailBoxPO.clickOnManagePermission();
    }

//    @And("User Get the information for mail sent from mailbox tab")
//    public void getMailInfoFromMailboxTab(){
//        objMailBoxPO.fillMailInfoFromMailBoxTab();
//        objMailBoxPO.fillRequirementDetails();
//    }

    @And("User Get the information about the candidate")
    public void getCandidateInfoFromCVDetail() {
        objMailBoxPO.fillCandidateInfoFromCVDetail(true);
    }

    @And("Verify mailBlock type {string} for {string}")
    public void verifyMailblock(String statusType, String interviewType) {
        Assert.assertTrue(objMailBoxPO.verifyMailBlock(statusType, interviewType, ""), "Mail Block for Interview Mail is broken");
        TestNGLogUtility.pass("Mail Block for Interview Mail is working fine");
    }

    @And("User move the candidate to {string} stage.")
    public void switchToOfferStage(String status) {
        objMailBoxPO.setStatus(status);
    }

    @Then("Verify ProfileTab is displayed")
    public void verifyProfileTabIsDisplayed() {
        Assert.assertTrue(objMailBoxPO.validatePresenceOfElementsOnMailTemplate("Profile Tab"));
        TestNGLogUtility.pass("Verify ProfileTab is displayed");
    }

    @And("User check the candidate profile image on cv detail page")
    public void setProfileImage(){
        objMailBoxPO.setCandidatePhotoCvDetail();
        TestNGLogUtility.info("Candidate Image Url updated for comparison");
    }

    @And("User Get the information about the candidate for unmapped profile")
    public void getCandidateInfoForUnmappedProfile() {
        objMailBoxPO.fillCandidateInfoFromCVDetail( false);
        TestNGLogUtility.info("Get the information about the candidate for unmapped profile");

    }

    @And("User change the subject for the mail to {string}")
    public void setSubject(String changedSubject){
        objMailBoxPO.changeSubject(changedSubject);
        TestNGLogUtility.info("subject for the mail changed");
    }

    @And("User replied to second mail in mail thread")
    public void clickOnReplyAll(){
        objMailBoxPO.clickOnReplyAllForSecondMail();
        TestNGLogUtility.info("replied to second mail on mail thread");
    }

    @And("User sets Configured email id {string} with password {string}")
    public void configureEmailId(String username, String password){
        Assert.assertTrue(objMailBoxPO.configureOutgoingEmailId("Gmail",username,password));
    }

    @And("User Verify Last active and No of emails is displayed on the tuple")
    public void verifyTupleElementsAreDisplayed(){
        Assert.assertTrue(objMailBoxPO.tupleElementsIsDisplayed(),"Tuple elements are not displayed");
        TestNGLogUtility.pass("Tuple Elements last active and no of mails are displayed");
    }

    @Then("User clicks on Edit Signature")
    public void clickOnEditSignature(){
        objMailBoxPO.clickOnEditSignature();
        TestNGLogUtility.info("click on edit signature");
    }

    @And("User sets the signature as {string}")
    public void editSignature(String signature){
        objMailBoxPO.fillContentIframe(signature);
        TestNGLogUtility.info("edit signature with"+signature);
    }

    @And("Verify Expand All functionality")
    public void verifyExpandAll(){
        Assert.assertTrue(objMailBoxPO.verifyExpandAll(),"Expand all functionality broken");
        TestNGLogUtility.pass("Expand all functionality working correctly");
    }

    @And("User click on candidate email tag")
    public void clickOnCandidateEmailTag(){
        objMailBoxPO.clickOnCandidateEmailTag();
        objMailBoxPO.clickOnSendMail();
        TestNGLogUtility.info("candidate email tag added");
    }

}



