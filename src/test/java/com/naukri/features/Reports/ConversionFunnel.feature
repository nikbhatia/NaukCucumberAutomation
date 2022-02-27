@tag
Feature: RMS Pre-Configured Conversion Funnel Reports
  Author: srissti.tyagi@naukri.com

  Background: 
    Given User logs in to Rms from "ProConsultant" account as a "Superuser"

  @id:1 @RequirementFunnnelReport @ConversionFunnelReport @Rms @RmsReports @Mailer @Wip
  Scenario: To verify that requirement level funnel report can be scheduled from detailed view, to verify the tool tips for column names and to verify that Requirement is clickable in RequirementFunnel report
    When User goes to the "RequirementFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User hovers on "contacted" column name in detailed Report
    Then Verify the "contactedColumnToolTip" in "Requirement Funnel" Report in detailed View
    When User hovers on "forwarded" column name in detailed Report
    Then Verify the "forwardedColumnToolTip" in "Requirement Funnel" Report in detailed View
    When User hovers on "interviewed" column name in detailed Report
    Then Verify the "interviewedColumnToolTip" in "Requirement Funnel" Report in detailed View
    When User hovers on "offered" column name in detailed Report
    Then Verify the "offeredColumnToolTip" in "Requirement Funnel" Report in detailed View
    When User hovers on "joined" column name in detailed Report
    Then Verify the "joinedColumnToolTip" in "Requirement Funnel" Report in detailed View
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view
    When User goes to the "RequirementFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on "Requirements" subTab in detailed report
    When User clicks on first requirement and return the requirement name
    Then User verifies that clicking on Requirement Name opens the overview page of that requirement

  @id:2 @StageLevelFunnnelReport @ConversionFunnelReport @Rms @RmsReports
  Scenario: To verify that stage level funnel report can be scheduled from detailed view and to verify that Requirement is clickable in StageLevelFunnel report
    When User goes to the "StageLevelFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on "Schedule this report" checkbox
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view
    When User goes to the "StageLevelFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on "Requirements" subTab in detailed report
    When User clicks on first requirement and return the requirement name
    Then User verifies that clicking on Requirement Name opens the overview page of that requirement

  @id:3 @RequirementFunnnelReport @ConversionFunnelReport @Rms @RmsReports
  Scenario: To verify the filters list for RequirementFunnel Report, and the download option in Requirement Funnel Report
    When User goes to the "RequirementFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Filter Icon
    Then User verifies the list of filters available for "RequirementFunnel" Report
      | Location           |
      | Industry           |
      | Functional Area    |
      | Requirement status |
      | Created By         |
      | Visible To         |
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:4 @StageLevelFunnnelReport @ConversionFunnelReport @Rms @RmsReports
  Scenario: To verify the filters list for StageLevelFunnel Report, and the download option in Stage Level Funnel Report
    When User goes to the "StageLevelFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Filter Icon
    Then User verifies the list of filters available for "StageLevelFunnel" Report
      | Location           |
      | Industry           |
      | Functional Area    |
      | Requirement status |
      | Created By         |
      | Visible To         |
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window

  @id:5 @RequirementFunnnelReport @ConversionFunnelReport @Rms @RmsReports
  Scenario: To verify that closed requirement status filter is working as expected for RequirementFunnel Report
    When User goes to the "RequirementFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Filter Icon
    And User clicks on "Requirement status" Filter option
    And User selects "Closed" filter label
    And User clicks on Refine Filters
    And User clicks on "Requirements" subTab in detailed report
    Then User verifies that the requirement shown after applying above filter have "Closed" status

  @id:6 @RequirementFunnnelReport @ConversionFunnelReport @Rms @RmsReports
  Scenario: To verify that open requirement status filter is working as expected for RequirementFunnel Report
    When User goes to the "RequirementFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Filter Icon
    And User clicks on "Requirement status" Filter option
    And User selects "Open" filter label
    And User clicks on Refine Filters
    And User clicks on "Requirements" subTab in detailed report
    Then User verifies that the requirement shown after applying above filter have "Open" status

  @id:7 @StageLevelFunnnelReport @ConversionFunnelReport @Rms @RmsReports
  Scenario: To verify that closed requirement status filter is working as expected for StageLevelFunnel Report
    When User goes to the "StageLevelFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Filter Icon
    And User clicks on "Requirement status" Filter option
    And User selects "Closed" filter label
    And User clicks on Refine Filters
    And User clicks on "Requirements" subTab in detailed report
    Then User verifies that the requirement shown after applying above filter have "Closed" status

  @id:8 @StageLevelFunnnelReport @ConversionFunnelReport @Rms @RmsReports
  Scenario: To verify that open requirement status filter is working as expected for StageLevelFunnel Report
    When User goes to the "StageLevelFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Filter Icon
    And User clicks on "Requirement status" Filter option
    And User selects "Open" filter label
    And User clicks on Refine Filters
    And User clicks on "Requirements" subTab in detailed report
    Then User verifies that the requirement shown after applying above filter have "Open" status

  @id:9 @StageLevelFunnnelReport @ConversionFunnelReport @Rms @RmsReports
  Scenario: To verify the Settings elements and validations for StageLevelFunnel Report
    When User goes to the "SelectionProcessSettings" Page
    When User gets all the stages present in the system
    When User goes to the "StageLevelFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Settings Icon in detailed report
    Then User verifies the elements under Settings Icon in "Stage Level Funnel" Report on Dashboard
    When User gets all the selected custom stages present in report
    When User clicks on Apply button for custom Stages
    Then Verify that only the stages that are selected in "Stage Level Funnel" report are visible as column names
    When User clicks on Settings Icon in detailed report
    When User clicks on "second" setting option available in "StageLevelFunnel" Report
    When User selects a stage if maximum limit is not reached
    When User gets all the selected custom stages present in report
    #When User clicks on Apply button for custom Stages
    Then Verify that only the stages that are selected in "Stage Level Funnel" report are visible as column names
    When User clicks on Settings Icon in detailed report
    When User clicks on "second" setting option available in "StageLevelFunnel" Report
    Then Verify that more than six stages cannot be selected

  @id:10 @wip
  Scenario: To verify the conversion rate for RequirementFunnel Report
    When User goes to the "RequirementFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Settings Icon in detailed report
    And User selects "conversionReportFirststage" setting
    Then Verify that conversion rate is correct according to selected Stage
    When User hovers on "sourced" column name in detailed Report
    Then Verify that fields of "sourced" column are sorted in respective order in the report

  @id:11 @wip
  Scenario: To verify the conversion rate for StageLevelFunnelReport
    When User goes to the "StageLevelFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Settings Icon in detailed report
    And User selects "customConversionReportFirststage" setting
    Then Verify that conversion rate is correct according to selected Stage

  @id:12 @RequirementFunnnelReport @ConversionFunnelReport @Rms @RmsReports
  Scenario: To verify the created requiement is present in RequirementFunnel report
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Test candidate" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    When User goes to the "RequirementFunnel" Report
    Then User verifies that this particular Detailed Report has loaded
    When User clicks on Time Duration DropDown
     When User selects "Current Quarter" from Time Duration DropDown
    When User clicks on Time Duration DropDown
    When User selects "Choose Custom Time Period" from Time Duration DropDown
    When User selects the custom from and to Dates
    And User clicks on "Requirements" subTab in Detailed Report
    Then User should be able to see recent created requirement in the report
        