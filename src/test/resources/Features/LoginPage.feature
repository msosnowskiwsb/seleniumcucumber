
  Feature: Test OrangeHRM Login Page

    Scenario Outline: Check login with wrong credentials
      Given Open login page
      When User enters <username> and <password>
      And Clics on login button
      Then The validation message is displayed

      Examples:
        | username | password |
        | Admin | 1234 |
        | admin | admin |