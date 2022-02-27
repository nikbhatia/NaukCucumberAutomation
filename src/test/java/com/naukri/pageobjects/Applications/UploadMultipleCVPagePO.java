package com.naukri.pageobjects.Applications;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Page Object Class for the multiple CV Upload
 * @author rachit.mehrotra
 *
 */
public class UploadMultipleCVPagePO extends PageObjectWrapper{
	//Objects
	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	
	//Locators
	By eleMultipleUploadPageHeading = By.xpath("//div[contains(text(),\"Add Candidate - Multiple Files\")]");
	By eleSelectFilePath = By.id("fileInput");
	By eleAddNewRequirement = By.id("createNProject");
	By eleExistingRequirement = By.id("chooseEProject");
	By eleRequirementName = By.id("projectName");
	By btnUploadFile = By.id("uploadMultipleFiles");
	By eleSuccessMessageOnMultipleUpload = By.id("SuccessmsgBx");
	By eleUploadLogs = By.id("loglink");
	By eleProcessLoader = By.xpath("//div[contains(@class,'processing-overlay processing-overlay-40')]");
	By eleProfileCreated = By.xpath("//a[contains(@href,\"/profile/inbox?\")]");
	
	//variables
	public static String requirementNameOfMultipleUpload;
	
	/**
	 * To check the multiple upload page title 
	 * @param headingText
	 * @return
	 */
	public boolean checkThePresenceOfMultipleUploadPageHeading(String headingText) {
		TestNGLogUtility.info("UI heading message " + getText(eleMultipleUploadPageHeading));
		return getText(eleMultipleUploadPageHeading).equals(headingText);
	}
	
	/**
	 * To select the resume content and resume extension
	 * @param resumeFileExtension
	 */
	public void selectTheCVToUpload(String resumeFileExtension) {
		HashMap<String, String> resumeContentMap = new HashMap<String, String>();
		resumeContentMap.put("Name", "CandidateName" + Integer.toString(genericFunctions.generateRandomDigits(10)));
		resumeContentMap.put("Email", "candidate"+Integer.toString(genericFunctions.generateRandomDigits(10))+"@yopmail.com");
		resumeContentMap.put("Phone", Integer.toString(genericFunctions.generateRandomDigits(10)));
		TestNGLogUtility.info("resume extension " + resumeFileExtension);
		TestNGLogUtility.info("resume content map " + resumeContentMap);
		genericFunctions.createResumeFileInDocFormat(resumeFileExtension , resumeContentMap);
		getElement(eleSelectFilePath).sendKeys(GenericFunctions.file.getAbsolutePath());
		resumeContentMap.clear();
	}
	
	/**
	 * To map the uploaded profile to a requirement basis on New/Existing Requirement
	 * @param mappingMethod
	 */
	public void mapCVToRequirement(String mappingMethod) {
		if (mappingMethod.equals("Add New ".trim()))
			click(eleAddNewRequirement);
		else
			click(eleExistingRequirement);
	}
	
	/**
	 * To fill the requirement title in case of add new requirement
	 * @param requirementTitle
	 */
	public void fillInTheRequirementTitle(String requirementTitle) {
		wait.hardWait(10);
		requirementNameOfMultipleUpload = requirementTitle + Long.toString(System.currentTimeMillis());
		sendKeys(eleRequirementName, requirementNameOfMultipleUpload);
		TestNGLogUtility.info("requirement created with name " + requirementNameOfMultipleUpload);
	}
	
	/**
	 * To click on upload button present on the webpage
	 */
	public void clickOnUploadFileButton() {
		click(btnUploadFile);
		TestNGLogUtility.info("Upload Multiple files button clicked");
	}
	
	/**
	 * To verify the success message after upload of CV
	 * @param actualSuccessMessage
	 * @return true/false basis the comparison
	 */
	public boolean checkThePresenceOfSuccessUploadMessage(String actualSuccessMessage) {
		wait.waitForInvisibilityOfElement(10, 3, eleProcessLoader);
		return getText(eleSuccessMessageOnMultipleUpload).equals(actualSuccessMessage);
	}
	
	/**
	 * To click on the upload logs button next to the success message
	 */
	public void clickOnViewUploadLogsButton() {
		click(eleUploadLogs);
	}
	
	/** 
	 * To verify the count under the column name for the local upload button
	 * @param count
	 * @param columnName
	 * @return true/false basis the comparison
	 */
	public boolean checkThePresenceOfCorrectCountForCorrectColumn(String count,String columnName) {
		genericFunctions.switchToChildWindow();
		boolean flag=false;
		if(columnName.equals("Profiles Created")) 
			flag = Integer.parseInt(getText(eleProfileCreated)) == Integer.parseInt(count);
		return flag;
	}
	
}
