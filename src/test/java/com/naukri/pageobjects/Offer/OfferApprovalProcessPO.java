package com.naukri.pageobjects.Offer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.test.base.BaseAutomation;

/**
 * @author raunak.b
 *
 */
public class OfferApprovalProcessPO extends BaseAutomation {

	public By addNewApprovalBtn = By.xpath("//div[@class='addToList']/span");
	public By templateName = By.xpath("//div[@class='approval-name-container']//input");
	public By stageNameText = By.xpath("(//input[@class='input-field'])[${string}]");
	public By enterApproversStage = By.xpath(
			"//label[text()='${string}']/ancestor::div[starts-with(@class,'stage-item')]//span[text()='Enter email Ids of approvers']");
	public By fillApprover = By.xpath("//div[@class='select-controller singleSelectBar']//input");
	public By SaveApprovalBtn = By.xpath("//button[@id='saveApprovalTemplate']");
	public By selectedTab = By.xpath("//div[@class='selectTab']");
	public By firstTemplateUnderSelected = By.xpath("//div[@class='select-list']//label");
	public By addApprovalStage = By.xpath("//div[@class='add-stage']//span");
	public By viewTemplate = By.xpath("//span[@class='list-hover-items']");
	public By approverOnSelectedTab = By.xpath("//li[text()='${string}']");
	public By everyOneApprovalMandatorychkbx = By.xpath("//div[@class='stage-approvers-check']//label");
	public By manageApprovaltabSettingsPage = By.xpath("//a[text()='${string}']");
	public By addNewApprovalBtnListingPage = By.xpath("//span[@id='addNewProcessBtn']//input");
	public By assignToGroupsOfOfferDD = By.xpath("(//span[@class='select-toggler'])[2]");
	public By firstGroupUnderOfferApproval = By.xpath("(//div[@class='select-list']//label)[1]");
	public By prefillFromExistingDD = By.xpath("//input[@id='prefill_inputBox']");
	public By selectprefillTemplate = By.xpath("//div[@class='searchSuggestionTuple']");
	public By approversList = By.xpath("//span[@class='toIds']");
	public By ApprovalTemplateActionsONListing = By.xpath("(//span[text()='${string}'])[1]");
	public By confirmationBtnOnLightbox = By.xpath("//button[@class='confBtn yes']");
	public By elementVisibleOnListing = By.xpath("//div[text()='${string}']");
	public By stripOnListingPage = By.xpath("//span[text()='${string}']");
	public By NoResultsFoundonSelectedTab = By.xpath("//div[@class='select-list']//ul//div");
	public By approvalSearchBar = By.xpath("//div[@id='inputSuggestor']//input");
	public By approvalSearchBtn = By.xpath("(//input[@type='button'])[2]");
	public By approversOnPreviewListing = By.xpath("(//div[@class='previewBulletText'])[${string}]");
	public By totalGroupsInSystem = By.xpath("(//em[@id='totalRecord'])[1]");
	public By groupsDisplayedOnOffer = By.xpath("//div[@class='allTab activeTab']");
	public By getTotalApprovaltemplates = By.xpath("(//span[@class='ml10'])[1]");
	private By timelineStatus = By.xpath("//div[@id='timeLineAction']//strong");
	private By BulkUpdateButtonOnLightBox = By.id("bulkStatusUpdateBtn");

	/**
	 * returns file system path
	 * 
	 * @return file path
	 */
	public String fileSystemPath() {
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testdata" + File.separator + "OfferManagement"
				+ File.separator;
		return filePath;
	}

	/**
	 * click add new approval template
	 */
	public void clickAddNewApprovalTemplate() {
		jsUtil.scrollDown(addNewApprovalBtn);
		wait.waitForElementToBeClickable(addNewApprovalBtn);
		click(addNewApprovalBtn);
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeClickable(templateName);
		wait.waitForVisibilityOfElement(templateName);
	}

	/**
	 * enter approval name
	 */
	public void enterApprovalName() {
		String approvalTemplate = "testOfferApprovalProcess" + System.currentTimeMillis();
		ReadWritePropertyFile.setProperty("ApprovalTemplateName", approvalTemplate,
				fileSystemPath() + "offerApproval.properties");
		sendKeys(templateName, approvalTemplate);
	}

	/**
	 * enter stage name
	 * 
	 * @param stageName
	 */
	public void enterStageName(String stageName) {
		getElement(stageNameText, "1").sendKeys(stageName);
	}

