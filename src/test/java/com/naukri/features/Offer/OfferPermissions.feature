@RMS @RMSOffer @RMSOfferPermissions
Feature: To verify the offer permission

  @RMSOfferPermissions1
  Scenario Outline: To verify the offer permission button availability for the RMS Enterprise user in the manage sub user section
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    And I navigate to "Enterprise" Open Manage Permissions for any recruiter
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    
    Examples: 
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  Scenario Outline: To verify the offer permission button unavailability for the other than RMS Enterprise user in the manage sub user section
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    And I navigate to "Consultant" Open Manage Permissions for any recruiter
    And I select 1 sub recruiter
    Then I should not be able to see "Allow User to Send or View Offer Letter" in manage permission light box
    
    Examples: 
      | userType             |
      | ProConsultant.Superuser |

  @TestOfferPermissions
  Scenario Outline: To verify the functionality of the offer permission button provided for the RMS Enterprise user
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    And I navigate to "Enterprise" Open Manage Permissions for any recruiter
    And I search subuser name "Enterprise.Sub_user"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    When I turn the "Allow User to Manage Offer" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And User is on "applicationInbox" page
    Then I am able to see View Offer Letter Cluster on the application inbox

		Examples: 
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |
      
  @TestOfferPermissions156789
  Scenario Outline: To verify the functionality of the offer permission button when switched off provided for the RMS Enterprise user
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    And I navigate to "Enterprise" Open Manage Permissions for any recruiter
    And I search subuser name "<subuserType>"
    And I open the manage permissions for searched subuser
    Then I should be able to see "Allow User to Manage Offer" in manage permission light box
    And I turn the "Allow User to Manage Offer" permission button to "off"
    And I logout of RMS
    When I login into RMS as "<subuserType>"
    And User is on "applicationInbox" page
    Then I am not able to see View Offer Letter Cluster on the application inbox
    When I am on CV details page for the first candidate
    #When I change the status of the candidate to offer
    Then I won't be able to change the candidate's status to Offer Stage
    
    Examples: 
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  @OfferSubStage
  Scenario Outline: To verify when offer stage is created by user from settings page or requirement dashboard, on SRP page that offer stage should also be visible
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And I add sub-stage to Offer Round
    And User is on "applicationInbox" page
    And I check the first Candidate checkbox and click Change Status
    Then I am able to see new sub-stage in Update Status dropdown
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And I delete the created sub-stage for Offer Round
    
    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @OfferSubStage
  Scenario Outline: To verify when offer stage is created by user from settings page or requirement dashboard, on CV details page that offer stage should also be visible
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And I add sub-stage to Offer Round
    And User is on "applicationInbox" page
    When I am on CV details page for the first candidate
    When I click on status change drop down
    Then I am able to see new sub-stage in status change drop down
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And I delete the created sub-stage for Offer Round
    
    Examples: 
      | userType             |
      | Enterprise.Super_user |
    
   Scenario Outline: To verify 'Offer Approval is mandatory' switch is visible
    Given I login into RMS as "<userType>"
    And I am on the Settings page of RMS
    When user click on "Approval Settings" link
    Then I should be able to see "Offer Approval is Mandatory" in manage permission light box

    Examples: 
      | userType             |
      | Enterprise.Super_user |
      
       @TestOffer
    Scenario Outline: To verify offer details timeline should be visible to subrecruiter in case permission is given
     Given I login into RMS as "<userType>"
     When User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " link
    And uncheck the switch Offer generation module on settings page
    And click on set offer generation settings 
     And  I save group ID for "<userType>"
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
    And user click on "SAVE" button
    When User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for subuser
    When I turn the "Allow User to Manage Offer" permission button to "on"
   	And I add candidate using API for "<userType>"
    And I navigate to CV details for the candidate
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And  I fill Offer Mail subject field 
	And I fill Offer Mail Body field 
	Then I click Send Mail button on Attach Offer Letter  
	When I logout of RMS
    And I login into RMS as "<subuserType>"
    And I navigate to CV details for the candidate
	And I navigate to CV details for the candidate
	Then I should see updated Offered details on CV Details page 
    
    
       Examples: 
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |