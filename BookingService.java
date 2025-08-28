package service;

import model.Booking;
import model.Movie;
import model.CinemaHall;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();

    public void makeBooking(User user, Movie movie, CinemaHall hall, int seat) {
        // check if seat is already taken
        for (Booking b : bookings) {
            if (b.getHall().equals(hall) && b.getSeat() == seat) {
                System.out.println("Seat " + seat + " is already taken!");
                return;
            }
        }
        Booking booking = new Booking(user, movie, hall, seat);
        bookings.add(booking);
        System.out.println("✅ Booking successful: " + booking);
    }

    public void cancelBooking(User user, Movie movie) {
        Booking bookingToRemove = null;
        for (Booking b : bookings) {
            if (b.getUser().equals(user) && b.getMovie().equals(movie)) {
                bookingToRemove = b;
                break;
            }
        }
        if (bookingToRemove != null) {
            bookings.remove(bookingToRemove);
            System.out.println("✅ Booking canceled: " + bookingToRemove);
        } else {
            System.out.println("⚠️ No booking found for this user and movie.");
        }
    }

    public void showAllBookings() {
        System.out.println("\n=== ALL BOOKINGS ===");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking b : bookings) {
                System.out.println(b);
            }
        }
    }
}
