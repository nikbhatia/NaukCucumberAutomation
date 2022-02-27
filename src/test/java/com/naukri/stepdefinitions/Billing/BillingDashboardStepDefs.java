package com.naukri.stepdefinitions.Billing;

import com.naukri.automation.util.BasicTestOps;
import com.naukri.automation.util.BillingAPI;
import com.naukri.automation.util.GenericFunctions;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.YamlReader;
import com.naukri.pageobjects.Applications.ViewApplicationDetailPagePO;
import com.naukri.pageobjects.Billing.BillingDashboardPagePO;
import com.naukri.pageobjects.Billing.InvoiceSettingsPO;
import com.naukri.pageobjects.Billing.MailPagePO;
import com.naukri.pageobjects.Billing.PreviewGenerateOverlayBillingDashboardPO;
import com.naukri.pageobjects.Settings.ManageEmployerPO;
import com.naukri.pageobjects.Settings.ManageTemplatePO;
import com.naukri.pageobjects.Settings.SettingsDashboardPO;
import com.naukri.stepdefinitions.Applications.PilotApplicationInboxStepDef;
import com.naukri.stepdefinitions.Settings.InvoiceSettingsStepDef;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.*;

public class BillingDashboardStepDefs {

    GenericFunctions genericFunction = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
    BillingDashboardPagePO billingDashboardPagePO = (BillingDashboardPagePO) PageObjectWrapper.getObject(BillingDashboardPagePO.class);
    BillingDashboardPagePO.WriteOffInvoiceOverlayPO writeOffInvoiceOverlayPO = billingDashboardPagePO.new WriteOffInvoiceOverlayPO();
    PreviewGenerateOverlayBillingDashboardPO previewGenerateOverlayBillingDashboardPO = (PreviewGenerateOverlayBillingDashboardPO) PageObjectWrapper.getObject(PreviewGenerateOverlayBillingDashboardPO.class);
    ViewApplicationDetailPagePO viewApplicationDetailPagePO = (ViewApplicationDetailPagePO) PageObjectWrapper.getObject(ViewApplicationDetailPagePO.class);
    CommonAction commonAction = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
    SettingsDashboardPO settingsPO = (SettingsDashboardPO) PageObjectWrapper.getObject(SettingsDashboardPO.class);
    ManageTemplatePO manageTemplatePO = (ManageTemplatePO) PageObjectWrapper.getObject(ManageTemplatePO.class);
    MailPagePO mailPage = (MailPagePO) PageObjectWrapper.getObject(MailPagePO.class);
    InvoiceSettingsPO invoiceSettings = (InvoiceSettingsPO) PageObjectWrapper.getObject(InvoiceSettingsPO.class);
    ManageEmployerPO manageEmployer = (ManageEmployerPO) PageObjectWrapper.getObject(ManageEmployerPO.class);
    BillingAPI billing = (BillingAPI) PageObjectWrapper.getObject(BillingAPI.class);
    public static String currentMoreOptionName, invoiceNoFromLayout, getAmountToBePaid, getInvoiceName;
    public static HashMap<String, HashMap<String, String>> candidateDetailsOnBillingDashboard = new HashMap<String, HashMap<String, String>>();
    String enteredAmount, paidOn, employerName;
    String [] candidateData;
    private String candidatedata[];
    private String timeStamp= ""+System.currentTimeMillis();
    private String latestCandidateName;
    private String billableSalary;
    private String totalAmount;
	private String dueDate;
	private String piDate;
	private String candidateName;
	private String invoiceNumber;
	private int newIndex;
	private String prefix;
	private int value;
    
    private void fillCandidateDetailsOfBillingDashboard(String moreOptionName) {

        if (moreOptionName.contains("Invoice")) {
            HashMap<String, String> details = new HashMap<>();
            details.put("Invoice Date", new SimpleDateFormat("d MMM yyyy").format(Calendar.getInstance().getTime()));
            details.put("Due Date", PilotApplicationInboxStepDef.offeredCandidateDetails.get("PAYMENT_DUE_ON"));
            if (BillingAPI.billingMode.equalsIgnoreCase("flat")) {
                details.put("Payable Amount", BillingAPI.billingValue);
            } else if (BillingAPI.billingMode.equalsIgnoreCase("percentage")) {
                if (PilotApplicationInboxStepDef.offeredCandidateDetails.get("CANDIDATE'S_BILLABLE_SALARY") == null) {
                    details.put("Payable Amount", "" + (Float.parseFloat(PilotApplicationInboxStepDef.offeredCandidateDetails.get("JOINING_SALARY")) * Float.parseFloat(BillingAPI.billingValue) / 100));
                    details.put("Candidate's billable salary", PilotApplicationInboxStepDef.offeredCandidateDetails.get("JOINING_SALARY"));
                } else {
                    details.put("Payable Amount", "" + (Float.parseFloat(PilotApplicationInboxStepDef.offeredCandidateDetails.get("CANDIDATE'S_BILLABLE_SALARY")) * Float.parseFloat(BillingAPI.billingValue) / 100));
                    details.put("Candidate's billable salary", PilotApplicationInboxStepDef.offeredCandidateDetails.get("CANDIDATE'S_BILLABLE_SALARY"));
                }
            }
            details.put("Bill to", BillingAPI.billToAddress);
            details.put("Choose an invoice rate to be applied", BillingAPI.billingCategory);
            details.put("Enter Billing Amount", "");
            details.put("Invoice No.", InvoiceSettingsStepDef.invoiceNumber);

            candidateDetailsOnBillingDashboard.put(moreOptionName, details);
            System.out.println("Value " + candidateDetailsOnBillingDashboard.values());
        }
    }

    @Then("User should be on {string} Tab")
    public void UserShouldBeOnTab(String tabName) {
        Assert.assertTrue(billingDashboardPagePO.verifyTabIsActive(tabName),
                "To Be Generated Tab is not displayed !!!!!!");
    }

