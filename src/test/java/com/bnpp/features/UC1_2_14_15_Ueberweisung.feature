@SEPA
Feature: UC1_2_14_Ueberweisung

  #Executable : Ueberweisung Anlegen (Euro-Ueberweisang(SEPA)/Auslandsueberweisung(SWIFT)/Refernzkonton)
  #Euro-Ueberweisang(SEPA)
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Ueberweisung_UmsaetzeZahlungsverkehr"
    And User selects Art_der_Ueberweisung in ArtDerUeberweisung_UeberweisungAnlegen
    And User enters "Name" in "Name_UeberweisungAnlegenSEPA"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_UeberweisungAnlegen"
    And User enters "Betrag" in "Betrag_UeberweisungAnlegen"
    And User selects Ausfuehrung in Ausfuehrung_UeberweisungAnlegen
    And User clicks on "WeiterZurTANEingabe_UeberweisungAnlegen"
    And User submits generated TAN number using "MobileTanLink_UeberweisungAnlegen" on "TAN_field_UeberweisungAnlegen"
    And User clicks on "UeberweisungAusfuehren_UeberweisungAnlegen"
    Then Verify details,Message on UeberweisungAnlegen

    Examples: 
      | TestCase                  |
      | Ueberweisung_Anlegen_SEPA |

  #Auslandsueberweisung(SWIFT)
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Ueberweisung_UmsaetzeZahlungsverkehr"
    And User selects Art_der_Ueberweisung in ArtDerUeberweisung_UeberweisungAnlegen
    And User enters "Name" in "Name_UeberweisungAnlegenSWIFT"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_UeberweisungAnlegen"
    And User enters "BIC" in "BIC_UeberweisungAnlegen"
    And User enters "Betrag" in "Betrag_UeberweisungAnlegen"
    And User selects Gebuehrenregelung in Gebuehrenregelung_UeberweisungAnlegen
    And User clicks on "WeiterZurTANEingabe_UeberweisungAnlegen"
    And User submits generated TAN number using "MobileTanLink_UeberweisungAnlegen" on "TAN_field_UeberweisungAnlegen"
    And User clicks on "UeberweisungAusfuehren_UeberweisungAnlegen"
    Then Verify details,Message on UeberweisungAnlegen

    Examples: 
      | TestCase                   |
      | Ueberweisung_Anlegen_SWIFT |

  #Ueberweisung to Referenz Konto(Tagesgeld)
  @UC1_2_14_Ueberweisung
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Ueberweisung_UmsaetzeZahlungsverkehr"
    And User selects Art_der_Ueberweisung in ArtDerUeberweisung_UeberweisungAnlegen
    And User enters "Name" in "Name_UeberweisungAnlegenSEPA"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_UeberweisungAnlegen"
    And User enters "Betrag" in "Betrag_UeberweisungAnlegen"
    And User selects Ausfuehrung in Ausfuehrung_UeberweisungAnlegen
    And User clicks on "WeiterZurTANEingabe_UeberweisungAnlegen"
    And User submits generated TAN number using "MobileTanLink_UeberweisungAnlegen" on "TAN_field_UeberweisungAnlegen"
    And User clicks on "UeberweisungAusfuehren_UeberweisungAnlegen"
    Then Verify details,Message on UeberweisungAnlegen

    Examples: 
      | TestCase                            |
      | Ueberweisung_Anlegen_Referenzkonton |

  #Ueberweisung from Tagesgeld to Verrechnungskonto
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Ueberweisung_UmsaetzeZahlungsverkehr"
    And User selects Art_der_Ueberweisung in ArtDerUeberweisung_UeberweisungAnlegen
    And User enters "Name" in "Name_UeberweisungAnlegenSEPA"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_UeberweisungAnlegen"
    And User enters "Betrag" in "Betrag_UeberweisungAnlegen"
    And User selects Ausfuehrung in Ausfuehrung_UeberweisungAnlegen
    And User clicks on "WeiterZurTANEingabe_UeberweisungAnlegen"
    And User submits generated TAN number using "MobileTanLink_UeberweisungAnlegen" on "TAN_field_UeberweisungAnlegen"
    And User clicks on "UeberweisungAusfuehren_UeberweisungAnlegen"
    Then Verify details,Message on UeberweisungAnlegen

    Examples: 
      | TestCase                                          |
      | Ueberweisung_Anlegen_TagesgeldToVerrechnungskonto |
