@RMS
Feature: Static Data Validation Of Billing and Invoice Scenarios

  User has moved candidate to billing stage and candidate is moved to "To be generated tab"

  Background:
    Given User login to the application "rmsDashboardPage" using "Superuser" of "ConsultantPlus" user
    And  User Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "percentage" , chargeValue as "30" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "true" .
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

  @id:1 @billing
  Scenario: Verify the tuple information on outstanding tab when unpaid
    Given User is on "billingDashboard" page
    When user click on "Outstanding" tab on billing dashboard
    Then verify the candidate details tuple on outstanding tab
    And verify invoice download and hiring for is visible on outstanding tab
    And Unpaid tag,Mark paid button should be visible on outstanding tab
#    And verify the mouse hover options on tab
    And verify candidate details when we hover on candidate name

  @id:2 @billing
  Scenario: verify the fill payment details page and mark the candidate as paid
    Given user get balance to be paid
    When user click on mark paid
    Then Validate the payment details page
    When enter the 180000 amount and click on mark paid
    And user click on "Paid" tab on billing dashboard
    Then candidate tuple should be visible on paid tab

  @id:3 @billing
  Scenario: verify the tuple information on outstanding tab when partially paid
    Given user click on mark paid
    When enter the 5000 amount and click on mark paid
    Then The tag should be changed to partially paid
    And payment receipt should be visible on tuple
    When click on payment receipt
    Then verify the details on payment receipt
    When User is on "billingDashboard" page
    When user click on "Outstanding" tab on billing dashboard
