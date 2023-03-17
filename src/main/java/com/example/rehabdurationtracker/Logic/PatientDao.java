package com.example.rehabdurationtracker.Logic;

import com.example.rehabdurationtracker.Data.HibernateUtil;
import com.example.rehabdurationtracker.Data.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.Iterator;
import java.util.List;

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

    public List<Patient> loadAllData() {
        Transaction transaction = null;
        List<Patient> patients = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaQuery<Patient> criteriaQuery = session.getCriteriaBuilder().createQuery(Patient.class);
            criteriaQuery.from(Patient.class);
            patients = session.createQuery(criteriaQuery).getResultList();
            Iterator<Patient> itr = patients.iterator();
            while (itr.hasNext()) {
                Patient pt = itr.next();

                System.out.println("Patient ID: " + pt.getId());
                System.out.println("Age: " + pt.getAge());
                System.out.println("Gender: " + pt.getGender());
                System.out.println("Primary diagnosis: " + pt.getPrimaryDiagnosis());
                System.out.println("Time of admission: " + pt.getTimeOfAdmission());
                System.out.println("Duration of rehab: " + pt.getDurationOfRehab());
            }
            transaction.commit();


        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return patients;
    }
}
