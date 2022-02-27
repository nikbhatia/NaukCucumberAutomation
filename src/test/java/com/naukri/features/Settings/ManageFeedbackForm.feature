Feature: Manage Feedback Form

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser1"

  @form
  Scenario: user is able to create new feedback form with all type of question
    When user click on "Manage Feedback Forms" link
    And user click on "Create Feedback Form" button
    Then verify user see heading "Create Feedback Form"
    When user fill feedback form name & Form title
    And user use all type of questions
    And user click on "SAVE" button
    Then verify user is able to see created feedback form

  @Settings 
  Scenario: user is able to create feedback form with only mandatory fields
    When user click on "Manage Feedback Forms" link
    Then verify that user is able to see the listed headings on page
      | Form Template Name |
      | Created By         |
      | Last Modified      |
      | Last Modified By   |
    And user click on "Create Feedback Form" button
    Then verify user see heading "Create Feedback Form"
    #When user click on "SAVE" button
    #Then verify user able to see error message "Feedback Form must have a name"
    When User adds a question of "Single Choice " type
    When user fill mandatory fields for feedback form
    And user click on "SAVE" button
    Then verify user is able to see created feedback form

  @Settings 
  Scenario: user is able to edit feedback form
    When user click on "Manage Feedback Forms" link
    And user click on "Create Feedback Form" button
    Then verify user see heading "Create Feedback Form"
    When User adds a question of "Single Choice " type
    When user fill mandatory fields for feedback form
    And user click on "SAVE" button
    Then verify user is able to see created feedback form
    When user click on "Edit" link
    Then verify user see heading "Edit Feedback Form"
    When User adds a question of "Multiple Choice " type
    And User adds a question of "Short Paragraph " type  
    And user click on "SAVE" button
    Then verify user is able to see created feedback form

  @Settings 
  Scenario: user is able to view already created preview feedback form
    When user click on "Manage Feedback Forms" link
    And user click on "Create Feedback Form" button
    Then verify user see heading "Create Feedback Form"
    When user fill mandatory fields for feedback form
    And User adds a question of "Short Paragraph " type
    And User adds a question of "Star Rating " type
    And user click on "SAVE" button
    Then verify success message "New form has been added successfully"
    And verify user is able to see created feedback form
    When user click on "Preview" link
    Then verify preview of feedback form is visible to user

  #@Settings
  #Scenario: user is able to see all columns on feedback listing page
  #	Then verify user is able to view all columns
  #
  @Settings
  Scenario: user is able to delete feedback form
    When user click on "Manage Feedback Forms" link
    And user click on "Create Feedback Form" button
    Then verify user see heading "Create Feedback Form"
    When User adds a question of "Star Rating " type
    When user fill feedback form name & Form title
    And user click on "SAVE" button
    Then verify success message "New form has been added successfully"
    And verify user is able to see created feedback form
    When user click on Delete link under feedback form
    Then verify success message "successfully deleted"

  @form
  Scenario: user is not able to view unshare feedback form
    When user click on "Manage Feedback Forms" link
    And user click on "Create Feedback Form" button
    Then verify user see heading "Create Feedback Form"
    When user fill mandatory fields for feedback form
    And user uncheck the box share with everyone
    And user click on "SAVE" button
    Then verify user is able to see created feedback form
    When I logout of RMS
    And "Enterprise" user is on Settings Page with "Subuser1"
    And user click on "Manage Feedback Forms" link
    Then feedback form is not visible to user

  @form
  Scenario: only owner of feedback form is able to edit and Delete
    When user click on "Manage Feedback Forms" link
    And user click on "Create Feedback Form" button
    Then verify user see heading "Create Feedback Form"
    When user fill mandatory fields for feedback form
    And user click on "SAVE" button
    Then verify user is able to see created feedback form
    When login with subuser
    And user go to feedback form listing page
    Then user see the template with only preview option

  @Settings
  Scenario: user is able to create feedback form by prefilling it
    When user click on "Manage Feedback Forms" link
    And user click on "Create Feedback Form" button
    Then verify user see heading "Create Feedback Form"
    When user enter same feedback form name
    And user click on "SAVE" button
    Then verify user able to see error message "Feedback form with this name already exists."
    When user fill feedback form name & Form title
    And user prefill the form by selecting already created form
    And user click on "SAVE" button
    Then verify user is able to see created feedback form

  #@form
  #Scenario: verify maximum number of question can be added
  
