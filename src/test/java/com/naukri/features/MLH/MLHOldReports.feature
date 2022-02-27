Feature: To verify scenarios related to MLH in old reports
  
  Backgound:
  Given User login to rms "ReportsPage" using "superuser1" and "superuser1password" of "Enterprise" user

  @id:1 @RecruiterReport @RMS2-3508 @wip
  Scenario: Team view is applicable: Verify Radio Button on generate page for Recruiter Report for subuser
    Given User is on generate "Recruiter Report" page
    When User click on "Download " tab
    Then Verify "Choose the view you want to Download" text is displayed
    And Verify radio button "Recruiter (Individual Contribution)" is displayed
    And Verify "Recruiter (Individual Contribution)" radio button is selected by default
    And Verify radio button "Direct Reportees (Team Contribution)" is displayed
    When User click on "Email Scheduler " tab
    Then Verify "Add Email Id :" label is above "Choose the view you want to Download" label
    And Verify radio button "Recruiter (Individual Contribution)" is displayed
    And Verify "Recruiter (Individual Contribution)" radio button is selected by default
    And Verify radio button "Direct Reportees (Team Contribution)" is displayed

  @id:2 @RecruiterReport @RMS2-3508 @wip
  Scenario: Team view is applicable: Verify Radio Button on generate page for Recruiter Report for superuser
    Given User is on generate "Recruiter Report" page
    When User click on "Download " tab
    Then Verify "Choose the view you want to Download" text is displayed
    And Verify radio button "Recruiter (Individual Contribution)" is displayed
    And Verify "Recruiter (Individual Contribution)" radio button is selected by default
    And Verify radio button "Team Contribution" is displayed
    When User click on "Email Scheduler " tab
    Then Verify "Add Email Id :" label is above "Choose the view you want to Download" label
    And Verify radio button "Recruiter (Individual Contribution)" is displayed
    And Verify "Recruiter (Individual Contribution)" radio button is selected by default
    And Verify radio button "Team Contribution" is displayed

  @id:3 @RecruiterReport @RMS2-3508 @wip
  Scenario: Team view is applicable: Verify Radio Button on view report page for Recruiter Report for subuser when user select Download Report
    Given User is on generate "Recruiter Report" page
    And User click on Generate Report button
    And User hover on "Download"
    When User click on "Download Report" download
    Then Verify header of lightbox is "Download Report"
    And Verify "Choose the view you want to Download" text is displayed
    And Verify radio button "Recruiter (Individual Contribution)" is displayed
    And Verify "Recruiter (Individual Contribution)" radio button is selected by default
    And Verify radio button "Direct Reportees (Team Contribution)" is displayed

  @id:4 @RecruiterReport @RMS2-3508 @wip
  Scenario: Team view is applicable: Verify Radio Button on view report page for Recruiter Report for superuser when user select Download Report
    Given User is on generate "Recruiter Report" page
    And User click on Generate Report button
    And User hover on "Download"
    When User click on "Download Report" download
    Then Verify header of lightbox is "Download Report"
    And Verify "Choose the view you want to Download" text is displayed
    And Verify radio button "Recruiter (Individual Contribution)" is displayed
    And Verify "Recruiter (Individual Contribution)" radio button is selected by default
    And Verify radio button "Team Contribution" is displayed

  @id:5 @RecruiterReport @RMS2-3508 @wip
  Scenario: Team view is applicable: Verify Radio Button on view report page for Recruiter Report for subuser when user select Download Report
    Given User is on generate "Recruiter Report" page
    And User click on Generate Report button
    And User hover on "Download"
    When User click on "Download Report with Candidate Tracker" download
    Then Verify header of lightbox is "Download Report" download
    And Verify that radio button are displayed before "Select candidate tracker:" label
    And Verify "Choose the view you want to Download" text is displayed
    And Verify radio button "Recruiter (Individual Contribution)" is displayed
    And Verify "Recruiter (Individual Contribution)" radio button is selected by default
    And Verify radio button "Direct Reportees (Team Contribution)" is displayed

  @id:6 @RecruiterReport @RMS2-3508 @wip
  Scenario: Team view is applicable: Verify Radio Button on view report page for Recruiter Report for superuser when user select Download Report
    Given User is on generate "Recruiter Report" page
    And User click on Generate Report button
    And User hover on "Download"
    When User click on "Download Report with Candidate Tracker" download
    Then Verify header of lightbox is "Download Report"
    And Verify that radio button are displayed before "Select candidate tracker:" label
    And Verify "Choose the view you want to Download" text is displayed
    And Verify radio button "Recruiter (Individual Contribution)" is displayed
    And Verify "Recruiter (Individual Contribution)" radio button is selected by default
    And Verify radio button "Team Contribution" is displayed

  @id:7 @RecruiterReport @RMS2-3508 @wip
  Scenario: Team view is not applicable: Verify that no Radio Button are displayed on generate recruiter report page
    Given User is on generate "Recruiter Report" page
    When User click on "Download " tab
    Then Verify "Choose the view you want to Download" text is not displayed
    And Verify radio button "Recruiter (Individual Contribution)" is not displayed
    And Verify radio button "Direct Reportees (Team Contribution)" is not displayed
    When User click on "Email Scheduler " tab
    Then Verify "Add Email Id :" label is above "Choose the view you want to Download" label
    And Verify radio button "Recruiter (Individual Contribution)" is not displayed
    And Verify radio button "Direct Reportees (Team Contribution)" is not displayed

  @id:8 @RecruiterReport @RMS2-3508 @wip
  Scenario: Team view is not applicable: Verify that no Radio Button are displayed on generate recruiter report page for Downloas Report with tracker
    Given User is on generate "Recruiter Report" page
    And User click on Generate Report button
    And User hover on "Download"
    When User click on "Download Report with Candidate Tracker" download
    Then Verify header of lightbox is "Download Report"
    And Verify "Choose the view you want to Download" text is not displayed
    And Verify radio button "Recruiter (Individual Contribution)" is not displayed
    And Verify radio button "Team Contribution" is not displayed

  @id:9 @RecruiterReport @RMS2-3508 @wip
  Scenario: Team view is not applicable: Verify that no Radio Button are displayed on generate recruiter report page for Downloas Report without tracker
    Given User is on generate "Recruiter Report" page
    And User click on Generate Report button
    And User hover on "Download"
    When User click on "Download Report" download
    Then Verify header of lightbox is "Download Report"
    And Verify "Choose the view you want to Download" text is not displayed
    And Verify radio button "Recruiter (Individual Contribution)" is not displayed
    And Verify radio button "Team Contribution" is not displayed
    
 @id:10 @WIP @RMS2-3454
