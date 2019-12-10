@TA-18 @TA-188 @TA-120 
Feature: TA-117

#Neukunden Tagesgeld Anlegen
  #Einzelkonto Anlegen
  Scenario Outline: <TestCase> <ExpectedResult>
	Given User launches Consorsbank web application
    When User navigates to "Tagesgeld" in "Sparen_Anlegen"
    And User clicks on "TagesgeldkontoEroeffnen_SparenAnlegen"

    Examples: 
      | TestCase                     |
      | TagesgeldEinzelkonto_Anlegen |

