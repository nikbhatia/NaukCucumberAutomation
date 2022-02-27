@regresssion
Feature: To verify MailFlow after generate PI/Invoices/CRN/Payment Receipt

  #Scenario: Verify Mail page is being displayed with all data after generation of invoice
  #Given I am on the "To be Generated" tab
  #When click on "Generate invoice" button
  #And click on "Generate invoice" button lightbox
  #Then "Invoice" mail page shoud displayed with success message
  #And On mail page "Generate Invoice" number should be displayed
  #And on mail page "Prefill from Template" , "Attach File" , "Save this mail as template" , "Mail a copy to me" , "[tags]" should be displayed
  #And on mail page "Send" , "Cancel" button should  be displayed
  #And download and print buttons are displayed.
  #And subject "Proforma Invoice for [Candidate Name], [Offered Designation]" should be displayed
  #
  #
  #Scenario: Verify send mail after invoice generation
  #Given I am on the "To be Generated" tab
  #When click on "Generate invoice" button
  #And click on "Generate invoice" button lightbox
  #And click on Cancel button on mail page
  #Then Mail sent successful message should be displayed.
  #
  #Scenario: Verify Candidate move to outstaning tab after invoice generation
  #Given I am on the "To be Generated" tab
  #When click on "Generate invoice" button
  #And click on "Generate invoice" button lightbox
  #And click on Cancel button on mail page
  #Then message "Invoice is now in Outstaing tab." should display and candidate should move to 'Outstanding' tab
  #When Click on 'Outstanding' link
  #Then Verify Candidate is displaying in "Outstanding" tab
  Background: 
    #Given User Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "percentage" , chargeValue as "30" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "true" .
    #When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
    #And User fill "Designation - Test" in "Offered Designation" .
    #And User fill "50000" in "Candidate's joining salary" .
    #And User select calendar date for "Candidate's tentative joining date" to be 10 days later .
    #And user click on "Next" button in footer On Offer Detailed Page
    #And user click on "Skip" button in footer On Offer Detailed Page
    #Then Moved candidate information should be displayed with designation as "Designation - Test" , joining salary as "50000"
    #
    Given User Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "percentage" , chargeValue as "30" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "false" .
    When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
    And User fill "Designation - Test" in "Offered Designation" .
    And User fill "50000" in "Candidate's joining salary" .
    And User select "Monthly" as "period" for "Candidate's joining salary" in Drop Down.
    And User select calendar date for "Candidate's tentative joining date" to be 10 days later .
    And User select calendar date for "Offered on" to be 1 days later .
    And user click on "Next" button in footer On Offer Detailed Page
    And user click on "Skip" button in footer On Offer Detailed Page
    Then Moved candidate information should be displayed with designation as "Designation - Test" , joining salary as "50000"
    
	@id:1
  Scenario: Verify that templates are correctly mapped with category and are visible on compose mail for client page .
    Given i am on manage email template
    When I click on Add new template
    And I choose finance option
    And select the "Proforma invoice" category
    And clear the subject and add subject "Test Subject Mail Template"
    And clear the body and add body "Test Body Mail Template"
    And Enter the template name "Test Template Name" and save it
    And User is on "billingDashboard" page
    #	Then User should be on "To Be Generated" Tab
    And click on candidate tuple "Generate Proforma Invoice" button
    And click on "Generate Proforma Invoice" button lightbox
    And click under "Prefill from Template" DD and choose that template
    Then Verify "Test Subject Mail Template" subject and "Test Body Mail Template" body should be displayed
    
	@id:2
  Scenario: Verify that tags under financial tab are working
    Given User is on "billingDashboard" page
    When User "Generate Invoice" of the Candidate
    And click on "Generate Invoice" button lightbox
    And click on  tags drop down and choose "Finance" tab
    Then Verify all the tags are visible
        #Scenario: Verify that preview mail is working fine
        #Given User is on "billingDashboard" page
         #When User "Generate Invoice" of the Candidate
        #And click on "Generate Invoice" button lightbox
        #And Enter subject "mail subject" and body "mail body" 
        #Then Download button and print button are visible
        #And Preview mail lightbox should be opened
        #And Mail fields including "mail subject" and "mail body" should be correctly displayed on preview
