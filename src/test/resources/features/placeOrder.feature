Feature: place order end to end test
  As a user, I should be able to place an order
@wip
  Scenario: placing order
    Given user is on the home page
    When user clicks on the login menu
    When user enters "mustafa68" username "Test12345" password and clicks on the login button
    And user adds "Samsung galaxy s6" product from "Phones" category
    And user adds "Sony vaio i5" product from "Laptops" category
    And user adds "MacBook air" product from "Laptops" category
    And user adds "Apple monitor 24" product from "Monitors" category
    And user removes "Sony vaio i5" product from cart page
    And user places order and capture and log amount
    Then verify that purchase order




#Benutzer navigiert zur Startseite.
#Klicken Sie auf das Login-Menü.
#Geben Sie den Benutzernamen ein.
#Geben Sie das Passwort ein.
#Klicken Sie auf die Login-Schaltfläche.
#Fügen Sie 4 Produkte aus den verschiedenen Kategorien hinzu.
#Entfernen Sie "Sony vaio i5" aus dem Warenkorb.
#Bestellen Sie die Produkte.
#Erfassen und protokollieren Sie den Gesamtbetrag.
#Überprüfen Sie den erfassten Kaufbetrag.