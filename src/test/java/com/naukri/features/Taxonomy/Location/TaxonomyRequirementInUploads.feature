Feature: Location Taxonomy changes in uploads - Add new requirement
#wip

  @id:1 @passed
  Scenario: Verify that if no character is typed, but the text area is clicked then only the top metro cities are displayed as checkboxes
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User clicks on Job Location drop down for "Requirement"
    Then User sees "Metropolitan Cities" as checkboxes
      | Ahmedabad              |
      | Bangalore/Bengaluru    |
      | Chennai                |
      | Hyderabad/Secunderabad |
      | Kolkata                |
      | Pune                   |
      | Delhi / NCR            |
      | Mumbai (All Areas)     |

  @id:2 @passed
  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User enters "d" in Job Location field for "Requirement"
    Then User sees at max 5 cities suggestions

  @id:3 @passed
  Scenario: Verify when city is not present in the suggestion
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User enters "x" in Job Location field for "Requirement"
    Then User sees 2 options to add
      | Add as National Location      |
      | Add as International Location |

  @id:4 @passed
  Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User enters "testgvj" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    Then User sees "Add Other Location" layer opened with options
      | Other Location |
      | State          |
    Then User sees "testgvj" entered text in "Other Location" field

  @id:5 @passed
  Scenario: Verify error messages in "Add Other Location" layer
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User enters "testgvj" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  @id:6 @passed
  Scenario: Verify user is able to add Other National Location
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "testgvj" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "testgvj-Andhra Pradesh" added as tag
    And User selects the candidate status as "Applied-Matching" while creating the candidate
    And User comments "Comment" on the application at the creation
    And User gives the star rating to the application as 5 stars
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And user click on requirement name on cv details page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "testgvj - Andhra Pradesh" added as location on Requirement Overview

  @id:7 @passed
  Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User enters "testgvj" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    Then User sees "Add International Location" layer opened with options
      | Other Location |
      | Country        |
    Then User sees "testgvj" entered text in "Other Location" field

  @id:8 @passed
  Scenario: Verify error messages in "Add International Location" layer
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User enters "testgvj" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "testgvj" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  @id:9 @passed
  Scenario: Verify user is able to add Other International Location
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User enters "testgvj" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    Then User sees "testgvj-Australia" added as tag
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And user click on requirement name on cv details page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "testgvj - Australia" added as location on Requirement Overview

  @id:10 @passed
  Scenario: Verify that each city selection is displayed as tags
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "Noida" in Job Location field for "Requirement"
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And user click on requirement name on cv details page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  @id:11 @passed
  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User checks 1 option from dropdown in Top Metropolitan Cities
    Then User sees selected city is shown checked in the dropdown

  @id:12 @passed
  Scenario: Verify the tag added if city is not present in global list
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User enters "testgvj" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    When User enters "Andhra Pradesh" in "locParent" field
    And User checks the checkbox from the dropdown
    #And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "testgvj-Andhra Pradesh" added as tag
    When User clicks cross icon for the tag
    When User enters "test1" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test1-Australia" added as tag

  @id:13 @passed
  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "rmsDashboardPage" page
    And User navigate through GNB to "Add a Single Profile" under "Profiles"
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User enters "Ajmer" in Job Location field for "Requirement"
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User clicks outside the Job Location dropdown
    When User enters "Ajmer" in Job Location field for "Requirement"
    Then User sees "Ajmer" option is checked in dropdown
    When User unchecks "Ajmer" option from dropdown
    Then User sees "Ajmer" removed as tag

  @id:14 @passed
  Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "rmsDashboardPage" page
    And User navigate through GNB to "Add a Single Profile" under "Profiles"
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    When User enters "Ajmer" in Job Location field for "Requirement"
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag

  @id:15 @passed
  Scenario: Verify location is editable after Requirement is created
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "Ajmer" in Job Location field for "Requirement"
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And user click on requirement name on cv details page
    And User click on the tab "Edit" on requirement overview page
    And User fill in the job title
    And User fill in the Job Description
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    And User clicks on "locSuggestor" drop down
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fill in the keywords as "java"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And Verify User redirected to requirement overview page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  @id:16 @passed
  Scenario: Verify that user is able to edit location entered after the requirement has been created with national location not present in global list
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "testgvj" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "testgvj-Andhra Pradesh" added as tag
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And user click on requirement name on cv details page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "testgvj - Andhra Pradesh" added as location on Requirement Overview
    And User click on the tab "Edit" on requirement overview page
    And User fill in the job title
    And User fill in the Job Description
    Then User sees "testgvj-Andhra Pradesh" added as tag
    When User clicks cross icon for the tag
    And User clicks on "locSuggestor" drop down
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fill in the keywords as "java"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And Verify User redirected to requirement overview page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  @id:17 @passed
  Scenario: Verify that user is able to edit location entered after the requirement has been created with international location not present in global list
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    And User uploads a resume of "PDF" type with "National" location for "SingleUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "testgvj" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "testgvj-Australia" added as tag
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And user click on requirement name on cv details page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "testgvj - Australia" added as location on Requirement Overview
    And User click on the tab "Edit" on requirement overview page
    Then User sees "testgvj-Australia" added as tag
    When User clicks cross icon for the tag
    And User clicks on "locSuggestor" drop down
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the keywords as "java"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And Verify User redirected to requirement overview page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  #Upload from Excel
  @id:18 @passed
  Scenario: Verify that if no character is typed, but the text area is clicked then only the top metro cities are displayed as checkboxes
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User clicks on Job Location drop down for "Requirement"
    Then User sees "Metropolitan Cities" as checkboxes
      | Ahmedabad              |
      | Bangalore/Bengaluru    |
      | Chennai                |
      | Hyderabad/Secunderabad |
      | Kolkata                |
      | Pune                   |
      | Delhi / NCR            |
      | Mumbai (All Areas)     |

  @id:19 @passed
  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User enters "d" in Job Location field for "Requirement"
    Then User sees at max 5 cities suggestions

  @id:20 @passed
  Scenario: Verify when city is not present in the suggestion
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User enters "x" in Job Location field for "Requirement"
    Then User sees 2 options to add
      | Add as National Location      |
      | Add as International Location |

  @id:21 @passed
  Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User enters "testing" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    Then User sees "Add Other Location" layer opened with options
      | Other Location |
      | State          |
    Then User sees "testing" entered text in "Other Location" field

  @id:22 @passed
  Scenario: Verify error messages in "Add Other Location" layer
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User enters "testing" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "testing" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  @id:23 @passed
  Scenario: Verify user is able to add Other National Location
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "testing" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "testing-Andhra Pradesh" added as tag
    And User click on Upload Files button
    Then User verify that profile is added successfully
    And User is on "requirementInbox" page
    And User clicks on created requirement name
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "testing - Andhra Pradesh" added as location on Requirement Overview

  @id:24 @passed
  Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User enters "testing" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    Then User sees "Add International Location" layer opened with options
      | Other Location |
      | Country        |
    Then User sees "testing" entered text in "Other Location" field

  @id:25 @passed
  Scenario: Verify error messages in "Add International Location" layer
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "rmsDashboardPage" page
    And User navigate through GNB to "Upload Profiles from Excel" under "Profiles"
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User enters "testing" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "testing" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

  @id:26 @passed
  Scenario: Verify user is able to add Other International Location
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "testing" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "testing-Australia" added as tag
    And User click on Upload Files button
    Then User verify that profile is added successfully
    And User is on "requirementInbox" page
    And User clicks on created requirement name
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "testing - Australia" added as location on Requirement Overview

  @id:27 @passed
  Scenario: Verify that each city selection is displayed as tags
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "Noida" in Job Location field for "Requirement"
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User click on Upload Files button
    Then User verify that profile is added successfully
    And User is on "requirementInbox" page
    And User clicks on created requirement name
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  @id:28 @passed
  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User checks 1 option from dropdown in Top Metropolitan Cities
    Then User sees selected city is shown checked in the dropdown

  @id:29 @passed
  Scenario: Verify the tag added if city is not present in global list
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User enters "testing" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "testing-Andhra Pradesh" added as tag
    When User clicks cross icon for the tag
    When User enters "tested" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "tested-Australia" added as tag

  @id:30 @passed
  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User enters "Ajmer" in Job Location field for "Requirement"
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User clicks outside the Job Location dropdown
    When User enters "Ajmer" in Job Location field for "Requirement"
    Then User sees "Ajmer" option is checked in dropdown
    When User unchecks "Ajmer" option from dropdown
    Then User sees "Ajmer" removed as tag

  @id:31 @passed
  Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    When User enters "Ajmer" in Job Location field for "Requirement"
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag

  @id:32 @passed
  Scenario: Verify location is editable after Requirement is created
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "Ajmer" in Job Location field for "Requirement"
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User click on Upload Files button
    Then User verify that profile is added successfully
    And User is on "requirementInbox" page
    And User clicks on created requirement name
    And User click on the tab "Requirement Details" on requirement overview page
    And User click on the tab "Edit" on requirement overview page
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the keywords as "java"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  @id:33 @passed
  Scenario: Verify that user is able to edit location entered after the requirement has been created with national location not present in global list
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "testing" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "testing-Andhra Pradesh" added as tag
    And User click on Upload Files button
    Then User verify that profile is added successfully
    And User is on "requirementInbox" page
    And User clicks on created requirement name
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "testing - Andhra Pradesh" added as location on Requirement Overview
    And User click on the tab "Edit" on requirement overview page
    Then User sees "testing-Andhra Pradesh" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the keywords as "java"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  @id:34 @passed
  Scenario: Verify that user is able to edit location entered after the requirement has been created with international location not present in global list
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User navigates to "excelUploadPage" page
    And User uploads a resume of "XLSX" type with "National" location for "ExcelUpload"
    And User clicks on Add New
    And User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    When User enters "testing" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "testing-Australia" added as tag
    And User click on Upload Files button
    Then User verify that profile is added successfully
    And User is on "requirementInbox" page
    And User clicks on created requirement name
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "testing - Australia" added as location on Requirement Overview
    And User click on the tab "Edit" on requirement overview page
    Then User sees "testing-Australia" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "locSuggestor" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the keywords as "java"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview
    
  # Upload Multiple CVs
  
  @id:33
  Scenario: Verify that if no character is typed, but the text area is clicked then only the top metro cities are displayed as checkboxes
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    And User fill in the requirement title
    When User clicks on Job Location drop down for "Requirement"
    Then User sees "Metropolitan Cities" as checkboxes
      | Ahmedabad              |
      | Bangalore/Bengaluru    |
      | Chennai                |
      | Hyderabad/Secunderabad |
      | Kolkata                |
      | Pune                   |
      | Delhi / NCR            |
      | Mumbai (All Areas)     |

  @id:34
  Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "d" in Job Location field for "Requirement"
    Then User sees at max 5 cities suggestions

	@id:35
  Scenario: Verify when city is not present in the suggestion
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "x" in Job Location field for "Requirement"
    Then User sees 2 options to add
      | Add as National Location      |
      | Add as International Location |

	@id:36
  Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "test" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    Then User sees "Add Other Location" layer opened with options
      | Other Location |
      | State          |
    Then User sees "test" entered text in "Other Location" field

	@id:37
  Scenario: Verify error messages in "Add Other Location" layer
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "test" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

	@id:38 @ToCheck
  Scenario: Verify user is able to add Other National Location
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "test" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "test-Andhra Pradesh" added as location on Requirement Overview

	@id:39
  Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "test" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    Then User sees "Add International Location" layer opened with options
      | Other Location |
      | Country        |
    Then User sees "test" entered text in "Other Location" field

	@id:40
  Scenario: Verify error messages in "Add International Location" layer
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "test" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    When User clears "Other Location" field
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer
    When User enters "test" in "Other Location" field in the layer
    And User clicks "Add" button
    Then User sees "This field cannot be left empty" error messages on Layer

	@id:41 @ToCheck
  Scenario: Verify user is able to add Other International Location
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "test" in Job Location field for "Requirement"
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "test-Australia" added as location on Requirement Overview

	@id:42 @ToCheck
  Scenario: Verify that each city selection is displayed as tags
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "Noida" in Job Location field for "Requirement"
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

	@id:43
  Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User checks 1 option from dropdown in Top Metropolitan Cities
    Then User sees selected city is shown checked in the dropdown

	@id:44
  Scenario: Verify the tag added if city is not present in global list
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "test" in Job Location field for "Requirement"
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as tag
    When User clicks cross icon for the tag
    When User enters "test1" in "Job Location" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test1-Australia" added as tag

	@id:45
  Scenario: Verify that user is able to un-check the selected location from the dropdown
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "Ajmer" in Job Location field for "Requirement"
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User clicks outside the Job Location dropdown
    When User enters "Ajmer" in "Job Location" field
    Then User sees "Ajmer" option is checked in dropdown
    When User unchecks "Ajmer" option from dropdown
    Then User sees "Ajmer" removed as tag

	@id:46
  Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "Ajmer" in Job Location field for "Requirement"
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    Then User sees "Ajmer" removed as tag

	@id:47 @ToCheck
  Scenario: Verify location is editable after Requirement is created
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "Ajmer" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Ajmer" added as tag
    And User fills all details other than Job Location
    And User click on "Add Requirement" button on requirement creation
    And User clicks on "Requirement Overview" button
    And User clicks "Edit" button
    Then User sees "Ajmer" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User clicks "Upload Files" button
    And User opens Requirement created with the profile
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

	@id:48 @ToCheck
  Scenario: Verify that user is able to edit location entered after the requirement has been created with national location not present in global list
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "test" in "Job Location" field
    And User clicks "Add as National Location" option for adding not found city
    And User selects 1 option from "State" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Andhra Pradesh" added as tag
    And User fills all details other than Job Location
    And User clicks "Upload Files" button
    And User opens Requirement created with the profile
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "test-Andhra Pradesh" added as location on Requirement Overview
    And User clicks "Edit" button
    Then User sees "test-Andhra Pradesh" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User clicks "Next" button
    And User clicks "Save Requirement" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

	@id:49 @ToCheck
  Scenario: Verify that user is able to edit location entered after the requirement has been created with international location not present in global list
    Given I login into RMS as an "Enterprise" user
    And User navigate through GNB to "Upload Multiple CVs" under "Profiles"
    And User uploads a resume of "DOCX" type with "National" location for "MultiUpload"
    And User clicks on Add New
    When User enters "test" in "Job Location" field
    And User clicks "Add as International Location" option for adding not found city
    And User selects 1 option from "Country" dropdown in layer
    And User clicks "Add" button
    Then User sees "test-Australia" added as tag
    And User fills all details other than Job Location
    And User clicks "Upload Files" button
    And User opens Requirement created with the profile
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "test-Australia" added as location on Requirement Overview
    And User clicks "Edit" button
    Then User sees "test-Australia" added as tag
    When User clicks cross icon for the tag
    When User enters "Noida" in "Job Location" field
    And User checks the checkbox from the dropdown
    Then User sees "Noida" added as tag
    And User fills all details other than Job Location
    And User clicks "Next" button
    And User clicks "Save Requirement" button
    And User click on the tab "Requirement Details" on requirement overview page
    Then User sees "Noida" added as location on Requirement Overview

  # Upload CVs in Bulk
  #Scenario: Verify that if no character is typed, but the text area is clicked then only the top metro cities are displayed as checkboxes
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User clicks on "Job Location" drop down
    #Then User sees "Metropolitan Cities" as checkboxes
      #| Ahmedabad              |
      #| Bangalore/Bengaluru    |
      #| Chennai                |
      #| Hyderabad/Secunderabad |
      #| Kolkata                |
      #| Pune                   |
      #| Delhi / NCR            |
      #| Mumbai (All Areas)     |
