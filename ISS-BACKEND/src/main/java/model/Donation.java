package model;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_donation")
    private final long idDonation = 1L;

    @OneToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;

    @Temporal(TemporalType.DATE)
    private Date collectionDate;

    @Column(name = "for_person")
    private String forPerson;

    @ElementCollection(targetClass = HealthIssue.class)
    @CollectionTable(name = "healthIssues", joinColumns = @JoinColumn(name = "IDHealthIssue"))
    @Column(name = "IDHealthIssues")
    private Set<HealthIssue> healthIssues;

    public Donation() {
    }

    public Donation(Donor donor, Set<HealthIssue> healthIssues) {
        this.donor = donor;
        this.healthIssues = healthIssues;
        collectionDate = new Date();
    }

    public Donation(Donor donor, String forPerson, Set<HealthIssue> healthIssues) {
        this.donor = donor;
        this.forPerson = forPerson;
        this.healthIssues = healthIssues;
        this.collectionDate = new Date();
    }

    public Donation(Donor donor, Date collectionDate, Set<HealthIssue> healthIssues) {
        this.donor = donor;
        this.collectionDate = collectionDate;
        this.healthIssues = healthIssues;
    }

    public Donation(Donor donor, Date collectionDate, String forPerson, Set<HealthIssue> healthIssues) {
        this.donor = donor;
        this.collectionDate = collectionDate;
        this.forPerson = forPerson;
        this.healthIssues = healthIssues;
    }

    public long getIdDonation() {
        return idDonation;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
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

    public void setHealthIssues(Set<HealthIssue> healthIssues) {
        this.healthIssues = healthIssues;
    }
}
