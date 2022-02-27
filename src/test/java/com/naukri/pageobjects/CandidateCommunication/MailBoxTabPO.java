package com.naukri.pageobjects.CandidateCommunication;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Requisition.ApprovalTemplateListingPO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;

/**
 * Mail Box Tab functionality
 *
 * @author abhishek.dwivedi,nikhil.bhatia
 */
public class MailBoxTabPO extends BaseAutomation {

    public By btnManagePermission = By.xpath("//a[@class =\"permissionTrig\"]");
    public By subUserSearchBox = By.id("quickSearchRecruiter");
    public By searchButton = By.id("quickSearchSumit");
    public By checkBoxCCMailLightbox = By.xpath("//input[@id=\"chkSendEmailCC\"]");
    public By eleEditOutgoingMail = By.xpath("//a[@class='outgoingEmailProfileEdit emailProfileEdit']//em[@class='editIc']");
    public By btnConfirmationOutgoingMail = By.xpath("//input[@value='Yes, Continue']");
    public By txtBoxOutgoingEmailId = By.xpath("//input[@id='emailId']");
    public By txtBoxPassword = By.xpath("//input[@id='password']");
    public By btnAddEmail = By.xpath("//input[@name='linkEmailBtn']");
    public By eleOutgoingSuccessStrip = By.xpath("//span[text()='Outgoing Email Configured successfully.']");
    public By eleToMailUnderMailboxTab = By.xpath("(//div[contains(@class,'message-to')])[1]");
    public By eleExpandAll = By.xpath("(//a[text()='Expand All'])[1]");
    public By eleCandidateEmailId = By.xpath("//div[@class='contactCol1']//a");
    public By eleToEmailId = By.xpath("//div[@class='receiver-name']//span[@class='toIds']");
    public By eleOfferHeader = By.xpath("//span[contains(text(),'Offer: ')] ");
    public By eleSendReminder = By.xpath("//a[contains(text(),'Send reminder')]");
    public By eleReminderSent = By.xpath("//span[text()='Reminder sent']");
    public By eleAssessmentHeader = By.xpath("//span[contains(text(),'Test')]");
    public By eleDocumentRequestHeader = By.xpath("//span[text()='Documents Pending :']");
    public By applyFilterButton = By.xpath("//button[text()='Apply']");
    public By eleContainsAttachmentFilter = By.xpath("//button[text()='Contains Attachment']");
    public By filterList = By.xpath("//div[@class='applyFilter ']//ul//li");
    public By filterDD = By.xpath("//div[text()[starts-with(.,'${status}')]]");
    public By eleDeleteAutomaticMailerForStage = By.xpath("(//div[contains(text(),'${status}')]//following-sibling::div)[1]//img[@class='deleteIcon']");
    private By eleStageAutomaticMailer = By.xpath("(//div[contains(text(),'${status}')]//following-sibling::div)[1]");
    private By eleSetDefaultAutomaticMailer = By.xpath("//div[contains(text(),'${status}')]//following-sibling::div/span/span/ul/li[1]");
    public By eleStageAutomaticMailerDD = By.xpath("(//div[contains(text(),'${status}')]//following-sibling::div/span)[1]");
    public By eleMailSettings = By.xpath("//a[text()=\"Automated Email Settings\"]");
    public By imgNoMailIcon = By.xpath("//img[@class='no-mail-icon']");
    public By eleNoMailsToShowCandidateText = By.xpath("//div[text()='To get started, send an email to the candidate.']");
    public By eleNoMailsToShow = By.xpath("//div[text()='No mails to show']");
    public By btnEmailCandidate = By.xpath("//a[text()=' Email Candidate(s)']");
    public By btnSetInterviewStage = By.xpath("//a[text()='Set']");
    public By eleVenueForInterview = By.xpath("//input[@name=\"VENUE\"]");
    public By eleCalendarIconInterview = By.xpath("//a[@class=\"calendar fr\"]");
    public By eleSetDateForInterview = By.xpath("//td[@class=\"currDate\"]");
    public By eleSetMinutesForInterview = By.xpath("//input[@name=\"interviewTimeMM\"]");
    public By eleSetHourForInterview = By.xpath("//input[@name=\"interviewTimeHH\"]");
    public By eleStatusChangeBlock = By.xpath("(//span[contains(text(),'${status}')])[1]");
    public By eleStatusChangeBlockText = By.xpath("(//span[contains(text(),'${status}')])[1]//following-sibling::span");
    public By eleHoverRecentlySentMsg = By.xpath("(//div[@title='This message is on its way. To confirm/ reply to this, please refresh the page'])[1]");
    public By eleFirstMessageOnPage = By.xpath("(//div[@class='message-tuple line2'])[1]");
    public By btnSendMessage = By.xpath("//button[text()='Send Mail']");
    public By eleMessageBody = By.xpath("//div[@class='mailBodyWriter']");
    public By btnManageProfile = By.xpath("//a[text()='Manage Your Profile']");
    public By btnGrantPermission = By.xpath("//a[contains(text(),'Grant Permission')]");
    public By btnPermissionConfirmationOnLightbox = By.xpath("//input[@value=\"Yes I'm sure\"]");
    public By btnRevokePermission = By.xpath("//a[contains(text(),'Revoke Permission')]");
    public By btnReply = By.xpath("(//img[@title='Reply'])[1]");
    public By btnReplyAll = By.xpath("(//img[@title='Reply all'])[1]");
    //new xpath up ABOVE
    public By eleMailSentSuccessMessage = By.xpath("//span[text()='Mail has been sent.']");
    public By btnSendStatusChangeMail = By.xpath("//input[@id='sendMailBtn']");
    public By txtBoxMailTemplateBody = By.xpath("//iframe[@id='mailTemplateBody']");
    public By txtBoxMailTemplateSubject = By.xpath("//input[@id='mailTemplateSubject']");
    public By eleStatusChangeSuccessMessage = By.xpath("//span[text()='Application status has been successfully changed to ${status}']");
    public By btnSendEmail = By.xpath("//a[text()='Send Email']");
    public By ddStatusChange = By.xpath("//span[@class=\" outerArow\"]");
    public By eleStatusChange = By.xpath("//ul[@class=' statusNav intround']//*[contains(text(),'${status}')]");
    public By eleMailboxTab = By.id("inboxTab");
    public By eleProfileTab = By.id("profileTab");
    public By eleMailboxTabCount = By.xpath("//span[@id='totalCount']");
    public By lblRequirementName = By.xpath("//span[@class[contains(.,'req-name')]]");
    public By lblThreadSubject = By.xpath("(//span[@class='thread-subject'])[1]");
    public By imgSendMailArrow = By.xpath("(//img[@src[contains(.,'arrow-bottom-left')]])[1]");
    public By eleConversation = By.xpath("//div[@class='thread-header']//following-sibling::div");
    public By eleCandidateName = By.xpath("(//strong[contains(@class , 'candName')]/a)[1]");
    public By lblDateTime = By.xpath("//div[@class='delivered-blk']");
    public By txtsubjectFieldInput = By.xpath("//div[contains(@class , 'subject')]/input|//input[@id='mailTemplateSubject']");
    public By lblUpdatedThreadSubject = By.xpath("//span[@class='thread-subject' and contains(.,'${lblSubject}')]");
    public By txtReplyToEmail = By.xpath("//input[@id='inp_contactLst']");
    public By chkRplyToEmail = By.xpath("(//ul[@id='ul_contactLst']//li)/a[1]");
    public By btnForwardMail = By.xpath("//small[@class[contains(.,'forwardIc')]]");
    public By eleProgressBar = By.xpath("extends BaseAutomation{");
    private By ddlDocumentArrow=By.xpath("//span[@class='dropArrowDD']");
    private By eleDocumentType=By.xpath("//ul[@class='dropdown ']//li//span[contains(.,'${Select All}')]");
    private By btnRequest=By.xpath("//button[contains(text(),'Request')]");
    private By chkTermAndCondition=By.xpath("//div[@class[contains(.,'legalRequestDoc')]]/label");
    private By btnRequestDocument =By.xpath("//a[@id='scrollToRequest']");
    private By btnRequirementOnCandidatePage=By.xpath("//small[@class[contains(.,'viewIc')]]//following-sibling::a");
    private By ddlInterviewer=By.xpath("//div[@id[contains(.,'intrvwEmail')]]//div[@class='DDwrap']");
    private By chkInterviewEmail=By.xpath("//li[@class='optgroup']//a[contains(.,'${InterviewEmail}')]");
    public By emailpage=By.xpath("//span[@id='emailIdForDisplay']");
    public By mailBodyFrame = By.id("mailTemplateBody");
    public By previewMessageBody = By.id("mailBodyData");
    public By lblCandidateemailId= By.xpath("//div[@id='candCont']//div//div//a");
    public By Ccmail=By.xpath("//input[@class='mailTextF' and @placeholder='Enter email']");
    public By eleCandidatePersonalMailSubject = By.xpath("(//td[@class='col-xs-5 ng-binding' and @ng-show='!msg.isVisible'])[1]");
    public By eleCandidatePersonalMailBody = By.xpath("//td[@id='mailBodyData']");
    public By eleCandidatePersonalFullMailBody=By.xpath("//div[@id=\"mailLayoutDiv\"]");
    public By eleCandidatePersonalMailToID = By.xpath("//td[@class='col-xs-4']//strong[1]");
    public By txtCCMailBody = By.xpath("//div[@class='message-body']");
    public By eleCCMailBoxToMail = By.xpath("//div[@class='sender-name clr6e']//span");
    public By eleConfigureEmail = By.xpath("//span[@id='configuredEmailLabel']");
    public By eleCandidateMailToID = By.xpath("//strong[contains(text(),'${mailtoid}')]");
    public By attachmentCCMailBox=By.xpath("//div[@class='message-container   opened ']//span[@class='atcmnt-name']");
    private By txtContactlistTo=By.id("inp_contactLst");
    private By txtMailCC=By.xpath("//label[contains(.,'Cc')]/..//input[@class='mailTextF']|//input[@id='inp_ccObjectList']|//input[@id='ccIdchipsArr']");
    private By txtMailCCChip=By.xpath("//input[@id='ccIdchipsArr' or @class='mailTextF' or @id='inp_ccObjectList']");

