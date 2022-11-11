package com.revature.helpinghandapi.services;
import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.exceptions.RequestNotFoundException;
import com.revature.helpinghandapi.repositories.ClientRepository;
import com.revature.helpinghandapi.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static com.revature.helpinghandapi.entities.Availability.CLOSED;
import static com.revature.helpinghandapi.entities.Availability.OPEN;

@Service
public class RequestService {

    @Autowired
    private RequestRepository rr;
    private ClientRepository cr;

    @Autowired
    public RequestService(RequestRepository rr, ClientRepository cr){
        System.out.println("RequestService Created!");
        this.rr = rr;
        this.cr = cr;
    }

    public List<RequestDTO> getAllRequests(){
        List<Request> requests = rr.findAll();
        List<RequestDTO> requestDTO = requests.stream()
            .map(request -> new RequestDTO(request))
            .collect(Collectors.toList());
        return requestDTO;
    }

    public Request updateRequest(RequestDTO request){
        Request updateRequest = rr.findById(request.getRequestId()).orElse(null);
        assert updateRequest != null;
        updateRequest.setAvailability(request.getAvailability());
        rr.save(updateRequest);
        if(request.getAvailability().equals(CLOSED)){
            closeRequest(request);
        }
        return updateRequest;
    }

    public void closeRequest(RequestDTO requestDTO){
        Request request = rr.findById(requestDTO.getRequestId()).orElse(null);
        List<Request> requests = rr.findAll();
        for (Request updateRequest : requests){
            if(updateRequest.getAvailability() == OPEN){
                assert request != null;
                if (updateRequest.getAvailability().equals(request.getAvailability()));
                updateRequest.setAvailability(CLOSED);
                rr.save(updateRequest);
            }
        }
    }

    public List<RequestDTO> getRequestsByClientId(String id) throws RequestNotFoundException {
        List<RequestDTO> requests = rr.findRequestsByClientId(id);
        return requests;
    }

    public RequestDTO createRequest(RequestDTO request){
        Request newRequest = new Request();
        Client client = cr.findById(request.getClientId()).orElse(null);
        newRequest.setClient(client);
        newRequest.setDescription(request.getDescription());
        newRequest.setTitle(request.getTitle());
        newRequest.setDeadline(request.getDeadline());
        newRequest.setAvailability(OPEN);
        rr.save(newRequest);

        request.setClientId(client.getId());
        request.setAvailability(OPEN);
        request.setRequestId(newRequest.getId());
        return request;
    }
}
