package com.bsuir.funapproximation.logic.impl;

import com.bsuir.funapproximation.logic.ApproximationService;
import com.bsuir.linearsystem.logic.LinearSystemService;
import com.bsuir.linearsystem.model.Matrix;
import com.bsuir.linearsystem.model.Vector;

import static com.bsuir.funapproximation.util.VariantUtils.getPhi;

public class ApproximationServiceImpl implements ApproximationService {
    private final LinearSystemService linearSystemService;

    public ApproximationServiceImpl(LinearSystemService linearSystemService) {
        this.linearSystemService = linearSystemService;
    }

    public void approximateFunction(Vector xVector, Vector yVector, int m, int n, Vector cVector) {
        Vector bVector = new Vector(n);
        Matrix gMatrix = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            bVector.set(i, 0);
            for (int k = 0; k < n; k++) {
                gMatrix.set(i, k, 0);
                for (int j = 0; j < m; j++) {
                    double xj = xVector.get(j);
                    gMatrix.set(i, k, gMatrix.get(i, k) + getPhi().apply(xj, i) * getPhi().apply(xj, k));
                }
            }
            for (int j = 0; j < m; j++) {
                bVector.set(i, bVector.get(i) + getPhi().apply(xVector.get(j), i) * yVector.get(j));
            }
        }
        linearSystemService.solveSystem(gMatrix, bVector, cVector, n);
    }
}
