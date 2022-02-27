package com.naukri.pageobjects.Settings;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author raunak.b
 *
 */
public class ManageEmployerPO extends BaseAutomation {
	private By btnAddNewEmployer = By.xpath("//a[text()='Add Employer']");
	private By addAddressbtn = By.xpath("//input[@value='Add Address']");
	private By txtEmployerName = By.xpath("//div[text()='Employer Name']/../div/input");
	private By employerDescription = By.xpath("//div[@class='mailBodyWriter']");
	private By eleRecruitersTab = By.xpath("//div[text()='Recruiters']");
	private By employerAddressTab = By.xpath("//div[text()='Employer Address']");
	private By ddlSelectRecruiters = By.xpath("//span[text()='Search Here']");
	private By selectAllRecruiterCB = By.xpath("//div[@class='selectAllSection']//label");
	private By ddlEnterRecruiterName = By.xpath("//input[@placeholder='Search here']");
	private By btnEmployerSave = By.xpath("//button[text()='SAVE']");
	private By btnNewBillingAdd = By.xpath("//button[text()='ADD']");
	private By eleSelectSubRecruiter = By.xpath("//b[text()='${string}']");
	private By billingDetailTab = By.xpath("//div[text()='Billing Details']");
	private By addBtn = By.xpath("//button[text()='ADD']");
	private By categoryNameText = By.xpath("//input[@id='rateField']");
	private By flatFeeText = By.xpath("//span[text()='₹']/following-sibling::input");
	private By getAllTabsName = By.xpath("//div[@class='tabHead']");
	private By getSubHeadsAllTabs = By.xpath("//div[@class='tabSubHead']");
	private By tabOnAddEmployer = By.xpath("//div[text()='${tabName}']");
	private By employerAddressTextField = By.xpath("//textarea[contains(@name,'address')]");
	private By gstincodeTextField = By.xpath("//input[contains(@placeholder,'Enter GSTIN Code')]");
	private By gstinRb = By.xpath("//label[@for='hasGSTRadio']");
	private By unregGstinRb = By.xpath("//label[@for='noGSTRadio']");
	private By flatFeeRb = By.xpath("//label[@for='flatFeeRadio']");
	private By percentageFeeText = By.xpath("//span[contains(text(),'Percentage of Salary')]/following-sibling::div//input");
	private By percentageFeeRb = By.xpath("//label[@for='percFeeRadio']");
	private By rupeeSymbol = By.xpath("//span[text()='₹']");
	private By editButton = By.xpath("//*[text()='edit']");
	private By deleteButton = By.xpath("//*[text()='cross']");
	By eleEmployerAdressTab = By.xpath("//div[text()='Employer Address']");
	By savebtn = By.id("saveGroupSettings");
	By addEmployerBtn = By.id("addEmployer");
	By eleEmployerName = By.xpath("//div[text()='Employer Name']/..//input");
	By eleEmployerAddressTbox = By.xpath("//textarea[contains(@name,'address')]");
	By elerecruiterTab = By.xpath("//div[text()='Recruiters']");
	By eleSelectAllRecruiterCB = By.xpath("//div[@class='selectAllSection']//label");
	By eleSelectRecruiterDD = By.xpath("//div[@class='select-controller multiSelectBar']");

	private String timeStamp = ""+System.currentTimeMillis();

	/**
	 * @author raunak.b click add new employer
	 */
	public void clickAddNewEmployer() {
		getElement(btnAddNewEmployer).click();
		wait.waitForPageToLoadCompletely();
	}

	/**
	 * @author raunak.b enter employer name
	 * 
	 */
	public String enterEmployerName(String employerName) {
		getElement(txtEmployerName).sendKeys(employerName);
		return employerName;
	}

	public void enterEmployerDescription(){
		String randomEmployerDesc = CommonAction.generateRandomStrings(5, "String");
		getElement(employerDescription).sendKeys(randomEmployerDesc);
	}

	/**
	 * @author raunak.b enter subrecruiter name on group
	 * 
	 * @param subRecruiter
	 */
	public void enterSubrecruiterNameOnGroup(String subRecruiter) {
		getElement(eleRecruitersTab).click();
		getElement(ddlSelectRecruiters).click();
		sendKeys(ddlEnterRecruiterName, subRecruiter);
		click(parameterizedLocator(eleSelectSubRecruiter, subRecruiter));
		getElement(btnEmployerSave).click();
	}

