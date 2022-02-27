@RMSOfferINPUT @RMSOfferGeneration @RMSOffer
Feature: Offer Generation Salary Template input page
	
	
  Scenario Outline: To verify All inputs are identified by RMS and output screen is displayed
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    Then verify all inputs are identified by RMS
    When click on next button on footer salary breakups page
    Then verify Define Salary Breakup is displayed

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  Scenario Outline: To verify last active screen is displayed when edit draft is clicked and change button not displayed after clicking on next from upload excel page
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And click on cancel from salary breakups lightbox
    And click on edit salary breakup template
    Then labels tab should be displayed
    When click on Upload Excel Tab
    Then Change button should not be visible
    When click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    And click on cancel from salary breakups lightbox
    And click on edit salary breakup template
    Then input screen should be displayed

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  Scenario Outline: To verify labels of sheet1 are identified and sheet2 are not identified
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "ExcelContaining2Sheets.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    Then validate only sheet1 labels are identified and 4 labels of sheet2 not identified

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  Scenario Outline: To verify no labels are identified when skip is clicked
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "ExcelContaining2Sheets.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    #And choose sheet "Manager" and label "Column A"
    And click on skip button
    Then verify no labels are identified add label is displayed in 5 cells

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  Scenario Outline: To verify default value is displayed on review and approve screen
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    And click on Default value of "Label1" and enter "100"
    And click on next button on footer salary breakups page
    And Select any cell reference under CTC "Sheet1:B5"
    And click on next button on footer salary breakups page
    Then "Label1" should have default value as "100"

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  Scenario Outline: To verify for display only allows numeric, date and text fields and verify validation errors on review and approve screen
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    And click on next button on footer salary breakups page
    And Select any cell reference under CTC "Sheet1:B5"
    And click on next button on footer salary breakups page
    And click on Update Breakup
    Then verify all the validation errors on the page for labels "Offered Designation","Offered on","joining","Label4","Label1"

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  @checkTC1
  Scenario Outline: To verify choose from spreadsheet single choice DD values are correctly displayed on review  page and sheet name is also displayed when range is selected
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    And click on add new input
    And fill label name "Label5"
    And select input type of "Label5" as "Single Choice"
    And select Fetch From Spreadsheet of "Label5"
    And select sheet "Sheet1" under Fetch From Spreadsheet
    And enter range values "A2" to "A4"
    And Click on save on fetch from spreadsheet lightbox
    Then Value Range of "Label5" should be "Sheet1: A2:A4"
    When click on next button on footer salary breakups page
    And Select any cell reference under CTC "Sheet1:B5"
    And click on next button on footer salary breakups page
    Then verify Single choice values for Labelname "Label5" should be
      | Label1 |
      |  			 |
      | Label3 |

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  Scenario Outline: To verify error displayed when invalid range is entered in case of fetch from spreadsheet
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    And click on add new input
    And fill label name "Label5"
    And select input type of "Label5" as "Single Choice"
    And select Fetch From Spreadsheet of "Label5"
    And select sheet "Sheet1" under Fetch From Spreadsheet
    And enter range values "A2" to "A1"
    And Click on save on fetch from spreadsheet lightbox
    Then error should be displayed when invalid range is entered

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  @checkTC1
  Scenario Outline: Verify single choice DD on review and approve screen when Manually type Options are entered
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    And click on add new input
    And fill label name "Label5"
    And select input type of "Label5" as "Single Choice"
    And Add 3 values "value1","value2","value3" in manually type options under "Label5"
    And delete "value1" value from manually type options
    And Click on save on fetch from spreadsheet lightbox
    And click on next button on footer salary breakups page
    And Select any cell reference under CTC "Sheet1:B5"
    And click on next button on footer salary breakups page
    Then verify Single choice values for Labelname "Label5" after deleting one value should be
      | value2 |
      |  |
		
    Examples: 
      | userType              |
      | Enterprise.Super_user |

  @checkTC
  Scenario Outline: To verify user entered inputs can be deleted and should not be displayed on review and approve screen
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    And click on add new input
    And fill label name "Label5"
    And select input type of "Label5" as "Numeric"
    And click on next button on footer salary breakups page
    And Select any cell reference under CTC "Sheet1:B5"
    And click on next button on footer salary breakups page
    And click on Input tab
    And delete row with label "Label5"
    And click on next button on footer salary breakups page
    And click on next button on footer salary breakups page
    Then verify label "Label5" is not displayed on review and approve page

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  @checkTC
  Scenario Outline: To verify only "Numeric" value should be allowed on review and approve screen when "Numeric" is selected on input screen
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "SampleExcel1.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    And click on add new input
    And fill label name "Label5"
    And select input type of "Label5" as "Numeric"
    And click on next button on footer salary breakups page
    And Select any cell reference under CTC "Sheet1:B5"
    And click on next button on footer salary breakups page
    And Enter text value "test" under "Label5"
    And click on Update Breakup
    Then validation should be displayed to only enter numeric values under "Label5"

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  Scenario Outline: To verify single choice is detected when vlookup is present in excel sheet
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "VlookupExcel.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    Then verify single choice is detected in input type corresponding to label "field"

    Examples: 
      | userType              |
      | Enterprise.Super_user |

  Scenario Outline: To verify error is displayed when null values are selected from vlookup excel in range tyfyjg
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    When click on Create Salary Breakup
    And click on Upload Salary Spreadsheet "VlookupExcel.xlsx"
    And Fill the Salary Template rule name
    And click on next button on footer salary breakups page
    And choose sheet "Sheet1" and label "Column A"
    And click on next button on footer salary breakups page
    And click on add new input
    And fill label name "Label5"
    And select input type of "Label5" as "Single Choice"
    And select Fetch From Spreadsheet of "Label5"
    And select sheet "Sheet1" under Fetch From Spreadsheet
    And enter range values "Z1" to "Z2"
    And Click on save on fetch from spreadsheet lightbox
    And click on next button on footer salary breakups page
    Then verify blank cell error is displayed on input screen

    Examples: 
      | userType              |
      | Enterprise.Super_user |
