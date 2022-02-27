Feature: Manage White Label

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser1"

  @Settings
  Scenario: verify RMS user is able to see all labels and headings
    When user click on "Manage White labelling Settings" link
    Then verify that user is able to see the listed headings on page
      | White Labeling      |
      | Choose Custom URL   |
      | Company Name:       |
      | About Company:      |
      | Choose Colour Theme |
      | Mail                |
    When user click on "Mail" link
    Then verify that user is able to see the listed headings on page
      | Choose Colour Theme for Mailer                   |
      | Do not include company name in the mail template |
    When user click on "Preview Mailer" link
    Then user should be able to see the label "Mail Preview - Status Change "  

  @Settings
  Scenario: verify user is able to fill details on White Labeling page
    When user click on "Manage White labelling Settings" link
    And user fill Company Name
    And user switch to frame about company
    And user fill About Company
    And user switch to default frame
    And user choose color theme & click on save
    Then verify success message "Settings saved successfully"
		