@UC27
Feature: UC27_DepotUebertrag

  #Executable - Depot Transfer Internally
  #The depot account should have open position not transfered.!!
  
 # Depot Uebertrag
  Scenario Outline: <TestCase>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
   And User submits generated TAN number in "TAN_field_Login"    
    #When User submits generated Mobile TAN number
    And User navigates to "DepotUebertrag" in "Mein_Konto_Depot"
    And User clicks on "DepotUebertragIntern_DepotUebertrag"
    And User selects radiobutton "Ohne_Glaeubigerwechsel" in "OhneGlaeubigerwechsel_DepotUebertrag"
    And User clicks on "Weiter_DepotUebertrag"
    And User selects "FromDepot_Nr" in "Depot_Nr_DepotUebertrag"
    And User selects radiobutton "Empfaengerkonto" in "Empfaengerkonto_DepotUebertrag"
    And User enters "Depotinhaber_Vorname" in "DepotinhaberVorname_DepotUebertrag"
    And User enters "Depotinhaber_Nachname" in "DepotinhaberNachname_DepotUebertrag"
    And User enters "ToDepot_Nr" in "DepotNr_DepotUebertrag"
    And User clicks on "Weiter_DepotUebertrag"
    And User enters "zu_uebertragende_Stueke" in "zuuebertragendeStueke_Positionwaehlen"
    And User selects checkbox "Ich_habe_diesen_Hinweis_zur_Kenntnis_genommen" in "IchhabediesenHinweiszurKenntnisgenommen_Positionwaehlen"
    And User clicks on "Weiter_Positionwaehlen"
    And Capture entered details on Depotuebertrag
    And User submits generated TAN number in "TAN_Depotuebertrag"
    And User clicks on "Bestaetign_Depotuebertrag"
    Then Verify the message
    And Verify the captured details from Depotuebertrag	

    Examples: 
      | TestCase              |
      | DepotUebertrag_Intern |
