package com.nflpickem;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class NFLPickemConfiguration extends Configuration {
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
