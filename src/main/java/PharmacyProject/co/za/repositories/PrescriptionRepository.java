package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.Prescription;

/**
 * Created by aubrey on 07/08/2017.
 */
public interface PrescriptionRepository {

    Prescription create(Prescription prescription);
    Prescription read(int prescriptionId);
    Prescription update(Prescription prescription);
    void delete(int prescriptionId);
}
