@RMS @RMSOfferGeneration @RMSOfferNewFlow
Feature: Offer Generation create, edit and delete offer doc templates

  Background: 
    Given I login into RMS as "Enterprise.Super_user"
    When User is on "settingsPage" page
    When I click "Offer Document Templates " link on Settings page
    And click on add new offer document template
    And check whether salary breakup template exists in system or not , if not create one

  @RMSOfferDocument
  Scenario: To verify offer document template is created and displayed on listing page
    When Navigate to Offer Doc Listing Page
    And click on add new offer document template
    And enter offer doc template name
    And select salary rule name from Salary Breakup rule name DD
    And click on save offer doc template
    Then verify offer doc template, salary breakup rule name, created by and last modified is displayed

  @RMSOfferDocument
  Scenario: To verify offer doc template can be deleted from listing page
    When Navigate to Offer Doc Listing Page
    And click on add new offer document template
    And enter offer doc template name
    And select salary rule name from Salary Breakup rule name DD
    And click on save offer doc template
    Then click on delete offer doc template on listing page
    Then offer doc template should be deleted from listing page
    And confirmation strip should be displayed on listing page

  @RMSOfferDocument
  Scenario: To verify if salary breakup template is deleted , it should not be displayed on offer doc listing page and Salary Breakup rule name DD
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    When click on next button on footer salary breakups page
    Then verify Define Salary Breakup is displayed
    And select "Sheet1:B2" in CTC dropdown
    And click on next button on footer salary breakups page
    Then verify Review & Approve is displayed
    And enter "string" value in "Offered Designation" field
    And select a date "2" days for current date in "Offered on" datepicker
    And select a date "4" days for current date in "Candidate's tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And click "Update Breakup" on Review page
    Then verify all the input and output fields in the breakup table
    And click "Confirm" button on Review page
    When Navigate to Offer Doc Listing Page
    And click on add new offer document template
    And enter offer doc template name
    And click on Salary Breakup rule name DD
    And select the created salary breakup template
    And click on save offer doc template
    And Navigate to Salary Rule Listing Page
    And click on delete template from salary breakup listing page
    When Navigate to Offer Doc Listing Page
    Then verify salary breakup name should not be displayed
    When click on add new offer document template
    And click on Salary Breakup rule name DD
    Then verify salary breakup name should not be displayed in Salary Breakup rule name DD

  @RMSOfferDocument
  Scenario: To verify edit functionality of offer doc template
    When Navigate to Offer Doc Listing Page
    And click on add new offer document template
    And enter offer doc template name
    And select salary rule name from Salary Breakup rule name DD
    And click on save offer doc template
    And click on edit offer doc template on listing page
    And edit doc template name
    And select another salary rule name from Salary Breakup rule name DD
    When click on save offer doc template
    Then verify offer doc template, salary breakup rule name, created by and last modified is displayed

  # not to be done
  #Scenario: To verify text under zoho editor is set to blank when salary breakup is changed in create flow
    #Given I login into RMS as "<userType>"
    #When Navigate to Offer Doc Listing Page
    #And click on add new offer document template
    #And enter offer doc template name
    #And select salary rule name "salary rule name" from Salary Breakup rule name DD
    #And enter random text under zoho editor
    #And select salary rule name "salary rule name1" from Salary Breakup rule name DD
    #Then verify text under zoho editor should set to blank

  #not to be done
  #Scenario: To verify by default only 10 offer doc templates are displayed
    #Given I login into RMS as "<userType>"
    #When Navigate to Offer Doc Listing Page
    #Then verify 10 offer doc templates are displayed
    #When select 20 offer doc templates from dropdown
    #Then verify 20 offer doc templates are displayed

  @RMSOfferDocument
  Scenario: To verify offer doc template name can be edited from offer doc listing page
    When Navigate to Offer Doc Listing Page
    And click on add new offer document template
    And enter offer doc template name
    And select salary rule name from Salary Breakup rule name DD
    And click on save offer doc template
    Then verify offer doc template, salary breakup rule name, created by and last modified is displayed
    When inline editing the created offer doc template name from listing page
    Then verify offer doc template name is edited

  @RMSOfferDocument
  Scenario: To verify if salary breakup template is under draft state , it should get removed from salary breakup DD
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    When click on next button on footer salary breakups page
    Then verify Define Salary Breakup is displayed
    And select "Sheet1:B2" in CTC dropdown
    And click on next button on footer salary breakups page
    Then verify Review & Approve is displayed
    And enter "string" value in "Offered Designation" field
    And select a date "2" days for current date in "Offered on" datepicker
    And select a date "4" days for current date in "Candidate's tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And click "Update Breakup" on Review page
    #Then verify all the input and output fields in the breakup table
    And click "Confirm" button on Review page
    And Navigate to Offer Doc Listing Page
    And click on add new offer document template
    And click on Salary Breakup rule name DD
    Then verify the salary breakup template name is displayed
    When Navigate to Salary Rule Listing Page
    And click on edit salary breakup template
    And click on next button on footer salary breakups page
    And click on next button on footer salary breakups page
    And click on add new input
    And fill label name "Label5"
    And click on next button on footer salary breakups page
    And click on cancel from salary breakups lightbox
    When Navigate to Offer Doc Listing Page
    And click on add new offer document template
    And click on Salary Breakup rule name DD
    Then verify salary breakup name should not be displayed in Salary Breakup rule name DD
