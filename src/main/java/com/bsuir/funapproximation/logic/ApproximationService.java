package com.bsuir.funapproximation.logic;

import com.bsuir.linearsystem.model.Vector;

public interface ApproximationService {
    void approximateFunction(Vector xVector, Vector yVector, int m, int n, Vector cVector);
}