    @And("On Hover in {string} tab click the link {string}")
    public void onHoverInTabClickTheLink(String tabName, String optionName) {
        billingDashboardPagePO.clickOnTab(tabName);
        if (optionName.startsWith("Generate Proforma")) {
            billingDashboardPagePO.clickOnButtonOnBillingdashboard(BillingAPI.candidateName, optionName);
        } else {
            billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, optionName);
        }
    }

    @And("User should see the {string} under {string} column")
    public void userShouldSeeTheUnderColumn(String actualValue, String labelName) {
        Assert.assertTrue((previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInServiceDescriptionTable(labelName).contains(actualValue)),
                "The actual value isn't dispayed on under the '" + labelName + "'");
    }

    @And("User should see the {string} In Footer")
    public void userShouldSeeTheInFooter(String actualNote) {
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed(actualNote),
                "The footer text for SEZ organization isn't the actual message to be displayed");
    }

    @When("User {string} of the Candidate")
    public void userOfTheCandidate(String btnText) {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, btnText);
        currentMoreOptionName = btnText;
        fillCandidateDetailsOfBillingDashboard(btnText);
    }

    @Then("User get the Invoice Number of the candidate")
    public void userGetTheInvoiceNumberOfTheCandidate() {
        invoiceNoFromLayout = previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Invoice No.");

    }

    @When("User generate PI for the added candidate from performa invoice page")
    public void userGeneratePIForTheAddedCandidateFromPerformaInvoicePage() {
    	String val=previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInServiceDescriptionTable("IGST");
		int firstSpace = val.indexOf(" ");
		int secondSpace = val.indexOf(" ", firstSpace+1);
		Assert.assertTrue(val.substring(firstSpace, secondSpace).trim().equalsIgnoreCase(""+0),"IGST Amount isn't zero for tax exempted employer !!!!");
		TestNGLogUtility.pass("IGST Amount is zero for tax exempted employer !!!!");
		Assert.assertTrue(val.contains("18%"),"IGST Applied is incorrect !!!");
		TestNGLogUtility.pass("IGST Applied is correct !!!");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Then("User verify the {string} and {string} on {string} tab")
    public void userVerifyTheAndOnTab(String candidateName, String invoiceNo, String tabName) {
        String verifyTheSuccessMessage = "Invoice No: " + invoiceNoFromLayout + " generated for " + BillingAPI.candidateName + ". Invoice is now in Outstanding tab. Dismiss";
        Assert.assertTrue(billingDashboardPagePO.getCommunicationMessageAfterTheMovementOfCandidateAcrossTuple(BillingAPI.candidateName).contains(verifyTheSuccessMessage), "Communication message isn't correct");
    }

    @Then("Added Candidate Name should be displayed in {string} Tab under {string} label")
    public void addedCandidateNameShouldBeDisplayedInTabUnderLabel(String tabName, String labelName) {
        Assert.assertTrue(BillingAPI.candidateName.contains(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, labelName)),
                "Candidate isn't visible");

    }


	@When("user click on {string} tab on billing dashboard")
	public void user_click_on_tab_on_billing_dashboard(String tabName) {
	    billingDashboardPagePO.clickOnTab(tabName);
	}

	@And("Get Invoice Name and amount to be paid")
	public void getInvoiceNameAndAmountToBePaid() {
        getAmountToBePaid= billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName,"Amount paid");
        getInvoiceName= billingDashboardPagePO.getInvoiceNumberFromTuple(BillingAPI.candidateName);	}

    @Then("Label {string} with correct value is displayed in layout")
    public void labelWithCorrectValueIsDisplayedInLayout(String labelName) {
        String value=previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout(labelName);
        if(value.contains("₹") || value.contains(",")) {
            int firstSpace = 0;
            int secondSpace = value.length();
            if(value.indexOf(" ")>=0) {
                firstSpace = value.indexOf(" ");
                if(value.lastIndexOf(" ")==value.indexOf(" ")) {
                    secondSpace=value.length();
                }else {
                    secondSpace = value.indexOf(" ", firstSpace + 1);
                }
            }
            value = ""+(Float.parseFloat(value.substring(firstSpace, secondSpace).replaceAll(",", "").replaceAll(" ", "")));
        }
        System.out.println("-----"+candidateDetailsOnBillingDashboard.get(currentMoreOptionName).get(labelName)+"-----");
        Assert.assertTrue(value.contains(candidateDetailsOnBillingDashboard.get(currentMoreOptionName).get(labelName)), labelName+" value is not Correct !!!!!!!!");
    }

    @And("Label {string} with correct value is displayed in sevice desc table")
    public void labelWithCorrectValueIsDisplayedInSeviceDescTable(String labelName) {
        String value=previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInServiceDescriptionTable(labelName);
        if(value.contains("₹") || value.contains(",")) {
            int firstSpace = 0;
            int secondSpace = value.length();
            if(value.indexOf(" ")>=0) {
                firstSpace = value.indexOf(" ");
                if(value.lastIndexOf(" ")==value.indexOf(" ")) {
                    secondSpace=value.length();
                }else {
                    secondSpace = value.indexOf(" ", firstSpace + 1);
                }
            }
            value = ""+(Float.parseFloat(value.substring(firstSpace, secondSpace).replaceAll(",", "").replaceAll(" ", "")));
        }
        Assert.assertTrue(value.contains(candidateDetailsOnBillingDashboard.get(currentMoreOptionName).get(labelName)), labelName+" value is not Correct !!!!!!!!");
    }

    @And("Label {string} of type {string} with correct value is displayed")
    public void labelOfTypeWithCorrectValueIsDisplayed(String labelName, String fieldType) {
        String value = previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer(labelName, fieldType);
        if(value.contains("₹") || value.contains(",")) {
            int firstSpace = 0;
            int secondSpace = value.length();
            if(value.indexOf(" ")>=0) {
                firstSpace = value.indexOf(" ");
                if(value.lastIndexOf(" ")==value.indexOf(" ")) {
                    secondSpace=value.length();
                }else {
                    secondSpace = value.indexOf(" ", firstSpace + 1);
                }
            }
            value = ""+(Float.parseFloat(value.substring(firstSpace, secondSpace).replaceAll(",", "").replaceAll(" ", "")));
        }
        Assert.assertTrue(value.contains(candidateDetailsOnBillingDashboard.get(currentMoreOptionName).get(labelName.trim())), labelName+" value is not Correct !!!!!!!!");
    }

    @And("Billing Office shows correct info in layout")
    public void billingOfficeShowsCorrectInfoInLayout() {
        String value=previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Billing Office");
        boolean flag= false;;
        for(String text : InvoiceSettingsStepDef.billingOffice) {
            if(value.contains(text)) {
                flag=true;
            }
        }
        Assert.assertTrue(flag, "Billing Office is Incorrect !!!!!!!!!!");
    }

    @And("Total Amount shows correct info with tax exempted employer")
    public void totalAmountShowsCorrectInfoWithTaxExemptedEmployer() {
        String value=previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInServiceDescriptionTable("Total Amount");
        if(value.contains("₹") || value.contains(",")) {
            int firstSpace = 0;
            int secondSpace = value.length();
            if(value.indexOf(" ")>=0) {
                firstSpace = value.indexOf(" ");
                if(value.lastIndexOf(" ")==value.indexOf(" ")) {
                    secondSpace=value.length();
                }else {
                    secondSpace = value.indexOf(" ", firstSpace + 1);
                }
            }
            value = ""+(Float.parseFloat(value.substring(firstSpace, secondSpace).replaceAll(",", "").replaceAll(" ", "").replaceAll("[^0-9]", "")));
        }
        Assert.assertTrue(candidateDetailsOnBillingDashboard.get(currentMoreOptionName).get("Payable Amount").equals(value), "Total Amount is Incorrect !!!!!!!!!");
    }

    @And("Verify Invoice number is correct in layout")
    public void verifyInvoiceNumberIsCorrectInLayout() {
        invoiceNoFromLayout=previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Invoice No.");
        Assert.assertTrue(invoiceNoFromLayout.equals(InvoiceSettingsStepDef.invoiceNumber), "Invoice Number is Incorrect !!!!!! as it should be "+InvoiceSettingsStepDef.invoiceNumber+" but found "+invoiceNoFromLayout);
    }

    @When("User click on {string} in footer in layout")
    public void userClickOnInFooterInLayout(String text) {
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter(text);
    }

    @Then("Verify success message for generated invoice")
    public void verifySuccessMessageForGeneratedInvoice() {
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getTextFromSuccessRibbon().contains("Invoice number: "+invoiceNoFromLayout+" generated successfully"), "Success message is not displayed or Incorrect !!!!!!!!!");

    }

    @And("All Options should be displayed under more options for {string} candidate under {string} Tab with {string}")
    public void allOptionsShouldBeDisplayedUnderMoreOptionsForCandidateUnderTabWith(String tagName, String tabName, String visibleLink) {
        Assert.assertTrue(billingDashboardPagePO.visibilityOfAllOptionsUnderMoreOptions(tagName, tabName, visibleLink),
                "All More Options are not Visible !!!!!!!!");
    }

    @When("User click on {string} under more options")
    public void userClickOnUnderMoreOptions(String moreOptionName) {
        if(moreOptionName.startsWith("Generate Proforma")) {
            billingDashboardPagePO.clickOnButtonOnBillingdashboard(BillingAPI.candidateName, moreOptionName);
        }else {
            billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, moreOptionName);
        }
        fillCandidateDetailsOfBillingDashboard(moreOptionName);
        currentMoreOptionName=moreOptionName;
    }

    @Then("Verify User see text {string}")
    public void verifyUserSeeText(String text) {
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed(text), text+" is not displayed !!!!!!!!");
    }

    @And("Category rate or fee should be displayed with correct value")
    public void categoryRateOrFeeShouldBeDisplayedWithCorrectValue() {
        if(BillingAPI.billingMode.equalsIgnoreCase("percentage")) {
            Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyInfoUnderBillingcategoryDD(BillingAPI.billingValue), "Billing category amount is not displayed !!!!!!!!!!");
        }else if (BillingAPI.billingMode.equalsIgnoreCase("flat")) {
            Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Payable Amount ", "span").replaceAll(",", "").contains(BillingAPI.billingValue), "Billing category amount is not displayed !!!!!!!!!!");
        }
    }

    @Then("Displayed label {string} must have added Billing Category name as {string} .")
    public void displayedLabelMustHaveAddedBillingCategoryNameAs(String labelName, String categoryName) {
        previewGenerateOverlayBillingDashboardPO.clickOnAnyDDInViewContainer(labelName);
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.valueInDDInViewContainerIsDisplayed(labelName, categoryName), "Billing category - "+categoryName+" is not displayed !!!!!!!!!!!!!!");
        previewGenerateOverlayBillingDashboardPO.clickOnAnyDDInViewContainer(labelName);
    }

    @When("User click on {string} Drop Down and select {string} with value as {string} and type as {string} .")
    public void userClickOnDropDownAndSelectWithValueAsAndTypeAs(String labelName, String value, String billingValue, String billingMode) {
        previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer(labelName, value);
        candidateDetailsOnBillingDashboard.get(currentMoreOptionName).put(labelName, value);
        if(billingMode.equalsIgnoreCase("flat")) {
            candidateDetailsOnBillingDashboard.get(currentMoreOptionName).put("Payable Amount", billingValue);
        }else if(billingMode.equalsIgnoreCase("percentage")) {
            if(PilotApplicationInboxStepDef.offeredCandidateDetails.get("CANDIDATE'S_BILLABLE_SALARY")==null) {
                candidateDetailsOnBillingDashboard.get(currentMoreOptionName).put("Payable Amount", ""+(Float.parseFloat(PilotApplicationInboxStepDef.offeredCandidateDetails.get("JOINING_SALARY"))*Float.parseFloat(billingValue)/100));
            }else {
                candidateDetailsOnBillingDashboard.get(currentMoreOptionName).put("Payable Amount", ""+(Float.parseFloat(PilotApplicationInboxStepDef.offeredCandidateDetails.get("CANDIDATE'S_BILLABLE_SALARY"))*Float.parseFloat(billingValue)/100));
            }
        }
        BillingAPI.billingValue=billingValue;
        BillingAPI.billingMode=billingMode;
    }

    @And("Category rate or fee should not be displayed")
    public void categoryRateOrFeeShouldNotBeDisplayed() {
        if(BillingAPI.billingMode.equalsIgnoreCase("percentage")) {
            Assert.assertFalse(previewGenerateOverlayBillingDashboardPO.verifyInfoUnderBillingcategoryDD(BillingAPI.billingValue), "Billing category amount is not displayed !!!!!!!!!!");
        }else if (BillingAPI.billingMode.equalsIgnoreCase("flat")) {
            Assert.assertFalse(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Payable Amount ", "span").replaceAll(",", "").contains(BillingAPI.billingValue), "Billing category amount is not displayed !!!!!!!!!!");
        }
    }

    @And("Displayed label {string} with value as {string}")
    public void displayedLabelWithValueAs(String labelName, String value) {
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer(labelName, "span").contains(value), "Wrong value is Displayed for label name "+labelName+" !!!!!!!!");
    }

    @And("User see valid text for Generate Proforma Invoice on header")
    public void userSeeValidTextForGenerateProformaInvoiceOnHeader() {
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed(BillingAPI.candidateName+", "+PilotApplicationInboxStepDef.offeredCandidateDetails.get("OFFERED_DESIGNATION")), "Text on header is incorrect !!!!!!");
    }

    @When("User generate PI for the added candidate")
    public void userGeneratePIForTheAddedCandidate() {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BillingAPI.candidateName , "Generate Proforma Invoice");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Proforma Invoice");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Then("User should not see text {string} .")
    public void userShouldNotSeeText(String text) {
        Assert.assertFalse(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed(text), text+" is displayed !!!!!!!");

    }

    @And("Displayed tag should be {string}")
    public void displayedTagShouldBe(String tagName) {
        Assert.assertTrue(billingDashboardPagePO.getCurrentStatus(BillingAPI.candidateName).contains(tagName),
                "Tag Name is not correct");
    }

    @And("Displayed label {string} with correct value")
    public void displayedLabelWithCorrectValue(String labelName) {
        Assert.assertEquals(
                PilotApplicationInboxStepDef.offeredCandidateDetails
                        .get(labelName.replaceAll(" ", "_").toUpperCase().replaceAll(":", "")),
                billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, labelName));

    }

    @And("user click on edit billing details of the employer")
    public void userClickOnEditBillingDetailsOfTheEmployer() {
    previewGenerateOverlayBillingDashboardPO.clickOnEditButtonOnBillingDetails("edit");
    }

    @And("User search for the employer under search employer")
    public void userSearchForTheEmployerUnderSearchEmployer() {
        billingDashboardPagePO.selectEmployerFromSearchEmployerDD(BillingAPI.employerName);
    }

    @Then("Warning message should be displayed as {string} for Added Candidate")
    public void warningMessageShouldBeDisplayedAsForAddedCandidate(String warningMessage) {
        Assert.assertTrue(billingDashboardPagePO.warningMessageFromToBeGenerated(BillingAPI.candidateName).equalsIgnoreCase(warningMessage),
                "The warning message displayed is not correct!!!");
    }

    @And("On Label {string} , On mouse hover show {string} Tab Information")
    public void onLabelOnMouseHoverShowTabInformation(String labelName, String tabName) {

    }

    @And("On Hover in {string} tab link {string} should be working")
    public void onHoverInTabLinkShouldBeWorking(String tabName,String linkName) {
//        if(linkName.equalsIgnoreCase("View Candidate Details")) {
////            String parent = driver.getWindowHandle();
//            billingDashboardPagePO.clickOnOptionsInMoreOptions(APITestOps.candidateName, linkName);
//            Assert.assertTrue(billingDashboardPagePO.moreOptionsOnHoverNotToBeVisible(APITestOps.candidateName), "The link Name " + linkName + " is not clickable");
//            Set<String> handles=driver.getWindowHandles();
//            driver.switchTo().window(handles.toArray()[1].toString());
//            System.out.println( driver.getCurrentUrl());
//            Assert.assertTrue("The application opened isn't same", driver.getCurrentUrl().contains(APITestOps.applicationId));
//            driver.switchTo().window(parent);
//            billingDashboardPagePO.goToBillingDashboardPage();
//            billingDashboardPagePO.clickOnTab(tabName);
//
//        }else {
//            billingDashboardPagePO.clickOnOptionsInMoreOptions(APITestOps.candidateName, linkName);
//            Assert.assertTrue("The link Name " + linkName + " is not clickable", billingDashboardPagePO.moreOptionsOnHoverNotToBeVisible(APITestOps.candidateName));
//            billingDashboardPagePO.goToBillingDashboardPage();
//            billingDashboardPagePO.clickOnTab(tabName);
//        }
    }

    @Then("verify the candidate details tuple on outstanding tab")
    public void verifyTheCandidateDetailsTupleOnOutstandingTab() {
        Assert.assertEquals(BillingAPI.candidateName,
                billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "IN"));
        Assert.assertEquals(
                PilotApplicationInboxStepDef.offeredCandidateDetails
                        .get("Offered designation".replaceAll(" ", "_").toUpperCase().replaceAll(":", "")),
                billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Offered designation"));
        Assert.assertEquals(
                PilotApplicationInboxStepDef.offeredCandidateDetails
                        .get("Payment Due on".replaceAll(" ", "_").toUpperCase().replaceAll(":", "")),
                billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Payment Due on"));

    }

    @And("verify invoice download and hiring for is visible on outstanding tab")
    public void verifyInvoiceDownloadAndHiringForIsVisibleOnOutstandingTab() {
        Assert.assertTrue(billingDashboardPagePO.verifyCandidateDownloadVisibleOnDashboard(BillingAPI.candidateName,"Invoice"), "invoice download not visible");
        Assert.assertTrue(billingDashboardPagePO.verifyHiringForDetailVisible(PilotApplicationInboxStepDef.offeredCandidateDetails,BillingAPI.candidateName), "hiring for not visble");

    }

    @And("Unpaid tag,Mark paid button should be visible on outstanding tab")
    public void unpaidTagMarkPaidButtonShouldBeVisibleOnOutstandingTab() {
        Assert.assertTrue(billingDashboardPagePO.verifyCandidateTagsVisibleOnDashboard(BillingAPI.candidateName,"UnPaid"), "unpaid not visible");
        Assert.assertTrue(billingDashboardPagePO.verifyButtonText(BillingAPI.candidateName,"Mark Paid"), "mark paid not visible");

    }

    @And("verify the mouse hover options on tab")
    public void verifyTheMouseHoverOptionsOnTab() {
        Assert.assertTrue(billingDashboardPagePO.visibilityOfAllOptionsUnderMoreOptions("UNPAID","Outstanding","Payment Receipt"),
                "All More Options are not Visible !!!!!!!!");
    }

    @And("verify candidate details when we hover on candidate name")
    public void verifyCandidateDetailsWhenWeHoverOnCandidateName() {
        billingDashboardPagePO.clickOnTab("Outstanding");
    }

    @Given("user get balance to be paid")
    public void userGetBalanceToBePaid() {
        getAmountToBePaid = billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName,"Amount to be paid");

    }

    @When("user click on mark paid")
    public void userClickOnMarkPaid() {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BillingAPI.candidateName, "Mark Paid");
    }

    @Then("Validate the payment details page")
    public void validateThePaymentDetailsPage() {
        System.out.println(getAmountToBePaid);
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTxtAreaInViewContainer("Payment Amount","input"), "Payment Amount not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTxtAreaInViewContainer("TDS Amount","input"), "TDS Amount not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTxtAreaInViewContainer("Cheque Number","input"), "Cheque Number not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTxtAreaInViewContainer("Note:","input"), "Note not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyAllDDValuesAreCorrectInPaidOverlay("Payment Method"), "Different Payment method not visible");
        //Assert.assertTrue("Balance to be paid not visible",previewGenerateOverlayBillingDashboardPO.verifyPaymentDueOnfillPayment(getAmountToBePaid));
    }

    @When("enter the {int} amount and click on mark paid")
    public void enterTheAmountAndClickOnMarkPaid(int salaryAmount) {
        enteredAmount= previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(""+salaryAmount , "Payment Amount" , "input");
        paidOn= viewApplicationDetailPagePO.selectDateInCalender("Paid On", 1);
        previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Payment Method", "Cash");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark Paid");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Then("candidate tuple should be visible on paid tab")
    public void candidateTupleShouldBeVisibleOnPaidTab() {
        billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName);
    }

    @Then("The tag should be changed to partially paid")
    public void theTagShouldBeChangedToPartiallyPaid() {
            String currentStatus=billingDashboardPagePO.getCurrentStatus(BillingAPI.candidateName);
            Assert.assertTrue(currentStatus.contains("PARTIALLY PAID"), "Status is not changed to 'Partially Paid' ");
        }

    @And("payment receipt should be visible on tuple")
    public void paymentReceiptShouldBeVisibleOnTuple() {
        Assert.assertTrue(billingDashboardPagePO.visibilityOfFooterLinks(BillingAPI.candidateName, "Payment Receipt"), "Payment receipt is not visible on tuple");
    }

    @When("click on payment receipt")
    public void clickOnPaymentReceipt() {
        billingDashboardPagePO.clickOnLinkOnFooter(BillingAPI.candidateName, "Payment Receipt");
    }

    @Then("verify the details on payment receipt")
    public void verifyTheDetailsOnPaymentReceipt() {
        String paidAmount=previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Total Paid Amount", "span");
        Assert.assertTrue(Integer.parseInt(paidAmount.replaceAll("[^0-9]", ""))==Integer.parseInt(enteredAmount), "Paid amount is not same");
    }

    @And("mouse hover on more options and refund issue credit note should be visible in more options")
    public void mouseHoverOnMoreOptionsAndRefundIssueCreditNoteShouldBeVisibleInMoreOptions() {
        Assert.assertTrue(billingDashboardPagePO.visibilityOfAllOptionsUnderMoreOptions("Partially Paid", "Outstanding", "Payment Receipt"), "All more options are not visible after payment.");
    }

    @And("mouse hover on balance to be paid and verify the details like total amount payable and amount paid")
    public void mouseHoverOnBalanceToBePaidAndVerifyTheDetailsLikeTotalAmountPayableAndAmountPaid() {
        Map<String, String> candidateDetails= new HashMap<String, String>();
        candidateDetails.put("Amount paid:", enteredAmount);
        candidateDetails.put("Total amount payable:", "180000");
        Assert.assertTrue(billingDashboardPagePO.verifyOptionsOnHover("Balance to be paid","Outstanding", candidateDetails), "Incorrect values are displayed on mouse hover.");
    }

    @And("click on cancel mail payment receipt")
    public void clickOnCancelMailPaymentReceipt() {

    }

    @Then("candidate has moved to paid tab link should be visible")
    public void candidateHasMovedToPaidTabLinkShouldBeVisible() {

    }

    @Then("verify the candidate details tuple information on paid tab")
    public void verifyTheCandidateDetailsTupleInformationOnPaidTab() {
        Assert.assertTrue(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Amount paid").equals("180000"), "Incorrect paid amount is displaying");
        Assert.assertTrue(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Paid on").equalsIgnoreCase(paidOn), "Incorrect Payment date is displaying");
        Assert.assertTrue(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Payment Mode").equals("Cash"), "Incorrcet payment mode is displaying");
    }

    @And("verify the paid tag")
    public void verifyThePaidTag() {
        String currentStatus=billingDashboardPagePO.getCurrentStatus(BillingAPI.candidateName);
        Assert.assertTrue(currentStatus.contains("PAID"), "Status is not changed to 'Partially Paid' ");
    }

    @And("mouse hover on more options and verify more options on mouse hover")
    public void mouseHoverOnMoreOptionsAndVerifyMoreOptionsOnMouseHover() {
        ArrayList<String> moreOptionList = new ArrayList<>(Arrays
                .asList("Refund/Issue credit note", "Mail", "Download", "Print", "View Candidate Details"));
        Assert.assertTrue(billingDashboardPagePO.visibilityOfAllOptionsUnderMoreOptionsWithList("Payment Receipt", moreOptionList), "All more options are not visible after payment.");
    }

    @And("mouse hover on amount paid and verify the details on amount paid")
    public void mouseHoverOnAmountPaidAndVerifyTheDetailsOnAmountPaid() {
        Map<String, String> candidateDetails= new HashMap<String, String>();
        candidateDetails.put("Amount paid:", enteredAmount);
        candidateDetails.put("Total amount payable:", "180000");
        Assert.assertTrue(billingDashboardPagePO.verifyOptionsOnHover("Amount paid","Paid", candidateDetails), "Incorrect values are displayed on mouse hover on Amount Paid");
    }

    @Then("the candidate should still be displayed in paid tab")
    public void theCandidateShouldStillBeDisplayedInPaidTab() {
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName), "Candidate is disappeared without sending the payment receipt");
    }

    @And("click on refund in more options")
    public void clickOnRefundInMoreOptions() {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName,"Refund/Issue credit note");
    }

    @Then("validate the refunded details page")
    public void validateTheRefundedDetailsPage() {

        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Issue Credit Note"), "Issue credit Note not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Refund in another mode"), "refund in another note not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Full Refund"), "full refund not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Partial Refund"), "partial refund not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyAllDDValuesAreCorrectInPaidOverlay("Refund Mode"), "refund mode options not correct");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Transaction Number"), "transaction no not visible");
        previewGenerateOverlayBillingDashboardPO.clickDDButton();
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyFullPaymentRefund(getAmountToBePaid), "full refunded amount not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.checkButtonDisabled(), "without filling details mark as refunded button is enabled");

    }

    @When("choose refund mode as cheque")
    public void chooseRefundModeAsCheque() {
        previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Refund Mode", "Cheque");

    }

    @And("click on Mark as refunded")
    public void clickOnMarkAsRefunded() {
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark as Refunded");
    }

    @Then("validate the mail refund lightbox")
    public void validateTheMailRefundLightbox() {
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyMailBoxPresent(), "mail box is visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTxtAreaInViewContainer("To:","input"), "To field in mail not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTxtAreaInViewContainer("Cc:","input"), "CC field in mail not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTxtAreaInViewContainer("From:","span"), "From field in mail not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("From:","span").equals(YamlReader.getAppConfigValue("Users.ConsultantPlus.Superuser.username")), "consultant name not correct");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Subject:","input").contains("Refund for"), "subject field not visible");
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.checkButtonDisabled(), "without filling To: Mail refund button is enabled");

    }

    @When("click on cancel button")
    public void clickOnCancelButton() {
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Then("the candidate tuple should be visible on refunded tab and no longer on paid tab")
    public void theCandidateTupleShouldBeVisibleOnRefundedTabAndNoLongerOnPaidTab() {
        Assert.assertTrue(billingDashboardPagePO.statusChangedToRefunded(BillingAPI.candidateName,getInvoiceName), "status of application not changed to refunded ");
        billingDashboardPagePO.clickStatusStrip();
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName), "candidate visible in refunded tab");
    }

    @And("click on refunded strip")
    public void clickOnRefundedStrip() {
        billingDashboardPagePO.clickStatusStrip();
    }

    @Then("verify the candidate details on refunded tab")
    public void verifyTheCandidateDetailsOnRefundedTab() {
        Assert.assertTrue(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName,"IN").equals(BillingAPI.candidateName), "invoice name not visible");
        Assert.assertEquals(
                PilotApplicationInboxStepDef.offeredCandidateDetails
                        .get("Offered designation".replaceAll(" ", "_").toUpperCase().replaceAll(":", "")),
                billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Offered designation"));
        Assert.assertTrue(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName,"Amount refunded").equals("180000"), "amount refunded not visible");
