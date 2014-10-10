package com.votabulary.view.response;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BaseResponse {
    private String message;

    public BaseResponse() {}

    public BaseResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse withMessage(String message) {
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

    public static Response toJsonResponse(Object entity, Response.Status httpStatus) {
        return Response
                .status(httpStatus)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(entity)
                .build();
    }

}
