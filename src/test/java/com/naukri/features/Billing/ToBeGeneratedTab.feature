@RMS @billing
Feature: To Be Generated Tab Scenario

  Background:
    Given User login to the application "rmsDashboardPage" using "Superuser" of "ConsultantPlus" user
    And User Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "percentage" , chargeValue as "30" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "true" .
    When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
    And User fill "Designation - Test" in "Offered Designation" .
    And User fill "50000" in "Candidate's joining salary" .
    And User select "Monthly" as "period" for "Candidate's joining salary" in Drop Down.
    And User select calendar date for "Candidate's tentative joining date" to be 10 days later .
    And User select calendar date for "Offered on" to be 1 days later .
    And user click on "Next" button in footer On Offer Detailed Page
    And user click on "Skip" button in footer On Offer Detailed Page
    #Then Moved candidate information should be displayed with designation as "Designation - Test" , joining salary as "50000"


  @id:1 
  Scenario: Verify Invoice is Generated with correct values
    Given User is on "settingsPage" page
    When User click on "Invoice Settings" link
    And user click on "Invoice No. prefix" tab
    And User Get Next Invoice Number from Invoice Settings
    And user click on "Registered Address & Bank Details" tab
    And User Get Billing Office Address from Invoice Settings
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    And Added Candidate Name should be displayed in "To Be Generated" Tab under "INV --" label
    When User "Generate Invoice" of the Candidate
    Then Label "Invoice Date" with correct value is displayed in layout
    And Label "Due Date" with correct value is displayed in layout
    And Label "Bill to" with correct value is displayed in layout
    And Label "Payable Amount" with correct value is displayed in sevice desc table
    And Label "Choose an invoice rate to be applied" of type "span" with correct value is displayed
    And Label "Candidate's billable salary" of type "input" with correct value is displayed
    And Billing Office shows correct info in layout
    And Total Amount shows correct info with tax exempted employer
    And Verify Invoice number is correct in layout
    When User click on "Generate Invoice" in footer in layout
    Then Verify success message for generated invoice
    
		
		
		