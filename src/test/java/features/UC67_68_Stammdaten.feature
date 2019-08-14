Feature: Stammdaten bestaetigen und aendern

Scenario Outline: <TestCase><ExpectedResult>
    When User Logs in with <UserID/Kontonummer> , <PIN/Password>
    And User submits the generated TAN number in "TAN_field"
    And User navigates to "Persoenliche_Einstellungen"
    And clicks on "Aendern"
    And User enters <House_number> in Straße, Hausnr. field
    And User enters <PLZ> in PLZ field
    And User enters <Ort> in Ort field
    And User selects <Branche> in Branche Field
    And User clicks on "Weiter" to continue
    Then Verify <ErrorMesssages> are displayed
             |ErrorMesssages|
             |"Bitte korrigieren Sie die folgenden Punkte:"|
             |"Branche: Bitte wählen Sie die Branche, in der Sie arbeiten, aus."|
             |"PLZ: Dieses Feld muss angegeben werden."|
             |"Straße, Hausnr.: Dieses Feld muss angegeben werden."|
             |"Ort: Dieses Feld muss angegeben werden."|
             
    #And "Branche: Bitte wählen Sie die Branche, in der Sie arbeiten, aus." is displayed
    #And "PLZ: Dieses Feld muss angegeben werden." is displayed
    #And "Straße, Hausnr.: Dieses Feld muss angegeben werden." is displayed
    #And "Ort: Dieses Feld muss angegeben werden." is displayed

    Examples: 
      | TestCase                              | ExpectedResult | UserID/Kontonummer | PIN/Password | House_number | PLZ  | Ort  | Branche           |
      | stammdaten_error_blankmandatoryfields | Verify errors  |          880589404 |        12345 | ""           | ""   | ""   | "Bitte auswählen" |


  
  