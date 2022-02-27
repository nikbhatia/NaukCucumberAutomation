Feature: Location Taxonomy in Add A single profile - Preferred Location

  Scenario: Verify that if nothing is clicked then centrally stored clusters are displayed
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Then User sees following options in "Preferred Location" dropdown
      | Anywhere in India          |
      | Anywhere in North India    |
      | Anywhere in South India    |
      | Anywhere in East India     |
      | Anywhere in West India     |
      | Any International Location |
      | Top Metropolitan Cities    |
      | Ahmedabad                  |
      | Bangalore/Bengaluru        |
      | Chennai                    |
      | Hyderabad/Secunderabad     |
      | Kolkata                    |
      | Pune                       |
      | Delhi / NCR                |
      | Mumbai (All Areas)         |

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    When User enters "a" in "Preferred Location" field
    Then User sees Indian cities as suggestions
    Then User sees at max 10 cities suggestions

  Scenario: Verify that each city selection is displayed as tags
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    When User enters "Noida" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Noida" as tags

  Scenario: Verify that cluster can be selected and is displayed as tag
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Anywhere in India" as tags

  Scenario: Verify that error message is displayed when more than 10 locations are selected
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User clicks on "Job Location" drop down
    And User checks 11 locations
    Then User sees error message "Max 10 locations allowed"

  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User clicks on "Job Location" drop down
    Then User sees "Ajmer" is checked
    When User unchecks "Ajmer" location
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    When User enters "Ajmer" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the location tag
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that user is able to change location
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "Ajmer" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Ajmer" added as tag
    And User clicks cross icon for the tag
    When User enters "Noida" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Noida" added as tag

  Scenario: Verify that correct location is visible on CV details after profile has been created
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    When User enters "Ajmer" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Ajmer" added as tag
    And User clicks "Add Candidate" button
    Then User sees "Ajmer" as "Preferred Location" on CV details page

  Scenario: Verify that correct location is visible on SRP after profile has been created
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    When User enters "Ajmer" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Ajmer" added as tag
    And User clicks "Add Candidate" button
    Then User sees "Ajmer" as "Preferred Location" on CV details page
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User search the candidate
    Then User sees "Ajmer" as "Preferred Location" on CV details page

  Scenario: Verify that Preferred Location can be updated from CV details page after profile has been created
    # Will be verified after edit profile is completed
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    When User enters "Ajmer" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Ajmer" added as tag
    And User clicks "Add Candidate" button
    Then User sees "Ajmer" as "Preferred Location" on CV details page
    When User clicks "Edit" button for "Candidate Details"
    And User enters "Noida" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Noida" added as tag
    And User clicks "editCandBasicButton" button
    Then User sees "Noida" as "Preferred Location" on CV details page
