package PharmacyProject.co.za.repositories;

/**
 * Created by aubrey on 08/08/2017.
 */

import PharmacyProject.co.za.domains.Condition;
import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.PatientCondition;
import PharmacyProject.co.za.factories.PatientConditionFactory;
import PharmacyProject.co.za.repositories.Imple.PatientConditionRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
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
                .patientIdentity(patient)
                .conditionIdentity(condition)
                .dateDiagnosed(today)
                .build();

        value = new HashMap<Date, Date>();
        value.put(patientCondition.getDateDiagnosed(),today);
}

    @Test
    public void testCreate() throws Exception {
        PatientCondition patientCondition = PatientConditionFactory.getPatientCondition(value,condition,patient);
        repository.create(patientCondition);
        assertEquals("ABLW9828",patientCondition.getPatientId().getPatientID());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        PatientCondition readpatient = repository.read(patientCondition.getPatientId().getPatientID());
        //System.out.print(readpatient.getPatientId());

        assertEquals("ABLW9828",readpatient.getPatientId().getPatientID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        PatientCondition patientConditionObject = repository.read(patientCondition.getPatientId().getPatientID());
        PatientCondition newPatientCondition = new PatientCondition.Builder()
                .patientIdentity(patient)
                .conditionIdentity(condition)
                .build();

        repository.update(newPatientCondition);
        PatientCondition UpdatePatientCondition =repository.read(patientCondition.getPatientId().getPatientID());
        assertEquals("BirdFlue",UpdatePatientCondition.getConditionId().getConditionName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        repository.delete(patientCondition.getPatientId().getPatientID());
        PatientCondition patientCondition1 = repository.read(patientCondition.getPatientId().getPatientID());
        assertNull(patientCondition1);
    }

}