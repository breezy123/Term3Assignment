package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Patient;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PatientFactory {

    public static Patient getPatient(Map<String,String>value){

        Patient patient = new Patient.Builder()
                .patientId(value.get("patientID"))
                .patientName(value.get("patientName"))
                .medicalaidName(value.get("medicalaidName"))
                .medicalaidNumber(value.get("medicalaidNumber"))
                .build();

        return patient;
    }
}
