@TradeKauf
Feature: UC17_18_19_20_21_TradingKauf

  #Executable - Aktie,Fonds,Anleihe - Anlegen, Aendern, loeschen (Zertifikat & Optionsschein Data pending)
  #Kauf Anlegen (Anleihe,Aktie) | Anleihe Limit - 90% & Aktie Limit - 105%
  @DeleteTradingKauf
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Mein_Konto_Depot" in "Mein_Konto_Depot"
    And User clicks on "KaufenVerkaufen_kontouebersicht"
    And User clicks on "Orderart"
    And User enters "Name_WKN_ISIN" in "NameWKNISIN_OrderErteilen"
    And User clicks on "Uebernehmen_OrderErteilen"
    And User clicks on "Handelsplatz_OrderErteilen"
    #And User clicks on "Handelsplatz_Tradegate"
    And User clicks on "Handelsplatz_BaaderBank"
    And User enters "NominalStueck_Betrag" in "NominalBetrag_OrderErteilen"
    And User clicks on "Limithandel_OrderErteilen"
    And User selects "Ordertyp" in "Ordertyp_OrderErteilen"
    #And User enters "Limit" in "Limit_OrderErteilen"
    And User enters "Limit" in "Stop_OrderErteilen"
    And User selects "Gueltigkeit" in "Gueltigkeit_OrderErteilen"
    And User clicks on "WeiterTANEingabe_OrderErteilen"
    And User submits generated TAN number using "MobileTanLink_OrderErteilen" on "TAN_field_OrderErteilen"
    And User clicks on "KostenpflichtigKaufen_OrderErteilen"
    And Capture entered details on OrderErteilen
    And Capture Message on OrderErteilen
    And User clicks on "ZumOrderUebersicht_OrderErteilen"
    Then Verify "Orderart","WKN","NominalStueck_Betrag","Ordertyp","Handelsplatz" on OrderUebersicht
    And Verify captured details,Message from OrderErteilen

    Examples: 
      | TestCase                |
      # | KaufOrder_Anlegen_Anleihe |
      | KaufOrder_Anlegen_Aktie |

  #Kauf Andern (Aktie) | Order Status - Offen ,
  @TDK
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Mein_Konto_Depot" in "Mein_Konto_Depot"
    And User clicks on "Orderuebersicht_kontouebersicht"
    And User clicks on "Edit"
    #of "Created_WKN","Status" in "CreatedWKN_OrderUebersicht" with "Status_OrderUebersicht"
    And User clicks on "Limithandel_OrderErteilen"
    And User enters "NominalStueck_Betrag" in "NominalBetrag_OrderErteilen"
    And User enters "Limit" in "Limit_OrderAendern"
    And User clicks on "WeiterTANEingabe_OrderAendern"
    And User submits generated TAN number using "MobileTanLink_OrderAendern" on "TAN_field_OrderAendern"
    And User clicks on "OrderAendern_OrderAendern"
    Then Verify Message,details on OrderAendern

    Examples: 
      | TestCase                 |
      | KaufOrder_Anendern_Aktie |

  #Kauf Anlegen (Fonds - 632995) |
  @UC17_
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Mein_Konto_Depot" in "Mein_Konto_Depot"
    And User clicks on "KaufenVerkaufen_kontouebersicht"
    And User clicks on "Orderart"
    And User enters "Name_WKN_ISIN" in "NameWKNISIN_OrderErteilen"
    And User clicks on "Uebernehmen_OrderErteilen"
    And User clicks on "Handelsplatz_OrderErteilen"
    And User clicks on "Handelsplatz_Fondsgesellschaft"
    And User enters "NominalStueck_Betrag" in "NominalBetrag_OrderErteilen"
    And User clicks on "WeiterTANEingabe_OrderErteilen"
    And User submits generated TAN number using "MobileTanLink_OrderErteilen" on "TAN_field_OrderErteilen"
    And User clicks on "KostenpflichtigKaufen_OrderErteilen"
    And Capture entered details on OrderErteilen
    And Capture Message on OrderErteilen
    And User clicks on "ZumOrderUebersicht_OrderErteilen"
    Then Verify "Orderart","WKN","NominalStueck_Betrag","Ordertyp","Handelsplatz" on OrderUebersicht
    And Verify captured details,Message from OrderErteilen

    Examples: 
      | TestCase                 |
      | KaufOrder_Anlegen_Fonds1 |

  #Kauf Anlegen (Fonds - 984811) | STOP : 105%
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Mein_Konto_Depot" in "Mein_Konto_Depot"
    And User clicks on "KaufenVerkaufen_kontouebersicht"
    And User clicks on "Orderart"
    And User enters "Name_WKN_ISIN" in "NameWKNISIN_OrderErteilen"
    And User clicks on "Uebernehmen_OrderErteilen"
    And User clicks on "Handelsplatz_OrderErteilen"
    And User clicks on "Handelsplatz_Tradegate"
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
    And User clicks on "KostenpflichtigKaufen_OrderErteilen"
    And Capture entered details on OrderErteilen
    And Capture Message on OrderErteilen
    And User clicks on "ZumOrderUebersicht_OrderErteilen"
    Then Verify "Orderart","WKN","NominalStueck_Betrag","Ordertyp","Handelsplatz" on OrderUebersicht
    And Verify captured details,Message from OrderErteilen

    Examples: 
      | TestCase                 |
      | KaufOrder_Anlegen_Fonds2 |

  #Kauf loeschen (Aktie,Fond) | Order Status - Offen
  @DeleteTradingKauf
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Mein_Konto_Depot" in "Mein_Konto_Depot"
    And User clicks on "Orderuebersicht_kontouebersicht"
    And User click on "Delete" of "Created_WKN","Status" in "CreatedWKN_OrderUebersicht" with "Status_OrderUebersicht"
    And User submits generated TAN number using "MobileTanLink_OrderLoeschen" on "TAN_field_OrderLoeschen"
    And User clicks on "OrderStreichen_OrderLoeschen"
    Then Verify Message on OrderLoeschen

    Examples: 
      | TestCase                 |
      | KaufOrder_Loeschen_Aktie |
    #  | KaufOrder_Loeschen_Fond  |
