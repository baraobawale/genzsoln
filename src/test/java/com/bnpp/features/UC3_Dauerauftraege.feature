@UC3
Feature: UC3_Dauerauftraege

  #Executable - Dauerauftraege anlegen,Andern,loeschen
  #Anlegen/Creation
 
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Dauerauftraege_UmsaetzeZahlungsverkehr"
    And User clicks on NeuesDauerauftraegeAnlengen_UmsaetzeZahlungsverkehr to create template
    And User enters "Name" in "Name_DauerauftrageAnlegen"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_DauerauftrageAnlegen"
    And User enters "Betrag" in "Betrag_DauerauftrageAnlegen"
    And User selects "Intervall" in "Intervall_DauerauftrageAnlegen" field
    And User selects "Immer_am" in "ImmerAm_DauerauftrageAnlegen" field
    And User selects future date in Startdatum_DauerauftrageAnlegen
    And User selects checkbox "Als_Vorlage_speichern" in "AlsVorlageSpeichern_DauerauftrageAnlegen"
    And User enters "Vorlagenname" in "Vorlagenname_DauerauftrageAnlegen"
    And User clicks on "WeiterZurTANEingabe_DauerauftrageAnlegen"
    And User submits generated TAN number using "MobileTanLink_DauerauftrageAnlegen" on "TAN_field_DauerauftrageAnlegen"
    And User clicks on "DauerauftraegeAnlegen_DauerauftrageAnlegen"
    And Capture entered details on DauerauftrageAnlegen
    And Capture Message on DauerauftrageAnlegen
    And User clicks on "ZumZahlungsverkehr_DauerauftrageAnlegen"
    Then Verify "Vorlagenname","Ausfuehrung_Am" on UmsaetzeZahlungsverkehr
    And Verify captured details,Message from DauerauftrageAnlegen

    Examples: 
      | TestCase               |
      | Dauerauftraege_Anlegen |

  #Andern/Updation
  
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Dauerauftraege_UmsaetzeZahlungsverkehr"
    And User clicks on "Edit_Dauerauftraege"
    And User enters "Betrag" in "Betrag_DauerauftrageAndern"
    And User clicks on "WeiterZurTANEingabe_DauerauftrageAndern"
    And User submits generated TAN number using "MobileTanLink_DauerauftrageAndern" on "TAN_field_DauerauftrageAndern"
    And User clicks on "DauerauftraegeSpeichern_DauerauftrageAndern"
    Then Verify Message,details on DauerauftrageAndern

    Examples: 
      | TestCase              |
      | Dauerauftraege_Andern |

  #Loeschen/Deletion
  @UC3 
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Dauerauftraege_UmsaetzeZahlungsverkehr"
    And User clicks on "Delete_Dauerauftraege"
    And User submits generated TAN number using "MobileTanLink_Dauerauftraegeloeschen" on "TAN_field_Dauerauftraegeloeschen"
    And User clicks on "Dauerauftraegeloeschen_Dauerauftraegeloeschen"
    Then Verify Message on Dauerauftraegeloeschen

    Examples: 
      | TestCase                |
      | Dauerauftraege_loeschen |
