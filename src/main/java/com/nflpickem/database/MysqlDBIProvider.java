package com.nflpickem.database;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class MysqlDBIProvider implements Provider<DBI> {
    @Inject
    Environment environment;
    @Inject
    DataSourceFactory databaseConfiguration;

    @Override
    public DBI get() {
        final DBIFactory factory = new DBIFactory();
        try {
            return factory.build(environment, databaseConfiguration, "mysql");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
