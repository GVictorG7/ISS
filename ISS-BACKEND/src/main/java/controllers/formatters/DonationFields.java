package controllers.formatters;

import model.Donor;
import model.HealthIssue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DonationFields implements HasDateFormat{
    private Long idDonor;

    private LocalDate collectionDate;

    private String forPerson;

    private Set<HealthIssue> healthIssues;


    public Long getIdDonor() {
        return idDonor;
    }

    public void setIdDonor(Long idDonor) {
        this.idDonor = idDonor;
    }

    public LocalDate getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = LocalDate.parse(collectionDate, dateFormat);
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
}