//        Assert.assertEquals("refunded on not visible",billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName,"Refunded on"),new SimpleDateFormat("d MMM yyyy").format(Calendar.getInstance().getTime()));
        Assert.assertTrue(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName,"Refund Mode").equals("CHEQUE"), "refund mode not visible");
        Map<String, String> detailsOnAmountRefunded= new HashMap<String, String>();
        detailsOnAmountRefunded.put("TOTAL_AMOUNT_PAYABLE","180000");
        detailsOnAmountRefunded.put("AMOUNT_PAID","180000");
        detailsOnAmountRefunded.put("AMOUNT_REFUNDED","180000");
        Assert.assertTrue(billingDashboardPagePO.verifyListOfOptionsOnHover("Amount refunded","Refunded", detailsOnAmountRefunded), "Incorrect values are displayed on mouse hover on amount refunded");

    }

    @And("refunded tag and mouse hover on more options should be visible on the tuple")
    public void refundedTagAndMouseHoverOnMoreOptionsShouldBeVisibleOnTheTuple() {
//        Assert.assertEquals("Refunded tag not visible",billingDashboardPagePO.getCurrentStatus(APITestOps.candidateName),"REFUNDED");
        billingDashboardPagePO.pageRefresh();
        billingDashboardPagePO.clickOnTab("Refunded");
        billingDashboardPagePO.hoverOnElement(BillingAPI.candidateName);
//        Assert.assertTrue(billingDashboardPagePO.visibilityOfAllOptionsUnderMoreOptions("REFUNDED","Refunded", "Payment Receipt"),
//                "All More Options are not Visible !!!!!!!!");
    }

    @And("verify the suboptions in more options")
    public void verifyTheSuboptionsInMoreOptions() {
        Assert.assertTrue(billingDashboardPagePO.verifyHiringForDetailVisible(PilotApplicationInboxStepDef.offeredCandidateDetails,BillingAPI.candidateName), "hiring for not visble");
        billingDashboardPagePO.clickOnTabAfterRefresh("Refunded");
        billingDashboardPagePO.hoverOnElement(BillingAPI.candidateName);
//        Assert.assertTrue(billingDashboardPagePO.verifySuboptions("REFUNDED","Refunded", "Mail","Payment Receipt"), "suboptions under mail not visible");
        billingDashboardPagePO.clickOnTabAfterRefresh("Refunded");
        billingDashboardPagePO.hoverOnElement(BillingAPI.candidateName);
//        Assert.assertTrue(billingDashboardPagePO.verifySuboptions("REFUNDED","Refunded", "Download","Payment Receipt"), "suboptions under download not visible");
        billingDashboardPagePO.clickOnTabAfterRefresh("Refunded");
        billingDashboardPagePO.hoverOnElement(BillingAPI.candidateName);
//        Assert.assertTrue(billingDashboardPagePO.verifySuboptions("REFUNDED","Refunded", "Print","Payment Receipt"), "suboptions under print not visible");
    }

    @And("invoice,payment receipt,hiring for should be visible on tuple")
    public void invoicePaymentReceiptHiringForShouldBeVisibleOnTuple() {
        Assert.assertTrue(billingDashboardPagePO.visibilityOfFooterLinks(BillingAPI.candidateName,"Invoice"), "invoice not visible in footer");
        Assert.assertTrue(billingDashboardPagePO.visibilityOfFooterLinks(BillingAPI.candidateName, "Payment Receipt"), "Payment receipt not visible");
    }

    @And("^click on refund/issue credit note$")
    public void clickOnRefundIssueCreditNote() {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, "Refund/Issue credit note");
    }

    @Then("the candidate should be moved to refunded tab")
    public void theCandidateShouldBeMovedToRefundedTab() {
        billingDashboardPagePO.clickOnTab("Refunded");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName), "Candidate is not displaying in refunded tabafter full payment");
    }

    @And("credit note option will also be displayed on the tuple in refunded tab")
    public void creditNoteOptionWillAlsoBeDisplayedOnTheTupleInRefundedTab() {
        Assert.assertTrue(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Refund Mode").contains("CREDIT NOTE"), "Correct Refund mode is not displaying on Candidate tuple");
    }

    @Then("credit note footer should be visible on paid tab")
    public void creditNoteFooterShouldBeVisibleOnPaidTab() {
        Assert.assertTrue(billingDashboardPagePO.visibilityOfFooterLinks(BillingAPI.candidateName, "Credit Note"), "Credit note is not displaying in the Footer");
    }

    @And("candidate tuple will also be visible on refunded tab")
    public void candidateTupleWillAlsoBeVisibleOnRefundedTab() {
        billingDashboardPagePO.clickOnTab("Refunded");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName), "Candidate is not displaying in refunded tab after partial payment");    }

    @And("credit note footer should also be visible on refunded tab")
    public void creditNoteFooterShouldAlsoBeVisibleOnRefundedTab() {
        Assert.assertTrue(billingDashboardPagePO.visibilityOfFooterLinks(BillingAPI.candidateName, "Credit Note"), "Credit note link is not displaying on Footer in refunded tab");

    }

    @And("verify the candidate details on mouse hover on amount refunded")
    public void verifyTheCandidateDetailsOnMouseHoverOnAmountRefunded() {
        Map<String, String> candidateDetails= new HashMap<String, String>();
        candidateDetails.put("Amount paid:", enteredAmount);
        candidateDetails.put("Total amount payable:", "180000");
        candidateDetails.put("Amount refunded:", "10000");
        Assert.assertTrue(billingDashboardPagePO.verifyOptionsOnHover("Amount refunded", "Refunded", candidateDetails), "Incorrect details are displaying on mouse hover on Amount reunfed option on tuple.");
    }

    @When("click on writeoff and do full written off amount")
    public void clickOnWriteoffAndDoFullWrittenOffAmount() {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, "Writeoff");
        writeOffInvoiceOverlayPO.clickWriteOffRadioButton("Full writeoff");
        writeOffInvoiceOverlayPO.clickAnyButtonOnModalFooter("Writeoff");
    }

    @Then("candidate is moved to writtenoff tab link should be displayed")
    public void candidateIsMovedToWrittenoffTabLinkShouldBeDisplayed() {
        Assert.assertTrue(billingDashboardPagePO.getCommunicationMessageAfterTheMovementOfCandidateAcrossTuple(BillingAPI.candidateName).contains("Writen Off"), "Movement message is not displaying");
    }

    @Then("the candidate should be displayed in writtenoff tab")
    public void theCandidateShouldBeDisplayedInWrittenoffTab() {
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName), "Candidate is not displaying in the Written off tab after Write off full amount");
    }

    @And("validate the details on writtenoff tab")
    public void validateTheDetailsOnWrittenoffTab() {
        Assert.assertTrue(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Amount written off").contains("180000"), "incorrect Amount details is displaying.");
    }


    @And("validate mouse hover more options")
    public void validateMouseHoverMoreOptions() {
        ArrayList<String> moreOptionList = new ArrayList<>(Arrays
                .asList("Mail", "Download", "Print", "View Candidate Details"));
        Assert.assertTrue(billingDashboardPagePO.visibilityOfAllOptionsUnderMoreOptionsWithList("Invoice", moreOptionList), "Correct options are not displaying on more hover.");

    }

    @And("verify the candidate details on mouse hover on candidate name and amount written off tab")
    public void verifyTheCandidateDetailsOnMouseHoverOnCandidateNameAndAmountWrittenOffTab() {
        Map<String, String> candidateDetails= new HashMap<String, String>();
        candidateDetails.put("Amount written off:", "180000");
        candidateDetails.put("Total amount payable:", "180000");
        Assert.assertTrue(billingDashboardPagePO.verifyOptionsOnHover("Amount written off", "Written Off", candidateDetails), "Incorrect details are displaying on mouse hover on Amount written off on tuple.");
        candidateDetails.clear();
        //Assert.assertTrue("Incorrect Details are displaying on hover on candidate name in written off tab",billingDashboardPagePO.verifyListOfOptionsOnHover("IN", "Written Off", ViewApplicationDetailPageStepDefs.offeredCandidateDetails));
    }

    @And("On Label Amount written off , On mouse hover show Written Off Tab Information")
    public void onLabelAmountWrittenOffOnMouseHoverShowWrittenOffTabInformation() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("TOTAL_AMOUNT_PAYABLE", "180000");
        map.put("AMOUNT_WRITTEN_OFF", "18000");
        Assert.assertTrue(billingDashboardPagePO.verifyListOfOptionsOnHover(
                        "Amount written off", "Written Off", map), "The hover options are not same!!!");
    }

    @And("click on cancel and continue")
    public void clickOnCancelAndContinue() {
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @When("search for created employer")
    public void searchForCreatedEmployer() {
        billingDashboardPagePO.selectEmployerFromSearchEmployerDD(BillingAPI.employerName);
    }

    @Then("Issued credit note amount should be displayed on finanace matrix in credit left section")
    public void issuedCreditNoteAmountShouldBeDisplayedOnFinanaceMatrixInCreditLeftSection() {
        Assert.assertTrue(billingDashboardPagePO.getValueFromFinanceMatrix("Credit left").contains("500"), "Incorrect amount is displaying in the Finanace matrix for credit note");
    }

    @And("enter the {int} amount in credit use and click on mark paid")
    public void enterTheAmountInCreditUseAndClickOnMarkPaid(int salaryAmount) {
        enteredAmount= previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(""+salaryAmount , "Use credit Amount" , "input");
        paidOn= viewApplicationDetailPagePO.selectDateInCalender("Paid On", 1);
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark Paid");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Then("credit amount should be deducted from credit left on finance matrix")
    public void creditAmountShouldBeDeductedFromCreditLeftOnFinanceMatrix() {
        Assert.assertTrue(billingDashboardPagePO.getValueFromFinanceMatrix("Credit left").contains("400"), "incorrect credit amount deducted from credit note");
    }

    @And("enter the {int} amount with {int} as TDS and click on mark paid")
    public void enterTheAmountWithAsTDSAndClickOnMarkPaid(int salaryAmount, int TDS) {
        enteredAmount= previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(""+salaryAmount , "Payment Amount" , "input");
        previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(""+TDS , "TDS Amount" , "input");
        paidOn= viewApplicationDetailPagePO.selectDateInCalender("Paid On", 1);
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark Paid");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Then("mouse hover on {string} on finance matrix TDS amount and payment amount should be displayed")
    public void mouseHoverOnOnFinanceMatrixTDSAmountAndPaymentAmountShouldBeDisplayed(String blockType) {
        Assert.assertTrue(billingDashboardPagePO.getValueFromFinanceMatrixOnMouseHover(blockType, "TDS").contains("100"), "incorrect amount is displaying in TDS");
        Assert.assertTrue(billingDashboardPagePO.getValueFromFinanceMatrixOnMouseHover(blockType, "Actual Received").contains("2000"), "incorrect amount is displaying in TDS");
    }

    @And("user fill {int} in Enter Amount for partial refund")
    public void userFillInEnterAmountForPartialRefund(int refundAmount) {
        previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(""+refundAmount, "Enter Amount", "input");
        previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Refund Mode", "Cash");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark as Refunded");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Then("mouse hover on {string} on finance matrix refunded amount and payment amount should be displayed")
    public void mouseHoverOnOnFinanceMatrixRefundedAmountAndPaymentAmountShouldBeDisplayed(String blockType) {
        Assert.assertTrue(billingDashboardPagePO.getValueFromFinanceMatrixOnMouseHover(blockType, "Refunded").contains("500"), "incorrect amount is displaying in Refunded after mouse hover");
        Assert.assertTrue(billingDashboardPagePO.getValueFromFinanceMatrix(blockType).contains("1600"), "incorrect amount is displaying in Received section");
    }

    @Then("{string} amount on finance matrix as {string} should be displayed")
    public void amountOnFinanceMatrixAsShouldBeDisplayed(String leftAmount, String blockType) throws Throwable {
        Assert.assertTrue(billingDashboardPagePO.getValueFromFinanceMatrix(blockType).contains(leftAmount), "incorrect amount is displaying in Received section");
    }

    @And("Total invoice amount should be displayed on finanace matrix as {string}")
    public void totalInvoiceAmountShouldBeDisplayedOnFinanaceMatrixAs(String blockType) {
        Assert.assertTrue(billingDashboardPagePO.getValueFromFinanceMatrix(blockType).contains("179400"), "incorrect amount is displaying in Received section");
    }

    @Then("calculation of amount should be displayed with TDS on mouse hover on {string} in finanace matrix")
    public void calculationOfAmountShouldBeDisplayedWithTDSOnMouseHoverOnInFinanaceMatrix(String blockType) {
        Assert.assertTrue(billingDashboardPagePO.getValueFromFinanceMatrix(blockType).contains("1100"), "incorrect amount is displaying in Received section");
        Assert.assertTrue((billingDashboardPagePO.getValueFromFinanceMatrixOnMouseHover(blockType, "Actual Received")+billingDashboardPagePO.getValueFromFinanceMatrixOnMouseHover(blockType, "TDS")).contains("1000"), "incorrect amount is displaying in TDS");
    }

    @Given("user create three candidate with same employer and default billing address and details")
    public void userCreateThreeCandidateWithSameEmployerAndDefaultBillingAddressAndDetails() {
        BillingAPI billingAPI = new BillingAPI();
        String timeStamp1 = ""+ BasicTestOps.generateRandomStrings(10,"Number");
        String timeStamp2 = ""+ BasicTestOps.generateRandomStrings(10,"Number");
        String timeStamp3 = ""+ BasicTestOps.generateRandomStrings(10,"Number");
        candidateData = billingAPI.createMultipleCandidatesForSingleEmployer(new String[] {"Candidate-"+timeStamp1 , "Candidate-"+timeStamp2 , "Candidate-"+timeStamp3}, new String[] {"can"+timeStamp1+"@yopmail.com" , "can"+timeStamp2+"@yopmail.com" , "can"+timeStamp3+"@yopmail.com"}, new String[] {"Req-"+timeStamp1, "Req-"+timeStamp2 , "Req-"+timeStamp3}, BillingAPI.employerName, "29374", 3);
        for(int i = 0 ; i < candidateData.length ; i++) {
            System.out.println(candidateData[i]);
            viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidateData[i]);
            viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
            viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "600000", 1, "", 30);
        }
    }

    @And("user click generate invoice for all three candidates")
    public void userClickGenerateInvoiceForAllThreeCandidates() {
        for(int i = 0 ; i < candidateData.length ; i++) {
            billingDashboardPagePO.clickOnOptionsInMoreOptions(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[i]).toString() , "candidateProfile[name]", 0) , "Generate Invoice");
            previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
            previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
            previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
            System.out.println("***********" + i);
        }
    }

    @When("^user create an employer$")
    public void userCreateAnEmployer() throws Throwable {
        employerName=billing.createEmployerWithOptions(Arrays.asList("percentage","percentage","percentage"), Arrays.asList("70","80","90"), 100, 120, Arrays.asList(true,true,true), 3, 3);
    }

    @And("user click on Mark Paid button for firstCandidate")
    public void userClickOnMarkPaidButtonForFirstCandidate() {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[0]).toString() , "candidateProfile[name]", 0 ), "Mark Paid");
    }

    @And("^click on refund/issue credit note for first candidate$")
    public void clickOnRefundIssueCreditNoteForFirstCandidate() {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[0]).toString(), "candidateProfile[name]", 0 ),"Refund/Issue credit note");
    }

    @And("user click on Mark Paid button for secondCandidate")
    public void userClickOnMarkPaidButtonForSecondCandidate() {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[1]).toString() , "candidateProfile[name]", 0 ), "Mark Paid");
    }

    @And("^click on refund/issue credit note for second candidate$")
    public void clickOnRefundIssueCreditNoteForSecondCandidate() {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[1]).toString(), "candidateProfile[name]", 0 ),"Refund/Issue credit note");
    }

    @And("user click on Mark Paid button for thirdCandidate")
    public void userClickOnMarkPaidButtonForThirdCandidate() {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[2]).toString() , "candidateProfile[name]", 0 ), "Mark Paid");
    }

    @Then("Total amount {string} of credit amount should be displayed on payment generation slip")
    public void totalAmountOfCreditAmountShouldBeDisplayedOnPaymentGenerationSlip(String arg0) {
        billingDashboardPagePO.getCreditNoteAmountOnPaymentReceipt().contains(arg0);
    }

    @And("user create three candidate with different employer and default billing address and details")
    public void userCreateThreeCandidateWithDifferentEmployerAndDefaultBillingAddressAndDetails() {
        String timeStamp1 = ""+ BasicTestOps.generateRandomStrings(10,"Number");
        String timeStamp2 = ""+ BasicTestOps.generateRandomStrings(10,"Number");
        String timeStamp3 = ""+ BasicTestOps.generateRandomStrings(10,"Number");
        candidateData = billing.createMultipleCandidatesForSingleEmployer(new String[] {"Candidate-"+timeStamp1 , "Candidate-"+timeStamp2 , "Candidate-"+timeStamp3}, new String[] {"can"+timeStamp1+"@yopmail.com" , "can"+timeStamp2+"@yopmail.com" , "can"+timeStamp3+"@yopmail.com"}, new String[] {"Req-"+timeStamp1, "Req-"+timeStamp2 , "Req-"+timeStamp3}, employerName, "29374", 3);
        for(int i = 0 ; i < candidateData.length ; i++) {
            viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidateData[i]);
            viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
            viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "600000", 1, "", 30);
        }
    }

    @And("search for specific created employer")
    public void searchForSpecificCreatedEmployer() {
        billingDashboardPagePO.selectEmployerFromSearchEmployerDD(employerName);
    }

    @And("user click on generate proforma invoice")
    public void userClickOnGenerateProformaInvoice() {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BillingAPI.candidateName, "Generate Proforma Invoice");
    }

    @When("user select one of the other {string} HSN Code")
    public void userSelectOneOfTheOtherHSNCode(String arg0) {
        previewGenerateOverlayBillingDashboardPO.clickOnEditButtonToEditLayout();
        if (arg0.equals("MODIFIED")) {
            previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("HSN Code", InvoiceSettingsStepDef.timeStamp);
        }else {
            previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("HSN Code", arg0);
        }
        previewGenerateOverlayBillingDashboardPO.clickOnSaveButtonToSaveLayout();
    }

    @Then("HSN Code should be {string}")
    public void hsnCodeShouldBe(String string) {
        if(string.equals("MODIFIED")) {
            Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed(InvoiceSettingsStepDef.timeStamp), InvoiceSettingsStepDef.timeStamp+" is not pre-selected for HSN Code !!!");
        }else {
            Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed(string), string+" is not pre-selected for HSN Code !!!");
        }
    }

    @And("In {string} tab Btn {string} should be working")
    public void inTabBtnShouldBeWorking(String tabName, String btnText) {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BillingAPI.candidateName, btnText);
        Assert.assertTrue(billingDashboardPagePO.visibilityOfButtonOnBillingdashboard(BillingAPI.candidateName, btnText), "gajhsdg");
        billingDashboardPagePO.goToBillingDashboardPage();
        billingDashboardPagePO.clickOnTab(tabName);
    }

    @Then("Link {string} should be working")
    public void linkShouldBeWorking(String linkText) {
        billingDashboardPagePO.clickOnLinkOnFooter(BillingAPI.candidateName, linkText);
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Proforma Invoice preview for PI"), "hnbgv");
        previewGenerateOverlayBillingDashboardPO.clickOnCrossBtnInPreviewOverlay();
    }
    
    @Given("I go to billing dashboard page")
    public void i_go_to_billing_dashboard_page() {
        billingDashboardPagePO.goToBillingDashboardPage();
    }

    @Given("I generate PI of already added candidate whose PI is not generated yet and get its billable salary mentioned")
    public void i_generate_PI_of_already_added_candidate_whose_PI_is_not_generated_yet_and_get_its_billable_salary_mentioned() {
    	latestCandidateName=billingDashboardPagePO.getLastAddedCandidateWithoutPIAlreadyGenerated();
	    billingDashboardPagePO.clickOnButtonOnBillingdashboard(latestCandidateName, "Generate Proforma Invoice");
	    billableSalary=previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Candidate's billable salary", "input").replaceAll("[^0-9]", "");
	    previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Proforma Invoice");
	    previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");	
    }

    @When("I click on edit generate proforma invoice")
    public void i_click_on_edit_generate_proforma_invoice() {
    	billingDashboardPagePO.clickOnOptionsInMoreOptions(latestCandidateName, "Edit Proforma Invoice");
    }

    @When("I select Others for invoice rate")
    public void i_select_Others_for_invoice_rate() {
    	previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Choose an invoice rate to be applied", "Others");
    }

    @Then("Verify Enter Billing Amount value is empty")
    public void verify_Enter_Billing_Amount_value_is_empty() {
    	Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Candidate's billable salary", "input").replaceAll("[^0-9]", "").contains(billableSalary),"Billable Salary is empty !!!");
 	    Assert.assertTrue(!previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Enter Billing Amount", "input").isEmpty(),"Enter Billing Amount field isn't Empty !!!!");
    }

    @When("I enter {string} in Enter Billing Amount field")
    public void i_enter_in_Enter_Billing_Amount_field(String arg1) {
    	previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(arg1, "Enter Billing Amount", "input");
    }

    @Then("Verify Payable Amount in the Invoice Layout and Top Section is same")
    public void verify_Payable_Amount_in_the_Invoice_Layout_and_Top_Section_is_same() {
    	Assert.assertEquals(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Payable Amount ", "span").replaceAll("[^0-9]", "").equalsIgnoreCase("1111"), previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInServiceDescriptionTable("Payable Amount").replaceAll("[^0-9]", "").equalsIgnoreCase("1111"), 
    			"Payable Amount is different in top section and invoice layout !!!");
    	TestNGLogUtility.pass("Payable Amount is same in top section and invoice layout !!");
    }
    
    @Given("I go to Account settings page and manage template section")
    public void i_go_to_Account_settings_page_and_manage_template_section() {
//    	commonAction.clickOnOptionsOnUsername("Account Settings");
    	settingsPO.clickOnManageEmailTemplate();
    }

    @Given("I add a new proforma invoice template with content")
    public void i_add_a_new_proforma_invoice_template_with_content() {
    	manageTemplatePO.clickOnAddNewTemplateBtn();
	    manageTemplatePO.chooseFinanceOption();
	    manageTemplatePO.clickOnCategoryList();
	    manageTemplatePO.clickOnParticularCategory("Proforma invoice");
	    manageTemplatePO.clearPreviousSubjAndFillNew("Proforma Temp Subject - "+timeStamp);
	    manageTemplatePO.clearPreviousBodyAndFillNew("Proforma Temp body - "+timeStamp);
	    String tempName=manageTemplatePO.enterTemplateName("Proforma Temp - "+timeStamp);
	    manageTemplatePO.verifyFinanaceTemplateCreated(tempName);
    }

    @Given("I go to Billing dashboard and click on generate proforma invoice of any candidate")
    public void i_go_to_Billing_dashboard_and_click_on_generate_proforma_invoice_of_any_candidate() {
    	billingDashboardPagePO.goToBillingDashboardPage();
	    latestCandidateName=billingDashboardPagePO.getLastAddedCandidateInToBeGeneratedTab();
	    boolean flag=billingDashboardPagePO.visibilityOfFooterLinks(latestCandidateName, "Proforma Invoice");
	    if(flag) {
	    	billingDashboardPagePO.clickOnOptionsInMoreOptions(latestCandidateName, "Edit Proforma Invoice");
	    } else {
	    billingDashboardPagePO.clickOnButtonOnBillingdashboard(latestCandidateName, "Generate Proforma Invoice");
	    }
    }

    @Given("I click on generate proforma invoice button")
    public void i_click_on_generate_proforma_invoice_button() {
    	totalAmount = previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Total Amount");
		dueDate = previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Due Date");
		piDate = previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Invoice Date");
	    previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Proforma Invoice");
    }

    @When("I select newly added template while sending proforma invoice mail")
    public void i_select_newly_added_template_while_sending_proforma_invoice_mail() {
    	mailPage.selectValueFromDDInViewContainer("Prefill from Template", "Proforma Temp - "+timeStamp);
    }

    @Then("Selected template content should be displayed")
    public void selected_template_content_should_be_displayed() {
    	Assert.assertEquals("Proforma Temp Subject - "+timeStamp, mailPage.getSubjectMailPage(),"Subject of proforma invoice mail is incorrect for templates !!!!");
  	    Assert.assertEquals("Proforma Temp body - "+timeStamp, mailPage.getBodyMailPage(),"Body content of proforma invoice mail is incorrect for templates !!!!");
    }

    @Then("Same should be displayed in mail preview")
    public void same_should_be_displayed_in_mail_preview() {
    	manageEmployer.click_on_Element("Preview Mail");
		Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayedInMailPreviewOverlay("Proforma Temp Subject - "+timeStamp),"Subject of proforma invoice mail is not displayed in preview mail !!!!");
		Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayedInMailPreviewOverlay("Proforma Temp body - "+timeStamp),"Body content of proforma invoice mail is not displayed in preview mail !!!!");
		previewGenerateOverlayBillingDashboardPO.clickOnAnyElementInMailPreviewOverlay("CLOSE");
    }

    @When("I select all the financial mail tags and click on preview")
    public void i_select_all_the_financial_mail_tags_and_click_on_preview() {
    	mailPage.enterMailBody("Financial tags");
    	mailPage.selectFinancialMailTagsForMailBody("Finance","Proforma Invoice Amount");
    	mailPage.selectFinancialMailTagsForMailBody("Finance","Proforma Date");
    	mailPage.selectFinancialMailTagsForMailBody("Finance","Due Date");
    	manageEmployer.click_on_Element("Preview Mail");
    }

    @Then("Values of financial email tags should be correct")
    public void values_of_financial_email_tags_should_be_correct() {
    	piDate=BasicTestOps.getDateInSpecificFormat("dd-MM-yyyy", "d MMM yyyy", piDate);
		dueDate=BasicTestOps.getDateInSpecificFormat("dd-MM-yyyy", "d MMM yyyy", dueDate);
//	    Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayedInMailPreviewOverlay(totalAmount.replaceAll("â‚¹", "").replaceAll(" ", "").replaceAll(",", "").trim()),"Body content with finacial tags are incorrect !!!!");
	    Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayedInMailPreviewOverlay(piDate),"Body content with finacial tags are incorrect !!!!");
	    Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayedInMailPreviewOverlay(dueDate),"Body content with finacial tags are incorrect !!!!");
    }

    @Then("Proforma Invoice is attached with this mail should be displayed in footer")
    public void proforma_Invoice_is_attached_with_this_mail_should_be_displayed_in_footer() {
    	Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayedInMailPreviewOverlay("  Proforma Invoice is attached with this mail  "),"Invoice Attached isn't visible !!!!");
		previewGenerateOverlayBillingDashboardPO.clickOnAnyElementInMailPreviewOverlay("CLOSE");
    }

    @When("I send the proforma invoice mail for the added candidate")
    public void i_send_the_proforma_invoice_mail_for_the_added_candidate() {
    	manageEmployer.fillTextAreaOrInputTextBoxInViewContainer(timeStamp+"emailId@abc.xyz", "To:", "input");
		manageEmployer.enterMessage();
	    mailPage.clickOnSendButton();
    }

    @Then("Verify {string} text should not be displayed and right date should be there")
    public void verify_text_should_not_be_displayed_and_right_date_should_be_there(String arg1) {
    	Assert.assertTrue(billingDashboardPagePO.getDetailsOnFooterOnrightCorner(latestCandidateName, "Last mail sent on").equalsIgnoreCase(new SimpleDateFormat("d MMM yyyy").format(Calendar.getInstance().getTime())),arg1+" is displayed with mail sent !!!!");;
    }
    
    @Given("I create candidate with default settings and move the candidate to Billing Stage")
    public void i_create_candidate_with_default_settings_and_move_the_candidate_to_Billing_Stage() {
    	viewApplicationDetailPagePO.generateCandidateIdWithEmployerOfRMSConsultantviaAPI("flat", "20000", 10, 180, "false");
 	    viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
 	    viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation"+timeStamp, "1200000", 1, "1020090", 15);
    }

    @Given("I go to billing dashboard page and generate the invoice of the added candidate")
    public void i_go_to_billing_dashboard_page_and_generate_the_invoice_of_the_added_candidate() {
    	billingDashboardPagePO.goToBillingDashboardPage();
		billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, "Generate Invoice");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Given("I go to Outstanding tab via link of success message of successfully moving candidate to Outstanding tab")
    public void i_go_to_Outstanding_tab_via_link_of_success_message_of_successfully_moving_candidate_to_Outstanding_tab() {
    	billingDashboardPagePO.clickOnTabLinkInSuccessMsgAfterMovingCandidateFromOneTabtoAnother("Outstanding");
    }

    @When("I click on Mark as paid for the added candidate")
    public void i_click_on_Mark_as_paid_for_the_added_candidate() {
    	billingDashboardPagePO.clickOnButtonOnBillingdashboard(BillingAPI.candidateName, "Mark Paid");
    }

    @When("I enter more than {int} decimal places values in Payment Amount and TDS")
    public void i_enter_more_than_decimal_places_values_in_Payment_Amount_and_TDS(Integer int1) {
    	previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("11.111", "Payment Amount", "input");
  	    previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("11.111", "TDS Amount", "input");
    }

    @Then("Verify error message as {string} for both amount and TDS")
    public void verify_error_message_as_for_both_amount_and_TDS(String errorMessage) {
    	Assert.assertEquals(errorMessage, previewGenerateOverlayBillingDashboardPO.getUnderlyingErrorMsgOrInfoOfFieldsInViewContainer("Payment Amount", "error"),"Error message isn't displayed for Payment Amount with more than 2 decimal places !!!!");
		Assert.assertEquals(errorMessage, previewGenerateOverlayBillingDashboardPO.getUnderlyingErrorMsgOrInfoOfFieldsInViewContainer("Payment Amount", "error"),"Error message isn't displayed for TDS with more than 2 decimal places ");
    }

    @Then("Mark paid button should be disabled")
    public void mark_paid_button_should_be_disabled() {
    	boolean flag=previewGenerateOverlayBillingDashboardPO.verifyButtonIsDisabledInFooter("Mark Paid");
		Assert.assertTrue(flag,"Mark Paid button is not disabled !!!");
    }

    @When("I mark as paid with partial payment")
    public void i_mark_as_paid_with_partial_payment() {
    	previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("10200.12", "Payment Amount", "input");
	    previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("9799.87", "TDS Amount", "input");
	    previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark Paid");
	    previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @When("I click on refund or issue credit note for the paid amount")
    public void i_click_on_refund_or_issue_credit_note_for_the_paid_amount() {
    	billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, "Refund/Issue credit note");
    }

    @When("While using partial refund if i enter more than paid amount")
    public void while_using_partial_refund_if_i_enter_more_than_paid_amount() {
    	manageEmployer.click_on_Element("Issue Credit Note");
		manageEmployer.click_on_Element("Partial Refund");
		previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("50000", "Enter Amount", "input");
    }

    @Then("Mark as refunded button should be disabled and I should get Amount cannot be greater than the paid amount error")
    public void mark_as_refunded_button_should_be_disabled_and_I_should_get_Amount_cannot_be_greater_than_the_paid_amount_error() {
    	Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getUnderlyingErrorMsgOrInfoOfFieldsInViewContainer("Enter Amount", "error").contains("Amount cannot be greater than 19,999.99"),"Error message isn't displayed for Amount refunded with more than paid amount !!!!");
		boolean flag=previewGenerateOverlayBillingDashboardPO.verifyButtonIsDisabledInFooter("Mark as Refunded");
		Assert.assertTrue(flag,"Mark Paid button is not disabled !!!");
    }
    
    @When("I refund paid amount as credit note")
    public void i_refund_paid_amount_as_credit_note() {
    	billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, "Refund/Issue credit note");
		manageEmployer.click_on_Element("Issue Credit Note");
		manageEmployer.click_on_Element("Partial Refund");
		previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("19999.99", "Enter Amount", "input");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark as Refunded");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @When("I click on mark as paid button")
    public void i_click_on_mark_as_paid_button() {
    	billingDashboardPagePO.clickOnButtonOnBillingdashboard(BillingAPI.candidateName, "Mark Paid");
    }

    @When("I click on Use Credit link")
    public void i_click_on_Use_Credit_link() {
    	  manageEmployer.click_on_Element("Use Credit");
    }

    @When("I click on Don't use credit link")
    public void i_click_on_Don_t_use_credit_link() {
    	manageEmployer.click_on_Element("Don't use credit");
    }

    @Then("Verify Credit associated fields are not displayed")
    public void verify_Credit_associated_fields_are_not_displayed() {
    	 Assert.assertFalse(manageEmployer.click_on_Element("Use credit Amount", 1),"Credit associated fields are displayed without using credit link !!!!");
    }
    
    @Given("I create candidate with {int} days as Bill becomes due after and {int} days for Remind to generate Invoice and move the candidate to Billing Stage")
    public void i_create_candidate_with_days_as_Bill_becomes_due_after_and_days_for_Remind_to_generate_Invoice_and_move_the_candidate_to_Billing_Stage(Integer arg1, Integer arg2) {
    	viewApplicationDetailPagePO.generateCandidateIdWithEmployerOfRMSConsultantviaAPI("percentage", "10", arg2, arg1, "false");
		viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
		viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "1000000", 0, "100000", 0);
		billingDashboardPagePO.goToBillingDashboardPage();
    }

    @Then("Waring message {string} should not be displayed under candidate tuple")
    public void waring_message_should_not_be_displayed_under_candidate_tuple(String arg1) {
    	 Assert.assertFalse(billingDashboardPagePO.warningMessageFromToBeGenerated(BillingAPI.candidateName).contains(arg1),"Warning message is should not be displayed !!!!");
    }

    @When("I delete all the registered addresses")
    public void i_delete_all_the_registered_addresses() {
        manageEmployer.clickOnDeleteEditForAllRegisteredAddress("Delete");
    }
    
    @Given("I create multiple candidates for a single employer with multiple addresses and percentage mode of billing and move all the candidates to billing dashboard")
    public void i_create_multiple_candidates_for_a_single_employer_with_multiple_addresses_and_percentage_mode_of_billing_and_move_all_the_candidates_to_billing_dashboard() {
	    employerName=billing.createEmployerWithOptions(Arrays.asList("percentage","percentage","percentage"), Arrays.asList("70","80","90"), 100, 120, Arrays.asList(true,true,true), 3, 3);
	    String timeStamp1 = ""+BasicTestOps.generateRandomStrings(10, "Number");
	    String timeStamp2 = ""+BasicTestOps.generateRandomStrings(10, "Number");
	    String timeStamp3 = ""+BasicTestOps.generateRandomStrings(10, "Number");
	    candidatedata = billing.createMultipleCandidatesForSingleEmployer(new String[] {"Candidate-"+timeStamp1, "Candidate-"+timeStamp2, "Candidate-"+timeStamp3},new String[] {"can"+timeStamp1+"@yopmail.com", "can"+timeStamp1+"@yopmail.com", "can"+timeStamp1+"@yopmail.com"},new String[] {"Req-"+timeStamp1, "Req-"+timeStamp2, "Req-"+timeStamp3}, employerName, "29374", 3);
	    for(int i=0;i<candidatedata.length;i++) {
	    	viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidatedata[i]);
	    	viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
	    	viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "1000000", 1, "100000", 30);
	    }
	    billingDashboardPagePO.goToBillingDashboardPage();
	}

    @Given("Generate Invoice of first candidate selecting other than default address and save the address")
    public void generate_Invoice_of_first_candidate_selecting_other_than_default_address_and_save_the_address() {
    	String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[0]).toString();
		String candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
		billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Generate Invoice");
		String employerData=BillingAPI.employerDataByEmployerNameAsJSON.get(employerName).toString();
		String secondAddressOfEmployer = BasicTestOps.getSpecificValueFromJSON(employerData, "address", 1);
		previewGenerateOverlayBillingDashboardPO.clickOnEditButtonToEditLayout();
		previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Bill to", secondAddressOfEmployer);
		previewGenerateOverlayBillingDashboardPO.clickOnSaveButtonToSaveLayout();
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @When("I click on generate invoice button for second candidate")
    public void i_click_on_generate_invoice_button_for_second_candidate() {
    	String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[1]).toString();
		String candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
		billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Generate Invoice");
    }

    @Then("Verify Last used address is pre-selected and then generate the Invoice")
    public void verify_Last_used_address_is_pre_selected_and_then_generate_the_Invoice() {
    	String employerData=BillingAPI.employerDataByEmployerNameAsJSON.get(employerName).toString();
		String secondAddressOfEmployer = BasicTestOps.getSpecificValueFromJSON(employerData, "address", 1);
	    Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Bill to").contains(secondAddressOfEmployer),"Last Used Address isn't pre-selected !!!!");
    }

    @When("I edit the associated employer and add another address in employer settings")
    public void i_edit_the_associated_employer_and_add_another_address_in_employer_settings() {
    	genericFunction.launchSpecificURL(YamlReader.getAppConfigValue("URLs.baseURL")+"/employer/list");
		manageEmployer.clickOnAddedEmployerRelatedLinks(employerName, "Edit");
		manageEmployer.click_on_Employer_address_tab();
		manageEmployer.click_on_Element("Add More");
		manageEmployer.fillTextAreaOrInputTextBoxInViewContainer("Address-Latest", "Address:", "textarea");
		manageEmployer.click_on_Element("GST Unregistered");
		manageEmployer.clickEmployerAddressAddButton();
		manageEmployer.save_Employer_DetailsOnEmployerPage();
    }

    @When("I go to billing dashboard to generate invoice of third candidate")
    public void i_go_to_billing_dashboard_to_generate_invoice_of_third_candidate() {
    	billingDashboardPagePO.goToBillingDashboardPage();
		String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[2]).toString();
		String candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
		billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Generate Invoice");
    }

    @Then("Verify latest added address is pre-selected for invoice generation for third candidate")
    public void verify_latest_added_address_is_pre_selected_for_invoice_generation_for_third_candidate() {
    	previewGenerateOverlayBillingDashboardPO.clickOnEditButtonToEditLayout();
//		Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Bill to").contains("Address-Latest"),"Latest added Address isn't pre-selected !!!!");
    }

    @When("I change Bill to address from dropdown")
    public void i_change_Bill_to_address_from_dropdown() {
    	String employerData=BillingAPI.employerDataByEmployerNameAsJSON.get(employerName).toString();
		String thirdAddressOfEmployer = BasicTestOps.getSpecificValueFromJSON(employerData, "address", 2);
	    previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Bill to", thirdAddressOfEmployer);
	    previewGenerateOverlayBillingDashboardPO.clickOnSaveButtonToSaveLayout();
	}

    @Then("Verify Payable amount remains same in the layout and the top section")
    public void verify_Payable_amount_remains_same_in_the_layout_and_the_top_section() {
    	Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Payable Amount ","span").trim().replaceAll("[^0-9]", "").equals(previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInServiceDescriptionTable("Payable Amount").trim().replaceAll("[^0-9]", "")),"Payable Amount is incorrect or not same in layout and top section !!!!");
    }
    
    @Given("I create a candidate for a employer having multiple addresses and multiple billing details and move the candidate to Billing Stage")
    public void i_create_a_candidate_for_a_employer_having_multiple_addresses_and_multiple_billing_details_and_move_the_candidate_to_Billing_Stage() {
    	employerName=billing.createEmployerWithOptions(Arrays.asList("percentage","percentage","percentage"), Arrays.asList("70","80","90"), 100, 120, Arrays.asList(true,true,true), 3, 3);
	    String timeStamp1 = ""+BasicTestOps.generateRandomStrings(10, "Number");
	    candidatedata = billing.createMultipleCandidatesForSingleEmployer(new String[] {"Candidate-"+timeStamp1},new String[] {"can"+timeStamp1+"@yopmail.com"},new String[] {"Req-"+timeStamp1}, employerName, "29374", 1);
	    for(int i=0;i<candidatedata.length;i++) {
	    	viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidatedata[i]);
	    	viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
	    	viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "1000000", 1, "100000", 30);
	    }
	    billingDashboardPagePO.goToBillingDashboardPage();
    }

    @When("I generate PI of the candidate with all of the information updated in PI layout selected other than default")
    public void i_generate_PI_of_the_candidate_with_all_of_the_information_updated_in_PI_layout_selected_other_than_default() {
    	String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[0]).toString();
		String candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
		billingDashboardPagePO.clickOnButtonOnBillingdashboard(candidateName, "Generate Proforma Invoice");
		String employerData=BillingAPI.employerDataByEmployerNameAsJSON.get(employerName).toString();
		String secondBillingCategory=BasicTestOps.getSpecificValueFromJSON(employerData, "invoiceRateName", 1);
		previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Choose an invoice rate to be applied", secondBillingCategory);
		String secondAddress=BasicTestOps.getSpecificValueFromJSON(employerData, "address", 1);
		previewGenerateOverlayBillingDashboardPO.clickOnEditButtonToEditLayout();
		previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Bill to", secondAddress);
		previewGenerateOverlayBillingDashboardPO.clickOnSaveButtonToSaveLayout();
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Proforma Invoice");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @When("I click on generate Invoice for the added candidate")
    public void i_click_on_generate_Invoice_for_the_added_candidate() {
    	String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[0]).toString();
		String candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
		billingDashboardPagePO.clickOnButtonOnBillingdashboard(candidateName, "Generate Invoice");
    }

    @Then("Verify all the updated information is reflected on Invoice Layout")
    public void verify_all_the_updated_information_is_reflected_on_Invoice_Layout() {
    	String employerData=BillingAPI.employerDataByEmployerNameAsJSON.get(employerName).toString();
		String secondAddress=BasicTestOps.getSpecificValueFromJSON(employerData, "address", 1);
		String secondBillingCategory=BasicTestOps.getSpecificValueFromJSON(employerData, "invoiceRateName", 1);
		Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Bill to").contains(secondAddress),"Updated Address isn't reflecting in Invoice !!!!");
		Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Choose an invoice rate to be applied", "span").contains(secondBillingCategory),"Updated Billing Category isn't reflecting in Invoice !!!!");
		Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Payable Amount ","span").trim().replaceAll("[^0-9]", "").equals("80000"),"Payable Amount is incorrect in top section !!!!");
		Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInServiceDescriptionTable("Payable Amount").trim().replaceAll("[^0-9]", "").equals("80000"),"Payable Amount is incorrect in layout !!!!");
    }

    @When("I click on generate Invoice and move to mail invoice page")
    public void i_click_on_generate_Invoice_and_move_to_mail_invoice_page() {
    	previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
    }

    @Then("Verify that candidate name and designation is displayed corrrectly")
    public void verify_that_candidate_name_and_designation_is_displayed_corrrectly() {
    	String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[0]).toString();
		String candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
	    Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("generated successfully"),"Candidate Name and Designation is not displayed correctly !!!!");
    }
    
    @Given("I create a candidate for a employer having flat fee billing details")
    public void i_create_a_candidate_for_a_employer_having_flat_fee_billing_details() {
    	viewApplicationDetailPagePO.generateCandidateIdWithEmployerOfRMSConsultantviaAPI("flat", "25000", 10, 90, "true");
    }

    @When("While moving candidate to billing stage, I do not mention billable salary")
    public void while_moving_candidate_to_billing_stage_I_do_not_mention_billable_salary() {
    	viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
    	viewApplicationDetailPagePO.fillTextAreaOrInputTextBoxInViewContainer("Designation "+timeStamp, "Offered Designation", "input");
    	viewApplicationDetailPagePO.fillTextAreaOrInputTextBoxInViewContainer("1000000", "Candidate's joining salary", "input");
    	viewApplicationDetailPagePO.selectDateInCalender("Offered on", 1);
    	viewApplicationDetailPagePO.selectDateInCalender("Candidate's tentative joining date", 30);
    }

    @Then("Verify Payable amount is same as flat fee")
    public void verify_Payable_amount_is_same_as_flat_fee() {
    		Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Payable Amount", "span").replaceAll("[^0-9]", "").equals("25000"),"Payable Amount is Incorrect !!!!");
    }

    @When("I move the candidate to Billing stage and again click on changing the status to billing stage")
    public void i_move_the_candidate_to_Billing_stage_and_again_click_on_changing_the_status_to_billing_stage() {
    	viewApplicationDetailPagePO.clickOnElementInFooter("Next");
    	viewApplicationDetailPagePO.clickOnElementInFooter("Skip");
		viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
    }

    @When("I clear the billable salary which has been pre-filled same as joining salary and move the candidate to billing stage")
    public void i_clear_the_billable_salary_which_has_been_pre_filled_same_as_joining_salary_and_move_the_candidate_to_billing_stage() {
    	viewApplicationDetailPagePO.fillTextAreaOrInputTextBoxInViewContainer("", "Candidate's Billable salary", "input");
    	viewApplicationDetailPagePO.clickOnElementInFooter("Next");
    	viewApplicationDetailPagePO.clickOnElementInFooter("Skip");
    }

    @When("I go to billing dashboard in To be generated tab")
    public void i_go_to_billing_dashboard_in_To_be_generated_tab() {
    	billingDashboardPagePO.goToBillingDashboardPage();
    }

    @Then("Verify Joining Salary should not be zero and equal to the joining salary which mentioned while moving the candidate to billing stage")
    public void verify_Joining_Salary_should_not_be_zero_and_equal_to_the_joining_salary_which_mentioned_while_moving_the_candidate_to_billing_stage() {
    	employerName=billing.createEmployerWithOptions(Arrays.asList("flat"), Arrays.asList("33000"), 10, 90, Arrays.asList(true), 1, 1);
		String randomString = BasicTestOps.generateRandomStrings(13, "Number");
		candidatedata=billing.createMultipleCandidatesForSingleEmployer(new String[] {""}, new String[] {"Candidate"+randomString+"@yopmail.com"}, new String[] {"Req-"+randomString}, employerName, "29374", 1);
		String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[0]).toString();
		candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[alternateEmails][0][email]", 0);
		viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidatedata[0]);
    	viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
    	viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "1000000", 1, "100000", 30);
		billingDashboardPagePO.goToBillingDashboardPage();
    }
    
    @Given("I create a candidate without candidate name for a employer having flat fee billing details and move the candidate to billing stage")
    public void i_create_a_candidate_without_candidate_name_for_a_employer_having_flat_fee_billing_details_and_move_the_candidate_to_billing_stage() {
    	employerName=billing.createEmployerWithOptions(Arrays.asList("flat"), Arrays.asList("33000"), 10, 90, Arrays.asList(true), 1, 1);
		String randomString = BasicTestOps.generateRandomStrings(13, "Number");
		candidatedata=billing.createMultipleCandidatesForSingleEmployer(new String[] {""}, new String[] {"Candidate"+randomString+"@yopmail.com"}, new String[] {"Req-"+randomString}, employerName, "29374", 1);
		String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[0]).toString();
		candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[alternateEmails][0][email]", 0);
		viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidatedata[0]);
    	viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
    	viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "1000000", 1, "100000", 30);
		billingDashboardPagePO.goToBillingDashboardPage();
    }

    @When("I generate Invoice for the added candidate and moving to ouststanding tab and I hover the more opptions to download options")
    public void i_generate_Invoice_for_the_added_candidate_and_moving_to_ouststanding_tab_and_I_hover_the_more_opptions_to_download_options() {
    	billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Generate Invoice");
  	    previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
  	    previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
  		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
  		billingDashboardPagePO.clickOnTab("Outstanding");
    }

    @Then("Only Invoice download link should be displayed and payment receipt link should not be displayed")
    public void only_Invoice_download_link_should_be_displayed_and_payment_receipt_link_should_not_be_displayed() {
    	boolean presence=billingDashboardPagePO.verifySubOptionOfMoreOptionsIsDisplayed(candidateName,"Download", "Invoice");
	    Assert.assertTrue(presence,"Invoice Download Link is not present !!!!");
	    presence=billingDashboardPagePO.verifySubOptionOfMoreOptionsIsDisplayed(candidateName,"Download", "Payment Receipt");
	    Assert.assertFalse(presence,"Payment Receipt Download Link is present !!!!");
    }

    @When("I click on mark as paid for full payment and candidate moves to mail payment receipt page and click on preview mail")
    public void i_click_on_mark_as_paid_for_full_payment_and_candidate_moves_to_mail_payment_receipt_page_and_click_on_preview_mail() {
    	billingDashboardPagePO.goToBillingDashboardPage();
		billingDashboardPagePO.clickOnTab("Outstanding");
	    billingDashboardPagePO.clickOnButtonOnBillingdashboard(candidateName, "Mark Paid");
	    previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("33000", "Payment Amount", "input");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark Paid");
		manageEmployer.click_on_Element("Preview Mail");
    }

    @Then("Verify In place of candidate name, candidate email is displayed in content and header of mail")
    public void verify_In_place_of_candidate_name_candidate_email_is_displayed_in_content_and_header_of_mail() {
    	boolean presence=previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayedInMailPreviewOverlay("Payment Acknowledgment for Invoice",1);
		Assert.assertTrue(presence,"Candidate Email is not displayed in header !!!!");
		presence=previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayedInMailPreviewOverlay("Payment Received for Service Provided",1);
		Assert.assertTrue(presence,"Candidate Email is not displayed in body content !!!!");
    }

    @When("I close the mail preview of payment receipt mail preview")
    public void i_close_the_mail_preview_of_payment_receipt_mail_preview() {
    	previewGenerateOverlayBillingDashboardPO.clickOnAnyElementInMailPreviewOverlay("CLOSE");
    }

    @Then("Verify Send button should not be enabled without filled [To] field")
    public void verify_Send_button_should_not_be_enabled_without_filled_To_field() {
    	boolean presence = previewGenerateOverlayBillingDashboardPO.verifyButtonIsDisabledInFooter("Send Acknowledgement");
		Assert.assertTrue(presence,"Send Acknowledgement button is not disabled !!!");
    }

    @When("I check the save as template checkbox")
    public void i_check_the_save_as_template_checkbox() {
    	manageEmployer.click_on_Element("Save this mail as template");
    }

    @Then("No validation message should be there like This field cannot be left blank.")
    public void no_validation_message_should_be_there_like_This_field_cannot_be_left_blank() {
    	 Assert.assertFalse(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("This field cannot be left blank."),"Validation message is displayed !!!");
    }

    @When("I click on cancel and candidate moves to Paid tab")
    public void i_click_on_cancel_and_candidate_moves_to_Paid_tab() {
    	previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
		billingDashboardPagePO.clickOnTabLinkInSuccessMsgAfterMovingCandidateFromOneTabtoAnother("Paid");
    }

    @When("I refund the amount partially leaving only {double} rupee left paid")
    public void i_refund_the_amount_partially_leaving_only_rupee_left_paid(Double double1) {
    	billingDashboardPagePO.selectEmployerFromSearchEmployerDD(employerName);
		billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Refund/Issue credit note");
		manageEmployer.click_on_Element("Issue Credit Note");
		manageEmployer.click_on_Element("Partial Refund");
		previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("32999.99", "Enter Amount", "input");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark as Refunded");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @When("I click on refund again")
    public void i_click_on_refund_again() {
    	billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Refund/Issue credit note");
    }

    @Then("Verify Max Refundable Amount is {double}")
    public void verify_Max_Refundable_Amount_is(Double double1) {
    	Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Max Refundable Amount: ₹0.01"),"Max refundable amount is incorrect !!!");
    }

    @Then("Reflection on Text box against Payment method is changing after changing the payment mode")
    public void reflection_on_Text_box_against_Payment_method_is_changing_after_changing_the_payment_mode() {
    	previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Refund Mode", "Cheque");
		Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Cheque Number"),"Cheque Number is not displayed !!!!");
		previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Refund Mode", "Online Transfer");
		Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Transaction Number"),"Transaction Number is not displayed !!!!");
		previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Refund Mode", "Cash");
		Assert.assertFalse(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Transaction Number"),"Transaction Number is displayed !!!!");
    }

    @When("Refunded partially with {double} rupee")
    public void refunded_partially_with_rupee(Double double1) {
    	manageEmployer.click_on_Element("Issue Credit Note");
		manageEmployer.click_on_Element("Partial Refund");
		previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("0.01", "Enter Amount", "input");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark as Refunded");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Then("Candidate should be moved to Refunded tab")
    public void candidate_should_be_moved_to_Refunded_tab() {
    	billingDashboardPagePO.clickOnDismiss();
		Assert.assertFalse(billingDashboardPagePO.checkThePresenceOfCandidateName(candidateName),"Candidate name is displayed in Paid Tab !!!!");
		billingDashboardPagePO.clickOnTab("Refunded");
		Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(candidateName),"Candidate name is displayed in Paid Tab !!!!");
    }
    
    @Given("I add two candidates for a single employer and moves both the candidates to Billing stage and Generate Invoice of the candidates")
    public void i_add_two_candidates_for_a_single_employer_and_moves_both_the_candidates_to_Billing_stage_and_Generate_Invoice_of_the_candidates() {
    	employerName=billing.createEmployerWithOptions(Arrays.asList("flat"), Arrays.asList("33000"), 10, 90, Arrays.asList(true), 1, 1);
		String randomString1 = BasicTestOps.generateRandomStrings(13, "Number");
		String randomString2 = BasicTestOps.generateRandomStrings(13, "Number");
		candidatedata=billing.createMultipleCandidatesForSingleEmployer(new String[] {"Candidate"+randomString1,"Candidate"+randomString2}, new String[] {"Can"+randomString1+"@yopmail.com","Can"+randomString2+"@yopmail.com"}, new String[] {"Req-"+randomString1,"Req-"+randomString2}, employerName, "29374", 2);
		for(int i=0;i<candidatedata.length;i++) {
	    	viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidatedata[i]);
	    	viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
	    	viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "1000000", 1, "100000", 30);
	    }
	    billingDashboardPagePO.goToBillingDashboardPage();
	    for(int i=0;i<candidatedata.length;i++) {
	    	String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[i]).toString();
			String candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
			billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Generate Invoice");
			previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
			previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
			previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
	    }
	    billingDashboardPagePO.clickOnTab("Outstanding");
	}

    @Given("I mark first candidate as paid with half its total amount and refund the same as credit note")
    public void i_mark_first_candidate_as_paid_with_half_its_total_amount_and_refund_the_same_as_credit_note() {
    	String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[0]).toString();
		String candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
		billingDashboardPagePO.clickOnButtonOnBillingdashboard(candidateName, "Mark Paid");
	    previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("20000", "Payment Amount", "input");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark Paid");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
		billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Refund/Issue credit note");
		manageEmployer.click_on_Element("Issue Credit Note");
		manageEmployer.click_on_Element("Partial Refund");
		previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("20000", "Enter Amount", "input");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark as Refunded");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @When("I click mark as paid for second candidate and use credit and do rest of payment with other payment mode totalling more than total amount")
    public void i_click_mark_as_paid_for_second_candidate_and_use_credit_and_do_rest_of_payment_with_other_payment_mode_totalling_more_than_total_amount() {
    	String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[1]).toString();
		String candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
		billingDashboardPagePO.clickOnButtonOnBillingdashboard(candidateName, "Mark Paid");
		manageEmployer.click_on_Element("Use Credit");
		manageEmployer.click_on_Element("Add another payment method");
		previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("20000", "Payment Amount", "input");
    }

    @Then("Verify error message is displayed Sum of all amounts cannot be greater than total amount")
    public void verify_error_message_is_displayed_Sum_of_all_amounts_cannot_be_greater_than_total_amount() {
    	 Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayedInFooter("Sum of all amounts cannot be greater than ₹33000"), "Error message isn't displayed !!!!");
    }

    @Then("Mark Paid button should be disabled")
    public void mark_Paid_button_should_be_disabled() {
    	Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyButtonIsDisabledInFooter("Mark Paid"),"Mark Paid button isn't disabled !!!!");
    }
    
    @When("I create candidate for a employer having mutiple addresses and mutiple billing details and move the candidate to billing stage")
    public void i_create_candidate_for_a_employer_having_mutiple_addresses_and_mutiple_billing_details_and_move_the_candidate_to_billing_stage() {
    	employerName=billing.createEmployerWithOptions(Arrays.asList("flat","percentage"), Arrays.asList("42000","40"), 10, 90, Arrays.asList(true,true), 2, 2);
		String randomString1 = BasicTestOps.generateRandomStrings(13, "Number");
		candidatedata=billing.createMultipleCandidatesForSingleEmployer(new String[] {"Candidate"+randomString1}, new String[] {"Can"+randomString1+"@yopmail.com"}, new String[] {"Req-"+randomString1}, employerName, "29374", 1);
		viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidatedata[0]);
    	viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
    	viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "1000000", 1, "100000", 30);
		billingDashboardPagePO.goToBillingDashboardPage();
    }

    @Then("Verify multiple candidate tuple entries are not created on billing dashboard")
    public void verify_multiple_candidate_tuple_entries_are_not_created_on_billing_dashboard() {
    	String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[0]).toString();
		candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
		Assert.assertFalse(billingDashboardPagePO.checkThePresenceOfCandidateName(candidateName,2),"Multiple Tuple Entries are created !!!!");
    }

    @When("I search for the employer associated with added candidate")
    public void i_search_for_the_employer_associated_with_added_candidate() {
    	billingDashboardPagePO.selectEmployerFromSearchEmployerDD(employerName);
    }

    @Then("Only added candidate tuple should be displayed")
    public void only_added_candidate_tuple_should_be_displayed() {
    	Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(candidateName,1),"Candidate isn't displayed after search !!!!");
		Assert.assertFalse(billingDashboardPagePO.checkThePresenceOfCandidateName(candidateName,2),"Multiple Tuple Entries are created !!!!");
    }

    @When("I generate invoice of the added candidate changing its default address, billing details, invoice date and subtext under invoice")
    public void i_generate_invoice_of_the_added_candidate_changing_its_default_address_billing_details_invoice_date_and_subtext_under_invoice() {
    	billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Generate Invoice");
 	    previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Choose an invoice rate to be applied", BasicTestOps.getSpecificValueFromJSON(BillingAPI.employerDataByEmployerNameAsJSON.get(employerName).toString(), "invoiceRateName", 1));
 	    previewGenerateOverlayBillingDashboardPO.clickOnEditButtonToEditLayout();
 	    previewGenerateOverlayBillingDashboardPO.selectValueFromDDInViewContainer("Bill to", BasicTestOps.getSpecificValueFromJSON(BillingAPI.employerDataByEmployerNameAsJSON.get(employerName).toString(), "address", 1));
 	    previewGenerateOverlayBillingDashboardPO.clickOnAnyTextAreaOrInputBoxInViewContainer("", "Invoice Editor", "input");
 	    previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("Demo Text", "Invoice Editor", "input");
 	    previewGenerateOverlayBillingDashboardPO.clickOnSaveButtonToSaveLayout();
 	    previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
 	    previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
 		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @When("Mark candidate as fully paid and click on refund in paid tab")
    public void mark_candidate_as_fully_paid_and_click_on_refund_in_paid_tab() {
    	billingDashboardPagePO.clickOnTab("Outstanding");
		billingDashboardPagePO.clickOnButtonOnBillingdashboard(candidateName, "Mark Paid");
		previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("40000", "Payment Amount", "input");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark Paid");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
		billingDashboardPagePO.clickOnTabLinkInSuccessMsgAfterMovingCandidateFromOneTabtoAnother("Paid");
		billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Refund/Issue credit note");
		manageEmployer.click_on_Element("Issue Credit Note");
    }

    @Then("Verify for refund as credit note, all the default details are same in credit note layout as selected while generating invoice")
    public void verify_for_refund_as_credit_note_all_the_default_details_are_same_in_credit_note_layout_as_selected_while_generating_invoice() {
    	String employerData=BillingAPI.employerDataByEmployerNameAsJSON.get(employerName).toString();
		String secondAddressOfEmployer = BasicTestOps.getSpecificValueFromJSON(employerData, "address", 1);
	    Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Bill to").contains(secondAddressOfEmployer),"Last Used Address isn't pre-selected in Credit Note layout !!!!");
    }

    @Given("I create a employer without any billing details")
    public void i_create_a_employer_without_any_billing_details() {
		settingsPO.clickOnManageEmployer();
		manageEmployer.click_on_Add_Employer_Button();
		employerName="Emp-"+timeStamp;
		manageEmployer.fill_Employer_DetailsOnEmployerPage(employerName, "Description-"+timeStamp);
		manageEmployer.click_on_Employer_address_tab();
		manageEmployer.click_on_Add_address_buton();
		manageEmployer.fill_Employer_Address("Employer Address - "+timeStamp);
		manageEmployer.click_on_Element("GST Unregistered");
		manageEmployer.click_on_Element("ADD");
		manageEmployer.select_RecruitersOnEmployerPage();
		manageEmployer.save_Employer_DetailsOnEmployerPage();
    }

    @Given("I create a candidate associated with created employer with new requirement without specifying any billing details")
    public void i_create_a_candidate_associated_with_created_employer_with_new_requirement_without_specifying_any_billing_details() {
    	String randomString1 = BasicTestOps.generateRandomStrings(13, "Number");
		candidatedata=billing.createMultipleCandidatesForSingleEmployer(new String[] {"Candidate"+randomString1}, new String[] {"Can"+randomString1+"@yopmail.com"}, new String[] {"Req-"+randomString1}, employerName, "29374", 1);
    }

    @When("I click to move this candidate to billing stage")
    public void i_click_to_move_this_candidate_to_billing_stage() {
    	viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidatedata[0]);
    	viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
    }

    @Then("No dropdown should be there for billing category")
    public void no_dropdown_should_be_there_for_billing_category() {
    	 Assert.assertFalse(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Choose invoice rate to be applied"),"Billing category drop down is visible without billing category !!!!");
    }

    @When("I move this candidate to billing stage and candidate is on billing dashboard")
    public void i_move_this_candidate_to_billing_stage_and_candidate_is_on_billing_dashboard() {
    	viewApplicationDetailPagePO.fillTextAreaOrInputTextBoxInViewContainer("Designation "+timeStamp, "Offered Designation", "input");
    	viewApplicationDetailPagePO.fillTextAreaOrInputTextBoxInViewContainer("1000000", "Candidate's joining salary", "input");
    	viewApplicationDetailPagePO.selectDateInCalender("Offered on", 1);
		viewApplicationDetailPagePO.selectDateInCalender("Candidate's tentative joining date", 30);
		viewApplicationDetailPagePO.clickOnElementInFooter("Next");
		viewApplicationDetailPagePO.clickOnElementInFooter("Skip");
		String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[0]).toString();
		candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
		billingDashboardPagePO.goToBillingDashboardPage();
    }

    @Then("Verify tuple is visible in To be generated tab and payment due must be --")
    public void verify_tuple_is_visible_in_To_be_generated_tab_and_payment_due_must_be() {
    	billingDashboardPagePO.checkThePresenceOfCandidateName(candidateName);
  	    boolean presence=billingDashboardPagePO.getOfferedCandidateDetail(candidateName, "Payment Due on").trim().equals("--");
  	    Assert.assertTrue(presence,"Payment due is incorrect !!!");
    }

    @When("I click on generate invoice")
    public void i_click_on_generate_invoice() {
    	billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Generate Invoice");
    }

    @Then("Others option should be selected and associated field of Enter Billing Amount should be displayed")
    public void others_option_should_be_selected_and_associated_field_of_Enter_Billing_Amount_should_be_displayed() {
    	boolean presence=previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Choose an invoice rate to be applied", "span").equals("Others");
		Assert.assertTrue(presence,"Others isn't pre-selected !!!! !!!");
		presence=previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayed("Enter Billing Amount");
		Assert.assertTrue(presence,"Enter Billing Amount field isn't displayed !!!!");
		presence=previewGenerateOverlayBillingDashboardPO.verifyButtonIsDisabledInFooter("Generate Invoice");
		Assert.assertTrue(presence,"Generate Invoice button isn't disabled !!!!");
    }

    @When("I fill Enter Billing Amount and click on generate invoice")
    public void i_fill_Enter_Billing_Amount_and_click_on_generate_invoice() {
    	previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer("20000", "Enter Billing Amount", "input");
		invoiceNumber=previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Invoice No.").trim();
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
    }

    @Then("Invoice should be successfully generated and after clicking cancel for mailing, tuple should move to outstanding tab")
    public void invoice_should_be_successfully_generated_and_after_clicking_cancel_for_mailing_tuple_should_move_to_outstanding_tab() {
    	boolean presence=previewGenerateOverlayBillingDashboardPO.getTextFromSuccessRibbon().trim().equalsIgnoreCase("Invoice number: "+invoiceNumber+" generated successfully");
		Assert.assertTrue(presence,"Invoice is not successfully generated !!!");
		previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
		previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
		billingDashboardPagePO.clickOnTabLinkInSuccessMsgAfterMovingCandidateFromOneTabtoAnother("Outstanding");
		Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(candidateName),"Candidate is not moving to outstanding tab after Invoice Generation !!!");
    }
    
