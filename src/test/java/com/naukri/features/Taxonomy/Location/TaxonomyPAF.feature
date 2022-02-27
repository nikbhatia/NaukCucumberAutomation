Feature: Location Taxonomy changes for PAF
	
  Scenario: Verify that if no character is typed, but the text area is clicked then top metro cities are displayed as checkboxes
		Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
		When User clicks on "Job Location" drop down
    Then User sees "Metropolitan Cities" as checkboxes
      | Ahmedabad              |
      | Bangalore/Bengaluru    |
      | Chennai                |
      | Hyderabad/Secunderabad |
      | Kolkata                |
      | Pune                   |
      | Delhi / NCR            |
      | Mumbai (All Areas)     |
	
  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
  Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
  	When User enters "d" in "Job Location" field
    Then User sees at max 10 cities suggestions

  Scenario: Verify that country suggestions load in the location dropdown only when no. of city suggestions is less than 10
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
  	When User enters "Aus" in "Job Location" field
    Then User sees "Australia" as one of the options in dropdown

  Scenario: Verify that each city selection is displayed as tags
  Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
  	When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag

  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
  	When User checks 1 option from dropdown in "Top Metropolitan Cities"
    Then User sees selected city is shown checked in the dropdown

  Scenario: Verify that user is able to un-check the selected location from the dropdown
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
  	When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag
    And User clicks outside the Job Location dropdown
    When User enters "Chandigarh" in "Job Location" field
    Then User sees "Chandigarh" option is checked in dropdown
    When User unchecks "Chandigarh" option from dropdown
    Then User sees "Chandigarh" removed as tag

  Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
  	When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag
    When User clicks cross icon for the tag
    Then User sees "Chandigarh" removed as tag

  Scenario: Verify that locations entered while creating requirement are prefilled on PAF filter
  Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
  	Then User sees "Ajmer" added as tag

  Scenario: Verify that long tail locations entered while creating requirement are prefilled on PAF filter
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "test" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
    Then User sees "test-Andhra Pradesh" added as tag

  Scenario: Verify that locations can be added to PAF other than prefilled from creating requirement
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
    Then User sees "Ajmer" added as tag
    When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag

  Scenario: Verify that locations can be edited/changed to PAF other than prefilled from creating requirement
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag
    When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag

  Scenario: Verify that all locations added to PAF are displayed on "Response Filters" tab on requirement overview
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
    Then User sees "Ajmer" added as tag
    When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag
    And User clicks "Save Project" button
    And User click on the tab "Response Filters" on requirement overview page
    Then User sees "Ajmer" added as location on Requirement Overview on "Response Filters" tab
    Then User sees "Chandigarh" added as location on Requirement Overview on "Response Filters" tab

  Scenario: Verify that PAF filter with new location dropdown can be applied from requirement overview page after the requirement is created
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User clicks "Save Requirement" button
    And User click on the tab "Response Filters" on requirement overview page
    When User clicks "Apply Response Filters" button
    Then User is directed to "Response Filters(Optional)" page
    Then User sees "Ajmer" added as tag
    When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag
    And User clicks "Save Project" button
    And User click on the tab "Response Filters" on requirement overview page
    Then User sees "Ajmer" added as location on Requirement Overview on "Response Filters" tab
    Then User sees "Chandigarh" added as location on Requirement Overview on "Response Filters" tab

  Scenario: Verify that location in PAF can be edited by clicking on "Edit Response Filters" on Requirement Listing
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
    Then User sees "Ajmer" added as tag
    And User clicks "Save Project" button
    And User click on the tab "Response Filters" on requirement overview page
    Then User sees "Ajmer" added as location on Requirement Overview on "Response Filters" tab
    When User clicks "Edit Filter" link
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag
    When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag
    And User clicks "Save Project" button
    And User click on the tab "Response Filters" on requirement overview page
    Then User sees "Chandigarh" added as location on Requirement Overview on "Response Filters" tab

  Scenario: Verify that location in PAF can be edited by clicking "Edit Response Filters" on Requirement Overview in "Response Filters" tab
  	Given User login to the application "addANewRequirement" using "Superuser2" of "Enterprise" user
    When User enters "Ajmer" in "Job Location" field
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
    And User checks "Choose custom filters to apply on responses" checkbox on Requirement Details page
    And User clicks "Save Requirement" button
    Then User is directed to "Response Filters (Optional)" page
    Then User sees "Ajmer" added as tag
    And User clicks "Save Project" button
    And User saves requirement Tracking ID to local
    And User click on the tab "Response Filters" on requirement overview page
    Then User sees "Ajmer" added as location on Requirement Overview on "Response Filters" tab
    And User navigate through GNB to "All Requirements" under "Requirements"
    And User searches for requirement using saved Requirement Tracking ID
    And User hover on "Modify" for a "requirement created"
    And User clicks "Edit Response Filters" link
    Then User is directed to "Response Filters(Optional)" page
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag
    When User enters "Chandigarh" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Chandigarh" added as tag
    And User clicks "Save Project" button
    And User click on the tab "Response Filters" on requirement overview page
    Then User sees "Chandigarh" added as location on Requirement Overview on "Response Filters" tab

