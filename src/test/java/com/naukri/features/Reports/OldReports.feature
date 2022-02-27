Feature: RMSEN-1210,RMSEN-1301 scenarios

  #@RMSOldReports @RecruiterReport
  #Scenario: To verify the display of timeline bar on selecting the corresponding radio button on recruiter report
    #Given I login into RMS as an "Enterprise" user
    #And I am on Reports page
    #When I click on "Recruiter" report
    #Then I should be able to see 2 radio button with labels "Show reports for Requirements created / re-opened" and "Show reports for Activities done"
    #When I click on radio button "Show reports for Requirements created / re-opened"
    #Then I should be able to see the "requirement creation" timeline bar with options "This Week, Last Month, This Month, Last Quarter, This Quarter, More, Custom"
    #When I click on more of "requirement creation"
    #Then I should be able to see the "requirement creation" more list "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days"
    #When I click on radio button "Show reports for Activities done"
    #Then I should be able to see the "activities done" timeline bar with options "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days, More, Custom"
#		When I click on more of "activities done"
    #Then I should be able to see the "activities done" more list "This Week, Last Month, This Month, Last Quarter, This Quarter"
  #
  #@RMSOldReports @RequirementReport
  #Scenario: To verify the display of timeline bar on selecting the corresponding radio button on requirement report
    #Given I login into RMS as an "Enterprise" user
    #And I am on Reports page
    #When I click on "Requirement" report
    #Then I should be able to see 2 radio button with labels "Show reports for Requirements created / re-opened" and "Show reports for Activities done"
    #When I click on radio button "Show reports for Requirements created / re-opened"
    #Then I should be able to see the "requirement creation" timeline bar with options "This Week, Last Month, This Month, Last Quarter, This Quarter, More, Custom"
    #When I click on more of "requirement creation"
    #Then I should be able to see the "requirement creation" more list "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days"
    #When I click on radio button "Show reports for Activities done" 
    #Then I should be able to see the "activities done" timeline bar with options "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days, More, Custom"
#		When I click on more of "activities done"
    #Then I should be able to see the "activities done" more list "This Week, Last Month, This Month, Last Quarter, This Quarter"
#
   #@RMSOldReports @GroupReport
  #Scenario: To verify the display of timeline bar on selecting the corresponding radio button on group report
    #Given I login into RMS as an "Enterprise" user
    #And I am on Reports page
    #When I click on "Group Wise" report
    #Then I should be able to see 2 radio button with labels "Show reports for Requirements created / re-opened" and "Show reports for Activities done"
    #When I click on radio button "Show reports for Requirements created / re-opened"
    #Then I should be able to see the "requirement creation" timeline bar with options "This Week, Last Month, This Month, Last Quarter, This Quarter, More, Custom"
    #When I click on more of "requirement creation"
    #Then I should be able to see the "requirement creation" more list "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days" 
    #When I click on radio button "Show reports for Activities done"
    #Then I should be able to see the "activities done" timeline bar with options "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days, More, Custom"
#		When I click on more of "activities done"
    #Then I should be able to see the "activities done" more list "This Week, Last Month, This Month, Last Quarter, This Quarter"
#
  #@RMSOldReports @EmployerReport
  #Scenario: To verify the display of timeline bar on selecting the corresponding radio button on employer report
    #Given I login into RMS as an "ProConsultant" user
    #And I am on Reports page
    #When I click on "Employer Wise" report
    #Then I should be able to see 2 radio button with labels "Show reports for Requirements created / re-opened" and "Show reports for Activities done"
    #When I click on radio button "Show reports for Requirements created / re-opened"
    #Then I should be able to see the "requirement creation" timeline bar with options "This Week, Last Month, This Month, Last Quarter, This Quarter, More, Custom"
    #When I click on more of "requirement creation"
    #Then I should be able to see the "requirement creation" more list "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days"
    #When I click on radio button "Show reports for Activities done"
    #Then I should be able to see the "activities done" timeline bar with options "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days, More, Custom"
