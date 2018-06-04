package controllers.formatters;

import model.DonationStatus;
import model.HealthIssue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DonationFields implements HasDateFormat {
    private Long id;

    private String forPerson;

    private Set<HealthIssue> healthIssues;

    private DonationStatus status;

    private String bloodRH;

    private String bloodType;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public DonationFields() {

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