#
  #Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "d" in "Job Location" field
    #Then User sees at max 5 cities suggestions
#
  #Scenario: Verify when city is not present in the suggestion
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "x" in "Job Location" field
    #Then User sees 2 options to add
      #| Add as National Location      |
      #| Add as International Location |
#
  #Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as National Location" option for adding not found city
    #Then User sees "Add Other Location" layer opened with options
      #| Other Location |
      #| State          |
    #Then User sees "test" entered text in "Other Location" field
#
  #Scenario: Verify error messages in "Add Other Location" layer
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as National Location" option for adding not found city
    #When User clears "Other Location" field
    #And User clicks "Add" button
    #Then User sees "This field cannot be left empty" error messages on Layer
    #When User enters "test" in "Other Location" field in the layer
    #And User clicks "Add" button
    #Then User sees "This field cannot be left empty" error messages on Layer
#
  #Scenario: Verify user is able to add Other National Location
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as National Location" option for adding not found city
    #And User selects 1 option from "State" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test-Andhra Pradesh" added as tag
    #And User fills all details other than Job Location
    #And User click on "Add Requirement" button on requirement creation
    #And User clicks on "Requirement Overview" button
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "test-Andhra Pradesh" added as location on Requirement Overview
#
  #Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as International Location" option for adding not found city
    #Then User sees "Add International Location" layer opened with options
      #| Other Location |
      #| Country        |
    #Then User sees "test" entered text in "Other Location" field
