package com.bsuir.funapproximation.util;

import com.bsuir.linearsystem.model.Vector;

import java.util.function.BiFunction;
import java.util.function.Function;

public class VariantUtils {
    private VariantUtils() {
    }

    public static Function<Double, Double> getF() {
        return x -> Math.sin(x) * Math.sin(x) - 3 * Math.cos(x);
    }

    public static double calculatePhiSum(double xi, int n, Vector cVector) {
        double phiSum = 0;
        for (int j = 0; j < n; j++) {
            phiSum += cVector.get(j) * getPhi().apply(xi, j);
        }
        return phiSum;
    }

    public static BiFunction<Double, Integer, Double> getPhi() {
        return Math::pow;
    }
}
