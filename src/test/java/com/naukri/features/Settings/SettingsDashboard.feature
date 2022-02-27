Feature: Settings Dashboard

  @Settings @testraunak
  Scenario: verify list of settings visible to Enterprise Superuser
    When "Enterprise" user is on Settings Page with "Superuser2"
    Then user is able to see all sub headings on settings page
      | Requirement Settings      |
      | Sub User Settings         |
      | Account Settings          |
      | Profile Settings          |
      | Offer Generation Settings |
      | Manage Sources            |
    Then user is able to see all settings name on setting page
      | Manage Groups                           |
      | Manage Questionnaires                   |
      | Manage Email Templates                  |
      | Manage Download Tracker                 |
      | Manage Requirements                     |
      | Manage Feedback Forms                   |
      | Manage Approval Processes               |
      | Manage Requisition Templates            |
      | Manage Recruiters                       |
      | Manage Hiring Managers/Interviewers     |
      | Manage Your Profile                     |
      | Manage Requirement id & Requisition id  |
      | Manage White labelling Settings         |
      | Manage Blog                             |
      | Customize the Selection Process         |
      | Manage Automatic CV Back Up Settings    |
      | Manage Reports                          |
      | Manage Uploads and Duplicate Settings   |
      | Manage Documents                        |
      | Offer Generation Rules & Salary Breakup |
      | Offer Document Templates                |
      | Offer Generation Module On/Off          |
      | Manage Job BoardsBETA                   |
      | Manage VendorsBETA                      |
      | Manage External Sources                 |

  @Settings
  Scenario: verify list of settings visible to Enterprise Subuser
    When "Enterprise" user is on Settings Page with "Subuser2"
    Then user is able to see all sub headings on settings page
      | Requirement Settings      |
      | Account Settings          |
      | Offer Generation Settings |
      | Manage Sources            |
    Then user is able to see all settings name on setting page
      | Manage Groups                           |
      | Manage Questionnaires                   |
      | Manage Email Templates                  |
      | Manage Download Tracker                 |
      | Manage Feedback Forms                   |
      | Manage Approval Processes               |
      | Manage Requisition Templates            |
      | Manage Your Profile                     |
      | Manage Blog                             |
      | Manage Reports                          |
      | Offer Generation Rules & Salary Breakup |
      | Offer Document Templates                |
      | Manage VendorsBETA                      |
      | Manage External Sources                 |

  @Settings
  Scenario: verify list of settings visible to Consultant Superuser
    When "Consultant" user is on Settings Page with "Superuser"
    Then user is able to see all sub headings on settings page
      | Requirement Settings |
      | Sub User Settings    |
      | Account Settings     |
      | Profile Settings     |
      | Manage Sources       |
    Then user is able to see all settings name on setting page
      | Manage Employer                       |
      | Manage Questionnaires                 |
      | Manage Email Templates                |
      | Manage Tracker                        |
      | Manage Watermark on Forwarded CVs     |
      | Manage Requirements                   |
      | Manage Sub Users                      |
      | Manage Your Profile                   |
      | Manage White labelling Settings       |
      | Customize the Selection Process       |
      | Manage Automatic CV Back Up Settings  |
      | Manage Reports                        |
      | Invoice Settings                      |
      | Manage Uploads and Duplicate Settings |
      | Manage Documents                      |
      | Manage Job BoardsBETA                 |
      | Manage Vendors                        |
      | Manage External Sources               |

  @Settings
  Scenario: verify list of settings visible to Consultant Subuser
    When "Consultant" user is on Settings Page with "Subuser"
    Then user is able to see all sub headings on settings page
      | Requirement Settings |
      | Account Settings     |
      | Manage Sources       |
    Then user is able to see all settings name on setting page
      | Manage Employer                   |
      | Manage Questionnaires             |
      | Manage Email Templates            |
      | Manage Tracker                    |
      | Manage Watermark on Forwarded CVs |
      | Manage Your Profile               |
      | Manage Reports                    |
      | Manage Vendors                    |
      | Manage External Sources           |

  @Settings
  Scenario: verify list of settings visible to Company Superuser
    When "Company" user is on Settings Page with "Superuser"
    Then user is able to see all sub headings on settings page
      | Requirement Settings |
      | Sub User Settings    |
      | Account Settings     |
      | Profile Settings     |
      | Manage Sources       |
    Then user is able to see all settings name on setting page
      | Manage Groups                         |
      | Manage Questionnaires                 |
      | Manage Email Templates                |
      | Manage Download Tracker               |
      | Manage Requirements                   |
      | Manage Sub Users                      |
      | Manage Your Profile                   |
      | Manage White labelling Settings       |
      | Manage Blog                           |
      | Customize the Selection Process       |
      | Manage Automatic CV Back Up Settings  |
      | Manage Reports                        |
      | Manage Uploads and Duplicate Settings |
      | Manage Documents                      |
      | Manage Job BoardsBETA                 |
      | Manage Vendors                        |
      | Manage External Sources               |

  @Settings
  Scenario: verify list of settings visible to Company Subuser
    When "Company" user is on Settings Page with "Subuser"
    Then user is able to see all sub headings on settings page
      | Requirement Settings |
      | Account Settings     |
      | Manage Sources       |
    Then user is able to see all settings name on setting page
      | Manage Groups           |
      | Manage Questionnaires   |
      | Manage Email Templates  |
      | Manage Download Tracker |
      | Manage Your Profile     |
      | Manage Blog             |
      | Manage Reports          |
      | Manage Vendors          |
      | Manage External Sources |
