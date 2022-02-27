Feature: Manage CV BackUp

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser1"

  @Settings
  Scenario: verify RMS user is able to see all headings and labels
    When user click on "Manage Automatic CV Back Up Settings" link
    Then verify that user is able to see the listed headings on page
      | CV Back up                           |
      | Select Auto Backup Criteria          |
      | Back up Based on Pipeline Stages     |
      | Back up Based on Actions taken on CV |
    When user click on "Manage Backup" other than button,link
    Then user should be able to see the label "  All Backup Profiles "

  @Settings
  Scenario: verify RMS user is able to set CV backUp Setting
    When user click on "Manage Automatic CV Back Up Settings" link
    And user select different criteria for auto backUp setting
    Then verify success message "Backup Settings Saved Successfully"
