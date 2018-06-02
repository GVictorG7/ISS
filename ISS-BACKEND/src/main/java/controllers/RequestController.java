package controllers;

import controllers.formatters.ModifiedRequestFields;
import controllers.formatters.RequestFields;
import controllers.formatters.ResponseErrors;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.RequestService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "request")
public class RequestController {
    RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    // done by Doctor
    @PostMapping(value = "/makeRequest")
    public void makeRequest(@Valid @RequestBody RequestFields requestFields, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            try {
                response.sendError(412, ResponseErrors.getErrorsFormatted(result.getFieldErrors())); //PRECONDITION_FAILED - should have been 422
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Request request = new Request(requestFields.getForPerson(),
                LocalDate.now(),
                RequestPriority.valueOf(requestFields.getPriority()),
                BloodCategory.valueOf(requestFields.getBloodCategory()),
                BloodRH.valueOf(requestFields.getBloodRh()),
                BloodType.valueOf(requestFields.getBloodType()),
                requestFields.getBloodQuantity(),
                RequestStatus.OPEN,
                requestService.getDoctor(requestFields.getIdDoctor()));

        requestService.save(request);

        response.setStatus(HttpServletResponse.SC_CREATED); // 201
    }

    // done by Doctor
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

    @GetMapping(value = "/getRequestsOpen")
    public List<Request> getAllRequestsByStatusOpen(HttpServletResponse response) {
        return requestService.getAllRequestsByStatus(RequestStatus.OPEN);
    }

    // done by Personnel
    @PostMapping(value = "/modifyRequest")
    public List<Donor> modifyRequest(@Valid @RequestBody ModifiedRequestFields modifiedRequestFields, HttpServletResponse response) {
        System.out.println();
        Request request = requestService.getById(modifiedRequestFields.getId());
        if (request == null || request.getStatus().equals(RequestStatus.ACCEPTED)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400
            return null;
        } else if (requestService.findDesireBlood(request.getBloodType(), request.getBloodRH(), request.getBloodCategory(), request.getBloodQuantity()) != null) {
            request.setStatus(RequestStatus.ACCEPTED);
            requestService.save(request);
            response.setStatus(HttpServletResponse.SC_OK); // 200
            return null;
        } else {
            request.setStatus(RequestStatus.IN_PROGRESS);
            request.setSummary("Looking for donors as quick as we can");
            response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED); //412
            requestService.save(request);
            return requestService.getCopatibleDonors(request.getBloodType(), request.getBloodRH());
        }
    }
}
