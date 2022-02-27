Feature: Test Scenarios of RMS1-6001 Configuration - Part 1 - View Partners Part 2 - Configure Partners and Part 4 - Request Demo

  Background: 
    Given User login to the application "settingsPage" using "Superuser" of "Enterprise5" user

  @id:1 @ViewPartners @PartnersUnconfigured @partnerAssessment
  Scenario: Verify Manage Integrations and Assessment Partner Integration is visible in Settings and lands on assessment partners listing
    Then User verify Manage Integration option is visible
    Then User verify Assessment Partner Integration option is visible
    And User click on Assessment Partner Integration Assessment
    Then Verify User lands on Partner listing page
    Then User verify partner's list is in alphabetical order or not
    And User verify all three partners are listed in the listing

    
  @id:2 @ViewPartners @PartnersUnconfigured @partnerAssessment
  Scenario Outline: Verify the content of Assessments partners if present
    Then User click on Assessment Partner Integration Assessment
    And User verify that "<partner>" is present and unconfigured
    And User verify the "SubText" for "<partner>"
    And User verify the "Description" for "<partner>"
    And User verify the links for "<partner>" in the description
    Examples:
      | partner           |
      | Codility          |
      | HackerEarth       |
      | Naukri Assessments |


  @id:3 @ViewPartners @wip
  Scenario: Verify ER is shown as configured if FN subscription present
    Then User click on Assessment Partner Integration Assessment
    And User Verify ER is shown as configured if FN subscription present
    
  @id:4 @ConfigurePartners @Docker @TestDBInteraction @Codility
  Scenario: Verify key value pair is stored in Master table for Codility
    Then User click on Assessment Partner Integration Assessment
    And User delete the entry from client_account table if HE already configured
      | Key       | Value  |
      | clientId  | 168613 |
      | partnerId |    3   |
    And User click on each Configure "Codility"
    And User fill and submit configure light box for "Codility" with correct credentials
	  | Api key |
      | MEtbanE46K7JYFx40GiD |
    And User validate "Codility" is shown configured
    Then User validate entry is made in client_account table in database
      | Key       | Value  |
      | clientId  | 168613 |
      | partnerId |    3   |
    

  @id:5 @ConfigurePartners @Docker @TestDBInteraction
  Scenario: Verify key value pair is stored in Master table for HackerEarth
    Then User click on Assessment Partner Integration Assessment
    And User delete the entry from client_account table if HE already configured
      | Key       | Value  |
      | clientId  | 168613 |
      | partnerId | 2      |
    And User click on each Configure "HackerEarth"
    And User fill and submit configure light box for HackerEarth with correct credentials
      | client_id                                                        | client_secret                            |
      | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
    And User validate "HackerEarth" is shown configured
    Then User validate entry is made in client_account table in database
      | Key       | Value  |
      | clientId  | 168613 |
      | partnerId | 2      |

  @id:6 @ConfigurePartners @PartnersUnconfigured @partnerAssessment
  Scenario Outline: Verify error message is displayed on entering incorrect config values for partners
    Then User click on Assessment Partner Integration Assessment
    And User click on each Configure "<partner>"
    And User verify number of fields in configuration light box for "<partner>"
    And User fill and submit configure light box for "<partner>" with incorrect credentials
      | client_id | client_secret | Api key |
      | test      | test          | test    |
    Then User validate the error message for "<partner>" configuration failure

    Examples:
      | partner     |
      | Codility    |
      | HackerEarth |


  @id:7 @ConfigurePartners @HEunconfigured
  Scenario: Verify name of labels for HackerEarth
    Then User click on Assessment Partner Integration Assessment
    And User click on each Configure "HackerEarth"
    And User verify both the labels in configuration light box

  @id:8 @ConfigurePartners @Docker
  Scenario: Verify success message is displayed on entering correct key value pair for HE
    Then User click on Assessment Partner Integration Assessment
    And User delete the entry from client_account table if HE already configured
      | Key       | Value       |
      | clientId  |      168613 |
      | partnerId | hackerearth |
    And User click on each Configure "HackerEarth"
    And User fill and submit configure light box for HackerEarth with correct credentials
      | client_id                                                        | client_secret                            |
      | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
    And User validate "HackerEarth" is shown configured
    Then User validate the success message for HackerEarth configuration

    

  @id:9 @ConfigurePartners @partnerAssessment
  Scenario: Verify configure button for Naukri Assessments is not present
    Then User click on Assessment Partner Integration Assessment
    And User verify Naukri Assessments is displayed
    And User verify configure button not present for Naukri Assessments

  @id:10 @RequestDemo @HEunconfigured
  Scenario: Verify a separate page is visible for request Demo
    Then User click on Assessment Partner Integration Assessment
    Then User move to Marketing tour page for "HackerEarth" from Assessment partner Integration
    Then User click on "Request a demo" button on marketing page
    Then User verifies that Request Demo page is displayed

  @id:11 @RequestDemo @wip
  Scenario: Verify Request demo information is redirecting to specific email ids
    Then User click on Assessment Partner Integration Assessment
    Then User move to Marketing tour page for "HackerEarth" from Assessment partner Integration
    Then User click on "REQUEST A DEMO" button on marketing page
    Then user submit the Request Demo Form
    And User verify success message is displayed.
    And User verify the information is visible on support@hackerearth.com
    And User verify same information is displayed on our support email id rmshelpdesk@naukri.com , kaur.amanpreet@naukri.com

  @id:12 @RequestDemo @HEunconfigured
  Scenario: Verify feilds are displayed on Request demo form
    Then User click on Assessment Partner Integration Assessment
    Then User move to Marketing tour page for "HackerEarth" from Assessment partner Integration
    Then User click on "REQUEST A DEMO" button on marketing page
    Then User Verify "Full Name" field is displayed
    And User Verify "Work Email Address" field is displayed
    And User Verify "Designation" field is displayed
    And User Verify "Company Name" field is displayed
    And User Verify "Phone Number" field is displayed
    And User Verify " REQUEST NOW " button is displayed

  @id:13 @RequestDemo @HEunconfigured
  Scenario: Verify regex check on phone and email
    Then User click on Assessment Partner Integration Assessment
    Then User move to Marketing tour page for "HackerEarth" from Assessment partner Integration
    Then User click on "REQUEST A DEMO" button on marketing page
    Then User verifies that Request Demo page is displayed
    And User verify Phone Number is accepting valid data
      | 9999999999 |
    And User Verify Phone Number with invalid digits gives proper Error message
      | 999051 |
    And User verify Work Email Address field with valid email
      | abc@yopmail.com |
    And User verify Work Email Address field with invalid email gives proper error
      | abcde.com |

  @id:14 @RequestDemo @HEunconfigured
  Scenario: Verify Mandatory field on Request Demo page RMS1-6004
    Then User click on Assessment Partner Integration Assessment
    Then User move to Marketing tour page for "HackerEarth" from Assessment partner Integration
    Then User click on "REQUEST A DEMO" button on marketing page
    Then User verify error message is displayed for mandatory fields if submitted empty

  @id:15 @RequestDemo @Docker
  Scenario: Verify user is able to submit the request Demo form RMS1-6004
    Then User click on Assessment Partner Integration Assessment
    Then User move to Marketing tour page for "HackerEarth" from Assessment partner Integration
    Then User click on "REQUEST A DEMO" button on marketing page
    Then user submit the Request Demo Form
    And User verify success message is displayed.

  @id:16 @RequestDemo @HEunconfigured
  Scenario: Verify madatory fields are marked with asterik
    Then User click on Assessment Partner Integration Assessment
    Then User move to Marketing tour page for "HackerEarth" from Assessment partner Integration
    Then User click on "REQUEST A DEMO" button on marketing page
    Then user verify mandatory fields labels are followed by Asterik
    
   @id:17 @ConfigurePartners @Docker @TestDBInteraction
  Scenario: Verify key value pair is stored in Master table for HackerEarth
    Then User click on Assessment Partner Integration Assessment
    And User delete the entry from client_account table if HE already configured
      | Key       | Value       |
      | clientId  |      168613 |
      | partnerId | hackerearth |
    And User click on each Configure "HackerEarth"
    And User fill and submit configure light box for HackerEarth with correct credentials
      | client_id                                                        | client_secret                            |
      | 41e777e1e60e105555a6106290d626a53cfe11cb0fa4.api.hackerearth.com | 88d4e7a41c342d9ef13c5a0ddfbd2581f46beac3 |
    And User validate "HackerEarth" is shown configured
    Then User validate entry is made in client_account table in database
      | Key       | Value       |
      | clientId  |      168613 |
      | partnerId | hackerearth |

    