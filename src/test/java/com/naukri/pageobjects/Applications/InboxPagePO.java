package com.naukri.pageobjects.Applications;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.PageObjectWrapper;

/**
 * Inbox Page (Profile/Application/Backup/Profile) PageObject
 *
 * @author rachit.mehrotra
 *
 */
public class InboxPagePO extends PageObjectWrapper {

	GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
	SendAMessagePagePO sendMessage = (SendAMessagePagePO) PageObjectWrapper.getObject(SendAMessagePagePO.class);

	public By txtAdvancedSearch = By.xpath("//a[text()=\"Advanced Search\"]");
	public By eleExpandSearch = By.xpath("//span[@class  = \"expandLink\"]/a");
	public By expandSearchDiv = By.xpath("//div[@class  = \"expandSearch\"]");
	public By sendARequirementLightbox = By.xpath("//textarea[@id = \"projectListJson\"]/following-sibling::div/p");
	public By sendARequirementOptionFromEmail = By.xpath("//li/a[text()=\"Send a Requirement\"]");
	public By forwardLink = By.id("rpSendForwardEmail");
	public By forwardLightboxHeading = By.xpath("//div[@id = \"sendEmailBlock\"]//p[text()=\"Forward Mail\"]");
	public By downloadOption = By.xpath("//a[text()=\" Download \"]");
	public By checkBoxForAttachedResumeOnAttachedResumeLightbox = By.id("daDoc");
	public By downloadStartingIndex = By.id("startingIndex");
	public By downloadEndIndex = By.id("endingIndex");
	public By addToRequirementOption = By.id("addToProjectTrig");
	public By loaderElement = By.id("inactiveProgress");
	public By successMessageOnAddToRequirement = By.xpath("//div[@id = \"profileList\"]//div[@id = \"sMsg\"]");
	public By errorMessageOnBackupPage = By.id("errorCheckBoxMsg");
	public By removeFromBackup = By.xpath("//a[text() = \" Remove From Backup \"]");
	public By firstCandidateNameLocator = By
			.xpath("(//div[contains(@class , \"candDet newTuple\")]//strong[contains(@class , 'candName')]/a)[1]");
	public By removeFromBackupSuccessMessage = By.id("SuccessMessageDiv");
	public By facetList = By.xpath("//div[@id = \"pipeline\"]//p/a");
	public By loaderForLoadingThePage = By.xpath("//div[contains(@class, \" processing-overlay\")]");
	public By countForParticularSubstage = By.xpath("(//em[@id = \"totalRecord\"])[1]");
	public By clickFirstCandidateInput = By.xpath("(//input[@name= \"profileIds[]\"])[1]");
	public By allProfileSelectCheckbox = By.xpath("//div[@id = \"stick\"]//input");
	public By interviewLocation = By.xpath("//input[@name=\"VENUE\"]");
	public By interviewCalenderLocator = By.cssSelector("a.calendar.fr");
	public By interviewHour = By.xpath("//input[@name = \"interviewTimeHH\"]");
	public By interviewMinute = By.xpath("//input[@name = \"interviewTimeMM\"]");
	public By interviewSetBtn = By.cssSelector("a.red_btn.fl");
	public By requirementName = By.xpath("//div[@class='interview']/../..//a[contains(@href,'dashboard')]");
	public By eleSuccessMessageForwardStringOne = By.xpath("//div[@id=\"statusChangeMessageDiv\"]//strong");
	public By eleSuccessMessageForwardStringTwo = By
			.xpath("//div[@id=\"statusChangeMessageDiv\"]//strong/following-sibling::span");

	public By cbSelectAllApplication = By.xpath("//input[@name='topchk']");
	public By allTupleStatusCount = By.xpath("//div[@class='hiringStat cle']//span[@class=' interTxt ']");
	public By candidateStatusOnTuple = By
			.xpath("(//div[contains(@class,'interview')]//span[contains(@class,'interTxt')])[${tuple}]");
	public By changeStatusPopup = By.xpath("//h2[text()='Update Status']");
	public By StatusListOnChangeStatus = By.id("inp_statusListDD");
	public By selectStatusOnChangeStatus = By.xpath("//div[@id='dp_statusListDD']//a[text()='${Status}']");
	public By btnBulkStatusUpdate = By.id("bulkStatusUpdateBtn");
	public By subOption = By.xpath("//a[contains(.,'${option}')]/following-sibling::ul//a[text()='${subOption}']");
	public By btnDownload = By.xpath("//button[text()='Download']");
	public By downloadPopup = By.xpath("//div[@class='downloadBody']");
	public By downloadOptions = By.xpath("//label[contains(text(),'${option}')]");
	public By successMessageFromInbox = By.xpath("//div[contains(@class,'psuccess')]");

	public By ddStatus = By.xpath("//div[contains(@class,'interview')]//span[contains(@class,'outerArow')]");
	public By eleStatus = By.xpath("//ul[contains(@class,'statusNav')]//a[text()='${Status}' and span[text()='${subStatus}']]");
	public By eleStatus2 = By.xpath("//ul[contains(@class,'statusNav')]//a[text()='${Status}']");
	public By ddSubStatusInterview = By.xpath("//select[@name='STAGE']");
	public By ddInterviewType = By.xpath("//select[@name='TYPE']");
	public By eleWhenWhereErrorMsg = By.xpath("//div[contains(text(),'${ErrorMsg}')]");
	public By eleStatusMailButton = By.xpath("//a[contains(@id,'calendarInviteEnable') and contains(text(),'${Btn}')]");
	public By eleInterviewSubStatusOnTuple = By.xpath("(//div[contains(@id,'statusDataCaptureDiv')]//span//strong)[1]");
	public By eleInterviewType = By.xpath("(//div[contains(@id,'statusDataCaptureDiv')]//span)[1]");
	public By btnInterviewEdit = By.xpath("(//div[contains(@id,'statusDataCaptureDiv')]//small[@class='editIc'])[1]");
	public By eleToField = By.xpath("//input[@id='inp_contactLst']");
	public By btnSend = By.xpath("//input[@value='Send']");
	By eleFooterBtnOfDownloadTpl = By.xpath("//button[contains(text(),'${footerBtnString}')]");
	By eleCurrentDateForInterview = By.xpath("//td[contains(@class,\"currDate\")]");
	By eleAMPMSelect = By.name("interviewTimeAmPm");
	By eleFirstCandidateNameLocator = By.xpath("//strong[contains(@class,\"candName\")]/a");
	By eleFirstCandidateStatusChange = By.xpath("//a[text()='${candidateName}']/ancestor::div[contains(@class,\"candDet newTuple\")]/following-sibling::div//span[contains(@class,\" interTxt\")]");
	String eleApplicationCustomCalendar = "(//input[contains(@name,'customApplyDt')]/following-sibling::a)";
	public By eleCluster = By.xpath("//div[@class='panelHead ']//span[text()='${value}']");
	public By eleSubCluster = By.xpath("//span[text()='${cluster}']//ancestor::div[contains(@class,'panelHead')]/following-sibling::div//label[contains(.,'${subCluster}')]");

