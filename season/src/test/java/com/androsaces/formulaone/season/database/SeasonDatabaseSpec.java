package com.androsaces.formulaone.season.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Andrew Kearney
 */
class SeasonDatabaseSpec {
    private SeasonDatabase mDatabase;

    @Test
    void a_newly_created_database_is_not_started() {
        mDatabase = new SeasonDatabase(DatabaseConfiguration.NULL);
        assertFalse(mDatabase.isRunning());
    }

    @Test
    void a_started_database_can_be_queried() {
        DatabaseConfiguration configuration = createSqliteInMemoryConfiguration();
        mDatabase = new SeasonDatabase(configuration);
        mDatabase.start();
        assertTrue(mDatabase.isRunning());
    }

    @Test
    void a_stopped_database_cannot_be_stopped_again() {
        DatabaseConfiguration configuration = createSqliteInMemoryConfiguration();
        mDatabase = new SeasonDatabase(configuration);
        mDatabase.stop();
    }

    @Test
    void a_started_database_when_stopped_will_not_be_started() {
        DatabaseConfiguration configuration = createSqliteInMemoryConfiguration();
        mDatabase = new SeasonDatabase(configuration);
        mDatabase.start();
        mDatabase.stop();
        assertFalse(mDatabase.isRunning());
    }

    @AfterEach
    void tearDown() {
        if (mDatabase.isRunning()) {
            mDatabase.stop();
        }
    }

    private DatabaseConfiguration createSqliteInMemoryConfiguration() {
        DatabaseConfiguration configuration = new SQLiteConfiguration();
        configuration.setUrl("jdbc:sqlite::memory:");
        return configuration;
    }

    private void seedDatabase(Database database) {
        // TODO add seeding information here
    }
}