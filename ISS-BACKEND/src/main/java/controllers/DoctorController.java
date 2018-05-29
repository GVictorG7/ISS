package controllers;

import controllers.formatters.DoctorFields;
import controllers.formatters.ResponseErrors;
import model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.interfaces.IDoctorService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
    private final IDoctorService medicService;

    @Autowired
    public DoctorController(IDoctorService medicService) {
        this.medicService = medicService;
    }

    @PostMapping(value = "/save")
    public void saveDoctor(@Valid @RequestBody DoctorFields doctorFields, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECONDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.setStatus(HttpServletResponse.SC_CREATED); // 201
        medicService.save(new Doctor(doctorFields.getFirstName(), doctorFields.getLastName(), medicService.getUserDoctor(doctorFields.getUserId()), medicService.getHospitalDoctor(doctorFields.getUserHospital())));
    }
}
