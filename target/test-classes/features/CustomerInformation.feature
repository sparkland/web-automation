Feature: Customer information is displayed via multiple banners on viewing the site

  As a customer
  I want to see detailed information
  So that I feel safe with the brand

  Background:
    Given I am on the "index" page

  Scenario: The COVID information banner contains the current information
    Given the COVID banner is visible
    When I see the following information associated with each header
      | Header      | Value                    |
      | APPOINTMENT | Arrive at scheduled time |
      | PROTECTION  | Wear a mask or covering  |
      | SANITISER   | Use on arrival           |
      | SPACE       | Keep distance            |
      | SICK        | Do not attend            |
    Then I can close the COVID banner successfully

  Scenario: The Cookie banner is visible and can be interacted with
    Given the Cookie banner is visible
    And the "Accept" option is selectable
    And the "Reject" option is selectable
    And the "Privacy policy" option is selectable
    When I select "Privacy policy"
    Then I am on the "privacy-policy" page