@tag
Feature: RMS Pre-Configured Turn Around Time Reports
  Author: srissti.tyagi@naukri.com

  Background: 
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user

  @id:1 @StageLevelTATReport @TATReport @Rms @RmsReports @Smoke
  Scenario: To verify the Settings elements and validations for Stage Level TAT Report
  When User goes to the "SelectionProcessSettings" Page
  When User gets all the selection stages present in RMS from settings page
  When User goes to the "StageLevelTAT" Report
  Then User verifies that this particular Detailed Report has loaded
  When User clicks on the "TABULAR" mode of the Report
  Then User verifies that this particular Detailed Report has loaded
  When User clicks on Settings Icon in detailed report
  When User gets the list of all the selections available in reports
  Then User verifies that all the parent stages are visible in the reports
  When User gets all the selected custom stages present in report
  When User clicks on Apply button for custom Stages
  Then Verify that only the stages that are selected in "Stage Level TAT" report are visible as column names
  When User clicks on Settings Icon in detailed report
  When User selects a stage if maximum limit is not reached
  When User gets all the selected custom stages present in report
  When User clicks on Apply button for custom Stages
  Then Verify that only the stages that are selected in "Stage Level TAT" report are visible as column names
  When User clicks on Settings Icon in detailed report
  Then Verify that more than six stages cannot be selected
  
  @id:2 @StageLevelTATReport @TATReport @Rms @RmsReports
  Scenario: To verify the list of filters and the download option in the Stage Level TAT Report
  When User goes to the "StageLevelTAT" Report
  Then User verifies that this particular Detailed Report has loaded
  When User clicks on the "TABULAR" mode of the Report
  When User clicks on first requirement and return the requirement name
  Then User verifies that clicking on Requirement Name opens the overview page of that requirement
  When User goes to the "StageLevelTAT" Report
  Then User verifies that this particular Detailed Report has loaded
  When User clicks on Filter Icon
  Then User verifies the list of filters available for "StageLevelTAT" Report
  | Location           |
  | Industry           |
  | Functional Area    |
  | Group              |
  | Requirement status |
  | Created By         |
  | Visible To         |
  When User clicks on Download on detailed Report
  When User switches to new window
  Then User verifies that Download Link is generated in the new window
  
  @id:3 @StageLevelTATReport @TATReport @Rms @RmsReports
  Scenario: To verify that closed status filter is working as per the expectations and to verify that report can be scheduled from detailed view in Stage Level TAT report
  When User goes to the "StageLevelTAT" Report
  Then User verifies that this particular Detailed Report has loaded
  When User clicks on Filter Icon
  And User clicks on "Requirement status" Filter option
  And User selects "Closed" filter label
  And User clicks on Refine Filters
  And User clicks on "Requirements" subTab in detailed report
  Then User verifies that the requirement shown after applying above filter have "Closed" status
  When User goes to the "StageLevelTAT" Report
  Then User verifies that this particular Detailed Report has loaded
  When User clicks on SaveSchedule on detailed Report and return report name
  And User clicks on "Schedule this report" checkbox
  And User clicks on Save button in saveSchedulePopUp
  And User goes to the "SaveSchedule" Report
  Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view
  
  @id:4 @RequirementTatReport @TATReport @Rms @RmsReports
  Scenario: To verify the tool tips and to verify that requirement is clickable and to verify the list of filters and the download option in the requirement TAT Report
  When User goes to the "RequirementTAT" Report
  Then User verifies that this particular Detailed Report has loaded
  When User clicks on the "TABULAR" mode of the Report
  When User clicks on "Requirements" subTab in Detailed Report
  When User clicks on first requirement and return the requirement name
  Then User verifies that clicking on Requirement Name opens the overview page of that requirement
  When User goes to the "RequirementTAT" Report
  Then User verifies that this particular Detailed Report has loaded
  When User clicks on Filter Icon
  Then User verifies the list of filters available for "RequirementTAT" Report
  | Location           |
  | Industry           |
  | Functional Area    |
  | Group              |
  | Requirement status |
  | Created By         |
  | Visible To         |
  When User clicks on Download on detailed Report
  When User switches to new window
  Then User verifies that Download Link is generated in the new window
  
  @id:5 @RequirementTatReport @TATReport @Rms @RmsReports
  Scenario: To verify the column names, To verify that closed status filter is working as per the expectations and to verify that report can be scheduled from detailed view in requirement TAT report
  When User goes to the "RequirementTAT" Report
  Then User verifies that this particular Detailed Report has loaded
  Then User verifies the summary elements of "Requirement TAT" Report in detailed view
  | Days To Source The First Candidate    |
  | Days To Contact The First Candidate   |
  | Days To Forward The First Candidate   |
  | Days To Interview The First Candidate |
  | Days To Offer The First Candidate     |
  | Days To Join The First Candidate      |
  When User clicks on the "TABULAR" mode of the Report
  Then User verifies that this particular Detailed Report has loaded
  When User clicks on Filter Icon
  And User clicks on "Requirement status" Filter option
  And User selects "Closed" filter label
  And User clicks on Refine Filters
  Then User verifies that this particular Detailed Report has loaded
  And User clicks on "Requirements" subTab in detailed report
  Then User verifies that this particular Detailed Report has loaded
  Then User verifies that the requirement shown after applying above filter have "Closed" status
  When User goes to the "RequirementTAT" Report
  Then User verifies that this particular Detailed Report has loaded
  When User clicks on SaveSchedule on detailed Report and return report name
  And User clicks on "Schedule this report" checkbox
  And User clicks on Save button in saveSchedulePopUp
  And User goes to the "SaveSchedule" Report
  Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view
  
  @RequirementTatReport @TATReport @Rms @RmsReports
  Scenario: To verify the Candidate count on stage is dispalying in Stage Level TAT report
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Test candidate" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    When User fills in the requirement title for add a single profile
    And User selects the candidate status as "Prospect" while creating the candidate
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    When User goes to the "StageLevelTAT" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the "TABULAR" mode of the Report
    When User clicks on Time Duration DropDown
    When User selects "Current Month" from Time Duration DropDown
    When User clicks on Time Duration DropDown
    When User selects "Choose Custom Time Period" from Time Duration DropDown
    When User selects the custom from and to Dates
    Then User should be able to see recent created requirement in Stage Level Tat report
    Then User should be able to see candidate count against "Prospect" Stage
