#Author: your.email@your.domain.com
Feature: Mobile Purchase
  I want to use this template for my feature file

  Scenario: Title of your scenario
    Given Go to flipcart page
    And skip the login bar
    When User search for mobile
    And user enter the mobile name and click
    Then User click the buy now option

     Scenario: Title of your scenario
    Given Go to flipcart page
    And skip the login bar
    When User search for mobile by one dim list
    |iPhone|Samsung|realme|
    And user enter the mobile name and click
    Then User click the buy now option
    
    
    
     Scenario: Title of your scenario by map
    Given Go to flipcart page
    And skip the login bar
    When User search for mobile by one dim map
    |iPhone|iPhone|
    |sam|Samsung|
     |realme|realme|
    And user enter the mobile name and click
    Then User click the buy now option
    