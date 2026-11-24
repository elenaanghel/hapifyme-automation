Feature: Login functionality

  As a HapifyMe user
  I want to authenticate into the application
  So that I can access my account

  Scenario: Successful login
    Given I am on the HapifyMe login page
    When I login using valid credentials
    Then I should access the application feed

  Scenario Outline: Unsuccessful login
    Given I am on the HapifyMe login page
    When I login with username "<username>" and password "<password>"
    Then I should see a login error message

    Examples:
      | username          | password       |
      | invalid@email.com | wrong_password |
      |                   | wrong_password |
      | invalid@email.com |                |
      |                   |                |