#		When I click on more of "activities done"
    #Then I should be able to see the "activities done" more list "This Week, Last Month, This Month, Last Quarter, This Quarter"

  @wip @RMSOldReports
  Scenario: To verify the display of timeline bar on selecting the corresponding radio button on recruiter report
    Given I login into RMS as an "Enterprise" user
    And I am on Reports page
    When I click on "Recruiter" report
    And I click on radio button "Show reports for Requirements created / re-opened"
    And I click on more of "requirement creation"
    And I select any option from the more list
    Then I should be able to see the more option changed to the value selected from the list
    And I click on replaced option
   Then I should be able to see the "requirement creation" more list "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days"
    When I click on radio button "Show reports for Activities done"
    When I click on more of "activities done"
    And I select any option from the more list
    Then I should be able to see the more option changed to the value selected from the list
    And I click on replaced option
    Then I should be able to see the "activities done" more list "This Week, Last Month, This Month, Last Quarter, This Quarter"

  #@wip
  #Scenario: To verify the display of timeline bar on selecting the corresponding radio button on requirement report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Requirement" report
    #And I check on the "Show reports for Requirements created / re-opened"
    #And I click on more option
    #And I select any option from the more list
    #Then I should be able to see the more option changed to the value selected from the list
    #And I click on replaced option
    #Then I should be able to see the list "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days"
    #When I check on the "Show reports for Activities done"
    #And I click on more option
    #And I select any option from the more list
    #Then I should be able to see the more option changed to the value selected from the list
    #And I click on replaced option
    #Then I should be able to see the list "This week, Last Month, This Month, Last Quarter, This Quarter"
#
  #@wip
  #Scenario: To verify the display of timeline bar on selecting the corresponding radio button on group report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Group" report
    #And I check on the "Show reports for Requirements created / re-opened"
    #And I click on more option
    #And I select any option from the more list
    #Then I should be able to see the more option changed to the value selected from the list
    #And I click on replaced option
    #Then I should be able to see the list "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days"
    #When I check on the "Show reports for Activities done"
    #And I click on more option
    #And I select any option from the more list
    #Then I should be able to see the more option changed to the value selected from the list
    #And I click on replaced option
    #Then I should be able to see the list "This week, Last Month, This Month, Last Quarter, This Quarter"
#
  #@wip
  #Scenario: To verify the display of timeline bar on selecting the corresponding radio button on employer report
    #Given I am login to RMS as an "Consultant" user.
    #And I am on Reports page
    #When I click on "Group" report
    #And I check on the "Show reports for Requirements created / re-opened"
    #And I click on more option
    #And I select any option from the more list
    #Then I should be able to see the more option changed to the value selected from the list
    #And I click on replaced option
    #Then I should be able to see the list "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days"
    #When I check on the "Show reports for Activities done"
    #And I click on more option
    #And I select any option from the more list
    #Then I should be able to see the more option changed to the value selected from the list
    #And I click on replaced option
    #Then I should be able to see the list "This week, Last Month, This Month, Last Quarter, This Quarter"
#
  #@wip
  #Scenario: To verify the absence of "Include recruiters with no activities in this period" checkbox in recruiter report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #Then I should not be able to see "Include recruiters with no activities in this period"
#
  #@wip
  #Scenario: To verify the absence of "Include requirements with no data in this period" checkbox in requirement report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Requirement" report
    #Then I should not be able to see "Include requirements with no data in this period (Data available for any selected duration of only 3 monthns)"
#
  #@wip
  #Scenario: To verify the absence of "Include Groups with no data in this period" checkbox in group report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Group" report
    #Then I should not be able to see "Include Employers with no data in this period (Data available for any selected duration of only 3 months)"
