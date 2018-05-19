package validators;


import model.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component("beforeCreatePersonValidator")
public class DonationValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        Person person= (Person) target;
        ValidationUtils.rejectIfEmpty(errors, "pregnant", "pregnant.empty");
        ValidationUtils.rejectIfEmpty(errors, "menstruating", "menstruating.empty");
        ValidationUtils.rejectIfEmpty(errors, "consumedDrinks", "consumedDrinks.empty");
        ValidationUtils.rejectIfEmpty(errors, "systolic", "systolic.empty");
        ValidationUtils.rejectIfEmpty(errors, "pulse", "pulse.empty");
        ValidationUtils.rejectIfEmpty(errors, "smoked", "smoked.empty");
        ValidationUtils.rejectIfEmpty(errors, "wellSlept", "wellSlept.empty");
        ValidationUtils.rejectIfEmpty(errors, "bloodType", "bloodType.empty");
        ValidationUtils.rejectIfEmpty(errors, "rh", "rh.empty");

    }

}