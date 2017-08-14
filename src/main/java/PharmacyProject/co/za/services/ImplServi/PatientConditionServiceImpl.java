package PharmacyProject.co.za.services.ImplServi;

import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.PatientCondition;
import PharmacyProject.co.za.repositories.Imple.PatientConditionRepositoryImpl;
import PharmacyProject.co.za.repositories.PatientConditionRepository;
import PharmacyProject.co.za.services.PatientConditionService;

/**
 * Created by aubrey on 08/08/2017.
 */
public class PatientConditionServiceImpl implements PatientConditionService {

    static PatientConditionRepository repository = PatientConditionRepositoryImpl.getInstance();

    public static PatientConditionRepositoryImpl getInstance(){
        if(repository==null){
            repository = new PatientConditionRepositoryImpl();
        }
        return (PatientConditionRepositoryImpl) repository;
    }

    public PatientCondition create(PatientCondition patientCondition) {
        return repository.create(patientCondition);
    }

    public PatientCondition read(String patientId) {
        return repository.read(patientId);
    }

    public PatientCondition update(PatientCondition patientCondition) {
        return  repository.update(patientCondition);
    }

    public void delete(String patientId) {
        repository.delete(patientId);
    }
}
