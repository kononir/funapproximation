package com.bsuir.funapproximation.logic.impl;

import com.bsuir.funapproximation.logic.FunctionService;
import com.bsuir.linearsystem.model.Vector;

import java.util.function.Function;

import static com.bsuir.funapproximation.util.VariantUtils.calculatePhiSum;

public class FunctionServiceImpl implements FunctionService {
    public Vector calculateXVector(double a, double b, int m) {
        Vector xVector = new Vector(m);
        for (int i = 0; i < m; i++) {
            xVector.set(i, a + i * (b - a) / (m - 1));
        }
        return xVector;
    }

    public Vector calculateYVector(Function<Double, Double> fun, Vector xVector) {
        int m = xVector.len();
        Vector yVector = new Vector(m);
        for (int i = 0; i < m; i++) {
            yVector.set(i, fun.apply(xVector.get(i)));
        }
        return yVector;
    }

    @Override
    public Vector calculatePhiVector(Vector xVector, Vector cVector) {
        int m = xVector.len();
        int n = cVector.len();
        Vector phiVector = new Vector(m);
        for (int i = 0; i < m; i++) {
            phiVector.set(i, calculatePhiSum(xVector.get(i), n, cVector));
        }
        return phiVector;
    }

    @Override
    public Vector calculateInaccuracy(Vector yVector, Vector phiVector) {
        int m = yVector.len();
        Vector inaccuracyVector = new Vector(m);
        for (int i = 0; i < m; i++) {
            inaccuracyVector.set(i, yVector.get(i) - phiVector.get(i));
        }
        return inaccuracyVector;
    }
}
