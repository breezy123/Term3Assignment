package PharmacyProject.co.za.services.ImplServi;

import PharmacyProject.co.za.domains.Pharmacist;
import PharmacyProject.co.za.repositories.Imple.PharmacistRepositoryImpl;
import PharmacyProject.co.za.repositories.PharmacistRepository;
import PharmacyProject.co.za.services.PharmacistService;

/**
 * Created by aubrey on 08/08/2017.
 */
public class PharmacistServiceImpl implements PharmacistService {

    static PharmacistRepository repository = PharmacistRepositoryImpl.getInsatance();

    public static PharmacistRepositoryImpl getInsatance(){
        if(repository==null){
            repository = new PharmacistRepositoryImpl();
        }
        return (PharmacistRepositoryImpl)repository;
    }

    public Pharmacist create(Pharmacist pharmacist) {
        return  repository.create(pharmacist);
    }

    public Pharmacist read(String pharmacistID) {
        return  repository.read(pharmacistID);
    }

    public Pharmacist update(Pharmacist pharmacist) {
        return repository.update(pharmacist);
    }

    public void delete(String pharmacistID) {
        repository.delete(pharmacistID);
    }
}
