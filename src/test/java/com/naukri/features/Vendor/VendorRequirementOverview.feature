Feature: VendorRequirementOverview

  Background:
    Given User login to the application "addSingleProfile" using "Superuser" of "Enterprise2" user
    And User is on "addSingleProfile" page
    And I fill in all the details of the candidate
    And I click on Save button
    And User reload the page.
    And User click on requirement on cv details page


  @RMS   @RMSVendor @RMSVendorRequirementOverview @New
  Scenario: Verify that user is able to see success strip when vendor is added to requirement ,when user clicks on cross icon on the strip and refreshes the page user should not see the success message strip
    And  User clicks on "Assign Vendor" Link on Requirement Overview Page
    And  User click on "Select Vendors" button on the page
    And  User adds below vendors on Assign Requirement to Vendor Page
      |ExternalVendorCHeck2 |vendoradded|Textile Company|New vendor for video|prashant.emlh@yopmail.com|
    And  User adds maxCv "20" for Vendor on Assign Requirement To Vendor
    And  User adds Questionnaire,instruction to Vendor on Assign Requirement To Vendor
    And  User clicks on "ASSIGN" button in conformation box
    Then Verify the success message is displayed on Requirement Overview page
    When User clicks on cross icon on the strip of success message
    Then Verify the success message should not displayed on Requirement Overview page after refresh


  @RMS   @RMSVendor @RMSVendorRequirementOverview @Smoke  @New
  Scenario: Verify that user is able to  click on edit assignement details,Unassign , ressign ,send reminder and can send message to vendor
    And  User clicks on "Assign Vendor" Link on Requirement Overview Page
    And  User click on "Select Vendors" button on the page
    And  User adds below vendors on Assign Requirement to Vendor Page
      |ExternalVendorCHeck2 |vendoradded|Textile Company|New vendor for video|prashant.emlh@yopmail.com|
    And  User adds maxCv "20" for Vendor on Assign Requirement To Vendor
    And  User adds Questionnaire,instruction to Vendor on Assign Requirement To Vendor
    And  User clicks on "ASSIGN" button in conformation box
    And  User reload the page.
    And  User Clicks on "Edit Assignment Details" for "prashant.emlh@y..." on Requirement Overview page
    And  User adds maxCv "40" for Vendor on Assign Requirement To Vendor
    And  User clicks on "UPDATE" button in conformation box
    And  User reload the page.
    And  User Clicks on "Unassign" for "prashant.emlh@y..." on Requirement Overview page
    And  User reload the page.
    Then Verify that option to Reassign the requirement is available for "prashant.emlh@y..." on Requirement Overview page
    When  User Clicks on "Reassign" for "prashant.emlh@y..." on Requirement Overview page
    And  User clicks on "RE-ASSIGN" button in conformation box
    And  User reload the page.
    And  User Clicks on "Send Reminder" for "prashant.emlh@y..." on Requirement Overview page
    And  User clicks on send button in send reminder confirmation box
    And  User reload the page.
    And  User Clicks on "Message" for "prashant.emlh@y..." on Requirement Overview page
    And  User clicks on "Send" button in conformation box
    Then Verify that message added to Overview Page

  @RMS   @RMSVendor @RMSVendorRequirementOverview @New
  Scenario: Verify that user should be able to see "Selected Vendor(no of vendors)" in closed drop down of Selected Vendor
    And  User clicks on "Assign Vendor" Link on Requirement Overview Page
    And  User click on "Select Vendors" button on the page
    And  User adds below vendors on Assign Requirement to Vendor Page
      |ExternalVendorCHeck2 |vendoradded|Textile Company|New vendor for video|vendornotificationslive2|HM Vendor|
    And  User adds maxCv "40" for Vendor on Assign Requirement To Vendor
    Then User Verify the count of vendors in closed DD should be same as of the chip count
    And  User verify the names of Vendor selected and displayed in chip list should be same
    And  User adds Questionnaire,instruction to Vendor on Assign Requirement To Vendor
    And  User clicks on "ASSIGN" button in conformation box


  @RMS   @RMSVendor @RMSVendorRequirementOverview @RMSSubmission @New
  Scenario: Verify that user should be able to see all assigned vendors on Requirement Overview page
    And  User clicks on "Assign Vendor" Link on Requirement Overview Page
    And  User click on "Select Vendors" button on the page
    And  User adds below vendors on Assign Requirement to Vendor Page
      |vendoradded|Textile Company|prashant.emlh@yopmail.com|
    And  User adds maxCv "40" for Vendor on Assign Requirement To Vendor
    And  User adds Questionnaire,instruction to Vendor on Assign Requirement To Vendor
    And  User clicks on "ASSIGN" button in conformation box
    And  User reload the page.
    Then User Verify below vendors are visible on Requirement Overview page
     |vendoradded|Textile Company|prashant.emlh@y...|



  @RMS   @RMSVendor @RMSVendorRequirementOverview @RMSSubmission @New
  Scenario: Verify that user should be able to add vendor from all requirements page and able to verify success message as well
    And  User is on "requirementInbox" page
    And  User clicks on assign vendor from more actions present below the requirement on all requirements page
    And  User click on "Select Vendors" button on the page
    And  User adds below vendors on Assign Requirement to Vendor Page
      |ExternalVendorCHeck2|vendoradded|prashant.emlh@yopmail.com|
    And  User adds maxCv "20" for Vendor on Assign Requirement To Vendor
    And  User adds Questionnaire,instruction to Vendor on Assign Requirement To Vendor
    And  User clicks on "ASSIGN" button in conformation box
    Then Verify the success message is displayed on Requirement Overview page
    When User clicks on cross icon on the strip of success message
    Then Verify the success message should not displayed on Requirement Overview page after refresh


  @RMS   @RMSVendor @RMSVendorRequirementOverview @RMSSubmission @New
  Scenario: Verify that user should be able to verify sources on all requirements page are same as added
    And  User is on "requirementInbox" page
    And  User clicks on assign vendor from more actions present below the requirement on all requirements page
    And  User click on "Select Vendors" button on the page
    And  User adds below vendors on Assign Requirement to Vendor Page
      |ExternalVendorCHeck2|vendoradded|prashant.emlh@yopmail.com|
    And  User adds maxCv "20" for Vendor on Assign Requirement To Vendor
    And  User adds Questionnaire,instruction to Vendor on Assign Requirement To Vendor
    And  User clicks on "ASSIGN" button in conformation box
    And  User reload the page.
    When User clicks on sources on all requirements page
    Then User Verify below vendors are visible on Requirement Overview page
      |ExternalVendorC...|vendoradded|prashant.emlh@y...|

  @RMS   @RMSVendor @RMSVendorRequirementOverview @RMSSubmission @New
  Scenario: Verify that user should be able to verify options available for vendor on all requirements page
    And  User is on "requirementInbox" page
    And  User clicks on assign vendor from more actions present below the requirement on all requirements page
    And  User click on "Select Vendors" button on the page
    And  User adds below vendors on Assign Requirement to Vendor Page
      |ExternalVendorCHeck2|vendoradded|
    And  User adds maxCv "20" for Vendor on Assign Requirement To Vendor
    And  User adds Questionnaire,instruction to Vendor on Assign Requirement To Vendor
    And  User clicks on "ASSIGN" button in conformation box
    When User clicks on sources on all requirements page
    Then Verify the new options for Vendor
      |Messages|Edit Assignment Details|Unassign|Send Reminder |

  @RMS   @RMSVendor @RMSVendorRequirementOverview @RMSSubmission @New
  Scenario: Verify that user should be able to perform actions on options available for vendor on all requirements page
    And  User is on "requirementInbox" page
    And  User clicks on assign vendor from more actions present below the requirement on all requirements page
    And  User click on "Select Vendors" button on the page
    And  User adds below vendors on Assign Requirement to Vendor Page
      |ExternalVendorCHeck2|vendoradded|
    And  User adds maxCv "20" for Vendor on Assign Requirement To Vendor
    And  User adds Questionnaire,instruction to Vendor on Assign Requirement To Vendor
    And  User clicks on "ASSIGN" button in conformation box
    When User clicks on sources on all requirements page
    Then  Verify the new options for Vendor
      |Messages|Edit Assignment Details|Unassign|Send Reminder |
    And  User Clicks on "Message" for "ExternalVendorC..." on Requirement Overview page
    And  User clicks on "Send" button in conformation box
    Then Verify that message added to Overview Page
    And  User Clicks on "Edit Assignment Details" for "vendoradded" on Requirement Overview page
    And  User adds maxCv "40" for Vendor on Assign Requirement To Vendor
    And  User clicks on "UPDATE" button in conformation box
    When User clicks on sources on all requirements page
    And  User Clicks on "Unassign" for "vendoradded" on Requirement Overview page
    When User clicks on sources on all requirements page
    Then Verify that option to Reassign the requirement is available for "vendoradded" on Requirement Overview page
    When  User Clicks on "Reassign" for "vendoradded" on Requirement Overview page
    And  User clicks on "RE-ASSIGN" button in conformation box