    public By eleCandidateCurrentCompanyOnCVDetail = By.xpath("//em[contains(text(),'Current Company:')]//following-sibling::span");
    public By eleCandidateCurrentDesignationOnCVDetail = By.xpath("//em[contains(text(),'Current Designation: ')]//following-sibling::span");
    public By eleCandidatePhoneNumberOnCVDetail = By.xpath("//span[@id=\"candidatePhoneId\"]");
    public By eleRequirementNameMailboxTab = By.xpath("//span[@class='req-name clr3b']");
    public By eleRequirementStatusOnReqDashboard = By.xpath("//div[@class='fl projectStatus pRel']/a");
    public By eleRequirementLocationOnReqDashboard = By.xpath("//div[@class='prosubHead']/following-sibling::p[5]");
    public By eleCandidateCurrentStageOnCVDetail = By.xpath("//span[@class='interTxt ']");
    public By eleCandidateNameOnCVDetail = By.xpath("//div[@data-highlight=\"name\"]");
    public By eleRequirementNameOnCVDetail = By.xpath("//small[contains(@class,'viewIc')]/following-sibling::a");
    public By eleRequirementDetailsTab = By.id("smtabRequirement");
    public By eleFromFieldMailboxTab = By.xpath("(//div[contains(@class,'sender-name')])[1]/span");
    public By eleToFieldMailboxTab = By.xpath("(//div[contains(@class,'message-to')])[1]");
    public By eleCCFieldMailboxTab = By.xpath("(//div[contains(@class,'message-to')])[2]");
    public By eleMailBodyMailboxTab = By.xpath("//div[@class='message-body']");
    public By eleMailSubjectMailboxTab = By.xpath("(//span[@class='thread-subject'])[1]");
    public By eleUserName = By.xpath("//div[@class='settingOuter']//a[@id='gnbSettingLinkUserNameTextId']");
    public By eleCurrentStatus = By.xpath("//a//span[text()='${status}']");
    public By eleReject = By.xpath("//a[contains(text(),'Reject')]");
    public By eleCandidateImage = By.xpath("//div[contains(@class,\"canPic\")]//img[contains(@id,\"logo\")]");
    public By eleRequirementNameOnReqDashboard = By.xpath("//span[text()='Requirement:']//parent::div/parent::div");
    public By eleAssessmentMailBodyMailboxTab = By.xpath("(//div[@id='mailLayoutDiv']//tbody)[1]");
    public By eleMailBodyRightFacet = By.xpath("//td[@id='mailBodyData']");
    public By eleStartTestAssessmentMail = By.xpath("//a[contains(text(),'Start Test')]");
    public By btnDeleteProfile = By.id("delApplicationTrigger");
    public By btnDeleteOnConformationBox = By.id("deleteApplicationBtn");
    public By eleDeletionSuccessMessage = By.xpath("//div[@class='botErrText']");
    public By eleSubjectReplyAll = By.id("mailTemplateSubject");
    public By eleReplyAllSecondMailInThread = By.xpath("(//img[@title='Reply all'])[2]");
    public By eleConfiguredEmailId = By.xpath("//span[contains(text(),'${configuredEmailid}')]");
    public By eleNoOfEmails = By.xpath("//span[contains(text(),\"Master Profile\")]/following-sibling::span/span[contains(text(),\"No of Emails:\")]");
    public By eleLastActive = By.xpath("//span[contains(text(),\"Master Profile\")]/following-sibling::span/span[contains(text(),\"Last Active:\")]");
    public By eleEditSignature = By.xpath("//a[@id=\"signLink\"]");
    public By iframeContent=By.xpath("//iframe[@id='sigBodyEditor']");
    public By eleUnsubscribe = By.xpath("//a[contains(text(),\"Unsubscribe\")]");
    public By textUnderSignature = By.xpath("//body");
    public By eleCandidateEmailTag = By.xpath("//li[text() =\"Candidate Email\"]");
    public By eleMailbodyIframe = By.xpath("(//iframe[@class=\"hh__frame\"])[1]");
    public By eleAssementHeader = By.xpath("//span[contains(@title,'Test has been sent')]");


