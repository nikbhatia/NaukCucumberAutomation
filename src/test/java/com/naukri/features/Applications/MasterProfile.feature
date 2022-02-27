@RMSApplications
Feature: Master Profile

  @RMS @RMSApplications @RMSMasterProfile @id:1 @Smoke
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

  @RMS @RMSApplications @RMSMasterProfile @id:2
  Scenario: To verify the Send A Message Flow for master profile
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And I fill in the subject field
    And I click on "PREVIEW"
    Then I should be able to see the message body and message subject on preview layout
    And I should be able to see the "SEND MAIL" and "CLOSE" buttons on the layout footer
    When I click on "SEND MAIL" button
    Then I should be able to see the success ribbon with a message as "Mail sent succesfully"

  @RMS @RMSApplications @RMSMasterProfile @id:3
  Scenario: To verify the Send A Requirement Flow for master profile
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And User select the first candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And I type in the mail subject "testMailBodyText"
    And I type in the mail body "testMailBodyText"
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Success! Mail has been sent." on application inbox

  @RMS @RMSApplications @RMSMasterProfile @RMSForwardFlow @id:4 
  Scenario: To verify the Forward Flow for master profile
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com" for master profile forward
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    And User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."

  @RMS @RMSApplications @RMSMasterProfile @id:5
  Scenario: To verify the presence of the errors without selecting the profile and mailing
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be able to see the error message "Error! Please select the resume(s) you want to contact"
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    Then I should be able to see the error message "Error! Please select the resume(s) you want to contact"
    When User clicks on the forward option
    Then User should be able to see the error message "Error! Please select the resume(s) you want to forward"

  @RMS @RMSApplications @RMSMasterProfile @id:6
  Scenario: To verify the absence of the status strip and star rating
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And User should not be able to the status strip
    And User should not be able to see the star rating

  @RMS @RMSApplications @RMSMasterProfile @id:7
  Scenario: To verify the presence and functionality of the comment for the master profile
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And User should be able to see the comments icon
    When User click on comment icon
    Then User should be able to see the comment widget open
    When User types in the "Comment" in the comment field of the master profile
    And User clicks on Add Comment buttons
    Then User should be able to see the added comment "Comment" in the comment list
    And User should be able to see the comment count incremented

  @RMS @RMSApplications @RMSMasterProfile @id:8
  Scenario: To verify the Add to Requirement error message through the action bar of the SRP page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the Add to Requirement on the action bar
    Then User should be able to see the error message "Error! Please select the resume(s) you want to add to requirement"

  @RMS @RMSApplications @RMSMasterProfile @id:9
  Scenario: To verify the Add to Requirement Functionality through the action bar of SRP page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User select the first candidate checkbox
    And User clicks on the Add to Requirement on the action bar
    Then User should be able to see the popup with heading "Add to Requirement"
    When User clicks on the checkbox for add new requirement
    Then User should be able to see the text field with the label "Requirement Title:"
    When User types in the requirement name in the popup
    And User selects the status as "Applied-Matching"
    And User clicks on the "ADD" button on the popup
    Then User should be able to see the success message as "Success! Profiles are added to selected project"
    And User should be able to see the name of the requirement entered

  @RMS @RMSApplications @RMSMasterProfile @id:10
  Scenario: To verify the Add to Requirement functionality present on the master profile tupple
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User clicks on the Add to Requirement on the tupple
    When User clicks on the checkbox for add new requirement
    Then User should be able to see the text field with the label "Requirement Title:"
    When User types in the requirement name in the popup
    And User selects the status as "Applied-Matching"
    And User clicks on the "ADD" button on the popup
    Then User should be able to see the success message as "Success! Profile Added to selected project" 
    And User should be able to see the name of the requirement entered

  @RMS @RMSApplications @RMSMasterProfile @id:11
  Scenario: To verify the Download Selected Resume Scenario
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And User select the first candidate checkbox
    Then I should be able to see the download drop down
    When I click on download drop down
    And I click on the "Selected Resumes" option
    Then I should be able to see the checkbox for "Attached Resume" on the download lightbox
    When User clicks on the "Download" button on download lightbox
    Then User should be able to see the profile appearing on the search result page

  @RMS @RMSApplications @RMSMasterProfile @id:12
  Scenario: To verify the Download by index range
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When I click on the "Index Range" option
    Then I should be able to see the from index and to index field for "Index Range"
    When User fills in 1 for starting range and 1 for ending range
    When User clicks on the "Download" button on download lightbox
    Then User should be able to see the profile appearing on the search result page

  @RMS @RMSApplications @RMSMasterProfile @id:13
  Scenario: To verify the error message of selected resume without selecting profile
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    Then I should be able to see the download drop down
    When I click on download drop down
    And I click on the "Selected Resumes" option
    Then User should be able to see the success message as "Error!Please select the resume(s) you want to download"

  @RMS @RMSApplications @RMSMasterProfile @id:14
  Scenario: To verify the master profile tupple on the SRP
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And User should be able to see the "Current Designation" same as "designation" from property file
    And User should be able to see the "Current Company" same as "company" from property file
    And User should be able to see the "Current Location" same as "current location" from property file
    And User should be able to see the "Pref Location" same as "preferred location" from property file
    And User should be able to see the "Functional Area" same as "functional area" from property file
    And User should be able to see the "Industry" same as "industry" from property file

  @RMS @RMSApplications @RMSMasterProfile @id:15
  Scenario: To verify the presence of personal CV symbol on master profile
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And User should be able to see the personal symbol for CV searched
    And User should be able to see the tooltip of personal symbol as "Exists in your database and can be downloaded or forwarded for free"

  @RMS @RMSApplications @RMSMasterProfile @id:16
  Scenario: To verify the functionality of sort by parameter
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User records the page count
    And User changes the Sort by category to "Freshness"
    Then User should be able to see the same count of profile
    When User changes the Sort by category to "Relevance"
    Then User should be able to see the same count of profile

  @RMS @RMSApplications @RMSMasterProfile @id:17
  Scenario Outline: To verify the functionality of change in page size
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User records the page count
    When User changes the page size to "20" of "<presenceOfPageSize>"
    Then User should be able to see the same count of profile
    When User changes the page size to "40" of "<presenceOfPageSize>"
    Then User should be able to see the same count of profile
    When User changes the page size to "60" of "<presenceOfPageSize>"
    Then User should be able to see the same count of profile
    When User changes the page size to "80" of "<presenceOfPageSize>"
    Then User should be able to see the same count of profile
    When User changes the page size to "160" of "<presenceOfPageSize>"
    Then User should be able to see the same count of profile
    Examples: 
      | presenceOfPageSize |
      |                  1 |
      |                  2 |

  @RMS @RMSApplications @RMSMasterProfile @id:18
  Scenario: To verify the highlighting on master profile
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User searches for the "company" value in search within result
    Then User should be able to see the "Current Company" highlighted
    When User searches for the "designation" value in search within result
    Then User should be able to see the "Current Designation" highlighted

  @RMS @RMSApplications @RMSMasterProfile @id:19
  Scenario: To verify the call actions for a master profile
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User hovers on select next to contact number and selects "Called"
    Then User should be able to see the status "Called" next to contact number
    When User hovers on select next to contact number and selects "Messaged"
    Then User should be able to see the status "Messaged" next to contact number
    When User hovers on select next to contact number and selects "Call not picked"
    Then User should be able to see the status "Call not picked" next to contact number
    When User hovers on select next to contact number and selects "Not Reachable"
    Then User should be able to see the status "Not Reachable" next to contact number

  @RMS @RMSApplications @RMSMasterProfile @id:20
  Scenario: To verify location facet
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User records the page count
    And User clicks on "Location" facet
    Then User should be able to see count 1 infront of "current location" in property file
    When User checks the checkbox with "current location" value
    Then User should be able to see the same count of profile

  @RMS @RMSApplications @RMSMasterProfile @id:21
  Scenario: To verify functional area facet
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User records the page count
    And User clicks on "Functional Area" facet
    Then User should be able to see count 1 infront of "functional area" in property file
    When User checks the checkbox with "functional area" value
    Then User should be able to see the same count of profile

  @RMS @RMSApplications @RMSMasterProfile @id:22
  Scenario: To verify role facet
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User records the page count
    And User clicks on "Role" facet
    Then User should be able to see count 1 infront of "role" in property file
    When User checks the checkbox with "role" value
    Then User should be able to see the same count of profile

  @RMS @RMSApplications @RMSMasterProfile @id:23
  Scenario: To verify industry facet
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User records the page count
    And User clicks on "Industry" facet
    Then User should be able to see count 1 infront of "industry" in property file
    When User checks the checkbox with "industry" value
    Then User should be able to see the same count of profile

  @RMS @RMSApplications @RMSMasterProfile @id:24
  Scenario: To verify ctc facet
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User records the page count
    And User clicks on "CTC" facet
    Then User should be able to see count 1 infront of "annual salary" in property file
    When User checks the checkbox with "annual salary" value
    Then User should be able to see the same count of profile

  @RMS @RMSApplications @RMSMasterProfile @id:25
  Scenario: To verify designation facet
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User records the page count
    And User clicks on "Designation" facet
    Then User should be able to see count 1 infront of "designation" in property file
    When User checks the checkbox with "designation" value
    Then User should be able to see the same count of profile

  @RMS @RMSApplications @RMSMasterProfile @id:26
  Scenario: To verify personal count under more filter facet
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    When User records the page count
    When User clicks on "More Filters" facet
    Then User should be able to see count 1 infront of Personal CVs count
    When User clicks on Private CVs checkbox
    Then User should be able to see the same count of profile
  
 	@RMS @RMSApplications @RMSMasterProfile @id:27
  Scenario: To verify the active date on master profile tupple
  	Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And User should be able to see the "Active:" date of present day on master profile SRP
  
  @RMS @RMSApplications @RMSMasterProfile @id:28  
  Scenario: To verify the modified date on master profile tupple
  	Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User searches the master profile of the application created in the previous step
    Then User should be able to see the profile appearing on the search result page
    And User should be able to see the "Modified:" date of present day on master profile SRP
  	
