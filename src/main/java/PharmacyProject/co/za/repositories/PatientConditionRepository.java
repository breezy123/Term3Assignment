package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.PatientCondition;

/**
 * Created by aubrey on 07/08/2017.
 */
public interface PatientConditionRepository {

    PatientCondition create(PatientCondition patientCondition);

    PatientCondition read(String patientId);

    PatientCondition update(PatientCondition patientCondition);

    void delete(String patientId);
}
