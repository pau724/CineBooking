package service;

import model.Movie;
import model.CinemaHall;
import java.util.ArrayList;
import java.util.List;

public class CinemaService {
    private List<Movie> movies;
    private List<CinemaHall> halls;

    public CinemaService() {
        this.movies = new ArrayList<>();
        this.halls = new ArrayList<>();

        // Preload some sample data (like a real cinema)
        movies.add(new Movie("Inception", "Sci-Fi", 148));
        movies.add(new Movie("The Dark Knight", "Action", 152));
        movies.add(new Movie("Interstellar", "Sci-Fi", 169));
        movies.add(new Movie("The Matrix", "Action", 136));

        halls.add(new CinemaHall(1, 50));
        halls.add(new CinemaHall(2, 100));
        halls.add(new CinemaHall(3, 80));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<CinemaHall> getHalls() {
        return halls;
    }

    public void addMovie(String title, String genre, int duration) {
        movies.add(new Movie(title, genre, duration));
        System.out.println("Movie added successfully: " + title);
    }

    public void showMovies() {
        System.out.println("\n=== MOVIE LIST ===");
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
        } else {
            for (int i = 0; i < movies.size(); i++) {
                System.out.println((i + 1) + ". " + movies.get(i));
            }
        }
    }
}

