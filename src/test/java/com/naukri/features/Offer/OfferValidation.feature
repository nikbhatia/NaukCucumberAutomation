@RMS @RMSOffer @RMSOfferValidation 
Feature: To verify Validations on Candidates moved to Offer Stage 

Background: To verify profile creation through Add a Single Profile flow 
	Given I login into RMS as "Enterprise.Super_user"
	When User is on "settingsPage" page
 	When user click on "Offer Generation Module On/Off " link
  And uncheck the switch Offer generation module on settings page
  And click on set offer generation settings 
	When User is on "addSingleProfile" page
	And I fill in all the details of the candidate 
	And I click on Save button 
	Then I should be directed to the CV details page 
	And I should be able to see the success message "The profile has been successfully created. Add more profiles" on CV Details Page 
	When I click on status change drop down 
#	And I click on "Prospect" on DD 
#	And I should be able to see the status change message "Success! Application status has been successfully changed to Prospect" on CV Details Page 
#	When I click on status change drop down 
	And I click on first stage of offer 
	Then I should be directed to Offer Generation page 
		
@OfferValidation112312 
Scenario: Verify if cancel is clicked after filling all the offer details , candidate status should not be changed to offer 
	When I fill in all the details for Offer Generation 
	And I click on Cancel Offer button 
	Then I should see the current status of the candidate as "Prospect" 
	
@OfferValidation
Scenario: Verify offered date is prefilled as current date 
	And I should see offered date is prefilled as current date 
	
@OfferValidation
Scenario: Verify only numbers are allowed in salary textbox 
	When I enter alphanumericals and numbers in Salary textbox 
	Then I should see only numbers are allowed in salary textbox 
	
@OfferValidation
Scenario: verify validation of designation and joining salary of offer 
	When Enter designation and joining salary on offer details page 
	And clear designation field and salary field 
	Then verify validation messages of designation and joining salary "This field cannot be left blank."

@OfferValidation123sdfgh 
Scenario: To verify that joining date is reset if offered date is set ahead of joining date	
	When select offered date ahead of joining date 
	Then verify choose date should be displayed under "Candidate's tentative joining date"
