#@tag
#Feature: DragAndDropOrderOfReportsSmoke
#Author: srissti.tyagi@naukri.com
#
 #@id:1 @RmsReportsSmoke
  #Scenario: To verify the functionality of customize link
    #Given I am on Dashboard Reports
    #When I click on Customize link
    #Then Verify that DD list with ArrangeWidgets heading is visible on click
    #
 #@id:2 @RmsReportsSmoke
  #Scenario: To verify that All report names are visible for enterprise superuser
    #Given I am on Dashboard Reports
    #When I click on ReportsNameDD
    #And I get the elements from ReportsNameDD
    #And I click on Customize link
    #Then Verify that DD list has all the reports name except for SaveSchedule
    #
 #@id:3 @RmsReportsSmoke1
  #Scenario: To verify that Recruiter Activity Report is not visible to Subusers who are not TL
    #Given I am on Dashboard Reports
    #When I logout from RMS 
    #And I login to RMS from a NonHrSpoc Subuser and land on Dashboard page
    #And I click on Customize link
    #Then Verify that Recruiter Activity Report is not visible for NonTL
    #When I logout from RMS 
    #And I login to RMS from a TL Subuser and land on reportsDashboard page
    #And I click on Customize link
    #Then Verify that Recruiter Activity Report is visible for TL
    #
 #@id:4 @RmsReportsSmoke1
  #Scenario: To verify the visibility of HMReport
    #Given I am on Dashboard Reports
    #When I logout from RMS 
    #And I login to RMS from a NonHrSpoc enterprise Subuser and land on Dashboard page
    #And I click on Customize link
    #Then Verify that HMReport Report is not visible for NonHrSpoc
    #
 #@id:5 @RmsReportsSmoke1
  #Scenario: To verify that the drag icon is visible on names of all reports when user hovers on them
    #Given I am on Dashboard Reports
    #When I click on Customize link
    #And I hover on any report name 
    #Then Verify that DragAndDrop icon is visible on hovering
    #
 #@id:6 @RmsReportsSmoke1
  #Scenario: To verify that user is able to Drag any report name to any desired position
    #Given I am on Dashboard Reports
    #When I click on Customize link
    #And I hover on any report name 
    #And I get the Report name that is reordered
    #And I Drag one row to another place
    #And I click on Apply 
    #And I wait for Reports to load
    #Then Verify that Order is changed
    #
 #@id:7 @RmsReportsSmoke1
  #Scenario: To verify that the order set by the user remains same until and unless changed by the user himself
    #Given I am on Dashboard Reports
    #When I click on Customize link
    #And I hover on any report name 
    #And I get the Report name that is reordered
    #And I Drag one row to another place
    #And I click on Apply 
    #And I wait for Reports to load
    #And I logout from RMS 
    #And I am on the Dashboard Reports
#		Then Verify that Order is changed
    #
 #@id:8 @RmsReportsSmoke
  #Scenario: To verify that Save and schedule Widget is visible at the top only - if any report is saved
    #Given I am on Dashboard Reports
   #	Then I verify that SavedAndScheduledIs visible at top
   #	
 #@id:9 @RmsReportsSmoke1
  #Scenario: To verify that all other basic functionality should function properly
    #Given I am on Dashboard Reports
    #When I click on Customize link
    #And I hover on any report name 
    #And I Drag one row to another place
    #And I click on Apply 
    #And I wait for Reports to load
    #And I click on ReportsNameDD
    #Then Verify that ReportsNameDD remains same
    #
 #@id:10 @RmsReportsSmoke
  #Scenario: To verify that option of Customizing the reports is visible only on dashboard
    #Given I am on Dashboard Reports
    #Then I verify that Customize link is visible here
    #When I go to RequirementTATReports
    #Then I check if the report is loaded first
    #And I verify that Customize link is not visible here
 