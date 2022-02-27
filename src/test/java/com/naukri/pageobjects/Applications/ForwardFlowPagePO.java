package com.naukri.pageobjects.Applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Settings.SettingsDashboardPO;
import com.naukri.test.base.PageObjectWrapper;

import scala.annotation.meta.getter;

/**
 * The page object class comprises of all the page object methods and locators used in forward flow
 * @author rachit.mehrotra
 *
 */
public class ForwardFlowPagePO extends PageObjectWrapper{
	
	//Objects
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	
	//Locators for forward lightbox
	public By forwardFlowLightboxTitle = By.xpath("//p[text()=\"Forward Mail\"]");
	public By viewPolicyLink = By.xpath("//a[text()=\"View Quota Policy\"]");
	public By quotaFieldDesc = By.id("senderMailIdQuotaMsg");
	public By chooseTemplateDD = By.id("inp_mailTemplateList");
	public By listOfForwardTemplates = By.xpath("//ul[@id = \"ul_mailTemplateList\"]/li");
	public By dmarcNoticeText = By.id("senderMailIdMsg");
	public By mailServerSelectRadio = By.id("csmMailServer");
	public By toInputField = By.id("inp_contactLst");
	public By toFieldLabel = By.xpath("//p[text()=\"To \"]");
	public By subjectInputField = By.id("mailTemplateSubject");
	public By mailTemplateBody = By.id("mailTemplateBody");
	public By includeSignatureField = By.id("includeSignature");
	public By saveTemplateField = By.id("chkSaveTemplate");
	public By companyLogoField = By.id("chkAddLogoInEmail");
	public By statusDD = By.id("subStatusId");
	public By sendMailBtn = By.id("sendMailBtn");
	public By toErrorText = By.id("to_sendMail_err");
	public By subjectErrorText = By.id("mailTemplateSubject_err");
	public By mailBodyErrorText = By.id("mailTemplateBody_err");
	public By boldEditorText = By.id("editor_BoldmailTemplateBody");
	public By tagsForSubject = By.id("tagsForSubject");
	public By tagsForBody = By.id("tagsForBody");
	public By maskingCheckbox = By.id("maskingDetails");
	public By maskingTextPresent = By.xpath("//div[@id=\"maskingDiv\"]//label");
	public By maskingWarningText = By.xpath("//div[@id=\"maskingWarning\"]//span");
	public By editCVNameCheckbox = By.id("editCVName");
	public By cvNameList = By.id("editCVNameSelect");
	public By cvNameListOptions = By.xpath("//select[@id=\"editCVNameSelect\"]/option");
	By eleToFieldInMasterProfile = By.id("toId");
	public By eleFieldNameInTagSection = By.xpath("//ul[@id='${value1}']//a[text()='${value2}']");
	public By eleSectionInTagSection = By.xpath("//a[@rel='${value1}']");
	public By eleTemplteList = By.id("inp_prefillTemp");
	public By eletemplate = By.xpath("//ul[@id='ul_prefillTemp']//a[contains(text(),'${value}')]");
	public By eletemplatePreviewColumns = By.xpath("//li[@class='table-header-row list ']//span[text()='${value}']");
	By circleLoader=By.xpath("//div[@class='circle']");
	By specificTemplateName=By.xpath("(//ul[@id=\"ul_prefillTemp\"]//a)[${value}]");
	By TemplateNameTotal=By.xpath("(//ul[@id=\"ul_prefillTemp\"]//a)");
	By uploadPasswordPopup=By.xpath("//p[@id='linkemailHeading']");
	By uploadPasswordPopupClose=By.xpath("//a[@id='updatePasswordClose']");
	By eleVariableValueInMailBody=By.xpath("//td[@id='mailBodyData' and contains(.,'${value} %')]");
	By eleAttachFiles = By.id("fileInput");
	By eleFileNameAttached = By.xpath("//ul[contains(@id,\"results\")]//div");
	By eleDeletedButtonOfDocument = By.xpath("//ul[contains(@id,\"results\")]//button");
	By elePreviewBtn = By.id("previewMailFromCreateLB");
	By elePreviewLayerSubjectKey = By.xpath("//b[contains(text(),'${subjectKey}')]");
	By eleSubjectHolderOnPreview = By.xpath("//div[(text()='${textToBeChecked}')]");
	By eleMailBody = By.id("mailBodyData");
	By eleSendMailBtnOnPreview = By.xpath("//input[contains(@value,'SEND MAIL')]");
	By eleCloseButtonOnPreview = By.xpath("//a[contains(text(),\"CLOSE\")]");
	By eleListOfTemplate = By.xpath("//ul[contains(@id,\"ul_mailTemplateList\")]//b");
	By eleAddCCLink = By.xpath("//a[contains(text(),\"Add Cc\")]");
	By eleCCTextField = By.id("inp_ccObjectList");
	By eleCCValidationErrorMessage = By.id("to_sendMailcc_err");
	By eleSenderName = By.id("mailTemplateSenderName");
	By eleCcLabelOnForward = By.xpath("//p[contains(text(),\"Cc\")]");
	By eleIncludeSignature = By.id("includeSignature");
	By eleStatusChangeOnForwardTemplate = By.id("subStatusId");
	By eleTextInfoForStatusChangeOfUnmappedProfile = By.xpath("//strong[contains(text(),\"Update Status of Profiles \")]/following-sibling::span");
	By cbAttachFeedback = By.id("attachFeedback");
	
