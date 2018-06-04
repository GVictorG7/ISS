package services;

import controllers.formatters.BloodCounterRH;
import controllers.formatters.BloodCounterType;
import controllers.formatters.BloodCounterTypes;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BloodRepository;
import services.interfaces.IBloodService;

import java.time.LocalDate;
import java.util.List;

@Service
public class BloodService implements IBloodService {
    private final BloodRepository bloodRepository;

    @Autowired
    public BloodService(BloodRepository bloodRepository) {
        this.bloodRepository = bloodRepository;
    }

    @Override
    public Blood save(BloodType bloodType, BloodRH bloodRH, BloodCategory bloodCategory, Boolean used, LocalDate exireDate) {
        return bloodRepository.save(new Blood(
                bloodType,
                bloodRH,
                bloodCategory,
                used,
                exireDate
        ));
    }

    @Override
    public void delete(Long id) {
        bloodRepository.delete(id);
    }

    @Override
    public List<Blood> getAll() {
        return bloodRepository.findAll();
    }


    @Override
    public Blood findById(Long id) {
        return bloodRepository.getById(id);
    }

    @Override
    public BloodCounterTypes getBloodCounter() {
        BloodCounterTypes bloodCounterTypes = new BloodCounterTypes();

        List<Blood> bloodList = bloodRepository.findAllValid();
        for (Blood blood : bloodList) {
            switch (blood.getBloodType()) {
                case O:
                    this.countBloodTypeByBlood(bloodCounterTypes.getTypeO(), blood);
                    break;
                case A:
                    this.countBloodTypeByBlood(bloodCounterTypes.getTypeA(), blood);
                    break;
                case B:
                    this.countBloodTypeByBlood(bloodCounterTypes.getTypeB(), blood);
                    break;
                case AB:
                    this.countBloodTypeByBlood(bloodCounterTypes.getTypeAB(), blood);
                    break;
            }
        }
        return bloodCounterTypes;
    }

    private void countBloodTypeByBlood(BloodCounterType bloodCounterType, Blood blood) {
        BloodCounterRH bloodCounterRH = bloodCounterType.getPositiveRH();
        if (blood.getBloodRH().equals(BloodRH.NEGATIVE)) {
            bloodCounterRH = bloodCounterType.getNegativeRH();
        }
        switch (blood.getBloodCategory()) {
            case WHOLE:
                bloodCounterRH.setNoOfWhole(bloodCounterRH.getNoOfWhole() + 1);
                break;
            case PLASMA:
                bloodCounterRH.setNoOfPlasma(bloodCounterRH.getNoOfPlasma() + 1);
                break;
            case REDCELL:
                bloodCounterRH.setNoOfRedcell(bloodCounterRH.getNoOfRedcell() + 1);
                break;
            case THROMBOCYTE:
                bloodCounterRH.setNoOfThrombocyte(bloodCounterRH.getNoOfThrombocyte() + 1);
                break;
        }
    }


}
