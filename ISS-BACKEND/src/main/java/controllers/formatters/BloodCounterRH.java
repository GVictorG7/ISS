package controllers.formatters;

import java.io.Serializable;

public class BloodCounterRH implements Serializable {
    private int noOfPlasma;
    private int noOfRedcell;
    private int noOfWhole;
    private int noOfThrombocyte;

    public BloodCounterRH() {
        setNoOfPlasma(0);
        setNoOfRedcell(0);
        setNoOfWhole(0);
        setNoOfThrombocyte(0);
    }

    public BloodCounterRH(int noOfPlasma, int noOfRedcell, int noOfWhole, int noOfThrombocyte) {
        this.noOfPlasma = noOfPlasma;
        this.noOfRedcell = noOfRedcell;
        this.noOfWhole = noOfWhole;
        this.noOfThrombocyte = noOfThrombocyte;
    }

    public int getNoOfPlasma() {
        return noOfPlasma;
    }

    public void setNoOfPlasma(int noOfPlasma) {
        this.noOfPlasma = noOfPlasma;
    }

    public int getNoOfRedcell() {
        return noOfRedcell;
    }

    public void setNoOfRedcell(int noOfRedcell) {
        this.noOfRedcell = noOfRedcell;
    }

    public int getNoOfWhole() {
        return noOfWhole;
    }

    public void setNoOfWhole(int noOfWhole) {
        this.noOfWhole = noOfWhole;
    }

    public int getNoOfThrombocyte() {
        return noOfThrombocyte;
    }

    public void setNoOfThrombocyte(int noOfThrombocyte) {
        this.noOfThrombocyte = noOfThrombocyte;
    }
}
