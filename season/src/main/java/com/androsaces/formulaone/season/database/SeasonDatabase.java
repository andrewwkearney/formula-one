/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.database;

import java.sql.Connection;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrew Kearney
 */
public class SeasonDatabase implements Database {
    private static final Logger logger = LoggerFactory.getLogger(SeasonDatabase.class);

    private final AtomicBoolean mStarted = new AtomicBoolean(false);
    private final DatabaseConfiguration mConfiguration;
    private Connection mConnection;

    public SeasonDatabase(DatabaseConfiguration configuration) {
        mConfiguration = configuration;
    }

    @Override
    public void start() {
        if (!mStarted.getAndSet(true)) {
            logger.info("starting database with config {}", mConfiguration);
            // TODO add in connection start here
        }
    }

    @Override
    public Connection getConnection() {
        return mConnection;
    }
}
