package controllers;


import controllers.formatters.PersonnelFields;
import controllers.formatters.ResponseErrors;
import model.Donation;
import model.Personnel;
import model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.interfaces.IPersonnelService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/personnel")
public class PersonnelController {
    private final IPersonnelService personnelService;

    @Autowired
    public PersonnelController(IPersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping(value = "/save")

    public Personnel saveDonor(@RequestBody PersonnelFields personnelFields, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECONDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.setStatus(HttpServletResponse.SC_CREATED); // 201
        return personnelService.save(new Personnel(personnelFields.getFirstName(), personnelFields.getLastName(), personnelService.getUserPersonnel(personnelFields.getUserId())));
    }


    @GetMapping(value = "/getDonations")
    public List<Donation> getAllDonation() {
        return personnelService.getAllDonation();
    }

    @GetMapping(value = "/getBloodRequests")
    public List<Request> getAllBloodRequest() {
        return personnelService.getAllBloodRequest();
    }


}
