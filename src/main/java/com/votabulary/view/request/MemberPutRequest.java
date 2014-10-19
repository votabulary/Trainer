package com.votabulary.view.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class MemberPutRequest extends MemberPostRequest {
    @NotNull
    protected Long id;

    @JsonCreator
    public MemberPutRequest(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("email") String email,
            @JsonProperty("state") String state,
            @JsonProperty("county") String county,
            @JsonProperty("precinct") Integer precinct,
            @JsonProperty("emailReminder") Boolean emailReminder,
            @JsonProperty("smsReminder") Boolean smsReminder,
            @JsonProperty("smsNumber") String smsNumber,
            @JsonProperty("id") Long id
    ) {
        super(firstName, lastName, email, state, county, precinct, emailReminder, smsReminder, smsNumber);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
