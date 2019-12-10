@TA-183 
Feature: TA-180

  #Executable - Referenzkonto anlegen, loeschen
  # Verify Error
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Referenz_konton" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_ReferenzKonton"
    And User clicks on "NeuesReferenzKontonAnlengen_ReferenzKonton"
    And User enters "Empfanger_name" in "EmpfangerName_ReferenzKontoAnlengen"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_ReferenzKontoAnlengen"
    And User selects "Ich_bestaetige" in "IchBestaetige_ReferenzKontoAnlengen"
    And User clicks on "WeiterZurTanEingabe_ReferenzKontoAnlengen"
    Then Verify displayed "ErrorMesssages" on ReferenzKontoAnlengen

    Examples: 
      | TestCase                    |
      | Referenzkonto_Verify_Errors |

  #Create/Anlegen IBAN Referenzkonto
  @UC11
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Referenz_konton" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_ReferenzKonton"
    And User clicks on "NeuesReferenzKontonAnlengen_ReferenzKonton"
    And User enters "Empfanger_name" in "EmpfangerName_ReferenzKontoAnlengen"
    And User enters "IBAN_oder_Kontonummer" in "IBANOderKontonummer_ReferenzKontoAnlengen"
    And User selects checkbox "Ich_bestaetige" in "IchBestaetige_ReferenzKontoAnlengen"
    And User clicks on "WeiterZurTanEingabe_ReferenzKontoAnlengen"
    And User submits generated TAN number using "MobileTanLink_ReferenzKontonAnlengen" on "TAN_field_ReferenzKontonAnlengen"
    And User clicks on "ReferenzkontoAnlegen_ReferenzKontonAnlengen"
    And Capture entered details on ReferenzKontonAnlengen
    And User clicks on "ZuDenReferenzkonto_ReferenzKontonAnlengen"
    Then Verify "Empfanger_name","IBAN_oder_Kontonummer" on Referenzkonten

    # And Verify captured details,Message from ReferenzKontonAnlengen
    Examples: 
      | TestCase                   |
      | Referenzkonto_Anlegen_IBAN |