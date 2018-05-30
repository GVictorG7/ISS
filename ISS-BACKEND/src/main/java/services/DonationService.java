package services;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BloodRepository;
import repositories.DonationRepository;
import repositories.DonorRepository;
import services.interfaces.IDonationService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static controllers.formatters.HasDateFormat.dateFormat;

@Service
public class DonationService implements IDonationService {
    private final DonationRepository donationRepository;
    private final DonorRepository donorRepository;
    private final BloodRepository bloodRepository;


    @Autowired
    public DonationService(DonationRepository donationRepository, DonorRepository donorRepository, BloodRepository bloodRepository, BloodRepository bloodRepository1) {
        this.donationRepository = donationRepository;
        this.donorRepository = donorRepository;
        this.bloodRepository = bloodRepository1;
    }

    @Override
    public Donation getById(Long id) {
        return donationRepository.findById(id);
    }

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public void save(Long idDonor, LocalDate collectionDate, String forPerson, DonationStatus status, BloodRH bloodRH, BloodType bloodType, Set<HealthIssue> healthIssues) {
        donationRepository.save(new Donation(
                donorRepository.findById(idDonor),
                collectionDate,
                forPerson,
                status,
                bloodRH,
                bloodType,
                healthIssues));
    }


    @Override
    public void save(Long idDonor) {
        Donation donation = new Donation(donorRepository.findById(idDonor));
        donation.setStatus(DonationStatus.OPEN);
        donation.setRequestDate(LocalDate.now());
        donationRepository.save(donation);
    }


    @Override
    public Donation deleteById(Long id) {
        return donationRepository.deleteById(id);
    }

    @Override
    public void changeStatus(Long idDonatie, Long idDonor, String forPerson, String collectionDate, DonationStatus status, String bloodRH, String bloodType, Set<HealthIssue> healthIssues) {

        LocalDate donoationDate = LocalDate.parse(collectionDate, dateFormat);

        System.out.println(donoationDate);
        System.out.println(status);
        if (status.equals(DonationStatus.ACCEPTED)) {
            System.out.println("Ajung aici acceptes");
            System.out.println(bloodRH + " " + bloodType);
            Blood blood = new Blood(BloodType.valueOf(bloodType), BloodRH.valueOf(bloodRH), BloodCategory.WHOLE, false);
            System.out.println(blood.getBloodRH() + " " + blood.getBloodCategory() + " " + blood.getBloodType());

            Donation donation = getById(idDonatie);
            donation.setCollectionDate(donoationDate);
            donation.setForPerson(forPerson);
            donation.setStatus(status);
            donation.setBloodRH(BloodRH.valueOf(bloodRH));
            donation.setBloodType(BloodType.valueOf(bloodType));
            donation.setHealthIssues(healthIssues);
            donationRepository.save(donation);
            bloodRepository.save(blood);
        } else if (status.equals(DonationStatus.REJECTED.toString())) {
            System.out.println("nu ajung");
            Donation donation = getById(idDonatie);
            donation.setCollectionDate(donoationDate);
            donation.setForPerson(forPerson);
            donation.setStatus(status);
            donation.setBloodRH(BloodRH.valueOf(bloodRH));
            donation.setBloodType(BloodType.valueOf(bloodType));
            donation.setHealthIssues(healthIssues);
            donationRepository.save(donation);
        }
    }


    /**
     * Gets all donations by donor
     *
     * @param idDonor - id of given donor
     * @return list of donations
     */
    @Override
    public List<Donation> getAllDonationsByDonor(Long idDonor) {
        Donor donor = donorRepository.getOne(idDonor);
        return donationRepository.getAllByDonor(donor);
    }

    /**
     * Updates a donation
     *
     * @param donation - the new given donation
     */
    @Override
    public void update(Donation donation) {
        donationRepository.save(donation);
    }

    /**
     * Gets all open donations
     *
     * @return list of donations
     */
    @Override
    public List<Donation> getAllOpenDonations() {
        return donationRepository.getAllByStatus(DonationStatus.OPEN);
    }




}
