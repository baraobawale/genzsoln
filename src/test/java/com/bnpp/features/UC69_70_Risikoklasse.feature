
Feature: UC69_70_Risikoklasse

  #Executable - Risikoklasse/FTG setzen (mit Fehlermeldungen)
  # Risikoklasse/FTG Setzen Fehlermeldungen
  Scenario Outline: <TestCase>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Persoenliche_Einstellungen" in "Mein_Konto_Depot"
    And User clicks on "Risikoklasse/Finanztermingeschaefte_PersoenlicheEinstellungen"
    And User clicks on "RisikoklasseJetztAendern_RisikoklasseFinanztermingeschaefte"
    And User selects "Hinweis_gelesen" in "HinweisGelesen_RisikoklasseFinanztermingeschaefte"
    And User selects "Kenntnisse_vorhanden" in "KenntnisseVorhanden_RisikoklasseFinanztermingeschaefte"
    And User selects "Wertpapierkaeufe" in "WertpapierkaeufeInDenLetztenZweiJahren_RisikoklasseFinanztermingeschaefte"
    And User clicks on "Weiter_RisikoklasseFinanztermingeschaefte"
    Then Verify displayed ErrorMesssages on RisikoklasseFinanztermingeschaefte

    Examples: 
      | TestCase                   |
      | Risikoklasse_Verify_Errors |

  # Risikoklasse/FTG Setzen
  Scenario Outline: <TestCase>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Persoenliche_Einstellungen" in "Mein_Konto_Depot"
    And User clicks on "Risikoklasse/Finanztermingeschaefte_PersoenlicheEinstellungen"
    And User clicks on "RisikoklasseJetztAendern_RisikoklasseFinanztermingeschaefte"
    And User selects "Hinweis_gelesen" in "HinweisGelesen_RisikoklasseFinanztermingeschaefte"
    And User selects "Kenntnisse_vorhanden" in "KenntnisseVorhanden_RisikoklasseFinanztermingeschaefte"
    And User selects "Wertpapierkaeufe" in "WertpapierkaeufeInDenLetztenZweiJahren_RisikoklasseFinanztermingeschaefte"
    And User clicks on "Weiter_RisikoklasseFinanztermingeschaefte"
    And User clicks on checkbox "TAN_bestaetigung" in "TANBestaetigung_RisikoklasseFinanztermingeschaefte"
    And User submits generated TAN number in "TAN_field_Vorlageloeschen"
    And User clicks on "Bestaetigen_RisikoklasseFinanztermingeschaefte"
    Then verify success message shown on bestaetigung page

    Examples: 
      | TestCase                 |
      | Risikoklasse_Verify_Save |
