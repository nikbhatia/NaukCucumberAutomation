Feature: Manage External Sources

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser1"

  @Settings
  Scenario: verify RMS user is able to see all headings and labels on Manage external source listing page
    When user click on "Manage External Sources" link
    Then verify that user is able to see the listed headings on page
      | External Source Name        |
      | Total Assigned Requirements |
      | Created By                  |
      | Last Modified               |

  @Settings
  Scenario: verify RMS user is able to add external sources
    When user click on "Manage External Sources" link
    Then user should be able to see the label "Manage Apply Links for External Sources"
    When user click on "Add New Source" value
    And user fill external source name
    And user click on "ADD" button
    Then verify created external source is visible to user

  @WIP
  Scenario: verify RMS user is able to edit external sources
    When user click on "Manage External Sources" link
    Then user should be able to see the label "Manage Apply Links for External Sources"
    When user click on "Add New Source" value
    And user fill external source name
    And user click on "ADD" button
    Then verify success message "External Source Added successfully"
    When user click on "Edit" option on manage external source listing page
    And user input new external source name
    And user click on "UPDATE" button
    Then verify success message "External Source Updated successfully"

  @WIP
  Scenario: verify RMS user is able to delete external source
    When user click on "Manage External Sources" link
    Then user should be able to see the label "Manage Apply Links for External Sources"
    When user click on "Add New Source" value
    And user fill external source name
    And user click on "ADD" button
    Then verify success message "External Source Added successfully"
    When user click on "Delete" option on manage external source listing page
    Then user click on "NO" button
    When user click on "Delete" option on manage external source listing page
    Then user click on "YES" button

  @Setting
  Scenario: verify RMS user is unable to enter same external source name
    When user click on "Manage External Sources" link
    And user click on "Add New Source" value
    And user fill external source name
    And user click on "ADD" button
    Then verify created external source is visible to user
    When user click on "Add New Source" value
    And user fill same external source name which is already created
    And user click on "ADD" button
    And verify user able to see error message "External Source with this name already exists. Please use a different name."
