package PharmacyProject.co.za.repositories.Imple;

import PharmacyProject.co.za.domains.Prescription;
import PharmacyProject.co.za.repositories.PrescriptionRepository;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PrescriptionRepositoryImple implements PrescriptionRepository {

    private static PrescriptionRepositoryImple repository=null;

    private Map<Integer,Prescription>prescriptionTable;

    public PrescriptionRepositoryImple(){
        prescriptionTable = new HashMap<Integer, Prescription>();
    }

    public static PrescriptionRepositoryImple getInstance(){
        if(repository==null){
            repository = new PrescriptionRepositoryImple();
        }
        return repository;
    }

    public Prescription create(Prescription prescription) {
        prescriptionTable.put(prescription.getPrescriptionID(),prescription);
        Prescription savedPrescription = prescriptionTable.get(prescription.getPrescriptionID());
        return  savedPrescription;
    }

    public Prescription read(int prescriptionId) {
        Prescription prescription = prescriptionTable.get(prescriptionId);
        return  prescription;
    }

    public Prescription update(Prescription prescription) {
        prescriptionTable.put(prescription.getPrescriptionID(),prescription);
        Prescription savedPrescription = prescriptionTable.get(prescription.getPrescriptionID());
        return  savedPrescription;
    }

    public void delete(int prescriptionId) {
        prescriptionTable.remove(prescriptionId);
    }
}