	public By btnGo = By.xpath("//input[@value='Go']");
	public By eleAppliedDateOnTuple = By.xpath("//div[contains(@class,'candDet')]//span[contains(text(),'Applied On')]/small");
	public By eleAppliedDateOnCurrentTuple = By.xpath("(//div[contains(@class,'candDet')]//span[contains(text(),'Applied On')]/small)[${Value}]");
	public By eleCommentCount = By.xpath("(//span[contains(@id,'commentCountDisplay')])[1]");
	public By eleStarCount = By.xpath("((//div[contains(@id,'starRating')]/ul)[1]/li)[${value}]");
	public By eleViewCount = By.xpath("(//small[contains(@class,'eyeIc')]/following-sibling::strong)[1]");
	public By eleCommentIcon = By.xpath("(//small[contains(@class,'commentIc')])[1]");
	public By eleCommentTextArea = By.xpath("//textarea[@id='commentsTextArea']");
	public By eleCommentText = By.xpath("//ul[contains(@class,'commentList')]/li/p");
	public By eleSingleCommentText = By.xpath("(//ul[contains(@class,'commentList')]/li/p)[${value}]");
	public By eleSingleDeleteIcon = By.xpath("(//a[contains(@class,'delIcon')])[${value}]");
	public By eleSinglecommentDate = By.xpath("(//ul[contains(@class,'commentList')]//em[contains(@id,'date')])[${value}]");
	public By eleAllProfilesBackedUp = By.xpath("//a[@id='addToBackupAll']");
	public By btnAllProfilesBackedUp = By.xpath("//button[@id='addBackupAllAndFilteredBtn']");
	public By eleSelectedProfilesBackedUp = By.xpath("//a[@id='addToBackup']");
	public By eleBackedUpIcon = By.xpath("(//small[@title='Backed up'])[1]");
	By eleIconOfPageNumber = By.xpath("(//div[contains(@class,\"paging\")]//a[contains(@class,\"last\")][${positionCount}])[${pageOrientationCount}]");
	By elePageNumber = By.xpath("(//div[contains(@class,\"paging\")]//a[contains(text(),'${pageNumber}')])[${pageOrientationCount}]");
	
	By eleBulkActionGNB = By.id("srpBulkActionsStatus");
	By inputGlobalSearch = By.id("headTopSearchBox");
	By inputLocalSearch = By.id("keywordSearch");
	By eleCommentCountLast = By.xpath("(//span[contains(@id,'commentCountDisplay')])[last()]");
	By txtOuterFacet = By.xpath("//div[@id ='pipeline']//a[text()='${facetName}']");
	By txtStateHMFeedback = By.xpath("//div[@id ='pstage_feedbackStatus']//a[text()='${facetName}']");
	
	// variables
	public static String firstCandidateName = "";
	static List<String> emailOptions = Arrays.asList("Send a Requirement", "Message");
	static List<String> removeFromBackupOption = Arrays.asList("Selected Resumes", "All Profiles",
			"All Duplicate Profiles");
	HashMap<Integer, HashMap<String, String>> facetMap = new HashMap<Integer, HashMap<String, String>>();
	HashMap<String, String> newFacetMap = new HashMap<String, String>();
	HashMap<Integer, Integer> starRatingMap = new HashMap<Integer, Integer>();
	public static boolean finalFlag = false;
	public static boolean starRatingFlag = false;
	public static String interviewCity = "Delhi";
	boolean flag = false;

	/**
	 * To check the presence of advance search on inbox pages
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean presenceOfAdvanceSearch() {
		for (int i = 1; i <= getElements(txtAdvancedSearch).size(); i++) {
			StringBuilder advancedSearchBuilder = new StringBuilder();
			advancedSearchBuilder.append("(");
			advancedSearchBuilder.append("//a[text()=\"Advanced Search\"]");
			advancedSearchBuilder.append(")[");
			advancedSearchBuilder.append(Integer.toString(i));
			advancedSearchBuilder.append("]");
			String advancedSearchString = advancedSearchBuilder.toString();
			if (!isDisplayed(By.xpath(advancedSearchString))) {
				TestNGLogUtility.info(advancedSearchString + "is not displayed");
				return false;
			}
		}
		return true;

	}

	/**
	 * To check the clickability of advance search field
	 *
	 * @author rachit.mehrotra
	 * @author gupta.mansi
	 * @return boolean
	 */
	public boolean checkTheClickableOfAdvancedSearchField() {
		for (int i = 1; i <= getElements(txtAdvancedSearch).size(); i++) {
			StringBuilder advancedSearchBuilder = new StringBuilder();
			advancedSearchBuilder.append("(");
			advancedSearchBuilder.append("//a[text()=\"Advanced Search\"]");
			advancedSearchBuilder.append(")[");
			advancedSearchBuilder.append(Integer.toString(i));
			advancedSearchBuilder.append("]");
			String advancedSearchString = advancedSearchBuilder.toString();
			click(By.xpath(advancedSearchString));
			wait.waitForPageToLoadCompletely();
			if (!getCurrentURL().contains(YamlReader.getAppConfigValue("URLs.advancedSearchURL"))) {
				TestNGLogUtility.info(advancedSearchString + "is not clickable");
				return false;
			} 
		}
		genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.backupInboxPage"));
		return true;
	}