#
  #@wip
  #Scenario: To verify the absence of "Include Employers with no data in this period" checkbox in employment report
    #Given I am login to RMS as an "Consultant" user.
    #And I am on Reports page
    #When I click on "Employer" report
    #Then I should not be able to see "Include Employers with no data in this period (Data available for any selected duration of only 3 months)"
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on "Show reports for Requirements created / re-opened"
    #And I select on any duration
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup(Source) filter.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on "Show reports for Requirements created / re-opened"
    #And I select on any duration
    #And I select breakup by "Source"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Source" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup(Requirement) filter.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on "Show reports for Requirements created / re-opened"
    #And I select on any duration
    #And I select breakup by "Requirement"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Requirement" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup(Group) filter.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on "Show reports for Requirements created / re-opened"
    #And I select on any duration
    #And I select breakup by "Group"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Group" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup(Employer) filter.
    #Given I am login to RMS as an "Consultant" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on "Show reports for Requirements created / re-opened"
    #And I select on any duration
    #And I select breakup by "Employer"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Employer" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the list of recruiters on requirement reports page who have visibility to the requirement created and reopened with breakup(Recruiter) filter.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Requirement" report
    #And I click on "Show reports for Requirements created / re-opened"
    #And I select on any duration
    #And I select breakup by "Recruiter"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Recruiter" breakup against the recruiters with some activity done in the requirements filtered and those without any activity       should be filtered out
#
  #@wip
  #Scenario: To verify the list of recruiters on group reports page who have visibility to the requirement created and reopened with breakup(Recruiter) filter.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Group" report
    #And I click on "Show reports for Requirements created / re-opened"
    #And I select on any duration
    #And I select breakup by "Recruiter"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Recruiter" breakup against the recruiters with some activity done in the requirements filtered and those without any activity       should be filtered out
