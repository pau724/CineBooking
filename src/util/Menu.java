package util;

import java.util.Scanner;
import model.User;
import model.Movie;
import model.CinemaHall;
import service.CinemaService;
import service.BookingService;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final CinemaService cinemaService = new CinemaService();
    private final BookingService bookingService = new BookingService();

    // Default user for now
    private final User defaultUser = new User("Paula", "pau@example.com", false);

    public void showMainMenu() {
        int option;
        do {
            System.out.println("\n=== CINEBOOKING ===");
            System.out.println("1. Show movies");
            System.out.println("2. Make a booking");
            System.out.println("3. Cancel booking");
            System.out.println("4. Admin mode");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> cinemaService.showMovies();
                case 2 -> makeBooking();
                case 3 -> cancelBooking();
                case 4 -> showAdminMenu();
                case 0 -> System.out.println("Thank you for using CineBooking!");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }

    private void makeBooking() {
        System.out.println("\n=== MAKE A BOOKING ===");
        cinemaService.showMovies();

        System.out.print("Choose a movie (number): ");
        int movieChoice = scanner.nextInt();
        scanner.nextLine();

        if (movieChoice < 1 || movieChoice > cinemaService.getMovies().size()) {
            System.out.println("Invalid movie selection.");
            return;
        }
        Movie chosenMovie = cinemaService.getMovies().get(movieChoice - 1);

        System.out.println("\nAvailable halls:");
        for (int i = 0; i < cinemaService.getHalls().size(); i++) {
            System.out.println((i + 1) + ". " + cinemaService.getHalls().get(i));
        }

        System.out.print("Choose a hall (number): ");
        int hallChoice = scanner.nextInt();
        scanner.nextLine();

        if (hallChoice < 1 || hallChoice > cinemaService.getHalls().size()) {
            System.out.println("Invalid hall selection.");
            return;
        }
        CinemaHall chosenHall = cinemaService.getHalls().get(hallChoice - 1);

        System.out.print("Choose a seat number (1 - " + chosenHall.getCapacity() + "): ");
        int seat = scanner.nextInt();
        scanner.nextLine();

        if (seat < 1 || seat > chosenHall.getCapacity()) {
            System.out.println("Invalid seat number.");
            return;
        }

        bookingService.makeBooking(defaultUser, chosenMovie, chosenHall, seat);
    }

    private void cancelBooking() {
        System.out.println("\n=== CANCEL A BOOKING ===");
        cinemaService.showMovies();

        System.out.print("Choose a movie (number) to cancel booking: ");
        int movieChoice = scanner.nextInt();
        scanner.nextLine();

        if (movieChoice < 1 || movieChoice > cinemaService.getMovies().size()) {
            System.out.println("Invalid movie selection.");
            return;
        }
        Movie chosenMovie = cinemaService.getMovies().get(movieChoice - 1);

        bookingService.cancelBooking(defaultUser, chosenMovie);
    }

    private void showAdminMenu() {
        int option;
        do {
            System.out.println("\n=== ADMIN MODE ===");
            System.out.println("1. Add a new movie");
            System.out.println("2. Show all bookings");
            System.out.println("0. Back to main menu");
            System.out.print("Select an option: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addMovie();
                case 2 -> bookingService.showAllBookings();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }

    private void addMovie() {
        System.out.println("\n=== ADD A NEW MOVIE ===");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter duration (minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        cinemaService.addMovie(title, genre, duration);
    }
}



