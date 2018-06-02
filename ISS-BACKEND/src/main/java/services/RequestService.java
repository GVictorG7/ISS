package services;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BloodRepository;
import repositories.DoctorRepository;
import repositories.DonationRepository;
import repositories.RequestRepository;
import services.interfaces.IRequestService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RequestService implements IRequestService {
    private final RequestRepository requestRepository;
    private final DoctorRepository doctorRepository;
    private final BloodRepository bloodRepository;
    private final DonationRepository donationRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository, DoctorRepository doctorRepository, BloodRepository bloodRepository, DonationRepository donationRepository) {
        this.requestRepository = requestRepository;
        this.doctorRepository = doctorRepository;
        this.bloodRepository = bloodRepository;
        this.donationRepository = donationRepository;
    }

    @Override
    public Request save(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Request getById(Long id) {
        return requestRepository.findById(id);
    }

    @Override
    public List<Request> getAllRequest() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> getAllRequestsByStatus(RequestStatus status) {
        return requestRepository.findAllByStatus(status);
    }

    @Override
    public List<Request> getAllRequestsByDoctor(Doctor doctor) {
        return requestRepository.findAllByDoctorOrderByRequestDate(doctor);
    }

    // used in controller
    @Override
    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public void deleteBlood(Long id) {

    }

    @Override
    public List<Blood> getAll() {
        return null;
    }


    @Override
    public Blood findDesireBlood(BloodType bloodType, BloodRH bloodRH, BloodCategory bloodCategory, int bloodQuantity) {
        List<Blood> bloodList = bloodRepository.findBloodForRequest(bloodCategory, bloodRH, bloodType);
        Blood blood = null;
        if (bloodList.size() >= bloodQuantity) {
            for (int i = 0; i < bloodQuantity; i++) {
                blood = bloodList.get(i);
                blood.setUsed(true);
                bloodRepository.save(blood);
            }

        }
        if (blood == null) {
            List<Blood> bloodNotSepartedList = bloodRepository.findByBloodTypeAndBloodRh(bloodType, bloodRH);
            Blood bloodNotSeparted = null;
            if (bloodNotSepartedList.size()+bloodList.size()>=bloodQuantity) {
                for (int i = 0; i < bloodList.size(); i++) {
                    blood = bloodList.get(i);
                    blood.setUsed(true);
                    bloodRepository.save(blood);
                }
                int counter=bloodQuantity-bloodList.size();
                for (int j=0;j<counter;j++) {
                    bloodNotSeparted = bloodNotSepartedList.get(j);
                    saveSeparatedBlood(bloodNotSeparted, bloodCategory);

                }
            }
            else
                return bloodNotSeparted;
//            if (bloodNotSeparted == null)
//                return null;
//            else {
//
//            }

        }
        return blood;

    }

    @Override
    public Blood saveSeparatedBlood(Blood blood, BloodCategory bloodCategory) {

        Blood bloodWithRedCellCategory = new Blood(blood.getBloodType(), blood.getBloodRH(), BloodCategory.REDCELL, blood.getUsed(), LocalDate.now().plusDays(Blood.getDaysToExpire(BloodCategory.REDCELL)));
        Blood bloodWithThrombocyteCategory = new Blood(blood.getBloodType(), blood.getBloodRH(), BloodCategory.THROMBOCYTE, blood.getUsed(), LocalDate.now().plusDays(Blood.getDaysToExpire(BloodCategory.THROMBOCYTE)));
        Blood bloodWithPlasmaCategory = new Blood(blood.getBloodType(), blood.getBloodRH(), BloodCategory.PLASMA, blood.getUsed(), LocalDate.now().plusDays(Blood.getDaysToExpire(BloodCategory.PLASMA)));
        blood.setUsed(true);

        bloodRepository.save(blood);

        if (bloodCategory.equals(BloodCategory.PLASMA)) {
            bloodWithPlasmaCategory.setUsed(true);
            bloodRepository.save(bloodWithRedCellCategory);
            bloodRepository.save(bloodWithThrombocyteCategory);
            bloodRepository.save(bloodWithPlasmaCategory);
            return bloodWithPlasmaCategory;

        } else if (bloodCategory.equals(BloodCategory.REDCELL)) {
            bloodWithRedCellCategory.setUsed(true);
            bloodRepository.save(bloodWithThrombocyteCategory);
            bloodRepository.save(bloodWithPlasmaCategory);
            bloodRepository.save(bloodWithRedCellCategory);
            return bloodWithRedCellCategory;
        } else {
            bloodWithThrombocyteCategory.setUsed(true);
            bloodRepository.save(bloodWithRedCellCategory);
            bloodRepository.save(bloodWithPlasmaCategory);
            bloodRepository.save(bloodWithThrombocyteCategory);
            return bloodWithThrombocyteCategory;
        }
    }

    @Override
    public List<Donor> getCopatibleDonors(BloodType bloodType, BloodRH bloodRh) {
        List<Donation> listaDonatiiCompatibile = donationRepository.getAllByBloodTypeAndBloodRH(bloodType, bloodRh);
        Set<Donor> donors = new HashSet<>();

        for (Donation donation : listaDonatiiCompatibile) {
            if (donation.getDonor().getLocalAddress().contains("Cluj-Napoca"))
                donors.add(donation.getDonor());
        }

        List<Donor> donorsList = new ArrayList<>();
        for (Donor donor : donors)
            donorsList.add(donor);

        return donorsList;
    }
//        }

}



