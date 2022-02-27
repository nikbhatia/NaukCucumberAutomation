@regresssion
Feature: Candidate Tuple on Outstanding Section
  I want to use this template for my feature file
  
  Background: I create candidate, move to billing stage, generate Invoice and move to Outstanding Tab
  	Given I Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "flat" , chargeValue as "50000" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "false" .
  	When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
  	And User fill "Designation - Test" in "Offered Designation" .
  	And User fill "50000" in "Candidate's joining salary" .
  	And User select calendar date for "Candidate's tentative joining date" to be 10 days later .
		When user click on "Next" button in footer
		When user click on "Skip" button in footer
		Then Moved candidate information should be displayed with designation as "Designation - Test" , joining salary as "50000"
		When User is on "billingDashboard" page
 	  Then User should be on "To Be Generated" Tab
 	  And Added Candidate Name should be displayed in "To be generated" Tab under "INV --" label
 	  
	@id:1
  Scenario: Verify candidate tuple for Unpaid Tag
  	When I generate Invoice of the candidate
 	  And I click on "Outstanding" tab
    Then Added Candidate Name should be displayed in "Outstanding" Tab
    And Displayed tag should be "UNPAID" 
    And All Details for "UNPAID" candidate under "Outstanding" Tab should be displayed
    And All Options should be displayed under more options for "UNPAID" candidate under "Outstanding" Tab with "Payment Receipt" 
    

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
