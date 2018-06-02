package controllers.formatters;

import java.io.Serializable;

public class BloodCounterType implements Serializable {
    private BloodCounterRH positiveRH;
    private BloodCounterRH negativeRH;

    public BloodCounterType(BloodCounterRH positiveRH, BloodCounterRH negativeRH) {
        this.positiveRH = positiveRH;
        this.negativeRH = negativeRH;
    }

    public BloodCounterType() {
        setPositiveRH(new BloodCounterRH());
        setNegativeRH(new BloodCounterRH());
    }

    public BloodCounterRH getPositiveRH() {
        return positiveRH;
    }

    public void setPositiveRH(BloodCounterRH positiveRH) {
        this.positiveRH = positiveRH;
    }

    public BloodCounterRH getNegativeRH() {
        return negativeRH;
    }

    public void setNegativeRH(BloodCounterRH negativeRH) {
        this.negativeRH = negativeRH;
    }
}
