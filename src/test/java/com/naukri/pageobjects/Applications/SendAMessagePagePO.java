package com.naukri.pageobjects.Applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Offer.OfferGenerationSalaryRuleSettingsPO;
import com.naukri.pageobjects.CandidateCommunication.MailBoxTabPO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Class comprises of page objects and method definitions for send message
 * interface
 * 
 * @author rachit.mehrotra
 *
 */
public class SendAMessagePagePO extends BaseAutomation {

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);

	public By emailButtonApplicationInbox = By.xpath("//a[text()=' Email ']|//a[@class='btn' and contains(.,'Email')]");
	public By messageOptionOnMailDropDown = By.xpath("//a[text()='Email ' or text()=' Email ']/../ul//a[contains(text(),'Message')]");
	public By numberOfApplicationCountOnRequirementListingPage = By
			.xpath("//div[@class = \"listWrap\"]//div[@class = \"profile\"]//a/em");
	public By firstCandidateLink = By.xpath("(//input[@name=\"profileIds[]\"]/../..//a)[1]");
	public By emailButtonOnCVDetailPage = By
			.xpath("//div[contains(@class,\"candBtns\")]//a[contains(text(),\"Email \")]");
	public By messageListOptionDropDown = By.xpath("//ul[@class = \"subNav\"]/li/a[contains(text(),\"Message\")]");
	public By firstCandidateCheckbox = By.xpath("(//input[@name=\"profileIds[]\"])[1]");
	public By messageOptionOnCVDetailsPage = By.xpath("//ul//a[contains(text(),'Message')]");
	public By noCandidateSelectedErrorMessageStrong = By
			.xpath("//span[@id = \"errorCheckBoxMsg\"]/preceding-sibling::strong");
	public By noCandidateSelectedErrorMessageSpan = By.id("errorCheckBoxMsg");
	public By listOfPrefillFromTemplates = By.xpath("//div[@class = \"select-list\"]//li/span");
	public By ccErrorMessage = By.xpath("//label[contains(text(),\"Cc :\")]/../p");
	public By templateListingName = By.xpath("//a[contains(@id,\"mailTemplateName\")]");
	public By successMessageOnApplicationInbox = By.id("successCheckBoxMsg");
	public By backArrowSpanBtn = By.xpath("//span[@class= \"backArrow\"]");

	// Message template page object
	public By replyToField = By.xpath("//div[contains(@class,\"from\")]/label");
	public By ccField = By.xpath("//div[contains(@class,\"to\")]/label[contains(text(),\"Cc\")]");
	public By mailToMeACopyLabel = By.xpath("//div[@class = \"copyToMe\"]/label");
	public By mailToMeACopyCheckbox = By.xpath("//div[@class = \"copyToMe\"]/label");
	public By prefillFromTemplatesField = By.xpath("//span[contains(text(),\"Prefill from Template\")]");
	public By subjectLabel = By.xpath("//div[contains(@class , 'subject')]/label");
	public By subjectFieldInput = By.xpath("//div[contains(@class , 'subject')]/input");
	public By includeSignature = By.xpath("//input[@id=\"includeSign\"]");
	public By requestedDocuments = By.xpath("//div[contains(@class , \"to\")]/label[contains(text(),\"Requested\")]");
	public By attachedLabel = By.xpath("//div[contains(@class , \"to\")]/label[contains(text(),\"Attached\")]");
	public By sendMailBtn = By.id("sendMessageEmail");
	public By previewMailBtn = By.xpath("//button[contains(text(),\"PREVIEW\")]");
	public By mailBodyWriter = By.xpath("(//div[contains(@class,\"mailBodyWriter\")])[2]");
	public By mailSubjectErrorText = By.id("subject_err");
	public By ccMailTextField = By.xpath("//input[@placeholder = \"Enter email\"]");
	public By saveTemplateField = By.xpath("//a[contains(text(),\"Save Template\")]");
	public By saveTemplateInputField = By.id("saveOfferTemp");
	public By tagsDD = By.xpath("//span[contains(text(),\"[tags]\")]");
	public By listOfTags = By.xpath("//ul[@class = \"mailTags\"]//li");
	private By lstMailTo=By.xpath("//li[@class=' tagit']//span[contains(.,'@')]");
	private By chkRplyToEmail = By.xpath("(//ul[@id='ul_contactLst']//li)/a[1]");
	private By btnAddCC=By.xpath("//div[@class[contains(.,'ccText')]]/a");
	private By txtMailCC=By.xpath("//label[contains(.,'Cc')]/..//input[@class='mailTextF']|//input[@id='inp_ccObjectList']|//input[@id='ccIdchipsArr']");
	private By txtMailSubject=By.xpath("//label[contains(.,'Subject')]//following-sibling::input[@name='subject']|//input[@id='mailTemplateSubject']");
	private By iframeMailBody=By.xpath("//iframe[@id='mailTemplateBody']");
	private By txtMailBody=By.xpath("//div[@class[contains(.,'composeMail')]]//div[@class='mailBodyWriter']|//iframe[@id='mailTemplateBody']");
	private By btnUploadOfferLetter = By.xpath("//button[text()='UPLOAD']");
	private By btnAttach=By.xpath("//input[@id='mailAttachment' or @id='fileInput']");
	private By btnAttachFile=By.xpath(".//input[@type='file']");
	private By txtMailCCChip=By.xpath("//input[@id='ccIdchipsArr' or @class='mailTextF' or @id='inp_ccObjectList']");
	private By btnPreview=By.xpath("//a[@id='previewMailFromCreateLB']|//button[@class='next borderBtn']");
	private By btnSendMailOnPreview=By.xpath("//input[@value='SEND MAIL']");
	private By lblMailBodyDataOnPreview=By.xpath("//td[@id='mailBodyData']");
	private By chkOnSendreqFlow=By.xpath("//div[@id='contactLstCc' and @style[contains(.,'display: none;')]]/..//input[@id='chkSendEmailCC']");
	private By lblMailHeader=By.xpath("//div[@class='lb_head']");
	public By ddlchoseRequirementDD = By.id("SendMailProjectList");
	// static text for mail body and subject
	public static String mailBodyText = "Test Mail Body";
	public static String mailSubjectText = "Test Mail Subject";
	public static String templateName = "";
	public List<String> recruiterTags = Arrays.asList("Recruiter Name", "Recruiter Email", "Recruiter Company",
			"Recruiter Mobile");
	public List<String> candidateTags = Arrays.asList("Date of Birth", "Candidate Email", "Candidate Designation",
			"Gender", "Candidate Experience (years, months)", "Candidate Functional Area", "Candidate Company",
			"Current CTC", "Candidate City", "Notice Period", "Candidate Mobile", "Candidate Keyskills", "PG Degree",
			"PG University", "Candidate Industry", "Candidate Name", "PG Specialization", "PPG Degree",
			"PPG Specialization", "PPG University", "Preferred Work Location", "UG Specialization", "UG Degree",
			"UG University");

	SoftAssert softAssert = new SoftAssert();
	 SendARequirementPagePO sendRequirement = (SendARequirementPagePO) PageObjectWrapper.getObject(SendARequirementPagePO.class);
	 MailBoxTabPO objMailBoxTabPO = (MailBoxTabPO) PageObjectWrapper.getObject(MailBoxTabPO.class);
	
	/**
	 * This method use to fill email details like To email id, cc email id, Mail
	 * subject, Mail body and mail attachment For all type of mail pop up
	 * 
	 * @author abhishek.dwivedi
	 * @return hamp of data used in filling Mail data.
	 */

	public HashMap<String, String> sendEmail(Map<String, String> data) {
		HashMap<String, String> hmapSendMailInputdata = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : data.entrySet()) {
			switch (entry.getKey()) {
			case "MailTo":
				if (entry.getValue().trim().equals("")) {
					addMailToIfRequired(hmapSendMailInputdata, entry.getKey(), entry.getValue());
				} else {
					objMailBoxTabPO.forwardToField(entry.getValue().trim());
					click(lblMailHeader);
					addDetilsinMap(hmapSendMailInputdata, entry.getKey(), entry.getValue());
				}
				break;
			case "MailCC":
				if (entry.getValue().trim().equals("")) {
					hmapSendMailInputdata.put(entry.getKey(), entry.getValue());
				} else {
					clickAddCC();
					wait.hardWait(2);
					objMailBoxTabPO.forwardToField(entry.getValue());
					addDetilsinMap(hmapSendMailInputdata, entry.getKey(), entry.getValue());
				}
				break;
			case "MailSubject":
				if (entry.getValue().trim().equals("")) {
					hmapSendMailInputdata.put(entry.getKey(), getAttribute(txtMailSubject, "value"));
				} else {
					String subject=entry.getValue()+genericFunctions.generateRandomStrings(9, "Alphanumeric");
					sendKeys(txtMailSubject, subject);
					addDetilsinMap(hmapSendMailInputdata, entry.getKey(), subject);
				}
				break;
			case "MailAttachment":
				if (!entry.getValue().trim().equals("")) {
					String offerLetterPath = OfferGenerationSalaryRuleSettingsPO.fileSystemPath()
							+ YamlReader.getAppConfigValue("TestData." + entry.getValue());
					driver.findElement(By.xpath(".//input[@type='file']")).sendKeys(offerLetterPath);
					wait.hardWait(5);
					addDetilsinMap(hmapSendMailInputdata, entry.getKey(), entry.getValue());
				}
				break;
			case "MailBody":
				if (entry.getValue().trim().equals("")) {
					if (isDisplayed(btnPreview)) {
						click(btnPreview);
						wait.hardWait(2);
						hmapSendMailInputdata.put(entry.getKey(), getText(lblMailBodyDataOnPreview).toString());
					}
				} else {
					if (isDisplayed(iframeMailBody)) {
						fillMailBodyIframe(entry.getValue());
						switchToDefaultContent();
						selectRequirementFromDropDown();
					} else {
						sendKeys(txtMailBody, entry.getValue());
					}
					addDetilsinMap(hmapSendMailInputdata, entry.getKey(), entry.getValue());
					clickBtnPreviewOnMailPopUp();
				}
				break;
			}
		}
		wait.hardWait(3);
		click(btnSendMailOnPreview);
		wait.hardWait(5);
		return hmapSendMailInputdata;
	}

	/**
	 * This method use to email in mail to filed if it is required
	 * 
	 * @author abhishek.dwivedi
	 * @param hashmap
	 *            contains of To email id
	 * @param key
	 *            and value
	 */
	public void addMailToIfRequired(Map<String, String> hmapSendMailInputdata, String key, String value) {
		if (isDisplayed(lstMailTo)) {
			hmapSendMailInputdata.put(key, getText(lstMailTo));
		} else {
			addDetilsinMap(hmapSendMailInputdata, key, value);
		}
	}

	/**
	 * This method use to click on Add CC button
	 * 
	 * @author abhishek.dwivedi
	 */
	public void clickAddCC() {
		wait.hardWait(2);
		if (isDisplayed(btnAddCC)) {
			wait.hardWait(2);
			jsUtil.clickByJS(btnAddCC);
		} else if (isDisplayed(chkOnSendreqFlow)) {
			click(chkOnSendreqFlow);
		}
	}

	/**
	 * This method use to fill mail body by switching to the iframe of MailBody
	 * 
	 * @author abhishek.dwivedi
	 * @param String
	 *            value
	 */
	public void fillMailBodyIframe(String entryValue) {
		switchToFrame(iframeMailBody);
		getElement(By.tagName("body")).sendKeys(entryValue);
	}

	/**
	 * This method use to select Requirement From Drop Down
	 * 
	 * @author abhishek.dwivedi
	 */
	public void selectRequirementFromDropDown() {
		if (isDisplayed(ddlchoseRequirementDD)) {
			sendRequirement.clickRequirementDD();
			sendRequirement.selectFirstRequirementFromDD();
		}
	}

	/**
	 * This method use to click on Preview button of Mail Pop up
	 * 
	 * @author abhishek.dwivedi
	 *
	 */
	public void clickBtnPreviewOnMailPopUp() {
		if (isDisplayed(btnPreview)) {
			click(btnPreview);
			wait.hardWait(2);
		}
	}

	/**
	 * This method use to to put details in hashmap and Display which key value pair
	 * added to it
	 * 
	 * @author abhishek.dwivedi
	 * @param hashmap
	 *            contains of To email id
	 * @param key
	 *            and value
	 */
	public void addDetilsinMap(Map<String, String> hmapSendMailInputdata, String key, String value) {
		hmapSendMailInputdata.put(key, value);
		TestNGLogUtility.info(key + " value entered...");
	}

	/**
	 * To hover on email button present across inboxes
	 * 
	 * @author rachit.mehrotra
	 */
	public void hoverOnEmailButton() {
		jsUtil.scrollDown(emailButtonApplicationInbox);
		actionBuilderUtil.hoverByActionAlternate(emailButtonApplicationInbox);
	}

	/**
	 * To verify the presence of message option on email DD
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean presenceOfMessageOption() {
		return isDisplayed(messageOptionOnMailDropDown);
	}

	/**
	 * To navigate to requirement inbox basis application count > 0. This will click
	 * on first occurence of any such project
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnRequirementListingCount() {
		int listSizeOfRequirementCount = getElements(numberOfApplicationCountOnRequirementListingPage).size();
		for (int i = 1; i <= listSizeOfRequirementCount; i++) {
			String currentRequirementCount = "(//div[@class = \"listWrap\"]//div[@class = \"profile\"]//a/em)["
					+ Integer.toString(i) + "]";
			if (Integer.parseInt(getText(By.xpath(currentRequirementCount))) != 0) {
				click(By.xpath(currentRequirementCount));
				changeWindowHandler();
				return;
			}
		}
	}

	/**
	 * To change window tabs
	 * 
	 * @author rachit.mehrotra
	 */
	public void changeWindowHandler() {
		genericFunctions.switchToWindow();
	}

	/**
	 * To click on first candidate
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnFirstCandidate() {
		click(firstCandidateLink);
		changeWindowHandler();
	}

	/**
	 * To hover on Email Option on CV details page
	 * 
	 * @author rachit.mehrotra
	 */
	public void hoverOnEmailFromCVDetailsPage() {
		actionBuilderUtil.hoverByActionAlternate(emailButtonOnCVDetailPage);
	}

	/**
	 * To verify the presence of message option on Email DD on CV details page
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean presenceOfMessageOptionOnCVDetailsPage() {
		return isDisplayed(messageListOptionDropDown);
	}

	/**
	 * To select first candidate checkbox
	 * 
	 * @author rachit.mehrotra
	 */
	public void selectFirstCandidateCheckbox() {
		jsUtil.scrollUp();
		TestNGLogUtility.info(firstCandidateCheckbox.toString());
		wait.waitForVisibilityOfElement(firstCandidateCheckbox);
		click(firstCandidateCheckbox);
	}

	/**
	 * To click on message option on the inbox
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickMessageOptionOnInbox() {
		wait.waitForVisibilityOfElement(messageOptionOnMailDropDown);
		click(messageOptionOnMailDropDown);
	}

	/**
	 * To validate presence of elements accross the message layout
	 * 
	 * @author rachit.mehrotra
	 */
	public void validatePresenceOfElementsOnMailTemplate() {
		List<Boolean> presenceOfElements = new ArrayList<Boolean>();
		List<String> keyIndicatorOfElements = new ArrayList<String>();
		presenceOfElements.add(isDisplayed(replyToField));
		keyIndicatorOfElements.add("replyToField");
		presenceOfElements.add(isDisplayed(mailToMeACopyCheckbox));
		keyIndicatorOfElements.add("mailToMeACopyCheckbox");
		presenceOfElements.add(isDisplayed(ccField));
		keyIndicatorOfElements.add("ccField");
		presenceOfElements.add(isDisplayed(mailToMeACopyLabel));
		keyIndicatorOfElements.add("mailToMeACopyLabel");
		presenceOfElements.add(isDisplayed(prefillFromTemplatesField));
		keyIndicatorOfElements.add("prefillFromTemplatesField");
		presenceOfElements.add(isDisplayed(subjectLabel));
		keyIndicatorOfElements.add("subjectLabel");
		presenceOfElements.add(isDisplayed(subjectLabel));
		keyIndicatorOfElements.add("subjectLabel");
		presenceOfElements.add(isDisplayed(subjectFieldInput));
		keyIndicatorOfElements.add("subjectFieldInput");
		presenceOfElements.add(isDisplayed(mailBodyWriter));
		keyIndicatorOfElements.add("mailBodyWriter");
		presenceOfElements.add(isDisplayed(requestedDocuments));
		keyIndicatorOfElements.add("requestedDocuments");
//		presenceOfElements.add(isDisplayed(attachedLabel));  Legacy code, will remove after review
//		keyIndicatorOfElements.add("attachedLabel");
		presenceOfElements.add(isDisplayed(sendMailBtn));
		keyIndicatorOfElements.add("sendMailBtn");
		presenceOfElements.add(isDisplayed(previewMailBtn));
		keyIndicatorOfElements.add("previewMailBtn");
		assertUtil.softAssertTrueListOfElements(presenceOfElements, keyIndicatorOfElements);
		testPresence();

	}

	/**
	 * To verify presence of signature
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean testPresence() {
		jsUtil.scrollDown(includeSignature);
		return isDisplayed(includeSignature);
	}

	/**
	 * To click message option present on CV details page
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickMessageOptionOnCvDetailsPage() {
		click(messageOptionOnCVDetailsPage);
	}

	/**
	 * To verify the content of error message when no candidate is selected
	 * 
	 * @author rachit.mehrotra
	 * @param errorMessage
	 * @return
	 */
	public boolean checkNoCandidateSelectedErrorMessage(String errorMessage) {
		return (getText(noCandidateSelectedErrorMessageStrong) + " " + getText(noCandidateSelectedErrorMessageSpan))
				.contains(errorMessage);
	}

	/**
	 * To verify the presence of prefill from template option on send message layout
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean verifyPrefillTemplatePresence() {
		return isDisplayed(prefillFromTemplatesField);
	}

	/**
	 * To click prefill from template
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickPrefillTemplatePresence() {
		click(prefillFromTemplatesField);
	}

	/**
	 * To verify the size of prefill from template
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean sizeOfPrefillFromTemplates() {
		clickPrefillTemplatePresence();
		if (getElements(listOfPrefillFromTemplates).size() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * To fill the mail body content in message lightbox
	 * 
	 * @author rachit.mehrotra
	 */
	public void fillMailBody() {
		sendKeys(mailBodyWriter, mailBodyText);
	}

	/**
	 * To click buttons present on send a message footer
	 * 
	 * @author rachit.mehrotra
	 * @param buttonText
	 */
	public void clickButtonOnMessageFooter(String buttonText) {
		switch (buttonText) {
		case "SEND MAIL":
			click(sendMailBtn);
			break;
		case "PREVIEW":
			click(previewMailBtn);
			break;
		}
	}

	/**
	 * To verify the empty message subject error message
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean presenceOfSubjectErrorMessageAndText() {
		return isDisplayed(mailSubjectErrorText);
	}

	/**
	 * To verify the content of empty message subject text
	 * 
	 * @author rachit.mehrotra
	 * @param actualErrorTextMessage
	 * @return boolean
	 */
	public boolean errorTextMessage(String actualErrorTextMessage) {
		return getText(mailSubjectErrorText).contains(actualErrorTextMessage);
	}

	/**
	 * To fill mail subject in message flow
	 * 
	 * @author rachit.mehrotra
	 */
	public void fillMailSubject() {
		sendKeys(subjectFieldInput, mailSubjectText);
	}

	/**
	 * To fill the CC fields
	 * 
	 * @author rachit.mehrotra
	 * @param ccAddress
	 */
	public void fillInCCField(String ccAddress) {
		sendKeys(ccMailTextField, ccAddress);
	}

	/**
	 * To check CC error text
	 * 
	 * @author rachit.mehrotra
	 * @param ccErrorText
	 * @return boolean
	 */
	public boolean checkTheCCErrorText(String ccErrorText) {
		return ccErrorText.contains(getText(ccErrorMessage));
	}

	/**
	 * To click on save button on send message template
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnSaveTemplateButton() {
		jsUtil.scrollDown(saveTemplateField);
		click(saveTemplateField);
	}

	/**
	 * To verify the presence of save template fields
	 * 
	 * @author rachit.mehrotra
	 * @param placeholderString
	 * @return boolean
	 */
	public boolean presenceSaveTemplateField(String placeholderString) {
		return (isDisplayed(saveTemplateInputField)
				&& getAttribute(saveTemplateInputField, "placeholder").contains(placeholderString));
	}

	/**
	 * To fill the template name while saving template during message flow
	 * 
	 * @author rachit.mehrotra
	 */
	public void fillTemplateName() {
		templateName = "Message Template Name " + Long.toString(System.currentTimeMillis());
		TestNGLogUtility.info("Template Name " + templateName);
		sendKeys(saveTemplateInputField, templateName);
	}

	/**
	 * To check the presence of template on template listing page
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean checkVisibilityOfTemplateOnTemplateListingPage() {
		String testXpath = "//a[contains(@id,\"mailTemplateName\")]";
		driver.navigate().refresh();
		wait.hardWait(5);
		for (int i = 1; i < getElements(templateListingName).size(); i++) {
			driver.navigate().refresh();
			StringBuilder str = new StringBuilder();
			str.append("(" + testXpath + ")[");
			str.append(Integer.toString(i) + "]");
			if (getText(By.xpath(str.toString())).equalsIgnoreCase(templateName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * To verify the sucess message of sent message
	 * 
	 * @author rachit.mehrotra
	 * @param successMessage
	 * @return boolean
	 */
	public boolean messageSentSuccessMessagePresence(String successMessage) {
		return getText(successMessageOnApplicationInbox).contains(successMessage);
	}

	/**
	 * To click back arrow button on send messsage layout
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickBackArrowButton() {
		click(backArrowSpanBtn);
	}

	/**
	 * To verify the tags DD present on layout
	 * 
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean verifyPresenceOfTagsDD() {
		jsUtil.scrollMid(tagsDD);
		return isDisplayed(tagsDD);
	}

	/**
	 * To click on tags DD present on send message layout
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickTagsDD() {
		wait.waitForElementToBeClickable(tagsDD);
		click(tagsDD);
	}

	/**
	 * To verify the categorization of message tags based on candidate and recruiter
	 * 
	 * @author rachit.mehrotra
	 * @param groupName
	 * @return boolean
	 */
	public boolean verifyPresenceOfGroupText(String groupName) {
		return isDisplayed(By.xpath("//li[text()=\"" + groupName + "\"]"));
	}

	/**
	 * To click the categorization of message tags based on candidate and recruiter
	 * 
	 * @author rachit.mehrotra
	 * @param groupName
	 */
	public void clickGroupText(String groupName) {
		click(By.xpath("//li[text()=\"" + groupName + "\"]"));
	}

	/**
	 * To compare the list of tags for each category
	 * 
	 * @author rachit.mehrotra
	 * @param groupName
	 * @return boolean
	 */
	public boolean compareTagList(String groupName) {
		boolean flag = false;
		List<WebElement> listOfWebElements = getElements(listOfTags);
		if (groupName.equals("Recruiter")) {
			flag = verifyListOfTags(listOfWebElements, recruiterTags);
		} else if (groupName.equals("Candidate")) {
			flag = verifyListOfTags(listOfWebElements, candidateTags);
		}
		return flag;
	}

	/**
	 * To verify each list of tags present element wise
	 * 
	 * @author rachit.mehrotra
	 * @param listOfWebElement
	 * @param actualListOfTags
	 * @return boolean
	 */
	public boolean verifyListOfTags(List<WebElement> listOfWebElement, List<String> actualListOfTags) {
		int sizeofList = listOfWebElement.size();
		for (int i = 0; i < sizeofList; i++) {
			if (i == 12)
				jsUtil.scrollDown(By.xpath("(//ul[@class = \"mailTags\"]//li)[" + sizeofList + "]"));
			if (!listOfWebElement.get(i).getText().contains(actualListOfTags.get(i)))
				return false;
		}
		return true;
	}

	/**
	 * Inner class Page Object comprises of all the methods and locators used to
	 * automate message preview page
	 * 
	 * @author rachit.mehrotra
	 *
	 */
	public class PreviewMessagePagePO extends PageObjectWrapper {

		public By previewWindowHeader = By.xpath("//div[@class= \"previewBody\"]//p");
		public By previewMessageSubject = By.xpath("//div[contains(@class,\"previewTemplate\")]/form//b/..");
		public By previewMessageBody = By.id("mailBodyData");
		public By previewCloseButtonOnFooter = By.xpath("//div[contains(@class , \"previewTemplate\")]//a[text()=\"CLOSE\"]");
		public By previewSendMail = By.xpath("//div[contains(@class , \"previewTemplate\")]//input[@value=\"SEND MAIL\"]");

		/**
		 * To verify the message subject and message body on the preview page
		 * 
		 * @author rachit.mehrotra
		 * @return boolean
		 */
		public boolean verifySubjectAndBodyOnPreview() {
			return (getText(previewMessageBody).contains(mailBodyText)
					&& getText(previewMessageSubject).split(":")[1].contains(mailSubjectText));
		}

		/**
		 * To verify the presence of buttons on footer of message preview layout
		 * 
		 * @author rachit.mehrotra
		 * @return boolean
		 */
		public boolean verifyThePresenceOfButtonsOnPreview() {
			return (isDisplayed(previewCloseButtonOnFooter) && isDisplayed(previewSendMail));
		}

		/**
		 * To click send message link
		 * 
		 * @author rachit.mehrotra
		 */
		public void previewSendMail(String btnText) {
			if(btnText.contains("SEND MAIL")) 
				click(previewSendMail);
			}
	}

	
}
