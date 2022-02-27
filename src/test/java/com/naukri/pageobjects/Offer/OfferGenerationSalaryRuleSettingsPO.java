package com.naukri.pageobjects.Offer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.groovy.vmplugin.v5.JUnit4Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;

/**
 * @author raunak.b
 *
 */
public class OfferGenerationSalaryRuleSettingsPO extends BaseAutomation {

    public static By uploadExcelSpreadsheet = By.xpath("//button[text()='Upload Salary Spreadsheet']");
    public static By salaryBreakupName = By.xpath("//input[@class='exl-lbl-inp ']");
    public static By cancelSalaryBreakupsBtn = By.xpath("//button[@id='cancel-salary-template-creation']");
    public static By nextSalaryBreakupsBtn = By.xpath("//button[@class='save blockBtn']");
    public static By ContinueConfirmationBtn = By.xpath("//button[@class='confBtn yes']");
    public static By SelectSheetDD = By.xpath("//input[@id='sheetSelect']");
    public static By selectSheet1 = By.xpath("//li[@value='aSheet1']");
    public static By coloumnDD = By.xpath("//input[@id='sheetCol']");
    public static By coloumnDDSize = By.xpath("//li[text()[contains(.,'Column')]]");
    public static By salaryBreakupContainer = By.xpath("//div[@class='salary-breakup-container']");
    public static By addInputBtn = By.xpath("//button[@class='sb-input-button']");
    public static By addNewLabel = By.xpath("//input[@placeholder='Enter Label']");
    public static By errorMsgOnInputScreen = By.xpath("//div[@class='ext-error-msg']");
    public static By fileSizeErrorOnUploadExcel = By.xpath("//span[@class='excel-upld-err']");
    public static By Exceluploaded = By.xpath("//span[@class='sheetName']");
    public static By LabelColoumnSize = By.xpath("//ul[@class='dropdown ']//li");
    public static By errorUploadValidFile = By.xpath("//div[@class='msg']");
    public static By labelTab = By.xpath("//div[@class='label-select']");
    public static By uploadExcelTab = By.xpath("(//span[@class='stepper  '])[1]");
    public static By changeBtnUploadExcel = By.xpath("//button[contains(text(),'Change')]");
    public static By inputTab = By.xpath("//span[text()='3. Define Inputs']");
    public static By addLabelWE = By.xpath("//span[text()='Add Label']");
    public static By skipLabelsScreenBtn = By.xpath("//button[contains(text(),'Skip')]");
    public static By cellRefWE = By.xpath("//input[@name='cellReference']");
    public static By updateBreakupBTn = By.xpath("//div[@class='ra-update-breakup-button']");
    public static By FetchFromSpreadsheetRBtn = By.xpath("//input[@id='spreadsheet-options']");
    public static By chooseSheetNameFetchFRomSpreadsheet = By.xpath("//div[@class='dropdownMainContainer']");
    public static By saveFetchFromSpreadsheet = By.xpath("//div[@class='rm-save-button']");
    public static By errorMsgValueRange = By.xpath("//div[@class='err-foot-msg-strip']");
    public static By listDDValuesOnReviewAndApprove = By.xpath("//ul[@class='dropdown ']//li");
    public static By addOptionManuallyTypeOption = By.xpath("//button[text()='Add Option']");
    public static By enterValueManuallytypeOptions = By.xpath("//input[@placeholder='Type Option']");
    public static By chooseFromLabelScreenByText = By.xpath("//li[text()='${string}']");
    public static By labelDefineInputs = By.xpath("//Table[@id='inputsTable']//tr[${string}]//td[1]//span");
    public static By sourceDefineInputs = By.xpath("//Table[@id='inputsTable']//tr[${string}]//td[2]//span");
    public static By enterDefaultValue = By.xpath("(//input[@class='txt-input'])[2]");
    public static By ValidationErrorOnReviewandApprove = By.xpath(
            "//label[contains(text(),'${string}')]/ancestor::div[@class='input-wrapper']//div[@class='ra-err-msg']");
    public static By ClickDefaultValueOnInputScreen = By.xpath("//span[text()='${string}']/ancestor::tr//td[4]");
    public static By singleChoiceDDValuesOnReview = By
            .xpath("//span[text()='${string}']//ancestor::div//span[@class='dropArrowDD']");
    public static By singleChoiceOnInputScreen = By.xpath("//span[text()='${string}']/ancestor::tr//td[3]//span");
    public static By deleteIconOnInputScreen = By
            .xpath("//span[text()='${string}']/ancestor::tr//div[@class='delete-icon di-icons-config custom']//img");
    public static By ByText = By.xpath("//span[text()='${string}']");
    public static By deleteSingleChoiceValues = By.xpath("//input[@value='${string}']/following-sibling::div");
    public static By DDvaluesOnUpdateAndReview = By.xpath("(//ul[@class='dropdown ']//li)[${string}]");
    public static By defaultValueText = By.xpath("//label[text()='${string}']/following-sibling::input");
    public static By RangeFillFromSpreadsheet = By.xpath("//div[@class='input-containers']//input[${string}]");
    public static By labelOnReviewAndApprove = By.xpath("//input[@placeholder='Enter ${string}']");

