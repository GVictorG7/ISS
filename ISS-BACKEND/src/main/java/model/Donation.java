package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Donations")
public class Donation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "pregnant")
    private boolean pregnant;

    @Column(name = "menstruating")
    private String menstruating;

    @Column(name = "consumed_alcohol")
    private String consumedAlcohol;

    @Column(name = "systolic_value")
    private int systolicValue;

    @Column(name = "pulse")
    private int pulse;

    @Column(name = "for_person")
    private String forPerson;

    @Column(name = "smoked")
    private boolean smoked;

    @Column(name = "well_slept")
    private boolean wellSlept;

    @Column(name = "harvest_date")
    private String harvestDate;

    @Column(name = "donor_age")
    private int donorAge;

    @Column(name = "donor_weight")
    private int donorWeight;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;

    @OneToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

    @OneToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    public Donation() {
    }

    public Donation(boolean pregnant, String menstruating, String consumedAlcohol, int systolicValue, int pulse, String forPerson, boolean smoked, boolean wellSlept, String harvestDate, int donorAge, int donorWeight, String status, Donor donor, Treatment treatment, Disease disease) {
        this.pregnant = pregnant;
        this.menstruating = menstruating;
        this.consumedAlcohol = consumedAlcohol;
        this.systolicValue = systolicValue;
        this.pulse = pulse;
        this.forPerson = forPerson;
        this.smoked = smoked;
        this.wellSlept = wellSlept;
        this.harvestDate = harvestDate;
        this.donorAge = donorAge;
        this.donorWeight = donorWeight;
        this.status = status;
        this.donor = donor;
        this.treatment = treatment;
        this.disease = disease;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public String getMenstruating() {
        return menstruating;
    }

    public void setMenstruating(String menstruating) {
        this.menstruating = menstruating;
    }

    public String getConsumedAlcohol() {
        return consumedAlcohol;
    }

    public void setConsumedAlcohol(String consumedAlcohol) {
        this.consumedAlcohol = consumedAlcohol;
    }

    public int getSystolicValue() {
        return systolicValue;
    }

    public void setSystolicValue(int systolicValue) {
        this.systolicValue = systolicValue;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public String getForPerson() {
        return forPerson;
    }

    public void setForPerson(String forPerson) {
        this.forPerson = forPerson;
    }

    public boolean isSmoked() {
        return smoked;
    }

    public void setSmoked(boolean smoked) {
        this.smoked = smoked;
    }

    public boolean isWellSlept() {
        return wellSlept;
    }

    public void setWellSlept(boolean wellSlept) {
        this.wellSlept = wellSlept;
    }

    public String getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }

    public int getDonorAge() {
        return donorAge;
    }

    public void setDonorAge(int donorAge) {
        this.donorAge = donorAge;
    }

    public int getDonorWeight() {
        return donorWeight;
    }

    public void setDonorWeight(int donorWeight) {
        this.donorWeight = donorWeight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
