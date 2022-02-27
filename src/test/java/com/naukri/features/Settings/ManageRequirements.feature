Feature: Manage Requirements

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser1"

  @Settings
  Scenario: verify RMS user is able to see all labels & cancel button functionality
    When user click on "Manage Requirements" link
    Then verify that user is able to see the listed headings on page
      | Manage Requirements                                              |
      | Restrict Visibility of Requirements created from Resdex          |
      | Restrict Visibility of Requirements created through Resdex Mails |
      | Restrict Visibility of Requirements created from Email Import    |
    When user click on "Cancel" link
    Then user should be able to see the label "Configure Recruitment Management System" 

  #@MR
  #Scenario: user is able to set manage requirements
