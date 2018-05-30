package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id = 1L;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_donor")
    private Donor donor;

    @Column(name = "collectionDate")
    private LocalDate collectionDate;

    @Column(name = "for_person")
    private String forPerson;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DonationStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_rh")
    private BloodRH bloodRH;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_type")
    private BloodType bloodType;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = HealthIssue.class)
    @CollectionTable(name = "healthIssues", joinColumns = @JoinColumn(name = "IDHealthIssue"))
    @Column(name = "IDHealthIssues")
    private Set<HealthIssue> healthIssues;

    public Donation() {
    }

    public Donation(Donor donor) {
        this.donor = donor;
    }


    public Donation(Long id,Donor donor, LocalDate collectionDate, String forPerson, DonationStatus status, BloodRH bloodRH, BloodType bloodType, Set<HealthIssue> healthIssues) {
        this.id=id;
        this.donor = donor;
        this.collectionDate = collectionDate;
        this.forPerson = forPerson;
        this.status = status;
        this.bloodRH = bloodRH;
        this.bloodType = bloodType;
        this.healthIssues = healthIssues;
    }
    public Donation(Donor donor, LocalDate collectionDate, String forPerson, DonationStatus status, BloodRH bloodRH, BloodType bloodType, Set<HealthIssue> healthIssues) {
        this.donor = donor;
        this.collectionDate = collectionDate;
        this.forPerson = forPerson;
        this.status = status;
        this.bloodRH = bloodRH;
        this.bloodType = bloodType;
        this.healthIssues = healthIssues;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public LocalDate getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(LocalDate collectionDate) {
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

    public DonationStatus getStatus() {
        return status;
    }

    public void setStatus(DonationStatus status) {
        this.status = status;
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

    public long getId() {
        return id;
    }
}
