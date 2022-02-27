package com.naukri.stepdefinitions.Assessment;

import java.io.File;
import java.util.List;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.naukri.automation.util.APITestOps;
import com.naukri.automation.util.PropFileHandler;
import com.naukri.automation.util.ReadEmail;
import com.naukri.automation.util.ReadWritePropertyFile;
import com.naukri.automation.util.TestNGLogUtility;
import com.naukri.automation.util.WaitUtility;
import com.naukri.pageobjects.Assessment.AttachTestCandidatePO;
import com.naukri.pageobjects.Assessment.TestDetailsOnSrpAndCVDetailsPO;
import com.naukri.stepdefinitions.VendorPlatform.AssessmentFeaturesSrpCvDetailsPageStepDef;
import com.naukri.stepdefinitions.VendorPlatform.VideoInterviewStepDef;
import com.naukri.test.base.BaseAutomation;
import com.naukri.test.base.CommonAction;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TestDetailsOnSrpAndCVDetailsStepDef extends BaseAutomation{
	TestDetailsOnSrpAndCVDetailsPO PageTestDetails = (TestDetailsOnSrpAndCVDetailsPO) PageObjectWrapper
			.getObject(TestDetailsOnSrpAndCVDetailsPO.class);
	CommonAction commonActions = (CommonAction) PageObjectWrapper.getObject(CommonAction.class);
	APITestOps APITestObj = (APITestOps) PageObjectWrapper.getObject(APITestOps.class);
	AttachTestCandidatePO AttachTestOnSrp = new AttachTestCandidatePO();
	private static String TestDataFile = ".//src//test//resources//testdata//testDataAssessment.properties";
	public static String content="";
	SoftAssert softAssert=new SoftAssert();
	@Then("^verify the assessment tuple on srp page$")
	public void verifyAssessmentTupleOnSRPPage(DataTable dt) {

		List<String> list = dt.asList(String.class);

		Assert.assertEquals(PageTestDetails.checkTupleSRP(list.get(0)), true);
	}

	@When("^Recruiter Navigated to requirement SRP Page$")
	public void navigateToSRPPage() {
		PageTestDetails.navigateToSrpPage();

	}

	@And("^Navigate to requirement CVDetails Page$")
	public void navigateToCVDetailsPage() {
		PageTestDetails.navigateToCVDetailsPage();
	}

	@And("^Move candidate to following stage$")
	public void moveCandidateToAStatus(DataTable dt) {
		List<String> list = dt.asList(String.class);
		PageTestDetails.statusChangeDD(list.get(0));
	}

	@And("^click on folllowing tuple Link$")
	public void clickLinkTupleOnSRP(DataTable dt) {
		List<String> list = dt.asList(String.class);
		PageTestDetails.clickLinkonTupleOnSRP(list.get(0));
	}

	@And("^click on following in reminder lightbox$")
	public void chooseYesorNoReminderBox(DataTable dt) {
		List<String> list = dt.asList(String.class);
		PageTestDetails.selectResponseSendReminder(list.get(0));
//		reloadPage();
	}

	@Then("verify reminder sent icon is visible on srp page")
	public void VerifyReminderSentLinkOnSrp() {
		Assert.assertEquals(PageTestDetails.VerifyReminderSentLink(), true);
		Reporter.log("Test case Passed : As Reminder send link exist as per functionality");
	}

	@When("reload the page")
	public void reloadPage() {
		PageTestDetails.pageRefresh();
	}
	
	@And("delete all mail with label \"([^\"]*)\"")
	public void deleteAllGmailMail(String labelName) {
		ReadEmail.deleteMail(ReadWritePropertyFile.getProperty("gmailCandId", TestDataFile),
				ReadWritePropertyFile.getProperty("gmailCandPwd", TestDataFile), labelName);
		TestNGLogUtility.info("Deleted mails with label "+labelName);
	}

	@Then("^verify the reminder mail is sent to the candidate$")
	public void verifyReminderMail() {
		String StorageFileLocation	= ".//assessmentTest.html";
		String mailStatus = ReadEmail.ReadEmailContent("Reminder|", ReadWritePropertyFile.getProperty("gmailCandId", TestDataFile),
				ReadWritePropertyFile.getProperty("gmailCandPwd", TestDataFile), "inbox", StorageFileLocation);
		Assert.assertEquals("Mail Found", readMail(),
				"Test case Failed : As candidate did not receive a mail which should not happen as the description of test case");
	}
	
	@Then("User verify that Recipient get the listed mail for specific requirement with label \"([^\"]*)\"")
	public void verifyThatCandidateGetTheListedMail(String labelName, DataTable dt) throws InterruptedException {
		List<String> list = dt.asList(String.class);
		String StorageFileLocation = System.getProperty("user.dir") + File.separator + list.get(1);
		if(VideoInterviewStepDef.mailSubject.equals(""))
			VideoInterviewStepDef.mailSubject = list.get(0)+ " " + AssessmentFeaturesSrpCvDetailsPageStepDef.reqName;
		TestNGLogUtility.info(VideoInterviewStepDef.mailSubject);
		String mailStatus[] = ReadEmail.WaitandReadEmailContent(VideoInterviewStepDef.mailSubject,
				ReadWritePropertyFile.getProperty("gmailCandId", AssessmentDashboardStepDefs.TestDataFile),
				ReadWritePropertyFile.getProperty("gmailCandPwd", AssessmentDashboardStepDefs.TestDataFile), labelName,
				StorageFileLocation);
		content= mailStatus[1];
		TestNGLogUtility.info("Content:"+content);
		VideoInterviewStepDef.mailFound=content;
		VideoInterviewStepDef.mailSubject = "";
		softAssert.assertEquals(mailStatus[0], "Mail Found", "Test case failed : As user did not get the mail");
		//softAssert.assertAll();
	}

	@When("Candidate Read the mail")
	public String readMail() {
		String StorageFileLocation = ".//assessmentTest.html";
		String mailStatus[] = ReadEmail.WaitandReadEmailContent("Online Assessment Test link for",
				ReadWritePropertyFile.getProperty("gmailCandId", TestDataFile),
				ReadWritePropertyFile.getProperty("gmailCandPwd", TestDataFile), "inbox", StorageFileLocation);
		content= mailStatus[1];
		return mailStatus[0];
	}

	@Then("^verify the reminder mail is not sent to the candidate$")
	public void verifyReminderMailNotSent() {
		Assert.assertEquals("Mail Not Found", readMail(),
				"Test case Failed : As candidate received a mail which should not happen as the description of test case");
	}

	@Then("verify result on Srp")
	public void verifyResultOnSrp() {
		boolean result = AttachTestOnSrp.verifyResultsOnSrp();
		Assert.assertTrue(result, "Test fail as information on srp page is wrong");
	}
}
