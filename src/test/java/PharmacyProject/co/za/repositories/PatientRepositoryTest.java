package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.factories.PatientFactory;
import PharmacyProject.co.za.repositories.Imple.PatientRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PharmacyProject.co.za.domains.Patient;
import java.util.HashMap;
import java.util.Map;
import static org.testng.Assert.*;
/**
 * Created by aubrey on 08/08/2017.
 */
public class PatientRepositoryTest {

    Map<String,String>value;
    PatientRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = PatientRepositoryImpl.getInstance();

        value = new HashMap<String,String>();
        value.put("patientID","AUB1990393");
        value.put("patientName","Aubrey");
        value.put("medicalaidName","Discovery");
        value.put("medicalaidNumber","DCS938382");
    }

    @Test
    public void testCreate() throws Exception {
        Patient patient = PatientFactory.getPatient(value);
        repository.create(patient);
        assertEquals("DCS938382",patient.getMedicalaidNumber());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Patient patient = repository.read("AUB1990393");
        assertEquals("DCS938382",patient.getMedicalaidNumber());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Patient patient = repository.read("AUB1990393");
        Patient newPatient = new Patient.Builder()
                .patientId("AUB1990393")
                .patientName("Aubrey")
                .medicalaidName("Discovery")
                .medicalaidNumber("DCS938382")
                .build();

        repository.update(newPatient);
        Patient Update = repository.read("AUB1990393");
        assertEquals("DCS938382",Update.getMedicalaidNumber());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        repository.delete("AUB1990393");
        Patient patient = repository.read("AUB1990393");
        assertNull(patient);
    }

}