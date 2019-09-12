Feature: UC69_70_Risikoklasse

  @RTA
  Scenario Outline: <TestCase> <ExpectedResult>
     When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User clicks on "Einloggen"
    And User submits generated TAN number in "TAN_field"
    And User clicks on "BestaetigenButton"
    And User navigates to "Mein_Konto_Depot" in "Persoenliche_Einstellungen"
    And User clicks on "Risikoklasse/Finanztermingeschaefte"
    And User clicks on "Risikoklasse_jetzt_aendern"
    And User "check" in "Hinweis_gelesen" field
    And User "check" in "Kenntnisse_vorhanden" field
    And User "check" in "Wertpapierkufe_in_den_letzten_zwei_Jahren" field
    And User clicks on "Weiter"
    Then Verify if ErrorMesssages are displayed on Risikoklasse

    Examples: 
      | TestCase                                | ExpectedResult |
      | Risikoklasse_error_blankmandatoryfields | Verify Errors  |

  @RTA
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User clicks on "Einloggen"
    And User submits generated TAN number in "TAN_field"
    And User clicks on "BestaetigenButton"
    And User navigates to "Mein_Konto_Depot" in "Persoenliche_Einstellungen"
    And User clicks on "Risikoklasse/Finanztermingeschaefte"
    And User clicks on "Risikoklasse_jetzt_aendern"
    And User "check" in "Hinweis_gelesen" field
    And User "check" in "Kenntnisse_vorhanden" field
    And User "check" in "Wertpapierkufe_in_den_letzten_zwei_Jahren" field
    And User clicks on "Weiter"
    And User "check" in "TAN-bestaetigung" field
    And User submits generated TAN number in "mobile_TAN_field"
    And User clicks on "Bestaetigen_button"
    Then "Ihre_Angaben_wurden_erfolgreich_gespeichert_und_ausgewertet" is present

    Examples: 
      | TestCase                         | ExpectedResult |
      | Risikoklasse_set_mandatoryfields | Verify Save    |
