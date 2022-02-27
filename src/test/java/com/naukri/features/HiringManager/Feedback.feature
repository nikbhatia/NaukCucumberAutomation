Feature: Feedback in hiring manager

  @id:0 @HMRequisition @RMS @Feedback
  Scenario: Verify that user is able to create a group in which user map HRSpoc, HMSpoc, HRs, HMs and requisition approval process and turn off Approval mandatory button
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

  @id:1 @HMRequisition @RMS @Feedback
  Scenario: Number dispalyed for Pending Feeback of a sub stage of Pipeline Stage on dashboard must be same as the number displayed for Pending Reviews Feed page of substage.
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And I am on Pending Reviews Feed page for a particular sub stage
    And I check the count of pending feedback on page
    And User navigates to "hiringManagerDashboard" page
    And refresh the page
    When I checked the count of pending review for a particular sub stage
    Then Verify count on dashboard for pipeline stage is same as on pending feedback page

  @id:2 @HMRequisition @RMS @Feedback
  Scenario: Number dispalyed for Pending Reviews on dashboard must be same as the number displayed for Pending Reviews Feed page of particular stage.
    Given I am logged in with "Enterprise" user "superuser1"
    And I created a requirement which is mapped with created group
    And I added a single profile in requirement
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    When I am on Pending Reviews Feed page for a first pipeline stage
    Then Verify application is displayed
    And I check the count of pending feedback on page
    And User navigates to "hiringManagerDashboard" page
    And refresh the page
    When I checked the count of pending review for a particular stage
    Then Verify count on dashboard for pipeline stage is same as on pending feedback page

  @id:3 @HMRequisition @RMS @Feedback @Smoke
  Scenario: To approve candidate by giving feedback on a particular Stage under Pipeline Stage on dashboard and check that feedback button is not visible after giving feedback.
    			To check that comment count increases and feedback comment is visible for that application.
    			To check that feedback given by HM is displayed on cv detail page of candidate

    Given I am logged in with "Enterprise" user "superuser1"
    And I created a requirement which is mapped with created group
    And User click on the tab "Selection Stages" on requirement overview page
    And User map "Feedback Automation" feedback form to "Prospect" state
    And I added a single profile in requirement
    And User gets application id from CV Detail page
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And I am on Pending Reviews Feed page for a first pipeline stage
    And Verify application is displayed
    And I checked the comment count for first application
    And User clicks on Give Feedback button for given emailId
    And User click on "Approve" state
    And User fills feedback form
    And User click on "Submit Feedback" button from feedback form lightbox
    And User is on "requirementInbox" page
    When User click on count displayed against requirement
    Then Verify application is displayed
    And Verify Give Feedback dd is not displayed on SRP page
    Then I see "Approved" is appended before the stage name
    Then I see that the comment count for same application is increased by one
    And I see that the comment given during feedback is displayed
    And I see that the star rating given during feedback is displayed
    When I click on application name
    Then I verify that feedback is displayed for that stage with "Approved" label
    And I verify that " by You" is displayed in place of name of approver
    And refresh the page
    And I verify that current stage is "Approved - Prospect"

  @id:4 @HMRequisition @RMS @Feedback @Smoke
  Scenario: Verify that application on which feedback is not pending are not displayed to HM Spoc or HM
    Given I am logged in with "Enterprise" user "superuser1"
    And I created a requirement which is mapped with created group
    And I added a single profile in requirement
    And I move profile on "Shortlisted" stage
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager2"
    And User is on "hiringManagerDashboard" page
    When I am on Pending Reviews Feed page for "Shortlisted" stage
    Then Verify application is not displayed
    When User is on "requirementInbox" page
    Then Verify created requirement is not displayed
    And I close current tab and switch to parent tab
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    When I am on Pending Reviews Feed page for "Shortlisted" stage
    Then Verify application is not displayed
    When User is on "requirementInbox" page
    Then Verify created requirement is displayed
    When User click on count displayed against requirement
    Then Verify application is displayed
    And Verify Give Feedback dd is not displayed on SRP page

  @id:5 @HMRequisition @RMS @Feedback
  Scenario: Verify that application pending for feedback is displayed on Dashboard and All pending reviews page for non interview stage
    Given I am logged in with "Enterprise" user "superuser1"
    And I created a requirement which is mapped with created group
    And I added a single profile in requirement
    And User gets application id from CV Detail page
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And User click on count for "Pending Reviews"
    Then Verify application is displayed
    And User is on "hiringManagerDashboard" page
    Then Verify that give feedback dd is displayed for application id

  @id:6 @HMRequisition @RMS @Feedback
  Scenario: Verify that for application on which interview is scheduled is displayed under upcoming interviews and option to give feedback is also present
    			Verify that application is not displayed anymore under Upcoming interview after feedback is provided.

    Given I am logged in with "Enterprise" user "superuser1"
    And I created a requirement which is mapped with created group
    And click on selection stage
    And I map "MansiHM" to "Interview - Round 1" stage
    And refresh the page
    And click on selection stage
    And User map "Feedback Automation" feedback form to "Interview - Round 1" state
    And I added a single profile in requirement
    And User gets application id from CV Detail page
    And I move profile on "Interview - Round 1" stage
    And User provides Interview Date as next month's day one
    And User provides the Interview time as "10" hours and "00" minutes
    And User sets "PM" from AM PM dd
    And User fills in the interview venue as "Delhi"
    And User click on set Interview
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    Then Verify application is displayed under Upcoming Interview section
    And User get count of Upcoming Interview from dashboard
    When User clicks application under upcoming interview from dashboard
    And Verify Give Feedback dd is present on CV Deatil page
    And User click on Give Feedback dd for top application
    And User click on "Approve" state
    And User fills feedback form
    And User click on "Submit Feedback" button from feedback form lightbox
    When User is on "requirementInbox" page
    When User click on count displayed against requirement
    And Verify Give Feedback dd is not displayed on SRP page
    And I verify that current stage for given application id is "Approved - Interview - Round 1" from SRP
    When User is on "hiringManagerDashboard" page
    Then Verify that current count of Upcoming Interview is one less than count before giving feedback
    And Verify that the the candidate is not displayed count under section Upcomimg Interviews

  @id:7 @HMRequisition @RMS @Feedback
  Scenario: Verify that after giving feedback from pending review page that application is not displayed on page anymore
    Given I am logged in with "Enterprise" user "superuser1"
    And I created a requirement which is mapped with created group
    And I added a single profile in requirement
    And User gets application id from CV Detail page
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    When I am on Pending Reviews Feed page for a first pipeline stage
    Then Verify application is displayed
    And User clicks on Give Feedback button for given emailId
    And User click on "Approve" state
    And User fills feedback form
    And User click on "Submit Feedback" button from feedback form lightbox
    Then Verify application is not displayed

  @id:8 @HMRequisition @RMS @Feedback
  Scenario: Verify that count of summation of all pending reviews from pipeline is equal to count of pending reviews
    And I am logged in with "Enterprise" user "hiringmanager2"
    And User is on "hiringManagerDashboard" page
    When User do summation of all numbers corresponding to pipeline stages
    And User get count of Pending Reviews
    Then Verify that count of summation of pipeline stage and All pending review is same

  @id:9 @HMRequisition @RMS @Feedback
  Scenario: Verify that states added in feedback form is displayed under Give Feedback dd
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "settingsPage" page
    And User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    And User deletes all questions
    And User adds a question of "Single Choice " type
    And User click on "Add another option" button on form
    When User fills "Feedback Form State Seven" as state name
    And User click on "Add another option" button on form
    When User fills "CustomState123" as state name
    And User fills feedback form name
    When User click on "SAVE" button on form
    When I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    Then Verify that Group name is displayed on manage group page
    And refresh the page
    And User click on "Selection Stages" stage mapping button
    And I map "MansiHM" to "Prospect" stage
    And User map created feedback form to "Prospect" stage
    And I created a requirement which is mapped with created group
    And I added a single profile in requirement
    And I move profile on "Prospect" stage
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And I am on Pending Reviews Feed page for "Prospect" stage
    And Verify application is displayed
    When User clicks on Give Feedback button for given emailId
    Then Verify that "CustomState123" state is displayed in Give Feedback dd
    And Verify that "Feedback Form State Seven" state is displayed in Give Feedback dd
    And Verify that "Approve" state is displayed in Give Feedback dd
    And Verify that "Reject" state is displayed in Give Feedback dd

  @id:10 @HMRequisition @RMS @Feedback
  Scenario: Verify that feedback is submitted when No question is mapped on state
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "settingsPage" page
    And User click on "Manage Feedback Forms" link
    And User click on "Create Feedback Form" button
    And User deletes all questions
    And User fills feedback form name
    When User click on "SAVE" button on form
    When I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    Then Verify that Group name is displayed on manage group page
    And refresh the page
    And User click on "Selection Stages" stage mapping button
    And I map "MansiHM" to "Prospect" stage
    And User map created feedback form to "Prospect" stage
    And I created a requirement which is mapped with created group
    And I added a single profile in requirement
    And I move profile on "Prospect" stage
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And I am on Pending Reviews Feed page for "Prospect" stage
    And Verify application is displayed
    When User clicks on Give Feedback button for given emailId
    When User click on "Approve" state
    Then Verify give feedback lightbox is not displayed
    And User is on "requirementInbox" page
    When User click on count displayed against requirement
    Then Verify application is displayed
    When I click on application name
    And I verify that current stage is "Approved - Prospect"

  @id:11 @Feedback @HMRequisition @RMS 
  Scenario: Verify that Change Feedback button is displayed only to HM who submits feedback and not to other HM
    Given I am logged in with "Enterprise" user "superuser1"
    And I created a requirement which is mapped with created group
    And click on selection stage
    And I map "MansiTest" to "Prospect" stage
    And User map "Feedback Automation" feedback form to "Prospect" state
    And I added a single profile in requirement
    And I logout
    When I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And I am on Pending Reviews Feed page for "Prospect" stage
    And Verify application is displayed
    And User clicks on Give Feedback button for given emailId
    And User click on "Reject" state
    And User fills feedback form
    And User click on "Submit Feedback" button from feedback form lightbox
    And User is on "requirementInbox" page
    When User click on count displayed against requirement
    Then Verify application is displayed
    Then Verify Give Feedback dd is not displayed on SRP page
    Then Verify that "Change Feedback" button is displayed for application
    When I click on application name
    And Verify that " Give Feedback " button is not displayed for application
    And Verify that "Change Feedback" button is displayed for application
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager2"
    And User is on "requirementInbox" page
    When User click on count displayed against requirement
    Then Verify application is displayed
    Then Verify Give Feedback dd is not displayed on SRP page
    Then Verify that "Change Feedback" button is not displayed for application
    When I click on application name
    And Verify that " Give Feedback " button is not displayed for application
    And Verify that "Change Feedback" button is not displayed for application

  @id:12 @Feedback @HMRequisition @RMS 
  Scenario: Verify that when user click on save for later then 'Feedback saved as draft' text, 'Complete Feedback' and 'Discard Draft' button are displayed only to HM who saved draft
    Given I am logged in with "Enterprise" user "superuser1"
    And I created a requirement which is mapped with created group
    And click on selection stage
    And I map "MansiTest" to "Prospect" stage
    And User map "Feedback Automation" feedback form to "Prospect" state
    And I added a single profile in requirement
    And I logout
    When I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And I am on Pending Reviews Feed page for "Prospect" stage
    And Verify application is displayed
    And User clicks on Give Feedback button for given emailId
    And User click on "Reject" state
    And User fills feedback form
    When User click on "Save for Later" button from feedback form lightbox
    Then Verify that "Feedback saved as draft" button is displayed for application
    Then Verify that "Complete Feedback" button is displayed for application
    Then Verify that "Discard Draft" button is displayed for application
    And User is on "requirementInbox" page
    When User click on count displayed against requirement
    Then Verify application is displayed
    Then Verify Give Feedback dd is not displayed on SRP page
    Then Verify that "Feedback saved as draft" button is displayed for application
    Then Verify that "Complete Feedback" button is displayed for application
    Then Verify that "Discard Draft" button is displayed for application
    When I click on application name
    And Verify that " Give Feedback " button is not displayed for application
    Then Verify that "Feedback saved as draft" button is displayed for application
    Then Verify that "Complete Feedback" button is displayed for application
    Then Verify that "Discard Draft" button is displayed for application
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager2"
    And User is on "requirementInbox" page
    When User click on count displayed against requirement
    Then Verify application is displayed
    Then Verify that " Give Feedback " button is displayed for application
    Then Verify that "Feedback saved as draft" button is not displayed for application
    Then Verify that "Complete Feedback" button is not displayed for application
    Then Verify that "Discard Draft" button is not displayed for application
    When I click on application name
    And Verify that " Give Feedback " button is displayed for application
    Then Verify that "Feedback saved as draft" button is not displayed for application
    Then Verify that "Complete Feedback" button is not displayed for application
    Then Verify that "Discard Draft" button is not displayed for application

  @id:13 @Feedback @HMRequisition @RMS 
  Scenario: Verify that when Feedback Visibility Settings is off then interviewer other that then one who has given feedback does not see Assessment feedback section
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "settingsPage" page
    When I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    And Verify that Group name is displayed on manage group page
    And refresh the page
    And User click on "Selection Stages" stage mapping button
    And I map "MansiHM" to "Prospect" stage
    And I map "MansiTest" to "Prospect" stage
    And User map "Feedback Automation" feedback form to "Prospect" state
    And User is on "settingsPage" page
    And user click on "Feedback Visibility Settings" link
    And User turn "off" Feedback Visibility Settings
    And User save feedback visibility setting
    And I created a requirement which is mapped with created group
    And I added a single profile in requirement
    And I move profile on "Prospect" stage
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And I am on Pending Reviews Feed page for "Prospect" stage
    And Verify application is displayed
    And User clicks on Give Feedback button for given emailId
    And User click on "Approve" state
    And User fills feedback form
    And User click on "Submit Feedback" button from feedback form lightbox
    And User is on "requirementInbox" page
    And User click on count displayed against requirement
    And Verify application is displayed
    When I click on application name
    Then Verify Assessment section is displayed
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager2"
    And User is on "requirementInbox" page
    And User click on count displayed against requirement
    And Verify application is displayed
    When I click on application name
    Then Verify Assessment section is not displayed
    And Verify that " Give Feedback " button is not displayed for application
    And I verify that current stage is "Approved - Prospect"

  @id:14 @Feedback @HMRequisition @RMS 
  Scenario: Verify that when Feedback Visibility Settings is on then interviewer other that then one who has given feedback does see Assessment feedback section
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "settingsPage" page
    When I create group with below as HR, HRSpoc, HM, HMSpoc and Approval Process
      | HR          | HRSpoc      | HM        | HMSpoc  |
      | Mansi Gupta | Mansi Gupta | MansiHM   | MansiHM |
      | MansiHR     | NA          | MansiTest | NA      |
    And Verify that Group name is displayed on manage group page
    And refresh the page
    And User click on "Selection Stages" stage mapping button
    And I map "MansiHM" to "Prospect" stage
    And I map "MansiTest" to "Prospect" stage
    And User map "Feedback Automation" feedback form to "Prospect" state
    And User is on "settingsPage" page
    And user click on "Feedback Visibility Settings" link
    And User turn "on" Feedback Visibility Settings
    And User save feedback visibility setting
    And I created a requirement which is mapped with created group
    And I added a single profile in requirement
    And I move profile on "Prospect" stage
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And I am on Pending Reviews Feed page for "Prospect" stage
    And Verify application is displayed
    And User clicks on Give Feedback button for given emailId
    And User click on "Approve" state
    And User fills feedback form
    And User click on "Submit Feedback" button from feedback form lightbox
    And User is on "requirementInbox" page
    And User click on count displayed against requirement
    And Verify application is displayed
    When I click on application name
    Then Verify Assessment section is displayed
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager2"
    And User is on "requirementInbox" page
    And User click on count displayed against requirement
    And Verify application is displayed
    When I click on application name
    Then Verify Assessment section is displayed
    And Verify that " Give Feedback " button is not displayed for application
    And I verify that current stage is "Approved - Prospect"
    And I verify that " by MansiHM" is displayed in place of name of approver

  @id:15 @Feedback @HMRequisition @RMS @done
  Scenario: Verify that when attached feedback form is changed before submitting,save for later feedback, discard draft link is present on complete feedback form
  Given I am logged in with "Enterprise" user "superuser1"
    And User is on "rmsDashboardPage" page
    And User add a new requirment with "AutomationWithNoApprovalProcess" group
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And User click on the tab "Selection Stages" on requirement overview page
    And User map "Feedback Automation" feedback form to "Prospect" state
    And I added a single profile in requirement
    When User is on "requirementInbox" page
    Then Verify requirement name is displayed
    And User click on count against created requirement
    Then Verify application is displayed
    And User click on Give Feedback dd for top application
    And User click on "Approve" state
    And User fills feedback form
    And User click on "Save for Later" button from feedback form lightbox
    And User click on "Overview" link
    And User click on the tab "Selection Stages" on requirement overview page
    And User map "Default Feedback Form" feedback form to "Prospect" state
    When User is on "requirementInbox" page
    And User click on count against created requirement
    And User click on "Complete Feedback" button
    And user should be able to see the label "This Feedback form is outdated. Discard this and submit Feedback on the updated form."
    Then Verify that "Discard Draft" button is displayed for application
    When User click on "Discard Draft" button from feedback form lightbox
    Then user should be able to see the label "Are you sure you want to discard this draft?"
    And user should be able to see the label "Discarding the draft is an irreversible action"
    And Verify that "Discard Draft" button is displayed for application
    When User click on "Discard Draft" button on confirmation box
    Then Verify that " Give Feedback " button is displayed for application

  @id:16 @Feedback @HMRequisition @RMS @done
  Scenario: Verify that if stage is moved while feedback was pending then that application will not be displayed on pending review page
	Given I am logged in with "Enterprise" user "superuser1"
    And User is on "rmsDashboardPage" page
    And User add a new requirment with "AutomationWithNoApprovalProcess" group
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And User click on the tab "Selection Stages" on requirement overview page
    And I map "MansiHM" to "Prospect" stage
    And User map "Feedback Automation" feedback form to "Prospect" state
    And I added a single profile in requirement
    And I move profile on "Prospect" stage
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    When I am on Pending Reviews Feed page for "Prospect" stage
    Then Verify application is displayed
    And I logout
    And I am logged in with "Enterprise" user "superuser1"
    And User is on "requirementInbox" page
    And User click on count displayed against requirement
    And I click on application name
    And I move profile on "Shortlisted" stage
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    When I am on Pending Reviews Feed page for "Shortlisted" stage
    Then Verify application is not displayed
    And User is on "hiringManagerDashboard" page
    When I am on Pending Reviews Feed page for "Prospect" stage
    Then Verify application is not displayed
    
  @wip
  Scenario: To verify that all the filled details while giving feedback is displayed on CV Detail page under Assessment feedback section
    When I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And I am on Pending Reviews Feed page for "Prospect" stage
    And User click on Give Feedback dd for top application
    And User click on "Reject" state
    And User fill feedback form with saving questions whose answer is filled
    And User click on "Submit Feedback" button from feedback form lightbox
    When User is on "requirementInbox" page
    When User click on count displayed against requirement
    Then Verify application is displayed
    When I click on application name
    And User click on Assessment Section
    And Verify Submitted ques with answer is present
    
  @wip
  Scenario: Verify that when if recruiter rejects application from feedback then its count is increased under HM Feedback Rejected

