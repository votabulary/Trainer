package com.nflpickem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.nflpickem.view.resource.AdminPlayerResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.Arrays;
import java.util.List;

public class NFLPickemApplication extends Application<NFLPickemConfiguration> {

    private Injector injector;
    private Environment environment;
    private NFLPickemConfiguration configuration;

    public static void main(String[] args) throws Exception {
        new NFLPickemApplication().run(args);
    }

    @Override
    public String getName() {
        return "nfl-pickem";
    }

    @Override
    public void initialize(Bootstrap<NFLPickemConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle());
    }

    @Override
    public void run(NFLPickemConfiguration configuration, Environment environment) throws Exception {
        this.environment = environment;
        this.configuration = configuration;
        prepareInjector();
        environment.jersey().register(injector.getInstance(AdminPlayerResource.class));

        configureSerialization();
    }

    private void prepareInjector() {
        List<? extends Module> modules = Arrays.asList(new NFLPickemModule(configuration, environment));
        injector = Guice.createInjector(modules);
    }

    private void configureSerialization() {
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
