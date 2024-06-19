module com.example.fx200575777 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.fx200575777 to javafx.fxml;
    exports com.example.fx200575777;
}