#
  #Scenario: Verify error messages in "Add International Location" layer
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as International Location" option for adding not found city
    #When User clears "Other Location" field
    #And User clicks "Add" button
    #Then User sees "This field cannot be left empty" error messages on Layer
    #When User enters "test" in "Other Location" field in the layer
    #And User clicks "Add" button
    #Then User sees "This field cannot be left empty" error messages on Layer
#
  #Scenario: Verify user is able to add Other International Location
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as International Location" option for adding not found city
    #And User selects 1 option from "Country" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test-Australia" added as tag
    #And User fills all details other than Job Location
    #And User click on "Add Requirement" button on requirement creation
    #And User clicks on "Requirement Overview" button
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "test-Australia" added as location on Requirement Overview
#
  #Scenario: Verify that each city selection is displayed as tags
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "Noida" in "Job Location" field
    #And User checks 1 option from the Job Location dropdown
    #Then User sees "Noida" added as tag
    #And User fills all details other than Job Location
    #And User click on "Add Requirement" button on requirement creation
    #And User clicks on "Requirement Overview" button
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "Noida" added as location on Requirement Overview
#
  #Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User checks 1 option from dropdown in "Top Metropolitan Cities"
    #Then User sees selected city is shown checked in the dropdown
#
  #Scenario: Verify the tag added if city is not present in global list
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as National Location" option for adding not found city
    #And User selects 1 option from "State" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test-Andhra Pradesh" added as tag
    #When User clicks cross icon for the tag
    #When User enters "test1" in "Job Location" field
    #And User clicks "Add as International Location" option for adding not found city
    #And User selects 1 option from "Country" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test1-Australia" added as tag
