
@regresssion @dataUpdates
Feature: Scenarios for Billing Data Updates


  @id:1 @regresssion @dataUpdates
  Scenario: PI Not generated and Status change other than billing stage or rejected stage
  	Given I login with consultant account
		And I create candidate and move the candidate to billing stage
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    And Added Candidate Name should be displayed in "To Be Generated" Tab under "INV --" label
    When I update added candidate status to other value from Billing and Reject 
    And User is on "billingDashboard" page
    Then All actions should be disabled to Generate PI and Invoice for candidate tuple
    When I cancel the candidate tuple
    Then Candidate tuple should move to Cancel Tab
    
    
	@id:2 @regresssion @dataUpdates
  Scenario: PI not generated and Status change to again billing stage
  	Given I login with consultant account
		And I create candidate and move the candidate to billing stage
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    And Added Candidate Name should be displayed in "To Be Generated" Tab under "INV --" label
    When I update added candidate status to other value from Billing and Reject 
    And User is on "billingDashboard" page
    Then All actions should be disabled to Generate PI and Invoice for candidate tuple
    And Info strip must display value as "The application status is changed. Its current status is Shortlisted"
    When I update added candidate status to Billing
    And I update candidate offer details
    And User is on "billingDashboard" page
    Then Added Candidate Name should be displayed in "To Be Generated" Tab under "INV --" label
    And Updated details should be visible on candidate tuple
    When I cancel the candidate tuple
    Then Candidate tuple should move to Cancel Tab
    
    
	@id:3 @regresssion @dataUpdates
  Scenario: PI Generated and Status change other than billing and then again billing
  	Given I login with consultant account
		And I create candidate and move the candidate to billing stage
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    And Added Candidate Name should be displayed in "To Be Generated" Tab under "INV --" label
    When User generate PI for the added candidate
    And I update added candidate status to other value from Billing and Reject 
    And User is on "billingDashboard" page
    Then All actions should be disabled to Generate PI and Invoice for PI Generated candidate tuple
    And Info strip must display value as "The application status is changed. Its current status is Shortlisted"
    When I update added candidate status to Billing
    And I update candidate offer details
    And User is on "billingDashboard" page
    Then Info strip must display value as "The application status is changed. Its current status is Offers & Joining - Move To Billing" 
    When I cancel the candidate tuple
    Then Candidate tuple should move to Cancel Tab
    
