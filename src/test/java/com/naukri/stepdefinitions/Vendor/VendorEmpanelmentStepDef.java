package com.naukri.stepdefinitions.Vendor;

import java.util.Date;
import java.util.List;

import com.naukri.automation.util.*;

import com.naukri.pageobjects.Reports.SaveAndSchedulePageObject;
import com.naukri.pageobjects.Vendor.VendorEmpanelmentPO;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;


public class VendorEmpanelmentStepDef {

	VendorEmpanelmentPO vendorEmpanelmentPO = (VendorEmpanelmentPO) PageObjectWrapper.getObject(VendorEmpanelmentPO.class);
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	SaveAndSchedulePageObject SaveAndScheduleObject = new SaveAndSchedulePageObject();

	public String vendorname, vendorInvitationMailId="kjj";
	public String pocName, pocPhnNumber, pocMailId;
	public String BillingBracketName;



	@And("Add all details in Add New Billing Rate")
	public void addContractDetails() {
		BillingBracketName = CommonAction.generateRandomStrings(10, "Alphanumeric");
		vendorEmpanelmentPO.fillTrackContractDetails(BillingBracketName);
		TestNGLogUtility.info("Added all the details of billing rate");

	}

	@And("User Verify that all billing information added successfully")
	public void verifyBillingAdded() {
		System.out.println(BillingBracketName);
		Assert.assertTrue(vendorEmpanelmentPO.verifyBillingRate(BillingBracketName), "Test case failed : As billing rate not added");
		TestNGLogUtility.pass("Verified all billing information added successfully");
	}

	@And("User Verify that Clicking on Cancel discards the added details and takes me back to the previous page")
	public void verifyBillingRateCancel() {
		System.out.println(BillingBracketName);
		Assert.assertFalse(vendorEmpanelmentPO.verifyBillingRate(BillingBracketName), "Test case failed : As billing rate added");
		TestNGLogUtility.pass("Verified Billing rate cancelled and took back to previous page ");
	}


	@And("User fills all the information of Vendor")
	public void enterVendorDetails() {
		vendorname = CommonAction.generateRandomStrings(10, "Alphanumeric");
		vendorInvitationMailId = (CommonAction.generateRandomStrings(10, "Alphanumeric")) + ("@yopmail.com");
		vendorEmpanelmentPO.addNewVendorName(vendorname);
		vendorEmpanelmentPO.addNewVendorDetails(vendorInvitationMailId);
		TestNGLogUtility.info("Filled all the information of vendor");
	}

	@Then("User Verify that user is able to see Vendor name and following status")
	public void verifyVendorStatus(DataTable dt) {
		List<Object> list = dt.asList(String.class);
		boolean flag = vendorEmpanelmentPO.checkVendorStatus(vendorname, list.get(0).toString());
		Assert.assertEquals(flag, true);
		TestNGLogUtility.pass(" user is able to see Vendor name and following status");
	}


	@And("User fills all the information of Add New Point of Contact")
	public void fillPocDetails() {
		pocName = CommonAction.generateRandomStrings(10, "Alphanumeric");
		pocMailId = ("POC") + (CommonAction.generateRandomStrings(7, "Alphanumeric")) + ("@yopmail.com");
		pocPhnNumber = ("6") + CommonAction.generateRandomStrings(9, "Number");
		vendorEmpanelmentPO.newVendorfillPocDetails(pocName, pocMailId, pocPhnNumber);
	}


	@Then("User Verify Poc Added successfully")
	public void verifyPOC() {
		vendorEmpanelmentPO.verifyNewVendorPocAdd(pocName);
		Assert.assertTrue(vendorEmpanelmentPO.verifyNewVendorPocAdd(pocName), "test case failed: As did not find the POC name on the POC details Page");
		TestNGLogUtility.pass("Verified POC added successfully");
	}


	@Then("User Verify that user can see the POC,billing,files added,and invite sent details in popup")
	public void verifyVendorListingDetailsInPopUp() {
		Assert.assertTrue(vendorEmpanelmentPO.vendorDetailsfromVendorListingPopUp(vendorname));
		TestNGLogUtility.pass("Verfied Vendor Listing details from PopUp on Manage Vendor Page");
	}

	@And("User Verify user is able to see the view more link for contract details and Billing rate in popup")
	public void verifyViewMoreLink() {
		Assert.assertTrue(vendorEmpanelmentPO.verifyViewMore(), "Test Case Failed : As view more link on pop up of vendor listing does not exist");
		TestNGLogUtility.pass("User is able to see view more link in PopUp");
	}


	@And("User fills all the details in flat fee section")
	public void addFlatFeeDetails() {
		addContractDetails();
		TestNGLogUtility.info("User filled all the details in flat fee section");
	}

