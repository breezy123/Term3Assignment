package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Condition;
import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.PatientCondition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PatientConditionFactoryTest {
    Map<Date,Date>value;

    Date today = new Date();
    Condition condition;
    Patient patient;
    PatientCondition patientCondition;
    Patient patientObject;

    @BeforeMethod
    public void setUp() throws Exception {
        patientObject = new Patient();

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
    public void testGetPatientCondition() throws Exception {
        PatientCondition patientConditionObject = PatientConditionFactory.getPatientCondition(value,condition,patient);
        //System.out.print(patient.getPatientID());
        //System.out.println(patientCondition.getPatientId());
        assertEquals("BFL933827",patientConditionObject.getConditionId().getConditionId());
        //System.out.println(patientConditionObject.getConditionId().getConditionId());
    }

}