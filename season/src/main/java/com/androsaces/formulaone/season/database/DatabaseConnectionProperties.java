/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.database;

/**
 * This interface should be implemented by any class that is used to configure
 * database properties, like the driver, username or password, etc.
 *
 * @author Andrew Kearney
 */
public interface DatabaseConnectionProperties {
    /**
     * Returns a string representation of the database connection URL
     */
    String getUrl();

    /**
     * Returns the SQL JDBC driver
     */
    String getDriver();

    /**
     * Returns the username for the database connection
     */
    String getUsername();

    /**
     * Returns the password for the database connection
     */
    String getPassword();

    /**
     * Returns true if the database connection requires a username and password,
     * otherwise it returns false.
     */
    boolean isAuthenticationRequired();

    DatabaseConnectionProperties NULL = new DatabaseConnectionProperties() {
        @Override public String getUrl() { return "NULL"; }
        @Override public String getDriver() { return "NULL"; }
        @Override public String getUsername() { return "NULL"; }
        @Override public String getPassword() { return "NULL"; }
        @Override public boolean isAuthenticationRequired() { return true; }
        @Override public String toString() { return DatabaseConnectionProperties.class.getSimpleName().concat(".NULL"); }
    };
}
