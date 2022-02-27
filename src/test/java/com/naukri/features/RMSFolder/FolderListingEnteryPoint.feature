Feature: Folder Listing Entery Point

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify HM user can not see the folder GNB and the Folder option
    Given User logged in as <type> user into RMS application
    Then Verify that user is not able to see the Folder in GNB
    When User hit the Folder URL direct
    Then User should be able to display the permission error
    And Verify that folder option is not displaying in footer of the page

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify that user can not access the folder pages through Folder GNB option under manage jobs and responses
    Given User logged in as <type> user into RMS application
    When I navigate to naukri site
    And User click on jobs and responses GNB button
    And User click on Folder option
    Then Verify that user can see the permission error

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify that user can not access the folder pages through Folder GNB option under RMS/CSM
    Given User logged in as <type> user into RMS application
    When I navigate to naukri site
    And I click on RMS/CSM GNB option
    And User click on Folder option
    Then Verify that user can see the permission error

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify that user can not see the create folder lightbox and folder page while hiting the direct URL of naukri create folder
    Given User logged in as <type> user into RMS application
    When I navigate to naukri site
    And User direct hit the create folder URL/
    Then Verify that user can see the permission error

  #type==>> HM and Finance user
  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify that user is able to see the Folder option in application footer
    Given User logged in as <type> user into RMS application
    Then Verify that user is able to see the Folder option in footer of the application and it is functional

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify the folders pop-up
    Given User logged in as <type> user into RMS application
    Then Verify that folder pop-up is displaying
    When User click on anywhere on the screen other than pop-up
    Then Verify that folder pop-up is displaying
    When User click on "Okay, Got it" button
    Then Verify that Folder pop-up is not displaying
    When User navigate to other GNB page
    Then Verify that Folder pop-up is not displaying

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify that folder option in naukri GNB is navigating to Folder listing if no folder is available in my folder tab
    Given User logged in as <type> user into RMS application
    When I navigate to naukri site
    And I click on RMS/CSM GNB option
    Then User is able to see the "Folder" option
    When User click on "Folder" option
    Then Verify that user is able to navigate to "Shared Folders" tab

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify that my folder option under jobs and responses GNB is navigating to folder listing if no folders are available in my folder tab
    Given User logged in as <type> user into RMS application
    When I navigate to naukri site
    And User click on jobs and responses GNB button
    And User click on "My Folder" button
    Then Verify that user is able to navigate to "Shared Folders" tab

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify that folder option in naukri GNB is navigating to Folder listing if folders are available in my folder tab
    Given User logged in as <type> user into RMS application
    When I navigate to naukri site
    And I click on RMS/CSM GNB option
    Then User is able to see the "Folder" option
    When User click on "Folder" option
    Then Verify that user is able to navigate to "My Folders" tab

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify that my folder option under jobs and responses GNB is navigating to folder listing if folders are available in my folder tab
    Given User logged in as <type> user into RMS application
    When I navigate to naukri site
    And User click on jobs and responses GNB button
    And User click on "My Folder" button
    Then Verify that user is able to navigate to "My Folders" tab

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify the "Create Folder" link on MNR home page is displaying
    Given User logged in as <type> user into RMS application
    When I navigate to naukri site
    Then Verify that user is able to see the "Create Folder" link

  @Folder @RMS3-4328 @FolderListingEntryPoint @RMS @WIP
  Scenario: Verify the "Create Folder" link on MNR home page is functional
    Given User logged in as <type> user into RMS application
    When I navigate to naukri site
    Then Verify that user is able to see the "Create Folder" link
    When User click on "Create Folder" link
    Then Verify that user is navigating to create folder lightbox on RMS
    When User enter the details to add the folder
    Then Verify that a folder should be display

  @Folder @RMS3-4328 @FolderListingEntryPointq @RMS @WIP
  Scenario: Verify the tabs under Folder GNB
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User click on GNB option "Folders"
    Then Verify that user is able to see in GNB dropdown "My Folders" option
    And Verify that user is able to see in GNB dropdown "Shared Folders" option
    And Verify that user is able to see in GNB dropdown "Create Folder" option
#    And Verify that user is not able to see the count with the names of the tab  @Manual
