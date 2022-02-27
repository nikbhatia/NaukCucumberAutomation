#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: To verify Candidate Tuple Feature for Invoices Tab

  Background: 
    Given User Create Candidate Application for Billing Invoice for Consultant User with chargeMode as "percentage" , chargeValue as "30" , invoiceGenerationAfterDays as 0 , payableAfterDays as 90 , isTaxExempted as "true" .

  #Scenario: To verify candidate is moving to To be generated tab
    #When I change application status to "Offers & Joining"
    #And I fill Offer Details with all details
    #And I click on "NEXT" button
    #Then Success message as "Application status has been successfully changed to Offers & Joining - Move To Billing" should be displayed
    #When I fill mail details
    #And I click on "Send Mail" button
    #Then Success message as "Mail has been sent Successfully." should be displayed
    #And Offer Details should be displayed in View Application Page
    #When I go to Billing Dashboard Page
    #Then Candidate Details should be displayed on Billing Dashboard Page under To be generated tab

    Scenario: jhgfds
    When Run
    #And jhkdfg