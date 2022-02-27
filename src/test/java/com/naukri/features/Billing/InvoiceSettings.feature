 @RMS @billingregression
Feature: Invoice Settings Scenarios
  I want to use this template for my invoice settings feature file

  @id:1  @billing @Settings @smoke
  Scenario: Verify Invoice no. prefix tab
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Invoice Settings" link
    Then Verify Invoice Settings page opens with all tabs
      | Registered Address & Bank Details |
      | Define Services                   |
      | Invoice No. prefix                |
      | Proforma No. prefix               |
      | Credit Note No. prefix            |
      | Define Invoice layout             |
    And Verify sub headings of tabs present on Invoice Settings page
      | Addresses of your registered offices, so that proper GST can be applied     |
      | Define HSN Codes for different services                                     |
      | Define prefix, starting number for your invoices.                           |
      | Define prefix, starting number for your Proforma Invoices.                  |
      | Define prefix, starting number for your Credit Notes.                       |
      | Add footer, upload letterhead and signature which would appear on invoices. |
    When user click on "Invoice No. prefix" tab
    And user click on "Create new prefix series" button
    Then verify Page having "invoice-prefix" textbox open
    When user click on "Proforma No. prefix" tab
    And user click on "Create new prefix series" button
    Then verify Page having "proforma-prefix" textbox open
    When user click on "Credit Note No. prefix" tab
    And user click on "Create new prefix series" button
    Then verify Page having "credit-note-prefix" textbox open

  @id:2  @billing @RMS2-2783 @RMS2-2869
  Scenario: verify Invoice no. with prefix
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Invoice Settings" link
    And user click on "Invoice No. prefix" tab
    And user click on "Create new prefix series" button
    And user fill prefix text field for "Invoice"
    And user fill only start from field
    And user click on "Save Prefix" button
    And user click on "Proforma No. prefix" tab
    And user click on "Create new prefix series" button
    And user fill prefix text field for "Proforma"
    And user fill only start from field
    And user click on "Save Prefix" button
    And user click on "Credit Note No. prefix" tab
    And user click on "Create new prefix series" button
    And user fill prefix text field for "Credit"
    And user fill only start from field
    And user click on "Save Prefix" button
    And user click on "Save" button on footer
    And user click on "Invoice Settings" link
    And user click on "Invoice No. prefix" tab
    Then saved invoice name should be same as entered "Invoice"
    When user click on "Proforma No. prefix" tab
    Then saved invoice name should be same as entered "Proforma"
    When user click on "Credit Note No. prefix" tab
    Then saved invoice name should be same as entered "Credit"

  @id:3  @billing
  Scenario: Verify Invoice no. without prefix
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Invoice Settings" link
    And user click on "Invoice No. prefix" tab
    And user click on "Create new prefix series" button
    And user fill only start from field
    And user click on "Proforma No. prefix" tab
    And user click on "Create new prefix series" button
    And user fill only start from field
    When user click on "Credit Note No. prefix" tab
    And user click on "Create new prefix series" button
    And user fill only start from field
    And user click on "Save" button on footer
    And user click on "Invoice Settings" link
    And user click on "Invoice No. prefix" tab
    Then saved index number should be displayed "No invoices"
    When user click on "Proforma No. prefix" tab
    Then saved index number should be displayed "No proforma invoices"
    When user click on "Credit Note No. prefix" tab
    Then saved index number should be displayed "No credit notes"

  @id:4  @billing
  Scenario: Verify validation message for last generate index invoice
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Invoice Settings" link
    And user click on "Invoice No. prefix" tab
    And user click on "Create new prefix series" button
    And user fill only start from field with null string
    Then validation message for start index
    When user click on "Proforma No. prefix" tab
    And user click on "Create new prefix series" button
    And user fill only start from field with null string
    Then validation message for start index
    When user click on "Credit Note No. prefix" tab
    And user click on "Create new prefix series" button
    And user fill only start from field with null string
    Then validation message for start index

  @id:5  @billing
  Scenario: Verify Register Addresses with GSTIN code successfully add with validations
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Invoice Settings" link
    And user click on "Registered Address & Bank Details" tab
    And user click on "Add more" button
    And user click Address field and then click anywhere for textbox validation message
    Then verify validation message "This filed can not be empty." for "Address" should appear
    When user click GSTIN field and then click anywhere for textbox validation message
    Then verify validation message "This field can not be empty." for "GSTIN Code" should appear
    When user enter GSTIN "1234567890123456" code
    Then verify validation message "Invalid GSTIN code." for "GSTIN Code" should appear
    When user enter GSTIN "993456789012345" code
    Then verify validation message "Invalid GSTIN code." for "GSTIN Code" should appear
    When user enter GSTIN "12ppppp1111c1z1" code
    Then verify validation message "Registered in" for "GSTIN Code" should appear

  @id:6  @billing @RMS2-2706
  Scenario: Verify Register Addresses with GSTIN code successfully add
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Invoice Settings" link
    And user click on "Registered Address & Bank Details" tab
    And user click on "Add more" button
    And user Fill "EmployerAddress" character in address field
    And user enter GSTIN "12ppppp1111c1z1" code
    And user click on "Add" button
    Then Added Employer Registered Address should be displayed in the list
    And Added Employer GSTIN Code should be displayed in the list
    And Added Employer PAN No. should be displayed in the list

  @id:7  @billing @RMS2-2706
  Scenario: Verify Register Addresses without GSTIN code successfully add
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Invoice Settings" link
    And user click on "Registered Address & Bank Details" tab
    And user click on "Add more" button
    And user Fill "EmployerAddress" character in address field
    And user click on "GST Unregistered" radio button
    And user click on "Add" button
    Then Added Employer Registered Address should be displayed in the list

  @id:8  @billing
  Scenario: Verify Change Signature Link
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Invoice Settings" link
    And user click on "Define Invoice layout " tab
    When user click on remove icon with change signature link
#    Then Change signature link should work and user should be able to upload signature
#    And user click on "Save" button on footer
#    Then Invoice settings should be saved with updated layout
