/**
 * This class is generated by jOOQ
 */
package com.votabulary.database.schema;

/**
 * This class is generated by jOOQ.
 *
 * A class modelling foreign key relationships between tables of the <code>votabulary</code> 
 * schema
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.Identity<com.votabulary.database.schema.tables.records.MemberRecord, java.lang.Long> IDENTITY_MEMBER = Identities0.IDENTITY_MEMBER;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.UniqueKey<com.votabulary.database.schema.tables.records.MemberRecord> KEY_MEMBER_PRIMARY = UniqueKeys0.KEY_MEMBER_PRIMARY;
	public static final org.jooq.UniqueKey<com.votabulary.database.schema.tables.records.MemberRecord> KEY_MEMBER_IDX_EMAIL = UniqueKeys0.KEY_MEMBER_IDX_EMAIL;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends org.jooq.impl.AbstractKeys {
		public static org.jooq.Identity<com.votabulary.database.schema.tables.records.MemberRecord, java.lang.Long> IDENTITY_MEMBER = createIdentity(com.votabulary.database.schema.tables.Member.MEMBER, com.votabulary.database.schema.tables.Member.MEMBER.ID);
	}

	private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.UniqueKey<com.votabulary.database.schema.tables.records.MemberRecord> KEY_MEMBER_PRIMARY = createUniqueKey(com.votabulary.database.schema.tables.Member.MEMBER, com.votabulary.database.schema.tables.Member.MEMBER.ID);
		public static final org.jooq.UniqueKey<com.votabulary.database.schema.tables.records.MemberRecord> KEY_MEMBER_IDX_EMAIL = createUniqueKey(com.votabulary.database.schema.tables.Member.MEMBER, com.votabulary.database.schema.tables.Member.MEMBER.EMAIL);
	}
}
