Feature: Messing about with a second feature

  As a customer
  I want to see detailed information
  So that I feel safe with the brand

  Background:
    Given I am on the "index" page

  Scenario: The Cookie information banner contains the current information
    Given the Cookie banner is visible
    Then I can close the Cookie banner successfully