package com.example.rehabdurationtracker.Logic;

import com.example.rehabdurationtracker.Data.Patient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.w3c.dom.Text;

public class AppController{
    private SessionFactory session;
    @FXML
    private TextField age;


    //new ChoiceBox(FXCollections.observableArrayList("M", "F"));
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

    @FXML
    private TextField insertIdDelete;

    @FXML
    private Button deletePatientById;

    @FXML
    private Label deletedPatientDisplay;

    @FXML
    private TextField searchById;

    @FXML
    private Button getPatientFromDb;

    @FXML
    private ListView listOfPatients;


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

    public void deleteButtonClick(){
        deletePatientById.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PatientDao patientDao = new PatientDao();
                patientDao.deletePatient(Integer.parseInt(insertIdDelete.getText()));
                deletedPatientDisplay.setText("Patient " + insertIdDelete.getText() + " is deleted!");
            }
        });
    }




}