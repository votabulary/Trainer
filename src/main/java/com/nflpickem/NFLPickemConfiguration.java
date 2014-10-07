package com.nflpickem;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class NFLPickemConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @NotEmpty
    private String something;

    @JsonProperty
    public String getSomething() {
        return something;
    }

    @JsonProperty
    public void setSomething(String something) {
        this.something = something;
    }
}
