package controllers.formatters;

import model.Blood;
import model.BloodCategory;
import model.BloodRH;
import model.BloodType;

public class BloodFields {

    private BloodType bloodType;

    private BloodRH bloodRH;

    private BloodCategory bloodCategory;

    public BloodFields() {
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public BloodRH getBloodRH() {
        return bloodRH;
    }

    public void setBloodRH(BloodRH bloodRH) {
        this.bloodRH = bloodRH;
    }

    public BloodCategory getBloodCategory() {
        return bloodCategory;
    }

    public void setBloodCategory(BloodCategory bloodCategory) {
        this.bloodCategory = bloodCategory;
    }

    public Blood generateBlood(){
        return new Blood(bloodType,bloodRH,bloodCategory);
    }

    @Override
    public String toString() {
        return "BloodFields{" +
                "bloodType=" + bloodType +
                ", bloodRH=" + bloodRH +
                ", bloodCategory=" + bloodCategory +
                '}';
    }
}
