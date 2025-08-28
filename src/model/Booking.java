package model;

public class Booking {
    private User user;
    private Movie movie;
    private CinemaHall hall;
    private int seat;

    public Booking(User user, Movie movie, CinemaHall hall, int seat) {
        this.user = user;
        this.movie = movie;
        this.hall = hall;
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public CinemaHall getHall() {
        return hall;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Booking: " + user.getName() + " - "
                + movie.getTitle() + " in " + hall + ", seat " + seat;
    }
}
