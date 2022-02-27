Feature: Verify Status change On SRP and CV detail page

Background:
Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise2" user


  @StatusChange @RMS @RMSApplications
  	Scenario: verify RMS user is able to Change the status On SRP page
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
    Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on status dropdwon.
    And User select the status as "Prospect" from dropdown
    Then User should be able to see updated status "Prospect" on the tuple
    When User click on status dropdwon.
    And User select the status as "Applied - Matching" from dropdown
    Then User should be able to see updated status "Applied - Matching" on the tuple
     When User click on status dropdwon.
    When User select the status as "Shortlisted2" from dropdown
    Then User should be able to see updated status "Shortlisted2" on the tuple
    When User click on status dropdwon.
    When User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    And User click on "Set" link
    Then User should be able to see updated status "Interview - Round 1" on the tuple
   

  @StatusChange @RMS @RMSApplications
  Scenario: verify RMS user is able to send calendar mail to candidate
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
    Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on status dropdwon.
    And User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    And User click on "Set" link
    And User click on "Email Candidate(s)" button on success message
    And User click on send button on send status change pop-up
    Then User should be able to see updated status "Interview - Round 1" on the tuple
    And User should be able to see the success message "Success! Mail has been sent."

  @StatusChange @RMS @RMSApplications
  Scenario: verify RMS user is able to send calendar mail to Hiring Manager
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
    Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on status dropdwon.
    And User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    And User click on "Set" link
    And User click on "Forward To Hiring Manager" button on success message
    And User enter the email "himdua@yopmail.com" in To field
    And User click on send button on send status change pop-up
    Then User should be able to see updated status "Interview - Round 1" on the tuple
    Then User should be able to see the success message "Success! Mail has been sent." 

  @StatusChange @RMS @RMSApplications 
  Scenario: verify RMS user is able to select Sub status and Interview Type
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
     Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on status dropdwon.
    And User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    And User select Set Sub Status as "On Hold"
    And User click on "Set" link
    Then User should be able to see sub status as "On Hold"
    When User click on "Edit" button against interview details
    And User select Set Sub Status as "Selected"
    And User click on "Set" link
    Then User should be able to see sub status as "Selected"
    When User click on "Edit" button against interview details
    And User select Set Sub Status as "Not Attended"
    And User click on "Set" link
    Then User should be able to see sub status as "Not Attended"
    When User click on "Edit" button against interview details
    And User select Set Interview Type as "Telephonic"
    And User enter the venue detail
    And User click on "Set" link
    Then User should be able to see Interview Type as "Telephonic"
    When User click on "Edit" button against interview details
    And User select Set Interview Type as "Video Conference"
    And User enter the venue detail
    And User click on "Set" link
    Then User should be able to see Interview Type as "Video Conference"
    When User click on "Edit" button against interview details
    And User select Set Interview Type as "Google Meet/Hangout"
    And User click on "Set" link
    Then User should be able to see Interview Type as "Google Meet/Hangout"

  @StatusChange @RMS @RMSApplications
  Scenario: verify RMS user is able to see error message for when and where fields
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
     Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on status dropdwon.
    And User select the status as "Interview - Round 1" from dropdown
    And User click on "Set" link
    Then User should be able to see Error message "Enter Venue details."
    And User should be able to see Error message "Enter Interview Date and Time details."

  @StatusChange @RMS @RMSApplications
  Scenario: verify RMS user is able to reject application on all application status
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
     Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on status dropdwon.
    And User select the status as "Prospect" from dropdown
    And User click on " Reject " link
    Then User should be able to see updated status "Rejected - Prospect" on the tuple
    When User click on status dropdwon.
    And User select the status as "Applied - Matching" from dropdown
    And User click on " Reject " link
    Then User should be able to see updated status "Rejected - Applied - Matching" on the tuple
    When User click on status dropdwon.
    When User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    And User click on "Set" link
    And User click on " Reject " link
    Then User should be able to see updated status "Rejected - Interview - Round 1" on the tuple
    When User click on status dropdwon.
    When User select the status as "Shortlisted2" from dropdown
    And User click on " Reject " link
    Then User should be able to see updated status "Rejected - Shortlisted2" on the tuple
    
    
    @StatusChange @CvDetails @RMS @RMSApplications
  	Scenario: verify RMS user is able to Change the status On CV detail page
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
     Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on first candidate name on inbox page
    And User click on status dropdwon.
    And User select the status as "Prospect" from dropdown
    Then User should be able to see updated status "Prospect" on the tuple
    When User click on status dropdwon.
    And User select the status as "Applied - Matching" from dropdown
    Then User should be able to see updated status "Applied - Matching" on the tuple
     When User click on status dropdwon.
    When User select the status as "Shortlisted2" from dropdown
    Then User should be able to see updated status "Shortlisted2" on the tuple
    When User click on status dropdwon.
    When User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    And User click on "Set" link
    Then User should be able to see updated status "Interview - Round 1" on the tuple
   
   
   
    @StatusChange @CvDetails @RMS @RMSApplications
  Scenario: verify RMS user is able to send calendar mail to candidate from CV detail page
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
     Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on first candidate name on inbox page
    And User click on status dropdwon.
    And User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    And User click on "Set" link
    And User click on "Email Candidate(s)" button on success message
    And User click on send button on send status change pop-up
    Then User should be able to see updated status "Interview - Round 1" on the tuple
    And User should be able to see the success message "Success! Mail has been sent."  
    
    
    @StatusChange  @CvDetails @RMS @RMSApplications
  Scenario: verify RMS user is able to send calendar mail to Hiring Manager on cv detail page
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
     Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on first candidate name on inbox page
    And User click on status dropdwon.
    And User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    And User click on "Set" link
    And User click on "Forward To Hiring Manager" button on success message
    And User enter the email "himdua@yopmail.com" in To field
    And User click on send button on send status change pop-up
    Then User should be able to see updated status "Interview - Round 1" on the tuple
    And User should be able to see the success message "Success! Mail has been sent." 

    @StatusChange @CvDetails @RMS @RMSApplications
  Scenario: verify RMS user is able to select Sub status and Interview Type on cv detail page
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
     Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on first candidate name on inbox page
    And User click on status dropdwon.
    And User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    And User select Set Sub Status as "On Hold"
    And User click on "Set" link
    Then User should be able to see sub status as "On Hold"
    When User click on "Edit" button against interview details
    And User select Set Sub Status as "Selected"
    And User click on "Set" link
    Then User should be able to see sub status as "Selected"
    When User click on "Edit" button against interview details
    And User select Set Sub Status as "Not Attended"
    And User click on "Set" link
    Then User should be able to see sub status as "Not Attended"
    When User click on "Edit" button against interview details
    And User select Set Interview Type as "Telephonic"
    And User enter the venue detail
    And User click on "Set" link
    Then User should be able to see Interview Type as "Telephonic"
    When User click on "Edit" button against interview details
    And User select Set Interview Type as "Video Conference"
    And User enter the venue detail
    And User click on "Set" link
    Then User should be able to see Interview Type as "Video Conference"
    When User click on "Edit" button against interview details
    And User select Set Interview Type as "Google Meet/Hangout"
    And User click on "Set" link
    Then User should be able to see Interview Type as "Google Meet/Hangout"

  @StatusChange @CvDetails @RMS @RMSApplications
  Scenario: verify RMS user is able to see error message for when and where fields on cv detail page
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
     Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on first candidate name on inbox page
    And User click on status dropdwon.
    And User select the status as "Interview - Round 1" from dropdown
    And User click on "Set" link
    Then User should be able to see Error message "Enter Venue details."
    And User should be able to see Error message "Enter Interview Date and Time details."

  @StatusChange @CvDetails @RMS @RMSApplications
  Scenario: verify RMS user is able to reject application on all application status on cv detail page
    When User add a new requirment with "Duplicate candidate" group
    Then User should able to see success message of requirement creation
    When User select a "Add a Single Profile" from "Profiles" option
    And User fill in the random email of the candidate
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on "Add To Requirement" button on inbox page
    And User "Add" recently created candiate in recent created requirement
     Then verify that user should be able to add candidate
    When User reload the page.
    And User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on first candidate name on inbox page
    And User click on status dropdwon.
    And User select the status as "Prospect" from dropdown
    And User click on " Reject " link
    Then User should be able to see updated status "Rejected - Prospect" on the tuple
    When User click on status dropdwon.
    And User select the status as "Applied - Matching" from dropdown
    And User click on " Reject " link
    Then User should be able to see updated status "Rejected - Applied - Matching" on the tuple
    When User click on status dropdwon.
    When User select the status as "Interview - Round 1" from dropdown
    And User fill the interview on upcoming date.
    And User click on "Set" link
    And User click on " Reject " link
    Then User should be able to see updated status "Rejected - Interview - Round 1" on the tuple
    When User click on status dropdwon.
    When User select the status as "Shortlisted2" from dropdown
    And User click on " Reject " link
    Then User should be able to see updated status "Rejected - Shortlisted2" on the tuple
    