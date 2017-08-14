package PharmacyProject.co.za.repositories.Imple;

import PharmacyProject.co.za.domains.Prescriptionline;
import PharmacyProject.co.za.repositories.PrescriptionLineRepository;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PrescriptionLineRepositoryImpl implements PrescriptionLineRepository {

    private Prescriptionline prescriptionlineObj = new Prescriptionline();
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
        prescriptionTable.put(prescriptionline.getLineId(),prescriptionline);
        Prescriptionline savedPrescriptionLine = prescriptionTable.get(prescriptionline.getLineId());
        return savedPrescriptionLine;
    }

    public Prescriptionline read(int lineID) {
        Prescriptionline prescriptionline = prescriptionTable.get(lineID);
        return prescriptionline;
    }

    public Prescriptionline update(Prescriptionline prescriptionline) {
        prescriptionTable.put(prescriptionline.getLineId(),prescriptionline);
        Prescriptionline savedPrescriptionLine = prescriptionTable.get(prescriptionline.getLineId());
        return savedPrescriptionLine;
    }
    public double taxDue(){
        return 0.14;
    }
    public double prescriptionTotal(int qauntity){

        return (prescriptionlineObj.getPrice() * qauntity * taxDue()) + prescriptionlineObj.getPrice() * qauntity;
    }
    public void delete(int lineID) {
        prescriptionTable.remove(lineID);
    }
}
