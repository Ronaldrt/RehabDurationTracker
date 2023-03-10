package com.example.rehabdurationtracker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

public class AppController{
    private SessionFactory session;
    @FXML
    private TextField age;
    @FXML
    private TextField gender;
    @FXML
    private TextField primaryDiagnosis;
    @FXML
    private TextField timeOfAdmission;
    @FXML
    private TextField durationOfRehab;

    @FXML
    private Button addPatient;


    public void setSession(SessionFactory session) {
        this.session = session;
    }

}