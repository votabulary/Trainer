package com.nflpickem;

import com.google.inject.AbstractModule;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Environment;

public class NFLPickemModule extends AbstractModule {
    private final NFLPickemConfiguration configuration;
    private final Environment environment;

    public NFLPickemModule(NFLPickemConfiguration configuration, Environment environment) {
        this.configuration = configuration;
        this.environment = environment;
    }

    @Override
    protected void configure() {
        bind(DataSourceFactory.class).toInstance(configuration.getDataSourceFactory());
        bind(Environment.class).toInstance(environment);

        install(new DatabaseModule());
    }
}
