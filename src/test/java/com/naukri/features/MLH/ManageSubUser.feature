#Author: gupta.mansi@naukri.com
@wip
Feature: This feature contains all the scenarios related to manage subuser/recruiter, hm or fm at RMS end

  @id:1 @RMS2-3112
  Scenario: Verify that superuser cannot edit alias of users from RMS
    Given I am logged in with <subscription> superuser account
    And I am on manage recruiter page of RMS
    When I click on edit button for any <user type>
    Then I verify that I cannot edit name of the <user type>
      | subscription | user type      |
      | Enterprise   | recruiter      |
      | Enterprise   | hiring manager |
      | Consultant   | recruiter      |
      | Consultant   | fm+recruiter   |
      | Consultant   | fm             |

  @id:2 @RMS2-3112
  Scenario: Verify that user name in RMS is same as alias name in MNR, if alias name is present in MNR
    Given I am logged in with <subscription> superuser account
    And I am on manage subuser page in MNR
    And I edit the first <user type> tuple
    And I fill the alias name for the first <user type>
    And I save it
    And I am on manage <user type> page in RMS
    And I search the <user type> name
    When I click on edit button
    And I verify that name is same as alias name in MNR
    And I verify that I cannot edit name of <user type>
    And I verify that I cannot edit RM
      | subscription | user type    |
      | Enterprise   | recruiter    |
      | Consultant   | recruiter    |
      | Consultant   | fm+recruiter |

  @id:3 @RMS2-3112
  Scenario: Verify that user name in RMS is same as username in MNR, if alias name is not present in MNR
    Given I am logged in with <subscription> superuser account
    And I am on manage subuser page in MNR
    And I edit the first <user type> tuple
    And I clear the alias name for the first <user type>
    And I save it
    And I am on manage <user type> page in RMS
    And I search the <user type> name
    When I click on edit button
    And I verify that name is same as username name in MNR
    And I verify that I cannot edit name of <user type>
    And I verify that I cannot edit RM
      | subscription | user type    |
      | Enterprise   | recruiter    |
      | Consultant   | recruiter    |
      | Consultant   | fm+recruiter |

  @id:4 @RMS2-3112
  Scenario: Verify that hiring/finance manager name in RMS is same as alias name in MNR, if alias name is present in MNR
    Given I am logged in with <subscription> superuser account
    And I am on manage subuser page in MNR
    And I edit the first <user type> tuple
    And I fill the alias name for the first <user type>
    And I save it
    And I am on manage <user type> page in RMS
    And I search the <user type> name
    When I click on edit button
    And I verify that name is same as alias name in MNR
    And I verify that I cannot edit name of <user type>
    And I verify that there is no reporting manager field is present
      | subscription | user type      |
      | Enterprise   | hiring manager |
      | Consultant   | fm             |

  @id:5 @RMS2-3112
  Scenario: Verify that hiring manager name in RMS is same as username in MNR, if alias name is not present in MNR
    Given I am logged in with <subscription> superuser account
    And I am on manage subuser page in MNR
    And I edit the first <user type> tuple
    And I clear the alias name for the first <user type>
    And I save it
    And I am on manage <user type> page in RMS
    And I search the <user type> name
    When I click on edit button
    And I verify that name is same as username name in MNR
    And I verify that I cannot edit name of <user type>
    And I verify that there is no reporting manager field is present
      | subscription | user type      |
      | Enterprise   | hiring manager |
      | Consultant   | fm             |

  @id:6 @RMS2-3112
  Scenario: Verify that for user in RMS who is not reporting to anyone, also do not have editable name and reporting manager field
    Given I am logged in with <subscription> superuser account
    And I am on manage subuser page in MNR
    And I add new <user type> who don't have any RM
    And I am on manage <user type> page in RMS
    And I search the <user type> name
    When I click on edit button
    And I verify that I cannot edit name of <user type>
    And I verify that I cannot edit RM
      | subscription | user type    |
      | Enterprise   | recruiter    |
      | Consultant   | recruiter    |
      | Consultant   | fm+recruiter |

  @id:7 @RMS2-3112
  Scenario: Verify that if alias for user is edited in MNR then that changed is reflected in RMS
    Given I am logged in with <subscription> superuser account
    And I am on manage subuser page in MNR
    And I click on edit button for first tuple for <user type>
    And I change alias name for the first <user type>
    And I save it
    And I am on manage <user type> page in RMS
    And I search the <user type> name
    When I click on edit button
    Then I verify that name is same as alias name in MNR
    And I verify that I cannot edit name of <user type>
    And I verify that I cannot edit RM
      | subscription | user type      |
      | Enterprise   | recruiter      |
      | Enterprise   | hiring manager |
      | Consultant   | recruiter      |
      | Consultant   | fm+recruiter   |
      | Consultant   | fm             |

  @id:8 @RMS2-3112
  Scenario: Verify that if RM for user is edited in MNR then that changed is reflected in RMS
    Given I am logged in with <subscription> superuser account
    And I am on manage subuser page in MNR
    And I click on edit button for first tuple for <user type>
    And I change RM for the first <user type>
    And I save it
    And I am on manage <user type> page in RMS
    And I search the <user type> name
    When I click on edit button
    Then I verify that RM name is same as RM name in MNR
    And I verify that I cannot edit name of <user type>
    And I verify that I cannot edit RM
      | subscription | user type    |
      | Enterprise   | recruiter    |
      | Consultant   | recruiter    |
      | Consultant   | fm+recruiter |
