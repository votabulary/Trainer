package com.nflpickem.controller;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.nflpickem.controller.exceptions.PlayerNotFoundException;
import com.nflpickem.model.Player;
import com.nflpickem.model.dao.PlayerDAO;

import java.util.List;

public class AdminPlayerService {

    @Inject
    private PlayerDAO playerDAO;

    public Player getPlayer(Long playerId) {
        Optional<Player> player = playerDAO.getPlayerById(playerId);
        if (!player.isPresent())
            throw new PlayerNotFoundException(String.format("Player (%d) not found.", playerId));

        return player.get();
    }

    public List<Player> getPlayers() {
        return playerDAO.getPlayers();
    }
}
