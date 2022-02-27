Feature: RMSVendorEmpanelment

  Background:
    Given User is on Setting Page
    When User redirects to "AddNewVendorPage" page

  @RMS   @RMSVendor @RMSVendorEmpanelment @RMSVendorMerge @E2E
  Scenario: Verify that user is able to Add a vendor from Add New Vendor page
    And User fills all the information of Vendor
    And User clicks on "SAVE & INVITE" button in conformation box
    Then User Verify that user is able to see Vendor name and following status
      | Invite Sent |


  @RMS   @RMSVendor @RMSVendorEmpanelment @RMSVendorMerge @E2E
  Scenario: Verify that user is able to use back button functionality on Add New Vendor Page
    And User clicks on back navigation arrow on Add New Vendor Page
    And  User clicks on "NO" button in conformation box
    Then User Verify user Clicking on No button it take user back to the current Add Vendor page
    When User clicks on back navigation arrow on Add New Vendor Page
    And  User clicks on "YES" button in conformation box
    Then User Verify that Clicking on yes button takes user back to the Manage Vendor Page without saving the vendor details

  @RMS   @RMSVendor @RMSVendorEmpanelment @RMSVendorMerge @E2E
  Scenario: Verify that user is able add point of contact details for New Vendor on Add New Vendor Page
    And User fills all the information of Vendor
    And User clicks on "Add Point of Contact"
    And User fills all the information of Add New Point of Contact
    And  User clicks on "ADD" button in conformation box
    Then User Verify Poc Added successfully

  @RMS   @RMSVendor @RMSVendorEmpanelment @RMSVendorMerge
  Scenario: Verify that user is able cancel point of contact details for New Vendor on Add New Vendor Page
    And User fills all the information of Vendor
    And User clicks on "Add Point of Contact"
    And User fills all the information of Add New Point of Contact
    And  User clicks on "CANCEL" button in conformation box
    Then User Verify that Clicking on CANCEL cancels the POC details addition and takes me back to the previous Vendor Details section

  @RMS   @RMSVendor @RMSVendorEmpanelment @RMSVendorMerge
  Scenario: Verify that user is able to add track contract details for New Vendor on Add New Vendor Page
    And User clicks on "Track Contract Details"
    And User click on "ADD BILLING RATE" button on the page
    And User clicks on "Flat Fee" button
    And Add all details in Add New Billing Rate
    And  User clicks on "ADD" button in conformation box
    Then User Verify that all billing information added successfully
