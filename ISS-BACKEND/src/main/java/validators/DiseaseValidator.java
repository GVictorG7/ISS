package validators;

import model.Disease;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("beforeCreateDiseaseValidator")
public class DiseaseValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Disease.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Disease disease = (Disease) target;
        ValidationUtils.rejectIfEmpty(errors, "hepatitis", "hepatitis.empty");
        ValidationUtils.rejectIfEmpty(errors, "pox", "pox.empty");
        ValidationUtils.rejectIfEmpty(errors, "tbc", "tbc.empty");
        ValidationUtils.rejectIfEmpty(errors, "mallaria", "mallaria.empty");
        ValidationUtils.rejectIfEmpty(errors, "epilepsy", "epilepsy.empty");
        ValidationUtils.rejectIfEmpty(errors, "mentalIllness", "mentalIllness.empty");
        ValidationUtils.rejectIfEmpty(errors, "brucellosis", "brucellosis.empty");
        ValidationUtils.rejectIfEmpty(errors, "ulcer", "ulcer.empty");
        ValidationUtils.rejectIfEmpty(errors, "diabetes", "diabetes.empty");
        ValidationUtils.rejectIfEmpty(errors, "hearDisease", "hearDisease.empty");
        ValidationUtils.rejectIfEmpty(errors, "skinDisease", "skinDisease.empty");
        ValidationUtils.rejectIfEmpty(errors, "myopia", "myopia.empty");
        ValidationUtils.rejectIfEmpty(errors, "cancer", "cancer.empty");
    }
}
