package PharmacyProject.co.za.domains;

import java.io.Serializable;

/**
 * Created by aubrey on 07/08/2017.
 */
public class Pharmacist implements Serializable {

    private String pharmacistID;
    private String pharmacistName;
    private String qualification;


    public Pharmacist() {
    }

    public String getPharmacistID() {
        return pharmacistID;
    }

    public String getPharmacistName() {
        return pharmacistName;
    }

    public String getQualification() {
        return qualification;
    }

    public Pharmacist(Builder build){
        this.pharmacistID = build.pharmacistID;
        this.pharmacistName = build.pharmacistName;
        this.qualification = build.qualification;
    }
    public static class Builder{
        private String pharmacistID;
        private String pharmacistName;
        private String qualification;

        public Builder pharmacistID(String value){
            this.pharmacistID =value;
            return this;
        }
        public Builder pharmacistName(String value){
            this.pharmacistName =value;
            return this;
        }
        public Builder qualification(String value){
            this.qualification =value;
            return this;
        }
        public Pharmacist build(){
            return new Pharmacist(this);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pharmacist)) return false;

        Pharmacist that = (Pharmacist) o;

        return getPharmacistID().equals(that.getPharmacistID());
    }

    @Override
    public int hashCode() {
        return getPharmacistID().hashCode();
    }
}
