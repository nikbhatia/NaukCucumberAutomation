@tag
Feature: RMS Pre-Configured Activity Reports
  Author: srissti.tyagi@naukri.com

  Background: 
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user

  @id:1 @ActivityReports @CandidateActivityReport @Rms @RmsReports
  Scenario: To verify that Candidate Activity report can be scheduled from detailed view, to verify the tool tips for column names and to verify that Application is clickable in RequirementFunnel report
    When User goes to the "CandidateActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Settings Icon in detailed report
    Then User verifies the options available custom stages in settings option in "CandidateActivity" Report in Detailed Report
      | Requirement    |
      | Group          |
      | Stage Moved By |
      | Stage Moved to |
      | Movement date  |
      | Details        |
    When User gets all the selected custom stages present in report
    When User clicks on Apply button for custom Stages
    Then Verify that only the stages that are selected in "Candidate Activity" report are visible as column names
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view
    When User goes to the "CandidateActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on first candidate and return the candidate name
    Then User verifies that clicking on candidate Name opens the CV Detail page of that candidate

  @id:2 @ActivityReports @CandidateActivityReport @Rms @RmsReports
  Scenario: To verify the filters list, and the download option for candidate Activity Report
    When User goes to the "CandidateActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Filter Icon
    Then User verifies the list of filters available for "CandidateActivity" Report
      | Group              |
      | Requirement status |
      | Requirement Name   |
      | Stage Moved To     |
      | Stage Moved By     |
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:3 @ActivityReports @CandidateActivityReport @Rms @RmsReports
  Scenario: To verify that clicking on the recruiter name applies the filter of that recruiter
    When User goes to the "CandidateActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the first "stageMoveTo" name
    Then User verifies that this particular Detailed Report has loaded
    Then User verifies that the above clicked value is visible as the applied tag
    Then User verifies that no other "stageMoveTo" is visible

  @id:4 @ActivityReports @RecruitmentActivityReport @Rms @RmsReports
  Scenario: To verify that data is visible according to the selected tab and that Recruitment Activity report can be downloaded from the detailed view
    When User goes to the "RecruitmentActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on "Requirements" subTab in Detailed Report
    Then Verify that data in detailed report is visible according to the "Requirements" subtab
    When User clicks on "Groups" subTab in Detailed Report
    Then Verify that data in detailed report is visible according to the "Groups" subtab
    When User clicks on "Recruiters" subTab in Detailed Report
    Then Verify that data in detailed report is visible according to the "Recruiters" subtab
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:5 @ActivityReports @RecruitmentActivityReport @Rms @RmsReports
  Scenario: To verify the filters list of Recruitment Activity report and to verify that it can be scheduled from detailed view
    When User goes to the "RecruitmentActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    Then User verifies the summary elements of "Recruitment Activity" Report in detailed view
      | Sourced     |
      | Contacted   |
      | Forwarded   |
      | Interviewed |
      | Offered     |
      | Joined      |
    When User clicks on Filter Icon
    Then User verifies the list of filters available for "RecruitmentActivity" Report
      | Group		           |
      | Requirement status |
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view
