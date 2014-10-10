package com.votabulary.model.dao;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.votabulary.database.transaction.Transactional;
import com.votabulary.model.Member;
import org.jooq.Record;
import org.jooq.Result;
import org.skife.jdbi.v2.TransactionIsolationLevel;

import java.util.List;

import static com.votabulary.database.schema.Tables.MEMBER;

public class MemberDAO extends AbstractDAO {

    @Transactional(TransactionIsolationLevel.REPEATABLE_READ)
    public List<Member> getMembers() {
        Result<? extends Record> results = jooq().select(
                MEMBER.ID,
                MEMBER.FIRST_NAME,
                MEMBER.LAST_NAME,
                MEMBER.EMAIL)
                .from(MEMBER).fetch();

        return Lists.transform(results, new MembersFromRecord());
    }

    @Transactional(TransactionIsolationLevel.REPEATABLE_READ)
    public Optional<Member> getMemberById(Long memberId) {
        Result<? extends Record> results = jooq().select(
                MEMBER.ID,
                MEMBER.FIRST_NAME,
                MEMBER.LAST_NAME,
                MEMBER.EMAIL)
                .from(MEMBER)
                .where(MEMBER.ID.eq(memberId))
                .fetch();

        List<Member> members = Lists.transform(results, new MembersFromRecord());
        return (members.size() == 0)
                ? Optional.<Member>absent()
                : Optional.of(members.get(0));
    }

    private static class MembersFromRecord implements Function<Record, Member> {
        @Override
        public Member apply(Record record) {
            return new Member()
                    .withEmail(record.getValue(MEMBER.EMAIL))
                    .withFirstName(record.getValue(MEMBER.FIRST_NAME))
                    .withLastName(record.getValue(MEMBER.LAST_NAME))
                    .withId(record.getValue(MEMBER.ID));
        }
    }

}
