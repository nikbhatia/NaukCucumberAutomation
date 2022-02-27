Feature: Manage Requisition Template

  Background: 
    Given "Enterprise" user is on Settings Page with "Superuser1"

  @Settings @RMSRequisition
  Scenario: verify user is able to see all headings and use sorting on requisition template listing page
    When user click on "Manage Requisition Templates" link
    Then verify that user is able to see the listed headings on page
      | Manage Requisition Templates |
      | Template Name                |
      | Groups                       |
      | Created By                   |
      | Modified On                  |
    When user click on sorting option on template name
    Then verify user is able to see template name is sorted order

  @Settings @RMSRequisition
  Scenario: verify user is able to create requisition template by prefilling it
    When user click on "Manage Requisition Templates" link
    Then user should be able to see the label "Manage Requisition Templates"
    When user click on "Create Requisition Template" value
    Then user should be able to see the label "Create Requisition Template"
    When user create Requisition template by prefilling it
    And user click on "Save Template" value
    Then verify success message "Requisition Template is successfully created"
    When user click on list item "Delete" on requisition template listing page
    And user click on "Delete" button

  @Settings @RMSRequisition
  Scenario: verify user is able to create requisition template with mandatory fields
    When user click on "Manage Requisition Templates" link
    And user click on "Create Requisition Template" value
    Then user should be able to see the label "Create Requisition Template"
    When user fill mandatory fields for requisition template
    And user click on "Save Template" value
    Then verify created requisition template is visible to user
    When user click on list item "Delete" on requisition template listing page
    And user click on "Delete" button

  @Settings @RMSRequisition
  Scenario: verify user is able to create requisition template with full details
    When user click on "Manage Requisition Templates" link
    Then user should be able to see the label "Manage Requisition Templates"
    When user click on "Create Requisition Template" value
    Then user should be able to see the label "Create Requisition Template"
    When user fill all fields for creating requisition template
    And user click on "Save Template" value
    Then verify created requisition template is visible to user
    When user click on list item "Delete" on requisition template listing page
    And user click on "Delete" button

  @Settings @RMSRequisition @Wip
  Scenario: verify user is able to edit requisition template
    When user click on "Manage Requisition Templates" link
    And user click on "Create Requisition Template" value
    And user create Requisition template by prefilling it
    And user click on "Save Template" value
    Then verify created requisition template is visible to user
    When user click on list item "Edit" on requisition template listing page
    Then user should be able to see the label "Create Requisition Template"

  @Settings @RMSRequisition
  Scenario: verify user is able to delete requisition template
    When user click on "Manage Requisition Templates" link
    And user click on "Create Requisition Template" value
    And user create Requisition template by prefilling it
    And user click on "Save Template" value
    Then verify created requisition template is visible to user
    When user click on list item "Delete" on requisition template listing page
    And user click on "Delete" button
    Then verify success message "Requisition Template is successfully deleted"

  @Settings @RMSRequisition
  Scenario: verify user is able to preview already created requisition template
    When user click on "Manage Requisition Templates" link
    And user click on "Create Requisition Template" value
    And user create Requisition template by prefilling it
    And user click on "Save Template" value
    Then verify created requisition template is visible to user
    When user click on list item "Preview" on requisition template listing page
    Then verify that user is able to see the listed headings on page
      | Requisition Template Details |
      | Job Title                    |
      | yrs                          |
      | Key Skills                   |
    When user click on "Cancel" button
    And user click on list item "Delete" on requisition template listing page
    And user click on "Delete" button

  @Settings @RMSRequisition
  Scenario: verify user is able to search requisition template on requisition template listing page
    When user click on "Manage Requisition Templates" link
    And user click on "Create Requisition Template" value
    And user create Requisition template by prefilling it
    And user click on "Save Template" value
    Then verify created requisition template is visible to user
    When user entered the created requisition template on search bar
    Then verify created requisition template is visible to user
    When user click on list item "Delete" on requisition template listing page
    And user click on "Delete" button

  @Settings @RMSRequisition
  Scenario: verify success strip cancel button is working
    When user click on "Manage Requisition Templates" link
    Then user should be able to see the label "Manage Requisition Templates"
    When user click on "Create Requisition Template" value
    And user create Requisition template by prefilling it
    And user click on "Save Template" value
    Then verify success message "Requisition Template is successfully created"
    When user click on cross option on success strip
    Then verify success message "Requisition Template is successfully created" is not visible
    When user click on list item "Delete" on requisition template listing page
    And user click on "Delete" button

  @Settings @RMSRequisition
  Scenario: verify all validations is working properly
    When user click on "Manage Requisition Templates" link
    Then user should be able to see the label "Manage Requisition Templates"
    When user click on "Create Requisition Template" value
    And user click on "Save Template" value
    Then verify user able to see error message "Template name cannot be blank"
    When user enter same requisition template name which already exist
    And user click on "Save Template" value
    Then verify user able to see error message "Provide a unique template name"

  @Settings @RMSRequisition
  Scenario: create requisition template from all requisition page by clicking
    When user click on "Manage Requisition Templates" link
    And User is on "RMSRequisitionList" page
    Then user should be able to see the label "List of Requisitions"
    When user click on " Create Requisition Template" link
    And user create Requisition template by prefilling it
    And user click on "Save Template" value
    Then verify success message "Requisition Template is successfully created"
    When user click on list item "Delete" on requisition template listing page
    And user click on "Delete" button

  @Settings @RMSRequisition
  Scenario: user has only preview option on template which is created by other user
    When user click on "Manage Requisition Templates" link
    And user click on "Create Requisition Template" value
    Then user should be able to see the label "Create Requisition Template"
    When user create Requisition template by prefilling it
    And user click on "Save Template" value
    Then verify success message "Requisition Template is successfully created"
    When I logout of RMS
    And "Enterprise" user is on Settings Page with "Subuser1"
    And user click on "Manage Requisition Templates" link
    Then verify user has only preview option available on template which is created by superuser

  @Settings @RMSRequisition
  Scenario: RMS user is able to Raise requistion by prefilling from Requisition template
    When user click on "Manage Requisition Templates" link
    Then user should be able to see the label "Manage Requisition Templates"
    When user click on "Create Requisition Template" value
    Then user should be able to see the label "Create Requisition Template"
    When user fill all fields for creating requisition template
    And user click on "Save Template" value
    Then verify created requisition template is visible to user
    When I logout of RMS
    And "Enterprise" user is on Settings Page with "HiringManager1"
    And user click on "Requisitions" link
    And user click on "Raise a Requisition " value
    Then user should be able to see the label "Raise Hiring Requisition"
    When user fill requisition name,group,recruiter on raise requisition page
    And user prefill requisition from requisition template on raise requisition page
    And user click on "Add Requisition" value
    Then verify success message of requisition creation 
