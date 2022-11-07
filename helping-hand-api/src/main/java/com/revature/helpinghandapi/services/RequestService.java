package com.revature.helpinghandapi.services;

import com.revature.helpinghandapi.dtos.RequestDTO;
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

//        request.forEach(r -> System.out.println(r));
//        Request requests = rr.getById(Client);
    }

    public List<RequestDTO> getAllRequests(){
        List<Request> requests = rr.findAll();
        List<RequestDTO> requestDTO = requests.stream()
                .map(request -> new RequestDTO(request))
                .collect(Collectors.toList());
        return requestDTO;
    }


    public RequestDTO getRequestById(String id) throws RequestNotFoundException {
        Request request = rr.findById(id).orElseThrow(() -> new RequestNotFoundException());
        RequestDTO requestDTO = new RequestDTO(request);
        return requestDTO;
    }

    public Request createRequest(RequestDTO request){
        Request newRequest = new Request();
        Client client = cr.findById(request.getClientId()).orElse(null);
        newRequest.setClient(client);
        newRequest.setDescription(request.getDescription());
        newRequest.setTitle(request.getTitle());
        newRequest.setDeadline(request.getDeadline());

        rr.save(newRequest);
        return newRequest;
    }



}
