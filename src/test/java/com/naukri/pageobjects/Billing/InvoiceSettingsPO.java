package com.naukri.pageobjects.Billing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.naukri.automation.util.BasicTestOps;
import com.naukri.test.base.PageObjectWrapper;

public class InvoiceSettingsPO extends PageObjectWrapper {

    private Map<String, String> defaultServices = new HashMap<>();

    private By buttonWithText = By.xpath("//button[contains(text() , '${buttonText}')]");
    private By accountHolderName = By.xpath("//input[@id='accHolderName']");
    private By accountNumber = By.xpath("//input[@id='accountNumber']");
    private By ifscCode = By.xpath("//input[@id='ifscCode']");
    private By bankDetailsVisibilityCheckBox = By.xpath("//label[@for='bankDetailsVisibility']");
    private By addAddressBtn = By.xpath("//button[text()=\"Add\"]");
    private By inputOrTextBoxForBillingAddress = By.xpath("//label[contains(text(), '${labelName}')]/following-sibling::'${inputType}'");
    private By saveButton = By.xpath("//div[@class='foot']/button[text()='Save']");
    private By chooseFromExistingDD = By.xpath("//input[@id='chooseBankDetailsFromExistingDD']");
    private By prefixFiled = By.xpath("//input[contains(@id,'-prefix')]");
    private By startIndexFromField = By.xpath("//input[contains(@class,'startInvoiceFrom')]");
    private By startPrefix = By.xpath("//p[contains(@class, 'predefinedPrefix')]");
    private By informationOnInvociceSettingsForIndex = By.xpath("//p[contains(text(),'have been generated')]");
    private By removeSignatureIcon = By.xpath("//span[contains(@class,'signatureRemoveIcon')]/img");
    private By alreadyGeneratedInvoices = By.xpath("//h2[contains(text(),'Currently used')]/../p[2]");
    By invoiceNoTab = By.xpath("//div[ text()='Invoice No. prefix']/following-sibling::div");
	By proformaNoTab = By.xpath("//div[ text()='Proforma No. prefix']");
	By creditNoteNoTab = By.xpath("//div[ text()='Credit Note No. prefix']");
	By registerAddressNoTab = By.xpath("//div[contains(text(),'Registered Address & Bank Details')]");
	By defineServicesTab = By.xpath("//div[contains(text(),'Define Services')]");
	By registeredAddressesTab = By.xpath("//div[contains(text(),'Registered Address & Bank Details')]");
	By defineInvoiceLayoutTab = By.xpath("//div[contains(text(),'Define Invoice layout')]");
	By createNewPrefixBtn = By.xpath("//button[text()='Create new prefix series']");
	By savePrefixButton = By.xpath("//button[ text()='Save Prefix']");

    private String indexNumber;
    
    public InvoiceSettingsPO() {
		defaultServices.put("Executive/retained personnel search services", "998511");
		defaultServices.put("Permanent placement services, other than executive search services.", "998512");
		defaultServices.put("Contract staffing services", "998513");
		defaultServices.put("Temporary staffing services", "998514");
		defaultServices.put("Long-term staffing (pay rolling) services", "998515");
		defaultServices.put("Temporary staffing-to-permanent placement services", "998516");
		defaultServices.put("Co-employment staffing services", "998517");
		defaultServices.put("Other employment & labour supply services", "998519");
	}

    public void clickOnRemoveSignatureIconInInvoiceLayout() {
        if(isDisplayed(removeSignatureIcon)){
            click(removeSignatureIcon);
        }
    }

    public void clickButtonWithText(String buttonText) {
        wait.waitForPageToLoadCompletely();
        click(buttonWithText);
    }

    public boolean verifyAllBankDetailsFieldsVisibility() {
        Boolean accountHolderNameVisibility = isDisplayed(accountHolderName);
        Boolean accountNumberVisibility = isDisplayed(accountNumber);
        Boolean ifscCodeVisibility = isDisplayed(ifscCode);
        Boolean bankDetailsVisibility = isDisplayed(bankDetailsVisibilityCheckBox);
        return (accountHolderNameVisibility && accountNumberVisibility && ifscCodeVisibility && bankDetailsVisibility);
    }

    public boolean verifyAddAddressButtonVisibility() {
        String attribute = getAttribute(addAddressBtn, "class");
        if (attribute.contains("disabledBtn")) {
            return false;
        } else {
            return true;
        }
    }

    public void clickOnDeleteEditForAllRegisteredAddress(String optionTitle) {
        wait.waitForValignWrapperToDisappear(10, 5);
        int count = driver.findElements(By.xpath("//div[@class='head']/following::div[@class='registered-addresses']//li")).size();
        for (int i = count - 1; i >= 1; i--) {
            click(By.xpath("(//div[@class='head']/following::div[@class='registered-addresses']//li/div//span[@title=\"" + optionTitle + "\"]/img)[" + i + "]"));
        }
        wait.hardWait(1);
    }

