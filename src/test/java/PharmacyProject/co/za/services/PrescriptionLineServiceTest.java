package PharmacyProject.co.za.services;

import PharmacyProject.co.za.domains.*;
import PharmacyProject.co.za.factories.PrescriptionLineFactory;
import PharmacyProject.co.za.repositories.PrescriptionLineRepository;
import PharmacyProject.co.za.services.ImplServi.PrescriptionLineServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by aubrey on 08/08/2017.
 */
public class PrescriptionLineServiceTest {
    PrescriptionLineService service;
    Prescription prescription;
    Map<Integer,Integer> value;
    Pharmacist pharmacist;
    Patient patient;
    Date today = new Date();
    Medicine medicine;
    Prescriptionline prescription2;
    Prescriptionline prescription3;
    PrescriptionLineRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {

        prescription3 = new Prescriptionline();
        service = new PrescriptionLineServiceImpl();

        patient = new Patient.Builder()
                .patientId("ABY7382")
                .patientName("Aubrey")
                .medicalaidNumber("DCY8393")
                .medicalaidName("Discovery")
                .build();


        pharmacist = new Pharmacist.Builder()
                .pharmacistID("124TRQF")
                .pharmacistName("TCL-Pharmacy")
                .qualification("PHD Medicine")
                .build();

        prescription = new Prescription.Builder()
                .doctorId("893HGSTS")
                .patientID(patient)
                .pharmacistID(pharmacist)
                .prescriptionDate(today)
                .prescriptionID(73636271)
                .build();

        medicine = new Medicine.Builder()
                .medicineId("PND39837")
                .medicineName("Panado")
                .medicinePrice(139.99)
                .build();

        prescription2 = new Prescriptionline.Builder()
                .lineID(4144)
                .prescriptionID(prescription)
                .instructions("Once a Day")
                .medicineID(medicine)
                .price(139.89)
                .build();

        value = new HashMap<Integer, Integer>();
        value.put(prescription3.getLineId(),4144);
    }

    @Test
    public void testCreate() throws Exception {
        Prescriptionline prescriptionline = PrescriptionLineFactory.getPrescriptionLine(value,prescription,"Once a day",
                medicine,139.89);
        service.create(prescriptionline);
        assertEquals("PND39837",prescriptionline.getMedicineID().getMedicineID());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Prescriptionline prescriptionline =service.read(4144);
        assertEquals("PND39837",prescriptionline.getMedicineID().getMedicineID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Prescriptionline prescriptionline =service.read(4144);
        Prescriptionline newPrescriptionLine = new Prescriptionline.Builder()
                .lineID(4144)
                .prescriptionID(prescription)
                .instructions("Once a Day")
                .medicineID(medicine)
                .price(139.99)
                .build();

        service.update(newPrescriptionLine);
        Prescriptionline updatePrescriptionline = service.read(4144);
        assertEquals("PND39837",prescriptionline.getMedicineID().getMedicineID());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        service.delete(4144);
        Prescriptionline prescriptionline = service.read(4144);
        assertNull(prescriptionline);
    }

}