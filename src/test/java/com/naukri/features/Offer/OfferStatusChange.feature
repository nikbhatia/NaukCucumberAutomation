@RMS @RMSOffer @RMSOfferGeneration
Feature: To verify offer generation for status change

  @PrefillOffer1232
  Scenario Outline: To verify prefill from template functionality on offer details page
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " link
    And uncheck the switch Offer generation module on settings page
    And click on set offer generation settings 
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And click on offer stage and check the first stage on offer and joining stage
    When User is on "settingsPage" page
    And I click "Create a New Email Template" link on Settings page
    And user select template type "Status Change "
    And select "Offers & Joining" as category
    And enter template name and mail body and mail subject in status change template page
    And user click on Save template
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    Then I should be directed to the CV details page
    And I should be able to see the success message "The profile has been successfully created. Add more profiles" on CV Details Page
    When I click on status change drop down
    And I click on first stage of offer
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And click on "Prefill from Template" on attach offer page
    And select email template name
    Then verify mail body and mail subject on offer mail page
    
    Examples: 
      | userType        |
      | Enterprise.Super_user |

  @TestOffer @checkTC
  Scenario Outline: To verify Offer functionality id working fine for Eapps client
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I click on status change drop down
    And I click on first stage of offer
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I fill Offer Mail subject field
    And I fill Offer Mail Body field
    Then I click Send Mail button on Attach Offer Letter
    And I should see updated Offered details on offer strip

    Examples: 
      | userType        |
      | Eapps.Superuser |

@TestOffer
  Scenario Outline: To verify that when no offer is uploaded , subject and mail body is not entered , send mail button is disabled in tagged stage
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " link
    And uncheck the switch Offer generation module on settings page
    And click on set offer generation settings 
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And click on offer stage and check the first stage on offer and joining stage
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I click on status change drop down
    And I click on first stage of offer
    And I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I clear Offer Mail subject field
    And I clear Offer Mail Body field
    Then I should see Send Mail button is disabled

    Examples: 
      | userType             |
      | Enterprise.Super_user |
      
@TestOffer
  Scenario Outline: To verify that when no subject and body is entered, send mail is disabled  in untagged stage
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " link
    And uncheck the switch Offer generation module on settings page
    And click on set offer generation settings 
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And click on offer stage and uncheck the second stage on offer and joining stage
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I click on status change drop down
    And I click on second stage of offer
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I clear Offer Mail subject field
    And I clear Offer Mail Body field
    Then I should see Send Mail button is disabled
    And attach offer letter should not be displayed on the offer details page for untagged stage

    Examples: 
      | userType             |
      | Enterprise.Super_user |

@BulkStatusChange12345hghb
      Scenario Outline: To verify functionality of Bulk status change for Offer
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " link
    And uncheck the switch Offer generation module on settings page
    And click on set offer generation settings 
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And click on offer stage and check the first stage on offer and joining stage
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
    And Enter one approver as "<subuserType>"
    And Click on save template
    And user click on "SAVE" button
    Given I save group ID for "<userType>"
    And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    And I click Requirement name on CV details for the candidate
    And I get requirement ID from the page
    And I navigate to requirment inbox page
    And I search for requirement on Requirement Listing page
    And I add candidate to the requirement
    And I navigate to profile project inbox page for the candidate
    Then verify 2 profiles are displayed on project inbox page 
    When I select profile 1 on profile listing page
    And I select profile 2 on profile listing page
    And I click on the bulk status update from the top panel
    Then I should be able to see the status change drop down in the modal
    When I change the status of the candidates to "Offers & Joining"
    And I click on update on the bulk status layer
    Then I should be able to see the success message as "Success! Application Status have been successfully changed to Offer"
     When I navigate to CV details for the candidate
    Then I should see "Offer Details Pending" offer status on CV Details page
    Then I should see "Offer Details Pending" status text in offer timeline
   	And "FILL OFFER DETAILS" should be displayed on offer timeline  
    
    Examples: 
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario: To verify Allow user to manage offer permission should not be displayed for consultant client
