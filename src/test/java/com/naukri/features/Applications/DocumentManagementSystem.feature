@RMSApplications
Feature: Document Management System

  Background: 
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

  @RMS @RMSApplications @DMS @id:1
  Scenario: To verify the functionality of Request Documents on the action bar
    When User clicks on Request Document link on action bar
    Then User should be able to see the message "Select the documents that you wish the candidate sends"
    And User should be able to see a text field with placeholder "Select Documents"
    And User should be able to see a "Request" button on DMS widget
    And User should be able to see a "Cancel" button on DMS widget

  @RMS @RMSApplications @DMS @id:2
  Scenario: To verify the list of default documents present in the list
    When User scrolls down to Attached Documents section
    And User clicks on "Request Document" link
    And User clicks on text field for documents list
    Then User should be able to see the following options
      | Select All                |
      | Resume                    |
      | Date of Birth Certificate |
      | Professional Reference    |

  @RMS @RMSApplications @DMS @id:3
  Scenario: To verify the additional document present in the list
    When I click on "Account Settings" by hovering on username
    When user click on "Manage Documents" link
    Then User should be able to see the lightbox with title "Allowed Documents in Profile"
    And user click on "Clear All " link
    When User clicks on Select Documents
    And User selects "PAN Card"
    And user input new document name on manage document page
    And user click on add symbol on manage document page
    Then newly added document should be visible on the manage document page
    When user click on "Save" value
    Then verify success message "Document Type Saved Successfully"
    When User navigates to the added candidate CV details page
    When User scrolls down to Attached Documents section
    And User clicks on "Request Document" link
    And User clicks on text field for documents list
    Then User should be able to see the added options from account settings page

  @RMS @RMSApplications @DMS @id:4
  Scenario: To verify the select all functionality
    When User scrolls down to Attached Documents section
    And User clicks on "Request Document" link
    And User clicks on text field for documents list
    When User clicks on "Select All" for Document
    Then User should be able to see all the documents checkbox checked
    Then User should be able to see the placeholder of input field as "Selected documents" followed by the number of documents

  @RMS @RMSApplications @DMS @id:5
  Scenario: To verify the selection and request of 1 documents
    When User scrolls down to Attached Documents section
    And User clicks on "Request Document" link
    And User clicks on text field for documents list
    When User clicks on "Resume" for Document
    And User clicks on "Request" button for Document
    Then User should be able to see the "Resume" tag on the compose mail screen
    When User clicks on legal acceptance checkbox
    And User clicks on "SEND MAIL" button for DMS
    Then User should be able to see the success message "Mail sent successfully" for document request mail sent

  @RMS @RMSApplications @DMS @id:6
  Scenario: To verify the error message for DMS mail without legalAcceptance
    When User scrolls down to Attached Documents section
    And User clicks on "Request Document" link
    And User clicks on text field for documents list
    When User clicks on "Resume" for Document
    And User clicks on "Request" button for Document
    Then User should be able to see the "Resume" tag on the compose mail screen
    And User should be able to see the message as "We hereby agree that we shall use the documents collected pursuant to this correspondence for the sole and exclusive purpose of recruitment, and shall be solely responsible for any use/misuse of the said documents to the maximum extent permitted by applicable laws, including without limitation, data protection laws."
    When User clicks on "SEND MAIL" button for DMS
    Then User should be able to see the error message as "You have to accept the terms and conditions" on DMS mail

  @RMS @RMSApplications @DMS @id:7
  Scenario: To verify the functionality of Request Documents on DMS mail module
    When User scrolls down to Attached Documents section
    And User clicks on "Request Document" link
    And User clicks on text field for documents list
    When User clicks on "Resume" for Document
    And User clicks on "Request" button for Document
    And User clicks on Request Documents link on mail screen
    And User selects "Date of Birth Certificate" from Document List on mail screen
    Then User should be able to see the "Resume" tag on the compose mail screen
    Then User should be able to see the "Date of Birth Certificate" tag on the compose mail screen
    When User clicks on legal acceptance checkbox
    When User clicks on "SEND MAIL" button for DMS
    Then User should be able to see the success message "Mail sent successfully" for document request mail sent

	@RMS @RMSApplications @DMS @id:8
  Scenario: To verify the include signature for DMS
    When I click on "Account Settings" by hovering on username
    When User click on "Edit Signature" link on settings page
    Then User should be able to see a pop up with heading "Edit Signature" 
    When User records the signature from the popup
    When User navigates to the added candidate CV details page
    When User scrolls down to Attached Documents section
    And User clicks on "Request Document" link
    And User clicks on text field for documents list
    When User clicks on "Resume" for Document
    And User clicks on "Request" button for Document
    And User checks the checkbox for include signature
    And User clicks on legal acceptance checkbox
    When User clicks on "PREVIEW" button for DMS
    Then User should be able to see the heading as "Mail Preview - Message" 
    And User should be able to see the signature as a part of message body
    When User clicks on the "SEND MAIL" on preview lightbox
    Then User should be able to see the success message "Mail sent successfully" for document request mail sent

	@RMS @RMSApplications @DMS @id:9
  Scenario: To verify the send reminder functionality of DMS
    When User scrolls down to Attached Documents section
    And User clicks on "Request Document" link
    And User clicks on text field for documents list
    When User clicks on "Resume" for Document
    And User clicks on "Request" button for Document
    Then User should be able to see the "Resume" tag on the compose mail screen
    When User clicks on legal acceptance checkbox
    When User clicks on "SEND MAIL" button for DMS
    Then User should be able to see the success message "Mail sent successfully" for document request mail sent
    When User scrolls down to Attached Documents section
    And User should be able to see the message as "Candidate's Resume is pending." for DMS
    And User should be able to see a link of Send Reminder for the DMS
    When User clicks on link of Send Reminder
    Then User should be able to see the text "Sent just now" appearing next to send reminder
  
  @RMS @RMSApplications @DMS @id:10
  Scenario: To verify the list of default documents present in the list
		When User scrolls down to Attached Documents section
		And User clicks on "Request Document" link
		And User clicks on text field for documents list
		Then User should be able to see the following options
		| Select All                 |
		| Resume                     |
		| Date of Birth Certificate  |
		| Professional Reference     |
