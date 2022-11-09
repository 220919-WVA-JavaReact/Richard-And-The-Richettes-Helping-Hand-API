package com.revature.helpinghandapi.controllers;
import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.dtos.HelperDTO;
import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.entities.Availability;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.services.HelperService;
import com.revature.helpinghandapi.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/helper")
public class HelperController {

    private final HelperService hs;

    private final RequestService rs;

    @Autowired
    public HelperController(HelperService hs, RequestService rs) {
        this.hs = hs;
        this.rs = rs;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<HelperDTO> createHelper(@RequestBody Credentials cred) {
        HelperDTO helperDTO = hs.createHelper(cred);
        return new ResponseEntity<>(helperDTO, HttpStatus.CREATED);
    }

    @GetMapping("/requests")
    public ResponseEntity<List<RequestDTO>> getAllRequests() {
        List<RequestDTO> requests = rs.getAllRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PatchMapping("/requests/update/{availability}")
    public ResponseEntity<Request> updateRequests(@RequestBody RequestDTO requestDTO) {
        Request updateRequest = rs.updateRequest(requestDTO);
        return new ResponseEntity<>(updateRequest, HttpStatus.ACCEPTED);
    }
}
