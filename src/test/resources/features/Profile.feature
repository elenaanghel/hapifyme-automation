Feature: User profile functionality

  As a logged-in user
  I want to search for another user
  So that I can view their profile

  Background:
    Given I am logged in to HapifyMe

  Scenario: Search and open another user's profile
    When I search for user "live tester"
    And I open the profile
    Then I should see the profile of "live tester"