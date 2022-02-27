@tag
Feature: RMS Pre-Configured Requirement Reports
  Author: srissti.tyagi@naukri.com

  Background: 
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user

  @id:1 @RequirementReports @RequirementAgingReport @Rms @RmsReports @Smoke
  Scenario: To verify that filters of open and onHold are always applied in this report and to verify the list of filters and to verify that report can be downloaded
    When User goes to the "RequirementAging" Report
    Then User verifies that this particular Detailed Report has loaded
    Then User verifies that expected filters that are applied are visible as tag in the saved report
      | Open    |
      | On Hold |
    When User clicks on Filter Icon
    When User clicks on Clear All option to clear all the filters
    Then User verifies the list of filters available for "RequirementAging" Report
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

  @id:2 @RequirementReports @RequirementAgingReport @Rms @RmsReports
  Scenario: To verify that DropDown of time duration is not displayed , to verify the summary elements and to verify that Requirement Aging report can saved from the detailed view
    When User goes to the "RequirementAging" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that time duration dropDown is not visible in this report
    Then User verifies the time duration options in the summary widget of Requirement Aging Report
      | 0-1 month  |
      | 1-3 month  |
      | 3-6 month  |
      | 6-12 month |
      | >1 year    |
    Then Verify the elements in the column names of Requirement Report
      | Requirement       |
      | Date Created      |
      | Age               |
      | (Since created)   |
      | Date Last Active  |
      | Since Last Active |
      |                   |
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  @id:3 @RequirementReports @RequirementCreationReport @Rms @RmsReports
  Scenario: To verify the list of filters, to verify the summary elements and to verify that report can be downloaded
    When User goes to the "RequirementCreation" Report
    Then User verifies that this particular Detailed Report has loaded
    Then User verifies the summary elements of "Requirement Creation" Report in detailed view
      | Requirements Created |
      | Groups               |
      | Vacancies Created    |
      | Requirements Closed  |
      | Groups               |
      | Offered In Closed    |
    When User clicks on the "TABULAR" mode of the Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on "Growth" subTab in detailed report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify the elements in the column names of Requirement Report
      | Growth           |
      | Requirements     |
      | Created          |
      | Vacancies        |
      | Created          |
      | Created for No.  |
      | of Groups        |
      | Requirements     |
      | Closed           |
      | Vacancies        |
      | Closed           |
      | Offers in Closed |
      | Requirements     |
    When User clicks on Filter Icon
    Then User verifies the list of filters available for "RequirementCreation" Report
      | Location           |
      | Industry           |
      | Functional Area    |
      | Requirement status |
      | Created By         |
      | Visible To         |
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:4 @RequirementReports @RequirementCreationReport @Rms @RmsReports
  Scenario: To verify the options in Graphical view of the requirement Creation report and to verify that requirement creation report can be scheduled from detailed view
    Given User goes to the "RequirementCreation" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the "GRAPHICAL" mode of the Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on "Groups" subTab in detailed report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on the Drop Down option available at the top left of the graph
    Then Verify the Drop Down options available in Graphical view of Requirement Creation Report
      | Max Requirements Created |
      | Min Requirements Created |
      | Max Requirements Closed  |
      | Min Requirements Closed  |
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view
