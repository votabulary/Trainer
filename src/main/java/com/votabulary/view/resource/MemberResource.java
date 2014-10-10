package com.votabulary.view.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.votabulary.controller.MemberService;
import com.votabulary.controller.exceptions.MemberNotFoundException;
import com.votabulary.model.Member;
import com.votabulary.view.dto.BaseResponse;
import com.votabulary.view.dto.MemberResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
//        return MembersResponse.fromModels(members).toJsonResponse(Response.Status.OK);
        return BaseResponse.toJsonResponse(members, Response.Status.OK);
    }
}