#    And mouse hover on more options and refund issue credit note should be visible in more options
#    And mouse hover on balance to be paid and verify the details like total amount payable and amount paid

  @id:4 @billing
  Scenario: verify the fill payment details page and mark the candidate as paid
    When user click on mark paid
    Then Validate the payment details page
    When enter the 180000 amount and click on mark paid
    And click on cancel mail payment receipt
    Then candidate has moved to paid tab link should be visible
    When user click on "Paid" tab on billing dashboard
    Then candidate tuple should be visible on paid tab

  @id:5 @billing
  Scenario: verify the candidate tuple details on paid tab when full amount is paid
    When user click on mark paid
    And enter the 180000 amount and click on mark paid
    And user click on "Paid" tab on billing dashboard
    And Get Invoice Name and amount to be paid
    Then verify the candidate details tuple information on paid tab
    And verify the paid tag
    And mouse hover on more options and verify more options on mouse hover
    And mouse hover on amount paid and verify the details on amount paid
    Then the candidate should still be displayed in paid tab

  @id:6 @billing 
  Scenario: verify that candidate is moved to refunded tab  and refund in another mode is chosen
    When user click on mark paid
    And enter the 180000 amount and click on mark paid
    And user click on "Paid" tab on billing dashboard
    And Get Invoice Name and amount to be paid
    And click on refund in more options
    Then validate the refunded details page
    When choose refund mode as cheque
    And click on Mark as refunded
    Then validate the mail refund lightbox
    When click on cancel button
    Then the candidate tuple should be visible on refunded tab and no longer on paid tab

  @id:7 @billing
  Scenario: verify that refunded as credit note is working
    When user click on mark paid
    And enter the 180000 amount and click on mark paid
    When user click on "Paid" tab on billing dashboard
    And Get Invoice Name and amount to be paid
    And click on refund/issue credit note
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 180000 in Enter Amount
    Then the candidate should be moved to refunded tab
    And credit note option will also be displayed on the tuple in refunded tab

  @id:8 @billing
  Scenario: verify the details on refunded tab
    When user click on mark paid
    And enter the 180000 amount and click on mark paid
    When user click on "Paid" tab on billing dashboard
    And Get Invoice Name and amount to be paid
    And click on refund/issue credit note
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 180000 in Enter Amount
    Then the candidate should be moved to refunded tab
    And credit note option will also be displayed on the tuple in refunded tab

  @id:9 @billing
  Scenario: verify the details on refunded tab
    When user click on mark paid
    And enter the 180000 amount and click on mark paid
    And user click on "Paid" tab on billing dashboard
    And Get Invoice Name and amount to be paid
    And click on refund in more options
    And choose refund mode as cheque
    And click on Mark as refunded
    And click on cancel button
    And click on refunded strip
    Then verify the candidate details on refunded tab
    And refunded tag and mouse hover on more options should be visible on the tuple
    And verify the suboptions in more options
    And invoice,payment receipt,hiring for should be visible on tuple

  @id:10 @billing
  Scenario: verify that in case of partial refund as credit note , the candidate will be visible on paid and refunded tab both
    When user click on mark paid
    And enter the 180000 amount and click on mark paid
    When user click on "Paid" tab on billing dashboard
    And Get Invoice Name and amount to be paid
    And click on refund/issue credit note
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 10000 in Enter Amount
    Then credit note footer should be visible on paid tab
    And candidate tuple will also be visible on refunded tab
    And credit note footer should also be visible on refunded tab
    And verify the candidate details on mouse hover on amount refunded

  @id:11 @billing
  Scenario: Verify the candidate tuple moves to writtenoff tab in case of full writeoff and the payment status is unpaid
    When click on writeoff and do full written off amount
    Then candidate is moved to writtenoff tab link should be displayed
    When user click on "Written Off" tab on billing dashboard
    Then the candidate should be displayed in writtenoff tab
    And validate the details on writtenoff tab
    And validate mouse hover more options
    And verify the candidate details on mouse hover on candidate name and amount written off tab

  @id:12 @billing
  Scenario: verify the candidate tuple moves to writtenoff tab in case of partial writeoff and the payment status is unpaid and is also visible on outstanding tab
    When user click on Writeoff link under more options of added candidate
    And user select the option Partial writeoff
    And user fill 18000 in Writeoff amount
    And user click Writeoff button in the layout
    Then Moved candidate information should be displayed with designation as Designation - Test , Balance to be paid as 162000
    When user click on "Written Off" tab on billing dashboard
    Then Moved candidate information should be displayed with designation as Designation - Test , Amount written off as 18000 under Written Off tab
    When On Label "IN" , On mouse hover show "Written Off" Tab Information
    And On Label Amount written off , On mouse hover show Written Off Tab Information

  @id:13 @billing
  Scenario:  verify the validations on paid , refunded and written off tab
    When user click on mark paid
    And Enter "2000000" as payment amount
    Then verify the amount validation
    When enter the 18000 amount and click on mark paid
    And user click on mark paid
    And click on cancel and continue
    And click on refund in more options
    And user click on Refund Amount as "Partial Refund"
    And Enter "1800000" as enter amount
    Then verify that refunded amount cannot be greater than the paid
    When user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And Enter "1800000" as enter amount
    Then verify that refunded amount cannot be greater than the paid
    When user fill 18000 in Enter Amount
    And user click on "Outstanding" tab on billing dashboard
    And user click on Writeoff link under more options of added candidate
    And user select the option Partial writeoff
    And user fill 1800000 in Writeoff amount
    Then verify that amount cannot be greater than 162000
    When user fill 161000 in Writeoff amount
    Then Communication message Unpaid Invoice of 1000 will remain in Outstanding tab. should appear below the Writeoff amount label

  @id:14 @billing
  Scenario: Verify Finance matrix amount
    When search for created employer
    And user click on mark paid
    And enter the 1000 amount and click on mark paid
    And click on refund/issue credit note
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 500 in Enter Amount
    Then Issued credit note amount should be displayed on finanace matrix in credit left section
    When user click on mark paid
    And user click on Use Credit Link
    And enter the 100 amount in credit use and click on mark paid
    Then credit amount should be deducted from credit left on finance matrix
    When user click on mark paid
    And enter the 1000 amount with 100 as TDS and click on mark paid
    Then mouse hover on "Received in this quarter" on finance matrix TDS amount and payment amount should be displayed
    And click on refund/issue credit note
    And user click on Mode of Refund as "Refund in another mode"
    And user click on Refund Amount as "Partial Refund"
    And user fill 500 in Enter Amount for partial refund
    Then mouse hover on "Received in this quarter" on finance matrix refunded amount and payment amount should be displayed
    And user click on mark paid
    And enter the 177800 amount and click on mark paid
    Then "0" amount on finance matrix as "Pending Payment" should be displayed
    And Total invoice amount should be displayed on finanace matrix as "Received in this quarter"

  @id:15 @billing
  Scenario: Verify amount in Received in this quarter on Finance matrix
    When search for created employer
    And user click on mark paid
    And enter the 1000 amount with 100 as TDS and click on mark paid
    Then calculation of amount should be displayed with TDS on mouse hover on "Received in this quarter" in finanace matrix

  @id:16 @billing
  Scenario: Verify Finance matrix calculation for multiple users for same employer
    Given user create three candidate with same employer and default billing address and details
    When User is on "billingDashboard" page
    And user click generate invoice for all three candidates
    And user click on "Outstanding" tab on billing dashboard
    And search for created employer
    And user click on Mark Paid button for firstCandidate
    And enter the 1000 amount and click on mark paid
    And click on refund/issue credit note for first candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 500 in Enter Amount
    And user click on Mark Paid button for secondCandidate
    And enter the 1000 amount and click on mark paid
    And click on refund/issue credit note for second candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 500 in Enter Amount
    And user click on Mark Paid button for thirdCandidate
    Then Total amount "1000" of credit amount should be displayed on payment generation slip

  @id:17
  Scenario: Verify Finance matrix calculation for multiple users for different employer
    Given User is on "settingsPage" page
    And user click on "Manage Employer " link
    When user create an employer
    And user create three candidate with different employer and default billing address and details
    And User is on "billingDashboard" page
    And user click generate invoice for all three candidates
    And user click on "Outstanding" tab on billing dashboard
    And search for specific created employer
    And user click on Mark Paid button for firstCandidate
    And enter the 1000 amount and click on mark paid
    And click on refund/issue credit note for first candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 500 in Enter Amount
    And user click on Mark Paid button for secondCandidate
    And enter the 1000 amount and click on mark paid
    And click on refund/issue credit note for second candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 500 in Enter Amount
    When user create an employer
    And user create three candidate with different employer and default billing address and details
    When user click generate invoice for all three candidates
    And user click on "Outstanding" tab on billing dashboard
    And search for specific created employer
    And user click on Mark Paid button for firstCandidate
    And enter the 1000 amount and click on mark paid
    And click on refund/issue credit note for first candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 500 in Enter Amount
    And user click on Mark Paid button for secondCandidate
    And enter the 1000 amount and click on mark paid
    And click on refund/issue credit note for second candidate
    And user click on Mode of Refund as "Issue Credit Note"
    And user click on Refund Amount as "Partial Refund"
    And user fill 500 in Enter Amount
    When user click on Mark Paid button for thirdCandidate
    Then Total amount "1000" of credit amount should be displayed on payment generation slip
