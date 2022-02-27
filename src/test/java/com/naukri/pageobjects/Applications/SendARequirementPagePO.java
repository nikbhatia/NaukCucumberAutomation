package com.naukri.pageobjects.Applications;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Page Object class deals with send a requirement page object
 *
 * @author rachit.mehrotra
 *
 */
public class SendARequirementPagePO extends PageObjectWrapper {

    public By requirementLinkInDD = By.xpath("//li/a[text()=\"Send a Requirement\"]");
    public By requirementLinkOnCVDetailsPageDD = By.xpath("//ul[@class = \"subNav\"]/li/a[contains(text(),\"Send a Requirement\")]");
    public By sendARequirementLabel = By.xpath("//p[text()='Send a Requirement']");
    public By sendARequirementLabelOnCVDetailsPage = By.xpath("//ul//a[text()=\"Send a Requirement\"]");
    public By readJobTitleOfFirstCandidate = By.xpath("(//div[contains(@id , \"replaceStarRating\")]/preceding-sibling::div//a)[1]");
    public By requirementDetailsTabOnRequirementOverview = By.xpath("//a[text() = \"Requirement Details\"]");
    public By requirementNameFromRequriementOverviewPage = By.xpath("//span[text()=\"Requirement:\"]/..");
    public By listOfMailTemplatesAvailableOnLightbox = By.cssSelector("ul#ul_mailTemplateList>li>a");
    public By replyToMailIdSendARequirementLightbox = By.id("senderMailId");
    public By sendersEmailErrorMessage = By.id("from_sendMail_err");
    public By sendEmailButton = By.id("sendMailBtn");
    public By configuredMailServer = By.id("configuredMailServer");
    public By rmsMailServer = By.id("csmMailServer");
    public By mailBodyFrame = By.id("mailTemplateBody");
    public By subjectErrorMessage = By.id("mailTemplateSubject_err");
    public By mailSubjectField = By.id("mailTemplateSubject");
    public By mailSubjectErrorMessage = By.id("mailTemplateBody_err");
    public By sendACopy = By.id("chkSendEmailCC");
    public By senderEmailField = By.id("ccIdchipsArr");
    public By bccCheckBox = By.id("chkSendEmailCopy");
    public By sendACopyLabel = By.xpath("//input[@id = \"chkSendEmailCopy\"]/following-sibling::label");
    public By sendACopyToMeAsMailLabel = By.xpath("//input[@id = \"chkSendEmailCC\"]/following-sibling::label");
    public By invalidCCErrorMessage = By.id("to_sendMailcc_err");
    public By choseRequirementDD = By.id("SendMailProjectList");
    public By requirementListDDFirstRequirement = By.xpath("(//ul[@id = \"ul_SendMailProjectList\"]//a)[1]");
    public By saveThisAsANewTemplateCheckbox = By.id("chkSaveTemplate");
    public By saveThisAsANewTemplateTextField = By.id("mailTemplateName");
    public By saveThisTemplateInputFieldErrorMessage = By.id("mailTemplateName_err");
    public By successMessageFromInbox = By.xpath("//div[@class='psuccess']");
    public By mailPreviewTemplate = By.xpath("//div[@id= \"sendEmailPreview\"]//p");
    public By allApplications = By.xpath("//div[contains(@class,\"pageHead cle\")]//div/div");
    public By chooseTemplateField = By.cssSelector("input#inp_mailTemplateList");
    public By replyToMailIdText = By.id("replyToMailId");
    public By requirementAdditionProgressBar = By.id("activeProgress");
    public By duplicateCandidateLayer = By.id("dupCandidateData");
    public By cancelButtonOnDuplicateCandidateLayer = By.xpath("(//a[@id=\"close_btn\"])[1]");

    //xpaths for mailTemplateListingPage
    public By filterTemplateListingPage = By.id("templateTypeFilter");
    public By sendARequirementFilter = By.xpath("//option[text()=\"Send a Requirement\"]");
    public By requirementTemplateText = By.cssSelector("a[id*='mailTemplateName']");
    public By readFirstRequirementTemplateName = By.xpath("(//a[contains(@id , \"mailTemplateName\")])[1]");
    public By pageSize = By.cssSelector("em#totalRecord");
    public By pageCount = By.xpath("//ul[contains(@class,'pList')]//li//a[not(@class='last')]");
    By eleSuccessMessage = By.xpath("//*[contains(text(),'${textToVerify}')]");

