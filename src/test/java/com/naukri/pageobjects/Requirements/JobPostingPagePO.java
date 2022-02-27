package com.naukri.pageobjects.Requirements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.naukri.test.base.PageObjectWrapper;

/**
 * Job Posting page object class
 * 
 * @author rachit.mehrotra
 *
 */
public class JobPostingPagePO extends PageObjectWrapper {

	By eleNextButtonOnEditJob = By.id("buttonID");
	By eleEmploymentType = By.id("employmentType");
	By eleEmployementTypeDD = By.xpath("//li[contains(@value,'${value}')]");
	By eleKeywordSkill = By.xpath("//input[@id='keySkillSugg']");
	By eleKeywordSkillStar = By.xpath("//span[@class='tagTxt' and text()='${value}']/preceding-sibling::span");
	By eleKeywordSkillValue = By.xpath("//span[@class='tagTxt' and text()='${value}']");
	By eleSelectField = By.xpath("//input[@id='${value}']");
	By eleSelectFieldValue = By.xpath("//input[@id='${value}']/parent::div//li[text()='${value}']");
	By eleVariableChangeLink = By.xpath("//span[@class='fixedSal show']/button");
	By eleVariableInput = By.xpath("//input[@class='jpInput varSalaryInp']");
	By eleWalkin = By.xpath("//label[text()='Include walk-in details']");
	By eleRequirementName = By.id("requirementName");
	By eleWalkinStartDate = By.xpath("(//input[@id='startDate'])[${value}]");
	By eleWalkinStartDateTotal = By.xpath("(//input[@id='startDate'])");
	By eleScheduleRefreshEndDate = By.id("endDate");
	By eleVenue= By.xpath("//textarea[@id='venueAddress']");
	By eleScheduleRefreshLink= By.xpath("//button[text()='Schedule Refresh']");
	By eleRefreshType= By.xpath("//span[text()='${value}']");
	By eleRefreshFixedDate = By.id("refBtnDate");
	By eleSaveButton= By.xpath("//span[text()='SAVE']");
	By elePreviewAndPostButton= By.xpath("//button[@id='jpSubmit']");
	By eleNextDateFromCalaender1=By.xpath("(//div[contains(@class,'DayPicker-Day--today')]/parent::div/following-sibling::div//div)[${value}]");
	By eleNextDateFromCalaender=By.xpath("(//div[contains(@class,'DayPicker-Day--today')]/following-sibling::div)[${value}]");
	By eleAMRCheckbox = By.xpath("//label[@for='showhideRmEmails']");
	By eleAMREmailField = By.xpath("//input[@id='rmsEmails']");
	By eleAddEmailLink= By.xpath("//li[@class='notFound']/span[text()='Add']");
	By elePostbutton = By.xpath("//span[text()='Post Job']/parent::button");
	By eleJobPostingHeading = By.id("desigSugg");
	By eleRefCode = By.id("refCode");
	By eleVacancyField = By.id("vacancyField");
	By eleJobDescriptionValue=By.xpath("(//span[text()='${value}']/parent::span/parent::div[contains(@class,'DraftStyleDefault')]/parent::div/following-sibling::div//span[@data-text='true'])[1]");
	By eleJobDescriptionfield=By.xpath("//span[text()='${value}']");
	By eleDismissguide=By.id("guide-dismiss-button");
	By elerightPanel=By.id("jpRightPanel");
	By scheduleRefreshPopUp=By.xpath("//div[@id='scroll-dialog-title']");
	By circleLoader=By.xpath("//div[@class='circle']");
	By eleWalkinTiming=By.id("dailyTiming");
	By eleWalkinDuration=By.id("duration");
	By attachedVideoThumbnail=By.xpath("//img[@alt='video thumb']");
	By eleCompanyDetailsEditBtn=By.xpath("//div[@class='companyContainer']//span[contains(@class,'edit')]");
	By attachedPhotoThumbnail=By.xpath("(//img[@alt='company thumb'])[${value}]");
	By eleUploadPhotoLink=By.xpath("//label[text()='Upload Photo/PPT']");
	By eleUploadedPhotos=By.xpath("//label[@for='UploadPhotos']/following-sibling::div//img");
	By eleJDValues=By.xpath("(//span[text()='${value}']/ancestor::div[contains(@class,'textAreawithCounter')]//textarea)[3]");
	By eleAddCandidateLink=By.xpath("//button[@name='addCandidateProfile']");
	By eleEducationCombination=By.xpath("//div[contains(@class,'degreeCombination')]");
	By eleCompanyDetails=By.xpath("//div[@class='companyContainer']//div[@role='textbox']");
	By eleCompanyDetailsValue=By.xpath("(//div[@class='companyContainer']//div[@role='textbox']//span/*)[1]");
	By eleContactPersonName=By.xpath("//input[@name='walkinContactPerson']");
	By eleContactPersonNumber=By.xpath("//input[@name='walkinContactNumber']");
	By eleMapURL=By.xpath("//input[@name='mapUrl']");
	
	
	/**
	 * To click on next button of the edit job flow
	 */
	public void clickOnNextButtonForEditJob() {
		click(eleNextButtonOnEditJob);
	}

