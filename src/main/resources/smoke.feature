Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario: Check cannot sign in with invalid email
    Given User opens main page
    When User clicks sign in button
    And User enters invalid email in the field
    And User clicks continue button
    Then User checks that error message appears

  Scenario: Check change the language
    Given User opens main page
    When User clicks language button
    And User clicks Deutsch language
    And User clicks save changes button
    Then User checks that current url contains chosen language

  Scenario: Check sign in with valid email and password
    Given User opens main page
    When User clicks sign in button
    And User enters valid email in the field
    And User clicks continue button
    And User enters valid password in the field
    And User clicks sign in button to continue
    Then User checks that his name on the page

  Scenario: Check add product to wishlist
    Given User opens main page
    And User clicks sign in button
    And User enters valid email in the field
    And User clicks continue button
    And User enters valid password in the field
    And User clicks sign in button to continue
    When User makes search by keyword
    And User clicks search button
    And User clicks on needed product
    And User clicks wish list on product
    Then User checks that product added to wishlist

  Scenario: Check delete product from wishlist
    Given User opens main page
    And User clicks sign in button
    And User enters valid email in the field
    And User clicks continue button
    And User enters valid password in the field
    And User clicks sign in button to continue
    When User clicks sign in button
    And User clicks on section lists
    And User clicks on delete item
    Then User checks that product deleted

  Scenario: Check add product to cart
    Given User opens main page
    And User clicks sign in button
    And User enters valid email in the field
    And User clicks continue button
    And User enters valid password in the field
    And User clicks sign in button to continue
    When User makes search by other keyword
    And User clicks search button
    And User clicks on first product
    And User clicks on add to cart button
    Then User checks that product added to cart

  Scenario: Check delete product from cart
    Given User opens main page
    And User clicks sign in button
    And User enters valid email in the field
    And User clicks continue button
    And User enters valid password in the field
    And User clicks sign in button to continue
    When User clicks on cart button
    And User deletes product from cart
    Then User checks that cart is empty

  Scenario: Check filters works correctly
    Given User opens main page
    When User clicks on catalog
    And User clicks on electronics category
    And User clicks on phones and accessories
    And User clicks on filter Ailun
    Then User checks that names of products in the page contains Ailun

  Scenario: Check error appears when create account with invalid email
    Given User opens main page
    And User clicks sign in button
    When User clicks button to create account
    And User enters name in field
    And User enters invalid email in the field
    And User enters valid password in the field
    And User re-enters password
    And User clicks continue button
    Then User checks that error appears under email field

  Scenario: Check error appears when create account without name
    Given User opens main page
    And User clicks sign in button
    When User clicks button to create account
    And User enters valid email in the field
    And User enters valid password in the field
    And User re-enters password
    And User clicks continue button
    Then User checks that error appears under name field

