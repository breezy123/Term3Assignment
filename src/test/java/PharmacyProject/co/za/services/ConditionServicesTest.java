package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Condition;
import PharmacyProject.co.za.factories.ConditionFactory;
import PharmacyProject.co.za.services.ImplServi.ConditionServicesImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by aubrey on 08/08/2017.
 */
public class ConditionServicesTest {

    ConditionServices services;
    Map<String,String>value;

    @BeforeMethod
    public void setUp() throws Exception {
            services = new ConditionServicesImpl(); {
            value = new HashMap<String, String>();
            value.put("conditionId","4144");
            value.put("conditionName","Birdflue");
        }
    }

    @Test
    public void testCreate() throws Exception {
        Condition condition = ConditionFactory.getCondition(value);
        services.create(condition);
        assertEquals("4144",condition.getConditionId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Condition readCondtion = services.read("4144");
        assertEquals("Birdflue",readCondtion.getConditionName());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Condition condition = services.read("4144");
        Condition newCondition = new Condition.Builder()
                .conditionId("4144")
                .conditionName("Birdflue")
                .build();

        services.update(newCondition);
        Condition updateCondition = services.read("4144");
        assertEquals("Birdflue",updateCondition.getConditionName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        services.delete("4144");
        Condition condition = services.read("4144");
        assertNull(condition);
    }

}