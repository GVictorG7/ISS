package controllers;


import controllers.formatters.HospitalFields;
import controllers.formatters.MedicFields;
import controllers.formatters.ResponseErrors;
import model.Hospital;
import model.Medic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.interfaces.IHospitalService;
import services.interfaces.IMedicService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/hospitals")
public class HospitalController {

    private final IHospitalService hospitalService;

    @Autowired
    public HospitalController(IHospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @PostMapping(value = "/save")
    public void saveHospital(@RequestBody HospitalFields hospitalFields, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECONDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         List<Medic> list=new ArrayList<>();

        response.setStatus(HttpServletResponse.SC_CREATED); // 201
        hospitalService.save(new Hospital(hospitalFields.getName(),hospitalFields.getAdress(),list));
    }



    @GetMapping(value = "/getHospitals")
    public List<Hospital> getAllDonation() {
        return hospitalService.getAllHospital();
    }

}