Scenario: Verify If No hierarchy configured in organisation for Recruiter Report
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "Recruiter" Report
    Then user  see "All" option and below "All" I see all my recruiters indented
    When A, B, C, D & E are all recruiters without any reportees or reporting to
	And user A is the Superuser
	Then user A will see below option
	|All|
	|A  |
	|B  |
	|C  |
	|D  |
	|E  |
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	
	  
	  
	  @id:11 @WIP @RMS2-3454
Scenario: Verify If No hierarchy configured in organisation for Group Wise Report Report
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "Group Wise Report" Report
    Then user  see "All" option and below "All" I see all my recruiters indented
    When A, B, C, D & E are all recruiters without any reportees or reporting to
	And user A is the Superuser
	Then user A will see below option
	|All|
	|A  |
	|B  |
	|C  |
	|D  |
	|E  |
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
  
  @id:3 @WIP @RMS2-3454
Scenario: Verify If No hierarchy configured in organisation for Requirement Report
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "Requirement" Report
    Then user  see "All" option and below "All" I see all my recruiters indented
    When A, B, C, D & E are all recruiters without any reportees or reporting to
	And User A is the Superuser
	Then user A will see below option
	|All|
	|A  |
	|B  |
	|C  |
	|D  |
	|E  |
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	
	@id:4 @WIP @RMS2-3454
Scenario: Verify If my organisation has only 1 level of hierarchy and 1 root for Recruiter Report
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	When User A is the Superuser and Single root
	And User B and C reports to A
	Then user A will see below option
	|All|
	|A  |
	|B  |
	|C  |
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
@id:5 @WIP @RMS2-3454
Scenario: Verify If my organisation has 1 root for Recruiter Report.A is the Single root. Only his team exists in RMS. B and C reports to A. B is the Superuser
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	When User B is the Superuser
	Then user B will see below option
	|All|
	|A  |
	|B  |
	|C  |
