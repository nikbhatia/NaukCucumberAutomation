Feature: Manage WatermarkOnCV

  Background: 
    Given "Consultant" user is on Settings Page with "Superuser"

  @Settings
  Scenario:RMS user is able to see all headings and labels on manage watermark page
    When user click on " Manage Watermark on Forwarded CVs " link
    Then verify that user is able to see the listed headings on page
      | Manage Watermark on Forwarded CVs                                                                                             |
      | Add watermark on all pages of the CV                                                                                          |
      | Configure position and opacity of the watermark                                                                               |
      | If switched OFF, a front page will be added to every CV and company logo will be placed on top-left corner of the front page. |

  @Settings111
  Scenario: RMS user is able to turn on feature if it is off
    When user click on " Manage Watermark on Forwarded CVs " link
    And user turn on add watermark setting and set it at default position and opacity
    Then verify that user is able to see the listed headings on page
      | Configure Recruitment Management System |
