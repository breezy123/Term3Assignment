package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.Prescriptionline;

/**
 * Created by aubrey on 07/08/2017.
 */
public interface PrescriptionLineRepository {
    Prescriptionline create(Prescriptionline prescriptionline);
    Prescriptionline read(int prescriptionId);
    Prescriptionline update(Prescriptionline prescriptionline);
    void delete(int prescriptionId);
}
