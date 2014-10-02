package com.nflpickem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nflpickem.view.resource.AdminPlayerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class NFLPickemApplication extends Application<NFLPickemConfiguration> {

    private Injector injector;
    private Environment environment;

    public static void main(String[] args) throws Exception {
        new NFLPickemApplication().run(args);
    }

    @Override
    public String getName() {
        return "nfl-pickem";
    }

    @Override
    public void initialize(Bootstrap<NFLPickemConfiguration> bootstrap) {

    }

    @Override
    public void run(NFLPickemConfiguration configuration, Environment environment) throws Exception {
        this.environment = environment;
        injector = Guice.createInjector();
        environment.jersey().register(injector.getInstance(AdminPlayerResource.class));

        configureSerialization();
    }

    private void configureSerialization() {
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
