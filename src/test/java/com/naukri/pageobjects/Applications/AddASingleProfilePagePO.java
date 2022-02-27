package com.naukri.pageobjects.Applications;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Class comprises of page object of add a single profile webpage
 * 
 * @author rachit.mehrotra
 *
 */
public class AddASingleProfilePagePO extends PageObjectWrapper {

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	// variables
	public static String candidateName = "", contactNumber = "", requirementTitle = "", secondaryContactNumber = "";
	public static String emailId = null;
	public static String secondaryEmail = "";
	static String selectionStage = "Prospect";
	public String baseUrlOfCVDetailsPage = "/application/viewApplication";
	public static String profileSummary = "";
	public static String newRequirementTitle = "";
	boolean flag = false;
	boolean randomNameGeneration = false;
	HashMap<String, String> resumeContentMap = new HashMap<String, String>();

	// locators
	public By candidateName_text = By.xpath("//label[@for= \"name\"]/following-sibling::input");
	public By email_text = By.id("emilBlock_0");
	public By contact_text = By.id("numBlock_0");
	public By saveCandidate_btn = By.id("editCandBasicButton");
	public By addNewRequirement_link = By.xpath("//a[text()=\"Add New \"]");
	public By requirementTitle_text = By.id("projectName");
	public By statusSelect_dd = By.id("subStatusId");
	public By visibilityToRecruiters = By.id("visToMe");
	By eleCandidateName = By.id("candidateName");
	By eleCandidateNameError = By.id("candidateName_err");
	By eleCandidateEmailError = By.id("candidateProfile[alternateEmails][0][email]_err");
	By elePhoneNumber = By.id("numBlock_0");
	By eleCandidateMobileError = By.id("candidateProfile[alternatePhones][0][phoneNo]_err");
	By eleProfileSummary = By.id("profile");
	By eleProfileSummaryErrorText = By.id("profile_err");
	By eleAddAnotherEmail = By.xpath("//a[contains(text(),\"Add another email\")]");
	By eleSecondaryEmail = By.id("emilBlock_4");
	By eleAddAnotherNumber = By.xpath("//a[contains(text(),\"Add another number\")]");
	By eleSecondaryNumber = By.id("numBlock_4");
	By eleUploadLogsText = By.xpath("//p[contains(text(),'${expectedText}')]");
	By eleUploadLogs = By.xpath("(//a[contains(text(),\"View Upload Logs\")])[1]");
	By eleEmailMainText = By.xpath("//p[contains(text(),'${mainText}')]");
	By eleListOfOptionForEmail = By.xpath("//span[contains(text(),'${listOfOptionText}')]");
	By eleEmailLinkOption = By.xpath("//a[contains(text(),\"Connect Your Email to get Resume\")]");
	By eleManageRecruiterProfile = By.xpath("//li[contains(text(),'${mainText}')]");
	By eleBulkUploadList = By.xpath("//*[contains(text(),'${replacementOption}')]");
	By eleBulkUploadLink = By.xpath("//a[contains(text(),\"Add Profiles via Bulk Upload\")]");
	By eleBulkUploadText = By.xpath("//div[contains(text(),'${replacementText}')]");
	By eleMultipleProfileUpload = By.xpath("//a[contains(text(),\"Add Multiple Profiles\")]");
	By eleExcelUpload = By.xpath("//a[contains(text(),\"Add Profiles via Excel Upload \")]");
	By eleAddNewRequirement = By.id("createNProject");
	By eleRequirementAdditionHeading = By.xpath("//*[contains(text(),'${replacementTag}')]");
	By eleRequirementName = By.id("projectName");
	By eleProcessOverlay = By.xpath("//div[contains(@class, \"processing-overlay\")]");
	By eleCurrentDesignation = By.id("Designation");
	By eleCompany = By.id("company");
	By eleLocation = By.id("inp_Location");
	By elePreferredLocation = By.xpath("//label[contains(text(),'${preferredLocationText}')]/input");
	By eleFunctionalArea = By.id("inp_functional");
	By eleRole = By.id("inp_role");
	By eleIndustry = By.id("inp_industry");
	By eleTotalExperienceInYears = By.id("t_exp");
	By eleTotalExperienceInMonths = By.name("candidateProfile[experienceMonths]");
	By eleAnnualSalaryInLakhs = By.id("anualSal");
	By eleAnnaulSalaryInThousands = By.name("candidateProfile[annualSalaryThousands]");
	By eleExpectedCTCInLakhs = By.name("candidateProfile[expectedCTCLacs]");
	By eleExpectedCTCInThousands = By.name("candidateProfile[expectedCTCThousands]");
	By eleCurrentKeyHolder = By.xpath("//em[contains(text(),'${keyString}')]/following-sibling::span");
	By eleCommentsTextArea = By.name("comments");
	By eleUploadFile = By.id("infile");
	By eleImageUploadForCandidate = By.id("profilePhotoInput");
	By eleStatusSelectOnCreation = By.id("subStatusId");
	By eleCandCurrentLocation = By.xpath("//div[@id='basicDetailsOfCandidate']//input[@id='locSuggestor']");
	By eleVeriableAmount = By.id("amountOfVariableSalary");
	
