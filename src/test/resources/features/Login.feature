# Login.feature

Feature: User Login

  Scenario: Successful Login
    Given the user navigates to the login page
    When the user enters the credentials from the config file
    And clicks the login button
    Then the user should be logged in successfully

# Scenario: Unsuccessful Login (Invalid Credentials)
#   Given the user navigates to the login page
#   When the user enters the credentials from the config file
#   And clicks the login button
##   Then the user should be on the login page
