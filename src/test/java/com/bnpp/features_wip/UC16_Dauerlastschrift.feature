Feature: UC16_Dauerlastschrift 

	#Executable - Dauerlastschrift anlegen,Andern,loeschen
	#Anlegen/Creation
@RTARTA
  Scenario Outline: <TestCase> <ExpectedResult>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User clicks on "Einloggen"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Umsaetze_Zahlungsverkehr" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Zahlungsverkehr_UmsaetzeZahlungsverkehr"
    And User clicks on "Dauerlastschriften_UmsaetzeZahlungsverkehr"
    And User clicks on "NeuesDauerlastschriftenAnlengen_UmsaetzeZahlungsverkehr"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_DauerlastschriftAnlengen"
    And User enters "Betrag" in "Betrag_DauerlastschriftAnlengen" 
    And User selects "Intervall" in "Intervall_DauerlastschriftAnlengen" 
    And User selects "Immer_am" in "ImmerAm_DauerlastschriftAnlengen" 
    And User enters "Startdatum" in "Startdatum_DauerlastschriftAnlengen" 
    And User selects checkbox "UnbegrenztGultig_DauerlastschriftAnlengen"
    And User clicks on "WeiterZurTANEingabe_DauerlastschriftAnlengen"
    And User submits generated TAN number in "TAN_field" 
    And User clicks on "DauerlastschriftenAnlegen_DauerlastschriftAnlengen"
    # And Capture "Message"
    And User clicks on "ZumZahlungsverkehr_DauerlastschriftAnlengen"
    # Then Verify "Name","IBAN_oder_Kontonummer" under "LaufendenZahlungenVorlagen_UmsaetzeZahlungsverkehr"
    # And Verify captured details,Message

    Examples: 
      | TestCase                 | ExpectedResult                           |
      | Dauerlastschrift_Anlegen | ihre Dauerlastschriften wurde angenommen |


