Feature: HM Requirement Inbox Feature

  @id:1 @HMRequirementListing @RMS @HMRequisition
  Scenario: Verify hiring manager does not see call to action buttons gnb on requirement inbox page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "requirementInbox" page
    When I go to requirement which has atleast one application
    Then Verify user does not see bulk action gnb
    And Verify that " Email " button is not displayed on requirement inbox page
    And Verify that "Forward" button is not displayed on requirement inbox page
    And Verify that " Download " button is not displayed on requirement inbox page
    And Verify that " Change Status " button is not displayed on requirement inbox page
    And Verify that "Add To Requirement " button is not displayed on requirement inbox page
    And Verify that " Add To Backup " button is not displayed on requirement inbox page
    And Verify that "Delete " button is not displayed on requirement inbox page
    And Verify that "Search in RMS " button is not displayed on requirement inbox page
    And Verify that "Search in Resdex" button is not displayed on requirement inbox page
    And Verify that "More " button is not displayed on requirement inbox page
    And Verify that "Overview" button is displayed on requirement inbox page
    And Verify user does not see bulk action checkbox

  @id:2 @HMRequirementListing @RMS @HMRequisition
  Scenario: To check the availability of the link "Advance Search" on the page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "requirementInbox" page
    When I go to requirement which has atleast one application
    Then I should be able to see the advance search link
    And The advance search link should be clickable

  @id:3 @HMRequirementListing @RMS @HMRequisition
  Scenario: To verify the expansion of local search expand DD against the search bar
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "requirementInbox" page
    When I go to requirement which has atleast one application
    And refresh the page
    And I click on expand against the "global search"
    Then I should be able to see the expand div against "global search"

  @id:4 @HMRequirementListing @RMS @HMRequisition
  Scenario: To verify the number of profiles displayed in application inbox against the page size
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "requirementInbox" page
    When I go to requirement which has atleast one application
    And I read the page display count of the inbox page
    Then I should be able to see the same count as on the page display count

  @id:5 @HMRequirementListing @RMS @HMRequisition
  Scenario: To verify user is able to enter comment on inbox SRP page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And User click on comment icon on inbox
    And User enter comment on inbox
    And User click on "Add Comment" link
    And refresh the page
    When User click on comment icon on inbox
    Then User shoule be able to see entered comment
    And User should be able to see delete icon and comment date

  @id:6 @HMRequirementListing @RMS @HMRequisition
  Scenario: To verify the facet listed on the requirement inbox
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And User click on the "Custom" under "Application Date" cluster
    And User select the current date from calander
    Then User should be able to see all Application on the current Date

  @id:7 @HMRequirementListing @RMS @HMRequisition
  Scenario: To verify the facet reading from star rating in requirement inbox
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    And I read in the data of the star rating of that particular inbox
    Then I should be able to see the sum of different star rating to be the total count of the inbox
    
   @id:8 @HMRequirementListing @RMS @HMRequisition @done
   Scenario: Verify that Hiring Manager(previously spoc) can see all application mapped with requirement
    Given I am logged in with "Enterprise" user "superuser1"
    And User is on "rmsDashboardPage" page
    And User add a new requirment with "AutomationWithNoApprovalProcess" group
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And I added a single profile in requirement
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "requirementInbox" page
    Then Verify requirement name is displayed
    And User click on count against created requirement
    Then Verify application is displayed
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager2"
    When User is on "requirementInbox" page
    Then Verify requirement name is not displayed

  @id:9 @wip
  Scenario: Verify that hiring manager can see Rejected(Recruiter) with info icon and Hiring Manager/Interviewer feedback on side cluster
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "requirementInbox" page
    And I go to requirement which has atleast one application
    Then User verify that "Rejected " is displayed under selection process cluster
    And User verify presence of info icon for "Rejected " for recruiter with text "Applications rejected by Recruiters"
    And User verify that " Hiring Manager Feedback " is displayed under selection process cluster
    And User verify presence of info icon for "Rejected " for HM with text "Applications rejected by Hiring Manager/Interviewer"
    And User verify that "Approved " is displayed under HM Feedback cluster
    And User verify that "Rejected" is displayed under HM Feedback cluster
    
  @wip
  Scenario: Verify that when if recruiter rejects application then its count is increased under Recruiter Rejected
    

