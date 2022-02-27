Feature: Folder Creation Page

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify the content on create folder light box is correct and be default "Only me" is set for visibility
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "Create Folder" under "Folders"
    Then Verify the URL of the "createFolder" page is correct
    And Verify that create folder lightbox is displaying
    And Verify the heading of the create folder light box
    And Verify the folder name title on create folder light box
    And Verify the place holder value of folder name input box on create folder light box
    And Verify the share folder with title is displaying on create folder light box
    And Verify that folder visibility is "Only me"
    When User click on dropdown of share folder with on create folder light box
    Then Verify that share folder dropdown list is displayig
    And Verify that the value "Only me" is displaying in the list
    And Verify that the value "Selected Recruiters" is displaying in the list
    And Verify that the value "Everyone in the company" is displaying in the list
    When User click on dropdown of share folder with on create folder light box
    #    Then Verify that share folder with dropdown list is not displaying  ###############Bug(Dropdown is not closing while clicking on dropdown button)
    And Verify that create folder button is displaying and disabled
    And Verify that cancel button on create folder light box is displaying
    When User enter the name of folder as "Folder Example" in the text field
    Then Verify that create folder button is displaying and not disabled
    When User click on cancel button of create folder light box
    Then Verify that create folder light box is not displaying

    Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify the cross button fuctionality of create folder light box
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "Create Folder" under "Folders"
    And User click on cross icon of the light box
    Then Verify that create folder light box is not displaying

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify the validations for Folder Name
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "Create Folder" under "Folders"
    And User enter the name of folder as "<></>" in the text field
    Then Verify that error message on create folder light box as "Folder name should begin with a letter (A-Z), number (0-9) or dot (.)." is displaying
    And User enter the name of folder as " " in the text field
    Then Verify that error message on create folder light box as "Folder name can't be blank." is displaying
    And User enter the name of folder as "abcd<input>efgh" in the text field
    #    Then Verify that error message on create folder light box as "Folder Name can not include HTML tags." is displaying ####Bug
    When User enter the name of folder as "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" in the text field
    Then Verify that error message on create folder light box as "Folder name can’t be more than 200 characters." is displaying

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify that user is able to add the folder name with 200 character
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "Create Folder" under "Folders"
    When User enter the name of folder as "EBAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" in the text field
    And User click on create folder button on light box
    Then Verify that user is able to see the folder name on folder listing page as "EBAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
    And Verify that user is able to see create folder date on folder listing page for "EBAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
    And Verify that user is able to see the shared with category as "Only me" for folder "EBAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
    And Verify that user is able to see the count as "0" of candidate for folder "EBAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
    And Verify that user is able to see the candidate text for folder "EBAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreationq @RMS
  Scenario Outline: User delete the folder created
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    And User click on three dots for a folder "EBAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
    And User select the option "Delete Folder" from the dropdown
    And User click on confirm button to delete folder
    Then Verify that user is not able to see the folder "EBAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify the folder name start with numbers
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "Create Folder" under "Folders"
    When User enter the name of folder as "33Folder name example" in the text field
    And User click on create folder button on light box
    Then Verify that user is able to see the folder name on folder listing page as "33Folder name example"
    And Verify that user is able to see the success message of folder "33Folder name example" creation
    And Verify that user is able to see create folder date on folder listing page for "33Folder name example"
    And Verify that user is able to see the shared with category as "Only me" for folder "33Folder name example"
    And Verify that user is able to see the count as "0" of candidate for folder "33Folder name example"
    And Verify that user is able to see the candidate text for folder "33Folder name example"

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: User delete the folder created
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    And User click on three dots for a folder "123Folder name example"
    And User select the option "Delete Folder" from the dropdown
    And User click on confirm button to delete folder
    Then Verify that user is not able to see the folder "123Folder name example"

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify that folder name start with dot(.)
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "Create Folder" under "Folders"
    When User enter the name of folder as ".123Folder name example" in the text field
    And User click on create folder button on light box
    Then Verify that user is able to see the folder name on folder listing page as ".123Folder name example"
    And Verify that user is able to see the success message of folder ".123Folder name example" creation
    And Verify that user is able to see create folder date on folder listing page for ".123Folder name example"
    And Verify that user is able to see the shared with category as "Only me" for folder ".123Folder name example"
    And Verify that user is able to see the count as "0" of candidate for folder ".123Folder name example"
    And Verify that user is able to see the candidate text for folder ".123Folder name example"

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: User delete the folder created
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    And User click on three dots for a folder ".123Folder name example"
    And User select the option "Delete Folder" from the dropdown
    And User click on confirm button to delete folder
    Then Verify that user is not able to see the folder ".123Folder name example"

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @FolderManual @RMS3-4248 @ManualTes
  Scenario: Verify that Folder name can have special characters
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User navigate through GNB to "Create Folder" under "Folders"
    When User enter the name of folder as "nam +!@#$%^&()_+=-{}[]|\:';<>?/., example" in the text field
    And User click on create folder button on light box
    Then Verify that user is able to see the folder name on folder listing page as "nam +!@#$%^&()_+=-{}[]|\:';<>?/., example"
    And Verify that user is able to see the success message of folder "nam +!@#$%^&()_+=-{}[]|\:';<>?/., example" creation
    And Verify that user is able to see create folder date on folder listing page for "nam +!@#$%^&()_+=-{}[]|\:';<>?/., example"
    And Verify that user is able to see the shared with category as "Only me" for folder "nam +!@#$%^&()_+=-{}[]|\:';<>?/., example"
    And Verify that user is able to see the count as "0" of candidate for folder "nam +!@#$%^&()_+=-{}[]|\:';<>?/., example"
    And Verify that user is able to see the candidate text for folder "nam +!@#$%^&()_+=-{}[]|\:';<>?/., example"

  @FolderManual @RMS3-4248 @ManualTes
  Scenario: User delete the folder created
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
    When User navigate through GNB to "My Folders" under "Folders"
    And User click on three dots for a folder "name !@#$%^&*()_+=-{}[]|\:';<>?/., example"
    And User select the option "Delete Folder" from the dropdown
    And User click on confirm button to delete folder
    Then Verify that user is not able to see the folder "name !@#$%^&*()_+=-{}[]|\:';<>?/., example"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify that super user adding a Folder with visibilty "Only me"
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "Create Folder" under "Folders"
    When User enter the name of folder as "Example folder super user" in the text field
    And User click on create folder button on light box
    Then Verify that user is able to see the folder name on folder listing page as "Example folder super user"
    And Verify that user is able to see the success message of folder "Example folder super user" creation
    And Verify that user is able to see create folder date on folder listing page for "Example folder super user"
    And Verify that user is able to see the shared with category as "Only me" for folder "Example folder super user"
    And Verify that user is able to see the count as "0" of candidate for folder "Example folder super user"
    And Verify that user is able to see the candidate text for folder "Example folder super user"

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify that other sub-users are not having the visibilty of folder created by subuser
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    Then Verify that user is not able to see the folder "Example folder super user"
    When User navigate through GNB to "Shared Folders" under "Folders"
    Then Verify that user is not able to see the folder "Example folder super user"