    public void fillTextInInputOrTextBoxForBillingAddress(String labelName, String inputType, String inputValue) {
//		sendKeys(inputOrTextBoxForBillingAddress,inputValue);
        sendKeys(By.xpath("//label[contains(text(), \"" + labelName + "\")]/following-sibling::" + inputType + ""), inputValue);

    }

    public boolean verifyValidationForLabelInInvoiceSettingsPage(String validationMsg, String labelName) {
        String text = getText(driver.findElement(By.xpath(
                "//*[contains(text(),\"" + labelName + "\")]/..//p")));
        if (text.contains(validationMsg)) {
            return true;
        } else {
            return false;
        }

    }

    public void saveInvoiceSettingsBtn() {
        click(saveButton);
        wait.waitForValignWrapperToDisappear(10, 3);
    }

    public List<String> getAllRegisteredAddresses() {
        //List<WebElement> listWe = getLocators("//div[@class='head']/following-sibling::ul/div//li/div[1]");
        List<WebElement> listWe = driver.findElements(By.xpath("//div[contains(@class,'registered-addresses')]//ul/li[contains(@class , 'tableRow')]"));
        List<String> regAddresses = new ArrayList<>(listWe.size());
        for (int i = 1; i <= listWe.size(); i++) {
            WebElement we = driver.findElement(By.xpath("(//div[contains(@class,'registered-addresses')]//ul/li[contains(@class , 'tableRow')])[" + i + "]/div[1]"));
            regAddresses.add(getText(we).trim());
        }
        return regAddresses;
    }

    public void clickOnDeleteEditRegisteredAddress(String addressText, String optionTitle) {
        click(By.xpath("(//div[@class='head']/following::div[@class='registered-addresses']//li//*[contains(text(),\"" + addressText + "\")]/following::div//span[@title=\"" + optionTitle + "\"])[1]/img"));
    }

    public boolean verifyTextIsDisplayed(String text) {
        if (isDisplayed(By.xpath(
                "//*[@class=\"viewContainer\" or contains(@class,'tabViewHeader')]/div//*[contains(text(),\"" + text
                        + "\") or @value=\"" + text + "\"]"))) {
            return true;
        } else {
            jsUtil.scrollDown((By.xpath(
                    "//*[@class=\"viewContainer\" or contains(@class,'tabViewHeader')]/div//*[contains(text(),\"" + text
                            + "\") or @value=\"" + text + "\"]")));
            wait.hardWait(2);
            boolean result = driver.findElement(By.xpath(
                    "//*[@class=\"viewContainer\" or contains(@class,'tabViewHeader')]/div//*[contains(text(),\"" + text
                            + "\") or @value=\"" + text + "\"]")).isDisplayed();
            return result;
        }
    }

    public void clickOnChooseBankDetailsFromExistingDD() {
        click(chooseFromExistingDD);
    }

    public String getFirstBankDetailFromExistingDD() {
        return getText(By.xpath("//div[@class='dropdownPrimary']//li[1]"));

    }

    public void selectBankDetailsFromDD() {
        click(By.xpath("//div[@class='dropdownPrimary']//li[1]"));
    }

    public boolean verifyBankDetailsAreNotVisible() {
//		return isDisplayed(By.xpath("//input[@id='accHolderName']"));
        return elementVisibility(By.xpath("//input[@id='accHolderName']"));
    }

