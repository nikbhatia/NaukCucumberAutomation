@RMS
Feature: Changes in invoice for SEZ & Unreg cases

  Define the changes in invoice for SEZ cases

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

  @id:1 @billing
  Scenario: Define the changes in invoice for SEZ cases
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    And On Hover in "To Be Generated" tab click the link "Generate Proforma Invoice"
    And User should see the "0 (18%)" under "IGST" column