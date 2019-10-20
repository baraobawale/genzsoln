@UC67
Feature: UC67_68_Stammdaten

  Scenario Outline: <TestCase>
   Given User launches consorsbank web application
 		And User clicks on "Login"
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Persoenliche_Einstellungen" in "Mein_Konto_Depot"
    And User clicks on "Aendern_PersoenlicheEinstellungen"
    And User enters "Strasse_Hausnr" in "StrasseHausnr_PersoenlicheEinstellungen"
    And User enters "PLZ" in "PLZ_PersoenlicheEinstellungen"
    And User enters "Ort" in "Ort_PersoenlicheEinstellungen"
    And User selects "Branche" in "Branche_PersoenlicheEinstellungen"
    And User clicks on "Weiter_PersoenlicheEinstellungen"
    Then Verify displayed "ErrorMesssages" on PersoenlicheEinstellungen

    Examples: 
      | TestCase                 |
      | Stammdaten_Verify_Errors |

  Scenario Outline: <TestCase>
   Given User launches consorsbank web application
 		And User clicks on "Login"
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Persoenliche_Einstellungen" in "Mein_Konto_Depot"
    And User clicks on "Aendern_PersoenlicheEinstellungen"
    And User enters "Strasse_Hausnr" in "StrasseHausnr_PersoenlicheEinstellungen"
    And User enters "PLZ" in "PLZ_PersoenlicheEinstellungen"
    And User enters "Ort" in "Ort_PersoenlicheEinstellungen"
    And User selects "Land" in "Land_PersoenlicheEinstellungen"
    And User enters "Steueridentifikationsnummer" in "Steueridentifikationsnummer_PersoenlicheEinstellungen"
    And User selects "Beruf" in "Beruf_PersoenlicheEinstellungen"
    And User selects "Branche" in "Branche_PersoenlicheEinstellungen"
    And User clicks on "Weiter_PersoenlicheEinstellungen"
    And User submits generated TAN number using "MobileTanLink_PersoenlicheEinstellungen" on "TAN_field_PersoenlicheEinstellungen"
        And User clicks on "Bestaetigen_PersoenlicheEinstellungen"
    Then verify changed data shown on bestaetigung page

    Examples: 
      | TestCase               |
      | Stammdaten_Verify_Save |