#
  #Scenario: Verify that user is able to un-check the selected location from the dropdown
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "Ajmer" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Ajmer" added as tag
    #And User clicks outside the Job Location dropdown
    #When User enters "Ajmer" in "Job Location" field
    #Then User sees "Ajmer" option is checked in dropdown
    #When User unchecks "Ajmer" option from dropdown
    #Then User sees "Ajmer" removed as tag
#
  #Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "Ajmer" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Ajmer" added as tag
    #When User clicks cross icon for the tag
    #Then User sees "Ajmer" removed as tag
#
  #Scenario: Verify location is editable after Requirement is created
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "Ajmer" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Ajmer" added as tag
    #And User fills all details other than Job Location
    #And User click on "Add Requirement" button on requirement creation
    #And User clicks on "Requirement Overview" button
    #And User clicks "Edit" button
    #Then User sees "Ajmer" added as tag
    #When User clicks cross icon for the tag
    #When User enters "Noida" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Noida" added as tag
    #And User fills all details other than Job Location
    #And User clicks "Upload Files" button
    #And User opens Requirement created with the profile
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "Noida" added as location on Requirement Overview
#
  #Scenario: Verify that user is able to edit location entered after the requirement has been created with national location not present in global list
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as National Location" option for adding not found city
    #And User selects 1 option from "State" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test-Andhra Pradesh" added as tag
    #And User fills all details other than Job Location
    #And User clicks "Upload Files" button
    #And User opens Requirement created with the profile
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "test-Andhra Pradesh" added as location on Requirement Overview
    #And User clicks "Edit" button
    #Then User sees "test-Andhra Pradesh" added as tag
    #When User clicks cross icon for the tag
    #When User enters "Noida" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Noida" added as tag
    #And User fills all details other than Job Location
    #And User clicks "Next" button
    #And User clicks "Save Requirement" button
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "Noida" added as location on Requirement Overview
#
  #Scenario: Verify that user is able to edit location entered after the requirement has been created with international location not present in global list
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs in Bulk" under "Profiles"
    #And User uploads bulk CVs
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as International Location" option for adding not found city
    #And User selects 1 option from "Country" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test-Australia" added as tag
    #And User fills all details other than Job Location
    #And User clicks "Upload Files" button
    #And User opens Requirement created with the profile
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "test-Australia" added as location on Requirement Overview
    #And User clicks "Edit" button
    #Then User sees "test-Australia" added as tag
    #When User clicks cross icon for the tag
    #When User enters "Noida" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Noida" added as tag
    #And User fills all details other than Job Location
    #And User clicks "Next" button
    #And User clicks "Save Requirement" button
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "Noida" added as location on Requirement Overview
#
  # Upload CVs from Email
  #Scenario: Verify that if no character is typed, but the text area is clicked then only the top metro cities are displayed as checkboxes
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User clicks on "Job Location" drop down
    #Then User sees "Metropolitan Cities" as checkboxes
      #| Ahmedabad              |
      #| Bangalore/Bengaluru    |
      #| Chennai                |
      #| Hyderabad/Secunderabad |
      #| Kolkata                |
      #| Pune                   |
      #| Delhi / NCR            |
      #| Mumbai (All Areas)     |
