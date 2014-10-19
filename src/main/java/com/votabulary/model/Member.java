package com.votabulary.model;

import com.votabulary.database.schema.tables.records.MemberRecord;
import com.votabulary.view.request.MemberPostRequest;
import com.votabulary.view.request.MemberPutRequest;

public class Member {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String state;
    private String county;
    private Integer precinct;
    private Boolean emailReminder;
    private Boolean smsReminder;
    private String smsNumber;

    public static Member fromRequest(MemberPostRequest request) {
        Member member = new Member()
                .withFirstName(request.getFirstName())
                .withLastName(request.getLastName())
                .withEmail(request.getEmail())
                .withState(request.getState())
                .withCounty(request.getCounty())
                .withPrecinct(request.getPrecinct())
                .withEmailReminder(request.getEmailReminder())
                .withSmsReminder(request.getSmsReminder())
                .withSmsNumber(request.getSmsNumber());
        if (request instanceof MemberPutRequest) {
            member.withId(((MemberPutRequest)request).getId());
        }
        return member;
    }

    public static Member fromRecord(MemberRecord record) {
        return new Member()
                .withId(record.getId())
                .withFirstName(record.getFirstName())
                .withLastName(record.getLastName())
                .withEmail(record.getEmail())
                .withState(record.getState())
                .withCounty(record.getCounty())
                .withPrecinct(record.getPrecinct())
                .withEmailReminder(record.getEmailReminder())
                .withSmsReminder(record.getSmsReminder())
                .withSmsNumber(record.getSmsNumber());
    }

    public Long getId() {
        return id;
    }

    public Member withId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Member withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Member withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Member withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getState() {
        return state;
    }

    public Member withState(String state) {
        this.state = state;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public Member withCounty(String county) {
        this.county = county;
        return this;
    }

    public Integer getPrecinct() {
        return precinct;
    }

    public Member withPrecinct(Integer precinct) {
        this.precinct = precinct;
        return this;
    }

    public Boolean getEmailReminder() {
        return emailReminder;
    }

    public Member withEmailReminder(Boolean emailReminder) {
        this.emailReminder = emailReminder;
        return this;
    }

    public Boolean getSmsReminder() {
        return smsReminder;
    }

    public Member withSmsReminder(Boolean smsReminder) {
        this.smsReminder = smsReminder;
        return this;
    }

    public String getSmsNumber() {
        return smsNumber;
    }

    public Member withSmsNumber(String smsNumber) {
        this.smsNumber = smsNumber;
        return this;
    }
}
