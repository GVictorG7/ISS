package services.interfaces;

import model.Request;

import java.util.List;

public interface IRequestService {
    Request save(Request request);

    List<Request> getAllRequest();

    List<Request> getAllRequestsByStatus(String status);
}
