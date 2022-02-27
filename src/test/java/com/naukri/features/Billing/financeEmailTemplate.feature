@RMS @billingregression
Feature: Financial Email Template Scenarios

  @id:1 @Settings @billing @smoke
  Scenario: Login to RMS application with consultant account and verify finance template
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Financial"
    And user should be able to see the label "Create a financial mail template"
    And user fill mandatory fields for financial template
    And user save financial template
    Then verify created financial template is visible to user

  @id:2 @Settings @billing
  Scenario: Verify duplicate template validation message
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Financial"
    And user should be able to see the label "Create a financial mail template"
    And user fill mandatory fields for financial template with the same template name
    And user save financial template
    Then validate duplicate template validation message

  @id:3 @Settings @billing
  Scenario: Verify preview mail template
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Financial"
    And user should be able to see the label "Create a financial mail template"
    And user fill mandatory fields for financial template
    And user click on "Preview" button
    Then user is able to view preview of mail template

  @id:4 @Settings @billing
  Scenario: Verify Share mail template
   	Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Financial"
    And user should be able to see the label "Create a financial mail template"
    And user fill mandatory fields for financial template
    And user share financial template
    And user save financial template
    Then validate template should be shared

  @id:5 @Settings @billing
  Scenario: Verify category list in mail template
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Financial"
    And user should be able to see the label "Create a financial mail template"
    Then validate all options in the category list

  @id:6 @billing 
  Scenario: Verify category list in mail template data
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Financial"
    And user should be able to see the label "Create a financial mail template"
    And user click on category list button
    Then validate all category options template data
