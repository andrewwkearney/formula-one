/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.database;

import com.androsaces.buckaroo.Params;

/**
 * An SQLite implementation of connection properties for a database.
 *
 * @author Andrew Kearney
 */
public class SQLiteConnectionProperties implements DatabaseConnectionProperties {
    private String mUrl = "jdbc:sqlite:";
    private String mDriver = "org.sqlite.JDBC";
    private String mUsername = null;
    private String mPassword = null;
    private boolean isAuthenticationRequired = false;

    @Override
    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        Params.notEmpty(url);
        if (!urlStartsWith(url)) {
            mUrl = mUrl.concat(url);
        } else if (urlStartsWith(url)){
            mUrl = url;
        }
    }

    private boolean urlStartsWith(String url) {
        return url.startsWith("jdbc.sqlite");
    }

    @Override
    public String getDriver() {
        return mDriver;
    }

    public void setDriver(String driver) {
        mDriver = driver;
    }

    @Override
    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    @Override
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    @Override
    public boolean isAuthenticationRequired() {
        return isAuthenticationRequired;
    }

    public void setAuthenticationRequired(boolean authenticationRequired) {
        isAuthenticationRequired = authenticationRequired;
    }

    @Override
    public String toString() {
        return "SQLiteConnectionProperties{" +
            "mUrl='" + mUrl + '\'' +
            ", mDriver='" + mDriver + '\'' +
            ", isAuthenticationRequired=" + isAuthenticationRequired +
            '}';
    }
}
