package validators;

import model.Treatment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("beforeCreateTreatmentValidator")
public class TreatmentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Treatment.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Treatment disease = (Treatment) target;
        ValidationUtils.rejectIfEmpty(errors, "hypertension", "hypertension.empty");
        ValidationUtils.rejectIfEmpty(errors, "heartDisease", "heartDisease.empty");
        ValidationUtils.rejectIfEmpty(errors, "kidneyDisease", "kidneyDisease.empty");
        ValidationUtils.rejectIfEmpty(errors, "mentalIllness", "mentalIllness.empty");
        ValidationUtils.rejectIfEmpty(errors, "bloodDisease", "bloodDisease.empty");
        ValidationUtils.rejectIfEmpty(errors, "endocrineAffection", "endocrineAffection.empty");
    }
}
