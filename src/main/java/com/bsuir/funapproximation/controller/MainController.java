package com.bsuir.funapproximation.controller;

import com.bsuir.funapproximation.data.ApproximationResult;
import com.bsuir.funapproximation.logic.ApproximationService;
import com.bsuir.funapproximation.logic.FunctionService;
import com.bsuir.funapproximation.logic.impl.ApproximationServiceImpl;
import com.bsuir.funapproximation.logic.impl.FunctionServiceImpl;
import com.bsuir.linearsystem.logic.LinearSystemService;
import com.bsuir.linearsystem.logic.impl.LinearSystemServiceImpl;
import com.bsuir.linearsystem.logic.strategies.LinearSystemStrategy;
import com.bsuir.linearsystem.logic.strategies.impl.GaussStrategy;
import com.bsuir.linearsystem.logic.strategies.impl.SquareRootStrategy;
import com.bsuir.linearsystem.model.Vector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.bsuir.funapproximation.util.VariantUtils.getF;

public class MainController {
    private final LinearSystemStrategy gaussStrategy = new GaussStrategy();
    private final LinearSystemService linearSystemService = new LinearSystemServiceImpl(gaussStrategy);
    private final ApproximationService approximationService = new ApproximationServiceImpl(linearSystemService);
    private final FunctionService functionService = new FunctionServiceImpl();

    @FXML
    private TextField aField;

    @FXML
    private TextField bField;

    @FXML
    private TextField mField;

    @FXML
    private TextField nField;

    public void approximateFunctionAndShowResult() throws IOException {
        double a = Double.parseDouble(aField.getText());
        double b = Double.parseDouble(bField.getText());
        int m = Integer.parseInt(mField.getText());

        Vector knownXVector = functionService.calculateXVector(a, b, m);
        Vector knownYVector = functionService.calculateYVector(getF(), knownXVector);

        int n = Integer.parseInt(nField.getText());

        Vector cVector = new Vector(n);
        approximationService.approximateFunction(knownXVector, knownYVector, m, n, cVector);

        Vector notKnownXVector = functionService.calculateXVector(a, b, 21);
        Vector phiVector = functionService.calculatePhiVector(notKnownXVector, cVector);
        Vector notKnownYVector = functionService.calculateYVector(getF(), notKnownXVector);
        Vector dVector = functionService.calculateInaccuracy(notKnownYVector, phiVector);

        ApproximationResult results = new ApproximationResult(notKnownXVector, notKnownYVector, phiVector, dVector);

        showResultWindow("/graphics.fxml", results);
        showResultWindow("/table.fxml", results);
    }

    private void showResultWindow(String path, ApproximationResult results) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        AbstractResultController controller = loader.getController();
        controller.initResults(results);

        stage.show();
    }
}
