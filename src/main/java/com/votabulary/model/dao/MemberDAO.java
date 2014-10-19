package com.votabulary.model.dao;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.votabulary.database.schema.tables.records.MemberRecord;
import com.votabulary.database.transaction.Transactional;
import com.votabulary.model.Member;
import org.jooq.Record;
import org.skife.jdbi.v2.TransactionIsolationLevel;

import java.util.List;

import static com.votabulary.database.schema.Tables.MEMBER;

public class MemberDAO extends AbstractDAO {

    @Transactional(TransactionIsolationLevel.REPEATABLE_READ)
    public List<Member> getMembers() {
        List<MemberRecord> records = jooq().selectFrom(MEMBER).fetch().into(MemberRecord.class);

        return Lists.transform(records, new MembersFromRecord());
    }

    @Transactional(TransactionIsolationLevel.REPEATABLE_READ)
    public Optional<Member> getMemberById(Long memberId) {
        MemberRecord record = jooq()
                .selectFrom(MEMBER)
                .where(MEMBER.ID.eq(memberId))
                .fetchOne()
                .into(MemberRecord.class);

        return (record == null)
                ? Optional.<Member>absent()
                : Optional.of(Member.fromRecord(record));
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
        record.setSmsNumber(member.getSmsNumber());
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
                    .withSmsReminder(record.getValue(MEMBER.SMS_REMINDER))
                    .withSmsNumber(record.getValue(MEMBER.SMS_NUMBER));
        }
    }

}
