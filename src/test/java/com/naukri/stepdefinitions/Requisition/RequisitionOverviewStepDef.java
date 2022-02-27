package com.naukri.stepdefinitions.Requisition;

import com.naukri.pageobjects.HiringManager.RaiseRequisitionPagePO;
import com.naukri.pageobjects.RequirementID.RequirementIDSettingsPO;
import com.naukri.pageobjects.Requisition.RequisitionOverviewPO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;

public class RequisitionOverviewStepDef {
    RequisitionOverviewPO requisitionOverviewPO = (RequisitionOverviewPO) PageObjectWrapper
            .getObject(RequisitionOverviewPO.class);
    RaiseRequisitionPagePO raiseRequisitionPO = (RaiseRequisitionPagePO) PageObjectWrapper
            .getObject(RaiseRequisitionPagePO.class);

    @Then("Verify Requisiton details on requisition overview page")
    public void verifyRequisitionDetailsOnRequisitionOverviewPage()
    {
        Assert.assertTrue(requisitionOverviewPO.verifyRequisitionDetailsOnPage(),"requisition details are not displayed corrctly");
    }
    @Then("verify requsition status {string}, hr spoc, group, raised by you field")
    public void verifyRequisitionSectionOnPage(String status)
    {
        Assert.assertTrue(requisitionOverviewPO.verifyReqSectionOnPage(status),"requisition section not displayed correctly");
    }
    @Then("verify the url contains requisition id on requisition overview page")
    public void verifyRequisitionIdOnURL()
    {
        Assert.assertTrue(requisitionOverviewPO.verifyRequisitionIdOnUrl(),"url is not generated with cirrect url");
    }
    @Then("verify requisition id on overview page")
    public void verifyRequisitionIdOnOverviewPage()
    {
        Assert.assertTrue(requisitionOverviewPO.verifyRequisitionIdONPage(),"requisition id is not displayed correctly on page");
    }
    @When("HM Spoc creates requisition with approval process {string}")
    public void raiseRequisitionWithApprovalProcess(String approverName) {
        raiseRequisitionPO.fillRequisitionWithApprovalProcessAndSpcificToOnAccount("approverGroup",approverName);
    }
    @When("Approver approves the requisition on overview page")
    public void approverApprovsRequisition()
    {
        requisitionOverviewPO.clickApproveOnOverviewPage();
    }
    @When("Approver rejects the requisition on overview page")
    public void approverRejectsTheRequisition()
    {
        requisitionOverviewPO.clickRejectOnOverviewPage();
    }
    @Then("verify status of requisition is {string}")
    public void verifyStatusOfRequsition(String status)
    {
       Assert.assertTrue(requisitionOverviewPO.verifyStatusOfRequisiton(status),"status of requisition not displayed correctly");
    }
    @Then("verify Current Approval Stage is {string}")
    public void verifyCurrentApprovalStage(String recName)
    {
        Assert.assertTrue(requisitionOverviewPO.verifyCurrentApprovalStage(recName),"current approval stage is not displayed on overview page");
    }
    @Then("Verify the requisition strip {string}")
    public void verifyTheStripOnPage(String message)
    {
        Assert.assertTrue(requisitionOverviewPO.verifyMessageOnOverviewPage(message),"message displayed is incorrect");
    }
    @Then("Verify that {string} button is displayed for requirement on overview page")
    public void verifyBtnVisibleOnOverviewPage(String btnText)
    {
        Assert.assertTrue(requisitionOverviewPO.verifyBtnVisibleOnOverviewPage(btnText),"btn is not displayed on overview page");
    }
    @Then("Verify that {string} button is not displayed for requirement on overview page")
    public void verifyBtnNotVisibleOnOverviewPage(String btnText)
    {
        Assert.assertFalse(requisitionOverviewPO.verifyBtnVisibleOnOverviewPage(btnText),"btn is displayed on overview page when rejected");
    }
    @When("User click on {string} button on requisition overview page")
    public void userCLicksOnBtnOnRequisitionOverview(String button)
    {
        requisitionOverviewPO.clickOnBtnOnRqOverviewPage(button);
    }


}
