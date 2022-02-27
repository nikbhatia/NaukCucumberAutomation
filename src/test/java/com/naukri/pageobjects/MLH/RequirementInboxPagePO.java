package com.naukri.pageobjects.MLH;

import org.openqa.selenium.By;

import com.naukri.pageobjects.VendorPlatform.AssessmentPartnerIntegrationPO;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;

public class RequirementInboxPagePO extends BaseAutomation{
	AssessmentPartnerIntegrationPO objAssessmentPartnerIntegrationPO = (AssessmentPartnerIntegrationPO) PageObjectWrapper.getObject(AssessmentPartnerIntegrationPO.class);
	
	By ddlSelectionStage = By.xpath("//span[@class=' outerArow']");
	By pathMoveApplicationToSelectionStage = By.xpath(" //a[text()='${selectionStage}']//span[text()=' - ${substageName}']");
	private By btnCommentOnReqInboxPage=By.xpath("//a/small[@class[contains(.,'commentIc')]]");
	private By txtCommentArea=By.id("commentsTextArea");
	private By btnAddComment=By.xpath("//a[@onclick[contains(.,'addComments')]]");
	private By lblCommentProvided=By.xpath("//p[contains(.,'${CommentProvided}')]");
	private By eleNoOfstartGiven=By.xpath("//input[@id[contains(.,'starRating')]]");
	private By eleStarrating=By.xpath("//div[@class='ratingOuter']//li[@id[contains(.,'_${noOfStarGiven}')]]");
	private By btnForwardToHiringManager=By.id("calendarInviteEnableForward");
	private By eleCandidteTuple=By.xpath("//div[@class[contains(.,'candDet')]]");
	private By eleCandidateStage=By.xpath("//span[@class=' interTxt ']");
	private By btnAddToBackup=By.xpath("//a[contains(.,'Add To Backup')]");
	private By btnAllProfiles=By.xpath("//a[contains(.,'Add To Backup')]/../ul//a[@id='addToBackupAll']");
	private By btnAddToBackUPonPopUp=By.id("addBackupAllAndFilteredBtn");
	private By lblInterviewStatus=By.xpath("//div[@class='interview']//span[contains(.,'Reject')]");
	
	String commentGiven="";
	int previousRating,PostRating;
	/**
	 * This method is used to move candidate to given stage's give substage
	 * @param selectionStageName
	 * @param selectionSubSatgeName
	 */
	public void moveApplicationToSelectionStageMappedWithHM(String selectionStageName, String selectionSubSatgeName)
	{
		wait.waitForElementToBeClickable(ddlSelectionStage);
		getElement(ddlSelectionStage).click();
		getElement(pathMoveApplicationToSelectionStage).click();
	}
	
	/**
	 * This method is used to enter comment on Req Inbox page against a tuple
	 * @author abhishek.dwivedi
	 * @param comment given
	 */
	public void enterCommentOnReqInboxPage(String commentGiven)
	{
		click(btnCommentOnReqInboxPage);
		sendKeys(txtCommentArea, commentGiven);
		click(btnAddComment);
	}
	/**
	 * This method is click on star rating on ReqInbox page
	 * @author abhishek.dwivedi
	 * @param Int new rating given
	 * @return true/false
	 */
	public void changeStarRating(int newRating)
	{	wait.hardWait(5);
		click(parameterizedLocator(eleStarrating, String.valueOf(newRating)));
		wait.hardWait(2);
	}

	/**
	 * This method is click on Forward to Hiring manager
	 * 
	 * @author abhishek.dwivedi
	 * 
	 */
	public void clickForwardToHiringmanager() {
		click(btnForwardToHiringManager);
	}
	
	/**
	 * This method use to refresh and verify the candidate tuple is visible on the Requirement Inbox page
	 * 
	 * @author abhishek.dwivedi
	 * 
	 */
	public void refreshAndWaitForTheCandidateUple() {
		objAssessmentPartnerIntegrationPO.refreshPageAndCheckElementIsDisplayed(eleCandidteTuple, 10);
	}
	
	/**
	 * This method use to get previous stage 
	 * 
	 * @author abhishek.dwivedi
	 * @return stage name
	 * 
	 */
	public String getCandidateStage() {
		return getText(eleCandidateStage);
	}
	
	/**
	 * This method use to get the starRating
	 * 
	 * @author abhishek.dwivedi
	 * @return no of star given
	 * 
	 * 
	 */
	public int getStarRating() {
		wait.hardWait(3);
		System.out.println("The no of star available -"+getElement(eleNoOfstartGiven).getAttribute("value"));
		return Integer.parseInt(getElement(eleNoOfstartGiven).getAttribute("value"));
	}
	/**
	 * This method is click on Add to back up
	 * 
	 * @author abhishek.dwivedi
	 * 
	 */
	public void clickAddToBackUp() {
		hover(btnAddToBackup);
		wait.hardWait(2);
		click(btnAllProfiles);
		//switchToAlert();
		click(btnAddToBackUPonPopUp);
		wait.hardWait(2);
	}
	/**
     * To return the getTheCurrentPage Url
     * @author abhishek.dwivedi
     * @return page URL
     */
    public String getPageUrl() {
    	return getCurrentURL();
    }
    /**
     * To return the Status of the selection stage on Req Inbox page
     * @author abhishek.dwivedi
     * @return true/false
     */
    public boolean isSelctionStageStatusDisplayed() {
    	return isDisplayed(lblInterviewStatus);
    }
}