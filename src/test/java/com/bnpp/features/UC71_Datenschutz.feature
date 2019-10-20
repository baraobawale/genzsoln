@UC71 @report
Feature: UC71_Datenschutz

  # Datenschutz andern - Non Executable
  Scenario Outline: <TestCase>
   Given User launches consorsbank web application
 		And User clicks on "Login"
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Mein_Datenschutz" in "Mein_Konto_Depot"
    And User selects checkbox "E-Mail_informiert" in "EMailInformiert_MeinDatenschutzAndern"
    And User selects checkbox "telefonisch_informiert" in "telefonischInformiert_MeinDatenschutzAndern"
    And User selects checkbox "meine_Bewegungen" in "meineBewegungen_MeinDatenschutzAndern"
    And User clicks on "Bestaetigen_MeinDatenschutzAndern"
    Then Verify messages displayed on Mein Datenchutz

    Examples: 
      | TestCase                          |
      | Datenschutz_select_All_Unselected |
      | Datenschutz_select_All_Selected   |