#
  #@wip
  #Scenario: To verify the list of recruiters on employer reports page who have visibility to the requirement created and reopened with breakup(Recruiter) filter.
    #Given I am login to RMS as an "Consultant" user.
    #And I am on Reports page
    #When I click on "Employer" report
    #And I click on "Show reports for Requirements created / re-opened"
    #And I select on any duration
    #And I select breakup by "Recruiter"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Recruiter" breakup against the recruiters with some activity done in the requirements filtered and those without any activity       should be filtered out
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup filter.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on "Show reports for Activities done"
    #And I select on any duration
    #And I select breakup by "Source"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Source" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup filter.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on "Show reports for Activities done"
    #And I select on any duration
    #And I select breakup by "Requirement"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Requirement" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup filter.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on "Show reports for Activities done"
    #And I select on any duration
    #And I select breakup by "Group"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Group" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup filter.
    #Given I am login to RMS as an "Consultant" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on "Show reports for Activities done"
    #And I select on any duration
    #And I select breakup by "Employer"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Employer" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup filter.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Requirement" report
    #And I click on "Show reports for Activities done"
    #And I select on any duration
    #And I select breakup by "Recruiter"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Recruiter" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup filter.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Group" report
    #And I click on "Show reports for Activities done"
    #And I select on any duration
    #And I select breakup by "Recruiter"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Recruiter" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the list of recruiters on reports page who have visibility to the requirement created and reopened with breakup filter.
    #Given I am login to RMS as an "Consultant" user.
    #And I am on Reports page
    #When I click on "Employer" report
    #And I click on "Show reports for Activities done"
    #And I select on any duration
    #And I select breakup by "Recruiter"
    #And I generate the report with configuration
    #Then I should be able to see the "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be only able to see the list of recruiters having the visibility with the requirement.
    #And I should only be able to see the "Recruiter" breakup against the recruiters with some activity done in the requirements filtered
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in recruiter report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I scroll to the radio button with label "Show requirements created in this period"
    #Then I should be able to see a checkbox "Comparison with previous period" below the radio button
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in requirement report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Requirement" report
    #And I scroll to the radio button with label "Show requirements created in this period"
    #Then I should be able to see a checkbox "Comparison with previous period" below the radio button
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in group report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Group" report
    #And I scroll to the radio button with label "Show requirements created in this period"
    #Then I should be able to see a checkbox "Comparison with previous period" below the radio button
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in employer report
    #Given I am login to RMS as an "Consultant" user.
    #And I am on Reports page
    #When I click on "Employer" report
    #And I scroll to the radio button with label "Show requirements created in this period"
    #Then I should be able to see a checkbox "Comparison with previous period" below the radio button
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Group" report
    #And I scroll to the radio button with label "Show requirements created in this period"
    #And I select the report type "Hourly"
    #Then I should be able to see a checkbox "Comparison with previous period" below the radio button disabled
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Group" report
    #And I scroll to the radio button with label "Show requirements created in this period"
    #And I select the report type "Daily"
    #Then I should be able to see a checkbox "Comparison with previous period" below the radio button disabled
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Group" report
    #And I scroll to the radio button with label "Show requirements created in this period"
    #And I select the report type "Consolidated"
    #Then I should be able to see a checkbox "Comparison with previous period" below the radio button enabled
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in recruiter report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on the radio button with label "Show requirements created in this period"
    #And I select any duration in the requirement creation time period
    #And I check the checkbox with label "Comparison with previous period"
    #And I click on generate report
    #Then I should be able to see the message "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy" on reports data page.
    #And I should be able to see the same data in 2 parts one referring to the time period selected and another referring to the same time duration preceeding the one         selected
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in requirement report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Requirement" report
    #And I click on the radio button with label "Show requirements created in this period"
    #And I select any duration in the requirement creation time period
    #And I check the checkbox with label "Comparison with previous period"
    #And I click on generate report
    #Then I should be able to see the message "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy" on reports data page.
    #And I should be able to see the same data in 2 parts one referring to the time period selected and another referring to the same time duration preceeding the one         selected
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in employer report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Employer" report
    #And I click on the radio button with label "Show requirements created in this period"
    #And I select any duration in the requirement creation time period
    #And I check the checkbox with label "Comparison with previous period"
    #And I click on generate report
    #Then I should be able to see the message "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy" on reports data page.
    #And I should be able to see the same data in 2 parts one referring to the time period selected and another referring to the same time duration preceeding the one         selected
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in group report
    #Given I am login to RMS as an "Consultant" user.
    #And I am on Reports page
    #When I click on "Group" report
    #And I click on the radio button with label "Show requirements created in this period"
    #And I select any duration in the requirement creation time period
    #And I check the checkbox with label "Comparison with previous period"
    #And I click on generate report
    #Then I should be able to see the message "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy" on reports data page.
    #And I should be able to see the same data in 2 parts one referring to the time period selected and another referring to the same time duration preceeding the one         selected
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in recruiter report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter" report
    #And I click on the radio button with label "Show reports for Activities done"
    #And I select any duration in the activity time period
    #And I check the checkbox with label "Comparison with previous period"
    #And I click on generate report
    #Then I should be able to see the message "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy" on reports data page.
    #And I should be able to see the same data in 2 parts one referring to the time period selected and another referring to the same time duration preceeding the one         selected
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in requirement report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Requirement" report
    #And I click on the radio button with label "Show reports for Activities done"
    #And I select any duration in the activity time period
    #And I check the checkbox with label "Comparison with previous period"
    #And I click on generate report
    #Then I should be able to see the message "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy" on reports data page.
    #And I should be able to see the same data in 2 parts one referring to the time period selected and another referring to the same time duration preceeding the one         selected
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in employer report
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Employer" report
    #And I click on the radio button with label "Show reports for Activities done"
    #And I select any duration in the activity time period
    #And I check the checkbox with label "Comparison with previous period"
    #And I click on generate report
    #Then I should be able to see the message "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy" on reports data page.
    #And I should be able to see the same data in 2 parts one referring to the time period selected and another referring to the same time duration preceeding the one         selected
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in group report
    #Given I am login to RMS as an "Consultant" user.
    #And I am on Reports page
    #When I click on "Group" report
    #And I click on the radio button with label "Show reports for Activities done"
    #And I select any duration in the activity time period
    #And I check the checkbox with label "Comparison with previous period"
    #And I click on generate report
    #Then I should be able to see the message "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy" on reports data page.
    #And I should be able to see the same data in 2 parts one referring to the time period selected and another referring to the same time duration preceeding the one         selected
