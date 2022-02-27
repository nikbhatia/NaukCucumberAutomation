@RMS @billingregression @RMS2-2397 
Feature: Candidate Tuple on To be Generated Section

  User has moved candidate to billing stage and candidate is moved to "To be generated tab"

  Background:
    Given User login to the application "rmsDashboardPage" using "Superuser" of "ConsultantPlus" user
    And User Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "percentage" , chargeValue as "30" , invoiceGenerationAfterDays as 0 , payableAfterDays as 0 , isTaxExempted as "true" .
    When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
    And User fill "Designation - Test" in "Offered Designation" .
    And User fill "50000" in "Candidate's joining salary" .
    And User select "Monthly" as "period" for "Candidate's joining salary" in Drop Down.
    And User select calendar date for "Offered on" to be 1 days later .
    And User select calendar date for "Candidate's tentative joining date" to be 1 days later .
    And user click on "Next" button in footer On Offer Detailed Page
    And user click on "Skip" button in footer On Offer Detailed Page
    Then Moved candidate information should be displayed with designation as "Designation - Test" , joining salary as "50000"

  @id:1 @billing @RMS2-2773 
  Scenario: Verify all Candidate tuple information is visible for Not Generated PI
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    And Added Candidate Name should be displayed in "To Be Generated" Tab under "INV --" label
    And Displayed tag should be "NOT GENERATED"
    And All Options should be displayed under more options for "NOT GENERATED" candidate under "To Be Generated" Tab with "Proforma Invoice" 
#    And On Label "INV --" , On mouse hover show "To Be Generated" Tab Information
    And Displayed label "Offered designation" with correct value
    And Displayed label "Joining Salary" with correct value
    And Displayed label "Payment Due on" with correct value
    And Displayed label "Offered on" with correct value

  @id:2 @billing @RMS2-2932 @RMS2-2887 @TestBilling
  Scenario Outline: Verify Warning Messages for Invoice Generation After Days and Payable After Days
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    And Added Candidate Name should be displayed in "To Be Generated" Tab under "INV --" label
    When User is on "settingsPage" page
    And user click on "Manage Employer " link
    And user click on "Edit" option of Employer
    When user click on Billing Details tab
    And user click on edit billing details of the employer
    When user fill <dueDate> in label "Payment becomes due after" for "input" type TextBox
    And user fill <remindDate> in label "Invoice generation becomes due before" for "input" type TextBox
    And user click on "SAVE" button
    And user click on Save button On Employer Page
    And user is on "cvDetailsPage" page for added candidate
    And User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
    And User fill "Designation - Test" in "Offered Designation" .
    And User fill "50000" in "Candidate's joining salary" .
    And User select "Monthly" as "period" for "Candidate's joining salary" in Drop Down.
    And User select calendar date for "Offered on" to be -1 days later .
    And User select calendar date for "Candidate's tentative joining date" to be 0 days later alpha.
    And user click on "Next" button in footer On Offer Detailed Page
    And user click on "Skip" button in footer On Offer Detailed Page
    And User is on "billingDashboard" page
    And User search for the employer under search employer
    Then Warning message should be displayed as <warningMessage> for Added Candidate
    Examples:
      | dueDate | remindDate | warningMessage                                                 |
      | "2"     | "1"        | "Payment due date in 2 days, invoice not yet generated."       |
      | "3"     | "2"        | "Invoice generation date in 1 day, invoice not yet generated." |
      | "0"     | "0"        | "Payment due date passed today, invoice not yet generated."    |
      | "2"     | "2"        | "Payment due date in 2 days, invoice not yet generated."       |

  @id:3 @billing
  Scenario: Verify all Candidate tuple information is visible for Generated PI
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    When User generate PI for the added candidate
    Then Added Candidate Name should be displayed in "To Be Generated" Tab under "PI" label
    And Displayed tag should be "NOT GENERATED"
    And All Options should be displayed under more options for "NOT GENERATED" candidate under "To Be Generated" Tab with "Proforma Invoice"
    And On Label "PI" , On mouse hover show "To Be Generated" Tab Information
    And Displayed label "Offered designation" with correct value
    And Displayed label "Joining Salary" with correct value
    And Displayed label "Payment Due on" with correct value
    And Displayed label "Offered on" with correct value

  @id:4 @billing
  Scenario: Verify all buttons and links are working for Not Generated and Generated PI
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    Then All Options should be displayed under more options for "NOT GENERATED" candidate under "To Be Generated" Tab with "Proforma Invoice"
    And On Hover in "To Be Generated" tab link "Generate Invoice" should be working
    And On Hover in "To Be Generated" tab link "View Candidate Details" should be working
    And In "To Be Generated" tab Btn "Generate Proforma Invoice" should be working
    When User generate PI for the added candidate
    Then Link "Proforma Invoice" should be working
    And In "To Be Generated" tab Btn "Generate Invoice" should be working
    And On Hover in "To Be Generated" tab link "Edit Proforma Invoice" should be working
    And On Hover in "To Be Generated" tab link "View Candidate Details" should be working
    And On Hover in "To Be Generated" tab link "Mail Proforma Invoice" should be working

