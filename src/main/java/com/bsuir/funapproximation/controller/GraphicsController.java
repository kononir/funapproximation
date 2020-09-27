package com.bsuir.funapproximation.controller;

import com.bsuir.funapproximation.data.ApproximationResult;
import com.bsuir.linearsystem.model.Vector;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class GraphicsController extends AbstractResultController {
    @FXML
    private LineChart<Number, Number> graphics;

    @Override
    public void initResults(ApproximationResult results) {
        Vector xVector = results.getXVector();
        addSeries("f(x)", xVector, results.getYVector());
        addSeries("φ(x,c)", xVector, results.getPhiVector());
        addSeries("d(x)", xVector, results.getDVector());
    }

    private void addSeries(String name, Vector xVector, Vector yVector) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(name);
        ObservableList<XYChart.Data<Number,Number>> seriesData = series.getData();

        int m = xVector.len();
        for (int i = 0; i < m; i++) {
            seriesData.add(new XYChart.Data<>(xVector.get(i), yVector.get(i)));
        }

        graphics.getData().add(series);
    }
}