	@Then("User Verify that all billing information in flat fee section added successfully")
	public void verifyFlatFeeRate() {
		Assert.assertTrue(vendorEmpanelmentPO.verifyFlatFee(BillingBracketName), "Test case Failed : As user is not able to see the infromation which filled in flat fee section");
		TestNGLogUtility.pass("Verified that all billing information added in flat fee section");
	}

	@Then("User Verify that all billing information in flat fee section discarded successfully")
	public void verifyDiscardFlatFeeRate() {
		Assert.assertFalse(vendorEmpanelmentPO.verifyFlatFee(BillingBracketName), "Test case Failed : As user is not able to see the infromation which filled in flat fee section");
		TestNGLogUtility.pass("Verified that all billing information discarded in flat fee section");
	}

	@Then("User is successfully able to add the document")
	public void verifyUploadedDocument(){
		Assert.assertTrue(vendorEmpanelmentPO.verifyUploadedDocument());
		TestNGLogUtility.info("User is successfully able to add the document");
	}

	@When("User clicks on {string} uploaded document button")
	public void vendorEmpanalmentDownloadDocument(String btnname){
		vendorEmpanelmentPO.vendorEmpanalmentDownloadDocument(btnname);
		TestNGLogUtility.info("Clicked on Download button");
	}

	@Then("User Verify that user is able to delete the documents")
	public void verifyUserIsAbleToDeleteTheDocument(){
		Assert.assertTrue(vendorEmpanelmentPO.verifyUserIsAbleToDeleteTheDocument());
		TestNGLogUtility.pass("Verified that user is able to delete the documents");
	}
	@Then("User Verify that Clicking on CANCEL cancels the POC details addition and takes me back to the previous Vendor Details section")
	public void verifyCancelPoc() {
		vendorEmpanelmentPO.verifyNewVendorPocAdd(pocName);
		Assert.assertFalse(vendorEmpanelmentPO.verifyNewVendorPocAdd(pocName), "test case failed: As found the POC name on the POC details Page");
		TestNGLogUtility.pass("Verified canceled POC details");
	}

	@Then("User clicks on Upload Vendor Documents Tab")
	public void clickOnUploadVendorDocumentsTab()
	{
		vendorEmpanelmentPO.clickOnUploadVendorDocumentsTab();
		TestNGLogUtility.info("Clicked on Upload Vendor Documents Tab");
	}

	@Then("User clicks on Upload documents button")
	public void clickOnUploadDocumentsButton()
	{
		vendorEmpanelmentPO.clickOnUploadDocumentsButton();
		TestNGLogUtility.info("Clicked on Upload documents button");
	}
	@And("User clicks on back navigation arrow on Add New Vendor Page")
	public void clickBackNavigationArrow() {
		vendorEmpanelmentPO.clickBackNavigationArrow();
		TestNGLogUtility.info("User click on back button");
	}

	@Then("User Verify user Clicking on No button it take user back to the current Add Vendor page")
	public void verifyAddDetailsAndInviteVendorTab() {
		boolean flag = vendorEmpanelmentPO.verifyAddDetailsAndInviteVendorTab();
		Assert.assertEquals(flag, true, "Test case failed : Clicking on no button it is not returning to Add Details & Invite Vendor");
		TestNGLogUtility.pass("Verified when clicked on No redirecting to Add New Vendor Page");
	}

	@Then("User Verify that Clicking on yes button takes user back to the Manage Vendor Page without saving the vendor details")
	public void verifyNotRedirectingToAddNewVendorPage() {
		boolean flag = vendorEmpanelmentPO.verifyAddDetailsAndInviteVendorTab();
		Assert.assertEquals(flag, false, "Test case failed : Clicking on yes button it should not returning to Add Details & Invite Vendor");
		TestNGLogUtility.pass("Verified when clicked on yes not redirecting to Add New Vendor Page");
	}



	@And("User search {string} vendor on Manage Vendor page")
	public void manageVendorPageSearch(String vendorname){
		vendorEmpanelmentPO.searchVendorByName(vendorname);
		TestNGLogUtility.info("Searched the vendor of active status on manage vendor page");
	}

	@And("User clicks on search icon")
	public void clickOnSearchIcon(){
		vendorEmpanelmentPO.clickOnSearchIcon();
	}

	@And("User clicks on {string} tuple whose status is ActiveorExpired")
	public void clickOnVendorTupleOnManageVendor(String vendorname){
		vendorEmpanelmentPO.clickOnVendorTuple(vendorname);
		TestNGLogUtility.info("Clicked active/expired status vendor");
	}

	@Then("User Verify user is able to see {string} status in popup")
	public void verifyInviteAcceptedByTab(String Status)
	{
		Assert.assertTrue(vendorEmpanelmentPO.verifyInviteAcceptedBY(Status),"Verified");
		TestNGLogUtility.pass("Verified invite accepted by");
	}

	@When("User deletes the vendor by clicking delete option appears when hover on vertical ellipsis")
	public void deleteTheExistingVendor(){
		vendorEmpanelmentPO.deleteTheVendor();
		TestNGLogUtility.info("Deleted the vendor");
	}

