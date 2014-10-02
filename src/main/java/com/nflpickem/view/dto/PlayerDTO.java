package com.nflpickem.view.dto;

import com.nflpickem.model.Player;

public class PlayerDTO extends NFLPickemResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static PlayerDTO fromModel(Player model) {
        return new PlayerDTO()
                .setEmail(model.getEmail())
                .setFirstName(model.getFirstName())
                .setLastName(model.getLastName())
                .setId(model.getId());
    }

    public Long getId() {
        return id;
    }

    public PlayerDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PlayerDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PlayerDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PlayerDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
