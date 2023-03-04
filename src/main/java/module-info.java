module com.example.rehabdurationtracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rehabdurationtracker to javafx.fxml;
    exports com.example.rehabdurationtracker;
}