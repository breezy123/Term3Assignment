package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.*;

import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PrescriptionLineFactory {

    public static Prescriptionline getPrescriptionLine(Map<Integer,Integer>value,
                                                       Prescription prescription, String instructions,
                                                       Medicine medicine,double price){

        Prescriptionline prescriptionline2 = new Prescriptionline();
        Prescriptionline prescriptionline = new Prescriptionline.Builder()

                .lineID(value.get(prescriptionline2.getLineId()))
                .prescriptionID(prescription)
                .instructions("instructions")
                .price(price)
                .medicineID(medicine)
                .build();
        return prescriptionline;
    }
}
