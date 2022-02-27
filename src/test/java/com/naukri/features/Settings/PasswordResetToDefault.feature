Feature: Reset Account Password to default

  @PasswordReset
  Scenario Outline: Reset password
   Given I login into RMS as an "<UserName>" user
   When User rest the password to default password
   And User logout from application
   Examples: 
      | UserName |
      | anima.taraiya@naukri.com/P@ssw0rd0987|
      | lokesh.agrawal@naukri.com/P@ssw0rd0987|
      | singh.avinash@naukri.com/P@ssw0rd0987|
      | rmspro_consultant@naukri.com/P@ssw0rd0987|
      | rmspro_company@naukri.com/P@ssw0rd0987|
      | enterprise_subuser1@naukri.com/P@ssw0rd0987|
      
      

		