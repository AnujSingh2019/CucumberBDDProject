Feature: Add Customer

  Background: 
    Given user launch Chrome Browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and enters Password as "admin"
    And clicks on Login
    Then user can view Dashboard

  @Sanity
  Scenario: Add a new customer
    When user clicks on Customer Menu
    And clicks on Customer Menu Item
    And Click on Add New button
    Then user can view Add New Customer page
    When user enters customer info
    And clicks on Save button
    Then user can view confirmation message "The new customer has been added successfully"
    And Close Browser

  @regression
  Scenario: Search an existing customer by Email
    When user clicks on Customer Menu
    And clicks on Customer Menu Item
    When user enters email address
    And clicks on Search button
    Then user can view  Customer details in page
    And Close Browser

  @regression
  Scenario: Search an existing customer by Name
    When user clicks on Customer Menu
    And clicks on Customer Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When clicks on Search button
    Then User should found Name in the Search table
    And Close Browser
