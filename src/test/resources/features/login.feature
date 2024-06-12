Feature: login functionality
  As a user, I should be able to login

  Background: login menu
    Given user is on the home page
    When user clicks on the login menu

  Scenario: positive login test1
    When user enters valid credentials and clicks on the login button
    Then verify that user can see username


  Scenario: positive login test with parameters
    When user enters "mustafa68" username "Test12345" password and clicks on the login button
    Then verify that user can see "mustafa68" username

  Scenario Outline: positive login test DDT
    When user enters "<username>" username "<password>" password and clicks on the login button
    Then verify that user can see "<username>" username
    Examples:
      | username  | password  |
      | mustafa68 | Test12345 |
      | batch16fy | 54321     |
      | batch16   | Test123-  |

  Scenario Outline: positive login test DDT with dataTable
    When user enters following credentials
      | username | <username> |
      | password | <password> |
    Then verify that user can see "<username>" username
    Examples:
      | username  | password  |
      | mustafa68 | Test12345 |
      | batch16fy | 54321     |
      | batch16   | Test123-  |