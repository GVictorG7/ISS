package controllers;


import controllers.formatters.PersonelFields;
import controllers.formatters.ResponseErrors;
import model.Donation;
import model.Personel;
import model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.interfaces.IPersonelService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/personel")
public class PersonelController {
    private final IPersonelService personelService;

    @Autowired
    public PersonelController(IPersonelService personelService) {
        this.personelService = personelService;
    }

    @PostMapping(value = "/save")
    public Personel saveDonor(@RequestBody PersonelFields personelFields, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECONDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.setStatus(HttpServletResponse.SC_CREATED); // 201
        return personelService.save(new Personel(personelFields.getFirstName(), personelFields.getLastName(), personelService.getUserPersonel(personelFields.getUserId())));
    }


    @GetMapping(value = "/getDonations")
    public List<Donation> getAllDonation() {
        return personelService.getAllDonation();
    }

    @GetMapping(value = "/getBloodRequests")
    public List<Request> getAllBloodRequest() {
       return personelService.getAllBloodRequest();
    }


}
