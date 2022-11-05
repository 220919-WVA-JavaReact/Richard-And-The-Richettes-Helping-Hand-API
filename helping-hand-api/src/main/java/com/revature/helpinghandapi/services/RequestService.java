package com.revature.helpinghandapi.services;

import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.helpinghandapi.entities.Client;

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
//        Request requests = rr.getById(Client);
    }
//    public List<Request> getAllRequests() {
//        List<Request> requests = rr.findRequestByClientId(Client.getId());
////        List<Request> request = request.stream().map(user -> new Request(request)).collect(Collectors.toList());
//        return requests;
//    }



}