And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports

@id:6 @WIP @RMS2-3454
Scenario: Verify If my organisation has only 1 level of hierarchy and 1 root for Requirement Report
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	When User A is the Superuser and Single root
	And User B and C reports to A
	Then user A will see below option
	|All|
	|A  |
	|B  |
	|C  |
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
@id:7 @WIP @RMS2-3454
Scenario: Verify If my organisation has 1 root for Requirement Report.A is the Single root. Only his team exists in RMS. B and C reports to A. B is the Superuser
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	When User B is the Superuser
	Then user B will see below option
	|All|
	|A  |
	|B  |
	|C  |
And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports	

@id:8 @WIP @RMS2-3454
Scenario: Verify If my organisation has only 1 level of hierarchy and 1 root for Group Wise Report Report
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	When User A is the Superuser and Single root
	And User B and C reports to A
	Then user A will see below option
	|All|
	|A  |
	|B  |
	|C  |
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
@id:9 @WIP @RMS2-3454
Scenario: Verify If my organisation has 1 root for Group Wise Report Report.A is the Single root. Only his team exists in RMS. B and C reports to A. B is the Superuser
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	When User B is the Superuser
	Then user B will see below option
	|All|
	|A  |
	|B  |
	|C  |
And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports	

@id:10 @WIP @RMS2-3454
Scenario Outline: Verify If my organisation has multiple root  for  all 3 Report
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report
	When User select "All" recruiter 
	Then Verify Roots as Teams
	And Verify All recruiters directly or indirectly reporting the root as recruiters / team member
	And Verify All" should be in bold in DropDown
	And Verify Team Recruiter name" should be in bold.
	And Verify all recruiters directly or indirectly part of "Team Recruiter name" as recruiters below the corresponding "Team Recruiter name"
	When User select "All" recruiter
	Then Verify All recruiters / teams should be selected
	When User manually select all recruiters in a team 
	Then Verify The "Team Recruiter name" should be selected
	When I have selected all teams (This can be due to selection of individual recruiters in a team or "Team Recruiter name")
	Then Verify "All" should be selected
	Then user B will see below option
	|All|
	|A  |
	|Team P  |
	|C   |
	|D |
	|E  |
	|F  |
	|P |
	|Team T  |
	|G   |
	|H |
	|I |
	|J |
	|T |
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |

@id:11 @WIP @RMS2-3454
Scenario Outline: Verify If superuser of a company with a single root and there is alteast 2 level of hierarchy in my organisation for all 3 Report
And User P is super user and root
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report
	When User select "All" recruiter 
	Then Verify Roots as Teams
	And Verify All recruiters directly or indirectly reporting the root as recruiters / team member
	And Verify All" should be in bold in DropDown
	And Verify Team Recruiter name" should be in bold.
	And Verify all recruiters directly or indirectly part of "Team Recruiter name" as recruiters below the corresponding "Team Recruiter name"
	When User select "All" recruiter
	Then Verify All recruiters / teams should be selected
	When User manually select all recruiters in a team 
	Then Verify The "Team Recruiter name" should be selected
	When User have selected all teams (This can be due to selection of individual recruiters in a team or "Team Recruiter name")
	Then Verify "All" should be selected
	When User P is super user and root
	Then user P will see below option
	|All|
	|P  |
	|P  |
	|Team A  |
	|B  |
	|C  |
	|D |
	|E  |
	|A  |
	|Team AJ  |
	|G   |
	|H |
	|I |
	|J |
	|AJ |
	|Team L |
	|K |
	|L |
	|M |
	|N |
	|O |
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |	  
	  
