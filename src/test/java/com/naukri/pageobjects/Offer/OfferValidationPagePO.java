package com.naukri.pageobjects.Offer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.JSUtility;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

public class OfferValidationPagePO extends BaseAutomation {

	// variables
	public static String candidateName = "", contactNumber = "", emailId = "", requirementTitle = "",
			offeredDesignation = "", candidatesJoiningSalary = "", offerLetterPath = "", offeredOnDateValue = "",
			candidateTentativeJoiningDateValue = "";
	static String selectionStage = "Prospect";
	public static String candidateDetailsPageUrl = "";
	static String OfferGenPageVerifyText = "Fill Offer Details";

	// locators
	public By successMessage_span = By.xpath("//div[@id = \"messageFromAddCand\"]//span");
	public By statusChangeArrow = By
			.xpath("//a[text()=\" Reject \"]/preceding-sibling::a//*[contains(@class, \" outerArow\")]");

	public By candidateName_text = By.xpath("//label[@for= \"name\"]/following-sibling::input");
	public By email_text = By.id("emilBlock_0");
	public By contact_text = By.id("numBlock_0");
	public By saveCandidate_btn = By.id("editCandBasicButton");
	public By addNewRequirement_link = By.xpath("//a[text()=\"Add New \"]");
	public By requirementTitle_text = By.id("projectName");
	public By statusSelect_dd = By.id("subStatusId");
	public By visibilityToRecruiters = By.id("visToMe");

	public By lblOfferGenPage = By.xpath("//span[@class='stepper current disable']/span");
	public By txtOfferedDesignation = By.name("designation");
	public By txtCandidatesJoiningSalary = By.name("salary");
	public By offeredOnDate = By.xpath("(//div[@class='dateHolder']/span)[1]");
	public By tentativeJoiningDate = By.xpath("(//div[@class='dateHolder']/span)[2]");
	public By btnCancelOffer = By.xpath("//button[@class='cancel noBorderBtn']");
	public By currentStatusOfCandidate = By.xpath("//span[contains(@class,\" interTxt\")]");
	public By statusChangeSuccessMessage = By.xpath("//div[@id ='statusChangeMessageDiv']//span[@class='etxt']");
	public By txtOfferedOnDate = By.xpath("(//div[@class='dateHolder']/span)[1]");
	public By btnNextOnOfferDetails = By.id("sendOfferMail");
	public By attachOfferLetterInput = By.id("attachOfferLetter");
	public By btnAttachOfferLetterUpload = By.xpath("//*[starts-with(@class,'uploadBtn')]");
	public By errorValidationOfferDetails = By.xpath("(//p[@class='erLbl err'])[${string}]");
	public By dateOnOfferDetailsPage = By.xpath("//label[text()='${string}']/following-sibling::div//span");
	
	public void addCandidateInformation() {
		candidateName = "candidateName";
		contactNumber = Long.toString(System.currentTimeMillis()).substring(0, 10);
		emailId = "email" + System.currentTimeMillis() + "@yopmail.com";
		sendKeys(candidateName_text, candidateName);
		sendKeys(email_text, emailId);
		sendKeys(contact_text, contactNumber);
	}

	public void addRequirementDetailsForCandidate() {
		requirementTitle = "addSingleCandidateRequirement" + System.currentTimeMillis();
		click(addNewRequirement_link);
		sendKeys(requirementTitle_text, requirementTitle);
		jsUtil.scrollDown(statusSelect_dd);
		click(statusSelect_dd);
		click(By.xpath("(//select[@id=\"subStatusId\"]/option[contains(text(),\"" + selectionStage + "\")])[1]"));
	}

	public void clickAddCandidateBtn() {
		jsUtil.scrollDown(saveCandidate_btn);
		click(saveCandidate_btn);
	}

	public void selectGroupForNewRequirement(String groupName) {
		click(By.id("inp_hiringFordd"));
		click(By.xpath("//a[text()=\"" + groupName + "\"]"));
	}

	public void selectVisibilityOption(String visibilityOption) {
		wait.waitForInvisibilityOfElement(10, 3,
				By.xpath("//div[@class=\" processing-overlay processing-overlay-40  \" ]"));
		click(By.xpath("//label[contains(text(),\"Visibility Setting: \")]"));
		click(By.xpath("//select[@id = \"visToMe\"]/option[contains(text(), \"" + visibilityOption + "\")]"));
	}