#
  #Scenario: Verify that on first stroke of any aplhabet, suggestion pool is displayed
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "d" in "Job Location" field
    #Then User sees at max 5 cities suggestions
#
  #Scenario: Verify when city is not present in the suggestion
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "x" in "Job Location" field
    #Then User sees 2 options to add
      #| Add as National Location      |
      #| Add as International Location |
#
  #Scenario: Verify when city is not present in the suggestion and user selects "Add as National Location"
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as National Location" option for adding not found city
    #Then User sees "Add Other Location" layer opened with options
      #| Other Location |
      #| State          |
    #Then User sees "test" entered text in "Other Location" field
#
  #Scenario: Verify error messages in "Add Other Location" layer
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as National Location" option for adding not found city
    #When User clears "Other Location" field
    #And User clicks "Add" button
    #Then User sees "This field cannot be left empty" error messages on Layer
    #When User enters "test" in "Other Location" field in the layer
    #And User clicks "Add" button
    #Then User sees "This field cannot be left empty" error messages on Layer
#
  #Scenario: Verify user is able to add Other National Location
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as National Location" option for adding not found city
    #And User selects 1 option from "State" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test-Andhra Pradesh" added as tag
    #And User fills all details other than Job Location
    #And User click on "Add Requirement" button on requirement creation
    #And User clicks on "Requirement Overview" button
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "test-Andhra Pradesh" added as location on Requirement Overview
#
  #Scenario: Verify when city is not present in the suggestion and user selects "Add as International Location"
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as International Location" option for adding not found city
    #Then User sees "Add International Location" layer opened with options
      #| Other Location |
      #| Country        |
    #Then User sees "test" entered text in "Other Location" field
