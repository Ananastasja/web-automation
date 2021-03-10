Feature: Search

  @search
  Scenario Outline: Search Tests
    Given I open Search page
    When I apply value <value> to the filter <filter>
    Then I see the value <value> is applied
    And I see the right filter <filter> results


    Examples:
      | value  | filter |
      | weiß   | Farbe  |
      | silber | Farbe  |
      | AEG    | Marke  |
      | Based  | Marke  |

