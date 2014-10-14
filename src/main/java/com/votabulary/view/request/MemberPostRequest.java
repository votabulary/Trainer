package com.votabulary.view.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class MemberPostRequest {
    @NotNull
    protected String firstName;
    @NotNull
    protected String lastName;
    @NotNull
    protected String email;
    @NotNull
    protected String state;
    @NotNull
    protected String county;
    @NotNull
    protected Integer precinct;
    @NotNull
    protected Boolean emailReminder;
    @NotNull
    protected Boolean smsReminder;

    @JsonCreator
    public MemberPostRequest(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("email") String email,
            @JsonProperty("state") String state,
            @JsonProperty("county") String county,
            @JsonProperty("precinct") Integer precinct,
            @JsonProperty("emailReminder") Boolean emailReminder,
            @JsonProperty("smsReminder") Boolean smsReminder
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.state = state;
        this.county = county;
        this.precinct = precinct;
        this.emailReminder = emailReminder;
        this.smsReminder = smsReminder;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
    }

    public Integer getPrecinct() {
        return precinct;
    }

    public Boolean getEmailReminder() {
        return emailReminder;
    }

    public Boolean getSmsReminder() {
        return smsReminder;
    }
}
