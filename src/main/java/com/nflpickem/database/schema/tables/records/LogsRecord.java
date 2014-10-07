/**
 * This class is generated by jOOQ
 */
package com.nflpickem.database.schema.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LogsRecord extends org.jooq.impl.UpdatableRecordImpl<com.nflpickem.database.schema.tables.records.LogsRecord> implements org.jooq.Record5<org.jooq.types.UInteger, java.sql.Timestamp, java.lang.String, java.lang.String, java.lang.String> {

	private static final long serialVersionUID = -572702981;

	/**
	 * Setter for <code>pickem.logs.log_id</code>.
	 */
	public void setLogId(org.jooq.types.UInteger value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>pickem.logs.log_id</code>.
	 */
	public org.jooq.types.UInteger getLogId() {
		return (org.jooq.types.UInteger) getValue(0);
	}

	/**
	 * Setter for <code>pickem.logs.time_stamp</code>.
	 */
	public void setTimeStamp(java.sql.Timestamp value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>pickem.logs.time_stamp</code>.
	 */
	public java.sql.Timestamp getTimeStamp() {
		return (java.sql.Timestamp) getValue(1);
	}

	/**
	 * Setter for <code>pickem.logs.logger</code>.
	 */
	public void setLogger(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>pickem.logs.logger</code>.
	 */
	public java.lang.String getLogger() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>pickem.logs.priority</code>.
	 */
	public void setPriority(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>pickem.logs.priority</code>.
	 */
	public java.lang.String getPriority() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>pickem.logs.message</code>.
	 */
	public void setMessage(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>pickem.logs.message</code>.
	 */
	public java.lang.String getMessage() {
		return (java.lang.String) getValue(4);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<org.jooq.types.UInteger> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<org.jooq.types.UInteger, java.sql.Timestamp, java.lang.String, java.lang.String, java.lang.String> fieldsRow() {
		return (org.jooq.Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<org.jooq.types.UInteger, java.sql.Timestamp, java.lang.String, java.lang.String, java.lang.String> valuesRow() {
		return (org.jooq.Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<org.jooq.types.UInteger> field1() {
		return com.nflpickem.database.schema.tables.Logs.LOGS.LOG_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.sql.Timestamp> field2() {
		return com.nflpickem.database.schema.tables.Logs.LOGS.TIME_STAMP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return com.nflpickem.database.schema.tables.Logs.LOGS.LOGGER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return com.nflpickem.database.schema.tables.Logs.LOGS.PRIORITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return com.nflpickem.database.schema.tables.Logs.LOGS.MESSAGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.types.UInteger value1() {
		return getLogId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.sql.Timestamp value2() {
		return getTimeStamp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return getLogger();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getPriority();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getMessage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LogsRecord value1(org.jooq.types.UInteger value) {
		setLogId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LogsRecord value2(java.sql.Timestamp value) {
		setTimeStamp(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LogsRecord value3(java.lang.String value) {
		setLogger(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LogsRecord value4(java.lang.String value) {
		setPriority(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LogsRecord value5(java.lang.String value) {
		setMessage(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LogsRecord values(org.jooq.types.UInteger value1, java.sql.Timestamp value2, java.lang.String value3, java.lang.String value4, java.lang.String value5) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached LogsRecord
	 */
	public LogsRecord() {
		super(com.nflpickem.database.schema.tables.Logs.LOGS);
	}

	/**
	 * Create a detached, initialised LogsRecord
	 */
	public LogsRecord(org.jooq.types.UInteger logId, java.sql.Timestamp timeStamp, java.lang.String logger, java.lang.String priority, java.lang.String message) {
		super(com.nflpickem.database.schema.tables.Logs.LOGS);

		setValue(0, logId);
		setValue(1, timeStamp);
		setValue(2, logger);
		setValue(3, priority);
		setValue(4, message);
	}
}
