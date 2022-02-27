@RMS @RMSOfferSettings @RMSOffer @Settings
Feature: To verify Settings for Offer Generation

  @RMS3-2978
  Scenario Outline: Verify RMS Enterprise Super User is able to see new "Offer Generation Settings" section on settings page
    Given I login into RMS as "<userType>"
    And User is on "settingsPage" page
    Then I should see "Offer Generation Settings" section on settings page

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @RMS3-2978-2
  Scenario Outline: Verify RMS Pro and Consultant variants are not able to see new "Offer Settings" section on settings page
    Given I login into RMS as "<userType>"
    And User is on "settingsPage" page
    Then I should not see "Offer Generation Settings" section on settings page

    Examples: 
      | userType                |
      | ProConsultant.Superuser |
      | Company.Superuser       |

  @RMS3-2979
  Scenario Outline: Verify RMS Enterprise Super User sees three sub-headings under Offer Generation Settings on setting page
    Given I login into RMS as "<userType>"
    And User is on "settingsPage" page
    Then I should see the sub-headings and description text
      | Offer Generation Rules & Salary Breakup                                                                                                                          |
      | Manage rules for creating Salary Breakup                                                                                                                         |
      | Offer Document Templates                                                                                                                                         |
      | Manage Offer Document Templates                                                                                                                                  |
      | Offer Generation Module On/Off                                                                                                                                   |
      | If this setting is ON, recruiters will generate and send Offer letters using rules set in RMS. Emailing of Offer letters created outside RMS will not be allowed |

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @RMS3-2979-2 @Smoke
  Scenario Outline: Verify Offer Generation Settings section would not be visible to recruiter if he has NO permission given by superuser from "Manage Permission" section
    Given I login into RMS as "<userType>"
    And User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for subuser
    Then I should be able to see "Give access to Offer Generation settings" in manage permission light box
    When I turn the "Give access to Offer Generation settings" permission button to "off"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And User is on "settingsPage" page
    Then I should not see "Offer Generation Settings" section on settings page

    Examples: 
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  @RMS3-2979-3
  Scenario Outline: Verify clicking on "Offer Generation Rules & Salary Breakup" redirects user on "Salary Breakup listing" page
    Given I login into RMS as "<userType>"
    And User is on "settingsPage" page
    When user click on "Offer Generation Rules & Salary Breakup " link
    Then I am redirected to "Salary Breakup Templates List" page

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @RMS3-2979-4
  Scenario Outline: Verify clicking on "Offer Generation Module On/Off" opens a layer with "Create Offer Documents using Offer rules saved in RMS" switch
    Given I login into RMS as "<userType>"
    And User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " offer generation link
    Then I see a layer with "Create Offer Documents using Offer rules saved in RMS" switch

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @RMS3-2979-5
  Scenario Outline: Verify if "Give access to Offer Generation settings" in Manage Permission is ON for a recruiter then Offer Settings are displayed for the recruiter with two sub-headings
    Given I login into RMS as "<userType>"
    And User is on "settingsPage" page
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for subuser
    Then I should be able to see "Give access to Offer Generation settings" in manage permission light box
    When I turn the "Give access to Offer Generation settings" permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And User is on "settingsPage" page
    Then I should see "Offer Generation Settings" section on settings page

    Examples: 
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

  @testOfferValidationAndAttachOffer
  Scenario Outline: To verify that "Attach Offer Letter" section is not available when status change mail is sent for untagged stage
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " link
    And uncheck the switch Offer generation module on settings page
    And click on set offer generation settings
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And click on offer stage and uncheck the second stage on offer and joining stage
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And I click on status change drop down
    And I click on second stage of offer
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    Then Attach Offer Letter should not be displayed

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @signature
  Scenario Outline: To verify signature is displayed on offer preview and mail
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " link
    And uncheck the switch Offer generation module on settings page
    And click on set offer generation settings
    When User is on "settingsPage" page
    And click on edit signature
    And enter text under signature body
    And click on save signature
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    Then I should be directed to the CV details page
    And I should be able to see the success message "The profile has been successfully created. Add more profiles" on CV Details Page
    When I click on status change drop down
    And I click on first stage of offer
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And click on "Include signature" on offer details page
    And I click "Preview Mail" button on Attach Offer Letter page
    Then I should see signature in the preview

    Examples: 
      | userType             |
      | Enterprise.Super_user |
# Not to be done
#Scenario Outline: Verify if "Give access to Offer Generation settings" in Manage Permission is OFF for a recruiter then Offer Settings are not displayed for subuser
#Scenario: Verify that for RMS Enterprise Super User "Give access to Offer Generation settings" option is displayed for sub-users in Manage Permissions section
#Scenario: Verify Offer Generation Settings section would not be visible to recruiter if he has NO permission given by superuser from “Manage Permission“ section
#Scenario: Verify Offer Generation Settings would be placed just above Manage Sources section
#Scenario: Verify sub-heading text and description text for all three options