    //Variables
    public static String candidateProfileImageUrl;
    public static String configureEmailText;
    public static String candidatePersonalMailToID;
    public static String candidatePersonalMailToIDsplit;
    public static String CCMailBoxToMail="null";
    public String candidatEmailOnCCPage;
    public static  Map<String, String> candidateInfoOnCVDetailPage = new HashMap<>();
    public static Map<Object, Object> hmapCandidatePersonalMailBox;
    public static Map<Object, Object> hmapCCMailBoxMailContent;
    public static Map<Object, Object> hmapForwardMailBoxContent;
    public String flowType = "null";
    public String forwardEmailCC;
    public String ccAttachmentname;
    boolean valueAttachmentCCMailBox;
    boolean candidateFullMailBody;
    boolean candidateMailBody;

    GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
    ApprovalTemplateListingPO approvalTemplateListingPO = new ApprovalTemplateListingPO();
    CommonAction commonAction = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);

    //CommunicationInboxPO communicationInboxPO = (CommunicationInboxPO) PageObjectWrapper.getObject(CommunicationInboxPO.class);
    // CommunicationInboxPO communicationInboxPO = new CommunicationInboxPO();
    /**
     * This method use to removeAutomaticMailerForStage.
     * @param stage name
     * @author nikhil.bhatia
     */
    public void removeAutomaticMailerForStage(String stage){
        click(eleMailSettings);
        pageRefresh();
        if (getElement(eleStageAutomaticMailer,stage).getText().equalsIgnoreCase("Not AutomatedSet a template"));
        else{
            getElement(eleDeleteAutomaticMailerForStage,stage).click();
            wait.hardWait(10);
            TestNGLogUtility.info("deleting mapping");
        }

    }

    /**
     * This method use to set Default Automatic Mailer For Stage.
     * @param stage name
     * @author ambar.gupta
     * @return Automation mail Status for the stage
     */
    public String setDefaultAutomaticMailerForStage(String stage) {
        String automatedMailStatus = getText(parameterizedLocator(eleStageAutomaticMailer, stage));
        if (automatedMailStatus.equalsIgnoreCase("Not AutomatedSet a template")) {
            jsUtil.scrollDown(parameterizedLocator(eleStageAutomaticMailerDD,stage));
            hover(parameterizedLocator(eleStageAutomaticMailerDD,stage));
            click(parameterizedLocator(eleSetDefaultAutomaticMailer,stage));
            wait.hardWait(2);
            automatedMailStatus = getText(parameterizedLocator(eleStageAutomaticMailer, stage)).trim();
        }
        return automatedMailStatus;
    }


    /**
     * This method is use to  verify mail block i.e status change ,interview and offer block that comes under mailbox tab
     * @param venue ,hour,minutes
     * @author nikhil.bhatia
     * @return boolean
     */
    public boolean verifyMailBlock(String statusType ,String blockValue0, String blockValue2) {
        String statusBlockValues = PropFileHandler.readProperty(statusType);
        String[] blockValues = statusBlockValues.split(",");
        if(statusType.equals("Interview")){
            if(getElement(eleStatusChangeBlock, blockValues[0]).isDisplayed() && getElement(eleStatusChangeBlock, blockValues[1]).isDisplayed())
                return (getElement(eleStatusChangeBlockText, blockValues[0]).getText().equals(blockValue0));
        }
        if (getElement(eleStatusChangeBlock, blockValues[0]).isDisplayed() && getElement(eleStatusChangeBlock, blockValues[1]).isDisplayed() &&
                getElement(eleStatusChangeBlock, blockValues[2]).isDisplayed()) {
            return (getElement(eleStatusChangeBlockText, blockValues[0]).getText().equals(blockValue0) && getElement(eleStatusChangeBlockText, blockValues[2]).getText().equals(blockValue2));
        } else {
            return false;
        }
    }

    /**
     * This method is use to scheduleInterview
     * @param venue ,hour,minutes
     * @author nikhil.bhatia
     */

    public void scheduleInterview(String venue,String hour,String minutes){
        sendKeys(eleVenueForInterview,venue);
        click(eleCalendarIconInterview);
        click(eleSetDateForInterview);
        sendKeys(eleSetHourForInterview,hour);
        sendKeys(eleSetMinutesForInterview,minutes);
    }

    /**
     * This method use check noMailsToShowIsDisplayed
     *
     * @author nikhil.bhatia
     */
    public boolean noMailsToShowIsDispalyed(){
        return (isDisplayed(eleNoMailsToShow)&& isDisplayed(eleNoMailsToShowCandidateText) && isDisplayed(imgNoMailIcon));
    }

    /**
     * This method use to click on setInterviewStage.
     *
     * @author nikhil.bhatia
     */
    public void clickOnsetInterviewStage(){
        click(btnSetInterviewStage);
        wait.hardWait(3);
        wait.waitForPageToLoadCompletely();
    }

    /**
     * This method use to click on setInterviewStage.
     *
     * @author nikhil.bhatia
     */
    public void clickOnEmailCandidateButton(){
        wait.waitForInvisibilityOfElement(5, 3, btnEmailCandidate);
        if(isDisplayed(btnEmailCandidate)) {
            click(btnEmailCandidate);}
    }
    /**
     * This method use to click on ManagePermission
     *
     * @author nikhil.bhatia
     */
    public void clickOnManagePermission(){
        wait.waitForVisibilityOfElement(btnManagePermission);
        click(btnManagePermission);
    }

    //settings page candidate communication functions
    /**
     * This method use to enable and disable reply from mailboxtab
     * @param permission
     * @author nikhil.bhatia
     */
    public void ccReplySetting(String permission) {
        // List<String> permissions = dt.asList(String.class);
        //  for (int i=0;i<permissions.size();i++) {
        if (permission.equals("Grant Permission")) {
            if (isDisplayed(btnGrantPermission)){
                clickOnGrantPermissionButton();
                wait.waitForVisibilityOfElement(btnRevokePermission);}
        } else if (permission.equals("Revoke Permission")) {
            if (isDisplayed(btnRevokePermission)){
                clickOnRevokePermissionButton();
                wait.waitForVisibilityOfElement(btnGrantPermission);}
        }
    }
    /**
     * This method is used to openSpecificURL
     *
     * @author Nikhil.Bhatia
     */
    public void openSpecificURL(String URL) {
        genericFunction.launchSpecificURL(URL);
        wait.waitForPageToLoadCompletely();
    }

    /**
     * This method use to clickOnGrantPermissionButton.
     *
     * @author nikhil.bhatia
     */
    public void clickOnGrantPermissionButton() {
        click(btnGrantPermission);
        wait.waitForVisibilityOfElement(btnPermissionConfirmationOnLightbox);
        click(btnPermissionConfirmationOnLightbox);
    }
    /**
     * This method use to clickOnSendMail.
     *
     * @author nikhil.bhatia
     */
    public void clickOnSendMail() {
        jsUtil.scrollMid(btnSendMessage);
        wait.waitForVisibilityOfElement(btnSendMessage);
        jsUtil.clickByJS(btnSendMessage);
        wait.hardWait(10);
    }

    /**
     * This method use to check message on top of conversation contains same message that was sent.
     *
     * @author nikhil.bhatia
     */
    public boolean checkMessage(String message){
        return getText(eleFirstMessageOnPage).contains(message);
    }

    /**
     * This method use to hoverOnRecentlySentMessageIsDisplayed.
     *
     * @author nikhil.bhatia
     */
    public boolean hoverOnRecentlySentMessageIsDisplayed(){
        return getElement(eleHoverRecentlySentMsg).isDisplayed();
    }

    /**
     * This method use to clickOnRevokePermissionButton.
     *
     * @author nikhil.bhatia
     */
    public void clickOnRevokePermissionButton() {
        click(btnRevokePermission);
        wait.waitForVisibilityOfElement(btnPermissionConfirmationOnLightbox);
        click(btnPermissionConfirmationOnLightbox);

    }

    /**
     * This method use to clickOnManagePermissionButton.
     *
     * @author nikhil.bhatia
     */
    public void clickOnManageProfileButton() {
        click(btnManageProfile);
    }

    /**
     * This method use to fill message body in message box under Mailbox Tab for reply and reply all option.
     *
     * @author nikhil.bhatia
     */
    public String fillMessageBody(String message) {
        wait.waitForVisibilityOfElement(btnSendMessage);
        wait.waitForVisibilityOfElement(eleMessageBody);
        jsUtil.scrollMid(eleMessageBody);
        sendKeys(eleMessageBody,message);
        getText(eleMessageBody);
        jsUtil.scrollDown(btnSendMessage);
        return message;
    }

    /**
     * This method use to attach document.
     *
     * @author nikhil.bhatia
     */
    public void addAttachment(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('mailAttachment').setAttribute('style', 'display:block')");
        String filepath = getAppConfigValue("TestData.OfferLetterPathLessThan5MB");
        driver.findElement(By.id("mailAttachment")).sendKeys(System.getProperty("user.dir")
                + "/src/test/resources/testdata/OfferManagement/TestOfferLetterSample.docx");
    }
    /**
     * This method use to click on Reply Button in message box under Mailbox Tab.
     *
     * @author nikhil.bhatia
     */
    public void clickOnReplyButton() {
        jsUtil.scrollDown(eleFirstMessageOnPage);
        hover(eleFirstMessageOnPage);
        wait.waitForVisibilityOfElement(btnReply);
        click(btnReply);
    }

    public boolean sendMessageIsDisplayed(){
        return isDisplayed(btnSendMessage);
    }

    /**
     * This method use to click on Reply All Button in message box under Mailbox Tab.
     *
     * @author nikhil.bhatia
     */
    public void clickOnReplyAllButton() {
        jsUtil.scrollDown(eleFirstMessageOnPage);
        hover(eleFirstMessageOnPage);
        jsUtil.clickByJS(btnReplyAll);
        if(isDisplayed(eleMessageBody)) {
            jsUtil.scrollMid(eleMessageBody);
        }
    }

    /**
     * This method use to get content in iframe editor
     *
     * @author nikhil.bhatia
     * @param String
     *
     */
    public String getContentIframe(By by) {
        wait.hardWait(1);
        switchToFrame(eleMailbodyIframe);
        String body =  getElement(by).getText();
        switchToDefaultContent();
        return body;
    }


    //new code above
    /**
     * This method use to verify presence of element on Mail box page
     *
     * @param labelName Present on the page
     * @return true/false
     * @author abhishek.dwivedi
     */
    public boolean validatePresenceOfElementsOnMailTemplate(String mailBoxPageLabelName) {
        boolean flag = false;
        switch (mailBoxPageLabelName.toString()) {
            case "Mailbox Tab":
                flag = getElement(eleMailboxTab).isDisplayed();
                break;
            case "Profile Tab":
                flag = getElement(eleProfileTab).isDisplayed();
                break;
            case "Conversation":
                flag = getElement(eleConversation).isDisplayed();
                break;
            case "RequirementName":
                flag = getElement(lblRequirementName).isDisplayed();
                break;
            case "ThreadSubject":
                flag = getElement(lblThreadSubject).isDisplayed();
                break;
            case "SendMailArrow":
                flag = getElement(imgSendMailArrow).isDisplayed();
                break;
            case "MailboxTabCount":
                flag = getElement(eleMailboxTabCount).isDisplayed();
                break;
            case "Message DateTime":
                flag = getElement(lblDateTime).isDisplayed();
                break;
        }
        return flag;
    }

    /**
     * This method use to click on Mail box tab on the cv detail page
     *
     * @author abhishek.dwivedi
     */
    public void clickOnMailBox() {
        pageRefresh();
        wait.waitForVisibilityOfElement(eleMailboxTabCount);
        wait.waitForElementToBeClickable(eleMailboxTab);
        getElement(eleMailboxTab).click();
    }

    /**
     * This method use to click on candidate Name, switch focus on the candidate
     * detail page and move to the specific candidate detail page
     *
     * @author abhishek.dwivedi
     */
    public void clickOnCandidateNameAndSwtchToWindow() {
        getElement(eleCandidateName).click();
        genericFunction.switchToWindow();
        genericFunction.launchSpecificURL(PropFileHandler.readProperty("viewcandidateDetailsUrl") + PropFileHandler.readProperty("candidateIdForCandidateCommunication"));

    }

    /**
     * This method use check the current mail count , refresh the page and get the updated mail count
     * and return true if the mail count is changed
     *
     * @return true/false
     * @author abhishek.dwivedi
     */
    public boolean refreshPageAndGetUpdatedMailCount() {
        String previousMailCount = getElement(eleMailboxTabCount).getText().replaceAll("[^0-9]", "");
        if(previousMailCount.equals("")){previousMailCount = "0";}
        System.out.println(previousMailCount);
        wait.hardWait(20);
        driver.navigate().refresh();
        wait.waitForVisibilityOfElement(eleMailboxTabCount);
        //wait.hardWait(10);
        String updatedMailCount = getElement(eleMailboxTabCount).getText().replaceAll("[^0-9]", "");
        if(updatedMailCount.equals("")){updatedMailCount = "0";}
        System.out.println(updatedMailCount);
        if (Integer.parseInt(updatedMailCount) >= Integer.parseInt(previousMailCount) + 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method use to fill the subject of the mail
     *
     * @param mailSubject provided
     * @author abhishek.dwivedi
     */
    public void fillMailSubject(String mailSubject) {
        sendKeys(txtsubjectFieldInput, mailSubject);
    }

    /**
     * This method use to fill the subject of the mail
     *
     * @param mailSubject provided
     * @return true/false
     * @author abhishek.dwivedi
     */
    public boolean isUpdatedThreadSubjectDisplayed(String mailThreadSubject) {
        wait.waitForVisibilityOfElement(eleContainsAttachmentFilter);
        return isDisplayed(By.xpath("//span[@class='thread-subject' and contains(.,'" + mailThreadSubject + "')]"));
    }

    /**
     * This method use to fill the Reply To Email
     *
     * @author abhishek.dwivedi
     */
    public void fillReplyToEmail() {
        getElement(txtReplyToEmail).click();
        getElement(chkRplyToEmail).click();

    }

    /**
     * This method use to click on Forward mail option on candidate page
     *
     * @author abhishek.dwivedi
     */
    public void clickForwardMailButton() {
        getElement(btnForwardMail).click();
        wait.waitForInvisibilityOfElement(10, 3, eleProgressBar);
        flowType="forward";
    }

    /**
     * This method use to click on send email button for composing mail on non Interview stages
     *
     * @author nikhil.bhatia
     */
    public void clickOnSendEmail() {
        if(isDisplayed(btnSendEmail)) {
            getElement(btnSendEmail).click();
            wait.waitForVisibilityOfElement(txtBoxMailTemplateSubject);
        }
    }
    /**
     * This method use to click on send email button for triggering mail after composing non Interview stages
     *
     * @author nikhil.bhatia
     */
    public void clickOnSendStatusChangeMail() {
        getElement(btnSendStatusChangeMail).click();
        wait.waitForPageToLoadCompletely();
    }
    /**
     * This method use to check success strip after mail sent on non Interview stages
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean successMessageForMailSentIsDisplayed() {
        return isDisplayed(eleMailSentSuccessMessage);
    }
    /**
     * This method use to set subject while composing mail on non Interview stages
     * @param subject of mail
     * @author nikhil.bhatia
     */
    public void setMailTemplateSubject(String subject) {
        sendKeys(txtBoxMailTemplateSubject, subject);
    }
    /**
     * This method use to set body while composing mail on non Interview stages
     * @param body of mail
     * @author nikhil.bhatia
     */
    public void setMailTemplateBody(String body) {
        switchToFrame(txtBoxMailTemplateBody);
        getElement(By.tagName("body")).sendKeys(body);
        switchToDefaultContent();
    }

    /**
     * This method use to do status change of any candidate
     * @param status change of candidate
     * @author nikhil.bhatia
     */
    public void setStatus(String status) {
        if(isDisplayed(eleCurrentStatus,status)) {
            click(eleReject);
            wait.waitForProcessingToDisappear(10,3);
        }
        jsUtil.scrollUp();
        click(ddStatusChange);
        if (status.contains("-")) {
            String statusSubString = status.substring(status.indexOf("-"), status.length());
            getElement(eleStatusChange, statusSubString).click();
            wait.waitForProcessingToDisappear(10,3);
        } else {
            getElement(eleStatusChange, status).click();
            wait.waitForProcessingToDisappear(10,3);
        }
    }
    /**
     * This method use to click on Request Document Link on candidate page
     * @author abhishek.dwivedi
     *
     */
    public void clickRequestDocumentLink() {
        getElement(btnRequestDocument).click();
    }

    /**
     * This method use to click on cc checkbox comes under status change lightbox
     * @author nikhil.bhatia
     *
     */
    public void ccMailCheckbox() {
        click(checkBoxCCMailLightbox);
    }
    /**
     * This method use to click on Document dropdown
     * @author abhishek.dwivedi
     *
     */
    public void clickOnDocumentDropDown() {
        getElement(ddlDocumentArrow).click();

    }
    /**
     * This method use to select value from Document dropdown
     * @author abhishek.dwivedi
     *
     */
    public void selectOptionFromDocumentDropDown(String option) {
        getElement(eleDocumentType,option).click();

    }

    /**
     * This method use to click on Request button on candidate page
     * @author abhishek.dwivedi
     *
     */
    public void clickRequestButton() {
        wait.waitForVisibilityOfElement(btnRequest);
        getElement(btnRequest).click();
    }
    /**
     * This method use to click on Term and Condition check box request Document page
     * @author abhishek.dwivedi
     *
     */
    public void clickTermandConditionCheckBox() {
        jsUtil.scrollDown(chkTermAndCondition);
        getElement(chkTermAndCondition).click();
    }
    /**
     * This method use to click on candidate Name, switch focus on the candidate
     * detail page
     *
     * @author abhishek.dwivedi
     */
    public void clickOnCandidateNameAndSwtchToWindowCandidateDetailPage() {
        wait.waitForPageToLoadCompletely();
        jsUtil.scrollUp();
        wait.waitForVisibilityOfElement(eleCandidateName);
        click(eleCandidateName);
        genericFunction.switchToWindow();
    }
    /**
     * This method use to click on Requirement Name on candidate page
     * @author abhishek.dwivedi
     *
     */
    public void clickRequirementOnCandidateDetailsPage() {
        jsUtil.scrollUp();
        wait.waitForVisibilityOfElement(btnRequirementOnCandidatePage);
        getElement(btnRequirementOnCandidatePage).click();
        switchToChildWindow();
        wait.hardWait(3);
    }
    /**
     * This method use to close Requirement Detail page and switch to  candidate detail page
     * @author abhishek.dwivedi
     *
     */
    public void closeRequirementpageAndSwitchBacktoCandidateDetailPage() {
        closeWindow();
        switchToParentWindow();
    }

    /**
     * This method is use set Interview email from the drop down
     *
     * @param Interviewer Email
     * @author abhishek.dwivedi
     */

    public void setInterviewerEmail(String interviewEmail) {
        getElement(ddlInterviewer).click();
        if (getElement(chkInterviewEmail, interviewEmail).isDisplayed()) {
            getElement(chkInterviewEmail, interviewEmail).click();
            getElement(eleVenueForInterview).click();

        }
    }
//
//    /**
//     * This method use to check Configured Email
//     * @author avani
//     */
//    public void candidateCommunicationSetting() {
//        genericFunction.launchSpecificURL(PropFileHandler.readProperty("RmsManageYourProfile"));
//        configureEmailText = getText(eleConfigureEmail);
//    }

    /**
     * This method use to fill Forward Mail body
     * @author avani
     */
    public void fillforwardmailbody(String txtforwardmailbody) {
        switchToFrame(mailBodyFrame);
        if(!getElement(By.tagName("body")).equals(null)){
            getElement(By.tagName("body")).clear();
            getElement(By.tagName("body")).sendKeys(txtforwardmailbody);}
        else {
            getElement(By.tagName("body")).sendKeys(txtforwardmailbody);
        }
        switchToDefaultContent();
        wait.hardWait(10);
    }

    /**
     * This method use to fill Forward ToMailId
     *
     * @author avani
     * @author abhishek.dwivedi
     * @param forwardToField i.e email id to be entered in To field
     */
    public void forwardToField(String forwardToField) {
        wait.hardWait(3);
        if (isDisplayed(txtMailCC)) {
            sendKeys(txtMailCC, forwardToField);
            if (isDisplayed(chkRplyToEmail)) {
                getElement(chkRplyToEmail).click();
            }
            getElement(txtMailCCChip).sendKeys(Keys.ENTER);
        } else if (isDisplayed(txtContactlistTo)) {
            sendKeys(txtContactlistTo, forwardToField);
            if (isDisplayed(chkRplyToEmail)) {
                getElement(chkRplyToEmail).click();
            }
            else {
                getElement(txtContactlistTo).sendKeys(Keys.ENTER);
            }
        }
    }
    /**
     * This method use to create  Hashmap of  Candidate Communication Mailbox
     * @return Hashmap of Candidate Communication MailBOx content
     * @author avani
     */
    public Map<Object, Object> getDataCandidateCommunicationMailBox() {
        hmapCCMailBoxMailContent = new HashMap<Object, Object>();
        candidatEmailOnCCPage = getElement(lblCandidateemailId).getText();
        hmapCCMailBoxMailContent.put("Subject","\""+getText(lblThreadSubject)+"\"");
        getElement(eleCCMailBoxToMail).click();
        CCMailBoxToMail=getText(eleCCMailBoxToMail);
        if(candidateFullMailBody){
            hmapCCMailBoxMailContent.put("MailBody", getText(eleCandidatePersonalFullMailBody));
        }else {
            hmapCCMailBoxMailContent.put("MailBody", getText(txtCCMailBody));
        }
        if(CCMailBoxToMail.equalsIgnoreCase("You")){
            String youCaseCCMailBoxToMail = YamlReader.getAppConfigValue("Users.Enterprise.Superuser.username");
            int index = youCaseCCMailBoxToMail.indexOf('@');
            String youCaseCCMailBoxToMailSplit =youCaseCCMailBoxToMail.substring(0, index);
            hmapCCMailBoxMailContent.put("To",youCaseCCMailBoxToMailSplit);
        } else if(CCMailBoxToMail.equalsIgnoreCase("NAUKRI RMS"))
        {
            hmapCCMailBoxMailContent.put("To",PropFileHandler.readProperty("CCMailBoxToMail"));
        } else if(CCMailBoxToMail.contains("@"))
        {
            int index = CCMailBoxToMail.indexOf('@');
            String CCMailBoxToMailsplit = CCMailBoxToMail.substring(0, index);
            hmapCCMailBoxMailContent.put("To",CCMailBoxToMailsplit);
        }else {
            hmapCCMailBoxMailContent.put("To",CCMailBoxToMail);
        }
        valueAttachmentCCMailBox= isDisplayed(attachmentCCMailBox);
        if(valueAttachmentCCMailBox){
            ccAttachmentname=getText(attachmentCCMailBox);
            hmapCCMailBoxMailContent.put("Attachment Name",ccAttachmentname);
        }
        else {
            hmapCCMailBoxMailContent.put("Attachment Name", null);

        }
        return hmapCCMailBoxMailContent;
    }

    /**
     * This method use to create  hashmap of  candidate personal Email
     * @return candidate personal Email Mailbox Hashmap
     * @author avani
     */
    public Map<Object, Object> getDataCandidatePersonalMailBox() {
        hmapCandidatePersonalMailBox = new HashMap<Object, Object>();
        if (!flowType.equals("null")) {
            genericFunction.launchSpecificURL(PropFileHandler.readProperty("CandidatePersonalEmailUrl") + "inbox/" + PropFileHandler.readProperty("CandidateId"));
        } else {
            genericFunction.launchSpecificURL(PropFileHandler.readProperty("CandidatePersonalEmailUrl") + "inbox/" +candidatEmailOnCCPage );

        }
        pageRefresh();
        wait.hardWait(10);
        candidatePersonalMailToID = getText(eleCandidatePersonalMailToID);
        int index = candidatePersonalMailToID.indexOf('@');
        candidatePersonalMailToIDsplit = candidatePersonalMailToID.substring(0, index);
        String infocasecandidatePersonalMailToIDsplit=candidatePersonalMailToID.substring(0,4);
        getElement(eleCandidateMailToID, candidatePersonalMailToIDsplit).click();
        if(CCMailBoxToMail.equalsIgnoreCase("NAUKRI RMS")&&(flowType.equalsIgnoreCase("null")))
        {
            hmapCandidatePersonalMailBox.put("To", infocasecandidatePersonalMailToIDsplit);
        } else {
            hmapCandidatePersonalMailBox.put("To", candidatePersonalMailToIDsplit);
        }
        candidateFullMailBody=isDisplayed(eleCandidatePersonalFullMailBody);
        candidateMailBody=isDisplayed(eleCandidatePersonalMailBody);
        if((candidateFullMailBody)&&(candidateMailBody)){
            hmapCandidatePersonalMailBox.put("MailBody", getText(eleCandidatePersonalMailBody));
        }else{
            hmapCandidatePersonalMailBox.put("MailBody", getText(eleCandidatePersonalFullMailBody));
        }
        String source=driver.getPageSource();
        String Subject = parseStringFromPageSource(source,"subject");
        String Attachment = parseStringFromPageSource(source,"attachments\":");
        hmapCandidatePersonalMailBox.put("Subject", Subject);
        if((!flowType.equals("null"))&&(Attachment!=null)){
            hmapCandidatePersonalMailBox.put("Attachment Name",PropFileHandler.readProperty("ForwardAttachment"));
        }
        else if((valueAttachmentCCMailBox)&&(Attachment!=null)){
            hmapCandidatePersonalMailBox.put("Attachment Name",ccAttachmentname);
        } else {
            hmapCandidatePersonalMailBox.put("Attachment Name", null);
        }
        return hmapCandidatePersonalMailBox;
    }
    /**
     * This method use to create  hashmap of Forward MailBox Content
     * @return candidate personal Forward MailBox Content
     * @param mailBodySubject,txtforwardmailbody,txtforwardToField
     * @author avani
     */
    public Map<Object, Object> forwardMailBoxContent(String mailBodySubject, String txtforwardmailbody, String txtforwardToField) {
        hmapForwardMailBoxContent = new HashMap<Object, Object>();
        hmapForwardMailBoxContent.put("Subject","\""+mailBodySubject+"\"" );
        hmapForwardMailBoxContent.put("MailBody",txtforwardmailbody);
        // hmapForwardMailBoxContent.put("CC", forwardEmailCC);
        hmapForwardMailBoxContent.put("Attachment", PropFileHandler.readProperty("ForwardAttachment"));
        String forwarReplyToId = YamlReader.getAppConfigValue("Users.Enterprise.Superuser.username");
        int index = forwarReplyToId.indexOf('@');
        String forwarReplyToIdSplit = forwarReplyToId.substring(0, index);
        hmapForwardMailBoxContent.put("To", forwarReplyToIdSplit);
        return hmapForwardMailBoxContent;
    }

    /**
     * This method use to fetch the data from the mailsac source page
     * @param pageSource ,searchValue
     * @author avani
     */
    public  String parseStringFromPageSource(String pageSource,String searchValue) {
        int startIndex = pageSource.indexOf(searchValue) + searchValue.length() + 2;
        int endIndex = pageSource.indexOf(",", startIndex);
        return pageSource.substring(startIndex,endIndex);
    }

    /**
     * This method use to compare conversation between recruiter and candidate
     * Compares hashmap of Recuriter Mailbox and particular Candidate Email
     * @author avani
     */
    public boolean verifyCCMailBoxContentwithCandidatePersonalMailBox() {
        System.out.println("hmapCCMailBoxMailContent"+hmapCCMailBoxMailContent);
        System.out.println("hmapCandidatePersonalMailBox"+hmapCandidatePersonalMailBox);
        if (hmapCCMailBoxMailContent.values().toString().equals(hmapCandidatePersonalMailBox.values().toString())) {
            System.out.println("result" + (hmapCCMailBoxMailContent.toString().equals(hmapCandidatePersonalMailBox.toString())));
            return true;
        } else {
            return false;
        }

    }

    /**
     * This method use to compare conversation between recruiter and candidate
     * Compares hashmap of Recuriter forward Mailbox and particular Candidate Email
     * @author avani
     */
    public boolean verifyforwardMailBoxContentwithCandidatePersonalMailBox()
    {
        System.out.println("hmapForwardMailBoxContent"+hmapForwardMailBoxContent);
        System.out.println("hmapCandidatePersonalMailBox"+hmapCandidatePersonalMailBox);
        if (hmapForwardMailBoxContent.values().toString().equals(hmapCandidatePersonalMailBox.values().toString())) {
            System.out.println("result" + (hmapForwardMailBoxContent.toString().equals(hmapCandidatePersonalMailBox.toString())));
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used as adapter/client for main function of filtersApplied for both DD on mailboxtab and attachment
     * @param filterFromAllMails,filterAllMails,filterFromMailType,filterMailType,attachment
     * @author nikhil.bhatia
     */

    public void filtersApplied(String filterFromMailType ,String filterMailType, String filterFromAllMails ,String filterAllMails,boolean attachment){
        List<String> mailTypeFilter = new ArrayList<>();
        mailTypeFilter.add(filterFromMailType);
        List<String> allMailFilter = new ArrayList<>();
        allMailFilter.add(filterFromAllMails);
        applyFilter(mailTypeFilter,allMailFilter,attachment,filterMailType,filterAllMails);
    }

    /**
     * This method is use clickOnFilterDD for both DD on mailboxtab
     *
     * @param typeOfFilter
     * @author nikhil.bhatia
     */
    public void clickOnFilterDD(String typeOfFilter) {
        getElement(filterDD, typeOfFilter).click();
    }


    /**
     * This method is use to apply filters of all type mailtype,contains attachment and all mails for both DD on mailboxtab
     *
     * @param mailTypeFilterToBeSelected,allMailsFilterToBeSelected,allMailsFilterToBeSelected,containsAttachment,mailTypeFilter,allMailFilter
     * @author nikhil.bhatia
     */
    public void applyFilter(List<String> mailTypeFilterToBeSelected, List<String> allMailsFilterToBeSelected, boolean containsAttachment, String mailTypeFilter, String allMailFilter) {
        if (!mailTypeFilter.equals("")){clickOnFilterDD(mailTypeFilter);}
        List<WebElement> mailType = getElements(filterList);
        clickOnSelectedFilters(mailTypeFilterToBeSelected, mailType);
        if(!allMailFilter.equals("")){clickOnFilterDD(allMailFilter);}
        List<WebElement> allMails = getElements(filterList);
        clickOnSelectedFilters(allMailsFilterToBeSelected, allMails);
        if (containsAttachment) {
            click(eleContainsAttachmentFilter);
        }

    }

    /**
     * This method is use clickOnSelectedFilters for both DD on mailboxtab
     *
     * @param filterSelected,allFilter
     * @author nikhil.bhatia
     */
    public void clickOnSelectedFilters(List<String> filterSelected, List<WebElement> allFilter) {
        Map<String, WebElement> filters = allFilter.stream().collect(
                Collectors.toMap(x -> x.getText(), x -> x));
        Iterator<String> iterator = filterSelected.iterator();
        while (iterator.hasNext()) {
            filters.get(iterator.next()).click();
        }
        if(filterSelected.size()>0){click(applyFilterButton);}
    }


    /**
     * This method use to check documentRequestHeaderIsDisplayed
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean documentRequestHeaderIsDisplayed() {
        return isDisplayed(eleDocumentRequestHeader);
    }

    /**
     * This method use to check documentRequestHeaderIsDisplayed
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean reminderSentIsDisplayed() {
        return isDisplayed(eleReminderSent);
    }

    /**
     * This method use to click on SendReminder.
     *
     * @author nikhil.bhatia
     */
    public void clickOnSendReminder(){
        click(eleSendReminder);
    }

    /**
     * This method use to check offerHeaderIsDisplayed
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean offerHeaderIsDisplayed() {
        return isDisplayed(eleOfferHeader);
    }

    /**
     * This method use to check assessmentHeaderIsDisplayed
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean assessmentHeaderIsDisplayed() {
        return isDisplayed(eleAssessmentHeader);
    }

    /**
     * This method use to check Expand All Functionality
     * @return true/false
     * @author nikhil.bhatia
     */
    public boolean verifyExpandAll() {
        wait.waitForVisibilityOfElement(eleExpandAll);
        clickOnExpandAll();
        switchToFrame(eleMailbodyIframe);
        wait.waitForVisibilityOfElement(eleUnsubscribe);
        return isDisplayed(eleUnsubscribe);
    }

    /**
     * This method use to click on ExpandAll.
     *
     * @author nikhil.bhatia
     */
    public void clickOnExpandAll(){
        jsUtil.scrollMid(eleExpandAll);
        click(eleExpandAll);
    }

    /**
     * This method is use to compare mail id of candidate on tpl and in to field for reply all message component
     *
     * @author nikhil.bhatia
     */
    public boolean checkToEmailIds(){
        wait.waitForVisibilityOfElement(eleCandidateEmailId);
        wait.waitForVisibilityOfElement(eleToEmailId);
        return getText(eleCandidateEmailId).equals(getText(eleToEmailId));
    }

    /**
     * This method use to configureOutgoingEmailId.
     * @parameters EmailClient,EmailId,Password
     * @return true if set successfully and false if not set successfully
     * @author nikhil.bhatia
     *   */
    public boolean configureOutgoingEmailId(String emailClient, String emailId, String password){
        if(isDisplayed(parameterizedLocator(eleConfiguredEmailId,emailClient)))
            return true;
        click(eleEditOutgoingMail);
        if(isDisplayed(btnRevokePermission)){
            click(btnConfirmationOutgoingMail);
        }
        approvalTemplateListingPO.selectValueFromPaginationDD(emailClient);
        sendKeys(txtBoxOutgoingEmailId,emailId);
        sendKeys(txtBoxPassword,password);
        wait.waitForElementToBeClickable(btnAddEmail);
        click(btnAddEmail);
        wait.waitForVisibilityOfElement(eleOutgoingSuccessStrip);
        return isDisplayed(eleOutgoingSuccessStrip);
    }


    /**
     * This method use to checkHeaders for doc request,assessment sent, offer sent.
     * @parameters headerType
     * @return true if header displayed and reminder sent successfully and false if not set successfully
     * @author nikhil.bhatia
     */

    public boolean checkHeaders(String headerType) {
        boolean headerFlag = true;
        boolean reminderSentFlag = true;
        switch (headerType) {
            case "Documents requested":
                headerFlag = documentRequestHeaderIsDisplayed();
                clickOnSendReminder();
                reminderSentFlag = reminderSentIsDisplayed();
                break;
            case "Assessments sent":
                headerFlag = assessmentHeaderIsDisplayed();
                clickOnSendReminder();
                reminderSentFlag = reminderSentIsDisplayed();
                break;
            case "Offers sent":
                headerFlag = offerHeaderIsDisplayed();
                clickOnSendReminder();
                reminderSentFlag = reminderSentIsDisplayed();
                break;
        }
        return headerFlag && reminderSentFlag;
    }

    /**
     * To search recruiter from a list
     *
     * @author nikhil.bhatia
     */
    public void searchRecruiter(String subusername) {
        sendKeys(subUserSearchBox, subusername);
        click(searchButton);
    }


    /**
     * This method is use to fill candidate info from cv detail page
     * @author nikhil.bhatia
     * @return Map
     */
    public Map<String, String> fillCandidateInfoFromCVDetail(boolean mappedApplication) {

        candidateInfoOnCVDetailPage.put("CandidateName", getText(eleCandidateNameOnCVDetail));
        candidateInfoOnCVDetailPage.put("CurrentStage", getNotMentionedValue(eleCandidateCurrentStageOnCVDetail));
        candidateInfoOnCVDetailPage.put("CurrentDesignation", getNotMentionedValue(eleCandidateCurrentDesignationOnCVDetail));
        candidateInfoOnCVDetailPage.put("CurrentCompany", getNotMentionedValue(eleCandidateCurrentCompanyOnCVDetail));
        candidateInfoOnCVDetailPage.put("CandidatePhoneNumber", getNotMentionedValue(eleCandidatePhoneNumberOnCVDetail));
        if (!mappedApplication) {
            candidateInfoOnCVDetailPage.put("RequirementName", "No Requirement Attached");
        }
        TestNGLogUtility.info("candidateInfo" + candidateInfoOnCVDetailPage);
        return candidateInfoOnCVDetailPage;
    }

    /**
     * This method is use to fill top most mail info from cv detail page under mailbox tab
     * @author nikhil.bhatia
     * @return Map
     */
    public Map<String, String> fillMailInfoFromMailBoxTab(){
        candidateInfoOnCVDetailPage.put("From",getText(eleFromFieldMailboxTab));
        candidateInfoOnCVDetailPage.put("Subject",getText(eleMailSubjectMailboxTab));
        click(eleFromFieldMailboxTab);
        candidateInfoOnCVDetailPage.put("TO",getText(eleToFieldMailboxTab));
        candidateInfoOnCVDetailPage.put("MailBody",getMailBody());
        candidateInfoOnCVDetailPage.put("CC",commonAction.getTextByVisibility(eleCCFieldMailboxTab));
        TestNGLogUtility.info("MailInfo"+candidateInfoOnCVDetailPage);
        return candidateInfoOnCVDetailPage;
    }


    /**
     * This method is use to fill top most mail info from cv detail page under mailbox tab
     * @author nikhil.bhatia
     * @return mailbody fo the mail in mailbox tab
     */
    public String getMailBody(){
        if(isDisplayed(eleAssementHeader)) {
            return getContentIframe(eleAssessmentMailBodyMailboxTab);
        }
        else if(isDisplayed(eleToMailUnderMailboxTab)) {
            return getContentIframe(textUnderSignature).trim();
        }
        else {
            return getContentIframe(eleMailBodyRightFacet).trim();

        }
    }

    /**
     * This method is use to get requirement details from requirement dashboard
     * @author nikhil.bhatia
     * @return Map
     */
    public Map<String, String> fillRequirementDetails(){
        jsUtil.scrollMid(eleRequirementNameOnCVDetail);
        click(eleRequirementNameOnCVDetail);
        switchToChildWindow();
        wait.waitForPageToLoadCompletely();
        click(eleRequirementDetailsTab);
        candidateInfoOnCVDetailPage.put("RequirementLocation",commonAction.getTextByVisibility(eleRequirementLocationOnReqDashboard));
        candidateInfoOnCVDetailPage.put("RequirementStatus",getText(eleRequirementStatusOnReqDashboard));
        candidateInfoOnCVDetailPage.put("RequirementName", getAttribute(eleRequirementNameOnReqDashboard,"title"));
        System.out.println("Req Name"+getAttribute(eleRequirementNameOnReqDashboard,"title"));
        TestNGLogUtility.info("cv map complete"+candidateInfoOnCVDetailPage);
        return candidateInfoOnCVDetailPage;
    }

    /**
     * This method is use to check Not Mentioned Value for fields on CV detail page
     * @author nikhil.bhatia
     * @return empty string / Actual Value if it is "Not Mentioned"
     */
    public String getNotMentionedValue(By by){
        String str = "";
        if(commonAction.getTextByVisibility(by).contains("Not Mentioned")){
            return str;
        }
        else {
            return commonAction.getTextByVisibility(by);
        }
    }
    /**
     * This method is use to get Username from Any page on RMS
     * @author nikhil.bhatia
     * @return Username
     */
    public String getUsername(){
        return getAttribute(eleUserName,"title");
    }

    /**
     * This method is use to set ImageUrl from cv detail
     * @author nikhil.bhatia
     */
    public void setCandidatePhotoCvDetail(){
        pageRefresh();
        candidateProfileImageUrl= getAttribute(eleCandidateImage,"src").replaceFirst("\\?(.*?)\\&","");
        TestNGLogUtility.info("URL for image on CVdetail Page : " + candidateProfileImageUrl);
    }

    /**
     * This method is use to delete profile
     * @return true/ false
     * @author nikhil.bhatia
     */
    public boolean deleteProfile(){
        wait.waitForVisibilityOfElement(btnDeleteProfile);
        click(btnDeleteProfile);
        click(btnDeleteOnConformationBox);
        return isDisplayed(eleDeletionSuccessMessage);
    }

    /**
     * This method is use to change Subject of mail
     * @param  newSubject
     * @author nikhil.bhatia
     */
    public void changeSubject(String newSubject){
        wait.waitForVisibilityOfElement(eleSubjectReplyAll);
        sendKeys(eleSubjectReplyAll,newSubject);
    }

    /**
     * This method is use to click On ReplyAll For SecondMail in mail thread
     * @return true/ false
     * @author nikhil.bhatia
     */
    public void clickOnReplyAllForSecondMail(){
        wait.waitForVisibilityOfElement(eleReplyAllSecondMailInThread);
        click(eleReplyAllSecondMailInThread);
    }

    /**
     * This method is use to verify last active and no of email elements are displayed on master profile tuple
     * @return true/ false
     * @author nikhil.bhatia
     */
    public boolean tupleElementsIsDisplayed(){
        jsUtil.scrollToElement(eleLastActive);
        wait.waitForVisibilityOfElement(eleLastActive);
        wait.waitForVisibilityOfElement(eleNoOfEmails);
        return isDisplayed(eleLastActive) && isDisplayed(eleNoOfEmails);
    }

    /**
     * This method is use to click on edit signature
     * @author nikhil.bhatia
     */
    public void clickOnEditSignature(){
        wait.waitForVisibilityOfElement(eleEditSignature);
        click(eleEditSignature);
    }

    /**
     * This method use to fill content in iframe editor
     *
     * @author nikhil.bhatia
     * @param String
     *
     */
    public void fillContentIframe(String value) {
        switchToFrame(iframeContent);
        getElement(textUnderSignature).clear();
        getElement(textUnderSignature).sendKeys(value);
    }

    /**
     * This method is use to click on CandidateEmailTag
     * @author nikhil.bhatia
     */
    public void clickOnCandidateEmailTag(){
       // wait.waitForVisibilityOfElement(eleCandidateEmailTag);
        click(eleCandidateEmailTag);
    }

    /**
     * This method is use to get CandidateEmailId
     * @return candidate email id
     * @author nikhil.bhatia
     */
    public String getCandidateEmailId(){
        wait.waitForVisibilityOfElement(eleCandidateEmailId);
        return getText(eleCandidateEmailId);
    }
}


