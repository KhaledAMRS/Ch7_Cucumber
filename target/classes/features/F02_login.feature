@regression
Feature: testing login functionality

  @smoke
  Scenario: user could login with valid credentials
    Given user navigate to home page
    And user go to login page
    When user enter valid email and password in login page
    And user click on loginBtn


  Scenario: user could login with invalid credentials
    Given user navigate to home page
    And user go to login page
    When user enter valid email and password in login page
    And user click on loginBtn