#
  #@wip
  #Scenario: To verify the change in text of comparison with previous time period in recruiter report
    #Given I am login to RMS as an "Consultant" user.
    #And I am on Reports page
    #When I click on "Employer" report
    #And I click on the radio button with label "Show reports for Activities done"
    #And I select any duration in the activity time period
    #And I check the checkbox with label "Comparison with previous period"
    #And I select the breakup "Requirement,Group/Employer,Source".
    #And I click on generate report
    #Then I should be able to see the message "Data of Activities done from dd-Mon-yyyy to dd-Mon-yyyy" on reports data page.
    #And I should be able to see the same data in 2 parts one referring to the time period selected and another referring to the same time duration preceeding the one         selected
    #And I should be able to see the breakup respected in data corresponding to the both the time periods
#
  #@wip
  #Scenario: To verify the time period of reports get saved when the report is saved.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Employer" report
    #And I scroll down and click on the radio button "Show reports for Requirements created / re-opened"
    #And I select any duration
    #And I check the checkbox with label "Save this Report"
    #Then I should be able to see the text box with label "Report Name"
    #When I fill in the name of the report.
    #And I click on "Save and Generate Report"
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #When I navigate to the "https://rms.naukri.com/reports/scheduleList"
    #Then I should be able to see the report saved with the name provided above
    #When I "edit" the report
    #Then I should be able to see the same duration selected.
#
  #@wip
  #Scenario: To verify the time period of reports get saved when the report is saved.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Employer" report
    #And I scroll down and click on the radio button "Show reports for Activities done"
    #And I select any duration
    #And I check the checkbox with label "Save this Report"
    #Then I should be able to see the text box with label "Report Name"
    #When I fill in the name of the report.
    #And I click on "Save and Generate Report"
    #Then I should be able to see the "Time period of activities done: dd Mon yyyy -dd Mon yyyy’"
    #When I navigate to the "https://rms.naukri.com/reports/scheduleList"
    #Then I should be able to see the report saved with the name provided above
    #When I "edit" the report
    #Then I should be able to see the same duration selected.
#
  #@wip
  #Scenario: To verify the time period of reports get saved when the report is saved.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Employer" report
    #And I scroll down and click on the radio button "Show reports for Requirements created / re-opened"
    #And I select any duration
    #And I click on "Generate Report"
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #When I click on Modify button
    #Then I should be able to see the same duration selected.
#
  #@wip
  #Scenario: To verify the time period of reports get saved when the report is saved.
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Employer" report
    #And I scroll down and click on the radio button "Show reports for Activities done"
    #And I select any duration
    #And I select any duration
    #And I click on "Generate Report"
    #Then I should be able to see the "Time period of activities done: dd Mon yyyy -dd Mon yyyy"
    #When I click on Modify button
    #Then I should be able to see the same duration selected.
#
  #@wip
  #Scenario: To verify the report is generated on the requirement creation date when requirement creation date filter is selected
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Employer" report
    #And I scroll down and click on the radio button "Show reports for Requirements created / re-opened"
    #And I select any duration
    #And I click on "Generate Report"
    #Then I should be able to see the "Data of Requirements created from dd-Mon-yyyy to dd-Mon-yyyy"
    #And I should be able to see the data filtered according to "Show reports for Requirements created / re-opened"
    #And I should be able to see no data filtered according to "Show reports for Activities done"
#
  #@wip
  #Scenario: To verify the report is generated on the activities when activity done filter is selected
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Employer" report
    #And I scroll down and click on the radio button "Show reports for Activities done"
    #And I select any duration
    #And I click on "Generate Report"
    #Then I should be able to see the "Time period of activities done: dd Mon yyyy -dd Mon yyyy"
    #And I should be able to see the data filtered according to "Show reports for Activities done"
    #And I should be able to see no data filtered according to "Show reports for Requirements created / re-opened"
