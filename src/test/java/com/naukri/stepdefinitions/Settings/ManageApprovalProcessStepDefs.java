package com.naukri.stepdefinitions.Settings;

import java.util.List;

import org.testng.Assert;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.test.base.CommonAction;
import com.naukri.pageobjects.Settings.ManageApprovalProcessPO;
import com.naukri.pageobjects.Settings.ManageCVBackUpPO;
import com.naukri.pageobjects.Settings.ManageJobBoardsPO;
import com.naukri.pageobjects.Settings.ManageWhiteLabelPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ManageApprovalProcessStepDefs {

	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	ManageApprovalProcessPO ManageApprovalProcessPOobj = new ManageApprovalProcessPO();

	@When("user fill approval process name")
	public void userFillApprovalProcessName() {
		String approvalName = "approval" + CommonAction.generateRandomStrings(10, "String");
		PropFileHandler.writeProperty("approvalName", approvalName);
		ManageApprovalProcessPOobj.fillApprovalProcessName(approvalName);
	}

	@And("user fill mandatory fields for approval process")
	public void userFillMandatoryFieldsForApprovalProcess() {
		ManageApprovalProcessPOobj.fillMandatoryFieldsOfApprovalProcess();
	}

	@And("verify created approval process is visible")
	public void verifyCreatedApprovalProcessIsVisible() {
		String approvalName = PropFileHandler.readProperty("approvalName");
		Assert.assertTrue(ManageApprovalProcessPOobj.verifyApprovalProcessAdded(approvalName),
				"Test case failed : As user is not able to see new added Approval Process " + approvalName + "");
	}

	@And("user fill all details of approval process")
	public void userFillAllDetailsOfApprovalProcess() {
		ManageApprovalProcessPOobj.fillAllDetailsOfApprovalProcess();
	}

	@And("user prefill from existing approval process")
	public void userPrefillFromExisitingApprovalProcess() {
		ManageApprovalProcessPOobj.prefillFromExistingApprovalProcess();
	}

	@When("user click on backarrow")
	public void userClickOnBackArrow() {
		ManageApprovalProcessPOobj.clickOnBackArrow();
	}
	
	@When("user enter approval process name in search bar and click on search")
	public void enterApprovalProcessNameInSearchbar() {
		String approvalName = PropFileHandler.readProperty("approvalName");
		ManageApprovalProcessPOobj.enterApprovalProcessClickOnSearchbar(approvalName);
	}
	
}
//\"([^\"]*)\"