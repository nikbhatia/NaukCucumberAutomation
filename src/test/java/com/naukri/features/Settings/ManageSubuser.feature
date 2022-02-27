Feature: Manage Subuser MLH

  Background: 
    Given User login to rms "settingsPage" using "superuser1" and "superuser1password" of "Enterprise" user

  @id:1 @RMS2-3513 @MLH @ManageSubuser @Smoke
  Scenario: Verify that user names cannot be same across company
    Given user click on "Manage Recruiters" link
    And user click on "Edit" button for "Abhishek.mlh@yopmail.com"
    And user fills name as "Abhishek.mlh@yopmail.com"
    And user click on save button on lb
    And user click on "Edit" button for "Pradeep.mlh@yopmail.com"
    And user fills name as "Abhishek.mlh@yopmail.com"
    When user click on save button on lb
    Then Verify error message "User with this name already exists." is displayed
    And Verify name field is highlighted in "#be1e2d/Red"
    When user click on Cancel button on lb
    Then Verify "Pradeep  " username is displayed
    And user click on Hiring Managers section
    And user click on "Edit" button for "onehm@yopmail.com"
    And user fills name
    And user click on save button on lb
    And user click on Recruiters section
    And user click on "Edit" button for "Pradeep.mlh@yopmail.com"
    And user fills same name
    When user click on save button on lb
    Then Verify error message "User with this name already exists." is displayed
    And Verify name field is highlighted in "#be1e2d/Red"
    When user click on Cancel button on lb
    Then Verify "Pradeep  " username is displayed
    And user click on "Edit" button for "Abhishek.mlh@yopmail.com"
    And user fills name
    And user click on save button on lb
    And user click on "Edit" button for "Pradeep.mlh@yopmail.com"
    And user fills name as "Abhishek.mlh@yopmail.com"
    When user click on save button on lb
    Then Verify error message "Another user with this email ID already exists." is displayed
    And Verify name field is highlighted in "#be1e2d/Red"
    When user click on Cancel button on lb
    Then Verify "Pradeep  " username is displayed

  @id:2 @RMS2-3513 @MLH @ManageSubuser
  Scenario: Verify error when filling name and email Id of deleted user
    Given user click on "Manage Recruiters" link
    And user click on "Edit" button for "Abhishek.mlh@yopmail.com"
    And user fills name as "UniqueUser@yopmail.com"
    When user click on save button on lb
    Then Verify error message "Another user with this email ID already exists." is displayed
    And user fills name as "DifferentName"
    When user click on save button on lb
    Then Verify error message "User with this name existed in the account." is displayed

  @id:3 @MLHDowngrade @MLH @ManageSubuser
  Scenario: Verify that Reporting To dd is disabled for Recruiters
    Given user click on "Manage Recruiters" link
    When user click on "Edit" button for "Abhishek.mlh@yopmail.com"
    Then Verify "Reporting To:" label is displayed
    And Verify Reporting To dd is disbled

  @id:4 @RMS2-3513 @MLH @ManageSubuser
  Scenario: Verify that error will be displayed irrespective of casing of letters
    Given user click on "Manage Recruiters" link
    And user click on "Edit" button for "Abhishek.mlh@yopmail.com"
    And user fills name as "uniQueUSer@yopmail.com"
    When user click on save button on lb
    Then Verify error message "Another user with this email ID already exists." is displayed
    And user fills name as "DiFFerentName"
    When user click on save button on lb
    Then Verify error message "User with this name existed in the account." is displayed

  @id:5 @MLHDowngrade @MLH @ManageSubuser
  Scenario: Verify that if Reporting to is changed from MNR then same is reflected in RMS
    Given user is on Manage Sub-Users page on MNR
    And user click on cross for photo uploader
    And user click on "Edit Hierarchy" link
    And user click on reporting to dd for "Kaustubh.mlh@yopmail.com"
    And user fills "None" as reporting to for "Kaustubh.mlh@yopmail.com"
    And user click on "SAVE THIS HIERARCHY" button
    And User navigate to settings page
    And user click on "Manage Recruiters" link
    When user click on "Edit" button for "Kaustubh.mlh@yopmail.com"
    Then verify "" is displayed for reporting to
    And user is on Manage Sub-Users page on MNR
    And user click on "Edit Hierarchy" link
    And user click on reporting to dd for "Kaustubh.mlh@yopmail.com"
    And user fills "Abhishek.mlh@yopmail.com" as reporting to for "Kaustubh.mlh@yopmail.com"
    And user click on "SAVE THIS HIERARCHY" button
    And User navigate to settings page
    And user click on "Manage Recruiters" link
    When user click on "Edit" button for "Kaustubh.mlh@yopmail.com"
    Then verify "Abhishek.mlh@yopmail.com" is displayed for reporting to
