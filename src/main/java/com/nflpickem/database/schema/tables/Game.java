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
public class Game extends org.jooq.impl.TableImpl<com.nflpickem.database.schema.tables.records.GameRecord> {

	private static final long serialVersionUID = -1200959865;

	/**
	 * The singleton instance of <code>pickem.game</code>
	 */
	public static final com.nflpickem.database.schema.tables.Game GAME = new com.nflpickem.database.schema.tables.Game();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.nflpickem.database.schema.tables.records.GameRecord> getRecordType() {
		return com.nflpickem.database.schema.tables.records.GameRecord.class;
	}

	/**
	 * The column <code>pickem.game.id</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>pickem.game.version</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.Long> VERSION = createField("version", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>pickem.game.away_score</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.Integer> AWAY_SCORE = createField("away_score", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>pickem.game.away_team</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.String> AWAY_TEAM = createField("away_team", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>pickem.game.game_time</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.sql.Timestamp> GAME_TIME = createField("game_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

	/**
	 * The column <code>pickem.game.home_score</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.Integer> HOME_SCORE = createField("home_score", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>pickem.game.home_team</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.String> HOME_TEAM = createField("home_team", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>pickem.game.line</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.Double> LINE = createField("line", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * The column <code>pickem.game.offensive_yards</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.Double> OFFENSIVE_YARDS = createField("offensive_yards", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * The column <code>pickem.game.over_under</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.Double> OVER_UNDER = createField("over_under", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * The column <code>pickem.game.week_number</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.Integer> WEEK_NUMBER = createField("week_number", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>pickem.game.game_type</code>.
	 */
	public final org.jooq.TableField<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.String> GAME_TYPE = createField("game_type", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * Create a <code>pickem.game</code> table reference
	 */
	public Game() {
		this("game", null);
	}

	/**
	 * Create an aliased <code>pickem.game</code> table reference
	 */
	public Game(java.lang.String alias) {
		this(alias, com.nflpickem.database.schema.tables.Game.GAME);
	}

	private Game(java.lang.String alias, org.jooq.Table<com.nflpickem.database.schema.tables.records.GameRecord> aliased) {
		this(alias, aliased, null);
	}

	private Game(java.lang.String alias, org.jooq.Table<com.nflpickem.database.schema.tables.records.GameRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.nflpickem.database.schema.Pickem.PICKEM, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.nflpickem.database.schema.tables.records.GameRecord, java.lang.Long> getIdentity() {
		return com.nflpickem.database.schema.Keys.IDENTITY_GAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.nflpickem.database.schema.tables.records.GameRecord> getPrimaryKey() {
		return com.nflpickem.database.schema.Keys.KEY_GAME_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.nflpickem.database.schema.tables.records.GameRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.nflpickem.database.schema.tables.records.GameRecord>>asList(com.nflpickem.database.schema.Keys.KEY_GAME_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.nflpickem.database.schema.tables.Game as(java.lang.String alias) {
		return new com.nflpickem.database.schema.tables.Game(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.nflpickem.database.schema.tables.Game rename(java.lang.String name) {
		return new com.nflpickem.database.schema.tables.Game(name, null);
	}
}
