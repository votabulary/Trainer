package com.votabulary.view.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.votabulary.controller.MemberService;
import com.votabulary.controller.exceptions.MemberNotFoundException;
import com.votabulary.model.Member;
import com.votabulary.view.request.MemberPostRequest;
import com.votabulary.view.request.MemberPutRequest;
import com.votabulary.view.response.BaseResponse;

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
    public Response getMember(@PathParam("id") Long memberId) {
        try {
            Member member = memberService.getMember(memberId);
            return BaseResponse.toJsonResponse(member, Response.Status.OK);
        } catch (MemberNotFoundException ex) {
            return new BaseResponse(ex.getMessage()).toJsonResponse(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Timed
    public Response getMembers() {
        List<Member> members = memberService.getMembers();
        return BaseResponse.toJsonResponse(members, Response.Status.OK);
    }

    @POST
    @Timed
    public Response addPlayer(@Valid final MemberPostRequest request) {
        Member member = memberService.addMember(Member.fromRequest(request));

        return BaseResponse.toJsonResponse(member, Response.Status.OK);
    }

    @PUT
    @Timed
    public Response updatePlayer(@Valid final MemberPutRequest request) {
        Member member = memberService.updateMember(Member.fromRequest(request));

        return BaseResponse.toJsonResponse(member, Response.Status.OK);
    }
}
