package controllers;

import controllers.formatters.DoctorFields;
import controllers.formatters.RequestFields;
import controllers.formatters.ResponseErrors;
import model.Doctor;
import model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.interfaces.IDoctorService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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

    @PostMapping(value = "/request")
    public void requestBlood(@Valid @RequestBody RequestFields requestFields, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECONDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.setStatus(HttpServletResponse.SC_CREATED);

        String person = requestFields.getPerson();
        String date = requestFields.getRequestDate();
        int priority = requestFields.getPriority();
        String bloodCategory = requestFields.getBloodCategory();
        String bloodRh = requestFields.getBloodRh();
        String bloodType = requestFields.getBloodType();
        int bloodQuantity = requestFields.getBloodQuantity();
        Doctor doctor = medicService.getById(requestFields.getIdDoctor());

        Request request = new Request(person, date, priority, bloodCategory, bloodRh, bloodType, bloodQuantity, "open", doctor);
        medicService.requestBlood(request);
    }

    @GetMapping(value = "/getRequests")
    public List<Request> getAllRequests() {
        return medicService.getAllRequest();
    }
}
