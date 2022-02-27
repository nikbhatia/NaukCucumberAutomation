Feature: Location Taxonomy in Search - Preferred Location

  # Master Profile
  Scenario: Verify that un-checking the checkbox for "Preferred Location" , preferred location conmponent is not displayed
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User unchecks "Preferred Location" checkbox
    Then User does not see "Preferred Location" component

  Scenario: Verify that checking the checkbox for "Preferred Location" , "Either Current OR/AND Preferred Location will be searched" toggle button is displayed
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User checks "Preferred Location" checkbox
    Then User sees "Preferred Location" component
    Then User sees "Either Current OR/AND Preferred Location will be searched" toggle button

  Scenario: Verify that if no character is typed, but the text area is clicked then the list of individual metro cities, regions and states are displayed as checkboxes
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User clicks on "Preferred Location" drop down
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
    Then User sees all states in "Preferred Location" dropdown

  Scenario: Verify the functionality of "Recently Searched" when "cities" were selected in previous searches
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    Then User sees "cities" in "Recently Searched" for "Preferred Location"

  Scenario: Verify the functionality of "Recently Searched" when "states" were selected in previous searches
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    Then User sees "states" in "Recently Searched" for "Preferred Location"

  Scenario: Verify the functionality of "Recently Searched" when "Custom Groups" were selected in previous searches Eg: Anywhere in India, Any International location
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    Then User sees "Custom Groups" in "Recently Searched" for "Preferred Location"

  Scenario: Verify that click on any option in "Recently Searched" adds to the "Preferred Location" dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User clicks 1 option in "Recently Searched" for "Preferred Location"
    Then User sees option clicked on "Recently Searched" added to "Preferred Location" dropdown

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

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities > 7, no. of states >= 3
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User enters "d" in "Preferred Location" field
    Then User sees 7 cities, 3 states and 0 countries in "Preferred Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities > 7, no. of states < 3 Eg : 2
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User enters "d" in "Preferred Location" field
    Then User sees 8 cities, 2 states and 0 countries in "Preferred Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities < 7 Eg: 6, no. of states >= 3 Eg: 5
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User enters "d" in "Preferred Location" field
    Then User sees 6 cities, 4 states and 0 countries in "Preferred Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states < 10, no. of cities > 0 Eg: 3, no. of states > 0 Eg: 4 , no. of countries Eg: 4
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User enters "d" in "Preferred Location" field
    Then User sees 3 cities, 4 states and 4 countries in "Preferred Location" dropdown

  Scenario: Verify that each city/state/custom group selection is displayed as tags
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that all selected locations gets cleared on clicking "Clear All" button
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Clear All" Button
    Then User sees no tags added to "Preferred Location"

  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User checks 1 option from "Preferred Location" dropdown
    Then User sees selected city is shown checked in the dropdown

  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks outside the Job Location dropdown
    When User enters "Ajmer" in "Preferred Location" field
    When User unchecks "Ajmer" option from dropdown
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that if the city is not present in suggestion, pressing a Comma will make the text typed so far into a tag and a text search will be run on the same
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User enters "test," in "Preferred Location" field
    Then User sees "test" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    Then User sees profiles from open text input in the "others" field in legacy data

  Scenario: Verify that nearby cities are displayed for Selected cities
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Chandigarh" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Chandigarh"
    Then User sees Nearby Cities to "Ajmer"
    Then User sees 50 km as default distance

  Scenario: Verify that user is able to change options in distance dropdown in nearby cities
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"
    Then User sees options in distance dropdown
      |  50 |
      | 100 |
      | 150 |
      | 200 |
      | 250 |
      | 300 |
      | 400 |
      | 500 |

  Scenario: Verify that changing the distance in nearby cities updates the city list
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"
    And User selects 200 km in distance dropdown
    Then User ses cities updated as per distance selected

  Scenario: Verify that cities from nearby cities are added as tag to "Preferred Location" dropdown on clicking
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"

  Scenario: Verify the functionality of "Include All" button on Nearby cities
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"
    And User clicks "Include All" button
    Then User sees all nearby cities added as tag to "Preferred Location" dropdowns

  Scenario: Verify that on clicking any city in nearby cities, creates another cluster for the selected city and it gets removed from the suggestions
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Delhi" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Delhi" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Delhi"
    And User selects 1 option from Nearby Cities suggestions
    Then User sees another cluster in Nearby Cities for the city added

  Scenario: Verify the functionality of "?" icon on nearby cities
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Delhi" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Delhi" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Delhi"
    And User hovers over question mark icon
    Then User sees additional information text in tooltip

  Scenario: Verify that locations entered are visible in Recent Searches column
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Advanced Search" for "Master Profile"
    Then User sees locations in "Preferred Location" label in "Recent Searches" column

  Scenario: Verify that locations entered are visible in Saved Searches column
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Save Search" link
    And User enters search name
    And User clicks "Advanced Search" for "Master Profile"
    Then User sees locations in "Preferred Location" label in "Saved Searches" column

  Scenario: Verify that toggling OFF the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Same as Above"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Same as Above"
    And User toggles "OFF" the "Either Current OR/AND Preferred Location will be searched" toggle button
    And User clicks "Find Resumes" button
    Then User sees profiles with "Current Location" entered
    Then User sees profiles with "Preferred Location" entered similar to "Preferred Location"

  Scenario: Verify that toggling OFF the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Mentioned Below"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Mentioned Below"
    And User toggles "OFF" the "Either Current OR/AND Preferred Location will be searched" toggle button
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Current Location" entered
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that toggling ON the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Same as Above"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Mentioned Below"
    And User clicks "Find Resumes" button
    Then User sees profiles with same "Current Location" and "Preferred Location" entered

  Scenario: Verify that toggling ON the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Mentioned Below"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Mentioned Below"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Current Location" entered and "Preferred Location" entered

  Scenario: Verify user is able to change locations by clicking "Modify Search" on SRP
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Modify Search" link
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks cross icon for the tag
    And User clicks outside the Job Location dropdown
    When User enters "Chandigarh" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that user is able to edit locations in new saved searches
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Save Search" link
    And User enters search name
    And User clicks "Advanced Search" for "Master Profile"
    And User clicks "edit" option for saved search
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks cross icon for the tag
    And User clicks outside the Job Location dropdown
    When User enters "Chandigarh" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that when user fills from new saved search, all locations are prefilled
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Save Search" link
    And User enters search name
    And User clicks "Advanced Search" for "Master Profile"
    And User clicks "fill" option for saved search
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown

  Scenario: Verify that user fills from old legacy data saved search, all locations are prefilled
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    And User clicks "fill" option for old saved search
    Then User sees locations entered in saved search are added as tag to "Preferred Location" dropdown values

  Scenario: Verify that on clicking "Reset Search" link, all locations added to search gets removed
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Reset Search" link
    Then User sees no tags in "Preferred Location" dropdown

  # All profiles
  Scenario: Verify that un-checking the checkbox for "Preferred Location" , preferred location conmponent is not displayed
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User unchecks "Preferred Location" checkbox
    Then User does not see "Preferred Location" component

  Scenario: Verify that checking the checkbox for "Preferred Location" , "Either Current OR/AND Preferred Location will be searched" toggle button is displayed
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User checks "Preferred Location" checkbox
    Then User sees "Preferred Location" component
    Then User sees "Either Current OR/AND Preferred Location will be searched" toggle button

  Scenario: Verify that if no character is typed, but the text area is clicked then the list of individual metro cities, regions and states are displayed as checkboxes
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User clicks on "Preferred Location" drop down
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
    Then User sees all states in "Preferred Location" dropdown

  Scenario: Verify the functionality of "Recently Searched" when "cities" were selected in previous searches
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    Then User sees "cities" in "Recently Searched" for "Preferred Location"

  Scenario: Verify the functionality of "Recently Searched" when "states" were selected in previous searches
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    Then User sees "states" in "Recently Searched" for "Preferred Location"

  Scenario: Verify the functionality of "Recently Searched" when "Custom Groups" were selected in previous searches Eg: Anywhere in India, Any International location
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    Then User sees "Custom Groups" in "Recently Searched" for "Preferred Location"

  Scenario: Verify that click on any option in "Recently Searched" adds to the "Preferred Location" dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User clicks 1 option in "Recently Searched" for "Preferred Location"
    Then User sees option clicked on "Recently Searched" added to "Preferred Location" dropdown

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

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities > 7, no. of states >= 3
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User enters "d" in "Preferred Location" field
    Then User sees 7 cities, 3 states and 0 countries in "Preferred Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities > 7, no. of states < 3 Eg : 2
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User enters "d" in "Preferred Location" field
    Then User sees 8 cities, 2 states and 0 countries in "Preferred Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities < 7 Eg: 6, no. of states >= 3 Eg: 5
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User enters "d" in "Preferred Location" field
    Then User sees 6 cities, 4 states and 0 countries in "Preferred Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states < 10, no. of cities > 0 Eg: 3, no. of states > 0 Eg: 4 , no. of countries Eg: 4
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User enters "d" in "Preferred Location" field
    Then User sees 3 cities, 4 states and 4 countries in "Preferred Location" dropdown

  Scenario: Verify that each city/state/custom group selection is displayed as tags
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that all selected locations gets cleared on clicking "Clear All" button
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Clear All" Button
    Then User sees no tags added to "Preferred Location"

  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User checks 1 option from "Preferred Location" dropdown
    Then User sees selected city is shown checked in the dropdown

  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks outside the Job Location dropdown
    When User enters "Ajmer" in "Preferred Location" field
    When User unchecks "Ajmer" option from dropdown
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that if the city is not present in suggestion, pressing a Comma will make the text typed so far into a tag and a text search will be run on the same
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User enters "test," in "Preferred Location" field
    Then User sees "test" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    Then User sees profiles from open text input in the "others" field in legacy data

  Scenario: Verify that nearby cities are displayed for Selected cities
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Chandigarh" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Chandigarh"
    Then User sees Nearby Cities to "Ajmer"
    Then User sees 50 km as default distance

  Scenario: Verify that user is able to change options in distance dropdown in nearby cities
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"
    Then User sees options in distance dropdown
      |  50 |
      | 100 |
      | 150 |
      | 200 |
      | 250 |
      | 300 |
      | 400 |
      | 500 |

  Scenario: Verify that changing the distance in nearby cities updates the city list
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"
    And User selects 200 km in distance dropdown
    Then User ses cities updated as per distance selected

  Scenario: Verify that cities from nearby cities are added as tag to "Preferred Location" dropdown on clicking
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"

  Scenario: Verify the functionality of "Include All" button on Nearby cities
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"
    And User clicks "Include All" button
    Then User sees all nearby cities added as tag to "Preferred Location" dropdowns

  Scenario: Verify that on clicking any city in nearby cities, creates another cluster for the selected city and it gets removed from the suggestions
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Delhi" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Delhi" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Delhi"
    And User selects 1 option from Nearby Cities suggestions
    Then User sees another cluster in Nearby Cities for the city added

  Scenario: Verify the functionality of "?" icon on nearby cities
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Delhi" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Delhi" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Delhi"
    And User hovers over question mark icon
    Then User sees additional information text in tooltip

  Scenario: Verify that locations entered are visible in Recent Searches column
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Advanced Search" for "All Profiles"
    Then User sees locations in "Preferred Location" label in "Recent Searches" column

  Scenario: Verify that locations entered are visible in Saved Searches column
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Save Search" link
    And User enters search name
    And User clicks "Advanced Search" for "All Profiles"
    Then User sees locations in "Preferred Location" label in "Saved Searches" column

  Scenario: Verify that toggling OFF the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Same as Above"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Same as Above"
    And User toggles "OFF" the "Either Current OR/AND Preferred Location will be searched" toggle button
    And User clicks "Find Resumes" button
    Then User sees profiles with "Current Location" entered
    Then User sees profiles with "Preferred Location" entered similar to "Preferred Location"

  Scenario: Verify that toggling OFF the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Mentioned Below"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Mentioned Below"
    And User toggles "OFF" the "Either Current OR/AND Preferred Location will be searched" toggle button
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Current Location" entered
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that toggling ON the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Same as Above"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Mentioned Below"
    And User clicks "Find Resumes" button
    Then User sees profiles with same "Current Location" and "Preferred Location" entered

  Scenario: Verify that toggling ON the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Mentioned Below"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Mentioned Below"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Current Location" entered and "Preferred Location" entered

  Scenario: Verify user is able to change locations by clicking "Modify Search" on SRP
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Modify Search" link
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks cross icon for the tag
    And User clicks outside the Job Location dropdown
    When User enters "Chandigarh" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that user is able to edit locations in new saved searches
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Save Search" link
    And User enters search name
    And User clicks "Advanced Search" for "All Profiles"
    And User clicks "edit" option for saved search
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks cross icon for the tag
    And User clicks outside the Job Location dropdown
    When User enters "Chandigarh" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that when user fills from new saved search, all locations are prefilled
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Save Search" link
    And User enters search name
    And User clicks "Advanced Search" for "All Profiles"
    And User clicks "fill" option for saved search
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown

  Scenario: Verify that user fills from old legacy data saved search, all locations are prefilled
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    And User clicks "fill" option for old saved search
    Then User sees locations entered in saved search are added as tag to "Preferred Location" dropdown values

  Scenario: Verify that on clicking "Reset Search" link, all locations added to search gets removed
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Reset Search" link
    Then User sees no tags in "Preferred Location" dropdown

  #Requirement Responses
  Scenario: Verify that un-checking the checkbox for "Preferred Location" , preferred location conmponent is not displayed
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User unchecks "Preferred Location" checkbox
    Then User does not see "Preferred Location" component

  Scenario: Verify that checking the checkbox for "Preferred Location" , "Either Current OR/AND Preferred Location will be searched" toggle button is displayed
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User checks "Preferred Location" checkbox
    Then User sees "Preferred Location" component
    Then User sees "Either Current OR/AND Preferred Location will be searched" toggle button

  Scenario: Verify that if no character is typed, but the text area is clicked then the list of individual metro cities, regions and states are displayed as checkboxes
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User clicks on "Preferred Location" drop down
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
    Then User sees all states in "Preferred Location" dropdown

  Scenario: Verify the functionality of "Recently Searched" when "cities" were selected in previous searches
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    Then User sees "cities" in "Recently Searched" for "Preferred Location"

  Scenario: Verify the functionality of "Recently Searched" when "states" were selected in previous searches
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    Then User sees "states" in "Recently Searched" for "Preferred Location"

  Scenario: Verify the functionality of "Recently Searched" when "Custom Groups" were selected in previous searches Eg: Anywhere in India, Any International location
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    Then User sees "Custom Groups" in "Recently Searched" for "Preferred Location"

  Scenario: Verify that click on any option in "Recently Searched" adds to the "Preferred Location" dropdown
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User clicks 1 option in "Recently Searched" for "Preferred Location"
    Then User sees option clicked on "Recently Searched" added to "Preferred Location" dropdown

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

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities > 7, no. of states >= 3
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User enters "d" in "Preferred Location" field
    Then User sees 7 cities, 3 states and 0 countries in "Preferred Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities > 7, no. of states < 3 Eg : 2
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User enters "d" in "Preferred Location" field
    Then User sees 8 cities, 2 states and 0 countries in "Preferred Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states >=10, no. of cities < 7 Eg: 6, no. of states >= 3 Eg: 5
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User enters "d" in "Preferred Location" field
    Then User sees 6 cities, 4 states and 0 countries in "Preferred Location" dropdown

  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed, when no. of cities + states < 10, no. of cities > 0 Eg: 3, no. of states > 0 Eg: 4 , no. of countries Eg: 4
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User enters "d" in "Preferred Location" field
    Then User sees 3 cities, 4 states and 4 countries in "Preferred Location" dropdown

  Scenario: Verify that each city/state/custom group selection is displayed as tags
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that all selected locations gets cleared on clicking "Clear All" button
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User clicks "Advanced Search" for "Master Profile"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Clear All" Button
    Then User sees no tags added to "Preferred Location"

  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User checks 1 option from "Preferred Location" dropdown
    Then User sees selected city is shown checked in the dropdown

  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks outside the Job Location dropdown
    When User enters "Ajmer" in "Preferred Location" field
    When User unchecks "Ajmer" option from dropdown
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that if the city is not present in suggestion, pressing a Comma will make the text typed so far into a tag and a text search will be run on the same
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User enters "test," in "Preferred Location" field
    Then User sees "test" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    Then User sees profiles from open text input in the "others" field in legacy data

  Scenario: Verify that nearby cities are displayed for Selected cities
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Chandigarh" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Chandigarh"
    Then User sees Nearby Cities to "Ajmer"
    Then User sees 50 km as default distance

  Scenario: Verify that user is able to change options in distance dropdown in nearby cities
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"
    Then User sees options in distance dropdown
      |  50 |
      | 100 |
      | 150 |
      | 200 |
      | 250 |
      | 300 |
      | 400 |
      | 500 |

  Scenario: Verify that changing the distance in nearby cities updates the city list
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"
    And User selects 200 km in distance dropdown
    Then User ses cities updated as per distance selected

  Scenario: Verify that cities from nearby cities are added as tag to "Preferred Location" dropdown on clicking
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"

  Scenario: Verify the functionality of "Include All" button on Nearby cities
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Ajmer"
    And User clicks "Include All" button
    Then User sees all nearby cities added as tag to "Preferred Location" dropdowns

  Scenario: Verify that on clicking any city in nearby cities, creates another cluster for the selected city and it gets removed from the suggestions
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Delhi" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Delhi" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Delhi"
    And User selects 1 option from Nearby Cities suggestions
    Then User sees another cluster in Nearby Cities for the city added

  Scenario: Verify the functionality of "?" icon on nearby cities
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Delhi" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Delhi" added as tag to "Preferred Location" dropdown
    And User clicks "Preferred Location" dropdown
    Then User sees Nearby Cities to "Delhi"
    And User hovers over question mark icon
    Then User sees additional information text in tooltip

  Scenario: Verify that locations entered are visible in Recent Searches column
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Advanced Search" for "All Profiles"
    Then User sees locations in "Preferred Location" label in "Recent Searches" column

  Scenario: Verify that locations entered are visible in Saved Searches column
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Save Search" link
    And User enters search name
    And User clicks "Advanced Search" for "All Profiles"
    Then User sees locations in "Preferred Location" label in "Saved Searches" column

  Scenario: Verify that toggling OFF the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Same as Above"
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Same as Above"
    And User toggles "OFF" the "Either Current OR/AND Preferred Location will be searched" toggle button
    And User clicks "Find Resumes" button
    Then User sees profiles with "Current Location" entered
    Then User sees profiles with "Preferred Location" entered similar to "Preferred Location"

  Scenario: Verify that toggling OFF the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Mentioned Below"
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Mentioned Below"
    And User toggles "OFF" the "Either Current OR/AND Preferred Location will be searched" toggle button
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Current Location" entered
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that toggling ON the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Same as Above"
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Mentioned Below"
    And User clicks "Find Resumes" button
    Then User sees profiles with same "Current Location" and "Preferred Location" entered

  Scenario: Verify that toggling ON the "Either Current OR/AND Preferred Location will be searched" toggle button and dropdown is selected as "Mentioned Below"
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User checks "Preferred Location" checkbox
    And User selects "Preferred Location" checkbox dropdown as "Mentioned Below"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Current Location" entered and "Preferred Location" entered

  Scenario: Verify user is able to change locations by clicking "Modify Search" on SRP
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Modify Search" link
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks cross icon for the tag
    And User clicks outside the Job Location dropdown
    When User enters "Chandigarh" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that user is able to edit locations in new saved searches
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Save Search" link
    And User enters search name
    And User clicks "Advanced Search" for "All Profiles"
    And User clicks "edit" option for saved search
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks cross icon for the tag
    And User clicks outside the Job Location dropdown
    When User enters "Chandigarh" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered

  Scenario: Verify that when user fills from new saved search, all locations are prefilled
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Find Resumes" button
    Then User sees profiles with "Preferred Location" entered
    And User clicks "Save Search" link
    And User enters search name
    And User clicks "Advanced Search" for "All Profiles"
    And User clicks "fill" option for saved search
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown

  Scenario: Verify that user fills from old legacy data saved search, all locations are prefilled
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    And User clicks "fill" option for old saved search
    Then User sees locations entered in saved search are added as tag to "Preferred Location" dropdown values

  Scenario: Verify that on clicking "Reset Search" link, all locations added to search gets removed
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks on candidate count for requirement "abc"
    And User clicks "Advanced Search" for "All Profiles"
    When User enters "Ajmer" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag to "Preferred Location" dropdown
    When User enters "Haryana" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Haryana" added as tag to "Preferred Location" dropdown
    When User enters "Anywhere in North India" in "Preferred Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Anywhere in North India" added as tag to "Preferred Location" dropdown
    And User clicks "Reset Search" link
    Then User sees no tags in "Preferred Location" dropdown

    
    # Following scenarios to be done after data migration is complete
  Scenario: Verify that user is able to search profiles with legacy location data

  Scenario: Verify that user is able to edit old saved searches

  Scenario: Verify that profiles with new data is also visible to user if user performs search on old saved search

  Scenario: Verify that profiles with new data is also visible to user if user performs search on old recent search