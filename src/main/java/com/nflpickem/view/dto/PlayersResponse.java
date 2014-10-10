package com.nflpickem.view.dto;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.nflpickem.model.Player;

import java.util.Collections;
import java.util.List;

public class PlayersResponse extends NFLPickemResponse {
    private List<PlayerResponse> players;

    public PlayersResponse() {
        players = Collections.emptyList();
    }

    public PlayersResponse(List<PlayerResponse> players) {
        this.players = players;
    }

    public static PlayersResponse fromModels(List<Player> models) {
        return new PlayersResponse(Lists.transform(models, new FromModel()));
    }

    public List<PlayerResponse> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerResponse> players) {
        this.players = players;
    }

    private static class FromModel implements Function<Player, PlayerResponse> {
        @Override
        public PlayerResponse apply(Player player) {
            return PlayerResponse.fromModel(player);
        }
    }
}
