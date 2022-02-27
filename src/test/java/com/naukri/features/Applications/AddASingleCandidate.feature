@RMSApplications
Feature: Add a single profile

  @RMS231 @RMSApplications @SingleProfile @id:1
  Scenario: To verify the name field validations in the add single profile flow
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate ," characters in the candidate name
    And I click on Add Candidate button
    Then I should be able to see the error message as "Special Characters Other Than (Space Dot SingleQuote) are Not Allowed" under candidate name
    When I enter the "Candidate " characters in the candidate name
    And I click on Add Candidate button
    Then I should not be able to see the error message as "Special Characters Other Than (Space Dot SingleQuote) are Not Allowed" under candidate name
    When I enter the "Candidate'" characters in the candidate name
    And I click on Add Candidate button
    Then I should not be able to see the error message as "Special Characters Other Than (Space Dot SingleQuote) are Not Allowed" under candidate name
    When I enter the "Candidate." characters in the candidate name
    And I click on Add Candidate button
    Then I should not be able to see the error message as "Special Characters Other Than (Space Dot SingleQuote) are Not Allowed" under candidate name
    When I enter the "Candidate 1" characters in the candidate name
    And I click on Add Candidate button
    Then I should be able to see the error message as "Special Characters Other Than (Space Dot SingleQuote) are Not Allowed" under candidate name
    When I enter the "!@#$%^&*())?><:{}|" characters in the candidate name
    And I click on Add Candidate button
    Then I should be able to see the error message as "Special Characters Other Than (Space Dot SingleQuote) are Not Allowed" under candidate name

  @RMS @RMSApplications @SingleProfile @id:2
  Scenario Outline: To verify the candidate's name length and absence on the profile created
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the name of "<lengthOfCandidateName>" in the candidate name
    And I fill in the email of the candidate
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And I should be able to see the candidate name I entered while creation
    Examples: 
      | lengthOfCandidateName |
      |                    35 |
      |                    36 |

  @RMS @RMSApplications @SingleProfile @id:3
  Scenario: To verify email static validations on email field of add a single profile
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "empty" address in the email field
    And I click on Add Candidate button
    Then I must see an error message as "This field cannot be left blank" under candidate's email field
    When I enter the "test" address in the email field
    And I click on Add Candidate button
    Then I must see an error message as "Please enter a valid Email Address" under candidate's email field
    When I enter the "test@yopmail" address in the email field
    And I click on Add Candidate button
    Then I must see an error message as "Please enter a valid Email Address" under candidate's email field
    When I enter the "max length" address in the email field
    And I click on Add Candidate button
    Then I must see an error message as "Please enter a valid Email Address" under candidate's email field
    When I enter the "!@#$%^&*())?><:{}|@yopmail.com" address in the email field
    And I click on Add Candidate button
    Then I must see an error message as "Please enter a valid Email Address" under candidate's email field
    When I enter the "test@yopmail.com@yopmail" address in the email field
    And I click on Add Candidate button
    Then I must see an error message as "Please enter a valid Email Address" under candidate's email field
    When I enter the "randomcandidatefortest112@yopmail.com" address in the email field
    And I click on Add Candidate button
    And I should be able to see "The profile has been successfully created." on CV details page
    And I should be able to see the candidate email I entered while creation

  @RMS @RMSApplications @SingleProfile @id:4
  Scenario: To verify the static phone number verification
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter "asdasdasdasdasd" in the candidate phone
    And I click on Add Candidate button
    Then I must see an error message as "Please enter a valid phone number" under candidate's phone number
    When I enter "+91-9.876543210" in the candidate phone
    And I click on Add Candidate button
    Then I must see an error message as "Please enter a valid phone number" under candidate's phone number
    When I enter "{}||><?><>?><>>" in the candidate phone
    And I click on Add Candidate button
    Then I must see an error message as "Please enter a valid phone number" under candidate's phone number
    When I enter "16 digit" in the candidate phone
    And I fill in the email of the candidate
    And I click on Add Candidate button
    And I should be able to see "The profile has been successfully created." on CV details page
    And I should see the candidate mobile number of 15 digits I entered while creation

  @RMS @RMSApplications @SingleProfile @id:5
  Scenario: To verify the validation of the profile summary in add a candidate
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I fill in "<>" in profile summary
    And I fill in the email of the candidate
    And I click on Add Candidate button
    Then I must be able to see the "Special Characters \ and < are Not Allowed" as an error message
    When I fill in "\\" in profile summary
    And I fill in the email of the candidate
    And I click on Add Candidate button
    Then I must be able to see the "Special Characters \ and < are Not Allowed" as an error message
    When I fill in "Profile Summary" in profile summary
    And I fill in the email of the candidate
    And I click on Add Candidate button
    And I should be able to see "The profile has been successfully created." on CV details page
    And I should be able to see the "Profile Summary" in profile summary of CV details page

  @RMS @RMSApplications @SingleProfile @id:6
  Scenario Outline: To verify the profile summary length validation
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I fill in the summary of <summaryLength> characters in profile summary
    And I fill in the email of the candidate
    And I click on Add Candidate button
    And I should be able to see "The profile has been successfully created." on CV details page
    And I should be able to see the in profile summary of CV details page of length 250
    Examples: 
      | summaryLength |
      |           250 |
      |           251 |

  @RMS @RMSApplications @SingleProfile @id:7
  Scenario: To verify functionality of adding more than 1 email address
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I fill in the email of the candidate
    And I fill secondary email of the candidate
    And I click on Add Candidate button
    Then I should be able to see the candidate email I entered while creation
    And I should be able to see the secondary email I entered while creation

  @RMS @RMSApplications @SingleProfile @id:8
  Scenario: To verify the functionality of adding more than 1 contact number
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And I fill in the secondary of the candidate
    And I click on Add Candidate button
    Then I should be able to see the candidate email I entered while creation
    And I should be able to see the primary contact number I entered while creation
    And I should be able to see the secondary contact number I entered while creation

  @RMS @RMSApplications @SingleProfile @id:9
  Scenario: To verify the static links on add a single profile
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    Then I should be able to see the text "See the history of file uploads . "
    When I click on "View Upload Logs" on add a single profile
    Then I should be able to see the page with heading "Application Logs"
    When User select a "Add a Single Profile" from "Profiles" option
    Then I should be able to see the main text as "Import Resume from your Outlook ,Outlook Express, Gmail, Yahoo, Hotmail accounts directly" under email import
    Then I should be able to see the list text as "All imported resume will be searchable." and "Various settings to make sure only relevant emails are imported." under email import
    When I click on email import links
    Then I should be able to see the email import page with heading "Manage your profile"
    When User select a "Add a Single Profile" from "Profiles" option
    Then I should be able to see text "Import Resumes from Outlook (pst)" under Add Profiles via Bulk Upload
    And I should be able to see text " Import Resumes from Thunderbird (.mbox)" under Add Profiles via Bulk Upload
    And I should be able to see text " Import Resumes from Email Files (.eml)" under Add Profiles via Bulk Upload
    And I should be able to see text " Zipped Files [.zip]" under Add Profiles via Bulk Upload
    And I should be able to see text " WinRAR / RAR Files (.rar)" under Add Profiles via Bulk Upload
    And I should be able to see text " 7Zip Files (.7z)" under Add Profiles via Bulk Upload
    And I should be able to see text "Max: 10 GB per file. Max 3 files." under Add Profiles via Bulk Upload
    When I click on add profiles via bulk upload
    Then I should be able to see "Add Candidate - Bulk Upload Files" as the page heading for the bulk CV upload
    When User select a "Add a Single Profile" from "Profiles" option
    Then I should be able to see text "Add profiles by uploading any of the following" under Add Multiple Profiles
    Then I should be able to see text " Microsoft Word (.doc/.docx)" under Add Multiple Profiles
    Then I should be able to see text " Adobe PDF (.pdf)" under Add Multiple Profiles
    Then I should be able to see text " Rich Text Format (.rtf)" under Add Multiple Profiles
    Then I should be able to see text " Plain Text File (.txt)" under Add Multiple Profiles
    Then I should be able to see text " Zipped Archive of above (.zip)" under Add Multiple Profiles
    Then I should be able to see text "Max: 20 Files / 20 MB" under Add Multiple Profiles
    When I click on add multiple profiles
    Then I should be able to see "Add Candidate - Multiple Files" as the page heading for the multiple CV upload
    When User select a "Add a Single Profile" from "Profiles" option
    Then I should be able to see text "Upload Excel sheet with details of multiple candidates to create searchable profiles" under Add Profile via excel upload
    Then I should be able to see text "Max: 1 File" under Add Profile via excel upload
    When I click on excel upload
    Then I should be able to see the page with heading "Add Profile - Excel upload" on excel upload

  @RMS @RMSApplications @SingleProfile @id:10 @Smoke
  Scenario: To add a single profile and mapping it to a new requirement
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And I should be able to see the candidate name I entered while creation
    And I should be able to see the candidate email I entered while creation

  @RMS @RMSApplications @SingleProfile @id:11
  Scenario: To add a single profile and mapping it to a new requirement
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User fills in "Engineer Testing" as Current Designation
    And User fills in "Infoedge" as Current Company
    And User fills in "Noida" as Current Location
    And User checks in "Anywhere in North India" as preferred location
    And User fills in "IT Software - QA & Testing" as Functional Area
    And User fills in "QA/QC Exec." as Role
    And User fills in "Recruitment" as Industry
    And User selects 3 years and 10 months as total experience
    And User selects 10 lakhs and 50 thousands as annual salary
    And User selects 13 lakhs and 70 thousands as expected salary
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And I should be able to see the candidate name I entered while creation
    And I should be able to see the candidate email I entered while creation
    And User should be able to see the "Current Designation" same as "designation" from property file
    And User should be able to see the "Current Company" same as "company" from property file
    And User should be able to see the "Current Location" same as "current location" from property file
    And User should be able to see the "Pref. Location" same as "preferred location" from property file
    And User should be able to see the "Functional Area" same as "functional area" from property file
    And User should be able to see the "Role" same as "role" from property file
    And User should be able to see the "Industry" same as "industry" from property file
    And User should be able to see the "Total Experience" same as "total experience" from property file
    And User should be able to see the "Annual Salary" same as "annual salary" from property file
    And User should be able to see the "Expected CTC" same as "expected ctc" from property file

  @RMS @RMSApplications @SingleProfile @id:12 @Recent @userType 
  Scenario: To verify the comments and star rating for addition at time of creation
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User comments "Comment" on the application at the creation
    And User gives the star rating to the application as 5 stars
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And I should be able to see the candidate name I entered while creation
    And I should be able to see the candidate email I entered while creation
    And User should be able to see the "Comment" in comments section as the comment on index 1
    And User should be able to see the star rating value as "5"

  @RMS @RMSApplications @SingleProfile @id:13 @Recent
  Scenario: To verify the presence of upload sign on CV details page and source
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And I should be able to see the candidate name I entered while creation
    And I should be able to see the candidate email I entered while creation
    And User should be able to see the source as "Single Upload"
    And User should be able to see the upload symbol

  @RMS @RMSApplications @SingleProfile @id:14
  Scenario: To verify the upload and parse of CV through single upload
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    When User select the CV in ".doc" extension for single upload
    Then User should be able to see the "Name" same as resume
    Then User should be able to see the "Email" same as resume
    Then User should be able to see the "Phone" same as resume
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the source as "Single Upload"
    And User should be able to see the upload symbol

  @RMS @RMSApplications @SingleProfile @id:15 @recent
  Scenario: To verify the upload of image on add single profile
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    When User uploads the image of candidate
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And I should be able to see the candidate name I entered while creation
    And I should be able to see the candidate email I entered while creation
    And User uploaded image should also be visible on the CV
	
	@RMS @RMSApplications @SingleProfile @id:16 
  Scenario: To update the status of application while adding through single upload
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate Test User" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User selects the candidate status as "Applied-Matching" while creating the candidate
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    And User should be able to see the requirment name on the candidate page
    And I should be able to see the candidate name I entered while creation
    And I should be able to see the candidate email I entered while creation
    Then I should be able to see candidate on "Applied - Matching" on profile listing page
