package com.naukri.stepdefinitions.Vendor;

import java.util.List;

import com.naukri.automation.util.TestNGLogUtility;
import org.testng.Assert;

import com.naukri.pageobjects.Vendor.VendorPortalPO;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.annotations.Test;

public class VendorPortalStepDef {
	VendorPortalPO vendorPortal = (VendorPortalPO) PageObjectWrapper.getObject(VendorPortalPO.class);

	@And("User added a Spoc on Vendor Portal")
	public void addVendorSpoc() {
		vendorPortal.addVendorSpoc();
		TestNGLogUtility.info("Vendor added a Spoc on Vendor Portal");
	}


	@And("User click on Poc Name")
	public void clickOnPocName() {
		vendorPortal.clickOnPocName();
		TestNGLogUtility.info("Vendor clicked on Poc name");
	}

	@And("User clicks on edit against POC Name")
	public void clickOnEditAgainstPOCName(){
		vendorPortal.clickEditIcon();
	}

	@And("User edits the information of Spoc")
	public void editVendorPoc() {
//		vendorPortal.clickEditIcon();
		vendorPortal.editPoc();
		TestNGLogUtility.info("Vendor edited the information of Spoc");
	}

	@And("User click on delete button")
	public void deletePoc() {
		vendorPortal.clickDeleteIcon();
		vendorPortal.clickPopUpDeleteButton();
		TestNGLogUtility.info("Vendor Clicked on delete button");
	}

	@Then("User Verify that Poc deleted successfully")
	public void deletePocInformation() {
		Assert.assertFalse(vendorPortal.verifyEditedVendorSpoc(), "Test case failed : As poc did not delete successfully");
		TestNGLogUtility.pass("Verified POC deleted successfully");
	}

	@Then("User Verify that POC edited successfully")
	public void verifyPocEdit() {
		Assert.assertTrue(vendorPortal.verifyEditedVendorSpoc(), "Test case failed: As did not find the entry of Poc ");
		TestNGLogUtility.pass("Verified POC edited successfully");
	}

	@Then("User Verify that POC Added successfully")
	public void verifyVendorSpoc() {
		Assert.assertTrue(vendorPortal.verifyVendorSpoc(), "Test Case Failed: As Spoc not added");
		TestNGLogUtility.pass("Verified PoC added successfully");
	}

	@And("Vendor clicks on {string} Link")
	public void manageUserClick(String buttonName) {
		vendorPortal.vednorManageUserSetting(buttonName);
		TestNGLogUtility.info("Clicked on Button");
	}
	@And("User Invites the below Recruiters")
	public void inviteNewRecruiters(DataTable dt){
		List<String>listOfRecruiters = dt.asList(String.class);
		vendorPortal.inviteNewRecruiters(listOfRecruiters);
	}

	@And("User Clicks on {string} Link in Invite recruiter section")
	public void userClicksOnShowMoreLink(String ShowMore) {
		vendorPortal.ClicksOnShowMoreLink(ShowMore);
	}



//	@When("User deletes the recruiter in {string} Status")
//	public void userDeletesTheRecruiterInStatus(String Status) {
//		vendorPortal.deletsTheRecruiterInInviteStatus(Status);
//	}

	@And("User counts the no of recruiter in {string} status")
	public void userCountsTheNoOfRecruiterInStatus(String status) {
		vendorPortal.countOfRecruiter(status);
		TestNGLogUtility.info("Counted Recruiter of-->"+status+" status");
	}

	@Then("Verify if there is only one recuiter in {string} state then user should not get delete icon other wise user should get delete against recruiter")
	public void verifyDeleteIconAgainstRegisteredRecruiter(String status) {
		switch (status){
			case "REGISTERED":
				Assert.assertTrue(vendorPortal.verifyDeleteIconAgainstRecruiter(status));
				TestNGLogUtility.pass("Verified Delete Icon against Recruiter");
				break;
			case "INVITED":
				Assert.assertTrue(vendorPortal.verifyDeleteIconAgainstRecruiter(status));
				TestNGLogUtility.pass("Verified Delete Icon against Recruiter");
				break;
		}

	}

	@When("User deletes the below Recruiters")
	public void deleteRecruiters(DataTable dt){
		List<String>listOfRecruitersToDelete = dt.asList(String.class);
		for(int i=0;i<listOfRecruitersToDelete.size();i++) {
			String recruiters = (listOfRecruitersToDelete.get(i).toString());
			vendorPortal.deleteRecruiters(recruiters);

		}
	}
}
