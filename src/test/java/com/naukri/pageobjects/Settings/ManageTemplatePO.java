package com.naukri.pageobjects.Settings;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.test.base.BaseAutomation;
import org.openqa.selenium.By;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManageTemplatePO extends BaseAutomation {

    private By txtMsgTemplateName = By.xpath("//input[@placeholder='Enter template name']");
    private By txtTemplateName = By.id("mailTemplateName");
    private By txtMsgSubject = By.xpath("//input[@placeholder='Enter subject']");
    private By ddSelectCategory = By.xpath("(//option[contains(@title,'rospect')])[1]");
    private By ddCategory = By.id("tempCat");
    private By txtSubject = By.xpath("//input[@name='subject']");
    private By txtBody = By.xpath("//iframe[@id='mailTemplateBody']");
    private By lnkDelete = By.xpath("(//a[text()='Delete'])[2]");
    private By btnFinalDelete = By.id("deleteClose1");
    private By chktemplate1 = By.xpath("(//input[@type='checkbox'])[3]");
    private By chktemplate2 = By.xpath("(//input[@type='checkbox'])[4]");
    private By lnkBulkDelete = By.xpath("(//a[text()='Delete'])[1]");
    private By btnFinalBulkDelete = By.id("deleteClose");
    private By pMailPreview = By.xpath("//p[contains(text(),'Mail Preview')]");
    private By txtSearchBox = By.id("headSearch");
    private By btnSearch = By.xpath("(//input[@type='submit'])[2]");
    private By ddTemplateFilter = By.id("templateTypeFilter");
    private By ddCorrectFilter = By.xpath("//option[text()='Message']");
    private By ddWrongFilter = By.xpath("//option[text()='Forward']");
    private By ddPrefillTemplate = By.xpath("//span[text()='Prefill from Template']");
    private By ddSelectPrefillTemplate = By.xpath("(//span[contains(text(),'Template')])[2]");
    private By btnNxt = By.id("tempTypeNext");
    private By txtMsgBody = By.xpath("(//div[@class='mailBodyWriter'])[2]");
    private By ddMsgTags = By.xpath("//span[text()='[tags]']");
    private By ddTagElement1 = By.xpath("//li[text()='Date of Birth']");
    private By ddTagElement2 = By.xpath("//li[text()='Candidate Email']");
    private By financialCategoryDD = By.xpath("//span[text()='Select a category']/ancestor::div[@class='select-controller']//span[text()='DownArrow']");
    private By financialSelectedCategoryDD = By.xpath("//span[text()='Invoice']/ancestor::div[@class='select-controller']//span[text()='DownArrow']");
    private By subjectTemplateTxt = By.xpath("//*[text()='Subject :']/following-sibling::input[contains(@id,'Subject')]");
    private By mailBodyTemplateTxt = By.xpath("(//div[@class='mailBodyWriter'])[2]");
    private By saveTemplateName = By.xpath("//input[@name='saveTemplateName']");
    private By saveBtn = By.xpath("//button[@id='saveTempBtn']");
    private By prefilledDD = By.xpath("//div[@class='prefill colSec']//span[text()='Prefill from Template']");
    private By searchFinancialTemplate = By.xpath("//input[@placeholder='search here']");
    private By existingTemplateDD = By.xpath("//div[@class='prefill colSec']//span[text()='Prefill from Template']");
    private By closePreview = By.xpath("//a[@class='gray_btn fr previewShut'])[1]");
    private By mailErrorMessage = By.xpath("//div[@class='msg']");
    private By shareTmeplate = By.xpath("//label[text()='Share this template']");
    private By unshareTextOnfirstTemplate = By.xpath("(//ul[@class='manage cle'])[1]//li[@class='first']/a");
    private By selectCategory = By.xpath("//div[contains(@class,'select template-category')]");
    private By mailBodyContent = By.xpath("//div[contains(text(),'Dear')]");
    private By mailBody = By.xpath("(//div[@class=\"mailBodyWriter\"])[2]");
    private By subjectTemplate = By.xpath("(//input[@id='mailTemplateSubject'])[2]");
    By eleAddNewTemplate = By.xpath("//a[text()='Add a New Template  ']");
    By eleFinancialOption = By.xpath("//label[text()='Financial']/input");
	By eleNextBtn = By.id("tempTypeNext");
	By firstTemplateName = By.xpath("(//a[contains(@id,'mailTemplateName')])[1]");
	By eleExcelTrackerList = By.id("inp_prefillTemp");
	By eleSelectTheTemplate = By.xpath("(//ul[contains(@id,\"ul_prefillTemp\")]//a)[${count}]");
//	By subjectTemplateTxt = By.xpath("//*[text()='Subject :']/following-sibling::input[contains(@id,'Subject')]");

    boolean flag = true;
    private static String testDataFile = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testdata"+File.separator+"billingTestData.properties";
    public static String uniqueTemplateName = "";

    /**
     * @param templateType
     * @author jatin.bisht This method select template from various template
     */
    public void clickOnTemplateType(String templateType) {
        getElement(By.xpath("//label[text()='" + templateType + "']")).click();
        getElement(btnNxt).click();
    }

    /**
     * @param labelName
     * @return
     * @author jatin.bisht This method verifies labels visible on page
     */
    public boolean verifyLabel(String labelName) {
        return isDisplayed(By.xpath("(//*[text()='" + labelName + "'])"));
    }

    /**
     * @param templateName
     * @author jatin.bisht This method fill madatory fields for message template
     */
    public void fillMandatoryFieldsForMsg(String templateName) {
        getElement(txtMsgTemplateName).sendKeys(templateName);
        getElement(txtMsgSubject).sendKeys("this is subject");
        getElement(txtMsgBody).click();
        mouseHoverToWebElement(getElement(ddMsgTags));
        getElement(ddTagElement1).click();
        getElement(ddTagElement2).click();
    }

    /**
     * @param templateName
     * @author jatin.bisht This method verify created Template is visible
     */
    public boolean verifyTemplateAdd(String templateName) {
        wait.waitForPageToLoadCompletely();
        return isDisplayed(By.xpath("//a[text()='" + templateName + "']"));
    }

    /**
     * @param templateName
     * @author jatin.bisht This method fill mandatory fields for status change
     * template
     */
    public void fillMandatoryfieldForStatusChange(String templateName) {
        getElement(txtTemplateName).sendKeys(templateName);
        getElement(ddCategory).click();
        getElement(ddSelectCategory).click();
        getElement(txtSubject).sendKeys("this is subject status change");
        getElement(txtBody).sendKeys("this is body for status change");
    }

    /**
     * @param templateName
     * @author jatin.bisht This method fills mandatory fields for other templates
     */
    public void fillMandatoryfield(String templateName) {
        getElement(txtTemplateName).sendKeys(templateName);
        getElement(txtSubject).sendKeys("send a requirement");
        getElement(txtBody).sendKeys("this is body for send a requirement");
    }

    /**
     * @author jatin.bisht This method delete already created template
     */
    public void deleteTemplate() {
        getElement(lnkDelete).click();
        getElement(btnFinalDelete).click();
    }

    /**
     * @author jatin.bisht This method select multiple templates
     */
    public void selectTemplateBulk() {
        pageRefresh();
        wait.waitForPageToLoadCompletely();
        getElement(chktemplate1).click();
        getElement(chktemplate2).click();
    }

    /**
     * @author jatin.bisht This method click on bulk delete button
     */
    public void deleteTemplateBulk() {
        getElement(lnkBulkDelete).click();
        getElement(btnFinalBulkDelete).click();
    }

    /**
     * @author jatin.bisht This method fill new deatils after editing template
     */
    public void fillNewDetails() {
        getElement(txtSubject).sendKeys("Edit test case");
        getElement(txtBody).sendKeys("New body for status change after Edit ");

    }

    /**
     * @return
     * @author jatin.bisht This method verify all details are filled
     */
    public boolean verifyDetailFilled() {
        String subjectText = getElement(txtBody).getText();
        if (subjectText != "") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return
     * @author jatin.bisht This method verifies preview is visible
     */
    public boolean verifyMailpreview() {
        return isDisplayed(pMailPreview);
    }

    /**
     * @param searchTemplateName
     * @author jatin.bisht This method first search template in all then in coreect
     * template type
     */
    public void searchCorrectTemplate(String searchTemplateName) {
        wait.waitForPageToLoadCompletely();
        getElement(txtSearchBox).sendKeys(searchTemplateName);
        getElement(btnSearch).click();
        getElement(ddTemplateFilter).click();
        getElement(ddCorrectFilter).click();
    }

    /**
     * @param searchTemplateName
     * @author jatin.bisht This method verifes that template is visible under
     * correct template type
     */
    public boolean verifySearchCorrectTemplate(String searchTemplateName) {
        wait.waitForPageToLoadCompletely();
        return isDisplayed(By.xpath("//a[text()='" + searchTemplateName + "']"));
    }

    /**
     * @author jatin.bisht This method select wrong template type while searching
     */
    public void searchWrongTemplate() {
        getElement(ddTemplateFilter).click();
        getElement(ddWrongFilter).click();
    }

    /**
     * @param templateName
     * @author jatin.bisht This method prefills from existing template
     */
    public void prefillFromTemplate(String templateName) {
        getElement(txtMsgTemplateName).sendKeys(templateName);
        getElement(ddPrefillTemplate).click();
        getElement(ddSelectPrefillTemplate).click();

    }

    public void selectFinancialTemplateCategory(String templateCategory) {
        click(financialCategoryDD);
        wait.waitForPageToLoadCompletely();
        clickOnParticularCategory(templateCategory);
        wait.waitForPageToLoadCompletely();
    }

    public void changeFinancialTemplateCategory(String templateCategory) {
        click(financialSelectedCategoryDD);
        wait.waitForPageToLoadCompletely();
        clickOnParticularCategory(templateCategory);
        wait.waitForPageToLoadCompletely();
    }

    public void clickOnParticularCategory(String category) {
        click(By.xpath("//div[@class='select-list']//span[text()='" + category + "']"));
//        String sub = getTextFromSubjectField();
//        if (sub.isEmpty()) {
//            do {
//                sub = getTextFromSubjectField();
//            }
//            while (sub.isEmpty());
//        }
    }

    public String getTextFromSubjectField() {
        wait.waitForVisibilityOfElement(subjectTemplateTxt);
        wait.waitForValignWrapperToDisappear(10, 5);
        return getAttribute(subjectTemplateTxt, "value");
    }

    public void clearPreviousBodyAndFillNew(String body) {
        sendKeys(mailBodyTemplateTxt, body);
    }

    public String enterFinanceTemplateName(String templateName) {
        sendKeys(saveTemplateName, templateName);
        click(saveBtn);
        wait.waitForPageToLoadCompletely();
        return templateName;
    }

    public void clickOnPrefillFromTemplateDD() {
        click(prefilledDD);
        wait.waitForPageToLoadCompletely();
    }

    public void searchAndSelectExistingTemplate(String uniqueTemplateName) {
        click(searchFinancialTemplate);
        wait.waitForPageToLoadCompletely();
        click(By.xpath("//div[@class='select-list']//span[text()='" + uniqueTemplateName + "']"));
        wait.waitForPageToLoadCompletely();

//        click(existingTemplateDD);
    }

    public String getDefaultTextOfPrefillFromFinanceTemplate() {
        return getText(existingTemplateDD);
    }

    public void fillMandatoryfieldForFinancialTemplate(String templateName) {
        sendKeys(saveTemplateName, templateName);
        sendKeys(mailBodyTemplateTxt, "test mail body 123");
        sendKeys(txtMsgSubject, "Test subject 123");
    }

    public void saveFinancialTemplate() {
        click(saveBtn);
        wait.waitForPageToLoadCompletely();
    }

    public void closeMailPreview() {
        click(closePreview);
    }

    public String getValidationMessage() {
        return getText(mailErrorMessage);
    }

    public void clickOnShareTemplateBtn() {
        click(shareTmeplate);
    }

    public boolean verifyUnshareTextOnTemplate() {
        return flag = isDisplayed(unshareTextOnfirstTemplate);

    }

    public List<String> getCategoryList(String key) {
        List<String> categoryList = new ArrayList<String>();
        String[] category = ReadWritePropertyFile.getProperty(key, testDataFile).trim().split(",");
        for (String name : category)
            categoryList.add(name);
        System.out.println("CAtegory List  >>>" + categoryList);
        return categoryList;
    }

    public boolean VerifyAllCategory(List<String> expectedCategoryList) {
        List<String> actualCategoryList = new ArrayList<String>();
        wait.waitForVisibilityOfElement(selectCategory);
        click(selectCategory);
        String templateCategory = "//div[contains(@class,'react-select template-category')]//li";
        int categoryList = getElements(By.xpath(templateCategory)).size();
        for (int i = 1; i <= categoryList; i++) {
            String categoryName = "//div[contains(@class,'react-select template-category')]//li[" + i + "]";
            actualCategoryList.add(getText(By.xpath(categoryName)));
        }

        System.out.println("Actual Category List  >>>  " + actualCategoryList);
        Collections.sort(actualCategoryList);
        Collections.sort(expectedCategoryList);
        if (!actualCategoryList.equals(expectedCategoryList)) {
            flag = false;
        }
        return flag;
    }

    public void clickOnCategoryList() {
        click(selectCategory);
    }

    public boolean verifyCategoryTemplatesData() {
        String templateCategory = "//div[contains(@class,'react-select template-category')]//li";
        int categoryList = getElements(By.xpath(templateCategory)).size();
        for (int i = 1; i <= categoryList; i++) {
            if (i > 1)
                click(selectCategory);
            String categoryName = "//div[contains(@class,'react-select template-category')]//li[" + i + "]";
            String categoryValue = getText(By.xpath(categoryName)).trim().replace(" ", "_");
            click(By.xpath(categoryName));
            wait.waitForVisibilityOfElement(mailBodyContent);
            wait.hardWait(4);
            String bodyContent = getText(mailBody).replace("\n", "").replace("\r", "");
            String templateData = ReadWritePropertyFile.getProperty(categoryValue, testDataFile);
            String templateSubjectData = ReadWritePropertyFile.getProperty(categoryValue + "_subject", testDataFile);
            String subjectContent = getAttribute(subjectTemplate, "value");

            if (!subjectContent.equals(templateSubjectData) && !bodyContent.equals(templateData)) {
                System.out.println("Not equal data for Template "+ categoryValue);
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    public void clickOnAddNewTemplateBtn() {
		wait.waitForValignWrapperToDisappear(10, 3);
		click(eleAddNewTemplate);
	}

    public void chooseFinanceOption() {
		click(eleFinancialOption);
		click(eleNextBtn);
	}
    
	public void clearPreviousSubjAndFillNew(String subj)
	{
		while(!getTextFromSubjectField().isEmpty()) {
			click((subjectTemplateTxt));
			actionBuilderUtil.hardClear(getElement(subjectTemplateTxt));
		}
		sendKeys((subjectTemplateTxt), subj);
	}
	
	public String enterTemplateName(String templateName)
	{
		String randomName = GenericFunctions.generateRandomStrings(4, "Alphanumeric");
		this.uniqueTemplateName = templateName + randomName;
		getElement(saveTemplateName).clear();
		getElement(saveTemplateName).sendKeys(uniqueTemplateName);
		getElement(saveBtn).click();
		return uniqueTemplateName;
	}
	
	public boolean verifyFinanaceTemplateCreated(String createdTemplateName) {
		wait.waitForValignWrapperToDisappear(10,5);
		return (getText(firstTemplateName).equals(createdTemplateName));
	}
	
	/**
	 * To add the excel tracker in forward template
	 * @author rachit.mehrotra
	 * @param templateIndex
	 */
	public void selectExcelTrackerBasedOnIndexForTemplate(String templateIndex) {
		click(eleExcelTrackerList);
		click(parameterizedLocator(eleSelectTheTemplate, templateIndex.substring(0, 1)));
		PropFileHandler.writeProperty("excelTrackerName", jsUtil.executeJavascriptForJSVariables("document.getElementById('inp_prefillTemp').value"));
	}
}
