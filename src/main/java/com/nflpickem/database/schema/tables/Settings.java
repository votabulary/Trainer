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
public class Settings extends org.jooq.impl.TableImpl<com.nflpickem.database.schema.tables.records.SettingsRecord> {

	private static final long serialVersionUID = -527354624;

	/**
	 * The singleton instance of <code>pickem.settings</code>
	 */
	public static final com.nflpickem.database.schema.tables.Settings SETTINGS = new com.nflpickem.database.schema.tables.Settings();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.nflpickem.database.schema.tables.records.SettingsRecord> getRecordType() {
		return com.nflpickem.database.schema.tables.records.SettingsRecord.class;
	}

	/**
	 * The column <code>pickem.settings.id</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.SettingsRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>pickem.settings.version</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.SettingsRecord, java.lang.Long> VERSION = createField("version", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>pickem.settings.commish_note</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.SettingsRecord, java.lang.String> COMMISH_NOTE = createField("commish_note", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>pickem.settings.league_password</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.SettingsRecord, java.lang.String> LEAGUE_PASSWORD = createField("league_password", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>pickem.settings.second_pot_start_week</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.SettingsRecord, java.lang.Integer> SECOND_POT_START_WEEK = createField("second_pot_start_week", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>pickem.settings.winners_per_week</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.SettingsRecord, java.lang.Integer> WINNERS_PER_WEEK = createField("winners_per_week", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>pickem.settings</code> table reference
	 */
	public Settings() {
		this("settings", null);
	}

	/**
	 * Create an aliased <code>pickem.settings</code> table reference
	 */
	public Settings(java.lang.String alias) {
		this(alias, com.nflpickem.database.schema.tables.Settings.SETTINGS);
	}

	private Settings(java.lang.String alias, org.jooq.Table<com.nflpickem.database.schema.tables.records.SettingsRecord> aliased) {
		this(alias, aliased, null);
	}

	private Settings(java.lang.String alias, org.jooq.Table<com.nflpickem.database.schema.tables.records.SettingsRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.nflpickem.database.schema.Pickem.PICKEM, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.nflpickem.database.schema.tables.records.SettingsRecord, java.lang.Long> getIdentity() {
		return com.nflpickem.database.schema.Keys.IDENTITY_SETTINGS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.nflpickem.database.schema.tables.records.SettingsRecord> getPrimaryKey() {
		return com.nflpickem.database.schema.Keys.KEY_SETTINGS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.nflpickem.database.schema.tables.records.SettingsRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.nflpickem.database.schema.tables.records.SettingsRecord>>asList(com.nflpickem.database.schema.Keys.KEY_SETTINGS_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.nflpickem.database.schema.tables.Settings as(java.lang.String alias) {
		return new com.nflpickem.database.schema.tables.Settings(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.nflpickem.database.schema.tables.Settings rename(java.lang.String name) {
		return new com.nflpickem.database.schema.tables.Settings(name, null);
	}
}