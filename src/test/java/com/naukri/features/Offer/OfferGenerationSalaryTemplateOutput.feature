@RMSOfferGenerationSalaryTemplateOutput @RMSOfferGeneration @RMSOffer
Feature: Offer Generation Salary Template output page

  Scenario Outline: To verify All inputs are identified by RMS and output screen is displayed
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
    Then Verify system identified fields on the output screen

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify that User can add upto max 4 columns
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
    Then Click on Menu option for "Column"
    And Click "Insert Column On Right" on output screen
    Then Click on Menu option for "Column"
    And Click "Insert Column On Right" on output screen
    Then Click on Menu option for "Column"
    Then Verify "Insert Column On Right" not displayed on output screen

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify that Minimum number of columns has to be 1
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
    Then Click on Menu option for "Column"
    And Click "Delete Column" on output screen
    Then Click on Menu option for "Column"
    Then Verify "Delete Column" not displayed on output screen

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify that Minimum number of rows has to be 1
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
    And delete all rows from output screen
    Then Click on Menu option for "Row"
    Then Verify "Delete Row" not displayed on output screen

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify Add row functionality
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
    And Click on Menu option for "Row"
    And Click "Insert Row Below" on output screen
    Then Verify row added on output screen

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify the options available in Menu option for inside cells
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
    Then verify the options in the menu option for inside cell
      | Insert Tag                  |
      | Insert From Reference Table |
      | Insert Recruiter Input      |
      | Add Footnote                |

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify applying formatting options to a cell
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
    And click "Bold" in Menu option
    Then verify "Bold" has been applied to the cell
    And click "Italics" in Menu option
    Then verify "Italics" has been applied to the cell
    And click "Underline" in Menu option
    Then verify "Underline" has been applied to the cell
    And click "Left align" in Menu option
    Then verify "Left align" has been applied to the cell
    And click "Center align" in Menu option
    Then verify "Center align" has been applied to the cell
    And click "Right align" in Menu option
    Then verify "Right align" has been applied to the cell
    And click "Font color" in Menu option
    Then verify "Font color" has been applied to the cell

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify functionality of "Insert Tag" in Menu Option
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
    And Click "Insert Tag" on output screen
    Then verify available tags in Insert Tag Menu option
      | Job Location (Country)  |
      | Job Location (City)     |
      | Work Experience         |
      | Job Title / Designation |
      | Reference Code          |
      | Requirement Company     |
      | Group Name              |
      | Candidate Name          |
      | Candidate Email         |
      | Candidate Mobile        |
      | Date of Birth           |
      | Candidate City					|
      | Offer Date              |
      | Joining Date            |
      | Offered Salary          |
      | Offered Designation     |
    And Click "Job Location (Country)" on output screen
    Then verify "[Job Location (Country)]" tag inserted in the first inside cell

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify functionality of "Insert From Reference Table" in Menu Option
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
    And Click "Insert From Reference Table" on output screen
    And Click "Label2-Sheet1:B3" on output screen
    Then verify "[Sheet1:B3]" tag inserted in the first inside cell

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify functionality of "Insert Recruiter Input" in Menu Option
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
    And Click "Insert Recruiter Input" on output screen
    And Click "Label4" in Menu Option on output screen
    Then verify "[Input:Label4]" tag inserted in the first inside cell

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify functionality of "Add Footnote" in Menu Option
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
    Then verify footnote has been added
      | *                                |
      | This is a sample footnote text 1 |
      | This is a sample footnote text 2 |
      | This is a sample footnote text 3 |

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify functionality of Edit Footnote in Menu Option
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
    And Click on Menu option for "Inside Cell"
    And Click "Edit" on output screen
    Then "Add Footnote" layer opens on output screen
    And add Footnote Symbol "$" on the layer
    And add Footnote Text on the layer
      | This is a sample footnote text 4 |
      | This is a sample footnote text 5 |
      | This is a sample footnote text 6 |
    And click "Add Footnote" button
    Then verify footnote has been added
      | $                                |
      | This is a sample footnote text 4 |
      | This is a sample footnote text 5 |
      | This is a sample footnote text 6 |

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify functionality of Remove Footnote in Menu Option
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
    Then verify footnote has been added
      | *                                |
      | This is a sample footnote text 1 |
      | This is a sample footnote text 2 |
      | This is a sample footnote text 3 |
    And Click on Menu option for "Inside Cell"
    And Click "Remove" on output screen
    Then verify footnote has been removed

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify functionality of "Clear" in Menu Option
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
    And Click "Clear" on output screen
    Then verify contents of the first cell are cleared

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify error message is displayed when "CTC" is not selected
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
    And click on next button on footer salary breakups page
    Then verify "This field is mandatory" error message is displayed for CTC field

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  Scenario Outline: To verify selecting "CTC" field
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

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @checkTC
  Scenario Outline: To verify error message is displayed if any input field selected as "CTC" is changed and user directs on output page
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
    And select "Fill Into spreadsheet" as Input source
    And scroll down to cancel button for Input source
    And select "Sheet1" and "C22" as input
    And click "Save" on input screen
    When click on next button on footer salary breakups page
    Then verify Define Salary Breakup is displayed
    And select "Sheet1:C22" in CTC dropdown
    And click "Back" button
    And click "Label5" on input screen
    And select "Fill Into spreadsheet" as Input source
    And select "Sheet1" and "B21" as input
    And scroll down to cancel button for Input source
    And click "Save" on input screen
    And click on next button on footer salary breakups page
    Then verify warning message "CTC Cell Reference was modified, please select a new cell reference."

    Examples: 
      | userType             |
      | Enterprise.Super_user |
	#Not Automatable
  #Scenario Outline: To verify drag and drop functionality of rows
