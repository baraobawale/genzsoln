Feature: UC16_Dauerlastschrift 

	#Executable - Dauerlastschrift anlegen,Andern,loeschen
  #Anlegen/Creation
  @RTART
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User Logs in with "UserID_Kontonummer","PIN_Password"
    And User clicks on "Einloggen"
    And User submits generated TAN number in "TAN_field"
    And User navigates to "Umsaetze_Zahlungsverkehr"  in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Dauerlastschriften_UmsaetzeZahlungsverkehr"
    And User clicks on "NeuesDauerlastschriftenAnlengen_UmsaetzeZahlungsverkehr"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_DauerlastschriftAnlengen"
    And User enters "Betrag" in "Betrag_DauerlastschriftAnlengen"
    And User enters "Intervall" in "Intervall_DauerlastschriftAnlengen"
    And User enters "Immer_am" in "ImmerAm_DauerlastschriftAnlengen"
    And User enters "Startdatum" in "Startdatum_DauerlastschriftAnlengen"
    And User selects checkbox "Unbegrenzt_gultig" in "UnbegrenztGultig_DauerlastschriftAnlengen"
    And User clicks on "WeiterZurTANEingabe_DauerlastschriftAnlengen"
    And User submits generated TAN number in "TAN_field" 
    And User clicks on "DauerlastschriftenAnlegen_DauerlastschriftAnlengen"
    And Capture "Message"
    And User clicks on "ZumZahlungsverkehr_DauerlastschriftAnlengen"
    Then Verify "Name","IBAN_oder_Kontonummer" under "LaufendenZahlungenVorlagen_UmsaetzeZahlungsverkehr"
    And Verify captured details,Message

    Examples: 
      | TestCase                 | ExpectedResult                           |
      | Dauerlastschrift_Anlegen | ihre Dauerlastschriften wurde angenommen |

  #Andern/Updation
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password" 
    And User submits generated TAN number in "TAN_field" 
    And User navigates to "Umsaetze_Zahlungsverkehr"  in "Mein_Konto_Depot" 
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr" 
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr" 
    And User clicks on "Dauerlastschriften_UmsaetzeZahlungsverkehr" 
    And User clicks on "Edit" of "Created_Dauerlastschrift" in "CreatedDauerlastschrift_UmsaetzeZahlungsverkehr" 
    And User enters "Betrag" in "Betrag_DauerlastschriftAndern" 
    And User enters "Intervall" in "Intervall_DauerlastschriftAndern" 
    And User enters "Immer_am" in "ImmerAm_DauerlastschriftAndern" 
    And User enters "Startdatum" in "Startdatum_DauerlastschriftAndern" 
    And User clicks on "WeiterZurTANEingabe_DauerlastschriftAndern" 
    And User submits generated TAN number in "TAN_field" 
    And User clicks on "DauerlastschriftenSpeichern_DauerlastschriftAndern" 
    Then Verify Message,details

    Examples: 
      | TestCase                | ExpectedResult                            |
      | Dauerlastschrift_Andern | ihre Dauerlastschriften wurde gespeichert |

  #Loeschen/Deletion
  Scenario Outline: <TestCase> <ExpectedResult>
     When User Logs in with "UserID_Kontonummer","PIN_Password" 
    And User submits generated TAN number in "TAN_field" 
    And User navigates to "Umsaetze_Zahlungsverkehr"  in "Mein_Konto_Depot" 
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr" 
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr" 
    And User clicks on "Dauerlastschriften_UmsaetzeZahlungsverkehr" 
    And User clicks on "Delete" of "Created_Dauerlastschrift" in "CreatedDauerlastschrift_Dauerlastschriftloeschen" 
    And User submits the generated TAN number in "TAN_field"
    And User clicks on "Dauerlastschriftenloeschen_Dauerlastschriftloeschen"
    Then Verify Message

    Examples: 
      | TestCase                  | ExpectedResult                          |
      | Dauerlastschrift_loeschen | ihre Dauerlastschriften wurde geloescht |
