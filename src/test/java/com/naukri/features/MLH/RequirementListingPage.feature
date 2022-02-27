Feature: Changes due to hierarchy in organisation on Requirement Listing Page

  @id:1 @MLHRequirementListing @MLH
  Scenario: On requirement listing page user sees filter by label
    Given I am logged in with "Enterprise" user "subuser2"
    When User is on "requirementInbox" page
    When User is on "requirementInbox" page
    Then I see "Filter by" label
    And I verify that "Open" status is selected by default
    And I verify that All source is selected by default
    And I verify that Recruiter's filter is present

  @id:2 @MLHRequirementListing @MLH
  Scenario: To verify that the recruiter who created the requirement can close the requirement and no other recruiter can close the requirement
    Given I am logged in with "Enterprise" user "subuser1"
    When User is on "requirementInbox" page
    And User is on "addANewRequirement" page
    And I create requirement with "Visible to Selected People" with "shariq.mlh@yopmail.com"
    And I logout
    And I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    And I search the requirement
    When User hover on "Modify" for above requirement
    When I click on close button
    Then I verify "You are not allowed to perform this action" as error message

  @id:3 @MLHRequirementListing @MLH
  Scenario: On requirement listing page user sees name of all the Sources for a requirement
    Given I am logged in with "Enterprise" user "subuser2"
    When User is on "requirementInbox" page
    And I click on drop down for Source's filter drop down
    Then I see name of all the Sources for a requirement

  @id:4 @MLHRequirementListing @MLH
  Scenario: On requirement listing page user sees name of all the States of a requirement
    Given I am logged in with "Enterprise" user "subuser2"
    When User is on "requirementInbox" page
    And I click on drop down for Status's filter drop down
    Then I see name of all the Status of a requirement

  @id:5 @MLHRequirementListing @MLH
  Scenario: On requirement listing page RM sees View Only label for requirement in which he is not part of
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "addANewRequirement" page
    And I create a requirement with "Visible to Only Me"
    And I logout
    And I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is present
    And I verify that I see View only label under the requirement
    And I verify that I see comment button icon under the requirement raised by my reportee
    And I verify that I can add comment for the requirement
    And I verify that I can delete my comment
    And I verify that Search label is present
    When User hover on "Search" for above requirement
    Then I verify that I see "Resdex" button is present
    And I verify that on clicking "Resdex" button I am redirected to respective page with page title as "Resdex"
    When User hover on "Search" for above requirement
    Then I verify that I see "My Database" button is present
    And I verify that on clicking "My Database" button I am redirected to respective page with page title as "All Profiles: : Search Result(s)"

  @id:6 @MLHRequirementListing @MLH @ToRun
  Scenario: Second level hierarchy RM should not be able to see requirement in which his reportee don't have visibility but his reportee is part of the group for that requirement.
    Given I am logged in with "Enterprise" user "subuser2"
    And User is on "groupListing" page
    And I created a group in which I mapped "Kaustubh" and "MansiHR" as HR
    And I logout
    And I am logged in with "Enterprise" user "kaustubh"
    And User is on "addANewRequirement" page
    And I create a requirement with "Visible to Only Me" with group
    And I logout
    And I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is not present
    And I logout
    And I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    And I search the requirement
    Then I verify that requirement is not present
    And I logout
    And I am logged in with "Enterprise" user "kaustubh"
    And User is on "requirementInbox" page
    And I search the requirement
    Then I verify that requirement is present
    And I logout
    And I am logged in with "Enterprise" user "abhishek"
    And User is on "requirementInbox" page
    And I search the requirement
    Then I verify that requirement is present
    And I verify that I see View only label under the requirement

  @id:7 @MLHRequirementListing @MLH @ToRun
  Scenario: Third level RM should not be able to see Requirement when he don't have visibility but he is the part of group mapped to requirement
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "groupListing" page
    And I created a group in which I mapped "MansiHR" and "Lokesh" as HR
    And User is on "addANewRequirement" page
    And I create a requirement with "Visible to Only Me"
    And I logout
    And I am logged in with "Enterprise" user "lokesh"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is not present
    And I logout
    And I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is present
    And I verify that I see View only label under the requirement

  @id:8 @MLHRequirementListing @MLH @ToRun
  Scenario: Requirement created by second level RM in which third and first level RM are mapped in group, then requirement with CTA should be visble to first and third level RM
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "groupListing" page
    And I created a group in which I mapped "shariq.mlh@yopmail.com" and "Lokesh" as HR
    And User is on "addANewRequirement" page
    And I create requirement with "Visible to All in Group"
    And I logout
    And I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is present
    And I verify that all call to action are present for Modify
    And I logout
    And I am logged in with "Enterprise" user "lokesh"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is present
    And I verify that all call to action are present for Modify
    And I verify that all call to action are present for status change under "Open"
    And I verify that all call to action are present for More Actions

  @id:9 @MLHRequirementListing @MLH @ToRun
  Scenario: To verify requirement is not visible to recruiter who is not in hirarchy of reportees and RM have view only permission of requirement
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "groupListing" page
    And I created a group in which I mapped HRName as HR
      | HRName  |
      | MansiHR |
      | Lokesh  |
    And User is on "addANewRequirement" page
    And I create requirement with "Visible to All in Group"
    And I logout
    And I am logged in with "Enterprise" user "subuser2"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is present
    And I verify that I see View only label under the requirement
    And I logout
    And I am logged in with "Enterprise" user "abhishek"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is not present
    And I logout

  @id:10 @MLHRequirementListing @MLH @ToRun
  Scenario: To verify that requirement is not displayed on listing page when recruiter is removed from requirement and also not visible to RM
    Given I am logged in with "Enterprise" user "subuser1"
    And User is on "groupListing" page
    And I created a group in which I mapped HRName as HR
      | HRName   |
      | MansiHR  |
      | Kaustubh |
    And User is on "addANewRequirement" page
    And I create requirement with "Visible to All in Group"
    And I logout
    And I am logged in with "Enterprise" user "kaustubh"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is present
    And I verify that all call to action are present for Modify
    And I verify that all call to action are present for status change under "Open"
    And I verify that all call to action are present for More Actions
    And I logout
    And I am logged in with "Enterprise" user "abhishek"
    And User is on "requirementInbox" page
    Then I verify that requirement is present
    And I verify that I see View only label under the requirement
    And I logout
    And I am logged in with "Enterprise" user "subuser1"
    And User is on "requirementInbox" page
    And I search the requirement
    And I click on edit button
    And click on "Visible to Only Me" in visibility DD
    And User click on "Add Requirement" button on requirement creation
    And User chose "Industy" as "Hotels/Restaurants/Airlines/Travel"
    And User chose "Functional Area" as "Banking / Insurance"
    And User chose "Role" as "Cash Officer"
    And User click on Save and Post Requirement on requirement page
    And I logout
    And I am logged in with "Enterprise" user "kaustubh"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is not present
    And I logout
    And I am logged in with "Enterprise" user "abhishek"
    And User is on "requirementInbox" page
    When I search the requirement
    Then I verify that requirement is not present

  @id:11 @wip
  Scenario: On requirement listing page user sees name of all the recruiters reporting to him under Recruiter's filter drop down
    Given I am logged in with user name as "MLH.Enterprise.RME_0" and password as "MLH.Enterprise.RME_0Password"
    When User is on "RMSProjectList" page
    And I click on drop down for recruiter's filter
    Then I see name of all the recruiters reporting directly or indirectly to me