	/**
	 * This method will select Employment Type
	 * 
	 * @author himanshu.dua
	 * @param employementType
	 */
	public void selectEmployementType(String employementType) {
		click(eleEmploymentType);
		click(parameterizedLocator(eleEmployementTypeDD, employementType));
	}

	/**
	 * This method will keyword skill
	 * 
	 * @author himanshu.dua
	 * @param keySkill
	 */
	public void fillKeywordOnJp(String keySkill) {
		if(isDisplayed(eleDismissguide))
			click(eleDismissguide);
		click(eleKeywordSkill);
		sendKeys(eleKeywordSkill, keySkill);
		getElement(eleKeywordSkill).submit();
		if(isDisplayed(eleDismissguide))
			click(eleDismissguide);
	}

	/**
	 * This method will make keyskill must have
	 * 
	 * @author himanshu.dua
	 * @param keyskill
	 */
	public void makeKeyskillMustHave(String keyskill) {
		click(parameterizedLocator(eleKeywordSkillStar, keyskill));
	}

	/**
	 * This method will click on variable's change link
	 * 
	 * @author himanshu.dua
	 */
	public void clickOnChangeButton(String maxExp) {
		click(eleVariableChangeLink);
	}

	/**
	 * This method will fill variable
	 * 
	 * @param value
	 */
	public void fillVariable(String value) {
		click(eleVariableChangeLink);
		click(eleVariableInput);
		sendKeys(eleVariableInput, value);
	}

	/**
	 * This method will select value from field
	 * 
	 * @author himanshu.dua
	 * @param fieldName, value
	 */
	public void selectFieldValue(String fieldName, String value) {
		String field = "";
		switch (fieldName) {
		case "Minimum Salary":
			field = "minSalary";
			break;
		case "Maximum Salary":
			field = "maxSalary";
			break;
		case "Minimum Experience":
			field = "minimumExperience";
			break;
		case "Maximum Experience":
			field = "maximumExperience";
			break;
		case "Location":
			field = "Location";
			break;
		case "Industry":
			field = "industry";
			break;
		case "Functional Area":
			field = "farea";
			break;
		case "Role":
			field = "role";
			break;
		case "Currency":
			field = "currency";
			break;
		case "Duration":
			field = "duration";
			break;
		case "Refresh Stop":
			field = "refDimention";
			break;
		default:
			System.out.println("Please Provide correct Field Name.");
			break;
		}
		click(parameterizedLocator(eleSelectField, field));
		click(parameterizedLocator(eleSelectFieldValue, field, value));
		if(!field.equals("refDimention"))
			click(elerightPanel);
	}

	/**
	 * This method will click on walkIn checkbox
	 */
	public void clickOnWalkinCheckbox() {
		click(eleWalkin);
	}

