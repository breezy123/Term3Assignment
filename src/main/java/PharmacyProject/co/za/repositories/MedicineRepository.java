package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.Medicine;

/**
 * Created by aubrey on 07/08/2017.
 */
public interface MedicineRepository {

    Medicine create(Medicine medicine);
    Medicine read(String medicineId);
    Medicine update(Medicine medicine);
    void delete(String medicineId);
}
