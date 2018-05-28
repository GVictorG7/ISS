package services;

import model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RequestRepository;
import services.interfaces.IRequestService;

import java.util.List;

@Service
public class RequestService implements IRequestService {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request save(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public List<Request> getAllRequest() {
        return requestRepository.findAll();
    }

    @Override
    public List<Request> getAllRequestsByStatus(String status) {
        return requestRepository.findAllByStatus(status);
    }
}
