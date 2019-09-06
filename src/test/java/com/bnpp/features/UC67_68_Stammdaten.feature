Feature: UC67_68_Stammdaten

  Scenario Outline: <TestCase> <Expected Result>
    When User open an application
    And User Logs in with "UserID_Kontonummer","PIN_Password"
    And User clicks on "Einloggen"
    And User submits generated TAN number in "TAN_field"
    And User clicks on "BestaetigenButton"
    And User navigates to "Mein_Konto_Depot" and clicks on "Persoenliche_Einstellungen"
    And User clicks on "Aendern"
    And User enters "Strasse_Hausnr" in "Strasse_Hausnr" field
    And User enters "PLZ" in "PLZ_Page1" field
    And User enters "Ort" in "Ort" field
    And User selects "Branche" in "Branche" field
    And User clicks on "Weiter"
    Then Verify "ErrorMesssages" are displayed

    Examples: 
      | TestCase            | Expected Result |
      | UC67_68_Stammdaten1 | Verify Errors   |

  Scenario Outline: <TestCase> <ExpectedResult>
    When User open an application
    And User Logs in with "UserID_Kontonummer","PIN_Password"
    And User clicks on "Einloggen"
    And User submits generated TAN number in "TAN_field"
    And User clicks on "BestaetigenButton"
    And User navigates to "Mein_Konto_Depot" and clicks on "Persoenliche_Einstellungen"
    And User clicks on "Aendern"
    And User enters "Strasse_Hausnr" in "Strasse_Hausnr" field
    And User enters "PLZ" in "PLZ_Page1" field
    And User enters "Ort" in "Ort" field
    And User selects "Land" in "Land" field
    And User enters "Steueridentifikationsnummer" in "Steueridentifikationsnummer" field
    And User selects "Beruf" in "Beruf" field
    And User selects "Branche" in "Branche" field
    And User clicks on "Weiter"
    And User submits generated TAN number in "Mobile_TAN_field"
    And User clicks on "Bestaetigen_confirm"
    Then verify changed data shown on bestaetigung page

    Examples: 
      | TestCase            | ExpectedResult |
      | UC67_68_Stammdaten2 | Verify Save    |
