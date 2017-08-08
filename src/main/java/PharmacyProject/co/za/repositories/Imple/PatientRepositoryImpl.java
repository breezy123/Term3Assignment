package PharmacyProject.co.za.repositories.Imple;

import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.repositories.PatientRepository;
import java.util.*;

/**
 * Created by aubrey on 07/08/2017.
 */
public class PatientRepositoryImpl implements PatientRepository {

    private static PatientRepositoryImpl repository=null;

    private Map<String,Patient>patientTable;

    public   PatientRepositoryImpl(){
        patientTable = new HashMap<String, Patient>();
    }

    public static PatientRepositoryImpl getInstance(){
        if(repository==null){
            repository = new PatientRepositoryImpl();
        }
        return  repository;
    }
    public Patient create(Patient patient) {
        patientTable.put(patient.getPatientID(),patient);
        Patient savedPatient1 = patientTable.get(patient.getPatientID());
        return savedPatient1;
    }

    public Patient read(String patientID) {
        Patient patient = patientTable.get(patientID);
        return  patient;
    }

    public Patient update(Patient patient) {
       patientTable.put(patient.getPatientID(),patient);
       Patient savedPatient = patientTable.get(patient.getPatientID());
       return savedPatient;
    }

    public void delete(String patientID) {
        patientTable.remove(patientID);
    }
}
