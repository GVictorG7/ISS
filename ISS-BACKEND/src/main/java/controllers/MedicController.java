package controllers;

import controllers.formatters.MedicFields;
import controllers.formatters.ResponseErrors;
import model.Medic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import services.interfaces.IMedicService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

public class MedicController {
    private final IMedicService medicService;

    @Autowired
    public MedicController(IMedicService medicService) {
        this.medicService = medicService;
    }

    @PostMapping(value = "/saveMedic")
    public void saveDonor(@Valid @RequestBody MedicFields medicFields, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECOMDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.setStatus(HttpServletResponse.SC_CREATED); // 201
        medicService.save(new Medic(medicFields.getFirstName(), medicFields.getLastName(), medicService.getUserMedic(medicFields.getUserId()), medicService.getHospitalMedic(medicFields.getUserHospital())));
    }
}
