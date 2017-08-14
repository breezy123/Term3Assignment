package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Prescriptionline;

/**
 * Created by aubrey on 08/08/2017.
 */
public interface PrescriptionLineService {
    Prescriptionline create(Prescriptionline prescriptionline);
    Prescriptionline read(int prescriptionId);
    Prescriptionline update(Prescriptionline prescriptionline);
    double taxDue();
    double prescriptionTotal(int quantity);
    void delete(int prescriptionId);
}
