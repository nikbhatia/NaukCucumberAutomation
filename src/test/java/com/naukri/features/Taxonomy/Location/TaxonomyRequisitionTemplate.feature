Feature: Location taxonomy changes in Requisition Template

  @wip @id:1
  Scenario: Verify that if no character is typed, but the text area is clicked and there are no recent cities then only the top metro cities are displayed as checkboxes
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User clicks on "Job Location" drop down
    Then User sees "Top Metropolitan Cities" as checkboxes
      | Ahmedabad              |
      | Bangalore/Bengaluru    |
      | Chennai                |
      | Hyderabad/Secunderabad |
      | Kolkata                |
      | Pune                   |
      | Delhi / NCR            |
      | Mumbai (All Areas)     |

  @wip @id:2
  Scenario: Verify that if no character is typed, but the text area is clicked and the top metro cities along with 5 recent cities are displayed as checkboxes
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User clicks on "Job Location" drop down
    Then User sees "Top Metropolitan Cities" as checkboxes
      | Ahmedabad              |
      | Bangalore/Bengaluru    |
      | Chennai                |
      | Hyderabad/Secunderabad |
      | Kolkata                |
      | Pune                   |
      | Delhi / NCR            |
      | Mumbai (All Areas)     |
    Then User sees "Recently Used" as checkboxes

  @wip @id:3
  Scenario: Verify the functionality of "Recently Used" cities
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User creates Requisition Template
    And User creates new Requisition Template
    When User clicks on "Job Location" drop down
    Then User sees "Ajmer, Rajasthan" in "Recently Used"

  @wip @id:4
  Scenario: Verify when the same city is part of both Recent places and the Top Metropolitan cluster
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    Then User sees the place only in "Recent Cities"
    Then User sees the label appearing on Metro cluster as “Other Metropolitan cities”

  @wip @id:5
  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "d" in "Job Location" field
    Then User sees Indian cities as suggestions
    Then User sees at max 5 cities suggestions

  @wip @id:6
  Scenario: Verify when city is not present in the suggestion
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "x" in "Job Location" field
    Then User sees 2 options to add
      | Add as National Location      |
      | Add as International Location |

  @wip @id:7
  Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "test" in "Job Location" field
    And User clicks "Add as National Location" option
    Then User sees "Add Other Location" layer opened with options
      | Other Location |
      | State          |
    Then User sees already entered text in "Other Location" field

  @wip @id:8
  Scenario: Verify error messages in "Add Other Location" layer
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "test" in "Job Location" field
    And User clicks "Add as National Location" option
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages
    When User enters "test" in "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages

  @wip @id:9
  Scenario: Verify user is able to add Other National Location
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "test" in "Job Location" field
    And User clicks "Add as National Location" option
    And User selects 1 option from "State" dropdown
    And User clicks "Add" button
    Then User sees "test-<State>" added as tag

  @wip @id:10
  Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "test" in "Job Location" field
    And User clicks "Add as International Location" option
    Then User sees "Add International Location" layer opened with options
      | Other Location |
      | Country        |
    Then User sees already entered text in "Other Location" field

  @wip @id:11
  Scenario: Verify error messages in "Add International Location" layer
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "test" in "Job Location" field
    And User clicks "Add as International Location" option
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages
    When User enters "test" in "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages

  @wip @id:12
  Scenario: Verify user is able to add Other International Location
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "test" in "Job Location" field
    And User clicks "Add as International Location" options
    And User selects 1 option from "Country" dropdown
    And User clicks "Add" button
    Then User sees "test-<Country>" added as tag

  @wip @id:13
  Scenario: Verify that each city selection is displayed as tags
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "Noida" in "Job Location" field
    And User checks first option from the dropdown
    Then User sees "Noida" as tags

  @wip @id:14
  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User selects 1 option from dropdown in "Top Metropolitan Cities"
    Then User sees selected city is shown checked in the dropdown

  @wip @id:15
  Scenario: Verify the tag added if city is not present in global list
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "test" in "Job Location" field
    And User clicks "Add as National Location" option
    And User selects 1 option from "State" dropdown
    And User clicks "Add" button
    Then User sees "test-<State>" added as tag
    When User enters "test" in "Job Location" field
    And User clicks "Add as International Location" option
    And User selects 1 option from "Country" dropdown
    And User clicks "Add" button
    Then User sees "test-<Country>" added as tag

  @wip @id:16
  Scenario: Verify that error message is displayed when more than 9 locations are selected
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User clicks on "Job Location" drop down
    And User checks 10 locations
    Then User sees error message "You can not select more than 9 locations."

  @wip @id:17
  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User clicks on "Job Location" drop down
    Then User sees "Ajmer" is checked
    When User unchecks "Ajmer" location
    Then User sees "Ajmer" removed as tag

  @wip @id:18
  Scenario: Verify that user is able to de-select location by clicing on cross icon on the tag
    Given User login to the application "requisitionTemplate" using "Superuser" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the location tag
    Then User sees "Ajmer" removed as tag

  @wip @id:19
  Scenario: Verify that Location entered is visible in "Requisition Template Details" layer
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    And I click on Add New Button
    And User creates requisition with all details and "Ajmer" as location
    And User clicks on "Save Template" button
    When User search for created Template
    And User clicks on "Preview" button for the template
    Then User sees "Ajmer" on "Requisition Template Details" layer

  @wip @id:20
  Scenario: Verify that Location is prefilled when a template from "Prefill from other templates" is selected
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    And I click on Add New Button
    And User creates requisition with all details and "Ajmer" as location
    And User clicks on "Save Template" button
    And I click on Add New Button
    And User selects created Requisition Template in "Prefill from other templates" option
    Then User sees "Ajmer" location already selected

  @wip @id:21
  Scenario: Verify that on editing template, location remains the same
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    And I click on Add New Button
    And User creates requisition with all details and "Ajmer" as location
    And User clicks on "Save Template" button
    When User search for created Template
    And User clicks on "Edit" button for the template
    Then User sees "Ajmer" location already selected
