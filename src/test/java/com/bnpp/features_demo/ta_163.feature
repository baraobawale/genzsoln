Feature: TA-163
Scenario Outline: <TestCase>
Given User launches consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User navigates to "Persoenliche_Einstellungen" in "Mein_Konto_Depot"
    And User clicks on "Risikoklasse/Finanztermingeschaefte_PersoenlicheEinstellungen"
    And User clicks on "RisikoklasseJetztAendern_RisikoklasseFinanztermingeschaefte"
    And User selects "Hinweis_gelesen" in "HinweisGelesen_RisikoklasseFinanztermingeschaefte"
    And User selects "Kenntnisse_vorhanden" in "KenntnisseVorhanden_RisikoklasseFinanztermingeschaefte"
    And User selects "Wertpapierkaeufe" in "WertpapierkaeufeInDenLetztenZweiJahren_RisikoklasseFinanztermingeschaefte"
    And User clicks on "Weiter_RisikoklasseFinanztermingeschaefte"
    And User clicks on checkbox "TAN_bestaetigung" in "TANBestaetigung_RisikoklasseFinanztermingeschaefte"
    And User enters generated TAN number in "mobile_TAN_field"
    And User clicks on "RisikoklasseFinanztermingeschaefte_Bestaetigen"
    Then verify success message shown on bestaetigung page

    Examples: 
      | TestCase                 |
      | Risikoklasse_Verify_Save |