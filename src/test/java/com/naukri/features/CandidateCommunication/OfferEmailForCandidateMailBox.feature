Feature: To verify Validations on Candidates moved to Offer Stage

#  @Wip @Mailer
#  Background: Deleting mails from candidate personal mail id
#    Given I am on candidate personal inbox page
#    Then  I Delete all existing mails of candidate

    #   add usertype instead running for enterprise

  @CandidateCommunication @Mailer @Wip
  Scenario: To verify Offer Generation Email functionality for candidate Communication
    Given "Enterprise" user is on Settings Page with "Superuser"
    And User is on "settingsPage" page
    When user click on "Offer Generation Module On/Off " offer generation link
    When I turn the "offerGenerationModuleOnOff" offer generation permission button to "off"
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    #And User click on candidate and move to candidate page
    #And I move to particular candidate details page
    When I click on status change drop down
    And I click on "Offers & Joining change" on DD
    Then I should be directed to Offer Generation page
    When I fill in all the details for Offer Generation
    And I click Next Button on Offer Details
    And I attach Offer Letter on Attach Offer Letter page
    And User fill in the subject field as "Updated Subject"
    And I fill Offer Mail Body field
#    And I ADD Mail id's in notify other for recruiter mail as "nik@mailsac.com"
    Then I click Send Mail button on Attach Offer Letter
    Then I should see "Candidate's Reply Pending" status text on CV Details page
#    And I Comment on the candidate reply pending to start conversation with candidate
    Then User click on mailboxtab
    Then I apply filter "Offers sent" from "Mail Type" and "Mails Sent" from "All Mails" with attachment
    And Verify ThreadSubject is displayed as "Updated Subject"
#    Then Open Personal MailBox for candidate for comment mail as well as offer letter mail
#    And Verify Content and subject sent to the candidate from RMS.
#    Then Open Personal MailBox for other recruiter added in notify field
#    And Verify Content and subject sent to the recruiter from RMS.

#  Examples:
#    | offer         | userType     |
#    |  accepted     |Enterprise    |
#    |   rejected    |Enterprise    |
#    |  accepted     |Company       |
#    |   rejected    |Company       |
#    |  accepted     |ProConsultant |
#    |   rejected    |ProConsultant |
#
#
#  @wip
#  Scenario Outline: To verify Offer header after sending offer letter to candidate
#
#    Given I login into RMS as an "<userType>" user
#    When User is on "addSingleProfile" page
#    And I fill in all the details of the candidate
#    And I click on Save button
#    When I click on status change drop down
#    And I click on "Offers & Joining" on DD
#    Then I should be directed to Offer Generation page
#    When I fill in all the details for Offer Generation
#    And I click Next Button on Offer Details
#    And I attach Offer Letter on Attach Offer Letter page
#    And User fill in the subject field as "Updated Subject"
#    And I fill Offer Mail Body field
#    Then I click Send Mail button on Attach Offer Letter
#    Then Open Personal MailBox for candidate and check the offer letter
#    And Verify Content and subject sent to the candidate from RMS.
#    Then Candidate reply to Recruiter via message
#    Then I redirect to cv details page of candidate
#    And  From profile tab Recruiter reply to candidate via send a message
#    Then User click on mailboxtab
#    Then I apply filter "Offers sent" from "Mail Type" and "Mails Sent" from "All Mails" with attachment
#    And Verify ThreadSubject is displayed as "Updated Subject"
#    Then Verify conversation between recruiter and candidate is visible in mailbox tab
#
#    Examples:
#      | userType     |
#      | Enterprise   |
#      | Company      |
#      | ProConsultant|


#   add usertype instead running for enterprise
  @CandidateCommunication @Mailer @Wip
  Scenario: To Assessment test and Reminder email functionality for candidate communication
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    When I click on Requirement Name on candidate page
    And User clicks on Candidate Assessment Tab
    And User clicks on add candidate assessment button
    And select first test
    Then Verify that user is able to see the test name in headings on Selected Assessment Test
    And User attach a test on "Applied-Matching" stage when using selction stage DD to select stage
    And click on attach test
    And User close Requirement Detail page and switch to  candidate detail page
    And Move candidate to following stage
      | Applied |
    When click on folllowing tuple Link
      | Send Test |
    And I verify the mail count is changed
    Then User click on mailboxtab
    Then I apply filter "Assessments sent" from "Mail Type" and "Mails Sent" from "All Mails" without attachment
#    Then I Send Reminder to assessment and Verify if reminder is sent on mailbox tab
    And Verify ThreadSubject is displayed as "Online Assessment Test link"
    #Then Open Personal MailBox for candidate
#    And Verify Test and reminder Content and subject sent to the candidate from RMS.