#
  @RMS   @RMSVendor @RMSVendorEmpanelment @RMSVendorMerge
  Scenario: Verify that user is able to discard contract details for New Vendor on Add New Vendor Page
    And User clicks on "Track Contract Details"
    And User click on "ADD BILLING RATE" button on the page
    And Add all details in Add New Billing Rate
    And  User clicks on "CANCEL" button in conformation box
    Then User Verify that Clicking on Cancel discards the added details and takes me back to the previous page

  @RMS   @RMSVendor @RMSVendorEmpanelment @RMSVendorMerge @Smoke
  Scenario: Verify that user is able to add  flat fee in billing rate section for New Vendor on Add New Vendor Page
    And User clicks on "Track Contract Details"
    And User click on "ADD BILLING RATE" button on the page
    And  User clicks on "Flat Fee" button
    And User fills all the details in flat fee section
    And  User clicks on "ADD" button in conformation box
    Then User Verify that all billing information in flat fee section added successfully

  @RMS   @RMSVendor @RMSVendorEmpanelment @RMSVendorMerge
  Scenario: Verify that user is able to  discard flat fee in billing rate section for New Vendor on Add New Vendor Page
    And User clicks on "Track Contract Details"
    And User click on "ADD BILLING RATE" button on the page
    And User clicks on "Flat Fee" button
    And User fills all the details in flat fee section
    And User clicks on "CANCEL" button in conformation box
    Then User Verify that all billing information in flat fee section discarded successfully

  @RMS   @RMSVendor @RMSVendorEmpanelment @RMSVendorMerge
  Scenario: Verify that user is able Upload,delete and download the documents for New Vendor on Add New Vendor Page
    And User fills all the information of Vendor
    And User clicks on Upload Vendor Documents Tab
    And User clicks on Upload documents button
    Then User is successfully able to add the document
    When User clicks on "download" uploaded document button
    And User clicks on "delete" uploaded document button
    Then User Verify that user is able to delete the documents

  @RMS   @RMSVendor @RMSVendorEmpanelment @RMSVendorMerge @E2E
  Scenario: Verify that on Manage vendor page when clicked on Vendor Info user is able to see the view more link for contract details and  billing rate
    And User fills all the information of Vendor
    And User clicks on "Add Point of Contact"
    And User fills all the information of Add New Point of Contact
    And  User clicks on "ADD" button in conformation box
    And User clicks on "Add Point of Contact"
    And User fills all the information of Add New Point of Contact
    And  User clicks on "ADD" button in conformation box
    And User clicks on "Add Point of Contact"
    And User fills all the information of Add New Point of Contact
    And  User clicks on "ADD" button in conformation box
    And User clicks on "Add Point of Contact"
    And User fills all the information of Add New Point of Contact
    And  User clicks on "ADD" button in conformation box
    Then User Verify Poc Added successfully
    And User clicks on "SAVE & INVITE" button in conformation box
    Then User Verify that user can see the POC,billing,files added,and invite sent details in popup
    And User Verify user is able to see the view more link for contract details and Billing rate in popup

  @RMS @RMSVendor @RMSVendorEmpanelment @RMSVendorEmpanelmentManage @RMSVendorMerge
  Scenario: Verify that user is able to see error message if provided vendor name is duplicate via Add New Vendor
    And User redirects to "ManageVendorPage" page
    And User stores the name of Vendors listed on Manage Vendor Page
    And User redirects to "AddNewVendorPage" page
    And User fills the duplicate Vendor name with white spaces etc
    Then User Verify user should get error stating message under vendor name


  @RMS @RMSVendor @RMSVendorEmpanelment @RMSVendorEmpanelmentManage @RMSVendorMerge
  Scenario: Verify that user is able to error message if provided vendor name is duplicate
    And User redirects to "ManageVendorPage" page
    And User stores the name of Vendors listed on Manage Vendor Page
    And User clicks on Vendor tuple of existing Vendor
    And User clicks on "EDIT" button in conformation box
    And User Edits the Vendor name with already exists name along white spaces etc
    Then User Verify user should get error stating message under vendor name

  @RMS @RMSVendor @RMSVendorEmpanelment @RMSVendorEmpanelmentManage @RMSVendorMerge
  Scenario: Verify that user is able to see "Invite Accepted By" in pop up
    And User redirects to "ManageVendorPage" page
    And User search "ExternalVendorCHeck2" vendor on Manage Vendor page
    And User clicks on search icon
    And User clicks on "ExternalVendorCHeck2" tuple whose status is ActiveorExpired
    Then User Verify user is able to see "Invite accepted by" status in popup

  @RMS @RMSVendor @RMSVendorEmpanelment @RMSVendorEmpanelmentManage @RMSCHECK @RMSVendorMerge @E2E
  Scenario: Verify that user is able to restore the deleted vendor
    And User fills all the information of Vendor
    And User clicks on "SAVE & INVITE" button in conformation box
    When User deletes the vendor by clicking delete option appears when hover on vertical ellipsis
    And  User clicks on "YES" button in conformation box
    Then User Verify User is not able to see the deleted vendor on Manage Vendor page
    When User redirects to "AddNewVendorPage" page
    And  User provides duplicate vendor name
    Then User Verify on Edit page when  user provides the deleted vendor name user should get duplicate name error
    When User clicks on "Restore Vendor" link on Manage Vendor Page
    And  User clicks on "CONTINUE" button in conformation box
    And  User clicks on "SAVE" button in conformation box
    Then User Verify user is able to restore the deleted vendor on Edit page


  @RMS @RMSVendor @RMSVendorEmpanelment @RMSVendorEmpanelmentManage @RMSVendorMerge
  Scenario: Verify that user is not able to see the vendor of "Invite sent" status
    And User fills all the information of Vendor
    And User clicks on "SAVE & INVITE" button in conformation box
    And User redirects to "MultiuploadPageUrl" page
    And User clicks on requirement and selects requirement on Upload Multiple Cv page
    Then User Verify that user should not be able to see vendor in Invite Sent status



