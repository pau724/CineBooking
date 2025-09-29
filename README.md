# CineBooking 🎬

A small, clean **Java console application** that simulates a cinema booking system.  
Built to showcase **OOP**, basic **service architecture**, simple **input validation**, and an **admin flow**

## Features
- View movie list (preloaded + admin can add new ones)
- Make a booking (movie, hall, seat) with seat availability check
- Cancel a booking (by user & movie)
- Admin mode:
  - Add a new movie
  - List all bookings

## Tech Stack
- Java 21
- Plain Java project (no frameworks, no build tool)
- Runs in Eclipse or from terminal

## Project Structure
src/
main/
Main.java
util/
Menu.java
model/
User.java
Movie.java
CinemaHall.java
Booking.java
service/
CinemaService.java
BookingService.java
## How to Run

### Option A — Eclipse
1. Import / open the project in Eclipse.
2. Run `Main` (Right click → **Run As → Java Application**).

### Option B — Terminal
From the project root:

```bash
# Compile all sources to /out
mkdir -p out
javac -d out $(find src -name "*.java")

# Run
java -cp out main.Main
=== CINEBOOKING ===
1. Show movies
2. Make a booking
3. Cancel booking
4. Admin mode
0. Exit
Select an option: 1

=== MOVIE LIST ===
1. Inception - Sci-Fi (148 min)
2. The Dark Knight - Action (152 min)
3. Interstellar - Sci-Fi (169 min)
4. The Matrix - Action (136 min)

Select an option: 2
=== MAKE A BOOKING ===
Choose a movie (number): 1
Available halls:
1. Hall 1 (Capacity: 50)
2. Hall 2 (Capacity: 100)
3. Hall 3 (Capacity: 80)
Choose a hall (number): 2
Choose a seat number (1 - 100): 17
✅ Booking successful: Booking: Paula - Inception in Hall 2 (Capacity: 100), seat 17
## Design Notes
- **OOP-first**: domain split into `model`, `service`, `util`.
- `CinemaService` manages movies & halls; `BookingService` manages bookings.
- `Menu` is a thin console UI layer.

## Roadmap / Next Steps
- Persistence (save/load to file or SQLite)
- Multi-user support (simple login)
- Unit tests (JUnit 5)
- GUI (JavaFX) or REST API (Spring Boot) version

## Author
Paula Espinoza — Student developer.  
*This project is part of my portfolio for Werkstudent positions.*
