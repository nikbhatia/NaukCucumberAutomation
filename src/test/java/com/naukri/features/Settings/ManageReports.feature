Feature: Manage Reports

  Background:

  @Settings
  Scenario Outline: verify RMS user is able to see tabs for all reports
    When "<subscription>" user is on Settings Page with "Superuser"
    And user click on "Manage Reports" link
    Then verify that user is able to see the listed headings on page
      | Create Reports     |
      | Recruiter Report   |
      | Requirement Report |
      | Group Wise Report  |

    Examples:
      | subscription |
      | Enterprise   |
      | Company      |