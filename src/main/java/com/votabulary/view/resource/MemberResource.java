package com.votabulary.view.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.votabulary.controller.MemberService;
import com.votabulary.controller.exceptions.MemberNotFoundException;
import com.votabulary.model.Member;
import com.votabulary.view.request.MemberRequest;
import com.votabulary.view.response.BaseResponse;
import com.votabulary.view.response.MemberResponse;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
public class MemberResource {

    @Inject
    private MemberService memberService;

    @Path("/{id: [0-9]+}")
    @GET
    @Timed
    public Response getPlayer(@PathParam("id")Long playerId) {
        try {
            Member member = memberService.getMember(playerId);
            return MemberResponse.fromModel(member).toJsonResponse(Response.Status.OK);
        } catch (MemberNotFoundException ex) {
            return new BaseResponse(ex.getMessage()).toJsonResponse(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Timed
    public Response getPlayers() {
        List<Member> members = memberService.getPlayers();
        return BaseResponse.toJsonResponse(members, Response.Status.OK);
    }

    @POST
    @Timed
    public Response addPlayer(@Valid MemberRequest request) {
        // TODO Create new member
        return new BaseResponse("Not yet supported!").toJsonResponse(Response.Status.FORBIDDEN);
    }
}
