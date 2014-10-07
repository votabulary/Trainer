/**
 * This class is generated by jOOQ
 */
package com.nflpickem.database.schema.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Faq extends org.jooq.impl.TableImpl<com.nflpickem.database.schema.tables.records.FaqRecord> {

	private static final long serialVersionUID = -1307397903;

	/**
	 * The singleton instance of <code>pickem.faq</code>
	 */
	public static final com.nflpickem.database.schema.tables.Faq FAQ = new com.nflpickem.database.schema.tables.Faq();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.nflpickem.database.schema.tables.records.FaqRecord> getRecordType() {
		return com.nflpickem.database.schema.tables.records.FaqRecord.class;
	}

	/**
	 * The column <code>pickem.faq.id</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.FaqRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>pickem.faq.version</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.FaqRecord, java.lang.Long> VERSION = createField("version", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>pickem.faq.html_answer</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.FaqRecord, java.lang.String> HTML_ANSWER = createField("html_answer", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>pickem.faq.question</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.FaqRecord, java.lang.String> QUESTION = createField("question", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>pickem.faq.faq_type</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.FaqRecord, java.lang.String> FAQ_TYPE = createField("faq_type", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * Create a <code>pickem.faq</code> table reference
	 */
	public Faq() {
		this("faq", null);
	}

	/**
	 * Create an aliased <code>pickem.faq</code> table reference
	 */
	public Faq(java.lang.String alias) {
		this(alias, com.nflpickem.database.schema.tables.Faq.FAQ);
	}

	private Faq(java.lang.String alias, org.jooq.Table<com.nflpickem.database.schema.tables.records.FaqRecord> aliased) {
		this(alias, aliased, null);
	}

	private Faq(java.lang.String alias, org.jooq.Table<com.nflpickem.database.schema.tables.records.FaqRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.nflpickem.database.schema.Pickem.PICKEM, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.nflpickem.database.schema.tables.records.FaqRecord, java.lang.Long> getIdentity() {
		return com.nflpickem.database.schema.Keys.IDENTITY_FAQ;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.nflpickem.database.schema.tables.records.FaqRecord> getPrimaryKey() {
		return com.nflpickem.database.schema.Keys.KEY_FAQ_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.nflpickem.database.schema.tables.records.FaqRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.nflpickem.database.schema.tables.records.FaqRecord>>asList(com.nflpickem.database.schema.Keys.KEY_FAQ_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.nflpickem.database.schema.tables.Faq as(java.lang.String alias) {
		return new com.nflpickem.database.schema.tables.Faq(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.nflpickem.database.schema.tables.Faq rename(java.lang.String name) {
		return new com.nflpickem.database.schema.tables.Faq(name, null);
	}
}