Feature: Manage Approval processes

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser1"

  @Settings
  Scenario: verify RMS user is able to see all headings and labels on Manage Approval Process page
    When user click on "Manage Approval Processes" link
    Then verify that user is able to see the listed headings on page
      | Manage Approval Process |
      | Approval Process        |
      | Groups                  |
      | Applied On              |
      | Modified On             |
    And user click on "Add New" value
    Then verify that user is able to see the listed headings on page
      #| Name                                                                 |
      | Setup the approval process by creating stages and choosing approvers |
      | Assign to groups for Requisition Approval                            |
      | Assign to groups for Offer Approval                                  |
      | Prefill from existing approval process                               |
      #| Approval Stage                                                       |
      | Add Approvers                                                        |
      | At least one approver is required at any stage                       |
      #| Everyone's Approval Mandatory                                        |
      | ADD APPROVAL STAGE                                                   |

  @Settings
  Scenario: RMS user is able to create approval process from manage approval process page with mandatory Fields
    When user click on "Manage Approval Processes" link
    And user click on "Add New" value
    Then user should be able to see the label "Add Approval Process"
    When user fill approval process name
    And user fill mandatory fields for approval process
    And user click on "SAVE" button
    Then verify success message "The process was successfully added."
    And verify created approval process is visible

  @Settings
  Scenario: RMS user is able to create approval process from settings page
    When user click on "Add New Approval Process" link
    Then user should be able to see the label "Add Approval Process"
    When user fill approval process name
    And user fill mandatory fields for approval process
    And user click on "SAVE" button
    Then verify success message "The process was successfully added."
    And verify created approval process is visible

  @Settings
  Scenario: RMS user is able to create approval process with all details
    When user click on "Manage Approval Processes" link
    And user click on "Add New" value
    Then user should be able to see the label "Add Approval Process"
    When user fill approval process name
    And user fill all details of approval process
    And user click on "SAVE" button
    Then verify created approval process is visible

  @Settings @Smoke
  Scenario: RMS user is able to create approval process by prefilling from exisiting
    When user click on "Add New Approval Process" link
    Then user should be able to see the label "Add Approval Process"
    When user fill approval process name
    And user prefill from existing approval process
    And user click on "SAVE" button
    Then verify created approval process is visible

  @Settings
  Scenario: RMS user is able to use cancel button on add approval process page
    When user click on "Manage Approval Processes" link
    And user click on "Add New" value
    Then user should be able to see the label "Add Approval Process"
    When user click on backarrow
    Then verify that user is able to see the listed headings on page
      | Are you sure you want to navigate away from this page?                                                                                                                                         |
      | Any unsaved information on this page will be lost if you go back to the previous page. In case you have added/edited any information in the form, please Save the form before navigating away. |
    When user click on "Cancel" button
    And user fill approval process name
    When user click on "CANCEL" button
    Then verify that user is able to see the listed headings on page
      | Are you sure you want to navigate away from this page?                                                                                                                                         |
      | Any unsaved information on this page will be lost if you go back to the previous page. In case you have added/edited any information in the form, please Save the form before navigating away. |
    When user click on "Continue" button
    Then user should be able to see the label "Manage Approval Process"

  @Settings
  Scenario: RMS user is able to delete approval process
    When user click on "Add New Approval Process" link
    Then user should be able to see the label "Add Approval Process"
    When user fill approval process name
    And user fill mandatory fields for approval process
    And user click on "SAVE" button
    Then verify created approval process is visible
		When user click on "Delete" other than button,link
		Then verify that user is able to see the listed headings on page
		|Do you want to delete this approval process?|
		|This Approval template will be permanently deleted.|
		When user click on "DELETE" button
		Then verify success message "The selected Approval Process has been deleted." 
		
		@Settings
		Scenario: RMS user is able to search approval process on approval process page
		When user click on "Add New Approval Process" link
		Then user should be able to see the label "Add Approval Process"
    When user fill approval process name
    And user fill mandatory fields for approval process
    And user click on "SAVE" button
    Then verify success message "The process was successfully added." 
    When user enter approval process name in search bar and click on search
    Then verify created approval process is visible
     
    
    
    
    