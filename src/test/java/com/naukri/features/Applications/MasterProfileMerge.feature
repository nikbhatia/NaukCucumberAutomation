@wip
Feature: To verify the scenarios of Master profile Merge

	Background:
		Given User login to the application "duplicateSettings" using "Superuser" of "Enterprise" user
		And User deletes all the duplicate rules applied
	
	@wip
  Scenario: To verify the merge of master profiles on case of emails only
    When I select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name for "first" profile
    And I fill in the email of the candidate of "first" profile
    And I fill in the contact of the candidate for "first" profile
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And I should be able to see the candidate name I entered while creation
    And I should be able to see the candidate email I entered while creation
    When I select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name  for "second" profile
    And I fill in the email of the candidate of "second" profile
    And I fill in the contact of the candidate for "second" profile
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And I should be able to see the candidate name I entered while creation
    And I should be able to see the candidate email I entered while creation
