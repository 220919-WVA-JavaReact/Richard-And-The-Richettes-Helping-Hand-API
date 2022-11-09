package com.revature.helpinghandapi.controllers;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.dtos.HelperDTO;
import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.services.BidService;
import com.revature.helpinghandapi.services.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/helper")
public class HelperController {

    private final HelperService hs;
    private final BidService bs;

    @Autowired
    public HelperController(HelperService hs, BidService bs){
        this.hs = hs;
        this.bs = bs;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<HelperDTO> createHelper(@RequestBody Credentials cred){
        HelperDTO helperDTO = hs.createHelper(cred);
        return new ResponseEntity<>(helperDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{helperId}/bids")
    public ResponseEntity<List<BidDTO>> getBidsByRequestId(@PathVariable("helperId") String helperId) {
        List<BidDTO> bids = bs.getBidsByHelperId(helperId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

}
