Feature: Manage Templates

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser1"

  @Settings
  Scenario: user is able to create new "Message" template
    When user click on "Manage Email Templates" link
    Then verify that user is able to see the listed headings on page
      | Show My Templates |
      | Status            |
      | Modified On       |
    And user click on "Add a New Template  " link
    And user select template type "Message"
    Then user should be able to see the label "Create a message template"
    When user fill mandatory fields for Message template with tags
    And user click on "SAVE TEMPLATE" button
    Then verify created template is visible to user
    When user click on Delete link under template

  @Settings @Smoke
  Scenario: user is able to create new "Status Change " template
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Status Change "
    Then user should be able to see the label "Status Change"
    When user fill mandatory fields for status template
    And user click on "Save" value
    Then verify created template is visible to user
    When user click on Delete link under template

  @Settings
  Scenario: user is able to create new "Send a Requirement" template
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Send a Requirement"
    Then user should be able to see the label "Send a requirement"
    When user fill mandatory fields for other template
    And user click on "Save" value
    Then verify created template is visible to user
    When user click on Delete link under template

  @Settings
  Scenario: user is able to create new "Forward" template
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Forward"
    Then user should be able to see the label "Forward"
    When user fill mandatory fields for other template
    And user click on "Save" value
    Then verify created template is visible to user
    When user click on Delete link under template

  @Settings
  Scenario: user is able to delete template
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Message"
    Then user should be able to see the label "Create a message template"
    When user fill mandatory fields for Message template with tags
    And user click on "SAVE TEMPLATE" button
    Then verify created template is visible to user
    When user click on Delete link under template
    Then verify success message "Template deleted"

  @Settings
  Scenario: user able to delete template in bulk
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Send a Requirement"
    When user fill mandatory fields for other template
    When user click on "Save" value
    Then verify created template is visible to user
    And user click on "Add a New Template  " link
    And user select template type "Send a Requirement"
    When user fill mandatory fields for other template
    And user click on "Save" value
    And user select 2 template
    And user click on bulk delete button for template
    Then verify success message "Templates deleted"

  @Settings
  Scenario: user is able to edit template
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Status Change "
    When user fill mandatory fields for status template
    And user click on "Save" value
    Then verify created template is visible to user
    When user click on "Edit" link
    Then verify details are filled
    When user fill fields with new data
    And user click on "Save" value
    Then verify created template is visible to user
    When user click on Delete link under template

  @Settings
  Scenario: user is able to see preview of already created template
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Message"
    Then user should be able to see the label "Create a message template"
    When user fill mandatory fields for Message template with tags
    And user click on "SAVE TEMPLATE" button
    Then verify created template is visible to user
    When user click on "Preview" link
    Then user is able to view preview of mail template

  @Settings
  Scenario: user is able to search template according to filters
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Message"
    Then user should be able to see the label "Create a message template"
    When user fill mandatory fields for Message template with tags
    And user click on "SAVE TEMPLATE" button
    And user search the template with correct filters
    Then user able to see the searched template
    When user search the template with wrong filters
    Then verify user able to see error message "There are no mail template. Add a mail template"

  @Settings
  Scenario: user is able to create template by prefilling it
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Message"
    Then user should be able to see the label "Create a message template"
    When user chose prefill from template & fill template name
    And user click on "SAVE TEMPLATE" button
    Then verify created template is visible to user
    When user click on Delete link under template

  @Settings
  Scenario: validating mandatory fields in templates
    When user click on "Manage Email Templates" link
    And user click on "Add a New Template  " link
    And user select template type "Forward"
    Then user should be able to see the label "Forward"
    When user click on "Save" value
    Then user should be able to see the label "Required Field can not be left blank"

  @Settings
  Scenario: RMS user is able to create template from Settings page
    When user click on "Create a New Email Template" link
    And user select template type "Forward"
    Then user should be able to see the label "Forward"
    When user fill mandatory fields for other template
    And user click on "Save" value
    Then verify created template is visible to user
    When user click on Delete link under template

  @Settings
  Scenario: RMS user is able to see all heading and labels on Automated Email Settings
    When user click on "Automated Email Settings" link
    Then verify that user is able to see the listed headings on page
      | Configure Automatic Mails to Candidates on Status Change                                                     |
      | Send mail with calendar invite to Interviewer(s) at interview stages where status change mails are automated |
      | Pipeline Stage                                                                                               |
      | Select template for Status Change at stage                                                                   |
      | Select template for Rejection at stage                                                                       |