	/**
	 * This method will fill the requirement name
	 * 
	 * @author himanshu.dua
	 * @return
	 */
	public String fillRequireemntName() {
		String reqName = "JP_Requirement_" + System.currentTimeMillis();
		sendKeys(eleRequirementName, reqName);
		return reqName;
	}
	
	/**
	 * This method will click on Schedule Refresh link
	 * @author himanshu.dua
	 */
	public void clickOnScheduleRefreshLink() {
		movebyoffsetAndClick(eleScheduleRefreshLink, 0, 0);
		//click(eleScheduleRefreshLink);
	}
	
	/**
	 * This method will fill the venue detials
	 * @param venue
	 */
	public void enterVenueDetails(String venue) {
		sendKeys(eleVenue, venue);
	}
	
	/**
	 * This method will select Refresh Type
	 * @param refreshType
	 */
	public void selectRefreshType(String refreshType) {
		click(parameterizedLocator(eleRefreshType, refreshType));
	}
	
	/**
	 * This method will select the fixed stop refresh date
	 * @param days
	 */
	public void selectFixedStopRefreshDate(String days) {
		click(eleRefreshFixedDate);
		click(eleScheduleRefreshEndDate);
		if(isDisplayed(parameterizedLocator(eleNextDateFromCalaender,days)))
			click(parameterizedLocator(eleNextDateFromCalaender,days));
		else
			click(parameterizedLocator(eleNextDateFromCalaender1,days));
	}
	
	/**
	 * This method will select start day
	 * @param days
	 */
	public void selectNextDaysfromStartCalender(String days) {
		int size=getElements(eleWalkinStartDateTotal).size();
		click(parameterizedLocator(eleWalkinStartDate, String.valueOf(size)));
		if(isDisplayed(parameterizedLocator(eleNextDateFromCalaender,days)))
			click(parameterizedLocator(eleNextDateFromCalaender,days));
		else
			click(parameterizedLocator(eleNextDateFromCalaender1,days));
	}
	
	/**
	 * This method will click on save button on schedule refresh pop-up
	 */
	public void clickOnSaveButton() {
		click(eleSaveButton);
	}
	
	/**
	 * This method will click on Preview and post button
	 */
	public void clickOnPreviewAndPostButton() {
		click(elePreviewAndPostButton);
		click(elePostbutton);
		wait.waitForInvisibilityOfElement(50, 5, circleLoader);
	}
	
	/**
	 * This method will enter the email in AMR field
	 * @param mail
	 */
	public void enterAmrMail(String mail) {
		click(eleAMRCheckbox);
		click(eleAMREmailField);
		sendKeys(eleAMREmailField, mail);
		click(eleAddEmailLink);
	}
	
	/**
	 * This method will verify Keyskill
	 * @param keyskill
	 * @return
	 */
	public boolean verifyKeyskills(String keyskill) {
		return isDisplayed(parameterizedLocator(eleKeywordSkillValue, keyskill));
	}
	
	/**
	 * This method will verify variable
	 * @param variable
	 * @return
	 */
	public boolean verifyVeriable(int variable) {
		return Integer.valueOf(getAttribute(eleVariableInput,"value").trim())==variable;
	}
	
	/**
	 * This method will verify Keyskill must have
	 * @param keyskill
	 * @return
	 */
	public boolean verifyKeyskillsMustHave(String keyskill) {
		return getAttribute(parameterizedLocator(eleKeywordSkillStar, keyskill),"class").contains("shapeFull");
	}
	
	/**
	 * This method will verify employment Type
	 * @param employmentType
	 * @return
	 */
	public boolean verifyEmploymentType(String employmentType) {
		return getAttribute(eleEmploymentType, "value").trim().equals(employmentType);
	}
	
	/**
	 * This method will fill Job Posting Heading
	 * @param jobHeading
	 */
	public void filljobPostingHeading(String jobHeading) {
		if(isDisplayed(eleDismissguide))
			click(eleDismissguide);
		click(eleJobPostingHeading);
		sendKeys(eleJobPostingHeading, jobHeading);
	}
	
