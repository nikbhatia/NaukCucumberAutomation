Feature: Manage Documents

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser1"

  @Settings
  Scenario: verify RMS user is able to see all headings and labels
    When user click on "Manage Documents" link
    Then verify that user is able to see the listed headings on page
      | Allowed Documents in Profile |
      | Select Documents :           |
      | You have selected:           |
      | Clear All                    |
    When user click on "Save" value
    Then verify success message "Document Type Saved Successfully"

  @Settings
  Scenario: RMS user able to add new document from manage documents page
    When user click on "Manage Documents" link
    And user input new document name on manage document page
    And user click on add symbol on manage document page
    Then newly added document should be visible on the manage document page
    When user click on "Save" value
    Then verify success message "Document Type Saved Successfully"

  @Settings
  Scenario: RMS user is able to select all available documents on manage documents page
    When user click on "Manage Documents" link
    And user input new document name on manage document page
    And user click on add symbol on manage document page
    And user click on "Clear All " link
    When user select all available documents
    Then all selected documents should be visible on manage document page
    When user click on "Save" value
    Then verify success message "Document Type Saved Successfully"

  @Settings @Smoke
  Scenario: verify the all valdiation on Manage documents page
    When user click on "Manage Documents" link
    And user click on add symbol on manage document page
    Then verify user able to see error message "Please enter a valid document name"
    When user input new document name on manage document page
    And user click on add symbol on manage document page
    Then newly added document should be visible on the manage document page
    When user click on add symbol on manage document page
    Then verify user able to see error message "Document Type with this name already exists."
    When user click on "Save" value
    Then verify success message "Document Type Saved Successfully"
