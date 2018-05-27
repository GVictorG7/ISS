package controllers;

import controllers.formatters.UserFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.IUserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/saveUser")
    public void saveDonation(@RequestBody UserFields userFields)
    {
        System.out.println(userFields.toString());
        userService.save(userFields.generateUser());
    }
}
