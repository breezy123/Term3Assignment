package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Prescription;

/**
 * Created by aubrey on 08/08/2017.
 */
public interface PrescriptionService {

    Prescription create(Prescription prescription);
    Prescription read(int prescriptionId);
    Prescription update(Prescription prescription);
    void delete(int prescriptionId);
}
