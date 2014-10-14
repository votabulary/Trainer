package com.votabulary.model.dao;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.votabulary.database.schema.tables.records.MemberRecord;
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
                MEMBER.EMAIL,
                MEMBER.COUNTY,
                MEMBER.STATE,
                MEMBER.PRECINCT,
                MEMBER.EMAIL_REMINDER,
                MEMBER.SMS_REMINDER)
                .from(MEMBER).fetch();

        return Lists.transform(results, new MembersFromRecord());
    }

    @Transactional(TransactionIsolationLevel.REPEATABLE_READ)
    public Optional<Member> getMemberById(Long memberId) {
        Result<? extends Record> results = jooq().select(
                MEMBER.ID,
                MEMBER.FIRST_NAME,
                MEMBER.LAST_NAME,
                MEMBER.EMAIL,
                MEMBER.COUNTY,
                MEMBER.STATE,
                MEMBER.PRECINCT,
                MEMBER.EMAIL_REMINDER,
                MEMBER.SMS_REMINDER)
                .from(MEMBER)
                .where(MEMBER.ID.eq(memberId))
                .fetch();

        List<Member> members = Lists.transform(results, new MembersFromRecord());
        return (members.size() == 0)
                ? Optional.<Member>absent()
                : Optional.of(members.get(0));
    }

    @Transactional(TransactionIsolationLevel.SERIALIZABLE)
    public Member addMember(Member member) {
        MemberRecord record = toRecord(member);
        record.insert();

        return Member.fromRecord(record);
    }

    @Transactional(TransactionIsolationLevel.SERIALIZABLE)
    public Member updateMember(Member member) {
        MemberRecord record = toRecord(member);
        record.update();

        return Member.fromRecord(record);
    }

    private MemberRecord toRecord(Member member) {
        MemberRecord record = jooq().newRecord(MEMBER);
        record.setEmail(member.getEmail());
        record.setFirstName(member.getFirstName());
        record.setLastName(member.getLastName());
        record.setState(member.getState());
        record.setCounty(member.getCounty());
        record.setPrecinct(member.getPrecinct());
        record.setEmailReminder(member.getEmailReminder());
        record.setSmsReminder(member.getSmsReminder());
        if (member.getId() != null)
            record.setId(member.getId());
        return record;
    }

    private static class MembersFromRecord implements Function<Record, Member> {
        @Override
        public Member apply(Record record) {
            return new Member()
                    .withEmail(record.getValue(MEMBER.EMAIL))
                    .withFirstName(record.getValue(MEMBER.FIRST_NAME))
                    .withLastName(record.getValue(MEMBER.LAST_NAME))
                    .withId(record.getValue(MEMBER.ID))
                    .withCounty(record.getValue(MEMBER.COUNTY))
                    .withState(record.getValue(MEMBER.STATE))
                    .withPrecinct(record.getValue(MEMBER.PRECINCT))
                    .withEmailReminder(record.getValue(MEMBER.EMAIL_REMINDER))
                    .withSmsReminder(record.getValue(MEMBER.SMS_REMINDER));
        }
    }

}
