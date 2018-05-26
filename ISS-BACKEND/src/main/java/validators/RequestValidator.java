package validators;

import model.Request;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("beforeCreateRequestValidator")
public class RequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Request.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Request request = (Request) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "person", "person.empty");
        ValidationUtils.rejectIfEmpty(errors, "requestDate", "requestDate.empty");
        ValidationUtils.rejectIfEmpty(errors, "priority", "priority.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bloodCategory", "bloodCategory.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bloodType", "bloodType.empty");
        ValidationUtils.rejectIfEmpty(errors, "bloodQuantity", "bloodQuantity.empty");
        ValidationUtils.rejectIfEmpty(errors, "medic", "medic.empty");
        ValidationUtils.rejectIfEmpty(errors, "blood", "blood.empty");
    }
}
