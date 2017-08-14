package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.Pharmacist;
import PharmacyProject.co.za.factories.PharmacistFactory;
import PharmacyProject.co.za.services.ImplServi.PharmacistServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by aubrey on 08/08/2017.
 */
public class PharmacistServiceTest {
    PharmacistService service;
    Map<String,String> value;
    @BeforeMethod
    public void setUp() throws Exception {

        service = new PharmacistServiceImpl();
        value = new HashMap<String, String>();
        value.put("pharmacistID","MTL7263");
        value.put("pharmacistName","MitchellsPlain Medi-Chemist");
        value.put("qualification","PHD In Medicine");
    }

    @Test
    public void testCreate() throws Exception {
        Pharmacist pharmacist = PharmacistFactory.getPharmacist(value);
        service.create(pharmacist);
        assertEquals("MTL7263",pharmacist.getPharmacistID());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Pharmacist pharmacist1 = service.read("MTL7263");
        assertEquals("MTL7263",pharmacist1.getPharmacistID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Pharmacist pharmacist = service.read("MTL7263");
        Pharmacist newPharmacist = new Pharmacist.Builder()
                .pharmacistID("MTL7263")
                .pharmacistName("MitchellsPlain Medi-Chemist")
                .qualification("HD In Medicine")
                .build();

        service.update(newPharmacist);
        Pharmacist UpdatePharmacist = service.read("MTL7263");
        assertEquals("MitchellsPlain Medi-Chemist",UpdatePharmacist.getPharmacistName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete("MTL7263");
        Pharmacist pharmacist = service.read("MTL7263");
        assertNull(pharmacist);
    }

}