#
  #@wip
  #Scenario: To check the behaviour of Hourly Report Type when activity done is selected on basis of 4 days
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Employer" report
    #And I scroll down and click on the radio button "Show reports for Activities done"
    #And I select option "Yesterday"
    #Then I can see hourly Report type "enabled"
    #When I select option "Last 3 Days"
    #Then I can see hourly Report type "enabled"
    #When I select option "Last 7 Days"
    #Then I can see hourly Report type "disabled"
    #When I select option "Last 30 Days"
    #Then I can see hourly Report type "disabled"
    #When I select option "Last 90 Days"
    #Then I can see hourly Report type "disabled"
#
  #@wip
  #Scenario: To check the behaviour of Hourly Report Type when activity done is selected on basis of 4 days
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Employer" report
    #And I scroll down and click on the radio button "Show reports for Requirements created / re-opened"
    #And I select option "Yesterday"
    #Then I can see hourly Report type "enabled"
    #When I select option "Last 3 Days"
    #Then I can see hourly Report type "enabled"
    #When I select option "Last 7 Days"
    #Then I can see hourly Report type "disabled"
    #When I select option "Last 30 Days"
    #Then I can see hourly Report type "disabled"
    #When I select option "Last 90 Days"
    #Then I can see hourly Report type "disabled"
#
  #@wip
  #Scenario: To check the behaviour of Hourly Report Type when activity done is selected on basis of 4 days
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Employer" report
    #And I scroll down and click on the radio button "Show reports for Activities done"
    #And I click on Custom
    #Then I should be able to see the Hourly enabled when difference between to and from date is 2 days max
