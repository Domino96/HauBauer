# Code Style

## Klassen

* Klassennamen immer PascalCase
* Klassennamen immer in Englisch
* Zu Klassen immer den Accessor festlegen (`private`/`public`/`protected`)
* `abstract` benutzen, wenn Klasse *nur* vererbt wird
* `final` benutzen, wenn Klasse *nicht* vererbt wird

## Interfaces

* Ohne "I" am Anfang (stattdessen versuchen, die Funktion über den Namen zu beschreiben; im Zweifelsfall einfach nachfragen)

## Felder/Methoden

* Methoden- und Feldnamen immer camelCase
* Methoden- und Feldnamen immer in Englisch
* Felder immer als private festlegen
* Wenn Felder nach außen verfügbar sein sollen, immer Getter und/oder Setter benutzen
* Methoden immer als private, public, protected, oder nichts (d.h. package-private) festlegen
* Wenn Methoden nicht überschrieben werden sollen oder Felder nicht verändert werden sollen, immer als *final* deklarieren