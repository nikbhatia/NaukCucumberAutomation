Feature: To verify the bulk status update of applications in RMS

  @RMS @RMSBulkStatusUpdate @id:1 @RMSApplications
  Scenario: To verify change status gives error message on not selecting any applications
    Given I login into RMS as an "Enterprise" user
    When I am on application inbox page
    And I click on the bulk status change button on the top panel without selecting any profile
    Then I should see an error message "Please select atleast one resume(s) for which you want to change the status"

  @RMS @RMSBulkStatusUpdate @id:2 @RMSApplications
  Scenario: To verify change status gives error message on not selecting any applications
    Given I login into RMS as an "Enterprise" user
    When I am on application inbox page
    And I select profile 1 on profile listing page
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    And I should be able to see the "mark as rejected" checkbox

  @RMS @RMSBulkStatusUpdate @id:3 @RMSApplications
  Scenario: To verify selecting multiple applications and changing there status,gives a success message:- Success! Application Status have been successfully changed to Prospect-New
    Given I login into RMS as an "Enterprise" user
    When I am on application inbox page
    And I select profile 1 on profile listing page
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I select the status of the profiles to "Prospect-something"
    And I click on update on the layout
    Then I should be able to see the success message as "Success! Application Status have been successfully changed to Prospect"

  @RMS @RMSBulkStatusUpdate @id:4 @RMSApplications
  Scenario: To verify no of applications selected are reflected on change status light box
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And I select multiple profiles on the profile listing page
    And I click on the bulk status update from the top panel
    Then I should be able to see the number of selected profiles in the status change pop up

  @RMS @RMSBulkStatusUpdate @id:5 @RMSApplications
  Scenario: To verify On marking as rejected ,Candidate on respective stage is marked as rejected
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I check the Mark as Rejected checkbox
    And I click on update on the layout
    Then I should be able to see the status of the selected candidate as "Rejected"

  @RMS @RMSBulkStatusUpdate @id:6 @RMSApplications
  Scenario: To verify changed status reflected on view application page
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
  	And I select profile 1 on profile listing page
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I select the status of the profiles to "Applied-Matching"
    And I click on update on the layout
    Then I should be able to see the success message as "Success! Application Status have been successfully changed to Applied-Matching"

  @RMS @RMSBulkStatusUpdate @id:7 @RMSApplications
  Scenario: To verify On clicking 'Cancel' the changes are ignore and control returns to previous page.
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And User select the first candidate checkbox
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I click on the cancel button on the modal layout
    Then I should not see the success message "Success! Application Status have been successfully changed to Prospect"

  @RMS @RMSBulkStatusUpdate @id:8 @RMSApplications
  Scenario: To check the unavailability of the option to change status in bulk on candidate profile page
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And I select multiple profiles on the profile listing page
    And I click on the bulk status update from the top panel
    Then I should not see the option of bulk status change on the top panel and text "This option is not available when making status changes for applications across multiple requirements."