    //Variables
    public static String requirementNameOfFirstCandidate = "";
    public static List<String> requirementMailTemplateListing = new ArrayList<String>();
    private List<WebElement> requirementMailTemplateListingPage = new ArrayList<WebElement>();
    public static List<String> requirementMailListTemplateLightbox = new ArrayList<String>();
    public static String requirementTemplateName = "";
 
    /**
     * To check the presence of send a requirement
     *
     * @author rachit.mehrotra
     * @return boolean
     */
    public boolean checkPresenceOfSendARequirementLink() {
        return isDisplayed(requirementLinkInDD);
    }

    /**
     * To check presence of send a requirement link on CV details page
     *
     * @author rachit.mehrotra
     * @return boolean
     */
    public boolean checkPresenceOfSendARequirementLinkOnCVDetailsPage() {
        return isDisplayed(requirementLinkOnCVDetailsPageDD);
    }

    /**
     * To click on send a requirement from Application inbox
     *
     * @author rachit.mehrotra
     */
    public void clickSendARequirementOptionApplicationInbox() {
        click(requirementLinkInDD);
    }

    /**
     * To check the visibility of send a requirement lightbox
     *
     * @author rachit.mehrotra
     * @return boolean
     */
    public boolean checkVisibilityOfRequirementLightbox() {
        return isDisplayed(sendARequirementLabel);
    }

    /**
     * To click on send a requirement link on CV details page
     *
     * @author rachit.mehrotra
     */
    public void clickOnSendARequirementOptionFromCVDetailsPage() {
        click(sendARequirementLabelOnCVDetailsPage);
    }

    /**
     * To get the templates for requirement from mail template listing page
     *
     * @author rachit.mehrotra
     */
    public void populateRequirementMailTemplateListing() {
        int nextPage = 1;
        int tempCout = 0;
        click(filterTemplateListingPage);
        click(sendARequirementFilter);
        wait.hardWait(10);
        requirementMailTemplateListingPage = getElements(requirementTemplateText);
        for (int i = 0; i < Integer.parseInt(getText(pageSize)); i++) {
            if (i % 40 == 0 && nextPage <= getElements(pageCount).size() / 2 && (i != 0)) {
                getElements(pageCount).get(nextPage).click();
                wait.waitForPageToLoadCompletely();
                requirementMailTemplateListingPage = getElements(requirementTemplateText);
                tempCout = 0;
                nextPage++;
            }
            requirementMailTemplateListing.add(requirementMailTemplateListingPage.get(tempCout).getAttribute("title"));
            tempCout++;
        }
    }

    /**
     * To get the templates for requirement from send a requirement listing page
     *
     * @author rachit.mehrotra
     */
    public void populateRequirementMailTemplateSendARequirementLightbox() {
        for (int i = 0; i < getElements(listOfMailTemplatesAvailableOnLightbox).size(); i++) {
            requirementMailListTemplateLightbox.add(getText(getElements(listOfMailTemplatesAvailableOnLightbox).get(i)));
        }
    }

    /**
     * To check the size of templates for requirement
     *
     * @author rachit.mehrotra
     * @return
     */
    public boolean checkSizeOfMailTemplateDD() {
    	boolean flag = getElements(listOfMailTemplatesAvailableOnLightbox).size()>0 ? true : false;
    	return flag;
    }

