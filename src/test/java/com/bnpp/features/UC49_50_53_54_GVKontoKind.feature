@UC49
Feature: UC49_50_53_54_GVKontoKind

  #Test data added for int acc2 - Automatable in int acc2
  #GV Eroeffnet Konto Depot/Tagesgeld Kind
  #GV Eroeffnet Konto Depot - BESTEHENDES Kind
  @UC49_1
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User navigates to "Wertpapierdepot" in "Wertpapierhandel"
    And User clicks on "Wertpapierdepot_eroeffnen"
    And User selects radiobutton "Kunde_bei_der_Consorsbank" in "KundeBeiDerConsorsbank_WertpapierdepotEroeffnen"
    And User is redirected to login page to login with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User selects radiobutton "Gemeinschaftskonto_eroeffnen" in "GemeinschaftskontoEroeffnen_WertpapierdepotEroeffnen"
    And User selects radiobutton "minderjaehriges_Kind_eroeffnen" in "minderjaehrigesKindEroeffnen_WertpapierdepotEroeffnen"
    And User selects "Waehlen_Einen_Kontakt" in "Waehlen_Einen_Kontakt_WertpapierdepotEroeffnen"
    And User clicks on "Weiter_WertpapierdepotEroeffnen"
    And User clicks on "WeiterZurAntragsstrecke_KundeninformationZumDatenschutz"
    And User selects radiobutton "USA_steuerpflichtig" in "USASteuerpflichtig_Kontoinhaber"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA" in "AnsaessigkeitAusserhalbDeutschlandsUSA_Kontoinhaber"
    And User clicks on "Zum1GesetzlVertreter_Kontoinhaber"
    And User selects "Familienstand_2" in "Familienstand_GesetzlicherVertreter1Page"
    And User selects radiobutton "USA_steuerpflichtig_2" in "USASteuerpflichtig2_GesetzlicherVertreter1Page"
    And User enters "EMail_wiederholen_2" in "EMailWiederholen2_GesetzlicherVertreter1Page"
    And User selects checkbox "Alleiniger_Gesetzlicher_Vertreter_2" in "AlleinigerGesetzlicherVertreter2_GesetzlicherVertreter1Page"
    And User selects radiobutton "Erfahrungen_im_Bereich_Wertpapierhande_2" in "ErfahrungenImBereichWertpapierhande2_GesetzlicherVertreter1Page"
    And User clicks on "Weiter_GesetzlicherVertreter1Page"
    And User selects checkbox "Einverstaendnis_mit_PRIIP_Verordnung" in "EinverstaendnisMitPRIIPVerordnung_KontoverwendungPage"
    And User clicks on "kontoEroeffnen_KontoverwendungPage"
    And Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotBestehendesKind
    And User clicks on "EroeffnungsunterlagenHerunterladen_KostenlosesWertpapierdepotBestehendesKind"
    Then Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotBestehendesKind
    And Download PDF generated in New Tab

    Examples: 
      | TestCase                       |
      | GVDepotBestehendesKind_Anlegen |

  #GV Eroeffnet Konto Depot- WEITERES Kind
 @UC49_2
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    And User navigates to "Wertpapierdepot" in "Wertpapierhandel"
    And User clicks on "Wertpapierdepot_eroeffnen"
    And User selects radiobutton "Kunde_bei_der_Consorsbank" in "KundeBeiDerConsorsbank_WertpapierdepotEroeffnen"
    And User is redirected to login page to login with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User selects radiobutton "Gemeinschaftskonto_eroeffnen" in "GemeinschaftskontoEroeffnen_WertpapierdepotEroeffnen"
    And User selects radiobutton "minderjaehriges_Kind_eroeffnen" in "minderjaehrigesKindEroeffnen_WertpapierdepotEroeffnen"
    And User selects "Waehlen_Einen_Kontakt" in "Waehlen_Einen_Kontakt_WertpapierdepotEroeffnen"
    And User clicks on "Weiter_WertpapierdepotEroeffnen"
    And User clicks on "WeiterZurAntragsstrecke_KundeninformationZumDatenschutz"
    And User selects radiobutton "Anrede_1" in "Anrede1_Kontoinhaber"
    And User enters "Vorname_1" in "Vorname1_Kontoinhaber"
    And User enters "Nachname_1" in "Nachname1_Kontoinhaber"
    And User enters "Geburtsdatum_TT_1" in "GeburtsdatumTT1_Kontoinhaber"
    And User enters "Geburtsdatum_MM_1" in "GeburtsdatumMM1_Kontoinhaber"
    And User enters "Geburtsdatum_JJ_1" in "GeburtsdatumJJ1_Kontoinhaber"
    And User enters "Geburtsort_1" in "Geburtsort1_Kontoinhaber"
    And User selects "Geburtsland_1" in "Geburtsland1_Kontoinhaber"
    And User selects "Staatsangehoerigkeit_1" in "Staatsangehoerigkeit1_Kontoinhaber"
    And User selects radiobutton "Weitere_Staatsangehoerigkeit_USA_1" in "WeitereStaatsangehoerigkeitUSA1_Kontoinhaber"
    And User selects radiobutton "USA_steuerpflichtig_1" in "USASteuerpflichtig1_Kontoinhaber"
    And User enters "Strasse_Hausnummer_1" in "StrasseHausnummer1_Kontoinhaber"
    And User enters "PLZ_1" in "PLZ1_Kontoinhaber"
    And User enters "Ort_1" in "Ort1_Kontoinhaber"
    And User selects "Land_1" in "Land_1_Kontoinhaber"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA_1" in "AnsaessigkeitAusserhalbDeutschlandsUSA1_Kontoinhaber"
    And User enters "Telefon_privat_1" in "TelefonPrivat1_Kontoinhaber"
    And User selects "Beruf_1" in "Beruf1_Kontoinhaber"
    And User selects "Branche_1" in "Branche1_Kontoinhaber"
    And User selects "Jahreseinkommen_Netto_1" in "JahreseinkommenNetto1_Kontoinhaber"
    And User selects "Verfuegbares_Vermoegen_1" in "VerfuegbaresVermoegen1_Kontoinhaber"
    And User clicks on "Zum1GesetzlVertreter_Kontoinhaber"
    And User selects "Familienstand_2" in "Familienstand_GesetzlicherVertreter1Page"
    And User selects radiobutton "USA_steuerpflichtig_2" in "USASteuerpflichtig2_GesetzlicherVertreter1Page"
    And User enters "EMail_wiederholen_2" in "EMailWiederholen2_GesetzlicherVertreter1Page"
    And User selects checkbox "Alleiniger_Gesetzlicher_Vertreter_2" in "AlleinigerGesetzlicherVertreter2_GesetzlicherVertreter1Page"
    And User selects radiobutton "Erfahrungen_im_Bereich_Wertpapierhande_2" in "ErfahrungenImBereichWertpapierhande2_GesetzlicherVertreter1Page"
    And User clicks on "Weiter_GesetzlicherVertreter1Page"
    And User selects checkbox "Einverstaendnis_mit_PRIIP_Verordnung" in "EinverstaendnisMitPRIIPVerordnung_KontoverwendungPage"
    And User clicks on "kontoEroeffnen_KontoverwendungPage"
    And Capture then  Vorgangsnummer,Message on KostenlosesWertpapierdepotWeiteresKind
    And User clicks on "EroeffnungsunterlagenHerunterladen_KostenlosesWertpapierdepotWeiteresKind"
    Then Verify then captured Vorgangsnummer,Message from KostenlosesWertpapierdepotWeiteresKind
    And Download PDF generated in New Tab

    Examples: 
      | TestCase                    |
      | GVDepotWeiteresKind_Anlegen |

  #GV Eroeffnet Konto Tagesgeld - BESTEHENDES Kind
  @UC49_3
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    And User navigates to "Tagesgeld" in "Sparen_Anlegen"
    And User clicks on "TagesgeldkontoEroeffnen_SparenAnlegen"
    And User selects radiobutton "Kunde_bei_der_Consorsbank" in "KundeBeiDerConsorsbank_TagesgeldkontoEroeffnen"
    And User is redirected to login page to login with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User selects radiobutton "Gemeinschaftskonto_eroeffnen" in "GemeinschaftskontoEroeffnen_TagesgeldkontoEroeffnen"
    And User selects radiobutton "minderjaehriges_Kind_eroeffnen" in "minderjaehrigesKindEroeffnen_TagesgeldkontoEroeffnen"
    And User selects "Waehlen_Einen_Kontakt" in "Waehlen_Einen_Kontakt_TagesgeldkontoEroeffnen"
    And User clicks on "Weiter_TagesgeldkontoEroeffnen"
    And User clicks on "WeiterZurAntragsstrecke_KundeninformationZumDatenschutz"
    And User selects radiobutton "USA_steuerpflichtig" in "USASteuerpflichtig_Kontoinhaber"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA" in "AnsaessigkeitAusserhalbDeutschlandsUSA_Kontoinhaber"
    And User clicks on "Zum1GesetzlVertreter_Kontoinhaber"
    And User selects "Familienstand_2" in "Familienstand_GesetzlicherVertreter1Page"
    And User selects radiobutton "USA_steuerpflichtig_2" in "USASteuerpflichtig2_GesetzlicherVertreter1Page"
    And User enters "EMail_wiederholen_2" in "EMailWiederholen2_GesetzlicherVertreter1Page"
    And User selects checkbox "Alleiniger_Gesetzlicher_Vertreter_2" in "AlleinigerGesetzlicherVertreter2_GesetzlicherVertreter1Page"
    And User clicks on "Weiter_GesetzlicherVertreter1Page"
    And User clicks on "kontoEroeffnen_KontoverwendungPage"
    And Capture Vorgangsnummer,Message on TagesgeldkontoBestehendes
    And User clicks on "EroeffnungsunterlagenHerunterladen_KostenlosesWertpapierdepotBestehendesKind"
    Then Verify captured Vorgangsnummer,Message from TagesgeldkontoBestehendes
    And Download PDF generated in New Tab

    Examples: 
      | TestCase                           |
      | GVTagesgeldBestehendesKind_Anlegen |

  #GV Eroeffnet Konto Tagesgeld- WEITERES Kind
  @UC49_4
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    And User navigates to "Tagesgeld" in "Sparen_Anlegen"
    And User clicks on "TagesgeldkontoEroeffnen_SparenAnlegen"
    And User selects radiobutton "Kunde_bei_der_Consorsbank" in "KundeBeiDerConsorsbank_TagesgeldkontoEroeffnen"
    And User is redirected to login page to login with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User selects radiobutton "Gemeinschaftskonto_eroeffnen" in "GemeinschaftskontoEroeffnen_TagesgeldkontoEroeffnen"
    And User selects radiobutton "minderjaehriges_Kind_eroeffnen" in "minderjaehrigesKindEroeffnen_TagesgeldkontoEroeffnen"
    And User selects "Waehlen_Einen_Kontakt" in "Waehlen_Einen_Kontakt_TagesgeldkontoEroeffnen"
    And User clicks on "Weiter_TagesgeldkontoEroeffnen"
    And User clicks on "WeiterZurAntragsstrecke_KundeninformationZumDatenschutz"
    And User selects radiobutton "Anrede_1" in "Anrede1_Kontoinhaber"
    And User enters "Vorname_1" in "Vorname1_Kontoinhaber"
    And User enters "Nachname_1" in "Nachname1_Kontoinhaber"
    And User enters "Geburtsdatum_TT_1" in "GeburtsdatumTT1_Kontoinhaber"
    And User enters "Geburtsdatum_MM_1" in "GeburtsdatumMM1_Kontoinhaber"
    And User enters "Geburtsdatum_JJ_1" in "GeburtsdatumJJ1_Kontoinhaber"
    And User enters "Geburtsort_1" in "Geburtsort1_Kontoinhaber"
    And User selects "Geburtsland_1" in "Geburtsland1_Kontoinhaber"
    And User selects "Staatsangehoerigkeit_1" in "Staatsangehoerigkeit1_Kontoinhaber"
    And User selects radiobutton "Weitere_Staatsangehoerigkeit_USA_1" in "WeitereStaatsangehoerigkeitUSA1_Kontoinhaber"
    And User selects radiobutton "USA_steuerpflichtig_1" in "USASteuerpflichtig1_Kontoinhaber"
    And User enters "Strasse_Hausnummer_1" in "StrasseHausnummer1_Kontoinhaber"
    And User enters "PLZ_1" in "PLZ1_Kontoinhaber"
    And User enters "Ort_1" in "Ort1_Kontoinhaber"
    And User selects "Land_1" in "Land_1_Kontoinhaber"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA_1" in "AnsaessigkeitAusserhalbDeutschlandsUSA1_Kontoinhaber"
    And User enters "Telefon_privat_1" in "TelefonPrivat1_Kontoinhaber"
    And User selects "Beruf_1" in "Beruf1_Kontoinhaber"
    And User selects "Branche_1" in "Branche1_Kontoinhaber"
    And User selects "Jahreseinkommen_Netto_1" in "JahreseinkommenNetto1_Kontoinhaber"
    And User selects "Verfuegbares_Vermoegen_1" in "VerfuegbaresVermoegen1_Kontoinhaber"
    And User clicks on "Zum1GesetzlVertreter_Kontoinhaber"
    And User selects "Familienstand_2" in "Familienstand_GesetzlicherVertreter1Page"
    And User selects radiobutton "USA_steuerpflichtig_2" in "USASteuerpflichtig2_GesetzlicherVertreter1Page"
    And User enters "EMail_wiederholen_2" in "EMailWiederholen2_GesetzlicherVertreter1Page"
    And User selects checkbox "Alleiniger_Gesetzlicher_Vertreter_2" in "AlleinigerGesetzlicherVertreter2_GesetzlicherVertreter1Page"
    And User clicks on "Weiter_GesetzlicherVertreter1Page"
    And User clicks on "kontoEroeffnen__KontoverwendungPage"
    And Capture Vorgangsnummer,Message on TagesgeldkontoWeiteres
    And User clicks on "EroeffnungsunterlagenHerunterladen_TagesgeldkontoWeiteres"
    Then Verify captured Vorgangsnummer,Message from TagesgeldkontoWeiteres
    And Download PDF generated in New Tab

    Examples: 
      | TestCase                        |
      | GVTagesgeldWeiteresKind_Anlegen |