	/**
	 * To add basic information like name,contact and email of candidate
	 * 
	 * @author rachit.mehrotra
	 */
	public void addCandidateInformation() {
		wait.hardWait(1);
		candidateName = "candidateName";
		contactNumber = Long.toString(System.currentTimeMillis()).substring(0, 10);
		wait.waitForVisibilityOfElement(candidateName_text);
		sendKeys(candidateName_text, candidateName);
		this.emailId =  "email" + System.currentTimeMillis() + "@yopmail.com";
		sendKeys(email_text, this.emailId);
		sendKeys(contact_text, contactNumber);
	}

	/**
	 * To create requirement using requirement widget on Add A single profile
	 * 
	 * @author rachit.mehrotra
	 */
	public void addRequirementDetailsForCandidate() {
		requirementTitle = "addSingleCandidateRequirement" + System.currentTimeMillis();
		click(addNewRequirement_link);
		sendKeys(requirementTitle_text, requirementTitle);
		jsUtil.scrollDown(statusSelect_dd);
		click(statusSelect_dd);
		click(By.xpath("(//select[@id=\"subStatusId\"]/option[contains(text(),\"" + selectionStage + "\")])[1]"));
	}

	/**
	 * To click on save candidate button present on layout
	 * 
	 * @author rachit.mehrotra
	 */
	public void clickAddCandidateBtn() {
		wait.waitForInvisibilityOfElement(10, 2, eleProcessOverlay);
		jsUtil.scrollDown(saveCandidate_btn);
		click(saveCandidate_btn);
		wait.hardWait(5);
		if(isDisplayed(saveCandidate_btn))
			click(saveCandidate_btn);
	}

	/**
	 * To select the group while creating the requirement
	 * 
	 * @author rachit.mehrotra
	 * @param groupName
	 */
	public void selectGroupForNewRequirement(String groupName) {
		click(By.id("inp_hiringFordd"));
		click(By.xpath("//a[text()=\"" + groupName + "\"]"));
	}

	/**
	 * To select the visibility option for paricular requirement
	 * 
	 * @author rachit.mehrotra
	 * @param visibilityOption
	 */
	public void selectVisibilityOption(String visibilityOption) {
		wait.waitForInvisibilityOfElement(10, 3,
				By.xpath("//div[@class=\" processing-overlay processing-overlay-40  \" ]"));
		click(By.xpath("//label[contains(text(),\"Visibility Setting: \")]"));
		click(By.xpath("//select[@id = \"visToMe\"]/option[contains(text(), \"" + visibilityOption + "\")]"));
	}

	/**
	 * To fill in the candidate name on single profile upload page
	 * 
	 * @author rachit.mehrotra
	 * @param candidateName
	 */
	@SuppressWarnings("static-access")
	public void enterTheCandidateName(String candidateName) {
		if(randomNameGeneration) 
			this.candidateName = candidateName;
		else 
			this.candidateName = candidateName + GenericFunctions.generateRandomStrings(2, "String");
		sendKeys(eleCandidateName, this.candidateName);
		TestNGLogUtility.info("candidate name " + this.candidateName);
		PropFileHandler.writeProperty("candidateName", this.candidateName);
	}

