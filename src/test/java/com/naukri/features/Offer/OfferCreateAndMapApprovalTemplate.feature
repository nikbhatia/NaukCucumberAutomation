@Offer @RMSOfferApproval @RMSOffer
Feature: Create and map approval

  Scenario Outline: verify RMS Enterprise user is able to create offer approval template from group
    Given I login into RMS as "<userType>"
     When User is on "settingsPage" page
    When user click on "Manage Groups " link
    And user click on "Add Group" link
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And user Select Recruiters & Hiring Managers and fill all other details
    And user click on "NEXT" button
    And user click on "NEXT" button
    Then user should be able to see the label "Select Offer Process"
    When click on Add New offer Template
    And Enter offer approval template name
    And Enter stage name "stage1"
    And Enter two approvers "test1@yopmail.com" and "test2@yopmail.com"
    Then verify "Everyone's Approval Mandatory" is displayed
    When Click on save template
    And click on selected tab
    Then verify approval process is displayed under selected tab

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  # Live bug expected is "test2@yopmail.com" but is coming "test2@Yopmail.com"
  Scenario Outline: verify aprovers can be added in two different stages in approval
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    When user click on "Manage Groups " link
    And user click on "Add Group" link
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And user Select Recruiters & Hiring Managers and fill all other details
    And user click on "NEXT" button
    And user click on "NEXT" button
    Then user should be able to see the label "Select Offer Process"
    When click on Add New offer Template
    And Enter offer approval template name
    And Enter stage name "stage1"
    And Enter two approvers "test1@yopmail.com" and "test2@yopmail.com"
    And click on add approval stage
    And Enter second stage name "stage2"
    And Enter one approver in stage2 "test3@yopmail.com"
    And Click on save template
    And click on selected tab
    And click on preview of template created on group lightbox
    Then approvers are displayed under approval template
      | stage1            |
      | test1@yopmail.com |
      | test2@yopmail.com |
      | stage2            |
      | test3@yopmail.com |

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @manageApprovalTab
  Scenario Outline: To verify offer approval tab is not visible to any other client except Enterprise
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    Then "Manage Approval Processes" tab should not be visible

    Examples: 
      | userType                |
      | ProConsultant.Superuser |
      | Company.Superuser       |

  @offerapprovalTabnotVisible
  Scenario Outline: To verify offer approval tab is not displayed for subrecruiter client with no permission
    Given I login into RMS as "<userType>"
    And I am on the Settings page of RMS
    When user click on "Manage Recruiters" link
    And I search subuser name "<subuserType>"
    And I open the manage permissions for subuser
    Then I should be able to see "Manage Approval Workflows " in manage permission light box
    When I turn the "Manage Approval Workflows " permission button to "on"
    And I logout of RMS
    And I login into RMS as "<subuserType>"
    And I am on the Settings page of RMS
    Then "Manage Approval Processes" section on settings page

    Examples: 
      | userType             | subuserType        |
      | Enterprise.Super_user | Enterprise.Sub_user |

	# Live bug expected is "test2@yopmail.com" but is coming "test2@Yopmail.com"
  @OfferprefillFRomExisting
  Scenario Outline: To verify functionality of Prefill from existing approval process
   Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    And I click "Manage Approval Processes" link on Settings page
    And click on add new approval template
    And Enter one approval template name
    And Enter stage name "stage1"
    And Enter two approvers "test1@yopmail.com" and "test2@yopmail.com"
    And Click on save template
    And click on add new approval template
    And select one template under prefill from existing approval process
    Then verify stage name "stage1" and its approvers "test1@yopmail.com" and "test2@yopmail.com" should be displayed

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @DeleteFromApprovalTemplate
  Scenario Outline: To verify user is able to delete approval template from approval listing page when not mapped with any group
   Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    And I click "Manage Approval Processes" link on Settings page
    And click on add new approval template
    And Enter one approval template name
    And Enter stage name "stage1"
    And Enter two approvers "test1@yopmail.com" and "test2@yopmail.com"
    And Click on save template
    And user "Delete" approval template
    Then approval template should not be displayed on approval listing page
    And "The selected Approval Process has been deleted." should be displayed
      Examples: 
      | userType                |
      | Enterprise.Super_user	  |
    
    @DeleteApprovalTemplateWithMappedWithAgroup
    Scenario Outline: To verify user is able search approval template and delete approval template when template is mapped with group
   Given I login into RMS as "<userType>"
     When User is on "settingsPage" page
    When user click on "Manage Groups " link
    And user click on "Add Group" link
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And user Select Recruiters & Hiring Managers and fill all other details
    And user click on "NEXT" button
    And user click on "NEXT" button
    Then user should be able to see the label "Select Offer Process"
    When click on Add New offer Template
    And Enter offer approval template name
    And Enter stage name "stage1"
    And Enter two approvers "test1@yopmail.com" and "test2@yopmail.com"
    And Click on save template
   	And user click on "SAVE" button
   	And I am on the Settings page of RMS
    And I click "Manage Approval Processes" link on Settings page
    And enter approval template name on search bar
    And user "Delete" approval template
    And I am on the Settings page of RMS
    And user click on "Manage Groups " link
    And user type group name in search bar
    And user click on "Edit" link
    And user click on "NEXT" button
    And user click on "NEXT" button
    And user click on "NEXT" button
    And click on selected tab
    Then verify "No Results found" should be displayed

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @Offer5678902
  Scenario Outline: To verify edit and preview functionality of approval templates from approval listing page
    Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    And I click "Manage Approval Processes" link on Settings page
    And click on add new approval template
    And Enter one approval template name
    And Enter stage name "stage1"
    And Enter one approver "test1@yopmail.com"
    And Click on save template
    And user clicks on "Edit" approval template
    And click on add approval stage
    And Enter second stage name "stage2"
    And Enter one approver in stage2 "test3@yopmail.com"
    And Click on save template
    And enter approval template name on search bar
		And user clicks on "Preview" to preview approval template 
		Then approval template preview should be displayed ie stage "stage1" and approver "test1@yopmail.com" , "stage2" and approver "test3@yopmail.com"
		
		  Examples: 
      | userType                |
      | Enterprise.Super_user	  |
      
      @OfferTestCOuntOfGroups
  Scenario Outline: To verify the count of groups on add approval template page 
  	Given I login into RMS as "<userType>"
    When User is on "settingsPage" page
    And user click on "Manage Groups " link
    And get total no of groups present in the system 
    And I am on the Settings page of RMS
    And I click "Manage Approval Processes" link on Settings page
    And click on add new approval template
    And click on Assign to groups for Offer Approval DD
    Then verify count of groups displayed under DD

    Examples: 
      | userType             |
      | Enterprise.Super_user |

  @OfferAPprvoalCOunt
  Scenario Outline: To verify the count of approval templates on offer approval process tab
 Given I login into RMS as "<userType>"
  When User is on "settingsPage" page
    And I click "Manage Approval Processes" link on Settings page
    And get total no of approval templates visible 
    And I am on the Settings page of RMS
    And user click on "Manage Groups " link
    And user click on "Add Group" link
    And user click on "NEXT" button
    And user click on "NEXT" button
  	Then verify count of approval templates visible 
  	  Examples: 
      | userType                |
      | Enterprise.Super_user	  |
  	
  	@OfferAndGroupNameDisplayedxsxas
  Scenario Outline: To verify group name and applied on offers is displayed 
     Given I login into RMS as "<userType>"
     When User is on "settingsPage" page
    When user click on "Manage Groups " link
    And user click on "Add Group" link
    And user fill all fields in Group Details
    And user click on "NEXT" button
    Then user should be able to see the label "Select Interviewer(s) "
    And user Select Recruiters & Hiring Managers and fill all other details
    And user click on "NEXT" button
    And user click on "NEXT" button
    When click on Add New offer Template
    And Enter offer approval template name
    And Enter stage name "stage1"
    And Enter two approvers "test1@yopmail.com" and "test2@yopmail.com"
    And Click on save template
   	And user click on "SAVE" button
   	And I am on the Settings page of RMS
    And I click "Manage Approval Processes" link on Settings page
    # And enter approval template name on search bar
    Then verify group name and under Applied on Offers should be displayed

    Examples: 
      | userType             |
      | Enterprise.Super_user |
