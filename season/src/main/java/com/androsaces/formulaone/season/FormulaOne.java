/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season;

import com.androsaces.formulaone.season.database.Database;
import com.androsaces.formulaone.season.database.DatabaseConfiguration;
import com.androsaces.formulaone.season.database.SQLiteConfiguration;
import com.androsaces.formulaone.season.database.SeasonDatabase;
import java.sql.Connection;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrew Kearney
 */
public class FormulaOne extends Application {
    private static final Logger logger = LoggerFactory.getLogger(FormulaOne.class);

    private Database mSeasonDatabase;
    private DatabaseConfiguration mConfiguration;

    public static void main(String[] args) {
        try {
            FormulaOne formulaOne = new FormulaOne();
            formulaOne.configure();

            formulaOne.startApplication();
            launch(args);
        } catch (Exception e) {
            printUsage(e);
        }
    }

    private static void printUsage(Exception e) {
        logger.error("unable to start Formula One application.\n\t" +
            "", e);
    }

    private void configure() {
        mConfiguration = new SQLiteConfiguration();
        mConfiguration.setUrl("jdbc:sqlite:/data/sqlite/formula_one_2019.sqlite");
        mSeasonDatabase = new SeasonDatabase(mConfiguration);
    }

    private void startApplication() {
        mSeasonDatabase.start();
        Connection connection = mSeasonDatabase.getConnection(); //DriverManager.getConnection(mConfiguration.getUrl());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }
}