    public boolean verifyAllDefaultDefineServices() {
        wait.waitForPageToLoadCompletely();
        boolean flag = true;
        for (int i = 2; i <= 9; i++) {
            String serviceText = getText(By.xpath("//ul[contains(@class,'service-listing')]/li[" + i + "]/div[1]"));
            String seriveHSN = getText(By.xpath("//ul[contains(@class,'service-listing')]/li[" + i + "]/div[2]"));
            if (!seriveHSN.equalsIgnoreCase(defaultServices.get(serviceText))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean verifyDefineServicesFieldsandTexts() {
        if (!isDisplayed(By.xpath("//*[text()=\"Name of service\"]/following-sibling::input"))) {
            return false;
        } else if (!isDisplayed(By.xpath("//*[text()=\"Default Charge\"]/following-sibling::input"))) {
            return false;
        }
        return true;
    }

    public boolean verifyAddedBillingService(String serviceName, String HSN) {
        return isDisplayed(By.xpath("//*[text()='" + serviceName + "']/following-sibling::div[text()='" + HSN + "']"));

    }

    public String getPrefixField(String tabName) {
        String prefixStartingValue = "";
        switch (tabName) {
            case "Invoice":
                prefixStartingValue = "IN";
                break;
            case "Proforma":
                prefixStartingValue = "PI";
                break;
            case "Credit":
                prefixStartingValue = "CRN";
                break;
        }

        String prefixValue = prefixStartingValue + "/FY19-20/Test" + BasicTestOps.generateRandomStrings(3, "Number");
        return prefixValue;
    }

    public void enterPrefixValue(String prefixValue) {
        wait.waitForValignWrapperToDisappear(10, 3);
        getElement(prefixFiled).clear();
        wait.waitForValignWrapperToDisappear(10, 3);
        getElement(prefixFiled).sendKeys(prefixValue);
        wait.waitForValignWrapperToDisappear(10, 3);
    }

    public String enterStartIndexFrom(int value) {
        wait.waitForValignWrapperToDisappear(10, 3);
        getElement(startIndexFromField).clear();
        wait.waitForValignWrapperToDisappear(10, 3);
        getElement(startIndexFromField).clear();
        getElement(startIndexFromField).sendKeys(Keys.BACK_SPACE);
        getElement(startIndexFromField).sendKeys(String.valueOf(value + 1));
        wait.waitForValignWrapperToDisappear(10, 3);
        indexNumber = "" + (value + 1);
        return String.valueOf(value + 1);
    }

    public void clickOnButtonInFooter(String btnText) {
        wait.waitForVisibilityOfElement(By.xpath("//div[@class = 'foot']/button[contains(text(), '" + btnText + "')]"));
        boolean pres = isDisplayed(By.xpath("//div[@class = 'foot']/button[contains(text(), '" + btnText + "') and contains(@class,'disable')]"));
        if (!pres) {
            wait.waitForValignWrapperToDisappear(10, 5);
            jsUtil.scrollDown(By.xpath("//div[@class = 'foot']/button[contains(text(), '" + btnText + "')]"));
            click(By.xpath("//div[@class = 'foot']/button[contains(text(), '" + btnText + "')]"));
            wait.waitForPageToLoadCompletely();
        }
    }

    public String getEnteredPrefixValue() {
        return getText(startPrefix);
    }

    public boolean verifyEnteredPrefix(String prefixValue) {
        return getEnteredPrefixValue().contains(prefixValue);
    }

    public boolean verifyTheStringIndexMessage(String arg0) {
        String frontMessage = "";
        String middleMessage = "have been generated. New ";
        String messageFromUI = getText(informationOnInvociceSettingsForIndex);
        String actualMessage = frontMessage + middleMessage + arg0.toLowerCase() + "will start from series " + indexNumber;
        return messageFromUI.contains(actualMessage);
    }

    public boolean verifyTheErrorMessage() {
        String errorMessage = "Start index should be greater than last generated invoice (0)";
        String actualErrorMessageFromUI = getText(By.xpath("//p[contains(@class , 'startIndexError ')]"));
        return (errorMessage.contains(actualErrorMessageFromUI));
    }

    public boolean verifySaveButtonVisibility() {
        return isDisplayed(By.xpath("//div[@class = 'foot']/button[contains(text(), 'SAVE')]"));
    }

    public int getGeneratedInvoiceCount() {
        int value=0;
        hover(alreadyGeneratedInvoices);
        if(getText(alreadyGeneratedInvoices).contains("start from series")) {
            value= Integer.parseInt(getText(alreadyGeneratedInvoices).replaceAll("[^0-9]", ""));
            value=value-1;
        }
        else {
            value = Integer.parseInt(getText(alreadyGeneratedInvoices).split("upto")[1].replaceAll("[^0-9]", ""));
        }
        return value;
    }

    public void clickOnDeleteEditList(String rowKey, String optionTitle) {
        click(By.xpath("//div[contains(text(),'"+rowKey+"')]/following-sibling::div//span[@title='"+optionTitle+"']/img"));
    }
    
    public void clickOnTabOnInvoiceSettingsForm(String tabName) {
		wait.waitForValignWrapperToDisappear(10, 5);
		switch (tabName.toLowerCase()) {
		case "invoice":
			//hover(invoiceNoTab);
			click(invoiceNoTab);
			wait.waitForValignWrapperToDisappear(10, 5);
			break;

		case "proforma":
			click(proformaNoTab);
			wait.waitForValignWrapperToDisappear(10, 5);
			break;

		case "credit note":
			click(creditNoteNoTab);
			wait.waitForValignWrapperToDisappear(10, 5);
			break;

		case "invoice layout":
			click(defineInvoiceLayoutTab);
			wait.waitForValignWrapperToDisappear(10, 5);
			break;
			
		case "billing address":
			 click(registeredAddressesTab);
			 wait.waitForValignWrapperToDisappear(10, 5);
			 break;

		case "define services":
			 click(defineServicesTab);
			 wait.waitForValignWrapperToDisappear(10, 5);
			 break;
			 
		default:
			click(registerAddressNoTab);
			wait.waitForValignWrapperToDisappear(10, 5);
		}
	}
    
    public void clickOnCreatePrefixButton() {
		hover(createNewPrefixBtn);
		click(createNewPrefixBtn);
	}
    
	public void clickOnSavePrefixBtn() {
		wait.waitForValignWrapperToDisappear(10, 3);
		click(savePrefixButton);
		wait.waitForValignWrapperToDisappear(10, 3);
	}
	
}