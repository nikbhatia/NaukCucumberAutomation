package com.naukri.pageobjects.Billing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naukri.automation.util.BillingAPI;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.WaitUtility;
import com.naukri.test.base.PageObjectWrapper;

import scala.annotation.meta.param;

public class BillingDashboardPagePO extends PageObjectWrapper {

    private By searchEmployerDD = By.xpath("//div[@class='dd-button']");
    private By searchTextBox = By.xpath("//div[@class='search-box']/input");
    By eleBillingDashboardOnGNB = By.xpath("//span[contains(text(),\"Invoices\")]");
    By eleLayerOverTop = By.xpath("//span[@class='stepper  disable']");
    By eleListWrapper = By.xpath("//div[contains(@class, 'secondary-actions-list-wrapper')]");
    By eleOptionButton = By.xpath("//span[text()= '${candidateName}']//ancestor::div[contains(@class , \"bi-tuple\")]//button[contains(text(),'${option}')]");
    By eleCandidateNameLocator = By.xpath("//span[contains(text(),'${candidateName}')]");
    By eleSecondaryActionsLocator = By.xpath("//span[text()='${candidateName}']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions']");
    By eleSecondaryActionsOption = By.xpath("//span[text()='${candidateName}']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions']//div[contains(text(),'${optionString}')]");

    GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);

    private HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    private HashMap<String, ArrayList<String>> mapHoverDetails = new HashMap<String, ArrayList<String>>();
    
    private ArrayList<String> NOT_GENERATED_TO_BE_GENERATED_PROFORMA_INVOICE_FALSE = new ArrayList<>(
			Arrays.asList("Generate Invoice", "Cancel", "View Candidate Details"));
	private ArrayList<String> NOT_GENERATED_TO_BE_GENERATED_PROFORMA_INVOICE_TRUE = new ArrayList<>(
			Arrays.asList("Edit Proforma Invoice", "Mail Proforma Invoice", "Download Proforma Invoice",
					"Print Proforma Invoice", "Cancel", "View Candidate Details"));
	private ArrayList<String> PARTIALLY_PAID_OUTSTANDING_PAYMENT_RECEIPT_TRUE = new ArrayList<>(Arrays
			.asList("Writeoff", "Refund/Issue credit note", "Mail", "Download", "Print", "View Candidate Details"));
	private ArrayList<String> UNPAID_OUTSTANDING_PAYMENT_RECEIPT_FALSE = new ArrayList<>(
			Arrays.asList("Writeoff", "Mail", "Download", "Print", "View Candidate Details"));
	private ArrayList<String> CANDIDATE_NAME_TO_BE_GENERATED = new ArrayList<>(
			Arrays.asList("Offered By", "Joining On", "For Requirement"));
	private ArrayList<String> CANDIDATE_NAME_OUTSTANDING = new ArrayList<>(
			Arrays.asList("Joining Salary", "Joining On", "For Requirement", "Offered On", "Offered By"));
	private ArrayList<String> BALANCE_TO_BE_PAID = new ArrayList<>(
			Arrays.asList("Total amount payable", "Amount paid", "Amount refunded"));
	private ArrayList<String> CANDIDATE_NAME_PAID = new ArrayList<>(
			Arrays.asList("Joining Salary", "Joining On", "For Requirement", "Offered On", "Offered By"));
	private ArrayList<String> AMOUNT_PAID_PAID = new ArrayList<>(
			Arrays.asList("Total amount payable", "Amount paid", "Amount refunded"));
	private ArrayList<String> CANDIDATE_NAME_REFUNDED = new ArrayList<>(Arrays.asList("Offered By", "For Requirement"));
	private ArrayList<String> AMOUNT_REFUNDED_REFUNDED = new ArrayList<>(
			Arrays.asList("Total amount payable", "Amount paid", "Amount refunded"));
	private ArrayList<String> CANDIDATE_NAME_WRITTEN_OFF = new ArrayList<>(
			Arrays.asList("Offered By", "For Requirement"));
	private ArrayList<String> AMOUNT_WRITTEN_OFF_WRITTEN_OFF = new ArrayList<>(
			Arrays.asList("Total amount payable", "Amount written off"));
	private ArrayList<String> PAYMENT_METHODS_PAID = new ArrayList<>(
			Arrays.asList("Cheque", "Online Transfer", "Cash", "Others"));
	private ArrayList<String> REFUNDED_REFUNDED_PAYMENT_RECEIPT_TRUE = new ArrayList<>(
			Arrays.asList("Mail", "Download", "Print", "View Candidate Details"));
	private ArrayList<String> REFUNDED_REFUNDED_PAYMENT_RECEIPT_MAIL_TRUE = new ArrayList<>(
			Arrays.asList("Invoice", "Payment Receipt", "Refund"));
	private ArrayList<String> REFUNDED_REFUNDED_PAYMENT_RECEIPT_DOWNLOAD_TRUE = new ArrayList<>(
			Arrays.asList("Invoice", "Payment Receipt"));
	private ArrayList<String> REFUNDED_REFUNDED_PAYMENT_RECEIPT_PRINT_TRUE = new ArrayList<>(
			Arrays.asList("Invoice", "Payment Receipt"));
	public BillingDashboardPagePO() {
		map.put("NOT_GENERATED_TO_BE_GENERATED_PROFORMA_INVOICE_FALSE",
				NOT_GENERATED_TO_BE_GENERATED_PROFORMA_INVOICE_FALSE);
		map.put("NOT_GENERATED_TO_BE_GENERATED_PROFORMA_INVOICE_TRUE",
				NOT_GENERATED_TO_BE_GENERATED_PROFORMA_INVOICE_TRUE);
		map.put("PARTIALLY_PAID_OUTSTANDING_PAYMENT_RECEIPT_TRUE", PARTIALLY_PAID_OUTSTANDING_PAYMENT_RECEIPT_TRUE);
		map.put("UNPAID_OUTSTANDING_PAYMENT_RECEIPT_FALSE", UNPAID_OUTSTANDING_PAYMENT_RECEIPT_FALSE);
		map.put("REFUNDED_REFUNDED_PAYMENT_RECEIPT_TRUE", REFUNDED_REFUNDED_PAYMENT_RECEIPT_TRUE);
		map.put("REFUNDED_REFUNDED_PAYMENT_RECEIPT_MAIL_TRUE", REFUNDED_REFUNDED_PAYMENT_RECEIPT_MAIL_TRUE);
		map.put("REFUNDED_REFUNDED_PAYMENT_RECEIPT_DOWNLOAD_TRUE", REFUNDED_REFUNDED_PAYMENT_RECEIPT_DOWNLOAD_TRUE);
		map.put("REFUNDED_REFUNDED_PAYMENT_RECEIPT_PRINT_TRUE", REFUNDED_REFUNDED_PAYMENT_RECEIPT_PRINT_TRUE);
		mapHoverDetails.put("CANDIDATE_NAME_TO_BE_GENERATED", CANDIDATE_NAME_TO_BE_GENERATED);
		mapHoverDetails.put("CANDIDATE_NAME_OUTSTANDING", CANDIDATE_NAME_OUTSTANDING);
		mapHoverDetails.put("BALANCE_TO_BE_PAID", BALANCE_TO_BE_PAID);
		mapHoverDetails.put("CANDIDATE_NAME_PAID", CANDIDATE_NAME_PAID);
		mapHoverDetails.put("AMOUNT_PAID_PAID", AMOUNT_PAID_PAID);
		mapHoverDetails.put("CANDIDATE_NAME_REFUNDED", CANDIDATE_NAME_REFUNDED);
		mapHoverDetails.put("AMOUNT_REFUNDED_REFUNDED", AMOUNT_REFUNDED_REFUNDED);
		mapHoverDetails.put("CANDIDATE_NAME_WRITTEN_OFF", CANDIDATE_NAME_WRITTEN_OFF);
		mapHoverDetails.put("AMOUNT_WRITTEN_OFF_WRITTEN_OFF", AMOUNT_WRITTEN_OFF_WRITTEN_OFF);
		// mapHoverDetails.put("REFUNDED_REFUNDED_PAYMENT_RECEIPT_TRUE",
		// REFUNDED_REFUNDED_PAYMENT_RECEIPT_TRUE);
	}

    
    public boolean visibilityOfFooterLinks(String candidateName, String linkText) {
        return isDisplayed(By.xpath("//span[text()='" + candidateName
                + "']//ancestor::div[@class='tuple-main']/following-sibling::div//span[@class='attachment' and text()='"
                + linkText + "']"));
    }

    public boolean verifyTabIsActive(String tabName) {
        return isDisplayed(By.xpath("//div[contains(@class,\"tab active\")]/a[contains(text(),\"" + tabName + "\")]"));
    }

    public void clickOnTab(String tabName) {
        if (!verifyTabIsActive(tabName)) {
            wait.waitForValignWrapperToDisappear(10, 3);
            click(By.xpath("//div[@class=\"tab\"]/a[contains(text(),\"" + tabName + "\")]"));
            wait.waitForValignWrapperToDisappear(10, 3);
        } else {
            wait.waitForValignWrapperToDisappear(10, 3);
        }
    }

    public void clickOnButtonOnBillingdashboard(String candidateName, String optionName) {
        wait.waitForVisibilityOfElement(By.xpath("//span[text()= \"" + candidateName + "\"]//ancestor::div[contains(@class , \"bi-tuple\")]//*[contains(text(),\"" + optionName + "\")]"));
        wait.waitForValignWrapperToDisappear(10, 5);
        wait.waitForInvisibilityOfElement(10, 7, eleListWrapper);
        click(By.xpath("//span[text()= \"" + candidateName+ "\"]//ancestor::div[contains(@class , \"bi-tuple\")]//*[contains(text(),\"" + optionName + "\")]"));
        wait.waitForValignWrapperToDisappear(10, 5);
    }

    public String getCommunicationMessageAfterTheMovementOfCandidateAcrossTuple(String candidateName) {
        return getText(By.xpath("//div[@class = 'bi-moved-tuple']"));
    }

    public void clickOnOptionsInMoreOptions(String candidateName, String option) {
    	wait.waitForVisibilityOfElement(parameterizedLocator(eleSecondaryActionsLocator, candidateName));
    	TestNGLogUtility.info("candidate name " + candidateName +  " option " + option);
//    	jsUtil.scrollDown(parameterizedLocator(eleSecondaryActionsLocator, candidateName));
        hover(parameterizedLocator(eleSecondaryActionsLocator, candidateName));
        wait.waitForVisibilityOfElement(parameterizedLocator(eleSecondaryActionsOption, candidateName, option));
        TestNGLogUtility.info("check " + isDisplayed(parameterizedLocator(eleSecondaryActionsOption, candidateName,option)));
        click(parameterizedLocator(eleSecondaryActionsOption, candidateName, option));
        wait.waitForPageToLoadCompletely();
    }

    public String getOfferedCandidateDetail(String candidateName, String labelName) {
        String value;
        if (labelName.contains("Offered By") || labelName.contains("For Requirement")) {
            // scrollDown(getLocator("//div[text()=\"" + candidateName + "\"]"));
            hover(By.xpath("//span[text()=\"" + candidateName + "\"]"));
            value = getText(By.xpath("(//span[text()=\"" + candidateName
                    + "\"]/ancestor::div[contains(@class,'bi-tuple')]//*[contains(text(),\"" + labelName
                    + "\")]/following-sibling::*)[1]"));
        } else {
            value = getText(By.xpath("(//span[text()=\"" + candidateName
                    + "\"]/ancestor::div[contains(@class,'bi-tuple')]//*[contains(text(),\"" + labelName
                    + "\")]/following-sibling::*)[1]"));
            if (value.contains("₹") || value.contains(",")) {
                int firstSpace = 0;
                int secondSpace = value.length();
                if (value.indexOf(" ") >= 0) {
                    firstSpace = value.indexOf(" ");
                    if (value.lastIndexOf(" ") == value.indexOf(" ")) {
                        secondSpace = value.length();
                    } else {
                        secondSpace = value.indexOf(" ", firstSpace + 1);
                    }
                }
                value = value.substring(firstSpace, secondSpace).replaceAll(",", "").replaceAll(" ", "");
            }
        }
        return value;
    }

    public List<String> getMoreOptionsList(String candidateName) {
        hover(By.xpath("//span[text()='" + candidateName
                + "']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions']"));
        List<WebElement> we = getElements(By.xpath("//span[text()='" + candidateName
                + "']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions-list']/div"));
        List<String> listOfOptions = new ArrayList<>();
        for (WebElement webElement : we) {
            listOfOptions.add(getText(webElement));
        }
        return listOfOptions;
    }

    public boolean visibilityOfAllOptionsUnderMoreOptions(String tagName, String tabName, String linkText) {
        boolean visibility = true;
        try {
            wait.resetImplicitTimeout(1);
            WebDriverWait waits = new WebDriverWait(driver, 1);
            //waits.withTimeout(Duration.ofSeconds(1))
            waits.withTimeout(1, TimeUnit.SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"
                            + BillingAPI.candidateName
                            + "']//ancestor::div[@class='tuple-main']/following-sibling::div//span[@class='attachment' and text()='"
                            + linkText + "']")));
            wait.resetImplicitTimeout(60);
        } catch (Exception e) {
            visibility = false;
        }
        String arrayListName = tagName + " " + tabName + " " + linkText + " " + Boolean.toString(visibility);
        arrayListName = arrayListName.replaceAll(" ", "_").toUpperCase();
        if (map.containsKey(arrayListName)) {
            List<String> innerValue = map.get(arrayListName);
            List<String> listOfOptions = getMoreOptionsList(BillingAPI.candidateName);
            int i = 0;
            for (String str : innerValue) {
                if (!str.equalsIgnoreCase(listOfOptions.get(i))) {
                    return false;
                }
                i++;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyInfoUnderBillingcategoryDD(String billingValue) {
        WebElement elem;
        try {
            wait.resetImplicitTimeout(1);
            wait.waitForVisibilityOfElement(By.xpath("//div[@class='rateSelectionSec']//*[contains(text(),\""
                    + billingValue + "% of billable salary\") or contains(text(),\"Flat rate of " + billingValue
                    + "\")]"));
            elem = driver.findElement(By.xpath("//div[@class='rateSelectionSec']//*[contains(text(),\""
                    + billingValue + "% of billable salary\") or contains(text(),\"Flat rate of " + billingValue
                    + "\")]"));
        } catch (TimeoutException e) {
            wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
            return false;
        } catch (NoSuchElementException no) {
        	 wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
             return false;
        }
        wait.resetImplicitTimeout(WaitUtility.defaultImplicitTimeout);
        return elem.isDisplayed();
    }

    public String goToDDValueInViewContainer(String labelName, String value) {
        return "//div[@class='viewContainer']//*[contains(text(),\"" + labelName
                + "\")]/..//child::li//*[contains(text(),\"" + value + "\")]";
    }

    public boolean valueInDDInViewContainerIsDisplayed(String ddLabel, String value) {
        return isDisplayed(By.xpath(goToDDValueInViewContainer(ddLabel, value)));
    }

    public String getCurrentStatus(String candidateName) {
        return getText(By.xpath("//span[text()='" + candidateName
                + "']//ancestor::div[@class='tuple-main']/following-sibling::div//div[contains(@class,'status-tag')]"));
    }

    public String selectEmployerFromSearchEmployerDD(String employerName) {
        wait.waitForValignWrapperToDisappear(20, 5);
        clickOnSearchEmployerDD();
        wait.waitForValignWrapperToDisappear(20, 5);
        fillEmployerInSearchBox(employerName);
        clickOnEmployerInSearchEmployerDD(employerName);
        return employerName;
    }

    public void clickOnSearchEmployerDD() {
        wait.waitForValignWrapperToDisappear(10, 3);
        click(searchEmployerDD);
    }

    public void fillEmployerInSearchBox(String employerName) {
        wait.waitForVisibilityOfElement(searchTextBox);
        wait.waitForValignWrapperToDisappear(10, 5);
        driver.findElement(searchTextBox).clear();
        wait.waitForValignWrapperToDisappear(10, 5);
        sendKeys(searchTextBox, employerName);
        wait.waitForValignWrapperToDisappear(10, 5);
    }

    public void clickOnEmployerInSearchEmployerDD(String employerName) {
        wait.waitForValignWrapperToDisappear(20, 5);
        wait.waitForVisibilityOfElement(By.xpath("//div[@title=\"" + employerName + "\"]"));
        wait.waitForValignWrapperToDisappear(20, 5);
        click(By.xpath("//div[@title=\"" + employerName + "\"]"));
        wait.waitForValignWrapperToDisappear(20, 5);
    }

    public String warningMessageFromToBeGenerated(String candidateName) {
        boolean presence = isDisplayed(By.xpath("//span[text()= \"" + candidateName
                + "\"]//ancestor::div[contains(@class , \"bi-tuple\")]/div[@class= \"message-strip\" ]"));
        if (presence) {
            return getText(By.xpath("//span[text()= \"" + candidateName
                    + "\"]//ancestor::div[contains(@class , \"bi-tuple\")]/div[@class= \"message-strip\" ]"));
        } else {
            return "";
        }
    }

    public boolean moreOptionsOnHoverNotToBeVisible(String candidateName) {
        wait.resetImplicitTimeout(2);
        try {
            wait.waitForVisibilityOfElement(By.xpath("(//div[text()='" + candidateName
                    + "']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions-list']/div)[1]"));
        } catch (TimeoutException e) {
            return true;
        }
        wait.resetImplicitTimeout(60);
        return false;
    }

    public boolean verifyCandidateDownloadVisibleOnDashboard(String candidateName, String downloadOption) {
        return isDisplayed(By.xpath("//span[text()='" + candidateName
                + "']/ancestor::div[contains(@class,'bi-tuple')]//span[text()='" + downloadOption + "']"));
    }

    public boolean verifyHiringForDetailVisible(Map<String, String> offeredCandidateDetails, String candidateName) {
        String ActualHiringFor = offeredCandidateDetails.get("HIRING_FOR");
        String ExpectedhiringFor = getText(By.xpath("//span[text()='"+candidateName+"']/ancestor::div[contains(@class,'bi-tuple')]//span[text()='Hiring for ']/following-sibling::span"));

        if (ActualHiringFor.contains(ExpectedhiringFor)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyCandidateTagsVisibleOnDashboard(String candidateName, String TagName) {
        return isDisplayed(By.xpath("//span[text()='" + candidateName
                + "']/ancestor::div[contains(@class,'bi-tuple')]//div[text()='" + TagName + "']"));
    }

    public boolean verifyButtonText(String candidateName, String buttonTxt) {
        return isDisplayed(By.xpath("//span[text()='" + candidateName
                + "']/ancestor::div[contains(@class,'bi-tuple')]//button[text()='" + buttonTxt + "']"));
    }

    public boolean checkThePresenceOfCandidateName(String candidateName) {
    	TestNGLogUtility.info("candidate Name " + candidateName);
        boolean flag = true;
        flag = isDisplayed(By.xpath("//span[text()='" + candidateName + "' ]"));
        return flag;
    }

    public void clickOnLinkOnFooter(String candidateName, String attachment) {
        wait.waitForVisibilityOfElement(By.xpath("//span[text()='" + candidateName
                + "']//ancestor::div[@class='tuple-main']/following-sibling::div//span[@class='attachment' and text()='"
                + attachment + "']"));
        wait.waitForValignWrapperToDisappear(10, 5);
        driver.findElement(By.xpath("//span[text()='" + candidateName
                + "']//ancestor::div[@class='tuple-main']/following-sibling::div//span[@class='attachment' and text()='"
                + attachment + "']")).click();
        wait.waitForValignWrapperToDisappear(10, 5);
    }

    public boolean verifyOptionsOnHover(String labelName, String tabName, Map<String, String> candidateDetails) {
        HashMap<String, String> amountDetails = new HashMap<String, String>();
        driver.navigate().refresh();
        if (!verifyTabIsActive(tabName)) {
            clickOnTab(tabName);
            wait.waitForPageToLoadCompletely();
        }
        hover(By.xpath("//div[@class='wrapper']//span[contains(text(),'" + labelName + "')]"));
        int size = getElements(By.xpath("(//div[@class='payment-amount-wrapper']//div[contains(@class,'row')])")).size();

        for (int i = 1; i <= size; i++) {
            String key = getText(By.xpath(
                    "(//div[@class='payment-amount-wrapper']//div[contains(@class,'row')])[" + i + "]//span[1]"));
            String value = getText(By.xpath(
                    "(//div[@class='payment-amount-wrapper']//div[contains(@class,'row')])[" + i + "]//span[2]"))
                    .replaceAll("[^0-9]", "");
            amountDetails.put(key, value);
        }
        System.out.println(amountDetails);
        if (candidateDetails.equals(amountDetails))
            return true;
        else {
            return false;
        }

    }

    public String getInvoiceNumberFromTuple(String candidateName) {
        return getText(By.xpath("//div[@class='tabs-content-wrapper']//span[text()='" + candidateName
                + "']/preceding-sibling::span[contains(@class,'label-key')]"));
    }

    public boolean visibilityOfAllOptionsUnderMoreOptionsWithList(String linkText, ArrayList<String> arrayList) {
        boolean visibility = true, flag = true;
        try {
            wait.resetImplicitTimeout(1);
            WebDriverWait waits = new WebDriverWait(driver, 1);
            //waits.withTimeout(Duration.ofSeconds(1))
            waits.withTimeout(1,TimeUnit.SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"
                            + BillingAPI.candidateName
                            + "']//ancestor::div[@class='tuple-main']/following-sibling::div//span[@class='attachment' and text()='"
                            + linkText + "']")));
            wait.resetImplicitTimeout(60);
        } catch (Exception e) {
            visibility = false;
        }
        List<String> listOfOptions = getMoreOptionsList(BillingAPI.candidateName);
        int i = 0;
        for (String str : arrayList) {
            if (!str.equalsIgnoreCase(listOfOptions.get(i))) {
                flag = false;
                return flag;
            }
            i++;
        }
        return flag;
    }

    public void clickStatusStrip() {
        wait.waitForVisibilityOfElement(By.xpath("//a[@class='move-tuple-link']"));
        wait.waitForValignWrapperToDisappear(10, 3);
        click(By.xpath("//a[@class='move-tuple-link']"));
    }

    public boolean statusChangedToRefunded(String candidateName, String invoiceName) {
        String StripData = getText(driver.findElement(By.xpath("//div[@class='bi-moved-tuple']")));
        String StatusStripText = StripData.replaceAll("\n", "\b").replaceAll("\b", " ");
        return StatusStripText
                .contains("Invoice No: " + invoiceName + " is now in Refunded tab. Dismiss");
    }

    private Map<String, String> getCandidateAllDetailsOnHoverViaLabelName(String candidateName, String labelName,
                                                                          String tabName) {
        Map<String, String> details = new HashMap<String, String>();
        // clickOnTab(tabName);
        driver.navigate().refresh();
        wait.waitForValignWrapperToDisappear(10, 3);
        if (!verifyTabIsActive(tabName)) {
            clickOnTab(tabName);

            wait.waitForValignWrapperToDisappear(10, 2);
        }
        wait.waitForValignWrapperToDisappear(10, 3);
        hover(By.xpath("(//span[text()=\"" + candidateName
                + "\"]/ancestor::div[contains(@class,'bi-tuple')]//*[contains(text(),\"" + labelName
                + "\")]/following-sibling::*)[1]"));
        int size = getElements(By.xpath("//div[@class='tabs-content-wrapper']//span[text()=\"" + candidateName
                + "\"]/../../div//*[contains(text(),\"" + labelName + "\")]/following-sibling::div//span[2]")).size();
        for (int i = 1; i <= size; i++) {
            String key = getText(By.xpath("(//div[@class='tabs-content-wrapper']//span[text()=\"" + candidateName
                    + "\"]/../../div//*[contains(text(),\"" + labelName + "\")]/following-sibling::div//span[1])[" + i
                    + "]"));
            key = key.replaceAll(" ", "_").replaceAll(":", "").toUpperCase();
            String value = getText(By.xpath("(//div[@class='tabs-content-wrapper']//span[text()=\"" + candidateName
                    + "\"]/../../div//*[contains(text(),\"" + labelName + "\")]/following-sibling::div//span[2])[" + i
                    + "]"));
            if (value.contains("₹")) {
                value = value.replaceAll("[^0-9]", "");
            }
            details.put(key, value);
        }
        return details;
    }

    public boolean verifyListOfOptionsOnHover(String labelName, String tabName,
                                              Map<String, String> offeredCandidateDetails) {

        // output
        Map<String, String> getCandidateAllDetailsOnHoverViaLabelName = getCandidateAllDetailsOnHoverViaLabelName(
                BillingAPI.candidateName, labelName, tabName);
        // input
        Map<String, String> getCandidateActualDetailsFromViewApplicationDetailPageObject = offeredCandidateDetails;
        if (labelName.startsWith("Candidate") || labelName.startsWith("IN")) {
            labelName = "Candidate Name";
        }
        String hoverArrayList = labelName + " " + tabName;
        hoverArrayList = hoverArrayList.replaceAll(" ", "_").toUpperCase();
        if (mapHoverDetails.containsKey(hoverArrayList)) {
            // static list
            List<String> getLabelKeys = mapHoverDetails.get(hoverArrayList);
            for (String str : getLabelKeys) {
                str = str.replaceAll(" ", "_").toUpperCase();
                if (getCandidateActualDetailsFromViewApplicationDetailPageObject.containsKey(str)) {
                    String strTest = getCandidateActualDetailsFromViewApplicationDetailPageObject.get(str);
                    getCandidateAllDetailsOnHoverViaLabelName.containsKey(str);
                    if (!getCandidateAllDetailsOnHoverViaLabelName.get(str).contains(strTest)) {
                        return false;
                    }

                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public void hoverOnElement(String candidateName) {
        hover(By.xpath("//span[text()='" + candidateName
                + "']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions']"));
    }

    public void clickOnTabAfterRefresh(String tabName) {
        driver.navigate().refresh();
        wait.waitForValignWrapperToDisappear(10, 3);
        if (!verifyTabIsActive(tabName)) {
            clickOnTab(tabName);

            wait.waitForValignWrapperToDisappear(10, 2);
        }
    }
    public List<String> getMoreSubOptionsList(String candidateName, String option) {
        String lowerCaseOption = option.toLowerCase();
        hover(By.xpath("//span[text()='" + candidateName
                + "']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions']"));

        hover(By.xpath("//span[text()='" + candidateName
                + "']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions']//div[contains(text(),'"
                + option + "')]"));
        List<WebElement> we = getElements(By.xpath("//span[text()='" + candidateName
                + "']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions']//div[contains(text(),'"
                + option + "')]//div[@class='" + lowerCaseOption + "-list-option']"));

        List<String> listOfOptions = new ArrayList<>();
        for (WebElement webElement : we) {
            listOfOptions.add(getText(webElement));
        }
        return listOfOptions;
    }

    public boolean verifySuboptions(String tagName, String tabName, String option, String linkText) {
        boolean visibility = true;
        try {
            wait.resetImplicitTimeout(1);
            WebDriverWait waits = new WebDriverWait(driver, 1);
            //waits.withTimeout(Duration.ofSeconds(1))
            waits.withTimeout(1,TimeUnit.SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"
                            + BillingAPI.candidateName
                            + "']//ancestor::div[@class='tuple-main']/following-sibling::div//span[@class='attachment' and text()='"
                            + linkText + "']")));
            wait.resetImplicitTimeout(60);
        } catch (Exception e) {
            visibility = false;
        }
        String arrayListName = tagName + " " + tabName + " " + linkText + " " + option + " "
                + Boolean.toString(visibility);
        arrayListName = arrayListName.replaceAll(" ", "_").toUpperCase();
        System.out.println(arrayListName);
        System.out.println(map.containsKey(arrayListName));
        if (map.containsKey(arrayListName)) {
            List<String> innerValue = map.get(arrayListName);
            List<String> listOfOptions = getMoreSubOptionsList(BillingAPI.candidateName, option);
            int i = 0;
            for (String str : innerValue) {
                if (!str.equalsIgnoreCase(listOfOptions.get(i))) {
                    return false;
                }
                i++;
            }
            return true;
        } else {
            return false;
        }

    }

    public String getValueFromFinanceMatrix(String valueType) {
        return getText(By.xpath(
                "//div[@class='amount-summary']//div[contains(text(),'" + valueType + "')]/preceding-sibling::div"))
                .replaceAll("[^0-9]+", "");
    }

    public String getValueFromFinanceMatrixOnMouseHover(String valueType, String amountType) {
        hover(By.xpath(
                "//div[@class='amount-summary']//div[contains(text(),'" + valueType + "')]/preceding-sibling::div"));
        return getText(By.xpath("//div[@class='amount-summary']//div[contains(text(),'" + valueType
                + "')]/../following-sibling::div//div[text()='" + amountType + "']/following-sibling::div"))
                .replaceAll("[^0-9]", "");
    }

    public String getCreditNoteAmountOnPaymentReceipt() {
        return getText(By.xpath("//div[@class='credit-note-amount']//span[2]")).replaceAll("[^0-9]", "");

    }

    public void clickOnAnyElementInMailPreviewOverlay(String text) {
        click(By.xpath("//div[@class=\"previewTemplate mail-preview\"]/div//*[contains(text(),\"" + text + "\")]"));
    }

    public String successMessageFromWriteOffMessage() {
        return getText(By.xpath("//div[contains(@class , \"bi-success-message\")]"));
    }

    public void goToBillingDashboardPage() {
    	wait.waitForInvisibilityOfElement(10, 3, eleLayerOverTop);
        click(eleBillingDashboardOnGNB);
    }

    public boolean visibilityOfButtonOnBillingdashboard(String candidateName, String btnText) {
        return isDisplayed(By.xpath("//span[text()= \"" + candidateName
                + "\"]//ancestor::div[contains(@class , \"bi-tuple\")]//*[contains(text(),\"" + btnText + "\")]"));
    }

    public class WriteOffInvoiceOverlayPO {

        public String getDataFromInfoWrapper(String labelName) {
            String dataFromInfoWrapper = getText(By.xpath(
                    "//div[@class = \"modalWrapper \"]//div[@class = \"infoWrapper\"]/label[contains(text() , \""
                            + labelName + "\")]/following-sibling::p"));
            return dataFromInfoWrapper;
        }

        /*
         * radioButtonName = Full writeoff (For selecting the Full Write Off Radio
         * Button) radioButtonName = Partial writeoff (For selecting the Partial Write
         * Off Radio Button)
         */
        public void clickWriteOffRadioButton(String radioButtonName) {
            click(By.xpath(
                    "//div[contains(@class , 'writeOffBodyWrapper')]//label[text()=\"" + radioButtonName + "\"]"));
        }

        /*
         * <<<<<<< HEAD btnText = Writeoff for clicking WriteOff button btnText =
         * Donâ€™t writeoff for clicking Donâ€™t writeoff button =======
         * btnText = Writeoff for clicking WriteOff button btnText = Donâ€™t
         * writeoff for clicking Donâ€™t writeoff button >>>>>>>
         * upstream/BillingInvoiceNew
         */
        public void clickAnyButtonOnModalFooter(String btnText) {
            if (btnText.contains("Don’t writeoff")) {
                wait.waitForVisibilityOfElement((By.xpath(
                        "//div[@class = \"modalWrapper \"]//div[@class = \"writeOffModalFooter\"]/button[text() = \""
                                + btnText + "\"]")));
            }
            click(By.xpath(
                    "//div[@class = \"modalWrapper \"]//div[@class = \"writeOffModalFooter\"]/button[text() = \""
                            + btnText + "\"]"));
        }

        public void fillWriteOffAmount(String amountToBeWrittenOff) {
            sendKeys(By.xpath("//div[@class = 'modalWrapper ']//div[@class = 'writeoffAmountWapper']//input"),
                    amountToBeWrittenOff);
        }

        public boolean verifyWriteOffInfoText(String unpaidAmount) {
            boolean flag = false;
            String actualString = "Unpaid Invoice of " + unpaidAmount + " will remain in Outstanding tab.";
            String messageFromUI = getText(
                    By.xpath("//div[@class = \"modalWrapper \"]//div[@class = \"writeoffInfoText\"]//p"));
            if (messageFromUI.contains(actualString)) {
                flag = true;
            }
            return flag;
        }
    }

	public String getLastAddedCandidateWithoutPIAlreadyGenerated() {
		for (int i = 0; i < 5; i++) {
			if (isDisplayed(By.xpath(
					"(//div[@class='tuple-main']//span[@class='row-one label-key' and text()='INV --']/following-sibling::span)[1]"))) {
				jsUtil.scrollDown(By.xpath("(//div[@class='tuple-main']//span[@class='row-one label-key' and text()='INV --']/following-sibling::span)[1]"));
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-50)");
				wait.waitForValignWrapperToDisappear(10, 3);
				return getText(getElement(By.xpath(
						"(//div[@class='tuple-main']//span[@class='row-one label-key' and text()='INV --']/following-sibling::span)[1]")));
			} else {
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,10000)");
				wait.waitForValignWrapperToDisappear(10, 3);
			}
		}
		return null;
	}
	
	public String getLastAddedCandidateInToBeGeneratedTab() {
		return getText(By.xpath("(//div[@class='candidate-info']//span[contains(@class,'label-value')])[1]"));
	}
	
	public String getDetailsOnFooterOnrightCorner(String candidateName, String key) {
		if (key.equals("for"))
			return getText(By.xpath("(//span[text()='" + candidateName
					+ "']//ancestor::div[@class='tuple-main']/following-sibling::div//span[contains(text(),'" + key
					+ "')]/following-sibling::span)[2]"));
		else
			return getText(By.xpath("//span[text()='" + candidateName
					+ "']//ancestor::div[@class='tuple-main']/following-sibling::div//span[contains(text(),'" + key
					+ "')]/following-sibling::span"));
	}
	
	public void clickOnTabLinkInSuccessMsgAfterMovingCandidateFromOneTabtoAnother(String tabName) {
		wait.waitForValignWrapperToDisappear(10, 3);
		click(By.xpath("//a[@class='move-tuple-link' and text()=\"" + tabName + "\"]"));
		wait.waitForValignWrapperToDisappear(10, 3);
	}
	
	public boolean verifySubOptionOfMoreOptionsIsDisplayed(String candidateName, String option, String subOption) {
		hover(By.xpath("//span[text()='" + candidateName
				+ "']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions']"));
		hover(By.xpath("//span[text()='" + candidateName
				+ "']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions']//div[contains(text(),'"
				+ option + "')]"));
		return isDisplayed(By.xpath("//span[text()='" + candidateName
				+ "']/ancestor::div[@class='tuple-main']//div[@class='secondary-actions']//div[contains(text(),'"
				+ option + "')]//a[contains(text(),\"" + subOption + "\")]"));
	}
	
	public boolean verifyTextIsDisplayedInMailPreviewOverlay(String text, int index) {
		return isDisplayed(By.xpath(
				"(//div[@class=\"previewTemplate mail-preview\"]/div//*[contains(text(),\"" + text + "\")])[" + index + "]"));
	}
	
	public void clickOnDismiss() {
		click(By.xpath("//a[text()='Dismiss']"));
	}
	
	public boolean checkThePresenceOfCandidateName(String candidateName, int index) {
		boolean flag = true;
		flag = isDisplayed(By.xpath("(//span[text()='" + candidateName + "' ])[" + index + "]"));
		return flag;
	}
	
	public void clickOnButtonOnCandidateTupple(String option) {
		hover(parameterizedLocator(eleCandidateNameLocator, BillingAPI.candidateName));
		click(parameterizedLocator(eleOptionButton, BillingAPI.candidateName, option));
	}
	
}
