@UC5
Feature: UC5_6_7_Vorlage

  #Anlegen/Create - IBAN
  @UC5_1
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Vorlagen_UmsaetzeZahlungsverkehr"
   	And User clicks on NeueUeberweisungsvorlageAnlegen_UmsaetzeZahlungsverkehr to create template
    And User enters "Vorlagenname" in "Vorlagenname_VorlageAnlegen"
    And User enters "Name" in "Name_VorlageAnlegen"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_VorlageAnlegen"
    And User enters "Betrag" in "Betrag_VorlageAnlegen"
    And User clicks on "WeiterZurTANEingabe_VorlageAnlegen"
    And User submits generated TAN number using "MobileTanLink_VorlageAnlegen" on "TAN_field_VorlageAnlegen"
    And User clicks on "UeberweisungsvorlageAnlegen_VorlageAnlegen"
    And Capture entered details on VorlageAnlegen
    And Capture Message on VorlageAnlegen
    And User clicks on "ZumZahlungsverkehr_VorlageAnlegen"
    Then Verify "Vorlagenname","IBAN_oder_Kontonummer" on  UmsaetzeZahlungsverkehr
    And Verify captured details,Message from VorlageAnlegen

    Examples: 
      | TestCase             |
      | IBANVorlagen_Anlegen |

  #Anlegen/Create-KontoBLZ
  @UC5_2
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Vorlagen_UmsaetzeZahlungsverkehr"
    And User clicks on "NeueUeberweisungsvorlageAnlegen_UmsaetzeZahlungsverkehr"
    And User enters "Vorlagenname" in "Vorlagenname_VorlageAnlegen"
    And User enters "Name" in "Name_VorlageAnlegen"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_VorlageAnlegen"
    And User enters "BLZ" in "BLZ_VorlageAnlegen"
    And User enters "Betrag" in "Betrag_VorlageAnlegen"
    And User clicks on "WeiterZurTANEingabe_VorlageAnlegen"
    And User submits generated TAN number using "MobileTanLink_VorlageAnlegen" on "TAN_field_VorlageAnlegen"
    And User clicks on "UeberweisungsvorlageAnlegen_VorlageAnlegen"
    And Capture entered details on VorlageAnlegen
    And Capture Message on VorlageAnlegen
    And User clicks on "ZumZahlungsverkehr_VorlageAnlegen"
    Then Verify "Vorlagenname","IBAN_oder_Kontonummer" on  UmsaetzeZahlungsverkehr
    And Verify captured details,Message from VorlageAnlegen

    Examples: 
      | TestCase                 |
      | KontoBLZVorlagen_Anlegen |

  #Aendern/Change-IBAN/KontoBLZ
  @UC5_3
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Vorlagen_UmsaetzeZahlungsverkehr"
    And User click on "Edit" of "Created_Vorlagenname" in "CreatedVorlagenname_UmsaetzeZahlungsverkehr"
    And User enters "Betrag" in "Betrag_VorlageAendern"
    And User clicks on "WeiterZurTANEingabe_VorlageAendern"
    And User submits generated TAN number using "MobileTanLink_VorlageAnlegen" on "TAN_field_VorlageAnlegen"
    And User clicks on "UeberweisungVorlageSpeichern_VorlageAendern"
    Then Verify Message,details on VorlageAendern

    Examples: 
      | TestCase                  |
      | Vorlagen_Aendern_IBAN     |
      | Vorlagen_Aendern_kontoBLZ |

  #Loeschen/Delete-IBAN/KontoBLZ
  @UC5_4
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Vorlagen_UmsaetzeZahlungsverkehr"
    And User click on "Delete" of "Created_Vorlagenname" in "CreatedVorlagenname_UmsaetzeZahlungsverkehr"
    And User submits generated TAN number using "MobileTanLink_VorlageAnlegen" on "TAN_field_Vorlageloeschen"
    And User clicks on "UeberweisungsVorlageloeschen_Vorlageloeschen"
    Then Verify Message on Vorlageloeschen

    Examples: 
      | TestCase                   |
      | Vorlagen_loeschen_IBAN     |
      | Vorlagen_loeschen_kontoBLZ |
