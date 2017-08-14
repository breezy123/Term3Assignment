package PharmacyProject.co.za.domains;

import java.io.Serializable;

/**
 * Created by aubrey on 07/08/2017.
 */
public class Prescriptionline implements Serializable {

    private int lineId;
    private Prescription prescriptionID;
    private String instructions;
    private Medicine medicineID;
    private double price;

    public Prescriptionline() {
    }

    public Prescription getPrescriptionID() {
        return prescriptionID;
    }

    public int getLineId() {
        return lineId;
    }

    public String getInstructions() {
        return instructions;
    }

    public Medicine getMedicineID() {
        return medicineID;
    }

    public double getPrice() {
        return price;
    }

    /*public double taxDue(){
        return 0.14;
    }

    public double prescriptionTotal(double quantity){
        return (price * quantity * taxDue()) + price *quantity;
    }*/


    public Prescriptionline(Builder build){
        this.prescriptionID = build.prescriptionID;
        this.lineId = build.lineId;
        this.instructions = build.instructions;
        this.medicineID = build.medicineID;
        this.price = build.price;
    }
    public static class Builder{
        private Prescription prescriptionID;
        private int lineId;
        private String instructions;
        private Medicine medicineID;
        private double price;

        public Builder prescriptionID(Prescription value){
            this.prescriptionID = value;
            return this;
        }
        public Builder lineID(int value){
            this.lineId = value;
            return this;
        }
        public Builder instructions(String value){
            this.instructions = value;
            return this;
        }
        public Builder medicineID(Medicine value){
            this.medicineID = value;
            return this;
        }

        public Builder price(double value){
            this.price = value;
            return this;
        }
        public Prescriptionline build(){
            return new Prescriptionline(this);
        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prescriptionline)) return false;

        Prescriptionline that = (Prescriptionline) o;

        return getLineId() == that.getLineId();
    }

    @Override
    public int hashCode() {
        return getLineId();
    }
}
