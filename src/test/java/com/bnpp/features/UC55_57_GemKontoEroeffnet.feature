@UC55_57
Feature: UC55_57_GemKontoEroeffnet

  #Testable in int acc2 - test data added for int acc 2
  #Executable - Inhaber auf Gem.konto er�ffnet Konto Depot(Joint account holder opens a trading account/depot)
  #Gemeinschaftskonto depot Anlegen
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    And User navigates to "Wertpapierdepot" in "Wertpapierhandel"
    And User clicks on "Wertpapierdepot_eroeffnen"
    And User selects radiobutton "Kunde_bei_der_Consorsbank" in "KundeBeiDerConsorsbank_WertpapierdepotEroeffnen"
    And User is redirected to login page to login with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User selects radiobutton "Gemeinschaftskonto_eroeffnen" in "GemeinschaftskontoEroeffnen_WertpapierdepotEroeffnen"
    And User selects radiobutton "minderjaehriges_Kind_eroeffnen" in "minderjaehrigesKindEroeffnen_WertpapierdepotEroeffnen"
    And User clicks on "Weiter_WertpapierdepotEroeffnen"
    And User clicks on "WeiterZurAntragsstrecke_KundeninformationZumDatenschutz"
    And User selects radiobutton "USA_steuerpflichtig_1" in "USASteuerpflichtig_AngabenZurPerson1"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA_1" in "AnsaessigkeitAusserhalbDeutschlandsUSA_AngabenZurPerson1"
    And User enters "EMail_wiederholen_1" in "EMailWiederholen_AngabenZurPerson1"
    And User selects radiobutton "Erfahrungen_im_Bereich_Wertpapierhandel_1" in "ErfahrungenImBereichWertpapierhandel_AngabenZurPerson1"
    And User clicks on "Zu_Kontoinhaber_2"
    And User selects radiobutton "Anrede_2" in "Anrede2_Kontoinhaber2"
    And User enters "Vorname_2" in "Vorname2_Kontoinhaber2"
    And User enters "Nachname_2" in "Nachname2_Kontoinhaber2"
    And User enters "Geburtsdatum_TT_2" in "GeburtsdatumTT2_Kontoinhaber2"
    And User enters "Geburtsdatum_MM_2" in "GeburtsdatumMM2_Kontoinhaber2"
    And User enters "Geburtsdatum_JJ_2" in "GeburtsdatumJJ2_Kontoinhaber2"
    And User enters "Geburtsort_2" in "Geburtsort2_Kontoinhaber2"
    And User selects "Geburtsland_2" in "Geburtsland2_Kontoinhaber2"
    And User selects "verheiratet_oder_leben_Sie_miteinander" in "verheiratet_oder_leben_Sie_miteinander_Kontoinhaber2"
    And User selects "Staatsangehoerigkeit_2" in "Staatsangehoerigkeit2_Kontoinhaber2"
    And User selects radiobutton "Weitere_Staatsangehoerigkeit_USA_2" in "WeitereStaatsangehoerigkeitUSA2_Kontoinhaber2"
    And User selects radiobutton "USA_steuerpflichtig_2" in "USASteuerpflichtig2_Kontoinhaber2"
    And User enters "Strasse_Hausnummer_2" in "StrasseHausnummer2_Kontoinhaber2"
    And User enters "PLZ_2" in "PLZ2_Kontoinhaber2"
    And User enters "Ort_2" in "Ort2_Kontoinhaber2"
    And User selects "Land_2" in "Land2_Kontoinhaber2"
    And User selects radiobutton "Die_eingegebene_Adresse_ist_nicht_eindeutig_2" in "DieEingegebeneAdresseIstNichtEindeutig2_Kontoinhaber2"
    And User clicks on "Uebernehmen_Kontoinhaber2"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA_2" in "AnsaessigkeitAusserhalbDeutschlandsUSA2_Kontoinhaber2"
    And User enters "EMail_2" in "EMail2_Kontoinhaber2"
    And User enters "EMail_wiederholen_2" in "EMailWiederholen2_Kontoinhaber2"
    And User enters "Telefon_privat_2" in "TelefonPrivat2_Kontoinhaber2"
    And User selects "Beruf_2" in "Beruf2_Kontoinhaber2"
    And User selects "Branche_2" in "Branche2_Kontoinhaber2"
    And User selects "Jahreseinkommen_Netto_2" in "JahreseinkommenNetto2_Kontoinhaber2"
    And User selects "Verfuegbares_Vermoegen_2" in "VerfuegbaresVermoegen2_Kontoinhaber2"
    And User selects radiobutton "Erfahrungen_im_Bereich_Wertpapierhande_2" in "ErfahrungenImBereichWertpapierhande2_Kontoinhaber2"
    And User clicks on "Weiter_Kontoinhaber2"
    And User selects checkbox "Einverstaendnis_mit_PRIIP_Verordnung" in "EinverstaendnisMitPRIIPVerordnung_AngabenZurPerson2"
    And User clicks on "kontoEroeffnen_AngabenZurPerson2"
    And Capture the Vorgangsnummer,Message on KostenlosesWertpapierdepotGemeinschafts
    And User clicks on "EroeffnungsunterlagenHerunterladen_KostenlosesWertpapierdepotGemeinschafts"
    Then Verify the captured Vorgangsnummer,Message from KostenlosesWertpapierdepotGemeinschafts

    Examples: 
      | TestCase            |
      | Gemkonto_Kontodepot |

  #Gemeinschaftskonto tagesgeldkonto Anlegen
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    And User navigates to "Tagesgeld" in "Sparen_Anlegen"
    And User clicks on "TagesgeldkontoEroeffnen_SparenAnlegen"
    And User selects radiobutton "Kunde_bei_der_Consorsbank" in "KundeBeiDerConsorsbank_TagesgeldkontoEroeffnen"
    And User is redirected to login page to login with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User selects radiobutton "Gemeinschaftskonto_eroeffnen" in "GemeinschaftskontoEroeffnen_TagesgeldkontoEroeffnen"
    And User selects radiobutton "minderjaehriges_Kind_eroeffnen" in "minderjaehrigesKindEroeffnen_TagesgeldkontoEroeffnen"
    And User clicks on "Weiter_TagesgeldkontoEroeffnen"
    And User clicks on "Weiter_ZurAntragsstrecke"
    And User selects radiobutton "USA_steuerpflichtig_1" in "USASteuerpflichtig1_Kontoinhaber1"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA_1" in "AnsaessigkeitAusserhalbDeutschlandsUSA1_Kontoinhaber1"
    And User enters "EMail_wiederholen_1" in "EMailWiederholen1_Kontoinhaber1"
    And User clicks on "Zu_Kontoinhaber_2"
    And User selects radiobutton "Anrede_2" in "Anrede2_Kontoinhaber2"
    And User enters "Vorname_2" in "Vorname2_Kontoinhaber2"
    And User enters "Nachname_2" in "Nachname2_Kontoinhaber2"
    And User enters "Geburtsdatum_TT_2" in "GeburtsdatumTT2_Kontoinhaber2"
    And User enters "Geburtsdatum_MM_2" in "GeburtsdatumMM2_Kontoinhaber2"
    And User enters "Geburtsdatum_JJ_2" in "GeburtsdatumJJ2_Kontoinhaber2"
    And User enters "Geburtsort_2" in "Geburtsort2_Kontoinhaber2"
    And User selects "Geburtsland_2" in "Geburtsland2_Kontoinhaber2"
    And User selects "verheiratet_oder_leben_Sie_miteinander" in "verheiratet_oder_leben_Sie_miteinander_Kontoinhaber2"
    And User selects "Staatsangehoerigkeit_2" in "Staatsangehoerigkeit2_Kontoinhaber2"
    And User selects radiobutton "Weitere_Staatsangehoerigkeit_USA_2" in "WeitereStaatsangehoerigkeitUSA2_Kontoinhaber2"
    And User selects radiobutton "USA_steuerpflichtig_2" in "USASteuerpflichtig2_Kontoinhaber2"
    And User enters "Strasse_Hausnummer_2" in "StrasseHausnummer2_Kontoinhaber2"
    And User enters "PLZ_2" in "PLZ2_Kontoinhaber2"
    And User enters "Ort_2" in "Ort2_Kontoinhaber2"
    And User selects "Land_2" in "Land2_Kontoinhaber2"
    And User selects radiobutton "Die_eingegebene_Adresse_ist_nicht_eindeutig_2" in "DieEingegebeneAdresseIstNichtEindeutig2_Kontoinhaber2"
    And User clicks on "Uebernehmen_Kontoinhaber2"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA_2" in "AnsaessigkeitAusserhalbDeutschlandsUSA2_Kontoinhaber2"
    And User enters "EMail_2" in "EMail2_Kontoinhaber2"
    And User enters "EMail_wiederholen_2" in "EMailWiederholen2_Kontoinhaber2"
    And User enters "Telefon_privat_2" in "TelefonPrivat2_Kontoinhaber2"
    And User selects "Beruf_2" in "Beruf2_Kontoinhaber2"
    And User selects "Branche_2" in "Branche2_Kontoinhaber2"
    And User selects "Jahreseinkommen_Netto_2" in "JahreseinkommenNetto2_Kontoinhaber2"
    And User selects "Verfuegbares_Vermoegen_2" in "VerfuegbaresVermoegen2_Kontoinhaber2"
    And User clicks on "Weiter_Kontoinhaber2"
    And User clicks on "kontoEroeffnen_Kontoinhaber2"
    And Capture the Vorgangsnummer,Message on TagesgeldkontoGemeinschafts
    And User clicks on "EroeffnungsunterlagenHerunterladen_TagesgeldkontoGemeinschafts"
    Then Verify the captured Vorgangsnummer,Message from TagesgeldkontoGemeinschafts

    Examples: 
      | TestCase                |
      | Gemkonto_Tagesgeldkonto |
