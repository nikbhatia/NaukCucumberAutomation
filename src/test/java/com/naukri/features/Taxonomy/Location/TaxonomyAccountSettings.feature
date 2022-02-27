Feature: Location taxonomy changes in RMS Account Settings - Manage Your Profile

  @wip @id:1
  Scenario: Verify that if Location field is not visible for edit user for My Profile
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    When user click on "Manage Your Profile" link
    And User clicks Edit Icon next to user email
    Then User sees "Location" dropdown is not visible on "Edit User" layer

  @wip @id:2
  Scenario: Verify that if Location field is not visible for edit user for any recruiter in "Recruiters" tab
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    When user click on "Manage Your Profile" link
    And User clicks "Recruiters" tab
    And User clicks Edit "icon" for 1 "Recruiter"
    Then User sees "Location" dropdown is not visible on "Edit User" layer
    
  @wip @id:3
  Scenario: Verify that if Location field is not visible for edit user for any recruiter in "Recruiters" tab
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    When user click on "Manage Your Profile" link
    And User clicks "Recruiters" tab
    And User clicks Edit "link" for 1 "Recruiter"
    Then User sees "Location" dropdown is not visible on "Edit User" layer

  @wip @id:4
  Scenario: Verify that if Location field is not visible for edit user for any Hiring Manager in "Hiring Managers" tab
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    When user click on "Manage Your Profile" link
    And User clicks "Hiring Managers" tab
    And User clicks Edit "icon" for 1 "Hiring Manager"
    Then User sees "Location" dropdown is not visible on "Edit User" layer
    
  @wip @id:5
  Scenario: Verify that if Location field is not visible for edit user for any Hiring Manager in "Hiring Managers" tab
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise" user
    When user click on "Manage Your Profile" link
    And User clicks "Hiring Managers" tab
    And User clicks Edit "link" for 1 "Hiring Manager"
    Then User sees "Location" dropdown is not visible on "Edit User" layer