Examples:  
      |userType   |Subscription  |
      |"Subuser1" |"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify that other sub-users are not having the visibilty of folder created by superuser
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    Then Verify that user is not able to see the folder "Example folder super user"
    When User navigate through GNB to "Shared Folders" under "Folders"
    Then Verify that user is not able to see the folder "Example folder super user"

Examples:  
      |userType   |Subscription  |
      |"Subuser2" |"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: User delete the folder created
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    And User click on three dots for a folder "Example folder super user"
    And User select the option "Delete Folder" from the dropdown
    And User click on confirm button to delete folder
    Then Verify that user is not able to see the folder "Example folder super user"

Examples:  
      |userType   |Subscription  |
      |"Superuser" |"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify the only me visibilty functionality by sub user
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "Create Folder" under "Folders"
    When User enter the name of folder as "Example folder1" in the text field
    And User click on create folder button on light box
    Then Verify that user is able to see the folder name on folder listing page as "Example folder1"
    And Verify that user is able to see the success message of folder "Example folder1" creation
    And Verify that user is able to see create folder date on folder listing page for "Example folder1"
    And Verify that user is able to see the shared with category as "Only me" for folder "Example folder1"
    And Verify that user is able to see the count as "0" of candidate for folder "Example folder1"
    And Verify that user is able to see the candidate text for folder "Example folder1"

