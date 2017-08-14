package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.Prescriptionline;

/**
 * Created by aubrey on 07/08/2017.
 */
public interface PrescriptionLineRepository {
    Prescriptionline create(Prescriptionline prescriptionline);
    Prescriptionline read(int lineID);
    Prescriptionline update(Prescriptionline prescriptionline);
    double taxDue();
    double prescriptionTotal(int quantity);
    void delete(int lineID);
}
