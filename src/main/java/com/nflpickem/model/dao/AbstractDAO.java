package com.nflpickem.model.dao;

import com.google.inject.Inject;
import com.nflpickem.database.DSLContextProvider;
import org.jooq.DSLContext;

public class AbstractDAO {

    @Inject
    private DSLContextProvider contextProvider;

    protected DSLContext jooq() {
        return contextProvider.get();
    }
}
