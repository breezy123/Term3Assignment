package PharmacyProject.co.za.factories;

/**
 * Created by aubrey on 07/08/2017.
 */
import PharmacyProject.co.za.domains.Condition;
import java.util.*;
public class ConditionFactory {

    public static Condition getCondition(Map<String,String> values){

        Condition condition = new Condition.Builder()
                .conditionId(values.get("conditionId"))
                .conditionName(values.get("conditionName"))
                .build();
        return condition;
    }
}
