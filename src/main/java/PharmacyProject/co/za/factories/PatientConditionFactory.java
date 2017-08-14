package PharmacyProject.co.za.factories;

import PharmacyProject.co.za.domains.Condition;
import PharmacyProject.co.za.domains.Patient;
import PharmacyProject.co.za.domains.PatientCondition;
import java.util.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class PatientConditionFactory {

    public static PatientCondition getPatientCondition(Map<Date,Date>value,
                                                       Condition conditionID,Patient patientObject){

        //PatientCondition patientCondition1 = new PatientCondition();
        Date today = new Date();

        PatientCondition patientCondition = new PatientCondition.Builder()
                .patientIdentity(patientObject)
                .conditionIdentity(conditionID)
                .dateDiagnosed(value.get(today))
                .build();

        return patientCondition;
    }
}