#
  #Scenario: Verify error messages in "Add International Location" layer
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as International Location" option for adding not found city
    #When User clears "Other Location" field
    #And User clicks "Add" button
    #Then User sees "This field cannot be left empty" error messages on Layer
    #When User enters "test" in "Other Location" field in the layer
    #And User clicks "Add" button
    #Then User sees "This field cannot be left empty" error messages on Layer
#
  #Scenario: Verify user is able to add Other International Location
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as International Location" option for adding not found city
    #And User selects 1 option from "Country" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test-Australia" added as tag
    #And User fills all details other than Job Location
    #And User click on "Add Requirement" button on requirement creation
    #And User clicks on "Requirement Overview" button
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "test-Australia" added as location on Requirement Overview
#
  #Scenario: Verify that each city selection is displayed as tags
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "Noida" in "Job Location" field
    #And User checks 1 option from the Job Location dropdown
    #Then User sees "Noida" added as tag
    #And User fills all details other than Job Location
    #And User click on "Add Requirement" button on requirement creation
    #And User clicks on "Requirement Overview" button
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "Noida" added as location on Requirement Overview
#
  #Scenario: Verify that preselected city in dropdown are shown as checked/selected in the dropdown
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User checks 1 option from dropdown in "Top Metropolitan Cities"
    #Then User sees selected city is shown checked in the dropdown
