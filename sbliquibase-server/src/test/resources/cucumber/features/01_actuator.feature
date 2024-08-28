@burpScan
Feature: Check the health status
  Background:
    Given that all URLs are relative to "/actuator"
    And that all file paths are relative to "cucumber/features/01_actuator/"

  Scenario: Unauthenticated try to access health check
    When executing a GET call to "/health"
    Then I ensure that the status code of the response is 200
    And I ensure that the body of the response is equal to
    """
    { "status" : "UP" }
    """

  @bdd_lib_json_ignore_extra_fields
  Scenario: Unauthenticated try to access application info
    When executing a GET call to "/info"
    Then I ensure that the status code of the response is 200
    And I ensure that the body of the response is equal to
    """
    {
      "build": {
         "version": "${json-unit.ignore}"
      }
    }
    """
