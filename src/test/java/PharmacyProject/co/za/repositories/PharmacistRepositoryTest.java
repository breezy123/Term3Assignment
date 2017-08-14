package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.Pharmacist;
import PharmacyProject.co.za.factories.PharmacistFactory;
import PharmacyProject.co.za.repositories.Imple.PharmacistRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by aubrey on 08/08/2017.
 */
public class PharmacistRepositoryTest {
    Map<String,String>value;
    PharmacistRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        repository = PharmacistRepositoryImpl.getInsatance();

        value = new HashMap<String, String>();
        value.put("pharmacistID","MTL7263");
        value.put("pharmacistName","MitchellsPlain Medi-Chemist");
        value.put("qualification","PHD In Medicine");
    }

    @Test
    public void testCreate() throws Exception {
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(value);
        repository.create(pharmacist);
        assertEquals("MTL7263",pharmacist.getPharmacistID());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Pharmacist pharmacist1 = repository.read("MTL7263");
        System.out.println(pharmacist1.getPharmacistID());
        assertEquals("PHD In Medicine",pharmacist1.getQualification());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Pharmacist pharmacist = repository.read("MTL7263");
        Pharmacist newPharmacist = new Pharmacist.Builder()
                .pharmacistID("MTL7263")
                .pharmacistName("MitchellsPlain Medi-Chemist")
                .qualification("HD In Medicine")
                .build();

        repository.update(newPharmacist);
        Pharmacist UpdatePharmacist = repository.read("MTL7263");
        assertEquals("MitchellsPlain Medi-Chemist",UpdatePharmacist.getPharmacistName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        repository.delete("MTL7263");
        Pharmacist pharmacist = repository.read("MTL7263");
        assertNull(pharmacist);
    }

}