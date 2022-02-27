package com.naukri.pageobjects.Billing;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.naukri.test.base.BaseAutomation;

/**
 * Class comprises of page object of add a single profile webpage
 * @author rachit.mehrotra
 *
 */
public class AddASingleProfilePagePO extends BaseAutomation{
	
	//variables
	public static String candidateName = "", contactNumber = "", emailId = "", requirementTitle ="";
	static String selectionStage = "Prospect";
	
	//locators
	public By candidateName_text = By.xpath("//label[@for= \"name\"]/following-sibling::input");
	public By email_text = By.id("emilBlock_0");
	public By contact_text = By.id("numBlock_0");
	public By saveCandidate_btn = By.id("editCandBasicButton");
	public By addNewRequirement_link = By.xpath("//a[text()=\"Add New \"]");
	public By requirementTitle_text = By.id("projectName");
	public By statusSelect_dd = By.id("subStatusId");
	public By visibilityToRecruiters = By.id("visToMe");
	
	/**
	 * To add basic information like name,contact and email of candidate
	 * @author rachit.mehrotra
	 */
	public void addCandidateInformation() {
		candidateName = "candidateName";
		contactNumber = Long.toString(System.currentTimeMillis()).substring(0, 10);
		emailId = "email" + System.currentTimeMillis()+"@yopmail.com";
		sendKeys(candidateName_text, candidateName);
		sendKeys(email_text, emailId);
		sendKeys(contact_text, contactNumber);
	}
	
	/**
	 * To create requirement using requirement widget on Add A single profile
	 * @author rachit.mehrotra
	 */
	public void addRequirementDetailsForCandidate() {
		requirementTitle = "addSingleCandidateRequirement" + System.currentTimeMillis();
		click(addNewRequirement_link);
		sendKeys(requirementTitle_text, requirementTitle);
		jsUtil.scrollDown(statusSelect_dd);
		click(statusSelect_dd);
		click(By.xpath("(//select[@id=\"subStatusId\"]/option[contains(text(),\""+selectionStage+"\")])[1]"));
	}
	
	/**
	 * To click on save candidate button present on layout
	 * @author rachit.mehrotra
	 */
	public void clickAddCandidateBtn() {
		jsUtil.scrollDown(saveCandidate_btn);
		click(saveCandidate_btn);
	}
	
	/**
	 * To select the group while creating the requirement
	 * @author rachit.mehrotra
	 * @param groupName
	 */
	public void selectGroupForNewRequirement(String groupName) {
		click(By.id("inp_hiringFordd"));
		click(By.xpath("//a[text()=\""+groupName+"\"]"));
	}
	
	/**
	 * To select the visibility option for paricular requirement
	 * @author rachit.mehrotra
	 * @param visibilityOption
	 */
	public void selectVisibilityOption(String visibilityOption) {
		wait.waitForInvisibilityOfElement(10, 3, By.xpath("//div[@class=\" processing-overlay processing-overlay-40  \" ]"));
		click(By.xpath("//label[contains(text(),\"Visibility Setting: \")]"));
		click(By.xpath("//select[@id = \"visToMe\"]/option[contains(text(), \""+visibilityOption+"\")]"));
	}
	
	
	
	
	
}
