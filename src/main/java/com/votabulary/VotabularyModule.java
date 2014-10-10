package com.votabulary;

import com.google.inject.AbstractModule;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Environment;

public class VotabularyModule extends AbstractModule {
    private final VotabularyConfiguration configuration;
    private final Environment environment;

    public VotabularyModule(VotabularyConfiguration configuration, Environment environment) {
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
