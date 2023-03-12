module com.example.rehabdurationtracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.persistence;
    requires lombok;


    opens com.example.rehabdurationtracker to javafx.fxml, org.hibernate.orm.core ;
    exports com.example.rehabdurationtracker;
    exports com.example.rehabdurationtracker.Data;
    opens com.example.rehabdurationtracker.Data to javafx.fxml, org.hibernate.orm.core;
    exports com.example.rehabdurationtracker.Logic;
    opens com.example.rehabdurationtracker.Logic to javafx.fxml, org.hibernate.orm.core;

}