	/**
	 * To check the presence of expand link
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean checkThePresenceOfExpandLink() {
		for (int i = 1; i <= getElements(eleExpandSearch).size(); i++) {
			String expandLinkToBeChecked = "(" + "//span[@class  = \"expandLink\"]/a" + ")[" + Integer.toString(i)
					+ "]";
			if (!isDisplayed(By.xpath(expandLinkToBeChecked))) {
				TestNGLogUtility.info(expandLinkToBeChecked + "The expand link not present");
				return false;
			}
		}
		return true;
	}

	/**
	 * To check the presence of expand link div
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean checkThePresenceOfExpandLinkDiv() {
		for (int i = 1; i <= getElements(expandSearchDiv).size(); i++) {
			String expandLinkDivToBeChecked = "(" + "//div[@class  = \"expandSearch\"]" + ")[" + Integer.toString(i)
					+ "]";
			jsUtil.scrollUp();
			click(By.xpath("(" + "//span[@class  = \"expandLink\"]/a" + ")[" + Integer.toString(i) + "]"));
			if (!isDisplayed(By.xpath(expandLinkDivToBeChecked))) {
				TestNGLogUtility.info(expandLinkDivToBeChecked + "The expand link not clickable");
				return false;
			}
		}
		return true;
	}

	/**
	 * To check presence of email and send a requirement under email DD
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean checkThePresenceOfEmailAndSendARequirementOption() {
		sendMessage.hoverOnEmailButton();
		for (int i = 0; i < emailOptions.size(); i++) {
			String emailOptionListCandidate = "(//a[text() = \" Email \"]/../ul[@class]/li/a)["
					+ Integer.toString(i + 1) + "]";
			if (!getText(By.xpath(emailOptionListCandidate)).equals(emailOptions.get(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * To click send a requirement option
	 *
	 * @author rachit.mehrotra
	 * @return void
	 */
	public void clickSendARequirementFromMenu() {
		click(sendARequirementOptionFromEmail);
	}

	/**
	 * To verify send a requirement lightbox
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean verifyTheSendARequirementLightbox() {
		return isDisplayed(sendARequirementLightbox);
	}

	/**
	 * To check the presence of forward option on inbox
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean presenceOfForwardOption() {
		return isDisplayed(forwardLink);
	}

	/**
	 * To click the forward option
	 *
	 * @author rachit.mehrotra
	 */
	public void clickForwardOption() {
		click(forwardLink);
	}

	/**
	 * To check the presence of forward lightbox
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean checkPresenceOfForwardLightbox() {
		return isDisplayed(forwardLightboxHeading);
	}

	/**
	 * To verify the presence of download option on inboxes
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean presenceOfDownloadOption() {
		return isDisplayed(downloadOption);
	}

	/**
	 * To click Download option on inbox
	 *
	 * @author rachit.mehrotra
	 */
	public void clickDownloadOption() {
		click(downloadOption);
	}

