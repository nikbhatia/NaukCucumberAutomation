package com.naukri.pageobjects.HiringManager;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.naukri.test.base.PageObjectWrapper;

public class HMFeedbackPagePO extends PageObjectWrapper {

	By lnkCandidateName = By.xpath("//span[@title='${candEid}']//ancestor::div[contains(@class,'candDet')]//a[contains(@href,'http')]");
	By txtTopComment = By.xpath("((//ul[contains(@class,'commentList cle')]//li)[1]//div)[2]");
	By btnCommentFirstApplication = By.xpath("(//a[contains(@onclick,'showComments')])[1]");
	By txtAreaCommentBox = By.xpath("//textarea[@id='commentsTextArea']");
	By elecommentCountForFirstApplication = By.xpath("(//div[contains(@class,'hiringStat')])[1]//span[@id]");
	By firstProfileStarRating = By.xpath("(//div[contains(@class,'srchTup')])[1]//li[contains(@class,'selected')]");
	By totalFeedbackCountForStageOnPendingReviewFeedPageLabel = By.xpath("//p[@id='totalApplicantCount']");
	By eleFeedbackDDOption = By.xpath("(//div[contains(@class,'dropdown field')]//select)[${qnumber}]//option[@data-key='1']");
	By eleFeedbackStarRating = By.xpath("(//div[@class='field'])[${qnumber}]//li[@data-key='3']");
	By eleFeedbackSingleChoiceRadio = By.xpath("((//div[contains(@class,'singleChoice field')])[${qnumber}]//div[contains(@class,'feedOption')])[1]//label");
	By eleFeedbackMultiChk = By.xpath("((//div[contains(@class,'multipleChoice field')])[${qnumber}]//label)[1]");
	By eleTxtAreaFeedbackShortPara = By.xpath("(//div[contains(@class,'shortParagraph field')])[${qnumber}]//textarea");
	By eleTxtAreaFeedbackOneLine = By.xpath("(//div[contains(@class,'oneLineAnswer field')])[${qnumber}]//input");
	By eleTxtAreaFeedbackComment = By.xpath("(//div[contains(@class,'commentBox')])[${qnumber}]//textarea");
	By ddGiveFeedbackForGivenEid = By.xpath("//span[@title='${eID}']/../../../../../../..//span[contains(text(),'Give Feedback')]");
	By btnState = By.xpath("//li[text()='${stateName}']");
	By btnSubmit = By.xpath("(//button[contains(text(),'${btnName}')])[last()]");
	By ddGiveFeedbackForFirst = By.xpath("(//span[contains(text(),'Give Feedback')])[1]");
	By eleDropDown = By.xpath("(//div[contains(@class,'dropdown field')]//select)");
	By eleStarRating = By.xpath("//div[@class='field']");
	By eleSingleChoice = By.xpath("//div[contains(@class,'singleChoice field')]");
	By eleMultiChoice = By.xpath("//div[contains(@class,'multipleChoice field')]");
	By eleShortPara = By.xpath("//div[contains(@class,'shortParagraph field')]");
	By eleOneLine = By.xpath("//div[contains(@class,'oneLineAnswer field')]");
	By eleComment = By.xpath("//div[contains(@class,'commentBox')]");
	By eleNumberOfQues = By.xpath("//div[contains(@class,'field')]");
	By eleFeedbackFormLightBox = By.xpath("//div[@id='feedbackContainer']");
	By btnDiscardConfBox = By.xpath("//div[contains(@class,'feedbackChangeConfirmationBox')]//button[text()='${btn}']");

