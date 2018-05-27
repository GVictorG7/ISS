package controllers;


import controllers.formatters.BloodFields;
import model.Blood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.IBloodService;

@RestController
@RequestMapping(value = "/blood")
public class BloodController {
    private final IBloodService bloodService;

    @Autowired
    public BloodController(IBloodService bloodService) {
        this.bloodService = bloodService;
    }

    @PostMapping(value = "/saveBlood")
    public void saveDonation(@RequestBody BloodFields bloodFields)
    {

        System.out.println(bloodFields.toString());
        bloodService.save(bloodFields.generateBlood());
    }
}
