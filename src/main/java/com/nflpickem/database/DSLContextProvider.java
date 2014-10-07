package com.nflpickem.database;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.nflpickem.database.transaction.TransactionManager;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

import java.sql.Connection;

public class DSLContextProvider implements Provider<DSLContext> {

    @Inject
    private TransactionManager transactionManager;
    @Inject
    private SQLDialect dialect;
    @Inject
    private Settings settings;

    @Override
    public DSLContext get() {
        Connection connection = transactionManager.getTransactionConnection();
        return DSL.using(connection, dialect, settings);
    }
}
