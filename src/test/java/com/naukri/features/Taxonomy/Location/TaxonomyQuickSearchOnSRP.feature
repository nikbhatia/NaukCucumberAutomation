Feature: Location taxonomy changes in Quick Search on SRP - Expand option

  Scenario: Verify that if no character is typed, but the text area is clicked then the list of individual metro cities, regions and states are displayed as checkboxes
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And User clicks "Expand" option for "All Profiles"
    And User clicks on "Current Location" drop down
    Then User sees following options in "Current Location" dropdown
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
    Then User sees all states in "Current Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities > 7, no. of states >= 3
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And User clicks "Expand" option for "All Profiles"
    And User enters "d" in "Current Location" field
    Then User sees 7 cities, 3 states and 0 countries in "Current Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities > 7, no. of states < 3 Eg : 2
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And User clicks "Expand" option for "All Profiles"
    And User enters "d" in "Current Location" field
    Then User sees 8 cities, 2 states and 0 countries in "Current Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities < 7 Eg: 6, no. of states >= 3 Eg: 5
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And User clicks "Expand" option for "All Profiles"
    And User enters "d" in "Current Location" field
    Then User sees 6 cities, 4 states and 0 countries in "Current Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states < 10, no. of cities > 0 Eg: 3, no. of states > 0 Eg: 4 , no. of countries Eg: 4
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And User clicks "Expand" option for "All Profiles"
    And User enters "d" in "Current Location" field
    Then User sees 3 cities, 4 states and 4 countries in "Current Location" dropdown

  Scenario: Verify that each city/state/custom group selection is displayed as checked
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And User clicks "Expand" option for "All Profiles"
    When User enters "Ajmer" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" value checked for the location dropdown
    When User enters "Haryana" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" value checked for the location dropdown
    When User enters "Anywhere in North India" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" value checked for the location dropdown
    And User clicks "Find Resumes" button
    Then User sees locations in "Current Location" label on SRP page
    Then User sees profiles with locations entered

  Scenario: Verify that all selected locations are shown as count on the placeholder text
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And User clicks "Expand" option for "All Profiles"
    When User enters "Ajmer" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" value checked for the location dropdown
    When User enters "Haryana" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" value checked for the location dropdown
    When User enters "Anywhere in North India" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" value checked for the location dropdown
    Then User sees placeholder text "Selected Locations(3)"

  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And User clicks "Expand" option for "All Profiles"
    When User checks 1 option from "Current Location" dropdown
    Then User sees selected city is shown checked in the dropdown

  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And User clicks "Expand" option for "All Profiles"
    When User enters "Ajmer" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" value checked for the location dropdown
    And User clicks outside the Job Location dropdown
    When User enters "Ajmer" in "Current Location" field
    When User unchecks "Ajmer" option from dropdown
    Then User sees "Ajmer" removed as checked value

  Scenario: Verify that profiles having locations matching search are displayed when quick search is done using Expand location dropdown
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    And User clicks "Expand" option for "All Profiles"
    When User enters "Ajmer" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" value checked for the location dropdown
    When User enters "Haryana" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" value checked for the location dropdown
    When User enters "Anywhere in North India" in "Current Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" value checked for the location dropdown
    Then User sees placeholder text "Selected Locations(3)"
    And User clicks "Search" button
    Then User sees new profiles with new location data
    Then User sees old profiles with legacy location data

  #To be verified after data has been ported
  Scenario: Verify that user is able to search profiles with legacy location data
