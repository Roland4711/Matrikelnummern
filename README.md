# Matrikelnummern
Übungsprojekt vom Fach Informatik 1, Fachbereich Maschinenbau und Verfahrenstechnik der Hochschule Düsseldorf. 
<br>**Thema**: Statische Methoden

Die Matrikelnummern der Hochschule Düsseldorf (HSD) haben sechs Ziffern.
Die ersten fünf Ziffern sind signifikant und werden fortlaufend vergeben.
Die sechste Ziffer ist eine *Prüfziffer*.

## Einleitung ##
In diesem Beispiel werden:
- Matrikelnummern geprüft (boolean).
- Prüfziffern von Matrikelnummern berechnet.
- zufällige Matrikelnummern mit korrekten Prüfziffer generiert.
- Matrikelnummern mit vorgegebenen signifikaten Ziffern generiert.

## Algorithmus
Algorithmus zur Berechnung der Prüfziffer

Die Prüfziffer der Matrikelnummer wird in vier Schritten berechnet, indem...

- zuerst die gewichtete Summe berechnet wird. Die Gewichtung beträgt von rechts nach links  0, 1, 2, 3, ... (Anzahl Ziffern). Eine gewichtete Summe wird ähnlich der Quersumme berechnet, aber die Ziffern werden mit der Gewichtung an der Ziffernposition multipiziert.
<br>**Beispiel**: Wenn eine sechsstellige Matrikelnummer 777775 gegeben ist, dann ist die Gewichtung ebenso sechsstellig, nämlich 543210. Die Ziffern der Matrikelnummer werden einzeln mit den Ziffern der Gewichtung mulipliziert und addiert. In diesem Beispiel ergibt das: 7*5 + 7*4 + 7*3 + 7*2 + 7*1 + 5*0 = 105
- Von dieser gewichteten Summe wird der Rest der Division mit 11 gebildet.
  <br>**Beispiel**: Der Rest von 105 geteilt durch 11 ist 6, denn 9 * 11 + 6 = 105. 
- Dieser Rest der Division wird von 11 subtrahiert.
<br>**Beispiel**: 11 - 6 = 5 
- Nun erfolgt eine Fallunterscheidung: Wenn das Ergebnis aus der Berechnung eine 10 oder 11 ist, dann ist die Prüfziffer eine 0. Sonst ist die Prüfziffer das Ergebnis der Berechnung. 
<br>**Beispiel**: Das Ergebnis 5 ist nicht eine 10 oder 11, also ist die Prüfziffer 5.