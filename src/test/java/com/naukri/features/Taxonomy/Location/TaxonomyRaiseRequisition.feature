Feature: Location taxonomy changes in Raise Requisition

  @RaiseRequisitionTaxonomy @id:1
  Scenario: Verify that if no character is typed, but the text area is clicked and there are no recent cities then only the top metro cities are displayed as checkboxes
    Given User login to the application "RMSRaiseRequisition" using "HiringManager1" of "Enterprise" user
    When User clicks on "locSuggestor" drop down 
    Then User sees "Metropolitan Cities" as checkboxes
      | Ahmedabad              |
      | Bangalore/Bengaluru    |
      | Chennai                |
      | Hyderabad/Secunderabad |
      | Kolkata                |
      | Pune                   |
      | Delhi / NCR            |
      | Mumbai (All Areas)     |

  @RaiseRequisitionTaxonomy @id:2
  Scenario: Verify that if no character is typed, but the text area is clicked and the top metro cities along with 5 recent cities are displayed as checkboxes
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User clicks on "locSuggestor" drop down
    Then User sees "Other Metropolitan Cities" in dropdown
    Then User sees "Recently Used" in dropdown

  @RaiseRequisitionTaxonomy @id:3
  Scenario: Verify the functionality of "Recently Used" cities
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    #And User raises Requisition
    #And User creates new Requisition
    #When User clicks on "locSuggestor" drop down
    #Then User sees "Ajmer, Rajasthan" in "Recently Used"

  @wip @id:4 @manual
  Scenario: Verify when the same city is part of both Recent places and the Top Metropolitan cluster
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    Then User sees the place only in "Recent Cities"
    Then User sees the label appearing on Metro cluster as "Other Metropolitan cities"

  @RaiseRequisitionTaxonomy @id:5
  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "d" in "locSuggestor" field
    #Then User sees Indian cities as suggestions
    Then User sees at max 5 cities suggestions

  @RaiseRequisitionTaxonomy @id:6
  Scenario: Verify when city is not present in the suggestion
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "x" in "locSuggestor" field
    Then User sees 2 options to add
      | Add as National Location      |
      | Add as International Location |

  @RaiseRequisitionTaxonomy @id:7
  Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    Then User sees "Add Other Location" layer opened with options
      | Other Location |
      | State          |
    Then User sees "test" entered text in "Other Location" field

  @RaiseRequisitionTaxonomy @id:8
  Scenario: Verify error messages in "Add Other Location" layer
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  @RaiseRequisitionTaxonomy @id:9
  Scenario: Verify user is able to add Other National Location
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as tag

  @RaiseRequisitionTaxonomy @id:10
  Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    Then User sees "Add International Location" layer opened with options
      | Other Location |
      | Country        |
    Then User sees "test" entered text in "Other Location" field

  @RaiseRequisitionTaxonomy @id:11
  Scenario: Verify error messages in "Add International Location" layer
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  @RaiseRequisitionTaxonomy @id:12
  Scenario: Verify user is able to add Other International Location
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as tag

  @RaiseRequisitionTaxonomy @id:13
  Scenario: Verify that each city selection is displayed as tags
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "Noida" in "locSuggestor" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag

  @wip @id:14 @manual
  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User checks 1 option from dropdown in "Top Metropolitan Cities"
    Then User sees selected city is shown checked in the dropdown

  @RaiseRequisitionTaxonomy @id:15
  Scenario: Verify the tag added if city is not present in global list
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as tag
    When User clicks cross icon for the tag
    When User enters "test1" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test1-Australia" added as tag

  @wip @id:16 @manual
  Scenario: Verify that error message is displayed when more than 9 locations are selected
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User clicks on "locSuggestor" drop down
    And User checks 10 locations
    Then User sees error message "You can not select more than 9 locations."

  @wip @id:17
  Scenario: Verify that job is posted with new city
    #TO BE checked when requirement changes are done
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    And User checks 1 option from "State" dropdown
    And User clicks "Add" button
    Then User sees "test-<State>" added as tag
    And User fills all other details
    And User clicks "Next" button
    And User posts "Private" job
    Then User sees job posted with new city

  @RaiseRequisitionTaxonomy @id:18
  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User clicks outside the Job Location dropdown
    When User enters "Ajmer" in "locSuggestor" field
    Then User sees "Ajmer" option is checked in dropdown
    When User unchecks "Ajmer" option from dropdown
    Then User sees "Ajmer" removed as tag

  @RaiseRequisitionTaxonomy @id:19
  Scenario: Verify that user is able to de-select location by clicing on cross icon on the tag
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag

  @RaiseRequisitionTaxonomy @id:20
  Scenario: Verify that Location entered is visible on Requisition Overview page
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User creates requisition with no approval process and first group in DD, using "Ajmer" in "locSuggestor" field
    And saves Requisition Tracking ID
    And User navigates to Requisition Overview using Requisition Tracking ID
    Then User sees "Ajmer" as location on Requisition Overview

  @wip @id:21
  Scenario: Verify that Location is prefilled when a template from "Prefill from existing Requisitions or Templates" is selected
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    And I click on Add New Button
    And User creates requisition all details and "Ajmer" as location
    And User clicks on "Save Template" button
    And I logout of RMS
    And "Enterprise" user is on Settings Page with "HiringManager1"
    And User is on "RMSRaiseRequisition" page
    And User prefills from created Requisition Template
    Then User sees "Ajmer" as prefilled location

  @wip @id:22
  Scenario: Verify that on re-initiating the requisition, location remains same
    Given I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSRaiseRequisition" page
    And HM Spoc creates requisition with approval process and "Ajmer" as location
    And saves Requisition Tracking ID
    And I logout
    And I am logged in with "Enterprise" user "approver1"
    And User is on "RMSRequisitionList" page
    And Approver rejects the requisition
    And I logout
    And I am logged in with "Enterprise" user "hiringmanager1"
    And User is on "RMSHMRequisitionList" page
    When I reinitiate requisition
    And User navigates to Requisition Overview using Requisition Tracking ID
    Then User sees "Ajmer" as location
