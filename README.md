# Cinema Management Software

Kino-Reservierungs- und Buchungssystem

## Projektstruktur

Das Projekt besteht aus mehreren Komponenten, die in verschiedenen Ordnern organisiert sind:
- /backend/: Enthält das Java/Maven-Backend des Projekts.
  - /src/com/cinemamanagementsoftware: Der Hauptcode des Backends.
  - /src-gen: Der generierte Source-Code von Ecore
  - /src/test/: Enthält Unit-Tests.
  - /target/: Der generierte Code nach dem Build-Prozess.
  - pom.xml: Die Maven-Build-Datei mit allen Abhängigkeiten und Plugins.

- /backend/model/: Enthält die Ecore-Modelle zur Definition der Geschäftslogik. Definiert das Modell für Kinos, Besitzer, Hallen und Beziehungen. Und enthält Generator-Einstellungen für das Modell.
- /frontend/ (zukünftige GUI): Enthält alle Ressourcen für die Benutzeroberfläche (noch nicht implementiert).

## Import des Projekts in Eclipse
1. Eclipse mit Maven-Unterstützung installieren
    - Falls noch nicht geschehen, lade Eclipse IDE for Java Developers herunter.
3. Projekt importieren
    - Öffne Eclipse.
    - Wähle File → Import.
    - Wähle Existing Maven Projects und klicke auf Next.
    - Navigiere zum Ordner /backend/, wähle die pom.xml aus und klicke auf Finish.
    - Warte, bis Eclipse die Abhängigkeiten lädt (ggf. Maven → Update Project ausführen).
4. Neo4J-Datenbank starten
    - Stelle sicher, dass Neo4J installiert ist: https://neo4j.com/docs/desktop-manual/current/installation/download-installation
    - Starte die Datenbank mit: neo4j console
    - Bei erster Benutzung ändere das Passwort von neo4j auf http://localhost:7474/
      - Benutzername: neo4j
      - Altes Passwort: neo4j
      - Neues Passwort: lobster-child-atomic-canvas-infant-6060 

5. Backend starten
    - In Eclipse in der Datei com.cinemamanagementsoftware.Main unter Run → Run As → Java-Application
    - Alternativ mit Maven ausführen: mvn spring-boot:run

## Was tun damit Ecore bzw EMF funktioniert?

### Ecore-Tools
- Eclipse -> Help -> Install new software -> Add
- Dann die URL https://download.eclipse.org/ecoretools/updates/releases/3.5.2/2023-06/ hinzufügen und alle Pakete daraus installieren

### Eclipse Modeling Framework
- Eclipse -> Help -> Install new software -> Work with "All available sites"
- dort dann Eclipse Modeling Framework SDK suchen, auswählen und installieren.

### Warten
Warte bis alles vollständig herunterladen wurde, meistens passiert das im Hintergrund. Vorher Eclipse keinesfalls schließen! Sobald es fertig ist, fragt Eclipse ob es neugestartet werden soll. Definitiv neustarten!

### Updates
Wenn Eclipse geupdated wird, fliegen manchmal alle manuell installierten Plugins raus. Dann muss dieser Guide vollständig wiederholt werden!
