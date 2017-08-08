package PharmacyProject.co.za.domains;

import java.io.Serializable;

/**
 * Created by aubrey on 07/08/2017.
 */
public class Medicine implements Serializable {
    private String medicineID ;
    private String medicineName;
    private double medicinePrice;

    public Medicine() {
    }

    public String getMedicineID() {
        return medicineID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public double getMedicinePrice() {
        return medicinePrice;
    }

    public Medicine(Builder build){
        this.medicineID = build.medicineID;
        this.medicineName = build.medicineName;
        this.medicinePrice =build.medicinePrice;
    }
    public static class Builder{
        private String medicineID ;
        private String medicineName;
        private double medicinePrice;

        public Builder medicineId(String value){
            this.medicineID = value;
            return this;
        }
        public Builder medicineName(String value){
            this.medicineName = value;
            return this;
        }
        public Builder medicinePrice(double value){
            this.medicinePrice = value;
            return this;
        }
        public Medicine build(){
            return new Medicine(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;

        Medicine medicine = (Medicine) o;

        return getMedicineID().equals(medicine.getMedicineID());
    }

    @Override
    public int hashCode() {
        return getMedicineID().hashCode();
    }
}
