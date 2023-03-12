package com.example.rehabdurationtracker.Logic;

import com.example.rehabdurationtracker.Data.HibernateUtil;
import com.example.rehabdurationtracker.Data.Patient;
import javafx.scene.control.Label;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatientDao {

    public void addPatientToDatabase(Patient patient){
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public void deletePatient(int id){
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, id);
            if(patient != null){
                session.delete(patient);
            }
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