	/**
	 * To verify the error message for candidate name
	 * 
	 * @author rachit.mehrotra
	 * @param actualErrorMessage
	 * @return true/false basis on the name check
	 */
	public boolean verifyTheErrorMessage(String actualErrorMessage) {
		return isDisplayed(eleCandidateNameError) && getText(eleCandidateNameError).equals(actualErrorMessage);
	}

	/**
	 * To input the length of the candidate based on number of characters
	 * 
	 * @author rachit.mehrotra
	 * @param characterLength
	 */
	@SuppressWarnings("static-access")
	public void enterTheCandidateNameOfGivenCharacterLength(String characterLength) {
		int charsLength = Integer.parseInt(characterLength);
		flag = charsLength > 35 ? true : false;
		randomNameGeneration = true;
		enterTheCandidateName(GenericFunctions.generateRandomStrings(charsLength, "String"));
	}

	/**
	 * To fill the candidate email on random basis
	 * 
	 * @author rachit.mehrotra
	 */
	public void fillInCandidateEmail() {
		this.emailId =  "email" + System.currentTimeMillis() + "@yopmail.com";
		sendKeys(email_text, this.emailId);
		PropFileHandler.writeProperty("Candidate Email", this.emailId);
	}

	/**
	 * To fill in the candidate email id
	 * 
	 * @param emailId
	 */
	public void fillInCandidateEmail(String emailId) {
		if (!((emailId.contains("empty")) || (emailId.contains("max length")))) {
			this.emailId = emailId;
			sendKeys(email_text, emailId);
		}
		if (emailId.contains("max length")) {
			this.emailId = GenericFunctions.generateRandomStrings(242, "String") + "@yopmail.com";
			sendKeys(email_text, emailId);
		}
	}

	/**
	 * To verify the candidate email error message
	 * 
	 * @param expectedErrorMessage
	 * @return boolean basis comparison
	 */
	public boolean verifyTheEmailErrorMessage(String expectedErrorMessage) {
		return getText(eleCandidateEmailError).equals(expectedErrorMessage);
	}

	/**
	 * To fill the mobile number of candidate
	 * 
	 * @author rachit.mehrotra
	 * @param mobileNumber
	 */
	public void fillInTheMobileNumber(String mobileNumber) {
		if (mobileNumber.equals("16 digit"))
			contactNumber = GenericFunctions.generateRandomStrings(16, "Number");
		else
			contactNumber = mobileNumber;
		TestNGLogUtility.info("contact number " + contactNumber);
		sendKeys(elePhoneNumber, contactNumber);
	}

	/**
	 * To verify the error message for the contact number
	 * 
	 * @param expectedErrorMessage
	 */
	public boolean verifyErrorMessageForContactNumber(String expectedErrorMessage) {
		return getText(eleCandidateMobileError).equals(expectedErrorMessage);
	}

	/**
	 * To add the profile summary of the candidate
	 * 
	 * @param profileSummaryText
	 */
	public void addProfileSummary(String profileSummaryText) {
		sendKeys(eleProfileSummary, profileSummaryText);
	}

	/**
	 * To verify the profile summary error message
	 * 
	 * @param profileSummaryErrorText
	 * @return true/false basis comparison
	 */
	public boolean verifyTheProfileSummaryErrorMessage(String profileSummaryErrorText) {
		return getText(eleProfileSummaryErrorText).replaceAll("\"", "").equals(profileSummaryErrorText);
	}

	/**
	 * Add summary profile basis character length
	 * 
	 * @param lengthOfSummary
	 */
	public void addProfileSummary(int lengthOfSummary) {
		profileSummary = GenericFunctions.generateRandomStrings(lengthOfSummary, "String");
		addProfileSummary(profileSummary);
	}

	/**
	 * To fill secondary email while creating the candidate
	 */
	public void fillAnotherEmail() {
		click(eleAddAnotherEmail);
		wait.waitForVisibilityOfElement(eleSecondaryEmail);
		secondaryEmail = "email" + Long.toString(System.currentTimeMillis()) + "@yopmail.com";
		sendKeys(eleSecondaryEmail, secondaryEmail);
	}