    public Map<String, String> InputFields = new HashMap<String, String>();
    public Map<String, String> ActualInputFields = new HashMap<String, String>();
    // JSUtility jsObject = new JSUtility(driver, wait);

    GenericFunctions generic = new GenericFunctions();

    // JavascriptExecutor js = (JavascriptExecutor) driver;
    /**
     * To upload excel sheet on salary breakup table
     */
    // public void clickUploadExcelSpreadsheet() {
    // wait.waitForPageToLoadCompletely();
    // getElement(uploadExcelSpreadsheet).click();
    // wait.hardWait(5000);
    // }
    /**@author raunak.b
     * To return file system path
     *
     * @return fileSystemPath
     */
    public static String fileSystemPath() {
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "testdata" + File.separator + "OfferManagement" + File.separator;
        return filePath;
    }

    /**@author raunak.b
     * To upload excel sheet on salary breakup table
     *
     * @param excelName
     */
    public void UploadExcelFromBreakups(String excelName) {
    	String filePath = fileSystemPath() + excelName;
		wait.waitForPageToLoadCompletely();
		wait.waitForVisibilityOfElement(By.id("uploadSalarySheet"));
		jsUtil.executeJavascript(
				"document.getElementById('uploadSalarySheet').setAttribute('style', 'display:block');");
		driver.findElement(By.id("uploadSalarySheet")).sendKeys(filePath);
	}

    /**@author raunak.b
     * To fill salary rule template name
     */
    public void fillSalaryRuleTemplateName() {
        String salaryBreakupRandomName = "testSalaryBreakup" + System.currentTimeMillis();
        ReadWritePropertyFile.setProperty("SalaryBreakupName", salaryBreakupRandomName,
                fileSystemPath() + "offerManagementSalaryBreakup.properties");
        sendKeys(salaryBreakupName, salaryBreakupRandomName);
    }

    /**@author raunak.b
     * click on cancel button on salary breakup
     */
    public void clickOnCancelButtonOnSalaryBreakup() {
        wait.waitForValignWrapperToDisappear(1113, 577);
        getElement(cancelSalaryBreakupsBtn).click();
        getElement(ContinueConfirmationBtn).click();
        wait.waitForPageToLoadCompletely();
    }

    /**@author raunak.b
     * click on next button on salary breakup
     */
    public void clickOnNextButtonOnSalaryBreakup() {
        getElement(nextSalaryBreakupsBtn).click();
        wait.waitForPageToLoadCompletely();
    }

