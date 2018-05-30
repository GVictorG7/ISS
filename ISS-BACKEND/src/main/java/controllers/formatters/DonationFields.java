package controllers.formatters;

import model.DonationStatus;
import model.HealthIssue;

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

    public String getCollectionDate() {
//        LocalDate localDate=setCollectionDate(collectionDate);
        return collectionDate;
    }

    private String bloodRH;

    private String bloodType;

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


    public Long getIdDonatie() {
        return idDonatie;
    }

    public void setIdDonatie(Long idDonatie) {
        this.idDonatie = idDonatie;
    }

    public String getBloodRH() {
        return bloodRH;
    }

    public void setBloodRH(String bloodRH) {
        this.bloodRH = bloodRH;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
