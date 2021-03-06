package com.androsaces.formulaone.season.database;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link SQLiteConfiguration} class.
 *
 * @author Andrew Kearney
 */
class SQLiteConnectionTest {
    @Test
    @DisplayName("The connection URL cannot be null")
    void urlCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            SQLiteConfiguration properties = new SQLiteConfiguration();
            properties.setUrl(null);
        });
    }

    @Test
    @DisplayName("The connection URL cannot be an empty string")
    void urlCannotBeEmpty() {
        assertAll(() -> assertThrows(IllegalArgumentException.class, () -> {
                SQLiteConfiguration properties = new SQLiteConfiguration();
                properties.setUrl("");
            }),
            () -> assertThrows(IllegalArgumentException.class, () -> {
                SQLiteConfiguration properties = new SQLiteConfiguration();
                properties.setUrl("  ");
            })
        );
    }

    @Test
    @DisplayName("The connection URL should start must start with JDBC")
    void urlMustStartWithJdbc() {
        SQLiteConfiguration properties = new SQLiteConfiguration();
        properties.setUrl("/database/path/database_name.sql");
        assertTrue(properties.getUrl().startsWith("jdbc:sqlite:"));
    }

    @Test
    @DisplayName("The connection URL should start must contain with sqlite")
    void urlMustContainWithSqlite() {
        SQLiteConfiguration properties = new SQLiteConfiguration();
        properties.setUrl("jdbc:/database/path/database_name.sql");
        assertTrue(properties.getUrl().contains("sqlite"));
    }

    @Test
    @DisplayName("If the connection URL does not start with jdbc.sqlite, it should be appended")
    void urlMustStartWithJdbcSqlite() {
        SQLiteConfiguration properties = new SQLiteConfiguration();
        properties.setUrl("/database/path/database_name.sql");
        assertEquals("jdbc:sqlite:/database/path/database_name.sql", properties.getUrl());
    }
}
