package com.revature.helpinghandapi.controllers;
import com.revature.helpinghandapi.dtos.ClientDTO;
import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.services.ClientService;
import com.revature.helpinghandapi.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService cs;

    private final RequestService rs;

    @Autowired
    public ClientController(ClientService cs, RequestService rs){
        this.cs = cs;
        this.rs = rs;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClientDTO> createClient(@RequestBody Credentials cred) {
        ClientDTO clientDTO = cs.createClient(cred);
        return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/requests")
    public ResponseEntity<List<RequestDTO>> getRequestsByClientId(@PathVariable("id") String id) {
        List<RequestDTO> requests = rs.getRequestsByClientId(id);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }
}
