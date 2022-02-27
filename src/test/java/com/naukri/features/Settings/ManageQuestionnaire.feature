Feature: Manage Questionnaire

	@RMSBUG-3050 @Settings @newScenariosAdded @Smoke
  Scenario: Verify user able to add questionnaire when no questionnaire are available
    Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
    When user click on "Manage Questionnaires" link
    And User delete any questionnaire if already present
    And user click on "Add a New Questionnaire" link
    Then User should see "Add New Questionnaire" lightbox
    And User adds random Questionnaire Name
    And user click on "Add New Question" link
    And User adds a Question "What is your expected salary?" to questionnaire
    And User selects "Radio Button" radio button for Choose Answer Types
    And User adds options for the answer
      | option1 |
      | option2 |
    And user click on "Save Question" link
    When user click on "Save" link
    Then User should see message "Questionnaire created." for questionnaire
