package com.votabulary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.votabulary.view.resource.MemberResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.Arrays;
import java.util.List;

public class VotabularyApplication extends Application<VotabularyConfiguration> {

    private Injector injector;
    private Environment environment;
    private VotabularyConfiguration configuration;

    public static void main(String[] args) throws Exception {
        new VotabularyApplication().run(args);
    }

    @Override
    public String getName() {
        return "votabulary";
    }

    @Override
    public void initialize(Bootstrap<VotabularyConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }

    @Override
    public void run(VotabularyConfiguration configuration, Environment environment) throws Exception {
        this.environment = environment;
        this.configuration = configuration;
        prepareInjector();
        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(injector.getInstance(MemberResource.class));

        configureSerialization();
    }

    private void prepareInjector() {
        List<? extends Module> modules = Arrays.asList(new VotabularyModule(configuration, environment));
        injector = Guice.createInjector(modules);
    }

    private void configureSerialization() {
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
