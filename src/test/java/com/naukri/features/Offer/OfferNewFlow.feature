@OfferNewFlow @RMSOfferNewFlow
Feature: Offer status change new module when switch is ON

  Background: 
    Given I login into RMS as "Enterprise.Super_user"
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And click on offer stage and check the first stage on offer and joining stage
    And User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " offer generation link
    When I turn the "offerGenerationModuleOnOff" offer generation permission button to "on"

  Scenario: To verify if there is no breakup rule in Ready state yet, show an error message “Offer cannot be generated without Salary Breakup Template. Create Salary Breakup Template here and try again“ and clicking "here" link should redirect user to Salary rule listing
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I click on status change drop down
    And I click on first stage of offer
    Then I should see new offer layer
    Then I should see message "Offer cannot be generated without Salary Breakup Template. Create Salary Breakup Template" on new Offer layer
    And I click "here" link in message in new Offer layer
    Then I should be navigated to Salary Rule listing page

  Scenario: To verify that Salary Rule dropdown lists all rules in Alphabetical order and draft templates are not displayed
    And Navigate to Salary Rule Listing Page
    And I create a new salary template in "draft" state
    And I create a new salary template in "confirm" state
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I click on status change drop down
    And I click on first stage of offer
    Then I should see new offer layer
    And I click Select Salary-Breakup Template dropdown on new offer layer
    Then I should see confirm salary template in Select Salary-Breakup Template dropdown
    Then I should not see draft salary template in Select Salary-Breakup Template dropdown

  @testcase1
  Scenario: To verify that on selecting a Salary breakup, show the Inputs defined in that Salary Breakup in same the order
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I click on status change drop down
    And I click on first stage of offer
    Then I should see new offer layer
    And I click Select Salary-Breakup Template dropdown on new offer layer
    And I select confirm salary template in Select Salary-Breakup Template dropdown
    Then I should see all inputs on the first stepper of Offer layer
      | Offered Designation *                |
      | Offered on *                         |
      | Candidate's tentative joining date * |
      | Label4 *                             |
      |                                      |

  Scenario: To verify that Validations on Input data type
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I click on status change drop down
    And I click on first stage of offer
    Then I should see new offer layer
    And I click Select Salary-Breakup Template dropdown on new offer layer
    And I select confirm salary template in Select Salary-Breakup Template dropdown
    And user click on "Next" button
    Then I should see validation error for all fields on the first stepper of Offer layer
      | This field is mandatory  |
      | A valid date is required |
      | This field is mandatory  |
      |                          |

  Scenario: To verify that on clicking Next, the stage movement is completed (as in current flow) and the success message of stage movement is shown
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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

  Scenario: To verify 2 radio buttons should be displayed on review offer details page
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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
    Then I should see radio buttons on second stepper of new Offer layer
      | Only Salary Breakup |
      | Full Offer Letter   |

  Scenario: To verify salary breakup table is displayed when we click on salary breakup radio button
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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

  Scenario: To verify if no offer doc templates are there in the system , waring message to add offer doc first should be displayed when second radio button is clicked
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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
    And I click "Full Offer Letter" radio button on new offer layer
    Then I should see "There is no offer document template corresponding to the salary breakup you have previously used. Create it" error message on scond stepper of new offer layer
    And I click "here" link in message in new Offer layer
    Then I should be navigated to Offer Document listing page

  Scenario: To verify offer document is displayed after any offer document from the dropdown is clicked
    #	Also covered in this scenario
    # To verify the offer doc templates mapped to salary breakup are displayed on tab 2 when we click on Full Offer Document radio button
    When Navigate to Offer Doc Listing Page
    And I create a new Offer Document
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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
    And I click "Full Offer Letter" radio button on new offer layer
    And I click Select Offer Letter Template dropdown
    Then I should see new offer document created in dropdown options
    And I click new offer document created in dropdown
    Then I should see Zoho editor on second stepper

  Scenario: To verify offer is already attached on tab3 , download button is displayed but user cannot change the offer
    #When Navigate to Offer Doc Listing Page
    #And I create a new Offer Document
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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
    And I click "Full Offer Letter" radio button on new offer layer
    And I click Select Offer Letter Template dropdown
    And I click new offer document created in dropdown
    Then I should see Zoho editor on second stepper
    And I click on Generate and Attach Offer Letter button
    Then I should see attached offer letter and download button on third stepper

  Scenario: To verify user can go back to tab2 after offer is generated on tab 3 and edit the offer
    #When Navigate to Offer Doc Listing Page
    #And I create a new Offer Document
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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
    And I click "Full Offer Letter" radio button on new offer layer
    And I click Select Offer Letter Template dropdown
    And I click new offer document created in dropdown
    Then I should see Zoho editor on second stepper
    And I click on Generate and Attach Offer Letter button
    Then I should see attached offer letter and download button on third stepper
    And I click "2. Generate Offer Letter" stepper
    Then I should be directed back to second stepper of new offer layer

  Scenario: To verify warning message "Discard Offer Mail? All unsaved changes will be lost." should be displayed when cancel is clicked from tab3
    #When Navigate to Offer Doc Listing Page
    #And I create a new Offer Document
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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
    And I click "Full Offer Letter" radio button on new offer layer
    And I click Select Offer Letter Template dropdown
    And I click new offer document created in dropdown
    Then I should see Zoho editor on second stepper
    And I click on Generate and Attach Offer Letter button
    Then I should see attached offer letter and download button on third stepper
    And user click on "Cancel" button
    Then I should see "Discard Offer Mail?" dialog box

  Scenario: To verify offer can be generated with Salary template
    #When Navigate to Offer Doc Listing Page
    #And I create a new Offer Document
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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

  Scenario: To verify offer can be generated with Full Offer Document
    #When Navigate to Offer Doc Listing Page
    #And I create a new Offer Document
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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
    And I click "Full Offer Letter" radio button on new offer layer
    And I click Select Offer Letter Template dropdown
    And I click new offer document created in dropdown
    Then I should see Zoho editor on second stepper
    And I click on Generate and Attach Offer Letter button
    Then I should see attached offer letter and download button on third stepper
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    And I click Send Mail button on Attach Offer Letter
    Then I should see "Candidate's Reply Pending" offer status on CV Details page

  @testcase2
  Scenario: To verify Previous offer entry is displayed on timeline after offer is expired and again application is moved to offered stage
    #When Navigate to Offer Doc Listing Page
    #And I create a new Offer Document
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
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
    And I click on status change drop down
    And I click on "Applied" on DD
    And I should be able to see the status change message "Success! Application status has been successfully changed to Applied" on CV Details Page
    And refresh the page
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
    Then I should see "You have previously made 1 offer to this candidate." in previous offer information
    
#Cannot be automated
  #Scenario: To verify that if there is any error in terms of validation as returned by Excel, it should not allow stage movement
  #Scenario: To verify all the tags value in editor
  #Scenario: To verify correct Salary breakup is displayed when user selects Only Salary Breakup radio button
  #Scenario: To verify Full Offer Document content is correct when user selects Full Offer Letter radio button
  #Scenario: To verify the content of attached document when user selects Only Salary Breakup radio button
  #Scenario: To verify the content of attached document when user selects Full Offer Letter radio button