    /**@author raunak.b
     * To choose label and sheet
     *
     * @param SheetName
     * @param Label
     */
    public void chooseLabelAndSheet(String SheetName, String Label) {
        wait.waitForPageToLoadCompletely();
        getElement(SelectSheetDD).click();
        getElement(chooseFromLabelScreenByText, SheetName).click();
        getElement(coloumnDD).click();
        getElement(chooseFromLabelScreenByText, Label).click();
    }

    /**@author raunak.b	
     * To check whether input table displayed is correct
     *
     * @return boolean
     */
    public boolean verifyInputTableForSampleInput() {
        InputFields.put("Offered Designation", "For Display Only");
        InputFields.put("Offered on", "For Display Only");
        InputFields.put("Candidate's tentative joining date", "For Display Only");
        InputFields.put("Label4", "Sheet1: B5");
        InputFields.put("Label1", "Sheet1: B2");
        for (int i = 1; i <= 5; i++) {
            ActualInputFields.put(getElement(labelDefineInputs, Integer.toString(i)).getText(),
                    getElement(sourceDefineInputs, Integer.toString(i)).getText());
        }
        return InputFields.equals(ActualInputFields);
    }

    /**@author raunak.b
     * To verify output screen is displayed
     *
     * @return boolean
     */
    public boolean verifyOutputScreenIsDisplayed() {
        return getElement(salaryBreakupContainer).isDisplayed();
    }

    /**@author raunak.b
     * click on add input btn
     */
    public void addInputClick() {
        getElement(addInputBtn).click();
    }

    /**@author raunak.b
     * To fill new label name
     *
     * @param LabelName
     */
    public void fillNewLabelName(String LabelName) {
        sendKeys(addNewLabel, LabelName);
    }

    /**@author raunak.b
     * To verify duplicate labels is not allowed
     *
     * @return string
     */
    public String verifyDuplicateLabelsNotAllowed() {
        return getText(errorMsgOnInputScreen);
    }

    /**@author raunak.b
     * To click on change btn on excel upload screen
     *
     * @param ExcelName
     */
    public void clickChangeBtnExcelUpload(String ExcelName) {
        UploadExcelFromBreakups(ExcelName);
    }

    /**@author raunak.b
     * To verify excel is uploaded correctly
     *
     * @param ExcelName
     * @return boolean
     */
    public boolean verifyExcelIsUploadedCorrectly(String ExcelName) {
        return getText(Exceluploaded).equals(ExcelName);
    }

    /**@author raunak.b
     * To verify error on file size upto 5 MB allowed
     *
     * @return boolean
     */
    public boolean verifyErrorFileSizeUpto5MbAllowed() {
        return getText(fileSizeErrorOnUploadExcel).equals("File size up to 5MB allowed");
    }

    /**@author raunak.b
     * To select sheet and click on labels DD
     *
     * @param sheetName
     */
    public void selectSheetAndClickOnLabelsDD(String sheetName) {
        getElement(SelectSheetDD).click();
        getElement(chooseFromLabelScreenByText, sheetName).click();
        getElement(coloumnDD).click();
    }

    /**@author raunak.b
     * To verify coloumns count
     *
     * @param sheetName
     * @param ExpectedColoumnSize
     * @return
     */
    public boolean verifyColoumnsCount(String sheetName, int ExpectedColoumnSize) {
        return getElements(LabelColoumnSize).size() == ExpectedColoumnSize;
    }

    /**@author raunak.b
     * To verify error to upload valid file
     *
     * @return boolean
     */
    public boolean verifyErrorToUploadValidFile() {
        return getText(errorUploadValidFile).equals("No formula cells present. Please upload a valid file.");
    }

    /**@author raunak.b
     * To verify labels tab is displayed
     *
     * @return boolean
     */
    public boolean labelsScreenDisplayed() {
        wait.waitForVisibilityOfElement(labelTab);
        return getElement(labelTab).isDisplayed();
    }

    /**@author raunak.b
     * To click on upload excel tab
     */
    public void clickOnUploadExcelTab() {
        getElement(uploadExcelTab).click();
    }