	/**
	 * Fill random contact number
	 */
	public void fillInContactNumber() {
		contactNumber = GenericFunctions.generateRandomStrings(10, "Number");
		sendKeys(contact_text, contactNumber);
	}

	/**
	 * To fill the additional contact number
	 */
	public void fillInSecondaryNumber() {
		click(eleAddAnotherNumber);
		wait.waitForVisibilityOfElement(eleSecondaryNumber);
		secondaryContactNumber = GenericFunctions.generateRandomStrings(10, "Number");
		sendKeys(eleSecondaryNumber, secondaryContactNumber);
	}

	/**
	 * To verify upload logs text
	 * 
	 * @param expectedText
	 * @return true/false basis comparison
	 */
	public boolean verifyTheUploadLogsText(String expectedText) {
		return isDisplayed(parameterizedLocator(eleUploadLogsText, expectedText));
	}

	/**
	 * To click on link present basis the linkText
	 * 
	 * @param linkTextForClick
	 */
	public void clickOnLinkPresent(String linkTextForClick) {
		click(eleUploadLogs);
	}

	/**
	 * To verify the main text for the mail upload
	 * @param expectedMailText
	 * @return true/false basis comparison
	 */
	public boolean verifyTheMainTextForEmail(String expectedMailText) {
		return isDisplayed(parameterizedLocator(eleEmailMainText, expectedMailText));
	}

	/**
	 * To verify the list of options present under the email list
	 * @param expectedOption1
	 * @param expectedOption2
	 * @return true/false basis comparison
	 */
	public boolean verifyTheListOptionsForEmail(String expectedOption1, String expectedOption2) {
		return (isDisplayed(parameterizedLocator(eleListOfOptionForEmail, expectedOption1))
				&& isDisplayed(parameterizedLocator(eleListOfOptionForEmail, expectedOption2)));
	}
	
	/**
	 * To click on the email upload link
	 */
	public void clickOnEmailImportLink() {
		click(eleEmailLinkOption);
	}
	
	/**
	 * To verify the presence of manage recruiter page
	 * @param expectedHeadingText
	 * @return true/false basis comparison
	 */
	public boolean verifyThePresenceOfManageRecruiter(String expectedHeadingText) {
		return isDisplayed(parameterizedLocator(eleManageRecruiterProfile, expectedHeadingText));
	}
	
	/**
	 * To verify the presence of list under bulk upload
	 * @param expectedOption
	 * @return true/false basis comparison
	 */
	public boolean verifyThePresenceOfListUnderBulkUpload(String expectedOption) {
		return isDisplayed(parameterizedLocator(eleBulkUploadList, expectedOption));
	}
	
	/**
	 * TO click on the bulk upload link
	 */
	public void clickOnBulkUploadLink() {
		click(eleBulkUploadLink);
	}
	
	/**
	 * To verify the list of options present under the bulk upload
	 * @param replacementText
	 * @return true/false basis comparison
	 */
	public boolean verifyThePresenceOfBulkUpload(String replacementText) {
		return isDisplayed(parameterizedLocator(eleBulkUploadText, replacementText));
	}
	
	/**
	 * To verify the list of multiple option under upload
	 * @param expectedOption
	 * @return true/false basis comparison
	 */
	public boolean verifyThePresenceOfListUnderMultipleUpload(String expectedOption) {
		jsUtil.scrollDown(parameterizedLocator(eleBulkUploadList, expectedOption));
		return isDisplayed(parameterizedLocator(eleBulkUploadList, expectedOption));
	}
	
	/**
	 * to click on multiple upload link
	 */
	public void clickOnMultipleUploadLink() {
		click(eleMultipleProfileUpload);
	}
	
	/**
	 * To verify the text present under the email import
	 * @param expectedOption
	 * @return true/false basis comparison
	 */
	public boolean verifyTheTextPresentUnderEmail(String expectedOption) {
		jsUtil.scrollDown(parameterizedLocator(eleBulkUploadList, expectedOption));
		return isDisplayed(parameterizedLocator(eleBulkUploadList, expectedOption));
	}
	
	/**
	 * To click on the excel uplaod
	 */
	public void clickOnExcelUploadOnSingleUpload() {
		jsUtil.scrollMid(eleExcelUpload);
		click(eleExcelUpload);
	}
	
