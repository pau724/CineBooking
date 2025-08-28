package model;

public class CinemaHall {
    private int number;
    private int capacity;

    public CinemaHall(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Hall " + number + " (Capacity: " + capacity + ")";
    }
}
