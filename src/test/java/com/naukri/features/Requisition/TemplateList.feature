Feature: Test Scenarios of Template listing Page

  Author: nikhil.bhatia@naukri.com

  @id:1   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify title of the page and search on template listing page
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    And Verify that title on template listing page is Manage Approval workflow.
    Then I click on search button by filling valid template on template listing page
    And Verify template with same text searched is displayed.

  @id:2   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify search when Template not found on template listing Page
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    When I click on search button with template that does not exist for the client
    Then I see Template not found with clear link
    Then I click on clear button
    And Verify that after clicking on clear button it redirects to template listing page.

  @id:3   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify highlighted text on search when you search Group on template listing page
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    Then I click on search button by filling valid Group on template listing page
    And verify that the text with the search keyword if exist in groups should be highlighted and listed on Page in tuples.

  @id:4   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify highlighted text on search when you search By template on template listing page
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    Then I search with text that exist.
    And verify that the text with the search keyword if exist in Template should be highlighted and listed on Page in tuples.

  @id:5   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify highlighted text and link on search template
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    When I search with text by typing first three words irrespective of template or group
    Then i see link to the templates and groups in the search bar
    Then i click on any of the results
    And Verify it shows the result with template that you clicked.

  @id:6   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify preview and delete template on template listing page
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    Then I click on preview in the first tuple.
    And Verify template preview is visible
    Then i see list of templates and on first tuple i click on delete button
    And Verify Template is deleted and not visible on search

  @id:7   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify template is created with add new button template listing page
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    Then I click on Add New Button
    Then Verify Template creation Lightbox opens up
    Then fill the required details like group name and stage name , approvers and click on save button
    And Verify that on template listing page ,Template is visible on top.

  @id:8   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify Template is created from Settings page and visible on template listing page
    Given I login into RMS as an "Enterprise" user
    Then I navigate to Account settings page.
    Then I click on a link to create Approval Template under Manage Approval Workflow.
    Then fill the required details like group name and stage name , approvers and click on save button
    And Verify that on template listing page ,Template is visible on top.

  @id:9   @RMS @RMSTemplateListing @RMSRequisition @Smoke
  Scenario: Verify Template is created from Settings page using prefill while creating a group
    Given I login into RMS as an "Enterprise" user
    Then I navigate to Account settings page.
    Then I click on Manage group button and then edit the group.
    Then I click on Requisition approval tab to map approval process
    Then I click on a link Add New to create Approval Template under Manage Approval Workflow.
    Then Verify Template creation Lightbox opens up
    Then I fill the Approval process name and prefill other details using existing template.
    And  Verify after clicking on save button that Approval process is created.
    And  Verify after clicking on save button that group is edited successfully

  @id:10   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify Template is  Edited from template listed page
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    Then I click on edit and change the approval name in first stage
    And  Verify that Approval Name changed is visible on top.

  @id:11   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify template is created with prefill functionality from template listing page
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    Then I click on Add New Button
    Then Verify Template creation Lightbox opens up
    Then I fill the Approval process name and prefill other details using existing template.
    And Verify that on template listing page ,Template is visible on top.

  @id:12   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify Template is created from Settings page without using prefill while creating a group
    Given I login into RMS as an "Enterprise" user
    Then I navigate to Account settings page.
    Then I click on Manage group button and then edit the group.
    Then I click on Requisition approval tab to map approval process
    Then I click on a link Add New to create Approval Template under Manage Approval Workflow.
    Then Verify Template creation Lightbox opens up
    Then fill the required details like approval name,stage name,approvers and click on save button
    And  Verify after clicking on save button that Approval process is created.
    And  Verify after clicking on save button that group is edited successfully

  @id:13   @RMS @RMSTemplateListing @RMSRequisition
  Scenario: Verify Pagination on template listing page
    Given I login into RMS as an "Enterprise" user
    Then I navigate to template listing page.
    And Verify that number we are selecting through pagination and the tuples as result we are getting are correct.