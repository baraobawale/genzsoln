@UC78
Feature: UC78_79_Aboservice

  #Executable : Aboservice setzen und zuruecksetzen(mit Fehlermeldungen)
  # Verify Error - Aboservice
  @UC78_1
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Aboservice" in "Mein_Konto_Depot"
    And User clicks on "NewsLetter_Aboservice"
    And User clicks on "Weiter_NewsLetter"
    Then Verify displayed "ErrorMesssages"

    Examples: 
      | TestCase                 |
      | Aboservice_Verify_Errors |

  #Setzen/Set Newsletter Subscription
  @UC78_2
   Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Aboservice" in "Mein_Konto_Depot"
    And User clicks on "NewsLetter_Aboservice"
    And User selects checkbox "Abonnieren" in "Abonnieren_NewsLetter"
    And User clicks on "Weiter_NewsLetter"
    And User submits generated TAN number using "MobileTanLink_NewsLetter" on "TAN_field_NewsLetter"
    And User clicks on "KostenpflichtigAbonnieren_NewsLetter"
    Then Verify Message on NewsLetter
    And Verify "Abonnement" in "Abonnement_Newsletter"
    And Verify "Nutzungsart" in "Nutzungsart_Newsletter"
    And Verify "Preis" in "Preis_Newsletter"

    Examples: 
      | TestCase          |
      | Aboservice_Setzen |

  #Zuruecksetzen/Reset subscription
  @UC78_3
  Scenario Outline: <TestCase>
    Given User launches Consorsbank web application
    When User Logs in with "UserID_Kontonummer","PIN_Password"
    And User submits generated TAN number in "TAN_field_Login"
    And User navigates to "Aboservice" in "Mein_Konto_Depot"
    And User clicks on "MeineAbos_Aboservice"
    And User selects checkbox "Abo_kuendigen" in "Abokuendigen_NewsletterMeineAbos"
    And User clicks on "Weiter_NewsletterMeineAbos"
    And User submits generated TAN number using "MobileTanLink_NewsletterMeineAbos" on "TAN_field_NewsletterMeineAbos"
    And User clicks on "Kuendigen_NewsletterMeineAbos"
    And Capture Message on NewsletterMeineAbos
    And Capture "Abonnement" on "Abonnement_NewsletterMeineAbos"
    And Capture "Preis" on "Preis_NewsletterMeineAbos"
    And Capture "Kuendigung_zum" on "KuendigungZum_NewsletterMeineAbos"
    And User clicks on "MeineAbos_NewsletterMeineAbos"
    Then Verify "Cancelled_on" on NewsletterMeineAbos
    And Verify captured Message, details from NewsletterMeineAbos

    Examples: 
      | TestCase                 |
      | Aboservice_Zuruecksetzen |
