Feature: Location taxonomy changes in Pre-Config Reports

  Background: 
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user

  #Requirement TAT
  Scenario: Verify that Location filter for Requirement TAT, contains all new and old locations with which data is present
    When User goes to the "RequirementTAT" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Talupula |
    And User sees options in "Location" filter contains Old locations data
      | Bangalore |

  Scenario: Verify that Location filter for Requirement TAT, contains long tail locations with which data is present
    When User goes to the "RequirementTAT" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Test - Andhra Pradesh |

  Scenario: Verify that applying any location as filter which is present in old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementTAT" Report
    When User clicks on Filter Icon
    And User selects "Bangalore" as "Location"
    Then User sees data for "Bangalore" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementTAT" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new as well as old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementTAT" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter after old location has been updated to new, is displayed as per filter, downloaded reports has same data as viewed report
    When User goes to the "RequirementTAT" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that user is able to Save report with old and new locations filter applied
    When User goes to the "RequirementTAT" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  Scenario: Verify that user is able to apply new locations in filter to Old Saved reports
    When User goes to the "SaveSchedule" Report
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location

  #Requisition Overview
  Scenario: Verify that Location filter for Requisition Overview, contains all new and old locations with which data is present
    When User goes to the "RequisitionOverview" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Talupula |
    And User sees options in "Location" filter contains Old locations data
      | Bangalore |

  Scenario: Verify that Location filter for Requisition Overview, contains long tail locations with which data is present
    When User goes to the "RequisitionOverview" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Test - Andhra Pradesh |

  Scenario: Verify that applying any location as filter which is present in old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequisitionOverview" Report
    When User clicks on Filter Icon
    And User selects "Bangalore" as "Location"
    Then User sees data for "Bangalore" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequisitionOverview" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new as well as old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequisitionOverview" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter after old location has been updated to new, is displayed as per filter, downloaded reports has same data as viewed report
    When User goes to the "RequisitionOverview" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that user is able to Save report with old and new locations filter applied
    When User goes to the "RequisitionOverview" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  Scenario: Verify that user is able to apply new locations in filter to Old Saved reports
    When User goes to the "SaveSchedule" Report
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location

  #Stage Level TAT
  Scenario: Verify that Location filter for Stage Level TAT, contains all new and old locations with which data is present
    When User goes to the "StageLevelTAT" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Talupula |
    And User sees options in "Location" filter contains Old locations data
      | Bangalore |

  Scenario: Verify that Location filter for Stage Level TAT, contains long tail locations with which data is present
    When User goes to the "StageLevelTAT" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Test - Andhra Pradesh |

  Scenario: Verify that applying any location as filter which is present in old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "StageLevelTAT" Report
    When User clicks on Filter Icon
    And User selects "Bangalore" as "Location"
    Then User sees data for "Bangalore" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "StageLevelTAT" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new as well as old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "StageLevelTAT" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter after old location has been updated to new, is displayed as per filter, downloaded reports has same data as viewed report
    When User goes to the "StageLevelTAT" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that user is able to Save report with old and new locations filter applied
    When User goes to the "StageLevelTAT" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  Scenario: Verify that user is able to apply new locations in filter to Old Saved reports
    When User goes to the "SaveSchedule" Report
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location

  #Requisition TAT
  Scenario: Verify that Location filter for RequisitionTAT, contains all new and old locations with which data is present
    When User goes to the "RequisitionTAT" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Talupula |
    And User sees options in "Location" filter contains Old locations data
      | Bangalore |

  Scenario: Verify that Location filter for RequisitionTAT, contains long tail locations with which data is present
    When User goes to the "RequisitionTAT" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Test - Andhra Pradesh |

  Scenario: Verify that applying any location as filter which is present in old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequisitionTAT" Report
    When User clicks on Filter Icon
    And User selects "Bangalore" as "Location"
    Then User sees data for "Bangalore" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequisitionTAT" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new as well as old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequisitionTAT" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter after old location has been updated to new, is displayed as per filter, downloaded reports has same data as viewed report
    When User goes to the "RequisitionTAT" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that user is able to Save report with old and new locations filter applied
    When User goes to the "RequisitionTAT" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  Scenario: Verify that user is able to apply new locations in filter to Old Saved reports
    When User goes to the "SaveSchedule" Report
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location

  #Requirement Funnel
  Scenario: Verify that Location filter for RequirementFunnel, contains all new and old locations with which data is present
    When User goes to the "RequirementFunnel" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Talupula |
    And User sees options in "Location" filter contains Old locations data
      | Bangalore |

  Scenario: Verify that Location filter for RequirementFunnel, contains long tail locations with which data is present
    When User goes to the "RequirementFunnel" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Test - Andhra Pradesh |

  Scenario: Verify that applying any location as filter which is present in old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementFunnel" Report
    When User clicks on Filter Icon
    And User selects "Bangalore" as "Location"
    Then User sees data for "Bangalore" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementFunnel" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new as well as old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementFunnel" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter after old location has been updated to new, is displayed as per filter, downloaded reports has same data as viewed report
    When User goes to the "RequirementFunnel" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that user is able to Save report with old and new locations filter applied
    When User goes to the "RequirementFunnel" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  Scenario: Verify that user is able to apply new locations in filter to Old Saved reports
    When User goes to the "SaveSchedule" Report
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location

  #Stage Level Funnel
  Scenario: Verify that Location filter for StageLevelFunnel, contains all new and old locations with which data is present
    When User goes to the "StageLevelFunnel" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Talupula |
    And User sees options in "Location" filter contains Old locations data
      | Bangalore |

  Scenario: Verify that Location filter for StageLevelFunnel, contains long tail locations with which data is present
    When User goes to the "StageLevelFunnel" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Test - Andhra Pradesh |

  Scenario: Verify that applying any location as filter which is present in old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "StageLevelFunnel" Report
    When User clicks on Filter Icon
    And User selects "Bangalore" as "Location"
    Then User sees data for "Bangalore" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "StageLevelFunnel" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new as well as old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "StageLevelFunnel" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter after old location has been updated to new, is displayed as per filter, downloaded reports has same data as viewed report
    When User goes to the "StageLevelFunnel" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that user is able to Save report with old and new locations filter applied
    When User goes to the "StageLevelFunnel" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  Scenario: Verify that user is able to apply new locations in filter to Old Saved reports
    When User goes to the "SaveSchedule" Report
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location

  #Requirement Aging
  Scenario: Verify that Location filter for RequirementAging, contains all new and old locations with which data is present
    When User goes to the "RequirementAging" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Talupula |
    And User sees options in "Location" filter contains Old locations data
      | Bangalore |

  Scenario: Verify that Location filter for RequirementAging, contains long tail locations with which data is present
    When User goes to the "RequirementAging" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Test - Andhra Pradesh |

  Scenario: Verify that applying any location as filter which is present in old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementAging" Report
    When User clicks on Filter Icon
    And User selects "Bangalore" as "Location"
    Then User sees data for "Bangalore" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementAging" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new as well as old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementAging" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter after old location has been updated to new, is displayed as per filter, downloaded reports has same data as viewed report
    When User goes to the "RequirementAging" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that user is able to Save report with old and new locations filter applied
    When User goes to the "RequirementAging" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  Scenario: Verify that user is able to apply new locations in filter to Old Saved reports
    When User goes to the "SaveSchedule" Report
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location

  #Overall Source Performance
  Scenario: Verify that Location filter for SourcePerformance, contains all new and old locations with which data is present
    When User goes to the "SourcePerformance" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Talupula |
    And User sees options in "Location" filter contains Old locations data
      | Bangalore |

  Scenario: Verify that Location filter for SourcePerformance, contains long tail locations with which data is present
    When User goes to the "SourcePerformance" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Test - Andhra Pradesh |

  Scenario: Verify that applying any location as filter which is present in old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "SourcePerformance" Report
    When User clicks on Filter Icon
    And User selects "Bangalore" as "Location"
    Then User sees data for "Bangalore" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "SourcePerformance" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new as well as old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "SourcePerformance" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter after old location has been updated to new, is displayed as per filter, downloaded reports has same data as viewed report
    When User goes to the "SourcePerformance" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that user is able to Save report with old and new locations filter applied
    When User goes to the "SourcePerformance" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  Scenario: Verify that user is able to apply new locations in filter to Old Saved reports
    When User goes to the "SaveSchedule" Report
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location

  #Vendor Performance
  Scenario: Verify that Location filter for VendorPerformance, contains all new and old locations with which data is present
    When User goes to the "VendorPerformance" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Talupula |
    And User sees options in "Location" filter contains Old locations data
      | Bangalore |

  Scenario: Verify that Location filter for VendorPerformance, contains long tail locations with which data is present
    When User goes to the "VendorPerformance" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Test - Andhra Pradesh |

  Scenario: Verify that applying any location as filter which is present in old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "VendorPerformance" Report
    When User clicks on Filter Icon
    And User selects "Bangalore" as "Location"
    Then User sees data for "Bangalore" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "VendorPerformance" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new as well as old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "VendorPerformance" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter after old location has been updated to new, is displayed as per filter, downloaded reports has same data as viewed report
    When User goes to the "VendorPerformance" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that user is able to Save report with old and new locations filter applied
    When User goes to the "VendorPerformance" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  Scenario: Verify that user is able to apply new locations in filter to Old Saved reports
    When User goes to the "SaveSchedule" Report
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location

  #Requirement Creation
  Scenario: Verify that Location filter for RequirementCreation, contains all new and old locations with which data is present
    When User goes to the "RequirementCreation" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Talupula |
    And User sees options in "Location" filter contains Old locations data
      | Bangalore |

  Scenario: Verify that Location filter for RequirementCreation, contains long tail locations with which data is present
    When User goes to the "RequirementCreation" Report
    When User clicks on Filter Icon
    And User sees options in "Location" filter contains new locations data
      | Test - Andhra Pradesh |

  Scenario: Verify that applying any location as filter which is present in old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementCreation" Report
    When User clicks on Filter Icon
    And User selects "Bangalore" as "Location"
    Then User sees data for "Bangalore" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementCreation" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter which is present in new as well as old data shows all relevant data for the location, downloaded reports has same data as viewed report
    When User goes to the "RequirementCreation" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that applying any location as filter after old location has been updated to new, is displayed as per filter, downloaded reports has same data as viewed report
    When User goes to the "RequirementCreation" Report
    When User clicks on Filter Icon
    And User selects "Talupula" as "Location"
    And User selects "Test - Andhra Pradesh" as "Location"
    Then User sees data for "Talupula" location
    Then User sees data for "Test - Andhra Pradesh" location
    When User clicks on Download on detailed Report
    When User switches to new window
    Then User verifies that Download Link is generated in the new window
    When User clicks download reports link
    Then User sees data matches the displayed report

  Scenario: Verify that user is able to Save report with old and new locations filter applied
    When User goes to the "RequirementCreation" Report
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
    When User clicks on SaveSchedule on detailed Report and return report name
    And User clicks on Save button in saveSchedulePopUp
    And User goes to the "SaveSchedule" Report
    Then User verifies that this particular Detailed Report has loaded
    Then Verify that the name of first report is the one that is saved above when the report is saved from detailed view

  Scenario: Verify that user is able to apply new locations in filter to Old Saved reports
    When User goes to the "SaveSchedule" Report
    When User gets the first saved report name from List
    And User clicks on first Report from list
    And User switches to new window
    Then Verify that the expected saved report has opened
    When User clicks on Filter Icon
    And User selects "Delhi" as "Location"
    Then User sees data for "Delhi" location
