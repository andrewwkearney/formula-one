/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.database;

import java.sql.Connection;

/**
 * @author Andrew Kearney
 */
public interface Database {
    void start();

    void stop();

    boolean isRunning();

    Connection getConnection();

    Database NULL = new Database() {
        @Override public void start() {}
        @Override public void stop() {}
        @Override public boolean isRunning() { return false; }
        @Override public Connection getConnection() { return null; }
        @Override public String toString() { return Database.class.getSimpleName().concat(".NULL"); }
    };
}
