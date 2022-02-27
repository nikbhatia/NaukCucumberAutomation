@RMS @RMSApplications
Feature: Candidate Details Page

  @CandidateDetailsPage @id:1 @testEdu
  Scenario: Creating a profile for master profile search
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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

  @CandidateDetailsPage @id:2
  Scenario: To verify the Send A Message Flow for master profile candidate on candidate details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And I fill in the subject field
    And I click on "PREVIEW"
    Then I should be able to see the message body and message subject on preview layout
    And I should be able to see the "SEND MAIL" and "CLOSE" buttons on the layout footer
    When I click on "SEND MAIL" button
    Then I should be able to see the success ribbon with a message as "Mail sent successfully" on CandidateDetailsPage

  @CandidateDetailsPage @id:3
  Scenario: To verify the Send A Requirement Flow for master profile candidate on candidate details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And I type in the mail subject "testMailBodyText"
    And I type in the mail body "testMailBodyText"
    And I click on "Send" button on sendRequirement
    Then I should be able to see the success ribbon with a message as "Mail has been sent." on CandidateDetailsPage

  @CandidateDetailsPage @id:4
  Scenario: To verify the Forward Flow for master profile
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User clicks on the forward option on candidate details page
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com" for master profile forward
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."

  @CandidateDetailsPage @id:5
  Scenario: To verify the static information of candidate on candidate details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
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

  @CandidateDetailsPage @id:6
  Scenario: To verify the functionality of attach button on the candidate details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User clicks on the Attach button
    Then User should be able to see the Attached Documents section
    And User should be able to see the informational text "Max file size is 5 MB . Allowed formats are .doc,.docx,.odt,.pdf,.txt,.rtf" under the document drop down
    And User should be able to see the button with text "Upload File"
    And User should be able to see the button with text "Cancel"

  @CandidateDetailsPage @id:7
  Scenario: To verify the functionality of requirement name widget
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should be able to see the "Exists in 1 Other Requirement" on requirement widget
    And User should be able to see the name of the requirement to which the application was mapped
    And User should be able to see the link with text "VIEW" under the requirement
    When User records the status of the application linked to the master profile
    When User clicks on the click with text "VIEW" under the requirement
    Then I should be redirected to the CV details page
    And User should be able to see the requirement name the application is mapped with
    And User should be able to see the status of the application which was recorded from master profile

  @CandidateDetailsPage @id:8
  Scenario: To verify the absence of the star rating filter
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should not be able to see the star rating widget on the candidate details page

  @CandidateDetailsPage @id:9
  Scenario: To verify the absence of status drop down on candidate details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should not be able to see the status drop down on the candidate details page

  @CandidateDetailsPage @id:10
  Scenario: To verify the functionality of comments on candidate details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User comments "Comment" on the application created
    Then User should be able to see the "Comment" in comments section as the comment on index 1

  @CandidateDetailsPage @id:11
  Scenario: To verify the all the links are visible on the Candidate Details Page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    Then User should be able to see link on CV detail page
      | Custom Fields      |
      | Work Experience    |
      | Education          |
      | Attached Documents |
      | Attached Resume    |

  @CandidateDetailsPage @id:12
  Scenario: To verify all sections of information present is present on the Candidate Details Page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    Then User should be able to see following sections on CV detail page
      | Candidate Details           |
      | Custom Fields for candidate |
      | Summary                     |
      | Work Experience             |
      | Education                   |
      | IT Skills                   |
      | Language Known              |
      | Projects                    |
      | Other Details               |
      | Attached Documents          |

  @CandidateDetailsPage @id:13
  Scenario: To verify the functionality of edit summary
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User click on "Edit" link against "Summary" on CV detail page
    And enter data in summary as "This is summary detail for candidate"
    And User click on "Save" button.
    And User reload the page.
    Then User should be able to see saved summary data.

  @CandidateDetailsPage @id:14
  Scenario: To verify the functionality of add experience on candidate details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User click on "Add Experience" link against "Work Experience" on CV detail page
    And User fill detail in Employer Name field as "TCS"
    And User select radio button of "Current Employer"
    And User select "Duration" as "Mar" "2018" on CV detail page
    And User fill detail in Designation field as "Testing Engineer" on CV detail page
    And User fill detail in job Profile field as "Test job profile" on CV detail page
    And User select "Notice period" from dropdown as "15 Days or less" on CV detail page
    And User click on "Save" button on candidate profile page
    Then User should be able to see all the entered details in work experience fields

  @CandidateDetailsPage @id:15 @testEdu
  Scenario: To verify the functionality of add education ug fields
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User click on "Add UG" link against "Education" on CV detail page
    And User choose Degree from dropdown on CV detail page
      | Degree         | B.A                 |
      | specialization | Communication       |
      | University     | Amravati University |
      | Year           |                2017 |
    And User select the education type as "Part Time" on CV detail page
    And User click on "Save" button on candidate profile page
    Then User should be able to see the success message as "Qualification added for the candidate" for added qualification
    When User reload the page.
    Then User should be able to see saved education on the cv details page for "UG"

  @CandidateDetailsPage @id:16 @testEdu
  Scenario: To verify the functionality of add education pg fields
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User click on "Add PG" link against "Education" on CV detail page
    And User choose Degree from dropdown on CV detail page
      | Degree         | M.A             |
      | specialization | Communication   |
      | University     | Anna University |
      | Year           |            2019 |
    And User select the education type as "Full Time" on CV detail page
    And User click on "Save" button on candidate profile page
    Then User should be able to see the success message as "Qualification added for the candidate" for added qualification
    When User reload the page.
    Then User should be able to see saved education on the cv details page for "PG"

  @CandidateDetailsPage @id:17 @testEdu
  Scenario: To verify the functionality of add education ppg fields
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User click on "Add PPG" link against "Education" on CV detail page
    And User choose Degree from dropdown on CV detail page
      | Degree         | MPHIL                |
      | specialization | Anthropology         |
      | University     | Allahabad University |
      | Year           |                 2021 |
    And User select the education type as "Correspondence/Distance Learning" on CV detail page
    And User click on "Save" button on candidate profile page
    Then User should be able to see the success message as "Qualification added for the candidate" for added qualification
    When User reload the page.
    Then User should be able to see saved education on the cv details page for "PPG"

  @CandidateDetailsPage @id:18 @testEdu
  Scenario: To verify the functionality of add certification on candidate's detail page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User click on "Add Certification" link against "Education" on CV detail page
    And User fill detail in "Diploma/Certificate" as "Testing Diploma ISTQB certified" on CV detail page
    And User click on "Save" button on candidate profile page
    Then User should be able to see the success message as "Certifications saved successfully" for added qualification
    Then User should be able to see added certificate in education

  @CandidateDetailsPage @id:19
  Scenario: To verify the functionality of language addition on candidate detail's page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User click on "Edit" link against "Language Known" on CV detail page
    And Add language "English" and Proficiency as "read" , "write" and "speak" on CV detail page
    And click on "Add Language" link on CV detail page
    Then User should be able to see another field for add language
    When User click on "Save" button on candidate profile page
    Then User should be able to see added language on CV detail page

  @CandidateDetailsPage @id:20
  Scenario: To verify the functionality of other details edit on candidate's detail page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    When User click on "Edit" link against "Other Details" on CV detail page
    And User choose "Date of Birth"  date as "11" and month as "Mar" and year as "1988" on CV detail page
    And User choose option in other details on CV detail page
      | Gender                					| Male                  |
      | Job Type             					  | Temporary/Contractual |
      | Employment Type       					| Full Time             |
      | Other Countries       					| Australia             |
      | Physically Challenged 					| Yes                   |
    And User select value in other details on CV detail page
      | maritalStatus         					| Married               |
      | workPermitUS  									| Need H1 Visa 					| 
      | category      									| ST           					|
    And User entered value in other details on CV detail page
      | postalAddress            | This is my Permanent Address |
      | pinCode                  |                       121102 |
      | homeTown                 | Delhi                        |
      | physicallyChallengedDesc | This is Description          |
    And User click on "Save" button on candidate profile page
    Then User should be able to see added details in "Other Details" section

  @CandidateDetailsPage @id:21
  Scenario: To verify absence of delete button on the candidate details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should not be able to see the "Delete" button on the candidate details page

  @CandidateDetailsPage @id:22
  Scenario: To verify absence of attach to backup button on the candidate details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should not be able to see the "Attach to Backup" button on the candidate details page

  @CandidateDetailsPage @id:23
  Scenario: To verify absence of Request Documents link button on the candidate details page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should not be able to see the Request documents link on the candidate details page
  
  @CandidateDetailsPage @id:24 
  Scenario: To verify the last active date on the candidate details page
  	Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should be able to see the "Last Active:" date of present day
  
  @CandidateDetailsPage @id:25
  Scenario: To verify the modified date on the candidate details page
  	Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should be able to see the "Last Modified:" date of present day
  
  @CandidateDetailsPage @id:25
  Scenario: To verify the absence of the ug addition after addition of ug
  	Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should not be able to see "Add UG" under "Education" on details page
  
  @CandidateDetailsPage @id:26
  Scenario: To verify the absence of the pg addition after addition of pg
  	Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should not be able to see "Add PG" under "Education" on details page
    
  @CandidateDetailsPage @id:27  
  Scenario: To verify the absence of the ppg addition after addition of ppg
  	Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should not be able to see "Add PPG" under "Education" on details page
  
  @CandidateDetailsPage @id:28
  Scenario: To verify the absence of the certificate addition after addition of certificate
  	Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the name of the candidate on the SRP page
    Then User should be redirected to the candidate details page
    And User should not be able to see Add Certificate under Education on details page
    
    
  	
  	
    
 		
