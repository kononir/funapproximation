package com.bsuir.funapproximation.controller;

import com.bsuir.funapproximation.data.ApproximationResult;
import com.bsuir.funapproximation.util.ViewUtils;
import com.bsuir.linearsystem.model.Vector;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;

public class GraphicsController extends AbstractResultController {
    @FXML
    private LineChart<Number, Number> graphics;

    @Override
    public void initResults(ApproximationResult results) {
        Vector xVector = results.getXVector();
        ViewUtils.addSeries(graphics, "f(x)", xVector, results.getYVector());
        ViewUtils.addSeries(graphics, "φ(x,c)", xVector, results.getPhiVector());
        ViewUtils.addSeries(graphics, "d(x)", xVector, results.getDVector());
    }
}
