package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Pharmacist;

/**
 * Created by aubrey on 08/08/2017.
 */
public interface PharmacistService {
    Pharmacist create(Pharmacist pharmacist);
    Pharmacist read(String pharmacistID);
    Pharmacist update(Pharmacist pharmacist);
    void delete(String pharmacistID);
}
