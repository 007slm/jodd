// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package jodd.db;

import jodd.exception.UncheckedException;
import jodd.exception.ExceptionUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Unchecked SQL exception.
 */
public class DbSqlException extends UncheckedException {

	public DbSqlException(Throwable t) {
		super(t);
	}

	public DbSqlException(String message) {
		super(message);
	}

	public DbSqlException(DbQueryBase dbQuery, String message) {
		super(message + "\nQuery: " + dbQuery.getQueryString());
	}

	public DbSqlException(String message, Throwable t) {
		super(message, t);
	}

	public DbSqlException(List<SQLException> sexs) {
		this(ExceptionUtil.rollupSqlExceptions(sexs));
	}

	public DbSqlException(String message, List<SQLException> sexs) {
		this(message, ExceptionUtil.rollupSqlExceptions(sexs));
	}

	public DbSqlException(DbQueryBase dbQuery, String message, Throwable t) {
		super(message + "\nQuery: " + dbQuery.getQueryString(), t);
	}

}