package controllers.formatters;

import model.BloodRH;
import model.BloodType;
import model.DonationStatus;
import model.HealthIssue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DonationFields implements HasDateFormat {
    private Long idDonatie;

    private Long idDonor;

    private String collectionDate;

    private String forPerson;

    private Set<HealthIssue> healthIssues;

    private DonationStatus status;

    public Long getIdDonor() {
        return idDonor;
    }

    public void setIdDonor(Long idDonor) {
        this.idDonor = idDonor;
    }

    public LocalDate getCollectionDate() {
        LocalDate localDate=setCollectionDate(collectionDate);
        return localDate;
    }

    private BloodRH bloodRH;

    private BloodType bloodType;

    public LocalDate setCollectionDate(String collectionDateString) {

        return LocalDate.parse(collectionDateString, dateFormat);
    }

    public String getForPerson() {
        return forPerson;
    }

    public void setForPerson(String forPerson) {
        this.forPerson = forPerson;
    }

    public Set<HealthIssue> getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(List<HealthIssue> healthIssues) {
        this.healthIssues = new HashSet<>(healthIssues);
    }


    @Override
    public String toString() {
        return "DonationFields{" +
                "idDonor=" + idDonor +
                ", collectionDate=" + collectionDate +
                ", forPerson='" + forPerson + '\'' +
                ", healthIssues=" + healthIssues +
                '}';
    }

    public DonationStatus getStatus() {
        return status;
    }

    public void setStatus(DonationStatus status) {
        this.status = status;
    }

    public BloodRH getBloodRH() {
        return bloodRH;
    }

    public void setBloodRH(BloodRH bloodRH) {
        this.bloodRH = bloodRH;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Long getIdDonatie() {
        return idDonatie;
    }

    public void setIdDonatie(Long idDonatie) {
        this.idDonatie = idDonatie;
    }
}
