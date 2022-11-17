package com.revature.helpinghandapi.controllers;
import com.revature.helpinghandapi.dtos.ClientDTO;
import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client-auth")
public class ClientAuthController {
    private final ClientService cs;

    @Autowired
    public ClientAuthController(ClientService cs) {
        this.cs = cs;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClientDTO> authenticate(@RequestBody Credentials cred){
        ClientDTO client = cs.authenticate(cred);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
