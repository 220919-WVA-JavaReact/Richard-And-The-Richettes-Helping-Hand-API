package com.revature.helpinghandapi.services;

import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.entities.Status;
import com.revature.helpinghandapi.exceptions.RequestNotFoundException;
import com.revature.helpinghandapi.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RequestService {

    @Autowired
    private RequestRepository rr;
    @Autowired
    public RequestService(RequestRepository rr){
        System.out.println("RequestService Created!");
        this.rr = rr;
        List<Request> request = rr.findAll();

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

    public List<RequestDTO> findRequestsByStatus(Status status){
        List<Request> requests = rr.findRequestByStatus(status);
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

    public RequestDTO createRequest(String title){
        Request newRequest = new Request();
        newRequest.setStatus(Status.PENDING);
//        newRequest.setClient(client.getId());

        rr.save(newRequest);
        return new RequestDTO(newRequest);
    }



}
