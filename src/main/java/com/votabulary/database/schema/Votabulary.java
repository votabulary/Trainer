/**
 * This class is generated by jOOQ
 */
package com.votabulary.database.schema;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Votabulary extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = -191430208;

	/**
	 * The singleton instance of <code>votabulary</code>
	 */
	public static final Votabulary VOTABULARY = new Votabulary();

	/**
	 * No further instances allowed
	 */
	private Votabulary() {
		super("votabulary");
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			com.votabulary.database.schema.tables.Member.MEMBER);
	}
}
