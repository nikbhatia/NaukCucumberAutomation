@RMS @RMSOffer @RMSOfferGeneration
Feature: To verify offer generation for old flow

	Background: To verify profile creation through Add a Single Profile flow
		Given I login into RMS as "Enterprise.Super_user"
		When User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " link
    And uncheck the switch Offer generation module on settings page
    And click on set offer generation settings 
		When User is on "settingsPage" page
		And I click "Customize the Selection Process" link on Settings page
		And click on offer stage and check the first stage on offer and joining stage
		And User is on "addSingleProfile" page
		And I fill in all the details of the candidate
		And I click on Save button
		Then I should be directed to the CV details page
		And I should be able to see the success message "The profile has been successfully created. Add more profiles" on CV Details Page
		When I click on status change drop down
		And I click on first stage of offer
		Then I should be directed to Offer Generation page

	Scenario: To verify more than 5 MB file cannot be uploaded
		When I fill in all the details for Offer Generation
		And I click Next Button on Offer Details
		And I attach Offer Letter of more than 5 MB size on Attach Offer Letter page
		And I should see error message "Attachment size limit exceeded. Please attach file of less than 5 MB" on Attach Offer letter page

	Scenario: To verify template is saved from offer mail page if save template textbox is clicked
		When I fill in all the details for Offer Generation
		And I click Next Button on Offer Details
		And I attach Offer Letter on Attach Offer Letter page
		And I fill Offer Mail subject field
		And I fill Offer Mail Body field
		And I click "Save Template" link and enter template name
		Then I click Send Mail button on Attach Offer Letter
		When I navigate to Settings page
		And I click "Manage Email Templates" link on Settings page
		And I should see new Offer Template created on Manage Email Templates page

	Scenario: To verify that the "Attach Offer Details" section is disable if I have not filled the complete offer details
		And I should see Attach Offer Details section is disabled

	@TestOffer
	Scenario: To verify send mail functionality
		When I fill in all the details for Offer Generation
		And I click Next Button on Offer Details
		And I attach Offer Letter on Attach Offer Letter page
		And I fill Offer Mail subject field
		And I fill Offer Mail Body field
		Then I click Send Mail button on Attach Offer Letter
		Then I should see "Candidate's Reply Pending" status text on CV Details page
		When User is on "offerLogs" page
		Then verify offer status of candidate should be changed to "Mailed"

	@Mailer @Wip
	Scenario: To verify send reminder functionality on sending offer mail
		When I fill in all the details for Offer Generation
		And I click Next Button on Offer Details
		And I attach Offer Letter on Attach Offer Letter page
		And I fill Offer Mail subject field
		And I fill Offer Mail Body field
		Then I click Send Mail button on Attach Offer Letter
		Then I should see "Candidate's Reply Pending" status text on CV Details page
		And I click SEND REMINDER Button
		Then I should be able to see message "Reminder has been sent successfully" for reminder sent on CV Details Page
#    Then Open Personal MailBox for candidate
#    And Verify Content and subject sent to the candidate from RMS.

	@checkTC
	Scenario: To verify edit offer functionality
		When I fill in all the details for Offer Generation
		And I click Next Button on Offer Details
		And I attach Offer Letter on Attach Offer Letter page
		And I fill Offer Mail subject field
		And I fill Offer Mail Body field
		Then I click Send Mail button on Attach Offer Letter
		Then I should see "Candidate's Reply Pending" status text on CV Details page
		And I click Edit Offer button
		Then I should see "Previous offer will no longer be valid. Generating this new offer will expire the offer that is already in process." message on Offer page
		And I update all the details for Offer Generation
		And I click Next Button on Offer Details
		And I attach Offer Letter on Attach Offer Letter page
		And I fill Offer Mail subject field
		And I fill Offer Mail Body field
		Then I click Send Mail button on Attach Offer Letter
		Then I should see "Candidate's Reply Pending" status text on CV Details page
		Then I should see updated Offered details on CV Details page

	Scenario: To verify preview functionality of offer mail
		When I fill in all the details for Offer Generation
		And I click Next Button on Offer Details
		And I attach Offer Letter on Attach Offer Letter page
		And I fill Offer Mail subject field
		And I fill Offer Mail Body field
		And I click "Preview Mail" button on Attach Offer Letter page
		Then I should see Mail Subject and Mail Body in the preview

	Scenario: To verify Currency drop down values are listed correctly
		When I fill in all the details for Offer Generation
		And I change currency dropdown to "\$"
		And I click Next Button on Offer Details
		And I attach Offer Letter on Attach Offer Letter page
		And I fill Offer Mail subject field
		And I fill Offer Mail Body field
		And I click Send Mail button on Attach Offer Letter
		Then I should see "Candidate's Reply Pending" status text on CV Details page
		Then I should see "$" in "Salary Offered" in Offer Details section
		Then I should see "$" in "Salary Offered" in Offer status section

	@TestOffer
	Scenario: To verify the details should be saved when I provide complete offer details and save them and then click on skip
		When I fill in all the details for Offer Generation
		And I click Next Button on Offer Details
		And click on skip attach offer letter
		Then I should see updated Offered details on CV Details page

	@checkTC
	Scenario: To verify list of previous offers are displayed on offer cluster on CV details page
		When I fill in all the details for Offer Generation
		And I click Next Button on Offer Details
		And I attach Offer Letter on Attach Offer Letter page
		And I fill Offer Mail subject field
		And I fill Offer Mail Body field
		Then I click Send Mail button on Attach Offer Letter
		Then I should see "Candidate's Reply Pending" status text on CV Details page
		And I click on status change drop down
		And I click on first stage of offer
		And I should be directed to Offer Generation page
		And I save previous offer details
		When I fill in all the details for Offer Generation
		And I click Next Button on Offer Details
		And I attach Offer Letter on Attach Offer Letter page
		And I fill Offer Mail subject field
		And I fill Offer Mail Body field
		Then I click Send Mail button on Attach Offer Letter
		Then I should see "Candidate's Reply Pending" status text on CV Details page
		And I click " Previous Offer(s)" down arrow	on CV Details page
		Then I should see previous offer details in Offer Details section
