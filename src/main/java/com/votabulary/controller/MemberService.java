package com.votabulary.controller;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.votabulary.controller.exceptions.MemberNotFoundException;
import com.votabulary.model.Member;
import com.votabulary.model.dao.MemberDAO;

import java.util.List;

public class MemberService {

    @Inject
    private MemberDAO memberDAO;

    public Member getMember(Long memberId) {
        Optional<Member> member = memberDAO.getMemberById(memberId);
        if (!member.isPresent())
            throw new MemberNotFoundException(String.format("Player (%d) not found.", memberId));

        return member.get();
    }

    public List<Member> getMembers() {
        return memberDAO.getMembers();
    }

    public Member addMember(Member member) {
        return memberDAO.addMember(member);
    }

    public Member updateMember(Member member) {
        return memberDAO.updateMember(member);
    }
}