	/**
	 * This method will fill refCode
	 * @param refCode
	 */
	public void fillrefcode(String refCode) {
		click(eleRefCode);
		sendKeys(eleRefCode, refCode);
	}
	
	/**
	 * This method will fill vacancy
	 * @param vacancy
	 */
	public void fillVacancyField(String vacancy) {
		click(eleVacancyField);
		sendKeys(eleVacancyField, vacancy);
	}
	
	/**
	 * This wrapper method will select walkin and set walking duration as '2' and place 'Noida'
	 * @param days
	 */
	public void selectWalkin(String days) {
		clickOnWalkinCheckbox();
		selectNextDaysfromStartCalender(days);
		selectFieldValue("Duration", "2");
		enterVenueDetails("Noida");
		fillContactPersonName("Interviewer");
		fillContactPersonNumber("9876543211");
		fillMapURL("https://www.google.co.in/maps?q=28.1472852,77.3259878");
	}
	
	/**
	 * This method will set refresh schedule 
	 * @param days
	 * @param refreshType
	 */
	public void selectRefreshschedule(String refreshType, String days) {
		clickOnScheduleRefreshLink();
		while (!isDisplayed(scheduleRefreshPopUp))
			clickOnScheduleRefreshLink();
		selectRefreshType(refreshType);
		selectNextDaysfromStartCalender(days);
		selectFieldValue("Refresh Stop", days);
		clickOnSaveButton();

	}

	/**
	 * This method will fill job description on JP
	 * @param field
	 * @param jd
	 */
	public void filljobDescription(String field, String jd) {
		if(isDisplayed(eleDismissguide))
			click(eleDismissguide);
		click(parameterizedLocator(eleJobDescriptionfield, field));
		actionBuilderUtil.sendKeysByAction(parameterizedLocator(eleJobDescriptionfield, field), Keys.ARROW_DOWN);
		//actionBuilderUtil.sendKeysByAction(parameterizedLocator(eleJobDescriptionfield, field), Keys.ENTER);
		//getElement(parameterizedLocator(eleJobDescriptionfield, field)).sendKeys(Keys.ENTER);
		//click(parameterizedLocator(eleJobDescriptionValue, field));
		getElement(parameterizedLocator(By.xpath("(//span[text()='${value}']/parent::span/parent::div[contains(@class,'DraftStyleDefault')]/parent::div/following-sibling::div//span[@data-text='true'])[1]"), field)).sendKeys(jd);
	}
	
	public void selectEducation(String field, String degree, String subject) {
		click(parameterizedLocator(eleSelectField, field));
		click(parameterizedLocator(eleSelectFieldValue, field, degree));
		click(parameterizedLocator(eleSelectFieldValue, field, subject));
		click(elerightPanel);
	}
	
	/**
	 * This method will verify the walkin start date
	 * @param startDate
	 * @return
	 */
	public boolean verifyWalkinStartDate(String startDate) {
		return getAttribute(eleWalkinStartDateTotal, "value").contains(startDate);
	}
	
	/**
	 * This method will verify walkin timing
	 * @param timing
	 * @return
	 */
	public boolean verifyWalkinTiming(String timing) {
		return getAttribute(eleWalkinTiming, "value").contains(timing);
	}
	
	/**
	 * This method will verify walkin Duration
	 * @param timing
	 * @return
	 */
	public boolean verifyWalkinDuration(String duration) {
		return getAttribute(eleWalkinDuration, "value").contains(duration);
	}
	
	/**
	 * This method will click on the Company details edit button
	 */
	public void clickOnCompanyDetailsEditBtn() {
		click(eleCompanyDetailsEditBtn);
	}
	
	/**
	 * This method will verify attached video with job
	 * @return
	 */
	public boolean verifyVideoThumbnail() {
		return isDisplayed(attachedVideoThumbnail);
	}
	