	public void selectRecruitersOnEmployerPage() {
		wait.waitForValignWrapperToDisappear(5, 3);
		getElement(eleRecruitersTab).click();
		wait.waitForValignWrapperToDisappear(5, 3);
		getElement(ddlSelectRecruiters).click();
		wait.waitForValignWrapperToDisappear(5, 3);
		getElement(selectAllRecruiterCB).click();
		wait.waitForValignWrapperToDisappear(5, 3);
	}

	public void clickBillingDetailsTab() {
		click(billingDetailTab);
		wait.waitForPageToLoadCompletely();
	}

	public void clickAddButtonToAddBillingInformation() {
		click(addBtn);
	}

	public void addNewBillingInformation(String categoryName, String flatFee) {
		sendKeys(categoryNameText, categoryName);
		sendKeys(flatFeeText, flatFee);
		hover(btnNewBillingAdd);
		wait.waitForValignWrapperToDisappear(10, 3);
		click(btnNewBillingAdd);
		wait.waitForValignWrapperToDisappear(10, 3);
	}

	public void saveEmployer() {
		click(btnEmployerSave);
		wait.waitForValignWrapperToDisappear(10, 3);
	}

	public void clickOnAddedEmployerRelatedLinks(String empName, String linkText) {
		wait.waitForValignWrapperToDisappear(10, 3);
		By locator = By.xpath("//a[@title='"+empName+"']/../..//a[text()='"+linkText+"']");
		hover(locator);
		wait.waitForVisibilityOfElement(locator);
		click(locator);
	}

	public void click_on_Element(String textValue) {
		wait.waitForValignWrapperToDisappear(10, 3);
		hover(By.xpath(goToElementContainingTextInViewContainer(textValue)));
		wait.waitForValignWrapperToDisappear(10, 3);
		click(By.xpath(goToElementContainingTextInViewContainer(textValue)));
		wait.waitForValignWrapperToDisappear(10, 3);
	}

	public boolean click_on_Element(String textValue, int index) {
		boolean presence = isDisplayed(By.xpath("("+goToElementContainingTextInViewContainer(textValue)+")["+index+"]"));
		if(presence) {
			hover(By.xpath("("+goToElementContainingTextInViewContainer(textValue)+")["+index+"]"));
			click(By.xpath("("+goToElementContainingTextInViewContainer(textValue)+")["+index+"]"));
		}
		return presence;
		}

	public String goToElementContainingTextInViewContainer(String labelName) {
		return "//div[@class='viewContainer']//*[text()=\"" + labelName + "\" or @value=\"" + labelName + "\"]";
	}

	public void clickCategoryNameInBillingDetails() {
		click(categoryNameText);
		wait.waitForPageToLoadCompletely();
	}

	public void clickFlatFeeTextBoxInBillingDetails() {
		click(flatFeeText);
		wait.waitForPageToLoadCompletely();
	}

	public boolean verifySuccessMessage(String successMessage) {
		return isDisplayed(By.xpath("//span[@id='SuccessmsgBx' and text()='" + successMessage + "']"));

	}

	public void clickEmployerAddressTab() {
		click(employerAddressTab);
		wait.waitForPageToLoadCompletely();
	}

	public List<String> getNameOfAllTabsVisible() {
		List<String> allTabsName = new ArrayList<String>();
		for (WebElement we : getElements(getAllTabsName)) {
			allTabsName.add(we.getText());
		}
		TestNGLogUtility.info("List of all Tabs created");
		System.out.println(allTabsName);
		return allTabsName;
	}

	public List<String> getSubHeadOfAllTabsVisible() {
		List<String> subHeadsOfAllTabsName = new ArrayList<String>();
		for (WebElement we : getElements(getSubHeadsAllTabs)) {
			subHeadsOfAllTabsName.add(we.getText());
		}
		TestNGLogUtility.info("List of Sub Heads of all Tabs created");
		return subHeadsOfAllTabsName;
	}

