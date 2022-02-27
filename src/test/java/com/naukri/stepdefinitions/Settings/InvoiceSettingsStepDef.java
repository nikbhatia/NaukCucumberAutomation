package com.naukri.stepdefinitions.Settings;

import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.ViewApplicationDetailPagePO;
import com.naukri.pageobjects.Billing.InvoiceSettingsPO;
import com.naukri.pageobjects.Settings.ManageEmployerPO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceSettingsStepDef {

    InvoiceSettingsPO invoiceSettingsPO = (InvoiceSettingsPO) PageObjectWrapper.getObject(InvoiceSettingsPO.class);
    ManageEmployerPO manageEmployerObject = new ManageEmployerPO();
    ViewApplicationDetailPagePO viewApplicationDetailPagePO = (ViewApplicationDetailPagePO) PageObjectWrapper.getObject(ViewApplicationDetailPagePO.class);

    String expectedIndex, expectedIndexWithNull;
    public static String invoiceNumber, prefixValue;
    public static List<String> billingOffice;
    public static String timeStamp = "" + System.currentTimeMillis();

    Map<String, String> prefix = new HashMap<String, String>();

    @Then("All bank details fields should be visible")
    public void allBankDetailsFieldsShouldBeVisible() {
        Assert.assertTrue(invoiceSettingsPO.verifyAllBankDetailsFieldsVisibility(), "All Fields are not visible !!!!!");
    }


    @And("Add button is disabled")
    public void addButtonIsDisabled() {
        Assert.assertFalse(invoiceSettingsPO.verifyAddAddressButtonVisibility(), "Add Address button is enabled");
    }

    @And("user remove all added addresses")
    public void userRemoveAllAddedAddresses() {
        invoiceSettingsPO.clickOnDeleteEditForAllRegisteredAddress("Delete");
    }

    @And("user fill name as {string} and account as {string} and ifsc as {string}")
    public void userFillNameAsNameAndAccountAsAccountAndIfscAsIfsc(String name, String account, String ifsc) {
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("Account Holder's name", "input", name);
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("Account Number", "input", account);
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("IFSC Code", "input", ifsc);
    }

    @Then("user should get validation error under {string} as {string}")
    public void userShouldGetValidationErrorUnderAsNameValidation(String label, String validation) {
        Assert.assertTrue(invoiceSettingsPO.verifyValidationForLabelInInvoiceSettingsPage(validation, label), validation + " isn't displayed for " + label + " !!!!");

    }

    @And("user add all bank details")
    public void userAddAllBankDetails() {
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("Address", "textarea", "Address with Bank " + timeStamp.substring(1, 3));
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("GSTIN Code", "input", "12AKOTG4567S9ZG");
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("Account Holder's name", "input", "Holder - " + timeStamp.substring(3, 5));
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("Account Number", "input", timeStamp.substring(9) + timeStamp);
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("IFSC Code", "input", "PUNB0019800");
    }

    @And("user click on Employer Address Add button on layout")
    public void clickAddEmployerButton() {
        manageEmployerObject.click_on_Element("Add");

    }

    @And("user click on save invoice settings button")
    public void userClickOnSaveInvoiceSettingsButton() {
        invoiceSettingsPO.saveInvoiceSettingsBtn();

    }

    @Then("Saved Address should be displayed")
    public void savedAddressShouldBeDisplayed() {
        boolean visibility = invoiceSettingsPO.getAllRegisteredAddresses().get(0).contains("Address with Bank " + timeStamp.substring(1, 3));
        System.out.println(visibility);
        Assert.assertTrue(visibility, "Saved Address with bank details are not displayed !!!!");
    }

    @When("user click to edit the address")
    public void userClickToEditTheAddress() {
        invoiceSettingsPO.clickOnDeleteEditRegisteredAddress("Address with Bank " + timeStamp.substring(1, 3), "Edit");

    }

    @Then("All details should be visible with bank details")
    public void allDetailsShouldBeVisibleWithBankDetails() {
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed("Address with Bank " + timeStamp.substring(1, 3)));
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed("12AKOTG4567S9ZG"));
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed("Holder - " + timeStamp.substring(3, 5)));
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed(timeStamp.substring(9) + timeStamp));
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed("PUNB0019800"));
    }

    @And("Options to Change and Remove should be visible")
    public void optionsToChangeAndRemoveShouldBeVisible() {
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed("change"));
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed("Remove"));
    }

    @When("user click on change bank details")
    public void userClickOnChangeBankDetails() {
        manageEmployerObject.click_on_Element("change");
    }

    @And("user click choose from existing")
    public void userClickChooseFromExisting() {
        manageEmployerObject.click_on_Element("Choose from existing");
    }

    @Then("Added bank details should be visible in the dropdown")
    public void addedBankDetailsShouldBeVisibleInTheDropdown() {
        invoiceSettingsPO.clickOnChooseBankDetailsFromExistingDD();
        String bankDetails = invoiceSettingsPO.getFirstBankDetailFromExistingDD();
        Assert.assertTrue(bankDetails.contains("Holder"), "Bank Details aren't displayed in the drop down !!!!!!!!!");
    }

    @When("user select the added bank detail")
    public void userSelectTheAddedBankDetail() {
        invoiceSettingsPO.selectBankDetailsFromDD();
    }

    @When("user click on Add new bank details")
    public void userClickOnAddNewBankDetails() {
        manageEmployerObject.click_on_Element("Add new bank details");
    }

    @When("user update all bank details")
    public void userUpdateAllBankDetails() {
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("Account Holder's name", "input", "Updated Holder - " + timeStamp.substring(3, 5));
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("Account Number", "input", timeStamp.substring(9) + timeStamp);
        invoiceSettingsPO.fillTextInInputOrTextBoxForBillingAddress("IFSC Code", "input", "PUNB0019801");
    }

    @Then("All details should be visible with updated bank details")
    public void allDetailsShouldBeVisibleWithUpdatedBankDetails() {
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed("Address with Bank " + timeStamp.substring(1, 3)));
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed("12AKOTG4567S9ZG"));
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed("Updated Holder - " + timeStamp.substring(3, 5)));
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed(timeStamp.substring(9) + timeStamp));
        Assert.assertTrue(invoiceSettingsPO.verifyTextIsDisplayed("PUNB0019801"));
    }

    @When("user click on remove bank details")
    public void userClickOnRemoveBankDetails() {
        manageEmployerObject.click_on_Element("Remove");
    }

    @Then("Bank details should not be visible")
    public void bankDetailsShouldNotBeVisible() {
        Assert.assertFalse(invoiceSettingsPO.verifyBankDetailsAreNotVisible(), "Bank Details are still visible !!");

    }

    @Then("List of default services should be visible")
    public void listOfDefaultServicesShouldBeVisible() {
        Assert.assertTrue(invoiceSettingsPO.verifyAllDefaultDefineServices(), "Default Services aren't displayed !!!");
    }


    @Then("Verify all define services fields and details should be there")
    public void verifyAllDefineServicesFieldsAndDetailsShouldBeThere() {
        Assert.assertTrue(manageEmployerObject.click_on_Element("Name of service", 1), "Name of service isn't displayed !!!!");
        Assert.assertTrue(manageEmployerObject.click_on_Element("HSN Code", 1), "HSN Code isn't displayed !!!!");
        Assert.assertTrue(manageEmployerObject.click_on_Element("Default Charge", 1), "Default Charge isn't displayed !!!!");
        Assert.assertTrue(invoiceSettingsPO.verifyDefineServicesFieldsandTexts(), "Define Services Fields are missing !!!!");
    }

    @When("user fill all the details in service fields")
    public void userFillAllTheDetailsInServiceFields() {
        manageEmployerObject.enterTextAreaOrInputTextBoxInViewContainer("Service " + timeStamp, "Name of service", "input");
        manageEmployerObject.enterTextAreaOrInputTextBoxInViewContainer(timeStamp, "HSN Code", "input");
    }

    @Then("verify Billing Services should be displayed")
    public void verifyBillingServicesShouldBeDisplayed() {
        Assert.assertTrue(invoiceSettingsPO.verifyAddedBillingService("Service " + timeStamp, timeStamp), "Added Billing Service isn't displayed in the list !!!");
        invoiceSettingsPO.saveInvoiceSettingsBtn();
    }

    @Then("Verify Invoice Settings page opens with all tabs")
    public void verifyInvoiceSettingsPageOpensWithAllTabs(DataTable allTabsOnInvoiceSettingsPage) {
        List<String> AllTabsOnInvoiceSettingsPage = allTabsOnInvoiceSettingsPage.asList(String.class);
        List<String> AllTabsOnInvoiceSettingsPageVisible = manageEmployerObject.getNameOfAllTabsVisible();
        Assert.assertEquals(AllTabsOnInvoiceSettingsPageVisible, AllTabsOnInvoiceSettingsPage);
        TestNGLogUtility.pass("[Assertion Pass]: Correct Tab name are visible");
    }

    @And("Verify sub headings of tabs present on Invoice Settings page")
    public void verifySubHeadingsOfTabsPresentOnInvoiceSettingsPage(DataTable subHeadsOfTabs) {
        List<String> SubHeadsOfTabs = subHeadsOfTabs.asList(String.class);
        List<String> SubHeadsOfTabsVisible = manageEmployerObject.getSubHeadOfAllTabsVisible();
        Assert.assertEquals(SubHeadsOfTabsVisible, SubHeadsOfTabs);
        TestNGLogUtility.pass("[Assertion Pass]: Correct Tab Sub Headings name are visible");
    }

    @And("user fill prefix text field for {string}")
    public void userFillPrefixTextFieldFor(String tabName) {
        prefixValue = invoiceSettingsPO.getPrefixField(tabName);
        prefix.put(tabName, prefixValue);
        invoiceSettingsPO.enterPrefixValue(prefix.get(tabName));
    }

    @And("user fill only start from field")
    public void userFillOnlyStartFromField() {
        expectedIndex = invoiceSettingsPO.enterStartIndexFrom(1300);

    }

    @And("user click on {string} button on footer")
    public void userClickOnButtonOnFooter(String buttonText) {
        invoiceSettingsPO.clickOnButtonInFooter(buttonText);
    }


    @And("saved invoice name should be same as entered {string}")
    public void savedInvoiceNameShouldBeSameAsEntered(String tabName) {
        Assert.assertTrue(invoiceSettingsPO.verifyEnteredPrefix(prefix.get(tabName)), "Prefix is not as equal as entered");
    }

    @Then("saved index number should be displayed {string}")
    public void savedIndexNumberShouldBeDisplayed(String arg0) {
        invoiceSettingsPO.verifyTheStringIndexMessage(arg0);
    }

    @And("user fill only start from field with null string")
    public void userFillOnlyStartFromFieldWithNullString() {
// -1 is passed because the startsWith Index should be 0 and the method adds 1 to passed on value
        expectedIndexWithNull= invoiceSettingsPO.enterStartIndexFrom(-1);
    }

    @Then("validation message for start index")
    public void validationMessageForStartIndex() {
        invoiceSettingsPO.verifyTheErrorMessage();
    }

    @When("user click on remove icon with change signature link")
    public void userClickOnRemoveIconWithChangeSignatureLink() {
        invoiceSettingsPO.clickOnRemoveSignatureIconInInvoiceLayout();
    }

    @Given("user create candidate with tax exempted employer and move the candidate to billing stage")
    public void userCreateCandidateWithTaxExemptedEmployerAndMoveTheCandidateToBillingStage() {
        viewApplicationDetailPagePO.generateCandidateIdWithEmployerOfRMSConsultantviaAPI("flat", "50000", 10, 90, "true");
        viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
        viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation - "+timeStamp,"100000",1,"90000",15);
    }

    @Then("Only {string} should be displayed in layout to save")
    public void onlyShouldBeDisplayedInLayoutToSave(String arg0) {
        manageEmployerObject.click_on_Element("Enter Prefix");
        Assert.assertTrue(invoiceSettingsPO.verifyValidationForLabelInInvoiceSettingsPage(arg0+"/1", "Start proforma invoice number from"), "Prefix is exceding from 50 characters !!!");

    }

    @When("user enter {string} while Create new prefix series")
    public void userEnterWhileCreateNewPrefixSeries(String arg0) {
        invoiceSettingsPO.enterPrefixValue(arg0);
    }

    @Then("Verify save button is disabled to save the invoice settings")
    public void verifySaveButtonIsDisabledToSaveTheInvoiceSettings() {
        Assert.assertFalse(invoiceSettingsPO.verifySaveButtonVisibility(), "Save button is enabled after deleting all registered addresses of consultant !!!!");

    }

    @And("User Get Next Invoice Number from Invoice Settings")
    public void userGetNextInvoiceNumberFromInvoiceSettings() {
        String prefix= invoiceSettingsPO.getEnteredPrefixValue();
        int value = invoiceSettingsPO.getGeneratedInvoiceCount()+1;
        invoiceNumber=prefix+"/"+String.format("%06d",value);
    }

    @And("User Get Billing Office Address from Invoice Settings")
    public void userGetBillingOfficeAddressFromInvoiceSettings() {
        billingOffice=invoiceSettingsPO.getAllRegisteredAddresses();

    }

    @And("user edit added service and save")
    public void userEditAddedServiceAndSave() {
        invoiceSettingsPO.clickOnDeleteEditList("Service "+timeStamp, "Edit");
        timeStamp = ""+System.currentTimeMillis();
        manageEmployerObject.fillTextAreaOrInputTextBoxInViewContainer("Service "+timeStamp, "Name of service", "input");
        manageEmployerObject.fillTextAreaOrInputTextBoxInViewContainer(timeStamp, "HSN Code", "input");
        Assert.assertTrue(manageEmployerObject.click_on_Element("Edit", 1), "Edit Button isn't displayed !!!");
    }

    @Then("Billing Services should be displayed")
    public void billingServicesShouldBeDisplayed() {
        Assert.assertTrue(invoiceSettingsPO.verifyAddedBillingService("Service "+timeStamp, timeStamp), "Added Billing Service isn't displayed in the list !!!");
        invoiceSettingsPO.saveInvoiceSettingsBtn();
    }

    @And("user delete the added services and save")
    public void userDeleteTheAddedServicesAndSave() {
        invoiceSettingsPO.clickOnDeleteEditList("Service "+timeStamp, "Delete");
        invoiceSettingsPO.saveInvoiceSettingsBtn();
    }

    @Then("Billing Services should not be displayed")
    public void billingServicesShouldNotBeDisplayed() {
        Assert.assertFalse(invoiceSettingsPO.verifyAddedBillingService("Service "+timeStamp, timeStamp), "Deleted Billing Service is displayed in the list !!!");
    }
}
