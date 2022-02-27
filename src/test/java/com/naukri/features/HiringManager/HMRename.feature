Feature: Rename HM spoc/HM to hiring manager and interviewer

  @id:1 @RenameHM @RMS 
  Scenario: Verify that the hiring manager(s) text is changed to interviewer(s) and Hiring manager(s) field is added
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When I navigate to Settings page
    And user click on "Manage Groups " link
    And user click on "View Details " link
    Then user should be able to see the label "Interviewer(s)"
    Then user should be able to see the label "Hiring Manager(s)"

  @id:2 @RenameHM @RMS 
  Scenario: Verify that the field for Hiring manager is added showing list of HMSpoc
    Given I am logged in with "Enterprise" user "superuser1"
    When I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    Then Verify that Group name is displayed on manage group page
    And refresh the page
    And user click on "View Details " link
    And user should be able to see "MansiTest, MansiHM" under "Interviewer(s)" label
    And user should be able to see "MansiHM" under "Hiring Manager(s)" label

  @id:3 @RenameHM @RMS 
  Scenario: Verify that the select hiring manager is changed to select interviewer while adding group
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When I navigate to Settings page
    And user click on "Manage Groups " link
    And user click on "Add Group" link
    Then verify that user is able to see the listed headings on page
      | Recruiters and Interviewers |
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And user should be able to see the label "Select Hiring manager(s) "
    And user should be able to see the label "The selected hiring managers can raise requisition for this group"

  @id:4 @RenameHM @RMS 
  Scenario: Verify that the select hiring manager is changed to select interviewer while editing group
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When I navigate to Settings page
    And user click on "Manage Groups " link
    And user click on "Add Group" link
    Then verify that user is able to see the listed headings on page
      | Recruiters and Interviewers |
    And user fill mandatory field to add group
    And user click on "SAVE" button
    And user click on "Continue" link
    Then verify success message "Group Added"
    When user click on "Edit" link
    And user enter new Group Name
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And user should be able to see the label "Select Hiring manager(s) "
    And user should be able to see the label "The selected hiring managers can raise requisition for this group"

  @id:5 @RenameHM @RMS 
  Scenario: Verify that the add hiring manager is changed to add interviewer while mapping interviewer for selection stages for group with interview(s)
    Given I am logged in with "Enterprise" user "superuser1"
    And I create group with below as HR, HRSpoc, HM, HMSpoc
      | HR          | HRSpoc      | HM      | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM | MansiHM |
    And user click on "Continue" link
    Then verify user is navigated to Manage Groups Page
    When user click on "Selection Stages" link
    Then User verify "Add Interviewer(s)" title is present for add interviewer icon for "Shortlisted" stage
    And User click on "Add Interviewer(s)" icon for "Shortlisted" stage
    Then User should be able to see the text "Map Interviewer(s) to Stage" on lightbox
    Then User should be able to see the text "Select the interviewer(s) you wish to map to this stage" on lightbox
    Then User should be able to see the placeholder text "Select Interviewer(s)" on lightbox
    And User selects first interviewer from lightbox dropdown
    Then User should be able to see the placeholder text "Selected 1 Interviewer(s)" on lightbox

  @id:6 @RenameHM @RMS 
  Scenario: Verify that the add hiring manager is changed to add interviewer while mapping interviewer for selection stages for group without interview(s)
    Given I am logged in with "Enterprise" user "superuser1"
    When I navigate to Settings page
    And user click on "Manage Groups " link
    And user click on "Add Group" link
    And user fill mandatory field to add group
    And user click on "SAVE" button
    And user click on "Continue" link
    Then verify user is navigated to Manage Groups Page
    When user click on "Selection Stages" link
    Then User verify "Add Interviewer(s)" title is present for add interviewer icon for "Shortlisted" stage
    When User click on "Add Interviewer(s)" icon for "Shortlisted" stage
    Then User should be able to see the text "Map Interviewer(s) to Stage" on lightbox
    And User should be able to see the text "No Interviewer(s) in the system. Please add Interviewer(s) to map them to pipeline stages." on lightbox

  @id:7 @RenameHM @RMS 
  Scenario: Verify that the add hiring manager is changed to add interviewer while mapping interviewer for selection stages for requirement with no group mapped
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "rmsDashboardPage" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
		And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And Verify User redirected to requirement overview page
    When User click on the tab "Selection Stages" on requirement overview page
    Then User verify "Add Interviewer(s)" title is present for add interviewer icon for "Shortlisted" stage
    When User click on "Add Interviewer(s)" icon for "Shortlisted" stage
    Then User should be able to see the text "Map Interviewer(s) to Stage" on lightbox
    And User should be able to see the text "You can not add Interviewer(s) to this stage. Please select a valid Group for this Requirement to add Interviewer(s)." on lightbox

  @id:8 @RenameHM @RMS
  Scenario: Verify that the add hiring manager is changed to add interviewer while mapping interviewer for selection stages for requirement with no iterviewer(s) in group
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "rmsDashboardPage" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
		And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User fills in the "AutomationGroupWithNoHM" as the group attached to the requirement
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And Verify User redirected to requirement overview page
    When User click on the tab "Selection Stages" on requirement overview page
    Then User verify "Add Interviewer(s)" title is present for add interviewer icon for "Shortlisted" stage
    When User click on "Add Interviewer(s)" icon for "Shortlisted" stage
    Then User should be able to see the text "Map Interviewer(s) to Stage" on lightbox
    Then User should be able to see the text "No Interviewer(s) in the system. Please add Interviewer(s) to map them to pipeline stages." on lightbox

  @id:9 @RenameHM @RMS 
  Scenario: Verify that the add hiring manager is changed to add interviewer while mapping interviewer for selection stages for requirement with iterviewer(s) in group
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "rmsDashboardPage" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
		And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And User fills in the "AutomationWithNoApprovalProcess" as the group attached to the requirement
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And Verify User redirected to requirement overview page
    When User click on the tab "Selection Stages" on requirement overview page
    Then User verify "Add Interviewer(s)" title is present for add interviewer icon for "Shortlisted" stage
    And User click on "Add Interviewer(s)" icon for "Shortlisted" stage
    Then User should be able to see the text "Map Interviewer(s) to Stage" on lightbox
    Then User should be able to see the text "Select the interviewer(s) you wish to map to this stage" on lightbox
    Then User should be able to see the placeholder text "Select Interviewer(s)" on lightbox
    And User selects first interviewer from lightbox dropdown
    Then User should be able to see the placeholder text "Selected 1 Interviewer(s)" on lightbox

  @id:10 @RenameHM @RMS 
  Scenario: Verify that the manage interviewer(s) in displayed on settings page for CTC visibility settings
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When I navigate to Settings page
    Then User should be able to see link with name "Manage Hiring Managers/Interviewers"
    And User should be able to see text "View and edit Hiring Managers/Interviewers details"
    When user click on "CTC Visibility Settings" link
    And I turn "off" CTC Visibility toggle bar
    Then User should be able to see the text "If this setting is OFF, CTC details will be hidden from all Interviewer(s)." on lightbox
    When I turn "on" CTC Visibility toggle bar
    Then User should be able to see the text "Selecting this option will display the Applicant CTC details to all Hiring Managers and Interviewers." on lightbox
    And User click on CTC Visibility drop down
    Then User should be able to see the text "All Hiring Managers and Interviewers" on lightbox
    And User should be able to see the text "Only Hiring Managers" on lightbox
    When User selects "Only Hiring Managers" from drop down
    Then User should be able to see the text "Selecting this option will display the Applicant CTC details to only the Hiring Managers." on lightbox

  @id:11 @RenameHM @RMS 
  Scenario: Verify that the text is changed in feedback visibilty lightbox
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When I navigate to Settings page
    And user click on "Feedback Visibility Settings" link
    When User turn "off" Feedback Visibility Settings
    Then User should be able to see the text "Feedback not visible to other Interviewer(s)" on lightbox
    And User should be able to see the text "Choose whether the feedback given by one Interviewer against a candidate should be visible to other Interviewers mapped to the requirement" on lightbox
    And User should be able to see the text "NOTE: Feedback given by an Interviewer is always visible to all Recruiters and the Hiring Manager mapped to the requirement." on lightbox
    When User turn "on" Feedback Visibility Settings
    Then User should be able to see the text "Feedback visible to all Interviewer(s)" on lightbox
    And User should be able to see the text "NOTE: Feedback given by an Interviewer is always visible to all Recruiters and the Hiring Manager mapped to the requirement." on lightbox

  @id:12 @RenameHM @RMS 
  Scenario: Verify that the text is changed from hmspoc to hiring manager
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And I navigate to Settings page
    When user click on "Hiring Manager reports visibility settings " link
    Then User should be able to see the text "Hiring manager reports visibility settings" on lightbox
    And User should be able to see the text "Choose the reports which will be visible to all Hiring managers in the organization" on lightbox
    And User should be able to see the text "Track the conversion ratio at each hiring stage" on lightbox
    And User should be able to see the text "Access hiring speed over time and identify the bottlenecks in pipeline" on lightbox
    And User should be able to see the text "Track the status of requisitions raised by hiring manager" on lightbox
    And User should be able to see the text "Access turnaround time from requisition raised to hiring stages" on lightbox
    And User should be able to see the text "Track the activities done by hiring managers/interviewers" on lightbox
    And User should be able to see the text " report to hiring manager" on lightbox
    And User should not be able to see the text " report to hiring manager spoc" on lightbox

  @id:13 @RenameHM @RMS 
  Scenario: Verify that the text is changed from hrspoc to hiring manager
    Given I am logged in with "Enterprise" user "superuser1"
    When I navigate to Settings page
    And user click on "Manage Hiring Managers/Interviewers" link
    Then User should be able to see the text "Hiring Managers/Interviewers" on lightbox
    And User should be able to see the text "Manage hiring managers/interviewers" on lightbox
    When user click on "Edit" button for "ankur.1@naukri.com"
    Then User should be able to see the text "     Hiring Manager/Interviewer  " on lightbox

  @id:14 @RenameHM @RMS
  Scenario: To verify error message text change when user creates requirement from requisition raised from group in which Hiring Manager is removed
    Given I am logged in with "Enterprise" user "superuser1"
    When I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    Then Verify that Group name is displayed on manage group page
    And refresh the page
    And User click on "Selection Stages" stage mapping button
    And I map "MansiHM" to "Prospect" stage
    And User map "Feedback Automation" feedback form to "Prospect" state
     And User is on "settingsPage" page
    And I turn "off" Requisition Approval Mandatory toggle bar
    And I logout
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process
    And I logout
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "settingsPage" page
    And user click on "Manage Groups " link
    And User click on Edit link under group
    And User edit the group and "Remove" HMSpoc "MansiHM" from group
    And user click on "SAVE" button
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    When I create requirement for raised requisition
    Then user should be able to see the label " Requirement can’t be created from this requisition as hiring manager has been removed from the group"

  @id:15 @RenameHM @RMS 
  Scenario: Verify that on requirement creation page text is changed from Hiring Manage Spoc to Hiring Manager
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "rmsDashboardPage" page
    When User select a "Add A New Requirement" from "Requirements" option
    Then user should be able to see the label "Hiring Manager:  "
    And user should be able to see the label "The Selected user will be the Hiring Manager for this requirement."
    And User should be able to see text "No Hiring Manager Selected"
    When User fills in the "AutomationGroupWithNoHM" as the group attached to the requirement
    Then User should be able to see text "Select Hiring Manager"

  @id:16 @RenameHM @RMS 
  Scenario: Verify that on requirement creation page text is changed from Hiring Manage Spoc to Hiring Manager on editing requirement
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "requirementInbox" page
    And User click on top requirement name
    When User click on the tab "Edit" on requirement overview page
    Then user should be able to see the label "Hiring Manager:  "
    Then user should be able to see the label "The Selected user will be the Hiring Manager for this requirement."

  @id:17 @RenameHM @RMS 
  Scenario: Verify that Hiring Manager SPOC is renamed to Hiring Manager under Requirement Details for recruiter for requirement created from requisition
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with no approval process for "AutomationWithNoApprovalProcess" group
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    When I create requirement for raised requisition
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    When User click on the tab "Requirement Details" on requirement overview page
    Then user should be able to see the label "Hiring Manager"

  @id:18 @RenameHM @RMS 
  Scenario: Verify that Hiring Manager SPOC is renamed to Hiring Manager under Requirement Details for recruiter for requirement created from requisition
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "rmsDashboardPage" page
    And User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
		And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi"
    And User fills in the "AutomationWithNoApprovalProcess" as the group attached to the requirement
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    When User click on the tab "Requirement Details" on requirement overview page
    Then user should be able to see the label "Hiring Manager"

  @id:19 @RenameHM @RMS 
  Scenario: Verify that Hiring Manager SPOC is renamed to Hiring Manager under Requirement Details and Requisition Details section for interviewer
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "requirementInbox" page
    And User click on top requirement name
    And User navigates to requirement overview page if directed to requirement inbox
    When User click on the tab "Requirement Details" on requirement overview page
    Then user should be able to see the label "Hiring Manager"

  @id:20 @RenameHM @notification @RMS 
  Scenario: Verify that text is changed from HM Spoc to HM when HM is removed from requirement mapped with group
    Given I am logged in with "Enterprise" user "superuser1"
    And I create group with below as HR, HRSpoc, HM, HMSpoc
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    And User created a requirement which is mapped with no approval group
    And User click on the tab "Edit" on requirement overview page
    And User fills in the "AutomationGroupWithNoHM" as the group attached to the requirement
    And User click on "Next" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    When User is on "rmsDashboardPage" page
    And User verify text of notification for HM removed for requirement
    When User click on received notification for HM Removal for requirement
    Then User should be able to see text " Hiring manager has been removed from this requirement.  "

  @id:21 @RenameHM @notification @RMS 
  Scenario: Verify that text is changed from HM Spoc to HM when HM is removed from group stage and feedback is pending
    Given I am logged in with "Enterprise" user "superuser1"
    And I create group with below as HR, HRSpoc, HM, HMSpoc
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    And I map "MansiHM" to "Prospect" stage
    And User map "Feedback Automation" feedback form to "Prospect" state
    And User created a requirement which is mapped with no approval group
    And I added a single profile in requirement
    And I move profile on "Prospect" stage
    And User is on "settingsPage" page
    And user click on "Manage Groups " link
    And User click on "Selection Stages" link under group for created group
    And User click on "Add Interviewer(s)" icon for "Prospect" stage
    And User click on "MansiHM" from add interviewer dd
    And user click on "Save" button
    When User is on "rmsDashboardPage" page
    Then User verify text of notification for HM removed for "Prospect" group stage
    When User click on received notification for HM Removal for "Prospect" group stage
    Then User should be able to see text " Interviewer has been removed from the 'Prospect' group stage. Refer the list of profiles whose feedback is pending from interviewer. Remove the interviewer from requirement to restrict visibility of new profiles added to that requirement.  "
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And I am on Pending Reviews Feed page for "Prospect" stage
    And Verify application is displayed
    And User clicks on Give Feedback button for given emailId
    And User click on "Approve" state
    And User fills feedback form
    And User click on "Submit Feedback" button from feedback form lightbox
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    When User is on "rmsDashboardPage" page
    Then User verify text of notification for HM removed for "Prospect" group stage
    When User click on received notification for HM Removal for "Prospect" group stage
    Then User should be able to see text " Interviewer has been removed from the 'Prospect' group stage. No feedback is pending from the interviewer. Remove the interviewer from requirement stage to restrict visibility of new profiles added to that requirement.  "

  @id:22 @RenameHM @RMS 
  Scenario: Verify that the label is changed in view reports
    Given I login into RMS as an "Enterprise" user
    And I am on Reports page
    When I click on "Recruiter" report
    And User click on "Show More Filters (8)"
    Then User should be able to see text "Select Hiring Managers/Interviewers"
    And User should be able to see the placeholder text "Select Hiring Managers/Interviewers" on lightbox
    And I am on Reports page
    When I click on "Requirement" report
    And User click on "Show More Filters (8)"
    Then User should be able to see text "Select Hiring Managers/Interviewers"
    And User should be able to see the placeholder text "Select Hiring Managers/Interviewers" on lightbox
    And I am on Reports page
    When I click on "Group Wise" report
    And User click on "Show More Filters (8)"
    Then User should be able to see text "Select Hiring Managers/Interviewers"
    And User should be able to see the placeholder text "Select Hiring Managers/Interviewers" on lightbox

  @id:23 @RenameHM @RMS 
  Scenario: Verify that Hiring Manager is replaced with interviewers in info icon for Hiring Manager Activity Report
    Given I am logged in with "Enterprise" user "subuser1"
    And User goes to the "Dashboard" Report
    And User reload "Hiring Manager Activity" report if error
    When User hovers on the info icon against the "Hiring Manager Activity" Report on Dashboard
    Then User should be able to see text "Stay abreast with activities done by or pending at the hiring managers/interviewers."

  @id:24 @RenameHM @RMS 
  Scenario Outline: Verify that Attach Hiring Manager Feedback is changed to  Attach feedback received so far  in forward flow on all srp
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "<inboxPage>" page
    And I should be able to see the forward option
    When I click on the forward option
    Then User should be redirected to the forward lightbox
    Then user should be able to see the label " Attach feedback received so far "
    And User fills in to field as "testacount@yopmail.com"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User select  Attach feedback received so far checkbox
    When User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."
    #Manual Steps
    #Then Verify that in excel received in mail sheet name is "InterviewerFeedback"
    #Then Verify that in excel received in mail "Interviewer" column is present
    #Then Verify that in excel received in mail "Hiring Manager" column is not present
    Examples: 
      | inboxPage           |
      | applicationInbox    |
      | profileListingInbox |
      | backupInboxPage     |

  @id:25 @RenameHM @RMS 
  Scenario: Verify that Attach Hiring Manager Feedback is changed to Attach feedback received so far in forward flow on req inbox
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    Then I should be able to see the forward option
    When I click on the forward option for requirement inbox
    Then User should be redirected to the forward lightbox
    Then user should be able to see the label " Attach feedback received so far "
    And User fills in to field as "testacount@yopmail.com"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User select  Attach feedback received so far checkbox
    When User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."
	  #Manual Steps
	  #Then Verify that in excel received in mail sheet name is "InterviewerFeedback"
	  #Then Verify that in excel received in mail "Interviewer" column is present
	  #Then Verify that in excel received in mail "Hiring Manager" column is not present
  
  @id:26 @RenameHM @RMS 
  Scenario: Verify that Attach Hiring Manager Feedback is changed to Attach feedback received so far in forward flow on CV Detail page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the name of "35" in the candidate name
    And I fill in the email of the candidate
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    When User clicks on the forward option on candidate details page
    Then User should be redirected to the forward lightbox
    Then user should be able to see the label " Attach feedback received so far "
    When User fills in to field as "testacount@yopmail.com" for master profile forward
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User select  Attach feedback received so far checkbox
    When User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."
	  #Manual Steps
	  #Then Verify that in excel received in mail sheet name is "InterviewerFeedback"
	  #Then Verify that in excel received in mail "Interviewer" column is present
	  #Then Verify that in excel received in mail "Hiring Manager" column is not present
  
  @id:27 @RenameHM @RMS 
  Scenario: To verify that text is not changed under Select Approval Process while creating group or editing group
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And I navigate to Settings page
    And user click on "Manage Groups " link
    And user click on "Add Group" link
    And user click on "NEXT" button
    When user click on "NEXT" button
    Then user should be able to see the label "If you select multiple processes, Hiring Managers will have to choose one when raising a requisition"
    And I navigate to Settings page
    And user click on "Manage Groups " link
    When user click on "Edit" link
    And user click on "NEXT" button
    And user click on "NEXT" button
    Then user should be able to see the label "If you select multiple processes, Hiring Managers will have to choose one when raising a requisition"

  @id:28 @RenameHM @RMS 
  Scenario Outline: To verify that Hiring Manager text is changed to Interviewer(s) on Configure Automatic Mails to Candidates on Status Change page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "<user>" user
    And I navigate to Settings page
    When user click on "Automated Email Settings" link
    Then user should be able to see the label "Send mail with calendar invite to Interviewer(s) at interview stages where status change mails are automated"

    Examples: 
      | user          |
      | ProConsultant |
      | Enterprise    |

  @id:29 @RenameHM @RMS 
  Scenario: To verify that Forward To Hiring Manager Button's text is changed to Forward to Interviewer when automatic mailer to HM is unchecked
    Given I am logged in with "Enterprise" user "superuser1"
    And I navigate to Settings page
    And I remove Automatic mailer for "Interview-Round 1" stage.
    And User uncheck Automatic mailer to HM checbox in settings
    And I created a requirement which is mapped with created group
    And click on selection stage
    And I map "MansiHM" to "Interview - Round 1" stage
    And I added a single profile in requirement
    And User gets application id from CV Detail page
    And I move profile on "Interview - Round 1" stage
    And User provides InterviewDate as current date
    And User provides the Interview time as "10" hours and "00" minutes
    And User sets "PM" from AM PM dd
    And User fills in the interview venue as "Delhi"
    When User click on set Interview
    Then Verify that "Forward To Interviewer" button is displayed for application
    And I move profile on "Prospect" stage
    And User select a "All Requirements" from "Requirements" option
    And User click on count against created requirement
    And User click on status dropdwon.
    And User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    When User click on "Set" link
    Then Verify that "Forward To Interviewer" button is displayed for application

  @id:30 @RenameHM @RMS 
  Scenario: To verify that Forward To Hiring Manager Button's text is changed to Forward to Interviewer when automatic mailer to HM is checked
    Given I am logged in with "Enterprise" user "superuser1"
    And I navigate to Settings page
    And I create group with below as HR, HRSpoc, HM, HMSpoc
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    And I navigate to Settings page
    And I remove Automatic mailer for "Interview-Round 1" stage.
    And User check Automatic mailer to HM checbox in settings
    And User created a requirement which is mapped with no approval group
    And click on selection stage
    And I map "MansiHM" to "Interview - Round 1" stage
    And I added a single profile in requirement
    And User gets application id from CV Detail page
    And I move profile on "Interview - Round 1" stage
    And User provides InterviewDate as current date
    And User provides the Interview time as "10" hours and "00" minutes
    And User sets "PM" from AM PM dd
    And User fills in the interview venue as "Delhi"
    When User click on set Interview
    Then user should be able to see the label "Application status has been successfully changed to Interview - Round 1. Mail with invite has been sent to all mapped interviewers at this stage."
    And I move profile on "Prospect" stage
    And User select a "All Requirements" from "Requirements" option
    And User click on count against created requirement
    And User click on status dropdwon.
    And User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    When User click on "Set" link
    Then user should be able to see the label "Application status has been successfully changed to Interview - Round 1. Mail with invite has been sent to all mapped interviewers at this stage."

  @id:31 @RenameHM @RMS 
  Scenario Outline: Verify that Attach Hiring Manager Feedback is changed to Attach feedback received so far in download flow on all srp for Selected Resumes
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User is on "<inboxPage>" page
    And User select the first candidate checkbox
    Then I should be able to see the download drop down
    When I click on download drop down
    Then I must be able to see "Selected Resumes" and "Index Range"
    When I click on the "Selected Resumes" option
    Then user should be able to see the label "Attach feedback received so far"
    #Manual Steps
    #And User select  Attach feedback received so far checkbox
    #When user click on "Download" button
    #Then Verify that in excel received in mail sheet name is "InterviewerFeedback"
    #Then Verify that in excel received in mail "Interviewer" column is present
    #Then Verify that in excel received in mail "Hiring Manager" column is not present
    Examples: 
      | inboxPage           |
      | applicationInbox    |
      | profileListingInbox |
      | backupInboxPage     |

  @id:32 @RenameHM @RMS 
  Scenario Outline: Verify that Attach Hiring Manager Feedback is changed to Attach feedback received so far in download flow on all srp for Indexed Resumes
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User is on "<inboxPage>" page
    And User select the first candidate checkbox
    Then I should be able to see the download drop down
    When I click on download drop down
    Then I must be able to see "Selected Resumes" and "Index Range"
    And I click on the "Index Range" option
    Then user should be able to see the label "Attach feedback received so far"

    Examples: 
      | inboxPage           |
      | applicationInbox    |
      | profileListingInbox |
      | backupInboxPage     |

  @id:33 @RenameHM @RMS 
  Scenario: Verify that Attach Hiring Manager Feedback is changed to Attach Feedback Received So Far in forward flow on req inbox
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And User select the first candidate checkbox
    Then I should be able to see the download drop down
    When I click on download drop down
    Then I must be able to see "Selected Resumes" and "Index Range"
    And I click on the "Selected Resumes" option
    Then user should be able to see the label "Attach feedback received so far"
	  #Manual Steps
	  #And User select  Attach feedback received so far checkbox
	  #When user click on "Download" button
	  #Then Verify that in excel received in mail sheet name is "InterviewerFeedback"
	  #Then Verify that in excel received in mail "Interviewer" column is present
	  #Then Verify that in excel received in mail "Hiring Manager" column is not present
	  
  @id:34 @RenameHM @notification @RMS 
  Scenario: To verify text change on removal of HM from group mapped with requirement with HM feedback pending
    Given I am logged in with "Enterprise" user "superuser1"
    And I create group with below as HR, HRSpoc, HM, HMSpoc
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    And user click on "Continue" link
    Then verify user is navigated to Manage Groups Page
    When user click on "Selection Stages" link
    And I map "MansiHM" to "Shortlisted" stage
    And User map "Feedback Automation" feedback form to "Shortlisted" state
    And User created a requirement which is mapped with no approval group
    And I added a single profile in requirement
    And I move profile on "Shortlisted" stage
    And refresh the page
    And user click on "Send Reminder" link
    And User is on "settingsPage" page
    And user click on "Manage Groups " link
    And User click on "Edit" link under group for created group
    When User edit the group and "Remove" HMSpoc "MansiHM" from group
    And user click on "SAVE" button
    Then User should be able to see the text "Removed Interviewer(s) have 1 feedback(s) pending" on lightbox
    Then User should be able to see the text "Removing interviewer(s) will only impact the group level information. Recruiters need to remove the interviewer from requirement to restrict visibility of new profiles added to that requirement. Recruiters will be notified about the change." on lightbox
    Then User should be able to see the text "Save interviewer(s)" on lightbox
    When user click on "Save interviewer(s)" button
    When User is on "rmsDashboardPage" page
    Then User verify text of notification for HM removed for group
    When User click on received notification for HM Removal for group
    Then User should be able to see the info with text " Interviewer has been removed from the '" group name "' group. Refer the list of requirement(s) visible to interviewer. Remove the interviewer from requirement to restrict visibility of new profiles added to that requirement.  "
    And User select a "All Requirements" from "Requirements" option
    And User clicks on created requirement name with no approval process group
    When User click on the tab "Edit" on requirement overview page
    And User fills in the "AutomationGroupWithNoHM" as the group attached to the requirement
    And User click on "Next" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    When User is on "rmsDashboardPage" page
    Then User verify text of notification for HM removed for group
    When User click on received notification for HM Removal for group
    Then User should be able to see the info with text " Interviewer has been removed from the '" group name "' group. There is no requirement visible to the interviewer.  "

  @id:35 @RenameHM @notification @RMS 
  Scenario: To verify text change on removal of Interviewers from group when feedback is pending from Manage Hiring Manager/Interviewer page
    Given I am logged in with "Enterprise" user "superuser1"
    And I create group with below as HR, HRSpoc, HM, HMSpoc
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    And I map "MansiTest" to "Shortlisted" stage
    And User map "Feedback Automation" feedback form to "Shortlisted" state
    And User created a requirement which is mapped with no approval group
    And I added a single profile in requirement
    And I move profile on "Shortlisted" stage
    And refresh the page
    And user click on "Send Reminder" link
    And User is on "settingsPage" page
    And user click on "Manage Hiring Managers/Interviewers" link
    And user click on "Edit" button for "Test.bug@YOPMAIL.COM"
    And user click on Group dropdown
    And user type group name and click on group name
    When user click on save button on lb
    #Then I should be able to see the lightbox with title "Interviewer has 1 feedback(s) pending in removed group(s)"
    #Then User should be able to see the text "Recruiters need to remove the interviewer from requirement to restrict visibility of new profiles added to that requirement. Recruiters will be notified about the change" on lightbox
    #When User click on "Save interviewer(s)" button
    And User is on "rmsDashboardPage" page
    Then User verify text of notification for HM removed for group
    When User click on received notification for HM Removal for group
    Then User should be able to see the info with text " Interviewer has been removed from the '" group name "' group. Refer the list of requirement(s) visible to interviewer. Remove the interviewer from requirement to restrict visibility of new profiles added to that requirement.  "
    And User select a "All Requirements" from "Requirements" option
    And User clicks on created requirement name with no approval process group
    When User click on the tab "Edit" on requirement overview page
    And User fills in the "AutomationGroupWithNoHM" as the group attached to the requirement
    And User click on "Next" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    When User is on "rmsDashboardPage" page
    Then User verify text of notification for HM removed for group
    When User click on received notification for HM Removal for group
    Then User should be able to see the info with text " Interviewer has been removed from the '" group name "' group. There is no requirement visible to the interviewer.  "

  @id:36 @Rename @RMS 
  Scenario: Verify that on create feedback form no text is changed
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "settingsPage" page
    And User click on "Manage Feedback Forms" link
    When User click on "Create Feedback Form" button
    Then user should be able to see the label "These questions will be answered by the Hiring Manager/Interviewer after interview with the candidate"
    And User is on "settingsPage" page
    When User click on "Add New Feedback Form" link
    Then user should be able to see the label "These questions will be answered by the Hiring Manager/Interviewer after interview with the candidate"
 
  #@id:37 @RenameHM @manual @wip
  #Scenario: To verify that in mail received by requisition approver Hiring Manager Spoc is changed to Hiring Manager
    #Given I am logged in with "Enterprise" user "superuser1"
    #And I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      #| HR          | HRSpoc      | HM        | HMSpoc  |
      #| Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      #| MansiHR     | NA          | MansiTest | NA      |
    #And Verify that Group name is displayed on manage group page
    #And I logout
    #And I am logged in with "Enterprise" user "hiringmanager1"
    #And User is on "RMSRaiseRequisition" page
    #And HM Spoc creates requisition with approval process
    #And user click on "Send Reminder" for raised requisition
    #And I logout
    #And User opens approver mail
    #When user click on approval mail received
    #Then user is able to see "Hiring Manager" in footer
    #Then user does not see "Hiring Manager SPOC" in footer
    #When user click on approval mail reminder received
    #Then user is able to see "Hiring Manager" in footer
    #Then user does not see "Hiring Manager SPOC" in footer
    #And user "Rejects" requisition
    #And I am logged in with "Enterprise" user "hiringmanager1"
    #And User is on "RMSRequisitionList" page
    #And User "Reintiate" requisition
    #And I logout
    #And user opens HRSpoc mail
    #When user clicks on New Requisition raised mail
    #Then user is able to see "Hiring Manager" in footer
    #Then user does not see "Hiring Manager SPOC" in footer
    #When user click on "Track Requisition" from mail
    #Then user sees "Unable to display Approval details as the Requisition has been re-initiated by the Hiring Manager.You will be able to view this page once the requisition comes to you for Approval."
    #When user click on "View More Details" from mail
    #Then user sees "Unable to display Approval details as the Requisition has been re-initiated by the Hiring Manager.You will be able to view this page once the requisition comes to you for Approval."
