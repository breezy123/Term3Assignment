package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Condition;

/**
 * Created by aubrey on 08/08/2017.
 */
public interface ConditionServices {
    Condition create(Condition condition);
    Condition read(String conditionId);
    Condition update(Condition condition);
    void delete(String conditionId);
}
