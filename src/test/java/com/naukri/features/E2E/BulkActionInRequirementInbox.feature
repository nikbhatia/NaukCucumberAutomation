Feature: Bulk Actions in Requirement inbox

  @WIP
    Scenario: verify RMS user is able to perform bulk actions in requirement inbox.
    Given I login into RMS as an "Enterprise" user
    When User add a new requirment with "Duplicate candidate" group
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User select the questionnaire from list
    And User click on the tab "Save Requirement" on requirement overview page
    And User click on the "Questionnaire" tab on requirement overview page
    Then User should be able to see attached questionnaire under questionnaire tab
    When User select a "Upload Multiple CVs" from "Profiles" option
    Then I should be able to see "Add Candidate - Multiple Files" as the page heading for the multiple CV upload
    When I select the CV in ".doc" extension for bulk upload
    When I select the CV in ".doc" extension for bulk upload
    When I select the CV in ".doc" extension for bulk upload
    And User "Upload Files" recently created candiate in recent created requirement
    Then I should be able to see the success message of multiple uploaded CV as "The files have been uploaded and the profile creation process in in progress. Please check the upload logs in some time for more details."
    When User select a "All Requirements" from "Requirements" option
    And User click on the application count against requirement.
    And User click on Select all candidate checkbox
    And User click on "Change Status" option on inbox page
    Then User should be able to see change status pop up
    When User select the "Shortlisted" status on change status popup
    And User click on update button
    Then User should be able to see changed status "Shortlisted" of candidate
    When User click on first candidate on inbox page
    And User click on "Download" option on inbox page
    And User click on "Selected Resumes" option from "Download"
    Then User should be able to see download popup
    And User should be able to see "Attached Resume"
    And User should be able to see "Candidate Details (Excel)"
    And User should be able to see "Attached Document"
    When User Click on download button
    Then User should be able to Download application with ".xlsx"
    When User click on first candidate on inbox page
    And User click on "Download" option on inbox page
    And User click on "Index Range" option from "Download"
    Then User should be able to see download popup
    And User should be able to see "Attached Resume"
    And User should be able to see "Candidate Details (Excel)"
    And User should be able to see "Attached Document"
    When User enter range on download popup as "1" and "1"
    And User Click on download button
    Then User should be able to Download application with ".xlsx"
    When click on Select all candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then User should be able to see the Message option in the hover list
    When User click on Message option
    And I fill in the body field
    And I fill in the subject field
    And I click on "SEND MAIL"
    Then I should be able to see the success ribbon with a message as "Mail sent succesfully"
    When User reload the page.
    And click on Select all candidate checkbox
    And User hover on the Email option on top panel of the inbox
    Then I should be able to see the Send A Requirement option in the hover list
    When I click the send a requirement option in hover list
    Then I should be redirected to send a requirement lightbox
    When I select the first requirement in the requirement drop down
    And I type in the mail subject "testMailBodyText"
    And I type in the mail body "testMailBodyText"
    And I click on "Send" button on sendRequirement
    Then I should be able to see "Success! Mail has been sent." on application inbox
