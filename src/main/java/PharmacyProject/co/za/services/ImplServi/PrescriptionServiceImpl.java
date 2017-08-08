package PharmacyProject.co.za.services.ImplServi;

import PharmacyProject.co.za.domains.Prescription;
import PharmacyProject.co.za.repositories.Imple.PrescriptionRepositoryImple;
import PharmacyProject.co.za.repositories.PrescriptionRepository;
import PharmacyProject.co.za.services.PrescriptionService;

/**
 * Created by aubrey on 08/08/2017.
 */
public class PrescriptionServiceImpl implements PrescriptionService {

    static PrescriptionRepository repository = PrescriptionRepositoryImple.getInstance();

    public static PrescriptionRepositoryImple getInstance(){
        if(repository==null){
            repository = new PrescriptionRepositoryImple();
        }
        return (PrescriptionRepositoryImple)repository;
    }
    public Prescription create(Prescription prescription) {
       return  repository.create(prescription);
    }

    public Prescription read(int prescriptionId) {
        return repository.read(prescriptionId);
    }

    public Prescription update(Prescription prescription) {
        return repository.update(prescription);
    }

    public void delete(int prescriptionId) {
        repository.delete(prescriptionId);
    }
}
