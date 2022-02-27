package com.naukri.pageobjects.Billing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.reporters.jq.TestNgXmlPanel;

import com.naukri.automation.util.TestNGLogUtility;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PreviewGenerateOverlayBillingDashboardPO extends BillingDashboardPagePO {

	By eleClickOnValueForLabel = By.xpath("(//div[@class='viewContainer']//*[contains(text(),'${ddLabel}')]/..//following::*[@class='arrow' or @class='select-controller'])[1]");

    private ArrayList<String> NOT_GENERATED_TO_BE_GENERATED_PROFORMA_INVOICE_FALSE = new ArrayList<>(
            Arrays.asList("Generate Invoice", "Cancel", "View Candidate Details"));
    private ArrayList<String> NOT_GENERATED_TO_BE_GENERATED_PROFORMA_INVOICE_TRUE = new ArrayList<>(
            Arrays.asList("Edit Proforma Invoice", "Mail Proforma Invoice", "Download Proforma Invoice",
                    "Print Proforma Invoice", "Cancel", "View Candidate Details"));
    private ArrayList<String> PARTIALLY_PAID_OUTSTANDING_PAYMENT_RECEIPT_TRUE = new ArrayList<>(Arrays
            .asList("Writeoff", "Refund/Issue credit note", "Mail", "Download", "Print", "View Candidate Details"));
    private ArrayList<String> UNPAID_OUTSTANDING_PAYMENT_RECEIPT_FALSE = new ArrayList<>(
            Arrays.asList("Writeoff", "Mail", "Download", "Print", "View Candidate Details"));
    private HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

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

    public String getValueFromAnyLabelInServiceDescriptionTable(String labelName) {
        wait.waitForVisibilityOfElement(By.xpath("(//table[@class=\"serviceDescriptionTable\"]//th)[1]"));
        jsUtil.scrollDown(By.xpath("(//table[@class=\"serviceDescriptionTable\"]//th)[1]"));
        wait.hardWait(2);
        List<WebElement> we = getElements(By.xpath("//table[@class=\"serviceDescriptionTable\"]//th"));
        int i = 0;
        for (WebElement w : we) {
            i++;
            if (getText(w).contains(labelName)) {
                return getText(By.xpath("(//table[@class=\"serviceDescriptionTable\"]//td)[" + i + "]"));
            }
        }
        return null;
    }

    public boolean verifyTextIsDisplayed(String actualNote) {
    	System.out.println("actual note " + actualNote);
        if (isDisplayed(By.xpath("//*[@class=\"viewContainer\" or contains(@class,'tabViewContainer')]/div//*[contains(text(),\"" + actualNote+"\")]"))) {
           TestNGLogUtility.info("in if of true " + getText(By.xpath("//*[@class=\"viewContainer\" or contains(@class,'tabViewContainer')]/div//*[contains(text(),\"" + actualNote+"\")]")));
           TestNGLogUtility.info("displaying nature " + isDisplayed(By.xpath("//*[@class=\"viewContainer\" or contains(@class,'tabViewContainer')]/div//*[contains(text(),\"" + actualNote+"\")]")));
           return true;
        } else {
        	System.out.println("returned value " + verifyTextIsDisplayedInPreviewOverlay(actualNote));
            return verifyTextIsDisplayedInPreviewOverlay(actualNote);

        }
    }

    private boolean verifyTextIsDisplayedInPreviewOverlay(String text) {
    	System.out.println("text another method ");
        return isDisplayed(By.xpath("//*[@class=\"bodyView\"]/div//*[contains(text(),\"" + text + "\")]"));
    }

    public String getValueFromAnyLabelInInvoiceLayout(String labelName) {
    	TestNGLogUtility.info("labelName " + labelName);
        wait.waitForVisibilityOfElement(By.xpath("//div[@class=\"invoiceLayout\"]//*[contains(text(),\"" + labelName + "\")]/following-sibling::*"));
        jsUtil.scrollDown(By.xpath("//div[@class=\"invoiceLayout\"]//*[contains(text(),\"" + labelName+ "\")]/following-sibling::*"));
        System.out.println("*****"+getText(By.xpath("//div[@class=\"invoiceLayout\"]//*[contains(text(),\"" + labelName + "\")]/following-sibling::*"))+"*****");
        return getText(By.xpath("//div[@class=\"invoiceLayout\"]//*[contains(text(),\"" + labelName + "\")]/following-sibling::*"));
    }

    private String goToElementContainingTextInFooter(String labelName) {
        return "//div[@class='foot']//*[text()='" + labelName + "']";
    }

    public void clickOnElementInFooter(String textValue) {
        wait.waitForValignWrapperToDisappear(20, 5);
        hover(By.xpath(goToElementContainingTextInFooter(textValue)));
        click(By.xpath(goToElementContainingTextInFooter(textValue)));
        if (textValue.contains("Generate Invoice") || textValue.contains("Generate Proforma Invoice") || textValue.contains("Mark Paid") || textValue.contains("Mark as Refunded")) {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='statusRibbon']//*[@class='msg']")).getText()
                            .contains("successfully"),
                    "Unsuccessful Attempt for " + textValue + " !!!!");
        }
    }

    public void clickOnButtonOnConfirmationBox(String option) {
        click(By.xpath("//div[@class='ConfirmationBox']//*[text()='" + option + "']"));
        wait.waitForValignWrapperToDisappear(10, 5);
    }

    private String goToTextAreaOrInputTextBoxInViewContainer(String labelName, String fieldType) {
        return "//div[@class='viewContainer' or @class='bodyView' or @class ='offerDetail']//*[contains(text(),\"" + labelName + "\")]/following::"+fieldType+"[1]";
    }

    public String getTextFromAnyTextAreaOrInputBoxInViewContainer(String labelName, String fieldType) {
    	WebElement we = getElement(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, fieldType)));
    	String toBeChecked = getText(we);
    	try {
			if (toBeChecked.isEmpty()) {
				return we.getAttribute("value");
			} else if (toBeChecked.trim().equalsIgnoreCase("₹")) {
				TestNGLogUtility.info("in else if");
				return we.getAttribute("value");
			} else {
				return toBeChecked;
			}
        } catch (NullPointerException ex) {
        	return toBeChecked;
        }
    }

    public String getTextFromSuccessRibbon() {
        wait.waitForValignWrapperToDisappear(10, 5);
        String text=getText(By.xpath("//div[@class='statusRibbon']//*[@class='msg']"));
        return text;
    }

    public void clickOnAnyDDInViewContainer(String ddLabel) {
        click(By.xpath("(//div[@class='viewContainer']//*[contains(text(),\"" + ddLabel
                + "\")]/..//following::*[@class='arrow' or @class='select-controller'])[1]"));
    }

    public void selectValueFromDDInViewContainer(String ddLabel, String value) {
    	jsUtil.scrollDown(parameterizedLocator(eleClickOnValueForLabel, ddLabel));
        click(parameterizedLocator(eleClickOnValueForLabel, ddLabel));
        click(By.xpath(goToDDValueInViewContainer(ddLabel, value)));
    }

    public void clickOnEditButtonOnBillingDetails(String textOfBtn) {
        click(By.xpath("//div[contains(@class , 'viewContainer')]//*[contains(text() , '" + textOfBtn + "')]"));
    }

    public boolean verifyTxtAreaInViewContainer(String labelName, String fieldType) {
        return isDisplayed(By.xpath(
                "//div[@class='viewContainer']//*[contains(text(),\"" + labelName + "\")]/following::" + fieldType + "[1]"));
    }

    public boolean verifyAllDDValuesAreCorrectInPaidOverlay(String ddLabel) {
        List<String> listAllValuesInPaymentMode = getAllValuesFromAnyDDInViewContainer(ddLabel);
        System.out.println(listAllValuesInPaymentMode);
        System.out.println(PAYMENT_METHODS_PAID);
        return PAYMENT_METHODS_PAID.equals(listAllValuesInPaymentMode);
    }

    public List<String> getAllValuesFromAnyDDInViewContainer(String ddLabel) {

        clickOnAnyDDInViewContainer(ddLabel);
        wait.waitForVisibilityOfElement(By.xpath(
                "(//div[@class='viewContainer']//*[contains(text(),\"" + ddLabel + "\")]/..//child::li//span)[1]"));
        List<WebElement> ddElements = driver.findElements(By.xpath(
                "//div[@class='viewContainer']//*[contains(text(),\"" + ddLabel + "\")]/..//child::li//span"));
        List<String> ddValues = new ArrayList<>();
        int i = 1;
        for (WebElement we : ddElements) {
            jsUtil.scrollDown(By.xpath("(//div[@class='viewContainer']//*[contains(text(),\"" + ddLabel
                            + "\")]/..//child::li//span)[" + i + "]"));
//            jsUtil.scrollDown((By) elementWE);
//            scrollDown(elementWE);
            ddValues.add(getText(By.xpath("(//div[@class='viewContainer']//*[contains(text(),\"" + ddLabel
                    + "\")]/..//child::li//span)[" + i + "]")));
            i++;
        }
        return ddValues;
    }

    public String fillTextAreaOrInputTextBoxInViewContainer(String value, String labelName, String fieldType) {
        sendKeys(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, fieldType)), value);
        return value;
    }

    public void clickDDButton() {
        click(By.xpath("//span[text()='DownArrow']"));
    }

    public boolean verifyFullPaymentRefund(String FullAmount) {
        String RefundPaymentFullStrip = getText(
                By.xpath("//*[@class='viewContainer' or @class='tabViewHeader']//div[@class='blueTextBar']"));
        String RefundPaymentModified = RefundPaymentFullStrip.replaceAll(",", "").replaceAll("₹", "");
        return RefundPaymentModified.contains(FullAmount);
    }

    public boolean checkButtonDisabled() {
        return isDisplayed(By.xpath("//div[@class='foot']//button[@class='save blockBtn disable']"));
    }

    public boolean verifyMailBoxPresent() {
        return isDisplayed(By.xpath("//div[@class='mailWrapper']"));
    }

    public String verifyValidationOnPaymentAmount() {
        return getText(By.xpath("//p[@class='currencyErrorMsg']"));

    }

    public void clickOnEditButtonToEditLayout() {
        click(By.xpath("//div[@class='editAction']"));
    }

    public void clickOnSaveButtonToSaveLayout() {
        click(By.xpath("//div[@class='saveCancelActions']/div[text()='Save']"));
    }

    public boolean verifyTextIsDisplayedInFooter(String messageDisplayed) {
        boolean flag;
        String messageFromUI = getText(By.xpath("//div[@class = 'foot']//span[@class = 'errorText']"));
        TestNGLogUtility.info("message from UI " + messageFromUI);
        TestNGLogUtility.info("message expected " + messageDisplayed);
        if (messageFromUI.contains(messageDisplayed)) {
            flag = true;
        } else {
            flag = false;
        }

        return flag;
    }

    public void clickOnCrossBtnInPreviewOverlay() {
        click(By.xpath("//*[@class=\"bodyView\"]/div//*[@class=\"headerCancel\"]"));
    }
    
    public boolean verifyTextIsDisplayedInMailPreviewOverlay(String text) {
		return isDisplayed(By.xpath("//div[@class=\"previewTemplate mail-preview\"]/div//*[text()=\"" + text + "\"]"));
	}
    
    public String getUnderlyingErrorMsgOrInfoOfFieldsInViewContainer(String labelName, String underlyingType) {
		if (underlyingType.equalsIgnoreCase("error")) {
			return getText(By.xpath("//*[contains(text(),\"" + labelName
					+ "\")]/following-sibling::*//p[contains(@class,'Error') or contains(@class,'err')]"));
		} else if (underlyingType.equalsIgnoreCase("info") || underlyingType.equalsIgnoreCase("information")) {
			return getText(By.xpath(
					"//*[contains(text(),\"" + labelName + "\")]/following-sibling::p[contains(@class,\"info\")]"));
		} else {
			return null;
		}
	}
    
	public boolean verifyButtonIsDisabledInFooter(String buttonText) {
		return isDisplayed(By.xpath(
				"//div[@class='foot']//*[contains(text(),\"" + buttonText + "\") and contains(@class,'disable')]"));
	}
	
	public void clickOnAnyTextAreaOrInputBoxInViewContainer(String value, String labelName, String fieldType) {
		click(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, fieldType)));
	}

}
