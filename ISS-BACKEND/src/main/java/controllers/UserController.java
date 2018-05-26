package controllers;

import controllers.formatters.Credentials;
import controllers.formatters.ResponseErrors;
import controllers.formatters.ReturnObject;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
        User user = userService.login(credentials.getUsername(), credentials.getPassword());
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 - auth failed
            return null;
        }
        response.setStatus(HttpServletResponse.SC_OK);// 200

        if (user.getUserType().equals("Donor"))
            return new ReturnObject(userService.getUserDonor(user.getId()),user.getUserType());
        if(user.getUserType().equals("Medic"))
            return new ReturnObject(userService.getUserMedic(user.getId()),user.getUserType());
        if(user.getUserType().equals("Personel"))
            return  new ReturnObject(userService.getUserPersonel(user.getId()),user.getUserType());
        return null;
    }

    @PostMapping(value = "/signup")
    public Long signup(@Valid @RequestBody User user, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECONDITION_FAILED - should have been 422
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

    @PostMapping(value = "/update")
    public User update(@Valid @RequestBody User user, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECONDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        response.setStatus(HttpServletResponse.SC_CREATED); // 201
        return userService.update(user);
    }
}
