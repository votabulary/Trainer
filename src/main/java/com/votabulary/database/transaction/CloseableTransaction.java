package com.votabulary.database.transaction;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.TransactionIsolationLevel;

import java.sql.Connection;

public abstract class CloseableTransaction implements AutoCloseable {

    protected final Handle handle;

    private CloseableTransaction(Handle handle) {
        this.handle = handle;
    }

    public Handle getHandle() {
        return handle;
    }

    public Connection getConnection() {
        return handle.getConnection();
    }

    protected abstract int getNestingLevel();

    public abstract void commit();

    static class TopLevelTransaction extends CloseableTransaction {

        private final Runnable onCloseCallback;
        private boolean commitDone = false;

        TopLevelTransaction(Handle handle, TransactionIsolationLevel isolationLevel, Runnable onCloseCallback) {
            super(handle);
            this.onCloseCallback = onCloseCallback;

            handle.setTransactionIsolation(isolationLevel);
            handle.begin();
        }

        @Override
        protected int getNestingLevel() {
            return 0;
        }

        @Override
        public void commit() {
            if (commitDone) {
                throw new IllegalStateException("Commit called multiple times on the same transaction.");
            }
            handle.commit();
            commitDone = true;
        }

        @Override
        public void close() {
            if (!commitDone) {
                handle.rollback();
            }
            handle.close();
            if (onCloseCallback != null) {
                onCloseCallback.run();
            }
        }
    }

    static class NestedTransaction extends CloseableTransaction {

        private final Runnable onCloseCallback;
        private final int nestingLevel;
        private final String savePointName;
        private boolean commitDone = false;

        NestedTransaction(CloseableTransaction transaction, Runnable onCloseCallback) {
            super(transaction.getHandle());
            this.onCloseCallback = onCloseCallback;
            nestingLevel = transaction.getNestingLevel() + 1;
            savePointName = "NESTED_" + nestingLevel;
            handle.checkpoint(savePointName);
        }

        @Override
        protected int getNestingLevel() {
            return nestingLevel;
        }

        @Override
        public void commit() {
            if (commitDone) {
                throw new IllegalStateException("Commit called multiple times on the same transaction.");
            }
            handle.release(savePointName);
            commitDone = true;
        }

        @Override
        public void close() {
            if (!commitDone) {
                handle.rollback(savePointName);
            }
            if (onCloseCallback != null) {
                onCloseCallback.run();
            }
        }
    }
}
