package PharmacyProject.co.za.repositories;

import PharmacyProject.co.za.domains.*;
import PharmacyProject.co.za.factories.PrescriptionLineFactory;
import PharmacyProject.co.za.repositories.Imple.PrescriptionLineRepositoryImpl;
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
public class PrescriptionLineRepositoryTest {
    Map<Integer,Integer> value;

    PrescriptionLineRepository repository;
    Prescription prescription;
    Pharmacist pharmacist;
    Patient patient;
    Date today = new Date();
    Medicine medicine;
    Prescriptionline prescription2;
    Prescriptionline prescriptionline1;
    @BeforeMethod
    public void setUp() throws Exception {

        prescriptionline1 = new Prescriptionline();

        repository = PrescriptionLineRepositoryImpl.getInstance();

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
        value.put(prescriptionline1.getLineId(),4144);
    }

    @Test
    public void testCreate() throws Exception {
        Prescriptionline prescriptionline = PrescriptionLineFactory.getPrescriptionLine(value,prescription,"Once a day",
                medicine,139.89);
        repository.create(prescriptionline);
        assertEquals("PND39837",prescriptionline.getMedicineID().getMedicineID());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Prescriptionline prescriptionline = repository.read(4144);
        assertEquals("PND39837",prescriptionline.getMedicineID().getMedicineID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Prescriptionline prescriptionlineObject =repository.read(4144);
        Prescriptionline newPrescriptionLine = new Prescriptionline.Builder()
                .lineID(4144)
                .prescriptionID(prescription)
                .instructions("Once a Day")
                .medicineID(medicine)
                .price(139.99)
                .build();

        repository.update(newPrescriptionLine);
        Prescriptionline updatePrescriptionline = repository.read(4144);
        assertEquals("PND39837",prescriptionlineObject.getMedicineID().getMedicineID());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        repository.delete(4144);
        Prescriptionline prescriptionline = repository.read(4144);
        assertNull(prescriptionline);
    }

}