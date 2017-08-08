package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.factories.PatientFactory;
import PharmacyProject.co.za.services.ImplServi.PatientServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by aubrey on 08/08/2017.
 */
public class PatientServiceTest {
    PatientService service;
    Map<String,String> value;
    @BeforeMethod
    public void setUp() throws Exception {
        service = new PatientServiceImpl();
        value = new HashMap<String,String>();
        value.put("patientID","AUB1990393");
        value.put("patientName","Aubrey");
        value.put("medicalaidName","Discovery");
        value.put("medicalaidNumber","DCS938382");
    }

    @Test
    public void testCreate() throws Exception {
        Patient patient = PatientFactory.getPatient(value);
        service.create(patient);
        assertEquals("DCS938382",patient.getMedicalaidNumber());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Patient patient = service.read("AUB1990393");
        assertEquals("DCS938382",patient.getMedicalaidNumber());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Patient patient = service.read("AUB1990393");
        Patient newPatient = new Patient.Builder()
                .patientId("AUB1990393")
                .patientName("Aubrey")
                .medicalaidName("Discovery")
                .medicalaidNumber("DCS938382")
                .build();

        service.update(newPatient);
        Patient Update = service.read("AUB1990393");
        assertEquals("DCS938382",Update.getMedicalaidNumber());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("AUB1990393");
        Patient patient = service.read("AUB1990393");
        assertNull(patient);
    }

}