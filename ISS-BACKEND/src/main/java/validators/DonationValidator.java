package validators;

import model.Donation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("beforeCreateDonationValidator")
public class DonationValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Donation.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Donation donation = (Donation) target;
        ValidationUtils.rejectIfEmpty(errors, "pregnant", "pregnant.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menstruating", "menstruating.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "consumedAlcohol", "consumedAlcohol.empty");
        ValidationUtils.rejectIfEmpty(errors, "systolicValue", "systolicValue.empty");
        ValidationUtils.rejectIfEmpty(errors, "pulse", "pulse.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "forPerson", "forPerson.empty");
        ValidationUtils.rejectIfEmpty(errors, "smoked", "smoked.empty");
        ValidationUtils.rejectIfEmpty(errors, "wellSlept", "wellSlept.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "harvestDate", "harvestDate.empty");
        ValidationUtils.rejectIfEmpty(errors, "donorAge", "donorAge.empty");
        ValidationUtils.rejectIfEmpty(errors, "donorWeight", "donorWeight.empty");
        ValidationUtils.rejectIfEmpty(errors, "status", "status.empty");
        ValidationUtils.rejectIfEmpty(errors, "donor", "donor.empty");
        ValidationUtils.rejectIfEmpty(errors, "treatment", "treatment.empty");
        ValidationUtils.rejectIfEmpty(errors, "disease", "disease.empty");
        // eliminate the last 3 if needed
    }
}
