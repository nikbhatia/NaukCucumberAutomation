@RMS
Feature: Scenarios for Bank Detail in Invoive Setting for Consultant

  @id:1 @billing @Settings
  Scenario: Verify Bank Details are visible when clicked
    Given "Consultant" user is on Settings Page with "Superuser"
    When user click on "Invoice Settings" link
    And user click on "Add more" button
    And user click on "Add Bank details" other than button,link
    Then All bank details fields should be visible
    And Add button is disabled

  @id:2 @billing
  Scenario Outline: Verify Bank Details fields validation
    Given "Consultant" user is on Settings Page with "Superuser"
    When user click on "Invoice Settings" link
    And user remove all added addresses
    And user click on "Add more" button
    And user click on "Add Bank details" other than button,link
    And user fill name as <name> and account as <account> and ifsc as <ifsc>
    Then user should get validation error under "Account Holder's name " as <nameValidation>
    And user should get validation error under "Account Number " as <accountValidation>
    And user should get validation error under "IFSC Code " as <ifscValidation>
    And Add button is disabled

    Examples:
      | name | account              | ifsc            | nameValidation                 | accountValidation              | ifscValidation                 |
      | "1"  | "alpha"              | "beta"          | "Invalid Account Holder Name." | "Invalid Account Number."      | "Invalid IFSC Code."           |
      | " "  | " "                  | " "             | "This field can not be empty." | "This field can not be empty." | "This field can not be empty." |
      | "**" | "a*^&*(*&^987656789" | "vbnbmvnbcvgjh" | "Invalid Account Holder Name." | "Invalid Account Number."      | "Invalid IFSC Code."           |

  @id:3 @billing
  Scenario: Verify Bank Details are added/updated/removed successfully
    Given "Consultant" user is on Settings Page with "Superuser"
    When user click on "Invoice Settings" link
    And user remove all added addresses
    Then Verify save button is disabled to save the invoice settings
    When user click on "Add more" button
    And user click on "Add Bank details" other than button,link
    And user add all bank details
    And user click on Employer Address Add button on layout
    And user click on save invoice settings button
    And user click on "Invoice Settings" link
    Then Saved Address should be displayed
    When user click to edit the address
    Then All details should be visible with bank details
    And Options to Change and Remove should be visible
    When user click on change bank details
    And user click choose from existing
    Then Added bank details should be visible in the dropdown
    When user select the added bank detail
    Then All details should be visible with bank details
    When user click on Add new bank details
    When user update all bank details
    And user click on Employer Address Add button on layout
    And user click on save invoice settings button
    And user click on "Invoice Settings" link
    Then Saved Address should be displayed
    When user click to edit the address
    Then All details should be visible with updated bank details
    And Options to Change and Remove should be visible
    When user click on remove bank details
    And user click on Employer Address Add button on layout
    And user click on save invoice settings button
    And user click on "Invoice Settings" link
    Then Saved Address should be displayed
    When user click to edit the address
    Then Bank details should not be visible