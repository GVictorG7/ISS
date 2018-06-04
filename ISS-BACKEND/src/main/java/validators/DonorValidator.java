package validators;

import model.Donor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("beforeCreateDonorValidator")
public class DonorValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Donor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Donor donor = (Donor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cnp", "cnp.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "birthday.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "localAddress", "localAddress.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "user.empty");
    }
}
