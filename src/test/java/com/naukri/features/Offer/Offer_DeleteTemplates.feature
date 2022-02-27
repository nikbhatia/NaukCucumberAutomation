@deleteAllTemplates
Feature: Offer Generation delete Offer Salary templates and Offer Document templates

  @deleteAllSalaryTemplates
  Scenario Outline: To delete all created Salary templates
    Given I login into RMS as "<userType>"
    When Navigate to Salary Rule Listing Page
    And I delete all salary templates

    Examples: 
      | userType             |
      | Enterprise.Superuser |

  @deleteAllOfferDocTemplates
  Scenario Outline: To delete all created Offer Doc templates
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    When I click "Offer Document Templates " link on Settings page
    And I delete all Offer Doc templates

    Examples: 
      | userType             |
      | Enterprise.Superuser |