	public boolean verifyRedirectedOnCVDetailsPage() {
		wait.waitForPageToLoadCompletely();
		return driver.getCurrentUrl().contains(YamlReader.getAppConfigValue("URLs.cvDetailsPage"));
	}

	public boolean verifySuccessStatusMessage(String successMessage) {
		candidateDetailsPageUrl = driver.getCurrentUrl();
		return getText(successMessage_span).contains(successMessage);
	}

	public void clickOnStatusChangeDD() {
		click(statusChangeArrow);
	}

	public void changeStatusOfCandidate(String statusText) {
		click(By.xpath("(//a[contains(text(),\"" + statusText + "\")])[1]"));
	}

	public boolean verifyRedirectedOnOfferGenerationPage() {
		wait.waitForPageToLoadCompletely();
		return getText(lblOfferGenPage).contains(OfferGenPageVerifyText);
	}

	public void addOfferedDesignation(String designation) {
		offeredDesignation = designation;
		ReadWritePropertyFile.setProperty("OfferedDesignation", offeredDesignation,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		sendKeys(txtOfferedDesignation, offeredDesignation);
	}

	public void addCandidatesJoiningSalary(String salary) {
		candidatesJoiningSalary = salary;
		ReadWritePropertyFile.setProperty("candidatesJoiningSalary", candidatesJoiningSalary,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		sendKeys(txtCandidatesJoiningSalary, candidatesJoiningSalary);
	}

	public void addOfferedOnDate(String currentDate) {
		sendKeys(offeredOnDate, currentDate);
	}

	public void addCandidatesTentativeJoiningDate(String currentDate) {
		sendKeys(tentativeJoiningDate, currentDate);
	}

	public void clickAddCancelOfferBtn() {
		click(btnCancelOffer);
	}

	public boolean verifyStatusOfCandidate(String statusText) {
		return getText(currentStatusOfCandidate).contains(statusText);
	}

	public boolean validateStatusChangeSuccessMessage(String successMessage) {
		wait.waitForInvisibilityOfElement(10, 3,
				By.xpath("//div[@class = ' processing-overlay processing-overlay-40  ']"));
		return getText(statusChangeSuccessMessage).contains(successMessage);
	}

	@SuppressWarnings("unused")
	private String selectDateInCalendar(String dateToSelect) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		Date date = new Date();
		try {
			date = formatter.parse(dateToSelect);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime();
		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(currentDate);
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(date);

		int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		// System.out.println(diffMonth);
		if (diffMonth <= 0) {
			int x = diffMonth * -1;
			for (int i = 0; i < x; i++) {
				// click(By.xpath("//div[@class='viewContainer']//span[contains(@aria-label,'Previous
				// Month')]"));
				click(By.xpath("//span[contains(@aria-label,'Previous Month')]"));
			}
		jsUtil.scrollDown(By.xpath("//div[contains(@class,'DayPicker-Day') and (@aria-disabled = 'false' and text()='" + date.getDate()
							+ "')]"));
		
			click(By.xpath(
					// "//div[@class='viewContainer']//div[contains(@class,'DayPicker-Day')
					// and (@aria-disabled = 'false' and text()='"
					// + date.getDate() + "')]"));
					"//div[contains(@class,'DayPicker-Day') and (@aria-disabled = 'false' and text()='" + date.getDate()
							+ "')]"));

		} else {
			for (int i = 0; i < diffMonth; i++) {
				// click(By.xpath("//div[@class='viewContainer']//span[contains(@aria-label,'Next
				// Month')]"));
				click(By.xpath("//span[contains(@aria-label,'Next Month')]"));
			}
			click(By.xpath(
					// "//div[@class='viewContainer']//div[contains(@class,'DayPicker-Day')
					// and (@aria-disabled = 'false' and text()='"
					// + date.getDate() + "')]"));
					"//div[contains(@class,'DayPicker-Day') and (@aria-disabled = 'false' and text()='" + date.getDate()
							+ "')]"));
		}

		return dateToSelect;
	}

	@SuppressWarnings("deprecation")
	public String selectDateInCalendar(String labelName, int daysToShift) {
		if (labelName.equalsIgnoreCase("special")) {
			labelName = " tentative joining date";
			// click(By.xpath("//div[@class='viewContainer']//*[text()=\"" +
			// labelName
			// + "\"]/following::*[contains(@class,'calenderIcon')][1]"));
//			click(By.xpath("//*[text()=\"" + labelName + "\"]/following::*[contains(@class,'calenderIcon')][1]"));
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, daysToShift);
			SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
			return selectDateInCalendar(formatter.format(cal.getTime()));
		} else if (getText(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, "span")))
				.contains("Choose Date")) {
		//	click(By.xpath("//label[contains(text(),'"+labelName+"')]/ancestor::div[@class='offerField']//i"));
			click(By.xpath("//label[contains(text(),'"+labelName+"')]/parent::div//i"));
		//	click(By.xpath("//span[contains(text(),'" + labelName + "']/following::i[contains(@class,'calenderIcon')][1]"));
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, daysToShift);
			SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
			return selectDateInCalendar(formatter.format(cal.getTime()));
		} else {
			// click(By.xpath("//div[@class='viewContainer']//*[text()=\"" +
			// labelName
			// + "\"]/following::*[contains(@class,'calenderIcon')][1]"));
		//	click(By.xpath("//label[contains(text(),'"+labelName+"')]/ancestor::div[@class='offerField']//i"));
			click(By.xpath("//label[contains(text(),\""+labelName+"\")]/parent::div//i"));

			//click(By.xpath("//span[contains(text(),'" + labelName + "']/following::*[contains(@class,'calenderIcon')][1]"));
			String selected_date = getText(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, "span")));
			SimpleDateFormat format = new SimpleDateFormat("d MMM yyyy");
			Calendar cal = Calendar.getInstance();
			try {
				cal.set(Calendar.DATE, format.parse(selected_date).getDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cal.add(Calendar.DATE, daysToShift);
			return selectDateInCalendar(format.format(cal.getTime()));
		}

	}
	@SuppressWarnings("deprecation")
	public String selectDateInCalendarInOfferGenerationOld(String labelName, int daysToShift) {
		if (labelName.equalsIgnoreCase("special")) {
			labelName = " tentative joining date";
			// click(By.xpath("//div[@class='viewContainer']//*[text()=\"" +
			// labelName
			// + "\"]/following::*[contains(@class,'calenderIcon')][1]"));
//			click(By.xpath("//*[text()=\"" + labelName + "\"]/following::*[contains(@class,'calenderIcon')][1]"));
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, daysToShift);
			SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
			return selectDateInCalendar(formatter.format(cal.getTime()));
		} else if (getText(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, "span")))
				.contains("Choose Date")) {
			click(By.xpath("//label[contains(text(),'"+labelName+"')]/ancestor::div[@class='offerField']//i"));
		//	click(By.xpath("//label[contains(text(),'"+labelName+"')]/ancestor::div[@class='input-wrapper']//i"));
		//	click(By.xpath("//span[contains(text(),'" + labelName + "']/following::i[contains(@class,'calenderIcon')][1]"));
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, daysToShift);
			SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
			return selectDateInCalendar(formatter.format(cal.getTime()));
		} else {
			// click(By.xpath("//div[@class='viewContainer']//*[text()=\"" +
			// labelName
			// + "\"]/following::*[contains(@class,'calenderIcon')][1]"));
			click(By.xpath("//label[contains(text(),'"+labelName+"')]/ancestor::div[@class='offerField']//i"));
		//	click(By.xpath("//label[contains(text(),'"+labelName+"')]/ancestor::div[@class='input-wrapper']//i"));

			//click(By.xpath("//span[contains(text(),'" + labelName + "']/following::*[contains(@class,'calenderIcon')][1]"));
			String selected_date = getText(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, "span")));
			SimpleDateFormat format = new SimpleDateFormat("d MMM yyyy");
			Calendar cal = Calendar.getInstance();
			try {
				cal.set(Calendar.DATE, format.parse(selected_date).getDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cal.add(Calendar.DATE, daysToShift);
			return selectDateInCalendar(format.format(cal.getTime()));
		}

	}

	private String goToTextAreaOrInputTextBoxInViewContainer(String labelName, String fieldType) {
		// return "//div[@class='viewContainer']//*[text()='" + labelName +
		// "']/following::" + fieldType + "[1]";
	//	return "//*[text()=\"" + labelName + "\"]/following::" + fieldType + "[1]";
		return "//label[contains(text(),\""+ labelName +"\")]/following-sibling::div//"+fieldType+"";
	}

	public boolean verifyOfferedDateSameAsCurrentDate(String date) {
		return (date.contains(getText(txtOfferedOnDate)));
	}

	public void addAlphanumericsAndNumrericsInSalaryTextBox(String str) {
		sendKeys(txtCandidatesJoiningSalary, str);
	}

	public boolean verifySalaryTextboxIsNumeric() {
		return GenericFunctions.checkStringIsNumeric(getAttribute(txtCandidatesJoiningSalary, "value"));
	}

	public void clickNextOnOfferDetailsBtn() {
		click(btnNextOnOfferDetails);
	}

	/**
	 * save Offered On Date and Candidate's tentative joining date Filed Values
	 */
	public void saveValuesEnteredInDateFields() {
		offeredOnDateValue = getText(offeredOnDate);
		ReadWritePropertyFile.setProperty("offeredOnDateValue", offeredOnDateValue,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
		candidateTentativeJoiningDateValue = getText(tentativeJoiningDate);
		ReadWritePropertyFile.setProperty("candidateTentativeJoiningDateValue", candidateTentativeJoiningDateValue,
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
	}

	/*
	 * public void attachOfferLetterOnAttachOfferLetterPage() { if
	 * (System.getProperty("os.name").toString().toLowerCase().contains(
	 * "windows")) { offerLetterPath = System.getProperty("user.dir") + "\\" +
	 * YamlReader.getAppConfigValue("TestData.OfferLetterPath"); } else if
	 * (System.getProperty("os.name").equalsIgnoreCase("linux")) {
	 * offerLetterPath = "~" +
	 * YamlReader.getAppConfigValue("TestData.OfferLetterPath"); } else if
	 * (System.getProperty("os.name").equalsIgnoreCase("unix")) {
	 * offerLetterPath = "~" +
	 * YamlReader.getAppConfigValue("TestData.OfferLetterPath"); }
	 * System.out.println(offerLetterPath); while
	 * (elementVisibility(btnAttachOfferLetterUpload)) ; String
	 * showAttachOfferLetterInput =
	 * "document.getElementById('attachOfferLetter').style.display = 'inline-block';"
	 * ; jsUtil.executeJavascript(showAttachOfferLetterInput);
	 * wait.waitForVisibilityOfElement(btnAttachOfferLetterUpload); //
	 * sendKeys(attachOfferLetterInput, offerLetterPath);
	 * jsUtil.sendKeysByJS(attachOfferLetterInput, offerLetterPath);
	 * 
	 * String hideAttachOfferLetterInput =
	 * "document.getElementById('attachOfferLetter').style.display = 'none';";
	 * System.out.println(getAttribute(attachOfferLetterInput, "files")); }
	 */
	/**clear designation on offer details page 
	 * 
	 */
	public void clearDesignation()
	{
		getElement(txtOfferedDesignation).clear();
	}
	/**clear Joining Salary on offer details page 
	 * 
	 */
	public void clearJoiningSalary()
	{
		getElement(txtCandidatesJoiningSalary).clear();
	}
	/**verify Validation of Designation And Salary
	 * @param errorOfferDetails
	 * @return true if Validation of Designation And Salary is displayed 
	 */
	public boolean verifyValidationDesignationAndSalary(String errorOfferDetails)
	{
		String designationError = getText(parameterizedLocator(errorValidationOfferDetails,Integer.toString(1)));
		String salaryError = getText(parameterizedLocator(errorValidationOfferDetails,Integer.toString(2)));
		return designationError.contains(errorOfferDetails) && salaryError.contains(errorOfferDetails);
	}
	/**verify Joining Date Is Not Selected
	 * @param LabelOfferedDetails
	 * @return true if Joining Date Is Not displayed 
	 */
	public boolean verifyJoiningDateIsNotSelected(String LabelOfferedDetails)
	{
		return getText(parameterizedLocator(dateOnOfferDetailsPage,LabelOfferedDetails)).contains("Choose Date");
	}
	
}
