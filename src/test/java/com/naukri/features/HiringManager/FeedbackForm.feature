Feature: Create Feedback Form

  Background: 
    Given I am logged in with "Enterprise" user "superuser1"
    And I am on "settingsPage" page

  @id:1 @FeedbackForm @HMRequisition
  Scenario: User sees Default Feedback form on top of all other feedback forms
    When User click on "Manage Feedback Forms" link
    Then Verify that default feedback form name is "Default Feedback Form (Default)"
    And Verify that "Default Feedback Form (Default)" is on top of list
    When User clicks on sort by "Form Template Name"
    Then Verify that "Default Feedback Form (Default)" is on top of list
    When User clicks on sort by "Last Modified"
    Then Verify that "Default Feedback Form (Default)" is on top of list

  @id:2 @FeedbackForm @HMRequisition
  Scenario: Verify that Edit and Preview buttons are displayed while Delete and Share buttons are not present for Default Feedback Form on listing page for superuser
    When User click on "Manage Feedback Forms" link
    Then Verify "Edit" button is displayed for default feedback form
    And Verify "Preview" button is displayed for default feedback form
    And Verify "Delete" button is not displayed for default feedback form
    And Verify "Share" button is not displayed for default feedback form
    And Verify "Unshare" button is not displayed for default feedback form
    And Verify "Owner Mansi Gupta Shared with Everyone" is displayed below form name

  @id:3 @FeedbackForm @HMRequisition
  Scenario: Verify Superuser is able to Edit Default Feedback Form
    When User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    Then Verify user see heading "Edit Feedback Form"
    And User edits form title as "New Form Title"
    And User click on "SAVE" button on form
    And User click on "Preview" link for default feedback form
    And Verify form tilte is "New Form Title"

  @id:4 @FeedbackForm @HMRequisition
  Scenario: Verify that subuser cannot edit default feedback form
    Given I logout
    And I am logged in with "Enterprise" user "subuser1"
    And I am on "settingsPage" page
    When User click on "Manage Feedback Forms" link
    Then Verify "Edit" button is not displayed for default feedback form
    And Verify "Preview" button is displayed for default feedback form
    And Verify "Delete" button is not displayed for default feedback form
    And Verify "Share" button is not displayed for default feedback form
    And Verify "Share" button is not displayed for default feedback form
    And Verify "Unshare" button is not displayed for default feedback form
    And I logout

  @id:5 @FeedbackForm @HMRequisition
  Scenario: Verify that superuser can add or remove on hold button in default feedback form
    When User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    Then Verify that "On Hold" button can be added in default feedback form
    When User click on "PREVIEW" button on form
    Then Verify "On Hold" button is displayed
    When User click on "EDIT" button on form
    Then Verify that "On Hold" button can be removed
    When User click on "PREVIEW" button on form
    Then Verify "On Hold" button is not displayed

  @id:6 @FeedbackForm @HMRequisition
  Scenario: Verify that on hold state cannot be removed from feedback form if default form has on hold state
    Given User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    And User adds "On Hold" button in default feedback form
    And User click on "SAVE" button on form
    When User click on "Create Feedback Form" button
    Then Verify "On Hold" button is displayed
    And Verify user cannot remove "On Hold" state

  @id:7 @FeedbackForm @HMRequisition
  Scenario: Verify that user can add and remove on hold state if default form dont have on hold state while creating new form or editing already existing form
    Given User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    And User removes "On Hold" button in default feedback form
    And User click on "SAVE" button on form
    When User click on "Create Feedback Form" button
    Then Verify that "On hold" state can be added
    When User click on "PREVIEW" button on form
    Then Verify "On hold" button is displayed
    And User click on back arrow button
    And User fills feedback form name
    And User click on "SAVE" button on form
    When User click on "Preview" link for feedback form
    Then Verify "On hold" button is displayed
    When User click on back arrow button
    And User click on "Edit" link for feedback form
    Then Verify that "On hold" state can be removed
    When User click on "PREVIEW" button on form
    Then Verify "On hold" button is not displayed
    And User click on back arrow button
    And User click on "SAVE" button on form
    When User click on "Preview" link for feedback form
    Then Verify "On hold" button is not displayed

  @id:8 @FeedbackForm @HMRequisition
  Scenario: Verify that user cannot remove Approve/Reject states from feedback form
    Given User click on "Manage Feedback Forms" link
    When User click on "Edit" link for default feedback form
    Then Verify user cannot remove "Approve" state
    And Verify user cannot remove "Reject" state
    And User click on "SAVE" button on form
    When User click on "Create Feedback Form" button
    Then Verify user cannot remove "Approve" state
    And Verify user cannot remove "Reject" state

  @id:9 @FeedbackForm @HMRequisition
  Scenario: Verify that user cannot save feedback form with name same as Default Feedback Form
    Given User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    And User fills feedback form name as "Default Feedback Form"
    When User click on "SAVE" button on form
    Then User sees error as "Feedback form with this name already exists."

  @id:10 @FeedbackForm @HMRequisition
  Scenario: Verify that if any question is present in feedback form then default state mapping is Ask all Questions and if no question then mapping is Ask No Questions
    Given User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    When User deletes all questions
    Then Verify "Ask No Questions" is displayed for state mapping
    When User click on "Add Question" button on form
    Then Verify "Ask all Questions" is displayed for state mapping

  @id:11 @FeedbackForm @HMRequisition
  Scenario: Verify static content on create feedback form
    Given User click on "Manage Feedback Forms" link
    When User click on "Create Feedback Form" button
    And User adds a question of "Single Choice " type
    Then Verify text "Feedback Questions" is displayed
    And Verify text "Feedback Response Options" is displayed
    And Verify text "Configure responses provided by hiring managers/interviewers for an application" is displayed
    And Verify text "Form Title" is displayed
    And Verify text "Options" is displayed
    And Verify text "Select questions to ask for this Option" is displayed
    And Verify text "Share with everyone" is displayed
    And Verify text "These questions will be answered by the Hiring Manager/Interviewer after interview with the candidate" is displayed

  @id:12 @FeedbackForm @HMRequisition
  Scenario: Verify message for state on form preview when no questions are mapped with state
    Given User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    And User deletes all questions
    And User adds a question of "Single Choice " type
    And User click on state question mapping dd for "Approve"
    And User unselects "all" questions from state mapping dd
    When User click on "PREVIEW" button on form
    And User click on "Approve" state on form
    Then Verify "No further questions will be asked if the interviewer selects" state name "Approve" is displayed
    And Verify text "Preview for each Feedback Response Option:" is displayed
    And Verify text "These questions will be answered by the Hiring Manager/Interviewer after interview with the candidate" is displayed

  @id:13 @FeedbackForm @HMRequisition
  Scenario: Verify that when default form dont have any questions then on creating new form no questions will be present
    Given User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    And User edits form title as "New Default Feedback Form Title"
    When User deletes all questions
    And User click on "SAVE" button on form
    When User click on "Create Feedback Form" button
    Then Verify no questions are present
    And Verify form title is "New Default Feedback Form Title"
    And Verify "Ask No Questions" is displayed for state mapping

  @id:14 @FeedbackForm @HMRequisition
  Scenario: Verify only one question can be marked as Overall Rating Question in one feedback form
    Given User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    And User deletes all questions
    And User click on "Add Question" button on form
    And User click on Change question type dd
    When User selects "Star Rating" question
    Then Verify Mark as Overall Rating is selected
    And User click on "Add Question" button on form
    And User click on Change question type dd
    When User selects "Star Rating" question
    Then Verify Mark as Overall Rating is unselected
    When User hover over "Mark as Overall Rating" label
    Then Verify "Only one question can be marked as Overall Rating. Unselect the question currently marked as Overall Rating to select a new one." is displayed

  @id:15 @FeedbackForm @HMRequisition
  Scenario: Verify that Add Question button is greyed out after maximum question limit is achieved
    Given User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    And User deletes all questions
    When User adds maximum limit "Single Choice " questions "60"
    And User hover over "Add Question" button
    Then Verify title "You can add a maximum of 60 questions to a feedback form" is displayed for Add Question button
    And User fills feedback form name
    And User click on "SAVE" button on form

  @id:16 @FeedbackForm @HMRequisition
  Scenario: Verify success message on creation of new form with all type of questions
    Given User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    And User deletes all questions
    And User adds single questions of every type
    And User fills feedback form name
    When User click on "SAVE" button on form
    Then Verify text "New form has been added successfully" is displayed

  @id:17 @FeedbackForm @HMRequisition
  Scenario: Verify that user is able to add custom buttons
    Given User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    And User adds single questions of every type
    And User click on "Add another option" button on form
    When User fills "Feedback Form State Seven" as state name
    Then Verify "Feedback Form State Seven" state tag is created
    And User click on "Add another option" button on form
    When User fills "CustomState123" as state name
    Then Verify "CustomState123" state tag is created
    When User click on "PREVIEW" button on form
    Then Verify "Feedback Form State Seven" button is displayed
    And Verify "CustomState123" button is displayed
    And User click on back arrow button
    And User fills feedback form name
    And User click on "SAVE" button on form
    When User click on "Preview" link for feedback form
    Then Verify "Feedback Form State Seven" button is displayed
    And Verify "CustomState123" button is displayed

  @id:18 @FeedbackForm @HMRequisition
  Scenario: Verify that custom state with names such as Accepted,1,2,approve,approved,accept,reject,rejected,pending cannot be created
    Given User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    When User click on "Add another option" button on form
    Then User fills below as state name and verifies error
      | State    | Error                                                                   |
      | Accepted | Accepted is a system reserved option. Please rename the entered option. |
      |        1 | Field should contain at least one alphabet (A-Z).                       |
      |        2 | Field should contain at least one alphabet (A-Z).                       |
      | Approve  | Duplicate Options are not allowed                                       |
      | Approved | Approved is a system reserved option. Please rename the entered option. |
      | Reject   | Duplicate Options are not allowed                                       |
      | Rejected | Rejected is a system reserved option. Please rename the entered option. |
      | Accept   | Accept is a system reserved option. Please rename the entered option.   |
      | Pending  | Pending is a system reserved option. Please rename the entered option.  |
      |   122345 | Field should contain at least one alphabet (A-Z).                       |
      |        0 | Field should contain at least one alphabet (A-Z).                       |

  @id:19 @FeedbackForm @HMRequisition
  Scenario: Verify that only two custom states can be added
    Given User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    And User removes "On Hold" button in default feedback form
    And User click on "SAVE" button on form
    When User click on "Create Feedback Form" button
    And User click on "Add another option" button on form
    And User click on "Reject" state on form
    Then Verify error as "Field is mandatory"
    And User fills "Feedback Form State Seven" as state name
    And User click on "Add another option" button on form
    And User fills "CustomState123" as state name
    And User click on "Add another option" button on form
    When User fills "ABCD" as state name
    Then Verify error as "Only two custom responses are allowed."

  @id:20 @FeedbackForm @HMRequisition
  Scenario: Verify Add Question Button location after previewing
    Given User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    And User adds a question of "Star Rating " type
    And User click on "PREVIEW" button on form
    When User click on "EDIT" button on form
    Then Verify x coodinate of "Add Question" is "215"

  @id:21 @FeedbackForm @HMRequisition
  Scenario: Verify that all questions are present in state question mapping
    Given User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    And User deletes all questions
    And User adds single questions of every type
    Then Verify that all questions are displayed in state mapping dd for "Reject"

  @id:22 @FeedbackForm @HMRequisition
  Scenario: Verify that overall star rating question is inherited from default feedback form if overall rating question is present in default form else first satr rating question is marked as overall rating
    Given User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    And User deletes all questions
    And User adds a question of "Star Rating " type
    And User click on "SAVE" button on form
    When User click on "Create Feedback Form" button
    Then Verify Mark as Overall Rating is selected
    And User fills feedback form name
    And User click on "SAVE" button on form
    And User click on "Edit" link for default feedback form
    And User deletes all questions
    And User adds a question of "Single Choice " type
    And User click on "SAVE" button on form
    When User click on "Create Feedback Form" button
    When User adds a question of "Star Rating " type
    Then Verify Mark as Overall Rating is selected

  @id:23 @FeedbackForm @HMRequisition
  Scenario: Verify user is able to save from prefilled from another form
    Given User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    And User fills feedback form name
    When User prefill feedback form from top feedback form
    And User click on "SAVE" button on form
    Then Verify text "New form has been added successfully" is displayed
    
  @id:24 @FeedbackForm @HMRequisition @done
  Scenario: Verify that on hold is automatically added removed from form basis default form
    Given User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    And User removes "On Hold" button in default feedback form
    And User click on "SAVE" button on form
    When User click on "Create Feedback Form" button
    And User fills feedback form name
    And User click on "SAVE" button on form
    And I am on "settingsPage" page
    And User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    And User adds "On Hold" button in default feedback form
    And User click on "SAVE" button on form
    When User click on "Edit" link for feedback form
    Then Verify "On Hold" button is displayed
    And Verify user cannot remove "On Hold" state

  @id:25 @FeedbackForm @HMRequisition
  Scenario: Verify feedback form is prefilled from default feedback form and question mapping is set to default
    Given User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    And User edits form title as "New Default Feedback Form Title"
    And User deletes all questions
    And User adds single questions of every type
    And User click on state question mapping dd for "Approve"
    And User unselects "all" questions from state mapping dd
    And User click on state question mapping dd for "Reject"
    And User unselects "none" questions from state mapping dd
    And User adds "On Hold" button in default feedback form
    And User click on state question mapping dd for "On Hold"
    And User unselects "5" questions from state mapping dd
    And User click on "SAVE" button on form
    When User click on "Create Feedback Form" button
    Then Verify that only "On Hold,Approve,Reject" states are present
    And Verify "Ask all Questions" is displayed for state mapping
    When User click on "PREVIEW" button on form
    And Verify that same questions are present

  @id:26 @wip @ToBeReWritten
  Scenario: Verify that questions are displayed as per state mapping on previewing form
    Given User click on "Manage Feedback Forms" link
    And User click on "Edit" link for default feedback form
    And User edits form title as "New Default Feedback Form Title"
    And User deletes all questions
    And User adds single questions of every type
    And User click on state question mapping dd for "Approve"
    And User unselects "all" questions from state mapping dd
    And User click on state question mapping dd for "Reject"
    And User unselects "none" questions from state mapping dd
    And User adds "On Hold" button in default feedback form
    And User click on state question mapping dd for "On Hold"
    And User unselects "5" questions from state mapping dd
    And User click on "SAVE" button on form
    When User click on "Preview" link for default feedback form
    And Verify text "Preview for each Feedback Response Option:" is displayed
    And Verify text "These questions will be answered by the Hiring Manager/Interviewer after interview with the candidate" is displayed
    And User click on "Approve" state on form
    Then Verify "No further questions will be asked if the interviewer selects" state name "Approve" is displayed
    And User click on "Reject" state on form
    Then Verify all questions are displayed
    And User click on "Reject" state on form
    Then Verify unselected questions are not displayed
    And Verify selected questions are displayed
    Then Verify that on previewing default form same questions are present for states which were mapped
    And Verify form title is "New Default Feedback Form Title"
    And Verify "Ask all Questions" is displayed for state mapping



  @id:27 @wip
  Scenario: Verify user lands on Create feedback form page when clicking on Create Feedback form from Add Feedback form button on selection stage for group or requirement and is able to create form
