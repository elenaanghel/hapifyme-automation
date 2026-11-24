Feature: Feed post functionality

  As a logged-in user
  I want to publish a new post
  So that other users can see my message

  Background:
    Given I am logged in to HapifyMe

  Scenario: Create a new post
    When I create a post with the following message "Automation testing with Selenide"
    Then the post should be visible on the feed