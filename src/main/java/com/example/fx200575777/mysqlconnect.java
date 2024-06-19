package com.example.fx200575777;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mysqlconnect {
    public static Connection databaseLink;

    public static Connection ConnectDb() {
        String databaseName = "javafx";
        String databaseUser = "root";
        String databasePassword = "Anand#1225";
        String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName;

        try {
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }

    public static ObservableList<Diagnosis> getDiagnosisData(String patientId) {
        Connection conn = ConnectDb();
        ObservableList<Diagnosis> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM diagnosis WHERE patientId = ?");
            ps.setString(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Diagnosis(rs.getString("patientId"), rs.getString("symptoms"), rs.getString("diagnosis"), rs.getString("medicines")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
