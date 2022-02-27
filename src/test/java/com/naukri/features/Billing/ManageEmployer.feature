@RMS @billingregression
Feature: Employer Address and Billing Details Scenarios

  @id:1 @billing @smoke
  Scenario: Login to RMS application with consultant account and verify all Details in Add employer
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Employer " link
    And user click on "Add Employer" link
    Then Verify add employer page opens with all tabs
      | Employer Details |
      | Employer Address |
      | Recruiters       |
      | Employer Contact |
      | Billing Details  |
    And Verify sub headings of tabs present on Add Employer Page
      | Provide name and description of the employer                                            |
      | Fill billing address of the employer                                                    |
      | Select members who will be a part of this employer team                                 |
      | Add POCs for the requirements to be tracked for this employer                           |
      | You can define multiple Billing categories here as per your agreement with the Employer |
    When user fill mandatory fields of Employer Details and Recruiters on Add new employer page
    And user fill mandatory fields of Employer Address "Addressqwertyuiop" as Address and "12ppppp1111c1z1" as GSTIN on Add new employer page
    And user fill mandatory fields of Billing Details "Categoryasdfghjkl" as Category Name and "67890" as flatfee on Add new employer page
    And user click on "SAVE" button
    Then Added employer should be displayed
    And Success ribbon as "Employer Added" should be displayed
    When user click on "Edit" option of Added Employer
    And user click on Employer Address tab
    Then Added Employer Registered Address should be displayed in the list
    And Added Employer GSTIN Code should be displayed in the list
    And Added Employer PAN No. should be displayed in the list
    When user click on "Add More" button
    And user enter 15 character length in address field
    And user click on "GST Unregistered" radio button
    And user click on "ADD" button
    Then Added Employer as Not Registered should be displayed in the list
    When user click on Billing Details tab
    Then Added Employer billing category as "Categoryasdfghjkl" should be displayed in the list
    And Added Employer billing charge as "67890" should be displayed in the list
    And Saved Billing Details should not be duplicated with "Categoryasdfghjkl" Category Name
    When user click on "SAVE" button
    Then Added employer should be displayed
    And Success ribbon as "Employer details edited" should be displayed
    When user click on "Edit" option of Added Employer
    And user click on Employer Address tab
    Then Added Employer as Not Registered should be displayed in the list
    When user click on "SAVE" button
    When user click on "Delete" option of Added Employer
    And user click on Element with Id as "deleteButton" on the Confirmation Pop Up
    Then Success ribbon as "Employer Deleted." should be displayed

  @id:2 @billing
  Scenario: Verify Validation messages of Employer Address
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Employer " link
    And user click on "Add Employer" link
    And user click on "Employer Address" tab
    And user click on "Add Address" value
    And user click Address field and then click anywhere for textbox validation message
    Then verify validation message "This field is mandatory" for "Address" should appear
    When user click GSTIN field and then click anywhere for textbox validation message
    Then verify validation message "This field is mandatory" for "GSTIN Code" should appear
    When user enter 201 character length in address field
    Then verify validation message "Characters in input field must be less than 200" for "Address" should appear
    When user Fill "=" character in address field
    Then verify validation message "Special characters other than . # @ - , $ & /  are not allowed." for "Address:" should appear
    When user enter GSTIN "1234567890123456" code
    Then verify validation message "GSTIN Invalid" for "GSTIN Code" should appear
    When user enter GSTIN "993456789012345" code
    Then verify validation message "GSTIN Invalid" for "GSTIN Code" should appear
    When user enter GSTIN "12ppppp1111c1z1" code
    Then verify validation message "Registered in" for "GSTIN Code" should appear
    When user enter 15 character length in address field
    And user click on "ADD" button
    Then Added Employer Registered Address should be displayed in the list
    And Added Employer GSTIN Code should be displayed in the list
    And Added Employer PAN No. should be displayed in the list
    And Edit and delete button should be displayed on mousehover on saved details

  @id:3 @billing
  Scenario: Verify Employer Company is Tax Exempted
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Employer " link
    And user click on "Add Employer" link
    And user click on "Employer Address" tab
    And user click on "Add Address" value
    When user enter 15 character length in address field
    When user enter GSTIN "12ppppp1111c1z1" code
    Then verify validation message "Registered in" for "GSTIN Code" should appear
    When user click on "Company is tax exempt" checkbox
    And user click on "ADD" button
    Then Added Employer GSTIN Code as Tax Exempt should be displayed in the list

  @id:4 @billing
  Scenario: Verify Employer Company is Not Registered
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Employer " link
    And user click on "Add Employer" link
    And user click on "Employer Address" tab
    And user click on "Add Address" value
    And user enter 15 character length in address field
    And user click on "GST Unregistered" radio button
    And user click on "ADD" button
    Then Added Employer as Not Registered should be displayed in the list

  @id:5 @billing
  Scenario: Verify Added Employer Address - Registered Addresses Options
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Employer " link
    And user click on "Add Employer" link
    And user click on "Employer Address" tab
    And user click on "Add Address" value
    And user Fill "EmployerAddress" character in address field
    And user enter GSTIN "12ppppp1111c1z1" code
    And user click on "ADD" button
    And user click on "edit" icon
    Then Employer Address options should be displayed
    And Added "Address:" as "EmployerAddress" must be present in the "textarea" field
    And Added "GSTIN Code" as "12ppppp1111c1z1" must be present in the "input" field
    When user enter 10 character length in address field
    And user enter GSTIN "19zzzzz1111C1Z1" code
    And user click on "ADD" button
    Then Added Employer Registered Address should be displayed in the list
    And Added Employer GSTIN Code should be displayed in the list
    And Added Employer PAN No. should be displayed in the list
    When user click on "Add More" button
    Then Employer Address options should be displayed
    When user click on "CANCEL" button
    Then Added Employer Registered Address should be displayed in the list
    And Added Employer GSTIN Code should be displayed in the list
    And Added Employer PAN No. should be displayed in the list
    When user click on "cross" icon
    Then Add Address button should be displayed

  @id:6 @billing
  Scenario: Verify Billing details for an employer
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Employer " link
    And user click on "Add Employer" link
    When user click on "Billing Details" tab
    And user click on "ADD" button
    Then Billing options should be displayed
    When user fill all mandatory billing details as "hjdfgzfghj" category name and "768765" as flat fee
    And user click on Add button to Add New Billing Info
    Then Added Employer billing category as "hjdfgzfghj" should be displayed in the list
    And Added Employer billing charge as "768765" should be displayed in the list
    And Edit and delete button should be displayed on mousehover on saved details

  @id:7 @billing
  Scenario: Verify validation messages of Billing details
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Employer " link
    And user click on "Add Employer" link
    When user click on "Billing Details" tab
    And user click on "ADD" button
    And user click on category name field and click on flat fee option
    Then verify validation message "This field is mandatory" for "Category Name" should appear
    When user click on Category Name Textbox
    Then verify validation message "This field is mandatory" for "Flat Fee " should appear
    When user click on Category Name Textbox
    And user fill "$%^&*()" characters in Category Name Textbox
    Then verify validation message "Special characters other than (hyphen underscore dot @) are not allowed" for "Category Name" should appear
    When user fill "199999999" in Flat Fee Textbox
    Then verify validation message "The value should be less than Rs 10 crores." for "Flat Fee " should appear
    When user click on "Fixed Percentage of joining salary" radio button
    And user click on Percentage of Salary Textbox
    And user click on Category Name Textbox
    And user fill "199999999" in Fixed Percentage of joining salary
    Then verify validation message "Enter number between 1 to 100" for "Percentage of Salary" should appear
    When user fill "Category Name - hgfdsfgvb" characters in Category Name Textbox
    And user click on Percentage of Salary Textbox
    And user fill "12" in label "Percentage of Salary " for "input" type TextBox
    And user click on "ADD" button
    Then Added Employer billing category as "Category Name - hgfdsfgvb" should be displayed in the list
    And Added Employer billing charge as "12%" should be displayed in the list
    And Edit and delete button should be displayed on mousehover on saved details

  @id:8 @billing
  Scenario: Verify Added Employer Billing details - Saved Billing Details Options
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Employer " link
    And user click on "Add Employer" link
    When user click on "Billing Details" tab
    And user click on "ADD" button
    And user fill all mandatory billing details as "hjdfgzfghj" category name and "768765" as flat fee
    And user click on "ADD" button
    And user click on "edit" icon
    Then Billing options should be displayed
    And Added "Category Name" as "hjdfgzfghj" must be present in the "input" field
    And Added "Flat Fee " as "768765" must be present in the "input" field
    When user fill all mandatory billing details as "CategoryName" category name and "99999" as flat fee
    And user click on "SAVE" button
    Then Added Employer billing category as "CategoryName" should be displayed in the list
    And Added Employer billing charge as "99999" should be displayed in the list
    When user click on "Add more" link
    Then Billing options should be displayed
    When user click on "CANCEL" button
    And user click on "Add more" link
    And user fill "-1" in label "Payment becomes due after" for "input" type TextBox
    Then verify validation message "Please enter a valid value" for "Payment becomes due after" should appear
    And user fill "365+1" in label "Payment becomes due after" for "input" type TextBox
    Then verify validation message "Please enter a valid value" for "Payment becomes due after" should appear
    When user fill "367" in label "Payment becomes due after" for "input" type TextBox
    Then verify validation message "Enter number between 0 to 365" for "Payment becomes due after" should appear
    When user fill " " in label "Payment becomes due after" for "input" type TextBox
    Then verify validation message "This field is mandatory." for "Payment becomes due after" should appear
    When user fill "-1" in label "Invoice generation becomes due before" for "input" type TextBox
    Then verify validation message "Please enter a valid value" for "Invoice generation becomes due before" should appear
    When user fill "365+1" in label "Invoice generation becomes due before" for "input" type TextBox
    Then verify validation message "Please enter a valid value" for "Invoice generation becomes due before" should appear
    When user fill "367" in label "Invoice generation becomes due before" for "input" type TextBox
    Then verify validation message "Enter number between 0 to 365" for "Invoice generation becomes due before" should appear
    When user fill " " in label "Invoice generation becomes due before" for "input" type TextBox
    Then verify validation message "Please enter a valid value" for "Invoice generation becomes due before" should appear
    When user click on "CANCEL" button
    Then Added Employer billing category as "CategoryName" should be displayed in the list
    And Added Employer billing charge as "99999" should be displayed in the list
    When user click on "cross" icon
    Then Add button should be displayed in Billing details