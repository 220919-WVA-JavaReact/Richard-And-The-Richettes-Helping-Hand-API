package com.revature.helpinghandapi.controllers;
import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService rs;

    public RequestController(RequestService rs){
        System.out.println("RequestController Created!");
        this.rs = rs;
    }

    @PostMapping
    public ResponseEntity<RequestDTO> createRequest(@RequestBody RequestDTO request){
        RequestDTO newRequest = rs.createRequest(request);
        return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestDTO> updateRequests(@PathVariable ("id") String id, @RequestBody RequestDTO requestDTO) {
        RequestDTO updateRequest = rs.updateRequests(requestDTO);
        return new ResponseEntity<>(updateRequest, HttpStatus.CREATED);
    }

}
