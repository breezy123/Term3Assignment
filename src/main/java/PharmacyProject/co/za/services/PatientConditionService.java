package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.PatientCondition;

/**
 * Created by aubrey on 08/08/2017.
 */
public interface PatientConditionService {
    PatientCondition create(PatientCondition patientCondition);

    PatientCondition read(String patientId);

    PatientCondition update(PatientCondition patientCondition);

    void delete(String patientId);
}
