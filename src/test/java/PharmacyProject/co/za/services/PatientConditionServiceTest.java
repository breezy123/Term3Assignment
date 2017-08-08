package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Condition;
import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.PatientCondition;
import PharmacyProject.co.za.factories.PatientConditionFactory;
import PharmacyProject.co.za.services.ImplServi.PatientConditionServiceImpl;
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
public class PatientConditionServiceTest {
    Map<Date,Date> value;
    PatientConditionService service;
    Date today = new Date();
    Condition condition;
    Patient patient;
    PatientCondition patientCondition;
    Patient patientObject;


    @BeforeMethod
    public void setUp() throws Exception {
        service = new PatientConditionServiceImpl();


        patient = new Patient.Builder()
                .patientId("ABLW9828")
                .patientName("Aubrey")
                .medicalaidName("Bonitas")
                .medicalaidNumber("BNT93872")
                .build();


        condition = new Condition.Builder()
                .conditionId("BFL933827")
                .conditionName("BirdFlue")
                .build();

        patientCondition = new PatientCondition.Builder()
                .patientId(patient)
                .conditionId(condition)
                .dateDiagnosed(today)
                .build();

        value = new HashMap<Date, Date>();
        value.put(today,today);
    }

    @Test
    public void testCreate() throws Exception {
        PatientCondition patientCondition = PatientConditionFactory.getPatientCondition(value,condition,patient);
        service.create(patientCondition);
        assertEquals("ABLW9828",patientCondition.getPatientId().getPatientID());

    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        PatientCondition readpatient = service.read(patient);
        assertEquals("ABLW9828",readpatient.getPatientId().getPatientID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        PatientCondition patientCondition = service.read(patient);
        PatientCondition newPatientCondition = new PatientCondition.Builder()
                .patientId(patient)
                .conditionId(condition)
                .build();

        service.update(newPatientCondition);
        PatientCondition UpdatePatientCondition =service.read(patient);
        assertEquals("BirdFlue",UpdatePatientCondition.getConditionId().getConditionName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete(patient);
        PatientCondition patientCondition = service.read(patient);
        assertNull(patientCondition);
    }

}