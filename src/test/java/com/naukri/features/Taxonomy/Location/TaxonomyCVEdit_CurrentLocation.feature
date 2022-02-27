Feature: Location Taxonomy changes for CV Edit - Current Location

  Scenario: Verify that old location is displayed as "Current Location" for legacy profiles when user tries to edit current location for any candidate
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    Then User sees old location in "Current Location" field

  Scenario: Verify that new location is displayed as "Current Location" for new profiles when user tries to edit current location for any candidate
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    Then User sees new location in "Current Location" field

  Scenario: Verify that if no character is typed, but the text area is clicked then only the top metro cities are displayed
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User clicks on "Current Location" drop down
    Then User sees "Top Metropolitan Cities" as checkboxes
      | Ahmedabad              |
      | Bangalore/Bengaluru    |
      | Chennai                |
      | Hyderabad/Secunderabad |
      | Kolkata                |
      | Pune                   |
      | New Delhi              |
      | Gurgaon/Gurugram       |
      | Noida                  |
      | Mumbai                 |

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "b" in "Current Location" field
    Then User sees at max 10 cities suggestions

  Scenario: Verify when city is not present in the suggestion
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "x" in "Current Location" field
    Then User sees 2 options to add
      | Add as National Location      |
      | Add as International Location |

  Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "test" in "Current Location" field
    And User clicks "Add as National Location" option for adding not found city
    Then User sees "Add Other Location" layer opened with options
      | Other Location |
      | State          |
    Then User sees "test" entered text in "Other Location" field

  Scenario: Verify error messages in "Add Other Location" layer
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "test" in "Current Location" field
    And User clicks "Add as National Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  Scenario: Verify user is able to add Other National Location
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "test" in "Current Location" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as location value

  Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "test" in "Current Location" field
    And User clicks "Add as International Location" option for adding not found city
    Then User sees "Add International Location" layer opened with options
      | Other Location |
      | Country        |
    Then User sees "test" entered text in "Other Location" field

  Scenario: Verify error messages in "Add International Location" layer
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "test" in "Current Location" field
    And User clicks "Add as International Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  Scenario: Verify user is able to add Other International Location
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "test" in "Current Location" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as location value

  Scenario: Verify that each city selection is displayed as text in "Current Location" Field
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "Ajmer" in "Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value

  Scenario: Verify that preselected city in dropdown is highlighted and tick is displayed along the selected location
    # not in add a single profile
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User selects 1 option from dropdown in "Top Metropolitan Cities"
    Then User sees selected city is highlighted and tick mark is displayed beside the option in dropdown

  Scenario: Verify the value added if city is not present in global list
    #Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "test" in "Current Location" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as location value
    When User clicks on "Current Location" drop down
    And User enters "test" in "Current Location" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as location value

  Scenario: Verify that user is able to enter Indian City as "Current Location"
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "Ajmer" in "Current Location" field
    And User selects 1 option from the "Current Location" dropdown
    Then User sees "Ajmer" text in "Current Location" Field
    When User enters "Ajmer" in "Current Location" field
    Then User sees the selected value is highlighted in dropdown

  Scenario: Verify that user is able to change location
    #Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "Ajmer" in "Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value
    When User clicks on "Current Location" drop down
    And User enters "Chandigarh" in "Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Chandigarh" added as location value

  Scenario: Verify that correct location is visible on CV details after location has been updated
    #Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "Ajmer" in "Current Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value
    And User clicks "Save" button
    Then User sees "Ajmer" as "Current Location:" on CV details page

  Scenario: Verify that user is able to add "National Location" as "Current Location"
    #Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "test" in "Current Location" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as location value
    And User clicks "Save" button
    Then User sees "test-Andhra Pradesh" as "Current Location:" on CV details page

  Scenario: Verify that user is able to add "International Location" as "Current Location"
    #Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    And User enters "test" in "Current Location" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as location value
    And User clicks "Save" button
    Then User sees "test-Australia" as "Current Location:" on CV details page

  Scenario: Verify that correct location is visible on SRP after profile has been created
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "All Profiles Including Uploads" under "Profiles"
    And User clicks 1 profile on "All Profiles"
    And User clicks "Edit Candidate Details" on CV details
    When User enters "Ajmer" in "Current Location" field
    And User checks 1 option from the "Current Location" dropdown
    Then User sees "Ajmer" added as tag
    And User clicks "Save" button
    Then User sees "Ajmer" as "Current Location" on CV details page
    And User navigate through GNB to "All Profiles (Including Uploads)" under "Profiles"
    And User search the candidate
    Then User sees "Ajmer" as "Current Location" on SRP page