	//product page locator
	public By headingOnPromotionPage = By.xpath("//div[@id = \"product-updates-container\"]//h1/a");
	
	//settings page locator
	public By viewList = By.id("templateTypeFilter");
	public By viewForwardList = By.xpath("//select[@id= \"templateTypeFilter\"]/option[text()=\"Forward\"]");
	public By listOfForwardTemplateName = By.xpath("//a[contains(@id,\"mailTemplateName\")]");
	
	//variables
	public static ArrayList<String> listOfForwardTemplatesName = new ArrayList<String>();
	public static ArrayList<String> listOfForwardTemplateNamesFromSettingsPage = new ArrayList<String>();
	//List of tags
	public static List<String> listOfRecruiterTags = Arrays.asList("Recruiter Name","Recruiter Email","Recruiter Company","Recruiter Mobile");
	public static List<String> listOfRequirementTags = Arrays.asList("Job Location (Country)","Requirement Industry","Job Location (City)","Desired Candidate UG","Requirement Functional Area"
			,"Desired Candidate Profile","Job Description","Work Experience","Other Salary Details","Job Title / Designation","Employment Type","Requirement Keywords","Requirement Must Have Keywords","Annual CTC","Variable CTC Percentage","Requirement Company",
			"Contact No","Contact Person","Desired Candidate PG","Desired Candidate PPG","Reference Code","Website","Group Name");
	public static List<String> listRequirementTagsConsultant = Arrays.asList("Job Location (Country)","Requirement Industry","Job Location (City)","Desired Candidate UG",
			"Requirement Functional Area","Desired Candidate Profile","Job Description","Work Experience","Other Salary Details","Job Title / Designation","Employment Type","Requirement Keywords","Requirement Must Have Keywords","Annual CTC","Variable CTC Percentage",
			"Requirement Company","Contact No","Contact Person","Desired Candidate PG","Desired Candidate PPG","Reference Code","Website","Public Employer Name","Employer Name");
	public List<String> editCVNameList = Arrays.asList("Serial-Number_First-Name_Last-Name","CV_First-Name_Last-Name","CV_Full-Name_Current-Designation","CV_Full-Name_Current-Company",
			"CV_Full-Name_Current-Designation_Current-Company","CV_Full-Name_Current-Location_Consultant-Name");
	public boolean createReuseFlag = true;
	public static String subject ="", messageBody = "";
	
	//Error Messages
	public String toErrorString = "This field cannot be left blank";
	public String subjectErrorString = "This field cannot be left blank";
	public String bodyErrorString = "Required Field can not be left blank";
	
	/**
	 * To verify the presence of forward lightbpx
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean verifyForwardLightboxTitle() {
		wait.waitForOverlayProcessingToDisappear(10, 3);
		return isDisplayed(forwardFlowLightboxTitle);
	}
	
	/**
	 * To click on View Quota Policy Link on forward lightbox
	 * @author rachit.mehrotra
	 */
	public void clickOnViewQuotaPolicyLink() {
		click(viewPolicyLink);
	}
	
	/**
	 * To verify the currrentPage URL
	 * @author rachit.mehrotra
	 * @param partContainingURL
	 * @return boolean
	 */
	public boolean verifyCurrentPageUrl(String partContainingURL) {
		return driver.getCurrentUrl().contains(partContainingURL);
	}
	
	/**
	 * To verify the text of Quota Policy
	 * @author rachit.mehrotra
	 * @param expectedTextDesc
	 * @return boolean
	 */
	public boolean verifyTheTextOfQuotaPolicy(String expectedTextDesc) {
		return getText(quotaFieldDesc).replaceAll("View Quota Policy", "").equals(expectedTextDesc);
	}
	
	/**
	 * To verify the content of QuotaLinkPolicy text
	 * @author rachit.mehrotra
	 * @param expectedLinkDesc
	 * @return boolean
	 */
	public boolean verifyTheTextOfQuotaLinkPolicy(String expectedLinkDesc) {
		return getText(quotaFieldDesc).contains(expectedLinkDesc);
	}
	
	/**
	 * To store list of all forward templates to a list
	 * @author rachit.mehrotra
	 */
	public void addForwardTemplateNameToListFromLightbox() {
		click(chooseTemplateDD);
		int forwardListLength = getElements(listOfForwardTemplates).size();
		for(int i = 0 ; i < forwardListLength ; i ++) {
			String templateName = getText(getElements(listOfForwardTemplates).get(i));
			listOfForwardTemplatesName.add(templateName);
			TestNGLogUtility.info("Template name added " + templateName);
		}
		TestNGLogUtility.info("List of Template Name "+listOfForwardTemplatesName);
	}
	
