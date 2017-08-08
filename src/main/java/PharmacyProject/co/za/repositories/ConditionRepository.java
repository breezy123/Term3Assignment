package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.Condition;

/**
 * Created by aubrey on 07/08/2017.
 */
public interface ConditionRepository {
    Condition create(Condition condition);
    Condition read(String conditionId);
    Condition update(Condition condition);
    void delete(String conditionId);
}
