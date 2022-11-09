package com.revature.helpinghandapi.controllers;


import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.dtos.HelperDTO;
import com.revature.helpinghandapi.services.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helper-auth")
public class HelperAuthController {
    private final HelperService hs;

    @Autowired
    public HelperAuthController(HelperService hs){
        this.hs = hs;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<HelperDTO> authenticate(@RequestBody Credentials cred){
        HelperDTO helper = hs.authenticate(cred);
        return new ResponseEntity<>(helper, HttpStatus.OK);
    }
}
