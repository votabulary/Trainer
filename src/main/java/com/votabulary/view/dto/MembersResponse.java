package com.votabulary.view.dto;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.votabulary.model.Member;

import java.util.Collections;
import java.util.List;

public class MembersResponse extends BaseResponse {
    private List<MemberResponse> players;

    public MembersResponse() {
        players = Collections.emptyList();
    }

    public MembersResponse(List<MemberResponse> players) {
        this.players = players;
    }

    public static MembersResponse fromModels(List<Member> models) {
        return new MembersResponse(Lists.transform(models, new FromModel()));
    }

    public List<MemberResponse> getPlayers() {
        return players;
    }

    public void setPlayers(List<MemberResponse> players) {
        this.players = players;
    }

    private static class FromModel implements Function<Member, MemberResponse> {
        @Override
        public MemberResponse apply(Member member) {
            return MemberResponse.fromModel(member);
        }
    }
}
