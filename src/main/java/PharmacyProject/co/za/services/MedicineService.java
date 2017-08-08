package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Medicine;

/**
 * Created by aubrey on 08/08/2017.
 */
public interface MedicineService {
    Medicine create(Medicine medicine);
    Medicine read(String medicineId);
    Medicine update(Medicine medicine);
    void delete(String medicineId);
}
