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

    Connection getConnection();

    Database NULL = new Database() {
        @Override
        public void start() {

        }

        @Override
        public Connection getConnection() {
            return null;
        }

        @Override
        public String toString() {
            return Database.class.getSimpleName().concat(".NULL");
        }
    };
}
