package PharmacyProject.co.za.repositories.Imple;

import PharmacyProject.co.za.domains.Pharmacist;
import PharmacyProject.co.za.repositories.PharmacistRepository;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PharmacistRepositoryImpl implements PharmacistRepository {

    private static PharmacistRepositoryImpl repository=null;

    private Map<String,Pharmacist>pharmacistTable;

    public PharmacistRepositoryImpl(){
        pharmacistTable = new HashMap<String, Pharmacist>();
    }

    public static PharmacistRepositoryImpl getInsatance(){
        if(repository==null){
            repository = new PharmacistRepositoryImpl();
        }
        return repository;
    }

    public Pharmacist create(Pharmacist pharmacist) {
        pharmacistTable.put(pharmacist.getPharmacistID(),pharmacist);
        Pharmacist savedPharmacist = pharmacistTable.get(pharmacist.getPharmacistID());
        return  savedPharmacist;
    }

    public Pharmacist read(String pharmacistID) {
        Pharmacist pharmacist = pharmacistTable.get(pharmacistID);
        return  pharmacist;
    }

    public Pharmacist update(Pharmacist pharmacist) {
        pharmacistTable.put(pharmacist.getPharmacistID(),pharmacist);
        Pharmacist savedPharmacist = pharmacistTable.get(pharmacist.getPharmacistID());
        return  savedPharmacist;
    }

    public void delete(String pharmacistID) {
        pharmacistTable.remove(pharmacistID);
    }
}
