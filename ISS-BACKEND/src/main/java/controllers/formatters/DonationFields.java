package controllers.formatters;

import model.Donor;
import model.HealthIssue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DonationFields {
    private static final DateTimeFormatter timeFormat = DateTimeFormatter.ISO_LOCAL_DATE; //YYYY-MM-DD
    private Long idDonor;

    private LocalDate collectionDate;

    private String forPerson;

    private Set<HealthIssue> healthIssues;


    public DonationFields() {
    }

    public DonationFields(Long idDonor, String collectionDate, String forPerson, List<HealthIssue> healthIssues){
        this.idDonor = idDonor;
        this.collectionDate = LocalDate.parse(collectionDate, timeFormat);
        this.forPerson = forPerson;
        this.healthIssues = new HashSet<>(healthIssues);
    }


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
        this.collectionDate = LocalDate.parse(collectionDate, timeFormat);
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
}
