package com.revature.helpinghandapi.services;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.entities.Status;
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
    private BidService bs;

    @Autowired
    public RequestService(RequestRepository rr, ClientRepository cr, BidService bs){
        System.out.println("RequestService Created!");
        this.rr = rr;
        this.cr = cr;
        this.bs = bs;
    }

    public List<RequestDTO> getAllRequests(){
        List<Request> requests = rr.findAll();
        List<RequestDTO> requestDTO = requests.stream()
            .map(request -> new RequestDTO(request))
            .collect(Collectors.toList());
        return requestDTO;
    }


    public RequestDTO updateRequests(RequestDTO request){
        Request newRequest = rr.findById(request.getId()).orElse(null);
        newRequest.setAvailability(request.getAvailability());
        newRequest.setTitle(request.getTitle());
        newRequest.setDeadline(request.getDeadline());
        newRequest.setDescription(request.getDescription());
        rr.save(newRequest);
        return request;
    }    

    public List<RequestDTO> getOpenRequests(){
        List<Request> requests = rr.findByAvailability(OPEN);
        List<RequestDTO> requestDTO = requests.stream()
                .map(request -> new RequestDTO(request))
                .collect(Collectors.toList());
        return requestDTO;
    }

    public void closeRequest(RequestDTO requestDTO){
        Request request = rr.findById(requestDTO.getId()).orElse(null);
        List<Request> requests = rr.findAll();
        if(request.getAvailability().equals(CLOSED)){
            rr.save(request);
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
        request.setId(newRequest.getId());
        return request;
    }
}
