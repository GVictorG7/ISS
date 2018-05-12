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
        if (!blood.getGroup().equals("0") || !blood.getGroup().equals("A") || !blood.getGroup().equals("B") ||
                !blood.getGroup().equals("AB")) {
            errors.rejectValue("group", "invalid group");
        }
    }


}
