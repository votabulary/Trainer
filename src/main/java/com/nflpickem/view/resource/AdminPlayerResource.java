package com.nflpickem.view.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.nflpickem.controller.AdminPlayerService;
import com.nflpickem.model.Player;
import com.nflpickem.view.dto.NFLPickemResponse;
import com.nflpickem.view.dto.PlayerDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin/player")
@Produces(MediaType.APPLICATION_JSON)
public class AdminPlayerResource {

    @Inject
    private AdminPlayerService playerService;

    @Path("/{id: [0-9]+}")
    @GET
    @Timed
    public Response getPlayer(@PathParam("id")Long playerId) {
        Player player = playerService.getPlayer(playerId);
        if (player == null)
            return new NFLPickemResponse().setMessage(String.format("Player (%s) could not be found.", playerId))
                    .toJsonResponse(Response.Status.NOT_FOUND);
        return PlayerDTO.fromModel(player).toJsonResponse(Response.Status.OK);
    }
}
