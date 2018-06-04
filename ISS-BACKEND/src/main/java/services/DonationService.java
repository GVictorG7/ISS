package services;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BloodRepository;
import repositories.DonationRepository;
import repositories.DonorRepository;
import repositories.RequestRepository;
import services.interfaces.IDonationService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class DonationService implements IDonationService {
    private final DonationRepository donationRepository;
    private final DonorRepository donorRepository;
    private final BloodRepository bloodRepository;
    private final RequestRepository requestRepository;


    @Autowired
    public DonationService(DonationRepository donationRepository, DonorRepository donorRepository, BloodRepository bloodRepository, BloodRepository bloodRepository1, RequestRepository requestRepository) {
        this.donationRepository = donationRepository;
        this.donorRepository = donorRepository;
        this.bloodRepository = bloodRepository1;
        this.requestRepository = requestRepository;
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
    public void changeStatus(Long idDonatie,String forPerson,DonationStatus status, String bloodRH, String bloodType, Set<HealthIssue> healthIssues) {
        if (status.equals(DonationStatus.ACCEPTED)) {
            Blood blood = new Blood(BloodType.valueOf(bloodType), BloodRH.valueOf(bloodRH), BloodCategory.WHOLE, false,LocalDate.now().plusDays(Blood.getDaysToExpire(BloodCategory.WHOLE)));
            Donation donation = getById(idDonatie);
            donation.setCollectionDate(LocalDate.now());
            donation.setForPerson(forPerson);
            donation.setStatus(status);
            donation.setBloodRH(BloodRH.valueOf(bloodRH));
            donation.setBloodType(BloodType.valueOf(bloodType));
            donation.setHealthIssues(healthIssues);
            donationRepository.save(donation);
            bloodRepository.save(blood);
        } else if (status.equals(DonationStatus.REJECTED)) {
            Donation donation = getById(idDonatie);
            donation.setCollectionDate(null);
            donation.setForPerson(null);
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

    @Override
    public int getAllOpenDonationsCounter() {
        return donationRepository.findAllByStatusOpne();
    }


}
