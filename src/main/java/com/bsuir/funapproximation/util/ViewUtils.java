package com.bsuir.funapproximation.util;

import com.bsuir.linearsystem.model.Vector;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class ViewUtils {
    public static void addSeries(LineChart<Number, Number> graphics, String name, Vector xVector, Vector yVector) {
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
