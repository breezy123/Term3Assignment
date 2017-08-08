package PharmacyProject.co.za.repositories;
import PharmacyProject.co.za.domains.Pharmacist;
/**
 * Created by aubrey on 07/08/2017.
 */
public interface PharmacistRepository {

    Pharmacist create(Pharmacist pharmacist);
    Pharmacist read(String pharmacistID);
    Pharmacist update(Pharmacist pharmacist);
    void delete(String pharmacistID);
}
