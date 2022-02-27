Feature: Taxonomy changes for location filter for all profiles

  # All Profiles
  Scenario: Verify that all cities with which old profiles have been created are listed in Location filter
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    Then User sees all locations from which old profiles have been created

  Scenario: Verify that all locations with which new profiles have been created are listed in Location filter
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    Then User sees all new locations from which new profiles have been created

  Scenario: Verify that applications with only the cities selected in location filter are displayed
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Bangalore / Bangaluru" location filter
    Then User sees profiles with "Bangalore / Bangaluru" current location

  Scenario: Verify that count of applications for a location matches when the location filter is applied
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Bangalore / Bangaluru" location filter
    Then User sees same number of profile as mentioned in location filter

  Scenario: Verify that old as well as new applications are visible when any location filter is applied
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Bangalore / Bangaluru" location filter
    Then User sees old profiles with "Bangalore / Bangaluru" current location
    Then User sees new profiles with "Bangalore / Bangaluru" current location

  Scenario: Verify that old profiles with values added in other are displayed on selecting "Other City"
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Other City" location filter
    Then User sees old profiles with values in other

  Scenario: Verify that selecting multiple cities displays applications for all selected cities
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Bangalore / Bangaluru" location filter
    And User clicks "Mumbai" location filter
    Then User sees old profiles with "Bangalore / Bangaluru" current location
    Then User sees new profiles with "Bangalore / Bangaluru" current location
    Then User sees old profiles with "Mumbai" current location
    Then User sees new profiles with "Mumbai" current location

  Scenario: Verify that long tail values are displayed under locations filter, selecting any value shows application with that long tail values
    Given User login to the application "profileListingInbox" using "Superuser" of "Enterprise" user
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "test" location filter
    Then User sees new profiles with "test" current location

  # Requirement Responses
  Scenario: Verify that all cities with which old profiles have been created are listed in Location filter
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks requirement with multiple applicants
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    Then User sees all locations from which old profiles have been created

  Scenario: Verify that all locations with which new profiles have been created are listed in Location filter
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks requirement with multiple applicants
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    Then User sees all new locations from which new profiles have been created

  Scenario: Verify that applications with only the cities selected in location filter are displayed
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks requirement with multiple applicants
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Bangalore / Bangaluru" location filter
    Then User sees profiles with "Bangalore / Bangaluru" current location

  Scenario: Verify that count of applications for a location matches when the location filter is applied
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks requirement with multiple applicants
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Bangalore / Bangaluru" location filter
    Then User sees same number of profile as mentioned in location filter

  Scenario: Verify that old as well as new applications are visible when any location filter is applied
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks requirement with multiple applicants
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Bangalore / Bangaluru" location filter
    Then User sees old profiles with "Bangalore / Bangaluru" current location
    Then User sees new profiles with "Bangalore / Bangaluru" current location

  Scenario: Verify that old profiles with values added in other are displayed on selecting "Other City"
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks requirement with multiple applicants
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Other City" location filter
    Then User sees old profiles with values in other

  Scenario: Verify that selecting multiple cities displays applications for all selected cities
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks requirement with multiple applicants
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "Bangalore / Bangaluru" location filter
    And User clicks "Mumbai" location filter
    Then User sees old profiles with "Bangalore / Bangaluru" current location
    Then User sees new profiles with "Bangalore / Bangaluru" current location
    Then User sees old profiles with "Mumbai" current location
    Then User sees new profiles with "Mumbai" current location

	# Longtail for cities is only displayed, not for countries
  Scenario: Verify that long tail values are displayed under locations filter, selecting any value shows application with that long tail values
    Given User login to the application "requirementInbox" using "Superuser" of "Enterprise" user
    When User clicks requirement with multiple applicants
    When User clicks on "Location" filter
    And User clicks on "Show More" link
    And User clicks "test" location filter
    Then User sees new profiles with "test" current location
