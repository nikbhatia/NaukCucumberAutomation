@RMSOfferGenerationSalaryTemplateReviewAndApprove  @RMSOfferGeneration @RMSOffer
Feature: Offer Generation Salary Template review and approve page


  Scenario Outline: To verify All inputs are displayed on Review and Approve page
    Given I login into RMS as "<userType>"
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
    Then verify all input fields are displayed on Review page
      | Offered Designation *                |
      | Offered on *                         |
      | Candidate's tentative joining date * |
      | Label4 *                             |
      | Label1 *                             |

    Examples: 
      | userType             |
      | Enterprise.Super_user |


  Scenario Outline: To verify errors for all inputs are displayed on Review and Approve page
    Given I login into RMS as "<userType>"
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
    And click "Update Breakup" on Review page
    Then verify error message for each input fields
      | This field is mandatory  |
      | A valid date is required |
      | A valid date is required |
      | This field is mandatory  |
      | This field is mandatory  |

    Examples: 
      | userType             |
      | Enterprise.Super_user |


  Scenario Outline: To verify error when String is entered in numeric input field
    Given I login into RMS as "<userType>"
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
    And select a date "4" days for current date in " tentative joining date" datepicker
    And enter "string" value in "Label4" field
    And enter "number" value in "Label1" field
    And click "Update Breakup" on Review page
    Then verify error message for "Label4" field
      | A valid number is required |

    Examples: 
      | userType             |
      | Enterprise.Super_user |
      
  Scenario Outline: To verify computed value for output fields
    Given I login into RMS as "<userType>"
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
    And select a date "4" days for current date in " tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And click "Update Breakup" on Review page
    Then verify all the input and output fields in the breakup table

    Examples: 
      | userType             |
      | Enterprise.Super_user |
      

  Scenario Outline: To verify footnotes added to Review page
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    When click on next button on footer salary breakups page
    Then verify Define Salary Breakup is displayed
    And Click on Menu option for "Inside Cell"
    And Click "Add Footnote" on output screen
    Then "Add Footnote" layer opens on output screen
    And add Footnote Symbol "*" on the layer
    And add Footnote Text on the layer
      | This is a sample footnote text 1 |
      | This is a sample footnote text 2 |
      | This is a sample footnote text 3 |
    And click "Add Footnote" button
    And select "Sheet1:B2" in CTC dropdown
    And click on next button on footer salary breakups page
    Then verify Review & Approve is displayed
    And enter "string" value in "Offered Designation" field
    And select a date "2" days for current date in "Offered on" datepicker
    And select a date "4" days for current date in " tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And click "Update Breakup" on Review page
    Then verify footnotes have been added to Review page
      | *                                |
      | This is a sample footnote text 1 |
      | This is a sample footnote text 2 |
      | This is a sample footnote text 3 |

    Examples: 
      | userType             |
      | Enterprise.Super_user |

@3456789uhvbjn
  Scenario Outline: To verify template in non-draft mode on listing page
    Given I login into RMS as "<userType>"
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
    And select a date "4" days for current date in " tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And click "Update Breakup" on Review page
    Then verify all the input and output fields in the breakup table
    And click "Confirm" button on Review page
    Then Salary template rule name should be listed on page
    And template should not be in drafted state

    Examples: 
      | userType             |
      | Enterprise.Super_user |
