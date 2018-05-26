package controllers;

import controllers.formatters.DonorFields;
import controllers.formatters.ResponseErrors;
import model.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.interfaces.IDonorService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping(value = "/donor")
public class DonorController {
    private final IDonorService donorService;

    @Autowired
    public DonorController(IDonorService donorService) {
        this.donorService = donorService;
    }

    @PostMapping(value = "/saveDonor")
    public void saveDonor(@Valid @RequestBody DonorFields donor, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECOMDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.setStatus(HttpServletResponse.SC_CREATED); // 201
        donorService.save(new Donor(donor.getFirstName(), donor.getLastName(), donor.getCnp(), donor.getGender(), donor.getBirthday(), donor.getAddress(), donor.getLocalAddress(), donor.getEmail(), donor.getPhone(), donorService.getUserDonor(donor.getUserId())));
    }
}
