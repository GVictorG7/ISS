package validators;

import model.Blood;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("beforeCreateBloodValidator")
public class BloodValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Blood.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Blood blood = (Blood) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bloodType", "bloodType.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bloodRh", "bloodRh.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bloodCategory", "bloodCategory.empty");
        ValidationUtils.rejectIfEmpty(errors, "harvestDate", "harvestDate.empty");
        ValidationUtils.rejectIfEmpty(errors, "expireDate", "expireDate.empty");
    }
}
