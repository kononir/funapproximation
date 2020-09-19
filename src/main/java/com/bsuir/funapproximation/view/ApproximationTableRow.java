package com.bsuir.funapproximation.view;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ApproximationTableRow {
    private final DoubleProperty x;
    private final DoubleProperty f;
    private final DoubleProperty phi;
    private final DoubleProperty d;

    public ApproximationTableRow(double x, double f, double phi, double d) {
        this.x = new SimpleDoubleProperty(x);
        this.f = new SimpleDoubleProperty(f);
        this.phi = new SimpleDoubleProperty(phi);
        this.d = new SimpleDoubleProperty(d);
    }

    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public double getF() {
        return f.get();
    }

    public DoubleProperty fProperty() {
        return f;
    }

    public double getPhi() {
        return phi.get();
    }

    public DoubleProperty phiProperty() {
        return phi;
    }

    public double getD() {
        return d.get();
    }

    public DoubleProperty dProperty() {
        return d;
    }
}
