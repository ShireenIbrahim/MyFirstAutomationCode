Feature: User Registration
  User can register on the e-commerce system

  Scenario: User Register successfully
    Given Home page open
    When I click on the register link
    And Fill the user data
    Then User register 