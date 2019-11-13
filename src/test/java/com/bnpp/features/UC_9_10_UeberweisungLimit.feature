@UC_9_10
Feature: UC_9_10_UeberweisungLimit

  #Executable : Ueberweisungslimit Aendern (mit Fehlermeldungen)
  #Verify Error
  
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Kontodetails" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Andern_Kontodetails"
    And User enters Uberweisungslimit in Uberweisungslimit_Ueberweisungslimit
    And User selects checkbox "Ich_bestaetige" in "IchBestaetige_Ueberweisungslimit"
    And User clicks on "WeiterZurTanEingabe_Ueberweisungslimit"
    Then Verify displayed ErrorMesssages on Ueberweisungslimit

    Examples: 
      | TestCase                         |
      | Ueberweisungslimit_Verify_Errors |

  #Errors - Limit more than max limit
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Kontodetails" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Andern_Kontodetails"
    And User enters Uberweisungslimit in Uberweisungslimit_Ueberweisungslimit
    And User selects checkbox "Ich_bestaetige" in "IchBestaetige_Ueberweisungslimit"
    And User clicks on "WeiterZurTanEingabe_Ueberweisungslimit"
    And Capture Error Message on Ueberweisungslimit
    And User clicks on "UberweisungslimitErhoehen_Ueberweisungslimit"
    Then Verify captured Error Message from Ueberweisungslimit
    And Download PDF generated in New Tab

    Examples: 
      | TestCase                          |
      | Ueberweisungslimit_MaxLimit_Error |

  #Aendern
  @EmailSelect
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Kontodetails" in "Mein_Konto_Depot"
    And User selects "Account_Type" in "AccountType_UmsaetzeZahlungsverkehr"
    And User clicks on "Andern_Kontodetails"
    And User enters Uberweisungslimit in Uberweisungslimit_Ueberweisungslimit
    And User selects checkbox "Ich_bestaetige" in "IchBestaetige_Ueberweisungslimit"
    And User clicks on "WeiterZurTanEingabe_Ueberweisungslimit"
    And User submits generated TAN number using "MobileTanLink_Ueberweisungslimit" on "TAN_field_Ueberweisungslimit"
    And User clicks on "UeberweisungslimitAendern_Ueberweisungslimit"
    And Capture entered details on Ueberweisungslimit
    And Capture Message on Ueberweisungslimit
    And User clicks on "ZuDenKontoDetails_Ueberweisungslimit"
    Then Verify details on Ueberweisungslimit

    Examples: 
      | TestCase                   |
      | Ueberweisungslimit_Aendern |
