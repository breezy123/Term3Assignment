package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.Pharmacist;
import PharmacyProject.co.za.domains.Prescription;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PrescriptionFactory {

    public static Prescription getPrecscription(Map<Integer,Integer> value, Date datedescription, String doctorID,
                                                Patient patient, Pharmacist pharmacist){

        Prescription prescriptionID = new Prescription();

        Prescription prescription = new Prescription.Builder()

                .prescriptionID(value.get(prescriptionID.getPrescriptionID()))
                .prescriptionDate(datedescription)
                .doctorId(doctorID)
                .patientID(patient)
                .pharmacistID(pharmacist)
                .build();

        return prescription;
    }
}
