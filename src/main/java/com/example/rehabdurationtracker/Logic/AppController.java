package com.example.rehabdurationtracker.Logic;

import com.example.rehabdurationtracker.Data.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.SessionFactory;
import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

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
    private Button getPatientById;

    @FXML
    private Button getAllPatients;

    @FXML
    private TableView<Patient> patientTable;

    @FXML
    private TableColumn<Patient, Integer> columnId;
    @FXML
    private TableColumn<Patient, Integer> columnAge;
    @FXML
    private TableColumn<Patient, Character> columnGender;
    @FXML
    private TableColumn<Patient, String> columnDiagnosis;
    @FXML
    private TableColumn<Patient, Date> columnAdmission;
    @FXML
    private TableColumn<Patient, Integer> columnRehabDuration;



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

    // Doesn't work yet.
    public void getAllPatientsOnClick(){
        PatientDao patientDao = new PatientDao();
        List<Patient> patients = patientDao.loadAllData();
        ObservableList<Patient> list = FXCollections.observableArrayList(patients);
        columnId.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("id"));
        columnAge.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
        columnGender.setCellValueFactory(new PropertyValueFactory<Patient, Character>("gender"));
        columnDiagnosis.setCellValueFactory(new PropertyValueFactory<Patient, String>("primaryDiagnosis"));
        columnAdmission.setCellValueFactory(new PropertyValueFactory<Patient, Date>("timeOfAdmission"));
        columnRehabDuration.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("durationOfRehab"));
        patientTable.setItems(list);

    }







}