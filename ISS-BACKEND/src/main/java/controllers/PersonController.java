package controllers;

import controllers.formatters.Credentials;
import controllers.formatters.ResponseErrors;
import controllers.formatters.Token;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.IPersonService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping(value = "/auth")
public class PersonController {
    private final IPersonService personService;

    @Autowired
    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/login")
    public Token login(@RequestBody Credentials credentials, HttpServletResponse response) {
        Person person = personService.login(credentials.getUsername(), credentials.getPassword());
        if (person == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 - auth failed
            return null;
        }
        response.setStatus(HttpServletResponse.SC_OK);// 200
        return new Token(person.getId(), person.getFirstName(), person.getPersonType());
    }

    @PostMapping(value = "/signup")
    public Person signup(@Valid @RequestBody Person person, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECOMDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        response.setStatus(HttpServletResponse.SC_CREATED); // 201
        return personService.save(person);
    }
}
