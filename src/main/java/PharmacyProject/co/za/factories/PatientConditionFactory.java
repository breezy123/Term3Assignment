package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Condition;
import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.PatientCondition;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PatientConditionFactory {

    public static PatientCondition getPatientCondition(Map<Date,Date>value, Condition conditionID,Patient patientID){

        //PatientCondition patientCondition1 = new PatientCondition();
        Date today = new Date();
        Patient patient = new Patient.Builder()
                .patientId("patientId")
                .patientName("patientName")
                .medicalaidName("medicalaidName")
                .medicalaidNumber("medicalaidNumber")
                .build();

        PatientCondition patientCondition = new PatientCondition.Builder()
                .patientId(patientID)
                .conditionId(conditionID)
                .dateDiagnosed(value.get(today))
                .build();


        return patientCondition;
    }
}
