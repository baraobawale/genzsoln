@Demo300919 @report
Feature: UC76_77_EMailBenachrichtigungen

  Executable - E-Mail Benachrichtigungen setzen (mit Fehlermeldungen)
  Errors - E-Mail Benachrichtigungen (Fehlermeldungen)

  Scenario Outline: <TestCase>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Benachrichtigungen" in "Mein_Konto_Depot"
    And User clicks on "Aendern_Benachrichtigungen"
    And User selects checkbox "Orderausfuehrung" in "Orderausfuehrung_Benachrichtigungen"
    And User selects checkbox "Statusaenderung_Einer_Offenen_Order" in "StatusaenderungEinerOffenenOrder_Benachrichtigungen"
    And User selects checkbox "Ablauf_Gueltigkeit" in "AblaufGueltigkeit_Benachrichtigungen"
    And User selects checkbox "CFD_Margin_Call" in "CFDMarginCall_Benachrichtigungen"
    And User selects checkbox "Hinweis_Benachrichtigungsservice" in "HinweisBenachrichtigungsservice_Benachrichtigungen"
    And User clicks on "Bestaetigen_Benachrichtigungen"
    Then Verify displayed ErrorMesssages on Benachrichtigungen

    Examples: 
      | TestCase                        |
      | EMail_Benachrichtigungen_Errors |

  #E-Mail Benachrichtigungen setzen und zuruecksetzen (E-mail notifications Set & Reset)
  @UC76
  Scenario Outline: <TestCase>
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Benachrichtigungen" in "Mein_Konto_Depot"
    And User clicks on "Aendern_Benachrichtigungen"
    And User selects checkbox "Orderausfuehrung" in "Orderausfuehrung_Benachrichtigungen"
    And User selects checkbox "Statusaenderung_Einer_Offenen_Order" in "StatusaenderungEinerOffenenOrder_Benachrichtigungen"
    And User selects checkbox "Ablauf_Gueltigkeit" in "AblaufGueltigkeit_Benachrichtigungen"
    And User selects checkbox "CFD_Margin_Call" in "CFDMarginCall_Benachrichtigungen"
    And User selects checkbox "Hinweis_Benachrichtigungsservice" in "HinweisBenachrichtigungsservice_Benachrichtigungen"
    And User submits generated TAN number in "TAN_field_Benachrichtigungen"
    And User clicks on "Bestaetigen_Benachrichtigungen"
    Then Verify Message,Status on Benachrichtigungen

    Examples: 
      | TestCase                          |
      | EMail_Benachrichtigungen_Select   |
      | EMail_Benachrichtigungen_Unselect |
