package com.revature.helpinghandapi.controllers;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.dtos.NewBidDTO;
import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/bids")
public class BidController {
    private BidService bs;
    private HttpServletRequest req;

    @Autowired
    public BidController(BidService bs){
        this.bs = bs;
        this.req = req;
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Bid> createBid(@RequestBody BidDTO bid){
        Bid newBid = bs.createBid(bid);
        return new ResponseEntity<>(newBid, HttpStatus.CREATED);
    }


}
