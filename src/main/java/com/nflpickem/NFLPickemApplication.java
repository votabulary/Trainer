package com.nflpickem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.nflpickem.model.dao.PlayerDAO;
import com.nflpickem.view.resource.AdminPlayerResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

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

    }

    @Override
    public void run(NFLPickemConfiguration configuration, Environment environment) throws Exception {
        this.environment = environment;
        this.configuration = configuration;
        injector = Guice.createInjector();
        environment.jersey().register(injector.getInstance(AdminPlayerResource.class));

        configureSerialization();
    }

    private void configureSerialization() {
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private void configureDatabase() throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "msyql");
        final PlayerDAO dao = jdbi.onDemand(PlayerDAO.class);
//        environment.jersey().register(new UserResource(dao));
        // TODO Add player resource here...make it injectible
    }
}
