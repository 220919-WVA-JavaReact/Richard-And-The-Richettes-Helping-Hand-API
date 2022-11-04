package com.revature.helpinghandapi.services;
import com.revature.helpinghandapi.dtos.BidDTO;
import com.revature.helpinghandapi.entities.Bid;
import com.revature.helpinghandapi.entities.Helper;
import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.revature.helpinghandapi.entities.Status.PENDING;

@Service
public class BidService {
    private BidRepository br;

    @Autowired
    public BidService(BidRepository br) {
        this.br = br;
    }


    public Bid createBid(BidDTO bid){
        Bid newBid = new Bid();

        newBid.setHelper(bid.getHelper());
        newBid.setRequest(bid.getRequest());
        newBid.setAmount(bid.getAmount());
        newBid.setStatus(PENDING);
        br.save(newBid);
        return newBid;
    }


//    public Bid updateBid(){
//        return null;
//    }

}
