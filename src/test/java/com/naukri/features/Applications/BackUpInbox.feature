@RMSApplications
Feature: To verify the backup inbox functionality in RMS

  @id:1 @RMS @RMSBackUpInbox @RMSApplications
  Scenario: To check the availability of the link Advance Search , expand link against advanced search field and presence of Send a Requirement and Message flow under Email drop down
    To verify the error message on forward flow when no profile is selected
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    Then I should be able to see the advance search link
    And The advance search link should be clickable
    When User is on "backupInboxPage" page
    Then I should be able to see the expand link
    And The expand link should be clickable
    When User is on "backupInboxPage" page
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see send a requirement and message options
    When User click on Message option
    Then I should be able to see the error message "Error! Please select the resume(s) you want to contact"

  @id:4 @RMS @RMSBackUpInbox @RMSApplications
  Scenario: To verify the send requirement link under message option is clickable
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    And I click on Send a Requirement
    Then I should be able to see Send a Requirement Lightbox

  @id:6 @RMS @RMSBackUpInbox @RMSApplications
  Scenario: To verify the presence of forward link on backup inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    And User select the first candidate checkbox
    Then I should be able to see the forward link present
    And On clicking the forward link I should be able to see the forward lightbox

  @id:7 @RMS @RMSBackUpInbox @RMSApplications
  Scenario: To verify the error message on forward flow when no profile is selected
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    Then I should be able to see the forward link present
    When I click on forward option
    Then I should be able to see the error message "Error! Please select the resume(s) you want to forward"

  @id:8 @RMS @RMSBackUpInbox @RMSApplications
  Scenario: To verify the presence of the download DD on backup inbox with correct values
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    Then I should be able to see the download drop down
    When I click on download drop down
    Then I must be able to see "Selected Resumes" and "Index Range"

  @id:9 @RMS @RMSBackUpInbox @RMSApplications
  Scenario: To verify the functionality of the option of download drop down
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    And User select the first candidate checkbox
    Then I should be able to see the download drop down
    When I click on download drop down
    And I click on the "Selected Resumes" option
    Then I should be able to see the checkbox for "Attached Resume" on the download lightbox
    When User is on "backupInboxPage" page
    And I click on the "Index Range" option
    Then I should be able to see the from index and to index field for "Index Range"

  @id:10 @RMS @RMSBackUpInbox @RMSApplications
  Scenario: To check the functionality of the link Add to requirement on the backup inbox page
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    And User select the first candidate checkbox
    Then I am able to see the add to requirement option
    When I click on the add to requirement option
    Then I should be able to see the lightbox with title "Add to Requirement"
    When I chose a requirement name from requirement DD
    And I click on Add button on layout
    Then I should be able to see lightbox with the success message "Success! 1 Profiles are added to selected project"

  @id:11 @RMS @RMSBackUpInbox @RMSApplications
  Scenario: To check the error message for add to requirement on the backup inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    Then I am able to see the add to requirement option
    When I click on the add to requirement option
    Then I should be able to see the error message "Please select the resume(s) you want to add to requirement"

  @id:12 @RMS @RMSBackUpInbox @RMSApplications
  Scenario: To verify the functionality of remove from backup option
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    Then I should be able to see the remove from backup option
    When User select the first candidate checkbox
    And I read the name of the first candidate
    And I click on remove from backup inbox
    Then I should be able to see the options "Selected Resumes","All Profiles" and "All Duplicate Profiles" 
