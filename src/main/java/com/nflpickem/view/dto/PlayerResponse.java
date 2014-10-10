package com.nflpickem.view.dto;

import com.nflpickem.model.Player;

public class PlayerResponse extends NFLPickemResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static PlayerResponse fromModel(Player model) {
        return new PlayerResponse()
                .setEmail(model.getEmail())
                .setFirstName(model.getFirstName())
                .setLastName(model.getLastName())
                .setId(model.getId());
    }

    public Long getId() {
        return id;
    }

    public PlayerResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PlayerResponse setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PlayerResponse setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PlayerResponse setEmail(String email) {
        this.email = email;
        return this;
    }
}
