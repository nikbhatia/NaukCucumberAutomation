package com.naukri.pageobjects.Requisition;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.YamlReader;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.PageObjectWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Class contains page objects of Template Listing Page
 *
 * @author Nikhil.Bhatia
 */

public class ApprovalTemplateListingPO extends BaseAutomation {

    //xpaths
    public By txtBoxSearch = By.xpath("//input[@placeholder='Search by Processes and Groups']");
    public By btnSearch = By.xpath("//input[@id='searchIcon']");
    public By eleHighlightedText = By.xpath("(//span[@class='highlightedText'])[1]");
    public By lnkClear = By.xpath("//a[text()=\"Clear\"]");
    public By btnAddNewTemplate = By.xpath("//input[@value='Add New']");
    public By templateNotFound = By.xpath("//div[text()='No Matching Results']");
    public By suggestionForGroup = By.xpath("//div[@class='searchSuggestionTuple']//b[text()='${groupName}']");
    public By suggestionLinkTemplate = By.xpath("//a[contains(text(),'View All Results with the process name \"App...\"')]");
    public By tupleHighlightedTemplateListing = By.xpath("//div[@class=\"processName strong\"]/span");
    public By firstTupleTemplateListing = By.xpath("(//div[@class=\"processName strong\"])[1]");
    public By tupleTemplateList = By.xpath("(//div[@class=\"processName strong\"])");
    public By btnDelete = By.xpath("(//span[contains(text(),'Delete')])[1]");
    public By ddAssignGroup = By.xpath("//div[@class='approval-group-container']/div");
    public By tabHeadTitle = By.xpath("//div[text()='Add Approval Process']");
    public By groupList = By.xpath("//div[@class='approval-group-container']//li");
    public By deleteTemplateLightbox = By.xpath("//button[contains(text(),'DELETE')]");
    public By noResultAfterSearch = By.xpath("//div[@class=\"headerBar noResultsText\"]");
    public By lightboxFillTemplateName = By.xpath("//input[@placeholder='Provide a name to your approval workflow']");
    public By templateDeletionSuccessStrip = By.xpath("//span[contains(text(),'The selected Approval Process has been deleted.')]");
    public By approvalStageSection = By.xpath("//div[contains(@class,'stage-item')]");
    public By btnAddStage = By.xpath("//span[text()='ADD APPROVAL STAGE']");
    public By approvers_txt = By.xpath("//input[@placeholder='Enter email Ids of approvers']");
    public By btnSaveTemplate = By.xpath("//button[@id='saveApprovalTemplate']");
    public By searchSuggestionList = By.xpath("//*[contains(@class,'searchSuggestionOuterWrapper')]");
    public By eleTempCreationSuccessMessage = By.xpath("//span[contains(text(),'The process was successfully added.')]");
    public By addNewApprovalProcess = By.xpath("//a[contains(text(),'Add New Approval Process')]");
    public By btnmanageGroup = By.xpath("//a[text()='Manage Groups ']");
    public By btnEditGroup = By.xpath("//a[@class='editEmployerClick']");
    public By btnRequisitionApproval = By.xpath("//div[text()='Requisition Approval Process']");
    public By approvalTemplateDD = By.xpath("//input[@placeholder='Search from the list of already existing approval processes in the system']");
    public By templateList = By.xpath("//div[@class='searchSuggestionTuple']");
    public By btnAddNew = By.xpath("//span[text()='ADD NEW']");
    public By successStripGroupsTab = By.xpath("//span[@class='dspIb maxW350 ellipsis']");
    public By btnSaveGroup = By.xpath("//button[@class='save blockBtn']");
    public By saveGroupSuccessStrip = By.xpath("//span[text()='Group details edited']");
    public By btnPreview = By.xpath("(//span[text()='Preview'])[1]");
    public By btnEdit = By.xpath("(//span[@class='editButton'])[1]");
    public By editSuccessMsgStrip = By.xpath("//span[text()='The process was successfully edited.']");
    public By lnkManageApprovalProcess = By.xpath("//a[text()='Manage Approval Processes']");
    public By btnPagination = By.xpath("(//div[@class='pagination']/select)[1]/option");
    public By approver_DD = By.xpath("(//span[contains(text(),'Enter email Ids of approvers')])[${count}]");
    public By approversList = By.xpath("(//div[@class='stage-approvers-email']//li)[${count}]");
    public By approvalStageName = By.xpath("(//div[@class='process-field']/input)[${count}]");
    public By lblAddApprover = By.xpath("//label[contains(text(),\"Add Approvers\")]");
    public By approvalTemplateOverallCount = By.xpath("(//div[@class=\"pagination\"])[1]/span[text()='per Page']/following-sibling::span");
    public By txtHighlightedGroupName = By.xpath("//span[text()='Requisition-Approval']");
    public By templateInfoPreview = By.xpath("//div[@class='processDetails ']");
    public By eleSelect = By.xpath("//select");

    GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);

    /**
     * This method is used to login to RMS with given subscription type
     *
     * @param subscriptionType
     * @author Nikhil.Bhatia
     */

    public void loginToRMS(String subscriptionType) {
        genericFunction.setUsernameAndPassword(subscriptionType, "Superuser");
    }

    /**
     * This method is used to open specific url
     *
     * @param URL
     * @author Nikhil.Bhatia
     */

    public void openSpecificURL(String URL) {
        genericFunction.launchSpecificURL(YamlReader.getAppConfigValue(URL));
    }

    /**
     * This method is used to get title of approval template listing page
     *
     * @return Page title
     * @author Nikhil.Bhatia
     */

    public String getApprovalTemplateListingPageTitle() {
        return getPageTitle();
    }

    /**
     * This method is used to find visibility of tab head
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */

    public boolean getLightBoxTabHeadIsDisplayed() {
        wait.waitForVisibilityOfElement(tabHeadTitle);
        return isDisplayed(tabHeadTitle);
    }

    /**
     * This method is used to find visibility of preview link
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */

    public boolean getTemplateInfoPreview() {
        return isDisplayed(templateInfoPreview);
    }

    /**
     * This method is used to find visibility of suggestion link
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */

    public boolean getSuggestionLinkForTemplateIsDisplayed() {
        return isDisplayed(suggestionLinkTemplate);
    }

    /**
     * This method is used to find visibility of template not found text
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */

    public boolean getTemplateNotFoundIsDisplayed() {
        return isDisplayed(templateNotFound);
    }

    /**
     * This method is used to click on adddNewButton
     *
     * @author Nikhil.Bhatia
     */

    public void clickOnAddNewButton() {
        click(btnAddNewTemplate);
    }

    /**
     * This method is used to get first Template Name on tuple
     *
     * @return templateName
     * @author Nikhil.Bhatia
     */
    public String getFirstTemplateName() {
        wait.waitForPageToLoadCompletely();
        wait.waitForVisibilityOfElement(firstTupleTemplateListing);
        return getText(firstTupleTemplateListing);
    }

    /**
     * This method is used to getAllValuesOfPaginationDD
     *
     * @return page values existed on template listing page
     * @author Nikhil.Bhatia
     */
    public List<String> getAllValuesOfPaginationDD() {
        List<String> pageValues = new ArrayList<String>();
        List<WebElement> pageOptions = getElements(btnPagination);
        System.out.println("optionvalues" + pageOptions);
        for (WebElement pageOption : pageOptions)
            pageValues.add(pageOption.getText());
        System.out.println(pageValues);
        return pageValues;
    }

    /**
     * This method is used to getTemplateListCount
     *
     * @return approval process tuple count
     * @author Nikhil.Bhatia
     */
    public int getTemplateListCount() {
        wait.waitForPageToLoadCompletely();
        return getElements(tupleTemplateList).size();
    }

    /**
     * This method is used to getApprovalTemplateOverallCount
     *
     * @return Approval process total count
     * @author Nikhil.Bhatia
     */
    public String getApprovalTemplateOverallCount() {
        return getText(approvalTemplateOverallCount).split(" of ")[1].trim();
    }

    /**
     * This method is used to check pagination functionality and the count in each tab or tuple listed
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */

    public boolean paginationResultsIsDisplayed() {
        List<String> pages = getAllValuesOfPaginationDD();
        int overallCountOfTemplates = Integer.parseInt(getApprovalTemplateOverallCount());
        System.out.println(pages);
        boolean flag = false;
        for (String page : pages) {
            System.out.println(page);
            int pageValue = Integer.parseInt(page.trim());
            selectValueFromPaginationDD(page);
            int templateListCount = getTemplateListCount();
            System.out.println("templateListCount" + templateListCount);
            System.out.println("pageValue" + pageValue);
            System.out.println("overallCountOfTemplates" + overallCountOfTemplates);

            if (overallCountOfTemplates >= pageValue && templateListCount != pageValue) {
                return false;
            } else if (overallCountOfTemplates < pageValue && templateListCount != overallCountOfTemplates) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is used to getFirstHighlightedText in approval process tuple
     *
     * @return Highlighted Approval template name
     * @author Nikhil.Bhatia
     */
    public String getFirstHighlightedText() {
        return getText(eleHighlightedText);
    }

    /**
     * This method is used to selectValueFromPaginationDD
     *
     * @param value to be selected
     * @author Nikhil.Bhatia
     */
    public void selectValueFromPaginationDD(String value) {
        wait.waitForVisibilityOfElement(eleSelect);
        Select dd = new Select(driver.findElement(eleSelect));
        dd.selectByValue(value);
    }

    /**
     * This method is used to selectGroupFromSuggestionInSearch
     *
     * @param validGroupName
     * @author Nikhil.Bhatia
     */

    public void selectGroupFromSuggestionInSearch(String validGroupName) {
        click(txtBoxSearch);
        sendKeys(txtBoxSearch, validGroupName);
        click(parameterizedLocator(suggestionForGroup, validGroupName.toUpperCase()));
        System.out.println(validGroupName.toUpperCase());
    }

    /**
     * This method is used to fillSearchTextBox
     *
     * @param searchText
     * @author Nikhil.Bhatia
     */

    public void fillSearchTextBox(String searchText) {
        click(txtBoxSearch);
        sendKeys(txtBoxSearch, searchText);
    }

    /**
     * This method is used to  clickOnAllResultsSuggestionLink
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnAllResultsSuggestionLink() {
        click(suggestionLinkTemplate);
    }

    public String getPageUrl() {
        return getCurrentURL();
    }

    /**
     * This method is used to  getAllHighlightedTemplates
     *
     * @return tuples on template listing page
     * @author Nikhil.Bhatia
     */
    public List<WebElement> getAllHighlightedTemplates() {
        return getElements(tupleHighlightedTemplateListing);
    }

    public boolean highlightedTemplateResultsIsDisplayed(String highlightedText) {
        List<WebElement> we = getAllHighlightedTemplates();
        for (WebElement webElement : we) {
            if (!webElement.getText().toUpperCase().contains(highlightedText.toUpperCase())) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is used to  searchTemplate on template listing page
     *
     * @param text(template name or group)
     * @author Nikhil.Bhatia
     */
    public void searchTemplate(String text) {
        fillSearchTextBox(text);
        wait.waitForVisibilityOfElement(searchSuggestionList);
        click(btnSearch);
    }

    /**
     * This method is used to  clickOnDeleteFirstTemplateTuple
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnDeleteFirstTemplateTuple() {
        click(btnDelete);
        click(deleteTemplateLightbox);
    }

    /**
     * This method is used to find visibility of deletion success strip
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean templateDeletionSuccessStripIsDisplayed() {
        return isDisplayed(templateDeletionSuccessStrip);
    }

    /**
     * This method is used to find visibility No Matching Results
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean noResultTextFromSearchIsDisplayed(String templateName) {
        searchTemplate(templateName);
        return getText(noResultAfterSearch).equals("No Matching Results");
    }

    /**
     * This method is used to  clickOnClearLink
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnClearLink() {
        click(lnkClear);
    }

    /**
     * This method is used to  clickOnEditButtonUnderTemplateTuple
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnEditButtonUnderTemplateTuple() {
        wait.waitForElementToBeClickable(btnEdit);
        click(btnEdit);
    }

    /**
     * This method is used to  clickOnPreviewButtonUnderTemplateTuple
     *
     * @author Nikhil.Bhatia
     */

    public void clickOnPreviewButtonUnderTemplateTuple() {
        click(btnPreview);
    }

    /**
     * This method is used to find visibility of successStripForTemplateCreationOnTemplateListingPageIsDisplayed
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean successStripForTemplateCreationOnTemplateListingPageIsDisplayed() {
        wait.waitForVisibilityOfElement(eleTempCreationSuccessMessage);
        return isDisplayed(eleTempCreationSuccessMessage);
    }

    /**
     * This method is used to find visibility of successStripForTemplateEditOnTemplateListingPageIsDisplayed
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean successStripForTemplateEditOnTemplateListingPageIsDisplayed() {
        return isDisplayed(editSuccessMsgStrip);
    }

    /**
     * This method is used to  clickOnManageGroup
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnManageGroup() {
        wait.waitForPageToLoadCompletely();
        click(btnmanageGroup);
        click(btnEditGroup);
    }

    /**
     * This method is used to  clickOnRequisitionApprovalTab
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnRequisitionApprovalTab() {
        click(btnRequisitionApproval);
    }

    /**
     * This method is used to find visibility of successStripIsDisplayedForSavedGroup
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean successStripIsDisplayedForSavedGroup() {
        wait.waitForVisibilityOfElement(saveGroupSuccessStrip);
        return isDisplayed(saveGroupSuccessStrip);
    }

    /**
     * This method is used to  clickOnSaveGroup
     *
     * @author Nikhil.Bhatia
     */

    public void clickOnSaveGroup() {
        wait.waitForVisibilityOfElement(btnSaveGroup);
        click(btnSaveGroup);
    }

    /**
     * This method is used to  clickOnAddNewBtnGroupLightbox
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnAddNewBtnGroupLightbox() {
        jsUtil.scrollDown(btnAddNew);
        click(btnAddNew);
    }

    /**
     * This method is used to  clickOnAddNewApprovalProcessLinkFromSettingsPage
     *
     * @author Nikhil.Bhatia
     */
    public void clickOnAddNewApprovalProcessLinkFromSettingsPage() {
        jsUtil.scrollDown(lnkManageApprovalProcess);
        wait.waitForVisibilityOfElement(addNewApprovalProcess);
        click(addNewApprovalProcess);
    }

    /**
     * This method is used to find visibility of successStripForTemplateCreationIsDisplayedOnAddANewGroupLightBox
     *
     * @return boolean
     * @author Nikhil.Bhatia
     */
    public boolean successStripForTemplateCreationIsDisplayedOnAddANewGroupLightBox() {
        wait.waitForVisibilityOfElement(successStripGroupsTab);
        return isDisplayed(successStripGroupsTab);
    }

    public class AddNewApprovalTemplate {

        /**
         * This method is used to prefillTemplateFromExistingTemplate
         *
         * @author Nikhil.Bhatia
         */

        public void prefillTemplateFromExistingTemplate(String templateName) {
            wait.waitForVisibilityOfElement(approvalTemplateDD);
            click(approvalTemplateDD);
            sendKeys(approvalTemplateDD, templateName);
            getElements(templateList).get(0).click();
        }

        /**
         * This method is used to createTemplateFromExisting
         *
         * @param approvalProcessName,existing templateName
         * @author Nikhil.Bhatia
         */
        public void createTemplateFromExisting(String approvalProcessName, String templateName) {
            fillApprovalProcessName(approvalProcessName);
            prefillTemplateFromExistingTemplate(templateName);
            clickOnSaveTemplate();
        }

        /**
         * This method is used to clickOnAddApprovalStage
         *
         * @author Nikhil.Bhatia
         */

        public void clickOnAddApprovalStage() {
            click(lblAddApprover);
            jsUtil.scrollDown(btnAddStage);
            click(btnAddStage);
        }

        /**
         * This method is used to fillApprovalStage
         *
         * @param stageName and approverEmail
         * @author Nikhil.Bhatia
         */
        public void fillApprovalStage(String stageName, String approverEmail) {
            List<WebElement> approvalStages = getElements(approvalStageSection);
            fillStageName(approvalStages.size(), stageName);
            addApproverFromDD(approvalStages.size());
            enterApprover(approvalStages.size(), approverEmail);
        }

        /**
         * This method is used to fillStageName
         *
         * @param stageName and parameter for indexing
         * @author Nikhil.Bhatia
         */
        public void fillStageName(int index, String stageName) {
            getElement(parameterizedLocator(approvalStageName, "" + index)).clear();
            jsUtil.scrollDown(parameterizedLocator(approvalStageName, "" + index));
            getElement(parameterizedLocator(approvalStageName, "" + index)).click();
            sendKeys(parameterizedLocator(approvalStageName, "" + index), stageName);
        }

        /**
         * This method is used to fillApprovalProcessName
         *
         * @param approvalTemplateName
         * @author Nikhil.Bhatia
         */

        public void fillApprovalProcessName(String approvalTemplateName) {
            jsUtil.scrollUp();
            wait.waitForVisibilityOfElement(lightboxFillTemplateName);
            getElement(lightboxFillTemplateName).clear();
            sendKeys(lightboxFillTemplateName, approvalTemplateName);
        }

        /**
         * This method is used to createNewApprovalProcess
         *
         * @param approvalTemplateName ,stageName,approverEmail,flag(for group selection)
         * @author Nikhil.Bhatia
         */

        public void createNewApprovalProcess(String approvalTemplateName, String stageName, String approverEmail, String flag) {
            fillApprovalProcessName(approvalTemplateName);
            if (!flag.equals("group")) {
                fillGroupForRequisitionApproval();
            }
            fillApprovalStage(stageName, approverEmail);
            clickOnAddApprovalStage();
            fillApprovalStage(stageName, approverEmail);
            clickOnSaveTemplate();
        }

        /**
         * This method is used to editTemplateName
         *
         * @param approvalTemplateName ,stageName,approverEmail,flag(for group selection)
         * @author Nikhil.Bhatia
         */

        public void editTemplateName(String approvalTemplateName) {
            fillApprovalProcessName(approvalTemplateName);
            clickOnSaveTemplate();
        }

        /**
         * This method is used to clickOnSaveTemplate
         *
         * @author Nikhil.Bhatia
         * without hard wait it becomes flaky on test env ,dont remove this
         */
        public void clickOnSaveTemplate() {
            wait.hardWait(1);
            click(btnSaveTemplate);
        }

        /**
         * This method is used to fillGroupForRequisitionApproval
         *
         * @author Nikhil.Bhatia
         */
        public void fillGroupForRequisitionApproval() {
            click(ddAssignGroup);
            List<WebElement> groups = getElements(groupList);
            groups.get(0).click();
            click(tabHeadTitle);
        }

        /**
         * This method is used to addApproverFromDD (existing approvers in the system)
         *
         * @author Nikhil.Bhatia
         */
        public void addApproverFromDD(int index) {
            jsUtil.scrollDown(btnAddStage);
            getElement(approver_DD, String.valueOf(index)).click();
            getElements(approversList, "" + index).get(0).click();
        }

        /**
         * This method is used to enterApprover in stages
         *
         * @author Nikhil.Bhatia
         */
        public void enterApprover(int index, String approverEmail) {
            getElement(approver_DD, String.valueOf(index)).click();
            sendKeys(approvers_txt, (approverEmail + Keys.ENTER));
        }

    }
}

