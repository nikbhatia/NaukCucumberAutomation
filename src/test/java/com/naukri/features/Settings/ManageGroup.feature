Feature: Manage Groups

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser1"
    And user click on "Manage Groups " link

  @Settings
  Scenario: 
    verify RMS Enterprise user is able to Add Groups from Manage groups Page
    When user click on "Add Group" link
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And user Select Recruiters & Hiring Managers and fill all other details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Approval Process"
    And user create and Select Requisition Approval Process
    And user click on "NEXT" button
    Then user should be able to see the label "Select Offer Process"
    And user Select Offer Approval Process
    And user click on "SAVE" button
    And user click on "Continue" link
    Then verify created Group is added
		When user click on delete button under the group
		
  @Settings
  Scenario: 
    verify RMS Enterprise user is able to edit Groups from Manage groups Page
    When user click on "Add Group" link
    Then verify that user is able to see the listed headings on page
      | Add Group                    |
      | Recruiters and Interviewers  |
      | Requisition Approval Process |
      | Offer Approval Process       |
    And user fill mandatory field to add group
    And user click on "SAVE" button
    And user click on "Continue" link
    Then verify success message "Group Added"
    When user click on "Edit" link
    And user enter new Group Name
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    When user Select new Recruiters & Hiring Managers
    And user click on "SAVE" button
    Then verify edited Group
    When user click on delete button under the group

  @Settings
  Scenario: 
    verify RMS Enterprise user is able to edit selection stages(Add) in groups
    When user click on "Add Group" link
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    When user Select Recruiters & Hiring Managers and fill all other details
    And user click on "SAVE" button
    And user click on "Continue" link
    Then verify user is navigated to Manage Groups Page
    When user click on "Selection Stages" link
    And user Add new Selection Stage
    And user Add Hiring Manager to the new Stage
    Then verify new Selection Stage is visible in list
    When user Add new Sub Stage & attach FeedbackForm
    And user click on "Continue" link
    Then verify user is navigated to Manage Groups Page
    When user click on delete button under the group

  @Settings
  Scenario: 
    verify RMS Enterprise user is able to edit selection stages(delete) in groups
    When user click on "Add Group" link
    And user fill mandatory field to add group
    And user click on "SAVE" button
    And user click on "Continue" link
    Then verify user is navigated to Manage Groups Page
    When user click on "Selection Stages" link
    And user Add new Selection Stage
    Then verify new Selection Stage is visible in list
    When user delete new stage
    Then verify new selection stage is not visible in list
    When user click on "Continue" link
    Then verify user is navigated to Manage Groups Page
    When user click on delete button under the group

  @Settings
  Scenario: verify RMS Enterprise user is able to delete Group
    When user click on "Add Group" link
    And user fill mandatory field to add group
    Then user should be able to see the label "Select Interviewer(s) "
    When user click on "SAVE" button
    And user click on "Continue" link
    Then verify created Group is added
    When user click on delete button under the group
    Then verify success message "Group Deleted"

  @Settings @Smoke
  Scenario: verify RMS Enterprise user is able to delete Group in bulk
    When user click on "Add Group" link
    And user fill mandatory field to add group
    Then user should be able to see the label "Select Interviewer(s) "
    When user click on "SAVE" button
    And user click on "Continue" link
    Then verify success message "Group Added"
    When user click on "Add Group" link
    And user fill mandatory field to add group
    Then user should be able to see the label "Select Interviewer(s) "
    When user click on "SAVE" button
    And user click on "Continue" link
    And user select checkbox for 2 or more groups
    And click on bulk delete button
    Then verify success message "2 Group Deleted"

  @Settings
  Scenario: verify RMS Enterprise user is unable to add duplicate group name
    When user click on "Add Group" link
    And user fill group name which already exist
    Then verify user able to see error message "This name already exists."

  @Settings
  Scenario: verify RMS Enterprise user is able to search group
    When user click on "Add Group" link
    And user fill all fields in Group Details
    When user click on "SAVE" button
    Then verify user able to see error message "There are errors in this section!"
    When user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    When user Select Recruiters & Hiring Managers and fill all other details
    And user click on "SAVE" button
    And user click on "Continue" link
    Then verify success message "Group Added"
    When user type group name in search bar
    Then verify searched group is visible
    When user click on delete button under the group

  @Settings
  Scenario: RMS user is able to crete group from Settings page
    When user click on "Settings " link
    And user click on "Add New Group" link
    And user fill mandatory field to add group
    Then user should be able to see the label "Select Interviewer(s) "
    When user click on "SAVE" button
    

  @Settings @RMSBUG-3125
  Scenario: Verify count of avialable HM and Recruiter is greater or equal to Selected
    When User clicks "Edit" for group number 1 in the list
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And User clicks on "Select Recruiters" dropdown on Edit Group
    Then User should see ALL count should be greater than SELECTED
    And User clicks on "Select Interviewer(s) " dropdown on Edit Group
    Then User should see ALL count should be greater than SELECTED