	/**
	 * @param Selected Resumes downloadOption1
	 * @param Index    Range downloadOption2
	 * @author rachit.mehrotra
	 * @return boolean
	 *
	 */
	public boolean checkPresenceOfDownloadOptionOnDownloadDropdown(String downloadOption1, String downloadOption2) {
		List<String> actualDownloadOption = new ArrayList<String>();
		actualDownloadOption.add(downloadOption1);
		actualDownloadOption.add(downloadOption2);
		List<WebElement> optionofDownloadOptionsList = getElements(By.xpath("//a[contains(@id,\"downloadSrp\")]"));
		for (int i = 0; i < optionofDownloadOptionsList.size(); i++) {
			if (!optionofDownloadOptionsList.get(i).getText().contains(actualDownloadOption.get(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Hover on download option on inbox
	 *
	 * @author rachit.mehrotra
	 */
	public void hoverOnDownloadOption() {
		jsUtil.hoverByJS(downloadOption);
	}

	/**
	 * To click on a particular option of download DD
	 *
	 * @author rachit.mehrotra
	 * @param downloadOptionText
	 */
	public void clickOnDownloadOption(String downloadOptionText) {
		System.out.println("//a[contains(@id , \"downloadSrp\") and contains(text(),\"" + downloadOptionText + "\")]");
		jsUtil.clickByJS(
				By.xpath("//a[contains(@id , \"downloadSrp\") and contains(text(),\"" + downloadOptionText + "\")]"));
	}

	/**
	 * To check for presence of attached resume on download lightbox
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean presenceForCheckboxAttachedResumeForDownloadLightbox() {
		return isDisplayed(checkBoxForAttachedResumeOnAttachedResumeLightbox);
	}

	/**
	 * To check for presence of selected resume on download lightbox
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean presenceForCheckboxSelectedResumeForDownloadLightbox() {
		return isDisplayed(checkBoxForAttachedResumeOnAttachedResumeLightbox);
	}

	/**
	 * Check presence of starting resume and ending resume index
	 *
	 * @author rachit.mehrotra
	 * @return boolean
	 */
	public boolean presenceForSelectedResume() {
		return (isDisplayed(downloadStartingIndex) && isDisplayed(downloadEndIndex));
	}

	public void fillStartAndEndIndex(int startIndex, int endIndex) {
		sendKeys(downloadStartingIndex, "" + startIndex);
		TestNGLogUtility.info("Starting Index filled " + startIndex);
		sendKeys(downloadEndIndex, "" + endIndex);
		TestNGLogUtility.info("End Index Filled " + endIndex);
	}

	public void clickOnFooterButtonsOfDownload(String downloadOption) {
		click(parameterizedLocator(eleFooterBtnOfDownloadTpl, downloadOption));
	}
    
    /**
     * To check for the presence of add to requirement
     *
     * @author rachit.mehrotra
     * @return
     */
    public boolean checkThePresenceOfAddToRequirementOption() {
        return isDisplayed(addToRequirementOption);
    }

    /**
     * To click on add to requirement option
     *
     * @author rachit.mehrotra
     */
    public void clickAddToRequirementOption() {
        click(addToRequirementOption);
    }

    /**
     * To check presence and content of success message
     *
     * @author rachit.mehrotra
     * @param successString
     * @return boolean
     */
    public boolean presenceOfSuccessMessage(String successString) {
        wait.waitForInvisibilityOfElement(20, 3, loaderElement);
        if (isDisplayed(successMessageOnAddToRequirement)) {
            return getText(successMessageOnAddToRequirement).contains(successString);
        }
        return false;
    }

    /**
     * To check presence of error message
     *
     * @author rachit.mehrotra
     * @param errorMessage
     * @return boolean
     */
    public boolean presenceOfErrorMessage(String errorMessage) {
        if (isDisplayed(errorMessageOnBackupPage)) {
            return getText(errorMessageOnBackupPage).contains(errorMessage);
        }
        return false;
    }

    /**
     * To check presence of remove from backup
     *
     * @author rachit.mehrotra
     * @return boolean
     */
    public boolean checkPresenceOfRemoveFromBackup() {
        return isDisplayed(removeFromBackup);
    }

    /**
     * To store the first candidate name in static variable
     *
     * @author rachit.mehrotra
     */
    public void readFirstCandidateName() {
        firstCandidateName = getText(firstCandidateNameLocator);
    }

    /**
     * To hover on remove from backup
     *
     * @author rachit.mehrotra
     */
    public void hoverOnRemoveFromBackUp() {
        jsUtil.hoverByJS(removeFromBackup);
    }

    /**
     * To check from remove from backup
     *
     * @author rachit.mehrotra
     * @param listOfActualArguments
     * @return boolean
     */
    public boolean checkForRemoveFromInbox(List<String> listOfActualArguments) {
        click(removeFromBackup);
        List<WebElement> nameOfList = getElements(By.xpath("//a[text() = ' Remove From Backup ']/../ul/li/a"));
        for (int i = 0; i < nameOfList.size(); i++) {
            if (!nameOfList.get(i).getText().contains(listOfActualArguments.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * To click on any option present in remove DD
     *
     * @author rachit.mehrotra
     * @param optionName
     */
    public void clickOnOptionFromRemove(String optionName) {
        hover(removeFromBackup);
        click(By.xpath("//a[text() = \" Remove From Backup \"]/following-sibling::ul//a[text()\"" + optionName + "\"]"));
    }

    /**
     * To verify the success message after removal from backup
     *
     * @author rachit.mehrotra
     * @param successMessage
     * @return boolean
     */
    public boolean checkForSuccessMessageOnRemovalFromBackup(String successMessage) {
        if (isDisplayed(removeFromBackupSuccessMessage)) {
            return getText(removeFromBackupSuccessMessage).contains(successMessage);
        }
        return false;
    }

    /**
     * To check for the absence of first candidate in inbox
     *
     * @author rachit.mehrotra
     * @return boolean
     */
    public boolean checkForAbsenceOfFirstCandidateName() {
        while (getText(firstCandidateNameLocator).contains(firstCandidateName)) {
            driver.navigate().refresh();
        }
        return true;
    }

    /**
     * To click on global/advanced search
     *
     * @author rachit.mehrotra
     * @param scopeOfSearch
     */
    public void clickOnExpandSearch(String scopeOfSearch) {
        switch (scopeOfSearch) {
            case "global search":
                click(By.xpath("(//a[text()='Expand '])[1]"));
                break;
            
            case "local search":
                click(By.xpath("(//a[text()=\"Expand \"])[2]"));
                break;
        }
    }

    /**
     * To check the visibility of search div
     *
     * @author rachit.mehrotra
     * @param scopeOfSearch
     * @return boolean
     */
    public boolean visibilityOfExpandDiv(String scopeOfSearch) {
        boolean flag = false;
        switch (scopeOfSearch) {
            case "global search":
                flag = isDisplayed(By.xpath("(//div[@class=\"expandSearch\"])[1]"));
                break;
            case "local search":
                flag = isDisplayed(By.xpath("(//div[@class=\"expandSearch\"])[2]"));
                break;
        }
        return flag;
    }

    /**
     * To fill the data present in facets to a map
     *
     * @author rachit.mehrotra
     */
    public void fillAllTheFacetData() {
        for (int i = 1; i <= getElements(facetList).size(); i++) {
            String facetNameXpath = "(//div[@id = \"pipeline\"]//p/a)[" + Integer.toString(i) + "]";
            String facetCountXpath = "(//div[@id = \"pipeline\"]//p/a/span)[" + Integer.toString(i) + "]";
            newFacetMap.put(getText(By.xpath(facetNameXpath)), getText(By.xpath(facetCountXpath)));
            facetMap.put(i, newFacetMap);
        }
    }

    /**
     * To click on facet and corresponding substage
     *
     * @author rachit.mehrotra
     * @param subStageText
     */
    @SuppressWarnings("static-access")
    public void clickOnEachFacet(String subStageText) {
        for (int i = 1; i <= getElements(facetList).size(); i++) {
            if (!(i == 2)) {
                click(By.xpath("(//div[@id = \"pipeline\"]//p/a)[" + Integer.toString(i) + "]"));
            }
            String countOnAllFacet = (facetMap.get(i).get(getElements(facetList).get(i - 1).getText()));
            TestNGLogUtility.info("doFacet " + getElements(facetList).get(i - 1).getText());
            By iteratedXpath = By.xpath("(//div[@id = \"pipeline\"]//p/a/../following-sibling::div/label[text()=\" " + subStageText + " \"])[" + Integer.toString(i) + "]");
            TestNGLogUtility.info("Substage " + getText(By.xpath("(//div[@id = \"pipeline\"]//p/a/../following-sibling::div/label[text()=\" " + subStageText + " \"])[" + Integer.toString(i) + "]")));
            jsUtil.scrollDown(iteratedXpath);
            click(iteratedXpath);
            boolean test = compareFacetCountToCategotyCount(countOnAllFacet, i);
            if (!test) {
                TestNGLogUtility.info("Count from facet " + countOnAllFacet);
                TestNGLogUtility.info("Count from inbox " + getText(countForParticularSubstage));
                return;
            }
            driver.navigate().refresh();
        }
        finalFlag = true;
    }

    /**
     * To read facet count from UI and compare it across the data present in map
     *
     * @author rachit.mehrotra
     * @param facetCountValue
     * @param i
     * @return boolean
     */
    public boolean compareFacetCountToCategotyCount(String facetCountValue, int i) {
        TestNGLogUtility.info("Index " + i);
        wait.waitForInvisibilityOfElement(20, 3, loaderForLoadingThePage);
        jsUtil.scrollUp();
        if (Integer.parseInt(facetCountValue) == 0) {
            return isDisplayed(By.xpath("//strong[text()=\"No results found\"]"));
        }
        return Integer.parseInt(facetCountValue) == Integer.parseInt(getText(countForParticularSubstage));
    }

    /**
     * To fill number of counts corresponding to a star rating stage in map
     *
     * @author rachit.mehrotra
     */
    public void fillStarRatingTemplate() {
        jsUtil.scrollDown(By.xpath("//div[@id =\"facetItemsListingDiv_RATING\"]/label"));
        for (int i = getElements(By.xpath("//div[@id =\"facetItemsListingDiv_RATING\"]/label")).size() - 2; i >= 0; i--) {
            starRatingMap.put(i, Integer.parseInt(getText(By.xpath("//div[@id='facetItemsListingDiv_RATING']//input[@value=" + Integer.toString(i) + "]/following-sibling::span"))));
        }
        TestNGLogUtility.info("Star rating map info " + starRatingMap);
    }

    /**
     * To get the star rating for a particular stage and send to comparator
     *
     * @author rachit.mehrotra
     */
    public void starRatingFilterComparison() {
        jsUtil.scrollDown(By.xpath("//div[@id =\"facetItemsListingDiv_RATING\"]/label"));
        for (int i = getElements(By.xpath("//div[@id =\"facetItemsListingDiv_RATING\"]/label")).size() - 2; i >= 0; i--) {
            driver.navigate().refresh();
            wait.waitForPageToLoadCompletely();
            if (i == 1) {
                click(By.xpath("(//div[@id='facetItemsListingDiv_RATING']//input[@value=" + Integer.toString(i) + "])[3]"));
            } else {
                click(By.xpath("//div[@id='facetItemsListingDiv_RATING']//input[@value=" + Integer.toString(i) + "]"));
            }
            if (!compareStarRatingFacetToApplicationCount(i)) {
                return;
            }
        }
        starRatingFlag = true;
    }

    /**
     * To compare the star rating data to the application count
     *
     * @author rachit.mehrotra
     * @param i
     * @return boolean
     */
    public boolean compareStarRatingFacetToApplicationCount(int i) {
        TestNGLogUtility.info("Index of star rating " + i);
        wait.waitForInvisibilityOfElement(20, 3, loaderForLoadingThePage);
        jsUtil.scrollUp();
        if (!(Integer.parseInt(getText(countForParticularSubstage)) == starRatingMap.get(i))) {
            TestNGLogUtility.info("count of profile recieved " + getText(countForParticularSubstage));
            TestNGLogUtility.info("Count recieved from the map " + starRatingMap.get(i));
            return false;
        }
        return true;
    }

    /**
     * To verify the total application count against star rating filter to sum
     * of underlying stages
     *
     * @author rachit.mehrotra
     * @return boolean
     */
    public boolean verifyTheTotalCountOfStarFacet() {
        int sum = 0;        
        for (int i = getElements(By.xpath("//div[@id =\"facetItemsListingDiv_RATING\"]/label")).size() - 2; i >= 0; i--) {
            sum += Integer.parseInt(getText(By.xpath("//div[@id='facetItemsListingDiv_RATING']//input[@value=" + Integer.toString(i) + "]/following-sibling::span")));
        }
        TestNGLogUtility.info("sum calculated" + sum);
        jsUtil.scrollUp();
        return Integer.parseInt(getText(countForParticularSubstage)) == sum;
    }

    /**
     * To click on first candidate
     *
     * @author rachit.mehrotra
     */
    public void clickFirstCandidate() {
        jsUtil.scrollUp();
        click(clickFirstCandidateInput);
        PropFileHandler.writeProperty("firstCandidateNameForTest", getText(eleFirstCandidateNameLocator));
    }

    /**
     * To click on forward link on the requirement inbox
     *
     * @author rachit.mehrotra
     */
    public void clickForwardOnRequirementInbox() {
        jsUtil.scrollUp();
        wait.waitForElementToBeClickable(forwardLink);
        jsUtil.scrollMid(forwardLink);
        click(forwardLink);
    }

    /**
     * To select all the profiles across inboxes
     *
     * @author rachit.mehrotra
     */
    public void selectAllProfiles() {
        click(allProfileSelectCheckbox);
    }

    /**
     * To navigate from CV Listing to CV details page basis candidate name
     *
     * @author rachit.mehrotra
     * @param candidateName
     */
    public void clickOnCandidateNameForCVDetailsPage(String candidateName) {
        click(By.xpath("//a[contains(text(),\"" + candidateName + "\")]"));
    }

    /**
     * To fill the venue for interview
     *
     * @author rachit.mehrotra
     */
    public void fillVenueForInterview() {
        sendKeys(interviewLocation, interviewCity);
    }

    /**
     * To select the next day as of present day for scheduling interview
     *
     * @author rachit.mehrotra
     */
    public void selectDayForInterview() {
        click(interviewCalenderLocator);
        int dateForInterview = genericFunctions.getDateOfMonth()+1;    
        click(By.xpath("//td[text()=\"" + dateForInterview + "\"]"));
    }
    
    /**
     * To chose current date as the interview date
     */
    public void selectCurrentDayForInterview() {
    	click(interviewCalenderLocator);
    	click(eleCurrentDateForInterview);
    }

    /**
     * To set the hour of interview with helper method in generic functions
     * class\
     *
     * @author rachit.mehrotra
     */
    public void selectTimeOfDay() {                
        sendKeys(interviewHour, "09");
    }

    /**
     * To set minute part of interview schedule of the interview
     *
     * @author rachit.mehrotra
     */
    public void setMinuteOfInterview() {
        sendKeys(interviewMinute, "00");
    }
    
    /**
     * Change the time slot of the day
     * @param optionOfDay
     */
    public void changeAMPMForInterviewTime(String optionOfDay) {
    	selectByVisibleText(eleAMPMSelect, optionOfDay);
    }

    /**
     * Inner Class contains the page object for adding application to
     * requirement
     *
     * @author rachit.mehrotra
     *
     */
    public class AddToRequirementLightbox {
        
        public By addToRequirementTitle = By.xpath("//form[@id = \"addToProjectForm\"]//span[@id = \"addReqLabel\"]/p");
        public By addToRequirementDropdown = By.xpath("//div[@id = \"createProjectForm\"]//label[text()=\"Choose from a Requirement\"]/../div");
        public By firstRequirementOption = By.xpath("(//ul[@id = \"ul_projectList\"]/li)[1]");
        public By addToRequirementButtonOnLayout = By.xpath("//input[@id = \"download\"]");
        By eleAddNewRequirementCheckbox = By.id("chkCreateNew");
        By eleRequirementName = By.xpath("//label[contains(text(),'${requirementLabel}')]/following-sibling::input");
        By eleProjectName = By.id("projectName");
        By eleStatusSelectDD = By.id("status");
        By eleCancelButton = By.xpath("//a[contains(text(),'${buttonText}')]");
        By eleSuccessMessage = By.xpath("//*[contains(text(),'${textToVerify}')]");
       
        /**
         * To check presence of add to requirement lightbox
         *
         * @
         * @return boolean
         */
        public boolean checkPresenceAddToRequirementTitle() {
            return isDisplayed(addToRequirementTitle);
        }

        /**
         * To click on Requirement Listing DD
         *
         * @author rachit.mehrotra
         */
        public void clickOnRequirementDDOnRequirementLightbox() {
            click(addToRequirementDropdown);
        }

        /**
         * To select the first requirement from add to requirement DD
         *
         * @author rachit.mehrotra
         */
        public void selectFirstRequirementOption() {
            click(firstRequirementOption);
        }

        /**
         * To click on Add button on add to requirement popup
         *
         * @author rachit.mehrotra
         */
        public void clickAddToRequirement() {
            click(addToRequirementButtonOnLayout);
        }
        
        public void checkAddNewRequirementCheckbox() {
        	click(eleAddNewRequirementCheckbox);
        }
        
        public boolean verifyThePresenceOfInputForLabel(String labelText) {
        	return isDisplayed(parameterizedLocator(eleRequirementName, labelText));
        }
        
        public void fillInRequirementNameForMasterProfile() {
        	String projectName = "Master Profile Project " + GenericFunctions.generateRandomStrings(6, "Number");
        	sendKeys(eleProjectName, projectName);
        	PropFileHandler.writeProperty("projectName", projectName);
        }
        
        public void selectStatusOfApplication(String statusText) {
        	selectByVisibleText(eleStatusSelectDD, statusText);
        }
        
        public void clickOnActionButton(String btnText) {
        	if(btnText.equalsIgnoreCase("add"))
        		clickAddToRequirement();
        	else
        		click(parameterizedLocator(eleCancelButton, btnText));
        	wait.waitForProcessingToDisappear(10, 3);
        }
        
        public boolean verifyTheSuccessMessage(String successMessageText) {
        	return isDisplayed(parameterizedLocator(eleSuccessMessage, successMessageText.split("!")[0]+"!")) && 
        			isDisplayed(parameterizedLocator(eleSuccessMessage, successMessageText.split("!")[1].replaceAll("Profiles are added", "").replaceAll("Profile Added", "").trim()));
        }
        
        public boolean verifyThePresenceOfRequirementName() {
        	return isDisplayed(parameterizedLocator(eleSuccessMessage, PropFileHandler.readProperty("projectName")));
        }
    }
    
    public void clickOnSetInterViewButton() {
        getElement(interviewSetBtn).click();
        TestNGLogUtility.info("User clicked on set interview button");
    }
    
    /*
    This method verify the requirement name just above the selection stage DD
    */
    public boolean verifyRequiregetElementmentNameIsVisible(){
        return (!getElement(requirementName).getAttribute("title").isEmpty())&&(!getElement(requirementName).getText().isEmpty())&&getElement(requirementName).isDisplayed();
    }
    
    /**
     * To verify the success message
     * @param successMessageText
     * @return boolean based on comparison
     */
    public boolean verifyTheSuccessMessageText(String successMessageText) {
    	wait.waitForInvisibilityOfElement(10, 3, loaderForLoadingThePage);
    	jsUtil.scrollUp();
    	return ((getText(eleSuccessMessageForwardStringOne).replace("!", "").contains(successMessageText.split("!")[0])) 
    			&& getText(eleSuccessMessageForwardStringTwo).contains(successMessageText.split("!")[1].trim()));
    }

	/**
	 * This method will verify each status of candidate has changes through bulk
	 * action
	 * 
	 * @param statusValue
	 * @return
	 */
	public boolean verifyStatusOfEachCandidate(String statusValue) {
		wait.waitForProcessingToDisappear(10, 3);
		int size = getElements(allTupleStatusCount).size();
		for (int i = 1; i <= size; i++) {
			if (getText(parameterizedLocator(candidateStatusOnTuple, String.valueOf(i))).contains(statusValue))
				flag = true;
			else
				return false;

		}
		return flag;
	}

	/**
	 * This method will verify Change status pop up is displaying or not
	 * 
	 * @return
	 */
	public boolean verifyChangeStatusPopup() {
		wait.waitForValignWrapperToDisappear(10, 3);
		return isDisplayed(changeStatusPopup);
	}

	/**
	 * This method will select the status on change status popup
	 * 
	 * @param status
	 */
	public void selectStatusOnChangeStatusPopup(String status) {
		click(StatusListOnChangeStatus);
		click(parameterizedLocator(selectStatusOnChangeStatus, status));
	}

	/**
	 * This method will Click on update button on change status popup
	 */
	public void clickOnUpdateOnChangeStatusPopup() {
		click(btnBulkStatusUpdate);
		wait.waitForVisibilityOfElement(successMessageFromInbox);
		wait.waitForProcessingToDisappear(10, 3);
	}

	/**
	 * This method will Click on Download button on Download popup
	 */
	public void clickOnDownloadButtonOnDownloadPopup() {
		click(btnDownload);
		wait.waitForInvisibilityOfElement(10, 3, downloadPopup);
	}

	/**
	 * This method will select all Application in inbox
	 */
	public void selectAllApplicationCheckBox() {
		click(cbSelectAllApplication);
	}

	/**
	 * This method is click on sub option of bulk action
	 * 
	 * @param option
	 * @param suboption
	 */
	public void clickOnSuboption(String option, String suboption) {
		click(parameterizedLocator(subOption, option, suboption));
	}

	/**
	 * Verify Download profile popup is displaying
	 * 
	 * @return
	 */
	public boolean verifyDownloadprofilePopup() {
		return isDisplayed(downloadPopup);
	}

	/**
	 * This method enter download starting index and ending index.
	 */
	public void enterDownloadingindexRange(String startingIndex, String endingIndex) {
		sendKeys(downloadStartingIndex, startingIndex);
		sendKeys(downloadEndIndex, endingIndex);
	}

	public boolean verifyOptionOnDownloadPopup(String option) {
		return isDisplayed(parameterizedLocator(downloadOptions, option));
	}

	public boolean verifyDownloadedSectedOrByIndexApplication(String dirPath, String fileExtension) {
		String filename = "Test_Requirement-Nam_";
		File file = ReadWritePropertyFile.getLatestFilefromDir(dirPath);
		String lastDownloadedFileName = file.getName();
		if (lastDownloadedFileName.contains(filename)) {
			if (lastDownloadedFileName.contains(fileExtension))
				return flag = true;
		}
		return flag;
	}

	/**
	 * This method will click on provided status in list
	 * 
	 * @author himanshu.dua
	 * @param status
	 */
	public void selectStatus(String status) {
		if (status.contains("-")) {
			String[] statusValue = status.split("-");
			click(parameterizedLocator(eleStatus, statusValue[0].trim(), " - " + statusValue[1].trim()));
		} else
			click(parameterizedLocator(eleStatus2, status));
	}

	/**
	 * 
	 * @param statusValue
	 * @param CandidateCount
	 * @return
	 */
	public boolean verifyStatusOfNumberOfCandidates(String status) {
		wait.waitForProcessingToDisappear(10, 3);
		if (getText(parameterizedLocator(candidateStatusOnTuple, String.valueOf("1"))).contains(status))
			flag = true;
		return flag;
	}

	/**
	 * To check the presence of forward option on inbox
	 *
	 * @author himanshu.dua
	 * @return boolean
	 */
	public boolean presenceOfErrorMessageForInterviewVenueAndTime(String message) {
		return isDisplayed(parameterizedLocator(eleWhenWhereErrorMsg, message));
	}

	/**
	 * This method will select the Interview sub status
	 * 
	 * @author himanshu.dua
	 * @param subStatus
	 */
	public void selectSubStatusOfInterview(String subStatus) {
		selectByVisibleText(ddSubStatusInterview, subStatus);
	}

	/**
	 * This method will select the Interview type
	 * 
	 * @author himanshu.dua
	 * @param subStatus
	 */
	public void selectInterviewType(String type) {
		selectByVisibleText(ddInterviewType, type);
	}

	/**
	 * This method will click on button on status change success message.
	 * 
	 * @author himanshu.dua
	 * @param btnName
	 */
	public void clickOnStatusMailBtnOnSuccessMessage(String btnName) {
		click(parameterizedLocator(eleStatusMailButton, btnName));
	}

	/**
	 * This method will verify success message is displaying or not
	 * 
	 * @return
	 */
	public boolean verifyMailSentSuccessMessage() {
		return isDisplayed(successMessageFromInbox);
	}

	/**
	 * This method will used for entering the hm email in To fields
	 * 
	 * @param hmEmail
	 */
	public void enterHmEmailId(String hmEmail) {
		click(eleToField);
		getElement(eleToField).sendKeys(hmEmail+Keys.ENTER);
	}

	/**
	 * This method will click on send button
	 * 
	 * @param hmEmail
	 */
	public void clickOnSendButtton() {
		wait.waitForProcessingToDisappear(10, 3);
		click(btnSend);
	}

	/**
	 * This method will click on status drop down
	 * 
	 * @author himanshu.dua
	 */
	public void clickOnStatusDD() {
		click(ddStatus);
	}

	/**
	 * This method will verify interview sub status
	 * 
	 * @return
	 */
	public boolean verifyInterviewSubStatus(String status) {
		return getText(eleInterviewSubStatusOnTuple).trim().equals(status);
	}

	/**
	 * This method will verify interview type
	 * 
	 * @return
	 */
	public boolean verifyInterviewType(String Type) {
		wait.waitForProcessingToDisappear(10, 3);
		return getText(eleInterviewType).trim().contains(Type);
	}

	/**
	 * This method will click on interview edit button
	 * 
	 * @author himanshu.dua
	 */
	public void clickOnEditBtnOnInterviewInfoTuple() {
		click(btnInterviewEdit);
	}

	/**
	 * To Click on the first candidate name
	 *
	 * @author himanshu.dua
	 */
	public void clickFirstCandidateName() {
		click(firstCandidateNameLocator);
		genericFunctions.switchToChildWindow();

	}

	/**
	 * To Click on the provided cluster
	 *
	 * @author himanshu.dua
	 */
	public void clickOnCluster(String clusterName, String subClusterName) {
		wait.waitForPageToLoadCompletely();
		click(parameterizedLocator(eleCluster, clusterName));
		wait.waitForOverlayProcessingToDisappear(10, 3);
		click(parameterizedLocator(eleSubCluster, clusterName, subClusterName));
	}

	/**
	 * To select the next day as of present day for scheduling interview
	 *
	 * @author himanshu.dua
	 * 
	 */
	public int selectAppliationCustomDates() {
		int dateForInterview = 0;
		int size = getElements(By.xpath(eleApplicationCustomCalendar)).size();
		scrollToElement(interviewCalenderLocator);
		for (int i = 1; i <= size; i++) {
			getElement(By.xpath(eleApplicationCustomCalendar + "[" + i + "]")).click();
			dateForInterview = genericFunctions.getDateOfMonth();
			int dateSize = getElements(By.xpath("//td[text()=\"" + dateForInterview + "\"]")).size();
			click(By.xpath("(//td[text()=\"" + dateForInterview + "\"])[" + dateSize + "]"));
		}
		click(btnGo);
		return dateForInterview;
	}

	/**
	 * This method will verify Applied Date on application tuple
	 * 
	 * @param date
	 * @return
	 */
	public boolean verifyAppliedDateOnApplicationTuple(int date) {
		flag = true;
		wait.waitForProcessingToDisappear(10, 3);
		int size = getElements(eleAppliedDateOnTuple).size();
		for (int i = 1; i <= size; i++) {
			if (!getText(parameterizedLocator(eleAppliedDateOnCurrentTuple, String.valueOf(i)))
					.contains(String.valueOf(date))) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * This method verify comment count of application on inbox
	 * 
	 * @param count
	 * @return
	 */
	public boolean verifyCommentCountOnTuple(String count) {
		return getText(eleCommentCount).trim().equals(count);
	}

	/**
	 * This method verify View count of application on inbox
	 * 
	 * @param count
	 * @return
	 */
	public boolean verifyViewCountOnTuple(String count) {
		return getText(eleViewCount).trim().equals(count);
	}

	/**
	 * This method verify Star count of application on inbox
	 * 
	 * @param count
	 * @return
	 */
	public boolean verifyStarCountOnTuple(String count) {
		int starCount = 0;
		for (int i = 1; i <= 5; i++) {
			String text = getAttribute(parameterizedLocator(eleStarCount, String.valueOf(i)), "class");
			if (!text.equals("selected"))
				break;
			starCount += 1;
		}
		return starCount == Integer.valueOf(count);
	}

	/**
	 * This method is used for click on comment Icon
	 */
	public void clickOnCommentIconOnInbox() {
		wait.waitForProcessingToDisappear(10, 3);
		jsUtil.scrollMid(eleCommentCount);
		click(eleCommentCount);
	}

	/**
	 * This method is used for comment filling on Inbox
	 * 
	 * @param comment
	 */
	public String enterCommentOnInbox() {
		String comment = "comment_" + genericFunctions.generateRandomStrings(6, "Alphanumeric");
		sendKeys(eleCommentTextArea, comment);
		return comment;
	}

	/**
	 * This method is used for verify comment value
	 * 
	 * @param expectedComment
	 */
	public boolean verifyAddedComment(String expectedComment) {
		int size = getElements(eleCommentText).size();
		for (int i = 1; i <= size; i++) {
			if (getText(parameterizedLocator(eleSingleCommentText, String.valueOf(i))).trim().equals(expectedComment)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
    
    /**
     * To verify the status of the candidate
     * @param status
     * @return boolean
     */
    public boolean verifyTheStatusOfFirstCandidate(String status) {
    	return getText(parameterizedLocator(eleFirstCandidateStatusChange, PropFileHandler.readProperty("firstCandidateNameForTest"))).equals(status);
    }

    /**
    * This method is used verify comment delete icon and comment date
	 * 
	 * @return
	 */
	public boolean verifyCommentDeleteIconAndCommentDate() {
		int size = getElements(eleCommentText).size();
		for (int i = 1; i <= size; i++) {
			if (isDisplayed(parameterizedLocator(eleSingleDeleteIcon, String.valueOf(i)))) {
				if (isDisplayed(parameterizedLocator(eleSinglecommentDate, String.valueOf(i)))) {
					int date = genericFunctions.getDateOfMonth();
					if (getText(parameterizedLocator(eleSingleDeleteIcon, String.valueOf(i))).trim()
							.contains(String.valueOf(date)))
						flag = true;
				}
			}
		}
		return flag;
	}

	/**
	 * This method will click Backed-up profile option
	 * @author himanshu.dua
	 * @param option
	 */
	public void clickOnBackedUpOptionAfterHover(String option) {
		if(option.equalsIgnoreCase("Selected Resumes"))
			click(eleSelectedProfilesBackedUp);
		else {
			click(eleAllProfilesBackedUp);
			click(btnAllProfilesBackedUp);
		}
		wait.waitForOverlayProcessingToDisappear(10, 3);
	}
	
	/**
	 * This method will verify Backed-up icon on tuple	
	 * @author himanshu.dua
	 * @param option
	 */
	public boolean verifyBackedUpIcon() {
		return isDisplayed(eleBackedUpIcon);
	}
	
	public boolean verifyThePresenceOfIcon(String iconPosition, String index) {
		By by = iconPosition.equals("first") ? parameterizedLocator(eleIconOfPageNumber , index , "1"): parameterizedLocator(eleIconOfPageNumber , index , "2");
		return isDisplayed(by);
	}
	
	public void clickOnPageNumber(String pageNumber, String index) {
		click(parameterizedLocator(elePageNumber, pageNumber , index));
		wait.waitForOverlayProcessingToDisappear(10, 5);
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if bulk action gnb is displayed on page
	 * @return true if bulk action gnb is displayed on page else false
	 */
	public boolean verifyBulkStatusGNB()
	{
		wait.waitForPageToLoadCompletely();
		return isDisplayed(eleBulkActionGNB);
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if bulk select checkbox is present on page
	 * @return true if bulk select checkbox is present on page else false
	 */
	public boolean verifyPresenceOfBulkSelectCheckBox()
	{
		wait.waitForPageToLoadCompletely();
		return isDisplayed(cbSelectAllApplication);
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used to verify presence of global/local search
	 * @param searchType: global search/local search
	 * @return true if search bar is displayed else false
	 */
	public boolean visibilityOfGlobalLocalSearch(String searchType)
	{
		boolean flag = true;
		switch(searchType)
		{
		case "global search":
			wait.waitForPageToLoadCompletely();
			flag = isDisplayed(inputGlobalSearch);
		case "local search":
			wait.waitForPageToLoadCompletely();
			flag = isDisplayed(inputLocalSearch);
		}
		return flag;
	}
	
	/**
	 * @author gupta.mansi
	 * This method is used for click on comment Icon for last application on page
	 */
	public void clickOnCommentIconOnInboxForLastApplication() {
		wait.waitForProcessingToDisappear(10, 3);
		jsUtil.scrollMid(eleCommentCountLast);
		click(eleCommentCountLast);
		wait.waitForVisibilityOfElement(eleCommentTextArea);
	}

	/**
	 * @author gupta.mansi
	 * This method return true if given facet is displayed under selection stages cluster
	 * @param facetName
	 * @return true if given facet is displayed under selection stages
	 */
	public boolean checkPresenceOfGivenFacetName(String facetName)
	{
		return isDisplayed(parameterizedLocator(txtOuterFacet, facetName));
	}
	
	/**
	 * @author gupta.mansi
	 * This method return true if given state is displayed under HM Feedback cluster
	 * @param stateName
	 * @return true if given state is displayed under HM Feedback cluster
	 */	
	public boolean presneceOfStateUnderHMFeedbackCluster(String stateName)
	{
		return isDisplayed(parameterizedLocator(txtStateHMFeedback, stateName));
	}
}
