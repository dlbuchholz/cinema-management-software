# 📡 API-Spezifikation für das Kino-Reservierungs- & Buchungssystem

## 📝 **Beispielanfragen (cURL)**

📌 **Ein neues Kino erstellen:**
```sh
curl -X POST http://localhost:8080/api/cinemas \
     -H "Content-Type: application/json" \
     -d '{"name": "CineMega ABC", "location": "Hannover"}'
```

📌 **Die Kino-Liste abrufen:**
```sh
curl -X GET http://localhost:8080/api/cinemas
```

📌 **Ein Kino umbenennen:**
```sh
curl -X PATCH http://localhost:8080/api/cinemas/1 \
     -H "Content-Type: application/json" \
     -d '{"name": "Neues Kino"}'
```

📌 **Ein Kino löschen**
```sh
curl -X DELETE http://localhost:8080/api/cinemas/1
```


## 🎟️ **Kunde (Ticketbuchung & Reservierung)**

### 🎥 **Film- und Screening-Suche**
| Methode  | Endpoint                         | Beschreibung                                         |
|----------|----------------------------------|------------------------------------------------------|
| `GET`    | `/api/movies`                    | Liste aller aktuellen Filme abrufen                 |
| `GET`    | `/api/movies/{id}`               | Details zu einem Film abrufen                       |
| `GET`    | `/api/movies/{id}/screenings`    | Liste aller kommenden Vorführungen für einen Film  |
| `GET`    | `/api/screenings/{id}`           | Details zu einer spezifischen Vorführung abrufen   |

### 🛒 **Reservierung & Buchung**
| Methode  | Endpoint                           | Beschreibung                                       |
|----------|----------------------------------|--------------------------------------------------|
| `POST`   | `/api/tickets/reservation`               | Eine neue Reservierung anlegen                   |
| `PATCH`  | `/api/tickets/{id}/confirm`  | Reservierung in eine Buchung umwandeln           |
| `DELETE` | `/api/tickets/{id}/cancel`          | Reservierung stornieren                          |
| `POST`   | `/api/tickets`                   | Direkt eine Buchung erstellen (nicht stornierbar) |
| `GET`    | `/api/tickets/{id}`              | Details einer Buchung/Reservierung abrufen                    |

### 🪑 **Sitzplatz-Verwaltung**
| Methode  | Endpoint                                 | Beschreibung                                       |
|----------|----------------------------------------|--------------------------------------------------|
| `GET`    | `/api/seats/{screeningId}`            | Verfügbare Sitzplätze für eine Vorführung        |
| `PATCH`  | `/api/seats/{seatId}/cancel`          | Einzelnen Sitzplatz aus einer Reservierung stornieren |
| `GET`    | `/api/halls/{hallId}/seats`           | Liste aller Sitze in einem Kinosaal abrufen      |

---

## 🎭 **Kinobesitzer (Verwaltung & Statistiken)**

### 🎬 **Kino-Management**
| Methode  | Endpoint               | Beschreibung                     |
|----------|------------------------|----------------------------------|
| `GET`    | `/api/cinemas`         | Liste aller Kinos abrufen       |
| `POST`   | `/api/cinemas`         | Neues Kino erstellen            |
| `PATCH`  | `/api/cinemas/{id}`    | Kino aktualisieren              |
| `DELETE` | `/api/cinemas/{id}`    | Kino löschen                    |

### 🎬 **Kinosaal- & Sitzplatzverwaltung**
| Methode  | Endpoint                            | Beschreibung                                         |
|----------|----------------------------------|--------------------------------------------------|
| `GET`    | `/api/halls`                     | Liste aller Kinosäle                              |
| `GET`    | `/api/halls/{id}`                | Details zu einem bestimmten Saal abrufen         |
| `POST`   | `/api/halls`                     | Neuen Kinosaal erstellen                         |
| `PATCH`  | `/api/halls/{id}`                | Kinosaal bearbeiten (Reihen, Sitzplätze etc.)    |
| `PATCH`  | `/api/halls/{id}/activate`       | Kinosaal für Ticketverkauf freigeben             |

### 🎥 **Filmvorführungen erstellen & verwalten**
| Methode  | Endpoint                        | Beschreibung                                         |
|----------|--------------------------------|--------------------------------------------------|
| `GET`    | `/api/screenings`          | Alle Vorführungen abrufen              |
| `GET`    | `/api/screenings/{id}`      | Eine spezifische Vorführung abrufen    |
| `POST`   | `/api/screenings`              | Neue Filmvorführung erstellen                      |
| `PATCH`  | `/api/screenings/{id}`         | Vorführung bearbeiten (Name, Preis, Datum etc.)   |
| `DELETE` | `/api/screenings/{id}`         | Vorführung löschen                                |

### 📊 **Statistiken & Einnahmen**
| Methode  | Endpoint                        | Beschreibung                                         |
|----------|--------------------------------|--------------------------------------------------|
| `GET`    | `/api/statistics`     | Gesamtstatistiken abrufen                 |
| `GET`    | `/api/statistics/{id}`| Statistiken zu einem spezifischen Kino    |
| `GET`    | `/api/statistics/revenue`      | Gesamteinnahmen des Kinos abrufen                 |
| `GET`    | `/api/statistics/screenings/{id}` | Einnahmen für eine spezifische Vorführung abrufen |
| `GET`    | `/api/statistics/movies/{id}`  | Einnahmen pro Film abrufen                        |

---

## 🛠 **Sonstige Funktionen**
| Methode  | Endpoint                         | Beschreibung                                  |
|----------|----------------------------------|---------------------------------------------|
| `GET`    | `/api/categories`               | Alle Sitzplatz-Kategorien abrufen           |
| `GET`    | `/api/bookings/{id}/refund`     | Rücküberweisung für eine Stornierung prüfen |
| `GET`    | `/api/users/{id}/history`       | Buchungs- und Stornierungsverlauf eines Kunden |

---
