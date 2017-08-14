package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Condition;
import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.PatientCondition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.*;

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
    PatientCondition patientConditionObject;

    ///Patient patientObject;

    @BeforeMethod
    public void setUp() throws Exception {
        patientConditionObject = new PatientCondition();

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
        //System.out.println(patientCondition.getPatientId().getPatientID());
    }
    @Test
    public void testGetPatientCondition() throws Exception {

        PatientCondition patientConditionObject = PatientConditionFactory.getPatientCondition(value,condition,patient);
        assertEquals("Aubrey",patientConditionObject.getPatientId().getPatientName());
    }
}