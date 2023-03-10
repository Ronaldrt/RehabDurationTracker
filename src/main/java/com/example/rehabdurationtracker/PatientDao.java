package com.example.rehabdurationtracker;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatientDao {

    public void addPatient(Patient patient){
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
}
