package validators;

import model.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component("beforeCreatePersonValidator")
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"cnp","cnp.empty");
        ValidationUtils.rejectIfEmpty(errors,"password","password.empty");
        Person person= (Person) target;
        if( person.getCnp().length() != 13)
            //errors.rejectValue("cnp","incorrect");
            //nothing to do here , it will be validate by adnotation @Size in class
        if(!person.getFirstName().matches("[A-Z][a-zA-Z]*") || person.getFirstName() == null)
            errors.rejectValue("firstName","Only alphabetical");
        // other validation
    }
}
