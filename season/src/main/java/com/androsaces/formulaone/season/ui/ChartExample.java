/*
 * Copyright (c) 2019. Androsaces. All rights reserved.
 */

package com.androsaces.formulaone.season.ui;

import com.androsaces.formulaone.time.LapTime;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Andrew Kearney
 */
public class ChartExample extends Application {
    // private static final Logger log = LoggerFactory.getLogger(ChartExample.class);

    private final NumberAxis mXAxis;
    private final NumberAxis mYAxis;
    private final LineChart<Number, Number> mLineChart;
    private ObservableList<Event> mEvents;

    public ChartExample() {
        mXAxis = new NumberAxis("Laps", 1, 53, 5);
        mYAxis = new NumberAxis("Lap time", 90000, 120000, 5000);
        mLineChart = new LineChart<>(mXAxis, mYAxis);
        setSeries();
    }

    public void setSeries() {
        mEvents = FXCollections.observableArrayList(new Event("RIC", FXCollections.observableArrayList(
                createSeries("RIC", Arrays.asList(
                        new LapTime(98216L),
                        new LapTime(97625L),
                        new LapTime(96741L),
                        new LapTime(96183L),
                        new LapTime(96123L),
                        new LapTime(95567L),
                        new LapTime(96083L),
                        new LapTime(96034L),
                        new LapTime(96061L),
                        new LapTime(96165L),
                        new LapTime(96548L),
                        new LapTime(96459L),
                        new LapTime(96236L),
                        new LapTime(96168L),
                        new LapTime(96544L),
                        new LapTime(96536L),
                        new LapTime(96807L),
                        new LapTime(96331L),
                        new LapTime(96046L),
                        new LapTime(97325L),
                        new LapTime(96795L),
                        new LapTime(96570L),
                        new LapTime(97066L),
                        new LapTime(97431L),
                        new LapTime(97328L),
                        new LapTime(97491L),
                        new LapTime(100221L),
                        new LapTime(114884L),
                        new LapTime(94297L),
                        new LapTime(94112L),
                        new LapTime(94124L),
                        new LapTime(94303L),
                        new LapTime(94254L),
                        new LapTime(94649L),
                        new LapTime(94713L),
                        new LapTime(94669L),
                        new LapTime(94658L),
                        new LapTime(94885L),
                        new LapTime(94366L),
                        new LapTime(95067L),
                        new LapTime(95199L),
                        new LapTime(95337L),
                        new LapTime(93965L),
                        new LapTime(96782L),
                        new LapTime(96151L),
                        new LapTime(93481L),
                        new LapTime(94563L),
                        new LapTime(94178L),
                        new LapTime(94009L)
                        ))
        ), true));

        // log.info("series data: {}", pilot1.getData());
        // log.info("chart property: {}", pilot1.chartProperty());
        // log.info("data property: {}", pilot1.dataProperty());
        populateData();
        styleSeries();
    }

    private XYChart.Series<Number, Number> createSeries(String name, List<LapTime> data) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        ObservableList<XYChart.Data<Number, Number>> seriesData = FXCollections.observableArrayList();
        series.setName(name);
        for (int i = 0; i < data.size(); i++) {
            seriesData.add(new XYChart.Data<>(i + 2, data.get(i).getLapTime()));
        }
        series.setData(seriesData);
        return series;
    }

    private void populateData() {
        mLineChart.getData().clear();
        for (Event event : mEvents) {
            mLineChart.getData().addAll(event.getSeries());
        }
    }

    private void styleSeries() {
        mLineChart.applyCss();

        int nSeries = 0;
        for (Event event : mEvents) {
            if (!event.isActive()) continue;
            for (int i = 0; i < event.getSeries().size(); i++) {
                XYChart.Series<Number, Number> series = event.getSeries().get(i);
                Set<Node> nodes = mLineChart.lookupAll(".series" + nSeries);
                for (Node node : nodes) {
                    StringBuilder style = new StringBuilder();
                    style.append("-fx-stroke: #0a55fd; -fx-background-color: #0a55fd");
                    node.setStyle(style.toString());
                }
                nSeries++;
            }
        }
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

    private class Event {
        private final String mName;
        private final ObservableList<XYChart.Series<Number, Number>> mSeries;
        private boolean mIsActive;

        public Event(String name, ObservableList<XYChart.Series<Number, Number>> series, boolean isActive) {
            mName = name;
            mSeries = series;
            mIsActive = isActive;
        }

        public String getName() {
            return mName;
        }

        public ObservableList<XYChart.Series<Number, Number>> getSeries() {
            return mSeries;
        }

        public boolean isActive() {
            return mIsActive;
        }
    }
}
