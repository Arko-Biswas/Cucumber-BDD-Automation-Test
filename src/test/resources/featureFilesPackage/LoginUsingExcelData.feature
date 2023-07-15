@Login_UsingExcelData_feature
Feature: Login page feature

  # use this website: https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/
  # or use the below link
  # https://magento.softwaretestingboard.com/customer/account/
  # use creds: arkobiswas@gmail.com // Password@12345
  Scenario Outline: Login with correct credentials
    Given I am on login page
    When I enter username and password from sheetname "<SheetName>" and rownumber <RowNumber>
    And I click on Sign In button
    Then I get the title of the page
    And page title should be "My Account"

    Examples: 
      | SheetName | RowNumber |
      | loginData |         0 |
      | loginData |         1 |