	public void clickOnTab(String tabName) {
		wait.waitForValignWrapperToDisappear(10, 3);
		getElement(tabOnAddEmployer,tabName).click();
		wait.waitForPageToLoadCompletely();
	}

	public void manadatoryTextFieldValidationForAddress() {
		click(employerAddressTextField);
		click(gstincodeTextField);
		wait.waitForPageToLoadCompletely();
	}

	public boolean verifyValidationForLabelInEmployerPage(String validationMsg, String labelName) {
		return isDisplayed(By.xpath("//*[contains(text(),'" + labelName + "')]/..//*[contains(text(),'" + validationMsg + "')]"));
	}

	public void manadatoryTextFieldValidationForGSTIN() {
		click(gstincodeTextField);
		click(employerAddressTextField);
		wait.waitForPageToLoadCompletely();
	}

	public String fillEmployerAddress(String empAddress) {
		actionBuilderUtil.hardClear(getElement(employerAddressTextField));
		actionBuilderUtil.sendKeysByAction(employerAddressTextField, empAddress);
		return empAddress;
	}

	public String fillEmployerGSTIN(String gSTIN) {
		sendKeys(gstincodeTextField, gSTIN);
		return gSTIN;
	}

	public boolean verifyEmployerSavedDetailsisDisplayed(String label) {
		wait.waitForPageToLoadCompletely();
		return isDisplayed(By.xpath("//*[text()='" + label + "']"));
	}

	public boolean verifyEmployerAsTaxExemptisDisplayed(String panNumber) {
		return getText(By.xpath("//*[text()='" + panNumber + "']/preceding-sibling::td[1]")).contains("(Tax Exempted)");

	}

	public boolean verifyEmployerAsNotRegisteredCompanyDisplayed(String empAddress) {
		if (isDisplayed(By.xpath("//*[text()='" + empAddress + "']"))
				&& getElement(By.xpath("//*[text()='" + empAddress + "']/following-sibling::td[1]")).getText().equalsIgnoreCase("GST Unregistered")
				&& getElement(By.xpath("//*[text()='" + empAddress + "']/following-sibling::td[2]")).getText().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyEmployerAddressOptionsAreDisplayed() {
		return (isDisplayed(employerAddressTextField)
				&& isDisplayed(gstincodeTextField)
				&& isDisplayed(gstinRb)
				&& isDisplayed(unregGstinRb)
				&& isDisplayed(By.xpath(goToElementContainingTextInViewContainer("Company is tax exempt"))));
//		return allIsDisplayed(getAllUnqiueLocatorsAsGroupedList(
//				new String[] { employerAddressTextField, gstincodeTextField, gstinRb, unregGstinRb, goToElementContainingTextInViewContainer("Company is tax exempt") }));
//		return true;
	}

	public String goToTextAreaOrInputTextBoxInViewContainer(String labelName, String fieldType) {
		return "//div[@class='viewContainer']//*[text()='" + labelName + "' or @value='" + labelName + "']/following::"+fieldType+"[1]";
	}

	public void enterTextAreaOrInputTextBoxInViewContainer(String value, String labelName, String fieldType) {
		sendKeys(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, fieldType)), value);
	}