    /**@author raunak.b
     * To verify change btn visibilty
     *
     * @return boolean
     */
    public boolean changeBTnVisibility() {
        // return getElement(changeBtnUploadExcel).isDisplayed();
        return driver.findElements(changeBtnUploadExcel).size() > 0;
    }

    /**@author raunak.b
     * To check input screen displayed
     *
     * @return boolean
     */
    public boolean inputScreenDisplayed() {
        return getElement(inputTab).isDisplayed();
    }

    /**@author raunak.b
     * To click on skip on labels screen
     */
    public void clickOnSkipLabelsScreen() {
        getElement(skipLabelsScreenBtn).click();
        wait.waitForVisibilityOfElement(inputTab);
    }

    /**@author raunak.b
     * To verify labels identified
     *
     * @param countCellNotIdentified
     * @return boolean
     */
    public boolean verifyLabelsIdentified(int countCellNotIdentified) {
        return getElements(addLabelWE).size() == countCellNotIdentified;
    }

    /**@author raunak.b
     * To enter default values
     *
     * @param label
     * @param defaultValue
     */
    public void enterDefaultValue(String label, String defaultValue) {
        // click(By.xpath("//span[text()='" + label + "']/ancestor::tr//td[4]"));
        getElement(ClickDefaultValueOnInputScreen, label).click();
        sendKeys(enterDefaultValue, defaultValue);
    }

    /**@author raunak.b
     * To select any cell ref under CTC
     *
     * @param cellRef
     */
    public void selectAnyCellrefUnderCTC(String cellRef) {
        sendKeys(cellRefWE, cellRef);
        click(parameterizedLocator(ByText, cellRef));
    }

    /**@author raunak.b
     * To verify label has default value
     *
     * @param labelName
     * @param defaultValue
     * @return
     */
    public boolean verifyLabelHasDefaultValue(String labelName, String defaultValue) {
        return getElement(parameterizedLocator(defaultValueText, labelName)).getAttribute("value").equals(defaultValue);
    }

    /**@author raunak.b
     * To click on update breakup btn
     */
    public void clickOnUpdateBreakup() {
        getElement(updateBreakupBTn).click();
    }

    /**@author raunak.b
     * To verify all validation errors displayed
     *
     * @param label1
     * @param label2
     * @param label3
     * @param label4
     * @param label5
     * @return
     */
    public boolean verifyAllValidationErrors(String label1, String label2, String label3, String label4,
            String label5) {
        String ExpectedTextError = "This field is mandatory";
        String ExpectedDateError = "A valid date is required";
        String ActualDesignationTextError = getElement(ValidationErrorOnReviewandApprove, label1).getText();
        String ActualOfferedDateError = getElement(ValidationErrorOnReviewandApprove, label2).getText();
        String ActualJoiningDateError = getElement(ValidationErrorOnReviewandApprove, label3).getText();
        String ActualLabel1Error = getElement(ValidationErrorOnReviewandApprove, label4).getText();
        String ActualLabel2Error = getElement(ValidationErrorOnReviewandApprove, label5).getText();
        return ActualDesignationTextError.equals(ExpectedTextError) && ActualOfferedDateError.equals(ExpectedDateError)
                && ActualJoiningDateError.equals(ExpectedDateError) && ActualLabel1Error.equals(ExpectedTextError)
                && ActualLabel2Error.equals(ExpectedTextError);
    }

    /**@author raunak.b
     * To select input type
     *
     * @param label
     * @param inputType
     */
    public void selectInputType(String label, String inputType) {
        click(By.xpath("//input[@value='" + label + "']/ancestor::tr//td[3]"));
        click(By.xpath("//div[@data-option='" + inputType + "']"));
    }

