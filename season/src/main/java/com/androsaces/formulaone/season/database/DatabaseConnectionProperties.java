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
     * Sets the database URL
     *
     * @param url a string containing the url for the database connection
     */
    void setUrl(String url);

    /**
     * Returns the SQL JDBC driver
     */
    String getDriver();

    /**
     * Returns the username for the database connection
     */
    String getUsername();

    /**
     * Sets the username for the database connection
     *
     * @param username a string containing the username
     */
    void setUsername(String username);

    /**
     * Returns the password for the database connection
     */
    String getPassword();

    /**
     * Sets the password for the database connection
     *
     * @param password a string containing the password
     */
    void setPassword(String password);

    /**
     * Returns true if the database connection requires a username and password,
     * otherwise it returns false.
     */
    boolean isAuthenticationRequired();

    DatabaseConnectionProperties NULL = new DatabaseConnectionProperties() {
        @Override public String getUrl() { return "NULL"; }
        @Override public void setUrl(String url) { }
        @Override public String getDriver() { return "NULL"; }
        @Override public String getUsername() { return "NULL"; }
        @Override public void setUsername(String username) { }
        @Override public String getPassword() { return "NULL"; }
        @Override public void setPassword(String password) { }
        @Override public boolean isAuthenticationRequired() { return true; }
        @Override public String toString() { return DatabaseConnectionProperties.class.getSimpleName().concat(".NULL"); }
    };
}
