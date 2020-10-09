Feature: Foreign currency exchange rates api with currency conversion

  Scenario: Checking status code
    Given Rates API for Latest Foreign Exchange rates
    When The API is available
    Then Validte the code

  Scenario: checking response
    Given Rates API for Latest Foreign Exchange rates
    When The API is available
    Then Validte the response

  Scenario: checking error response
    Given Rates API for Latest Foreign Exchange rates
    When An incorrect or incomplete url is provided
    Then Validte the correct response

  Scenario: Foreign Exchange rates
    Given Rates API for Specific date Foreign Exchange rates
    When The API is available for foreign
    Then success status

  Scenario: Foreign Exchange rates latest
    Given Rates API for Specific date Foreign Exchange rates
    When The API is available for foreign
    Then response assertion

  Scenario: Foreign Exchange rates of today
    Given Rates API for Specific date Foreign Exchange rates
    When A future date is provided in the url
    Then future validation
