package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.Condition;
import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.PatientCondition;
import PharmacyProject.co.za.factories.PatientConditionFactory;
import PharmacyProject.co.za.repositories.Imple.PatientConditionRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;
import static org.testng.Assert.*;
/**
 * Created by aubrey on 08/08/2017.
 */

public class PatientConditionRepositoryTest {
    Map<Date,Date>value;
    PatientConditionRepository repository;
    Date today = new Date();
    Condition condition;
    Patient patient;
    PatientCondition patientCondition;
    Patient patientObject;

    @BeforeMethod
    public void setUp() throws Exception {
       // patientObject = new Patient();

        repository = PatientConditionRepositoryImpl.getInstance();

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
        repository.create(patientCondition);
        assertEquals("ABLW9828",patientCondition.getPatientId().getPatientID());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        PatientCondition readpatient = repository.read(patient);
        assertEquals("ABLW9828",readpatient.getPatientId().getPatientID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        PatientCondition patientCondition = repository.read(patient);
        PatientCondition newPatientCondition = new PatientCondition.Builder()
                .patientId(patient)
                .conditionId(condition)
                .build();

        repository.update(newPatientCondition);
        PatientCondition UpdatePatientCondition =repository.read(patient);
        assertEquals("BirdFlue",UpdatePatientCondition.getConditionId().getConditionName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        repository.delete(patient);
        PatientCondition patientCondition = repository.read(patient);
        assertNull(patientCondition);
    }

}