//    @When("I update the invoice settings")
//    public void i_update_the_invoice_settings() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
//    }

    @Given("I create a candidate with default settings and move the candidate to billing stage")
    public void i_create_a_candidate_with_default_settings_and_move_the_candidate_to_billing_stage() {
    	employerName=billing.createEmployerWithOptions(Arrays.asList("flat","percentage"), Arrays.asList("42000","40"), 10, 90, Arrays.asList(true,true), 2, 2);
  	    String randomString1=BasicTestOps.generateRandomStrings(9, "Number");
  	    candidatedata=billing.createMultipleCandidatesForSingleEmployer(new String[] {"Candidate"+randomString1}, new String[] {"Can"+randomString1+"@yopmail.com"}, new String[] {"Req-"+randomString1}, employerName, "2795", 1);
  	    viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidatedata[0]);
  	    viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
  	    viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "1000000", 1, "100000", 30);
      	String candidateData=BillingAPI.candidateDataByApplicationIdAsJSON.get(candidatedata[0]).toString();
  		candidateName=BasicTestOps.getSpecificValueFromJSON(candidateData, "candidateProfile[name]", 0);
    }

    @Given("I get next invoice number and i update series of invoice with same prefix")
    public void i_get_next_invoice_number_and_i_update_series_of_invoice_with_same_prefix() {
    	commonAction.clickOnOptionsOnUsername("Account Settings");
    	settingsPO.clickOnInvoiceSettings();
    	invoiceSettings.clickOnTabOnInvoiceSettingsForm("invoice");
	    newIndex=invoiceSettings.getGeneratedInvoiceCount()+Integer.parseInt(BasicTestOps.generateRandomStrings(1, "Number"));;
	    invoiceSettings.clickOnCreatePrefixButton();
	    invoiceSettings.enterStartIndexFrom(newIndex);
	    invoiceSettings.clickOnSavePrefixBtn();
		prefix= invoiceSettings.getEnteredPrefixValue();
		value = newIndex+1;
		if(prefix.endsWith("/")) {
			invoiceNumber=prefix+String.format("%06d",value);
		}else {
			invoiceNumber=prefix+"/"+String.format("%06d",value);
		}
		invoiceSettings.saveInvoiceSettingsBtn();
	}

    @When("I go to billing dashboard page and click on generate invoice of the added candidate")
    public void i_go_to_billing_dashboard_page_and_click_on_generate_invoice_of_the_added_candidate() {
    	billingDashboardPagePO.goToBillingDashboardPage();
		billingDashboardPagePO.clickOnOptionsInMoreOptions(candidateName, "Generate Invoice");
    }

    @Then("Verify updated series is reflected with same prefix for invoice")
    public void verify_updated_series_is_reflected_with_same_prefix_for_invoice() {
    	String val=previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Invoice No.");
		Assert.assertTrue(val.equals(invoiceNumber),"Updated series isn't reflecting on Invoice !!!!");
    }

    @When("I update the prefix as well as the series")
    public void i_update_the_prefix_as_well_as_the_series() {
    	commonAction.clickOnOptionsOnUsername("Account Settings");
    	settingsPO.clickOnInvoiceSettings();
    	invoiceSettings.clickOnTabOnInvoiceSettingsForm("invoice");
	    newIndex=invoiceSettings.getGeneratedInvoiceCount()+Integer.parseInt(BasicTestOps.generateRandomStrings(1, "Number"));
	    invoiceSettings.clickOnCreatePrefixButton();
	    invoiceSettings.enterPrefixValue("IN/FY/"+BasicTestOps.generateRandomStrings(5, "Number"));
	    invoiceSettings.enterStartIndexFrom(newIndex);
	    invoiceSettings.clickOnSavePrefixBtn();
		prefix= invoiceSettings.getEnteredPrefixValue();
		value = newIndex+1;
		if(prefix.endsWith("/")) {
			invoiceNumber=prefix+String.format("%06d",value);
		}else {
			invoiceNumber=prefix+"/"+String.format("%06d",value);
		}
		invoiceSettings.saveInvoiceSettingsBtn();
	}

    @Then("Verify updated prefix and series is reflected on invoice layout")
    public void verify_updated_prefix_and_series_is_reflected_on_invoice_layout() {
    	Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.getValueFromAnyLabelInInvoiceLayout("Invoice No").trim().contains(invoiceNumber),"Updated series isn't reflecting on Invoice !!!!");
    }
    
    @When("User click on {string} on candidate tupple")
    public void user_click_on_on_candidate_tupple(String optionName) {
        billingDashboardPagePO.clickOnButtonOnCandidateTupple(optionName);
    }
    
}