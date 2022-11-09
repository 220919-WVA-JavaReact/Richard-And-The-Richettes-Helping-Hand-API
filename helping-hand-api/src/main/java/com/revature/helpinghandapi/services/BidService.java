package com.revature.helpinghandapi.services;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.dtos.RequestDTO;
import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.entities.Helper;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.entities.Status;
import com.revature.helpinghandapi.repositories.BidRepository;
import com.revature.helpinghandapi.repositories.HelperRepository;
import com.revature.helpinghandapi.repositories.RequestRepository;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.revature.helpinghandapi.entities.Status.*;

@Service
public class BidService {
    private BidRepository br;
    private RequestRepository rr;
    private HelperRepository hr;

    @Autowired
    public BidService(BidRepository br, RequestRepository rr, HelperRepository hr) {
        this.br = br;
        this.rr = rr;
        this.hr = hr;
    }
    
    public Bid createBid(BidDTO bid){
        Bid newBid = new Bid();
        Request request = rr.findById(bid.getRequestId()).orElse(null);
        Helper helper = hr.findById(bid.getHelperId()).orElse(null);
        newBid.setHelper(helper);
        newBid.setRequest(request);
        newBid.setAmount(bid.getAmount());
        newBid.setStatus(PENDING);
        br.save(newBid);
        return newBid;
    } //This takes in a JSON object that contains helperId of the helper making the bid,the requestId that they want to make a bid on and the amount they want to bid


    public Bid updateBid(BidDTO bid){
        Bid updatedBid = br.findById(bid.getBidId()).orElse(null);
        assert updatedBid != null;
        updatedBid.setStatus(bid.getBidStatus()); //this has to be marked as getBidStatus because the Status is an object
        updatedBid.setAmount(bid.getAmount());
        br.save(updatedBid);
        if(bid.getBidStatus().equals(ACCEPTED)){
            closeBid(bid);
        }
        return updatedBid;
    } //This takes in a JSON object that contains the requestId and allows the Status and amount to be changed

    public void closeBid(BidDTO bidDTO){
        Request request = rr.findById(bidDTO.getRequestId()).orElse(null);
        List<Bid> bids = br.findAll();
        for(Bid bid : bids){
            if(bid.getStatus() == PENDING) {
                assert request != null;
                if (bid.getRequest().getId().equals(request.getId())) {
                    bid.setStatus(DECLINED);
                    br.save(bid);
                }
            }
        }
    }



    public List<Bid> getAllBids() {
        return br.findAll();
    }

    public Optional<Bid> getBidById(String id) {
        return br.findById(id);
    }
}
