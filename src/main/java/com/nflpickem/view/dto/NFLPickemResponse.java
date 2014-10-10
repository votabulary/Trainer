package com.nflpickem.view.dto;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NFLPickemResponse {
    private String message;

    public NFLPickemResponse() {}

    public NFLPickemResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public NFLPickemResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    public Response toJsonResponse(Response.Status httpStatus) {
        return Response
                .status(httpStatus)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(this)
                .build();
    }

}
