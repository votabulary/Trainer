package com.nflpickem.view.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.nflpickem.controller.AdminPlayerService;
import com.nflpickem.controller.exceptions.PlayerNotFoundException;
import com.nflpickem.model.Player;
import com.nflpickem.view.dto.NFLPickemResponse;
import com.nflpickem.view.dto.PlayerResponse;
import com.nflpickem.view.dto.PlayersResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin/player")
@Produces(MediaType.APPLICATION_JSON)
public class AdminPlayerResource {

    @Inject
    private AdminPlayerService playerService;

    @Path("/{id: [0-9]+}")
    @GET
    @Timed
    public Response getPlayer(@PathParam("id")Long playerId) {
        try {
            Player player = playerService.getPlayer(playerId);
            return PlayerResponse.fromModel(player).toJsonResponse(Response.Status.OK);
        } catch (PlayerNotFoundException ex) {
            return new NFLPickemResponse(ex.getMessage()).toJsonResponse(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Timed
    public Response getPlayers() {
        List<Player> players = playerService.getPlayers();
        return PlayersResponse.fromModels(players).toJsonResponse(Response.Status.OK);
    }
}
