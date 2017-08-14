package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.Pharmacist;
import PharmacyProject.co.za.domains.Prescription;
import PharmacyProject.co.za.factories.PrescriptionFactory;
import PharmacyProject.co.za.services.ImplServi.PrescriptionServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by aubrey on 08/08/2017.
 */
public class PrescriptionServiceTest {

    PrescriptionService service;
    Map<Integer,Integer> value;
    Prescription prescription;
    Pharmacist pharmacist;
    Patient patient;
    Date today = new Date();
    Prescription prescription1 ;

    @BeforeMethod
    public void setUp() throws Exception {
        service = new PrescriptionServiceImpl();
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
    public void testCreate() throws Exception {
        Prescription prescriptionObject = PrescriptionFactory.getPrecscription(value,today,
                "3726QQLLN",patient,pharmacist);
        service.create(prescriptionObject);
        assertEquals("3726QQLLN",prescriptionObject.getDoctorId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Prescription prescription = service.read(9023182);
        assertEquals("3726QQLLN",prescription.getDoctorId());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Prescription prescription = service.read(9023182);
        Prescription newPrescription =new  Prescription.Builder()
                .doctorId("3726QQLLN")
                .patientID(patient)
                .pharmacistID(pharmacist)
                .prescriptionDate(today)
                .build();

        service.update(newPrescription);
        Prescription Update = service.read(9023182);
        assertEquals("3726QQLLN",prescription.getDoctorId());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete(9023182);
        Prescription prescription =service.read(9023182);
        assertNull(prescription);
    }

}