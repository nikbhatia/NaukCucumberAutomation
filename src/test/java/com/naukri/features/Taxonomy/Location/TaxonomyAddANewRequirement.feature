Feature: Location taxonomy changes in Add a new Requirement

	@TaxonomyAddRequirement
  Scenario: Verify that "Select the required location." error message is displayed when Job Location field is left blank
    #Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    And User click on "Add Requirement" button on requirement creation
    And Verify User see the error message "Select atleast one location." for location field

	@TaxonomyAddRequirement
  Scenario: Verify that if no character is typed, but the text area is clicked and there are no recent cities then only the top metro cities are displayed as checkboxes
    #Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
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

	@TaxonomyAddRequirement
  Scenario: Verify that if no character is typed, but the text area is clicked and the top metro cities along with 5 recent cities are displayed as checkboxes
     #Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    When User clicks on "locSuggestor" drop down
    Then User sees "Other Metropolitan Cities" in dropdown
    Then User sees "Recently Used" in dropdown

  Scenario: Verify the functionality of "Recently Used" cities
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    When User clicks on "locSuggestor" drop down
    Then User sees "Ajmer, Rajasthan" in "Recently Used"

  Scenario: Verify when the same city is part of both Recent places and the Top Metropolitan cluster
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Then User sees the place only in "Recent Cities"
    Then User sees the label appearing on Metro cluster as "Other Metropolitan cities"
	
	@TaxonomyAddRequirement
  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
     #Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    When User enters "d" in "locSuggestor" field
    Then User sees at max 5 cities suggestions

	@TaxonomyAddRequirement
  Scenario: Verify when city is not present in the suggestion
    #Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    When User enters "x" in "locSuggestor" field
    Then User sees 2 options to add
      | Add as National Location      |
      | Add as International Location |

	@TaxonomyAddRequirement
  Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    #Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    Then User sees "Add Other Location" layer opened with options
      | Other Location |
      | State          |
    Then User sees "test" entered text in "Other Location" field

	@TaxonomyAddRequirement
  Scenario: Verify error messages in "Add Other Location" layer
    #Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  Scenario: Verify user is able to add Other National Location
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "test-Andhra Pradesh" added as location on Requirement Overview

	@TaxonomyAddRequirement
  Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    #Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    Then User sees "Add International Location" layer opened with options
      | Other Location |
      | Country        |
    Then User sees "test" entered text in "Other Location" field

	@TaxonomyAddRequirement
  Scenario: Verify error messages in "Add International Location" layer
    #Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  Scenario: Verify user is able to add Other International Location
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "test-Australia" added as location on Requirement Overview

  Scenario: Verify that each city selection is displayed as tags
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Noida" in "locSuggestor" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User checks 1 option from dropdown in "Top Metropolitan Cities"
    Then User sees selected city is shown checked in the dropdown

	@TaxonomyAddRequirement
  Scenario: Verify the tag added if city is not present in global list
    #Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
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

  Scenario: Verify that error message is displayed when more than 9 locations are selected
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User clicks on "locSuggestor" drop down
    And User checks 10 locations
    And User adds all other fields for Add Requirement
    And User click on "Add Requirement" button on requirement creation
    Then User sees error message "You can not select more than 9 locations."

  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User clicks outside the Job Location dropdown
    When User enters "Ajmer" in "locSuggestor" field
    Then User sees "Ajmer" option is checked in dropdown
    When User unchecks "Ajmer" option from dropdown
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that user is able to de-select location by clicing on cross icon on the tag
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag

  Scenario: Verify that Location is prefilled when a template from "Prefill from other Requirement" is selected
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    And User click on Prefill from other Requirement
    And User selects created Requirement from prefill dropdown
    Then User sees "Ajmer" added as tag

  Scenario: Verify location is prefilled when user creates requirement from requisition
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User creates requisition with no approval process and first group in DD, using "Ajmer" in "locSuggestor" field
    And saves Requisition Tracking ID
    And I logout of RMS
    Given User login to the application "RMSRequisitionList" using "Superuser2" of "Enterprise" user
    And User navigates to Requisition Overview using Requisition Tracking ID
    And User click on "Add Requirement" button on requirement creation
    Then User sees "Ajmer" added as tag

  Scenario: Verify location is editable after Requirement is created
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User clicks "Edit" button
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User clicks "Next" button
    And User clicks "Save Requirement" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  #Scenario: Verify that user is able to add requirement with national location not present in global list
  #
  #Scenario: Verify that user is able to add requirement with international location not present in global list
  #Scenario: Verify that user is able to edit location entered after the requirement has been created
  Scenario: Verify that user is able to edit location entered after the requirement has been created with national location not present in global list
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "test-Andhra Pradesh" added as location on Requirement Overview
    And User clicks "Edit" button
    Then User sees "test-Andhra Pradesh" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User clicks "Next" button
    And User clicks "Save Requirement" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  Scenario: Verify that user is able to edit location entered after the requirement has been created with international location not present in global list
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "test-Australia" added as location on Requirement Overview
    And User clicks "Edit" button
    Then User sees "test-Australia" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User clicks "Next" button
    And User clicks "Save Requirement" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  Scenario: Verify that user is able to add more locations when prefill from other requirement is selected
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    And User click on Prefill from other Requirement
    And User selects created Requirement from prefill dropdown
    Then User sees "Ajmer" added as tag
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Ajmer" added as location on Requirement Overview
    Then User sees "Noida" added as location on Requirement Overview

  Scenario: Verify that user is able to add more locations when requirement is created from Requisition
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User creates requisition with no approval process and first group in DD, using "Ajmer" in "locSuggestor" field
    And saves Requisition Tracking ID
    And I logout of RMS
    Given User login to the application "RMSRequisitionList" using "Superuser2" of "Enterprise" user
    And User navigates to Requisition Overview using Requisition Tracking ID
    And User click on "Add Requirement" button on requirement creation
    Then User sees "Ajmer" added as tag
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Ajmer" added as location on Requirement Overview
    Then User sees "Noida" added as location on Requirement Overview

  Scenario: Verify that user is able to change prefilled location when prefill from other requirement is selected
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User navigate through GNB to "Add A New Requirement" under "Requirements"
    And User click on Prefill from other Requirement
    And User selects created Requirement from prefill dropdown
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  Scenario: Verify that user is able to change prefilled location when requirement is created from Requisition
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User creates requisition with no approval process and first group in DD, using "Ajmer" in "locSuggestor" field
    And saves Requisition Tracking ID
    And I logout of RMS
    Given User login to the application "RMSRequisitionList" using "Superuser2" of "Enterprise" user
    And User navigates to Requisition Overview using Requisition Tracking ID
    And User click on "Add Requirement" button on requirement creation
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  Scenario: Verify that user is able to post job with location
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation, or Doctorate will be enforced"
    And User chose "Any Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And Verify Job types posted with action options such as "View,Remove,Create Employee Referral,Edit Job"

  Scenario: Verify that user is able to post job with national location not present in global list
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation, or Doctorate will be enforced"
    And User chose "Any Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And Verify Job types posted with action options such as "View,Remove,Create Employee Referral,Edit Job"

  Scenario: Verify that user is able to post job with international location not present in global list
    Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "test" in "locSuggestor" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User post a "Naukri Private Job"
    And User select "Graduation" field as "I Will Choose Graduation", "Choose Graduation Degree" as "B.A" and Choose Specialization as "English"
    Then Verify User see the "B.A(English)" under the label You have selected as "Graduation"
    When User select "Graduation & Post Graduation will be enforced"
    And User select "Post Graduation" field as "I Will Choose Post Graduation", "Choose Post Graduation Degree" as "M.A" and Choose Specialization as "English"
    Then Verify User see the "M.A(English)" under the label You have selected as "Post Graduation"
    When User select "Post Graduation, or Doctorate will be enforced"
    And User chose "Any Doctorate"
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User check for the companyname and about company for "JP migrated" user
    And User click on Save and Post Requirement on requirement page
    Then Verify User see a layer with title "Questionnaire suggestion based on your Requirement"
    When User click on "Skip Questionnaire For Now" on the questionnaire preview
    Then Verify User redirected to requirement overview page
    And Verify Job types posted with action options such as "View,Remove,Create Employee Referral,Edit Job"

  Scenario: Verify location in HM account when user creates requirement from requisition
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User creates requisition with no approval process and first group in DD, using "Ajmer" in "locSuggestor" field
    And saves Requisition Tracking ID
    And I logout of RMS
    Given User login to the application "RMSRequisitionList" using "Superuser2" of "Enterprise" user
    And User navigates to Requisition Overview using Requisition Tracking ID
    And User click on "Add Requirement" button on requirement creation
    Then User sees "Ajmer" added as tag
    And I logout of RMS
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    And User navigates to Requirement Overview using Requirement Tracking ID
    Then User sees "Ajmer" added as location on Requirement Overview

  Scenario: Verify that location details are visible in "Requisition Details" tab when requirment is created from requisition
    Given User login to the application "RMSRaiseRequisition" using "HiringManager" of "Enterprise" user
    When User creates requisition with no approval process and first group in DD, using "Ajmer" in "locSuggestor" field
    And saves Requisition Tracking ID
    And I logout of RMS
    Given User login to the application "RMSRequisitionList" using "Superuser2" of "Enterprise" user
    And User navigates to Requisition Overview using Requisition Tracking ID
    And User click on "Add Requirement" button on requirement creation
    Then User sees "Ajmer" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview
    And User click on the tab "Requisition Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview
