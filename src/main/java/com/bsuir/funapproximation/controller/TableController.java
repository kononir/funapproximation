package com.bsuir.funapproximation.controller;

import com.bsuir.funapproximation.data.ApproximationResult;
import com.bsuir.funapproximation.view.ApproximationTableRow;
import com.bsuir.linearsystem.model.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class TableController extends AbstractResultController {
    @FXML
    private TableView<ApproximationTableRow> table;

    @FXML
    private TableColumn<ApproximationTableRow, Double> xColumn;

    @FXML
    private TableColumn<ApproximationTableRow, Double> fColumn;

    @FXML
    private TableColumn<ApproximationTableRow, Double> phiColumn;

    @FXML
    private TableColumn<ApproximationTableRow, Double> dColumn;

    @FXML
    private void initialize() {
        xColumn.setCellValueFactory(cellData -> cellData.getValue().xProperty().asObject());
        fColumn.setCellValueFactory(cellData -> cellData.getValue().fProperty().asObject());
        phiColumn.setCellValueFactory(cellData -> cellData.getValue().phiProperty().asObject());
        dColumn.setCellValueFactory(cellData -> cellData.getValue().dProperty().asObject());
    }

    @Override
    public void initResults(ApproximationResult results) {
        table.setItems(convertToObservableList(results));
    }

    private ObservableList<ApproximationTableRow> convertToObservableList(ApproximationResult results) {
        Vector xVector = results.getXVector();
        Vector yVector = results.getYVector();
        Vector phiVector = results.getPhiVector();
        Vector dVector = results.getDVector();

        int m = xVector.len();

        List<ApproximationTableRow> resultsList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            resultsList.add(new ApproximationTableRow(xVector.get(i), yVector.get(i), phiVector.get(i), dVector.get(i)));
        }

        return FXCollections.observableArrayList(resultsList);
    }
}
