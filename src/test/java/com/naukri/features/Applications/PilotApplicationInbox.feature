@Inbox
Feature: To verify the application inbox

  @id:1 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To check the availability of the link "Advance Search" on the page
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    Then I should be able to see the advance search link
    And The advance search link should be clickable

  @id:2 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify the expansion of expand DD against the search bar
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And I click on expand against the "global search"
    Then I should be able to see the expand div against "global search"
    And I click on expand against the "local search"
    Then I should be able to see the expand div against "local search"

  @id:3 @RMS @RMSApplicationInbox @RMSApplications
  Scenario: To verify the facet listed on the application inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And I read all the facets maintained in the application inbox with the number
    And I click on each facet I check the "All" checkox
    Then I should get the same number of CV counts as mentioned on the filter

  @id:4 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify the facet listed on the application inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    And I read all the facets maintained in the application inbox with the number
    And I click on each facet I check the "All" checkox
    Then I should get the same number of CV counts as mentioned on the filter

  @id:5 @RMS @RMSApplications @RMSApplicationInbox @failure
  Scenario: To verify the facet reading from star rating in application inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And I read in the data of the star rating of that particular inbox
    Then I should be able to see the sum of different star rating to be the total count of the inbox
    When I click on each on of the star filter
    Then I should be able to see the same CV count of inbox as on cluster size

  @id:6 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify the number of profiles displayed in application inbox against the page size
    Given I login into RMS as an "Enterprise" user
    When User is on "applicationInbox" page
    And I read the page display count of the inbox page
    Then I should be able to see the same count as on the page display count

  @id:7 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify the facet reading from star rating in backup inbox
    Given I login into RMS as an "Enterprise" user
    When User is on "backupInboxPage" page
    And I read in the data of the star rating of that particular inbox
    Then I should be able to see the sum of different star rating to be the total count of the inbox
    When I click on each on of the star filter
    Then I should be able to see the same CV count of inbox as on cluster size

  @id:8 @RMS @RMSApplicationInbox @RMSApplications
  Scenario: To verify the facet reading from star rating in application inbox
    Given I login into RMS as an "Enterprise" user
    When I navigate to profile inbox
    And I read in the data of the star rating of that particular inbox
    Then I should be able to see the sum of different star rating to be the total count of the inbox
    When I click on each on of the star filter
    Then I should be able to see the same CV count of inbox as on cluster size

  @id:9 @RMS @RMSApplicationInbox @RMSApplications
  Scenario: To verify the facet listed on the application inbox
    Given I login into RMS as an "Enterprise" user
    When I navigate to profile inbox
    And I read all the facets maintained in the application inbox with the number
    And I click on each facet I check the "All" checkox
    Then I should get the same number of CV counts as mentioned on the filter

  @id:10 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify the facet listed on the application inbox
    Given I login into RMS as an "Enterprise" user
    When I navigate to profile inbox
    And User click on the "Custom" under "Application Date" cluster
    And User select the current date from calander
    Then User should be able to see all Application on the current Date

  @id:11 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify the View count, Commnet, Star rating on inbox SRP page
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate" characters in the candidate name
    And User fill in the random email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User comments "Comment" on the application at the creation
    And User gives the star rating to the application as 3 stars
    And I click on Add Candidate button
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    And User should be able to see view count as "1" on tuple
    And User should be able to see commnet count as "1" on tuple
    And User should be able to see star rating as "3" on tuple

  @id:12 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify user is able to enter comment on inbox SRP page
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate" characters in the candidate name
    And User fill in the random email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User gives the star rating to the application as 3 stars
    And I click on Add Candidate button
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on comment icon on inbox
    When User enter comment on inbox
    And User click on "Add Comment" link
    And User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User click on comment icon on inbox
    Then User shoule be able to see entered comment
    And User should be able to see delete icon and comment date

  @id:12 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify user is able to change candidate contact details on inbox SRP page
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate" characters in the candidate name
    And User fill in the random email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User gives the star rating to the application as 3 stars
    And I click on Add Candidate button
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When User hovers on select next to contact number and selects "Called"
    Then User should be able to see the status "Called" next to contact number
    When User hovers on select next to contact number and selects "Messaged"
    Then User should be able to see the status "Messaged" next to contact number
    When User hovers on select next to contact number and selects "Call not picked"
    Then User should be able to see the status "Call not picked" next to contact number
    When User hovers on select next to contact number and selects "Not Reachable"
    Then User should be able to see the status "Not Reachable" next to contact number

  @id:13 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify user is able to send bulk email from inbox SRP page
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate" characters in the candidate name
    And User fill in the random email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User gives the star rating to the application as 3 stars
    And I click on Add Candidate button
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When click on Select all candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And I fill in the subject field
    And I click on "SEND MAIL"
    Then I should be able to see the success ribbon with a message as "Mail sent succesfully"

  @id:14 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify user is able to send bulk Send a requirement from inbox SRP page
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate" characters in the candidate name
    And User fill in the random email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User gives the star rating to the application as 3 stars
    And I click on Add Candidate button
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When click on Select all candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And I type in the mail subject "testMailBodyText"
    And I type in the mail body "testMailBodyText"
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Success! Mail has been sent." on application inbox

  @id:15 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify user is able to send bulk forward from inbox SRP page
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate" characters in the candidate name
    And User fill in the random email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User gives the star rating to the application as 3 stars
    And I click on Add Candidate button
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    And I click on the forward option
    Then User should be redirected to the forward lightbox
    When User fills in to field as "testacount@yopmail.com"
    And User fills in the forward mail subject as "Forward Subject" in forward lightbox
    And User fills in the forward mail body as "Forward Mail Body" in forward lightbox
    When User click on Send button
    Then User should be able to see the success message "Success! Mail has been sent."

  @id:16 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify user is able to send bulk backed-up profile from inbox SRP page
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate" characters in the candidate name
    And User fill in the random email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User gives the star rating to the application as 3 stars
    And I click on Add Candidate button
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When click on Select all candidate checkbox
    And User hover on " Add To Backup "
    And User click on "Selected Resumes" option from backedup list
    When User reload the page.
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    And User should be able to see backedup icon on the tuple

  @id:17 @RMS @RMSApplications @RMSApplicationInbox
  Scenario: To verify user is able to see profile in backedup inbox which is backed-up from inbox SRP page
    Given I login into RMS as an "Enterprise" user
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "Candidate" characters in the candidate name
    And User fill in the random email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User gives the star rating to the application as 3 stars
    And I click on Add Candidate button
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    Then user should be able to see the added candidate on "All Profiles" page
    When click on Select all candidate checkbox
    And User hover on " Add To Backup "
    And User click on "All Profiles" option from backedup list
    When User select a "All Backed Up Profiles" from "Profiles" option
    Then user should be able to see the added candidate on "All Backed Up Profiles" page
 	
 	@id:18 @RMS @RMSApplications @RMSApplicationInbox
  Scenario Outline: To verify the page size change of inbox
  	Given User login to the application "<inboxName>" using "Superuser" of "Enterprise" user
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
    	| inboxName           |   presenceOfPageSize    |
    	| applicationInbox    |           1 						|
    	| applicationInbox    |					  2						  |
    	| profileListingInbox |           1 						|
    	| profileListingInbox |           2 						|
    	| backupInboxPage     |           1 						|
    	| backupInboxPage     |           1 						|
    	
   @wip
   Scenario Outline: To verify the change of page from inbox
   	Given User login to the application "<inboxName>" using "Superuser" of "Enterprise" user
   	Then User should be able to see the "last" icon on page size widget "<presenceOfPageSize>"
   	When User clicks on page number "2" on page size widget "<presenceOfPageSize>"
   	Then User should be able to see the "first" icon on page size widget "<presenceOfPageSize>"
   	Examples:
    	| inboxName           |   presenceOfPageSize    |
    	| applicationInbox    |           1 						|
    	| applicationInbox    |					  2						  |
    	| profileListingInbox |           1 						|
    	| profileListingInbox |           2 						|
    	| backupInboxPage     |           1 						|
    	| backupInboxPage     |           2 						|
		