@RMS @ReqID
Feature: To verify requirement ID and requisition ID settings

  @id:1 @Settings @ReqID @RMSRequirements @RMSRequirementReport
  Scenario: To verify manage requirement id and requisition id option on settings page
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    Then User should see "Manage Requirement id & Requisition id" on settings page

  @id:2 @Settings @ReqID2 @RMSRequirements @RMSRequirementReport
  Scenario: To verify manage requirement id and requisition id manage page will be opened and it's headings
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When User click on "Manage Requirement id & Requisition id" link
    Then User should be able to see "Manage Requirement id & Requisition id" heading of the page
    And User should be able to see "Setup your organization’s requirement id and requisition id series to organize work better" sub-heading of the page

  @id:3 @Settings @ReqID3 @RMSRequirements @RMSRequirementReport
  Scenario: To verify 3 components of ID will be dispalyed on manage ID settings page
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When User click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    Then User should be able to see all components on Manage Requirement ID page
      | Text Component    |
      | Year Component    |
      | Numeric Component |

  @id:4  @Settings @ReqID4 @RMSRequirements @Smoke @RMSRequirementReport
  Scenario: To verify Text component dropdown and it's options
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When User click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    When User click on the "Text Component" dropdown on Req ID page
    Then User should be able to see all options for Component dropdown
      | Company Initials |
      | Group Initials   |
      | Custom Text      |
      | Do Not Use       |

  @id:5 @manual
  Scenario: To verify when to choose Company initials from Text component dropdown
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User click on the "Text Component" dropdown on Req ID page
    And I select Company initials from dropdown
    Then I should be able to create all Requirement and Requisition with the same initials.

  @id:6 @manual
  Scenario: To verify initials creations logic  when to choose Company initials from Text component dropdown If requisition do not exists for a company in the past
    Given "Enterprise" user is on Settings Page with "Superuser"
    And Company has name with 3 words or more than that
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User click on the "Text Component" dropdown on Req ID page
    And I select Company initials from dropdown
    Then Initials should be 3 character long
    And Initials 3 character should be first character of first 3 words of company name.

  @id:7 @manual
  Scenario: To verify initials creations logic  when to choose Company initials from Text component dropdown If requisition do not exists for a company in the past
    Given "Enterprise" user is on Settings Page with "Superuser"
    And Company has name less than 2 words
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User click on the "Text Component" dropdown on Req ID page
    And I select Company initials from dropdown
    Then Initials should be 3 character long
    And Initials 3 character should be first 3 characters of company name.

  @id:8  @Settings @ReqID5 @RMSRequirements @RMSRequirementReport
  Scenario: To verify initials creations logic  when to choose Company initials from Text component dropdown If requisition exists for a company in the past
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage White labelling Settings" link
    And User enters "Naukri RMS Company Test" as Company Name
    And User clicks Save button on White Label Settings
    When User is on "settingsPage" page
    When User click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Company Initials" from dropdown on Req ID Settings
    Then User should see "NRCT" in Sample ID for "Text Component"

  @id:9  @Settings @ReqID6 @RMSRequirements @RMSRequirementReport
  Scenario: To verify initials creations logic  when to choose Company initials from Text component dropdown If requisition exists for a company in the past
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage White labelling Settings" link
    And User enters "Naukri RMS" as Company Name
    And User clicks Save button on White Label Settings
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Company Initials" from dropdown on Req ID Settings
    Then User should see "nauk" in Sample ID for "Text Component"

  @id:5  @Settings @ReqID7 @RMSRequirements @RMSRequirementReport
  Scenario: To verify Review group name initials link will be dispalyed when Group initials is selected
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Group Initials" from dropdown on Req ID Settings
    Then User should be able to see "Review group name initials" link on Requirement ID Settings page

  @id:10 @manual
  Scenario: To verify initials creations logic  when to choose Group initials from Text component dropdown
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User click on the "Text Component" dropdown on Req ID page
    And I select Group initials from dropdown
    And I click on Review group name initials link
    Then I should be able to see Edit Group initials pop-up
    And Initials should eb created with  first 3 character of group

  @id:11  @Settings @ReqID8 @RMSRequirements @RMSRequirementReport
  Scenario: To verify user is able to edit Group initials
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Group Initials" from dropdown on Req ID Settings
    And User click on Review group name initials link
    When User change Group Initials of first group on Edit Group initials pop-up
    And User clicks "Save group initials" button
    Then User should be able to save the group initials

  @id:12 @manual
  Scenario: To verify Group initials will be different for different groups and created requirement under group
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User click on the "Text Component" dropdown on Req ID page
    And I select Group initials from dropdown
    And I click on Review group name initials link
    And I change two group initials on Edit Group initials pop-up
    And I click on Save group initials button
    And I created two different requirement with those groups
    Then I should be able to see different initials for both the requirement w.r.t those groups

  @id:13 @manual
  Scenario: To verify a default initials value should be dispalyed if requirement is not attached to a group
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User click on the "Text Component" dropdown on Req ID page
    And I select Custom text from dropdown
    And I set a custom text initials
    And I created a requirement without group
    Then I should be able to see custom text initials for the requirement

  @id:14 @manual
  Scenario: To verify Preview group initials pop-up will be dispalyed when user try to set series without setting default or with duplicate initial for groups
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User click on the "Text Component" dropdown on Req ID page
    And I select Group initials from dropdown
    Then I should be able to see Review Group initials pop-up if user is set series without setting default or with duplicate initial for groups

  @id:15 @manual
  Scenario: To verify sample ID and it's text
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User click on the "Text Component" dropdown on Req ID page
    And I select Group initials from dropdown
    And I click on Review group name initials link
    And I change two group initials on Edit Group initials pop-up
    And I click on Save group initials button
    Then I should be able to see sample id with  first 3 characters of a group name(first group if sorted alphabetically)
    And I should be able to see sample text Requirement id for -group name- group for requirement
    And I should be able to see sample text Requisition id for -group name- group for Requisition

  @id:16  @Settings @ReqID9 @RMSRequirements @RMSRequirementReport
  Scenario: To verify a custom text textfield and it's validation message
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    Then User should be able to see text field in "Text Component" on Requirement ID page
    When User enters 0 "string" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    Then User should see validation message "Please enter text in custom field" for the text field

  @id:17  @Settings @ReqID10 @RMSRequirements @RMSRequirementReport
  Scenario: To verify a custom text type or character limit
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 1 "string" character in Text field for "Text Component" in Req ID page
    Then User should see validation message "Minimum 2 characters needed" for the text field
    When User enters 6 "string" character in Text field for "Text Component" in Req ID page
    Then User should see validation message "Maximum 5 characters allowed" for the text field

  @id:18  @Settings @ReqID11 @RMSRequirements @RMSRequirementReport
  Scenario: To verify sample id for custom text
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 3 "string" character in Text field for "Text Component" in Req ID page
    Then User should be able to see sample id contains characters entered in "Text Component" Text field

  @id:19 @manual
  Scenario: To verify custom id is for same for all created requisition in the company
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User click on the "Text Component" dropdown on Req ID page
    And I select Custom text from dropdown
    And I enter any character-number combination in textfield
    And I set the custom text
    And I create a requisition
    Then I should be able to see the created custom text for the same.

  @id:20 @Settings @ReqID12 @RMSRequirements @RMSRequirementReport
  Scenario: To verify sample id for Do not use option
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Do Not Use" from dropdown on Req ID Settings
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    Then User should not be able to see "Text Component" in Sample ID

  @id:21 @Settings @ReqID13 @RMSRequirements @RMSRequirementReport
  Scenario: To verify Year component dropdown and it's options
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    When User click on the "Year Component" dropdown on Req ID page
    Then User should be able to see all options for Component dropdown
      | Calendar Year  |
      | Financial Year |
      | Do Not Use     |

  @id:22 @Settings @ReqID14 @RMSRequirements @RMSRequirementReport
  Scenario: To verify when user choose Calendar year option in Year component dropdown
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    When User click on the "Text Component" dropdown on Req ID page
    And User select "Company Initials" from dropdown on Req ID Settings
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    Then User should see checkbox with text on Req Id page
      | Reset numeric counter to               |
      | at beginning of every new year (1-Jan) |
    Then User should see "Calendar Year" in Sample ID for "Year Component"

  @id:23 @Settings @ReqID15 @RMSRequirements @RMSRequirementReport
  Scenario: To verify when user choose Financial year option in Year component dropdown
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    When User click on the "Text Component" dropdown on Req ID page
    And User select "Company Initials" from dropdown on Req ID Settings
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Financial Year" from dropdown on Req ID Settings
    Then User should see checkbox with text on Req Id page
      | Reset numeric counter to               |
      | at beginning of every new year (1-Apr) |
    Then User should see "Financial Year" in Sample ID for "Year Component"

  @id:24 @Settings @ReqID16 @RMSRequirements @RMSRequirementReport
  Scenario: To verify when user choose Do not use option in Year component dropdown
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Company Initials" from dropdown on Req ID Settings
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Do Not Use" from dropdown on Req ID Settings
    Then User should not be able to see "Year Component" in Sample ID

  @id:25 @manual
  Scenario: To verify when Reset numeric count is dispalyed on new year
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    Then I should be able to see Year component as a dropdown
    When I click on the Year component dropdown
    And I choose Calendar Year option
    Then I should be able to see Reset numeric count checkbox on 31-Dec 12 AM
    And checkbox Reset numeric count by default selected
    When I choose Financial Year option
    Then I should be able to see Reset numeric count checkbox on 31-Mar 12 AM
    And checkbox Reset numeric count by default selected

  @id:26 @Settings @ReqID17 @RMSRequirements @RMSRequirementReport
  Scenario: To verify Numeric component dropdown
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    When User click on the "Numeric Component" dropdown on Req ID page
    Then User should be able to see all options for Component dropdown
      | Start From 001 |
      | Custom Number  |

  @id:27 @Settings @ReqID18 @RMSRequirements @RMSRequirementReport
  Scenario: To verify initials when Start from 001 is selected from Numeric component dropdown
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Company Initials" from dropdown on Req ID Settings
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Start From 001" from dropdown on Req ID Settings
    Then User should see "Start From 001" in Sample ID for "Numeric Component"

  @id:28 @Settings @ReqID19 @flakiness @RMSRequirements @RMSRequirementReport
  Scenario: To verify initials when Custom number is selected from Numeric component dropdown and validation message
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    Then User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 7 "number" character in Text field for "Numeric Component" in Req ID page
    Then User should see validation message "Maximum value can be 999999" for the text field
    When User enters 0 "number" character in Text field for "Numeric Component" in Req ID page
    Then User should see validation message "Minimum value can be 001" for the text field

  @id:29 @Settings @ReqID20 @RMSRequirements @RMSRequirementReport
  Scenario: To verify Numeric component functionality
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Company Initials" from dropdown on Req ID Settings
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    Then User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    Then User should see "Custom Number" in Sample ID for "Numeric Component"

  @id:30 @Settings @ReqID21 @RMSRequirements @RMSRequirementReport
  Scenario: To verify by default initial for Requirement Sample ID
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage White labelling Settings" link
    And User enters "Naukri RMS" as Company Name
    And User clicks Save button on White Label Settings
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Company Initials" from dropdown on Req ID Settings
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    Then User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    Then User should see values entered in the components in Sample Requirement ID
      | nauk |
      | y    |

  @id:31 @RMSRequisition @Settings @ReqID22 @RMSRequirements @RMSRequirementReport
  Scenario: To verify by default initial for Requisition Sample ID
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage White labelling Settings" link
    And User enters "Naukri RMS" as Company Name
    And User clicks Save button on White Label Settings
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Company Initials" from dropdown on Req ID Settings
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    Then User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    Then User should see values entered in the components in Sample Requisition ID
      | nauk |
      | y    |

  @id:32 @Settings @ReqID23 @RMSRequirements @RMSRequirementReport
  Scenario: To verify buttons at the bottom of the page
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    Then User should see buttons on Requirement ID page
      | Save for later |
      | Set ID series  |
      | Cancel         |

  @id:33 @Settings @ReqID24 @RMSRequirements @RMSRequirementReport
  Scenario: To verify configuration will be saved when user click on Save for Later button
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage White labelling Settings" link
    And User enters "Naukri RMS" as Company Name
    And User clicks Save button on White Label Settings
    When User is on "settingsPage" page
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Company Initials" from dropdown on Req ID Settings
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Save for later" button
    When user click on " Continue" link
    Then User should see same Sample Requirement ID and Requisition ID

  @id:34 @Settings @ReqID25 @RMSRequirements @RMSRequirementReport
  Scenario: To verify configuration will be set when user click on Set ID Series button
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
    Then User should see "Requirement/Requisition ID series set" message in snackbar on Settings page

  @id:35 @Settings @ReqID26 @RMSRequirements @RMSRequirementReport
  Scenario: To verify user will redirect on the starting page when user click on Cancel button
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on "Cancel" button
    Then User sees cancel confirmation box
    And User click on "Continue" button
    Then User should be directed to "settingsPage"

  @id:36 @manual
  Scenario: To verify Generate ids for past requirements will not available for Enterprise users
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    Then User should not see "" on Requirement Id page

  @id:37 @manual
  Scenario: To verify Generate ids for past requirements will not be availble for Consultant users
    Given I am login into application with Consultant user.
    When User is on "settingsPage" page
    When I click on manage requirement id and requisition id option on the page
    Then I should be able to see Generate ids for past requirements checkbox
    And Creation logic of past requirement should be same as mentioned during configurations

  @id:38 @manual
  Scenario: To verify requirement id is generated from all the sources with configuration
    Given "Enterprise" user is on Settings Page with "Superuser"
    When I create requirement from multiple sources
    Then I should be able to see created requirement id are same as configured

  @id:39 @Settings @ReqID27 @RMSRequirements @RMSRequirementReport
  Scenario: To verify user will be select both the components and its validation message
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Do Not Use" from dropdown on Req ID Settings
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Do Not Use" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And User click on "Set ID series" button
    Then User should see "Mandatory to use one of text component or year component" msg on Requirement Id page

  @id:40 @manual
  Scenario: To verify requirement id will not be chnaged once created
    Given "Enterprise" user is on Settings Page with "Superuser"
    When I create requirement without group
    Then I should be able to see created id with default initials
    When I add group in the recently created requirement
    Then Created ID should not be chnaged

  @id:41 @manual
  Scenario: To verify correct requirement id is generated as per set series(company initials)
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When I click on manage requirement id and requisition id option on the page
    And set a series with company initials
    And I create requirement
    Then I should be able to see the generated requirement id as per series
    And I should be able to see generated requirement id is incremented by 1

  @id:42 @manual
  Scenario: To verify correct requirement id is generated as per set series(Group initials)
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When I click on manage requirement id and requisition id option on the page
    And set a series with company initials
    And I create requirement
    Then I should be able to see the generated requirement id as per series w.r.t group
    When If first and second component matched
    Then I should be able to see generated requirement id is incremented by 1 with those initials

  @id:43 @manual
  Scenario: To verify requirement id will not be case sensitive
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When I click on manage requirement id and requisition id option on the page
    And set a series with initials
    And I create requirement
    And try to open created requirement with both lower or upper case requirement id
    Then I should be able to see the requirement overview page with both lower or upper case requirement id

  @id:44 @Settings @ReqID28 @RMSRequirements @RMSRequirementReport 
  Scenario: To verify review group initials pop-up is displaying if user try to set series with duplicate or without group initials
    Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Group Initials" from dropdown on Req ID Settings
    And User click on Review group name initials link
    And User makes the Group Initials of first two groups same
    And User clicks "Save group initials" button
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Do Not Use" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And User click on "Set ID series" button
    Then User should see "Edit group initials" lightbox on Req Id page

  @id:45 @Settings @ReqID29 @RMSRequirements @RMSRequirementReport
  Scenario: To verify review group initials pop-up is displaying if user try to set series without default initial
    Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Group Initials" from dropdown on Req ID Settings
    And User click on Review group name initials link
    And User clears Default Group Intials
    And User clicks "Save group initials" button
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Do Not Use" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And User click on "Set ID series" button
    Then User should see "Edit group initials" lightbox on Req Id page
    And User sets Default Group Initials
    And User clicks "Save group initials" button

  @id:46 @Settings @ReqID30 @RMSRequirements @RMSRequirementReport
  Scenario: To verify default initials will be unique as compare to groups
    Given User login to the application "settingsPage" using "Superuser1" of "Enterprise" user
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Group Initials" from dropdown on Req ID Settings
    And User click on Review group name initials link
    And User sets Default Group Initials
    When User sets same Group Initials as Default Group Initials for a group
    Then User should see "Group initials need to be unique" message on Group Initials lightbox

  @id:47 @manual
  Scenario: To verify Custom-group initials will be any combination of alphabets or numbers
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When I click on manage requirement id and requisition id option on the page
    And I click on the Text component dropdown
    And I select Group-Custom initials from dropdown
    And enter Special character in initial textbox
    Then I should be able to see validation message No special characters allowed
    And I should be able to start initial with number
    And Spaces should be trimed if any space entered while entering initials

  @id:48 @functionalityChanged
  Scenario: To verify by default values on manage requirement id and requisition id page
    Given "Enterprise" user is on Settings Page with "Superuser"
    When User is on "settingsPage" page
    When User click on manage requirement id and requisition id option on the page
    Then I should be able to see Company initial in Text component
    And I should be able to see calendar year selected in Year component
    And I should be able to see Start from 001’ selected in numeric dropdown
    And I should be able to see Reset number counter at beginning of new year checkbox selected by default
    And I should be able to see Generate past ids checkbox selected by default (Only Consultant account)

  @id:49 @manual
  Scenario: To verify when user downgrade-upgrade the subscription

  @id:50 @manual
  Scenario: To verify if user has multiple subscriptions

  @id:51 @RMSRequisition @Settings @ReqID31 @RMSRequirements @RMSRequirementReport
  Scenario: To verify the format of created requisition ID
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
    And I logout of RMS
    Given "Enterprise" user is on Settings Page with "HiringManager1"
    And User is on "RMSRaiseRequisition" page
    When User creates requisition with no approval process and first group in DD
    Then Verify User see same Requisition Id as set in Settings in Success Message on Requisition Listing

  @id:52 @RMSRequirements @Settings @ReqID32 @RMSRequisition @RMSRequirementReport @reportMR
  Scenario: To verify the same requirement id is generated same as requisition
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
    And I logout of RMS
    Given "Enterprise" user is on Settings Page with "HiringManager1"
    And User is on "RMSRaiseRequisition" page
    When User creates requisition with no approval process and first group in DD
    Then Verify User see same Requisition Id as set in Settings in Success Message on Requisition Listing
    And I logout of RMS
    And "Enterprise" user is on Settings Page with "Superuser"
    And User is on "RMSRequisitionList" page
    And I go to "Requisitions Ready for Creation" section
    When User creates requirement for raised requisition using Requisition ID
    Then Verify User see same Requirement ID as set in Settings on "Requisition Id"

  @id:53 @RMSRequirements @Settings @ReqID33 @RMSRequisition @RMSRequirementReport
  Scenario: To verify the same requirement id is generated as set in settings
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
     When User select a "Add A New Requirement" from "Requirements" option
    And User fill in the requirement title
    And User click on "Employment Type" field
    And User select an option "Full Time, Freelance/Homebased" from list
    And User fill in the job title
    And User fill in the Job Description
    And User fill in the Candidate Description
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User fill in the more salary details for "JP migrated" user
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    Then Verify User see same Requirement ID as set in Settings on "Requirement Creation"
    
    @id:54 @RMSRequirements @Settings @ReqID34 @RMSRequirementReport
  Scenario: To verify the same requirement id  as set in settings on CV details and SRP page
    Given "Enterprise" user is on Settings Page with "Superuser"
    When user click on "Manage Requirement id & Requisition id" link
    And User clicks "Reset ID series" button
    And User click on the "Text Component" dropdown on Req ID page
    And User select "Custom Text" from dropdown on Req ID Settings
    When User enters 5 "Alphanumeric" character in Text field for "Text Component" in Req ID page
    When User click on the "Year Component" dropdown on Req ID page
    And User select "Calendar Year" from dropdown on Req ID Settings
    And User click on the "Numeric Component" dropdown on Req ID page
    When User select "Custom Number" from dropdown on Req ID Settings
    And User should be able to see text field in "Numeric Component" on Requirement ID page
    When User enters 5 "number" character in Text field for "Numeric Component" in Req ID page
    And save Sample Requirement ID and Requisition ID
    And User click on "Set ID series" button
    When User select a "Add a Single Profile" from "Profiles" option
    And I enter the "" characters in the candidate name
    And I fill in the email of the candidate
    And I fill in the contact of the candidate
    And User clicks on Add New
    Then User should be able to see the "Add New Requirement- Provide details for new Requirement. You can change them later." for add requirement widget
    When User fills in the requirement title for add a single profile
    And User fills in the reference code for add a single profile
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User select the currency of CTC as "INR"
    And User fill in the "minCTC" as "5,00,000"
    And User fill in the "maxCTC" as "7,00,000"
    And User selects "Visible to All in Group" as the visibility mode of requirement
    And I click on Add Candidate button
    Then I should be redirected to the CV details page
    And I should be able to see "The profile has been successfully created." on CV details page
    Then Verify User see same Requirement ID as set in Settings on "CV Details"
    When User select a "All Profiles (Including Uploads)" from "Profiles" option
    And User search for candidate added using email ID
    Then Verify User see same Requirement ID as set in Settings on "SRP page"
