@RMS_OfferSalaryRuleListing @RMSOfferGeneration @RMSOffer
Feature: Offer Generation Salary Rule Listing page

  Scenario Outline: To verify Salary breakup template is listed in drafted state after uploading the excel
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    And click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And click on cancel from salary breakups lightbox
    Then Salary template rule name should be listed on page
    And template should be in drafted state
    And verify the last modified date and last edited by "<userType>"

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify we are able to change the excel uploaded in screen one
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    And click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "OfferReddy.xlsx"
    Then verify "OfferReddy.xlsx" is displayed on excel upload screen
    When click on change excel link and upload "ExcelGreaterThan5Mb.xls"
    Then validate excel cant be uploaded greater than 5 MB

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify duplicate labels are not allowed in input screen
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    And click on add new input
    And fill label name "Label1"
    And click on next button on footer salary breakups page
    Then validation error ie unique label should be displayed

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify all sheets and corresponding coloumns are identified by the system
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    And click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "ExcelContaining2Sheets.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Manager" and click on labels DD
    Then validate "Manager" has 2 coloumns
    When choose sheet "Sheet1" and click on labels DD
    Then validate "Sheet1" has 10 coloumns

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify if no formula cell is present in excel then error should be displayed
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "NoFORMULA.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    Then verify error is displayed to upload a valid file

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify if All templates can be displayed on listing page
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    Then verify by default only 40 templates are displayed
    When select 20 templates from DD
    Then verify 20 templates are displayed

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify salary breakup template can be deleted from listing page
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    And click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And click on cancel from salary breakups lightbox
    And click on delete template from salary breakup listing page
    Then deleted template should not be displayed

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify if null values are present in range of vlookup , error should be thrown
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "vlookupError.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    Then verify error should be displayed in case null values is passed in vlookup formula ie "Blank cell Sheet3:A5 used in formula : VLOOKUP(B5, Sheet3!A1:B5, 2, FALSE)"

    Examples: 
      | userType             |
      | Enterprise.Super_user |
   
   Scenario Outline: To verify template name on listing page should be unique and verify special characters not allowed
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    And click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And click on cancel from salary breakups lightbox
    And edit template name on listing page and enter duplicate template name
    Then verify error message of not allowing duplicate template name should be displayed ie "Name already exists"
    When enter invalid chars as template name "!@#$%^&*("
    Then verify invalid chars should not be allowed "Alphanumeric, underscore(_), hyphen(-), space( ) and dot(.) characters are only allowed."

    Examples: 
      | userType             |
      | Enterprise.Super_user |
