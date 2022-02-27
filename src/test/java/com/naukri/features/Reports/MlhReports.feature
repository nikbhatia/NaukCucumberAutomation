@tag
Feature: RMS Pre-Configured MLHReports
  Author: srissti.tyagi@naukri.com

  Background: 
    Given User logs in to Rms from "Enterprise" account as a "Superuser"
    When User goes to the "ManageSubusersOnNaukri" Page
    When User clicks on the option to Preview the hierarchy
    When User gets the name of any one teamLead and one non teamLead

  @id:1 @MLHReports @wip
  Scenario: To verify the the list of recruiters viible to a teamLead
    When User gets the users reporting to the above "teamLead"
    When User goes to the "RMSLogout" Page
    When User logs in to RMS as the above "teamLead"
    When User goes to the "Dashboard" Report
    When User clicks on the Choose button on the dashboard to select the recruiters
    When User gets the list of recruiters and their hierarchy from the reports
    Then User verifies the list and hierarchy of recruiters visible in RMS to the above teamLead

  @id:2 @MLHReports @wip
  Scenario: To verify that applied recruiter filter is visible as tag on dashboard and carried forward in the detailed report as well
    When User logs in to RMS as the above "teamLead"
    When User goes to the "Dashboard" Report
    When User clicks on the Choose button on the dashboard to select the recruiters
    When User selects the name of the above "teamLead" available in dropdown
    When User clicks on Apply button to see the results for selected recruiter
    Then User verifies that the above "teamLead" is visble as tag
    Then User verifies that the "Requisition TAT" report has loaded first on dashboard
    When User clicks on ViewAll Link for "Requisition TAT" Report
    Then User verifies that this particular Detailed Report has loaded
    Then User verifies that the above "teamLead" is visble as tag

  @id:3 @MLHReports @wip
  Scenario: To verify that the recruiter filter is applied in saved report and that it cannot be edited in the shared report by the user who has not created that report
    When User logs in to RMS as the above "teamLead"
    When User goes to the "Dashboard" Report
    When User clicks on the Choose button on the dashboard to select the recruiters
    When User selects the name of the above "teamLead" available in dropdown
    When User clicks on Apply button to see the results for selected recruiter
    Then User verifies that the "Requirement TAT" report has loaded first on dashboard
    When User clicks on Icon Ellipses for "Requirement TAT" Report on dashboard
    When User clicks on SaveSchedule option for "Requirement TAT" on dashboard and enter the unique report name
    And User clicks on "Share this report" checkbox
    And User selects email "enterprise_subuser1@naukri.com" from the available list of RMS users
    And User clicks on Save button in saveSchedulePopUp
    When User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on first Report from list
    And User switches to new window
    Then User verifies that the above "teamLead" is visble as tag
    When User goes to the "RMSLogout" Page
    When User logs in to Rms from "Enterprise" account as a "Subuser"
    When User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    And User clicks on first Report from list
    And User switches to new window
    Then User verifies that the above "teamLead" is visble as tag
    Then User verifies that no option to choose or clear the recruiters is visible to this user

  @id:4 @MLHReports @wip
  Scenario: To verify that recruiter options is not visible to Non teamLead and recruitment activity report is also not visible to Non teamLead
    When User logs in to RMS as the above "non teamLead"
    When User goes to the "Dashboard" Report
    Then User verifies that no option to choose or clear the recruiters is visible to this user
    Then User verifies that widget of "Recruitment Activity" report is not visible on the dashboard
    When User clicks on the Drop Down list of reports name
    Then User verifies that "Recruitment Activity" report is not visible in the All Reports DropDown
    When User clicks on the Customize Link on dashboard
    Then User verifies that "Recruitment Activity" report is not visible in the customize DropDown
    When User goes to the "RecruitmentActivity" Report
    Then User verifies that message of Insufficient Permissions is visible to the user
