Feature: Advance interview scheduling

  Background: Adding profile to requirement and moving it to stage on which feedback is attached

  @AdvanceInterview @Settings
  Scenario: user is able to schedule interview without interviewer and opening editior
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And user select Requirement while adding a single profile
    And I click on Add Candidate button
    And user move an application to interview stage
    Then verify that user is able to see the listed headings on page
      | Interview Type                          |
      | Schedule Interview for                  |
      | No Interviewer added to this stage. Add |
      | Interviewers                            |
      | Interview Date                          |
      | Interview Time                          |
      | Interview Location                      |
      | Customize Emails                        |
      | Block My Calendar                       |
      | Notify Interviewers via email           |
      | Notify Candidate via email              |
    When user fill "Infoedge" location for scheduling interview
    And user "select" block calendar checkbox
    And user click on "Schedule Interview" button
    Then user should be able to see the label "Confirm"
    And user click on "Confirm" button
    Then verify success message "Face-To-Face"

  @AdvanceInterview @Settings
  Scenario: user is able to schedule interview while opening email editor for both candidate and interviewer
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And user select Requirement while adding a single profile
    And I click on Add Candidate button
    When user move an application to interview stage
    And user fill "Infoedge" location for scheduling interview
    And user open email editor of candidate
    Then user should be able to see the label "Block calendar of candidate"
    When user click on "Schedule Interview" button
    Then user should be able to see the label "Interview Invite will be sent to -"
    And user click on "Confirm" button
    Then verify success message "Infoedge"
    When user click on edit icon for scheduled interview
    And user open email editor of candidate
    And user open email editor of interviewer
    Then user should be able to see the label "Block calendar of candidate"
    And user should be able to see the label "Block calendar of interviewer"
    And user fill "Infoedge India " location for scheduling interview
    When user click on "Send Update" button
    Then user should be able to see the label "Updated interview invite will be sent to the following users - "
    And user click on "Confirm" button
    Then verify success message "Infoedge India "

  @AdvanceInterview @Pro
  Scenario: RMS PRO user is able to schedule interview through advance interview scheduling
    Given User login to the application "applicationInbox" using "Superuser" of "Company" user
    When user move an application to interview stage
    Then verify that user is able to see the listed headings on page
      | Schedule Interview for                                           |
      | Scheduled Interview will be mailed to candidate and interviewers |
      | Interviewers                                                     |
      | Interview Date                                                   |
      | Interview Time                                                   |
      | Interview Location                                               |
      #| Block room for interview                                         |
      | Customize Emails                                                 |
      | Notify Interviewers via email                                    |
     # | Notify Candidate via email                                       |
     # | Block My Calendar                                                |
    When user fill interviewers name for interview
    And user fill "Infoedge" location for scheduling interview
    # And user click on "Block My Calendar" button
    Then verify that user is able to see the listed headings on page
      | Room for Interview                                            |
      | Interview room details will be shared only with interviewers. |
    When user select two meeting rooms for interview
    Then user should be able to see the label "You can not schedule interview with multiple rooms."
    When user click on delete icon for meeting rooms
    Then user should be able to see the label "Block room for interview"
    When user click on "Block room for interview" button
    And user select one meeting room for interview
    When user click on "Schedule Interview" button
    And verify that user is able to see the listed headings on page
      | Confirm                                      |
      | Interview details will be saved.             |
      | Interview Invite will not be sent to anyone. |
      | Confirm                                      |
      | Cancel                                       |
    And user click on "Send Invite" button
    Then verify success message "Interview Scheduled Successfully."

  @AdvanceInterview @Settings @Pro
  Scenario: RMS PRO user is able to edit interview when editors are opened
    Given User login to the application "applicationInbox" using "Superuser" of "Company" user
    When user move an application to interview stage
    When user fill interviewers name for interview
    And user fill "Infoedge" location for scheduling interview
    And user click on "Schedule Interview" button
    When user click on "Confirm" button
    Then verify success message "Interview Scheduled Successfully."
    When user click on edit icon for scheduled interview
    And user change the interview type,date,time
    And user fill "New edited Infoedge" location for scheduling interview
    And user add one more interviewer for interview
    And user click on notify interviewer checkbox
    And user click on "Preview" button
    Then user should be able to see the label "Mail Preview - Forward"
    When user click on "CLOSE" link
    And user click on notify candidate checkbox
    And user click on "Send Update" button
    Then user should be able to see the label "Updated interview invite will be sent to the following users - "
    When user click on "Confirm" button
    Then verify success message "Interview Scheduled Successfully."

  @AdvanceInterview @feed
  Scenario: user schedule interview with feedback and documents present in profile
    Given User login to the application "applicationInbox" using "Superuser" of "Company" user
    When user move an application to interview stage
    #Then user should be able to see the label "Scheduled Interview will be mailed to candidate and interviewers"
    #When user fill interviewers name for interview
    And user open email editor of interviewer and candidate
    And user fill "Infoedge" location for scheduling interview
    And user click on "Schedule Interview" button
    #Then user should be able to see the label "Interview Invite will be sent to -"
    When user click on "Send Invite" button

  @WIP @id:3
  Scenario: user edit interview and change the interview type,date,location and interviewers
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    When user move an application to interview stage
    And user fill "Infoedge" location for scheduling interview
    And user open email editor of candidate
    And user open email editor of interviewer
		Then user should be able to see the label "Block calendar of candidate"
    And user should be able to see the label "Block calendar of interviewer"
    When user click on "Schedule Interview" button
    Then user should be able to see the label "Interview Invite will be sent to -"
    And user click on "Confirm" button
    When user click on edit icon for scheduled interview
    And user change the interview type,date,time
    And user fill "Infoedge India " location for scheduling interview
    And user select interviewers while scheduling interview
    And user click on "Send Update" button
    Then user should be able to see the label "Confirm"
    When user click on "Send Updated Invite" button

  @WIP @id:4
  Scenario: user schedule from requirement inbox and edit interview by removing and adding interviewers
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise" user
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User select group while creating requirement
    And user click on "Add Candidate" value
    When user move to requirement inbox from cv detail page
    And user move an application to interview stage
    And user fill "Infoedge" location for scheduling interview
    And user open email editor of interviewer and candidate
    Then user should be able to see the label "Interview Invite to Interviewer(s)"
    And user should be able to see the label "Interview Invite to Candidate"
    When user click on "Schedule Interview" button
    And user click on "Send Invite" button
    #Then user is able to see success message for interview scheduled
    When user click on edit icon for scheduled interview
    And user change date & type of interview
    And user click on "Schedule Interview" button
    Then user should be able to see the label "Confirm"
    When user click on "Send Updated Invite" button
    Then only removed interviewer gets the interview cancelation mail
    And only new interviewer gets the interview scheduling mail

  @WIP @id:5
  Scenario: user see all labels of confirmation box for recipients when schedulling interview
    When user move an application to interview stage
    And user fill "Infoedge" location for scheduling interview
    And user open email editor of interviewer and candidate
    Then user should be able to see the label "Interview Invite to Candidate"
    And user click on "Schedule Interview" button
    Then user should be able to see the label "Confirm"
    And verify that user is able to see the listed headings on page
      | Confirm                           |
      | Interview Invite will be sent to- |
      | Candidate:                        |
      | Interviewers:                     |
      | Send Invite                       |
      | Cancel                            |
    When user click on "Cancel" button
    Then user click on "Schedule Interview" button
    When user click on "Send Invite" button
    And user click on edit icon for scheduled interview
    #And user change the interview venue
    And user fill "Infoedge" location for scheduling interview
    And user click on "Schedule Interview" button
    Then verify that user is able to see the listed headings on page
      | Confirm                                                                                                |
      | Updated Interview Invite will be only sent to following users for whom Interview details have changed. |
      | Recipients of Updated Invite-                                                                          |
      | Candidate:                                                                                             |
      | Interviewers:                                                                                          |
      | Cancelled Invite                                                                                       |
      | Send Updated Invite                                                                                    |
      | Cancel                                                                                                 |
    When user click on "Send Updated Invite" button

  @WIP @id:7
  Scenario: user reschedule interview after cancel scheduled interview
    Given user is on requirement inbox
    When user move an application to interview stage
    And user fill all details for scheduling interview
    And user open email editor of interviewer and candidate
    Then subject and body of email editor should be prefill from default template
    When user click on "SCHEDULE INTERVIEW" button
    And user click on "Send Invite" button
    Then user is able to see success message for interview scheduled
    And verify mail is sent to interviewer and candidate with same content
    When user select "cancel" substatus of interview
    And fill cancel mail for both interviewer & candidate
    And user click on "Cancel Interview" button
    Then both candidate and interviewer gets the mail for cancel interview
    When user click on reschedule button
    Then same interviewers should be prefilled which are selected for previous interview
    And interview date, time & location would be reset
    When user click on "SCHEDULE INTERVIEW" button
    And user click on "Send Invite" button
    Then user is able to see success message for interview scheduled
    And verify mail is sent to interviewer and candidate with same content

  @WIP @id:8
  Scenario: Scenario: verify all functionalities related to interviewer and candidate editor and preview
