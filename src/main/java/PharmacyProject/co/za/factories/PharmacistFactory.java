package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Pharmacist;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PharmacistFactory {

    public static Pharmacist getPharmacist(Map<String,String>value){

        Pharmacist pharmacist = new Pharmacist.Builder()
                .pharmacistID(value.get("pharmacistID"))
                .pharmacistName(value.get("pharmacistName"))
                .qualification(value.get("qualification"))
                .build();

        return pharmacist;
    }
}
