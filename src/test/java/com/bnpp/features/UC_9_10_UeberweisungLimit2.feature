  @UC9 @Report_test
Feature: UC_9_10_UeberweisungLimit

  #Executable : Ueberweisungslimit Aendern (mit Fehlermeldungen)
  #Verify Error
  @UC9_1
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"

    Examples: 
      | TestCase                         |
      | Ueberweisungslimit_Verify_Errors |

