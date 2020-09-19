package com.bsuir.funapproximation.logic;

import com.bsuir.linearsystem.model.Vector;

import java.util.function.Function;

public interface FunctionService {
    Vector calculateXVector(double a, double b, int m);

    Vector calculateYVector(Function<Double, Double> fun, Vector xVector);

    Vector calculatePhiVector(Vector xVector, Vector cVector);

    Vector calculateInaccuracy(Vector yVector, Vector phiVector);
}