@id:12 @WIP @RMS2-3454
Scenario Outline: Verify If superuser of a company with a single root and there is alteast 2 level of hierarchy in my organisation for all 3 Report
And User P is root and B is super.
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report
	When User select "All" recruiter 
	Then Verify Roots as Teams
	And Verify All recruiters directly or indirectly reporting the root as recruiters / team member
	And Verify All" should be in bold in DropDown
	And Verify Team Recruiter name" should be in bold.
	And Verify all recruiters directly or indirectly part of "Team Recruiter name" as recruiters below the corresponding "Team Recruiter name"
	When User select "All" recruiter
	Then Verify All recruiters / teams should be selected
	When User manually select all recruiters in a team 
	Then Verify The "Team Recruiter name" should be selected
	When User have selected all teams (This can be due to selection of individual recruiters in a team or "Team Recruiter name")
	Then Verify "All" should be selected
	When User B is super user
	Then user B will see below option
	|All|
	|P  |
	|P  |
	|Team A  |
	|B  |
	|C  |
	|D |
	|E  |
	|A  |
	|Team AJ  |
	|G   |
	|H |
	|I |
	|J |
	|AJ |
	|Team L |
	|K |
	|L |
	|M |
	|N |
	|O |
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |	  

@id:1 @WIP @RMS2-3428
Scenario Outline: Verify If Subuser has no reportees for sub user
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report
	Then Verify Recruiter Filter not applicable for it.
    And Verify user can only see his data and no ones else data in all report
	Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |
	  
	  
	  @id:2 @WIP @RMS2-3428
Scenario Outline: Verify sub user has only one level of reporting when MLH is applicable 
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report
    Then user  see "All" option and below "All" I see all my recruiters indented
    When User B and C Reports to A
	And user A is the Superuser
	Then user A will see below option
	|All|
	|A  |
	|B  |
	|C  |
	
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |
	
  
  @id:3 @WIP @RMS2-3428
Scenario Outline: Verify If sub user has more than one level of reportees below me &  when MLH is applicable for all 3 Report
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report
	When User select "All" recruiter 
	Then Verify Roots as Teams
	And Verify All recruiters directly or indirectly reporting the root as recruiters / team member
	And Verify All" should be in bold in DropDown
	And Verify Team Recruiter name" should be in bold.
	And Verify all recruiters directly or indirectly part of "Team Recruiter name" as recruiters below the corresponding "Team Recruiter name"
	When User select "All" recruiter
	Then Verify All recruiters / teams should be selected
	When User manually select all recruiters in a team 
	Then Verify The "Team Recruiter name" should be selected
	When User have selected all teams (This can be due to selection of individual recruiters in a team or "Team Recruiter name")
	Then Verify "All" should be selected
	When User P is super user and root
	Then user P will see below option
	|All|
	|P  |
	|P  |
	|Team A  |
	|B  |
	|C  |
	|D |
	|E  |
	|A  |
	|Team AJ  |
	|G   |
	|H |
	|I |
	|J |
	|AJ |
	|Team L |
	|K |
	|L |
	|M |
	|N |
	|O |
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |	  
	  @id:1 @WIP @RMS2-3426
Scenario Outline: Verify If Subuser has no reportees for non MLH
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report
	Then Verify Recruiter Filter not applicable for it.
    And Verify user can only see his data and no ones else data in all report
	Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |
	  
	  
	  @id:2 @WIP @RMS2-3426
Scenario Outline: Verify sub user has only one level of reporting when MLH is not applicable 
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report
    And Verify All" should be in bold in DropDown
	And Verify Team Recruiter name" should be in bold.
    When User B and C Reports to A
	And user A is the Superuser
	Then user A will see below option
	|All|
	|A  |
	|B  |
	|C  |
	
	When User select "All" recruiter 
	Then Verify All recruiters should be selected
	When User manually select all recruiters one by one 
	Then Verify "All" should get selected
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |
	
  
  @id:3  @WIP @RMS2-3426
Scenario Outline: Verify If a subuser who has at least one reportee and when MLH is not applicable for all 3 Report
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report
	When User select "All" recruiter 
	Then Verify Roots as Teams
	And Verify All recruiters directly or indirectly reporting the root as recruiters / team member
	And Verify All" should be in bold in DropDown
	And Verify Team Recruiter name" should be in bold.
	And Verify all recruiters directly or indirectly part of "Team Recruiter name" as recruiters below the corresponding "Team Recruiter name"
	When User select "All" recruiter
	Then Verify All recruiters / teams should be selected
	When User manually select all recruiters in a team 
	Then Verify The "Team Recruiter name" should be selected
	When User have selected all teams (This can be due to selection of individual recruiters in a team or "Team Recruiter name")
	Then Verify "All" should be selected
	When User P is super user and root
	Then user P will see below option
	|All|
	|P  |
	|A  |
	|B  |
	|C  |
	|D  |
	|E  |
	|F  |
	|G  |
	|H |
	|I |
	|J |
	
	And Verify  Placeholder on dropdown "Recruiters Selected (number of unique recruiters selected )"
	When Use select ALL as an option
	Then Verify cips should be formed based on my selection of recruiters.
	And Verify Teams names will not be shown
	And Verify By default all recruiters will be selected
	And Verify All recruiter, including me will be in Alphabetical order in dropdown as well as reports
	Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |	  	  	     

	

