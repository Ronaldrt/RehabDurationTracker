package com.example.rehabdurationtracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppMain.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 300);
        stage.setTitle("Rehabilitation duration tracker");
        stage.setScene(scene);
        stage.show();


    }





    public static void main(String[] args) {
        PatientDao patientDao = new PatientDao();
        Patient patient = new Patient(75, 'M', "stroke", "05-02-2023", 21);
        Patient patient2 = new Patient(35, 'M', "humerus fracture", "06-03-2023", 14);
        patientDao.addPatient(patient);
        patientDao.addPatient(patient2);



    }
}