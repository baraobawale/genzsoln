 @UC22
Feature: UC22_23_24_25_26_TradingVerkauf

  #Non Executable - Aktie,Fonds,Anleihe Verkauf - Anlegen, Aendern, loeschen (Zertifikat & Optionsschein Data pending)
  #Kauf Anlegen (Fonds - 984811) | STOP : 105%
  #Need to purchase fond before selling
  @UC22_1
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Mein_Konto_Depot" in "Mein_Konto_Depot"
    And User clicks on "KaufenVerkaufen_kontouebersicht"
    And User clicks on "Orderart"
    And User enters "Name_WKN_ISIN" in "NameWKNISIN_OrderErteilen"
    And User clicks on "Uebernehmen_OrderErteilen"
    And User selects value "Handelsplatz_Tradegate" in "Handelsplatz_OrderErteilen"
    And User enters "NominalStueck_Betrag" in "NominalBetrag_OrderErteilen"
    And User clicks on "Limithandel_OrderErteilen"
    And User selects "Ordertyp" in "Ordertyp_OrderErteilen"
    And User enters "Stop" in "Stop_OrderErteilen"
    And User enters "Abstand" in "Abstand_OrderErteilen"
    And User selects checkbox "Toleranz_Nach_Stop_Hinzufuegen" in "ToleranzNachStopHinzufuegen_OrderErteilen"
    And User enters "Toleranz_Nach_Stop" in "ToleranzNachStop_OrderErteilen"
    And User selects "Gueltigkeit" in "Gueltigkeit_OrderErteilen"
    And User clicks on "WeiterTANEingabe_OrderErteilen"
    And User submits generated TAN number using "MobileTanLink_OrderErteilen" on "TAN_field_OrderErteilen"
    And User clicks on KostenpflichtigKaufen_OrderErteilen
    And Capture entered details on OrderErteilen_Kauf
    And Capture Message on OrderErteilen_Kauf
    And User clicks on "ZumOrderUebersicht_OrderErteilen"
    Then Verify "Orderart","WKN","NominalStueck_Betrag","Ordertyp","Handelsplatz" on OrderUebersicht_Kauf
    And Verify captured details,Message from OrderErteilen_Kauf

    Examples: 
      | TestCase                |
      | KaufOrder_Anlegen_Fonds |

  @UC22_2
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Mein_Konto_Depot" in "Mein_Konto_Depot"
    And User clicks on "KaufenVerkaufen_kontouebersicht"
    And User clicks on "Orderart_TradingVerkauf"
    And User enters "Name_WKN_ISIN" in "NameWKNISIN_OrderErteilen"
    And User clicks on "Uebernehmen_OrderErteilen"
    And User selects value "Handelsplatz_Tradegate" in "Handelsplatz_OrderErteilen"
    And User enters "NominalStueck_Betrag" in "NominalStueck_Betrag_OrderErteilen_TradingVerkauf"
    And User clicks on "Limithandel_OrderErteilen"
    And User selects "Ordertyp" in "Ordertyp_OrderErteilen"
    And User enters "Stop" in "Stop_OrderErteilen"
    And User enters "Abstand" in "Abstand_OrderErteilen"
    And User selects checkbox "Toleranz_Nach_Stop_Hinzufuegen" in "ToleranzNachStopHinzufuegen_OrderErteilen"
    And User enters "Toleranz_Nach_Stop" in "ToleranzNachStop_OrderErteilen"
    And User selects "Gueltigkeit" in "Gueltigkeit_OrderErteilen"
    And User clicks on "WeiterTANEingabe_OrderErteilen"
    And User submits generated TAN number using "MobileTanLink_OrderErteilen" on "TAN_field_OrderErteilen"
    And User clicks on "KostenpflichtigKaufen_OrderErteilen_TradingVerkauf"
    And Capture entered details on OrderErteilen_TradingVerkauf
    And Capture Message on OrderErteilen_TradingVerkauf
    And User clicks on "ZumOrderUebersicht_OrderErteilen"
    Then Verify "Orderart","WKN","NominalStueck_Betrag","Ordertyp","Handelsplatz" on OrderUebersicht_TradingVerkauf
    And Verify captured details,Message from OrderErteilen_TradingVerkauf

    Examples: 
      | TestCase                   |
      | VerkaufOrder_Anlegen_Fonds |
