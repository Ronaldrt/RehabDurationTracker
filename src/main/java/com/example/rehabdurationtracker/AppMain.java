package com.example.rehabdurationtracker;

import com.example.rehabdurationtracker.Data.HibernateUtil;
import com.example.rehabdurationtracker.Data.Patient;
import com.example.rehabdurationtracker.Logic.AppController;
import com.example.rehabdurationtracker.Logic.PatientDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.mapping.List;

import javax.persistence.criteria.CriteriaQuery;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class AppMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        var hController = new AppController();
        fxmlLoader.setController(hController);
        stage.setTitle("Rehabilitation duration tracker");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();

    }
}