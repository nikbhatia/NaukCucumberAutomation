Feature: To Verify video URL in branding options

  @id:1 @RMS  @JPFormInRms
  Scenario: Verify user is able to see ‘Add Video URL’ drop down field in branding options.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User fill in the keywords as "java"
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User post a "Naukri Private Job"
  And User choose first address
  And User select the questionnaire from list
  Then User should be able to see Add Video URL drop down field and "Add New Video" link in branding options
  And Add Video URL drop down field should be non mandatory
  And User should be able to see "Add Video URL" label
  And Add Video URL drop down field should be displayed after "Presentation" field
  
  @id:2 @RMS @JPFormInRms
  Scenario: Verify user is able to only one video from ‘Add Video URL’ drop down in branding options.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User fill in the keywords as "java"
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User post a "Naukri Private Job"
  And User choose first address
  And User select the questionnaire from list
  And User click on Add Video URL drop down field
  And select first video URL from list
  Then User should not be able to select second video from list
  
 @id:3 @RMS @JPFormInRms
  Scenario: Verify user is able to see all videoes in ‘Add Video URL’ drop down in branding options.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User fill in the keywords as "java"
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User post a "Naukri Private Job"
  And User choose first address
  And User select the questionnaire from list
  And User click on "Add New Video" link
  And User switches to new window
  And User click on "Delete" button for delete all the added video or photos
  And User click on "Add URL" button and add video urls
  |https://www.youtube.com/watch?v=Q6VRbYkNqW0&list=RDQ6VRbYkNqW0&start_radio=1|
  |https://www.youtube.com/watch?v=O4f6TavtnnY|
  |https://www.youtube.com/watch?v=nj5rRgFaiGA|
  |https://www.youtube.com/watch?v=6nUJNRIaDW0|
  |https://www.youtube.com/watch?v=rXbV2AhMhbs|
  And User count total Number of Added video
  And User switches to parent window
  When User click on "Refresh List" link against "Add Video URL" field  
  And User click on Add Video URL drop down field
  Then User should be able to see all the videos link added by Superuser
  
  @id:4 @RMS @JPFormInRms
  Scenario: Verify user is able to see thumbnail corresponding to that video url.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User fill in the keywords as "java"
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User post a "Naukri Private Job"
  And User choose first address
  And User select the questionnaire from list
  And User click on Add Video URL drop down field
  And select first video URL from list
  Then User should be able to see thumbnail of corresponding URL
  When User should be able to click on thumbnail
  And User switches to new window
  Then User should be land on video URL in a new Tab
  
  @id:5 @RMS @JPFormInRms
  Scenario: Verify user is able to remove attached video url.
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User fill in the keywords as "java"
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User post a "Naukri Private Job"
  And User choose first address
  And User select the questionnaire from list
  And User click on Add Video URL drop down field
  And select first video URL from list
  And User remove the video link from video dropdown
  Then Attached video should be remove and no video should be attached with job
  
  @id:6 @RMS @JPFormInRms @fail
  Scenario: Verify user is able to see 2 links with the ‘Add Video URL’ drop down field
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User fill in the keywords as "java"
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User post a "Naukri Private Job"
  Then User should be able to see "Refresh List" link in branding options with "Add Video URL" field
  When User click on "Add New Video" link
  And User switches to new window
  Then User should be rediected on the Naukri add video URL "/manageVideoUrl/manage"
  And User count total Number of Added video
  And User switches to parent window
  When User click on "Refresh List" link against "Add Video URL" field
  And User click on Add Video URL drop down field
  Then User should be able to see all the videos link added by Superuser
  
  
  @id:7 @RMS @JPFormInRms
  Scenario: Verify user is able to see all attached thumbnail on Requirement preview page
  Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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
  And User fill in the "minExp" as "2" years of experience
  And User fill in the "maxExp" as "3" years of experience
  And User fill in the keywords as "java"
  And User fill in the job location as "Delhi,Ahmedabad"
  And User click on "Add Requirement" button on requirement creation
  And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  And User chose "Functional Area" as "Banking / Insurance"
  And User chose "Role" as "Cash Officer"
  And User post a "Naukri Private Job"
  And User choose first address
  And User select the questionnaire from list
  And User click on Add Video URL drop down field
  And select first video URL from list
  And User click on Preview button on requirement page
  Then User should be able to see all the attached "Video" on preview page as thumbnail
  And User should be able to see text "View" on attached "Video"
  When User click on "Video" thumbnail
  And User switches to new window
  Then User should be land on video URL in a new Tab
  
  @id:8 @RMS @JPFormInRms
  Scenario: Verify user is able to see all attached thumbnail on JP form
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User post a "Naukri Private Job"
    And User choose first address
    And User select the questionnaire from list
    And User click on Add Video URL drop down field
    And select first video URL from list
    And User click on Save and Post Requirement on requirement page
    When User click on GNB option "Naukri"
    And I select a "Manage Jobs & Responses" from "Jobs & Responses" option on Naukri GNB
    And User edit the recent created job on MJR
    And User click on company details edit button
    Then User should be able to see video thumbnail on the job
    
    
    @id:9 @RMS @JPFormInRms
  Scenario: Verify user is able to see all attached thumbnail on JD page
    Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
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
    And User fill in the "minExp" as "2" years of experience
    And User fill in the "maxExp" as "3" years of experience
    And User fill in the keywords as "java"
    And User fill in the job location as "Delhi,Ahmedabad"
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User post a "Naukri Private Job"
    And User choose first address
    And User select the questionnaire from list
    And User click on Add Video URL drop down field
    And select first video URL from list
    And User click on Save and Post Requirement on requirement page
    And User click on "View" action of "Naukri Private Job"
  	And User switches to new window
  	Then User should be able to see the thumbnail on JD page
  	
  	
  #@id:9 @manual
  #Scenario: Verify user is able to click on Add link only once at a time
    #Given User login to the application "rmsDashboardPage" using "Superuser" of "Enterprise" user
   #When I select a "Add A New Requirement" from "Requirements" option
    #And User fill in the requirement title
    #And User click on "Employment Type" field
    #And User select an option "Full Time, Freelance/Homebased" from list
    #And User fill in the job title
    #And User fill in the Job Description
    #And User fill in the Candidate Description
    #And I select the currency of CTC as "INR"
    #And User fill in the "minCTC" as "5,00,000"
    #And User fill in the "maxCTC" as "7,00,000"
    #And User fill in the "minExp" as "2" years of experience
    #And User fill in the "maxExp" as "3" years of experience
    #And User fill in the keywords as "java"
    #And User fill in the job location as "Delhi,Ahmedabad"
    #And I click on "Add Requirement" button on requirement creation
     #And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
  #And User chose "Functional Area" as "Banking / Insurance"
  #And User chose "Role" as "Cash Officer"
    #And User post a "Naukri Private Job"
    #And User choose first address
    #And User select the questionnaire from list
    #Then User is able to see 2 links "Refresh" and  "Add" with ‘Add Video URL’ drop down field
    #When User click on "Add" link
    #Then User should be able to click on 'Add' link only once at a time
