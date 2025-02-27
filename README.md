# Cinema Management Software

Kino-Reservierungs- und Buchungssystem

### **📁 Backend**
Das **Java/Maven-Backend** ist in verschiedene Services unterteilt:

- **`/backend/src/com/cinemamanagementsoftware/`**  
  ➜ Hauptcode des Backends mit verschiedenen Services.
- **`/backend/src-gen/`**  
  ➜ Generierter Source-Code aus den **Ecore-Modellen**.
- **`/backend/src/test/`**  
  ➜ Enthält **Unit- und Integrationstests**.
- **`/backend/target/`**  
  ➜ Generierter Code nach dem **Build-Prozess**.
- **`pom.xml`**  
  ➜ Die **Maven-Build-Datei** mit allen Abhängigkeiten und Plugins.

---

### **📁 Model**
- **`/backend/model/`**  
  ➜ Enthält die **Ecore-Modelle**, die die Geschäftslogik definieren.  
  ➜ Enthält **Generator-Einstellungen** für die Modelltransformation.

---

### **📁 Frontend (zukünftige GUI)**
- **`/frontend/`**  
  ➜ Wird die **Benutzeroberfläche** enthalten (**noch nicht implementiert**).  

---

## **📂 Services und ihre Funktionen**

### **📁 `applicationservice`**
📌 _Enthält die **Geschäftslogik** und REST-Schnittstellen._

- **`ConsoleInterface.java`**  
  ➜ **Interaktive Konsole**, um das System manuell zu steuern.  

#### **📁 `applicationservice.api`**
📌 _Enthält die **REST API-Controller** zur Kommunikation mit dem Frontend._

- **`CinemaController.java`**  
  ➜ **CRUD-API** für Kinos (Erstellen, Abrufen, Aktualisieren, Löschen).  
- **`ScreeningController.java`**  
  ➜ API für Vorführungen und Sitzplatzreservierungen.  
- **`StatisticsController.java`**  
  ➜ API für **Kino-Statistiken** aus der Datenbank.  

---

### **📁 `config`**
📌 _Konfigurationsdateien für externe Services._

- **`RabbitMQConfig.java`**  
  ➜ Konfiguriert die **RabbitMQ-Queues und Exchanges** für Messaging.  

---

### **📁 `persistenceservice`**
📌 _Datenbank-Persistenz (MySQL mit JPA/Hibernate)._  

#### **📁 `persistenceservice.consumers`**
📌 _Enthält die **RabbitMQ-Listener**, die Nachrichten verarbeiten._

- **`CinemaCommandConsumer.java`**  
  ➜ **RabbitMQ-Befehle** für Kino-Erstellung, Aktualisierung, Löschung.  

#### **📁 `persistenceservice.entities`**
📌 _JPA-Entities für die Datenbank._  

- **`CinemaEntity.java`** ➜ **Kino-Tabelle**  
- **`CinemaOwnerEntity.java`** ➜ **Kino-Besitzer**  
- **`CinemaHallEntity.java`** ➜ **Kinosäle**  
- **`MovieEntity.java`** ➜ **Filme**  
- **`SeatEntity.java`** ➜ **Sitzplätze**  
- **...weitere Entitäten...**  

#### **📁 `persistenceservice.repositories`**
📌 _JPA-Repositories zur Datenbankkommunikation._

- **`CinemaRepository.java`** ➜ **Datenbank-Methoden für Kinos**  
- **`ScreeningRepository.java`** ➜ **Datenbank-Methoden für Vorführungen**  

---

### **📁 `statisticservice`**
📌 _Verwaltet Statistiken in **Neo4j**._

- **`CinemaStatisticsService.java`**  
  ➜ **Kino-Statistiken verwalten & analysieren**.  
- **`GraphDatabaseController.java`**  
  ➜ **Komplexe Graph-Analysen mit Neo4j**.  

---

## **🔗 Kommunikation zwischen den Services**
- **REST API** (Frontend ↔ Backend)  
- **RabbitMQ** (Messaging zwischen ApplicationService ↔ PersistenceService)  
- **MariaDB** (Relationale Datenbank für Kinos & Buchungen)  
- **Neo4J** (Statistiken & Graph-Datenbank für Verknüpfungen)

## 📡 API Endpoints
=> [Siehe hier die Liste der API Endpoints](https://github.com/dlbuchholz/cinema-management-software/blob/stable/API.md)

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
5. MariaDB-Server starten
    - MariaDB installieren, wenn noch nicht getan (z.B. über XAMPP)
    - MariaDB starten
    - Hierfür wird kein Passwort benötigt oder vorrausgesetzt, gehe sicher, dass das Passwort für root leer ist
    - Folgendes Kommando ausführen um die Datenbank zu erstellen:
```
CREATE DATABASE cinema_db;
GRANT ALL PRIVILEGES ON cinema_db.* TO 'root'@'localhost';
FLUSH PRIVILEGES;
```
    
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
