@RMS
Feature: This feature file is for test scenarios of define services for billing

  @id:1 @billing @testUrlBuilder
  Scenario: Add/Edit/Delete is working for billing services in Invoice Setting
    Given User login to the application "settingsPage" using "Superuser" of "ConsultantPlus" user
    When user click on "Invoice Settings" link
    And user click on "Define Services" tab
		Then List of default services should be visible
    And user click on "Add services" button
    Then Verify all define services fields and details should be there
    When user fill all the details in service fields
    And user click on "Add" button
    Then verify Billing Services should be displayed
    Given user create candidate with tax exempted employer and move the candidate to billing stage
    When User is on "billingDashboard" page
    And user click on generate proforma invoice
    When user select one of the other "MODIFIED" HSN Code
    Then HSN Code should be "MODIFIED"
    Given User is on "settingsPage" page
    When user click on "Invoice Settings" link
    And user click on "Define Services" tab
    And user edit added service and save
    Then Billing Services should be displayed
    When User is on "billingDashboard" page
    And User "Generate Invoice" of the Candidate
    When user select one of the other "MODIFIED" HSN Code
    Then HSN Code should be "MODIFIED"
    When user select one of the other "NA" HSN Code
    Then HSN Code should be "NA"
    Given User is on "settingsPage" page
    When user click on "Invoice Settings" link
    And user click on "Define Services" tab
    And user delete the added services and save
    Given User is on "settingsPage" page
    When user click on "Invoice Settings" link
    And user click on "Define Services" tab
    Then Billing Services should not be displayed
		
		
		
