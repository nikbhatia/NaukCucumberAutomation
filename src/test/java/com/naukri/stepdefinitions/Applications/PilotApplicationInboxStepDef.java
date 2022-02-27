package com.naukri.stepdefinitions.Applications;

import com.naukri.automation.util.*;
import com.naukri.pageobjects.Applications.*;
import com.naukri.pageobjects.Billing.BillingDashboardPagePO;
import com.naukri.test.base.PageObjectWrapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class PilotApplicationInboxStepDef {

    GenericFunctions genericFunctions = (GenericFunctions) PageObjectWrapper.getObject(GenericFunctions.class);
    InboxPagePO inboxPagePO = (InboxPagePO) PageObjectWrapper.getObject(InboxPagePO.class);
    MasterProfileListingPagePO masterProfileListingPagePO = (MasterProfileListingPagePO) PageObjectWrapper.getObject(MasterProfileListingPagePO.class);
    CVDetailsPagePO cvDeatilsPagePo = (CVDetailsPagePO) PageObjectWrapper.getObject(CVDetailsPagePO.class);
    KafkaConsumerUtil kafka = (KafkaConsumerUtil) PageObjectWrapper.getObject(KafkaConsumerUtil.class);
    ViewApplicationDetailPagePO viewApplicationDetailPagePO = (ViewApplicationDetailPagePO) PageObjectWrapper.getObject(ViewApplicationDetailPagePO.class);
    BillingDashboardPagePO billingDashboardPagePO = (BillingDashboardPagePO) PageObjectWrapper.getObject(BillingDashboardPagePO.class);

    private String timeStamp = ""+System.currentTimeMillis();
    private String designation, joiningSalary, billabeSalary, joiningDate,comment;
    private int daysToShift,date;
    public static Map<String , String> offeredCandidateDetails = new HashMap<String , String>();
    private boolean joiningSalaryMonthlyFlag=false,billableSalaryMonthlyFlag= false;

    @When("I navigate to application inbox")
    public void i_navigate_to_application_inbox() {
        genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.applicationInbox"));
    }

    @When("I click on expand against the {string}")
    public void i_click_on_expand_against_the(String scopeOfAdvancedSearch) {
        inboxPagePO.clickOnExpandSearch(scopeOfAdvancedSearch);
    }

    @Then("I should be able to see the expand div against {string}")
    public void i_should_be_able_to_see_the_expand_div_against(String scopeOfAdvancedSearch) {
        Assert.assertTrue(inboxPagePO.visibilityOfExpandDiv(scopeOfAdvancedSearch), "The expand div is not visible");
    }

    @When("I read all the facets maintained in the application inbox with the number")
    public void i_read_all_the_facets_maintained_in_the_application_inbox_with_the_number() {
        inboxPagePO.fillAllTheFacetData();
    }

    @When("I click on each facet I check the {string} checkox")
    public void i_click_on_each_facet_I_check_the_checkox(String subStageText) {
        inboxPagePO.clickOnEachFacet(subStageText);
    }

    @Then("I should get the same number of CV counts as mentioned on the filter")
    public void i_should_get_the_same_number_of_CV_counts_as_mentioned_on_the_filter() {
        Assert.assertTrue(inboxPagePO.finalFlag, "The facet count mismatched");
    }

    @When("I read in the data of the star rating of that particular inbox")
    public void i_read_in_the_data_of_the_star_rating_of_that_particular_inbox() {
        inboxPagePO.fillStarRatingTemplate();
    }

    @Then("I should be able to see the sum of different star rating to be the total count of the inbox")
    public void i_should_be_able_to_see_the_sum_of_different_star_rating_to_be_the_total_count_of_the_inbox() {
        Assert.assertTrue(inboxPagePO.verifyTheTotalCountOfStarFacet(),
                "The sum calculated does not match the total number of CVs in the inbox");
    }

    @When("I click on each on of the star filter")
    public void i_click_on_each_on_of_the_star_filter() {
        inboxPagePO.starRatingFilterComparison();
    }

    @Then("I should be able to see the same CV count of inbox as on cluster size")
    public void i_should_be_able_to_see_the_same_CV_count_of_inbox_as_on_cluster_size() {
        Assert.assertTrue(inboxPagePO.starRatingFlag,
                "There is a difference between star rating filter facet count and the inbox total CV count");
    }

    @When("I navigate to profile inbox")
    public void i_navigate_to_profile_inbox() {
        genericFunctions.launchSpecificURL(YamlReader.getAppConfigValue("URLs.profileListingInbox"));
    }

    @When("I read the page display count of the inbox page")
    public void i_read_the_page_display_count_of_the_inbox_page() {

    }

    @Then("I should be able to see the same count as on the page display count")
    public void i_should_be_able_to_see_the_same_count_as_on_the_page_display_count() {
    }

    @When("I search for the candidate for master profile with {string}")
    public void i_search_for_the_candidate_for_master_profile(String masterProfileSearchKeyword) {
        cvDeatilsPagePo.fillGlobalSearchText(masterProfileSearchKeyword);
    }

    @When("I comment against the candidate for Master Profile SRP for {string}")
    public void i_comment_against_the_candidate_for_Master_Profile_SRP(String masterProfileSearchKeyword) {
        masterProfileListingPagePO.fillCommentText(masterProfileSearchKeyword);
    }

    @Then("I should see the number of comments visible")
    public void i_should_see_the_number_of_comments_visible() {
        Assert.assertTrue(masterProfileListingPagePO.checkForCommentCount(),
                "The comment count are not in sync");
    }

    @Then("I should be able to see the comment text visible")
    public void i_should_be_able_to_see_the_comment_text_visible() {
        Assert.assertTrue(masterProfileListingPagePO.checkCommentContext(),
                "The comments are not sync ");
    }

    @When("I navigate to the CV Details Page")
    public void i_navigate_to_the_CV_Details_Page() {
        masterProfileListingPagePO.clickOnCandidateNameToNavigate();
    }

    @Then("I should be able to see the comment text for the same candidate")
    public void i_should_be_able_to_see_the_comment_text_for_the_same_candidate() {
        Assert.assertTrue(masterProfileListingPagePO.checkCommentsFromListingPage(),
                "Test list for comments from CV details page");
    }

    @When("I click on candidate name of tupple")
    public void i_click_on_candidate_name_of_tupple() {
        masterProfileListingPagePO.waitForMasterProfileToLoad(AddASingleProfilePagePO.contactNumber);
        inboxPagePO.clickOnCandidateNameForCVDetailsPage(AddASingleProfilePagePO.candidateName);
    }

    @Then("I should be redirected to candidate details page")
    public void i_should_be_redirected_to_candidate_details_page() {
        Assert.assertTrue(masterProfileListingPagePO.comparePageURL(),
                "Redirection to candidate CV Details Page is not working");
    }

    @Then("I should be able to see contact of candidate highlighted")
    public void i_should_be_able_to_see_contact_of_candidate_highlighted() {
        Assert.assertTrue(cvDeatilsPagePo.getContactNumber().contains(AddASingleProfilePagePO.contactNumber),
                "Contact Number of candidate on candidate CV details page isn't visible");
    }

    @When("I fill in all the details")
    public void i_fill_in_all_the_details() {
        inboxPagePO.fillVenueForInterview();
        inboxPagePO.selectDayForInterview();
        inboxPagePO.selectTimeOfDay();
        inboxPagePO.setMinuteOfInterview();
    }

    @And("User click on set interview button")
    public void ClickOnSetInterview() {
        inboxPagePO.clickOnSetInterViewButton();
    }

    @Then("I should be able to see candidate on {string} on profile listing page")
    public void i_should_be_able_to_see_candidate_on_on_profile_listing_page(String statusStage) {
        Assert.assertTrue(cvDeatilsPagePo.verifyCandidateStatusChanges(statusStage), "[Assertion Fail]: Status is not chnaged to "+statusStage);
        TestNGLogUtility.pass("Status is chnaged to "+statusStage);
    }        
    
    @Then("Verify that user is able to see the requirement name just above the selection stage DD")
    public void verifyRequirementNameAboveTheSelectionStage(){
        Assert.assertTrue(inboxPagePO.verifyRequiregetElementmentNameIsVisible(),"[Assertion Fail]: Requirement name is not visible just above the selection stage DD");
        TestNGLogUtility.pass("Requirement name is visible just above the selection stage DD");
    }

    @Given("User Create Candidate Application for Billing Invoice for Consultant User with chargeMode as {string} , chargeValue as {string} , invoiceGenerationAfterDays as {int} , payableAfterDays as {int} , isTaxExempted as {string} .")
    public void userCreateCandidateApplicationForBillingInvoiceForConsultantUserWithChargeModeAsChargeValueAsInvoiceGenerationAfterDaysAsPayableAfterDaysAsIsTaxExemptedAs(String chargeMode, String chargeValue, int invoiceGenerationAfterDays, int payableAfterDays, String isTaxExempted) {
        viewApplicationDetailPagePO.generateCandidateIdWithEmployerOfRMSConsultantviaAPI(chargeMode, chargeValue, invoiceGenerationAfterDays, payableAfterDays, isTaxExempted);

    }

    @And("PI and Invoice Link should be displayed for the added candidate in Outstanding tab")
    public void piAndInvoiceLinkShouldBeDisplayedForTheAddedCandidateInOutstandingTab() {
        Assert.assertTrue(billingDashboardPagePO.visibilityOfFooterLinks(APITestOps.candidateName, "Proforma Invoice"), "Proforma Invoice Link is not displayed !!!");
        Assert.assertTrue(billingDashboardPagePO.visibilityOfFooterLinks(APITestOps.candidateName, "Invoice"), "Invoice Link is not displayed !!!");
    }

    @And("User create candidate and move the candidate to billing stage")
    public void userCreateCandidateAndMoveTheCandidateBillingStage() {
        viewApplicationDetailPagePO.generateCandidateIdWithEmployerOfRMSConsultantviaAPI("flat", "50000", 10, 90, "true");
        viewApplicationDetailPagePO.changeCandidateStageStatus("Offers & Joining", "Move To Billing");
        viewApplicationDetailPagePO.moveCandidateToBillingStage("Designation - "+timeStamp,"100000",1,"90000",15);
    }

    @When("User change candidate status to {string} with substage as {string} .")
    public void userChangeCandidateStatusToWithSubstageAs(String stage, String substage) {
        viewApplicationDetailPagePO.changeCandidateStageStatus(stage, substage);
    }

    public void fillCandidateOfferedData(String label, String value) {
        String modifiedLabel;
        if(label.contains("Candidate's joining salary")) {
            modifiedLabel = "Joining Salary";
            modifiedLabel = modifiedLabel.replaceAll(" ", "_").toUpperCase();
            offeredCandidateDetails.put(modifiedLabel, value);
        }

        if(label.contains("Offered Designation")) {
            modifiedLabel = "Offered designation";
            modifiedLabel = modifiedLabel.replaceAll(" ", "_").toUpperCase();
            offeredCandidateDetails.put(modifiedLabel, value);
        }

        if(label.contains("Offered on")) {
            modifiedLabel = "Offered On";
            modifiedLabel = modifiedLabel.replaceAll(" ", "_").toUpperCase();
            offeredCandidateDetails.put(modifiedLabel, value);
        }

        if(label.contains("Choose invoice rate to be applied")) {
            modifiedLabel = "Choose an invoice rate to be applied";
            modifiedLabel = modifiedLabel.replaceAll(" ", "_").toUpperCase();
            offeredCandidateDetails.put(modifiedLabel, value);
        }

        if(label.contains("Candidate's Billable salary")) {
            modifiedLabel = "Candidate's billable salary";
            modifiedLabel = modifiedLabel.replaceAll(" ", "_").toUpperCase();
            offeredCandidateDetails.put(modifiedLabel, value);
        }

        if(label.contains("Candidate's tentative joining date")) {
            modifiedLabel = "Joining On";
            modifiedLabel = modifiedLabel.replaceAll(" ", "_").toUpperCase();
            value = value.replaceAll(",", "");
            offeredCandidateDetails.put(modifiedLabel, value);
            setPaymentDueOn();
        }

        offeredCandidateDetails.put("OFFERED_BY" , BillingAPI.username.split("@")[0]);
        offeredCandidateDetails.put("FOR_REQUIREMENT", BillingAPI.requirementName);
        offeredCandidateDetails.put("HIRING_FOR", BillingAPI.employerName);
        offeredCandidateDetails.put("TOTAL_AMOUNT_PAYABLE", BillingAPI.billingValue);
        // System.out.println(offeredCandidateDetails);
    }

    private void setPaymentDueOn() {
        int payableAfterDay = Integer.parseInt(BillingAPI.payableAfterDays);
        TestNGLogUtility.info("payable after days " + BillingAPI.payableAfterDays + " daysToShift "+ daysToShift);
        Calendar cal =Calendar.getInstance();
        //System.out.println(offeredCandidateDetails.get("JOINING_ON"));
        cal.add(Calendar.DATE, daysToShift+payableAfterDay);
        SimpleDateFormat formatter =new SimpleDateFormat("d MMM yyyy");
        offeredCandidateDetails.put("PAYMENT_DUE_ON",formatter.format(cal.getTime()));
    }

    @And("User fill {string} in {string} .")
    public void userFillIn(String value, String label) {
        viewApplicationDetailPagePO.fillTextAreaOrInputTextBoxInViewContainer(value, label, "input");
        fillCandidateOfferedData(label,value);

    }

    @And("User select {string} as {string} for {string} in Drop Down.")
    public void userSelectAsForInDropDown(String value, String ddClassType, String labelName) {
        viewApplicationDetailPagePO.selectValueFromDDInViewContainer(labelName, value, ddClassType);
        if(labelName.contains("joining salary") && value.equalsIgnoreCase("Monthly")) {
            joiningSalaryMonthlyFlag=true;
        }
        if(labelName.contains("Billable salary") && value.equalsIgnoreCase("Monthly")) {
            billableSalaryMonthlyFlag=true;
        }
    }

    @And("User select calendar date for {string} to be {int} days later .")
    public void userSelectCalendarDateForToBeDaysLater(String label, int daysToShift) {
        String date=viewApplicationDetailPagePO.selectDateInCalender(label, daysToShift);
        this.daysToShift = daysToShift;
        fillCandidateOfferedData(label,date);
    }

    @When("^User select calendar date for \"(.*)\" to be (.*) days later alpha.$")
    public void ISelectCalendarDateForToBeDaysLaterAlpha(String label, int daysToShift) {
        String date=viewApplicationDetailPagePO.selectDateInCalender("special", daysToShift);
        this.daysToShift = daysToShift;
        fillCandidateOfferedData(label,date);
    }

    private void updateOfferedCandidateDetails() {
        if(joiningSalaryMonthlyFlag) {
            offeredCandidateDetails.put("JOINING_SALARY",""+(Integer.parseInt(offeredCandidateDetails.get("JOINING_SALARY"))*12));
        }
        if(billableSalaryMonthlyFlag) {
            offeredCandidateDetails.put("CANDIDATE'S_BILLABLE_SALARY",""+(Integer.parseInt(offeredCandidateDetails.get("CANDIDATE'S_BILLABLE_SALARY"))*12));
        }
    }

    @And("user click on \"([^\"]*)\" button in footer On Offer Detailed Page")
    public void userClickOnButtonInFooterOnOfferDetailedPage(String labelName){
        viewApplicationDetailPagePO.clickOnElementInFooter(labelName);
        if(labelName.equalsIgnoreCase("NEXT")) {
            updateOfferedCandidateDetails();
        }
    }

    @Then("Moved candidate information should be displayed with designation as {string} , joining salary as {string}")
    public void movedCandidateInformationShouldBeDisplayedWithDesignationAsJoiningSalaryAs(String designation, String joiningSalary) {
    	TestNGLogUtility.info("Feature designation " + designation + " ui of cv details page designation " + viewApplicationDetailPagePO.getElementValueOfStageStatusChange("Offer made for"));
        Assert.assertEquals(designation, viewApplicationDetailPagePO.getElementValueOfStageStatusChange("Offer made for"));
        TestNGLogUtility.info("Feature salary " + joiningSalary + " ui of cv details page salary " + viewApplicationDetailPagePO.getElementValueOfStageStatusChange("Salary Offered").replaceAll(",", ""));
        Assert.assertTrue(viewApplicationDetailPagePO.getElementValueOfStageStatusChange("Salary Offered").replaceAll(",", "").contains(joiningSalary));
    }
    
    @Then("User should be able to see the success message {string}")
    public void user_should_be_able_to_see_the_success_message(String successMessage) {
        Assert.assertTrue(inboxPagePO.verifyTheSuccessMessageText(successMessage), 
        		successMessage + " is not displayed on the inbox page");
        TestNGLogUtility.pass(successMessage + " is displayed on the inbox page");
    }
    
    @Then("User should see the status of candidate should be updated to {string} on inbox page")
    public void user_should_see_the_status_of_candidate_should_be_updated_to_on_inbox_page(String statusOfCandidate) {
    	Assert.assertTrue(inboxPagePO.verifyTheStatusOfFirstCandidate(statusOfCandidate), 
    			PropFileHandler.readProperty("firstCandidateNameForTest") + " is not " + statusOfCandidate);
    	TestNGLogUtility.pass(PropFileHandler.readProperty("firstCandidateNameForTest") + " is " + statusOfCandidate);
    }
	
	@When("User click on the {string} under {string} cluster")
	public void User_Click_On_The_Cluster(String subCluster, String cluster) {
		inboxPagePO.clickOnCluster(cluster, subCluster);
	}

	@When("User select the current date from calander")
	public void User_select_the_current_date_from_calander() {
		date = inboxPagePO.selectAppliationCustomDates();
	}

	@Then("User should be able to see all Application on the current Date")
	public void User_should_be_able_to_see_all_Application_on_the_current_Date() {
		Assert.assertTrue(inboxPagePO.verifyAppliedDateOnApplicationTuple(date),
				"Application are on inbox after applying application dates are not displayed correct");
		TestNGLogUtility.pass("Application are on inbox after applying application dates are displaying correct");
	}

	@Then("User should be able to see view count as {string} on tuple")
	public void User_should_be_able_to_see_view_count_as_on_tuple(String count) {
		Assert.assertTrue(inboxPagePO.verifyViewCountOnTuple(count),
				"View count on Application on inbox is not displayed correct");
		TestNGLogUtility.pass("View count on Application on inbox is displayed correct");
	}

	@Then("User should be able to see commnet count as {string} on tuple")
	public void User_should_be_able_to_see_commnet_count_as_on_tuple(String count) {
		Assert.assertTrue(inboxPagePO.verifyCommentCountOnTuple(count),
				"Comment count on Application on inbox is not displayed correct");
		TestNGLogUtility.pass("Comment count on Application on inbox is displayed correct");
	}

	@Then("User should be able to see star rating as {string} on tuple")
	public void User_should_be_able_to_see_star_rating_as_on_tuple(String count) {
		Assert.assertTrue(inboxPagePO.verifyStarCountOnTuple(count),
				"Star count on Application on inbox is not displayed correct");
		TestNGLogUtility.pass("Star count on Application on inbox is displayed correct");
	}

	@When("User enter comment on inbox")
	public void User_enter_comment_on_inbox() {
		comment = inboxPagePO.enterCommentOnInbox();
	}

	@When("User click on comment icon on inbox")
	public void User_click_on_comment_icon_on_inbox() {
		inboxPagePO.clickOnCommentIconOnInbox();
	}

	@Then("User shoule be able to see entered comment")
	public void User_shoule_be_able_to_see_entered_comment() {
		Assert.assertTrue(inboxPagePO.verifyAddedComment(comment),
				"Entered comment on Application on inbox is not displayed correct");
		TestNGLogUtility.pass("Entered comment on Application on inbox is displayed correct");
	}

	@Then("User should be able to see delete icon and comment date")
	public void User_should_be_able_to_see_delete_icon_and_comment_date() {
		Assert.assertTrue(inboxPagePO.verifyCommentDeleteIconAndCommentDate(),
				"Delete icon against comment on Application on inbox is not displayed");
		TestNGLogUtility.pass("Delete icon against comment on Application on inbox is displayed");
	}
	
	@Then("User should be able to see the {string} icon on page size widget {string}")
	public void user_should_be_able_to_see_the_icon_on_page_size_widget(String iconPosition, String index) {
	    Assert.assertTrue(inboxPagePO.verifyThePresenceOfIcon(iconPosition, index), 
	    		iconPosition + " at index "+ index + " is not visible");
	    TestNGLogUtility.pass(iconPosition + " at index "+ index + " is visible");
	}

	@When("User clicks on page number {string} on page size widget {string}")
	public void user_clicks_on_page_number_on_page_size_widget(String pageNumber, String index) {
	    inboxPagePO.clickOnPageNumber(pageNumber, index);
	}
	

}
