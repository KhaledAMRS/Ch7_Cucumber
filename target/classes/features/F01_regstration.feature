@regression
Feature: testing signup functionality


  Scenario: user could create new account with valid data (positive scenario)
    Given user navigate to home page
    And user go to register page
    When user select gender
    And user enter valid firstname "khaled" and "ramadan" lastname
    And user choose date of birth day "2" month "March" year "1992"
    And user enter valid email
    And mark on Newletters checkbox
    And user enter password "P@ssw0rd" & confirm password "P@ssw0rd"
    And user click on Register btn
    Then new account is created successfully


