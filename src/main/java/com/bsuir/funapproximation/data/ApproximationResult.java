package com.bsuir.funapproximation.data;

import com.bsuir.linearsystem.model.Vector;

public class ApproximationResult {
    private final Vector xVector;
    private final Vector yVector;
    private final Vector phiVector;
    private final Vector dVector;

    public ApproximationResult(Vector xVector, Vector yVector, Vector phiVector, Vector dVector) {
        this.xVector = xVector;
        this.yVector = yVector;
        this.phiVector = phiVector;
        this.dVector = dVector;
    }

    public Vector getXVector() {
        return xVector;
    }

    public Vector getYVector() {
        return yVector;
    }

    public Vector getPhiVector() {
        return phiVector;
    }

    public Vector getDVector() {
        return dVector;
    }
}
