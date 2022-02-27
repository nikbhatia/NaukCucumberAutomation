Feature: Hirirng Manager All Application Page

  @id:1 @HMAllApplication @RMS @HMRequisition
  Scenario: Verify user does not see bulk actions on all application page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "HMAllApplication" page
    Then Verify user does not see bulk action gnb
    And Verify that " Email " button is not displayed on requirement inbox page
    And Verify that "Forward" button is not displayed on requirement inbox page
    And Verify that " Download " button is not displayed on requirement inbox page
    And Verify that " Change Status " button is not displayed on requirement inbox page
    And Verify that "Add To Requirement " button is not displayed on requirement inbox page
    And Verify that " Add To Backup " button is not displayed on requirement inbox page
    And Verify that "Delete " button is not displayed on requirement inbox page
    And Verify user does not see bulk action checkbox

  @id:2 @HMAllApplication @RMS @HMRequisition
  Scenario: Verify count displayed on dashboard of all applications is same as count on all application page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "hiringManagerDashboard" page
    And User gets count of application from dashboard
    When User is on "HMAllApplication" page
    Then Verify user sees same count of applications as on dashboard

  @id:3 @HMAllApplication @RMS @HMRequisition
  Scenario: Verify user does not see local search or global search on All Applications page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "HMAllApplication" page
    Then Verify user does not see "global search" bar
    Then Verify user does not see "local search" bar

  @id:4 @HMAllApplication @RMS @HMRequisition
  Scenario: Verify user does not see side cluster on all apllication page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    When User is on "HMAllApplication" page
    Then Verify user does not see side cluster

  @id:5 @HMAllApplication @RMS @HMRequisition
  Scenario: To verify user is able to enter comment on all application page
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "HMAllApplication" page
    And User click on comment icon on inbox
    And User enter comment on inbox
    And User click on "Add Comment" link
    And User click on last page from pagination
    When User click on comment icon on inbox for last application
    Then User shoule be able to see entered comment
    And User should be able to see delete icon and comment date
