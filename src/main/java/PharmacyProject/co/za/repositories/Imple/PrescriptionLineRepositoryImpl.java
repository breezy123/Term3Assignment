package PharmacyProject.co.za.repositories.Imple;

import PharmacyProject.co.za.domains.Prescriptionline;
import PharmacyProject.co.za.repositories.PrescriptionLineRepository;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PrescriptionLineRepositoryImpl implements PrescriptionLineRepository {

    private static PrescriptionLineRepositoryImpl repository=null;

    private Map<Integer,Prescriptionline>prescriptionTable;

    public PrescriptionLineRepositoryImpl(){
        prescriptionTable = new HashMap<Integer, Prescriptionline>();
    }

    public static PrescriptionLineRepositoryImpl getInstance(){
        if(repository==null){
            repository = new PrescriptionLineRepositoryImpl();
        }
        return repository;
    }

    public Prescriptionline create(Prescriptionline prescriptionline) {
        prescriptionTable.put(prescriptionline.getPrescriptionID().getPrescriptionID(),prescriptionline);
        Prescriptionline savedPrescriptionLine = prescriptionTable.get(prescriptionline.getPrescriptionID());
        return savedPrescriptionLine;
    }

    public Prescriptionline read(int prescriptionId) {
        Prescriptionline prescriptionline = prescriptionTable.get(prescriptionId);
        return prescriptionline;
    }

    public Prescriptionline update(Prescriptionline prescriptionline) {
        prescriptionTable.put(prescriptionline.getPrescriptionID().getPrescriptionID(),prescriptionline);
        Prescriptionline savedPrescriptionLine = prescriptionTable.get(prescriptionline.getPrescriptionID());
        return savedPrescriptionLine;
    }

    public void delete(int prescriptionId) {
        prescriptionTable.remove(prescriptionId);
    }
}