@id:1 @WIP @RMS2-3505
Scenario Outline: Verify All recruiters selected in Recruiter Filter will reflect in Recruiter Column
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report.
	And User selected all Recruiter
	And User Generate the report
	Then Verify  All recruiters selected in Recruiter Filter will reflect in Recruiter Column
    Examples: 
      | ReportType   |
      | Recruiter |
	  
	  
	  @id:2 @WIP @RMS2-3505
Scenario Outline: Verify Team Column will be filled based on Recruiter Column and User generating (viewing) the report
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report.
	And User selected all Recruiter
	And User Generate the report
	Then Verify Team Column will be filled based on Recruiter Column and User generating (viewing) the report
    Examples: 
      | ReportType   |
      | Recruiter |
	  
@id:3 @WIP @RMS2-3506
Scenario Outline: Verify Impact of Recruiter Filter on different Report when visibility is assign to only
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report.
	And User selected all Recruiter
	And User Generate the report
	Then Verify Requirement is displayed as selected in the "<ReportType>" Report 
   Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |
	  
	  
@id:4 @WIP @RMS2-3506
Scenario Outline: Verify Impact of Recruiter Filter on different Report when visibility is view only
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report.
	And User selected all Recruiter
	And User Generate the report
	Then Verify Requirement is displayed as selected in the "<ReportType>" Report 
	
   Examples: 
      | ReportType   |
      | Recruiter |
	  | Requirement |
	  | Group Wise Reports |	  
	  
	  @id:5 @WIP @RMS2-3514
Scenario Outline: Verify ‘Overall’ column in recruiter report is not displayed for subUser
    Given User login to the application "requirementInbox" using "Superuser" of "SubUserType" user
	When User goes to the "<Report>" Report.
	Then Verify Overall filter is not displayed
	When User selected all Recruiter
	And user select Report Type as "<Report Type>"
	And user select BreakUp by as "<Breakup By>"
	And User select "<Comparison>"
	And User Generate the report
	Then Verify ‘Overall’ column in recruiter report is not displayed
	And Verify ‘Overall’ column in scheduled report  is not displayed  for Recruiter with no reportees
	And Verify ‘Overall’ column in existing saved report  is not displayed  for Recruiter with no reportees
   Examples: 
      | Report   |Report Type|Breakup By|Comparison|
      | Recruiter| Hourly    |	Source	 |	True	|
	  | Recruiter| Daily    |	Requirement	|	True	|
	  | Recruiter| Consolidated |	Group	|	True	|
	  | Recruiter| Hourly    |	Source	|	True	|
	  | Recruiter| Hourly    |	Group	 |	True	|
	  | Recruiter| Daily    |	Group	|	True	|
	  | Recruiter| Consolidated |	Source	|	True|
	  | Recruiter| Hourly    |	Source	|	True	|
	  | Recruiter| Hourly    |	None	 |	True	|
	  | Recruiter| Daily    |	None	|	True	|
	  | Recruiter| Consolidated |	None	|	True	|
	  | Recruiter| Hourly    |	None	|	True	|
	  | Recruiter| Hourly    |	None	 |	True	|
	  | Recruiter| Daily    |	None	|	True	|
	  | Recruiter| Consolidated |	None	|	True|
	  | Recruiter| Hourly    |	None	|	True	|
	  
	@id:6 @WIP @RMS2-3514
