package com.example.fx200575777;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class HelloController {

    @FXML
    private TextField patientIdField;
    @FXML
    private Button searchButton;
    @FXML
    private TableView<Diagnosis> tableView;
    @FXML
    private TableColumn<Diagnosis, String> colPatientId;
    @FXML
    private TableColumn<Diagnosis, String> colSymptoms;
    @FXML
    private TableColumn<Diagnosis, String> colDiagnosis;
    @FXML
    private TableColumn<Diagnosis, String> colMedicines;
    @FXML
    private TextField symptomsField;
    @FXML
    private TextField diagnosisField;
    @FXML
    private TextField medicinesField;
    @FXML
    private CheckBox wardRequiredCheckBox;
    @FXML
    private Button addButton;
    @FXML
    private Button closeButton;

    private Connection connection;

    @FXML
    public void initialize() {
        colPatientId.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        colSymptoms.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
        colDiagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        colMedicines.setCellValueFactory(new PropertyValueFactory<>("medicines"));

        connection = mysqlconnect.ConnectDb();

        addButton.setOnAction(event -> addDiagnosis());
        searchButton.setOnAction(event -> searchDiagnosis());
        closeButton.setOnAction(event -> System.exit(0));
    }

    private void addDiagnosis() {
        String patientId = patientIdField.getText();
        String symptoms = symptomsField.getText();
        String diagnosis = diagnosisField.getText();
        String medicines = medicinesField.getText();
        boolean wardRequired = wardRequiredCheckBox.isSelected();

        try {
            String query = "INSERT INTO diagnosis (patientId, symptoms, diagnosis, medicines, wardRequired) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, patientId);
            preparedStatement.setString(2, symptoms);
            preparedStatement.setString(3, diagnosis);
            preparedStatement.setString(4, medicines);
            preparedStatement.setBoolean(5, wardRequired);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchDiagnosis() {
        String patientId = patientIdField.getText();
        ObservableList<Diagnosis> list = mysqlconnect.getDiagnosisData(patientId);
        tableView.setItems(list);
    }
}
