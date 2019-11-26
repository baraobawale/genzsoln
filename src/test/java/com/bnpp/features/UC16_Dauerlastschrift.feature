@UC16
Feature: UC16_Dauerlastschrift

  #Executable - Dauerlastschrift anlegen,Andern,loeschen
  #Anlegen/Creation
  @UC16_1
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Dauerlastschriften_UmsaetzeZahlungsverkehr"
    And User clicks on "NeuesDauerlastschriftenAnlengen_UmsaetzeZahlungsverkehr"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_DauerlastschriftAnlengen"
    And User enters "Betrag" in "Betrag_DauerlastschriftAnlengen"
    And User selects value "Intervall" in "Intervall_DauerlastschriftAnlengen"
    And User selects value "Immer_am" in "ImmerAm_DauerlastschriftAnlengen"
    And User enters "Startdatum" in "Startdatum_DauerlastschriftAnlengen"
    # And User selects checkbox "Unbegrenzt_gültig" in "UnbegrenztGultig_DauerlastschriftAnlengen"
    And User clicks on "WeiterZurTANEingabe_DauerlastschriftAnlengen"
    And User submits generated TAN number using "MobileTanLink_DauerlastschriftAnlengen" on "TAN_field_DauerlastschriftAnlengen"
    And User clicks on "DauerlastschriftenAnlegen_DauerlastschriftAnlengen"
    And Capture entered details on DauerlastschriftAnlengen
    And Capture Message on DauerlastschriftAnlengen
    And User clicks on "ZumZahlungsverkehr_DauerlastschriftAnlengen"
    Then Verify "Name","IBAN_oder_Kontonummer" under LaufendenZahlungenVorlagen_UmsaetzeZahlungsverkehr
    And Verify captured details,Message from DauerlastschriftAnlengen

    Examples: 
      | TestCase                 |
      | Dauerlastschrift_Anlegen |

  #Andern/Updation
  @UC16_2
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Dauerlastschriften_UmsaetzeZahlungsverkehr"
    And User clicks on Edit_Dauerlastschrift of CreatedDauerlastschrift_UmsaetzeZahlungsverkehr
    And User enters "Betrag" in "Betrag_DauerlastschriftAndern"
    And User selects value "Intervall" in "Intervall_DauerlastschriftAndern"
    And User selects value "Immer_am" in "ImmerAm_DauerlastschriftAndern"
    And User enters "Startdatum" in "Startdatum_DauerlastschriftAndern"
    And User clicks on "WeiterZurTANEingabe_DauerlastschriftAndern"
    And User submits generated TAN number using "MobileTanLink_DauerlastschriftAndern" on "TAN_field_DauerlastschriftAndern"
    And User clicks on "DauerlastschriftenSpeichern_DauerlastschriftAndern"
    Then Verify captured details,Message on DauerlastschriftAndern

    Examples: 
      | TestCase                |
      | Dauerlastschrift_Andern |

  #Loeschen/Deletion
  @UC16_3
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Dauerlastschriften_UmsaetzeZahlungsverkehr"
    And User clicks on Delete_Dauerlastschrift of CreatedDauerlastschrift_Dauerlastschriftloeschen
    And User submits generated TAN number using "MobileTanLink_Dauerlastschriftloeschen" on "TAN_field_Dauerlastschriftloeschen"
    And User clicks on "Dauerlastschriftenloeschen_Dauerlastschriftloeschen"
    Then Verify Message on Dauerlastschriftloeschen

    Examples: 
      | TestCase                  |
      | Dauerlastschrift_loeschen |