Scenario Outline: Verify No change for Requirement / Employer / Group Report  w.r.t ‘Overall’ column for subUser
    Given User login to the application "requirementInbox" using "Superuser" of "SubUserType" user
	When User goes to the "<ReportType>" Report.
	Then Verify Overall filter is  displayed
	When User selected all Recruiter
	And User Generate the report
	Then Verify ‘Overall’ column in report  is  displayed
	And Verify ‘Overall’ column in scheduled report  is  displayed
	And Verify ‘Overall’ column in scheduled report  is  displayed  for Recruiter with no reportees
	And Verify ‘Overall’ column in existing saved report  is  displayed  for Recruiter with no reportees
  Examples: 
      | ReportType   |
      | Employer |
	  | Requirement |
	  | Group Wise Reports |
	  	    
@id:7 @WIP @RMS2-3514
Scenario Outline: Verify No Change for Subuser with reportees and for Superuser  w.r.t ‘Overall’ column 
    Given User login to the application "requirementInbox" using "Superuser" of "SubUserType" user
	When User goes to the "<ReportType>" Report.
	Then Verify Overall filter is  displayed
	When User selected all Recruiter
	And User Generate the report
	Then Verify ‘Overall’ column in report  is  displayed
	And Verify ‘Overall’ column in scheduled report  is  displayed  for Recruiter with no reportees
	And Verify ‘Overall’ column in existing saved report  is  displayed  for Recruiter with no reportees
  Examples: 
      | ReportType   |
      | Employer |
	  | Requirement |
	  | Group Wise Reports |
	  
@id:8 @WIP @RMS2-3504
Scenario Outline: Verify All recruiters selected in Recruiter Filter will reflect in Recruiter Column
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report.
	And User set hierarchy 
	|Pradeep heads RMS Tech|
	|Abhishek T, Lokesh, Ajay reports to Pradeep|
	|Shariq & Kaustabh reports to Abhishek|
	|Mansi, Rachit & Himanshu reports to Lokesh|
|Anamol & Vivek reports to Ajay|
|Usman & Prerna reports to Anamol|
|Tarun heads RMS Product|
|Sharat, Sharmistha, Amanpreet, Amit reports to Tarun|
|Manya & Piyush reports to Sharat|
|Nidhi, Vivek, Shubham reports to Amit|
	And User click on select Reruiter dropdown
	And User as Shariq is selected
	Then Verify Teams column against Shariq will correspond to Pradeep
	Examples: 
      | ReportType   |
      | Recruiter |
	  
@id:9 @WIP @RMS2-3504	  
Scenario Outline: Verify Root of my organisation as Team column when Recruiter or Team selected is the Root
    Given User login to the application "requirementInbox" using "Superuser" of "userType" user
	When User goes to the "<ReportType>" Report.
	And User set hierarchy 
	|Pradeep is the root|
|Abhishek T, Lokesh, Ajay reports to Pradeep|
|Shariq & Kaustabh reports to Abhishek|
|Mansi, Rachit & Himanshu reports to Lokesh|
|Anamol & Vivek reports to Ajay|
|Usman & Prerna reports to Anamol|
	And User click on select Reruiter dropdown
	And User as Pradeep is selected as Recruiter or Team
	Then Verify Team Column will show Pradeep
	Examples: 
      | ReportType   |
      | Recruiter |	  	    
      
  @id:10 @WIP @RMS2-3532
Scenario Outline: Verify a check box above ‘Generate Report’ or ‘Save’ Report
    Given User login to the application "requirementInbox" using "Superuser" of "UserType" user
	When User goes to the "<Report>" Report.
	Then Verify Overall filter is not displayed
	When User selected all Recruiter
	Then Verify a check box above ‘Generate Report’ or ‘Save’ Report is displayed.
	And Verify the check box is displayed as "Include data of deleted Recruiter"
	Examples: 
      | ReportType   |
      | Recruiter |
   
	  
	@id:11 @WIP @RMS2-3532
Scenario Outline: Verify details when “Include data of deleted Recruiter” is checked
    Given User login to the application "requirementInbox" using "Superuser" of "UserType" user
	When User goes to the "<Report>" Report.
	And User selected all Recruiter
	And User check the checkbox "Include data of deleted Recruiter"
	And User Select "Time Period" as "Last 7 Days"
	And User Generate the report.
	Then Verify  data of deleted recruiter if they had any activity in the selected duration
	
	Examples: 
      | ReportType  |
      | Recruiter |
	  
	  	@id:12 @WIP @RMS2-3532
