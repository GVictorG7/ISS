package validators;

import model.Medic;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("beforeCreateMedicValidator")
public class MedicValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Medic.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Medic medic = (Medic) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "user", "user.empty");
        ValidationUtils.rejectIfEmpty(errors, "hospital", "hospital.empty");
    }
}
