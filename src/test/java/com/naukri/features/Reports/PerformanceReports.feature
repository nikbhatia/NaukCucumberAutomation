@tag
Feature: RMS Pre-Configured Performance Reports
  Author: srissti.tyagi@naukri.com

  Background: 
    Given User logs in to Rms from "ProConsultant" account as a "Superuser"

  @id:1 @PerformanceReport @OverallSourcePerformanceReport @Rms @RmsReports
  Scenario: To verify the filters list, and the download option in OverAll Source Performance Report
    When User goes to the "SourcePerformance" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the "TABULAR" mode of the Report
    Then User verifies that this particular Detailed Report has loaded
    Then User verifies the column names for Performance Reports
      | Source       |
      | Total        |
      | Applications |
      | No. of CVs   |
      | Contacted    |
      | No. of CVs   |
      | Forwarded    |
      | No. of CVs   |
      | Interviewed  |
      | No. of CVs   |
      | Offered      |
      | No. of CVs   |
      | Joined       |
    Then User verifies the tool tips for the performance reports
      | No. of applications against requirements created         |
      | No. of applications contacted for requirements created   |
      | No. of applications forwarded for requirements created   |
      | No. of applications interviewed for requirements created |
      | No. of applications offered for requirements created     |
      | No. of applications joined for requirements created      |
    When User clicks on Filter Icon
    Then User verifies the list of filters available for "RequirementFunnel" Report
      | Location           |
      | Industry           |
      | Functional Area    |
      | Employer           |
      | Requirement status |
      | Created By         |
      | Visible To         |
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:2 @PerformanceReport @OverallSourcePerformanceReport @Rms @RmsReports
  Scenario: To verify the overall count and to verify the schedule functionality in OverAll Source Performance Report
    When User goes to the "SourcePerformance" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the "TABULAR" mode of the Report
    Then User verifies that this particular Detailed Report has loaded
    Then User verifies that over all count for all columns is the summation of all fields
    When User clicks on Settings Icon in detailed report
    And User selects "firststage" setting
    Then User verifies that this particular Detailed Report has loaded
    When User gets the visible values of conversion percentage
    When User gets the expected values of conversion percentage
    Then Verify that conversion rate is correct according to selected Stage
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  @id:3 @PerformanceReport @VendorPerformanceReport @Rms @RmsReports 
  Scenario: To verify the filters list, and the download option in OverAll Source Performance Report
    When User goes to the "VendorPerformance" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the "TABULAR" mode of the Report
    Then User verifies that this particular Detailed Report has loaded
    Then User verifies the column names for Performance Reports
      | Vendors       |
      | Total        |
      | Applications |
      | No. of CVs   |
      | Contacted    |
      | No. of CVs   |
      | Forwarded    |
      | No. of CVs   |
      | Interviewed  |
      | No. of CVs   |
      | Offered      |
      | No. of CVs   |
      | Joined       |
    Then User verifies the tool tips for the performance reports
      | No. of applications against requirements created         |
      | No. of applications contacted for requirements created   |
      | No. of applications forwarded for requirements created   |
      | No. of applications interviewed for requirements created |
      | No. of applications offered for requirements created     |
      | No. of applications joined for requirements created      |
    When User clicks on Filter Icon
    Then User verifies the list of filters available for "RequirementFunnel" Report
      | Location           |
      | Industry           |
      | Functional Area    |
      | Employer           |
      | Requirement status |
      | Created By         |
      | Visible To         |
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:4 @PerformanceReport @VendorPerformanceReport @Rms @RmsReports
  Scenario: To verify the overall count and to verify the schedule functionality in OverAll Source Performance Report
    When User goes to the "VendorPerformance" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the "TABULAR" mode of the Report
    Then User verifies that this particular Detailed Report has loaded
    Then User verifies that over all count for all columns is the summation of all fields
    When User clicks on Settings Icon in detailed report
    And User selects "firststage" setting
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that conversion rate is correct according to selected Stage
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view
