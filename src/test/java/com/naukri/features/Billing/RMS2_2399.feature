@RMS
Feature: Generate / Edit Proforma Invoice - Tab 1, top section

  User has moved candidate to billing stage and candidate is moved to "To be generated tab"

  Background:
    Given User login to the application "rmsDashboardPage" using "Superuser" of "ConsultantPlus" user
    And User Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "percentage" , chargeValue as "30" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "false" .
    When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
    And User fill "Designation - Test" in "Offered Designation" .
    And User fill "50000" in "Candidate's joining salary" .
    And User select "Monthly" as "period" for "Candidate's joining salary" in Drop Down.
    And User select calendar date for "Candidate's tentative joining date" to be 10 days later .
    And User select calendar date for "Offered on" to be 1 days later .
    And user click on "Next" button in footer On Offer Detailed Page
    And user click on "Skip" button in footer On Offer Detailed Page
    Then Moved candidate information should be displayed with designation as "Designation - Test" , joining salary as "50000"

  @id:1 @billing
  Scenario: Verify if the Pre-filled Billable Salary and Billing Category is displayed
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    When User click on "Generate Proforma Invoice" under more options
    Then Label "Choose an invoice rate to be applied" of type "span" with correct value is displayed
    And Label "Candidate's billable salary" of type "input" with correct value is displayed
    And Category rate or fee should be displayed with correct value
    And Label "Payable Amount " of type "span" with correct value is displayed

  @id:2 @billing
  Scenario: Verify if changed Billing Category is reflected on top section for types of Billing Category
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    And Added Candidate Name should be displayed in "To Be Generated" Tab under "INV --" label
    When User add another Billing Category with name as "Bill-Test" and value as "10000" and type as "flat"
    And User is on "billingDashboard" page
    And User click on "Generate Proforma Invoice" under more options
    Then Displayed label "Choose an invoice rate to be applied" must have added Billing Category name as "Bill-Test" .
    When User click on "Choose an invoice rate to be applied" Drop Down and select "Bill-Test" with value as "10000" and type as "flat" .
    Then Label "Choose an invoice rate to be applied" of type "span" with correct value is displayed
    And Label "Candidate's billable salary" of type "input" with correct value is displayed
    And Category rate or fee should be displayed with correct value
    And Label "Payable Amount " of type "span" with correct value is displayed

  @id:3 @billing
  Scenario: Verify top section details if Employer doesn't have any Billing Details
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    And Added Candidate Name should be displayed in "To Be Generated" Tab under "INV --" label
    When User remove all Billing Category
    And User is on "billingDashboard" page
    And User click on "Generate Proforma Invoice" under more options
    Then Displayed label "Choose an invoice rate to be applied" with value as "Others" 
    And Label "Candidate's billable salary" of type "input" with correct value is displayed
    And Label "Enter Billing Amount" of type "input" with correct value is displayed
    And Category rate or fee should not be displayed
    And Displayed label "Payable Amount " with value as "0"

  @id:4 @billing
  Scenario: Verify all texts and label name in top section
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    When User click on "Generate Proforma Invoice" under more options
    Then Verify User see text "Fill Proforma Invoice Details"
    And Verify User see text "This invoice has no serial number yet. Taxable invoice can be generated by clicking on generate invoice blue button on previous page"
    And User see valid text for Generate Proforma Invoice on header

  @id:5 @billing
  Scenario: Verify top section for Edit Proforma Invoice
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    When User generate PI for the added candidate
    And User click on "Edit Proforma Invoice" under more options
    Then User should not see text "Candidate's billable salary(as filled by recruiter)" .