Examples:  
      |userType   |Subscription  |
      |"Subuser"  |"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify that other sub-users are not having the visibilty of folder created by subuser
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    Then Verify that user is not able to see the folder "Example folder1"
    When User navigate through GNB to "Shared Folders" under "Folders"
    Then Verify that user is not able to see the folder "Example folder1"

Examples:  
      |userType   |Subscription  |
      |"Subuser1" |"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify that super user is having the visibilty of folder created by subuser
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    Then Verify that user is not able to see the folder "Example folder1"
    When User navigate through GNB to "Shared Folders" under "Folders"
    Then Verify that user is able to see the folder name on folder listing page as "Example folder1"
    And Verify that user is able to see create folder date on folder listing page for "Example folder1"
    And Verify that user is able to see the shared with category as "Only me" for folder "Example folder1"
    And Verify that user is able to see the count as "0" of candidate for folder "Example folder1"
    And Verify that user is able to see the candidate text for folder "Example folder1"

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @FolderManual @RMS3-4248 @ManualTest
  Scenario: Verify new user added into the RMS is not having the visibilty of Folder
    Given User logged in as superuser into RMS application
    When User add new sub user subusernew into the application
    Given User logged in as subusernew into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder1" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder1" is not displaying to the user

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: User delete the folder created
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    And User click on three dots for a folder "Example folder1"
    And User select the option "Delete Folder" from the dropdown
    And User click on confirm button to delete folder
    Then Verify that user is not able to see the folder "Example folder1"

Examples:  
      |userType   |Subscription  |
      |"Subuser"  |"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify the visibilty to everyone in the company of folder created by superuser
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "Create Folder" under "Folders"
    When User enter the name of folder as "Example folder12 to all superuser" in the text field
    When User click on dropdown of share folder with on create folder light box
    And User select the folder share with category value as "Everyone in the company"
    Then Verify that user is able to see the share folder chip message as "Every recruiter will be able to access the folder."
    When User click on create folder button on light box
    Then Verify that user is able to see the folder name on folder listing page as "Example folder12 to all superuser"
    And Verify that user is able to see the success message of folder "Example folder12 to all superuser" creation
    And Verify that user is able to see create folder date on folder listing page for "Example folder12 to all superuser"
    And Verify that user is able to see the shared with category as "Everyone" for folder "Example folder12 to all superuser"
    And Verify that user is able to see the count as "0" of candidate for folder "Example folder12 to all superuser"
    And Verify that user is able to see the candidate text for folder "Example folder12 to all superuser"

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify that sub-users are having the visibilty of folder created by superuser
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    Then Verify that user is not able to see the folder "Example folder12 to all superuser"
    When User navigate through GNB to "Shared Folders" under "Folders"
    Then Verify that user is able to see the folder name on folder listing page as "Example folder12 to all superuser"
    And Verify that user is able to see create folder date on folder listing page for "Example folder12 to all superuser"
    And Verify that user is able to see the shared with category as "Everyone" for folder "Example folder12 to all superuser"
    And Verify that user is able to see the count as "0" of candidate for folder "Example folder12 to all superuser"
    And Verify that user is able to see the candidate text for folder "Example folder12 to all superuser"

Examples:  
      |userType   |Subscription  |
      |"Subuser1" |"Enterprise"  |

  @FolderManual @RMS3-4248 @ManualTest
  Scenario: Verify new user added into the RMS is having the visibilty of Folder
    Given User logged in as superuser into RMS application
    When User add new sub user subusernew1 into the application
    Given User logged in as subusernew1 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to all superuser" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all superuser" is displaying to the user
    And Verify that info strip is having the message "Every recruiter will be able to access the folder"

  @FolderManual @RMS3-4248 @ManualTest
  Scenario: Verify that super user remove a sub user and again add that user and verify Folder is visibile
    Given User logged in as superuser into RMS application
    When User remove the subusernew1 from the application
    And User logout from the application
    Given User logged in as superuser into RMS application
    When User add new sub user subusernew1 into the application
    Given User logged in as subusernew1 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to all superuser" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all superuser" is displaying to the user
    And Verify that info strip is having the message "Every recruiter will be able to access the folder"

@Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: User delete the folder created
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    And User click on three dots for a folder "Example folder12 to all superuser"
    And User select the option "Delete Folder" from the dropdown
    And User click on confirm button to delete folder
    Then Verify that user is not able to see the folder "Example folder12 to all superuser"

Examples:  
      |userType   |Subscription  |
      |"Superuser"|"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify the visibilty to everyone in the company by sub-user
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "Create Folder" under "Folders"
    When User enter the name of folder as "Example folder12 to all superuser" in the text field
    When User click on dropdown of share folder with on create folder light box
    And User select the folder share with category value as "Everyone in the company"
    Then Verify that user is able to see the share folder chip message as "Every recruiter will be able to access the folder."
    When User click on create folder button on light box
    Then Verify that user is able to see the folder name on folder listing page as "Example folder12 to all superuser"
    And Verify that user is able to see the success message of folder "Example folder12 to all superuser" creation
    And Verify that user is able to see create folder date on folder listing page for "Example folder12 to all superuser"
    And Verify that user is able to see the shared with category as "Everyone" for folder "Example folder12 to all superuser"
    And Verify that user is able to see the count as "0" of candidate for folder "Example folder12 to all superuser"
    And Verify that user is able to see the candidate text for folder "Example folder12 to all superuser"

Examples:  
      |userType   |Subscription  |
      |"Subuser"  |"Enterprise"  |

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify that other sub-users are having the visibilty of folder created by subuser
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    Then Verify that user is not able to see the folder "Example folder12 to all superuser"
    When User navigate through GNB to "Shared Folders" under "Folders"
    Then Verify that user is able to see the folder name on folder listing page as "Example folder12 to all superuser"
    And Verify that user is able to see create folder date on folder listing page for "Example folder12 to all superuser"
    And Verify that user is able to see the shared with category as "Everyone" for folder "Example folder12 to all superuser"
    And Verify that user is able to see the count as "0" of candidate for folder "Example folder12 to all superuser"
    And Verify that user is able to see the candidate text for folder "Example folder12 to all superuser"

Examples:  
      |userType   |Subscription  |
      |"Subuser1" |"Enterprise"  |

  
  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: Verify that other super user is having the visibilty of folder created by subuser
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    Then Verify that user is not able to see the folder "Example folder12 to all superuser"
    When User navigate through GNB to "Shared Folders" under "Folders"
    Then Verify that user is able to see the folder name on folder listing page as "Example folder12 to all superuser"
    And Verify that user is able to see create folder date on folder listing page for "Example folder12 to all superuser"
    And Verify that user is able to see the shared with category as "Everyone" for folder "Example folder12 to all superuser"
    And Verify that user is able to see the count as "0" of candidate for folder "Example folder12 to all superuser"
    And Verify that user is able to see the candidate text for folder "Example folder12 to all superuser"

Examples:  
      |userType    |Subscription  |
      |"Superuser" |"Enterprise"  |

  @FolderManual @RMS3-4248 @ManualTest
  Scenario: Verify new user added into the RMS is having the visibilty of Folder
    Given User logged in as superuser into RMS application
    When User add new sub user subusernew into the application
    Given User logged in as subusernew into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to all" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all" is displaying to the user
    And Verify that info strip is having the message "Every recruiter will be able to access the folder"

  @FolderManual @RMS3-4248 @ManualTest
  Scenario: Verify that super user remove a sub user and again add that user and verify Folder is visibile
    Given User logged in as superuser into RMS application
    When User remove the subusernew from the application
    And User logout from the application
    Given User logged in as superuser into RMS application
    When User add new sub user subusernew into the application
    Given User logged in as subusernew into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to all" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all" is displaying to the user
    And Verify that info strip is having the message "Every recruiter will be able to access the folder"

  @FolderManual @RMS3-4248 @ManualTest
  Scenario: Verify that superuser remove the folder creator and verify that visibilty of the folder remains same
    Given User logged in as superuser into RMS application
    When User remove the subuser1 from the application
    When User click on "Folder" GNB
    And User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all" is displaying to the user
    And Verify that info strip is having the message "Every recruiter will be able to access the folder"
    Given User logged in as subuser2 into RMS application
    When User click on "Folder" GNB
    And User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all" is displaying to the user
    And Verify that info strip is having the message "Every recruiter will be able to access the folder"

