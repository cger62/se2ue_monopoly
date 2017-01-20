#Software-Engineering II - Monopoly

Es gelten die allgemeinen Monopoly Spielregeln, bis auf ein paar Sonderregeln:
- Erlaubte Spieleranzahl: 2-8
- Ein Spieler scheidet aus dem Spiel aus, sobald er keine Miete bzw. Steuern zahlen kann (es gibt keine Hypotheken oder Versteigerungen).
- Es gibt nur einen Würfel mit zwölf Augen (kein Pasch möglich).
- Wenn man sich im Gefängnis befindet, hat man drei Versuche, um eine bestimmte (jedes mal random generierte) Zahl zu würfeln. Gelingt dies, darf man das Gefängnis ohne weiteres verlassen. Wenn nicht, muss man erst 1000 zahlen und kommt dann erst wieder frei.
- Sobald man alle Straßen einer Farbe besitzt, verdoppelt sich die Miete für alle Straßen der entsprechenden Farbe.
- Die Miete passt sich je nach gebauten Häusern/Hotels an (für Häuser: aktuelle Miete * Anzahl Häuser * 5; für Hotels: aktuelle Miete * Anazahl Hotels * 10).
- Beim Wasserwerk und Elektrizitätswerk muss nur eine festgelegte Summe gezahlt werden.
- Wenn eine Texteingabe mit "Ja/Nein" gefordert wird, kann man durch die Eingabe "status" seinen aktuellen Status einsehen.

Um das Spiel zu starten, muss die main-Klasse **Monopoly.java** (im package *monopoly*) gestartet werden.
Das gesamte Spiel läuft von da an über die Konsole.


Zudem sind folgende JUnit Tests vorhanden:
- Im Paket **_Test Packages monopoly.map.MonopolyMapTest.java_**
    - **Test 1:** ob bei einer korrekten Eingabe der Anzahl der Spielteilnehmer auch die entsprechende Anzahl von Spielern erstellt wird, ohne dass eine Fehlermeldung erscheint.
    
- Im Paket **_Test Packages monopoly.spieler.SpielerTest.java_**
  - **Test 2:** ob dem Spieler das dreimalige Würfeln gestattet ist, sobald er sich im Gefängnis befindet und ob er - egal ob er anschließend zahlen muss oder nicht - für die nächste Runde wieder aus dem Gefängnis entlassen wird.
  - **Test 3:** ob Steuern korrekt in den Pott gezahlt werden, sobald ein Spieler auf ein SteuerFeld kommt.
  - **Test 4:** ob ein Spieler mithilfe der spielfigurSetzen()-Methode beim Übergeben einer Feldnummer auch genau auf dem Feld mit dieser Nummer landet.
  - **Test 5:** ob der Spieler korrekt aus dem Spiel ausscheidet, sobald er auf ein Feld kommt, dessen Miete/Steuern er nicht mehr zahlen kann.
  - **Test 6:** ob der Spieler den gesamten Betrag aus dem Pott bekommt, sobald er auf das FreiParken-Feld kommt.
