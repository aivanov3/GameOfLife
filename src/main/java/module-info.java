module com.example.gol {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gol to javafx.fxml;
    exports com.example.gol;
}