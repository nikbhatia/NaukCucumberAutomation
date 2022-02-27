package com.naukri.pageobjects.HiringManager;

import java.io.IOException;
import org.openqa.selenium.By;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

public class BulkUploadPagePO extends PageObjectWrapper{
	By btnSelectFile = By.xpath("//input[@id='file_input']");
	By txtReqTitle = By.xpath("//input[@id='projectName']");
	By ddGroup = By.xpath("//input[@id='inp_hiringFordd']");
	By ddVisibility = By.xpath("//select[@id='visToMe']");
	By btnAddNewReq = By.xpath("//a[@id='createNProject']");
	By lblGroupName = By.xpath("//ul[@id='ul_hiringFordd']//a[text()='${help}']");
	By btnUploadFile = By.xpath("//input[@id='uploadMultipleFiles']");
	By ddAddToExistingReq = By.xpath("//input[@id='inp_projectList']");
	By lblFirstReqFromDD = By.xpath("//div[@id='dp_projectList']//li[1]");
	By requirementList = By.xpath("//div[@id='dp_projectList']");
	By getSuccessMessage = By.xpath("//span[@id='SuccessmsgBx']");

	static String reqTitle = "Requirement " + CommonAction.generateRandomStrings(5, "String");

	/**
	 * This method is used to upload selected file
	 * @throws IOException
	 * @author gupta.mansi
	 */
	public void uploadFile() throws IOException {
		wait.waitForPageToLoadCompletely();
		switchToFrame(By.name("Bulk Upload Files"));
		wait.waitForElementToBeClickable(By.xpath("//span[text()=' Select File ']"));
		jsUtil.executeJavascript("document.getElementById('file_input').setAttribute('style', 'display:block');");
		driver.findElement(btnSelectFile).sendKeys("C:\\Users\\gupta.mansi\\Documents\\sample\\BulkUploadZip.zip");
		switchToDefaultContent();
		wait.hardWait(2);
	}

	/**
	 * This method is used create new requirement from bulk upload 
	 * @param groupName
	 * @param visibility
	 * @author gupta.mansi
	 */
	public void addNewRequirement(String groupName, String visibility) {
		switchToFrame(By.name("Bulk Upload Files"));
		getElement(btnAddNewReq).click();
		fillRequirementTitle();
		selectGroup(groupName);
		getElement(btnUploadFile).click();
	}

	/**
	 * This method is used create new requirement from bulk upload
	 * @author gupta.mansi
	 */
	public void addNewRequirement() {
		switchToFrame(By.name("Bulk Upload Files"));
		getElement(btnAddNewReq).click();
		fillRequirementTitle();
		getElement(btnUploadFile).click();
		switchToDefaultContent();
	}

	/**
	 * This method is used to select group
	 * @param groupName
	 * @author gupta.mansi
	 */
	public void selectGroup(String groupName) {
		getElement(ddGroup).click();
		getElement(lblGroupName, groupName);
	}

	/**
	 * This method is used to fill requirement title
	 * @author gupta.mansi
	 */
	public void fillRequirementTitle() {
		getElement(txtReqTitle).sendKeys(reqTitle);
	}

	/**
	 * This method is used to select first requirement name from add to existing
	 * requirement dd
	 * @author gupta.mansi
	 */
	public void addToExistingRequirement() {
		click(ddAddToExistingReq);
		wait.waitForVisibilityOfElement(requirementList);
		click(lblFirstReqFromDD);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to click on upload file button
	 * @author gupta.mansi
	 */
	public void clickOnUploadFiles() {
		click(btnUploadFile);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * This method is used to get success message after uploading the bulk files
	 * @return Success message
	 * @author gupta.mansi
	 */
	public String getSuccessMessage() {
		return getText(getSuccessMessage);
	}

	public void clickOnAddNewBtn() {
		switchToFrame(By.name("Bulk Upload Files"));
		getElement(btnAddNewReq).click();
	}
}