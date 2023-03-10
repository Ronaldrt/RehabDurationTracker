package com.example.rehabdurationtracker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int age;

    private char gender;

    @Column (name = "primary_diagnosis")
    private String primaryDiagnosis;

    @Column(name = "time_of_admission")
    private String timeOfAdmission = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss.SSS"));

    @Column (name = "duration_of_rehab")
    private int durationOfRehab;

    public Patient(int age, char gender, String primaryDiagnosis, String timeOfAdmission, int durationOfRehab) {
        this.age = age;
        this.gender = gender;
        this.primaryDiagnosis = primaryDiagnosis;
        this.timeOfAdmission = timeOfAdmission;
        this.durationOfRehab = durationOfRehab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPrimaryDiagnosis() {
        return primaryDiagnosis;
    }

    public void setPrimaryDiagnosis(String primaryDiagnosis) {
        this.primaryDiagnosis = primaryDiagnosis;
    }

    public String getTimeOfAdmission() {
        return timeOfAdmission;
    }

    public void setTimeOfAdmission(String timeOfAdmission) {
        this.timeOfAdmission = timeOfAdmission;
    }

    public int getDurationOfRehab() {
        return durationOfRehab;
    }

    public void setDurationOfRehab(int durationOfRehab) {
        this.durationOfRehab = durationOfRehab;
    }
}

