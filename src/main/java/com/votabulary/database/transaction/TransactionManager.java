package com.votabulary.database.transaction;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.TransactionIsolationLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.votabulary.database.transaction.CloseableTransaction.NestedTransaction;
import com.votabulary.database.transaction.CloseableTransaction.TopLevelTransaction;

import java.sql.Connection;

@Singleton
public class TransactionManager {

    private static final Logger log = LoggerFactory.getLogger(TransactionManager.class);

    private final ThreadLocal<CloseableTransaction> context = new ThreadLocal<>();

    @Inject
    private DBI jdbi;

    public boolean isTransactionInProgress() {
        return context.get() != null;
    }

    public CloseableTransaction beginTransaction(TransactionIsolationLevel isolationLevel) {
        CloseableTransaction newTransaction;
        if (isTransactionInProgress()) {
            if (getCurrentIsolationLevel().intValue() < isolationLevel.intValue()) {
                log.warn("Nested transaction has higher isolation level.", new Exception());
            }
            newTransaction = new NestedTransaction(context.get(), new OnCloseNested(context.get()));
        } else {
            newTransaction = new TopLevelTransaction(jdbi.open(), isolationLevel, onCloseTopLevel);
        }
        context.set(newTransaction);
        return newTransaction;
    }

    private CloseableTransaction getTransaction() {
        if (!isTransactionInProgress()) {
            throw new IllegalStateException("Transaction is not in progress.");
        }
        return context.get();
    }

    public Connection getTransactionConnection() {
        return getTransaction().getConnection();
    }

    public TransactionIsolationLevel getCurrentIsolationLevel() {
        return getTransaction().getHandle().getTransactionIsolationLevel();
    }

    private final Runnable onCloseTopLevel = new Runnable() {
        @Override
        public void run() {
            context.remove();
        }
    };

    private final class OnCloseNested implements Runnable {

        private final CloseableTransaction old;

        private OnCloseNested(CloseableTransaction old) {
            this.old = old;
        }

        @Override
        public void run() {
            context.set(old);
        }
    }

}
