package com.votabulary.view.response;

import com.votabulary.model.Member;

public class MemberResponse extends BaseResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String county;
    private String state;
    private Integer precinct;
    private Boolean emailReminder;
    private Boolean smsReminder;

    public static MemberResponse fromModel(Member model) {
        return new MemberResponse()
                .withEmail(model.getEmail())
                .withFirstName(model.getFirstName())
                .withLastName(model.getLastName())
                .withId(model.getId())
                .withCounty(model.getCounty())
                .withEmailReminder(model.getEmailReminder())
                .withPrecinct(model.getPrecinct())
                .withSmsReminder(model.getSmsReminder())
                .withState(model.getState());
    }

    public Long getId() {
        return id;
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

    public String getCounty() {
        return county;
    }

    public String getState() {
        return state;
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

    public MemberResponse withId(Long id) {
        this.id = id;
        return this;
    }

    public MemberResponse withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MemberResponse withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MemberResponse withEmail(String email) {
        this.email = email;
        return this;
    }

    public MemberResponse withCounty(String county) {
        this.county = county;
        return this;
    }

    public MemberResponse withState(String state) {
        this.state = state;
        return this;
    }

    public MemberResponse withPrecinct(Integer precinct) {
        this.precinct = precinct;
        return this;
    }

    public MemberResponse withEmailReminder(Boolean emailReminder) {
        this.emailReminder = emailReminder;
        return this;
    }

    public MemberResponse withSmsReminder(Boolean smsReminder) {
        this.smsReminder = smsReminder;
        return this;
    }
}
