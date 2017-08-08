package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Patient;

/**
 * Created by aubrey on 08/08/2017.
 */
public interface PatientService {
    Patient create(Patient patient);
    Patient read(String patientID);
    Patient update(Patient patient);
    void delete(String patientID);
}
