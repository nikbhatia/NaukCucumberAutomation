package com.naukri.pageobjects.Settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;

public class ManageFeedbackFormPO extends BaseAutomation {
	
	
	//private By txtFormTitle = By.id("formTitle");
	private By txtFormName = By.id("templateName");
	private By txtOption1 = By.id("option01");
	private By txtOption2 = By.id("option02");
//	private static By lnkDeleteForm = By.xpath("(//a[text()='Delete'])[1]");
	private static By eleSameFeedbackFormName = By.xpath("//select[@class='fr']//option[2]"); 
	private By btnConfirmationDelete = By.cssSelector("button[class='confBtn yes']");
	private By ddPrefill = By.xpath("//select[@class='fr']");
	private By ddSelectPrefillTemplate = By.xpath("//select[@class='fr']/option[3]");
	private By chkShareWithEveryone = By.xpath("//label[text()='Share with everyone']");
	private By txtFirstQuestion = By.xpath("//input[@name='questionName0']");
	private By btnAddQuestion = By.xpath("//button[@class='addQuestion']");
	private By txtFormTitle = By.id("formTitle");
	private By txtFormHeading = By.xpath("//h2");
	private By inputFormTitle = By.xpath("//input[@id='formTitle']");
	private By txtStateName = By.xpath("//div[text()='${button}']");
	private By btnAddOnHoldDefForm = By.xpath("//div[text()='Add On Hold']");
	private By btnOnFeedbackForm = By.xpath("//button[text()='${button}']");
	private By lnkBackArrow = By.xpath("//span[@class='backArrow']");
	private By btnRemoveState = By.xpath("//div[@title='${btnName}']//..//div[@class='delOpt']");
	private By btnOnHoldSuggester = By.xpath("//li[@class='choice']");
	private By inputStateName = By.xpath("//input[@placeholder='Add another option']");
	private By inputFeedbackFormName = By.xpath("//input[@id='templateName']");
	private By txtHeaderError = By.xpath("//div[@id='feedMsgBoxID_cMsgCnt']//p");
	private By elebtnAddQuestion = By.xpath("//span[text()='${text}']");
	private By weQuestions = By.xpath("//div[@id='fieldsWrapperDiv']//div[contains(@class,'tuple')]");
	private By btnDeleteDuplicateQuestion = By.xpath("//span[@title='${title}']");
	private By weStatesName = By.xpath("//div[@class='optionName ']");
	private By txtStatesName = By.xpath("(//div[@class='optionName '])[${number}]");
	private By txtDefaultStateMapping = By.xpath("//div[@title='${stateName}']//following-sibling::div//span");
	private By lblFormTitle = By.xpath("//label[text()='${formTitle}']");
	private By txtInfoInHeader = By.xpath("//div//p[text()='${text}']");
	private By txtStateNameError = By.xpath("//input[contains(@id,'feedbackOptionId')]/..//p");
	private By ddChangeQuestionType = By.xpath("//label[text()='Change question type']//..//select");
	private By txtQuestionType = By.xpath("//label[text()='Change question type']//..//option[text()='${quesType}']");
	private By weNoQuesPreview = By.xpath("//div[contains(@class,'noQue')]");
	private By ddstateMapping = By.xpath("//div[@title='${stateName}']//..//div[contains(@class,'questionList')]/span");
	private By weTopTupleOfQues = By.xpath("(//div[@id='fieldsWrapperDiv']//div[@class='sideLabel'])[1]");
	private By chkMarkOverAllRating = By.xpath("//input[@id='overallRating']");
	private By txtGetTitleMarkOverallRating = By.xpath("//input[@id='overallRating']//../..");
	private By chkSelectAll = By.xpath("//div[@class='selectAllSection']//input");
	private By weQuestionsListInMappingDD = By.xpath("//div[@class='select-list']//li//input");
	private By weInputQuestions = By.xpath("//input[@value='' and @placeholder='Click to type question']");
	private By weInputOptions = By.xpath("//input[@value='' and @placeholder='Enter option']");
	private By weInputHelpText = By.xpath("//input[@value='' and @placeholder='Please provide the help text']");
	private By chkQuesInStateMapping = By.xpath("(//div[@class='select-list']//li//input)[${header}]");
	private By txtTitleAddButtonMaxLimit = By.xpath("//span[text()='Add Question']/..");
	private By weGetPreviewQuestionText = By.xpath("//h2[@class='question']");
	private By weGetQuestionText = By.xpath("//input[@placeholder='Click to type question']");
	private By weGetQuestionInStateMappingdd = By.xpath("//li//label");
	private By eleSelectAllCheckboxQuestionMappingDD = By.xpath("//div[@class='selectAllSection']");
	private By eleChkQuesInStateMapping = By.xpath("(//div[@class='select-list']//li)[${header}]");
	private By ddPrefillForm = By.xpath("//option[@value='default']/parent::select");
	private By eleTopPrefillForm = By.xpath("(//option[@value='default']/parent::select//option)[2]");
	private By txtQuestion = By.xpath("//h2[@class='question' and text()='${quesTxt}']");
	public static List<String> feedbackQuestions = new ArrayList<String>();
	String questionTxt,filledText;
				
	
	
