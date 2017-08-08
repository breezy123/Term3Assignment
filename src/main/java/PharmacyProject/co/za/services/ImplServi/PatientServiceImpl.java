package PharmacyProject.co.za.services.ImplServi;

import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.repositories.Imple.PatientRepositoryImpl;
import PharmacyProject.co.za.repositories.PatientRepository;
import PharmacyProject.co.za.services.PatientService;

/**
 * Created by aubrey on 08/08/2017.
 */
public class PatientServiceImpl implements PatientService {

    static PatientRepository repository = PatientRepositoryImpl.getInstance();

    public static PatientRepositoryImpl getInstance(){
        if(repository==null){
            repository = new PatientRepositoryImpl();
        }
        return  (PatientRepositoryImpl)repository;
    }
    public Patient create(Patient patient) {
       return repository.create(patient);
    }

    public Patient read(String patientID) {
        return  repository.read(patientID);
    }

    public Patient update(Patient patient) {
        return  repository.update(patient);
    }

    public void delete(String patientID) {
            repository.delete(patientID);
    }
}
