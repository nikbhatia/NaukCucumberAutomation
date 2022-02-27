Feature: Manage Duplicate Settings

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser2"

  @Settings @E2E @DuplicateSettings
  Scenario: verify RMS user is able to block application with same email ID while adding manually within Groups/Employers settings
    When user click on "Manage Uploads and Duplicate Settings" link
    Then verify user should land on "Duplicate Settings" page successfully
    When User click on "Add New Duplicate Rule" button on duplicate settings page
    And user click on "Add Source" link
    And User choose source as "Added Manually" from list on duplicate setting page
    And User click on "Within same" Employer/Group radio button.
    And User select "1 month" option from list on duplicate setting page
    And User click on "SAVE" button on duplicate settings page for saving settings
    And User add a new requirment with "Duplicate candidate" group
    And User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
    Then verify that user should be able to add candidate
    When User reload the page.
    And User add a new requirment with "Duplicate candidate" group
    And User select a "Add a Single Profile" from "Profiles" option
    And User fill in the already created email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
    Then verify that user should be able to see the block message

  @Settings @E2E @DuplicateSettings
  Scenario: verify RMS user is able to block application with same email ID while adding manually across Groups/Employers settings
    When user click on "Manage Uploads and Duplicate Settings" link
    Then verify user should land on "Duplicate Settings" page successfully
    When User click on "Add New Duplicate Rule" button on duplicate settings page
    And user click on "Add Source" link
    And User choose source as "Added Manually" from list on duplicate setting page
    And User click on "Across all" Employer/Group radio button.
    And User select "1 month" option from list on duplicate setting page
    And User click on "SAVE" button on duplicate settings page for saving settings
    And User add a new requirment with "Duplicate candidate" group
    And User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
    Then verify that user should be able to add candidate
    When User reload the page.
    And User add a new requirment with "Duplicate candidate another" group
    And User select a "Add a Single Profile" from "Profiles" option
    And User fill in the already created email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
    Then verify that user should be able to see the block message

  @Settings @E2E @DuplicateSettings
  Scenario: verify RMS user is able to add application with same email ID in different group while adding manually within Groups/Employers settings
    When user click on "Manage Uploads and Duplicate Settings" link
    Then verify user should land on "Duplicate Settings" page successfully
    When User click on "Add New Duplicate Rule" button on duplicate settings page
    And user click on "Add Source" link
    And User choose source as "Added Manually" from list on duplicate setting page
    And User click on "Within same" Employer/Group radio button.
    And User select "1 month" option from list on duplicate setting page
    And User click on "SAVE" button on duplicate settings page for saving settings
    And User add a new requirment with "Duplicate candidate" group
    And User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
    Then verify that user should be able to add candidate
    When User reload the page.
    And User add a new requirment with "Duplicate candidate another again" group
    And User select a "Add a Single Profile" from "Profiles" option
    And User fill in the already created email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
    Then verify that user should be able to add candidate