	@Then("User Verify on Edit page when  user provides the deleted vendor name user should get duplicate name error")
	public void verifyDeletedVendorDetailsErrorMessage(){
		Assert.assertTrue(vendorEmpanelmentPO.verifyDeletedVendorErrorMessage(vendorname));
		TestNGLogUtility.pass("error for deleted vendor expired");
	}

	@Then("User Verify user is able to restore the deleted vendor on Edit page")
	public void verifyDeleteVendorDetails(){
		Assert.assertTrue(vendorEmpanelmentPO.verifyDeletedVendorDetails(vendorname));
		TestNGLogUtility.pass("user is able to restore the deleted vendor on Edit page");
	}

	@And("User clicks on requirement and selects requirement on Upload Multiple Cv page")
	public void clickRequirementSetSource(){
		vendorEmpanelmentPO.selectRequirementAndSetSource();
		TestNGLogUtility.info("CLicked requiremnet and click set source");
	}

	@Then("User Verify that user should not be able to see vendor in Invite Sent status")
	public void vendorSourceList(){
		Assert.assertFalse(vendorEmpanelmentPO.verifySetSourceList(vendorname),"Verified");
		TestNGLogUtility.pass("Not found the vendor of status invite sent");
	}

	@And("User stores the name of Vendors listed on Manage Vendor Page")
	public void nameOFVendorsOnManageVendor(){
		vendorEmpanelmentPO.storeNameOFVendors();
		TestNGLogUtility.info("Stored the vendor names");
	}

	@And("User redirects to {string} page")
	public void userRedirectsToPage(String PageName){
		commonActions.goToPageURL(YamlReader.getAppConfigValue("URLs." + PageName));
	}
	@And("User clicks on {string} button on Manage Vendor Page")
	public void clickOnAddNewVendorButtonOnManageVendorPage(String button){
		vendorEmpanelmentPO.clickOnAddNewVendorButtonOnManageVendorPage(button);
	}

	@And("User Edits the Vendor name with already exists name along white spaces etc")
	public void editTheVendorNameOnEdit(){
		vendorEmpanelmentPO.editExistingVendorNameWithDuplicateName();
		TestNGLogUtility.info("provided the duplicate name via edit vendor");
	}

	@And("User clicks on Vendor tuple of existing Vendor")
	public void clickOnEditForExistingVendorTuple(){
		vendorEmpanelmentPO.clickOnVendorTuple();
		TestNGLogUtility.info("CLicked Vendor tuple ");
	}
	@And("User fills the duplicate Vendor name with white spaces etc")
	public void vendorDuplicateNameWithSpace()
	{ vendorEmpanelmentPO.vendorDuplicateName();
		TestNGLogUtility.info("filled duplicate name with white spaces");
	}

	@Then("User Verify user should get error stating message under vendor name")
	public void verifyDuplicateNameError(){
		Assert.assertTrue(vendorEmpanelmentPO.verifyChecksForDuplicateName());
		TestNGLogUtility.pass("Verified the error of duplicate name");
	}
	@Then("User Verify User is not able to see the deleted vendor on Manage Vendor page")
	public void verifyDeletedVendorOnManageVendorPage(){
		Assert.assertFalse(vendorEmpanelmentPO.verifyVendorDeleted(vendorname));
		TestNGLogUtility.pass("User is not able to see the deleted vendor on Manage Vendor page");
	}
	@And("User provides duplicate vendor name")
	public void provideDuplicateVendorName(){
		vendorEmpanelmentPO.addNewVendorName(vendorname);

	}
	@And("User click on {string} button on the page")
	public void clickButtonOnManageVendorPage(String buttonName){
		vendorEmpanelmentPO.clickButtonOnAnyPage(buttonName);
		TestNGLogUtility.info("User clicked on "+ buttonName+" on the page");

	}

	@And("User clicks on {string} button")
	public void clickOnAddBillingRate(String buttonName) {
		vendorEmpanelmentPO.clickFlatFee(buttonName);
		TestNGLogUtility.info("Clicked on button");
	}

	@And("User clicks on {string}")
	public void ClickTrackContractDetails(String link) {
		vendorEmpanelmentPO.clickTrackContractDetails(link);
		TestNGLogUtility.info("Clicked on"+link+ "details");
	}

	@When("User clicks on {string} link on Manage Vendor Page")
	public void restoreTheDeletedVendorWithLink(String RestoreVendor)
	{
		vendorEmpanelmentPO.restoreTheDeletedVendor(RestoreVendor);
		TestNGLogUtility.info("clicked restore link and click on yes");
	}
	@And("User clicks on {string} button in conformation box")
	public void clickOnButton(String buttonName){
		SaveAndScheduleObject.clickOnDeleteButtonInDeleteCOnformationBox(buttonName);
	}
}

