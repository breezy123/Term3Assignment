package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Medicine;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class MedicineFactory {

    public static Medicine getMedicine(Map<String,String>value,double medicinePrice){

        Medicine medicine = new Medicine.Builder()
                .medicineId(value.get("medicineID"))
                .medicineName(value.get("medicineName"))
                .medicinePrice(medicinePrice)
                .build();

        return medicine;
    }
}
