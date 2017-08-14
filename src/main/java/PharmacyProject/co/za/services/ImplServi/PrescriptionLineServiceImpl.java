package PharmacyProject.co.za.services.ImplServi;

import PharmacyProject.co.za.domains.Prescriptionline;
import PharmacyProject.co.za.repositories.Imple.PrescriptionLineRepositoryImpl;
import PharmacyProject.co.za.repositories.PrescriptionLineRepository;
import PharmacyProject.co.za.services.PrescriptionLineService;
/**
 * Created by aubrey on 08/08/2017.
 */
public class PrescriptionLineServiceImpl implements PrescriptionLineService {

    private Prescriptionline prescriptionlineObj = new Prescriptionline();
    static PrescriptionLineRepository repository = PrescriptionLineRepositoryImpl.getInstance();

    public static PrescriptionLineRepositoryImpl getInstance(){
        if(repository==null){
            repository = new PrescriptionLineRepositoryImpl();
        }
        return (PrescriptionLineRepositoryImpl)repository;
    }

    public Prescriptionline create(Prescriptionline prescriptionline) {
        return  repository.create(prescriptionline);
    }

    public Prescriptionline read(int prescriptionId) {
        return repository.read(prescriptionId);
    }

    public Prescriptionline update(Prescriptionline prescriptionline) {
       return  repository.update(prescriptionline);
    }

    public double taxDue(){
        return 0.14;
    }
    public double prescriptionTotal(int qauntity){

        return (prescriptionlineObj.getPrice() * qauntity * taxDue()) + prescriptionlineObj.getPrice() * qauntity;
    }
    public void delete(int prescriptionId) {
            repository.delete(prescriptionId);
    }
}