	/**
	 * This method will verify attached Photo with job
	 * @return
	 */
	public boolean verifyPhotoThumbnail() {
		boolean flag = true;
		for (int i = 1; i <= 5; i++) {
			if (!isDisplayed(parameterizedLocator(attachedPhotoThumbnail, String.valueOf(i)))) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * This method is used for verify classified job JD values
	 * @param field
	 * @param expected
	 * @return
	 */
	public boolean verifyJdValuesForClassifiedJob(String field, String expected) {
		return getText(parameterizedLocator(eleJDValues, field)).equals(expected);
	}
	
	/**
	 * This method will verify job description values on JP
	 * @param field
	 * @param jd
	 */
	public boolean verifyjobDescriptionValues(String field, String jd) {
		if (isDisplayed(parameterizedLocator(eleJobDescriptionfield, field)))
			click(parameterizedLocator(eleJobDescriptionfield, field));
		if (!isDisplayed(parameterizedLocator(By.xpath(
				"(//span[text()='${value}']/parent::span/parent::div[contains(@class,'DraftStyleDefault')]/parent::div/following-sibling::div//span[@data-text='true'])[1]"),
				field)))
			return false;
		return getElement(parameterizedLocator(By.xpath(
				"(//span[text()='${value}']/parent::span/parent::div[contains(@class,'DraftStyleDefault')]/parent::div/following-sibling::div//span[@data-text='true'])[1]"),
				field)).getText().contains(jd);
	}
	
	/**
	 * This function will enter values in classified JD fields
	 * @param field
	 * @param value
	 */
	public void fillClassifiedJD(String field, String value) {
		if (field.contains("Candidate")) {
			if(isDisplayed(eleAddCandidateLink))
				click(eleAddCandidateLink);
		}
		click(parameterizedLocator(By.xpath("((//span[text()='${value}']/ancestor::div[contains(@class,'labelFeildName')])/following-sibling::div)[1]"),field));
		getElement(parameterizedLocator(eleJDValues,field)).clear();
		getElement(parameterizedLocator(eleJDValues,field)).sendKeys(value);
	}
	
	/**
	 * This function will enter values in classified JD fields
	 * @param field
	 * @param value
	 */
	public boolean verifyClassifiedJD(String field, String value) {
		return getText(parameterizedLocator(eleJDValues, field)).contains(value);
	}
	
	
	/**
	 * This method will fill job description on JP
	 * @param field
	 * @param jd
	 */
	public void removeJobDescription(String field) {
		click(parameterizedLocator(eleJobDescriptionfield, field));
		while (!getElement(parameterizedLocator(eleJobDescriptionValue, field)).getText().isEmpty()) {
			getElement(parameterizedLocator(eleJobDescriptionValue, field)).sendKeys(Keys.BACK_SPACE);
		}
		getElement(parameterizedLocator(eleJobDescriptionValue, field)).clear();
		getElement(parameterizedLocator(eleJobDescriptionfield, field)).clear();
	}
	
	/**
	 * This method will verify the education combination text on JP form
	 * @param expected
	 * @return
	 */
	public boolean verifyEducationSpecialization(String expected) {
		return getText(eleEducationCombination).contains(expected);
	}
	
	/**
	 * This method will fill the company details
	 * @param details
	 */
	public void fillCompanyDetails(String details) {
		click(eleCompanyDetails);
		sendKeys(eleCompanyDetails, details);
	}
	
	/**
	 * This method will fill the contact person name
	 * @param name
	 */
	public void fillContactPersonName(String name) {
		click(eleContactPersonName);
		sendKeys(eleContactPersonName, name);
	}
	
	/**
	 * This method will fill the contact person number
	 * @param number
	 */
	public void fillContactPersonNumber(String number) {
		click(eleContactPersonNumber);
		sendKeys(eleContactPersonNumber, number);
	}
	
	/**
	 * This method will fill the map url
	 * @param url
	 */
	public void fillMapURL(String url) {
		click(eleMapURL);
		sendKeys(eleMapURL, url);
	}
}
