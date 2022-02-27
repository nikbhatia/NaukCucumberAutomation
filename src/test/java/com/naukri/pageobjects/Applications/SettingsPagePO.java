package com.naukri.pageobjects.Applications;

import java.util.List;

import org.openqa.selenium.By;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

/**
 * Page Object class comprises of all the page object methods used in
 * applications for settings page
 * 
 * @author rachit.mehrotra
 *
 */
public class SettingsPagePO extends BaseAutomation {

	// locators
	public By createNewTemplate = By.id("savefolderLB");
	public By nextButtonOnMailSelectionPopUp = By.id("tempTypeNext");
	public By forwardMailTemplateName = By.id("mailTemplateName");
	public By fowardMailSubjectText = By.id("mailTemplateSubject");
	public By forwardMailSubjectFrame = By.id("mailTemplateBody");
	public By mailTemplateSaveButton = By.id("saveMailTemplateBtn");

	// variables
	public static String templateName = "";
	public static String subject = "";
	public static String body = "";

	public static String groupName = "";
	public static String groupDescription = "";

	/**
	 * To click on add new template
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnAddNewTemplate() {
		click(createNewTemplate);
	}

	/**
	 * To select the type of message template field
	 * 
	 * @author rachit.mehrotra
	 * @param mailTemplateOption
	 */
	public void selectMailTemplateOption(String mailTemplateOption) {
		click(By.xpath("//label[contains(text(),\"" + mailTemplateOption + "\")]"));
	}

	/**
	 * To click on Next button on add new template lightbox
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickNextOnMailTemplatePopUp() {
		click(nextButtonOnMailSelectionPopUp);
	}

	/**
	 * To fill the template fields basis description
	 * 
	 * @author rachit.mehrotra
	 * @param templateLocator
	 */
	public void fillInMailTemplateField(String templateLocator) {
		switch (templateLocator) {
		case "template name":
			templateName = "templateName " + Long.toString(System.currentTimeMillis());
			sendKeys(forwardMailTemplateName, templateName);
			break;
		case "subject":
			subject = "forwardSubject " + Long.toString(System.currentTimeMillis());
			sendKeys(fowardMailSubjectText, subject);
			break;
		case "body":
			body = "forwardBody " + Long.toString(System.currentTimeMillis());
			switchToFrame(forwardMailSubjectFrame);
			sendKeys(By.tagName("body"), body);
			switchToDefaultContent();
			break;
		default:
			TestNGLogUtility.info("Invalid Choice");
		}
	}

	/**
	 * To click on save template on mail template lightbox
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickOnSaveOnMailTemplate() {
		jsUtil.scrollDown(By.id("saveMailTemplateBtn"));
		click(mailTemplateSaveButton);
	}

	/**
	 * Inner Class deals with page object methods for creating a group
	 * 
	 * @author rachit.mehrotra
	 *
	 */
	public class GroupListingPagePO {

		// locators
		public By addNewGroup = By.id("addEmployer");
		public By groupNameText = By.xpath("//input[contains(@placeholder,\"Enter Name of the Group Here\")]");
		public By groupDescriptionTextArea = By.name("description");
		public By searchRecruiterName = By
				.xpath("//div[text()=\"Select Recruiters\"]/..//span[contains(text(),\"Search\")]");
		public By searchHiringManager = By
				.xpath("(//div[text()=\"Select Hiring Managers\"]/..//span[contains(text(),\"Search Here\")])[1]");
		By eleGrpInitial = By.name("initials");

		/**
		 * To click on add new group button
		 * 
		 * @author rachit.mehrotra
		 */
		public void clickAddNewGroupBtn() {
			click(addNewGroup);
		}

		/**
		 * To fill new group name
		 * 
		 * @author rachit.mehrotra
		 */
		public void fillGroupName() {
			groupName = "GroupName " + Long.toString(System.currentTimeMillis());
			sendKeys(groupNameText, groupName);
		}

		/**
		 * To fill the group description
		 * 
		 * @author rachit.mehrotra
		 */
		public void fillGroupDescription() {
			groupDescription = "GroupDescription " + Long.toString(System.currentTimeMillis());
			sendKeys(groupDescriptionTextArea, groupDescription);
		}

		/**
		 * To click any button present on footer
		 * 
		 * @author rachit.mehrotra
		 * @param btnText
		 */
		public void clickOnFooterButtonOnLayout(String btnText) {
			String modifiedBtnText = btnText.toUpperCase();
			switch (modifiedBtnText) {
			case "NEXT":
				click(By.xpath("//button[contains(text(),\"NEXT\")]"));
				break;
			case "SAVE":
				click(By.xpath("//button[contains(text(),\"SAVE\")]"));
				break;
			}
		}

		/**
		 * To select recruiter from recruiter list
		 * 
		 * @author rachit.mehrotra
		 * @param recruiterList
		 */
		public void selectRecruiterForGroup(List<String> recruiterList) {
			click(searchRecruiterName);
			for (String recruiterName : recruiterList) {
				By recruiterNameLocator = By.xpath("//label[text()=\"" + recruiterName + "\"]");
				jsUtil.scrollDown(recruiterNameLocator);
				click(recruiterNameLocator);
			}
		}

		/**
		 * To select the HM list for a particular group
		 * 
		 * @author rachit.mehrotra
		 * @param hmList
		 */
		public void selectHMForGroup(List<String> hmList) {
			click(By.xpath(
					"//li[contains(@class , \"tab \")]//div[contains(text(),\"Recruiters and Hiring Managers\")]"));
			click(searchHiringManager);
			for (String hiringManagerName : hmList) {
				By hiringManagerNameLocator = By.xpath("//label[text()=\"" + hiringManagerName + "\"]");
				jsUtil.scrollDown(hiringManagerNameLocator);
				click(hiringManagerNameLocator);
			}
		}

		public void fillInGroupInitials() {
			sendKeys(eleGrpInitial, GenericFunctions.generateRandomStrings(3, "Number"));
		}
	}
	
}
