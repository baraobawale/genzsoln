@UC4
Feature: UC4_Terminueberweisungen

  #Executable - Terminueberweisungen anlegen,Andern,loeschen
  #Anlegen/Creation
  
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Terminueberweisungen_UmsaetzeZahlungsverkehr"
    And User clicks on NeuesTerminueberweisungenAnlengen_UmsaetzeZahlungsverkehr to create template
    And User enters "Name" in "Name_TerminAnlegen"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_TerminAnlegen"
    And User enters "Betrag" in "Betrag_TerminAnlegen"
    And User enters future date in Datum_TerminAnlegen
    And User selects checkbox "Als_Vorlage_speichern" in "AlsVorlageSpeichern_TerminAnlegen"
    And User enters "Vorlagenname" in "Vorlagenname_TerminAnlegen"
    And User clicks on "WeiterZurTANEingabe_TerminAnlegen"
    And User submits generated TAN number using "MobileTanLink_TerminAnlegen" on "TAN_field_TerminAnlegen"
    And User clicks on "TerminueberweisungAnlegen_TerminAnlegen"
    And Capture entered details on TerminAnlegen
    And Capture Message on TerminAnlegen
    And User clicks on "ZumZahlungsverkehr_TerminAnlegen"
    Then Verify "Name","Ausfuehrung_Am" under "LaufendenZahlungenVorlagen_UmsaetzeZahlungsverkehr"
    And Verify captured details,Message from TerminAnlegen

    Examples: 
      | TestCase                     |
      | Terminueberweisungen_Anlegen |

  #Andern/Updation
  @UC44
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Terminueberweisungen_UmsaetzeZahlungsverkehr"
    And User clicks on "Edit_Terminueberweisungen"
    And User enters "Betrag" in "Betrag_TerminAendern"
    And User enters future date in Datum_TerminAnlegen
    And User clicks on "WeiterZurTANEingabe_TerminAendern"
    And User submits generated TAN number using "MobileTanLink_TerminAendern" on "TAN_field_TerminAendern"
    And User clicks on "TerminueberweisungSpeichern_TerminAendern"
    Then Verify Message,details on TerminAendern

    Examples: 
      | TestCase                    |
      | Terminueberweisungen_Andern |

  #Loeschen/Deletion
  @UC44
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Terminueberweisungen_UmsaetzeZahlungsverkehr"
    And User clicks on "Delete_Terminueberweisungen"
    And User submits generated TAN number using "MobileTanLink_Terminueberweisungloeschen" on "TAN_field_Terminueberweisungloeschen"
    And User clicks on "Terminueberweisungloeschen_Terminueberweisungloeschen"
    Then Verify Message on Terminueberweisungloeschen

    Examples: 
      | TestCase                      |
      | Terminueberweisungen_Loeschen |
