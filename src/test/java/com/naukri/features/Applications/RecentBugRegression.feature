Feature: To verify the regression of recent bug release

  @RMS @RMSRecent @id:1 @RMSBUG-1779 @RMSApplications
  Scenario: Adding a candidate using Add a Single Profile flow
    Given I login into RMS as an "Enterprise" user
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    Then I should be directed to the CV details page
    And I should be able to see the success message "The profile has been successfully created. Add more profiles" on CV Details Page
    And I should be able to view the filled information on the CV detail page
    When I click on the edit option
    And I update the mobile number
    And I click on the save button
    Then I should able to see the success message "Profile updated successfully"
    And I should be able to see the updated contact number

  @RMS @RMSRecent @id:2 @RMSBUG-1888 @RMSApplications
  Scenario: To verify the status change of candidate is recorded by a valid recruiter in the group
    Given I login into RMS as an "Enterprise" user
    When I am on Add a new group page
    And I fill in the group name and group description
    And I click on "Next" button on manage group layout
    And I select "Lokesh Agrawal" and "enterprise_subuser1@naukri.com" as recruiters
    And I select "enterprise_hm1@naukri.com" as HM.
    And I click on "Save" button on manage group layout
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I select the group created to requirement
    And I select the requirement visibility to "Visible to all in the group"
    And I click on Save button
    Then I should be directed to the CV details page
    And I should be able to see the success message "The profile has been successfully created. Add more profiles" on CV Details Page
    When I click on status change drop down
    And I click on "Prospect" on DD
    Then I should be able to see the success message "Success! Application status has been successfully changed to Prospect " On CV details Page
    When I login into RMS as an "Enterprise" subuser
    And I navigate to CV Details Page of candidate added
    Then I should see the current status of the candidate as "Prospect"
    And I should see the status change information "by Lokesh Agrawal"

  @RMS @RMSRecent @id:3 @RMSBUG-1702 @RMSApplications @StatusChange
  Scenario: To verify interview scheduling in consultant account
    Given I login into RMS as an "ProConsultant" user
    When I navigate to profile inbox
    When I click on status change drop down
    And I click on "Interview| - Round 1" on DD
    And I fill in all the details
    And User click on set interview button
    Then I should be able to see candidate on "Interview - Round 1" on profile listing page
    Then I should be able to see the success message "Success! Application status has been successfully changed to Interview - Round 1" On CV details Page
    When I click on status change drop down
    And I click on "Interview| - Round 2" on DD
    And I fill in all the details
    And User click on set interview button
    Then I should be able to see candidate on "Interview - Round 2" on profile listing page
    Then I should be able to see the success message "Success! Application status has been successfully changed to Interview - Round 2" On CV details Page

  @RMS @RMSRecent @id:3 @RMSBUG-2512 @RMSApplications
  Scenario: Verify that user is able to see the requirement name just above the selection stage DD on profile,Application inbox and backup page    
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User navigate through GNB to "All Profiles" under "Profiles"
    Then Verify that user is able to see the requirement name just above the selection stage DD
    When User navigate through GNB to "All Applications" under "Profiles"
    Then Verify that user is able to see the requirement name just above the selection stage DD
    When User navigate through GNB to "All Backed Up Profiles" under "Profiles"
    Then Verify that user is able to see the requirement name just above the selection stage DD
