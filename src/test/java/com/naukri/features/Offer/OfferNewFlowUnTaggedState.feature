@RMSOfferNewFlow @OfferNewFlowUntagged
Feature: TO verify new offer flow when offer stage is unTagged.

  Background: 
    Given I login into RMS as "Enterprise.Super_user"
    When User is on "settingsPage" page
    And I click "Customize the Selection Process" link on Settings page
    And click on offer stage and uncheck the second stage on offer and joining stage
    And User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " offer generation link

  @untagoff
  Scenario: To verify when switch is OFF, candidate is moved to UnTagged offer stage, Same as current flow for Old Offer flow is opened and values are not prefilled
    When I turn the "offerGenerationModuleOnOff" offer generation permission button to "off"
    When I add candidate using API for "Enterprise.Super_user" without any group
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on second stage of offer
    Then I should be directed to "Fill Offer Details" tab of Offer Old Flow
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I clear Offer Mail subject field
    And I clear Offer Mail Body field
    Then I should see Send Mail button is disabled
    And attach offer letter should not be displayed on the offer details page for untagged stage

  Scenario: To verify when switch is on, candidate is moved to UnTagged offer stage, Same as current flow for Old Offer flow is opened and values are not prefilled
    When I turn the "offerGenerationModuleOnOff" offer generation permission button to "on"
    When I add candidate using API for "Enterprise.Super_user" without any group
    And I navigate to CV details for the candidate
    And I click on status change drop down
    And I click on second stage of offer
    Then I should be directed to "Fill Offer Details" tab of Offer Old Flow
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I clear Offer Mail subject field
    And I clear Offer Mail Body field
    Then I should see Send Mail button is disabled
    And attach offer letter should not be displayed on the offer details page for untagged stage
