/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naukri.stepdefinitions.Vendor;

import static com.naukri.automation.util.YamlReader.getAppConfigValue;
import static com.naukri.automation.util.YamlReader.getYamlValues;

import java.io.File;
import java.util.List;

import com.naukri.automation.util.*;
import com.naukri.pageobjects.Vendor.VendorPortalPO;
import com.naukri.pageobjects.Vendor.VendorSubmissionPO;
import com.naukri.pageobjects.Vendor.VendorSubmissionVerificationPO;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class VendorDashboardStepDef {

	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	APITestOps APITestObj = new APITestOps();
	VendorSubmissionVerificationPO vendorSubmissionVerPO = (VendorSubmissionVerificationPO) PageObjectWrapper.getObject(VendorSubmissionVerificationPO.class);
	VendorSubmissionPO vendorSubmissionPO = (VendorSubmissionPO) PageObjectWrapper.getObject(VendorSubmissionPO.class);

	@Given("I am adding a single profile with new requirement")
	public void addNewCandidateAndReq(DataTable dt) {
		List<String> list = dt.asList(String.class);
		System.out.println(list.get(0));
		System.out.println("URLs: " + getAppConfigValue("URLs.authURL"));
		APITestObj.addCandidate(getAppConfigValue("Users.RMS.Username"), getAppConfigValue("Users.RMS.Password"), "",
				list.get(0));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User is on Setting Page")
	public void loginToRMSSettingsPage() {
		commonActions.loginToRMS(getAppConfigValue("URLs.RMSSettings"), getAppConfigValue("Users.Vendor.RMSUsername"), getAppConfigValue("Users.Vendor.RMSPassword"));
	}

	@Given("I am on requirement dashboard page")
	public void loginToRMSDashboardPage() {
		commonActions.loginToRMS(getAppConfigValue("URLs.RMSProjectList"), getAppConfigValue("Users.RMS.Username"),
				getAppConfigValue("Users.RMS.Password"));
		vendorSubmissionVerPO.getClientId();
	}

	@And("Select a requirement")
	public void selectARequirement() {
		commonActions.clickNewRequirement();
	}

	@And("I logged out from RMS")
	public void logoutRms() {
		commonActions.navigateToUrl(getAppConfigValue("URLs.RMSLogout"));
	}

	@When("User is on VendorPortal Page")
	public void navigateToVendorPortal(){
		vendorSubmissionPO.VendorLogin();

	}

	@When("Recruiter moved to a specific requirement")
	public void recruiterMovedToASpecificRequirement() {
		String requirementUrl = getAppConfigValue("URLs.baseURL")+ "/project/dashboard/" +ReadWritePropertyFile.getProperty("RequirementID", VendorPortalPO.vendorPortalFile);
		commonActions.navigateToUrl(requirementUrl);
	}


}