    /**@author raunak.b
     * To click on choose from spreadsheet
     *
     * @param label
     */
    public void chooseFromSpreadsheet(String label) {
        click(By.xpath("//input[@value='" + label + "']/ancestor::tr//td[5]"));
        jsUtil.scrollDown(saveFetchFromSpreadsheet);
        jsUtil.clickByJS(FetchFromSpreadsheetRBtn);
        // jsObject.scrollDown(saveFetchFromSpreadsheet);
        // jsObject.clickByJS(FetchFromSpreadsheetRBtn);
    }

    /**@author raunak.b
     * To select sheet from fetch from spreadsheet option
     *
     * @param sheet
     */
    public void selectSheet(String sheet) {
        click(chooseSheetNameFetchFRomSpreadsheet);
        getElement(chooseFromLabelScreenByText, sheet).click();

    }

    /**@author raunak.b
     * To enter range of values in fill from spreadsheet
     *
     * @param startRange
     * @param endRange
     */
    public void enterRangeOfValuesInFillFromSpreadsheet(String startRange, String endRange) {
        int startRangeFillFromSpreadsheet = 1;
        int endRangeFillFromSPreadsheet = 2;
        sendKeys(parameterizedLocator(RangeFillFromSpreadsheet, Integer.toString(startRangeFillFromSpreadsheet)),
                startRange);
        sendKeys(parameterizedLocator(RangeFillFromSpreadsheet, Integer.toString(endRangeFillFromSPreadsheet)),
                endRange);
    }

    /**@author raunak.b
     * To click on save from fetch from spreadsheet
     */
    public void clickSaveFetchFromSpreadsheet() {
        click(saveFetchFromSpreadsheet);
    }

    /**@author raunak.b
     * To check whether value range is displayed correctly
     *
     * @param labelName
     * @param valueRange
     * @return boolean
     */
    public boolean valueRangeDisplayedCorrectly(String labelName, String valueRange) {
        return getText(By.xpath("(//input[@value='" + labelName + "']/ancestor::tr//span)[5]")).equals(valueRange);
    }

    /**@author raunak.b
     * To verify error displayed on entering invalid range
     *
     * @return boolean
     */
    public boolean verifyErrorDisplayedOnInValidRange() {
        return getText(errorMsgValueRange).contains("A valid value range is required");
    }

    /**@author raunak.b
     * To verify single choice values
     *
     * @param label
     * @param option1
     * @param option2
     * @param option3
     * @return boolean
     */
    public boolean verifySingleChoiceValues(String label, List<String> list) {
    	ArrayList<String> ExpectedListOfElements = new ArrayList<String>();
    	wait.waitForPageToLoadCompletely();
    	jsUtil.scrollDown(By.xpath("//span[text()='"+label+"']"));
      //  jsUtil.scrollDown(parameterizedLocator(singleChoiceDDValuesOnReview, label));
        click(parameterizedLocator(singleChoiceDDValuesOnReview, label));
        wait.hardWait(1);
        List<WebElement> listSizeSingleChoiceDD = getElements(listDDValuesOnReviewAndApprove);
        for (WebElement element : listSizeSingleChoiceDD) {
            ExpectedListOfElements.add(getText(element));
        }
//        ArrayList<String> ActualListOfElements = new ArrayList<>(Arrays.asList(option1, option2, option3));
        TestNGLogUtility.info("Expected : " + list);
        TestNGLogUtility.info("Actual : " + ExpectedListOfElements);
        System.out.println("Expected : " + list);
        System.out.println("Actual : " + ExpectedListOfElements);
        return list.equals(ExpectedListOfElements);
    }

    /**@author raunak.b
     * To add values under manually type options
     *
     * @param value1
     * @param value2
     * @param value3
     * @param label
     */
    public void addValuesUnderManuallyTypeOptions(String value1, String value2, String value3, String label) {
        click(By.xpath("//input[@value='" + label + "']/ancestor::tr//td[5]"));
        for (int i = 1; i <= 3; i++) {
            click(addOptionManuallyTypeOption);
            sendKeys(By.xpath("(//input[@placeholder='Type Option'])[" + i + "]"), "value" + i);
            jsUtil.scrollDown(addOptionManuallyTypeOption);
        }
    }

