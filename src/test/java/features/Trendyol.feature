@DEMO
Feature: BBC test automation scenarios
  A collection of test scenarios for BBC, demonstrating capabilities of Mobileib

  @Universal
  Scenario: Universal Step
    A Scenario where universal step interactions are tested
    * Click listed element Turkey from countries list on the MainScreen
    * Click the genderSelectionMaleButton on the MainScreen
    * Click the tooltipCloseButton on the MainScreen
    * Click the searchInput on the MainScreen
    * Fill the searchInput on the MainScreen with text: parfume
    * Click listed element Sedef Parfümeri from searchResults list on the MainScreen
    * Click the homePageTabButton on the MainScreen
    * Wait 5 seconds