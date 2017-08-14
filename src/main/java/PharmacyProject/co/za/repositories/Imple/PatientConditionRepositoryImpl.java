package PharmacyProject.co.za.repositories.Imple;

import PharmacyProject.co.za.domains.PatientCondition;
import PharmacyProject.co.za.repositories.PatientConditionRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aubrey on 07/08/2017.
 */
public class PatientConditionRepositoryImpl implements PatientConditionRepository{

    private static PatientConditionRepositoryImpl repository=null;

    private Map<String,PatientCondition> patientConditionTable;

    public PatientConditionRepositoryImpl(){
        patientConditionTable = new HashMap<String, PatientCondition>();
    }

    public static PatientConditionRepositoryImpl getInstance(){
        if(repository==null){
            repository = new PatientConditionRepositoryImpl();
        }
        return repository;
    }

    public PatientCondition create(PatientCondition patientCondition) {
        patientConditionTable.put(patientCondition.getPatientId().getPatientID(),patientCondition);
        PatientCondition savedPationCondition1 = patientConditionTable.get(patientCondition.getPatientId());
        return savedPationCondition1;
    }

    public PatientCondition read(String patientId) {
       PatientCondition patientCondition = patientConditionTable.get(patientId);
       return  patientCondition;
    }

    public PatientCondition update(PatientCondition patientCondition) {
        patientConditionTable.put(patientCondition.getPatientId().getPatientID(),patientCondition);
        PatientCondition savedPationCondition = patientConditionTable.get(patientCondition.getPatientId().getPatientID());
        return savedPationCondition;
    }

    public void delete(String patientId) {
        patientConditionTable.remove(patientId);
    }
}
