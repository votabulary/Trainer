package com.votabulary.view.response;

import com.votabulary.model.Member;

public class MemberResponse extends BaseResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static MemberResponse fromModel(Member model) {
        return new MemberResponse()
                .setEmail(model.getEmail())
                .setFirstName(model.getFirstName())
                .setLastName(model.getLastName())
                .setId(model.getId());
    }

    public Long getId() {
        return id;
    }

    public MemberResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public MemberResponse setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public MemberResponse setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MemberResponse setEmail(String email) {
        this.email = email;
        return this;
    }
}
