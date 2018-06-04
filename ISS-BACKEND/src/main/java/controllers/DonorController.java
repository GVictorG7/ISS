package controllers;

import controllers.formatters.DonorFields;
import controllers.formatters.ResponseErrors;
import model.Donor;
import model.User;
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

    @PostMapping(value = "/save")
    public Donor saveDonor(@Valid @RequestBody DonorFields donor, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECOMDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String firstName = donor.getFirstName();
        String lastName = donor.getLastName();
        String cnp = donor.getCnp();
        String gender = donor.getGender();
        String birthday = donor.getBirthday();
        String address = donor.getAddress();
        String localAddress = donor.getLocalAddress();
        String email = donor.getEmail();
        String phone = donor.getPhone();
        User user = donorService.getUserDonor(donor.getUserId());


        Donor donorInstace = new Donor(firstName, lastName, cnp, gender, birthday, address, localAddress, email, phone, user);
        donorService.save(donorInstace);

        response.setStatus(HttpServletResponse.SC_CREATED); // 201
        return donorInstace;

    }

}
