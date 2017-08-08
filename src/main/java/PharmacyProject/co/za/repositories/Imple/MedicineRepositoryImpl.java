package PharmacyProject.co.za.repositories.Imple;

import PharmacyProject.co.za.domains.Medicine;
import PharmacyProject.co.za.repositories.MedicineRepository;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class MedicineRepositoryImpl implements MedicineRepository {

    private static MedicineRepositoryImpl repository=null;

    private Map<String,Medicine>medicineTable;
    public MedicineRepositoryImpl(){
        medicineTable = new HashMap<String, Medicine>();
    }

    public static MedicineRepositoryImpl getInstance(){
        if(repository==null)
            repository = new MedicineRepositoryImpl();
        return repository;
    }

    public Medicine create(Medicine medicine) {
        medicineTable.put(medicine.getMedicineID(),medicine);
        Medicine savedMedicine = medicineTable.get(medicine.getMedicineID());
        return savedMedicine;
    }

    public Medicine read(String medicineId) {
       Medicine medicine = medicineTable.get(medicineId);
       return medicine;
    }

    public Medicine update(Medicine medicine) {
        medicineTable.put(medicine.getMedicineID(),medicine);
        Medicine savedMedicine = medicineTable.get(medicine.getMedicineID());
        return savedMedicine;
    }

    public void delete(String medicineId) {
        medicineTable.remove(medicineId);
    }
}