	public boolean verifyHeadings(String heading) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(By.xpath("//h2[text()='"+heading+"']"));
	}

	public void fillFormNames(String formName) {
		getElement(txtFormTitle).clear();
		getElement(txtFormTitle).sendKeys("Automation Feedback Form");
		getElement(txtFormName).clear();
		getElement(txtFormName).sendKeys(formName);
	}
		
	public void createAllTypeQuestions(String question) {
		getElement(txtFirstQuestion).sendKeys(question);
		getElement(txtOption1).sendKeys("Options A");
		getElement(txtOption2).sendKeys("Option B");
		getElement(btnAddQuestion).click();
		
		
	}
	
	public boolean verifyFormsAdded(String formName) {
		wait.waitForPageToLoadCompletely();		
		pageRefresh();
		return (isDisplayed(By.xpath("//a[contains(text(),'"+formName+"')]")));
	}
	
	public void fillMandatoryFieldsForFeedbackForm(String formName) {
		wait.waitForPageToLoadCompletely();
		getElement(txtFormName).clear();
		getElement(txtFormName).sendKeys(formName);
	}
	
	public void userEnterSameFeedbackName() {
		String existingFeedbackForm = getElement(eleSameFeedbackFormName).getText();
		getElement(txtFormName).sendKeys(existingFeedbackForm);
	}
	public void fillNewfieldsFeedbackForm(String formName) {
		getElement(txtFormTitle).clear();
		getElement(txtFormTitle).sendKeys("New Form Title");
		getElement(txtFormName).clear();
		getElement(txtFormName).sendKeys(formName);
		getElement(txtFirstQuestion).clear();
		getElement(txtFirstQuestion).sendKeys("This is First Question");
		getElement(txtOption1).clear();
		getElement(txtOption1).sendKeys(" New Option1");
		getElement(txtOption2).clear();
		getElement(txtOption2).sendKeys(" New Option2");
	}

	public boolean verifyPreviewFeedbackForms() {
		return isDisplayed(By.xpath("//h2[contains(text(),'Preview')]"));
	}
	
	public void deleteFeedbackForms(String formName) {
		wait.waitForElementToBeClickable(By.xpath("//a[@title='"+formName+"']//parent::div//parent::div//a[text()='Delete']"));
		getElement(By.xpath("//a[@title='"+formName+"']//parent::div//parent::div//a[text()='Delete']")).click();
		getElement(btnConfirmationDelete).click();		
	}

	public void prefillFeedbackForms() {
		getElement(ddPrefill).click();
		getElement(ddSelectPrefillTemplate).click();
		wait.waitForPageToLoadCompletely();
		}
		
		public void unCheckShareCheckBoxs() {
		getElement(chkShareWithEveryone).click();	
		}
		
		
		
	/**
	 * @author gupta.mansi 
	 * This method is used to fill feedback form title
	 * @param title
	 */
	public void fillFormTitle(String title) {
		jsUtil.scrollDown(parameterizedLocator(lblFormTitle, "Form Title"));
		getElement(inputFormTitle).clear();
		getElement(inputFormTitle).sendKeys(title);
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to get the heading of feedback form
	 *         e.g "Create Feedback Form" or "Edit Feedback Form"
	 * @return string message with heading text
	 */
	public String getFeedbackFormHeader() {
		wait.waitForPageToLoadCompletely();
		return (getText(txtFormHeading));
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to add on hold state in default feedback from, if on hold button is already present then it removes it first and then add on hold
	 */
	public void addOnHoldStateInDefaultForm(String stateName) {
		jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
		if (isDisplayed(parameterizedLocator(txtStateName, stateName))) {
			removeState(stateName);
		}
		click(parameterizedLocator(btnAddOnHoldDefForm, stateName));
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to remove state from feedback form
	 * @param stateName of state which is to be removed
	 */
	public void removeState(String stateName) {
		jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
		if (isDisplayed(parameterizedLocator(txtStateName, stateName))) {
			wait.waitForVisibilityOfElement(parameterizedLocator(btnRemoveState, stateName));
			getElement(btnRemoveState, stateName).click();
		}
	}

	/**
	 * @author gupta.mansi 
	 * This method return true is On Hold State is displayed
	 * @return true if state name is displayed
	 */
	public boolean isStateDisplayed(String stateName) {
		jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
		return isDisplayed(parameterizedLocator(txtStateName, stateName));
	}

	/**
	 * @author gupta.mansi This method is used to return true is image/button to
	 *         remove state is displayed
	 * @param stateName
	 * @return boolean true if remove state present
	 */
	public boolean isStateRemoveBtnDispayed(String stateName) {
		return isDisplayed(parameterizedLocator(btnRemoveState, stateName));
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to add on hold button in non default feedback form
	 * @param stateName
	 */
	public void addOnHoldState(String stateName) {
		jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
		clickOnGivenButton("Add another option");
		jsUtil.scrollDown(parameterizedLocator(txtStateName, "Add another option"));
		click(inputStateName);
		click(btnOnHoldSuggester);
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to click on back arrow from feedback form preview page
	 */
	public void clickOnBackArrowButtonFromPreviewPage() {
		click(lnkBackArrow);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to fill feedback form name
	 * @param formName
	 */
	public void fillFeedbackFormName(String formName) {
		getElement(inputFeedbackFormName).clear();
		getElement(inputFeedbackFormName).sendKeys(formName);
	}

	/**
	 * @author gupta.mansi This method is used to get the error message displayed on
	 *         feedback form header
	 * @return error message in string format
	 */
	public String getErrorDisplayedOnHeader() {
		return getText(txtHeaderError);
	}

	/**
	 * @author gupta.mansi This method is used to delete all the questions present
	 *         in feedback form
	 */
	public void deleteAllQuestions() {
		wait.waitForPageToLoadCompletely();
		int numberOfQuestions = getElements(weQuestions).size();
		int tempCounter = 1;
		while (numberOfQuestions > 0) {
			if (numberOfQuestions == 1) {
				clickOnGivenButton("Delete question");
				numberOfQuestions = getElements(weQuestions).size();
			} else {
				jsUtil.scrollDown(parameterizedLocator(lblFormTitle, "Form Title"));
				if (tempCounter == 1) {
					getElement(weTopTupleOfQues).click();
					tempCounter++;
				}
				clickOnGivenButton("Delete question");
				numberOfQuestions = getElements(weQuestions).size();
			}
		}
	}

	/**
	 * @author gupta.mansi This method is used to return the text of all the states
	 *         present in feedback form
	 * @return A List containing text of states
	 */
	public List<String> getNameOfAllStatesOfFeedbackForm() {
		List<String> nameOfStates = new ArrayList<String>();
		int numberOfStates = getElements(weStatesName).size();
		while (numberOfStates > 0) {
			nameOfStates.add(getText(parameterizedLocator(txtStatesName, String.valueOf(numberOfStates))));
			--numberOfStates;
		}
		return nameOfStates;
	}

	/**
	 * @author gupta.mansi This method is used to get default state mapping i.e when
	 *         there are no question in feedback form and when all question are
	 *         selected by default when there is at least on question in form
	 * @param stateName
	 * @return text of mapping e.g "Ask No Questions" when no question are there in
	 *         ff and "Ask AllQuestions" when there is at least one ques
	 */
	public String getDefaultStateMappingText(String stateName) {
		return getText(parameterizedLocator(txtDefaultStateMapping, stateName));
	}

	public void clickOnGivenButton(String btnText) {
		switch (btnText) {
		case "Add Question":
			click(parameterizedLocator(elebtnAddQuestion, btnText));
			break;

		case "Duplicate this question":
			click(parameterizedLocator(btnDeleteDuplicateQuestion, btnText));
			break;

		case "Delete question":
			click(parameterizedLocator(btnDeleteDuplicateQuestion, btnText));
			break;

		case "SAVE":
			wait.waitForElementToBeClickable(parameterizedLocator(btnOnFeedbackForm, btnText));
			click(parameterizedLocator(btnOnFeedbackForm, btnText));
			wait.waitForInvisibilityOfElement(2, 4, parameterizedLocator(btnOnFeedbackForm, btnText));
			wait.waitForValignWrapperToDisappear(2, 3);
			wait.waitForPageToLoadCompletely();
			break;

		case "PREVIEW":
			wait.waitForElementToBeClickable(parameterizedLocator(btnOnFeedbackForm, btnText));
			click(parameterizedLocator(btnOnFeedbackForm, btnText));
			wait.waitForPageToLoadCompletely();
			break;

		case "CANCEL":
			click(parameterizedLocator(btnOnFeedbackForm, btnText));
			wait.waitForPageToLoadCompletely();
			break;

		case "EDIT":
			wait.waitForElementToBeClickable(parameterizedLocator(btnOnFeedbackForm, btnText));
			click(parameterizedLocator(btnOnFeedbackForm, btnText));
			wait.waitForPageToLoadCompletely();
			break;

		case "Add another option":
			jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
			click(parameterizedLocator(txtStateName, btnText));
			break;

		default:
			TestNGLogUtility.fail("Incorrect name of button to click on");
			break;
		}
	}

	/**
	 * @author gupta.mansi This method is used to verify whether given text is
	 *         displayed or not
	 * @param text
	 * @return boolean true if given text displayed on Create Feedback form page
	 */
	public boolean isTextDisplayed(String text) {
		boolean returnValue = false;
		switch (text) {
		case "Feedback Questions":
			jsUtil.executeJavascript("arguments[0].scrollIntoView(false);",
					parameterizedLocator(lblFormTitle, "Form Title"));
			returnValue = isDisplayed(parameterizedLocator(elebtnAddQuestion, text));
			break;

		case "Feedback Response Options":
			jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
			returnValue = isDisplayed(parameterizedLocator(elebtnAddQuestion, text));
			break;

		case "Configure responses provided by hiring managers/interviewers for an application":
			jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
			returnValue = isDisplayed(parameterizedLocator(elebtnAddQuestion, text));
			break;

		case "Form Title":
			jsUtil.executeJavascript("window.scrollTo(0,0)");
			returnValue = isDisplayed(parameterizedLocator(lblFormTitle, text));
			break;

		case "Select questions to ask for this Option":
			jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
			returnValue = isDisplayed(parameterizedLocator(txtStateName, text));
			break;

		case "Share with everyone":
			jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
			returnValue = isDisplayed(parameterizedLocator(lblFormTitle, text));
			break;

		case "These questions will be answered by the Hiring Manager/Interviewer after interview with the candidate":
			returnValue = isDisplayed(parameterizedLocator(txtInfoInHeader, text));
			break;

		case "Options":
			jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
			returnValue = isDisplayed(parameterizedLocator(txtStateName, text));
			break;

		case "Preview for each Feedback Response Option:":
			jsUtil.executeJavascript("window.scrollTo(0,0)");
			returnValue = isDisplayed(parameterizedLocator(txtStateName, text));
			break;

		case "No further questions will be asked if the interviewer selects Approve":
			returnValue = isDisplayed(parameterizedLocator(btnOnFeedbackForm, text));
			break;

		case "New form has been added successfully":
			jsUtil.executeJavascript("window.scrollTo(0,0)");
			returnValue = isDisplayed(parameterizedLocator(txtStateName, text));
			break;

		}

		return returnValue;
	}

	/**
	 * @author gupta.mansi This method is used to fill state name with input text
	 * @param txtStateName
	 */
	public void fillStateName(String stateName) {
		jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
		getElement(inputStateName).clear();
		getElement(inputStateName).sendKeys(stateName);
		click(parameterizedLocator(txtStateName, "Reject"));
	}

	/**
	 * This method is used to click on the names of state in feedback form
	 * 
	 * @param stateName
	 */
	public void clickOnStateNameInFeedbackFormInPreview(String stateName) {
		// jsUtil.executeJavascript("arguments[0].scrollIntoView(false);",parameterizedLocator(txtStateName,stateName));
		// jsUtil.scrollToElement(parameterizedLocator(txtStateName,stateName));
		jsUtil.scrollDown(parameterizedLocator(txtStateName, stateName));
		click(parameterizedLocator(txtStateName, stateName));
	}

	/**
	 * @author gupta.mansi This method is used to get error displayed for incorrect
	 *         state name
	 *  @return Error displayed for incorrect state name in string
	 */
	public String getErrorDisplayedForIncorrectStateName() {
		jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
		return getText(txtStateNameError);
	}

	/**
	 * @author gupta.mansi This method is used to get the X coordinates of Add
	 *         Question button
	 * @param txtOfAddQuestion
	 * @return x coordinates of Add question button
	 */
	public int xCordOfAddQuestionBtn(String txtOfAddQuestion) {
		wait.waitForPageToLoadCompletely();
		return getXCoordinates(getElement(elebtnAddQuestion, txtOfAddQuestion));
	}

	/**
	 * @author gupta.mansi This method is used to get X coordinates of given web
	 *         element
	 * @param objPath
	 * @return x coordinate of given web element in int type
	 */
	public int getXCoordinates(WebElement objPath) {
		Point pt = objPath.getLocation();
		return pt.getX();
	}

	/**
	 * @author gupta.mansi This method is used to get the number of questions
	 *         present in feedback form
	 * @return number of questions in form in int
	 */
	public int getNumberOfQuestionsInFeedbackForm() {
		return getElements(weQuestions).size();
	}
	
	/**
	 * This method return form title
	 * @return form title in string
	 */
	public String getFormTitle() {
		return getAttribute(inputFormTitle, "value");
	}

	/**
	 * @author gupta.mansi This method is used to click on change question type drop
	 *         down
	 */
	public void clickOnChangeQuestionDD() {
		jsUtil.executeJavascript("arguments[0].scrollIntoView(false);", getElement(txtStateName, "Reject"));
		click(ddChangeQuestionType);
	}

	/**
	 * @author gupta.mansi This method is used to select question type from change
	 *         question type drop down
	 * @param quesType
	 */
	public void clickOnQuestionType(String quesType) {
		click(parameterizedLocator(txtQuestionType, quesType));
	}

	/**
	 * @author gupta.mansi This method is used to hover over mark over all rating
	 *         checkbox
	 * @param textLabel
	 */
	public void hoverOverMarkOverallRating(String textLabel) {
		actionBuilderUtil.hoverByAction(parameterizedLocator(lblFormTitle, textLabel));
	}

	/**
	 * @author gupta.mansi This method is used to hover over Add Question button
	 * @param spanText
	 */
	public void hoverOverAddQuestionBtn(String spanText) {
		actionBuilderUtil.hoverByAction(parameterizedLocator(elebtnAddQuestion, spanText));
	}

	/**
	 * @author gupta.mansi This method is used to return the text message displayed
	 *         on preview page when no question are mapped
	 * @return message displayed
	 */
	public String getMsgWhenNoQuestMapped(String stateName) {
		clickOnStateNameInFeedbackFormInPreview(stateName);
		return getText(weNoQuesPreview);
	}

	/**
	 * @author gupta.mansi This method is used to click on state question mapping dd
	 *         of given state name
	 * @param stateName
	 */
	public void clickOnStateMappingDD(String stateName) {
		jsUtil.scrollDown(parameterizedLocator(txtStateName, "Reject"));
		click(parameterizedLocator(ddstateMapping, stateName));
	}

	/**
	 * @author gupta.mansi This method is used to return true if mark as overall
	 *         rating is selected for selected star rating question
	 * @return boolean true if mark overall rating is selected
	 */
	public boolean isMarkAsOverallRatingSelected() {
		return getElement(chkMarkOverAllRating).isSelected();
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to get the title of mark overall rating question when one question is already selected as overall raiting question
	 * @return string overall rating
	 */
	public String getOverAllRatingTitle() {
		return getAttribute(txtGetTitleMarkOverallRating, "title");
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to un select none, un-select all and un-select few questions from state question mapping
	 * @param choice
	 */
	public void chooseQuestionMapping(String choice) {
		if (choice.equals("all")) {
			if (getElement(chkSelectAll).isSelected())
				getElement(eleSelectAllCheckboxQuestionMappingDD).click();
		} else if (choice.equals("none")) {
			if (!getElement(chkSelectAll).isSelected())
				getElement(eleSelectAllCheckboxQuestionMappingDD).click();
		} else {
			try {
				int noOfQuestionToUnselect = Integer.parseInt(choice);
				if (noOfQuestionToUnselect > getElements(weQuestionsListInMappingDD).size()) {
					TestNGLogUtility.fail("Incorrect number of questions selected");
				}
				while (noOfQuestionToUnselect > 0) {
					jsUtil.scrollDown(
							parameterizedLocator(chkQuesInStateMapping, String.valueOf(noOfQuestionToUnselect)));
					getElement(parameterizedLocator(eleChkQuesInStateMapping, String.valueOf(noOfQuestionToUnselect)))
							.click();
					--noOfQuestionToUnselect;
				}
			} catch (NumberFormatException e) {
				throw e;
			}
		}
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to fill the fields of question test,option text and help text
	 * @param element
	 * @param number
	 * @param text
	 * @param customText
	 */
	public void fillText(By element, String text, String... customText) {
		for (WebElement webElement : getElements(element)) {
			jsUtil.executeJavascript("arguments[0].click();", webElement);
			filledText = text + " " + CommonAction.generateRandomStrings(5, "String");
			webElement.sendKeys(filledText);
			if(text.contains("Question")) {
				questionTxt = filledText;
				TestNGLogUtility.info("User adds question name "+filledText);}
			wait.hardWait(2);
		}
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to fill the text for question
	 */
	public void fillQuestionOptionHelpText(String... quesOptionTxt) {
		if (getElements(weInputQuestions).size() > 0) {
			fillText(weInputQuestions, "Question");
		}
		if (getElements(weInputOptions).size() > 0) {
			fillText(weInputOptions, "Option");
		}
		if (getElements(weInputHelpText).size() > 0) {
			fillText(weInputHelpText, "HelpText");
		}
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to add the given type of question for given number of times
	 * @param questionType
	 * @param noOfQuestions
	 */
	public void addQuestions(String questionType, int noOfQuestions, String... optionQuestionText) {
		switch (questionType) {
		case "Single Choice ":
		case "Multiple Choice ":
		case "Dropdown ":
		case "Short Paragraph ":
		case "Star Rating ":
		case "One Line Answer ":
			while (noOfQuestions > 0) {
				clickOnGivenButton("Add Question");
				clickOnChangeQuestionDD();
				clickOnQuestionType(questionType.trim());
				fillQuestionOptionHelpText(optionQuestionText);
				feedbackQuestions.add(questionTxt);
				--noOfQuestions;
			}
		}

	}

	/**
	 * @author gupta.mansi 
	 * This method is used to get title displayed on add button when max question limit for adding question is reached
	 * @return title displayed for Add Question button
	 */
	public String getAddQuesMaxTitle() {
		return getAttribute(txtTitleAddButtonMaxLimit, "title");
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to get the text of question displayed on previewing feedback form
	 * @return list of question in string form
	 */
	public List<String> getQuesListDisplayedOnPreview() {
		List<String> questionList = new ArrayList<String>();
		for (WebElement webElement : getElements(weGetPreviewQuestionText)) {
			questionList.add(getText(webElement));
		}
		return questionList;
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to get the text of question displayed on edit page of feedback form
	 * @return list of question in string form
	 */
	public List<String> getQuesListDisplayedOnEdit() {
		List<String> questionList = new ArrayList<String>();
		for (WebElement webElement : getElements(weGetQuestionText)) {
			questionList.add(webElement.getAttribute("value"));
		}
		return questionList;
	}

	/**
	 * @author gupta.mansi This method is used to get the text of question displayed on state mapping dd
	 * @return list of question in string form
	 */
	public List<String> getQuesListDisplayedOnMappingDD() {
		List<String> questionList = new ArrayList<String>();
		for (WebElement webElement : getElements(weGetQuestionInStateMappingdd)) {
			questionList.add(getText(webElement));
		}
		return questionList;
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to fill feedback form from top prefill option available
	 */
	public void prefillFromTopForm() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(ddPrefillForm));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(ddPrefillForm));
		click(ddPrefillForm);
		click(eleTopPrefillForm);

	}
	
	public boolean verifyPresenceOfQuestionOnPreview(String question)
	{
		return isDisplayed(parameterizedLocator(txtQuestion,question));
	}
}
