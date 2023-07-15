@Login_Feature
Feature: Login page feature

  # use this website: https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/
  # or use the below link
  # https://magento.softwaretestingboard.com/customer/account/
  # use creds: arkobiswas@gmail.com // Password@12345
  Scenario: Login page title
    Given I am on login page
    When I get the title of the page
    Then page title should be "Customer Login"

  Scenario: Forgot Password link
    Given I am on login page
    Then forgot password link should be displayed

 