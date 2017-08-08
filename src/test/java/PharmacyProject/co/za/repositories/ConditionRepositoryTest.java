package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.factories.ConditionFactory;
import PharmacyProject.co.za.repositories.Imple.ConditionRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PharmacyProject.co.za.domains.Condition;
import java.util.HashMap;
import java.util.Map;
import static org.testng.Assert.*;
/**
 * Created by aubrey on 07/08/2017.
 */
public class ConditionRepositoryTest {
    Map<String,String>value;
    ConditionRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = ConditionRepositoryImpl.getInstance();
        value = new HashMap<String, String>();
        value.put("conditionId","4144");
        value.put("conditionName","Birdflue");
    }

    @Test
    public void testCreate() throws Exception {
        Condition condition = ConditionFactory.getCondition(value);
        repository.create(condition);
        assertEquals("4144",condition.getConditionId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Condition readCondtion = repository.read("4144");
        assertEquals("Birdflue",readCondtion.getConditionName());

    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Condition condition = repository.read("4144");
        Condition newCondition = new Condition.Builder()
                .conditionId("4144")
                .conditionName("Birdflue")
                .build();

        repository.update(newCondition);
        Condition updateCondition = repository.read("4144");
        assertEquals("Birdflue",updateCondition.getConditionName());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        repository.delete("4144");
        Condition condition = repository.read("4144");
        assertNull(condition);
    }

}