	/**
	 * TO click on the add new requirement link
	 */
	public void clickOnAddRequirement() {
		wait.waitForElementToBeClickable(eleAddNewRequirement);
		jsUtil.scrollDown(eleAddNewRequirement);
		click(eleAddNewRequirement);
	}
	
	/**
	 * check for the presence of add a new requirement div
	 * @param expectedString
	 * @return
	 */
	public boolean checkForPresenceOfAddNewRequirementDiv(String expectedString) {
		return (isDisplayed(parameterizedLocator(eleRequirementAdditionHeading, expectedString.split("-")[0]))
				&& isDisplayed(parameterizedLocator(eleRequirementAdditionHeading, expectedString.split("-")[1])));
	}
	
	/**
	 * To fill in the requirement title
	 */
	public String fillInRequirementTitleAddNewProfile() {
		newRequirementTitle = "Requirement Name" + GenericFunctions.generateRandomStrings(6, "Number");
		sendKeys(eleRequirementName, newRequirementTitle);
		PropFileHandler.writeProperty("requirementNameForApplication", newRequirementTitle);
		return newRequirementTitle;
	}
	
	/**
	 * This method will generate random email at a run time.
	 * @return
	 */
	public String fillInCandidateRandomEmail(String email) {
		sendKeys(email_text, email);
		return email;
	}
	
	public void fillInCurrentDesignation(String designationString) {
		sendKeys(eleCurrentDesignation, designationString);
		PropFileHandler.writeProperty("designation", designationString);
		TestNGLogUtility.info("Designation: " + designationString);
	}
	
	public void fillInCurrentCompany(String companyString) {
		sendKeys(eleCompany, companyString);
		PropFileHandler.writeProperty("company", companyString);
		TestNGLogUtility.info("Company: " + companyString);
	}
	
	public void fillInCurrentLocation(String location) {
		getElement(eleLocation).sendKeys(location+Keys.ENTER);
		PropFileHandler.writeProperty("currentLocation", location);
		TestNGLogUtility.info("Location: " + location);
	}
	
	public void selectPreferredLocation(String preferredLocation) {
		click(parameterizedLocator(elePreferredLocation, preferredLocation));
		PropFileHandler.writeProperty("preferredLocation", preferredLocation);
		TestNGLogUtility.info("Preferred City: " + preferredLocation);
	}
	
	public void fillInFunctionalArea(String functionalArea) {
		getElement(eleFunctionalArea).sendKeys(functionalArea+Keys.ENTER);
		PropFileHandler.writeProperty("functionalArea", functionalArea);
		TestNGLogUtility.info("Functional Area: "+ functionalArea);
	}
	
	public void fillInTheRole(String role) {
		getElement(eleRole).sendKeys(role+Keys.ENTER);
		PropFileHandler.writeProperty("role", role);
		TestNGLogUtility.info("Role: " + role);
	}
	
	public void fillInIndustry(String industry) {
		getElement(eleIndustry).sendKeys(industry+Keys.ENTER);
		PropFileHandler.writeProperty("industry", industry);
		TestNGLogUtility.info("Industry: " + industry);
	}
	
	public void fillInExperience(int yearsOfExp, int monthsOfExp) {
		selectByVisibleText(eleTotalExperienceInYears, ""+yearsOfExp);
		selectByVisibleText(eleTotalExperienceInMonths, ""+monthsOfExp);
		PropFileHandler.writeProperty("totalExperience", ""+yearsOfExp+ " Year(s) "+monthsOfExp+ " Month(s)");
		TestNGLogUtility.info("Experience in Years " + yearsOfExp + " months" + monthsOfExp);
	}
	
	public void fillInCurrentCTC(int ctcInLakhs, int ctcInThousands) {
		selectByVisibleText(eleAnnualSalaryInLakhs, ""+ctcInLakhs);
		selectByVisibleText(eleAnnaulSalaryInThousands, ""+ctcInThousands);
		PropFileHandler.writeProperty("annualSalary", ""+ctcInLakhs+"."+ctcInThousands/10);
		TestNGLogUtility.info("CTC in lakhs " + ctcInLakhs+ " in thousands "+ ctcInThousands);
	}
	
