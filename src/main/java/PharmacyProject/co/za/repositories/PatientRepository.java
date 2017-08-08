package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.Patient;

/**
 * Created by aubrey on 07/08/2017.
 */
public interface PatientRepository {

    Patient create(Patient patient);
    Patient read(String patientID);
    Patient update(Patient patient);
    void delete(String patientID);
}
