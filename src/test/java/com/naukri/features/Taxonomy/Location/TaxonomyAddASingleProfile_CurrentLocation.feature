Feature: Location Taxonomy in Add A single profile - Current Location

  @AddSingleProfileCurrentLocation @id:1 @passed
  Scenario: Verify that if no character is typed, but the text area is clicked then only the top metro cities are displayed
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User clicks on "locSuggestor" drop down
    Then User sees "Top Metropolitan Cities" as checkboxes
      | Ahmedabad              |
      | Bangalore/Bengaluru    |
      | Chennai                |
      | Hyderabad/Secunderabad |
      | Kolkata                |
      | Pune                   |
      | New Delhi		           |
      | Gurgaon/Gurugram	     |
      | Noida                  |
      | Mumbai						     |

  @AddSingleProfileCurrentLocation @id:2 @passed
  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "b" in "locSuggestor" field
    Then User sees at max 10 cities suggestions

  @AddSingleProfileCurrentLocation @id:3 @passed
  Scenario: Verify when city is not present in the suggestion
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "x" in "locSuggestor" field
    Then User sees 2 options to add
      | Add as National Location      |
      | Add as International Location |

  @AddSingleProfileCurrentLocation @id:4 @passed
  Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "testing" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    Then User sees "Add Other Location" layer opened with options
      | Other Location |
      | State          |
    Then User sees "testing" entered text in "Other Location" field

  @AddSingleProfileCurrentLocation @id:5 @passed
  Scenario: Verify error messages in "Add Other Location" layer
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "testing" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "testing" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  @AddSingleProfileCurrentLocation @id:6 @passed
  Scenario: Verify user is able to add Other National Location
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "testing" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "testing-Andhra Pradesh" added as location value

  @AddSingleProfileCurrentLocation @id:7 @passed
  Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "testing" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    Then User sees "Add International Location" layer opened with options
      | Other Location |
      | Country        |
    Then User sees "testing" entered text in "Other Location" field

  @AddSingleProfileCurrentLocation @id:8 @passed
  Scenario: Verify error messages in "Add International Location" layer
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "testing" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "testing" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  @AddSingleProfileCurrentLocation @id:9 @passed
  Scenario: Verify user is able to add Other International Location
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "testing" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "testing-Australia" added as location value

  @AddSingleProfileCurrentLocation @id:10 @passed
  Scenario: Verify that each city selection is displayed as text in "locSuggestor" Field
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "Ajmer" in "locSuggestor" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value

  @AddSingleProfileCurrentLocation @id:11 @passed
  Scenario: Verify that preselected city in dropdown is highlighted
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "Noida" in Job Location field for "Candidate"
    And User checks 1 option from the Job Location dropdown
    When User enters "Noida" in Job Location field for "Candidate"
    Then User sees "Noida, Uttar Pradesh" is highlighted and selected

  @AddSingleProfileCurrentLocation @id:12 @passed
  Scenario: Verify the value added if city is not present in global list
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "testing" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "testing-Andhra Pradesh" added as location value
    When User clicks on "locSuggestor" drop down
    And User enters "tester" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "tester-Australia" added as location value

  @AddSingleProfileCurrentLocation @id:13 @passed
  Scenario: Verify that user is able to change location
   Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User enters "Ajmer" in "locSuggestor" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Ajmer" added as location value
    When User clicks on "locSuggestor" drop down
    And User enters "Chandigarh" in "locSuggestor" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Chandigarh" added as location value

  @AddSingleProfileCurrentLocation @id:14 @passed
  Scenario: Verify that correct location is visible on CV details after profile has been created
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    When User enters "Quepem" in "locSuggestor" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Quepem" added as location value
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    Then User sees "Quepem" as "Current Location:" on CV details page

  @AddSingleProfileCurrentLocation @id:15 @passed1
  Scenario: Verify that Current Location can be updated from CV details page after profile has been created
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    When User enters "New Delhi" in Job Location field for "Candidate"
    And User checks the checkbox from the dropdown
    And I click on Add Candidate button
    Then User sees current location as "New Delhi" on CV Deatil page
    When I click on the edit option
    And User enters "Greater Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Greater Noida" text in Job Location Field
    And I click on the save button
    And refresh the page
    And refresh the page
    Then User sees current location as "Greater Noida" on CV Deatil page
