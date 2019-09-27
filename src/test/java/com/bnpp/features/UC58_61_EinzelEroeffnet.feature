@UC58_61
Feature: UC58_61_EinzelEroeffnet

  #Executable - Inhaber Einzelkonto Eroeffnet Konto Depot /Tagesgeld Einzelkonto (Single account holder opens trading account/call to money account)
  #Eroeffnet Konto Depot
  @UC58_61
  Scenario Outline: <TestCase>
    When User open an application
    And User navigates to "Wertpapierdepot" in "Wertpapierhandel"
    And User clicks on "Wertpapierdepot_eroeffnen"
    And User selects radiobutton "Kunde_bei_der_Consorsbank" in "KundeBeiDerConsorsbank_WertpapierdepotEroeffnen"
    And User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User selects radiobutton "Gemeinschaftskonto_eroeffnen" in "GemeinschaftskontoEroeffnen_WertpapierdepotEroeffnen"
    And User selects radiobutton "minderjaehriges_Kind_eroeffnen" in "minderjaehrigesKindEroeffnen_WertpapierdepotEroeffnen"
    And User clicks on "Weiter_WertpapierdepotEroeffnen"
    And User clicks on "WeiterZurAntragsstrecke_KundeninformationZumDatenschutz"
    And User selects radiobutton "USA_Steuerpflichtig" in "USASteuerpflichtig_AngabenZurPerson"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA" in "AnsaessigkeitAusserhalbDeutschlandsUSA_AngabenZurPerson"
    And User enters "EMail_wiederholen" in "EMailWiederholen_AngabenZurPerson"
    And User enters "Telefon_privat" in "TelefonPrivat_AngabenZurPerson"
    And User selects radiobutton "Erfahrungen_im_Bereich_Wertpapierhande" in "ErfahrungenImBereichWertpapierhande_AngabenZurPerson"
    And User clicks on "Weiter_AngabenZurPerson"
    And User selects checkbox "Einverstaendnis_mit_PRIIP_Verordnung" in "EinverstaendnisMitPRIIPVerordnung_AngabenZurPerson"
    And User clicks on "kontoEroeffnen_AngabenZurPerson"
    And User submits generated TAN number in "TAN_field_AngabenZurPerson" for new customer
    Then Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotEinzel

    Examples: 
      | TestCase               |
      | Einzelkonto_KontoDepot |

  #Eroeffnet Tagesgeld Einzelkonto
  Scenario Outline: <TestCase>
    When User open an application
    And User navigates to "Tagesgeld" in "Sparen_Anlegen"
    And User clicks on "TagesgeldkontoEroeffnen_SparenAnlegen"
    And User selects radiobutton "Kunde_bei_der_Consorsbank" in "KundeBeiDerConsorsbank_TagesgeldkontoEroeffnen"
    And User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User selects radiobutton "Gemeinschaftskonto_eroeffnen" in "GemeinschaftskontoEroeffnen_TagesgeldkontoEroeffnen"
    And User selects radiobutton "minderjaehriges_Kind_eroeffnen" in "minderjaehrigesKindEroeffnen_TagesgeldkontoEroeffnen"
    And User clicks on "Weiter_TagesgeldkontoEroeffnen"
    And User clicks on "WeiterZurAntragsstrecke_KundeninformationZumDatenschutz"
    And User selects radiobutton "USA_Steuerpflichtig" in "USASteuerpflichtig_AngabenZurPerson"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA" in "AnsaessigkeitAusserhalbDeutschlandsUSA_AngabenZurPerson"
    And User enters "EMail_wiederholen" in "EMailWiederholen_AngabenZurPerson"
    And User enters "Telefon_privat" in "TelefonPrivat_AngabenZurPerson"
    And User clicks on "Weiter_AngabenZurPerson"
    And User clicks on "KontoEroeffnen_AngabenZurPerson"
    And User submits generated TAN number in "TAN_field_AngabenZurPerson" for new customer
    Then Verify captured Vorgangsnummer,Message from TagesgeldkontoEinzel

    Examples: 
      | TestCase              |
      | Einzelkonto_Tagesgeld |
