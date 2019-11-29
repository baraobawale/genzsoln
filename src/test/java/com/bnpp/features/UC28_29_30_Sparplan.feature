@UC28
Feature: UC28_29_30_Sparplan

  #Executable - Sparplan(Anlegen,Aendern,Loeschen) and Einmalzahlung(Anlegen,Loeschen)
  #Create/anlegen
  @UC28_1
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Sparplaene_1" in "Mein_Konto_Depot"
    And User clicks on "NeuesSparplanAnlengen_UebersichtSparplaene"
    And User enters "WKN/Name/ISIN" in "WKN/Name/ISIN_SparplanAnlegen"
    And User clicks on "Weiter_SparplanAnlegen"
   # And User selects checkbox "Risikoklasse" in "Hoehere_Risikoklasse"
    And User selects checkbox "Verkaufsunterlage" in "Verkaufsunterlage_SparplanAnlegen"
    And User selects checkbox "InformationFuerDenVerbraucher" in "InformationFuerDenVerbraucher_SparplanAnlegen"
    And User selects "Kategorie" in "Kategorie_SparplanAnlegen"
    And User enters "Name" in "Name_SparplanAnlegen"
    And User selects byValue "Sparintervall" in "Sparintervall_SparplanAnlegen"
    And User selects byValue "Immer_Am" in "Immer_am_SparplanAnlegen"
    And User enters Laufzeit_von in "Laufzeit_von_SparplanAnlegen"
    And User enters "Sparrate" in "Sparrate_SparplanAnlegen"
    And User selects byValue "Dynamik" in "Dynamik_SparplanAnlegen"
    And User selects byValue "Zum_Date" in "Zum_Date_SparplanAnlegen"
    And User selects byValue "Zum_Month" in "Zum_Month_SparplanAnlegen"
    And User selects radiobutton "kontodaten_angeben_mit" in "kontodaten_SparplanAnlegen"
    And User clicks on "SearchIBAN_SparplanAnlegen"
    And User clicks and selects "IBAN_SparplanAnlegen" in IBAN
    And User clicks on "Weiter__SparplanAnlegen"
    And User submits generated TAN number using "MobileTanLink_SparplanAnlegen" on "TAN_field_SparplanAnlegen"
    And User clicks on "SparplanAnlegenKostenpflichtigKaufen_SparplanAnlegen"
    And Capture entered details on SparplanAnlegen
    And Capture Message on SparplanAnlegen
    And User clicks on "ZurSparplaeneUebersicht_SparplanAnlegen"
    Then Verify "Name","WKN","Sparrate" on  UebersichtSparplaene
    And Verify captured details,Message from SparplanAnlegen

    Examples: 
      | TestCase         |
      | Sparplan_Anlegen |

  #Update/aendern
  @UC28_2
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Sparplaene_1" in "Mein_Konto_Depot"
    And user selects "Aktionen" of "Created_Sparplan" in "CreatedSparplan_UebersichtSparplaene"
    #And User selects checkbox "Risikoklasse" in "Hoehere_Risikoklasse"
    And User selects byValue "Sparintervall" in "Sparintervall_SparplanAendern"
    And User selects byValue "Immer_Am" in "ImmerAm_SparplanAendern"
    And User enters Laufzeit_von in "Laufzeit_von_SparplanAendern"
    And User selects byValue "Zum_Date" in "ZumDate_SparplanAendern"
    And User selects byValue "Zum_Month" in "ZumMonth_SparplanAendern"
    And User clicks on "Weiter_SparplanAendern"
    And User submits generated TAN number using "MobileTanLink_SparplanAendern" on "TAN_field_SparplanAendern"
    And User clicks on "Bestaetigen_SparplanAendern"
    Then Verify details,message on SparplanAendern

    Examples: 
      | TestCase         |
      | Sparplan_Aendern |

  # Create_Onetime-Payment/SparplanMitEinmalzahlung_Anlegen
  @UC28_3
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Sparplaene_1" in "Mein_Konto_Depot"
    And user selects "Aktionen" of "Created_Sparplan" in "CreatedSparplan_UebersichtSparplaene"
    And User enters "Betrag" in  "Betrag_EinmalzahlungFuerSparplan"
    And User enters "Ausfuhrung_am" in "AusfuhrungAm_EinmalzahlungFuerSparplan"
    And User selects radiobutton "Kontodaten_angeben_mit" in "KontodatenAngebenMin_EinmalzahlungFuerSparplan"
    And User clicks on "SearchIBAN_EinmalzahlungFuerSparplan"
    And User clicks and selects "IBAN_EinmalzahlungFuerSparplan" in IBAN
    And User clicks on "Weiter_EinmalzahlungFuerSparplan"
    And User submits generated TAN number using "MobileTanLink_EinmalzahlungFuerSparplan" on "TAN_field_EinmalzahlungFuerSparplan"
    And User clicks on "KostenpflichtigKaufen_EinmalzahlungFuerSparplan"
    Then Verify message,details on EinmalzahlungFuerSparplan

    Examples: 
      | TestCase                       |
      | Sparplan_Einmalzahlung_Anlegen |

  #Delete_Onetime-Payment/SparplanMitEinmalzahlung_loeschen
  @UC28_4
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Sparplaene_1" in "Mein_Konto_Depot"
    And user selects "Aktionen" of "Created_Sparplan" in "CreatedSparplan_UebersichtSparplaene"
    #And User clicks on "Delete_Einmalzahlung" in "IhreAuftragsuebersicht_AuftragsübersichtFuerSparplan"
    And User clicks on "Delete_Einmalzahlung"
    And User selects checkbox "Ja_ich_moechte_sparplan_loeschen" in "JaIchMoechteSparplanLoeschen_LoeschungDerEinmalzahlung"
    And User submits generated TAN number using "MobileTanLink_LoeschungDerEinmalzahlung" on "TAN_field_LoeschungDerEinmalzahlung"
    And User clicks on "weiter_LoeschungDerEinmalzahlung"
    Then Verify message on LoeschungDerEinmalzahlung

    Examples: 
      | TestCase                        |
      | Sparplan_Einmalzahlung_Loeschen |

  #Change_Security/Sparplan mit Wertpapierwechsel
  @UC28_5
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Sparplaene_1" in "Mein_Konto_Depot"
    And user selects "Aktionen" of "Created_Sparplan" in "CreatedSparplan_UebersichtSparplaene"
    And User enters "WKN/Name/ISIN" in "WKN/Name/ISIN_WertpapierwechselFuerSparplan"
    And User clicks on "weiter_WertpapierwechselFuerSparplan"
    And User selects checkbox "Verkaufsunterlage" in "Verkaufsunterlage_WertpapierwechselFuerSparplan"
    And User selects checkbox "InformationFuerDenVerbraucher" in "InformationFuerDenVerbraucher_WertpapierwechselFuerSparplan"
    And User submits generated TAN number using "MobileTanLink_WertpapierwechselFuerSparplan" on "TAN_field_WertpapierwechselFuerSparplan"
    And User clicks on "KostenpflichtigWertpapierwechseln_WertpapierwechselFuerSparplan"
    Then Verify message,details on WertpapierwechselFuerSparplan

    Examples: 
      | TestCase                   |
      | Sparplan_Wertpapierwechsel |

  #Delete/Sparplan_loeschen
  @UC28_6
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Sparplaene_1" in "Mein_Konto_Depot"
    And user selects "Aktionen" of "Created_Sparplan" in "CreatedSparplan_UebersichtSparplaene"
    And User clicks on "loeschung_AuftragsUebersichtFuerSparplan"
    And User selects checkbox "Ja_ich_moechte_sparplan_loeschen" in "JaIchMoechteSparplanLoeschen_LoeschungSparplan"
    And User submits generated TAN number using "MobileTanLink_LoeschungSparplan" on "TAN_field_LoeschungSparplan"
    And User clicks on "Bestaetigen_LoeschungSparplan"
    And Capture Message on LoeschungSparplan
    And User clicks on "ZurSparplaeneUebersicht_LoeschungSparplan"
    Then Verify captured Message from LoeschungSparplan
    And Verify Created Sparplan is not displayed

    Examples: 
      | TestCase          |
      | Sparplan_Loeschen |
