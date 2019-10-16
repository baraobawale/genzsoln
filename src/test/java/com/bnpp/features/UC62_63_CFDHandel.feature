@Demo300919 @report
Feature: UC62_63_CFDHandel

  #Executable : Inhaber Einzelkonto Eroeffnet Depot-CFD  (Neues/BestehendesKonto)
  #Eroeffnet Depot-CFD Neues Konto
  @demotest
  Scenario Outline: <TestCase>
    When User open the application
    And User navigates to "CFD_Handel" in "Wertpapierhandel"
    And User clicks on "CFDKontoEroeffnen_CFDHandel"
    And User selects radiobutton "Kunde_bei_der_Consorsbank" in "KundeBeiDerConsorsbank_CFDKontoEroeffnen"
    And User clicks on "Weiter_CFDKontoEroeffnen"
    And User clicks on "WeiterZurAntragsstrecke_KundeninformationZumDatenschutz"
    And User selects radiobutton "Anrede" in "Anrede_AngabenZurPerson"
    And User enters "Vorname" in "Vorname_AngabenZurPerson"
    And User enters "Nachname" in "Nachname_AngabenZurPerson"
    And User enters "Geburtsdatum_TT" in "GeburtsdatumTT_AngabenZurPerson"
    And User enters "Geburtsdatum_MM" in "GeburtsdatumMM_AngabenZurPerson"
    And User enters "Geburtsdatum_JJ" in "GeburtsdatumJJ_AngabenZurPerson"
    And User enters "Geburtsort" in "Geburtsort_AngabenZurPerson"
    And User selects "Geburtsland" in "Geburtsland_AngabenZurPerson"
    And User selects "Staatsangehoerigkeit" in "Staatsangehoerigkeit_AngabenZurPerson"
    And User selects radiobutton "Weitere_Staatsangehoerigkeit_USA" in "WeitereStaatsangehoerigkeitUSA_AngabenZurPerson"
    And User selects radiobutton "USA_steuerpflichtig" in "USASteuerpflichtig_AngabenZurPerson"
    And User enters "Strasse_Hausnummer" in "StrasseHausnummer_AngabenZurPerson"
    And User enters "PLZ" in "PLZ_AngabenZurPerson"
    And User enters "Ort" in "Ort_AngabenZurPerson"
    And User selects "Land" in "Land_AngabenZurPerson"
    And User selects radiobutton "Die_eingegebene_Adresse_ist_nicht_eindeutig" in "DieEingegebeneAdresseIstNichtEindeutig_AngabenZurPerson"
    And User clicks on "Uebernehmen_AngabenZurPerson"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA" in "AnsaessigkeitAusserhalbDeutschlandsUSA_AngabenZurPerson"
    And User enters "EMail" in "EMail_AngabenZurPerson"
    And User enters "EMail_wiederholen" in "EMailWiederholen_AngabenZurPerson"
    And User enters "Telefon_privat" in "TelefonPrivat_AngabenZurPerson"
    And User selects "Beruf" in "Beruf_AngabenZurPerson"
    And User selects "Branche" in "Branche_AngabenZurPerson"
    And User selects "Jahreseinkommen_Netto" in "JahreseinkommenNetto_AngabenZurPerson"
    And User selects "Verfuegbares_Vermoegen" in "VerfuegbaresVermoegen_AngabenZurPerson"
    And User selects checkbox "Mit_sehr_hohem_Risiko" in "MitSehrHohemRisiko_AngabenZurPerson"
    And User selects checkbox "Zulassung_zum_Handel_Finanztermingeschaeften" in "ZulassungzumHandelFinanztermingeschaeften_AngabenZurPerson"
    And User selects checkbox "Erklaerung_zu_Risiken_bei_Finanztermingeschaeften" in "ErklaerungzuRisikenbeiFinanztermingeschaeften_AngabenZurPerson"
    And User selects checkbox "Besondere_Merkmale_und_Risikoerklaerung" in "BesondereMerkmaleundRisikoerklaerung_AngabenZurPerson"
    And User clicks on "Weiter_AngabenZurPerson"
    And User selects checkbox "Einverstaendnis_mit_PRIIP_Verordnung" in "EinverstaendnisMitPRIIPVerordnung_AngabenZurPerson"
    And User clicks on "KontoEroeffnen_AngabenZurPerson"
    And Capture Vorgangsnummer,Message on CFDKontoEinzel
    And User clicks on "EroeffnungsunterlagenHerunterladen_CFDKontoEinzel"
    Then Verify captured Vorgangsnummer,Message from CFDKontoEinzel
    And Download PDF generated in New Tab

    Examples: 
      | TestCase                        |
      | Einzelkonto_DepotCFD_NeuesKonto |

  #Eroeffnet Depot-CFD Bestehendes Konto
   @demotest @CF_Handel
  Scenario Outline: <TestCase>
    When User open the application
    And User navigates to "CFD_Handel" in "Wertpapierhandel"
    And User clicks on "CFDKontoEroeffnen_CFDHandel"
    And User selects radiobutton "Kunde_bei_der_Consorsbank" in "KundeBeiDerConsorsbank_CFDKontoEroeffnen"
    And User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User clicks on "Weiter_CFDKontoEroeffnen"
    And User clicks on "WeiterZurAntragsstrecke_KundeninformationZumDatenschutz"
    And User selects "Depot" in "Depot_CFDKontodaten"
    And User clicks on "Weiter_CFDKontodaten"
    And User selects radiobutton "USA_Steuerpflichtig" in "USASteuerpflichtig_AngabenZurPerson"
    And User selects radiobutton "Ansaessigkeit_ausserhalb_Deutschlands_USA" in "AnsaessigkeitAusserhalbDeutschlandsUSA_AngabenZurPerson"
    And User enters "EMail" in "EMail_AngabenZurPerson"
    And User enters "EMail_wiederholen" in "EMailWiederholen_AngabenZurPerson"
    And User enters "Telefon_privat" in "TelefonPrivat_AngabenZurPerson"
    And User selects checkbox "Mit_sehr_hohem_Risiko" in "MitSehrHohemRisiko_AngabenZurPerson"
    And User selects checkbox "Zulassung_zum_Handel_Finanztermingeschaeften" in "ZulassungzumHandelFinanztermingeschaeften_AngabenZurPerson"
    And User selects checkbox "Erklaerung_zu_Risiken_bei_Finanztermingeschaeften" in "ErklaerungzuRisikenbeiFinanztermingeschaeften_AngabenZurPerson"
    And User selects checkbox "Besondere_Merkmale_und_Risikoerklaerung" in "BesondereMerkmaleundRisikoerklaerung_AngabenZurPerson"
    And User clicks on "Weiter_AngabenZurPerson"
    And User clicks on "KontoEroeffnen_AngabenZurPerson"
		And User submits generated TAN number in "TAN_field_AngabenZurPerson"
    And Capture Vorgangsnummer,Message on CFDKontoEinzel
    Then Verify captured Vorgangsnummer,Message from CFDKontoEinzel

    Examples: 
      | TestCase                              |
      | Einzelkonto_DepotCFD_BestehendesKonto |