#
  #@wip
  #Scenario: To check the behaviour of Hourly Report Type when activity done is selected on basis of 4 days
    #Given I am login to RMS as an "Enterprise" user.
    #And I am on Reports page
    #When I click on "Recruiter/Requirement/Employer" report
    #And I scroll down and click on the radio button "Show reports for Requirements created / re-opened"
    #And I click on Custom
    #Then I should be able to see the Hourly enabled when difference between to and from date is 2 days max
  @RMSBUG-3378 @RMSOldReports @RMS @LiveBUGS @NewAgainCheck
  Scenario: Verify User is able to see the report when clicked on Comparison checkbox for Last 3 Days
    Given User login to the application "settingsPage" using "Report" of "Enterprise2" user
    When User is on "ReportsPage" page
    And I click on "Requirement" report
    And User Clears All Recruiters
    And User select below recruiter from recruiter column
      |anima.taraiya@naukri.com|animasubuser1@yopmail.com|newsubuser@yopmail.com|
    And User select below column from Select column
      |Total Responses|Shortlisted|
    And I click on radio button "Show reports for Activities done"
    And User Selects "Last 3 Days" for Activities Done
    And User clicks on comparison checkbox
    And User click on Generate Report button
    Then User verify "Requirement Id" column is displayed in report
    And User verify "Requirement" column is displayed in report
    And User verify "Total Responses" column is displayed in report

  @RMSBUG-3378 @RMSOldReports @RMS @LiveBUGS @NewAgainCheck
  Scenario: Verify User is able to see the report when clicked on Comparison checkbox for Yesterday
    Given User login to the application "settingsPage" using "Report" of "Enterprise2" user
    When User is on "ReportsPage" page
    And I click on "Requirement" report
    And User Clears All Recruiters
    And User select below recruiter from recruiter column
      |anima.taraiya@naukri.com|animasubuser1@yopmail.com|newsubuser@yopmail.com|
    And User select below column from Select column
      |Total Responses|Shortlisted|
    And I click on radio button "Show reports for Activities done"
    And User Selects "Yesterday" for Activities Done
    And User clicks on comparison checkbox
    And User click on Generate Report button
    And User verify "Requirement Id" column is displayed in report
    And User verify "Requirement" column is displayed in report


  @RMSBUG-3378 @RMSOldReports @RMS @LiveBUGS @NewAgainCheck
  Scenario: Verify User is able to see the report when clicked on Comparison checkbox for Last 7 Days
    Given User login to the application "settingsPage" using "Report" of "Enterprise2" user
    When User is on "ReportsPage" page
    And I click on "Requirement" report
    And User Clears All Recruiters
    And User select below recruiter from recruiter column
      |anima.taraiya@naukri.com|animasubuser1@yopmail.com|newsubuser@yopmail.com|
    And User select below column from Select column
      |Total Responses|Shortlisted|
    And I click on radio button "Show reports for Activities done"
    And User Selects "Last 7 Days" for Activities Done
    And User clicks on comparison checkbox
    And User click on Generate Report button
    And User verify "Requirement Id" column is displayed in report
    And User verify "Requirement" column is displayed in report


  @RMSOldReports @RMSBUG-3429 @RMS @LiveBUGS @NewAgainCheck
  Scenario: Verify User is able to see the message of footer on report page
    Given User login to the application "settingsPage" using "Report" of "Enterprise2" user
    When User is on "ReportsPage" page
    And I click on "Requirement" report
    And User Clears All Recruiters
    And User select below recruiter from recruiter column
      |anima.taraiya@naukri.com|animasubuser1@yopmail.com|newsubuser@yopmail.com|
    And User select below column from Select column
      |Total Responses|Shortlisted|
    And I click on radio button "Show reports for Activities done"
    And User Selects "Last 7 Days" for Activities Done
    And User clicks on comparison checkbox
    And User Verify "All rights reserved @ 2017 Info Edge (India) Ltd." is visible in footer of report page

  @RMSBUG-3415 @RMSOldReports @RMS @LiveBUGS @NewAgainCheck
  Scenario: Verify User is able to see the report when clicked on Comparison checkbox for Yesterday
    Given User login to the application "settingsPage" using "Report" of "Enterprise2" user
    When User is on "ReportsPage" page
    And I click on "Requirement" report
    And User Clears All Recruiters
    And User select below recruiter from recruiter column
      |anima.taraiya@naukri.com|animasubuser1@yopmail.com|newsubuser@yopmail.com|
    And User select below column from Select column
      |Total Responses|Shortlisted|
    And I click on radio button "Show reports for Requirements created / re-opened"
    And I click on more of "requirement creation"
    Then I should be able to see the "requirement creation" more list "Yesterday, Last 3 Days, Last 7 Days, Last 30 Days, Last 90 Days"

  @RMSBUG-3415 @RMSOldReports @RMS @LiveBUGS @NewAgainCheck
  Scenario: Verify User is able to see the report when clicked on Comparison checkbox for Yesterday
    Given User login to the application "settingsPage" using "Report" of "Enterprise2" user
    When User is on "ReportsPage" page
    And I click on "Requirement" report
    And User Clears All Recruiters
    And User select below recruiter from recruiter column
      |anima.taraiya@naukri.com|animasubuser1@yopmail.com|newsubuser@yopmail.com|
    And User select below column from Select column
      |Total Responses|Shortlisted|
    And I click on radio button "Show reports for Activities done"
    And I click on more of "activities done"
    Then I should be able to see the "activities done" more list "This Week, Last Month, This Month, Last Quarter, This Quarter"


  @RMSBUG-3442 @RMSOldReports @RMS @LiveBUGS @NewAgainCheck
  Scenario: Verify User is able to see the report when clicked on Comparison checkbox for Yesterday
    Given User login to the application "settingsPage" using "Superuser" of "Eapps" user
    When User is on "ReportsPage" page
    And  User Selects "Edit" for Activities Done
    And User select below recruiter from recruiter column
      |YASHIKA.GUPTA|abhijeet.anand@yopmail.com|yashika.gupta.001@yopmail.com|
    And User select below column from Select column
      |Total Responses|Shortlisted|Viewed|Downloaded|Emailed|Interview|
    And I click on radio button "Show reports for Activities done"
    And User click on Generate Report button
    Then User verify "Total Responses" column is displayed in report
