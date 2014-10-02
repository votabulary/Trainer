package com.nflpickem.controller;

import com.nflpickem.model.Player;

public class AdminPlayerService {

    public Player getPlayer(Long playerId) {
        if (playerId % 2 == 0)
            return null;
        return new Player()
                .setEmail("jason.schmitt@gmail.com")
                .setFirstName("Jason")
                .setLastName("Schmitt")
                .setId(playerId)
                .setUsername("jschmitt");
    }
}
