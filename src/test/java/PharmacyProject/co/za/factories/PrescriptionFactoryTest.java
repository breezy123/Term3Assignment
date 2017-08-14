package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.Pharmacist;
import PharmacyProject.co.za.domains.Prescription;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;
import static org.testng.Assert.assertEquals;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PrescriptionFactoryTest {
    Map<Integer,Integer>value;

    Prescription prescription;
    Pharmacist pharmacist;
    Patient patient;
    Date today = new Date();
    Prescription prescription1 ;

    @BeforeMethod
    public void setUp() throws Exception {

        prescription1 = new Prescription();
        pharmacist = new Pharmacist.Builder()
                .pharmacistID("CTN9382")
                .pharmacistName("Medi-Chemist")
                .qualification("PHD Medicine")
                .build();

        patient = new Patient.Builder()
                .patientId("ABY3872")
                .patientName("Aubrey")
                .medicalaidNumber("DCY3892")
                .medicalaidName("Dicovery")
                .build();

        prescription = new Prescription.Builder()
                .prescriptionID(101114144)
                .prescriptionDate(today)
                .pharmacistID(pharmacist)
                .patientID(patient)
                .doctorId("3726QQLLN")
                .build();

        value = new HashMap<Integer, Integer>();
        value.put(prescription1.getPrescriptionID(),9023182);

    }

    @Test
    public void testGetPrecscription() throws Exception {

        Prescription prescriptionObject = PrescriptionFactory.getPrecscription(value,today,
                "3726QQLLN",patient,pharmacist);
        assertEquals(9023182,prescriptionObject.getPrescriptionID());
    }

}