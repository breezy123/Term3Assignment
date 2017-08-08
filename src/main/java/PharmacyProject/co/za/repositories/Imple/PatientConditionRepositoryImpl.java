package PharmacyProject.co.za.repositories.Imple;

import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.PatientCondition;
import PharmacyProject.co.za.repositories.PatientConditionRepository;
import java.util.*;

/**
 * Created by aubrey on 07/08/2017.
 */
public class PatientConditionRepositoryImpl implements PatientConditionRepository{

    private static PatientConditionRepositoryImpl repository=null;

    private Map<Patient,PatientCondition> patientConditionTable;

    public PatientConditionRepositoryImpl(){
        patientConditionTable = new HashMap<Patient, PatientCondition>();
    }

    public static PatientConditionRepositoryImpl getInstance(){
        if(repository==null){
            repository = new PatientConditionRepositoryImpl();
        }
        return repository;
    }

    public PatientCondition create(PatientCondition patientCondition) {
        patientConditionTable.put(patientCondition.getPatientId(),patientCondition);
        PatientCondition savedPationCondition1 = patientConditionTable.get(patientCondition.getPatientId());
        return savedPationCondition1;
    }

    public PatientCondition read(Patient patientId) {
       PatientCondition patientCondition = patientConditionTable.get(patientId.getPatientID());
       return  patientCondition;
    }

    public PatientCondition update(PatientCondition patientCondition) {
        patientConditionTable.put(patientCondition.getPatientId(),patientCondition);
        PatientCondition savedPationCondition = patientConditionTable.get(patientCondition.getPatientId().getPatientID());
        return savedPationCondition;
    }

    public void delete(Patient patientId) {
        patientConditionTable.remove(patientId.getPatientID());

    }
}
