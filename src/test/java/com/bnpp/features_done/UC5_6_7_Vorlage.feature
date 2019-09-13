@567
Feature: UC5_6_7_Vorlage

  #Anlegen/Create-IBAN
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Vorlagen_UmsaetzeZahlungsverkehr"
    And User clicks on "Neue_Ueberweisungsvorlage_anlegen"
    And User enters "Vorlagenname" in "Vorlagenname"
    And User enters "Name" in "Name"
    And User enters "IBAN_oder_Kontonummer" in "IBAN_oder_Kontonummer"
    And User enters "Betrag" in "Betrag"
    And User clicks on "Weiter_zur_TAN_Eingabe"
    And User submits generated TAN number in "Mobile_TAN_field1"
    And User clicks on "Ueberweisungsvorlage_anlegen"
    Then Verify IBAN create message

    Examples: 
      | TestCase                      | ExpectedResult     |
      | Ueberweisungsvorlagen_anlegen | Verify create IBAN |

  #Aendern/Change-IBAN
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Vorlagen_UmsaetzeZahlungsverkehr"
    And User clicks on "Edit" of "Created_Vorlagenname" field
    And User changes "Betrag" in "Betrag" field
    And User clicks on "Weiter_zur_TAN_Eingabe"
    And User submits generated TAN number in "Mobile_TAN_field1"
    And User clicks on "Ueberweisungsvorlage_speichern"
    Then Verify IBAN update message

    Examples: 
      | TestCase                           | ExpectedResult         |
      | Ueberweisungsvorlagen_aendern_IBAN | Verify change for IBAN |

  #Loeschen/Delete-IBAN
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Vorlagen_UmsaetzeZahlungsverkehr"
    And User clicks on "Delete" of "Created_Vorlagenname1" field
    And User clicks on "Weiter_zur_TAN_Eingabe"
    And User submits generated TAN number in "Mobile_TAN_field1"
    And User clicks on "Ueberweisungsvorlage_loeschen"
    Then Verify IBAN delete message

    Examples: 
      | TestCase                   | ExpectedResult         |
      | Ueberweisung_loeschen_IBAN | Verify delete for IBAN |

  #Anlegen/Create-KontoBLZ
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Vorlagen_UmsaetzeZahlungsverkehr"
    And User clicks on "Neue_Ueberweisungsvorlage_anlegen"
    And User enters "Vorlagenname" in "Vorlagenname"
    And User enters "Name" in "Name"
    And User enters "IBAN_oder_Kontonummer" in "IBAN_oder_Kontonummer"
    And User enters "BLZ" in "BLZ"
    And User enters "Betrag" in "Betrag"
    And User clicks on "Weiter_zur_TAN_Eingabe"
    And User submits generated TAN number in "Mobile_TAN_field1"
    And User clicks on "Ueberweisungsvorlage_anlegen"
    Then Verify KontoBLZ create message

    Examples: 
      | TestCase                      | ExpectedResult         |
      | Ueberweisungsvorlagen_anlegen | Verify create KontoBLZ |

  #Aendern/Change-KontoBLZ
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Vorlagen_UmsaetzeZahlungsverkehr"
    And User clicks on "Edit" of "Created_Vorlagenname" field
    And User changes "Betrag" in "Betrag" field
    And User clicks on "Weiter_zur_TAN_Eingabe"
    And User submits generated TAN number in "Mobile_TAN_field1"
    And User clicks on "Ueberweisungsvorlage_speichern"
    Then Verify KontoBLZ update message

    Examples: 
      | TestCase                               | ExpectedResult             |
      | Ueberweisungsvorlagen_aendern_kontoBLZ | Verify change for KontoBLZ |

  #Loeschen/Delete-KontoBLZ
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Vorlagen_UmsaetzeZahlungsverkehr"
    And User clicks on "Delete" of "Created_Vorlagenname1"
    And User clicks on "Weiter_zur_TAN_Eingabe"
    And User submits generated TAN number in "Mobile_TAN_field1"
    And User clicks on "Ueberweisungsvorlage_loeschen"
    Then Verify KontoBLZ delete message

    Examples: 
      | TestCase                       | ExpectedResult             |
      | Ueberweisung_loeschen_kontoBLZ | Verify delete for KontoBLZ |