	public void fillInExpectedCTC(int expectedInLakhs, int expectedInThousands) {
		selectByVisibleText(eleExpectedCTCInLakhs, ""+expectedInLakhs);
		selectByVisibleText(eleExpectedCTCInThousands, ""+expectedInThousands);
		PropFileHandler.writeProperty("expectedCtc", ""+expectedInLakhs+"."+expectedInThousands/10);
		TestNGLogUtility.info("Expected CTC in lakhs " + expectedInLakhs + " in thousands "+ expectedInThousands);
	}
	
	public boolean verifyKeyForAProperty(String propertyNameOnUI, String propertyNameInPropFile) {
		if(propertyNameInPropFile.contains(" ")) {
			String secondPortionOfString = propertyNameInPropFile.split(" ")[1];
			propertyNameInPropFile = propertyNameInPropFile.split(" ")[0]+
					Character.toString(Character.toUpperCase(secondPortionOfString.charAt(0)))+
					secondPortionOfString.substring(1,secondPortionOfString.length());
		}
		return (getText(parameterizedLocator(eleCurrentKeyHolder, propertyNameOnUI)).replaceAll("Rs", "").replaceAll("Lakhs", "").trim()
				.equals(PropFileHandler.readProperty(propertyNameInPropFile)));
	}
	
	public void addCommentWhileCreation(String commentText) {
		sendKeys(eleCommentsTextArea, commentText);
		TestNGLogUtility.info("Comment Added " + commentText);
	}
	
	/**
	 * To create a resume
	 * @param resumeFileExtension
	 */
	public void selectTheCVToUpload(String resumeFileExtension,String ... location) {
		resumeContentMap.put("Name", "CandidateName");
		resumeContentMap.put("Email", "candidate"+Integer.toString(genericFunctions.generateRandomDigits(10))+"@yopmail.com");
		resumeContentMap.put("Phone", Integer.toString(genericFunctions.generateRandomDigits(10)));
		if(location.length>0) {
			String loc = location[0];
			resumeContentMap.put("Current Location", loc);
		}
		TestNGLogUtility.info("resume extension " + resumeFileExtension);
		TestNGLogUtility.info("resume content map " + resumeContentMap);
		genericFunctions.createResumeFileInDocFormat(resumeFileExtension , resumeContentMap);
		getElement(eleUploadFile).sendKeys(GenericFunctions.file.getAbsolutePath());
	}
	
	/**
	 * To verify the parsing values of CV 
	 * @param keyOfMapCreated
	 * @return boolean
	 */
	public boolean verifyTheParsingOfUploadCV(String keyOfMapCreated) {
		wait.waitForOverlayProcessingToDisappear(10, 5);
		wait.hardWait(2);
		if(keyOfMapCreated.equals("Name")) 
			return (resumeContentMap.get(keyOfMapCreated)).contains(getAttribute(eleCandidateName, "value"));
		if(keyOfMapCreated.equals("Phone"))
			return getAttribute(elePhoneNumber, "value").equals(resumeContentMap.get(keyOfMapCreated));
		if(keyOfMapCreated.equals("Email"))
			return getAttribute(email_text, "value").equals(resumeContentMap.get(keyOfMapCreated));
		if(keyOfMapCreated.equals("Current Location")) 
			return getAttribute(eleCandCurrentLocation, "placeholder").equals(resumeContentMap.get(keyOfMapCreated));
		return false;
	}
	
	/**
	 * To upload the candidate image
	 */
	public void uploadTheCandidateImage() {
		String imagePath = System.getProperty("user.dir")+ File.separator + "candidatepicture.jpg";
		getElement(eleImageUploadForCandidate).sendKeys(imagePath);
		wait.hardWait(4);
		TestNGLogUtility.info("Image Uploaded");
	}
	
	/**
	 * To change the status of the candidate while creation
	 * @param statusString
	 */
	public void changeStatusWhileCreation(String statusString) {
		selectByVisibleText(eleStatusSelectOnCreation, statusString);
	}
	
	public boolean verifyVariableAmountOnUpload(String expectedVariable){
		return getText(eleVeriableAmount).trim().contains(expectedVariable);
	}
}
