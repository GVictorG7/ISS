package validators;

import model.Hospital;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("beforeCreateHospitalValidator")
public class HospitalValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Hospital.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Hospital hospital = (Hospital) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
        // we may have an initial hospital without Medics
    }
}
