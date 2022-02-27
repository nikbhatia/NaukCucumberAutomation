Feature: Location taxonomy changes in upload flows

  #Add a single profile
  @id:1 @taxonomyUploads @taxonomyLocation @passed
  Scenario: Verify that on uploading file, old location is identified and is filled on the page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User select the CV in ".doc" extension for single upload with location as "Ahmedabad"
    Then User should be able to see the "Name" same as resume
    Then User should be able to see the "Email" same as resume
    Then User should be able to see the "Phone" same as resume
    Then User should be able to see the "Current Location" same as resume
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in Job Location field for "Requirement"
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    Then User sees current location as "Ahmedabad" on CV Deatil page

	@id:2 @taxonomyUploads @taxonomyLocation @passed
  Scenario: Verify that on uploading file, locations other that old locations are not identified and location field is left blank
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User select the CV in ".doc" extension for single upload with location as "Kumarghat"
    Then User should be able to see the "Email" same as resume
    Then User should be able to see the "Phone" same as resume
    Then User should be able to see the Current Location as blank
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in Job Location field for "Requirement"
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    Then User sees current location as "Not Mentioned" on CV Deatil page

	@id:3 @taxonomyUploads @taxonomyLocation @passed
  Scenario: Verify that on uploading file, if location entered is an international location then location is not identified and is left blank
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    And User is on "addSingleProfile" page
    When User select the CV in ".doc" extension for single upload with location as "USA"
    Then User should be able to see the "Email" same as resume
    Then User should be able to see the "Phone" same as resume
    Then User should be able to see the Current Location as blank
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in Job Location field for "Requirement"
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    Then User sees current location as "Not Mentioned" on CV Deatil page

  #Upload from excel
  Scenario: Verify that on uploading file, old location is identified and is filled on the page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload Profile from Excel" from "Profiles" option
    And User uploads a resume of "XLS" type with "National" location for "ExcelUpload"
    And User selects Excel File Headers with Field to be used
      | EmailID          | Email ID         |
      | NAME             | Name             |
      | CONTACT NUMBER   | Phone Number     |
      | CURRENT LOCATION | Current Location |
    Then User should be able to see the "Location" same as resume
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Upload Files" button
    Then User is directed to "Add Profile - Excel Upload" page
    And User refreshes the page
    And User should be able to see "Success! Profile Creation Process is now complete." message on the page
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees location entered in upload file

  Scenario: Verify that on uploading file, locations other that old locations are not identified and location field is left blank
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload Profile from Excel" from "Profiles" option
    And User select the file in "FilewithNewLocation.xls" for excel upload
    And User selects Excel File Headers with Field to be used
      | EmailID          | Email ID         |
      | NAME             | Name             |
      | CONTACT NUMBER   | Phone Number     |
      | CURRENT LOCATION | Current Location |
    Then User should be able to see the "Location" as blank on Upload Excel
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Upload Files" button
    Then User is directed to "Add Profile - Excel Upload" page
    And User refreshes the page
    And User should be able to see "Success! Profile Creation Process is now complete." message on the page
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees blank location entered in upload file

  Scenario: Verify that on uploading file, if location entered is an international location then location is not identified and is left blank
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload Profile from Excel" from "Profiles" option
    And User select the file in "FilewithInternationalLocation.xls" for excel upload
    And User selects Excel File Headers with Field to be used
      | EmailID          | Email ID         |
      | NAME             | Name             |
      | CONTACT NUMBER   | Phone Number     |
      | CURRENT LOCATION | Current Location |
    Then User should be able to see the "Location" as blank on Upload Excel
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Upload Files" button
    Then User is directed to "Add Profile - Excel Upload" page
    And User refreshes the page
    And User should be able to see "Success! Profile Creation Process is now complete." message on the page
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees blank location entered in upload file

  #Upload Multiple CVs
  Scenario: Verify that on uploading file, old location is identified and is filled on the page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload Multiple CVs" from "Profiles" option
    And User select the file in "FilewithOldLocation.doc" for multiple upload
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Upload Files" button
    Then User is directed to "Add Candidate - Multiple Files" page
    And User should be able to see "Success! Profile Creation Process is now complete." message on the page
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees location entered in upload file

  Scenario: Verify that on uploading file, locations other that old locations are not identified and location field is left blank
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload Multiple CVs" from "Profiles" option
    And User select the file in "FilewithNewLocation.doc" for multiple upload
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Upload Files" button
    Then User is directed to "Add Candidate - Multiple Files" page
    And User should be able to see "Success! Profile Creation Process is now complete." message on the page
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees blank location entered in upload file

  Scenario: Verify that on uploading file, if location entered is an international location then location is not identified and is left blank
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload Multiple CVs" from "Profiles" option
    And User select the file in "FilewithInternationalLocation.doc" for multiple upload
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Upload Files" button
    Then User is directed to "Add Candidate - Multiple Files" page
    And User should be able to see "Success! Profile Creation Process is now complete." message on the page
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees blank location entered in upload file

  #Upload CVs in Bulk
  Scenario: Verify that on uploading file, old location is identified and is filled on the page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload CVs in Bulk" from "Profiles" option
    And User select the file in "FilewithOldLocation.zip" for Bulk upload
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Upload Files" button
    Then User is directed to "Add Candidate - Multiple Files" page
    And User should be able to see "The files have been uploaded and the profile creation process is in progress." message on the page
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    And User searches for candidate uploaded using email entered in upload file
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees location entered in upload file

  Scenario: Verify that on uploading file, locations other that old locations are not identified and location field is left blank
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload CVs in Bulk" from "Profiles" option
    And User select the file in "FilewithNewLocation.zip" for Bulk upload
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Upload Files" button
    Then User is directed to "Add Candidate - Multiple Files" page
    And User should be able to see "The files have been uploaded and the profile creation process is in progress." message on the page
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    And User searches for candidate uploaded using email entered in upload file
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees blank location entered in upload file

  Scenario: Verify that on uploading file, if location entered is an international location then location is not identified and is left blank
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload CVs in Bulk" from "Profiles" option
    And User select the file in "FilewithInternationalLocation.zip" for Bulk upload
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Upload Files" button
    Then User is directed to "Add Candidate - Multiple Files" page
    And User should be able to see "The files have been uploaded and the profile creation process is in progress." message on the page
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    And User searches for candidate uploaded using email entered in upload file
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees blank location entered in upload file

  #Upload CVs from Email
  Scenario: Verify that on uploading file, old location is identified and is filled on the page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload CVs from Email" from "Profiles" option
    And User enters credentials for linking email
    And User sees message "Success! Email Added successfully." on Link Email Account layer
    And User clicks "Add to Specific requirement" radio button
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Save" button
    And User should be able to see "Email Linked." message on the page
    And User sends email to linked email with attachment "FilewithOldLocation.pdf"
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    And User searches for candidate uploaded using email entered in upload file
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees location entered in upload file

  Scenario: Verify that on uploading file, locations other that old locations are not identified and location field is left blank
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload CVs from Email" from "Profiles" option
    And User enters credentials for linking email
    And User sees message "Success! Email Added successfully." on Link Email Account layer
    And User clicks "Add to Specific requirement" radio button    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Save" button
    Then User is directed to "Manage your profile" page
    And User should be able to see "Email Linked." message on the page
    And User sends email to linked email with attachment "FilewithNewLocation.pdf"
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    And User searches for candidate uploaded using email entered in upload file
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees blank location entered in upload file

  Scenario: Verify that on uploading file, if location entered is an international location then location is not identified and is left blank
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Upload CVs from Email" from "Profiles" option
    And User enters credentials for linking email
    And User sees message "Success! Email Added successfully." on Link Email Account layer
    And User clicks "Add to Specific requirement" radio button    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    When User enters "Noida" in "Job Location" field
    And User checks 1 option from the Job Location dropdown
    Then User sees "Noida" added as tag
    And User clicks "Save" button
    Then User is directed to "Manage your profile" page
    And User sends email to linked email with attachment "FilewithInternationalLocation.pdf"
    And User should be able to see "Email Linked." message on the page
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    And User searches for candidate uploaded using email entered in upload file
    And User clicks candidate name on the page
    Then User should be directed to CV Details page for the candidate
    Then User sees same email as entered in upload file
    Then User sees blank location entered in upload file

  #Vendor Upload
  Scenario: Verify that on uploading file, old location is identified and is filled on the page
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And User Select Specific Requirement on Vendor Portal
    And User clicks "Submit Candidates" button on Vendor Portal
    And User uploads "CVwithOldLocation.doc" file on Vendor Portal
    Then User should be able to see the "Location" same as resume on Vendor Portal
    And Vendor submit the resume of candidate
    Then Verify that Vendor is able to view the Success message
    When User is on "logoutPage" page
    And User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    And User Select specific requirement on Requirement list page and click on application count shown against the vendor
    And User clicks on the vendor submitted candidate on SRP Page
    Then User sees location entered is same as resume on CV Details

  Scenario: Verify that on uploading file, locations other that old locations are not identified and location field is left blank
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And User Select Specific Requirement on Vendor Portal
    And User clicks "Submit Candidates" button on Vendor Portal
    And User uploads "CVwithNewLocation.doc" file on Vendor Portal
    Then User should be able to see the "Location" same as resume on Vendor Portal
    And Vendor submit the resume of candidate
    Then Verify that Vendor is able to view the Success message
    When User is on "logoutPage" page
    And User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    And User Select specific requirement on Requirement list page and click on application count shown against the vendor
    And User clicks on the vendor submitted candidate on SRP Page
    Then User sees blank location entered on CV details

  Scenario: Verify that on uploading file, if location entered is an international location then location is not identified and is left blank
    Given User login to the application "VendorPortal" using "Vendor" of "Enterprise2" user
    And User Select Specific Requirement on Vendor Portal
    And User clicks "Submit Candidates" button on Vendor Portal
    And User uploads "CVwithInternationalLocation.doc" file on Vendor Portal
    Then User should be able to see the "Location" same as resume on Vendor Portal
    And Vendor submit the resume of candidate
    Then Verify that Vendor is able to view the Success message
    When User is on "logoutPage" page
    And User login to the application "requirementInbox" using "Superuser" of "Enterprise2" user
    And User Select specific requirement on Requirement list page and click on application count shown against the vendor
    And User clicks on the vendor submitted candidate on SRP Page
    Then User sees blank location entered on CV details
