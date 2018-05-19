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
        if (!person.getPersonType().matches("Donator"));
                errors.rejectValue("persone","Must be donor");
    }

}