	/**
	 * enter one approver in stage one
	 * 
	 * @param approver1
	 */
	public void enterOneApproverInStageOne(String approver1) {
		jsUtil.scrollDown(parameterizedLocator(enterApproversStage, "1"));
		click(parameterizedLocator(enterApproversStage, "1"));
		sendKeys(fillApprover, approver1);
		getElement(fillApprover).sendKeys(Keys.ENTER);

	}

	/**
	 * enter approvers in stage 1
	 * 
	 * @param Approver1
	 * @param Approver2
	 */
	public void enterApproversInStageOne(String Approver1, String Approver2) {
		jsUtil.scrollDown(parameterizedLocator(enterApproversStage, "1"));
		click(parameterizedLocator(enterApproversStage, "1"));
		sendKeys(fillApprover, Approver1);
		getElement(fillApprover).sendKeys(Keys.ENTER);
		sendKeys(fillApprover, Approver2);
		getElement(fillApprover).sendKeys(Keys.ENTER);
	}

	/**
	 * click on save approval template
	 */
	public void clickOnSaveApprovalTemplate() {
		wait.waitForVisibilityOfElement(SaveApprovalBtn);
		click(SaveApprovalBtn);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * verify approval template is displayed under selected tab
	 * 
	 * @return true if approval templates is displayed under selected
	 */
	public boolean verifyApprovalTemplateIsDisplayedUnderSelectedTab() {

		String ExpectedOfferTemplateName = ReadWritePropertyFile.getProperty("ApprovalTemplateName",
				fileSystemPath() + "offerApproval.properties");
		String ActualOfferTemplateName = getText(firstTemplateUnderSelected);
		return ExpectedOfferTemplateName.equals(ActualOfferTemplateName);
	}

	/**
	 * click on add approval stage
	 */
	public void clickOnAddApprovalStage() {
		wait.waitForVisibilityOfElement(parameterizedLocator(stageNameText, "1"));
		jsUtil.scrollDown(parameterizedLocator(stageNameText, "1"));
		getElement(stageNameText, "1").click();
		wait.waitForElementToBeClickable(addApprovalStage);
		click(addApprovalStage);
	}

	/**
	 * enter second stage name
	 * 
	 * @param stageName
	 */
	public void enterSecondStageName(String stageName) {
		wait.waitForVisibilityOfElement(parameterizedLocator(stageNameText, "3"));
		jsUtil.scrollDown(parameterizedLocator(stageNameText, "3"));
		getElement(stageNameText, "3").sendKeys(stageName);
	}

	/**
	 * enter one approver in stage 2
	 * 
	 * @param approverName
	 */
	public void enterOneApproverInStage2(String approverName) {
		wait.waitForElementToBeClickable(parameterizedLocator(enterApproversStage, "2"));
		getElement(enterApproversStage, "2").click();
		sendKeys(fillApprover, approverName);
		getElement(fillApprover).sendKeys(Keys.ENTER);
	}

	/**
	 * click on selected
	 * 
	 */
	public void clickOnSelected() {
		wait.waitForValignWrapperToDisappear(652, 151);
		click(selectedTab);
	}

	/**
	 * click on view template
	 */
	public void clickOnViewTemplate() {
		jsUtil.hoverByJS(viewTemplate);
		jsUtil.clickByJS(viewTemplate);

	}

	/**
	 * verify approvers displayed under template
	 * 
	 * @param list
	 * @return true if approvers displayed under template
	 */
	public boolean verifyApproversDisplayedUnderTemplate(List<String> list) {
		int j = 0;
		for (int i = 0; i < 5; i++) {
			if (getElement(approverOnSelectedTab, list.get(i)).isDisplayed()) {
				j++;
				continue;

			} else {
				break;
			}
		}
		return (j == 5);
	}

	/**
	 * verify appproval mandatory displayed
	 * 
	 * @param approvalMandatory
	 * @return true if appproval mandatory displayed
	 */
	public boolean verifyApprovalMandatoryDisplayed(String approvalMandatory) {
		return getElement(everyOneApprovalMandatorychkbx).getText().contains(approvalMandatory);
	}

	/**
	 * manage Approval Process Tab Is Displayed
	 * 
	 * @param approvalTab
	 * @return true if manage Approval Process Tab Is Displayed
	 */
	public boolean manageApprovalProcessTabIsDisplayed(String approvalTab) {
		return elementVisibility(manageApprovaltabSettingsPage, approvalTab);
	}

	/**
	 * text on settings page
	 * 
	 * @param textOnSettingsPage
	 * @return true if manage Approval Process Tab Is Displayed
	 */
	public boolean textOnSettingsPage(String textOnSettingsPage) {
		return getElement(manageApprovaltabSettingsPage, textOnSettingsPage).isDisplayed();
	}

	/**
	 * click on add new approval template
	 */
	public void clickOnAddNewApprovalTemplate() {
		wait.waitForVisibilityOfElement(addNewApprovalBtnListingPage);
		click(addNewApprovalBtnListingPage);
	}

	/**
	 * select First Group Under Offer Approval
	 */
	public void selectFirstGroupUnderOfferApproval() {
		click(assignToGroupsOfOfferDD);
		click(firstGroupUnderOfferApproval);
	}

	/**
	 * select One Template under Prefill From Existing
	 */
	public void selectOneTemplateunderPrefillFromExisting() {
		String OfferTemplateName = ReadWritePropertyFile.getProperty("ApprovalTemplateName",
				fileSystemPath() + "offerApproval.properties");
		sendKeys(prefillFromExistingDD, OfferTemplateName);
		click(selectprefillTemplate);
	}

	/**
	 * verify approvers and stage name displayed on prefill existing
	 * 
	 * @param stageName
	 * @param approver1
	 * @param approver2
	 * @return true if approvers and stage name displayed on prefill existing
	 */
	public boolean verifyApproversListAndStageNameInPrefillExisting(String stageName, String approver1,
			String approver2) {
		wait.waitForPageToLoadCompletely();
		jsUtil.scrollDown(parameterizedLocator(stageNameText, "1"));
		String ExpectedStageName = getAttribute(parameterizedLocator(stageNameText, "1"), "value");
		List<String> l1 = new ArrayList<String>();
		int ApproverListSize = getElements(approversList).size();
		for (int i = 1; i <= ApproverListSize; i++) {
			l1.add(getText(By.xpath("(//span[@class='toIds'])[" + i + "]")));
		}
		if (l1.contains(approver1) && l1.contains(approver2) && ExpectedStageName.contains(stageName))
			return true;
		else
			return false;
	}

	/**
	 * delete Approval Template Listing Page
	 * 
	 * @param deleteBtn
	 */
	public void deleteApprovalTemplateListingPage(String deleteBtn) {
		click(parameterizedLocator(ApprovalTemplateActionsONListing, deleteBtn));
		click(confirmationBtnOnLightbox);
	}

	/**
	 * TEMPLATE DELETED LISTING PAGE
	 * 
	 * @return true if template is deleted
	 */
	public boolean templateDeletedListingPage() {
		wait.waitForPageToLoadCompletely();
		String ExpectedOfferTemplateName = ReadWritePropertyFile.getProperty("ApprovalTemplateName",
				fileSystemPath() + "offerApproval.properties");
		return elementVisibility(elementVisibleOnListing, ExpectedOfferTemplateName);
	}

	/**
	 * template Deleted Strip listing Page
	 * 
	 * @param approvalTemplateStrip
	 * @return true if template is deleted and deletion strip is displayed
	 */
	public boolean templateDeletdStriplistingPage(String approvalTemplateStrip) {
		return elementVisibility(stripOnListingPage, approvalTemplateStrip);
	}

	/**
	 * enter approval template name
	 */
	public void enterApprovalTemplateName() {
		wait.waitForVisibilityOfElement(approvalSearchBar);
		String ExpectedOfferTemplateNamez = ReadWritePropertyFile.getProperty("ApprovalTemplateName",
				fileSystemPath() + "offerApproval.properties");
		click(approvalSearchBar);
		getElement(approvalSearchBar).sendKeys(ExpectedOfferTemplateNamez);
		click(approvalSearchBtn);
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * verify No Selected Template Visible
	 * 
	 * @param noResultsFound
	 * @return true if no selected template is visible
	 */
	public boolean verifyNoSelectedTemplateVisible(String noResultsFound) {
		return getText(NoResultsFoundonSelectedTab).contains(noResultsFound);
	}

	/**
	 * click on edit approval template
	 * 
	 * @param editBtn
	 */
	public void clickEditApprovalTemplate(String editBtn) {
		click(parameterizedLocator(ApprovalTemplateActionsONListing, editBtn));
	}

	/**
	 * click on preview template
	 * 
	 * @param preview
	 */
	public void clickPreviewTemplate(String preview) {
		click(parameterizedLocator(ApprovalTemplateActionsONListing, preview));
	}

	/**
	 * verify Preview Approval Template
	 * 
	 * @param stage1
	 * @param approver1
	 * @param stage2
	 * @param approver2
	 * @return TRUE if preview approval template is displayed
	 */
	public boolean verifyPreviewApprovalTemplate(String stage1, String approver1, String stage2, String approver2) {
		int i = 1;
		return getText(parameterizedLocator(approversOnPreviewListing, Integer.toString(i))).contains(approver1)
				&& getText(parameterizedLocator(approversOnPreviewListing, Integer.toString(i + 1)))
						.contains(approver2);
	}

	/**
	 * get total groups
	 */
	public void getTotalGroups() {
		String totalgroups = getText(totalGroupsInSystem);
		ReadWritePropertyFile.setProperty("TotalGroupsInSystem", totalgroups,
				fileSystemPath() + "offerApproval.properties");
	}

	/**
	 * click assign to groups for offer approval
	 */
	public void clickAssignToGroupsForOfferApproval() {
		click(assignToGroupsOfOfferDD);
	}

	/**
	 * verify Count Of Groups On Offer DD
	 * 
	 * @return true if count of groups on offer DD matches with total groups in
	 *         system
	 */
	public boolean verifyCountOfGroupsOnOfferDD() {
		String totalGroupsPresent = ReadWritePropertyFile.getProperty("TotalGroupsInSystem",
				fileSystemPath() + "offerApproval.properties");
		return getText(groupsDisplayedOnOffer).contains(totalGroupsPresent);
	}

	/**
	 * get total approval templates
	 */
	public void getTotalApprovalTemplates() {
		String extraStringIncludedInCountTemplates = getText(getTotalApprovaltemplates);
		String requiredCountApprovalListing = extraStringIncludedInCountTemplates.replace("showing 1 to 40 of ", "");
		ReadWritePropertyFile.setProperty("TotalApprovalTemlatesInSystem", requiredCountApprovalListing,
				fileSystemPath() + "offerApproval.properties");
	}

	/**
	 * verify count approval templates
	 * 
	 * @return true if count of approval templates matches with templates in system
	 */
	public boolean verifyCountApprovalTemplates() {
		String totalTemplatesInSystem = ReadWritePropertyFile.getProperty("TotalApprovalTemlatesInSystem",
				fileSystemPath() + "offerApproval.properties");
		return getText(groupsDisplayedOnOffer).contains(totalTemplatesInSystem);
	}

	/**
	 * verufy group name and applied on
	 * 
	 * @return true if verify group name and applied on
	 */
	public boolean verifyGroupNameAndAppliedOn() {
		// wait.hardWait(5);
		// driver.navigate().refresh();
		wait.hardWait(5);
		// String groupName = PropFileHandler.readProperty("GroupName");
		// System.out.println(groupName);
		String approvalName = ReadWritePropertyFile.getProperty("ApprovalTemplateName",
				fileSystemPath() + "offerApproval.properties");

		wait.waitForVisibilityOfElement(parameterizedLocator(elementVisibleOnListing, approvalName));
		System.out.println(getElement(elementVisibleOnListing, approvalName).isDisplayed());
		// System.out.println(getElement(elementVisibleOnListing,
		// groupName).isDisplayed());
		System.out.println(getElement(stripOnListingPage, "Offers").isDisplayed());
		return getElement(elementVisibleOnListing, approvalName).isDisplayed()
				&& getElement(stripOnListingPage, "Offers").isDisplayed();
	}

	/** save Template Name To Property File
	 * @param firstOrSecond
	 */
	public void saveTemplateNameToPropertyFile(String firstOrSecond) {
		ReadWritePropertyFile.setProperty(firstOrSecond + "ApprovalTemplateName", ReadWritePropertyFile.getProperty("ApprovalTemplateName", OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerApproval.properties"),
				OfferGenerationSalaryRuleSettingsPO.fileSystemPath() + "offerManagementSalaryBreakup.properties");
	}
	public boolean StatusOnTimeline(String statusTimeline)
	{
		System.out.println(getText(timelineStatus));
		return getText(timelineStatus).contains(statusTimeline);
	}
	public void clickUpdateBulkStatusLayer()
	{
		wait.waitForValignWrapperToDisappear(456, 364);
		click(BulkUpdateButtonOnLightBox);
	}
}
