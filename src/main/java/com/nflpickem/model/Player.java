package com.nflpickem.model;

public class Player {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;

    public Long getId() {
        return id;
    }

    public Player withId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Player withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Player withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Player withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Player withUsername(String username) {
        this.username = username;
        return this;
    }
}