	/**
	 * To compare the list of all forward templates
	 * @author rachit.mehrotra
	 * @param fromLightbox
	 * @param fromTemplateListing
	 * @return boolean
	 */
	public boolean compareTemplateList(List<String> fromLightbox, List<String> fromTemplateListing) {
		boolean flag = true;
		if(fromLightbox.size() == fromTemplateListing.size()) {
			int size = fromLightbox.size();
			for(int i = 0 ; i < size ; i++) {
				if(!fromLightbox.get(i).equals(fromTemplateListing.get(i))) {
					TestNGLogUtility.info("From lightbox list enetry " + fromLightbox.get(i));
					TestNGLogUtility.info("From Template Listing " + fromTemplateListing.get(i));
					return false;
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * To verify the presence and content of DMARC notice 
	 * @author rachit.mehrotra
	 * @param actualMessage
	 * @return boolean
	 */
	public boolean presenceOfDmarcNoticePage(String actualMessage) {
		boolean flag = false;
		try {
			driver.findElement(mailServerSelectRadio);
			if(!getElement(By.id("defaultMailServer")).isSelected())
				click(By.id("defaultMailServer"));
			flag = getText(dmarcNoticeText).contains(actualMessage);
		} catch(Exception ex) {
			flag = getText(dmarcNoticeText).contains(actualMessage);
		}
		return flag;
	}
	
	/**
	 * To verify the presence of an element basis label text input
	 * @author rachit.mehrotra
	 * @param labelTextInput
	 * @return boolean
	 */
	public boolean verifyUIOfForwardTemplate(String labelTextInput) {
		boolean flag = false;
		switch (labelTextInput) {
		case "to":
			jsUtil.scrollDown((toInputField));
			flag = (isDisplayed(By.xpath("//*[text() = \"To \"]")));
			TestNGLogUtility.info("Visible " + labelTextInput);
			break;

		case "subject":
			jsUtil.scrollDown(subjectInputField);
			flag = (isDisplayed(By.xpath("//*[(text() = \"Subject \")]")));
			TestNGLogUtility.info("Visible " + labelTextInput);
			break;

		case "mail body":
			flag = (isDisplayed(By.xpath("//*[(text() = \"Mail Body \")]")));
			TestNGLogUtility.info("Visible " + labelTextInput);
			break;

		case "Include Signature":
			jsUtil.scrollDown(includeSignatureField);
			flag = isDisplayed(By.xpath("//*[text()=\" Include Signature  \"]"));
			TestNGLogUtility.info("Visible " + labelTextInput);
			break;

		case "save template":
			jsUtil.scrollDown(saveTemplateField);
			flag = (isDisplayed(By.xpath("//*[(text() = \"Save this as a new template\")]"))
					&& isDisplayed(saveTemplateField));
			TestNGLogUtility.info("Visible " + labelTextInput);
			break;

		case "add company logo":
			jsUtil.scrollDown(companyLogoField);
			flag = (isDisplayed(By.xpath("//*[(text() = \"Add Company logo in Email header\")]"))
					&& isDisplayed(companyLogoField));
			TestNGLogUtility.info("Visible " + labelTextInput);
			break;

		case "update status field":
			jsUtil.scrollDown(statusDD);
			flag = (isDisplayed(By.xpath("//*[(text() = \"Update Status of Profiles \")]")) && isDisplayed(statusDD));
			TestNGLogUtility.info("Visible " + labelTextInput);
			break;

		}
		return flag;
	}
	
	/**
	 * To click on forward mail button
	 * @author rachit.mehrotra
	 */
	public void clickSendForwardMailButton() {
		click(sendMailBtn);
	}
	
	/**
	 * To verify the context of error basis field descriptor in forward mail lightbox
	 * @author rachit.mehrotra
	 * @param fieldDescriptor
	 * @return String
	 */
	public String checkForValidationErrorMessage(String fieldDescriptor) {
		boolean flag = false;
		switch (fieldDescriptor) {

		case "to":
			jsUtil.scrollUp();
			flag = getText(toErrorText).contains(toErrorString);
			break;

		case "subject":
			jsUtil.scrollDown(subjectErrorText);
			flag = getText(subjectErrorText).contains(subjectErrorString);
			break;

		case "body":
			jsUtil.scrollDown(mailBodyErrorText);
			flag = getText(mailBodyErrorText).contains(bodyErrorString);
			break;
		}
		return fieldDescriptor + flag;
	}
	
	/**
	 * To fill the mail body text in forward mail layout
	 * @author rachit.mehrotra
	 * @param bodyText
	 */
	public void fillMailBodyText(String bodyText) {
		messageBody = bodyText;
		switchToFrame(mailTemplateBody);
		getElement(By.tagName("body")).sendKeys(messageBody);
		switchToDefaultContent();
	}
	
	/**
	 * To click on text editing buttons
	 * @author rachit.mehrotra
	 * @param buttonText
	 */
	public void clickOnTextEditingButtons(String buttonText) {
		switch(buttonText) {
			case "bold" : click(boldEditorText);
				  break;
		}
	}
	
	/**
	 * To get the attribute of text edit buttons
	 * @author rachit.mehrotra
	 * @param attributeValue
	 * @return boolean
	 */
	public boolean getAttributeOfButton(String attributeValue) {
		boolean flag = false;
		switch (attributeValue) {
		case "bold":
			TestNGLogUtility.info(attributeValue);
			flag = getAttribute(By.id("editor_BoldmailTemplateBody"), "class").trim().contains("selected");
			break;
		case "italic":
			TestNGLogUtility.info(attributeValue);
			flag = getAttribute(By.id("editor_ItalicmailTemplateBody"), "class").trim().contains("selected");
			break;
		case "underline":
			TestNGLogUtility.info(attributeValue);
			flag = getAttribute(By.id("editor_undermailTemplateBody"), "class").trim().contains("selected");
			break;
		case "ordered list":
			TestNGLogUtility.info(attributeValue);
			flag = getAttribute(By.id("editor_olmailTemplateBody"), "class").trim().contains("selected");
			break;
		case "unordered list":
			TestNGLogUtility.info(attributeValue);
			flag = getAttribute(By.id("editor_ulmailTemplateBody"), "class").trim().contains("selected");
			break;
		}
		return flag;
	}
	
	/**
	 * To verify the tag list basis tagSegment (requirement,candidate) and forwardDiv (subject and body)
	 * @author rachit.mehrotra
	 * @param tagSegement
	 * @param forwardDiv
	 * @return String
	 */
	public String verifyTheTagList(String tagSegement, String forwardDiv) {
		String resultText = "";
		switch (forwardDiv) {
		case "subject":
			click(tagsForSubject);
			if (tagSegement.contains("Recruiter Tags")) {
				List<WebElement> listOfSubjectRecruiterTags = getElements(
						By.xpath("//ul[@id= \"Recruiter_subject\"]//a"));
				if (!verifyListOfTags(listOfSubjectRecruiterTags, listOfRecruiterTags))
					resultText = forwardDiv + "_" + tagSegement.replace(" ", "_")
							+ verifyListOfTags(listOfSubjectRecruiterTags, listOfRecruiterTags);
				else
					resultText = "" + verifyListOfTags(listOfSubjectRecruiterTags, listOfRecruiterTags);
			} else if (tagSegement.contains("Requirement Tags")) {
				List<WebElement> listOfSubjectRecruiterTags = getElements(
						By.xpath("//ul[@id= \"Requirement_subject\"]//a"));
				if (!verifyListOfTags(listOfSubjectRecruiterTags, listOfRequirementTags))
					resultText = forwardDiv + "_" + tagSegement.replace(" ", "_")
							+ verifyListOfTags(listOfSubjectRecruiterTags, listOfRequirementTags);
				else
					resultText = "" + verifyListOfTags(listOfSubjectRecruiterTags, listOfRequirementTags);
			}
		case "body":
			click(toInputField);
			click(tagsForBody);
			if (tagSegement.contains("Recruiter Tags")) {
				List<WebElement> listOfSubjectRecruiterTags = getElements(By.xpath("//ul[@id= \"Recruiter_body\"]//a"));
				if (!verifyListOfTags(listOfSubjectRecruiterTags, listOfRecruiterTags))
					resultText = forwardDiv + "_" + tagSegement.replace(" ", "_")
							+ verifyListOfTags(listOfSubjectRecruiterTags, listOfRecruiterTags);
				else
					resultText = "" + verifyListOfTags(listOfSubjectRecruiterTags, listOfRecruiterTags);
			} else if (tagSegement.contains("Requirement Tags")) {
				List<WebElement> listOfSubjectRecruiterTags = getElements(
						By.xpath("//ul[@id= \"Requirement_body\"]//a"));
				if (!verifyListOfTags(listOfSubjectRecruiterTags, listOfRequirementTags))
					resultText = forwardDiv + "_" + tagSegement.replace(" ", "_")
							+ verifyListOfTags(listOfSubjectRecruiterTags, listOfRequirementTags);
				else
					resultText = "" + verifyListOfTags(listOfSubjectRecruiterTags, listOfRequirementTags);
			}
		}
		return resultText;
	}
	
	/**
	 * To verify tag list for consultant
	 * @author rachit.mehrotra
	 * @param tagSegement
	 * @param forwardDiv
	 * @return String
	 */
	public String verifyTheTagListForConsultant(String tagSegement, String forwardDiv) {
		String resultText = "";
		switch (forwardDiv) {
		case "subject":
			click(tagsForSubject);
			if (tagSegement.contains("Requirement Tags")) {
				List<WebElement> listOfSubjectRecruiterTags = getElements(
						By.xpath("//ul[@id= \"Requirement_subject\"]//a"));
				if (!verifyListOfTags(listOfSubjectRecruiterTags, listRequirementTagsConsultant))
					resultText = forwardDiv + "_" + tagSegement.replace(" ", "_")
							+ verifyListOfTags(listOfSubjectRecruiterTags, listRequirementTagsConsultant);
				else
					resultText = "" + verifyListOfTags(listOfSubjectRecruiterTags, listRequirementTagsConsultant);
			}
		case "body":
			click(toInputField);
			click(tagsForBody);
			if (tagSegement.contains("Requirement Tags")) {
				List<WebElement> listOfSubjectRecruiterTags = getElements(
						By.xpath("//ul[@id= \"Requirement_body\"]//a"));
				if (!verifyListOfTags(listOfSubjectRecruiterTags, listRequirementTagsConsultant))
					resultText = forwardDiv + "_" + tagSegement.replace(" ", "_")
							+ verifyListOfTags(listOfSubjectRecruiterTags, listRequirementTagsConsultant);
				else
					resultText = "" + verifyListOfTags(listOfSubjectRecruiterTags, listRequirementTagsConsultant);
			}
		}
		return resultText;
	}
	
	/**
	 * To verify the text of tags in forward layout
	 * @author rachit.mehrotra
	 * @param listOfWebElement
	 * @param actualListOfTags
	 * @return boolean
	 */
	public boolean verifyListOfTags(List<WebElement> listOfWebElement , List<String> actualListOfTags) {
		int sizeofList = listOfWebElement.size();
		for(int i = 0 ; i < sizeofList ; i++) {
			if(!listOfWebElement.get(i).getText().contains(actualListOfTags.get(i))) 
				return false;
		}
		return true;
	}
	
	/**
	 * To check presence and content in absence of tags 
	 * @author rachit.mehrotra
	 * @param informationMessageText
	 * @param divLocator
	 * @return boolean
	 */
	public boolean checkPresenceOfMessageOfAbsenceOfTags(String informationMessageText, String divLocator) {
		boolean flag = true;
		if(divLocator.contains("Choose Template")) {
			jsUtil.scrollDown(By.id("senderMailIdMsg"));
			if(!getText(By.id("senderMailIdMsg")).contains(informationMessageText)) 
				return false;
		} else if(divLocator.contains("Mail Body")) {
			jsUtil.scrollDown(By.id("fwdMailTemapleMsg"));
			if(!getText(By.id("fwdMailTemapleMsg")).contains(informationMessageText)) 
				return false;
		}
		return flag;
	}
	
	/**
	 * To verify the invisibility of tags in forward layout
	 * @author rachit.mehrotra
	 * @param divLocator
	 * @return boolean
	 */
	public boolean checkInvisibilityOfTag(String divLocator) {
		boolean flag = true;
		if(divLocator.contains("subject"))
			flag = genericFunctions.checkInvisibilityOfElement(tagsForSubject);
		if(divLocator.contains("body"))
			flag = genericFunctions.checkInvisibilityOfElement(tagsForBody);
		return flag;
	}
	
	/**
	 * To click on choose template DD
	 * @author rachit.mehrotra
	 */
	public void clickChooseTemplateDD() {
		click(chooseTemplateDD);
		TestNGLogUtility.info("Clicked on template ");
	}
	
	/**
	 * To click on specific name of template from mail template DD
	 * @author rachit.mehrotra
	 */
	public void clickOnSpecificTemplate() {
		click(By.xpath("//ul[@id = \"ul_mailTemplateList\"]//a[text()=\""+SettingsPagePO.templateName+"\"]"));
		wait.hardWait(1);
	}
	
	/**
	 * To verify the template name is selected
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean verifyTemplateNameSelectedIsDisplayed() {
		return jsUtil.executeJavascriptForJSVariables("document.getElementById('inp_mailTemplateList').value").contains(SettingsPagePO.templateName);
	}
	
	/**
	 * To verify the subject of template in place of subject text of forward mail div
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean verifySubjectText() {
		int i = 0 ; 
		wait.hardWait(2);
		while(i<20) {
			if(getAttribute(subjectInputField,"value").isEmpty())
				i++;
			else 
				return getAttribute(subjectInputField,"value").contains(SettingsPagePO.subject);
		}
		return false;
	}
	
	/**
	 * To verify the subject of template in place of body text of forward mail div
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean verifyBodyText() {
		switchToFrame(mailTemplateBody);
		String bodyText = getText(By.tagName("body"));
		switchToDefaultContent();
		return bodyText.contains(SettingsPagePO.body);
	}
	
	/**
	 * To select template basis index 
	 * @author rachit.mehrotra
	 * @param n
	 */
	public void selectNMailTemplate(int n) {
		click(By.xpath("(//ul[@id=\"ul_mailTemplateList\"]/li)["+n+"]"));
		wait.hardWait(10);
	}
	
	/**
	 * To get the subject mail
	 * @author rachit.mehrotra
	 * @return String
	 */
	public String getMailSubject() {
		jsUtil.scrollDown(subjectInputField);
		return getAttribute(subjectInputField,"value");
	}
	
	/**
	 * To get the subject body
	 * @author rachit.mehrotra
	 * @return String
	 */
	public String getMailBody() {
		jsUtil.scrollDown(mailTemplateBody);
		switchToFrame(mailTemplateBody);
		String bodyText = getText(By.tagName("body"));
		switchToDefaultContent();
		return bodyText;
	}
	
	// Mail Template Listing Page 
	/**
	 * To select the forward templates on template listing page
	 * @author rachit.mehrotra
	 */
	public void selectForwardForDownload() {
		pageRefresh();
		click(viewList);
		click(viewForwardList);
	}
	
	/**
	 * To get all the templates of forward flow from template listing page
	 * @author rachit.mehrotra
	 */
	public void readForwardTemplateFromMailTemplateListingPage() {
		int sizeOfForwardTemplate = listOfForwardTemplatesName.size();
		int size = getElements(listOfForwardTemplateName).size();
		int defaultSizeOfForwardTemplateList = Integer.parseInt(getAttribute(By.id("recordPerPage"), "value"));
		int counterOfOuterLoop = (sizeOfForwardTemplate/defaultSizeOfForwardTemplateList);
		for(int j = 0; j <= counterOfOuterLoop; j++) {
			for(int i =  0 ; i < defaultSizeOfForwardTemplateList ; i++) {
				listOfForwardTemplateNamesFromSettingsPage.add(getText(getElements(listOfForwardTemplateName).get(i)));
			}
			click(By.xpath("(//ul[contains(@class , \"pList \")]/li[last()])[1]"));
			TestNGLogUtility.info("clicked next button ");
		}
		System.out.println("listOfForwardTemplateNamesFromSettingsPage"+listOfForwardTemplateNamesFromSettingsPage.size());
		TestNGLogUtility.info(""+listOfForwardTemplateNamesFromSettingsPage);
	}
	
	//Product Promotion Page method
	/**
	 * To verify the presence of heading text of promotion page
	 * @author rachit.mehrotra
	 * @param expectedHeadingPage
	 * @return boolean
	 */
	public boolean verifyPresenceOfHeading(String expectedHeadingPage) {
		return getText(headingOnPromotionPage).toUpperCase().trim().contains(expectedHeadingPage.toUpperCase().trim());
	}
	
	/**
	 * To check the presence of the masking checkbox and verify the text next to the checkbox
	 * @author rachit.mehrotra
	 * @param maskingOption
	 * @return boolean
	 */
	public boolean verifyThePresenceOfMaskDetail(String maskingOption) {
		jsUtil.scrollDown(maskingCheckbox);
		return (isDisplayed(maskingCheckbox) && getText(maskingTextPresent).trim().contains(maskingOption.trim()));
	}
	
	/**
	 * To click the masking checkbox present on the forward template
	 * @author rachit.mehrotra
	 */
	public void clickTheMaskingCheckbox() {
		if(getAttribute(maskingCheckbox, "value").equals("off"))
			click(maskingCheckbox);
	}
	
	/**
	 * To check the presence of the warning message for masking
	 * @author rachit.mehrotra
	 * @param warningText
	 * @return boolean
	 */
	public boolean checkThePresenceOfWarningTextbox(String warningText) {
		return getText(maskingWarningText).contains(warningText);
	}
	
	/**
	 * To check/uncheck the checkbox of edit cv name before forward
	 * @author rachit.mehrotra
	 * @param stateOfCheckbox
	 */
	public void changeTheStateOfEditNameOfCV(String stateOfCheckbox) {
		String checkedAttribute = getAttribute(editCVNameCheckbox, "value");
		if(stateOfCheckbox.equals("uncheck") && checkedAttribute.equals(Integer.toString(1))) 
			click(editCVNameCheckbox);
		if(stateOfCheckbox.equals("check") && checkedAttribute.equals(Integer.toString(0)))
			click(editCVNameCheckbox);
	}
	
	/**
	 * To verify the presence of the list of CV name type
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean presenceOfListOfEditCVNameAvailable() {
		return isDisplayed(cvNameList);
	}
	
	/**
	 * To verify the length of the CV DD option
	 * @author rachit.mehrotra
	 * @param actualSize
	 * @return boolean
	 */
	public boolean lengthOfEditCVNameList(int actualSize) {
		return getElements(cvNameListOptions).size() == actualSize;
	}
	
	/**
	 * To verify the list of options for the edit cv names
	 * @author rachit.mehrotra
	 * @param optionsOfEditName
	 * @return boolean
	 */
	public boolean verifyTheListOfOptions(String optionsOfEditName) {
		List<String> optionsOfEditNameList = Arrays.asList(optionsOfEditName.split(","));
		for(int i = 0 ; i < optionsOfEditNameList.size() ; i++) {
			if(!((optionsOfEditNameList.get(i)).equals(editCVNameList.get(i))))
				return false;
		}
		return true;
	}
	
	/**
	 * To fill the to field
	 * @param toEmailStringField
	 */
	public void fillInToField(String toEmailStringField) {
		getElement(toInputField).sendKeys(toEmailStringField + Keys.ENTER);
		TestNGLogUtility.info("To " + toEmailStringField);
		click(toFieldLabel);
		TestNGLogUtility.info("To label clicked");
	}
	
	/**
	 * To fill in the subject field
	 * @param forwardSubjectText
	 */
	public void fillInForwardSubject(String forwardSubjectText) {
		subject = forwardSubjectText;
		sendKeys(subjectInputField, subject);
		TestNGLogUtility.info("Subject " + subject);
	}
	
	/**
	 * To fill in the body field
	 * @param forwardMailText
	 */
	public void fillInForwardMailBody(String forwardMailText) {
		messageBody = forwardMailText;
		switchToFrame(mailTemplateBody);
		sendKeys(By.tagName("body"), messageBody);
		switchToDefaultContent();
		TestNGLogUtility.info("body " + messageBody);
	}
	
	/**
	 * To fill in to field of master profile's forward
	 * @param toEmailId
	 */
	public void fillInToEmailForMasterProfileForward(String toEmailId) {
		sendKeys(eleToFieldInMasterProfile, toEmailId);
		TestNGLogUtility.info("To field filled with " + toEmailId);
	}
	
	/**
	 * This method click on dedicated section
	 * @author himanshu.dua
	 * @param section
	 * @param againstField
	 */
	public void clickOnSectionOnTag(String section, String againstField) {
		String value=section +"_"+againstField;
		if(againstField.contains("body"))
			hover(tagsForBody);
		else
			hover(tagsForSubject);
		click(parameterizedLocator(eleSectionInTagSection, value));
	}
	
	/**
	 * This method is verify Field tag is available in dedicated section
	 * @author himanshu.dua
	 * @param section
	 * @param fieldName
	 * @param tagAgainstField
	 * @return
	 */
	public boolean verifyfieldTagInSection(String section, String fieldName, String tagAgainstField) {
		String tagSection=section+"_"+tagAgainstField;
		return isDisplayed(parameterizedLocator(eleFieldNameInTagSection, tagSection,fieldName));
	}
	
	/**
	 * This method will select the template from list
	 * @param templateName
	 */
	public void selectTemplate(String templateName) {
		click(eleTemplteList);
		click(parameterizedLocator(eletemplate, templateName));
	}
	
	/**
	 * This method will verify the columns on tracker preview.
	 * @param columnName
	 * @return
	 */
	public boolean verifyTrackerColumnsOnPreview(String columnName) {
		wait.waitForInvisibilityOfElement(40, 5, circleLoader);
		return isDisplayed(parameterizedLocator(eletemplatePreviewColumns, columnName));
	}
	
	/**
	 * This method will verify first template name is recent created template
	 * @param templateName
	 * @return
	 */
	public boolean verifyCreatedTemplate(String templateName) {
		click(eleTemplteList);
		int size=getElements(TemplateNameTotal).size();
		System.out.println(getText(parameterizedLocator(specificTemplateName, String.valueOf(size)))+"-->>> "+ templateName);
		return getText(parameterizedLocator(specificTemplateName, String.valueOf(size))).equals(templateName);
	}
	
	/**
	 * This method will click on the close button on update password pop-up
	 */
	public void cancelUpdatePassword() {
		if(isDisplayed(uploadPasswordPopup))
			click(uploadPasswordPopupClose);	
	}
	
	/**
	 * This method will verify variable tag value on mail body
	 * @param variable
	 * @return
	 */
	public boolean verifyVariableValueOnMail(String variable) {
		return isDisplayed(parameterizedLocator(eleVariableValueInMailBody, variable));
	}
	
	/**
	 * This method will click on tag
	 * @param section
	 * @param fieldName
	 * @param tagAgainstField
	 */
	public void clickTagInSection(String section, String fieldName, String tagAgainstField) {
		String tagSection=section+"_"+tagAgainstField;
		click(parameterizedLocator(eleFieldNameInTagSection, tagSection,fieldName));
	}		
	 /**
	  * To create a file to add to attach flow of forward
	  */
	public void addFileForAttachmentInForwardLightbox() {
		if(createReuseFlag) {
			HashMap<String,String> candidateDetails = new HashMap<String,String>();
			candidateDetails.put("name", "Candidate Test");
			candidateDetails.put("email","testuser@naukri.com");
			genericFunctions.createResumeFileInDocFormat(".doc", candidateDetails);
			createReuseFlag=false;
		} 
		jsUtil.scrollDown(eleAttachFiles);
		getElement(eleAttachFiles).sendKeys(GenericFunctions.file.getAbsolutePath());
	}
	
	/**
	 * To check the presence of document
	 * @return boolean basis condition
	 */
	public boolean checkThePresenceOfNameOfFileAttached() {
		wait.hardWait(1);
		if(elementVisibility(eleFileNameAttached))
			return getText(eleFileNameAttached).contains(GenericFunctions.file.toString().replace(System.getProperty("user.dir"), ""));
		return false;
	}
	
	/**
	 * To click on delete icon of attached doc
	 */
	public void deleteDocumentAttached() {
		click(eleDeletedButtonOfDocument);
		TestNGLogUtility.info("Delete button clicked");
	}
	
	/**
	 * To click on preview button on forward lightbox
	 */
	public void clickOnPreviewButtonForForward() {
		click(elePreviewBtn);
		TestNGLogUtility.info("Clicked on preview");
	}
	
	/**
	 * To verify the presence of subject key and subject content
	 * @param subjectKey
	 * @return
	 */
	public boolean verifyThePresenceOfSubjectKey(String subjectKey) {
		return (isDisplayed(parameterizedLocator(elePreviewLayerSubjectKey, subjectKey)) && isDisplayed(parameterizedLocator(eleSubjectHolderOnPreview, " "+subject+" ")));
	}
	
	/**
	 * To verify the body content on preview
	 * @return
	 */
	public boolean verifyTheContentOfBody() {
		return getText(eleMailBody).trim().contains(messageBody);
	}
	
	/**
	 * To click on footer of forward preview
	 * @param footerActionButtonText
	 */
	public void selectTheFooterActionOnPreview(String footerActionButtonText) {
		if(footerActionButtonText.equals("SEND MAIL"))
			click(eleSendMailBtnOnPreview);
		else
			click(eleCloseButtonOnPreview);
		TestNGLogUtility.info(footerActionButtonText + " clicked");
	}
	
	/**
	 * To select the created template
	 */
	public void selectTemplateCreated() {
		sendKeys(chooseTemplateDD, PropFileHandler.readProperty("templateName"));
		click(eleListOfTemplate);
		wait.hardWait(1);
	}
	
	/**
	 * To check the presence of pre selection of excel tracker
	 * @return boolean basis presence
	 */
	public boolean checkThePrefillOfExcelTrackerOnForward() {
		boolean flag = false;
		int i = 0;
		while(i < 5) {
			if(getAttribute(subjectInputField, "value")!=null) {
				TestNGLogUtility.info("Excel Tracker of forward " + jsUtil.executeJavascriptForJSVariables("document.getElementById('inp_prefillTemp').value"));
				TestNGLogUtility.info("Settings Tracker Name" + PropFileHandler.readProperty("excelTrackerName"));
				jsUtil.scrollDown(By.id("inp_prefillTemp"));
				return jsUtil.executeJavascriptForJSVariables("document.getElementById('inp_prefillTemp').value").equals(PropFileHandler.readProperty("excelTrackerName"));
			}
			i++;
		}
		return flag;
	}
	
	/**
	 * To verify the error message of invalid email id
	 * @param errorText
	 * @return boolean basis comparison
	 */
	public boolean verifyThePresenceOfErrorText(String errorText) {
		return getText(toErrorText).equals(errorText);
	}
	
	/**
	 * To click on add cc
	 */
	public void clickOnAddCC() {
		click(eleAddCCLink);
	}
	
	/**
	 * To verify the presence of CC field
	 * @return boolean basis presence
	 */
	public boolean verifyThePresenceCCTextField() {
		return isDisplayed(eleCCTextField);
	}
	
	/**
	 * To fill in the text of cc field
	 * @param ccText
	 */
	public void fillInCCText(String ccText) {
		getElement(eleCCTextField).sendKeys(ccText+Keys.ENTER);
		click(eleCcLabelOnForward);
	}
	
	/**
	 * To verify the CC field
	 * @param expectedErrorMessage
	 * @return boolean basis presence of error message
	 */
	public boolean verifyTheErrorMessageUnderTheCCField(String expectedErrorMessage) {
		return getText(eleCCValidationErrorMessage).equals(expectedErrorMessage);
	}
	
	/**
	 * To verify the presence of sender name
	 * @return boolean basis presence
	 */
	public boolean verifyThePresenceOfSenderName() {
		return isDisplayed(eleSenderName);
	}
	
	/**
	 * To verify the prefilling of sender name
	 * @return boolean
	 */
	public boolean verifyPrefilledSenderName() {
		return getAttribute(eleSenderName, "value").length()>0;
	}
	
	/**
	 * To clear the sender name
	 */
	public void clearTheSendersName() {
		getElement(eleSenderName).clear();
	}
	
	/**
	 * To fill in the sender name
	 * @param textType
	 * @param textSize
	 */
	public void fillInSendersName(String textType, int textSize) {
		sendKeys(eleSenderName, GenericFunctions.generateRandomStrings(textSize, textType));
	}
	
	/**
	 * To check the disable nature of preview btn
	 * @return boolean
	 */
	public boolean checkTheDisabilityOfPreviewButton() {
		return getAttribute(elePreviewBtn,"class").contains("disable");
	}
	
	/**
	 * To verify the presence of signature
	 * @return boolean
	 */
	public boolean verifyThePresenceOfSignature() {
		return getText(eleMailBody).trim().contains(SettingsDashboardPO.signatureText);
	}
	
	/**
	 * To click on include signature checkbox
	 */
	public void clickOnIncludeSignature() {
		click(eleIncludeSignature);
	}
	
	/**
	 * To change the status of candidate from the forward flow
	 * @param status
	 */
	public void selectStatusOfCandidateOnForward(String status) {
		selectByVisibleText(eleStatusChangeOnForwardTemplate, status);
	}
	
	/**
	 * To verify the presence of information text for status change on unmapped requirement
	 * @param expectedText
	 * @return boolean 
	 */
	public boolean verifyThePresenceOfStatusChangeOnUnmappedProfile(String expectedText) {
		jsUtil.scrollDown(eleTextInfoForStatusChangeOfUnmappedProfile);
		return getText(eleTextInfoForStatusChangeOfUnmappedProfile).contains(expectedText);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to select Attach Feedback received cb
	 */
	public void selectAttachFeedbackReceivedSoFarCB()
	{
		jsUtil.scrollToElement(cbAttachFeedback);
		click(cbAttachFeedback);
	}
}
