
  Feature: Test OrangeHRM Login Page

    Scenario Outline: Check login with wrong credentials
      Given Open login page
      When User enters invalid credentials <username> and <password>
      And Clics on login button
      Then The validation <message> is displayed

      Examples:
        | username | password | message |
        | Admin | 1234 | Invalid credentials |
        | admin | admin | Invalid credentials |
        |       | xyz | Username cannot be empty |
        | admin | | Password cannot be empty |

    Scenario: Check logo on login page
      Given Open login page
      When The page is loaded
      Then Logo is visible on login page

