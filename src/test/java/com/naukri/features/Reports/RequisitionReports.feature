@tag
Feature: RequisitionReportsSmoke
  Author: srissti.tyagi@naukri.com

  Background: 
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user

  @id:1 @RequisitionTatReport @RequisitionReports @Rms @RmsReports @Smoke
  Scenario: To verify the filters list of Requisition TAT report and to verify that it can be scheduled from detailed view
    When User goes to the "RequisitionTAT" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Filter Icon
    Then User verifies the list of filters available for "RequisitionTAT" Report
      | Location           |
      | Group              |
      | Requisition status |
      | Raised By          |
      | HR SPOC            |
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  @id:2 @RequisitionTatReport @RequisitionReports @Rms @RmsReports
  Scenario: To verify the setting option validations for requisition TAT report
    When User goes to the "RequisitionTAT" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the "TABULAR" mode of the Report
    When User clicks on Settings Icon in detailed report
    When User clicks on "first" setting option available in "RequisitionTAT" Report
    Then User verifies the options available for first setting option in "RequisitionTAT" Report in Detailed Report
      | From Requisition Creation |
      | From Requisition Approval |
    When User clicks on "second" setting option available in "RequisitionTAT" Report
    Then User verifies the options available custom stages in settings option in "RequisitionTAT" Report in Detailed Report
      | Requisition Approved    |
      | Requirement Created     |
      | Interviewed             |
      | Interview Feedback      |
      | Offered                 |
      | Offer Letter Rolled Out |
      | Offer Approved          |
      | Offer Acceptance        |
      | Joined                  |
    When User gets all the selected custom stages present in report
    When User clicks on Apply button for custom Stages
    Then Verify that only the stages that are selected in "Requisition TAT" report are visible as column names
    When User clicks on Settings Icon in detailed report
    When User clicks on "second" setting option available in "RequisitionTAT" Report
    When User selects a stage if maximum limit is not reached
    When User gets all the selected custom stages present in report
    When User clicks on Apply button for custom Stages
    Then Verify that only the stages that are selected in "Requisition TAT" report are visible as column names
    When User clicks on Settings Icon in detailed report
    When User clicks on "second" setting option available in "RequisitionTAT" Report
    Then Verify that more than six stages cannot be selected

  @id:3 @RequisitionTatReport @RequisitionReports @Rms @RmsReports
  Scenario: To verify that data is visible according to the selected tab and that requisition TAT report can be downloaded from the detailed view
    When User goes to the "RequisitionTAT" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the "TABULAR" mode of the Report
    When User clicks on "Requisitions" subTab in Detailed Report
    Then Verify that data in detailed report is visible according to the "Requisitions" subtab
    When User clicks on "Groups" subTab in Detailed Report
    Then Verify that data in detailed report is visible according to the "Groups" subtab
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:4 @RequisitionOverviewReport @RequisitionReports @Rms @RmsReports
  Scenario: To verify the filters list of Requisition Overview report and to verify that it can be scheduled from detailed view
    When User goes to the "RequisitionOverview" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Filter Icon
    Then User verifies the list of filters available for "RequisitionOverview" Report
      | Location           |
      | Group              |
      | Requisition status |
      | Raised By          |
      | HR SPOC            |
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  @id:5 @RequisitionOverviewReport @RequisitionReports @Rms @RmsReports
  Scenario: To verify the setting option validations for requisition Overview report
    When User goes to the "RequisitionOverview" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the "TABULAR" mode of the Report
    When User clicks on Settings Icon in detailed report
    Then User verifies the options available custom stages in settings option in "RequisitionOverview" Report in Detailed Report
      | Requisitions Created               |
      | Requisition Pending For Approval   |
      | Requisition Approved               |
      | Requisition Rejected               |
      | Requisition Withdrawn              |
      | Requirements Created               |
      | Requirements Closed                |
      | Requirements Open                  |
      | Requirements On Hold               |
      | Vacancies against the requirements |
      | Vacancies against the requisitions |
      | Candidates Interviewed             |
      | Candidates Offered                 |
      | Candidates Joined                  |
    When User gets all the selected custom stages present in report
    When User clicks on Apply button for custom Stages
    Then Verify that only the stages that are selected in "Requisition Overview" report are visible as column names
    When User clicks on Settings Icon in detailed report
    When User selects a stage if maximum limit is not reached
    When User gets all the selected custom stages present in report
    When User clicks on Apply button for custom Stages
    Then Verify that only the stages that are selected in "Requisition Overview" report are visible as column names
    When User clicks on Settings Icon in detailed report
    Then Verify that more than six stages cannot be selected
    When User clicks on the "GRAPHICAL" mode of the Report
    Then User verifies that no settings icon is visible in requisition Overview Report in Graphical Mode

  @id:6 @RequisitionOverviewReport @RequisitionReports @Rms @RmsReports
  Scenario: To verify that data is visible according to the selected tab and selected time division and that requisition overview report can be downloaded from the detailed view
    When User goes to the "RequisitionOverview" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the "TABULAR" mode of the Report
    Then User verifies the summary elements of "Requisition Overview" Report in detailed view
      | Requisitions Created             |
      | Requisition Pending For Approval |
      | Requisition Approved             |
      | Requisition Rejected             |
      | Requisition Withdrawn            |
      | Requirements Created             |
    When User clicks on "Growth" subTab in Detailed Report
    Then Verify that data in detailed report is visible according to the "Growth" subtab
    Then User verifies the Division label in Requisition Overview Report in detailed view
    When User selects "Current Quarter" time duration
    Then User verifies that options visible in the Division Label are according to "Current Quarter" time duration
    When User selects "Current Month" time duration
    Then User verifies that options visible in the Division Label are according to "Current Month" time duration
    When User clicks on "Groups" subTab in Detailed Report
    Then Verify that data in detailed report is visible according to the "Groups" subtab
    When User clicks on "HR Spoc" subTab in Detailed Report
    Then Verify that data in detailed report is visible according to the "HR Spoc" subtab
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:7 @HmActivityReport @RequisitionReports @Rms @RmsReports
  Scenario: To verify the filters list of Hiring Manager Activity report and to verify that it can be scheduled from detailed view
    When User goes to the "HiringManagerActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Filter Icon
    Then User verifies the list of filters available for "HiringManagerActivity" Report
      | Group   |
      | HR SPOC |
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  @id:8 @HmActivityReport @RequisitionReports @Rms @RmsReports
  Scenario: To verify the setting option validations for Hiring Manager Activity report
  	When User logout from application
  	Given User login to the application "rmsDashboardPage" using "Superuser1" of "Enterprise" user
    When User goes to the "HiringManagerActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Settings Icon in detailed report
    Then User verifies the options available custom stages in settings option in "HiringManagerActivity" Report in Detailed Report
      | Requisition Raised                               |
      | Requisition Withdrawn                            |
      | Requisition Re-Initiated                         |
      | Requisition Approval Pending                     |
      | Requisition Approved                             |
      | Requisition Rejected                             |
      | Candidate Reviews Pending                        |
      | Candidate Reviews Provided                       |
      | Reviews Provided - Candidate Approved            |
      | Reviews Provided - Candidate Rejected            |
      | Candidate Reviews Not Provided                   |
      | Interview scheduled                              |
      | Interview Feedback Pending                       |
      | Interview Feedback Provided                      |
      | Interview Feedback Provided - Candidate Approved |
      | Interview Feedback Provided - Candidate Rejected |
      | Interview Feedback Not Provided                  |
      | Offer Letter Approval Pending                    |
      | Offer Letter Approved                            |
      | Offer Letter Rejected                            |
    When User gets all the selected custom stages present in report
    When User clicks on Apply button for custom Stages
    Then Verify that only the stages that are selected in "Hiring Manager Activity" report are visible as column names
    When User clicks on Settings Icon in detailed report
    When User selects a stage if maximum limit is not reached
    When User gets all the selected custom stages present in report
    When User clicks on Apply button for custom Stages
    Then Verify that only the stages that are selected in "Hiring Manager Activity" report are visible as column names
    When User clicks on Settings Icon in detailed report
    Then Verify that more than six stages cannot be selected

  @id:9 @HmActivityReport @RequisitionReports @Rms @RmsReports
  Scenario: To verify that data is visible according to the selected tab and that Hiring Manager Activity report can be downloaded from the detailed view
    When User goes to the "HiringManagerActivity" Report
    Then User verifies that this particular Detailed Report has loaded
    Then User verifies the summary elements of "Hiring Manager Activity" Report in detailed view
      | Requisition Raised            |
      | Requisition Approved          |
      | Requisition Approval Pending  |
      | Interview Feedback Provided   |
      | Interview Feedback Pending    |
      | Offer Letter Approval Pending |
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