    /**@author raunak.b
     * To delete value from manually type option
     *
     * @param value
     */
    public void deleteValueFromManuallyTypeOption(String value) {
        getElement(deleteSingleChoiceValues, value).click();
    }

    /**@author raunak.b
     * To verify single choice values after deleting one value
     *
     * @param label
     * @param option1
     * @param option2
     * @return
     */
    public boolean verifySingleChoiceValuesAfterDeletingOneValue(String label, List<String> list) {
        //jsUtil.scrollDown(parameterizedLocator(singleChoiceDDValuesOnReview, label));
    	ArrayList<String> ExpectedListOfElementsAfterDeleting = new ArrayList<String>();
    	wait.waitForPageToLoadCompletely();
    	jsUtil.scrollDown(By.xpath("//span[text()='"+label+"']"));
        click(parameterizedLocator(singleChoiceDDValuesOnReview, label));
        wait.hardWait(1);
        List<WebElement> listSizeSingleChoiceDD = getElements(listDDValuesOnReviewAndApprove);
        for (WebElement element: listSizeSingleChoiceDD) {
            ExpectedListOfElementsAfterDeleting
                    .add(getText(element));
        }
//        ArrayList<String> ActualListOfElements = new ArrayList<>(Arrays.asList(option1, option2));
        TestNGLogUtility.info("Expected : " + list);
        TestNGLogUtility.info("Actual : " + ExpectedListOfElementsAfterDeleting);
        System.out.println("Expected : " + list);
        System.out.println("Actual : " + ExpectedListOfElementsAfterDeleting);
        return list.equals(ExpectedListOfElementsAfterDeleting);
    }

    /**@author raunak.b
     * click on input tab
     */
    public void clickOnInputTab() {
        getElement(inputTab).click();
    }

    /**@author raunak.b
     * label displayed correct or not
     *
     * @param labelName
     *
     */
    public boolean verifyLabelisNotDisplayed(String labelName) {
        return generic.checkInvisibilityOfElement(parameterizedLocator(ByText, labelName));
    }

    /**@author raunak.b
     * delete row on input screen
     *
     * @param labelName
     *
     */
    public void deleteRowWithLabel(String labelName) {
        jsUtil.executeJavascript(
        		"let e=document.getElementsByClassName('delete-icon di-icons-config custom'); $.each(e, function(){this.style.display='block';})");
        wait.hardWait(1);
        click(parameterizedLocator(deleteIconOnInputScreen, labelName));
    }

    /**@author raunak.b
     * verify single choice detected on input screen
     *
     * @param labelName
     * @return
     */
    public boolean verifySingleChoiceDetectedOnInputScreen(String labelName) {
        return getText(parameterizedLocator(singleChoiceOnInputScreen, labelName)).equals("Single Choice");
    }

    /**@author raunak.b
     * verify null values not supported by vlookup
     *
     * @param msg
     * @return
     */
    public boolean verifyVlookupErrorDisplayedNullValuesPresent(String msg) {
        return getText(errorUploadValidFile).equals(msg);
    }

    /**@author raunak.b
     * enter Text Under Label
     *
     * @param text
     * @param label
     */
    public void enterTextUnderLabel(String text, String label) {
        sendKeys(parameterizedLocator(labelOnReviewAndApprove, label), text);
    }

    /**@author raunak.b
     * verify Only Numeric Value Allowed
     *
     * @param labelName
     * @return
     */
    public String verifyOnlyNumericValueAllowed(String labelName) {
        return getElement(ValidationErrorOnReviewandApprove, labelName).getText();
    }

    /**@author raunak.b
     * verify Null Cell Error Vlookup Displayed On Input Screen
     *
     * @return
     */
    public String verifyNullCellErrorVlookupDisplayedOnInputScreen() {
        return getText(errorUploadValidFile);
    }
}
