package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Medicine;
import PharmacyProject.co.za.domains.Prescription;
import PharmacyProject.co.za.domains.Prescriptionline;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PrescriptionLineFactory {

    public static Prescriptionline getPrescriptionLine(Map<Integer,Integer>value,
                                                       Prescription prescription, String instructions,
                                                       Medicine medicine,double price){

        Prescriptionline prescriptionLine1 = new Prescriptionline();

        Prescriptionline prescriptionline = new Prescriptionline.Builder()
                .prescriptionID(prescription)
                .lineID(value.get(prescriptionLine1.getLineId()))
                .instructions("instructions")
                .medicineID(medicine)
                .price(price)
                .build();

        return prescriptionline;
    }
}
