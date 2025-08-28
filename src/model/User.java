package model;

public class User {
    private String name;
    private String email;
    private boolean admin;

    public User(String name, String email, boolean admin) {
        this.name = name;
        this.email = email;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return name + " (" + (admin ? "Admin" : "Customer") + ")";
    }
}