	/**
	 * @author gupta.mansi 
	 * This method is used to get overall feedback rating on Feedback form filled
	 * @return count of star rating
	 */
	public int getOverAllFeedbackStarRating() {
		List<WebElement> starRating = getElements(firstProfileStarRating);
		return starRating.size();
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to get the top comment for top application
	 * @return overall rating comment
	 */
	public String getOverAllFeedbackComment() {
		wait.waitForElementToBeClickable(btnCommentFirstApplication);
		getElement(btnCommentFirstApplication).click();
		wait.waitForVisibilityOfElement(txtAreaCommentBox);
		return getElement(txtTopComment).getText();
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to get the comment count for top application from SRP
	 * @return comment count
	 */
	public int getCommentCount() {
		return Integer.parseInt(getElement(elecommentCountForFirstApplication).getText());
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to give feedback to first candidate from Feedback pending page
	 */
	public void giveFeedbackToFirstCandidate() {
		wait.waitForVisibilityOfElement(ddGiveFeedbackForFirst);
		wait.waitForElementToBeClickable(ddGiveFeedbackForFirst);
		getElement(ddGiveFeedbackForFirst).click();
		fillFeedbackForm();
	}

	/**
	 * @author gupta.mansi 
	 * This method returns the name displayed after feedback is submitted
	 * @param actions: state of feedback given
	 * @return text displayed in string
	 */
	public String nameDisplayedAfterFeedbackApproved(String action) {
		By approvedFeedbackLabel = By.xpath("//span[contains(@title,'" + action + "')]");
		return getText(approvedFeedbackLabel);
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to click on comment count of top application
	 */
	public void clickOnCommentCount() {
		click(elecommentCountForFirstApplication);
	}

	/**
	 * @author gupta.mansi 
	 * This method returns the summation of total feedback pending on all pipeline stage
	 * @return total count of feedback pending on pipeline stages in int
	 */
	public int getTotalFeedbackCountForPipelineStageOnPendingReviewPage() {
		wait.waitForVisibilityOfElement(totalFeedbackCountForStageOnPendingReviewFeedPageLabel);
		StringBuilder countOnPendingReviewPage = new StringBuilder();
		String receivedString = getText(totalFeedbackCountForStageOnPendingReviewFeedPageLabel);
		for (int i = 0; i < receivedString.length(); i++) {
			if (Character.isDigit(receivedString.charAt(i))) {
				countOnPendingReviewPage.append(receivedString.charAt(i));
			}
		}

		return Integer.parseInt(countOnPendingReviewPage.toString());
	}

	/**
	 * @author gupta.mansi 
	 * This method gives feedback on given application id
	 * @param emailId
	 */
	public void giveFeedbackToGivenApplication(String emailId) {
		wait.waitForElementToBeClickable(parameterizedLocator(ddGiveFeedbackForGivenEid, emailId));
		click(parameterizedLocator(ddGiveFeedbackForGivenEid, emailId));
		fillFeedbackForm();
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to click on Give Feedback button for first candidate on page
	 */
	public void clickOnGiveFeedbackButtonForFistCandidate() {
		wait.waitForPageToLoadCompletely();
		getElement(ddGiveFeedbackForFirst).click();
	}

	/**
	 * @author gupta.mansi
	 * This method is used to click on name of given application id
	 * @param emailId
	 */
	public void clickOnGivenApplicationName(String emailId) {
		getElement(lnkCandidateName, emailId).click();
		switchToChildWindow();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author gupta.mansi 
	 * This method clicks on Give Feedback button for given applications id
	 * @param eId
	 */
	public void clickOnGiveFeedbackButtonForGivenEId(String eId) {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(parameterizedLocator(ddGiveFeedbackForGivenEid, eId));
		click(parameterizedLocator(ddGiveFeedbackForGivenEid, eId));
	}

	/**
	 * @author gupta.mansi 
	 * This method clicks on given state name from give feedback dd
	 * @param stateName
	 */
	public void clickOnStateNameFromGiveFeedbackDD(String stateName) {
		jsUtil.scrollToElement(parameterizedLocator(btnState, stateName));
		jsUtil.scrollMid(parameterizedLocator(btnState, stateName));
		wait.waitForElementToBeClickable(parameterizedLocator(btnState, stateName));
		click(parameterizedLocator(btnState, stateName));
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author gupta.mansi
	 * This method clicks on given button from give feedback lightbox
	 * @param buttonName
	 */
	public void clickOnButtonFromGiveFeedbackLB(String buttonName) {
		switch (buttonName) {
		case "Submit Feedback":
		case "Cancel":
		case "Save for Later":
		case "✕":
		case "Discard Draft":
			jsUtil.scrollToElement(parameterizedLocator(btnSubmit, buttonName));
			click(parameterizedLocator(btnSubmit, buttonName));
			wait.waitForPageToLoadCompletely();
			break;
		}
	}

	/**
	 * @author gupta.mansi 
	 * This method is used to fill feedback form
	 */
	public void fillFeedbackForm() {
		int numberOfDropDown = getElements(eleDropDown).size();
		int numberOfStarRating = getElements(eleStarRating).size();
		int numberOfSingleChoice = getElements(eleSingleChoice).size();
		int numberOfMultiChoice = getElements(eleMultiChoice).size();
		int numberOfShortPara = getElements(eleShortPara).size();
		int numberOfOneLine = getElements(eleOneLine).size();
		int numberOfComment = getElements(eleComment).size();

		while (numberOfDropDown > 0) {
			click(parameterizedLocator(eleFeedbackDDOption, String.valueOf(numberOfDropDown)));
			--numberOfDropDown;
		}

		while (numberOfStarRating > 0) {
			click(parameterizedLocator(eleFeedbackStarRating, String.valueOf(numberOfStarRating)));
			--numberOfStarRating;
		}

		while (numberOfSingleChoice > 0) {
			click(parameterizedLocator(eleFeedbackSingleChoiceRadio, String.valueOf(numberOfSingleChoice)));
			--numberOfSingleChoice;
		}

		while (numberOfMultiChoice > 0) {
			click(parameterizedLocator(eleFeedbackMultiChk, String.valueOf(numberOfMultiChoice)));
			--numberOfMultiChoice;
		}

		while (numberOfShortPara > 0) {
			click(parameterizedLocator(eleTxtAreaFeedbackShortPara, String.valueOf(numberOfShortPara)));
			getElement(parameterizedLocator(eleTxtAreaFeedbackShortPara, String.valueOf(numberOfShortPara))).sendKeys("Short paragraph type answer");
			--numberOfShortPara;
		}

		while (numberOfOneLine > 0) {
			click(parameterizedLocator(eleTxtAreaFeedbackOneLine, String.valueOf(numberOfOneLine)));
			getElement(parameterizedLocator(eleTxtAreaFeedbackOneLine, String.valueOf(numberOfOneLine))).sendKeys("One Line type answer");
			--numberOfOneLine;
		}

		while (numberOfComment > 0) {
			click(parameterizedLocator(eleTxtAreaFeedbackComment, String.valueOf(numberOfComment)));
			getElement(parameterizedLocator(eleTxtAreaFeedbackComment, String.valueOf(numberOfComment))).sendKeys("Feedback Comment");
			--numberOfComment;
		}
	}

	/**
	 * @author gupta.mansi
	 * This method returns true if given state name is displayed in give feedback dd
	 * @param stateName
	 * @return true if state name is present
	 */
	public boolean isGivenStateNameDisplayedInGiveFeedbackDD(String stateName) {
		return isDisplayed(parameterizedLocator(btnState, stateName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method returns true if feedback form lightbox is displayed
	 * @return true if feedback form lightbox is displayed
	 */
	public boolean isFeedbackFormLightboxDisplayed()
	{
		return isDisplayed(eleFeedbackFormLightBox);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to click on buttons on discard confirmation box
	 * @param button name
	 */
	public void clickOnButtonOnConfirmationBox(String btnName)
	{
		wait.waitForElementToBeClickable(parameterizedLocator(btnDiscardConfBox, btnName));
		click(parameterizedLocator(btnDiscardConfBox, btnName));
	}
}
