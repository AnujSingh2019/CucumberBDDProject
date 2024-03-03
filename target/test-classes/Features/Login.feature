Feature: Login

@Sanity
  Scenario: To test that user is able to login with valid user credentials
    Given user launch Chrome Browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and enters Password as "admin"
    And clicks on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When user clicks on Logout link
    Then Page Title should be "Your store. Login"
    And Close Browser

   @regression 
   Scenario Outline: To test that user is able to login with valid user credentials
    Given user launch Chrome Browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "<email>" and enters Password as "<password>"
    And clicks on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When user clicks on Logout link
    Then Page Title should be "Your store. Login"
    And Close Browser
    
    Examples: 
    |email|password|
    |admin@yourstore.com|admin|
    |test@yourstore.com|admin|