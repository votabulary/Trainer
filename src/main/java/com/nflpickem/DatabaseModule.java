package com.nflpickem;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.nflpickem.database.MysqlDBIProvider;
import com.nflpickem.database.transaction.Transactional;
import com.nflpickem.database.transaction.TransactionalInterceptor;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.skife.jdbi.v2.DBI;

public class DatabaseModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(DBI.class).toProvider(MysqlDBIProvider.class);
        // TODO make binding for MysqlDatabase...after making that class
        binder.bind(SQLDialect.class).toInstance(SQLDialect.MYSQL);
        binder.bind(Settings.class).toInstance(new Settings());

        TransactionalInterceptor transactionalInterceptor = new TransactionalInterceptor();
        binder.requestInjection(transactionalInterceptor);
        binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Transactional.class), transactionalInterceptor);
    }
}
