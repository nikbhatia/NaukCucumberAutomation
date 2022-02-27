@RMS @billing
Feature: Moving candidate across tabs Scenario

  Moving candidate across tabs

  Background:
   	Given User login to the application "rmsDashboardPage" using "Superuser" of "ConsultantPlus" user
    And User Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "percentage" , chargeValue as "30" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "true" .
    When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
    And User fill "Designation - Test" in "Offered Designation" .
    And User fill "50000" in "Candidate's joining salary" .
    And User select "Monthly" as "period" for "Candidate's joining salary" in Drop Down.
    And User select calendar date for "Offered on" to be 1 days later .
    And User select calendar date for "Candidate's tentative joining date" to be 10 days later .
    And user click on "Next" button in footer On Offer Detailed Page
    And user click on "Skip" button in footer On Offer Detailed Page
    Then Moved candidate information should be displayed with designation as "Designation - Test" , joining salary as "50000"

  @id:1 @RMS2-2755 @RMS2-2756 @RMS2-2848
  Scenario: Moving candidate across tabs
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    When User "Generate Invoice" of the Candidate
    Then User get the Invoice Number of the candidate
    When User generate PI for the added candidate from performa invoice page
    And User verify the "Candidate Name" and "Invoice Number" on "To Be Generated" tab
    When user click on "Outstanding" tab on billing dashboard
    Then Added Candidate Name should be displayed in "Outstanding" Tab under "IN" label
   	
   		 
   		 
   		 
   		 