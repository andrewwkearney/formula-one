/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.ui;

import com.androsaces.formulaone.season.ui.axis.LapTimeAxis;
import com.androsaces.formulaone.time.LapTime;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrew Kearney
 */
public class ChartExample extends Application {
    private static final Logger log = LoggerFactory.getLogger(ChartExample.class);

    private final NumberAxis mXAxis;
    private final LapTimeAxis mYAxis;
    private final LineChart<Number, LapTime> mLineChart;

    public ChartExample() {
        mXAxis = new NumberAxis();
        mYAxis = new LapTimeAxis();
        mLineChart = new LineChart<>(mXAxis, mYAxis);
        setSeries();
    }

    public void setSeries() {
        XYChart.Series<Number, LapTime> pilot1 = new XYChart.Series<>();
        pilot1.getData().add(new XYChart.Data<>(2, new LapTime(68216L)));
        pilot1.getData().add(new XYChart.Data<>(3, new LapTime(67625L)));
        pilot1.getData().add(new XYChart.Data<>(4, new LapTime(66741L)));
        pilot1.getData().add(new XYChart.Data<>(5, new LapTime(66183L)));
        pilot1.getData().add(new XYChart.Data<>(6, new LapTime(66123L)));
        pilot1.getData().add(new XYChart.Data<>(7, new LapTime(65567L)));
        pilot1.getData().add(new XYChart.Data<>(8, new LapTime(66083L)));

        log.info("series data: {}", pilot1.getData());
        log.info("chart property: {}", pilot1.chartProperty());
        log.info("data property: {}", pilot1.dataProperty());
        mLineChart.getData().add(pilot1);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lap Chart");

        Scene scene = new Scene(mLineChart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
