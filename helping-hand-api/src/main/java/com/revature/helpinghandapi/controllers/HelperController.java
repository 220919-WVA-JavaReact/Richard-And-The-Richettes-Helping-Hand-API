package com.revature.helpinghandapi.controllers;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.dtos.Credentials;
import com.revature.helpinghandapi.dtos.HelperDTO;
import com.revature.helpinghandapi.services.BidService;
import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.services.HelperService;
import com.revature.helpinghandapi.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/helper")
public class HelperController {

    private final HelperService hs;
    private final BidService bs;
    private final RequestService rs;

    @Autowired
    public HelperController(HelperService hs, BidService bs, RequestService rs){
        this.hs = hs;
        this.bs = bs;
        this.rs = rs;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<HelperDTO> createHelper(@RequestBody Credentials cred) {
        HelperDTO helperDTO = hs.createHelper(cred);
        return new ResponseEntity<>(helperDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{helperId}/bids")
    public ResponseEntity<List<BidDTO>> getBidsByRequestId(@PathVariable("helperId") String helperId) {
        List<BidDTO> bids = bs.getBidsByHelperId(helperId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }
    
    @GetMapping("/requests")
    public ResponseEntity<List<RequestDTO>> getAllRequests() {
        List<RequestDTO> requests = rs.getAllRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

}
