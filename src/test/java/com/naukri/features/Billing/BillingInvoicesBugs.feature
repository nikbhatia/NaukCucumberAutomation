@RMS
Feature: RMS Billing and Invoices Bugs
  This Feature file covers all uncovered bugs of Billing and Invoices

  @id:1  @billing @Settings
  Scenario: RMS2-2608 , By default Billing stage is not selected in customize selection stages.
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Customize the Selection Process" link
    And user click on "Offers & Joining" Stage
    Then user validate that Billing Stage should be selected

  @id:2  @billing
  Scenario: RMS2-2610 , Prefill from template list is not getting refreshed after changing the category
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Email Templates" link
    And user add a new "Financial" template with "Payment Reminder" category
    And user add a new "Financial" template with "Invoice" category
    And user add a "Financial" template with "Invoice" category from previously created templates
    And user change the category from category list
    Then Prefill template name should be changed to Prefill from template text

  @id:3  @billing
  Scenario: RMS2-2632, Unable to save after editing the Billing detail.
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Employer " link
    And user add a new employer with billing details
    And user edit added employer and click on billing details tab
    And user add new billing detail
    When user click on edit icon after adding billing details
    And user click on category name field and click on flat fee option
    Then Verify Save button is enabled

  @id:4  @billing 
  Scenario: RMS2-2644,RMS2-2792,RMS2-2793, Billing Details is showing in Company account
    Given User login to the application "settingsPage" using "Superuser" of "Company" user
    When user click on "Manage Groups " link
    And user click on "Add Group" link
    Then Verify Billing Details tab should not be displayed

  @id:5  @billing
  Scenario: RMS2-2646, Unable to add employee address due to Billing section is throwing validation exception. Also verify Delete Employer
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Manage Employer " link
    And user click on "Add Employer" link
    When user fill mandatory fields of Employer Details and Recruiters on Add new employer page
    And user click on Billing Details tab
    And user click on Employer Address tab
    And user click on Save button On Employer Page
    Then Verify employer is added with success msg
    When user click on "Delete" option of Added Employer
    And user click on Element with Id as "deleteButton" on the Confirmation Pop Up
    Then Success ribbon as "Employer Deleted." should be displayed

  @id:7  @billing
  Scenario: RMS2-2700, validation for length is not available in proforma prefix text field.
   Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And user click on "Invoice Settings" link
    And user click on "Proforma No. prefix" tab
    And user click on "Create new prefix series" button
    When user enter "pppppppppppppppppppppppppppppppppppppppppppppppppPqqq" while Create new prefix series
    Then Only "pppppppppppppppppppppppppppppppppppppppppppppppppP" should be displayed in layout to save

  @id:10  @billingregression
  Scenario: RMS2-2760,RMS2-2794,RMS2-2779,RMS2-2820, Selected template is not being populated while sending the proforma invoice mail and 'Mail not sent' text shouldn't appear after sending the mail
   	Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I go to Account settings page and manage template section
    And I add a new proforma invoice template with content
    And I go to Billing dashboard and click on generate proforma invoice of any candidate
    And I click on generate proforma invoice button
    When I select newly added template while sending proforma invoice mail
    Then Selected template content should be displayed
    And Same should be displayed in mail preview
    When I select all the financial mail tags and click on preview
    Then Values of financial email tags should be correct
    And Proforma Invoice is attached with this mail should be displayed in footer
    When I send the proforma invoice mail for the added candidate
    Then Verify "mail not sent" text should not be displayed and right date should be there

  @id:11 @billingregression 
  Scenario: RMS2-2762,RMS2-2805, Other amount is autofilled after editing in PI and Different payable amount is displaying on the same invoice.
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I go to billing dashboard page
    And I generate PI of already added candidate whose PI is not generated yet and get its billable salary mentioned
    When I click on edit generate proforma invoice
    And I select Others for invoice rate
    Then Verify Enter Billing Amount value is empty
    When I enter "11.11" in Enter Billing Amount field
    Then Verify Payable Amount in the Invoice Layout and Top Section is same

  @id:13  @billingregression
  Scenario: RMS2-2777,RMS2-2782, Able to Fill Payment Amount and TDS above 2 Decimal Places and Able to Mark as Refunded in case of Partial Refund with more than Paid Amount
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I create candidate with default settings and move the candidate to Billing Stage
    And I go to billing dashboard page and generate the invoice of the added candidate
    And I go to Outstanding tab via link of success message of successfully moving candidate to Outstanding tab
    When I click on Mark as paid for the added candidate
    And I enter more than 2 decimal places values in Payment Amount and TDS
    Then Verify error message as "Only numeric value allowed (up to 2 decimal places)" for both amount and TDS
    And Mark paid button should be disabled
    When I mark as paid with partial payment
    And I click on refund or issue credit note for the paid amount
    And While using partial refund if i enter more than paid amount
    Then Mark as refunded button should be disabled and I should get Amount cannot be greater than the paid amount error

  @id:14 @billingregression @flaki
  Scenario: RMS2-2784, Dont use credit not working
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I create candidate with default settings and move the candidate to Billing Stage
    And I go to billing dashboard page and generate the invoice of the added candidate
    And I go to Outstanding tab via link of success message of successfully moving candidate to Outstanding tab
    When I click on Mark as paid for the added candidate
    And I mark as paid with partial payment
    And I refund paid amount as credit note
    And I click on mark as paid button
    And I click on Use Credit link
    And I click on Don't use credit link
    Then Verify Credit associated fields are not displayed

  @id:16 @billingregression
  Scenario: RMS2-2795, Incorrect warning message is displayed for Invoice generation date
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I create candidate with 90 days as Bill becomes due after and 1 days for Remind to generate Invoice and move the candidate to Billing Stage
    When I go to billing dashboard page
    Then Waring message "Invoice generation date in 1 days, invoice not yet generated." should not be displayed under candidate tuple
    
  @id:20	@billing @regression
	Scenario: RMS2-2786, Able to Save Invoice Settings after deletion of all the Registered Address
		Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
		When user click on "Invoice Settings" link
		When I delete all the registered addresses
		Then Verify save button is disabled to save the invoice settings

  @id:17 @billingregression
  Scenario: RMS2-2798,RMS2-2799, Last Used Address/Latest Added Address aren't pre-selected and Billable Rate(%) is applied each time user changes the employer address
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I create multiple candidates for a single employer with multiple addresses and percentage mode of billing and move all the candidates to billing dashboard
    And Generate Invoice of first candidate selecting other than default address and save the address
    When I click on generate invoice button for second candidate
    Then Verify Last used address is pre-selected and then generate the Invoice
    When I edit the associated employer and add another address in employer settings
    And I go to billing dashboard to generate invoice of third candidate
    Then Verify latest added address is pre-selected for invoice generation for third candidate
    When I change Bill to address from dropdown
    Then Verify Payable amount remains same in the layout and the top section

  @id:18 @billingregression
  Scenario: RMS2-2807,RMS2-2832, Invoice is not generate same as proforma invoice and Candidate Name and Designation isn't displayed while generating Invoice
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I create a candidate for a employer having multiple addresses and multiple billing details and move the candidate to Billing Stage
    When I generate PI of the candidate with all of the information updated in PI layout selected other than default
    And I click on generate Invoice for the added candidate
    Then Verify all the updated information is reflected on Invoice Layout
    When I click on generate Invoice and move to mail invoice page
    Then Verify that candidate name and designation is displayed corrrectly

  @id:19 @billingregression
  Scenario: RMS2-2810,RMS2-2808, Payable Amount is showing Incorrect Values and Joining salary is showing 0 on candidate tuple in case of no billable salary mentioned
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I create a candidate for a employer having flat fee billing details
    When While moving candidate to billing stage, I do not mention billable salary
    #Then Verify Payable amount is same as flat fee
    When I move the candidate to Billing stage and again click on changing the status to billing stage
   # Then Verify Payable amount is same as flat fee
    When I clear the billable salary which has been pre-filled same as joining salary and move the candidate to billing stage
    And I go to billing dashboard in To be generated tab
    Then Verify Joining Salary should not be zero and equal to the joining salary which mentioned while moving the candidate to billing stage

  @id:20 @billingregression
  Scenario: RMS2-2831,RMS2-2822,RMS2-2815,RMS2-2843,RMS2-2836,RMS2-2845, Candidate name is not showing on mail preview if candidate name is not available and Incorrect rest amount is pending when user left only .01 paisa after refund.
   	Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I create a candidate without candidate name for a employer having flat fee billing details and move the candidate to billing stage
    When I generate Invoice for the added candidate and moving to ouststanding tab and I hover the more opptions to download options
    Then Only Invoice download link should be displayed and payment receipt link should not be displayed
    When I click on mark as paid for full payment and candidate moves to mail payment receipt page and click on preview mail
    Then Verify In place of candidate name, candidate email is displayed in content and header of mail
    When I close the mail preview of payment receipt mail preview
    Then Verify Send button should not be enabled without filled [To] field
    When I check the save as template checkbox
    Then No validation message should be there like This field cannot be left blank.
    When I click on cancel and candidate moves to Paid tab
    And I refund the amount partially leaving only 0.01 rupee left paid
    And I click on refund again
    #Then Verify Max Refundable Amount is 0.01
    And Reflection on Text box against Payment method is changing after changing the payment mode
    When Refunded partially with 0.01 rupee
    Then Candidate should be moved to Refunded tab

  @id:21 @billingregression
  Scenario: RMS2-2819, Validation message is not appearing if user use credit note and do rest payment with another mode.
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I add two candidates for a single employer and moves both the candidates to Billing stage and Generate Invoice of the candidates
    And I mark first candidate as paid with half its total amount and refund the same as credit note
    When I click mark as paid for second candidate and use credit and do rest of payment with other payment mode totalling more than total amount
   # Then Verify error message is displayed Sum of all amounts cannot be greater than total amount
    And Mark Paid button should be disabled

  @id:22 @billingregression
  Scenario: RMS2-2823,RMS2-2850,RMS2-2821, Employer and Consultant details mentioned in Generated Invoice isn't reflecting in Credit Note and Multiple candidate tuple entries are created on Billing dashboard.
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When I create candidate for a employer having mutiple addresses and mutiple billing details and move the candidate to billing stage
    Then Verify multiple candidate tuple entries are not created on billing dashboard
    When I search for the employer associated with added candidate
    Then Only added candidate tuple should be displayed
    When I generate invoice of the added candidate changing its default address, billing details, invoice date and subtext under invoice
    And Mark candidate as fully paid and click on refund in paid tab
    Then Verify for refund as credit note, all the default details are same in credit note layout as selected while generating invoice

  @id:23 @billingregression 
  Scenario: RMS2-2834, Candidate is not moving on billing dashboard if user doesn't mapped any billing category with employer.
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    And I create a employer without any billing details
    And I create a candidate associated with created employer with new requirement without specifying any billing details
    When I click to move this candidate to billing stage
    Then No dropdown should be there for billing category
    When I move this candidate to billing stage and candidate is on billing dashboard
    Then Verify tuple is visible in To be generated tab and payment due must be --
    When I click on generate invoice
    Then Others option should be selected and associated field of Enter Billing Amount should be displayed
    When I fill Enter Billing Amount and click on generate invoice
    Then Invoice should be successfully generated and after clicking cancel for mailing, tuple should move to outstanding tab

	