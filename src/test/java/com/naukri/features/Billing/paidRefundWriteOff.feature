@RMS @billingregression
Feature: Paid Refund Written Off Scenarios
  
  
  User has moved candidate to billing stage and candidate is moved to To be generated tab

  Background:
    Given User login to the application "rmsDashboardPage" using "Superuser" of "ConsultantPlus" user
    And User Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "percentage" , chargeValue as "30" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "true" .
    When User change candidate status to "Offers & Joining" with substage as "Move To Billing" .
    And User fill "Designation - Test" in "Offered Designation" .
    And User fill "50000" in "Candidate's joining salary" .
    And User select "Monthly" as "period" for "Candidate's joining salary" in Drop Down.
    And User select calendar date for "Offered on" to be 1 days later .
    And User select calendar date for "Candidate's tentative joining date" to be 10 days later .
    And user click on "Next" button in footer On Offer Detailed Page
    And user click on "Skip" button in footer On Offer Detailed Page
    Then Moved candidate information should be displayed with designation as "Designation - Test" , joining salary as "50000"
    When User is on "billingDashboard" page
    Then User should be on "To Be Generated" Tab
    And Added Candidate Name should be displayed in "To Be Generated" Tab under "INV --" label
    When user Generate Invoice for the added candidate
    And user click on "Outstanding" tab on billing dashboard
		
	@id:1 @billing @RMS2-2750 @RMS2-2751
  Scenario: Verify the candidate mark paid in outstanding tab is present in the paid tab
  	Then User should be able to see the invoice link on the footer
    When user click on Mark Paid button
    And user fill 180000 in Payment Amount
    And user click on Mark paid button on layout
    And user click on "Paid" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as "Designation - Test" , amount paid as 180000
    
	@id:2 @billing
  Scenario: Verify the candidate mark paid in outstanding tab has TDS and payable amount validation working
    When user click on Mark Paid button
    And user fill 180000 in Payment Amount
    And user fill 1000 in TDS Amount
    Then Error message "Sum of all amounts cannot be greater than ₹180000" appears left in the footer next to Mark Paid button
    When user fill 0 in Payment Amount
    And user fill 1000 in TDS Amount
    Then Error message "Payment amount corresponding to TDS cannot be zero" appears left in the footer next to Mark Paid button
    
	@id:3 @billing
  Scenario: Verify the presence and working of the WriteOff option in outstanding tab when the invoice of the candidate isn't generated
    When user click on Writeoff link under more options of added candidate
    Then The added candidate name under the label IN and the 180000 should appear under the label Amount to be paid in the modal appearing on screen
    When user select the option Full writeoff
    And user click Writeoff button in the layout
    Then uset see the success message of movement of candidate to Written Off tab
    And user click on "Written Off" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount paid as 180000 a
    And Moved candidate information should be not displayed with designation as Designation - Test , amount paid as 180000 under Paid tab
    And Moved candidate information should be not displayed with designation as Designation - Test , amount paid as 180000 under Refunded tab
    
	@id:4 @billing
  Scenario: Verify the working of Don’t writeoff button on the Write Off Invoice modal
    When user click on Writeoff link under more options of added candidate
    Then The added candidate name under the label IN and the 180000 should appear under the label Amount to be paid in the modal appearing on screen
    When user click Don't writeoff button in the layout
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount paid as 180000 a
    And Moved candidate information should be not displayed with designation as Designation - Test , amount paid as 180000 under Paid tab
    And Moved candidate information should be not displayed with designation as Designation - Test , amount paid as 180000 under Refunded tab
    And Moved candidate information should be not displayed with designation as Designation - Test , amount paid as 180000 under Written Off tab
    
	@id:5 @billing
  Scenario: Verify the working of partial Write Off checkbox with full amount paid
    When user click on Writeoff link under more options of added candidate
    Then The added candidate name under the label IN and the 180000 should appear under the label Amount to be paid in the modal appearing on screen
    When user select the option Partial writeoff
    And user fill 180000 in Writeoff amount
    Then Communication message Unpaid Invoice of 0 will remain in Outstanding tab. should appear below the Writeoff amount label
    When user click Writeoff button in the layout
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount written off as 180000 under Paid tab
    And Moved candidate information should be not displayed with designation as Designation - Test , amount paid as 180000 under Outstanding tab
	
	@id:6 @billing
  Scenario: Verify the working of partial Write Off checkbox with partial amount paid
    When user click on Writeoff link under more options of added candidate
    Then The added candidate name under the label IN and the 180000 should appear under the label Amount to be paid in the modal appearing on screen
    When user select the option Partial writeoff
    And user fill 18000 in Writeoff amount
    Then Communication message Unpaid Invoice of 162000 will remain in Outstanding tab. should appear below the Writeoff amount label
    When user click Writeoff button in the layout
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount written off as 18000 under Written Off tab
    And Moved candidate information should be displayed with designation as Designation - Test , amount paid as 162000 under Outstanding tab
	
	@id:7 @billing
  Scenario: Verify the working of partial payment in the outstanding tab
    When user click on Mark Paid button
    And user fill 18000 in Payment Amount
    And user click on Mark paid button on layout
    Then Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as 162000
    And Moved candidate information should be not displayed with designation as Designation - Test , amount paid as 180000 under Paid tab
    And Moved candidate information should be not displayed with designation as Designation - Test , amount paid as 180000 under Refunded tab
    And Moved candidate information should be not displayed with designation as Designation - Test , amount paid as 180000 under Written Off tab
	
	@id:8 @billing
  Scenario: Verify the functionality of partial payment in outstanding tab
    When user click on Mark Paid button
    And user fill 18000 in Payment Amount
    And user click on Mark paid button on layout
    Then Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as 162000
    When user click on Writeoff link under more options of added candidate
    When user select the option Partial writeoff
    And user fill 18000 in Writeoff amount
    Then Communication message Unpaid Invoice of 144000 will remain in Outstanding tab. should appear below the Writeoff amount label
    When user click Writeoff button in the layout
    Then Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as 162000
    When user click on "Written Off" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount written off as 18000 under Written Off tab
    When user click on "Outstanding" tab on billing dashboard
    And user click on Mark Paid button
    And user fill 62000 in Payment Amount
    And user click on Mark paid button on layout
    Then Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as 82000
    When user click on Refund/Issue credit note link under more options of added candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 18000 in Enter Amount
    And user click on "Refunded" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount refunded as 18000
	
	@id:9 @billing
  Scenario: Verify the payment functionality using the Credit Note when I partially pay the oustanding amount
    When user click on Mark Paid button
    And user fill 18000 in Payment Amount
    And user click on Mark paid button on layout
    And user click on "Outstanding" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as 162000
    When user click on Refund/Issue credit note link under more options of added candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 12400 in Enter Amount
    And user click on "Refunded" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount refunded as 12400
    When user click on "Outstanding" tab on billing dashboard
    And user click on Mark Paid button
    And user click on Use Credit Link
    Then the amount 12400 should be prefilled in the text field against Use Credit Amount Label
    When user click on Mark paid button on layout
    Then Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as 149600
    When user click on Mark Paid button
    And user fill 49600 in Payment Amount
    And user click on Mark paid button on layout
    Then Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as 100000
    When user click on Refund/Issue credit note link under more options of added candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    When user fill 67600 in Enter Amount
    And user click on "Refunded" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount refunded as 80000
    When user click on "Outstanding" tab on billing dashboard
    And user click on Mark Paid button
    And user click on Use Credit Link
    Then the amount 67600 should be prefilled in the text field against Use Credit Amount Label
    When user use other payment "Add another payment method" option
    And user fill 32400 in Payment Amount
    And user click on Mark paid button on layout
    When user click on "Paid" tab on billing dashboard
    And User search for the employer under search employer
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount paid as 180000 a  
	
	@id:10 @billing
  Scenario: Verify the payment of the outstanding candidate through credit note and other payment option
    When user click on Mark Paid button
    And user fill 12400 in Payment Amount
    And user click on Mark paid button on layout
    And user click on "Outstanding" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as 167600
    When user click on Refund/Issue credit note link under more options of added candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 12400 in Enter Amount
    And user click on "Refunded" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount refunded as 12400
    When user click on "Outstanding" tab on billing dashboard
    And user click on Mark Paid button
    And user click on Use Credit Link
    Then the amount 12400 should be prefilled in the text field against Use Credit Amount Label
    When user click on Mark paid button on layout
    And user click on Mark Paid button
    When user fill 155200 in Payment Amount
    When user click on Mark paid button on layout
    When user click on "Paid" tab on billing dashboard
    And User search for the employer under search employer
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount paid as 180000 a
	
	@id:11 @billing
  Scenario: Verify the presence of the success message after write off as
    When user click on Writeoff link under more options of added candidate
    And user select the option Partial writeoff
    And user fill 12400 in Writeoff amount
    And user click Writeoff button in the layout
    Then user is able to see the sucess message "has been successfully written off" .
    When user click on "Outstanding" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as 167600
    When user click on "Written Off" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount written off as 12400 under Written Off tab
    When user click on "Outstanding" tab on billing dashboard
    And user click on Writeoff link under more options of added candidate
    And user select the option Full writeoff
    And user click Writeoff button in the layout
    Then user is able to see the sucess message "has been successfully written off" .
    When user click on "Written Off" tab on billing dashboard
    And User search for the employer under search employer
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount written off as 180000 under Written Off tab
	
	@id:12 @billing
  Scenario: Verify the functionality of validation of credit note using writeoff functionality
    When user create three candidate with same employer and default billing address and details on paidRefundWriteOff
    And user click generate invoice for all three candidates on paidRefundWriteOff
    And user click on "Outstanding" tab on billing dashboard
    And user click on Mark Paid button for firstCanidate
    And user fill 180000 in Payment Amount
    And user click on Mark paid button on layout
    And user click on "Paid" tab on billing dashboard
    Then first Moved candidate information should be displayed with designation as Designation - Test , Amount paid as 180000 a
    When user click on Refund/Issue credit note link under more options of added first candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Full Refund"
    And user click on Mark refunded button
    And user click on "Refunded" tab on billing dashboard
    Then Moved first candidate information should be displayed with designation as Designation - Test , Amount refunded as 180000
    When user click on "Outstanding" tab on billing dashboard
    And user click on Writeoff link under more options of added candidate secondCandidate
    And user select the option Partial writeoff
    And user fill 90000 in Writeoff amount
    And user click Writeoff button in the layout
    And user click on Mark Paid button for secondCandidate on paidRefundWriteOff
    And user click on Use Credit Link
    And user click on Mark paid button on layout
    And user click on "Paid" tab on billing dashboard
    Then Moved second candidate information should be displayed with designation as Designation - Test , Amount paid as 90000
    When user click on "Outstanding" tab on billing dashboard
    And user click on Mark Paid button for thirdCandidate on paidRefundWriteOff
    And user click on Use Credit Link
    And user use other payment "Add another payment method" option
    And user fill 90000 in Payment Amount
    And user click on Mark paid button on layout
    And user click on "Paid" tab on billing dashboard
    Then Moved third candidate information should be displayed with designation as Designation - Test , Amount paid as 180000
