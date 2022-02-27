#@billingregression
Feature: Billing Details in Recruiter Flow  tyu

	@id:1  

  Scenario Outline: Verify Added Billing Category is Pre-Selected with associated Billing Information
  	Given I Create Candidate Application for Billing Invoice for Consultant User with chargeMode as <mode> , chargeValue as <value> , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "false" .
    When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
    Then All fields should be displayed
    And Verify "info" message as <value> for label "Choose invoice rate to be applied" should appear
    When I click on "Choose invoice rate to be applied" .
    Then Added Billing Category should be displayed in Drop Down
    When I click on added Billing Category in Drop Down
    Then Verify "info" message as <value> for label "Choose invoice rate to be applied" should appear 
    
    Examples:
    |mode|value|
    | "flat" | "10000" |
    | "percentage" | "30" |
   
   @id:2 
	Scenario: Verify all validation and info messages while moving to Billing Stage
		Given I Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "flat" , chargeValue as "50000" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "false" .
  	When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
  	And I click on "Offered Designation" .
  	And I click on "Candidate's joining salary" .
  	And I click on "Offered on" .
  	Then Verify "error" message as "This field cannot be left blank." for label "Offered Designation" should appear
  	And Verify "error" message as "This field cannot be left blank." for label "Candidate's joining salary" should appear
  	And Verify "info" message as "Rupees zero" for label "Candidate's joining salary" should appear
  	And Verify "info" message as "50000" for label "Choose invoice rate to be applied" should appear
  	And Verify "info" message as "Rupees zero" for label "Candidate's Billable salary" should appear
  	And Payable Amount should be "50,000" .
  	
  	@id:3 @test234567890
	Scenario: Verify all added information while moving to Billing Stage
  	Given I Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "flat" , chargeValue as "50000" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "false" .
  	When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
  	And User fill "Designation - Test" in "Offered Designation" .
  	And User fill "50000" in "Candidate's joining salary" .
  	And User select calendar date for "Candidate's tentative joining date" to be 10 days later .
  	Then Verify "info" message as "Due date for the invoice will be" for label "Candidate's tentative joining date" should appear
		When user click on "Next" button in footer
		Then Verify success message as "Application status has been successfully changed to Offers & Joining - Move To Billing" should appear
		When user click on "Skip" button in footer
		Then Moved candidate information should be displayed with designation as "Designation - Test" , joining salary as "50000"
		
		
		 