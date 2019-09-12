Feature: UC71_Datenschutz

  @RTA
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User clicks on "Einloggen"
    And User submits generated TAN number in "TAN_field"
    And User clicks on "BestaetigenButton"
    And User navigates to "Mein_Konto_Depot" in "Mein_Datenschutz"
    And User "check" in "E-Mail_informiert" field
    And User "check" in "telefonisch_informiert" field
    And User "check" in "meine_Bewegungen" field
    And User clicks on "Bestaetigen"
    Then Verify error messages with unselected mark displayed on Mein Datenchutz

    Examples: 
      | TestCase                                     | ExpectedResult |
      | Datenschutz_select_Notificationtype_unselect | All_Unselected |

 @RTA
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User clicks on "Einloggen"
    And User submits generated TAN number in "TAN_field"
    And User clicks on "BestaetigenButton"
    And User navigates to "Mein_Konto_Depot" in "Mein_Datenschutz"
    And User "check" in "E-Mail_informiert" field
    And User "check" in "telefonisch_informiert" field
    And User "check" in "meine_Bewegungen" field
    And User clicks on "Bestaetigen"
    Then Verify error messages with selected mark displayed on Mein Datenchutz

    Examples: 
      | TestCase                                   | ExpectedResult |
      | Datenschutz_select_Notificationtype_select | All_Selected   |
