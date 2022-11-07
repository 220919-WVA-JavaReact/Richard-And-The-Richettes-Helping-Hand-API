package com.revature.helpinghandapi.controllers;
import com.revature.helpinghandapi.dtos.ClientDTO;
import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService cs;

    @Autowired
    public ClientController(ClientService cs){
        this.cs = cs;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClientDTO> createClient(@RequestBody Credentials cred) {
        ClientDTO clientDTO = cs.createClient(cred);
        return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }
}
