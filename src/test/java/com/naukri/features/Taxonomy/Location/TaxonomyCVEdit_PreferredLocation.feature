Feature: Location Taxonomy changes for CV Edit - Preferred Location

Scenario: Verify that old locations / clusters are displayed in "Preferred Location" for legacy profiles when user tries to edit preferred location for any candidate
		Given I login into RMS as an "Enterprise" user
And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
Then User sees old location in "Preferred Location" field

Scenario: Verify that new locations / clusters are displayed in "Preferred Location" for new profiles when user tries to edit preferred location for any candidate
Given I login into RMS as an "Enterprise" user
And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
Then User sees new location in "Current Location" field

Scenario: Verify that if nothing is clicked then centrally stored clusters are displayed
    Given I login into RMS as an "Enterprise" user
And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
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
    Given I login into RMS as an "Enterprise" user
And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
    When User enters "a" in "Preferred Location" field
    Then User sees Indian cities as suggestions
    Then User sees at max 10 cities suggestions

  Scenario: Verify that each city selection is displayed as tags
    Given I login into RMS as an "Enterprise" user
And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
    When User enters "Noida" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Noida" as tags

  Scenario: Verify that cluster can be selected and is displayed as tag
    Given I login into RMS as an "Enterprise" user
And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Anywhere in India" as tags

  Scenario: Verify that error message is displayed when more than 10 locations are selected
    Given I login into RMS as an "Enterprise" user
And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
    When User clicks on "Job Location" drop down
    And User checks 11 locations
    Then User sees error message "Max 10 locations allowed"

  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given I login into RMS as an "Enterprise" user
And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User clicks on "Job Location" drop down
    Then User sees "Ajmer" is checked
    When User unchecks "Ajmer" location
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
    Given I login into RMS as an "Enterprise" user
And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
    When User enters "Ajmer" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the location tag
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that user is able to change location
    Given I login into RMS as an "Enterprise" user
And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
    When User enters "Ajmer" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Ajmer" added as tag
    And User clicks cross icon for the tag
    When User enters "Noida" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Noida" added as tag

  Scenario: Verify that correct location is visible on CV details after profile has been updated
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
    When User enters "Ajmer" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Ajmer" added as tag
    When User enters "Anywhere in India" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Anywhere in India" added as tag
    When User enters "Any International Location" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Any International Location" added as tag
    And User clicks "Save" button
    Then User sees "Ajmer" as "Preferred Location" on CV details page
    Then User sees "Anywhere in India" as "Preferred Location" on CV details page
    Then User sees "Any International Location" as "Preferred Location" on CV details page

  Scenario: Verify that correct location is visible on SRP after profile has been created
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
And User clicks 1 profile on "All Profiles"
And User clicks "Edit Candidate Details" on CV details
    When User enters "Ajmer" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Ajmer" added as tag
    When User enters "Anywhere in India" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Anywhere in India" added as tag
    When User enters "Any International Location" in "Preferred Location" field
    And User checks 1 option from the "Preferred Location" dropdown
    Then User sees "Any International Location" added as tag
    And User clicks "Save" button
    Then User sees "Ajmer" as "Preferred Location" on CV details page
    Then User sees "Anywhere in India" as "Preferred Location" on CV details page
    Then User sees "Any International Location" as "Preferred Location" on CV details page
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User search the candidate
    Then User sees "Ajmer" as "Preferred Location" on SRP Page
    Then User sees "Anywhere in India" as "Preferred Location" on SRP Page
    Then User sees "Any International Location" as "Preferred Location" on SRP Page

