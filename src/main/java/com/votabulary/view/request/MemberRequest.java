package com.votabulary.view.request;

import javax.validation.constraints.NotNull;

public class MemberRequest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
}
