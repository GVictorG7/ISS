package controllers;

import controllers.formatters.Credentials;
import controllers.formatters.ResponseErrors;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.interfaces.IUserService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping(value = "/auth")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public Object login(@RequestBody Credentials credentials, HttpServletResponse response) {
        User person = userService.login(credentials.getUsername(), credentials.getPassword());
        if (person == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 - auth failed
            return null;
        }
        response.setStatus(HttpServletResponse.SC_OK);// 200
        if (person.getUserType().equals("Donor"))
            return userService.getUserDonor(person.getId());
        else
            return userService.getUserMedic(person.getId());
    }

    @PostMapping(value = "/signup")
    public Long signup(@Valid @RequestBody User user, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECOMDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0L;
        }
        response.setStatus(HttpServletResponse.SC_CREATED); // 201
        userService.save(user);
        return user.getId();
//        return userService.save(user);
    }
}
