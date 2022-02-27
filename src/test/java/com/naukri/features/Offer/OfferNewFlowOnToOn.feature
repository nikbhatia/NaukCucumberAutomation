@RMSOfferNewFlow @OfferNewFlowOnToOn @TestTag1234
Feature: TO verify new offer flow when switch is ON and then turned ON.

	Background: 
    Given I login into RMS as "Enterprise.Super_user"
    And User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " offer generation link
    When I turn the "offerGenerationModuleOnOff" offer generation permission button to "on"

  Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Offer Details Pending' and now switch is ON, on clicking Edit, Tab1 for New Offer flow is opened and values are not prefilled
  	When I add candidate using API for "Enterprise.Super_user" without any group
  	And I navigate to requirment inbox page
    And I get requirement ID from the page
    And I navigate to profile project inbox page for the candidate
    Then I should see candidate on profile project inbox page
    When I select profile 1 on profile listing page
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I change the status of the candidates to "Offer Round"
    And I click on update on the bulk status layer
    Then I should be able to see the success message as "Success! Application Status have been successfully changed to Offer"
    When I navigate to CV details for the candidate
    Then I should see "Offer Details Pending" offer status on CV Details page
    And I click Edit Offer button
    Then I should be directed to "Input Offer Details" tab of Offer New Flow
    
  Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Offer Details Pending' and now switch is ON, on clicking Fill Offer Details, Tab1 for New Offer flow is opened and values are not prefilled
  	When I add candidate using API for "Enterprise.Super_user" without any group
  	And I navigate to requirment inbox page
    And I get requirement ID from the page
    And I navigate to profile project inbox page for the candidate
    Then I should see candidate on profile project inbox page
    When I select profile 1 on profile listing page
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I change the status of the candidates to "Offer Round"
    And I click on update on the bulk status layer
    Then I should be able to see the success message as "Success! Application Status have been successfully changed to Offer"
    When I navigate to CV details for the candidate
    Then I should see "Offer Details Pending" offer status on CV Details page
    And I click Fill Offer Details link on CV details page
    Then I should be directed to "Input Offer Details" tab of Offer New Flow
    
  Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Mail To Candidate Pending' and now switch is ON, on clicking Edit, Tab1 for New Offer flow is opened and values are prefilled
  	And Navigate to Salary Rule Listing Page
    And I create a new salary template in "confirm" state
  	When I add candidate using API for "Enterprise.Super_user" without any group
  	And I navigate to CV details for the candidate
  	And I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to "Input Offer Details" tab of Offer New Flow
    And I click Select Salary-Breakup Template dropdown on new offer layer
    And I select confirm salary template in Select Salary-Breakup Template dropdown
    And enter "string" value in "Offered Designation" field
    And select a date "2" days for current date in "Offered on" datepicker
    And select a date "4" days for current date in "Candidate's tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And user click on "Next" button
    Then I should see message "Offer Details saved. Application stage updated to Offer" on new Offer layer
    And user click on "Cancel" button
    Then I should see "Mail to Candidate Pending" offer status on CV Details page
    And I click Edit Offer button
    Then I should be directed to "Input Offer Details" tab of Offer New Flow
  
  Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Mail To Candidate Pending (click COMPOSE MAIL)' and now switch is ON, on clicking Compose Mail, Tab2(If offer pdf generated) else Tab3 for New Offer flow is opened and values are prefilled
  	When I add candidate using API for "Enterprise.Super_user" without any group
  	And I navigate to CV details for the candidate
  	And I click on status change drop down
    And I click on first stage of offer
    Then I should see new offer layer
    And I click Select Salary-Breakup Template dropdown on new offer layer
    And I select confirm salary template in Select Salary-Breakup Template dropdown
    And enter "string" value in "Offered Designation" field
    And select a date "2" days for current date in "Offered on" datepicker
    And select a date "4" days for current date in "Candidate's tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And user click on "Next" button
    Then I should see message "Offer Details saved. Application stage updated to Offer" on new Offer layer
    And user click on "Cancel" button
    Then I should see "Mail to Candidate Pending" offer status on CV Details page
    And I click on Compose Mail link
    Then I should be directed to "Generate Offer Letter" tab of Offer New Flow
  
	@testcase_newOffer_1
  Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Candidate’s Reply Pending' and now switch is ON, on clicking Edit, Tab1 for New Offer flow is opened and values are prefilled
  	When I add candidate using API for "Enterprise.Super_user" without any group
  	And I navigate to CV details for the candidate
  	And I click on status change drop down
    And I click on first stage of offer
    Then I should see new offer layer
    And I click Select Salary-Breakup Template dropdown on new offer layer
    And I select confirm salary template in Select Salary-Breakup Template dropdown
    And enter "string" value in "Offered Designation" field
    And select a date "2" days for current date in "Offered on" datepicker
    And select a date "4" days for current date in "Candidate's tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And user click on "Next" button
    Then I should see message "Offer Details saved. Application stage updated to Offer" on new Offer layer
    And I click "Only Salary Breakup" radio button on new offer layer
    Then I should see Zoho editor on second stepper
    And I click on Generate and Attach Offer Letter button
    Then I should see attached offer letter and download button on third stepper
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Candidate's Reply Pending" offer status on CV Details page
    And I click Edit Offer button
    Then I should be directed to "Input Offer Details" tab of Offer New Flow

