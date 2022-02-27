
@notAutomatable
Feature: Test Cases for Billing Excel Dump - RMS2-2419
  This feature file contains test scenarios and bugs for excel dump
	
	@id:1
  Scenario: Excel Dump for To be Generated Tab without/With PI Creation
    Given I am on Billing Dashboard after moving candidate to Billing Stage
    When I click on download excel dump
    And Select the current date
    And Click on download excel dump
    Then Excel Dump should download
    And Excel dump must contain Correct values
    When I generate PI of the associated candidate
    And Download Excel dump for that candidate
    Then All Values must be correct
    
  @id:2  
	Scenario: Excel Dump for Outstanding Tab with Invoice Generation and RMS2-3011
		Given I am on Billing Dashboard after moving candidate to Billing Stage
		When I generate Invoice for the associated candidate
		And I download excel dump
		Then All values in excel dump in Invoices tab must be correct
		When I am on Outstanding Tab
		And I download excel dump for associated candidate
		Then I should be able to download excel dump
		And All Values must be correct 
		And I data should only be present according to the date on which we have generated invoice
		
	@id:3	
	Scenario: Excel Dump for Paid, WriteOff and Refund Tab
		Given I am on Billing Dashboard after moving candidate to Billing Stage
		And I have generated invoice for the associated candidate
		When I Partially Pay for the candidate after editing the payment date
		And I download excel dump for associated candidate
		Then Data in Excel dump should be accurate for the paid tab
		And Same should be reflected in Invoices tab
		And I should only be able to get payment data in excel dump if i select the payment date as the date to download excel dump
		When I WriteOff Partial amount for current candidate
		Then Data must be refletcted for current date in WriteOff Tab in Excel Dump
		When I refund partial amount from paid amount
		Then Data must be reflected for the refunded date in Refund Tab in excel dump
		And Finally each data manipulation and transaction must be reflected in Invoices tab for the associated candidate
		
	@id:4
  Scenario: RMS2-3010 Multiple Entries in Excel Dump for Credit Note Refund
    Given I am on Billing Dashboard after moving candidate to Billing Stage
    And I have generated invoice for the associated candidate
    When I Partially Pay for the candidate after editing the payment date
    And I refund the paid amount as credit note
    And I download excel dump for credit note
    Then Multiple Entries should not be there in Excel Dump 