    /**
     * To verify the requirement template list
     *
     * @author rachit.mehrotra
     * @param requirementMailTemplateListing
     * @param requirementMailListTemplateLightbox
     * @return boolean
     */
    public boolean verifyListOfRequirementTemplateList(List<String> requirementMailTemplateListing, List<String> requirementMailListTemplateLightbox) {
        if (requirementMailTemplateListing.size() == requirementMailListTemplateLightbox.size()) {
            for (int i = 0; i < requirementMailTemplateListing.size(); i++) {
                if (!requirementMailTemplateListing.contains(requirementMailListTemplateLightbox.get(i))) {
                    TestNGLogUtility.info(Integer.toString(i));
                    TestNGLogUtility.info(requirementMailTemplateListing.get(i));
                    TestNGLogUtility.info(requirementMailListTemplateLightbox.get(i));
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * To clear Reply To mail id
     *
     * @author rachit.mehrotra
     */
    public void clearReplyToMailId() {
        if (isDisplayed(configuredMailServer)) {
            click(rmsMailServer);
        }
        getElement(replyToMailIdSendARequirementLightbox).clear();
    }

    /**
     * Add reply to mail id on send requirement link
     *
     * @author rachit.mehrotra
     * @param replyToMail
     */
    public void addEmailToReplyToMailId(String replyToMail) {
        sendKeys(replyToMailIdSendARequirementLightbox, replyToMail);
    }

    /**
     * To verify the presence of error message and context of error message
     *
     * @author rachit.mehrotra
     * @param errorText
     * @return boolean
     */
    public boolean checkForErrorMessage(String errorText) {
        return isDisplayed(sendersEmailErrorMessage) && getText(sendersEmailErrorMessage).contains(errorText);
    }

    /**
     * To click on send email button
     *
     * @author rachit.mehrotra
     */
    public void clickOnSendMailButton() {
        click(sendEmailButton);
    }

    /**
     * To fill mail body
     *
     * @author rachit.mehrotra
     * @param mailBodyText
     */
    public void fillMailBody(String mailBodyText) {
        switchToFrame(mailBodyFrame);
        getElement(By.tagName("body")).sendKeys(mailBodyText);
        switchToDefaultContent();
    }

    /**
     * To click on buttons present in footer of send a requirement lightbox
     *
     * @author rachit.mehrotra
     * @param buttonText
     */
    public void clickButtonOnLightboxFooter(String buttonText) {
    	wait.hardWait(2);
        switch (buttonText) {
            case "Send":
                click(By.id("sendMailBtn"));
                break;
            case "Preview & Send":
                click(By.id("previewMailFromCreateLB"));
                break;
            case "Cancel":
                click(By.xpath("//div[contains(@class,\"mailBtmSec\")]/a[contains(text(),\"Cancel\")]"));
                break;
        }
    }

    /**
     * To verify the presence and context of subject error message
     *
     * @param errorMessageFromUI
     * @author rachit.mehrotra
     * @return boolean
     */
    public boolean mailSubjectErrorMessage(String errorMessageFromUI) {
        return getText(subjectErrorMessage).contains(errorMessageFromUI);
    }

    /**
     * To add mail subject
     *
     * @author rachit.mehrotra
     * @param subjectText
     */
    public void addMailSubjectMessage(String subjectText) {
        sendKeys(mailSubjectField, subjectText);
    }

    /**
     * To verify the text mail body error message
     *
     * @author rachit.mehrotra
     * @param errorMessageFromUI
     * @return boolean
     */
    public boolean mailBodyErrorMessage(String errorMessageFromUI) {
        return getText(mailSubjectErrorMessage).contains(errorMessageFromUI);
    }

    /**
     * To verify the presence of send a copy to mail on requirement lightbox
     *
     * @author rachit.mehrotra
     * @param textOfLabelToVisible
     * @return boolean
     */
    public boolean checkThePresenceOfSendACopyOnRequirementLightbox(String textOfLabelToVisible) {
        jsUtil.scrollDown(sendACopy);
        return (isDisplayed(sendACopy) && getText(sendACopyToMeAsMailLabel).contains(textOfLabelToVisible));
    }

    /**
     * To check send a copy to me checkbox
     *
     * @author rachit.mehrotra
     */
    public void checkSendACopyOfThisMailCheckbox() {
        if (!getElement(sendACopy).isSelected()) {
            click(sendACopy);
        }
    }

    /**
     * To verify the content and presence of send me a copy
     *
     * @author rachit.mehrotra
     * @param textOfLabelToVisible
     * @return boolean
     */
    public boolean checkThePresenceOfSendMeACopyOnRequirementLightbox(String textOfLabelToVisible) {
        return (isDisplayed(bccCheckBox) && getText(sendACopyLabel).contains(textOfLabelToVisible));
    }

    /**
     * To verify the presence of additional CC address field
     *
     * @author rachit.mehrotra
     * @param placeholderText
     * @return boolean
     */
    public boolean checkThePresenceOfFieldForAdditionalCCAddress(String placeholderText) {
        return getAttribute(senderEmailField, "placeholder").contains(placeholderText);
    }

    /**
     * To fill the CC field
     *
     * @author rachit.mehrotra
     * @param ccFieldText
     */
    public void fillTheCCField(String ccFieldText) {
    	wait.waitForVisibilityOfElement(senderEmailField);
        sendKeys(senderEmailField, ccFieldText);
    }

    /**
     * To verify the error message of CC field
     *
     * @author rachit.mehrotra
     * @param actualMessage
     * @return boolean
     */
    public boolean checkForTheValidationOfCCMessage(String actualMessage) {
    	wait.waitForVisibilityOfElement(invalidCCErrorMessage);
        return getText(invalidCCErrorMessage).contains(actualMessage);
    }

    /**
     * To click on choose requirement DD present on send a requirement lightbox
     *
     * @author rachit.mehrotra
     */
    public void clickRequirementDD() {
        click(choseRequirementDD);
    }

    /**
     * To select first requirement from requirement DD in send a requirement
     * flow
     *
     * @author rachit.mehrotra
     */
    public void selectFirstRequirementFromDD() {
        click(requirementListDDFirstRequirement);
    }

    /**
     * To click on save template button
     *
     * @author rachit.mehrotra
     */
    public void checkSaveThisAsANewTemplate() {
        click(saveThisAsANewTemplateCheckbox);
    }

    /**
     * To verify the presence of save template
     *
     * @author rachit.mehrotra
     * @return boolean
     */
    public boolean checkPresenceOfSaveThisAsNewTemplate() {
        return isDisplayed(saveThisAsANewTemplateTextField);
    }

    /**
     * To fill in the requirement template name for send a requirement flow
     *
     * @author rachit.mehrotra
     * @param templateName
     */
    public void typeTheTemplateName(String templateName) {
        requirementTemplateName = templateName;
        sendKeys(saveThisAsANewTemplateTextField, templateName);
    }

    /**
     * To verify the error message with duplicate template name error message
     *
     * @author rachit.mehrotra
     * @param errorMessage
     * @return boolean
     */
    public boolean verifyTheErrorMessageForTemplateName(String errorMessage) {
        return getText(saveThisTemplateInputFieldErrorMessage).contains(errorMessage);
    }

    /**
     * To set the requirement template filter on template listing page
     *
     * @author rachit.mehrotra
     */
    public void setToRequirementTemplate() {
        click(filterTemplateListingPage);
        click(sendARequirementFilter);
    }

    /**
     * To verify the presence of requirement template name on template listing
     * page basis requirement name
     *
     * @author rachit.mehrotra
     * @param requirementTemplateName
     * @return boolean
     */
    public boolean verifyThePresenceOfRequirementTemplateName(String requirementTemplateName) {
        wait.hardWait(10);
        for (int i = 0; i < getElements(requirementTemplateText).size(); i++) {
            if (getElements(requirementTemplateText).get(i).getText().contains(requirementTemplateName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * To read the first requirement template name
     *
     * @author rachit.mehrotra
     */
    public void readFirstRequirementTemplateName() {
        requirementTemplateName = getText(readFirstRequirementTemplateName);
    }

    /**
     * To verify the content of success message
     *
     * @author rachit.mehrotra
     * @param successTextMessage
     * @return boolean
     */
    public boolean verifyThePresenceOfSuccessMessage(String successTextMessage) {
    	wait.waitForInvisibilityOfElement(10, 3, requirementAdditionProgressBar);
    	if(isDisplayed(duplicateCandidateLayer)) {
    		click(cancelButtonOnDuplicateCandidateLayer);
    	}
    	return isDisplayed(parameterizedLocator(eleSuccessMessage, successTextMessage.split("!")[0]+"!")) && 
    			isDisplayed(parameterizedLocator(eleSuccessMessage, successTextMessage.split("!")[1].trim()));
    }

    /**
     * To verify the presence of mail div layout
     *
     * @author rachit.mehrotra
     * @param mailLayoutDiv
     * @return boolean
     */
    public boolean verifyThePresenceOfMailDivLayout(String mailLayoutDiv) {
        return getText(mailPreviewTemplate).contains(mailLayoutDiv);
    }

    /**
     * To get application head text
     *
     * @author rachit.mehrotra
     * @param actualHeading
     * @return boolean
     */
    public boolean getApplicationHeadText(String actualHeading) {
        jsUtil.scrollUp();
        return getText(allApplications).trim().contains(actualHeading.trim());
    }
    
    /**
     * To verify the presence of disabled attribute of replyTo
     * @author rachit.mehrotra
     * @return boolean
     */
    public boolean verifyTheDisabilityOfReplyToMailId() {
    	String attributeForReplyMail = getAttribute(replyToMailIdText,"disabled");
    	boolean flag = false;
    	if(attributeForReplyMail == null)
    		flag =  false;
    	if(attributeForReplyMail.contains("true"))
    		flag = true;
    	return flag;
    }

}
