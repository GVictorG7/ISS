package controllers;

import controllers.formatters.RequestFields;
import controllers.formatters.ResponseErrors;
import model.Doctor;
import model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.RequestService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "request")
public class RequestController {
    RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping(value = "/makeRequest")
    public void requestBlood(@Valid @RequestBody RequestFields requestFields, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECONDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        requestService.save(new Request(requestFields.getPerson(),
                requestFields.getRequestDate(),
                requestFields.getPriority(),
                requestFields.getBloodCategory(),
                requestFields.getBloodRh(),
                requestFields.getBloodType(),
                requestFields.getBloodQuantity(),
                "open",
                requestService.getDoctor(requestFields.getIdDoctor())));

        response.setStatus(HttpServletResponse.SC_CREATED); // 201
    }

    @GetMapping(value = "/getRequests")
    public List<Request> getAllRequestsByDoctor(@RequestParam(value = "id", required = false) Long id, HttpServletResponse response) {
        Doctor doctor = requestService.getDoctor(id);
        if (doctor == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
            return null;
        }

        response.setStatus(HttpServletResponse.SC_ACCEPTED); // 202
        return requestService.getAllRequestsByDoctor(doctor);
    }
}