#
  #Scenario: Verify the tag added if city is not present in global list
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as National Location" option for adding not found city
    #And User selects 1 option from "State" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test-Andhra Pradesh" added as tag
    #When User clicks cross icon for the tag
    #When User enters "test1" in "Job Location" field
    #And User clicks "Add as International Location" option for adding not found city
    #And User selects 1 option from "Country" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test1-Australia" added as tag
#
  #Scenario: Verify that user is able to un-check the selected location from the dropdown
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "Ajmer" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Ajmer" added as tag
    #And User clicks outside the Job Location dropdown
    #When User enters "Ajmer" in "Job Location" field
    #Then User sees "Ajmer" option is checked in dropdown
    #When User unchecks "Ajmer" option from dropdown
    #Then User sees "Ajmer" removed as tag
#
  #Scenario: Verify that user is able to de-select location by clicking on cross icon on the tag
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "Ajmer" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Ajmer" added as tag
    #When User clicks cross icon for the tag
    #Then User sees "Ajmer" removed as tag
#
  #Scenario: Verify location is editable after Requirement is created
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "Ajmer" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Ajmer" added as tag
    #And User fills all details other than Job Location
    #And User click on "Add Requirement" button on requirement creation
    #And User clicks on "Requirement Overview" button
    #And User clicks "Edit" button
    #Then User sees "Ajmer" added as tag
    #When User clicks cross icon for the tag
    #When User enters "Noida" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Noida" added as tag
    #And User fills all details other than Job Location
    #And User clicks "Save" button
    #And User opens Requirement created with the profile
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "Noida" added as location on Requirement Overview
#
  #Scenario: Verify that user is able to edit location entered after the requirement has been created with national location not present in global list
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as National Location" option for adding not found city
    #And User selects 1 option from "State" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test-Andhra Pradesh" added as tag
    #And User fills all details other than Job Location
    #And User clicks "Save" button
    #And User opens Requirement created with the profile
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "test-Andhra Pradesh" added as location on Requirement Overview
    #And User clicks "Edit" button
    #Then User sees "test-Andhra Pradesh" added as tag
    #When User clicks cross icon for the tag
    #When User enters "Noida" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Noida" added as tag
    #And User fills all details other than Job Location
    #And User clicks "Next" button
    #And User clicks "Save Requirement" button
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "Noida" added as location on Requirement Overview
#
  #Scenario: Verify that user is able to edit location entered after the requirement has been created with international location not present in global list
    #Given I login into RMS as an "Enterprise" user
    #And User navigate through GNB to "Upload CVs from Email" under "Profiles"
    #And User enters credentails for account to be linked
    #And User clicks "Add to Specific requirement" option
    #And User clicks on Add New
    #When User enters "test" in "Job Location" field
    #And User clicks "Add as International Location" option for adding not found city
    #And User selects 1 option from "Country" dropdown in layer
    #And User clicks "Add" button
    #Then User sees "test-Australia" added as tag
    #And User fills all details other than Job Location
    #And User clicks "Save" button
    #And User opens Requirement created with the profile
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "test-Australia" added as location on Requirement Overview
    #And User clicks "Edit" button
    #Then User sees "test-Australia" added as tag
    #When User clicks cross icon for the tag
    #When User enters "Noida" in "Job Location" field
    #And User checks the checkbox from the dropdown
    #Then User sees "Noida" added as tag
    #And User fills all details other than Job Location
    #And User clicks "Next" button
    #And User clicks "Save Requirement" button
    #And User click on the tab "Requirement Details" on requirement overview page
    #Then User sees "Noida" added as location on Requirement Overview
