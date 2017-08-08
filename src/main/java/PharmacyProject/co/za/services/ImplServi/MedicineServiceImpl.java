package PharmacyProject.co.za.services.ImplServi;

import PharmacyProject.co.za.domains.Medicine;
import PharmacyProject.co.za.repositories.Imple.MedicineRepositoryImpl;
import PharmacyProject.co.za.repositories.MedicineRepository;
import PharmacyProject.co.za.services.MedicineService;

/**
 * Created by aubrey on 08/08/2017.
 */
public class MedicineServiceImpl implements MedicineService {

    static MedicineRepository repository = MedicineRepositoryImpl.getInstance();

    public static MedicineRepositoryImpl getInstance(){
        if(repository==null)
            repository = new MedicineRepositoryImpl();
        return (MedicineRepositoryImpl)repository;
    }

    public Medicine create(Medicine medicine) {
        return  repository.create(medicine);
    }

    public Medicine read(String medicineId) {
       return  repository.read(medicineId);
    }

    public Medicine update(Medicine medicine) {
        return repository.update(medicine);
    }

    public void delete(String medicineId) {
        repository.delete(medicineId);
    }
}