@Folder @RMS3-4248 @FolderCreation @RMS
  Scenario Outline: User delete the folder created
    Given User login to the application "rmsDashboardPage" using <userType> of <Subscription> user
    When User navigate through GNB to "My Folders" under "Folders"
    And User click on three dots for a folder "Example folder12 to all superuser"
    And User select the option "Delete Folder" from the dropdown
    And User click on confirm button to delete folder
    Then Verify that user is not able to see the folder "Example folder12 to all superuser"

Examples:  
      |userType   |Subscription  |
      |"Subuser"  |"Enterprise"  |


  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that MLH superuser create the folder with visibilty as selected recruiter
    Given User logged in as superuser into RMS application
    When User click on "Folder" GNB
    And User click on "Create Folder" option
    And User enter "Example folder2 to selected recruiters" as folder name text box
    And User select "Selected Recruiters" from shared folder dropdown
    Then Verify that User is able to see the dropdown of recruiters
    And Verify that user is able to see the select all checkbox
    And Verify that user is able to see the team leads
    When User click on the team lead
    Then Verify that user is able to see the breadcrumbs
    And Verify that all recruiter checkbox is not displaying
    And Verify that user is not able to see select all checkbox
    When User click on back button to reach all recruiters dropdown
    Then Verify that user is able to see select all checkbox
    And Verify that all recruiters are displaying with checkboxes
    And Verify that checkboxes of all recruiters are not selected
    And Verify that superuser can see own name in the dropdown
    And Verify that superuser name in the dropdown is not selected
    And Verify that superuser name in the dropdown is disabled
    When User select subuser1 recruiter
    Then Verify that no strip is displaying as 1 user selected
    When User uncheck the subuser1
    When User select the select all checkbox
    Then Verify that all the checkboxes of recruiters are selected except superuser
    When User uncheck the select all checkbox
    And Click on create folder button
    Then Verify that user is able to se an error message as "Select recruiter with whom you want to share this folder"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that superuser can search the recruiters to add
    Given User logged in as superuser into RMS application
    When User click on "Folder" GNB
    And User click on "Create Folder" option
    And User enter "Example folder2 to selected recruiters" as folder name text box
    And User select "Selected Recruiters" from shared folder dropdown
    Then Verify that User is able to see the dropdown of recruiters
    And Verify that user is able to see the search box
    When User enter "user" in the search box
    Then Verify that recruiter related to to name "user" are displaying
    And Verify that select all checkbox is not displaying
    And Verify that all the recruiter in search results are sorted alphabatically
    When User enter empty string in search box
    Then Verify that no search perfomed
    When User enter "||" in the search box
    Then Verify that no result found message is displaying
    When User enter "!@#$%^&*()_-+={}[];'?></.,|\" in the search box
    Then Verify that no result found message is displaying
    When User enter "!@#$%^&*()_-+={}[];'?></.,|\              sbahjbx            xsbhxs             xshbxs                    sxxshbxsxshbxsxshbxsxshbxsxshbxsxshbxsxshbxsxshbxs" in the search box
    Then Verify that no result found message is displaying
    When User enter "inactive user" in the search box
    Then Verify that no result found message is displaying

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that super user share the folder to some recruiters
    Given User logged in as superuser into RMS application
    When User click on "Folder" GNB
    And User click on "Create Folder" option
    And User enter "Example folder2 to selected recruiters" as folder name text box
    And User select "Selected Recruiters" from shared folder dropdown
    Then Verify that User is able to see the dropdown of recruiters
    And Verify that superuser checkbox is not selected
    And Verify that subuser checkbox is disabled
    When User select subuser1 recruiter
    When User select subuser2 recruiter
    When User select subuser3 recruiter
    And User click on "Create Folder" button
    Then Verify that folder "Example folder2 to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is not able to see the chips for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that checkbox of folder creator and superuser is selected and disabled for other users
    Given User logged in as subuser1 into RMS application
    When User click on "Folder" GNB
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to selected recruiters" is displaying to the user
    And Verify that superuser checkbox is selected
    And Verify that subuser checkbox is disabled

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser1 is having visibilty of the folder
    Given User logged in as subuser1 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser2 is having visibilty of the folder
    Given User logged in as subuser2 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser3 is having visibilty of the folder
    Given User logged in as subuser3 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser can remove own visibilty and can share the folder to other subuser
    Given User logged in as subuser3 into RMS application
    When User click on "Folder" GNB
    And User select "Shared Folder" tab
    And User share the folder "Example folder2 to selected recruiters" to the subuser4
    And Verify that superuser checkbox is selected
    And Verify that subuser checkbox is disabled
    And User remove visibilty of subuser3
    And User save the changes
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to selected recruiters" is not displaying to the user
    When User hit the direct URL of "Example folder2 to selected recruiters" folder
    Then Verify that user is able to see the permission error

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser4 is having visibilty of the folder
    Given User logged in as subuser4 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser4"
    And Verify that user is not able to see the chip for "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser4" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that new user which added into the application is not having the visibilty of the folder
    Given User logged in as superuser into RMS application
    When User add new sub user subusernew3 into the application
    Given User logged in as subusernew3 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to selected recruiters" is not displaying to the user
    When User hit the direct URL of "Example folder2 to selected recruiters" folder
    Then Verify that user is able to see the permission error

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that super user remove a sub user and again add that user and verify Folder is visibile
    Given User logged in as superuser into RMS application
    When User remove the subuser1 from the application
    And User logout from the application
    Given User logged in as superuser into RMS application
    When User add new sub user subuser1 into the application
    Given User logged in as subuser1 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser4"
    And Verify that user is not able to see the chip for "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser4" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that superuser set the visibilty to selected all recruiter
    Given User logged in as superuser into RMS application
    When User click on "Folder" GNB
    And User click on "Create Folder" option
    And User enter "Example folder2 to selected recruiters" as folder name text box
    And User select "Selected Recruiters" from shared folder dropdown
    Then Verify that User is able to see the dropdown of recruiters
    And Verify that superuser checkbox is not selected
    And Verify that subuser checkbox is disabled
    When User select the checkbox of "select all"
    And User click on "Create Folder" button
    Then Verify that folder "Example folder2 to all recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is not able to see the chips for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that checkbox of folder creator and superuser is selected and disabled for other users
    Given User logged in as subuser1 into RMS application
    When User click on "Folder" GNB
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all recruiters" is displaying to the user
    And Verify that superuser checkbox is selected
    And Verify that subuser checkbox is disabled

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser1 is having visibilty of the folder
    Given User logged in as subuser1 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to all recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser2 is having visibilty of the folder
    Given User logged in as subuser2 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to all recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser3 is having visibilty of the folder
    Given User logged in as subuser3 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to all recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser can remove own visibilty and can share the folder to other subuser
    Given User logged in as subuser3 into RMS application
    When User click on "Folder" GNB
    And User select "Shared Folder" tab
    And User remove visibilty of subuser3
    And User save the changes
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to all recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all recruiters" is not displaying to the user
    When User hit the direct URL of "Example folder2 to selected recruiters" folder
    Then Verify that user is able to see the permission error

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that new user which added into the application is not having the visibilty of the folder
    Given User logged in as superuser into RMS application
    When User add new sub user subusernew3 into the application
    Given User logged in as subusernew3 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to all recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all recruiters" is not displaying to the user
    When User hit the direct URL of "Example folder2 to selected recruiters" folder
    Then Verify that user is able to see the permission error

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that super user remove a sub user and again add that user and verify Folder is visibile
    Given User logged in as superuser into RMS application
    When User remove the subuser1 from the application
    And User logout from the application
    Given User logged in as superuser into RMS application
    When User add new sub user subuser1 into the application
    Given User logged in as subuser1 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder2 to all recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to all recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser4"
    And Verify that user is not able to see the chip for "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser4" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that sub user share the folder to some recruiters
    Given User logged in as subuser1 into RMS application
    When User click on "Folder" GNB
    And User click on "Create Folder" option
    And User enter "Example folder subuser to selected recruiters" as folder name text box
    And User select "Selected Recruiters" from shared folder dropdown
    Then Verify that User is able to see the dropdown of recruiters
    And Verify that superuser checkbox is selected
    And Verify that subuser checkbox is disabled
    And Verify that subuser1 checkbox is not selected
    And Verify that subuser1 checkbox is disabled
    When User select subuser2 recruiter
    When User select subuser3 recruiter
    And User click on "Create Folder" button
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser2" "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is not able to see the chips for "subuser1"
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that checkbox of folder creator and superuser is selected and disabled for other users
    Given User logged in as subuser2 into RMS application
    When User click on "Folder" GNB
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that superuser checkbox is selected
    And Verify that subuser checkbox is disabled
    And Verify that subuser1 checkbox is selected
    And Verify that subuser1 checkbox is disabled

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that checkbox of folder creator and superuser is selected and disabled for superuser
    Given User logged in as superuser into RMS application
    When User click on "Folder" GNB
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that superuser checkbox is selected
    And Verify that subuser checkbox is disabled
    And Verify that subuser1 checkbox is selected
    And Verify that subuser1 checkbox is disabled

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that superuser is having visibilty of the folder
    Given User logged in as superuser into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser3"
    And Verify that user can not remove the chip for "subuser1"
    And Verify that user can remove "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser2 is having visibilty of the folder
    Given User logged in as subuser2 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser1" "subuser2" "subuser3"
    And Verify that user can remove "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser" and "subuser1"
    And Verify that user can not remove the chip for "superuser" and "subuser1"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser3 is having visibilty of the folder
    Given User logged in as subuser3 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser2" "subuser3"
    And Verify that user can remove "subuser1" "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser" and "subuser1"
    And Verify that user can not remove the chip for "superuser" and "subuser1"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser can remove own visibilty and can share the folder to other subuser
    Given User logged in as subuser3 into RMS application
    When User click on "Folder" GNB
    And User select "Shared Folder" tab
    And User share the folder "Example folder subuser to selected recruiters" to the subuser4
    And User remove visibilty of subuser3
    And User save the changes
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder2 to selected recruiters" is not displaying to the user
    When User hit the direct URL of "Example folder2 to selected recruiters" folder
    Then Verify that user is able to see the permission error

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that subuser4 is having visibilty of the folder
    Given User logged in as subuser4 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser2" "subuser4"
    And Verify that user is not able to see the chip for "subuser3"
    And Verify that user can remove "subuser2" "subuser4" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser" and "subuser1"
    And Verify that user can not remove the chip for "superuser" and "subuser1"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that new user which added into the application is not having the visibilty of the folder
    Given User logged in as superuser into RMS application
    When User add new sub user subusernew4 into the application
    Given User logged in as subusernew3 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
    When User hit the direct URL of "Example folder subuser to selected recruiters" folder
    Then Verify that user is able to see the permission error

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that super user remove a sub user and again add that user and verify Folder is visibile
    Given User logged in as superuser into RMS application
    When User remove the subuser2 from the application
    And User logout from the application
    Given User logged in as superuser into RMS application
    When User add new sub user subuser2 into the application
    Given User logged in as subuser2 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser2" "subuser4"
    And Verify that user is not able to see the chip for "subuser3"
    And Verify that user can remove "subuser2" "subuser4" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser" and "subuser1"
    And Verify that user can not remove the chip for "superuser" and "subuser1"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that if folder creator removed form the application then folder is displaying to other users
    Given User logged in as superuser into RMS application
    When User remove the subuser1 from the application
    And User logout from the application
    Given User logged in as superuser into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser2" "subuser3"
    And Verify that user is not able to see the chips for "subuser1"
    And Verify that user can remove "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"
    Given User logged in as subuser2 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser2" "subuser3"
    And Verify that user is not able to see the chips for "subuser1"
    And Verify that user can remove "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"

  @Folder @RMS3-4248 @FolderCreation @RMS
  Scenario: Verify that folder creator is added to the application is having same visibilty
    Given User logged in as superuser into RMS application
    When User add new sub user subuser1 into the application
    Given User logged in as subuser1 into RMS application
    When User click on "Folder" GNB
    And User Click on "My Folder" option
    Then Verify that folder "Example folder subuser to selected recruiters" is displaying to the user
    And Verify that user is able to see the chips for "subuser2" "subuser3"
    And Verify that user can remove "subuser2" "subuser3" chips by clicking on cross icon
    And Verify that user is not able to see the chips for "subuser1"
    And Verify that user is able to see the chips for "superuser"
    And Verify that user can not remove the chip for "superuser"
    When User select "Shared Folder" tab
    Then Verify that folder "Example folder subuser to selected recruiters" is not displaying to the user
