@wip
Feature: All scenarios pertaining to reports

  @id:1 @RMSEN-3132
  Scenario: Requirement aging report will be visible to RM_0 for requirement created by RM_010
    Given I am logged in with user name as "RM_010"
    And I create a requirement with visibility to "all"
    And I logout
    Given I am logged in with user name as "RM_0"
    And User is on "PreConfiguredReports" page
    And I select "RM_010" as recruiter
    When I click on view all button for requirement aging
    Then I verify that requirement is visible to me

  @id:2 @RMSEN-3132
  Scenario: 
    Given I am logged in with user name as "RM_010"
    And I created a group in which I mapped RM_011,RM_000 and RM_01 as HR
    And I create a requirement with visibility to "all"
    And I logout
    And I am logged in with user name as <username>
    And User is on "PreConfiguredReports" page
    And I select <recruiter> as recruiter
    When I click on view all button for requirement aging
    Then I verify that requirement is visible to me
      | username | recruiter |
      | RM_00    | RM_000    |
      | RM_000   | me        |
      | RM_01    | me        |
      | RM_01    | RM_010    |
      | RM_01    | RM_011    |
      | RM_011   | me        |

  @id:3 @RMSEN-3132
  Scenario: 
    Given I am logged in with user name as "RM_010"
    And I created a group in which I mapped RM_011,RM_000 and RM_01 as HR
    And I create a requirement with visibility to "all"
    And I logout
    And I am logged in with user name as "RM_00"
    And User is on "PreConfiguredReports" page
    And I select "RM_000" as recruiter
    When I click on view all button for requirement aging
    Then I verify that requirement is visible to me
