Feature: Test a successful login

  Scenario: Successful login
    Given A cloud login page with text boxes to enter details
    When I add email as "test@tester.com" and password as "1234"
    Then the login should be successful and redirect me to the welcome page
