package com.example.rehabdurationtracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public Patient newPatient(){
        Patient patient = new Patient();
        patient.setAge(Integer.parseInt(age.getText()));
        patient.setGender(gender.getText().charAt(0));
        patient.setPrimaryDiagnosis(primaryDiagnosis.getText());
        patient.setTimeOfAdmission(timeOfAdmission.getText());
        patient.setDurationOfRehab(Integer.parseInt(durationOfRehab.getText()));
        return patient;
    }

    public void onButtonClick() {
        addPatient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PatientDao patientDao = new PatientDao();
                patientDao.addPatientToDatabase(newPatient());
            }
        });
    }

}