#	Offer Approval scenarios
	@testcase_newOffer_1
  Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Offer Approval Pending' and now switch is ON, on clicking Edit, Tab1 for New Offer flow is opened and values are prefilled
  	When User is on "settingsPage" page
    When user click on "Manage Groups " link
    And user click on "Add Group" link
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And user Select Recruiters & Hiring Managers and fill all other details
    And user click on "NEXT" button
    And user click on "NEXT" button
    When click on Add New offer Template
    And Enter offer approval template name
    And I save "first" Offer template name
    And Enter stage name "stage1"
    And Enter one approver as "Enterprise.Super_user"
    And Click on save template
    And user click on "SAVE" button
    And I save group ID for "Enterprise.Super_user"
    And I add candidate using API for "Enterprise.Super_user"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should see new offer layer
    And I click Select Salary-Breakup Template dropdown on new offer layer
    And I select confirm salary template in Select Salary-Breakup Template dropdown
    And enter "string" value in "Offered Designation" field
    And select a date "2" days for current date in "Offered on" datepicker
    And select a date "4" days for current date in "Candidate's tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And user click on "Next" button
    Then I should see message "Offer Details saved. Application stage updated to Offer" on new Offer layer
    And I click "Only Salary Breakup" radio button on new offer layer
    Then I should see Zoho editor on second stepper
    And I click on Generate and Attach Offer Letter button
    Then I should see attached offer letter and download button on third stepper
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I select "first" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    And I click Edit Offer button
    Then I should be directed to "Input Offer Details" tab of Offer New Flow
    
  # Also covering this scenario: 
  # Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Offer Approval Accepted' and now switch is ON, on clicking Send To Candidate, Tab3 for New Offer flow is opened and values are not prefilled
  Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Offer Approval Accepted' and now switch is ON, on clicking Edit, Tab1 for New Offer flow is opened and values are prefilled
  	And I add candidate using API for "Enterprise.Super_user"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should see new offer layer
    And I click Select Salary-Breakup Template dropdown on new offer layer
    And I select confirm salary template in Select Salary-Breakup Template dropdown
    And enter "string" value in "Offered Designation" field
    And select a date "2" days for current date in "Offered on" datepicker
    And select a date "4" days for current date in "Candidate's tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And user click on "Next" button
    Then I should see message "Offer Details saved. Application stage updated to Offer" on new Offer layer
    And I click "Only Salary Breakup" radio button on new offer layer
    Then I should see Zoho editor on second stepper
    And I click on Generate and Attach Offer Letter button
    Then I should see attached offer letter and download button on third stepper
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I select "first" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    And I "approve" the offer for the candidate
    And I should see "You have approved this offer" message on CV Details page
    And I navigate to CV details for the candidate
    Then I should see "Offer Approved by All" offer status on CV Details page
    And I click Edit Offer button
    Then I should be directed to "Input Offer Details" tab of Offer New Flow
    And I navigate to CV details for the candidate
    And I click Send to Candidate button    
    Then I should be directed to "Email Offer Letter to candidate" tab of Offer New Flow
    
	@testcase_newOffer
  Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Offer Approval Rejected' and now switch is ON, on clicking Edit, Tab1 for New Offer flow is opened and values are prefilled
  	And I add candidate using API for "Enterprise.Super_user"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should see new offer layer
    And I click Select Salary-Breakup Template dropdown on new offer layer
    And I select confirm salary template in Select Salary-Breakup Template dropdown
    And enter "string" value in "Offered Designation" field
    And select a date "2" days for current date in "Offered on" datepicker
    And select a date "4" days for current date in "Candidate's tentative joining date" datepicker
    And enter "number" value in "Label4" field
    And enter "number" value in "Label1" field
    And user click on "Next" button
    Then I should see message "Offer Details saved. Application stage updated to Offer" on new Offer layer
    And I click "Only Salary Breakup" radio button on new offer layer
    Then I should see Zoho editor on second stepper
    And I click on Generate and Attach Offer Letter button
    Then I should see attached offer letter and download button on third stepper
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I select "first" approval process from dropdown
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Offer Approval Pending" status text on CV Details page
    And I "reject" the offer for the candidate
    And I should see "You have rejected this offer" message on CV Details page
    And I navigate to CV details for the candidate
    Then I should see "Offer Approval Rejected" offer status on CV Details page
    And I click Edit Offer button
    Then I should be directed to "Input Offer Details" tab of Offer New Flow

#	Cannot be automated
  #Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Offer Accepted By Candidate' and now switch is ON, on clicking Edit, Tab1 for New Offer flow is opened and values are not prefilled
  #Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Offer Rejected By Candidate' and now switch is ON, on clicking Edit, Tab1 for New Offer flow is opened and values are prefilled
  #Scenario: To verify when switch is ON, candidate is moved to Tagged offer stage to status 'Offer Rejected By Candidate' and now switch is ON, on clicking Send New Offer, Tab1 for New Offer flow is opened and values are not prefilled