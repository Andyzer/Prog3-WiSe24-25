# Beleg Vorschau (94)
Checkboxen gemäß Bearbeitung befüllen und _kursiv_ gesetzten Text durch entsprechende Angaben ersetzten.
Bei keiner Angabe wird nur Entwurf, Tests (ohne Testabdeckung Rest), Fehlerfreiheit und Basisfunktionalität bewertet.
Die Zahl in der Klammer sind die jeweiligen Punkte für die Bewertung.
Die empfohlenen Realisierungen sind **fett** gesetzt und ergeben 53 Punkte.
Ergänzende Anmerkungen bitte immer _kursiv_ setzen. Andere Änderungen sind nicht zulässig.

## Vorrausetzungen für das Bestehen
- [ ] Quellen angegeben
- [ ] zip Archiv mit dem Projekt im root
- [ ] IntelliJ-Projekt (kein Gradle, Maven o.ä.)
- [ ] keine weiteren Bibliotheken außer JUnit5, Mockito und JavaFX (und deren Abhängigkeiten)
- [ ] keine Umlaute, Sonderzeichen, etc. in Datei- und Pfadnamen
- [ ] Trennung zwischen Test- und Produktiv-Code
- [ ] kompilierbar
- [ ] geforderte main-Methoden nur im default package des module belegProg3
- [ ] keine vorgetäuschte Funktionalität (inkl. leere Tests)

## Entwurf (11)
- [ ] **Benennung** (2)
- [ ] **Zuständigkeit** (2)
- [ ] **Paketierung** (2)
- [ ] **Schichtenaufteilung (via modules)** (2)
- [ ] **nur absolut notwendige down casts** (2)
- [ ] keine Duplikate (1)

## Tests (33)
- [ ] **Testqualität** (9)
- [ ] **Testabdeckung GL (inkl. Abhängigkeiten)** (8) _Abdeckung in Prozent angeben_
- [ ] Testabdeckung Rest (6)
  - [ ] Einfügen von Kund*innen über das CLI _Tests angeben_
  - [ ] Anzeigen von Kund*innen über das CLI _Tests angeben_
  - [ ] ein Beobachter _Tests angeben_
  - [ ] deterministische Funktionalität der Simulationen _Tests angeben_
  - [ ] Speichern via JOS oder JBP _Tests angeben_
  - [ ] Laden via JOS oder JBP _Tests angeben_
- [ ] **mindestens 5 Unittests, die Mockito verwenden** (5)
- [ ] mindestens 4 Spy- / Verhaltens-Tests (4)
- [ ] **keine unbeabsichtigt fehlschlagenden Test** (1)

## Fehlerfreiheit (10)
- [ ] **Kapselung** (5)
- [ ] **keine Ablauffehler** (5)

## Basisfunktionalität (10)
- [ ] **CRUD** (2)
- [ ] **CLI** (2)
  * Syntax gemäß Anforderungen
- [ ] **Simulation** (2)
  * ohne race conditions, ohne sleep
- [ ] **I/O** (2)
- [ ] **Net** (2)

## Funktionalität (20)
- [ ] vollständige GL (2)
- [ ] threadsichere GL (1)
- [ ] vollständiges CLI (2)
- [ ] ausdifferenziertes event-System mit mindestens 3 events (2)
- [ ] alternativ konfiguriertes CLI (1)
  * _angeben welche Funktionalität im alternativen CLI deaktiviert_
- [ ] observer (2)
- [ ] angemessene Collections bzgl. Anforderungen (2)
- [ ] Simulation 2 (1)
- [ ] Simulation 3 (1)
- [ ] sowohl JBP als auch JOS (2)
- [ ] sowohl TCP als auch UDP (2)
- [ ] Server unterstützt konkurierende Clients für TCP oder UDP (2)

## zusätzliche Anforderungen GUI (5)
- [ ] Basis-GUI (CRUD) (1)
- [ ] skalierbare GUI (1)
- [ ] vollständige GUI (1)
- [ ] Sortierung in der GUI (1)
- [ ] FXML verwendet (1)

## zusätzliche Anforderungen (5)
