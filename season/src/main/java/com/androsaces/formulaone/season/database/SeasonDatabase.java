/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

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
            try {
                mConnection = DriverManager.getConnection(mConfiguration.getUrl());
            } catch (SQLException e) {
                logger.error("an issue occurred while creating the connection, due to: ", e);
            }
        }
    }

    @Override
    public void stop() {
        if (!mStarted.get()) {
            logger.warn("cannot stop a database that is not running");
            return;
        }
        try {
            mConnection.close();
            mStarted.set(false);
        } catch (SQLException e) {
            logger.error("error while stopping database, due to: ", e);
        }
    }

    @Override
    public Connection getConnection() {
        return mConnection;
    }

    @Override
    public boolean isRunning() {
        return mStarted.get();
    }
}