	public String getValueOfTextAreaOrInputTextBoxInViewContainer(String labelName, String fieldType) {
		if(getText(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, fieldType))).isEmpty()) {
			return getAttribute(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, fieldType)), "value");
		}else {
			return getText(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, fieldType)));
		}
	}

	public boolean addAddressButtonisDisplayed() {
		return isDisplayed(addAddressbtn);
	}

	public boolean verifyBillingOptionsareDisplayed() {
		wait.waitForPageToLoadCompletely();
		return allIsDisplayed(Arrays.asList(new By[]{categoryNameText, flatFeeRb, percentageFeeRb, rupeeSymbol, flatFeeText}));
	}

	public String enterCategoryNameInBillingDetails(String categoryName) {
		sendKeys(categoryNameText, categoryName);
		return categoryName;
	}

	public String enterFlatFeeInBillingDetails(String flatFee) {
		sendKeys(flatFeeText, flatFee);
		return flatFee;
	}

	public void clickOnAddButtonToAddBillingInfo() {
		click(addBtn);
	}

	public boolean verifyEditButtonIsDisplayedOnHover() {
		hover(editButton);
		return isDisplayed(editButton);
	}

	public boolean verifyDeleteButtonIsDisplayedOnHover() {
		hover(deleteButton);
		return isDisplayed(deleteButton);
	}

	public void clickOnPercentageOfSalaryTextbox() {
		click(percentageFeeText);
	}

	public String enterPercentageOfJoiningSalary(String fixedPercentageJoiningSalary) {
		sendKeys(percentageFeeText, fixedPercentageJoiningSalary);
		return fixedPercentageJoiningSalary;
	}

	public boolean verifyAddbuttonIsDisplayed() {
		return isDisplayed(addBtn);
	}

	public void clickOnAnyDeleteConfirmationBoxElementById(String elementId) {
		click(By.xpath("//*[@id='"+elementId+"']"));
	}

	public boolean verifyEmployerNameonManageEmployerPageisDisplayed(String empName) {
		return isDisplayed(By.xpath("//a[@title='" + empName + "']"));
	}

	public int getEmployerSavedDetailsCount(String categoryName) {
		return getElements(By.xpath("//*[text()='" + categoryName + "']")).size();
	}

	public boolean verifyBillingDetailsTabIsDisplayed() {
		return isDisplayed(billingDetailTab);
	}

	public String fill_Percentage_of_Salary_in_Billing_Details(String percentageFee) {
		sendKeys(percentageFeeText, percentageFee);
		return percentageFee;
	}

	public void click_on_Add_button_to_Add_New_Billing_Information() {
		click(btnNewBillingAdd);
	}

	public void fillTextAreaOrInputTextBoxInViewContainer(String value, String labelName, String fieldType) {
		sendKeys(By.xpath(goToTextAreaOrInputTextBoxInViewContainer(labelName, fieldType)), value);
	}
	
	public void enterMessage() {
		getElement(By.xpath(goToTextAreaOrInputTextBoxInViewContainer("To:", "input"))).sendKeys(Keys.ENTER);
	}
	
	public void clickOnDeleteEditForAllRegisteredAddress(String optionTitle) {
		wait.waitForValignWrapperToDisappear(10, 5);
		int count = driver.findElements(By.xpath("//div[@class='head']/following::div[@class='registered-addresses']//li")).size();
		for(int i=count-1;i>=1;i--) {
			click(By.xpath("(//div[@class='head']/following::div[@class='registered-addresses']//li/div//span[@title=\""+optionTitle+"\"]/img)["+i+"]"));
			}
		wait.hardWait(1);
	}
	
	public void click_on_Employer_address_tab() {
		click(employerAddressTab);
	}
	
	public void clickEmployerAddressAddButton() {
		click(By.xpath(goToElementContainingTextInViewContainer("ADD")));
	}
	
	public void save_Employer_DetailsOnEmployerPage() {
		click(savebtn);
		wait.waitForValignWrapperToDisappear(10, 3);
	}

	public void click_on_Add_Employer_Button() {
		click(addEmployerBtn);
	}
	
	public String fill_Employer_DetailsOnEmployerPage(String EmpName, String EmpDesc) {
		sendKeys(eleEmployerName, EmpName);
		sendKeys(employerDescription, EmpDesc);
		return EmpName;
	}
	
	public void click_on_Add_address_buton() {
		click(addAddressbtn);
	}
	
	public String fill_Employer_Address(String empAddress) {
		actionBuilderUtil.hardClear(getElement(eleEmployerAddressTbox));
		actionBuilderUtil.sendKeysClearWithActionClass(eleEmployerAddressTbox, empAddress);
		return empAddress;
	}
	
	public void select_RecruitersOnEmployerPage() {
		wait.waitForValignWrapperToDisappear(5, 3);
		click(elerecruiterTab);
		wait.waitForValignWrapperToDisappear(5, 3);
		click(eleSelectRecruiterDD);
		wait.waitForValignWrapperToDisappear(5, 3);
		click(selectAllRecruiterCB);
		wait.waitForValignWrapperToDisappear(5, 3);
	}
}
