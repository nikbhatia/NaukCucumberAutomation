package com.naukri.stepdefinitions.Billing;

import org.testng.Assert;

import com.naukri.automation.util.BasicTestOps;
import com.naukri.automation.util.BillingAPI;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.pageobjects.Applications.ViewApplicationDetailPagePO;
import com.naukri.pageobjects.Billing.BillingDashboardPagePO;
import com.naukri.pageobjects.Billing.PreviewGenerateOverlayBillingDashboardPO;
import com.naukri.pageobjects.Settings.ManageEmployerPO;
import com.naukri.stepdefinitions.Applications.PilotApplicationInboxStepDef;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaidRefundWrittenOffStepDefs {
    BillingDashboardPagePO billingDashboardPagePO = (BillingDashboardPagePO) PageObjectWrapper.getObject(BillingDashboardPagePO.class);
    ManageEmployerPO manageEmployerObject = new ManageEmployerPO();
    PreviewGenerateOverlayBillingDashboardPO previewGenerateOverlayBillingDashboardPO = (PreviewGenerateOverlayBillingDashboardPO) PageObjectWrapper.getObject(PreviewGenerateOverlayBillingDashboardPO.class);
    BillingDashboardPagePO.WriteOffInvoiceOverlayPO writeOffInvoiceOverlayPO = billingDashboardPagePO.new WriteOffInvoiceOverlayPO();
    ViewApplicationDetailPagePO viewApplicationDetailPagePO = (ViewApplicationDetailPagePO) PageObjectWrapper.getObject(ViewApplicationDetailPagePO.class);
    BillingAPI billingAPI = (BillingAPI) PageObjectWrapper.getObject(BillingAPI.class);

    String enteredAmount;
    private String candidateData[];
    private String timeStamp = ""+System.currentTimeMillis();

    @When("user Generate Invoice for the added candidate")
    public void userGenerateInvoicefortheaddedcandidate() {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, "Generate Invoice");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @And("user click on Mode of Refund as {string}")
    public void userClickOnModeOfRefundAs(String modeOfRefund) {
        manageEmployerObject.click_on_Element(modeOfRefund);
    }

    @And("user click on Refund Amount as {string}")
    public void userClickOnRefundAmountAs(String refundAmount) {
        manageEmployerObject.click_on_Element(refundAmount);

    }

    @And("user fill {int} in Enter Amount")
    public void userFillInEnterAmount(int refundAmount) {
        previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(""+refundAmount, "Enter Amount", "input");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark as Refunded");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @And("user fill {int} in Writeoff amount")
    public void userFillInWriteoffAmount(int amountToBePaid) {
        writeOffInvoiceOverlayPO.fillWriteOffAmount(""+amountToBePaid);
        PilotApplicationInboxStepDef.offeredCandidateDetails.put("AMOUNT_WRITTEN_OFF", ""+amountToBePaid);
    }

    @When("user click on Writeoff link under more options of added candidate")
    public void userClickOnWriteoffLinkUnderMoreOptionsOfAddedCandidate() {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, "Writeoff");
    }

    @And("user select the option Partial writeoff")
    public void userSelectTheOptionPartialWriteoff() {
        writeOffInvoiceOverlayPO.clickWriteOffRadioButton("Partial writeoff");
    }

    @And("user click Writeoff button in the layout")
    public void userClickWriteoffButtonInTheLayout() {
        writeOffInvoiceOverlayPO.clickAnyButtonOnModalFooter("Writeoff");
    }

    @Then("Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as {int}")
    public void movedCandidateInformationShouldBeDisplayedWithDesignationAsDesignationTestBalanceToBePaidAs(int balanceToBePaid) {
        int balanceToBePaidFromUI = Integer.parseInt(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Balance to be paid"));
        Assert.assertTrue(balanceToBePaidFromUI==balanceToBePaid,
                "The balance to be paid isn't correct");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName),
                "The added candidate isn't visible on the outstanding tab");
    }

    @Then("Moved candidate information should be displayed with designation as Designation - Test , Amount written off as {int} under Written Off tab")
    public void movedCandidateInformationShouldBeDisplayedWithDesignationAsDesignationTestAmountWrittenOffAsUnderWrittenOffTab(int amountWrittenOff) {
        billingDashboardPagePO.clickOnTab("Written Off");
        int amountObtainedFromUI = Integer.parseInt(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName , "Amount written off"));
        Assert.assertTrue(amountObtainedFromUI==amountWrittenOff,
                "The candidate written off salary is not the same");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName),
                "The candidate name is not visible in the writte off tab");
    }

    @And("Enter {string} as enter amount")
    public void enterAsEnterAmount(String refundAmount) {
        previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(refundAmount, "Enter Amount", "input");
    }

    @Then("verify the amount validation")
    public void verifyTheAmountValidation() {
        Assert.assertEquals("Amount cannot be greater than 1,80,000",previewGenerateOverlayBillingDashboardPO.verifyValidationOnPaymentAmount());
    }

    @And("Enter {string} as payment amount")
    public void enterAsPaymentAmount(String arg0) {
        previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(arg0 , "Payment Amount" , "input");

    }

    @Then("verify that refunded amount cannot be greater than the paid")
    public void verifyThatRefundedAmountCannotBeGreaterThanThePaid() {
        Assert.assertEquals("Amount cannot be greater than 18,000",previewGenerateOverlayBillingDashboardPO.verifyValidationOnPaymentAmount());
    }

    @Then("^verify that amount cannot be greater than 162000$")
    public void verifyThatAmountCannotBeGreaterThan() {
        Assert.assertEquals("Amount cannot be greater than 1,62,000", previewGenerateOverlayBillingDashboardPO.verifyValidationOnPaymentAmount());

    }

    @Then("Communication message Unpaid Invoice of {int} will remain in Outstanding tab. should appear below the Writeoff amount label")
    public void communicationMessageUnpaidInvoiceOfWillRemainInOutstandingTabShouldAppearBelowTheWriteoffAmountLabel(int unpaidAmount) {
        writeOffInvoiceOverlayPO.verifyWriteOffInfoText(""+unpaidAmount);
    }

    @And("user click on Use Credit Link")
    public void userClickOnUseCreditLink() {
        manageEmployerObject.click_on_Element("Use Credit");
    }

    @When("user click on Mark Paid button")
    public void userClickOnMarkPaidButton() {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BillingAPI.candidateName, "Mark Paid");
    }

    @And("user fill {int} in Payment Amount")
    public void userFillInPaymentAmount(int salaryAmount) {
        enteredAmount= previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(""+salaryAmount , "Payment Amount" , "input");
    }

    @And("user click on Mark paid button on layout")
    public void userClickOnMarkPaidButtonOnLayout() {
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark Paid");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Then("Moved candidate information should be displayed with designation as {string} , amount paid as {int}")
    public void movedCandidateInformationShouldBeDisplayedWithDesignationAsAmountPaidAs(String designation, int amountPaid) {
        billingDashboardPagePO.selectEmployerFromSearchEmployerDD(BillingAPI.employerName);
        Assert.assertTrue(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName
                        , "Amount paid").contains(""+amountPaid), "The candidate  is not displayed");
    }

    @And("user fill {int} in TDS Amount")
    public void userFillInTDSAmount(int TDSAmount) {
        previewGenerateOverlayBillingDashboardPO.fillTextAreaOrInputTextBoxInViewContainer(""+TDSAmount , "TDS Amount" , "input");

    }

    @Then("Error message {string} appears left in the footer next to Mark Paid button")
    public void errorMessageAppearsLeftInTheFooterNextToMarkPaidButton(String warningMessage) {
        Assert.assertTrue(previewGenerateOverlayBillingDashboardPO.verifyTextIsDisplayedInFooter(warningMessage),
                "The warning message "+warningMessage+" is not displayed");
    }

    @Then("The added candidate name under the label IN and the {int} should appear under the label Amount to be paid in the modal appearing on screen")
    public void theAddedCandidateNameUnderTheLabelINAndTheShouldAppearUnderTheLabelAmountToBePaidInTheModalAppearingOnScreen(int amountToBePaid) {
        System.out.println("Verification of static details");
        Assert.assertTrue(writeOffInvoiceOverlayPO.getDataFromInfoWrapper("Amount to be paid").replaceAll(",", "").contains(""+amountToBePaid), "The Amount to be paid isn't visible in the overlay");
    }

    @When("user select the option Full writeoff")
    public void userSelectTheOptionFullWriteoff() {
        writeOffInvoiceOverlayPO.clickWriteOffRadioButton("Full writeoff");
    }

    @Then("uset see the success message of movement of candidate to Written Off tab")
    public void usetSeeTheSuccessMessageOfMovementOfCandidateToWrittenOffTab() {
        String messageToBeVerified = "has been successfully written off";
        Assert.assertTrue(billingDashboardPagePO.successMessageFromWriteOffMessage().contains(messageToBeVerified),
                "The success message for the write off message is not visible");
    }

    @And("Moved candidate information should be not displayed with designation as Designation - Test , amount paid as {int} under Paid tab")
    public void movedCandidateInformationShouldBeNotDisplayedWithDesignationAsDesignationTestAmountPaidAsUnderPaidTab(int arg1) {
        billingDashboardPagePO.clickOnTab("Paid");
        Assert.assertTrue(!billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName),
                "The candidate name is not visible in outstanding tab");
    }

    @And("Moved candidate information should be not displayed with designation as Designation - Test , amount paid as {int} under Refunded tab")
    public void movedCandidateInformationShouldBeNotDisplayedWithDesignationAsDesignationTestAmountPaidAsUnderRefundedTab(int arg1) {
        billingDashboardPagePO.clickOnTab("Refunded");
        Assert.assertTrue(!billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName),
                "The candidate name is not visible in refund tab");
    }

    @When("user click Don't writeoff button in the layout")
    public void userClickDonTWriteoffButtonInTheLayout() {
        System.out.println("In don't write off");
        writeOffInvoiceOverlayPO.clickAnyButtonOnModalFooter("Don’t writeoff");
    }

    @And("Moved candidate information should be not displayed with designation as Designation - Test , amount paid as {int} under Written Off tab")
    public void movedCandidateInformationShouldBeNotDisplayedWithDesignationAsDesignationTestAmountPaidAsUnderWrittenOffTab(int arg1) {
        billingDashboardPagePO.clickOnTab("Written Off");
        Assert.assertTrue(!billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName),
                "The candidate name is not visible in written off tab");
    }

    @Then("Moved candidate information should be displayed with designation as Designation - Test , Amount written off as {int} under Paid tab")
    public void movedCandidateInformationShouldBeDisplayedWithDesignationAsDesignationTestAmountWrittenOffAsUnderPaidTab(int arg1) {
        billingDashboardPagePO.clickOnTab("Written Off");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName),
                "The candidate name is not visible in paid tab");
    }

    @And("Moved candidate information should be not displayed with designation as Designation - Test , amount paid as {int} under Outstanding tab")
    public void movedCandidateInformationShouldBeNotDisplayedWithDesignationAsDesignationTestAmountPaidAsUnderOutstandingTab(int arg1) {
        billingDashboardPagePO.clickOnTab("Outstanding");
        Assert.assertTrue(!billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName),
                "The candidate is displayed under the outstanding tab");
    }

    @And("Moved candidate information should be displayed with designation as Designation - Test , amount paid as {int} under Outstanding tab")
    public void movedCandidateInformationShouldBeDisplayedWithDesignationAsDesignationTestAmountPaidAsUnderOutstandingTab(int balanceToBePaid) {
        billingDashboardPagePO.clickOnTab("Outstanding");
        int balanceToBePaidFromUI = Integer.parseInt(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Balance to be paid"));
        Assert.assertTrue(balanceToBePaid==balanceToBePaidFromUI,
                "The balanace to be paid is not correct");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName),
                "The candidate name is not visible in outstanding tab");
    }

    @When("^user click on Refund/Issue credit note link under more options of added candidate$")
    public void userClickOnRefundIssueCreditNoteLinkUnderMoreOptionsOfAddedCandidate() {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BillingAPI.candidateName, "Refund/Issue credit note");
    }

    @Then("Moved candidate information should be displayed with designation as Designation - Test , Amount refunded as {int}")
    public void movedCandidateInformationShouldBeDisplayedWithDesignationAsDesignationTestAmountRefundedAs(int refundedAmount) {
        int actualAmountRefundedFromUI = Integer.parseInt(billingDashboardPagePO.getOfferedCandidateDetail(BillingAPI.candidateName, "Amount refunded"));
        Assert.assertTrue(refundedAmount == actualAmountRefundedFromUI,
                "The amount refunded is not displayed correctly");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName),
                "The name of the displayed candidate in the refunded Tab isn't correct");
    }

    @Then("the amount {int} should be prefilled in the text field against Use Credit Amount Label")
    public void theAmountShouldBePrefilledInTheTextFieldAgainstUseCreditAmountLabel(int useCreditAmount) {
        int useCreditAmountFromUI = Integer.parseInt(previewGenerateOverlayBillingDashboardPO.getTextFromAnyTextAreaOrInputBoxInViewContainer("Use credit Amount", "input"));
        Assert.assertTrue(useCreditAmount==useCreditAmountFromUI,
                "The use credit amount is not correct which is displayed");
    }

    @When("user use other payment {string} option")
    public void userUseOtherPaymentOption(String addAnotherPaymentOption) {
        manageEmployerObject.click_on_Element(addAnotherPaymentOption);
    }

    @Then("Moved candidate information should be displayed with designation as Designation - Test , Amount paid as {int} a")
    public void movedCandidateInformationShouldBeDisplayedWithDesignationAsDesignationTestAmountPaidAsA(int arg1) {
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BillingAPI.candidateName),
                "The candidate name is not visible in outstanding tab");
    }

    @When("^user click on Refund/Issue credit note link under more options of added first candidate$")
    public void userClickOnRefundIssueCreditNoteLinkUnderMoreOptionsOfAddedFirstCandidate() {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[0]).toString(), "candidateProfile[name]", 0), "Refund/Issue credit note");
    }

    @And("user click on Mark refunded button")
    public void userClickOnMarkRefundedButton() {
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Mark as Refunded");
        previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
        previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
    }

    @Then("Moved first candidate information should be displayed with designation as Designation - Test , Amount refunded as {int}")
    public void movedFirstCandidateInformationShouldBeDisplayedWithDesignationAsDesignationTestAmountRefundedAs(int amountRefunded) {
        int actualAmountRefundedFromUI = Integer.parseInt(billingDashboardPagePO.getOfferedCandidateDetail(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[0]).toString() , "candidateProfile[name]", 0), "Amount refunded"));
        Assert.assertTrue(actualAmountRefundedFromUI == amountRefunded, "The amount refunded for the first case isn't correct");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[0]).toString() , "candidateProfile[name]", 0)),
                "The candidate isn't displayed under the desired tab");
    }

    @And("user click on Writeoff link under more options of added candidate secondCandidate")
    public void userClickOnWriteoffLinkUnderMoreOptionsOfAddedCandidateSecondCandidate() {
        billingDashboardPagePO.clickOnOptionsInMoreOptions(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[1]).toString() , "candidateProfile[name]", 0), "Writeoff");
    }

    @And("user click on Mark Paid button for secondCandidate on paidRefundWriteOff")
    public void userClickOnMarkPaidButtonForSecondCandidateOnPaidRefundWriteOff() {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[1]).toString() , "candidateProfile[name]", 0), "Mark Paid");
    }

    @Then("Moved second candidate information should be displayed with designation as Designation - Test , Amount paid as {int}")
    public void movedSecondCandidateInformationShouldBeDisplayedWithDesignationAsDesignationTestAmountPaidAs(int amountRefunded) {
        int actualAmountRefundedFromUI = Integer.parseInt(billingDashboardPagePO.getOfferedCandidateDetail(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[1]).toString() , "candidateProfile[name]", 0), "Amount paid"));
        Assert.assertTrue(amountRefunded == actualAmountRefundedFromUI, "The paid amount isn't correct");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[1]).toString() , "candidateProfile[name]", 0)),
                "The candidate name is not displayed in the paid tab");
    }

    @And("user click on Mark Paid button for thirdCandidate on paidRefundWriteOff")
    public void userClickOnMarkPaidButtonForThirdCandidateOnPaidRefundWriteOff() {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[2]).toString() , "candidateProfile[name]", 0 ), "Mark Paid");
    }

    @Then("Moved third candidate information should be displayed with designation as Designation - Test , Amount paid as {int}")
    public void movedThirdCandidateInformationShouldBeDisplayedWithDesignationAsDesignationTestAmountPaidAs(int amountPaid) {
        int actualAmountPaidFromUI = Integer.parseInt(billingDashboardPagePO.getOfferedCandidateDetail(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[2]).toString() , "candidateProfile[name]", 0), "Amount paid"));
        Assert.assertTrue(amountPaid == actualAmountPaidFromUI, "The paid amount isn't correct");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[2]).toString() , "candidateProfile[name]", 0)),
                "The candidate name is not displayed in the paid tab");
    }

    @Then("user is able to see the sucess message {string} .")
    public void userIsAbleToSeeTheSucessMessage(String successMessage) {
        Assert.assertTrue(billingDashboardPagePO.successMessageFromWriteOffMessage().contains(successMessage),
                "The write off success message is not visible");
    }

    @When("user create three candidate with same employer and default billing address and details on paidRefundWriteOff")
    public void userCreateThreeCandidateWithSameEmployerAndDefaultBillingAddressAndDetailsOnPaidRefundWriteOff() {
        String timeStamp1 = ""+ BasicTestOps.generateRandomStrings(10,"Number");
        String timeStamp2 = ""+ BasicTestOps.generateRandomStrings(10,"Number");
        String timeStamp3 = ""+ BasicTestOps.generateRandomStrings(10,"Number");
        candidateData = billingAPI.createMultipleCandidatesForSingleEmployer(new String[] {"Candidate-"+timeStamp1 , "Candidate-"+timeStamp2 , "Candidate-"+timeStamp3}, new String[] {"can"+timeStamp1+"@yopmail.com" , "can"+timeStamp2+"@yopmail.com" , "can"+timeStamp3+"@yopmail.com"}, new String[] {"Req-"+timeStamp1, "Req-"+timeStamp2 , "Req-"+timeStamp3}, BillingAPI.employerName, "29374", 3);
        for(int i = 0 ; i < candidateData.length ; i++) {
            viewApplicationDetailPagePO.goToViewApplicationDetailPage(candidateData[i]);
            viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
            viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation "+timeStamp, "600000", 1, "", 30);
        }
        billingDashboardPagePO.goToBillingDashboardPage();
    }

    @And("user click generate invoice for all three candidates on paidRefundWriteOff")
    public void userClickGenerateInvoiceForAllThreeCandidatesOnPaidRefundWriteOff() {
        for(int i = 0 ; i < candidateData.length ; i++) {
            billingDashboardPagePO.clickOnOptionsInMoreOptions(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[i]).toString() , "candidateProfile[name]", 0) , "Generate Invoice");
            previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Generate Invoice");
            previewGenerateOverlayBillingDashboardPO.clickOnElementInFooter("Cancel");
            previewGenerateOverlayBillingDashboardPO.clickOnButtonOnConfirmationBox("Continue");
        }
    }

    @And("user click on Mark Paid button for firstCanidate")
    public void userClickOnMarkPaidButtonForFirstCanidate() {
        billingDashboardPagePO.clickOnButtonOnBillingdashboard(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[0]).toString() , "candidateProfile[name]", 0), "Mark Paid");
    }

    @Then("first Moved candidate information should be displayed with designation as Designation - Test , Amount paid as {int} a")
    public void firstMovedCandidateInformationShouldBeDisplayedWithDesignationAsDesignationTestAmountPaidAsA(int amountPaid) {
        billingDashboardPagePO.selectEmployerFromSearchEmployerDD(BillingAPI.employerName);
        int actualAmountPaidFromUI = Integer.parseInt(billingDashboardPagePO.getOfferedCandidateDetail(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[0]).toString() , "candidateProfile[name]", 0), "Amount paid"));
        Assert.assertTrue(amountPaid == actualAmountPaidFromUI, "The paid amount isn't correct");
        Assert.assertTrue(billingDashboardPagePO.checkThePresenceOfCandidateName(BasicTestOps.getSpecificValueFromJSON(BillingAPI.candidateDataByApplicationIdAsJSON.get(candidateData[0]).toString() , "candidateProfile[name]", 0)),
                "The candidate name is not displayed in the paid tab");
    }
    
    @Then("User should be able to see the invoice link on the footer")
    public void user_should_be_able_to_see_the_invoice_link_on_the_footer() {
       Assert.assertTrue(billingDashboardPagePO.visibilityOfFooterLinks(BillingAPI.candidateName, "Invoice"), 
    		   "Invoice link is not visible for the candidate with name " + BillingAPI.candidateName);
       TestNGLogUtility.pass("Invoice link is visible for the candidate with name " + BillingAPI.candidateName);
    }
}