Scenario Outline: Verify details of Requirement Creation data when “Include data of deleted Recruiter” is checked
    Given User login to the application "requirementInbox" using "Superuser" of "UserType" user
	When User goes to the "<Report>" Report.
	And User selected all Recruiter
	And User check the checkbox "Include data of deleted Recruiter"
	And User Select "Time Period" as "Last 90 Days"
	And User Generate the report.
	Then Verify data of deleted recruiter related to Requirement creation is displayed
	
	Examples: 
      | ReportType  |
      | Recruiter |
	  
@id:13 @WIP @RMS2-3532
Scenario Outline: Verify details of user which are Recruiters converted to HM,  when “Include data of deleted Recruiter” is checked
    Given User login to the application "requirementInbox" using "Superuser" of "UserType" user
	When User goes to the "<Report>" Report.
	And User selected all Recruiter
	And User check the checkbox "Include data of deleted Recruiter"
	And User Select "Time Period" as "Last 90 Days"
	And User Generate the report.
	Then Verify data of recruiters converted to HM is displayed
	
	Examples: 
      | ReportType  |
      | Recruiter |
	  
@id:14 @WIP @RMS2-3532
Scenario Outline: Verify details of user where RMS permission is revoked , when “Include data of deleted Recruiter” is checked
    Given User login to the application "requirementInbox" using "Superuser" of "UserType" user
	When User goes to the "<Report>" Report.
	And User selected all Recruiter
	And User check the checkbox "Include data of deleted Recruiter"
	And User Select "Time Period" as "Last 90 Days"
	And User Generate the report.
	Then Verify data of RMS permission is revoked  is displayed
	
	Examples: 
      | ReportType  |
      | Recruiter |	  
	 
	 @id:15 @WIP @RMS2-3532
Scenario Outline: Verify details of user who is deleted from Naukri , when “Include data of deleted Recruiter” is checked
    Given User login to the application "requirementInbox" using "Superuser" of "UserType" user
	When User goes to the "<Report>" Report.
	And User selected all Recruiter
	And User check the checkbox "Include data of deleted Recruiter"
	And User Select "Time Period" as "Last 90 Days"
	And User Generate the report.
	Then Verify data of  users who is deleted from Naukri is displayed
	
	
	
	Examples: 
      | ReportType  |
      | Recruiter | 
	  
	  
	  @id:16 @WIP @RMS2-3532
Scenario Outline: Verify details when Remove all deleted users from Recruiter Filter and “Include data of deleted Recruiter” is checked
    Given User login to the application "requirementInbox" using "Superuser" of "UserType" user
	When User goes to the "<Report>" Report.
	And User selected all Recruiter
	And User check the checkbox "Include data of deleted Recruiter"
	Then Verify the deleted user are visible as greyed out in recruiter dropdown
	When User mouse hover the greyed out user
	Then Verify “Recruiter <Recruiter Name or Email> doesn't exist in RMS currently is displayed
	And User Select "Time Period" as "Last 90 Days"
	And User Generate the report.
	Then Verify data of RMS permission is revoked  is displayed
	Then Verify data of recruiters converted to HM is displayed
	When User click on modify
	And User view Saved and Scheduled Report
	Then Verify the deleted user are visible as greyed out in recruiter dropdown
	When User mouse hover the greyed out user
	Then Verify “Recruiter <Recruiter Name or Email> doesn't exist in RMS currently is displayed
	
	
	
	Examples: 
      | ReportType  |
      | Recruiter | 
 
 @id:17 @WIP @RMS2-3532
Scenario Outline: Verify when “Include data of deleted Recruiter” is checked then details of user when report is displayed in downloaded report
    Given User login to the application "requirementInbox" using "Superuser" of "UserType" user
	When User goes to the "<Report>" Report.
	And User selected all Recruiter
	And User check the checkbox "Include data of deleted Recruiter"
	And User Select "Time Period" as "Last 90 Days"
	And User Generate the report
	And User download the report
	Then Verify the deleted user are visible as greyed out in recruiter dropdown
	When User mouse hover the greyed out user
	Then Verify “Recruiter <Recruiter Name or Email> doesn't exist in RMS currently is displayed
	
	
	
	Examples: 
      | ReportType  |
      | Recruiter | 
	  	      