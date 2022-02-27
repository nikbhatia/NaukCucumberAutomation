Feature: Manage client tracker listing page

  Background: Login with consultant account and create a tracker
    Given I login into RMS as an "ProConsultant" user
    When User is on "settingsPage" page
    When User is on "clientTracker" page
    And click on add a new tracker
    And Enter tracker name
    And select name , email id , job title
    And Click on save button on create new tracker page
    And Enter the template name Under Quick Search Template

  @testManageListingPage @AddANewTracker @Settings
  Scenario: Quick search bar functionality working and existing functionality should be working
    Then The search results should be displayed correctly
    And Add a New Tracker name should be displayed on the page
    And Delete button should be displayed on the page
    And Heading such as Trackers , show my trackers and last modified date should be visible

  @testManageListingPage @AddANewTracker @Settings
  Scenario: List of trackers visible under Employer name(categorised) and uncategorised trackers
    Then Under Uncategorized Tracker ,tracker should be displayed
    When click on add a new tracker
    And Enter tracker name
    And click on the assign employer DD
    And Choose the employer from assign employer DD
    And select name , email id , job title
    And Click on save button on create new tracker page
    And Enter the template name Under Quick Search Template
    Then Tracker should be displayed under employer category

  @testManageListingPage @AddANewTracker @Settings
  Scenario: Share , edit, delete functionality should be working
    When Click on Edit button
    And select an employer
    And Click on save button on create new tracker page
    And Enter the template name Under Quick Search Template
    Then Share,Edit,Delete buttons should be visible
    When Click on Share button
    Then the tracker should be shared
    When Click on Delete button
    And Enter the template name Under Quick Search Template
    Then the tracker should no longer be in system
