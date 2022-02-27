package com.naukri.pageobjects.Requisition;


import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import scala.App;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequisitionListingPO extends BaseAutomation {

    //Locators
    public By eleRequisitionRaisedDate = By.xpath("(//div[@class=\"raisedOnDiv fl\"])[1]");
    public By eleSelectedTabCount = By.xpath("//li[@class='tabBlockLI selected']//div[@class=\"countDiv\"]");
    public By eleReminderSent = By.xpath("(//span[@class=\"fw600 remSent\"])[1]");
    public By btnSendReminderFromApprovalHistory = By.xpath("(//span[@class=\"sendRem \"])[1]");
    public By eleApproverName = By.xpath("(//div[@class=\"approverName\"])[1]");
    public By eleOpenApprovalHistory = By.xpath("(//i[@class=\"icon downIcon\"])[1]");
    public By eleRequisitionStatus = By.xpath("(//div[@class=\"statusDiv \"])[1]");
    public By eleRequisitionRaisedBy = By.xpath("(//div[@class=\"raisedNameDiv\"])[1]");
    public By txtBoxSearchRequisition = By.xpath("//input[@placeholder='Quick Search Requistion']");
    public By lnkClear = By.xpath("//a[text()='Clear']");
    public By noRequisitionFound = By.xpath("//div[text()='No Requisitions to show']");
    public By statusMessageRibbonOnRequisitionListing = By.id("statusRibbon");
    public By requisitionListingTabText = By.xpath("//div[contains(text(),'${tabText}')]");
    public By requisitionListingTabSelected = By.xpath("//div[contains(text(),'${tabText}')]/ancestor::li[contains(@class,'selected')]");
    public By requisitionStatus = By.xpath("//div[contains(text(),'${requisitionName}')]/ancestor::div[contains(@class, \"listItem\")]//div[contains(@class,\"statusDiv\")]");
    public By generationDateForRequisition = By.xpath("//div[contains(text(),'${requisitionName}')]/ancestor::div[contains(@class, \"listItem\")]//div[contains(@class,\"raisedOnDiv\")]");
    public By requisitionApprovalStatus = By.xpath("//div[contains(text(),'${requisitionName}')]/ancestor::div[contains(@class, \"listItem\")]//div[contains(@class,\"statusDiv \")]/i[contains(text(),\"Down_button\")]");
    public By approvalRequisitionList = By.xpath("//li[@class=\"block-li\"]");
    public By approvalName = By.xpath("(//li[@class=\"block-li\"]//div[contains(@class,\"approverName\")])['${count}']");
    public By sinceDataForApproval = By.xpath("(//li[@class=\"block-li\"]//span[contains(@class,\"greyTextDiv\")])['${count}'])");
    public By btnRaiseRequisition = By.xpath("//input[@value='Raise a Requisition ']");
    public By getFirstRequisitionName = By.xpath("(//div[contains(@class,'processName')])[1]");
    public By suggestionLinkRequisition = By.xpath("//a[text()='View All Results with the requisition name \"req...\"']");
    public By tupleHighlightedRequisitionListing = By.xpath("//div[@class=\"processName strong\"]/span");
    public By searchSuggestionList = By.xpath("//*[contains(@class,'searchSuggestionOuterWrapper')]");
    public By btnSearch = By.xpath("//input[@id='searchIcon']");
    public By firstTabBlock = By.xpath("(//div[@class='tabBlock'])[1]");
    public By btnCommentOuterTuple = By.xpath("(//li[@class='comment'])[1]");
    public By iconApproved = By.xpath("//span[text()='approved']");
    public By txtBoxComment = By.xpath("//textarea[@class='commentInputBox']");
    public By btnCommentInnerTuple = By.xpath("(//input[@class='commentBtn'])[1]");
    public By eleComment = By.xpath("//div[@class='commentBody']");
    public By btnDeleteComment = By.xpath("//span[@class=\"pl10 icon deleteIcon\"]");
    public By btnDeleteCommentLightbox = By.xpath("//button[@class=\"confBtn yes\"]");
    public By btnSendReminder = By.xpath("(//a[@class='Send Reminder'])[1]");
    public By selectFirstRequisitionPrefill = By.xpath("(//div[@id=\"ul_requestList\"]//li)[1]");
    GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
    ApprovalTemplateListingPO templateListingPO = (ApprovalTemplateListingPO ) PageObjectWrapper.getObject(ApprovalTemplateListingPO.class);
    /**
     * This method is used to create map for RequisitionFormData
     *
     * @return map filled with requisition form data
     * @author Nikhil.Bhatia
     */
    public Map<Object, Object> fillRequisitionFormData(String requisitionTitle, String prefillWithRequisition, String group, String recruiterSelector, String approvalProcess, String Keyskills, String jobTitle, String minExp, String maxExp) {
        Map<Object, Object> requisitionFormData = new HashMap<Object, Object>();
        requisitionFormData.put("requisitionTitle", requisitionTitle);
        requisitionFormData.put("prefillWithRequisition", prefillWithRequisition);
        requisitionFormData.put("group", group);
        requisitionFormData.put("Keyskills", Keyskills);
        requisitionFormData.put("recruiterSelector", recruiterSelector);
        requisitionFormData.put("approvalProcess", approvalProcess);
        requisitionFormData.put("jobTitle", jobTitle);
        requisitionFormData.put("minExp", minExp);
        requisitionFormData.put("maxExp", maxExp);
        return requisitionFormData;
    }

    /**
     * This method is used to fillSearchTextBox
     *
     * @param searchText name
     * @author Nikhil.Bhatia
     */
    public void fillSearchTextBox(String searchText) {
        click(txtBoxSearchRequisition);
        sendKeys(txtBoxSearchRequisition, searchText);
    }

    /**
     * This method is used to fillCommentTextBox
     *
     * @param comment
     * @author Nikhil.Bhatia
     */
    public void fillCommentTextBox(String comment) {
        click(txtBoxComment);
        sendKeys(txtBoxComment, comment);
    }

    /**
     * This method is used to getNameForHMWhoRaisedRequisition
     *
     * @return Name who raised requisition
     * @author Nikhil.Bhatia
     */
    public String getNameForHMWhoRaisedRequisition() {
        return getText(eleRequisitionRaisedBy);
    }
    /**
     * This method is used to getStatusForRequisitionListedInFirstTuple
     *
     * @return status of requisition
     * @author Nikhil.Bhatia
     */
    public String getStatusForRequisitionListedInFirstTuple() {
        return getText(eleRequisitionStatus);
    }
    /**
     * This method is used to getSelectedTabCount
     *
     * @return status of requisition
     * @author Nikhil.Bhatia
     */
    public String getSelectedTabCount() {
        return getText(eleSelectedTabCount);
    }
    /**
     * This method is used to getRequisitionRaisedDate
     *
     * @return status of requisition
     * @author Nikhil.Bhatia
     */
    public String getRequisitionRaisedDate() {

        return getText(eleRequisitionRaisedDate);
    }


    /**
     * This method is used to getApproverNameForRequisitionListedInFirstTuple
     *
     * @return approver Name
     * @author Nikhil.Bhatia
     */
    public String getPendingApproversNameForRequisitionListedInFirstTuple() {
        jsUtil.scrollDown(eleRequisitionStatus);
        click(eleRequisitionStatus);
        click(eleOpenApprovalHistory);
        return getText(eleApproverName);
    }


    /**
     * This method is used to clickOnSendReminder
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnSendReminder() {
        click(btnSendReminder);
    }

    /**
     * This method is used to clickOnSendReminder from Approval History Tab
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnSendReminderFromApprovalHistoryView() {
        click(btnSendReminderFromApprovalHistory);
    }

    /**
     * This method is used to check visibility of reminderSent from Approval History
     *
     * @author Nikhil.Bhatia
     */
    public boolean reminderSentFromApprovalHistoryIsDisplayed() {
        clickOnSendReminderFromApprovalHistoryView();
        return isDisplayed(eleReminderSent);
    }




    /**
     * This method is used to check visibility of reminderSent
     *
     * @author Nikhil.Bhatia
     */
    public boolean reminderSentIsDisplayed() {
        return isDisplayed(iconApproved);
    }

    /**
     * This method is used to clickOnSendReminder
     *
     * @author Nikhil.Bhatia
     */
    public void addComment(String comment) {
        click(btnCommentOuterTuple);
        fillCommentTextBox(comment);
        click(btnCommentInnerTuple);
    }



    /**
     * This method is used to deleteFirstComment
     *
     * @author Nikhil.Bhatia
     */
    public void deleteFirstComment() {
        click(btnDeleteComment);
        click(btnDeleteCommentLightbox);
    }

    /**
     * This method is used to deleteFirstComment
     *
     * @author Nikhil.Bhatia
     */
    public String getCurrentDate() {
        return genericFunction.getCurrentDate("d MMM yyyy");
    }

    /**
     * This method is used to deleteCommentButtonIsVisible
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean deleteCommentButtonIsVisible() {
        wait.waitForPageToLoadCompletely();
        return isDisplayed(btnDeleteComment);
    }

    /**
     * This method is used to getComment
     *
     * @return first comment on list of comments
     * @author Nikhil.Bhatia
     */
    public String getComment() {
        return getText(eleComment);
    }

    /**
     * This method is used to clickOnAllResultsSuggestionLink
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnAllResultsSuggestionLink() {
        click(suggestionLinkRequisition);
    }

    /**
     * This method is used to getSuggestionLinkForRequisitionIsDisplayed
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean getSuggestionLinkForRequisitionIsDisplayed() {
        return isDisplayed(suggestionLinkRequisition);
    }

    /**
     * This method is used to getAllHighlightedRequisitions
     *
     * @return list of elements(tuples on requisition)
     * @author Nikhil.Bhatia
     */
    public List<WebElement> getAllHighlightedRequisitions() {
        return getElements(tupleHighlightedRequisitionListing);
    }

    /**
     * This method is used to verify RequisitionResults highlighted Is Displayed
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean highlightedRequisitionResultsIsDisplayed(String highlightedText) {
        List<WebElement> we = getAllHighlightedRequisitions();
        for (WebElement webElement : we) {
            if (!webElement.getText().toLowerCase().contains(highlightedText)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is used to searchRequisition
     *
     * @param text
     * @author Nikhil.Bhatia
     */
    public void searchRequisition(String text) {
        fillSearchTextBox(text);
        wait.waitForVisibilityOfElement(searchSuggestionList);
        click(btnSearch);
    }

    /**
     * This method is used to openSpecificURL
     *
     * @author Nikhil.Bhatia
     */
    public void openSpecificURL(String URL) {
        genericFunction.launchSpecificURL(YamlReader.getAppConfigValue(URL));
        wait.waitForPageToLoadCompletely();
    }

    /**
     * This method is used to check successmessage is displayed
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean getSuccessMessage() {
        wait.waitForPageToLoadCompletely();
        return isDisplayed(statusMessageRibbonOnRequisitionListing);
    }

    /**
     * This method is used to check noRequisitionToShowIsDisplayed
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean noRequisitionToShowIsDisplayed() {
        return isDisplayed(noRequisitionFound);
    }

    /**
     * This method is used to check tabBlockIsDisplayed
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean tabBlockIsDisplayed() {
        return isDisplayed(firstTabBlock);
    }

    /**
     * This method is used to check clickOnRaiseRequest
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnRaiseRequest() {
        click(btnRaiseRequisition);
    }

    /**
     * This method is used to check clickOnClearLink
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnClearLink() {
        click(lnkClear);
    }

    /**
     * This method is used to check choseTabsOnRequisitionListingPage
     *
     * @param tabText
     * @author Nikhil.Bhatia
     */
    public void choseTabsOnRequisitionListingPage(String tabText) {
        getElement(requisitionListingTabText, tabText).click();
        wait.waitForVisibilityOfElement(parameterizedLocator(requisitionListingTabSelected, tabText));
    }

    /**
     * This method is used to check getFirstRequisitionName
     *
     * @param tabText
     * @author Nikhil.Bhatia
     */
    public String getFirstRequisitionName(String tabText) {
        wait.waitForPageToLoadCompletely();
        choseTabsOnRequisitionListingPage(tabText);
        wait.waitForVisibilityOfElement(getFirstRequisitionName);
        System.out.println(getText(getFirstRequisitionName));
        return getText(getFirstRequisitionName);
    }

    /**
     * This method is used to check getStatusForRequisition
     *
     * @param tabText,requsitionName
     * @author Nikhil.Bhatia
     */
    public boolean getStatusForRequisition(String tabText, String requsitionName , String statusPending ,String statusCompletion) {
        getElement(requisitionListingTabText, tabText).click();
        if (getElement(requisitionStatus, requsitionName).getText().equalsIgnoreCase(statusPending) ||  getElement(requisitionStatus, requsitionName).getText().equalsIgnoreCase(statusCompletion) ) ;
        return true;
    }

    public String getCreationDateForRequisitionAwaitingApproval(String tabText, String requsitionName) {
        getElement(requisitionListingTabText, tabText).click();
        return getElement(generationDateForRequisition, requsitionName).getText();
    }

    public Map<Integer, Object> getApprovalPendingStatusForRequsition(String tabText, String requisitionName) {
        getElement(requisitionListingTabText, tabText).click();
        getElement(requisitionApprovalStatus, requisitionName);
        Map<Integer, Object> outerApprovalStage = new HashMap<Integer, Object>();
        Map<String, String> internalApproverDetails = new HashMap<String, String>();
        int approvalListCountForRequisition = getElements(approvalRequisitionList).size();
        for (int i = 0; i < approvalListCountForRequisition; i++) {
            internalApproverDetails.put("approvalName", getElement(approvalName, Integer.toString(i)).getText());
            internalApproverDetails.put("sinceDate", getElement(sinceDataForApproval, Integer.toString(i)).getText());
            outerApprovalStage.put(i, internalApproverDetails);
        }
        return outerApprovalStage;
    }

    /**
     * This method is use to verify verify Pagination On RequisitionListingPage
     * @param Tab name for which pagination is checked
     * @return  true if Pagination for Tab is working correctly
     * @author nikhil.bhatia
     */

    public boolean verifyPaginationOnRequisitionListingPage(String str) {
        boolean flag = true;
        if(isDisplayed(requisitionListingTabText,str)) {
            choseTabsOnRequisitionListingPage(str);
            return templateListingPO.paginationResultsIsDisplayed();
        }else
            return flag;

    }

    public class RequisitionCreationFormPagePO {

        public By requisitionTitle = By.id("requestName");
        public By groupName = By.id("selectGroup");
        public By recruiterSelector = By.id("selectRecruiter");
        public By ddApprovalProcess = By.xpath("//input[@placeholder='Select Approval Process']");
        public By ddPrefill = By.id("inp_requestList");
        public By btnRaiseRequisition = By.xpath("//input[@value='Add Requisition']");

        /**
         * This method is used to  clickOnRaiseRequisition
         *
         * @author Nikhil.Bhatia
         */
        public void clickOnRaiseRequisition() {
            click(btnRaiseRequisition);
            wait.waitForPageToLoadCompletely();
        }

        /**
         * This method is used to fillRequisitionFormWithPrefill
         *
         * @author Nikhil.Bhatia
         */
        public void fillRequisitionFormWithPrefill(Map<Object, Object> requisitonFormDetail, boolean approval) {
            sendKeys(requisitionTitle, requisitonFormDetail.get("requisitionTitle").toString());
            sendKeys(ddPrefill, requisitonFormDetail.get("prefillWithRequisition").toString());
            click(selectFirstRequisitionPrefill);
            jsUtil.scrollDown(groupName);
            selectTextFromDropDown(groupName, requisitonFormDetail.get("group").toString());
            selectTextFromDropDown(recruiterSelector, requisitonFormDetail.get("recruiterSelector").toString());
            if (approval) {
                sendKeys(ddApprovalProcess, requisitonFormDetail.get("approvalProcess").toString());
                getElement(ddApprovalProcess).sendKeys(Keys.ENTER);
            }
            jsUtil.scrollDown(btnRaiseRequisition);
        }

        /**
         * This method is used to selectTextFromDropDown
         *
         * @param selectPath , value
         * @author Nikhil.Bhatia
         */
        public void selectTextFromDropDown(By selectPath, String value) {
            try {
                Select sel = new Select(driver.findElement(selectPath));
                sel.selectByVisibleText(value);

            } catch (Exception e) {
                Reporter.log("Value you choose is not present in dropdown", true);
                e.printStackTrace();
            }
        }
    }
}

