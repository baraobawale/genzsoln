@Demo14.10.2019 @UC_82
Feature: UC82_Authorization

  #Executable : Activate & Deactivate Session TAN
  # Session-TAN aktivieren & Deaktivieren
  Scenario Outline: <TestCase>
   Given User launches consorsbank web application
 		And User clicks on "Login"
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User clicks on "SessionTANAktivieren_MeinKontoDepot"
    And User select in checkbox "Ja_Mir_Sind" in "JaMirSind_SessionTANAktivieren"
    And User submits generated TAN number using "MobileTanLink_SessionTANAktivieren" on "TAN_SessionTANAktivieren"
    And User clicks on "SessionTANAktivieren_SessionTANAktivieren"
    And User clicks on "CloseWindow_SessionTANAktivieren"
    And User navigates to "Mein_Konto_Depot" in "Mein_Konto_Depot"
    And User clicks on "KaufenVerkaufen_kontouebersicht"
    And User selects "Orderart" in "Orderart_OrderErteilen"
    And User selects "Name_WKN_ISIN" in "NameWKNISIN_OrderErteilen"
    And User clicks on "Uebernehmen_OrderErteilen"
    And User selects "Handelsplatz" in "Handelsplatz_OrderErteilen"
    And User enters "NominalStueck_Betrag" in "NominalBetrag_OrderErteilen"
    And User clicks on "Weiter_OrderErteilen"
    And User clicks on "KostenpflichtigKaufen_OrderErteilen"
    And User clicks on "SessionTANDeaktivieren_OrderErteilen"
    And User clicks on "SessionTANDeaktivieren_SessionTANDeaktivieren"
    And User clicks on "CloseWindow_SessionTANAktivieren"
    Then Verify "SessionActivate_Link" is displayed on MeinKontoDepot

    Examples: 
      | TestCase               |
      | Session_TAN_Aktivieren |
