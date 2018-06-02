package controllers;

import controllers.formatters.BloodCounterTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.interfaces.IBloodService;

@RestController
@RequestMapping("/blood")
public class BloodController {
    private IBloodService bloodService;

    @Autowired
    public BloodController(IBloodService bloodService) {
        this.bloodService = bloodService;
    }

    @GetMapping(value="/getCounter")
    public BloodCounterTypes getBloodCounter(){
        return bloodService.getBloodCounter();
    }

}
