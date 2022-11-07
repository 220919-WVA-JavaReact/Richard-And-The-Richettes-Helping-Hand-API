package com.revature.helpinghandapi.controllers;


import com.revature.helpinghandapi.dto.Credentials;
import com.revature.helpinghandapi.dto.HelperDTO;
import com.revature.helpinghandapi.services.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helper")
public class HelperController {

    private final HelperService hs;

    @Autowired
    public HelperController(HelperService hs){
        this.hs = hs;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<HelperDTO> createHelper(@RequestBody Credentials cred){
        HelperDTO helperDTO = hs.createHelper(cred);
        return new ResponseEntity<>(helperDTO, HttpStatus.CREATED);
    }

}
