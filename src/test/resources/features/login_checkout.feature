@smoke
Feature: User Login and Checkout Flow
  As a user
  I want to login, add items to cart, and complete checkout
  So that I can purchase products

  Scenario: Complete checkout flow with backpack
    Given user lands on login page
    When user enters "standard_user" and "secret_sauce"
    And user adds "Backpack" to cart
    And user clicks Cart icon
    And user clicks Checkout
    And user enters details "John", "Doe", "12345" and continues
    Then verify "Thank You" message appears

